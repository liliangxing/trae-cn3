# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:I
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;


.method public synthetic constructor <init>(int  com.bytedance.trae.conversation.network.TaskTemplateRepository$TaskTemplateModel  com.bytedance.trae.conversation.widget.TaskTemplateAdapter$ViewHolder)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$0 I
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget v0, v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$0 I
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder$$ExternalSyntheticLambda0;->f$2 Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder;->$r8$lambda$3rH8Z51aOEO3q9bblgm5rXqgb8k(I Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel; Lcom/bytedance/trae/conversation/widget/TaskTemplateAdapter$ViewHolder; Landroid/view/View;)V
    return-void 
.end method
