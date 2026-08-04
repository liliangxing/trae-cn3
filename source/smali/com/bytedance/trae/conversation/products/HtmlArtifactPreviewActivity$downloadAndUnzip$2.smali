# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $url:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->$url Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->$url Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 22
    # ins_size=2
    move-object/from16 v1, v20
    const-string v0, "downloadAndUnzip: extracted to "
    const-string v2, "html_artifacts/"
    const-string v3, "downloadAndUnzip: download failed, error="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->label I
    const-string v6, "downloadTarget"
    const-string v7, "conversationId"
    const/4 v8, 1
    const-string v9, "HtmlArtifactPreview"
    if-eqz v5, +016h
    if-ne v5, v8, +00ch
    invoke-static/range v21, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v5, v21
    goto/16 +091h
    move-exception v0
    goto/16 +174h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v21, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getFileDownloadHelper$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-result-object v11
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v5
    invoke-virtual v5, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v12
    const-string v5, "getApplicationContext(...)"
    invoke-static v12, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v13, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->$url Ljava/lang/String;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +007h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v14, 0
    goto +2h
    move-object v14, v5
    iget-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getDownloadTarget$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v5
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v15
    iget-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getCliType$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v5
    const-string v16, "cliType"
    if-nez v5, +006h
    invoke-static/range v16, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    sget-object v17, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual/range v17, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v10
    invoke-static v5, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +01fh
    iget-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getCliType$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +006h
    invoke-static/range v16, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    sget-object v10, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v10
    invoke-static v5, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +5h
    const/4 v5, 0
    move/from16 v16, v5
    goto +3h
    move/from16 v16, v8
    iget-object v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getCreatedTime$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)J
    move-result-wide v17
    move-object/from16 v19, v1
    check-cast v19, Lkotlin/coroutines/Continuation;
    iput v8, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->label I
    invoke-virtual/range v11 ... v19, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCacheWithResult$conversation_mainlandRelease(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v4, +003h
    return-object v4
    check-cast v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult;
    instance-of v4, v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    if-eqz v4, +0a5h
    check-cast v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;->getFile()Ljava/io/File;
    move-result-object v3
    invoke-virtual v3, Ljava/io/File;->exists()Z
    move-result v4
    const/4 v5, 2
    if-eqz v4, +081h
    invoke-virtual v3, Ljava/io/File;->length()J
    move-result-wide v10
    const-wide/16 v12, 0
    cmp-long v4, v10, v12
    if-nez v4, +003h
    goto +75h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getDownloadTarget$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v4
    if-nez v4, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRequestedHtmlName()Ljava/lang/String;
    move-result-object v4
    const/16 v6, 46
    const/4 v8, 0
    invoke-static v4, v6, v8, v5, v8, Lkotlin/text/StringsKt;->substringBeforeLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    new-instance v5, Ljava/io/File;
    iget-object v6, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getFilesDir()Ljava/io/File;
    move-result-object v6
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +007h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    goto +2h
    move-object v10, v2
    invoke-virtual v8, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v7, 47
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, v6, v2, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +005h
    invoke-static v5, Lkotlin/io/FilesKt;->deleteRecursively(Ljava/io/File;)Z
    invoke-virtual v5, Ljava/io/File;->mkdirs()Z
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v2, v3, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$unzipFile(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/io/File; Ljava/io/File;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    invoke-direct v0, v5, v3, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;-><init>(Ljava/io/File; Ljava/io/File;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "downloadAndUnzip: download failed"
    invoke-virtual v0, v9, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;
    new-instance v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    const-string v3, "Downloaded file is invalid"
    const/4 v4, 0
    invoke-direct v2, v3, v4, v5, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;-><init>(Ljava/lang/String; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    return-object v0
    instance-of v0, v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    if-eqz v0, +035h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v3, v5
    check-cast v3, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v9, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;
    new-instance v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    move-object v3, v5
    check-cast v3, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;->getMessage()Ljava/lang/String;
    move-result-object v3
    check-cast v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;->getHttpStatusCode()Ljava/lang/Integer;
    move-result-object v4
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;-><init>(Ljava/lang/String; Ljava/lang/Integer;)V
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    return-object v0
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "downloadAndUnzip failed"
    invoke-virtual v2, v9, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;
    sget-object v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$InvalidArchive;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$InvalidArchive;
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    return-object v0
    :try_start_0x19
    :try_start_0x2e
    :try_start_0x6d
.end method
