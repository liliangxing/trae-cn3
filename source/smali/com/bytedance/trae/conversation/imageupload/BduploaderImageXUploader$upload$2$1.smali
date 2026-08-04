# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;
.super Ljava/lang/Object;
.source "BduploaderImageXUploader.kt"

.implements Lcom/ss/bduploader/BDImageXUploaderListener;

.field final synthetic $cont:Lkotlinx/coroutines/CancellableContinuation;
.field final synthetic $onProgress:Lkotlin/jvm/functions/Function1;


.method constructor <init>(kotlinx.coroutines.CancellableContinuation  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$onProgress Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public imageXUploadCheckNetState(int  int)int
    .registers 3
    # ins_size=3
    const/4 v1, 1
    return v1
.end method

.method public onLog(int  int  java.lang.String)void
    .registers 4
    # ins_size=4
    return-void 
.end method

.method public onNotify(int  long  com.ss.bduploader.BDImageXInfo)void
    .registers 23
    # ins_size=5
    move-object/from16 v0, v18
    move/from16 v1, v19
    move-object/from16 v2, v22
    iget-object v3, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    invoke-interface v3, Lkotlinx/coroutines/CancellableContinuation;->isCompleted()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    if-eqz v2, +005h
    iget-object v3, v2, Lcom/ss/bduploader/BDImageXInfo;->mImageTosKey Ljava/lang/String;
    goto +2h
    const/4 v3, 0
    const-wide/16 v4, 0
    if-eqz v2, +005h
    iget-wide v6, v2, Lcom/ss/bduploader/BDImageXInfo;->mErrorCode J
    goto +2h
    move-wide v6, v4
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getMSG_SINGLE_COMPLETE()I
    move-result v2
    const/4 v8, 1
    const/4 v9, -1
    const/4 v10, 0
    if-ne v2, v9, +021h
    move-object v2, v3
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v10
    goto +2h
    move v2, v8
    if-nez v2, +010h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    check-cast v1, Lkotlin/coroutines/Continuation;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getMSG_SINGLE_FAIL()I
    move-result v2
    const-string v11, "Upload failed, errorCode="
    if-ne v2, v9, +034h
    cmp-long v2, v6, v4
    if-eqz v2, +030h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    check-cast v1, Lkotlin/coroutines/Continuation;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 4
    const/16 v17, 0
    move-object v12, v2
    invoke-direct/range v12 ... v17, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    return-void 
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getMSG_UPDATE_PROGRESS()I
    move-result v2
    if-ne v1, v2, +016h
    move-wide/from16 v4, v20
    long-to-int v1, v4
    const/16 v2, 100
    invoke-static v1, v10, v2, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$onProgress Lkotlin/jvm/functions/Function1;
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto/16 +083h
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getMSG_SINGLE_COMPLETE()I
    move-result v2
    if-ne v1, v2, +040h
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move v8, v10
    if-nez v8, +010h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    check-cast v1, Lkotlin/coroutines/Continuation;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    goto +5dh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    check-cast v1, Lkotlin/coroutines/Continuation;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v4, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string v5, "Upload completed but mImageTosKey is empty"
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v3, v2
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    goto +3ch
    sget-object v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getMSG_SINGLE_FAIL()I
    move-result v2
    if-ne v1, v2, +030h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;->$cont Lkotlinx/coroutines/CancellableContinuation;
    check-cast v1, Lkotlin/coroutines/Continuation;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v13, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 4
    const/16 v17, 0
    move-object v12, v2
    invoke-direct/range v12 ... v17, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    goto +6h
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$Events;->getMSG_ALL_COMPLETE()I
    return-void 
.end method
