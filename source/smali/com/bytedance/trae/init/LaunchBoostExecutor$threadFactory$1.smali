# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/LaunchBoostExecutor$threadFactory$1;
.super Ljava/lang/Object;
.source "LaunchBoostExecutor.kt"

.implements Ljava/util/concurrent/ThreadFactory;

.field private final threadNumber:Ljava/util/concurrent/atomic/AtomicInteger;


.method constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;
    const/4 v1, 1
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    iput-object v0, v2, Lcom/bytedance/trae/init/LaunchBoostExecutor$threadFactory$1;->threadNumber Ljava/util/concurrent/atomic/AtomicInteger;
    return-void 
.end method

.method public newThread(java.lang.Runnable)java.lang.Thread
    .registers 9
    # ins_size=2
    const-string v0, "r"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/Thread;
    new-instance v2, Ljava/lang/ThreadGroup;
    const-string v1, "flow_a"
    invoke-direct v2, v1, Ljava/lang/ThreadGroup;-><init>(Ljava/lang/String;)V
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "flow_a_launch"
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v7, Lcom/bytedance/trae/init/LaunchBoostExecutor$threadFactory$1;->threadNumber Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v3, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I
    move-result v3
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-wide/16 v5, 0
    move-object v1, v0
    move-object v3, v8
    invoke-direct/range v1 ... v6, Ljava/lang/Thread;-><init>(Ljava/lang/ThreadGroup; Ljava/lang/Runnable; Ljava/lang/String; J)V
    return-object v0
.end method
