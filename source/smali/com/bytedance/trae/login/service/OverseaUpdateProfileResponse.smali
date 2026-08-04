# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;
.super Ljava/lang/Object;
.source "OverseaProfileApi.kt"

.field private final description:Ljava/lang/String;
.field private final errorCode:I
.field private final message:Ljava/lang/String;


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;-><init>(Ljava/lang/String; I Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    iput v2, v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    iput-object v3, v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  int  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    const/4 v3, 0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.service.OverseaUpdateProfileResponse  java.lang.String  int  java.lang.String  int  java.lang.Object)com.bytedance.trae.login.service.OverseaUpdateProfileResponse
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget v2, v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->copy(Ljava/lang/String; I Ljava/lang/String;)Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  int  java.lang.String)com.bytedance.trae.login.service.OverseaUpdateProfileResponse
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;
    iget-object v1, v4, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    iget v3, v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDescription()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    return-object v0
.end method

.method public final getErrorCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    return v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v2, v3, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    invoke-static v2, Ljava/lang/Integer;->hashCode(I)I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OverseaUpdateProfileResponse(message="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorCode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->errorCode I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", description="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;->description Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
