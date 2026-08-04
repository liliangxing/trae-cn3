# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnFocusChangeListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/devices/DirectoryNode;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder  com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    return-void 
.end method

.method public final onFocusChange(android.view.View  boolean)void
    .registers 6
    # ins_size=3
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-static v0, v1, v2, v4, v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->$r8$lambda$8fW9OfY5XnpNIA7mcT40w2jM3T8(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder; Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/view/View; Z)V
    return-void 
.end method
