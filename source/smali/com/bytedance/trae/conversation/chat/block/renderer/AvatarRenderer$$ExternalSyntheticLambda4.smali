# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/PopupWindow$OnDismissListener;

.field public final synthetic f$0:Landroid/view/View;
.field public final synthetic f$1:Ljava/lang/Runnable;
.field public final synthetic f$2:Landroid/view/View;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;
.field public final synthetic f$4:Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
.field public final synthetic f$5:Landroid/widget/PopupWindow;


.method public synthetic constructor <init>(android.view.View  java.lang.Runnable  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$showFastTooltip$attachListener$1  com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer  android.widget.PopupWindow)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$0 Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$1 Ljava/lang/Runnable;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$2 Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$3 Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$4 Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$5 Landroid/widget/PopupWindow;
    return-void 
.end method

.method public final onDismiss()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$0 Landroid/view/View;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$1 Ljava/lang/Runnable;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$2 Landroid/view/View;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$3 Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$4 Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;->f$5 Landroid/widget/PopupWindow;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->$r8$lambda$MQOnvgGoAkL7c1Bb9cFl1tIUStk(Landroid/view/View; Ljava/lang/Runnable; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1; Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer; Landroid/widget/PopupWindow;)V
    return-void 
.end method
