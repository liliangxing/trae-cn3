# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/fileupload/UploadResult;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.fileupload.UploadResult)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/fileupload/UploadResult;
    check-cast v2, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$addImages$2$1$3;->$r8$lambda$sZChMJM3TxZ_dWxXfP5POX0Uhik(Lcom/bytedance/trae/conversation/fileupload/UploadResult; Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    move-result-object v2
    return-object v2
.end method
