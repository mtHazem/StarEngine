package com.example.starengine.game.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/starengine/game/entities/Bullet;", "", "x", "", "y", "(FF)V", "bounds", "Landroid/graphics/RectF;", "<set-?>", "", "isActive", "()Z", "paint", "Landroid/graphics/Paint;", "deactivate", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getBounds", "update", "app_debug"})
public final class Bullet {
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.RectF bounds = null;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Paint paint = null;
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