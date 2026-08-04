# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ShareLinkBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $loadingContainer:Landroid/view/View;
.field final synthetic $loadingIcon:Landroid/widget/ImageView;
.field final synthetic $successContainer:Landroid/view/View;
.field final synthetic $tvShareUrl:Landroid/widget/TextView;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  android.view.View  android.view.View  android.widget.ImageView  android.widget.TextView  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingContainer Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$successContainer Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingIcon Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$tvShareUrl Landroid/widget/TextView;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingContainer Landroid/view/View;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$successContainer Landroid/view/View;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingIcon Landroid/widget/ImageView;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$tvShareUrl Landroid/widget/TextView;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +013h
    if-eq v1, v3, +00dh
    if-ne v1, v2, +003h
    goto +9h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +39h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$isLocal$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)Z
    move-result v11
    if-eqz v11, +018h
    iget-object v4, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingContainer Landroid/view/View;
    iget-object v6, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$successContainer Landroid/view/View;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingIcon Landroid/widget/ImageView;
    iget-object v8, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$tvShareUrl Landroid/widget/TextView;
    move-object v9, v10
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v3, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->label I
    invoke-static/range v4 ... v9, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$requestLocalShareLink(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +01ah
    return-object v0
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingContainer Landroid/view/View;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$successContainer Landroid/view/View;
    iget-object v4, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$loadingIcon Landroid/widget/ImageView;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->$tvShareUrl Landroid/widget/TextView;
    move-object v6, v10
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$requestShareLink$1;->label I
    move-object v2, v11
    invoke-static/range v1 ... v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$requestRemoteShareLink(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Landroid/view/View; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/TextView; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
