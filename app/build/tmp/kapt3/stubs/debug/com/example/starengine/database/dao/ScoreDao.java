package com.example.starengine.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\tH\'J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/example/starengine/database/dao/ScoreDao;", "", "deleteAllScores", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllScores", "", "Lcom/example/starengine/database/entities/Score;", "getTop5Scores", "Lkotlinx/coroutines/flow/Flow;", "getTop5ScoresList", "insertScore", "score", "(Lcom/example/starengine/database/entities/Score;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ScoreDao {
    
    @androidx.room.Query(value = "SELECT * FROM scores ORDER BY points DESC LIMIT 5")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.starengine.database.entities.Score>> getTop5Scores();
    
    @androidx.room.Query(value = "SELECT * FROM scores ORDER BY points DESC LIMIT 5")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTop5ScoresList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.starengine.database.entities.Score>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM scores")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllScores(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.starengine.database.entities.Score>> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertScore(@org.jetbrains.annotations.NotNull()
    com.example.starengine.database.entities.Score score, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM scores")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAllScores(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}