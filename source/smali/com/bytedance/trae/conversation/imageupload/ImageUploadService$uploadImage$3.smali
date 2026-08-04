# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ImageUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $file:Ljava/io/File;
.field final synthetic $onProgress:Lkotlin/jvm/functions/Function1;
.field final synthetic $timeoutMs:J
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;


.method constructor <init>(java.io.File  com.bytedance.trae.conversation.imageupload.ImageUploadService  kotlin.jvm.functions.Function1  long  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$file Ljava/io/File;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$onProgress Lkotlin/jvm/functions/Function1;
    iput-wide v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$timeoutMs J
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$file Ljava/io/File;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$onProgress Lkotlin/jvm/functions/Function1;
    iget-wide v4, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$timeoutMs J
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;-><init>(Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->label I
    const/4 v2, 1
    if-eqz v1, +011h
    if-ne v1, v2, +007h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09ah
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v13, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ImageValidation;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$file Ljava/io/File;
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/imageupload/ImageValidation;->validateFile(Ljava/io/File;)Lkotlin/Pair;
    move-result-object v13
    invoke-virtual v13, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;
    invoke-virtual v13, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v13
    move-object v5, v13
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getValid()Z
    move-result v13
    if-nez v13, +01eh
    new-instance v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorCode()Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-result-object v0
    if-nez v0, +004h
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UNKNOWN Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    move-object v7, v0
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/FileValidationResult;->getErrorMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "Invalid file"
    move-object v8, v0
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    move-object v6, v13
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    throw v13
    iget-object v13, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->access$getCompressor$p(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;)Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
    move-result-object v13
    if-eqz v13, +027h
    iget-object v13, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->access$getCompressor$p(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;)Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;
    move-result-object v3
    iget-object v4, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$file Ljava/io/File;
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;->compressIfNeeded$default(Lcom/bytedance/trae/conversation/imageupload/ImageCompressor; Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/imageupload/CompressionResult;
    move-result-object v13
    invoke-virtual v13, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->getFile()Ljava/io/File;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->getWidth()I
    move-result v4
    invoke-virtual v13, Lcom/bytedance/trae/conversation/imageupload/CompressionResult;->getHeight()I
    move-result v13
    invoke-direct v3, v4, v13, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;-><init>(I I)V
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v13
    goto +ah
    iget-object v13, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$file Ljava/io/File;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v13, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v13
    invoke-virtual v13, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Ljava/io/File;
    invoke-virtual v13, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v13
    move-object v5, v13
    check-cast v5, Lcom/bytedance/trae/conversation/imageupload/ImageDimension;
    iget-object v3, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v6, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$onProgress Lkotlin/jvm/functions/Function1;
    iget-wide v7, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->$timeoutMs J
    move-object v9, v12
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v2, v12, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadImage$3;->label I
    invoke-static/range v3 ... v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->access$uploadWithRetry(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Lcom/bytedance/trae/conversation/imageupload/ImageDimension; Lkotlin/jvm/functions/Function1; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    return-object v13
.end method
