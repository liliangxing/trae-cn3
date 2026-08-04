# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.widget.InputAttachmentAdapter  com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;->f$1 Lcom/bytedance/trae/conversation/widget/InputFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputFragment$$ExternalSyntheticLambda3;->f$1 Lcom/bytedance/trae/conversation/widget/InputFragment;
    check-cast v3, Ljava/util/List;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/widget/InputFragment;->$r8$lambda$qekqcDsAc2WF3BpsKLnZYGNPOts(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter; Lcom/bytedance/trae/conversation/widget/InputFragment; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
