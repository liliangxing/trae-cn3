# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
.super Ljava/lang/Object;
.source "BduploaderImageXUploader.kt"

.implements Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;

.field private final activeUploaders:Ljava/util/Set;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/LinkedHashSet;
    invoke-direct v0, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v0, Ljava/util/Set;
    invoke-static v0, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;
    move-result-object v0
    const-string/jumbo v1, synchronizedSet(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->activeUploaders Ljava/util/Set;
    return-void 
.end method

.method public static final synthetic access$upload$closeAndRemove(com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader  com.ss.bduploader.BDImageXUploader)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->upload$closeAndRemove(Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader; Lcom/ss/bduploader/BDImageXUploader;)V
    return-void 
.end method

.method private static final upload$closeAndRemove(com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader  com.ss.bduploader.BDImageXUploader)void
    .registers 4
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v3, Lcom/ss/bduploader/BDImageXUploader;->close()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->activeUploaders Ljava/util/Set;
    invoke-interface v2, v3, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    return-void 
    :try_start_0x0
.end method

.method public close()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->activeUploaders Ljava/util/Set;
    monitor-enter v0
    iget-object v1, v4, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->activeUploaders Ljava/util/Set;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v1
    monitor-exit v0
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +039h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/ss/bduploader/BDImageXUploader;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    invoke-virtual v1, Lcom/ss/bduploader/BDImageXUploader;->stop()V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    invoke-virtual v1, Lcom/ss/bduploader/BDImageXUploader;->close()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto -31h
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto -3ch
    iget-object v0, v4, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->activeUploaders Ljava/util/Set;
    invoke-interface v0, Ljava/util/Set;->clear()V
    return-void 
    move-exception v1
    monitor-exit v0
    throw v1
    :try_start_0x3
    :try_start_0x1e
    :try_start_0x36
.end method

.method public upload(java.io.File  java.lang.String  com.bytedance.trae.conversation.imageupload.StsTokenData  com.bytedance.trae.conversation.imageupload.UploaderConfig  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=7
    instance-of v0, v11, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;
    invoke-direct v0, v5, v11, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;-><init>(Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->label I
    const/4 v3, 1
    if-eqz v2, +01dh
    if-ne v2, v3, +013h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->L$2 Ljava/lang/Object;
    check-cast v6, Lcom/ss/bduploader/BDImageXUploader;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->L$1 Ljava/lang/Object;
    check-cast v7, Lkotlin/jvm/functions/Function1;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0dch
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v11, Lcom/ss/bduploader/BDImageXUploader;
    invoke-direct v11, Lcom/ss/bduploader/BDImageXUploader;-><init>()V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->activeUploaders Ljava/util/Set;
    invoke-interface v2, v11, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    invoke-virtual v9, Lcom/bytedance/trae/conversation/imageupload/UploaderConfig;->getImageHost()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v11, v9, Lcom/ss/bduploader/BDImageXUploader;->setUploadDomain(Ljava/lang/String;)V
    new-array v9, v3, [Ljava/lang/String;
    invoke-virtual v6, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v6
    const/4 v2, 0
    aput-object v6, v9, v2
    invoke-virtual v11, v3, v9, Lcom/ss/bduploader/BDImageXUploader;->setFilePath(I [Ljava/lang/String;)V
    new-array v6, v3, [Ljava/lang/String;
    aput-object v7, v6, v2
    invoke-virtual v11, v3, v6, Lcom/ss/bduploader/BDImageXUploader;->setFileStoreKeys(I [Ljava/lang/String;)V
    const/16 v6, 403
    invoke-virtual v11, v6, v2, Lcom/ss/bduploader/BDImageXUploader;->setNetworkType(I I)V
    const/16 v6, 404
    invoke-virtual v11, v6, v3, Lcom/ss/bduploader/BDImageXUploader;->setNetworkType(I I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getAccessKeyId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v11, v6, Lcom/ss/bduploader/BDImageXUploader;->setTopAccessKey(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getSecretAccessKey()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v11, v6, Lcom/ss/bduploader/BDImageXUploader;->setTopSecretKey(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getSessionToken()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v11, v6, Lcom/ss/bduploader/BDImageXUploader;->setTopSessionToken(Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/imageupload/StsTokenData;->getServiceId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v11, v6, Lcom/ss/bduploader/BDImageXUploader;->setServiceID(Ljava/lang/String;)V
    const-string v6, "image"
    invoke-virtual v11, v6, Lcom/ss/bduploader/BDImageXUploader;->setObjectType(Ljava/lang/String;)V
    const/4 v6, 3
    invoke-virtual v11, v6, Lcom/ss/bduploader/BDImageXUploader;->setMaxConcurrentFileNum(I)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->L$0 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->L$1 Ljava/lang/Object;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$1;->label I
    check-cast v0, Lkotlin/coroutines/Continuation;
    new-instance v6, Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-static v0, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->intercepted(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v7
    invoke-direct v6, v7, v3, Lkotlinx/coroutines/CancellableContinuationImpl;-><init>(Lkotlin/coroutines/Continuation; I)V
    invoke-virtual v6, Lkotlinx/coroutines/CancellableContinuationImpl;->initCancellability()V
    move-object v7, v6
    check-cast v7, Lkotlinx/coroutines/CancellableContinuation;
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;
    invoke-direct v8, v7, v10, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$1;-><init>(Lkotlinx/coroutines/CancellableContinuation; Lkotlin/jvm/functions/Function1;)V
    check-cast v8, Lcom/ss/bduploader/BDImageXUploaderListener;
    invoke-virtual v11, v8, Lcom/ss/bduploader/BDImageXUploader;->setListener(Lcom/ss/bduploader/BDImageXUploaderListener;)V
    new-instance v8, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;
    invoke-direct v8, v5, v11, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader$upload$2$2;-><init>(Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader; Lcom/ss/bduploader/BDImageXUploader;)V
    check-cast v8, Lkotlin/jvm/functions/Function1;
    invoke-interface v7, v8, Lkotlinx/coroutines/CancellableContinuation;->invokeOnCancellation(Lkotlin/jvm/functions/Function1;)V
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v8, v5
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;
    invoke-virtual v11, Lcom/ss/bduploader/BDImageXUploader;->start()V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    goto +ch
    move-exception v8
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v8, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v8
    if-eqz v8, +01dh
    check-cast v7, Lkotlin/coroutines/Continuation;
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    new-instance v9, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
    sget-object v10, Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;->UPLOAD_FAILED Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    const-string/jumbo v2, uploader.start() failed
    invoke-direct v9, v10, v2, v8, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    check-cast v9, Ljava/lang/Throwable;
    invoke-static v9, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v8
    invoke-static v8, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    invoke-interface v7, v8, Lkotlin/coroutines/Continuation;->resumeWith(Ljava/lang/Object;)V
    invoke-virtual v6, Lkotlinx/coroutines/CancellableContinuationImpl;->getResult()Ljava/lang/Object;
    move-result-object v6
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v7
    if-ne v6, v7, +005h
    invoke-static v0, Lkotlin/coroutines/jvm/internal/DebugProbesKt;->probeCoroutineSuspended(Lkotlin/coroutines/Continuation;)V
    if-ne v6, v1, +003h
    return-object v1
    move-object v7, v5
    move-object v4, v11
    move-object v11, v6
    move-object v6, v4
    move-object v8, v11
    check-cast v8, Ljava/lang/String;
    invoke-static v7, v6, Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader;->upload$closeAndRemove(Lcom/bytedance/trae/conversation/imageupload/BduploaderImageXUploader; Lcom/ss/bduploader/BDImageXUploader;)V
    return-object v11
    :try_start_0xc2
.end method
