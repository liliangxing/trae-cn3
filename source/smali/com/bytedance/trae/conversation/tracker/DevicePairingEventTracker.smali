# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"

.field private final elapsedRealtime:Lkotlin/jvm/functions/Function0;
.field private isReported:Z
.field private final onResult:Lkotlin/jvm/functions/Function1;
.field private final startedAtMillis:J


.method public constructor <init>(long  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  boolean)void
    .registers 7
    # ins_size=6
    const-string v0, "elapsedRealtime"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onResult"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->startedAtMillis J
    iput-object v4, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->onResult Lkotlin/jvm/functions/Function1;
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->isReported Z
    return-void 
.end method

.method public synthetic constructor <init>(long  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v12, v12, 8
    if-eqz v12, +003h
    const/4 v11, 0
    move v5, v11
    move-object v0, v6
    move-wide v1, v7
    move-object v3, v9
    move-object v4, v10
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;-><init>(J Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Z)V
    return-void 
.end method

.method private final report(boolean  com.bytedance.trae.conversation.tracker.DevicePairResultDetail)void
    .registers 9
    # ins_size=3
    iget-boolean v0, v6, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->isReported Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v6, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->isReported Z
    iget-object v0, v6, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->onResult Lkotlin/jvm/functions/Function1;
    new-instance v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->elapsedRealtime Lkotlin/jvm/functions/Function0;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->longValue()J
    move-result-wide v2
    iget-wide v4, v6, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->startedAtMillis J
    sub-long/2addr v2, v4
    const-wide/16 v4, 0
    invoke-static v2, v3, v4, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v2
    invoke-direct v1, v2, v3, v7, v8, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;-><init>(J Z Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;)V
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final isReported()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->isReported Z
    return v0
.end method

.method public final synchronized onPairingExited(boolean)void
    .registers 3
    # ins_size=2
    monitor-enter v1
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;->STEP1_COMPLETE Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;->STEP1_INCOMPLETE Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    const/4 v0, 0
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->report(Z Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;)V
    monitor-exit v1
    return-void 
    move-exception v2
    monitor-exit v1
    throw v2
    :try_start_0x3
.end method

.method public final synchronized onPairingSucceeded()void
    .registers 3
    # ins_size=1
    monitor-enter v2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;->STEP2_COMPLETE Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    const/4 v1, 1
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;->report(Z Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;)V
    monitor-exit v2
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0x1
.end method
