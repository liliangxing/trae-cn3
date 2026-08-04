# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ImageUploadService.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $sdkConfig:Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
.field synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadSdkConfig  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->$sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->$sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->invoke(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +22h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->$sdkConfig Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;->getApi()Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;
    move-result-object v1
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$1;->label I
    invoke-interface v1, v5, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadApi;->getStsToken(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    return-object v5
.end method
