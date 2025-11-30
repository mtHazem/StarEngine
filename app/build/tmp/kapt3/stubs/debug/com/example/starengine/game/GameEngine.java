package com.example.starengine.game;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020,H\u0002J\u0016\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0016J\b\u00105\u001a\u00020,H\u0002J\u0006\u00106\u001a\u00020,J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u00020,H\u0002J\u0006\u00109\u001a\u00020,R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/example/starengine/game/GameEngine;", "", "context", "Landroid/content/Context;", "screenWidth", "", "screenHeight", "(Landroid/content/Context;II)V", "alienSpawnDelay", "", "aliens", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/example/starengine/game/entities/Alien;", "ammoPaint", "Landroid/graphics/Paint;", "ammoRechargeDelay", "bullets", "Lcom/example/starengine/game/entities/Bullet;", "currentAmmo", "fireRateDelay", "gameOverPaint", "isFiring", "", "isGameOver", "()Z", "setGameOver", "(Z)V", "jet", "Lcom/example/starengine/game/entities/Jet;", "getJet", "()Lcom/example/starengine/game/entities/Jet;", "lastAlienSpawnTime", "lastAmmoRechargeTime", "lastShotTime", "maxAmmo", "score", "getScore", "()I", "setScore", "(I)V", "scorePaint", "starfield", "Lcom/example/starengine/game/effects/Starfield;", "checkCollisions", "", "draw", "canvas", "Landroid/graphics/Canvas;", "handleShooting", "handleTouch", "x", "", "isTouching", "rechargeAmmo", "reset", "shoot", "spawnAliens", "update", "app_debug"})
public final class GameEngine {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final int screenWidth = 0;
    private final int screenHeight = 0;
    @org.jetbrains.annotations.NotNull()
    private final com.example.starengine.game.effects.Starfield starfield = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.starengine.game.entities.Jet jet = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.CopyOnWriteArrayList<com.example.starengine.game.entities.Bullet> bullets = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.CopyOnWriteArrayList<com.example.starengine.game.entities.Alien> aliens = null;
    private long lastAlienSpawnTime = 0L;
    private long alienSpawnDelay = 2000L;
    private boolean isFiring = false;
    private long lastShotTime = 0L;
    private final long fireRateDelay = 250L;
    private final int maxAmmo = 20;
    private int currentAmmo;
    private final long ammoRechargeDelay = 100L;
    private long lastAmmoRechargeTime = 0L;
    private int score = 0;
    private boolean isGameOver = false;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint scorePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint ammoPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint gameOverPaint = null;
    
    public GameEngine(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int screenWidth, int screenHeight) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.starengine.game.entities.Jet getJet() {
        return null;
    }
    
    public final int getScore() {
        return 0;
    }
    
    public final void setScore(int p0) {
    }
    
    public final boolean isGameOver() {
        return false;
    }
    
    public final void setGameOver(boolean p0) {
    }
    
    public final void update() {
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final void handleTouch(float x, boolean isTouching) {
    }
    
    private final void shoot() {
    }
    
    private final void handleShooting() {
    }
    
    private final void rechargeAmmo() {
    }
    
    private final void spawnAliens() {
    }
    
    private final void checkCollisions() {
    }
    
    public final void reset() {
    }
}