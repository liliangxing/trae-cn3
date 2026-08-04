# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
.super Ljava/lang/Object;
.source "VolcRtcClient.kt"

.field private final fractionLost:D
.field private final rtt:I
.field private final rxQuality:I
.field private final totalBandwidth:I
.field private final txQuality:I
.field private final uid:Ljava/lang/String;


.method public constructor <init>(java.lang.String  double  int  int  int  int)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    iput-wide v2, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    iput v4, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    iput v5, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    iput v6, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    iput v7, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.lang.String  double  int  int  int  int  int  java.lang.Object)com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-wide v7, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    move-wide v0, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget v9, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    move v14, v9
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget v10, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    move v2, v10
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget v11, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    move v3, v11
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget v12, v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    move v4, v12
    move-object v7, v5
    move-object v8, v6
    move-wide v9, v0
    move v11, v14
    move v12, v2
    move v13, v3
    move v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->copy(Ljava/lang/String; D I I I I)Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    return-object v0
.end method

.method public final component2()double
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    return-wide v0
.end method

.method public final component3()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    return v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    return v0
.end method

.method public final component5()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    return v0
.end method

.method public final component6()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    return v0
.end method

.method public final copy(java.lang.String  double  int  int  int  int)com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    move-object v0, v8
    move-object v1, v10
    move-wide v2, v11
    move v4, v13
    move v5, v14
    move v6, v15
    move/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;-><init>(Ljava/lang/String; D I I I I)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    invoke-static v3, v4, v5, v6, Ljava/lang/Double;->compare(D D)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    iget v3, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    iget v3, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    iget v3, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    iget v8, v8, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getFractionLost()double
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    return-wide v0
.end method

.method public final getRtt()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    return v0
.end method

.method public final getRxQuality()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    return v0
.end method

.method public final getTotalBandwidth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    return v0
.end method

.method public final getTxQuality()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    return v0
.end method

.method public final getUid()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    invoke-static v1, v2, Ljava/lang/Double;->hashCode(D)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RtcNetworkQuality(uid="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->uid Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fractionLost="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->fractionLost D
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rtt="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rtt I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalBandwidth="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->totalBandwidth I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", txQuality="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->txQuality I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", rxQuality="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;->rxQuality I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
