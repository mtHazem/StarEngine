package com.example.starengine.game.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/starengine/game/entities/Bullet;", "", "x", "", "y", "(FF)V", "innerPaint", "Landroid/graphics/Paint;", "<set-?>", "", "isActive", "()Z", "outerPaint", "radius", "deactivate", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getBounds", "Landroid/graphics/RectF;", "update", "app_debug"})
public final class Bullet {
    private float x;
    private float y;
    private final float radius = 10.0F;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint innerPaint = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint outerPaint = null;
    private boolean isActive = true;
    
    public Bullet(float x, float y) {
        super();
    }
    
    public final boolean isActive() {
        return false;
    }
    
    public final void update() {
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.RectF getBounds() {
        return null;
    }
    
    public final void deactivate() {
    }
}