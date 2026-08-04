# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ShareLinkBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $loadingContainer:Landroid/view/View;
.field final synthetic $loadingIcon:Landroid/widget/ImageView;
.field final synthetic $result:Lcom/bytedance/trae/network/response/HttpDataResult;
.field final synthetic $successContainer:Landroid/view/View;
.field final synthetic $tvShareUrl:Landroid/widget/TextView;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  com.bytedance.trae.network.response.HttpDataResult  android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$result Lcom/bytedance/trae/network/response/HttpDataResult;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$loadingContainer Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$successContainer Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$loadingIcon Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$tvShareUrl Landroid/widget/TextView;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$result Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$loadingContainer Landroid/view/View;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$successContainer Landroid/view/View;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$loadingIcon Landroid/widget/ImageView;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$tvShareUrl Landroid/widget/TextView;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Lcom/bytedance/trae/network/response/HttpDataResult; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->label I
    if-nez v0, +0b4h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->isAdded()Z
    move-result v5
    if-nez v5, +005h
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$result Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +078h
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ShareLinkData;->getShareSessionId()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-eqz v5, +046h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setShareSessionId$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    sget-object v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->Companion Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;->getShareHost()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$setShareUrl$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getOnShareStateChangedListener()Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v0, v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;->onShareCreated(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$trackShareShowSuccess(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$loadingContainer Landroid/view/View;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$successContainer Landroid/view/View;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$loadingIcon Landroid/widget/ImageView;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->$tvShareUrl Landroid/widget/TextView;
    invoke-static v5, v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$showSuccess(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$copyToClipboard(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    goto +3ch
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$trackShareShow(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->dismiss()V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v5
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_link_generate_failed I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto +20h
    instance-of v5, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v5, +020h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$trackShareShow(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->dismiss()V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v5
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestRemoteShareLink$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_link_generate_failed I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
.end method
