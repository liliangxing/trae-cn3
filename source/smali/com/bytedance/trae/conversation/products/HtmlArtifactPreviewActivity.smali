# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "HtmlArtifactPreviewActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;
.field private static final DOWNLOAD_URL_MAX_RETRIES:I
.field private static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field private static final EVENT_HTML_ARTIFACT_PREVIEW:Ljava/lang/String;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_CREATED_TIME:Ljava/lang/String;
.field private static final EXTRA_MESSAGE_ID:Ljava/lang/String;
.field private static final EXTRA_PATH:Ljava/lang/String;
.field private static final EXTRA_REAL_PATH:Ljava/lang/String;
.field private static final EXTRA_TURN_ID:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private archiveCacheFile:Ljava/io/File;
.field private btnMainDownload:Landroid/widget/TextView;
.field private chatSessionId:Ljava/lang/String;
.field private cliId:Ljava/lang/String;
.field private cliType:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private createdTime:J
.field private final downloadFinishCallback:Lkotlin/jvm/functions/Function3;
.field private downloadStatusTitle:Landroid/widget/TextView;
.field private downloadTarget:Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
.field private existingShareId:Ljava/lang/String;
.field private existingShareUrl:Ljava/lang/String;
.field private final fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field private layoutContent:Landroid/widget/LinearLayout;
.field private loadingIcon:Landroid/widget/ImageView;
.field private messageId:Ljava/lang/String;
.field private path:Ljava/lang/String;
.field private progressBar:Landroid/view/View;
.field private realPath:Ljava/lang/String;
.field private final remoteArchiveUrlResolver:Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
.field private shareItems:Ljava/util/List;
.field private titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$2QtxCcQG6cw-EwTxI3Qnt6TPQik(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadFinishCallback$lambda$0(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$AHh_x2fachUrdNFt6BUlYw-rFlg(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createDownloadItem$lambda$9(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$EejxhYqkfuziEz2X87tkqKlYzQU(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setupDownloadButton$lambda$21(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$SSKCgJEqXNdU74fo-GIxcFltm3A(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->onCreate$lambda$5(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$WrsbsYOp3ggi0OmW_AkWryM7Rvw(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->showError$lambda$17(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$aYW1t2LzbFiGYOafhwEd0wAcg7E(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createShareItem$lambda$7(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$v66VM8xNlvOCz00bGH55RuLChII(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setupDownloadButton$lambda$18(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 10
    # ins_size=1
    invoke-direct v9, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-string v0, ""
    iput-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliId Ljava/lang/String;
    iput-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda2;
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    iput-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    new-instance v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iput-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    const/4 v6, 0
    const/16 v7, 15
    const/4 v8, 0
    move-object v1, v0
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSessionClient; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteSandboxStatusSource; J Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->remoteArchiveUrlResolver Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    return-void 
.end method

.method public static final synthetic access$downloadAndUnzip(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadAndUnzip(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchDownloadUrlWithRetry(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->fetchDownloadUrlWithRetry(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchFileUrl(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->fetchFileUrl(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getChatSessionId$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCliType$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCreatedTime$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createdTime J
    return-wide v0
.end method

.method public static final synthetic access$getDownloadTarget$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadTarget Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    return-object v0
.end method

.method public static final synthetic access$getFileDownloadHelper$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)com.bytedance.trae.conversation.products.FileDownloadHelper
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-object v0
.end method

.method public static final synthetic access$getPath$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getRealPath$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getRemoteArchiveUrlResolver$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->remoteArchiveUrlResolver Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    return-object v0
.end method

.method public static final synthetic access$reportApm(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final synthetic access$setExistingShareId$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->existingShareId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setExistingShareUrl$p(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->existingShareUrl Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$showError(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->showError(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    return-void 
.end method

.method public static final synthetic access$showWebView(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.io.File  java.io.File)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->showWebView(Ljava/io/File; Ljava/io/File;)V
    return-void 
.end method

.method public static final synthetic access$unzipFile(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.io.File  java.io.File)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->unzipFile(Ljava/io/File; Ljava/io/File;)V
    return-void 
.end method

.method private final buildBaseExtraLog()org.json.JSONObject
    .registers 5
    # ins_size=1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +008h
    const-string v1, "chatSessionId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const-string v3, "chat_session_id"
    invoke-virtual v0, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "conversationId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const-string v3, "conversation_id"
    invoke-virtual v0, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "messageId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const-string v3, "message_id"
    invoke-virtual v0, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "cliType"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    const-string v3, "cli_type"
    invoke-virtual v0, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    const-string v3, "path"
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    invoke-virtual v0, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-object v0
.end method

.method public static com_bytedance_trae_conversation_products_HtmlArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->com_bytedance_trae_conversation_products_HtmlArtifactPreviewActivity__onStop$___twin___()V
    invoke-static Lcom/bytedance/sysoptimizer/EnterTransitionCrashOptimizer;->getContext()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, +013h
    check-cast v1, Landroid/app/Activity;
    invoke-virtual v1, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v1
    invoke-virtual v1, Landroid/view/Window;->getDecorView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewTreeObserver;->dispatchOnPreDraw()Z
    return-void 
    :try_start_0xb
.end method

.method private final createDownloadItem()com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item
    .registers 12
    # ins_size=1
    new-instance v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_download I
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_export_as_zip I
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v2, "getString(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda6;
    invoke-direct v7, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    const/16 v8, 60
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
.end method

.method private static final createDownloadItem$lambda$9(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)kotlin.Unit
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->archiveCacheFile Ljava/io/File;
    if-eqz v0, +01eh
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-virtual v0, Ljava/io/File;->length()J
    move-result-wide v1
    const-wide/16 v3, 0
    cmp-long v1, v1, v3
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->saveZipToDevice(Ljava/io/File;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method private final createShareItem()com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item
    .registers 12
    # ins_size=1
    new-instance v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_chain_link I
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_temporary_link I
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v2, "getString(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda5;
    invoke-direct v7, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    const/16 v8, 60
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(I Ljava/lang/CharSequence; Z Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v10
.end method

.method private static final createShareItem$lambda$7(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createShareLink()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final createShareLink()void
    .registers 12
    # ins_size=1
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "cliType"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    sget-object v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->Companion Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v0, +009h
    const-string v0, "chatSessionId"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    goto +2h
    move-object v4, v0
    const-string v0, "downloadTarget"
    if-eqz v7, +029h
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    if-eqz v5, +016h
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadTarget Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    if-nez v2, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v0
    const-string v2, "package/"
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v0, v2, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    move-object v5, v2
    goto +1ah
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->remoteArchiveUrlResolver Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iget-object v5, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadTarget Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    if-nez v5, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v0
    iget-object v5, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->remoteArchiveUrlResolver Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->getWorkSpace()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v5, v0
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v0, +009h
    const-string v0, "conversationId"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    goto +2h
    move-object v6, v0
    iget-object v8, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->existingShareUrl Ljava/lang/String;
    iget-object v9, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->existingShareId Ljava/lang/String;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v0, +009h
    const-string v0, "messageId"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v1
    goto +2h
    move-object v10, v0
    invoke-virtual/range v3 ... v10, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$Companion;->newInstance(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$createShareLink$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    check-cast v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->setOnShareStateChangedListener(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$OnShareStateChangedListener;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v2, "ShareLinkBottomSheet"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private final downloadAndUnzip(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;
    const/4 v2, 0
    invoke-direct v1, v3, v4, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$downloadAndUnzip$2;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method private static final downloadFinishCallback$lambda$0(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    const-string/jumbo v3, savedPath
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v1, +032h
    const/4 v1, 1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->trackDownloadZip(Z)V
    const/16 v1, 47
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v2, v1, v4, v3, v4, Lkotlin/text/StringsKt;->substringBeforeLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    move-object v2, v0
    check-cast v2, Landroid/content/Context;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_success I
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v3, 10
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto +11h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->trackDownloadZip(Z)V
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final fetchDownloadUrlWithRetry(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=3
    move-object/from16 v0, v21
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    move-object/from16 v2, v19
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
    move-object/from16 v2, v19
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v4, +032h
    if-eq v4, v6, +022h
    if-ne v4, v5, +018h
    iget v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iget-object v8, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v0, v8
    move-object v8, v9
    move-object/from16 v18, v3
    move-object v3, v1
    move-object/from16 v1, v18
    goto/16 +0d5h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iget-object v8, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +55h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v0, 0
    move-object v8, v2
    move-object v4, v3
    move-object v3, v1
    move v1, v0
    move-object/from16 v0, v20
    const/16 v9, 21
    if-ge v1, v9, +103h
    sget-object v9, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v15, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    iget-object v10, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v10, +009h
    const-string v10, "conversationId"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v12, 0
    goto +2h
    move-object v12, v10
    iget-object v10, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v10, +009h
    const-string v10, "messageId"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v13, 0
    goto +2h
    move-object v13, v10
    const/4 v14, 0
    const/16 v16, 8
    const/16 v17, 0
    move-object v10, v15
    move-object v7, v15
    move/from16 v15, v16
    move-object/from16 v16, v17
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v8, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput v1, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iput v6, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    invoke-virtual v9, v7, v3, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v4, +003h
    return-object v4
    move-object v9, v8
    move-object v8, v0
    move-object v0, v7
    move-object/from16 v18, v4
    move v4, v1
    move-object v1, v3
    move-object/from16 v3, v18
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v7, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v10, "attempt"
    const-string v11, "fetch_download_url"
    const-string v12, "fail"
    if-eqz v7, +07eh
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v7, +00fh
    invoke-virtual v7, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v7
    if-eqz v7, +009h
    invoke-interface v7, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    goto +2h
    const/4 v7, 0
    if-eqz v7, +01eh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v0
    if-eqz v0, +00ah
    invoke-interface v0, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Ljava/lang/String;
    goto +2h
    const/4 v7, 0
    return-object v7
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    const-wide/16 v15, 202
    cmp-long v0, v13, v15
    if-nez v0, +01fh
    const/16 v0, 20
    if-ge v4, v0, +01bh
    iput-object v9, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iput v5, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    const-wide/16 v10, 2000
    invoke-static v10, v11, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, -0d9h
    return-object v3
    add-int/2addr v4, v6
    move/from16 v18, v4
    move-object v4, v1
    move/from16 v1, v18
    goto/16 -0b9h
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v0, v10, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string v1, "biz_code"
    invoke-virtual v0, v1, v13, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v1, retry_exhausted
    invoke-direct v9, v12, v11, v1, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    const/4 v0, 0
    return-object v0
    instance-of v1, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +02bh
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v10, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-static v3, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v3
    const-string v4, "error_code"
    invoke-virtual v1, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "error_message"
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v3, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string/jumbo v0, request_error
    invoke-direct v9, v12, v11, v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto -2eh
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const/4 v0, 0
    return-object v0
.end method

.method private final fetchFileUrl(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadTarget Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "downloadTarget"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getLocalRequestPath()Ljava/lang/String;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "fetchFileUrl: chatSessionId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    const-string v5, "chatSessionId"
    if-nez v4, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", cliType="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    const-string v6, "cliType"
    if-nez v4, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", path="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v4, "HtmlArtifactPreview"
    invoke-virtual v2, v4, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v2, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +012h
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->remoteArchiveUrlResolver Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v2, v1, v0, v8, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveUrlResolver;->resolve(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
    invoke-direct v7, v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->fetchDownloadUrlWithRetry(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method

.method private final isHtmlShareSupported(java.lang.String  java.lang.String)boolean
    .registers 5
    # ins_size=3
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-eqz v0, +003h
    return v1
    sget-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->isGreaterOrEqual(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v3
    return v3
.end method

.method private final isShareEnable(com.bytedance.trae.conversation.products.HtmlShareSettingsItem)boolean
    .registers 4
    # ins_size=2
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v1
    sget-object v0, Lcom/bytedance/trae/login/api/AccountType;->BYTEDANCE Lcom/bytedance/trae/login/api/AccountType;
    if-ne v1, v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;->getBytedanceEnable()Z
    move-result v3
    goto +9h
    sget-object v3, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE Lcom/bytedance/trae/settings/api/feature/FeatureCapability;
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/Feature;->HTML_SHARE Lcom/bytedance/trae/settings/api/feature/Feature;
    invoke-virtual v3, v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z
    move-result v3
    return v3
.end method

.method private final nextResolveModeAfter(com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure)com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v0, +008h
    const-string v0, "cliType"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewRetryPolicy;->nextRemoteResolveMode(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    move-result-object v3
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->ENSURE_SANDBOX_READY Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    return-object v3
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->finish()V
    return-void 
.end method

.method private final queryExistingShareLink()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "cliType"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    move-object v2, v9
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;
    invoke-direct v2, v0, v9, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$queryExistingShareLink$1;-><init>(Z Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final reportApm(java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject)void
    .registers 9
    # ins_size=5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v1, "html_artifact_preview"
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, status
    invoke-virtual v2, v3, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, step
    invoke-virtual v2, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    const-string v6, "cliType"
    if-nez v5, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v5, 0
    invoke-virtual v2, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    if-eqz v7, +007h
    const-string v5, "reason"
    invoke-virtual v2, v5, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->buildBaseExtraLog()Lorg/json/JSONObject;
    move-result-object v5
    invoke-virtual v0, v1, v2, v8, v5, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v5
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
    :try_start_0x20
.end method

.method static synthetic reportApm$default(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method private final saveZipToDevice(java.io.File)void
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-object v1, v10
    check-cast v1, Landroid/content/Context;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    const/4 v3, 0
    if-nez v2, +009h
    const-string v2, "chatSessionId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v3
    goto +2h
    move-object v4, v2
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadTarget Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    if-nez v2, +008h
    const-string v2, "downloadTarget"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->getSavePath()Ljava/lang/String;
    move-result-object v5
    move-object v2, v10
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    iget-wide v8, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createdTime J
    move-object v2, v11
    move-object v3, v4
    move-object v4, v5
    move-object v5, v6
    move-object v6, v7
    move-wide v7, v8
    invoke-virtual/range v0 ... v8, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->copyCachedFileAndLoading(Landroid/content/Context; Ljava/io/File; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; J)V
    return-void 
.end method

.method private final setDownloadEnabled(boolean)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v0, +009h
    const-string/jumbo v0, titleBar
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v1, 0
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionEnabled(I Z)V
    return-void 
.end method

.method private final setupDownloadButton()void
    .registers 6
    # ins_size=1
    const/4 v0, 0
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setDownloadEnabled(Z)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->shareItems Ljava/util/List;
    if-eqz v1, +00dh
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    if-ne v1, v2, +003h
    goto +2h
    move v2, v0
    const/4 v1, 0
    const-string/jumbo v3, titleBar
    if-eqz v2, +021h
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_title_bar_share I
    invoke-virtual v2, v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionResource(I I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    goto +1fh
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v1
    sget v4, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_download I
    invoke-virtual v2, v0, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionResource(I I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda1;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupDownloadButton$lambda$18(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->showExportMenu()V
    return-void 
.end method

.method private static final setupDownloadButton$lambda$21(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  android.view.View)void
    .registers 6
    # ins_size=2
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->archiveCacheFile Ljava/io/File;
    if-eqz v5, +01eh
    invoke-virtual v5, Ljava/io/File;->exists()Z
    move-result v0
    if-eqz v0, +00eh
    invoke-virtual v5, Ljava/io/File;->length()J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v0, v0, v2
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    goto +2h
    const/4 v5, 0
    if-eqz v5, +005h
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->saveZipToDevice(Ljava/io/File;)V
    return-void 
.end method

.method private final showError(com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure)void
    .registers 6
    # ins_size=2
    const/4 v0, 0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->archiveCacheFile Ljava/io/File;
    const/4 v1, 0
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setDownloadEnabled(Z)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->progressBar Landroid/view/View;
    if-nez v2, +008h
    const-string v2, "progressBar"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    const/16 v3, 8
    invoke-virtual v2, v3, Landroid/view/View;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->stopLoadingAnimation()V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v2, +009h
    const-string/jumbo v2, webView
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    invoke-virtual v2, v3, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v2, +008h
    const-string v2, "layoutContent"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    if-nez v1, +008h
    const-string v1, "downloadStatusTitle"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_unable_to_open I
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(I)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    const-string v2, "btnMainDownload"
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_reload I
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(I)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    new-instance v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda4;
    invoke-direct v1, v4, v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final showError$lambda$17(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  com.bytedance.trae.conversation.products.HtmlArtifactPreviewFailure  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v3, +008h
    const-string v3, "layoutContent"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v3, 0
    const/16 v0, 8
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->nextResolveModeAfter(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewFailure;)Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->startDownloadAndPreview(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;)V
    return-void 
.end method

.method private final showExportMenu()void
    .registers 9
    # ins_size=1
    iget-object v2, v8, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->shareItems Ljava/util/List;
    if-nez v2, +003h
    return-void 
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    if-nez v6, +003h
    return-void 
    new-instance v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
    move-object v1, v8
    check-cast v1, Landroid/content/Context;
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;-><init>(Landroid/content/Context; Ljava/util/List; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v6, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_page_height I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    const/16 v1, 10
    int-to-float v1, v1
    invoke-virtual v6, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v1, v2
    float-to-int v1, v1
    add-int/2addr v0, v1
    invoke-virtual v7, v6, v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->showBelow(Landroid/view/View; I)V
    return-void 
.end method

.method private final showLoading()void
    .registers 5
    # ins_size=1
    const/4 v0, 0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->archiveCacheFile Ljava/io/File;
    const/4 v1, 0
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setDownloadEnabled(Z)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v2, +009h
    const-string/jumbo v2, webView
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    const/16 v3, 8
    invoke-virtual v2, v3, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v2, +008h
    const-string v2, "layoutContent"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->progressBar Landroid/view/View;
    if-nez v2, +008h
    const-string v2, "progressBar"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->startLoadingAnimation()V
    return-void 
.end method

.method private final showWebView(java.io.File  java.io.File)void
    .registers 7
    # ins_size=3
    iput-object v6, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->archiveCacheFile Ljava/io/File;
    const/4 v6, 1
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setDownloadEnabled(Z)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->progressBar Landroid/view/View;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->stopLoadingAnimation()V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    const-string/jumbo v2, webView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    invoke-virtual v0, v6, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v0, v6, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v0, v6, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V
    invoke-virtual v0, v6, Landroid/webkit/WebSettings;->setAllowContentAccess(Z)V
    const-string v6, "UTF-8"
    invoke-virtual v0, v6, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    iget-object v6, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    new-instance v0, Landroid/webkit/WebChromeClient;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    invoke-virtual v6, v0, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v6, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v1
    new-instance v0, Landroid/webkit/WebViewClient;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    invoke-virtual v6, v0, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    iget-object v6, v4, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v6
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v0, "file://"
    invoke-direct v6, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v5, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private final startDownloadAndPreview(com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode)void
    .registers 13
    # ins_size=2
    invoke-direct v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->showLoading()V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v3
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v6, v0
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;
    const/4 v5, 0
    move-object v0, v9
    move-object v1, v11
    move-object v2, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$startDownloadAndPreview$1;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; J Lkotlin/coroutines/Continuation;)V
    move-object v12, v9
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    move-object v5, v6
    move-object v6, v7
    move-object v7, v8
    move-object v8, v12
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method static synthetic startDownloadAndPreview$default(com.bytedance.trae.conversation.products.HtmlArtifactPreviewActivity  com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    sget-object v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;->ENSURE_SANDBOX_READY Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->startDownloadAndPreview(Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode;)V
    return-void 
.end method

.method private final startLoadingAnimation()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->loadingIcon Landroid/widget/ImageView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "loadingIcon"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v2, v0, Landroid/graphics/drawable/Animatable;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/graphics/drawable/Animatable;
    if-eqz v1, +005h
    invoke-interface v1, Landroid/graphics/drawable/Animatable;->start()V
    return-void 
.end method

.method private final stopLoadingAnimation()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->loadingIcon Landroid/widget/ImageView;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "loadingIcon"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v2, v0, Landroid/graphics/drawable/Animatable;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/graphics/drawable/Animatable;
    if-eqz v1, +005h
    invoke-interface v1, Landroid/graphics/drawable/Animatable;->stop()V
    return-void 
.end method

.method private final trackDownloadZip(boolean)void
    .registers 8
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, status
    if-eqz v7, +009h
    const-string/jumbo v7, success
    invoke-virtual v0, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +6h
    const-string v7, "fail"
    invoke-virtual v0, v1, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "artifact_type"
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +008h
    const-string v1, "cliType"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v0, v7, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v7, "export_format"
    const-string/jumbo v1, zip
    invoke-virtual v0, v7, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v7
    const/16 v1, 95
    const-string v3, "messageId"
    const-string v4, "artifact_id"
    if-nez v7, +026h
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    iget-object v5, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +2ch
    new-instance v7, Ljava/lang/StringBuilder;
    invoke-direct v7, Ljava/lang/StringBuilder;-><init>()V
    iget-object v5, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v5, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v7
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "path"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v4, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "icube_artifact_html_export_click"
    invoke-virtual v7, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
    :try_start_0x0
    :try_start_0xa
    :try_start_0x3e
.end method

.method private final unzipFile(java.io.File  java.io.File)void
    .registers 12
    # ins_size=3
    const-string v0, "getCanonicalPath(...)"
    new-instance v1, Ljava/util/zip/ZipInputStream;
    new-instance v2, Ljava/io/FileInputStream;
    invoke-direct v2, v10, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v2, Ljava/io/InputStream;
    invoke-direct v1, v2, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V
    check-cast v1, Ljava/io/Closeable;
    move-object v10, v1
    check-cast v10, Ljava/util/zip/ZipInputStream;
    invoke-virtual v10, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +079h
    new-instance v4, Ljava/io/File;
    invoke-virtual v2, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-direct v4, v11, v5, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v4, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v7, 2
    const/4 v8, 0
    invoke-static v5, v6, v8, v7, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +03dh
    invoke-virtual v2, Ljava/util/zip/ZipEntry;->isDirectory()Z
    move-result v2
    if-eqz v2, +006h
    invoke-virtual v4, Ljava/io/File;->mkdirs()Z
    goto +23h
    invoke-virtual v4, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v2
    if-eqz v2, +005h
    invoke-virtual v2, Ljava/io/File;->mkdirs()Z
    new-instance v2, Ljava/io/FileOutputStream;
    invoke-direct v2, v4, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v2, Ljava/io/Closeable;
    move-object v4, v2
    check-cast v4, Ljava/io/FileOutputStream;
    move-object v5, v10
    check-cast v5, Ljava/io/InputStream;
    check-cast v4, Ljava/io/OutputStream;
    invoke-static v5, v4, v8, v7, v3, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    invoke-static v2, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-virtual v10, Ljava/util/zip/ZipInputStream;->closeEntry()V
    invoke-virtual v10, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;
    move-result-object v2
    goto -55h
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v2, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    new-instance v10, Ljava/lang/SecurityException;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, Ljava/lang/StringBuilder;-><init>()V
    const-string v0, "Zip entry is outside of the target dir: "
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v2, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V
    throw v10
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v1, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-void 
    move-exception v10
    throw v10
    move-exception v11
    invoke-static v1, v10, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v11
    :try_start_0x10
    :try_start_0x53
    :try_start_0x62
    :try_start_0x6e
    :try_start_0x70
    :try_start_0x98
.end method

.method public com_bytedance_trae_conversation_products_HtmlArtifactPreviewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 12
    # ins_size=2
    invoke-super v10, v11, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v11, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_html_artifact_preview I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setContentView(I)V
    sget v11, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    const-string v0, "findViewById(...)"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->progressBar Landroid/view/View;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->iv_loading I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/ImageView;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->loadingIcon Landroid/widget/ImageView;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/webkit/WebView;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->layout_content I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/LinearLayout;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->btn_main_download I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/TextView;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    sget v11, Lcom/bytedance/trae/conversation/R$id;->download_status_tile I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v11
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Landroid/widget/TextView;
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v0, "extra_chat_session_id"
    invoke-virtual v11, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    const-string v0, ""
    if-nez v11, +003h
    move-object v11, v0
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_cli_type"
    invoke-virtual v11, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    move-object v11, v0
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_path"
    invoke-virtual v11, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    move-object v11, v0
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_message_id"
    invoke-virtual v11, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    move-object v11, v0
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_conversation_id"
    invoke-virtual v11, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    move-object v11, v0
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_created_time"
    const-wide/16 v2, 0
    invoke-virtual v11, v1, v2, v3, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v1
    iput-wide v1, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createdTime J
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_cli_id"
    invoke-virtual v11, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    move-object v11, v0
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliId Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v11
    const-string v1, "extra_real_path"
    invoke-virtual v11, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    goto +2h
    move-object v0, v11
    iput-object v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    sget-object v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    const-string v1, "path"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v11, v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget$Companion;->fromPreviewPath(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->downloadTarget Lcom/bytedance/trae/conversation/products/HtmlArtifactDownloadTarget;
    sget-object v11, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;->INSTANCE Lcom/bytedance/trae/conversation/products/HtmlShareSettings;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/HtmlShareSettings;->getHtmlShareSettingsItem()Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;
    move-result-object v11
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->isShareEnable(Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;)Z
    move-result v0
    const-string v3, "cliType"
    const/4 v4, 2
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v0, +081h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +058h
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v8
    iget-object v9, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliId Ljava/lang/String;
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, -017h
    goto +2h
    move-object v7, v2
    check-cast v7, Lcom/bytedance/trae/im/service/Cli;
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/HtmlShareSettingsItem;->getMinSupportedIdeVersion()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v0, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->isHtmlShareSupported(Ljava/lang/String; Ljava/lang/String;)Z
    move-result v11
    if-eqz v11, +015h
    new-array v11, v4, [Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    invoke-direct v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createShareItem()Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    move-result-object v0
    aput-object v0, v11, v6
    invoke-direct v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createDownloadItem()Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    move-result-object v0
    aput-object v0, v11, v5
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    goto +2h
    move-object v11, v2
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->shareItems Ljava/util/List;
    goto +18h
    new-array v11, v4, [Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    invoke-direct v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createShareItem()Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    move-result-object v0
    aput-object v0, v11, v6
    invoke-direct v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->createDownloadItem()Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    move-result-object v0
    aput-object v0, v11, v5
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->shareItems Ljava/util/List;
    goto +3h
    iput-object v2, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->shareItems Ljava/util/List;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->shareItems Ljava/util/List;
    if-eqz v11, +007h
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v11
    goto +2h
    move v11, v6
    if-le v11, v5, +005h
    invoke-direct v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->queryExistingShareLink()V
    sget-object v11, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v7, "onCreate: "
    invoke-direct v0, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v7, +008h
    const-string v7, "chatSessionId"
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v2
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v7, 32
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v8, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v8, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v2
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v3, +008h
    const-string v3, "messageId"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v3, +008h
    const-string v3, "conversationId"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v2
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v3, "HtmlArtifactPreview"
    invoke-virtual v11, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->realPath Ljava/lang/String;
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    move v0, v5
    goto +2h
    move v0, v6
    if-eqz v0, +00ah
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v11, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v2
    check-cast v11, Ljava/lang/String;
    const/16 v0, 47
    invoke-static v11, v0, v2, v4, v2, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const-string/jumbo v1, titleBar
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +004h
    move v3, v5
    goto +2h
    move v3, v6
    if-eqz v3, +00dh
    sget v11, Lcom/bytedance/trae/conversation/R$string;->trae_html_artifact_title_file_management I
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v11
    const-string v3, "getString(...)"
    invoke-static v11, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v0, v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v11, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v2
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-virtual v11, v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightActionViewId(I I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-nez v11, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v2
    new-instance v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda3;
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    invoke-virtual v11, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->setupDownloadButton()V
    invoke-static v10, v2, v5, v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->startDownloadAndPreview$default(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity; Lcom/bytedance/trae/conversation/products/HtmlArtifactRemoteArchiveResolveMode; I Ljava/lang/Object;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->stopLoadingAnimation()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/webkit/WebView;->destroy()V
    invoke-super v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onDestroy()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->com_bytedance_trae_conversation_products_HtmlArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;)V
    return-void 
.end method
