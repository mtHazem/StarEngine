package com.example.starengine.game;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u00102\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u000205H\u0016J\u0006\u00106\u001a\u00020/J\u0006\u00107\u001a\u00020/J\b\u00108\u001a\u00020/H\u0016J\u0016\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000fJ(\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000fH\u0016J\u0010\u0010@\u001a\u00020/2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010B\u001a\u00020/H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/example/starengine/game/GameView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "alienSpawnDelay", "", "aliens", "", "Lcom/example/starengine/game/entities/Alien;", "ammo", "", "ammoPaint", "Landroid/graphics/Paint;", "boss", "Lcom/example/starengine/game/entities/Boss;", "bossBullets", "Lcom/example/starengine/game/entities/BossBullet;", "bossDefeatedCount", "bullets", "Lcom/example/starengine/game/entities/Bullet;", "dragging", "", "gameOverPaint", "jet", "Lcom/example/starengine/game/entities/Jet;", "jetInitialX", "", "lastAlienSpawn", "lastAmmoRecharge", "lastShotTime", "maxAmmo", "nextBossScore", "running", "score", "scorePaint", "starfield", "Lcom/example/starengine/game/effects/Starfield;", "thread", "Ljava/lang/Thread;", "touchDownX", "calculateAngleToJet", "drawGame", "", "canvas", "Landroid/graphics/Canvas;", "endGame", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "resume", "run", "setScreenSize", "width", "height", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "surfaceCreated", "surfaceDestroyed", "update", "app_debug"})
public final class GameView extends android.view.SurfaceView implements android.view.SurfaceHolder.Callback, java.lang.Runnable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Thread thread;
    private boolean running = false;
    private com.example.starengine.game.effects.Starfield starfield;
    private com.example.starengine.game.entities.Jet jet;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.starengine.game.entities.Bullet> bullets = null;
    private long lastShotTime = 0L;
    private int ammo = 20;
    private int maxAmmo = 20;
    private long lastAmmoRecharge = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.starengine.game.entities.Alien> aliens = null;
    private long lastAlienSpawn = 0L;
    private long alienSpawnDelay = 2000L;
    @org.jetbrains.annotations.Nullable()
    private com.example.starengine.game.entities.Boss boss;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.starengine.game.entities.BossBullet> bossBullets = null;
    private int nextBossScore = 750;
    private int bossDefeatedCount = 0;
    private int score = 0;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint scorePaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint ammoPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint gameOverPaint = null;
    private boolean dragging = false;
    private float touchDownX = 0.0F;
    private float jetInitialX = 0.0F;
    
    public GameView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @java.lang.Override()
    public void surfaceCreated(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder holder) {
    }
    
    @java.lang.Override()
    public void run() {
    }
    
    private final void update() {
    }
    
    private final void endGame() {
    }
    
    private final float calculateAngleToJet(com.example.starengine.game.entities.Boss boss) {
        return 0.0F;
    }
    
    private final void drawGame(android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public void surfaceDestroyed(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder holder) {
    }
    
    @java.lang.Override()
    public void surfaceChanged(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder holder, int format, int width, int height) {
    }
    
    public final void setScreenSize(int width, int height) {
    }
    
    public final void resume() {
    }
    
    public final void pause() {
    }
}