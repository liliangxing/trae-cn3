# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
.super Ljava/lang/Object;
.source "IMService.kt"

.field private final available:Z
.field private final cliId:Ljava/lang/String;
.field private final timestamp:J


.method public constructor <init>(java.lang.String  boolean  long)void
    .registers 6
    # ins_size=5
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    iput-wide v4, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  long  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    const-wide/16 v3, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;-><init>(Ljava/lang/String; Z J)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.IMService$CliStatusChangePayload  java.lang.String  boolean  long  int  java.lang.Object)com.bytedance.trae.im.service.IMService$CliStatusChangePayload
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-wide v3, v0, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->copy(Ljava/lang/String; Z J)Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    return v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    return-wide v0
.end method

.method public final copy(java.lang.String  boolean  long)com.bytedance.trae.im.service.IMService$CliStatusChangePayload
    .registers 6
    # ins_size=5
    const-string v0, "cliId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;-><init>(Ljava/lang/String; Z J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;
    iget-object v1, v7, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    iget-boolean v3, v8, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    if-eq v1, v3, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getAvailable()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CliStatusChangePayload(cliId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", available="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->available Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", timestamp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->timestamp J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
