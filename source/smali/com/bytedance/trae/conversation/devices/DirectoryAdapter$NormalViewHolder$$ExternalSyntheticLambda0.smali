# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/devices/DirectoryNode;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$NormalViewHolder;->$r8$lambda$CJluyy_O-G2LGSvZ3MuPk6y6mKI(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/view/View;)V
    return-void 
.end method
