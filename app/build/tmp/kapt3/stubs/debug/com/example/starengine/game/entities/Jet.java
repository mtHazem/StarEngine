package com.example.starengine.game.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\"J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0011R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/example/starengine/game/entities/Jet;", "", "x", "", "y", "bitmap", "Landroid/graphics/Bitmap;", "hasDoubleShot", "", "(FFLandroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getHasDoubleShot", "()Z", "setHasDoubleShot", "(Z)V", "height", "", "getHeight", "()I", "speed", "width", "getWidth", "getX", "()F", "setX", "(F)V", "getY", "setY", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getCollisionRect", "Landroid/graphics/RectF;", "shoot", "", "Lcom/example/starengine/game/entities/Bullet;", "update", "moveLeft", "moveRight", "screenWidth", "app_debug"})
public final class Jet {
    private float x;
    private float y;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Bitmap bitmap = null;
    private boolean hasDoubleShot;
    private final int width = 0;
    private final int height = 0;
    private final float speed = 12.0F;
    
    public Jet(float x, float y, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, boolean hasDoubleShot) {
        super();
    }
    
    public final float getX() {
        return 0.0F;
    }
    
    public final void setX(float p0) {
    }
    
    public final float getY() {
        return 0.0F;
    }
    
    public final void setY(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap getBitmap() {
        return null;
    }
    
    public final boolean getHasDoubleShot() {
        return false;
    }
    
    public final void setHasDoubleShot(boolean p0) {
    }
    
    public final int getWidth() {
        return 0;
    }
    
    public final int getHeight() {
        return 0;
    }
    
    public final void update(boolean moveLeft, boolean moveRight, int screenWidth) {
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.starengine.game.entities.Bullet> shoot() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.RectF getCollisionRect() {
        return null;
    }
}