# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;
.super Ljava/lang/Object;
.source "AvatarRenderer.kt"

.implements Landroid/view/View$OnAttachStateChangeListener;

.field final synthetic $dismissRunnable:Ljava/lang/Runnable;
.field final synthetic $popView:Landroid/view/View;
.field final synthetic $popupWindow:Landroid/widget/PopupWindow;


.method constructor <init>(android.view.View  java.lang.Runnable  android.widget.PopupWindow)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$popView Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$dismissRunnable Ljava/lang/Runnable;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$popupWindow Landroid/widget/PopupWindow;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onViewAttachedToWindow(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onViewDetachedFromWindow(android.view.View)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$popView Landroid/view/View;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$dismissRunnable Ljava/lang/Runnable;
    invoke-virtual v2, v0, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v2, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v2
    if-eqz v2, +007h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;->$popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v2, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
    :try_start_0xd
.end method
