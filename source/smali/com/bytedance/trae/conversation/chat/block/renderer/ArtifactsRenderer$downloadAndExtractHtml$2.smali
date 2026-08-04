# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactsRenderer.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $context:Landroid/content/Context;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $extras:Lorg/json/JSONObject;
.field final synthetic $filePath:Ljava/lang/String;
.field final synthetic $url:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  android.content.Context  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$filePath Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$url Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$conversationId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$context Landroid/content/Context;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 11
    # ins_size=3
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$filePath Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$url Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$conversationId Ljava/lang/String;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$context Landroid/content/Context;
    move-object v0, v9
    move-object v7, v10
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/coroutines/Continuation;
    return-object v9
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=2
    move-object/from16 v1, v19
    const-string v0, "getCanonicalPath(...)"
    const-string v2, "html_artifacts/"
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->label I
    const/4 v5, 0
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v4, +016h
    if-ne v4, v6, +00ch
    iget-object v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v6, v20
    goto +66h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v20, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$filePath Ljava/lang/String;
    invoke-virtual v4, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->fromPreviewPath(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v4
    new-instance v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v9
    invoke-virtual v9, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v9
    const-string v10, "getApplicationContext(...)"
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$url Ljava/lang/String;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$conversationId Ljava/lang/String;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v12
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    sget-object v14, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v14
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-nez v13, +013h
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    sget-object v14, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v14
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +003h
    goto +3h
    move v13, v5
    goto +2h
    move v13, v6
    const-wide/16 v14, 0
    move-object/from16 v16, v1
    check-cast v16, Lkotlin/coroutines/Continuation;
    const/16 v17, 32
    const/16 v18, 0
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->L$0 Ljava/lang/Object;
    iput v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->label I
    invoke-static/range v8 ... v18, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->downloadToCacheWithResult$conversation_mainlandRelease$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z J Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v3, +003h
    return-object v3
    move-object v3, v4
    check-cast v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult;
    instance-of v4, v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    if-eqz v4, +145h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v9, "download_html"
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    const-string/jumbo v11, success
    const-string v12, ""
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    invoke-virtual/range v8 ... v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    check-cast v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Success;->getFile()Ljava/io/File;
    move-result-object v4
    invoke-virtual v4, Ljava/io/File;->exists()Z
    move-result v6
    if-eqz v6, +119h
    invoke-virtual v4, Ljava/io/File;->length()J
    move-result-wide v8
    const-wide/16 v10, 0
    cmp-long v6, v8, v10
    if-nez v6, +004h
    goto/16 +10dh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRequestedHtmlName()Ljava/lang/String;
    move-result-object v6
    const/16 v8, 46
    const/4 v9, 2
    invoke-static v6, v8, v7, v9, v7, Lkotlin/text/StringsKt;->substringBeforeLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    new-instance v8, Ljava/io/File;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$context Landroid/content/Context;
    invoke-virtual v10, Landroid/content/Context;->getFilesDir()Ljava/io/File;
    move-result-object v10
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$conversationId Ljava/lang/String;
    invoke-virtual v11, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const/16 v11, 47
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v8, v10, v2, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v8, Ljava/io/File;->exists()Z
    move-result v2
    if-eqz v2, +005h
    invoke-static v8, Lkotlin/io/FilesKt;->deleteRecursively(Ljava/io/File;)Z
    invoke-virtual v8, Ljava/io/File;->mkdirs()Z
    new-instance v2, Ljava/util/zip/ZipInputStream;
    new-instance v6, Ljava/io/FileInputStream;
    invoke-direct v6, v4, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v6, Ljava/io/InputStream;
    invoke-direct v2, v6, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V
    check-cast v2, Ljava/io/Closeable;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    iget-object v15, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    move-object v4, v2
    check-cast v4, Ljava/util/zip/ZipInputStream;
    invoke-virtual v4, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;
    move-result-object v6
    if-eqz v6, +08dh
    new-instance v10, Ljava/io/File;
    invoke-virtual v6, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v8, v11, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v10, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    move-result-object v13
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v11, v13, v5, v9, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +047h
    invoke-virtual v6, Ljava/util/zip/ZipEntry;->isDirectory()Z
    move-result v6
    if-eqz v6, +00ah
    invoke-virtual v10, Ljava/io/File;->mkdirs()Z
    move-result v6
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    goto +27h
    invoke-virtual v10, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v6
    if-eqz v6, +009h
    invoke-virtual v6, Ljava/io/File;->mkdirs()Z
    move-result v6
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    new-instance v6, Ljava/io/FileOutputStream;
    invoke-direct v6, v10, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v6, Ljava/io/Closeable;
    move-object v10, v6
    check-cast v10, Ljava/io/FileOutputStream;
    move-object v11, v4
    check-cast v11, Ljava/io/InputStream;
    check-cast v10, Ljava/io/OutputStream;
    invoke-static v11, v10, v5, v9, v7, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    move-result-wide v10
    invoke-static v10, v11, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    invoke-static v6, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-virtual v4, Ljava/util/zip/ZipInputStream;->closeEntry()V
    invoke-virtual v4, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;
    move-result-object v6
    goto -5ah
    move-exception v0
    move-object v3, v0
    throw v3
    move-exception v0
    move-object v4, v0
    invoke-static v6, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    sget-object v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string/jumbo v11, unzip_html
    const-string v13, "failed"
    const-string v14, "outside_of_dir"
    invoke-virtual/range v10 ... v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v0, Ljava/lang/SecurityException;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    const-string v4, "Zip entry is outside of the target dir: "
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v6, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V
    throw v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v2, v7, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    sget-object v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string/jumbo v10, unzip_html
    iget-object v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    const-string/jumbo v12, success
    const-string v13, ""
    iget-object v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRequestedHtmlName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v8, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;->findEntryHtml(Ljava/io/File; Ljava/lang/String;)Ljava/io/File;
    move-result-object v7
    goto +53h
    move-exception v0
    move-object v3, v0
    throw v3
    move-exception v0
    move-object v4, v0
    invoke-static v2, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v9, "download_html"
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    const-string v11, "failed"
    const-string v12, "cache_file_error"
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    invoke-virtual/range v8 ... v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    return-object v7
    instance-of v0, v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    if-eqz v0, +016h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v9, "download_html"
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    const-string v11, "failed"
    check-cast v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/DownloadCacheResult$Failure;->getMessage()Ljava/lang/String;
    move-result-object v12
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    invoke-virtual/range v8 ... v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    return-object v7
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v9, "download_html"
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$cliType Ljava/lang/String;
    const-string v11, "failed"
    invoke-virtual v0, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v12
    iget-object v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;->$extras Lorg/json/JSONObject;
    invoke-virtual/range v8 ... v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "AgentBlock"
    const-string v4, "downloadAndExtractHtml failed"
    invoke-virtual v2, v3, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-object v7
    :try_start_0x17
    :try_start_0x28
    :try_start_0xfd
    :try_start_0x145
    :try_start_0x154
    :try_start_0x161
    :try_start_0x164
    :try_start_0x193
    :try_start_0x1b4
    :try_start_0x1b7
.end method
