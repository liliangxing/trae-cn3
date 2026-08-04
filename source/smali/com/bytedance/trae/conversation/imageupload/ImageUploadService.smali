# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
.super Ljava/lang/Object;
.source "ImageUploadService.kt"

.field private final compressor:Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
.field private final sdkConfig:Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
.field private final tokenManager:Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
.field private final uploader:Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;


.method public static synthetic $r8$lambda$LepMg7EEpEm5at9Bpg7m6NEgS7Y(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->_init_$lambda$0(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zpQXu5076whmdm1HodbIFY3fgFA(int)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadImage$lambda$2(I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig  com.bytedance.trae.conversation.imageupload.StsTokenManager  com.bytedance.trae.conversation.imageupload.ImageXUploader  com.bytedance.trae.conversation.imageupload.ImageCompressor)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, sdkConfig
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tokenManager
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, uploader
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->tokenManager Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploader Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->compressor Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig  com.bytedance.trae.conversation.imageupload.StsTokenManager  com.bytedance.trae.conversation.imageupload.ImageXUploader  com.bytedance.trae.conversation.imageupload.ImageCompressor  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 9
    # ins_size=7
    and-int/lit8 v8, v7, 2
    const/4 v0, 0
    if-eqz v8, +013h
    new-instance v4, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;
    invoke-direct v8, v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    new-instance v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;)V
    invoke-direct v4, v8, v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function0;)V
    and-int/lit8 v8, v7, 4
    if-eqz v8, +009h
    new-instance v5, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    invoke-direct v5, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;-><init>()V
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;
    and-int/lit8 v7, v7, 8
    if-eqz v7, +003h
    move-object v6, v0
    invoke-direct v2, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig; Lcom/bytedance/trae/conversation/imageupload/StsTokenManager; Lcom/bytedance/trae/conversation/imageupload/ImageXUploader; Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig)java.lang.String
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUploaderConfig()Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;->getDefaultServiceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getCompressor$p(com.bytedance.trae.conversation.imageupload.ImageUploadService)com.bytedance.trae.conversation.imageupload.ImageCompressor
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->compressor Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
    return-object v0
.end method

.method public static final synthetic access$getSdkConfig$p(com.bytedance.trae.conversation.imageupload.ImageUploadService)com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    return-object v0
.end method

.method public static final synthetic access$getUploader$p(com.bytedance.trae.conversation.imageupload.ImageUploadService)com.bytedance.trae.conversation.imageupload.ImageXUploader
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploader Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;
    return-object v0
.end method

