package com.example.starengine.game.entities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0006H\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001J\u0006\u00100\u001a\u00020\'R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001c\u00a8\u00062"}, d2 = {"Lcom/example/starengine/game/entities/Boss;", "", "x", "", "y", "health", "", "maxHealth", "bitmap", "Landroid/graphics/Bitmap;", "bulletSpeedMultiplier", "(FFIILandroid/graphics/Bitmap;F)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getBulletSpeedMultiplier", "()F", "getHealth", "()I", "setHealth", "(I)V", "height", "getHeight", "getMaxHealth", "setMaxHealth", "width", "getWidth", "getX", "setX", "(F)V", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "draw", "", "canvas", "Landroid/graphics/Canvas;", "equals", "", "other", "hashCode", "toString", "", "update", "Companion", "app_debug"})
public final class Boss {
    private float x;
    private float y;
    private int health;
    private int maxHealth;
    @org.jetbrains.annotations.NotNull()
    private final android.graphics.Bitmap bitmap = null;
    private final float bulletSpeedMultiplier = 0.0F;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.starengine.game.entities.Boss.Companion Companion = null;
    
    public Boss(float x, float y, int health, int maxHealth, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, float bulletSpeedMultiplier) {
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
    
    public final int getHealth() {
        return 0;
    }
    
    public final void setHealth(int p0) {
    }
    
    public final int getMaxHealth() {
        return 0;
    }
    
    public final void setMaxHealth(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap getBitmap() {
        return null;
    }
    
    public final float getBulletSpeedMultiplier() {
        return 0.0F;
    }
    
    public final int getWidth() {
        return 0;
    }
    
    public final int getHeight() {
        return 0;
    }
    
    public final void update() {
    }
    
    public final void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public final float component1() {
        return 0.0F;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap component5() {
        return null;
    }
    
    public final float component6() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.starengine.game.entities.Boss copy(float x, float y, int health, int maxHealth, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, float bulletSpeedMultiplier) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/example/starengine/game/entities/Boss$Companion;", "", "()V", "create", "Lcom/example/starengine/game/entities/Boss;", "resources", "Landroid/content/res/Resources;", "screenWidth", "", "healthMultiplier", "", "bulletSpeedMultiplier", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.starengine.game.entities.Boss create(@org.jetbrains.annotations.NotNull()
        android.content.res.Resources resources, int screenWidth, float healthMultiplier, float bulletSpeedMultiplier) {
            return null;
        }
    }
}