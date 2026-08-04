# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
.field public final synthetic f$1:Landroid/content/Context;
.field public final synthetic f$2:Landroid/widget/ImageView;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer  android.content.Context  android.widget.ImageView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;->f$1 Landroid/content/Context;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;->f$2 Landroid/widget/ImageView;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;->f$1 Landroid/content/Context;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;->f$2 Landroid/widget/ImageView;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->$r8$lambda$ko11uVHcLK4eQ2BNyV6HKb33Oik(Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer; Landroid/content/Context; Landroid/widget/ImageView; Landroid/view/View;)V
    return-void 
.end method
