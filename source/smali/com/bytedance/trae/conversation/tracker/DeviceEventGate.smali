# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"

.field private bridge isConsumed:Z


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed Z
    return-void 
.end method

.method public synthetic constructor <init>(boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    return-void 
.end method

.method public final isConsumed()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed Z
    return v0
.end method

.method public final synchronized reset()void
    .registers 2
    # ins_size=1
    monitor-enter v1
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed Z
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x2
.end method

.method public final synchronized tryConsume()boolean
    .registers 2
    # ins_size=1
    monitor-enter v1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed Z
    if-eqz v0, +005h
    monitor-exit v1
    const/4 v0, 0
    return v0
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed Z
    monitor-exit v1
    return v0
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x1
    :try_start_0x9
.end method
