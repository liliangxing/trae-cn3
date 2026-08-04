# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ImageUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $file:Ljava/io/File;
.field final synthetic $onProgress:Lkotlin/jvm/functions/Function1;
.field final synthetic $storeKey:Ljava/lang/String;
.field final synthetic $token:Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;


.method constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadService  java.io.File  java.lang.String  com.bytedance.trae.conversation.imageupload.StsTokenData  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$file Ljava/io/File;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$storeKey Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$token Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$onProgress Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$file Ljava/io/File;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$storeKey Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$token Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$onProgress Lkotlin/jvm/functions/Function1;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService; Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/StsTokenData; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +30h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->access$getUploader$p(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;)Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;
    move-result-object v3
    iget-object v4, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$file Ljava/io/File;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$storeKey Ljava/lang/String;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$token Lcom/bytedance/trae/conversation/imageupload/StsTokenData;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->this$0 Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;
    invoke-static v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;->access$getSdkConfig$p(Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;)Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getUploaderConfig()Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;
    move-result-object v7
    iget-object v8, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->$onProgress Lkotlin/jvm/functions/Function1;
    move-object v9, v10
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadOnce$tosUri$1;->label I
    invoke-interface/range v3 ... v9, Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;->upload(Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/StsTokenData; Lcom/bytedance/trae/conversation/imageupload/UploaderConfig; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    return-object v11
.end method
