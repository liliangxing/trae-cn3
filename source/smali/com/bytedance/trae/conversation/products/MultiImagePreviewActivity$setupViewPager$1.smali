# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setupViewPager$1;
.super Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;
.source "MultiImagePreviewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setupViewPager$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v0, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;-><init>()V
    return-void 
.end method

.method public onPageSelected(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setupViewPager$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$setCurrentIndex$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setupViewPager$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$updateIndicator(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    return-void 
.end method
