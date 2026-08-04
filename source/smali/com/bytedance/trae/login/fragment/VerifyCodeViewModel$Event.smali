# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;
.super Ljava/lang/Object;
.source "VerifyCodeViewModel.kt"

.field private final content:Ljava/lang/Object;
.field private final hasBeenHandled:Ljava/util/concurrent/atomic/AtomicBoolean;


.method public constructor <init>(java.lang.Object)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;->content Ljava/lang/Object;
    new-instance v2, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v0, 0
    invoke-direct v2, v0, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    iput-object v2, v1, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;->hasBeenHandled Ljava/util/concurrent/atomic/AtomicBoolean;
    return-void 
.end method

.method public final getContentIfNotHandled()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;->hasBeenHandled Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-eqz v0, +005h
    iget-object v0, v3, Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;->content Ljava/lang/Object;
    goto +2h
    const/4 v0, 0
    return-object v0
.end method
