# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/view/View;
.field public final synthetic f$1:Landroid/widget/PopupWindow;
.field public final synthetic f$2:[I
.field public final synthetic f$3:Landroid/view/View;
.field public final synthetic f$4:Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
.field public final synthetic f$5:F


.method public synthetic constructor <init>(android.view.View  android.widget.PopupWindow  int[]  android.view.View  com.bytedance.trae.conversation.widget.BubbleDrawable  float)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$0 Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$1 Landroid/widget/PopupWindow;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$2 [I
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$3 Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$4 Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    iput v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$5 F
    return-void 
.end method

.method public final run()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$0 Landroid/view/View;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$1 Landroid/widget/PopupWindow;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$2 [I
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$3 Landroid/view/View;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$4 Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    iget v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;->f$5 F
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->$r8$lambda$X2mvjr042Tqamuj1eHBwDkl14rg(Landroid/view/View; Landroid/widget/PopupWindow; [I Landroid/view/View; Lcom/bytedance/trae/conversation/widget/BubbleDrawable; F)V
    return-void 
.end method
