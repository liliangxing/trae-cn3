# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"

.field private lastAcceptedAtMillis:Ljava/lang/Long;
.field private final minIntervalMillis:J


.method public constructor <init>(long)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->minIntervalMillis J
    return-void 
.end method

.method public final synchronized release()void
    .registers 2
    # ins_size=1
    monitor-enter v1
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->lastAcceptedAtMillis Ljava/lang/Long;
    monitor-exit v1
    return-void 
    move-exception v0
    monitor-exit v1
    throw v0
    :try_start_0x2
.end method

.method public final synchronized tryAcquire(long)boolean
    .registers 7
    # ins_size=3
    monitor-enter v4
    iget-object v0, v4, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->lastAcceptedAtMillis Ljava/lang/Long;
    if-eqz v0, +019h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    cmp-long v1, v5, v1
    if-ltz v1, +011h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    sub-long v0, v5, v0
    iget-wide v2, v4, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->minIntervalMillis J
    cmp-long v0, v0, v2
    if-gez v0, +005h
    monitor-exit v4
    const/4 v5, 0
    return v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v5
    iput-object v5, v4, Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;->lastAcceptedAtMillis Ljava/lang/Long;
    monitor-exit v4
    const/4 v5, 1
    return v5
    move-exception v5
    monitor-exit v4
    throw v5
    :try_start_0x1
    :try_start_0x1c
.end method
