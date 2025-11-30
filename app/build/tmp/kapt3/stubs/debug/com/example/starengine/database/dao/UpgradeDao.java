package com.example.starengine.database.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/example/starengine/database/dao/UpgradeDao;", "", "getUpgrade", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/starengine/database/entities/Upgrade;", "getUpgradeSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUpgrade", "", "upgrade", "(Lcom/example/starengine/database/entities/Upgrade;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUpgrade", "app_debug"})
@androidx.room.Dao()
public abstract interface UpgradeDao {
    
    @androidx.room.Query(value = "SELECT * FROM upgrades WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.starengine.database.entities.Upgrade> getUpgrade();
    
    @androidx.room.Query(value = "SELECT * FROM upgrades WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUpgradeSync(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.starengine.database.entities.Upgrade> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUpgrade(@org.jetbrains.annotations.NotNull()
    com.example.starengine.database.entities.Upgrade upgrade, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUpgrade(@org.jetbrains.annotations.NotNull()
    com.example.starengine.database.entities.Upgrade upgrade, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}