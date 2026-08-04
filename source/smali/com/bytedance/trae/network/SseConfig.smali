# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/SseConfig;
.super Ljava/lang/Object;
.source "SseConfig.kt"

.field private final heartbeatTimeoutMs:J
.field private final maxConsecutiveFailures:I
.field private final reconnectBaseMs:J
.field private final reconnectJitterMs:J
.field private final reconnectMaxMs:J


.method public constructor <init>()void
    .registers 13
    # ins_size=1
    const-wide/16 v1, 0
    const-wide/16 v3, 0
    const-wide/16 v5, 0
    const-wide/16 v7, 0
    const/4 v9, 0
    const/16 v10, 31
    const/4 v11, 0
    move-object v0, v12
    invoke-direct/range v0 ... v11, Lcom/bytedance/trae/network/SseConfig;-><init>(J J J J I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  long  long  long  int)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    iput-wide v3, v0, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    iput-wide v5, v0, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    iput-wide v7, v0, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    iput v9, v0, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    return-void 
.end method

.method public synthetic constructor <init>(long  long  long  long  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 21
    # ins_size=12
    and-int/lit8 v0, v19, 1
    const-wide/16 v1, 30000
    if-eqz v0, +004h
    move-wide v3, v1
    goto +2h
    move-wide v3, v10
    and-int/lit8 v0, v19, 2
    const-wide/16 v5, 1000
    if-eqz v0, +004h
    move-wide v7, v5
    goto +2h
    move-wide v7, v12
    and-int/lit8 v0, v19, 4
    if-eqz v0, +003h
    goto +2h
    move-wide v1, v14
    and-int/lit8 v0, v19, 8
    if-eqz v0, +003h
    goto +3h
    move-wide/from16 v5, v16
    and-int/lit8 v0, v19, 16
    if-eqz v0, +004h
    const/4 v0, 5
    goto +3h
    move/from16 v0, v18
    move-object v10, v9
    move-wide v11, v3
    move-wide v13, v7
    move-wide v15, v1
    move-wide/from16 v17, v5
    move/from16 v19, v0
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/network/SseConfig;-><init>(J J J J I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.SseConfig  long  long  long  long  int  int  java.lang.Object)com.bytedance.trae.network.SseConfig
    .registers 22
    # ins_size=12
    move-object v0, v10
    and-int/lit8 v1, v20, 1
    if-eqz v1, +005h
    iget-wide v1, v0, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    goto +2h
    move-wide v1, v11
    and-int/lit8 v3, v20, 2
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    goto +2h
    move-wide v3, v13
    and-int/lit8 v5, v20, 4
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    goto +2h
    move-wide v5, v15
    and-int/lit8 v7, v20, 8
    if-eqz v7, +005h
    iget-wide v7, v0, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    goto +3h
    move-wide/from16 v7, v17
    and-int/lit8 v9, v20, 16
    if-eqz v9, +005h
    iget v9, v0, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    goto +3h
    move/from16 v9, v19
    move-wide v11, v1
    move-wide v13, v3
    move-wide v15, v5
    move-wide/from16 v17, v7
    move/from16 v19, v9
    invoke-virtual/range v10 ... v19, Lcom/bytedance/trae/network/SseConfig;->copy(J J J J I)Lcom/bytedance/trae/network/SseConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    return-wide v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    return-wide v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    return-wide v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    return v0
.end method

.method public final copy(long  long  long  long  int)com.bytedance.trae.network.SseConfig
    .registers 21
    # ins_size=10
    new-instance v10, Lcom/bytedance/trae/network/SseConfig;
    move-object v0, v10
    move-wide v1, v12
    move-wide v3, v14
    move-wide/from16 v5, v16
    move-wide/from16 v7, v18
    move/from16 v9, v20
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/SseConfig;-><init>(J J J J I)V
    return-object v10
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/network/SseConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/network/SseConfig;
    iget-wide v3, v7, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    iget-wide v5, v8, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    iget-wide v5, v8, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    iget-wide v5, v8, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    iget-wide v5, v8, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    iget v8, v8, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getHeartbeatTimeoutMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    return-wide v0
.end method

.method public final getMaxConsecutiveFailures()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    return v0
.end method

.method public final getReconnectBaseMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    return-wide v0
.end method

.method public final getReconnectJitterMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    return-wide v0
.end method

.method public final getReconnectMaxMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SseConfig(heartbeatTimeoutMs="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->heartbeatTimeoutMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", reconnectBaseMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->reconnectBaseMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", reconnectMaxMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->reconnectMaxMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", reconnectJitterMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/network/SseConfig;->reconnectJitterMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", maxConsecutiveFailures="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/network/SseConfig;->maxConsecutiveFailures I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
