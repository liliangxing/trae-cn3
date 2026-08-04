# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/git/BranchItemAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/git/BranchItem;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/git/BranchItemAdapter;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.git.BranchItem  com.bytedance.trae.conversation.git.BranchItemAdapter)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/git/BranchItem;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/git/BranchItem;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/BranchItemAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/git/BranchItemAdapter;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/git/BranchItemAdapter;->$r8$lambda$8GTNd_wjLZcUWGLuEhCmqFcqrl0(Lcom/bytedance/trae/conversation/git/BranchItem; Lcom/bytedance/trae/conversation/git/BranchItemAdapter; Landroid/view/View;)V
    return-void 
.end method
