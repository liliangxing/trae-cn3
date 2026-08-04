# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/InputFragment;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.InputFragment  com.bytedance.trae.conversation.widget.ChatAttachmentDialog)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;
    check-cast v3, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->$r8$lambda$wP5XQEUC3-H7mJdwqC0Aedg1cYI(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog; Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
