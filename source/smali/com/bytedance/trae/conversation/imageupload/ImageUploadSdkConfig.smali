# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
.super Ljava/lang/Object;
.source "ImageUploadModels.kt"

.field private final api:Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
.field private final enableContentCheck:Z
.field private final getImagexPrefix:Lkotlin/jvm/functions/Function0;
.field private final getRegion:Lkotlin/jvm/functions/Function0;
.field private final getUserId:Lkotlin/jvm/functions/Function1;
.field private final isCnRegion:Lkotlin/jvm/functions/Function0;
.field private final onImageCached:Lkotlin/jvm/functions/Function2;
.field private final uploaderConfig:Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;


.method public constructor <init>(com.bytedance.trae.conversation.imageupload.UploaderConfig  com.bytedance.trae.conversation.imageupload.ImageUploadApi  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  boolean  kotlin.jvm.functions.Function2)void
    .registers 10
    # ins_size=9
    const-string/jumbo v0, uploaderConfig
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "api"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "getUserId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    iput-object v9, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.imageupload.UploaderConfig  com.bytedance.trae.conversation.imageupload.ImageUploadApi  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  boolean  kotlin.jvm.functions.Function2  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 23
    # ins_size=11
    move/from16 v0, v21
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move-object v7, v2
    goto +3h
    move-object/from16 v7, v16
    and-int/lit8 v1, v0, 16
    if-eqz v1, +004h
    move-object v8, v2
    goto +3h
    move-object/from16 v8, v17
    and-int/lit8 v1, v0, 32
    if-eqz v1, +004h
    move-object v9, v2
    goto +3h
    move-object/from16 v9, v18
    and-int/lit8 v1, v0, 64
    if-eqz v1, +005h
    const/4 v1, 0
    move v10, v1
    goto +3h
    move/from16 v10, v19
    and-int/lit16 v0, v0, 128
    if-eqz v0, +004h
    move-object v11, v2
    goto +3h
    move-object/from16 v11, v20
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;-><init>(Lcom/bytedance/trae/conversation/imageupload/UploaderConfig; Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Z Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig  com.bytedance.trae.conversation.imageupload.UploaderConfig  com.bytedance.trae.conversation.imageupload.ImageUploadApi  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  boolean  kotlin.jvm.functions.Function2  int  java.lang.Object)com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig
    .registers 20
    # ins_size=11
    move-object v0, v9
    move/from16 v1, v18
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    goto +2h
    move-object v2, v10
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    goto +2h
    move-object v3, v11
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    goto +2h
    move-object v4, v12
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    goto +2h
    move-object v5, v13
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    goto +2h
    move-object v6, v14
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    goto +2h
    move-object v7, v15
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    goto +3h
    move/from16 v8, v16
    and-int/lit16 v1, v1, 128
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    goto +3h
    move-object/from16 v1, v17
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    move-object v14, v6
    move-object v15, v7
    move/from16 v16, v8
    move-object/from16 v17, v1
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->copy(Lcom/bytedance/trae/conversation/imageupload/UploaderConfig; Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Z Lkotlin/jvm/functions/Function2;)Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.imageupload.UploaderConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.imageupload.ImageUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    return-object v0
.end method

.method public final component3()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final component4()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component5()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component6()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    return v0
.end method

.method public final component8()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.imageupload.UploaderConfig  com.bytedance.trae.conversation.imageupload.ImageUploadApi  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  boolean  kotlin.jvm.functions.Function2)com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig
    .registers 19
    # ins_size=9
    const-string/jumbo v0, uploaderConfig
    move-object v2, v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "api"
    move-object v3, v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "getUserId"
    move-object v4, v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    move-object v1, v0
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    move/from16 v8, v17
    move-object/from16 v9, v18
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;-><init>(Lcom/bytedance/trae/conversation/imageupload/UploaderConfig; Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Z Lkotlin/jvm/functions/Function2;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getApi()com.bytedance.trae.conversation.imageupload.ImageUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    return-object v0
.end method

.method public final getEnableContentCheck()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    return v0
.end method

.method public final getGetImagexPrefix()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getGetRegion()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getGetUserId()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnImageCached()kotlin.jvm.functions.Function2
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public final getUploaderConfig()com.bytedance.trae.conversation.imageupload.UploaderConfig
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public final isCnRegion()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ImageUploadSdkConfig(uploaderConfig="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->uploaderConfig Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", api="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->api Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", getUserId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUserId Lkotlin/jvm/functions/Function1;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", getImagexPrefix="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getImagexPrefix Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isCnRegion="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", getRegion="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getRegion Lkotlin/jvm/functions/Function0;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enableContentCheck="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->enableContentCheck Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", onImageCached="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->onImageCached Lkotlin/jvm/functions/Function2;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
