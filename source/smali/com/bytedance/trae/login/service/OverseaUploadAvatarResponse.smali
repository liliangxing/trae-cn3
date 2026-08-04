# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;
.super Ljava/lang/Object;
.source "OverseaProfileApi.kt"

.field private final data:Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
.field private final message:Ljava/lang/String;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/service/OverseaUploadAvatarData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  com.bytedance.trae.login.service.OverseaUploadAvatarData)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.login.service.OverseaUploadAvatarData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=5
    and-int/lit8 v5, v4, 1
    const/4 v0, 0
    if-eqz v5, +003h
    move-object v2, v0
    and-int/lit8 v4, v4, 2
    if-eqz v4, +003h
    move-object v3, v0
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.service.OverseaUploadAvatarResponse  java.lang.String  com.bytedance.trae.login.service.OverseaUploadAvatarData  int  java.lang.Object)com.bytedance.trae.login.service.OverseaUploadAvatarResponse
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->copy(Ljava/lang/String; Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;)Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.login.service.OverseaUploadAvatarData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.login.service.OverseaUploadAvatarData)com.bytedance.trae.login.service.OverseaUploadAvatarResponse
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;-><init>(Ljava/lang/String; Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;
    iget-object v1, v4, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    iget-object v5, v5, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()com.bytedance.trae.login.service.OverseaUploadAvatarData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    return-object v0
.end method

.method public final getMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OverseaUploadAvatarResponse(message="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->message Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;->data Lcom/bytedance/trae/login/service/OverseaUploadAvatarData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
