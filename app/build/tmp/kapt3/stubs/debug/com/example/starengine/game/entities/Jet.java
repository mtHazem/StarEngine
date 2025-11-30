package com.example.starengine.game.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/example/starengine/game/entities/Jet;", "", "context", "Landroid/content/Context;", "screenWidth", "", "screenHeight", "(Landroid/content/Context;II)V", "bitmap", "Landroid/graphics/Bitmap;", "bounds", "Landroid/graphics/RectF;", "moveFactor", "", "targetX", "getTargetX", "()F", "setTargetX", "(F)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getBounds", "reset", "shoot", "Lcom/example/starengine/game/entities/Bullet;", "update", "app_debug"})
public final class Jet {
    private final int screenWidth = 0;
    private final int screenHeight = 0;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.Bitmap bitmap;
    @org.jetbrains.annotations.NotNull()
    private android.graphics.RectF bounds;
    private float targetX;
    private final float moveFactor = 0.2F;
    
    public Jet(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int screenWidth, int screenHeight) {
        super();
    }
    
    public final float getTargetX() {
        return 0.0F;
    }
    
    public final void setTargetX(float p0) {
    }
    
    public final void update() {
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.starengine.game.entities.Bullet shoot() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.RectF getBounds() {
        return null;
    }
    
    public final void reset() {
    }
}