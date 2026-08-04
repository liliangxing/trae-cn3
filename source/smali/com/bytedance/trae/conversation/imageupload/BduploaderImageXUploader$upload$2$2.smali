# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;
.super Ljava/lang/Object;
.source "BduploaderImageXUploader.kt"

.implements Lkotlin/jvm/functions/Function1;

.field final synthetic $uploader:Lcom/ss/bduploader/BDImageXUploader;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;


.method constructor <init>(com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader  com.ss.bduploader.BDImageXUploader)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;->this$0 Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;->$uploader Lcom/ss/bduploader/BDImageXUploader;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/lang/Throwable;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;->invoke(Ljava/lang/Throwable;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(java.lang.Throwable)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;->$uploader Lcom/ss/bduploader/BDImageXUploader;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/ss/bduploader/BDImageXUploader;->stop()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;->this$0 Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;->$uploader Lcom/ss/bduploader/BDImageXUploader;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->access$upload$closeAndRemove(Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader; Lcom/ss/bduploader/BDImageXUploader;)V
    return-void 
    :try_start_0x2
.end method
