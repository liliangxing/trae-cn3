# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-static v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addAttachment$3;->$r8$lambda$UNkOz8WS4lcQcUnzZLCmhrMrY7A(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v1
    return-object v1
.end method
