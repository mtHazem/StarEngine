package com.example.starengine.game

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.starengine.R
import com.example.starengine.activities.GameOverActivity
import com.example.starengine.game.entities.Boss
import com.example.starengine.game.entities.BossBullet
import com.example.starengine.game.effects.Starfield
import com.example.starengine.game.entities.Alien
import com.example.starengine.game.entities.Bullet
import com.example.starengine.game.entities.Jet
import com.example.starengine.utils.Constants

class GameView(context: Context, attrs: AttributeSet?) :
    SurfaceView(context, attrs), SurfaceHolder.Callback, Runnable {

    private var thread: Thread? = null
    private var running = false

    // Background
    private lateinit var starfield: Starfield

    // Player
    private lateinit var jet: Jet
    private val bullets = mutableListOf<Bullet>()
    private var lastShotTime = 0L
    private var ammo = Constants.MAX_AMMO
    private var maxAmmo = Constants.MAX_AMMO
    private var lastAmmoRecharge = 0L

    // Aliens
    private val aliens = mutableListOf<Alien>()
    private var lastAlienSpawn = 0L
    private var alienSpawnDelay = Constants.INITIAL_ALIEN_SPAWN_DELAY

    // Boss
    private var boss: Boss? = null
    private val bossBullets = mutableListOf<BossBullet>()
    private var nextBossScore = 750 // Spawn boss at 750 points
    private var bossDefeatedCount = 0

    // Game state
    private var score = 0

    // UI
    private val scorePaint = Paint().apply {
        color = Color.WHITE
        textSize = 40f
    }
    private val ammoPaint = Paint().apply {
        color = Color.WHITE
        textSize = 40f
    }
    private val gameOverPaint = Paint().apply {
        color = Color.RED
        textSize = 100f
        textAlign = Paint.Align.CENTER
    }

    // Touch control
    private var dragging = false
    private var touchDownX = 0f
    private var jetInitialX = 0f

    init {
        holder.addCallback(this)
        isFocusable = true
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        starfield = Starfield(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT)

        // Load and scale jet sprite
        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.jet)
        val scaledBitmap = Bitmap.createScaledBitmap(
            originalBitmap,
            Constants.JET_WIDTH.toInt(),
            Constants.JET_HEIGHT.toInt(),
            true
        )

        jet = Jet(
            x = (Constants.SCREEN_WIDTH / 2f) - (scaledBitmap.width / 2f),
            y = (Constants.SCREEN_HEIGHT - scaledBitmap.height - 400).toFloat(), // Moved jet up
            bitmap = scaledBitmap
        )

        if (!running) {
            running = true
            thread = Thread(this)
            thread?.start()
        }
    }

    override fun run() {
        while (running) {
            if (!holder.surface.isValid) continue

            val canvas = holder.lockCanvas()
            update()
            drawGame(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }

    private fun update() {
        if (!this::jet.isInitialized) {
            return
        }

        starfield.update()

        val now = System.currentTimeMillis()

        // --- FIRING --- (Only when touching)
        if (dragging && now - lastShotTime >= 300 && ammo > 0) {
            lastShotTime = now
            bullets.addAll(jet.shoot())
            ammo--
        }

        // --- AMMO REGENERATION ---
        if (!dragging && now - lastAmmoRecharge > 100) { // Faster recharge
            lastAmmoRecharge = now
            if (ammo < maxAmmo) {
                ammo++
            }
        }

        // --- SPAWN ALIENS ---
        if (now - lastAlienSpawn >= alienSpawnDelay && boss == null) {
            lastAlienSpawn = now

            val alienSprites = listOf(
                R.drawable.alien1, R.drawable.alien2, R.drawable.alien3
            )

            val sprite = alienSprites.random()
            val x = (0 until (Constants.SCREEN_WIDTH - Constants.ALIEN_WIDTH.toInt()))
                .random().toFloat()

            aliens.add(Alien(context, x, -Constants.ALIEN_HEIGHT, sprite))

            // Optional: Increase difficulty
            if (alienSpawnDelay > Constants.MIN_ALIEN_SPAWN_DELAY) {
                alienSpawnDelay -= 20
            }
        }

        // --- UPDATE PLAYER ---
        jet.update(moveLeft = false, moveRight = false, screenWidth = Constants.SCREEN_WIDTH)

        // --- UPDATE BULLETS ---
        bullets.forEach { it.update() }
        bullets.removeAll { !it.isActive }

        // --- UPDATE ALIENS ---
        aliens.forEach { it.update() }
        aliens.removeAll { !it.isActive || it.getBounds().top > Constants.SCREEN_HEIGHT }

        // --- BULLET ↦ ALIEN COLLISIONS ---
        val bulletsToRemove = mutableListOf<Bullet>()
        bullets.forEach { bullet ->
            aliens.forEach { alien ->
                if (alien.isActive &&
                    RectF.intersects(bullet.getBounds(), alien.getBounds())
                ) {
                    alien.hit()
                    bulletsToRemove.add(bullet)
                    score += Constants.POINTS_PER_ALIEN
                }
            }
        }
        bullets.removeAll(bulletsToRemove)

        // --- BOSS SPAWN ---
        if (score >= nextBossScore && boss == null) {
            boss = Boss.create(
                resources,
                Constants.SCREEN_WIDTH,
                1f + bossDefeatedCount * 0.2f,
                1f + bossDefeatedCount * 0.15f
            )
            nextBossScore += 750 // Set next boss spawn score
        }

        // --- UPDATE BOSS + BOSS BULLETS ---
        boss?.let { b ->
            b.update()

            // Boss firing only when on screen
            if (b.y >= 150f && (0..50).random() == 0) { // Move boss lower before firing
                val bullet = BossBullet(
                    x = b.x + b.width / 2f,
                    y = b.y + b.height,
                    speed = 12f * b.bulletSpeedMultiplier, // Faster boss bullets
                    angle = calculateAngleToJet(b)
                )
                bossBullets.add(bullet)
            }

            // Bullet hits boss
            val bulletsThatHitBoss = mutableListOf<Bullet>()
            bullets.forEach { bullet ->
                val bossRect = RectF(b.x, b.y, b.x + b.width, b.y + b.height)

                if (RectF.intersects(bullet.getBounds(), bossRect)) {
                    bulletsThatHitBoss.add(bullet)
                    b.health -= 10

                    if (b.health <= 0) {
                        boss = null
                        score += 200
                        bossDefeatedCount++

                        // Upgrades on boss defeat
                        if (bossDefeatedCount == 2) {
                            maxAmmo += 10
                        }
                        if (bossDefeatedCount == 3) {
                            jet.hasDoubleShot = true
                        }
                        return@let
                    }
                }
            }
            bullets.removeAll(bulletsThatHitBoss)
        }

        bossBullets.forEach { it.update() }
        bossBullets.removeAll { it.y > Constants.SCREEN_HEIGHT }

        // --- JET vs ALIEN/BULLET COLLISIONS ---
        val jetRect = jet.getCollisionRect()

        // Jet vs Alien
        val aliensToRemove = mutableListOf<Alien>()
        aliens.forEach { alien ->
            if (alien.isActive && RectF.intersects(jetRect, alien.getBounds())) {
                endGame()
                return
            }
        }

        // Jet vs Boss Bullet
        bossBullets.forEach { bullet ->
            val bulletRect = RectF(bullet.x - bullet.size / 2f, bullet.y - bullet.size / 2f, bullet.x + bullet.size / 2f, bullet.y + bullet.size / 2f)
            if (RectF.intersects(jetRect, bulletRect)) {
                endGame()
                return@forEach
            }
        }
    }

    private fun endGame() {
        running = false
        (context as? Activity)?.runOnUiThread {
            val intent = Intent(context, GameOverActivity::class.java)
            intent.putExtra("score", score)
            context.startActivity(intent)
        }
    }

    private fun calculateAngleToJet(boss: Boss): Float {
        val dx = (jet.x + jet.width / 2f) - (boss.x + boss.width / 2f)
        val dy = (jet.y + jet.height / 2f) - (boss.y + boss.height)
        return Math.toDegrees(Math.atan2(dy.toDouble(), dx.toDouble())).toFloat()
    }

    private fun drawGame(canvas: Canvas?) {
        if (canvas == null || !this::jet.isInitialized) return

        starfield.draw(canvas)

        jet.draw(canvas)

        bullets.forEach { it.draw(canvas) }

        aliens.forEach { it.draw(canvas) }

        boss?.draw(canvas)

        bossBullets.forEach { b ->
            canvas.drawCircle(b.x, b.y, b.size / 2f, Constants.redPaint)
        }

        // Draw UI
        canvas.drawText("Score: $score", 20f, 50f, scorePaint)
        canvas.drawText("Ammo: $ammo/$maxAmmo", (Constants.SCREEN_WIDTH - 300).toFloat(), 50f, ammoPaint)

        if (!running) {
            canvas.drawText("GAME OVER", Constants.SCREEN_WIDTH / 2f, Constants.SCREEN_HEIGHT / 2f, gameOverPaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dragging = true
                touchDownX = event.x
                jetInitialX = jet.x
            }

            MotionEvent.ACTION_MOVE -> {
                if (dragging) {
                    val dx = event.x - touchDownX
                    jet.x = jetInitialX + dx

                    // Prevent off-screen
                    if (jet.x < 0) jet.x = 0f
                    if (jet.x + jet.width > Constants.SCREEN_WIDTH) {
                        jet.x = (Constants.SCREEN_WIDTH - jet.width).toFloat()
                    }
                }
            }
            MotionEvent.ACTION_UP -> {
                dragging = false
            }
        }
        return true
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        running = false
        thread?.join()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    // Provided by GameActivity
    fun setScreenSize(width: Int, height: Int) {
        Constants.SCREEN_WIDTH = width
        Constants.SCREEN_HEIGHT = height
    }

    fun resume() {
        if (!running) {
            running = true
            thread = Thread(this)
            thread?.start()
        }
    }

    fun pause() {
        running = false
        thread?.join()
    }
}
