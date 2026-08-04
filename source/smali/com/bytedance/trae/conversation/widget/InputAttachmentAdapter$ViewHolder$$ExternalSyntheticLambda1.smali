# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/widget/AttachmentItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  com.bytedance.trae.conversation.widget.AttachmentItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->$r8$lambda$U7UEKrOFaTArvVsiEkAXoysrpVI(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; Lcom/bytedance/trae/conversation/widget/AttachmentItem; Landroid/view/View;)V
    return-void 
.end method
