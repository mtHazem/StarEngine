package com.example.starengine.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/starengine/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "levelDao", "Lcom/example/starengine/database/dao/LevelDao;", "scoreDao", "Lcom/example/starengine/database/dao/ScoreDao;", "upgradeDao", "Lcom/example/starengine/database/dao/UpgradeDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.starengine.database.entities.Score.class, com.example.starengine.database.entities.Upgrade.class, com.example.starengine.database.entities.Level.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.starengine.database.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.starengine.database.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.starengine.database.dao.ScoreDao scoreDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.starengine.database.dao.UpgradeDao upgradeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.starengine.database.dao.LevelDao levelDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/starengine/database/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/starengine/database/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "initializeDefaultData", "", "database", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.starengine.database.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final void initializeDefaultData(com.example.starengine.database.AppDatabase database) {
        }
    }
}