# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/FallbackPushRequest;
.super Ljava/lang/Object;
.source "HubNetFallbackApi.kt"

.field private final deviceId:J
.field private final frontierId:J
.field private final msgs:Ljava/util/List;


.method public constructor <init>(long  long  java.util.List)void
    .registers 7
    # ins_size=6
    const-string v0, "msgs"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    iput-wide v4, v1, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    iput-object v6, v1, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.FallbackPushRequest  long  long  java.util.List  int  java.lang.Object)com.bytedance.trae.network.FallbackPushRequest
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget-wide v9, v6, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    move-wide v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget-object v11, v6, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    move-object v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/network/FallbackPushRequest;->copy(J J Ljava/util/List;)Lcom/bytedance/trae/network/FallbackPushRequest;
    move-result-object v6
    return-object v6
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    return-wide v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    return-wide v0
.end method

.method public final component3()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    return-object v0
.end method

.method public final copy(long  long  java.util.List)com.bytedance.trae.network.FallbackPushRequest
    .registers 13
    # ins_size=6
    const-string v0, "msgs"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/network/FallbackPushRequest;
    move-object v1, v0
    move-wide v2, v8
    move-wide v4, v10
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/network/FallbackPushRequest;-><init>(J J Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/network/FallbackPushRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/network/FallbackPushRequest;
    iget-wide v3, v7, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    iget-wide v5, v8, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    iget-wide v5, v8, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    iget-object v8, v8, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getDeviceId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    return-wide v0
.end method

.method public final getFrontierId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    return-wide v0
.end method

.method public final getMsgs()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FallbackPushRequest(frontierId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/network/FallbackPushRequest;->frontierId J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/network/FallbackPushRequest;->deviceId J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", msgs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/network/FallbackPushRequest;->msgs Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
