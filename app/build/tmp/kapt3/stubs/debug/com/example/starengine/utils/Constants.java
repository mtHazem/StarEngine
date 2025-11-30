package com.example.starengine.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/starengine/utils/Constants;", "", "()V", "ALIEN_HEIGHT", "", "ALIEN_SPEED", "ALIEN_WIDTH", "BULLET_HEIGHT", "BULLET_POWER_UPGRADE_COST", "", "BULLET_SPEED", "BULLET_WIDTH", "FIRE_RATE_UPGRADE_COST", "FRAME_TIME_MS", "", "INITIAL_ALIEN_SPAWN_DELAY", "JET_HEIGHT", "JET_MOVE_SPEED", "JET_WIDTH", "MIN_ALIEN_SPAWN_DELAY", "POINTS_PER_ALIEN", "SHIP_WIDTH_UPGRADE_COST", "TARGET_FPS", "app_debug"})
public final class Constants {
    private static final int TARGET_FPS = 60;
    public static final long FRAME_TIME_MS = 16L;
    public static final float JET_WIDTH = 150.0F;
    public static final float JET_HEIGHT = 150.0F;
    public static final float JET_MOVE_SPEED = 20.0F;
    public static final float BULLET_WIDTH = 20.0F;
    public static final float BULLET_HEIGHT = 40.0F;
    public static final float BULLET_SPEED = 30.0F;
    public static final float ALIEN_WIDTH = 120.0F;
    public static final float ALIEN_HEIGHT = 120.0F;
    public static final float ALIEN_SPEED = 5.0F;
    public static final long INITIAL_ALIEN_SPAWN_DELAY = 2000L;
    public static final long MIN_ALIEN_SPAWN_DELAY = 500L;
    public static final int POINTS_PER_ALIEN = 10;
    public static final int FIRE_RATE_UPGRADE_COST = 50;
    public static final int BULLET_POWER_UPGRADE_COST = 100;
    public static final int SHIP_WIDTH_UPGRADE_COST = 75;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.starengine.utils.Constants INSTANCE = null;
    
    private Constants() {
        super();
    }
}