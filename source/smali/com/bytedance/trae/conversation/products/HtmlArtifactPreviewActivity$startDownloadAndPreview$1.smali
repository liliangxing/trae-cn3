# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $remoteResolveMode:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
.field final synthetic $startTime:J
.field  J$0:J
.field  J$1:J
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode  long  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$remoteResolveMode Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$startTime J
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$remoteResolveMode Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    iget-wide v3, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$startTime J
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; J Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 25
    # ins_size=2
    move-object/from16 v0, v23
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const-string v5, "fetch_url_duration_ms"
    const-string v6, "fail"
    const/4 v7, 1
    if-eqz v2, +028h
    if-eq v2, v7, +01eh
    if-eq v2, v4, +011h
    if-ne v2, v3, +007h
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +19ah
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-wide v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->J$1 J
    iget-wide v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->J$0 J
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v24
    goto/16 +09eh
    iget-wide v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->J$0 J
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v24
    goto +1ah
    invoke-static/range v24, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v8
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$remoteResolveMode Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    move-object v11, v0
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput-wide v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->J$0 J
    iput v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->label I
    invoke-static v2, v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$fetchFileUrl(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v10
    sub-long v9, v10, v8
    move-object v8, v2
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00ah
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +2h
    const/4 v7, 0
    const-string/jumbo v8, resolve_mode
    if-eqz v7, +02bh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$remoteResolveMode Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    invoke-virtual v2, v5, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->name()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v8, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v3, "fetch_url"
    const-string/jumbo v4, url_unavailable
    invoke-static v1, v6, v3, v4, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$reportApm(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    sget-object v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$UrlUnavailable;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$UrlUnavailable;
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    const-string/jumbo v12, success
    const-string v13, "fetch_url"
    const/4 v14, 0
    new-instance v15, Lorg/json/JSONObject;
    invoke-direct v15, Lorg/json/JSONObject;-><init>()V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$remoteResolveMode Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    invoke-virtual v15, v5, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->name()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v15, v8, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/16 v16, 4
    const/16 v17, 0
    invoke-static/range v11 ... v17, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->reportApm$default(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    move-object v12, v0
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput-wide v9, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->J$0 J
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->J$1 J
    iput v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->label I
    invoke-static v11, v2, v12, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$downloadAndUnzip(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v11
    sub-long/2addr v11, v7
    instance-of v4, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    const-string v7, "download_duration_ms"
    if-eqz v4, +0e1h
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    sget-object v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->getExtractDir()Ljava/io/File;
    move-result-object v8
    iget-object v13, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v13, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getDownloadTarget$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v13
    const-string v14, "downloadTarget"
    const/4 v15, 0
    if-nez v13, +006h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v15
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRequestedHtmlName()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v4, v8, v13, Lcom/bytedance/trae/conversation/products/HtmlArtifactEntryResolver;->findEntryHtml(Ljava/io/File; Ljava/lang/String;)Ljava/io/File;
    move-result-object v4
    if-nez v4, +06fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, startDownloadAndPreview: no html entry found, path=
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getPath$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +008h
    const-string v4, "path"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v15
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", extractDir="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->getExtractDir()Ljava/io/File;
    move-result-object v2
    invoke-virtual v2, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string v3, "HtmlArtifactPreview"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-virtual v2, v7, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$getDownloadTarget$p(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v3
    if-nez v3, +006h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v15, v3
    invoke-virtual v15, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getRequestedHtmlName()Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, requested_html_name
    invoke-virtual v2, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v3, "find_entry"
    const-string v4, "entry_unavailable"
    invoke-static v1, v6, v3, v4, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$reportApm(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    sget-object v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$EntryUnavailable;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$EntryUnavailable;
    check-cast v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v13
    move-object/from16 v24, v4
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->$startTime J
    sub-long/2addr v13, v3
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    const-string/jumbo v17, success
    const-string v18, "complete"
    const/16 v19, 0
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v6, total_duration_ms
    invoke-virtual v4, v6, v13, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v4, v5, v9, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    invoke-virtual v4, v7, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const/16 v21, 4
    const/16 v22, 0
    move-object/from16 v16, v3
    move-object/from16 v20, v4
    invoke-static/range v16 ... v22, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->reportApm$default(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; I Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v3
    check-cast v3, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1$5;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    move-object/from16 v6, v24
    invoke-direct v4, v5, v6, v2, v15, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1$5;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/io/File; Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v5, 3
    iput v5, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->label I
    invoke-static v3, v4, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    instance-of v1, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;
    if-eqz v1, +06ch
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Failure;->getFailure()Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    instance-of v3, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    const-string/jumbo v4, unknown
    if-eqz v3, +01dh
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v8, "download_error_"
    invoke-direct v5, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object v8, v1
    check-cast v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;->getHttpStatusCode()Ljava/lang/Integer;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v4, v8
    invoke-virtual v5, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto +7h
    instance-of v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$InvalidArchive;
    if-eqz v5, +004h
    const-string v4, "invalid_archive"
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, v7, v11, v12, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    if-eqz v3, +023h
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;->getMessage()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +004h
    const-string v7, ""
    const-string v8, "error_message"
    invoke-virtual v5, v8, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure$ArchiveDownload;->getHttpStatusCode()Ljava/lang/Integer;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    goto +2h
    const/4 v3, -1
    const-string v7, "http_status_code"
    invoke-virtual v5, v7, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v3, "download_unzip"
    invoke-static v2, v6, v3, v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$reportApm(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;->this$0 Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->access$showError(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