.method public static final synthetic access$uploadOnce(com.bytedance.trae.conversation.imageupload.ImageUploadService  java.io.File  com.bytedance.trae.conversation.imageupload.ImageDimension  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadOnce(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$uploadWithRetry(com.bytedance.trae.conversation.imageupload.ImageUploadService  java.io.File  com.bytedance.trae.conversation.imageupload.ImageDimension  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadWithRetry(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final defaultIsCnRegion()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method private final fallbackUrl(java.lang.String  java.lang.String)java.lang.String
    .registers 7
    # ins_size=3
    const-string v0, "http://"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +018h
    const-string v0, "https://"
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +eh
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v0, 47
    invoke-virtual v5, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private final getRegionOrDefault(boolean)java.lang.String
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getGetRegion()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    if-eqz v0, +019h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-eqz v0, +011h
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-nez v0, +009h
    if-eqz v3, +005h
    const-string v0, "cn"
    goto +3h
    const-string v0, "i18n"
    return-object v0
.end method

.method private final mapThrowable(java.lang.Throwable)com.bytedance.trae.conversation.imageupload.ImageUploadException
    .registers 5
    # ins_size=2
    instance-of v0, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    if-eqz v0, +005h
    check-cast v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    return-object v4
    instance-of v0, v4, Lkotlinx/coroutines/TimeoutCancellationException;
    if-eqz v0, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->TIMEOUT Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v2, "Upload timeout"
    invoke-direct v0, v1, v2, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-virtual v4, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, "Unknown"
    invoke-direct v0, v1, v2, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v0
.end method

.method public static synthetic uploadBatch$default(com.bytedance.trae.conversation.imageupload.ImageUploadService  java.util.List  int  int  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +003h
    const/4 v8, 0
    move v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +003h
    const/4 v9, 3
    move v3, v9
    and-int/lit8 v8, v12, 8
    if-eqz v8, +003h
    const/4 v10, 0
    move-object v4, v10
    move-object v0, v6
    move-object v1, v7
    move-object v5, v11
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadBatch(Ljava/util/List; I I Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    return-object v6
.end method

.method public static synthetic uploadImage$default(com.bytedance.trae.conversation.imageupload.ImageUploadService  java.io.File  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +007h
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda1;
    invoke-direct v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$$ExternalSyntheticLambda1;-><init>()V
    move-object v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +005h
    const-wide/32 v9, 60000
    move-wide v3, v9
    move-object v0, v6
    move-object v1, v7
    move-object v5, v11
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadImage(Ljava/io/File; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    return-object v6
.end method

.method private static final uploadImage$lambda$2(int)kotlin.Unit
    .registers 1
    # ins_size=1
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final uploadOnce(java.io.File  com.bytedance.trae.conversation.imageupload.ImageDimension  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 26
    # ins_size=7
    move-object/from16 v0, v19
    move-object/from16 v1, v25
    instance-of v2, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    const/4 v5, 1
    const/4 v6, 2
    const/4 v7, 0
    packed-switch v4, +0000244h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v3, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/io/File;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1cbh
    iget-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/io/File;
    iget-object v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +196h
    move-object v3, v4
    move-object v4, v5
    move-object v5, v8
    move-object v2, v9
    goto/16 +1c0h
    iget-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/io/File;
    iget-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +133h
    iget-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/io/File;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v5
    move-object v5, v4
    goto/16 +107h
    iget-wide v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->J$0 J
    iget-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$5 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$4 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    check-cast v10, Lkotlin/jvm/functions/Function1;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    iget-object v12, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    check-cast v12, Ljava/io/File;
    iget-object v13, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v15, v10
    move-object v14, v12
    goto/16 +0b6h
    iget-wide v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->J$0 J
    iget-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$4 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v10, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    check-cast v10, Lkotlin/jvm/functions/Function1;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    iget-object v12, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    check-cast v12, Ljava/io/File;
    iget-object v13, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide/from16 v17, v8
    move-object v9, v11
    move-object v8, v13
    move-wide/from16 v13, v17
    goto +51h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->isCnRegion()Lkotlin/jvm/functions/Function0;
    move-result-object v1
    if-eqz v1, +00ch
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    goto +4h
    invoke-direct/range v19, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->defaultIsCnRegion()Z
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v1
    if-eqz v1, +005h
    const-string v1, "i18n"
    goto +3h
    const-string v1, "cn"
    iget-object v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getGetUserId()Lkotlin/jvm/functions/Function1;
    move-result-object v4
    iput-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    move-object/from16 v8, v20
    iput-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    move-object/from16 v9, v21
    iput-object v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    move-object/from16 v10, v22
    iput-object v10, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$4 Ljava/lang/Object;
    move-wide/from16 v11, v23
    iput-wide v11, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->J$0 J
    iput v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    invoke-interface v4, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v3, +003h
    return-object v3
    move-wide v13, v11
    move-object v12, v8
    move-object v8, v0
    move-object/from16 v17, v4
    move-object v4, v1
    move-object/from16 v1, v17
    check-cast v1, Ljava/lang/String;
    iget-object v11, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getGetImagexPrefix()Lkotlin/jvm/functions/Function0;
    move-result-object v11
    if-eqz v11, +018h
    invoke-interface v11, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    if-eqz v11, +010h
    move-object v15, v11
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v15
    xor-int/2addr v5, v15
    if-eqz v5, +003h
    goto +2h
    move-object v11, v7
    if-nez v11, +003h
    move-object v11, v1
    iget-object v5, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->tokenManager Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;
    iput-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    iput-object v12, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$4 Ljava/lang/Object;
    iput-object v11, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$5 Ljava/lang/Object;
    iput-wide v13, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->J$0 J
    iput v6, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    invoke-virtual v5, v1, v2, Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;->getToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v15, v10
    move-object/from16 v17, v9
    move-object v9, v4
    move-wide v4, v13
    move-object v13, v8
    move-object v8, v11
    move-object v14, v12
    move-object/from16 v11, v17
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    sget-object v10, Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;
    invoke-virtual v10, v14, v8, v9, v11, Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;->generate(Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/ImageDimension;)Ljava/lang/String;
    move-result-object v8
    new-instance v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;
    const/16 v16, 0
    move-object v10, v9
    move-object v11, v13
    move-object v12, v14
    move-object v6, v13
    move-object v13, v8
    move-object v8, v14
    move-object v14, v1
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/StsTokenData; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    iput-object v6, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$4 Ljava/lang/Object;
    iput-object v7, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$5 Ljava/lang/Object;
    const/4 v1, 3
    iput v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    invoke-static v4, v5, v9, v2, Lkotlinx/coroutines/TimeoutKt;->withTimeout(J Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v5, v8
    move-object v8, v6
    move-object v4, v1
    check-cast v4, Ljava/lang/String;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getApi()Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    move-result-object v1
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    iput-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    iput-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    const/4 v9, 4
    iput v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    invoke-interface v1, v6, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;->getImageUrls(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    check-cast v1, Ljava/util/Map;
    invoke-interface v1, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +01fh
    iget-object v1, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUploaderConfig()Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;->getImageHost()Ljava/lang/String;
    move-result-object v1
    invoke-direct v8, v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->fallbackUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    goto +fh
    iget-object v1, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUploaderConfig()Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;->getImageHost()Ljava/lang/String;
    move-result-object v1
    invoke-direct v8, v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->fallbackUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    iget-object v6, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getEnableContentCheck()Z
    move-result v6
    if-eqz v6, +077h
    iget-object v6, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getApi()Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    move-result-object v6
    iput-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    iput-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    const/4 v9, 5
    iput v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    invoke-interface v6, v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;->checkImageContent(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v3, +003h
    return-object v3
    move-object v9, v8
    move-object v8, v5
    move-object v5, v4
    move-object v4, v1
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;
    if-nez v1, +026h
    iget-object v1, v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getApi()Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    move-result-object v1
    iput-object v9, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$0 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$1 Ljava/lang/Object;
    iput-object v5, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$2 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->L$3 Ljava/lang/Object;
    const/4 v6, 6
    iput v6, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$1;->label I
    invoke-interface v1, v4, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;->checkImageContent(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v3, v4
    move-object v4, v5
    move-object v5, v8
    move-object v2, v9
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;
    move-object v7, v1
    move-object v9, v2
    move-object v8, v5
    move-object v5, v4
    move-object v4, v3
    goto +2h
    move-object v7, v1
    move-object v1, v4
    move-object v4, v5
    move-object v5, v8
    move-object v8, v9
    goto +5h
    move-object v3, v1
    move-object v2, v8
    move-object v8, v2
    move-object v1, v3
    if-eqz v7, +026h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;->getCode()I
    move-result v2
    if-nez v2, +020h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/imageupload/ContentCheckResult;->getPass()Ljava/lang/Boolean;
    move-result-object v2
    const/4 v3, 0
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +fh
    new-instance v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->CONTENT_CHECK_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v11, "Image content does not meet requirements"
    const/4 v12, 0
    const/4 v13, 4
    const/4 v14, 0
    move-object v9, v1
    invoke-direct/range v9 ... v14, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v1
    iget-object v2, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getOnImageCached()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    if-eqz v2, +016h
    invoke-static v5, Lkotlin/io/FilesKt;->readBytes(Ljava/io/File;)[B
    move-result-object v3
    const/4 v5, 2
    invoke-static v3, v5, Landroid/util/Base64;->encodeToString([B I)Ljava/lang/String;
    move-result-object v3
    new-instance v5, Lcom/bytedance/trae/conversation/imageupload/ImageCacheData;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v3, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCacheData;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v2, v4, v5, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;
    invoke-direct v2, v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v2
    nop 
    packed-switch-payload 0 1 2 3 4 5 6
    :try_start_0x43
    :try_start_0x58
    :try_start_0x6f
    :try_start_0x18b
    :try_start_0x1d4
    :try_start_0x1f1
    :try_start_0x211
    :try_start_0x251
.end method

.method private final uploadWithRetry(java.io.File  com.bytedance.trae.conversation.imageupload.ImageDimension  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 31
    # ins_size=7
    move-object/from16 v0, v30
    instance-of v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->label I
    move-object/from16 v2, v24
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;
    move-object/from16 v2, v24
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->label I
    const/4 v6, 0
    const/4 v7, 2
    const/4 v8, 1
    if-eqz v4, +051h
    if-eq v4, v8, +02fh
    if-ne v4, v7, +025h
    iget v4, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->I$0 I
    iget-wide v9, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->J$0 J
    iget-object v11, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$4 Ljava/lang/Object;
    check-cast v11, Ljava/lang/Throwable;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$3 Ljava/lang/Object;
    check-cast v12, Lkotlin/jvm/functions/Function1;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v14, Ljava/io/File;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v15, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v5, v3
    move-object v0, v11
    move-object v3, v13
    move-object v11, v1
    move-object v1, v14
    move-object v14, v15
    goto/16 +0b0h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->I$0 I
    iget-wide v9, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->J$0 J
    iget-object v11, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$3 Ljava/lang/Object;
    check-cast v11, Lkotlin/jvm/functions/Function1;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v12, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    iget-object v13, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v13, Ljava/io/File;
    iget-object v14, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v14, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    move-exception v0
    move-object v15, v14
    move-object/from16 v22, v11
    move-object v11, v0
    move-object/from16 v0, v22
    goto +45h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v27
    move-wide/from16 v9, v28
    move-object v11, v1
    move-object v14, v2
    move-object v12, v3
    move-object v0, v6
    const/4 v13, 0
    move-object/from16 v1, v25
    move-object/from16 v3, v26
    if-ge v13, v8, +07dh
    iput-object v14, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v1, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v3, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$2 Ljava/lang/Object;
    iput-object v4, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$3 Ljava/lang/Object;
    iput-object v6, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$4 Ljava/lang/Object;
    iput-wide v9, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->J$0 J
    iput v13, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->I$0 I
    iput v8, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->label I
    move-object v15, v14
    move-object/from16 v16, v1
    move-object/from16 v17, v3
    move-object/from16 v18, v4
    move-wide/from16 v19, v9
    move-object/from16 v21, v11
    invoke-direct/range v15 ... v21, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->uploadOnce(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v12, +003h
    return-object v12
    return-object v0
    move-exception v0
    move-object v15, v14
    move-object/from16 v22, v11
    move-object v11, v0
    move-object v0, v4
    move v4, v13
    move-object v13, v1
    move-object/from16 v1, v22
    move-object/from16 v23, v12
    move-object v12, v3
    move-object/from16 v3, v23
    invoke-direct v15, v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->mapThrowable(Ljava/lang/Throwable;)Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    move-result-object v14
    invoke-virtual v14, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;->getCode()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v16
    sget-object v17, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->ordinal()I
    move-result v16
    aget v16, v17, v16
    packed-switch v16, +000004bh
    move/from16 v16, v8
    goto +3h
    const/16 v16, 0
    if-eqz v16, +030h
    if-eqz v4, +02eh
    const-wide/16 v16, 1
    shl-long v16, v16, v4
    const-wide/16 v18, 1000
    mul-long v5, v16, v18
    iput-object v15, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v13, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$2 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$3 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->L$4 Ljava/lang/Object;
    iput-wide v9, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->J$0 J
    iput v4, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->I$0 I
    iput v7, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadWithRetry$1;->label I
    invoke-static v5, v6, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    move-object v5, v3
    move-object v3, v12
    move-object v14, v15
    move-object v12, v0
    move-object v0, v11
    move-object v11, v1
    move-object v1, v13
    add-int/lit8 v13, v4, 1
    move-object v4, v12
    const/4 v6, 0
    move-object v12, v5
    goto -7bh
    throw v14
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "Retry failed"
    new-instance v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    invoke-direct v3, v4, v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    throw v3
    packed-switch-payload 1 2 3 4 5 6 7
    :try_start_0x6f
    :try_start_0x8d
.end method

.method public final close()void
    .registers 8
    # ins_size=1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$close$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$close$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final uploadBatch(java.util.List  int  int  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=6
    new-instance v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;
    const/4 v6, 0
    move-object v0, v7
    move v1, v10
    move-object v2, v9
    move v3, v11
    move-object v4, v8
    move-object v5, v12
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2;-><init>(I Ljava/util/List; I Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    invoke-static v7, v13, Lkotlinx/coroutines/CoroutineScopeKt;->coroutineScope(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method

.method public final uploadImage(java.io.File  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 15
    # ins_size=6
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;
    const/4 v7, 0
    move-object v1, v8
    move-object v2, v10
    move-object v3, v9
    move-object v4, v11
    move-wide v5, v12
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;-><init>(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v8, v14, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    return-object v10
.end method
