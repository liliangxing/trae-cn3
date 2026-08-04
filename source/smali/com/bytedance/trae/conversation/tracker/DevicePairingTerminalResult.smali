# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;
.super Ljava/lang/Object;
.source "DeviceEvents.kt"

.field private final durationMillis:J
.field private final isSuccess:Z
.field private final resultDetail:Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;


.method public constructor <init>(long  boolean  com.bytedance.trae.conversation.tracker.DevicePairResultDetail)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, resultDetail
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    iput-boolean v4, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    iput-object v5, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.tracker.DevicePairingTerminalResult  long  boolean  com.bytedance.trae.conversation.tracker.DevicePairResultDetail  int  java.lang.Object)com.bytedance.trae.conversation.tracker.DevicePairingTerminalResult
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->copy(J Z Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;)Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    return-wide v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    return v0
.end method

.method public final component3()com.bytedance.trae.conversation.tracker.DevicePairResultDetail
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    return-object v0
.end method

.method public final copy(long  boolean  com.bytedance.trae.conversation.tracker.DevicePairResultDetail)com.bytedance.trae.conversation.tracker.DevicePairingTerminalResult
    .registers 6
    # ins_size=5
    const-string/jumbo v0, resultDetail
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;-><init>(J Z Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    iget-boolean v3, v8, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    iget-object v8, v8, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getDurationMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    return-wide v0
.end method

.method public final getResultDetail()com.bytedance.trae.conversation.tracker.DevicePairResultDetail
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DevicePairingTerminalResult(durationMillis="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->durationMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSuccess="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->isSuccess Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", resultDetail="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;->resultDetail Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
