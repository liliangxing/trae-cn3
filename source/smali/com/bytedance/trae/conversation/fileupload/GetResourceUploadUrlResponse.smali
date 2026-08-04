# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;
.super Ljava/lang/Object;
.source "ResourceUploadModels.kt"

.field private final overrideResourceId:Ljava/lang/String;
.field private final sessionKey:Ljava/lang/String;
.field private final storeInfos:Ljava/util/List;
.field private final uploadHosts:Ljava/util/List;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;-><init>(Ljava/util/List; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.util.List  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.util.List  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;-><init>(Ljava/util/List; Ljava/util/List; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.GetResourceUploadUrlResponse  java.util.List  java.util.List  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.GetResourceUploadUrlResponse
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->copy(Ljava/util/List; Ljava/util/List; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.util.List  java.util.List  java.lang.String  java.lang.String)com.bytedance.trae.conversation.fileupload.GetResourceUploadUrlResponse
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;-><init>(Ljava/util/List; Ljava/util/List; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getOverrideResourceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    return-object v0
.end method

.method public final getSessionKey()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    return-object v0
.end method

.method public final getStoreInfos()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    return-object v0
.end method

.method public final getUploadHosts()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
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
    const-string v1, "GetResourceUploadUrlResponse(uploadHosts="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->uploadHosts Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", storeInfos="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->storeInfos Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sessionKey="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->sessionKey Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", overrideResourceId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/GetResourceUploadUrlResponse;->overrideResourceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
