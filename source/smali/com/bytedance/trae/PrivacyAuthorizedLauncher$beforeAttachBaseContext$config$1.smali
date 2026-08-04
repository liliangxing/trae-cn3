# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/PrivacyAuthorizedLauncher$beforeAttachBaseContext$config$1;
.super Ljava/lang/Object;
.source "PrivacyAuthorizedLauncher.kt"

.implements Ljava/util/concurrent/ThreadFactory;

.field private final mCount:Ljava/util/concurrent/atomic/AtomicInteger;


.method constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;
    const/4 v1, 1
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V
    iput-object v0, v2, Lcom/bytedance/trae/PrivacyAuthorizedLauncher$beforeAttachBaseContext$config$1;->mCount Ljava/util/concurrent/atomic/AtomicInteger;
    return-void 
.end method

.method public newThread(java.lang.Runnable)java.lang.Thread
    .registers 5
    # ins_size=2
    const-string v0, "r"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/Thread;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "_a_init_"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v3, Lcom/bytedance/trae/PrivacyAuthorizedLauncher$beforeAttachBaseContext$config$1;->mCount Ljava/util/concurrent/atomic/AtomicInteger;
    invoke-virtual v2, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I
    move-result v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v4, v1, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable; Ljava/lang/String;)V
    return-object v0
.end method
