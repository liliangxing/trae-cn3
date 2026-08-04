# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogAsyncThreadImpl;
.super Ljava/lang/Object;
.source "PraiseDialogAsyncThreadImpl.kt"

.implements Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAsyncThreadConfig;

.field private final executor:Ljava/util/concurrent/ExecutorService;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    invoke-static Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/praise/PraiseDialogAsyncThreadImpl;->executor Ljava/util/concurrent/ExecutorService;
    return-void 
.end method

.method public execute(java.lang.Runnable)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, runnable
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/praise/PraiseDialogAsyncThreadImpl;->executor Ljava/util/concurrent/ExecutorService;
    invoke-interface v0, v2, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method
