# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;
.super Ljava/lang/Object;
.source "HtmlArtifactPreviewActivity.kt"

.implements Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onShareCreated(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, shareUrl
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareUrl$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    return-void 
.end method

.method public onShareStopped()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareUrl$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$setExistingShareId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String;)V
    return-void 
.end method
