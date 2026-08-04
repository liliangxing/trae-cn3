# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"

.field private final onStep1Completed:Lkotlin/jvm/functions/Function0;
.field private final onStep2Shown:Lkotlin/jvm/functions/Function0;
.field private final step1Gate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.field private final step2Gate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;


.method public constructor <init>(boolean  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 6
    # ins_size=5
    const-string v0, "onStep1Completed"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onStep2Shown"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v4, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->onStep1Completed Lkotlin/jvm/functions/Function0;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->onStep2Shown Lkotlin/jvm/functions/Function0;
    new-instance v4, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v4, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->step1Gate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    new-instance v2, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->step2Gate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  boolean  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move v2, v0
    and-int/lit8 v6, v6, 2
    if-eqz v6, +003h
    move v3, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;-><init>(Z Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final isStep1Reported()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->step1Gate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    return v0
.end method

.method public final isStep2Reported()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->step2Gate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    return v0
.end method

.method public final synchronized onAuthorizationStepAvailable()void
    .registers 2
    # ins_size=1
    monitor-enter v1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->step1Gate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->onStep1Completed Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->step2Gate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;->onStep2Shown Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
.end method
