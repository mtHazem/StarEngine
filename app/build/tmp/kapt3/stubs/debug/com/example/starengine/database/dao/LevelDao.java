package com.example.starengine.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u0018\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/starengine/database/dao/LevelDao;", "", "deleteAllLevels", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLevels", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/starengine/database/entities/Level;", "getLevel", "levelNumber", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLevel", "level", "(Lcom/example/starengine/database/entities/Level;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface LevelDao {
    
    @androidx.room.Query(value = "SELECT * FROM levels WHERE levelNumber = :levelNumber")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLevel(int levelNumber, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.starengine.database.entities.Level> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM levels")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.starengine.database.entities.Level>> getAllLevels();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLevel(@org.jetbrains.annotations.NotNull()
    com.example.starengine.database.entities.Level level, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM levels")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllLevels(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}