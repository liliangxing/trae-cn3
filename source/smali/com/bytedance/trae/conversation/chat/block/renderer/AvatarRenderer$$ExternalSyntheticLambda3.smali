# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/widget/PopupWindow;


.method public synthetic constructor <init>(android.widget.PopupWindow)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda3;->f$0 Landroid/widget/PopupWindow;
    return-void 
.end method

.method public final run()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda3;->f$0 Landroid/widget/PopupWindow;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->$r8$lambda$I8uDfBzAl6spddmPIu51RbTV0GI(Landroid/widget/PopupWindow;)V
    return-void 
.end method
