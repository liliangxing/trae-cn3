# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/TextView$OnEditorActionListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/devices/DirectoryNode;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder  com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    return-void 
.end method

.method public final onEditorAction(android.widget.TextView  int  android.view.KeyEvent)boolean
    .registers 10
    # ins_size=4
    iget-object v0, v6, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-object v3, v7
    move v4, v8
    move-object v5, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->$r8$lambda$sNPCWoiVnOQK_u7b3b_MqxYOzDQ(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder; Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/widget/TextView; I Landroid/view/KeyEvent;)Z
    move-result v7
    return v7
.end method
