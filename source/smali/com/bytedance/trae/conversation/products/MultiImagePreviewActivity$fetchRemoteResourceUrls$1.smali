# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "MultiImagePreviewActivity.kt"

.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iput-object v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->result Ljava/lang/Object;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v3, v0
    iput v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v0, 0
    move-object v1, v2
    check-cast v1, Lkotlin/coroutines/Continuation;
    invoke-static v3, v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$fetchRemoteResourceUrls(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    return-object v3
.end method
