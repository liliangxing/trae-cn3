# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VideoArtifactCardView.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $lastFrameUri:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;


.method constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->$lastFrameUri Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->$lastFrameUri Ljava/lang/String;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->label I
    const/4 v2, 1
    if-eqz v1, +014h
    if-ne v1, v2, +00ah
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->L$0 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +31h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->this$0 Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->$lastFrameUri Ljava/lang/String;
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;->access$getResourceUploadApi(Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;)Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v7
    new-instance v3, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/fileupload/BizType;->Image Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    iput-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->L$0 Ljava/lang/Object;
    iput v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1;->label I
    invoke-virtual v7, v3, v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->getResourceUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    move-object v0, v1
    check-cast v7, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;->getUrlMap()Ljava/util/Map;
    move-result-object v7
    invoke-interface v7, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v7, 0
    return-object v7
    :try_start_0xf
    :try_start_0x26
.end method
