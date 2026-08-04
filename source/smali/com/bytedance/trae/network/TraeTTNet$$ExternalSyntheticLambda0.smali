# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/frameworks/baselib/network/TTNetInitMetrics$TTNetInitCallback;

.field public final synthetic f$0:Ljava/util/concurrent/atomic/AtomicBoolean;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(java.util.concurrent.atomic.AtomicBoolean  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;->f$0 Ljava/util/concurrent/atomic/AtomicBoolean;
    iput-object v2, v0, Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final ttnetInitSuccessCallback()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;->f$0 Ljava/util/concurrent/atomic/AtomicBoolean;
    iget-object v1, v2, Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, Lcom/bytedance/trae/network/TraeTTNet;->$r8$lambda$LlFMZey6RH6PvPL47gzObXXV99w(Ljava/util/concurrent/atomic/AtomicBoolean; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method
