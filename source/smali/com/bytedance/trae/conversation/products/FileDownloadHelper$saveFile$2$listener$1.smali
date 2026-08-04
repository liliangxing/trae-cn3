# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;
.super Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;
.source "FileDownloadHelper.kt"

.field final synthetic $cacheFile:Ljava/io/File;
.field final synthetic $downloadId:Lkotlin/jvm/internal/Ref$IntRef;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;


.method constructor <init>(com.bytedance.trae.conversation.products.FileDownloadHelper  kotlin.jvm.internal.Ref$IntRef  java.io.File)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->$cacheFile Ljava/io/File;
    invoke-direct v0, Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;-><init>()V
    return-void 
.end method

.method public onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo)void
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;->onCanceled(Lcom/ss/android/socialbase/downloader/model/DownloadInfo;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "Download canceled: "
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->$cacheFile Ljava/io/File;
    invoke-virtual v2, Ljava/io/File;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo  com.ss.android.socialbase.downloader.exception.BaseException)void
    .registers 14
    # ins_size=3
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/String;
    const/4 v1, 0
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/ss/android/socialbase/downloader/exception/BaseException;->getMessage()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    const/4 v3, 0
    aput-object v2, v0, v3
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/ss/android/socialbase/downloader/exception/BaseException;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    const/4 v3, 1
    aput-object v2, v0, v3
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/Iterable;
    const-string v0, "
"
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 62
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "Download failed: error="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ", targetFilePath="
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getTargetFilePath()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v1
    invoke-virtual v4, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v3, v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iget v3, v3, Lkotlin/jvm/internal/Ref$IntRef;->element I
    new-instance v4, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;
    if-eqz v12, +00bh
    invoke-virtual v12, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getHttpStatusCode()I
    move-result v12
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    goto +10h
    instance-of v12, v13, Lcom/ss/android/socialbase/downloader/exception/DownloadHttpException;
    if-eqz v12, +005h
    check-cast v13, Lcom/ss/android/socialbase/downloader/exception/DownloadHttpException;
    goto +2h
    move-object v13, v1
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/ss/android/socialbase/downloader/exception/DownloadHttpException;->getHttpStatusCode()I
    move-result v12
    goto -13h
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/conversation/products/SaveFileResult$Failure;-><init>(Ljava/lang/String; Ljava/lang/Integer;)V
    check-cast v4, Lcom/bytedance/trae/conversation/products/SaveFileResult;
    invoke-static v2, v3, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$resumeDownloadContinuation(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; I Lcom/bytedance/trae/conversation/products/SaveFileResult;)V
    return-void 
.end method

.method public onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo)void
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;->onProgress(Lcom/ss/android/socialbase/downloader/model/DownloadInfo;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Download progress: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v5, +00bh
    invoke-virtual v5, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getDownloadProcess()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo  com.ss.android.socialbase.downloader.exception.BaseException)void
    .registers 7
    # ins_size=3
    invoke-super v4, v5, v6, Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;->onRetry(Lcom/ss/android/socialbase/downloader/model/DownloadInfo; Lcom/ss/android/socialbase/downloader/exception/BaseException;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Download retry: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/4 v3, 0
    if-eqz v5, +00bh
    invoke-virtual v5, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getRetryCount()I
    move-result v5
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    goto +2h
    move-object v5, v3
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", error="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/ss/android/socialbase/downloader/exception/BaseException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v5, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onStart(com.ss.android.socialbase.downloader.model.DownloadInfo)void
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/ss/android/socialbase/downloader/depend/AbsDownloadListener;->onStart(Lcom/ss/android/socialbase/downloader/model/DownloadInfo;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "Download start"
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo)void
    .registers 7
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$getTAG$p(Lcom/bytedance/trae/conversation/products/FileDownloadHelper;)Ljava/lang/String;
    move-result-object v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Download success: targetFilePath="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/4 v3, 0
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getTargetFilePath()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->this$0 Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/FileDownloadHelper$saveFile$2$listener$1;->$downloadId Lkotlin/jvm/internal/Ref$IntRef;
    iget v1, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    new-instance v2, Lcom/bytedance/trae/conversation/products/SaveFileResult$Success;
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/ss/android/socialbase/downloader/model/DownloadInfo;->getTargetFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/SaveFileResult$Success;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/trae/conversation/products/SaveFileResult;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->access$resumeDownloadContinuation(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; I Lcom/bytedance/trae/conversation/products/SaveFileResult;)V
    return-void 
.end method
