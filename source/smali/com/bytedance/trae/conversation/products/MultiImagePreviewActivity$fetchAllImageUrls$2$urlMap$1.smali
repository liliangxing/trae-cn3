# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +25h
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getImageUploadApi(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v1
    invoke-static v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getPaths$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/List;
    move-result-object v4
    iput v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2$urlMap$1;->label I
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->getImageUrls(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Ljava/util/Map;
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v4, 0
    check-cast v4, Ljava/util/Map;
    if-nez v4, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v4
    return-object v4
    :try_start_0xb
    :try_start_0x20
.end method
