# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "InputPreviewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/InputPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.InputPreviewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-direct v0, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V
    return-void 
.end method

.method public onDoubleTap(android.view.MotionEvent)boolean
    .registers 3
    # ins_size=2
    const-string v0, "e"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$getCurrentScale$p(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)F
    move-result v2
    const/high16 v0, 1065353216
    cmpl-float v2, v2, v0
    if-lez v2, +008h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$animateToScale(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; F)V
    goto +8h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;->this$0 Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    const/high16 v0, 1075838976
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->access$animateToScale(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; F)V
    const/4 v2, 1
    return v2
.end method
