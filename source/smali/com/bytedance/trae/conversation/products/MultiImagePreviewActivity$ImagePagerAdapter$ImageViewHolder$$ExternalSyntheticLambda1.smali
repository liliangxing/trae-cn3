# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnTouchListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    return-void 
.end method

.method public final onTouch(android.view.View  android.view.MotionEvent)boolean
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder;->$r8$lambda$frN_ZzBFh4uRXgadNaCU4nQWwps(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter$ImageViewHolder; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v2
    return v2
.end method
