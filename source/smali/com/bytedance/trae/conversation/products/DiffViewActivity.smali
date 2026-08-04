# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/DiffViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "DiffViewActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;
.field private static final DOWNLOAD_URL_MAX_RETRIES:I
.field private static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field private static final EVENT_DIFF_VIEW_RESULT:Ljava/lang/String;
.field private static final EVENT_FETCH_DOWNLOAD_URL:Ljava/lang/String;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_MESSAGE_ID:Ljava/lang/String;
.field private static final EXTRA_TASK_NAME:Ljava/lang/String;
.field private static final EXTRA_TURN_ID:Ljava/lang/String;
.field private btnRetry:Landroid/view/View;
.field private conversationId:Ljava/lang/String;
.field private diffFiles:Ljava/util/List;
.field private ivBack:Landroid/view/View;
.field private layoutError:Landroid/widget/LinearLayout;
.field private messageId:Ljava/lang/String;
.field private progressBar:Landroid/widget/ProgressBar;
.field private tvTitle:Landroid/widget/TextView;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$0UAZqoC1ZUunzAe5ZtLl2jQPTR4(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->onCreate$lambda$0(Landroid/view/View; Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CoAxL5X2fbDIFxGH8LnfvDh05Nk(com.bytedance.trae.conversation.products.DiffViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$WXbRlwh1PjR06dONS-IpHY-Ta-8(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String)org.json.JSONObject
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->loadDiffFromUrl$lambda$32(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$cTweWeDEz1zzmxdu9QilJsU512E(com.bytedance.trae.conversation.products.DiffViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cVfeGO8Z-456zGOnV0h_bIDM65w(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->onCreate$lambda$4(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xgBgVzoaKx7s8-l5LfCFcrSqOSc(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->onCreate$lambda$3$lambda$2(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$zlJnbNG-lcnfLkOZV3hJuvzETJE(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String)org.json.JSONObject
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->fetchDownloadUrlWithRetry$lambda$16(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->Companion Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->conversationId Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->messageId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$fetchDownloadUrlWithRetry(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->fetchDownloadUrlWithRetry(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchJsonViaTTNet(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->fetchJsonViaTTNet(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.products.DiffViewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.products.DiffViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$handleDiffViewResult(com.bytedance.trae.conversation.products.DiffViewActivity  com.bytedance.trae.network.response.HttpDataResult  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->handleDiffViewResult(Lcom/bytedance/trae/network/response/HttpDataResult; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$loadDiffFromUrl(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->loadDiffFromUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$showDiffError(com.bytedance.trae.conversation.products.DiffViewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->showDiffError()V
    return-void 
.end method

.method private final collectDiffFilesFromResponse(com.bytedance.trae.im.service.DiffViewResponse)java.util.List
    .registers 2
    # ins_size=2
    invoke-virtual v1, Lcom/bytedance/trae/im/service/DiffViewResponse;->getChangedCodes()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOfNotNull(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->flatten(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method public static com_bytedance_trae_conversation_products_DiffViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.DiffViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->com_bytedance_trae_conversation_products_DiffViewActivity__onStop$___twin___()V
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

.method private final decodeContentString(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    const/4 v0, 0
    invoke-static v4, v0, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v0
    new-instance v1, Ljava/lang/String;
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v1, v0, v2, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    move-object v4, v1
    return-object v4
    :try_start_0x1
.end method

.method private final fetchDownloadUrlWithRetry(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 27
    # ins_size=3
    move-object/from16 v1, v24
    move-object/from16 v0, v26
    instance-of v2, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->label I
    const/4 v6, 2
    const-string v7, "reason"
    const-string v8, "fail"
    const/4 v9, 1
    const-string v10, "attempt"
    const-string/jumbo v11, status
    const-string v12, "diff_view_fetch_download_url"
    if-eqz v4, +03ah
    if-eq v4, v9, +020h
    if-ne v4, v6, +016h
    iget v4, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iget-object v14, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v14, Lkotlin/jvm/functions/Function0;
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    iget-object v13, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v13, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v0, v6
    goto/16 +0ebh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iget-object v13, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v13, Lkotlin/jvm/functions/Function0;
    iget-object v14, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v15, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v23, v14
    move-object v14, v13
    move-object v13, v15
    move-object/from16 v15, v23
    goto +42h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda6;
    move-object/from16 v4, v25
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String;)V
    const/4 v13, 0
    move-object v14, v1
    const/4 v15, 4
    if-ge v13, v15, +17dh
    sget-object v15, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v6, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v17
    iget-object v5, v14, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->conversationId Ljava/lang/String;
    iget-object v9, v14, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->messageId Ljava/lang/String;
    const/16 v20, 0
    const/16 v21, 8
    const/16 v22, 0
    move-object/from16 v16, v6
    move-object/from16 v18, v5
    move-object/from16 v19, v9
    invoke-direct/range v16 ... v22, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v14, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    iput v13, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    const/4 v5, 1
    iput v5, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->label I
    invoke-virtual v15, v6, v2, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    move-object v15, v4
    move v4, v13
    move-object v13, v14
    move-object v14, v0
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v5, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v6, "local"
    const-string/jumbo v9, type
    if-eqz v5, +0d8h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v5, +00fh
    invoke-virtual v5, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v5
    if-eqz v5, +009h
    invoke-interface v5, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    goto +2h
    const/4 v5, 0
    if-eqz v5, +03ch
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    check-cast v13, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v3, success
    invoke-virtual v2, v11, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v9, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v10, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lorg/json/JSONObject;
    invoke-virtual v0, v12, v2, v3, v4, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-object v5
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v16
    const-wide/16 v18, 202
    cmp-long v0, v16, v18
    if-nez v0, +026h
    const/4 v0, 3
    if-ge v4, v0, +018h
    iput-object v13, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v15, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v14, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    const/4 v0, 2
    iput v0, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$fetchDownloadUrlWithRetry$1;->label I
    const-wide/16 v5, 500
    invoke-static v5, v6, v2, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    const/4 v5, 1
    goto +3h
    const/4 v0, 2
    goto -3h
    add-int/2addr v4, v5
    move v6, v0
    move v9, v5
    move-object v0, v14
    move-object v14, v13
    move v13, v4
    move-object v4, v15
    goto/16 -0c8h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    check-cast v13, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v2, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, unexpected_code
    invoke-virtual v2, v7, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v2, v9, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v10, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lorg/json/JSONObject;
    const-string v6, "biz_code"
    invoke-static/range v16 ... v17, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Lorg/json/JSONObject;
    invoke-virtual v0, v12, v2, v3, v4, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v2, 0
    return-object v2
    instance-of v2, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +060h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    check-cast v13, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v2, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, request_error
    invoke-virtual v3, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v9, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "error_code"
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v6
    invoke-static v6, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v5, v10, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v14, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lorg/json/JSONObject;
    const-string v7, "error_message"
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v7, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Lorg/json/JSONObject;
    invoke-virtual v2, v12, v3, v5, v4, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v2, 0
    return-object v2
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    check-cast v14, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v2, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, retry_exhausted
    invoke-virtual v3, v7, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const/4 v5, 3
    invoke-virtual v4, v10, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lorg/json/JSONObject;
    invoke-virtual v2, v12, v3, v4, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    const/4 v2, 0
    return-object v2
    :try_start_0xd6
    :try_start_0x142
    :try_start_0x192
    :try_start_0x1f6
.end method

.method private static final fetchDownloadUrlWithRetry$lambda$16(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String)org.json.JSONObject
    .registers 5
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "conversation_id"
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "message_id"
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "file_path"
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-object v0
.end method

.method private final fetchJsonViaTTNet(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    const-string v0, "https://placeholder.trae/"
    const/4 v1, 0
    invoke-static v0, v4, v1, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v4
    const-class v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$DiffFetchApi;
    invoke-virtual v4, v0, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity$DiffFetchApi;
    if-nez v4, +003h
    return-object v1
    invoke-interface v4, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$DiffFetchApi;->get(Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v3
    invoke-interface v3, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    const-string v4, "execute(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v3, +003h
    return-object v1
    invoke-interface v3, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v3
    const-string v4, "in(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->readAllBytes(Ljava/io/InputStream;)[B
    move-result-object v3
    new-instance v4, Ljava/lang/String;
    invoke-static v3, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v3
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v4, v3, v0, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v4
.end method

.method private final handleDiffViewResult(com.bytedance.trae.network.response.HttpDataResult  java.lang.String)void
    .registers 13
    # ins_size=3
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "conversation_id"
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "message_id"
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    instance-of v1, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v2, "reason"
    const-string v3, "fail"
    const-string/jumbo v4, webView
    const-string v5, "remote"
    const-string/jumbo v6, type
    const-string/jumbo v7, status
    const-string v8, "diff_view_result"
    const/4 v9, 0
    if-eqz v1, +0abh
    move-object v1, v11
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/DiffViewResponse;
    if-eqz v1, +058h
    invoke-direct v10, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->collectDiffFilesFromResponse(Lcom/bytedance/trae/im/service/DiffViewResponse;)Ljava/util/List;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    sget-object v11, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->INSTANCE Lcom/bytedance/trae/conversation/products/DiffViewerHelper;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v9, v1
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    invoke-virtual v11, v9, v1, v12, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->showDiff(Landroid/webkit/WebView; Ljava/util/List; Ljava/lang/String;)V
    sget-object v11, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v11, v10
    check-cast v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v11, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v12, Lorg/json/JSONObject;
    invoke-direct v12, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, success
    invoke-virtual v12, v7, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v12, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v2, size
    iget-object v3, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v11, v8, v12, v1, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto/16 +0c8h
    move-exception v11
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto/16 +0bch
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v12, v10
    check-cast v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v12, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v7, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "empty_data"
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v2, "biz_code"
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, v2, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v12, v8, v1, v9, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto/16 +084h
    move-exception v11
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto/16 +078h
    instance-of v12, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v12, +075h
    iget-object v12, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v12, +008h
    const-string v12, "progressBar"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v9
    const/16 v1, 8
    invoke-virtual v12, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v12, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    if-nez v12, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v9
    invoke-virtual v12, v1, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v12, v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->layoutError Landroid/widget/LinearLayout;
    if-nez v12, +008h
    const-string v12, "layoutError"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v9
    const/4 v1, 0
    invoke-virtual v12, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v12, v10
    check-cast v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v12, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v1, v7, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v3, request_error
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v1, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v2, "error_code"
    move-object v3, v11
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-static v3, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v2, "error_message"
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, v2, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v12, v8, v1, v9, v0, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v11
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v11, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v11
    invoke-static v11, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    :try_start_0x4e
    :try_start_0x8e
    :try_start_0xfe
.end method

.method private final loadDiffFromUrl(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 29
    # ins_size=5
    move-object/from16 v1, v24
    move-object/from16 v0, v25
    move-object/from16 v2, v28
    instance-of v3, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;
    if-eqz v3, +012h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;
    iget v4, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->label I
    sub-int/2addr v2, v5
    iput v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;
    invoke-direct v3, v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->label I
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v5, +01fh
    if-ne v5, v6, +015h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->L$2 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/functions/Function0;
    iget-object v4, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->L$1 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v5, v3
    move-object v3, v2
    move-object v2, v0
    goto +33h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda5;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v5
    check-cast v5, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;
    move-object/from16 v9, v26
    invoke-direct v8, v1, v0, v9, v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$json$1;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    iput-object v1, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->L$0 Ljava/lang/Object;
    move-object/from16 v0, v27
    iput-object v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->L$1 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->L$2 Ljava/lang/Object;
    iput v6, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffFromUrl$1;->label I
    invoke-static v5, v8, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v4, +003h
    return-object v4
    move-object v4, v0
    move-object v5, v1
    check-cast v3, Ljava/lang/String;
    const-string v6, "reason"
    const-string v8, "fail"
    const-string v9, "local"
    const-string/jumbo v10, type
    const-string/jumbo v11, status
    const-string v12, "diff_view_result"
    if-nez v3, +03ah
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "fetch_json_failed"
    invoke-virtual v3, v6, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v10, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lorg/json/JSONObject;
    invoke-virtual v0, v12, v3, v7, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->showDiffError()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v13, Lcom/bytedance/trae/im/service/DiffViewResponse;
    invoke-virtual v0, v3, v13, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/DiffViewResponse;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/im/service/DiffViewResponse;
    if-nez v0, +03ah
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v11, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "json_parse_failed"
    invoke-virtual v3, v6, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v10, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lorg/json/JSONObject;
    invoke-virtual v0, v12, v3, v7, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->showDiffError()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->collectDiffFilesFromResponse(Lcom/bytedance/trae/im/service/DiffViewResponse;)Ljava/util/List;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v6, 10
    invoke-static v0, v6, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v6
    invoke-direct v3, v6, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +027h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v13, v6
    check-cast v13, Lcom/bytedance/trae/im/model/FileDiffInfo;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    invoke-virtual v13, Lcom/bytedance/trae/im/model/FileDiffInfo;->getBeforeContent()Ljava/lang/String;
    move-result-object v18
    invoke-virtual v13, Lcom/bytedance/trae/im/model/FileDiffInfo;->getAfterContent()Ljava/lang/String;
    move-result-object v19
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 207
    const/16 v23, 0
    invoke-static/range v13 ... v23, Lcom/bytedance/trae/im/model/FileDiffInfo;->copy$default(Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; I Ljava/lang/Object;)Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-result-object v6
    invoke-interface v3, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v3, Ljava/util/List;
    iput-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->INSTANCE Lcom/bytedance/trae/conversation/products/DiffViewerHelper;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    if-nez v3, +009h
    const-string/jumbo v3, webView
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v7, v3
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    invoke-virtual v0, v7, v3, v4, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->showDiff(Landroid/webkit/WebView; Ljava/util/List; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v4, success
    invoke-virtual v3, v11, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v3, v10, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v6, size
    iget-object v5, v5, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-virtual v4, v6, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lorg/json/JSONObject;
    invoke-virtual v0, v12, v3, v4, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x84
    :try_start_0xbc
    :try_start_0xea
    :try_start_0x17d
.end method

.method private static final loadDiffFromUrl$lambda$32(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String)org.json.JSONObject
    .registers 5
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "conversation_id"
    iget-object v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v1, "message_id"
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->messageId Ljava/lang/String;
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "download_url"
    invoke-virtual v0, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-object v0
.end method

.method private final loadDiffView(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=5
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->layoutError Landroid/widget/LinearLayout;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;
    const/4 v10, 0
    move-object v4, v0
    move-object v5, v12
    move-object v6, v14
    move-object v7, v11
    move-object v8, v15
    move-object v9, v13
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/products/DiffViewActivity$loadDiffView$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreate$lambda$0(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 6
    # ins_size=2
    const-string/jumbo v0, v
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "insets"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroidx/core/view/WindowInsetsCompat$Type;->statusBars()I
    move-result v0
    invoke-virtual v5, v0, Landroidx/core/view/WindowInsetsCompat;->getInsets(I)Landroidx/core/graphics/Insets;
    move-result-object v0
    const-string v1, "getInsets(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/View;->getPaddingLeft()I
    move-result v1
    iget v0, v0, Landroidx/core/graphics/Insets;->top I
    invoke-virtual v4, Landroid/view/View;->getPaddingRight()I
    move-result v2
    invoke-virtual v4, Landroid/view/View;->getPaddingBottom()I
    move-result v3
    invoke-virtual v4, v1, v0, v2, v3, Landroid/view/View;->setPadding(I I I I)V
    return-object v5
.end method

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.products.DiffViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.products.DiffViewActivity  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +018h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->diffFiles Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;->newInstance(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    const-string v0, "FileTreeBottomSheet"
    invoke-virtual v3, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$3$lambda$2(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->scrollWebViewToFile(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$4(com.bytedance.trae.conversation.products.DiffViewActivity  java.lang.String  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->loadDiffView(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final readAllBytes(java.io.InputStream)byte[]
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/io/Closeable;
    move-object v0, v6
    check-cast v0, Ljava/io/InputStream;
    new-instance v1, Ljava/io/ByteArrayOutputStream;
    invoke-direct v1, Ljava/io/ByteArrayOutputStream;-><init>()V
    const/16 v2, 8192
    new-array v2, v2, [B
    invoke-virtual v0, v2, Ljava/io/InputStream;->read([B)I
    move-result v3
    if-lez v3, +007h
    const/4 v4, 0
    invoke-virtual v1, v2, v4, v3, Ljava/io/ByteArrayOutputStream;->write([B I I)V
    goto -ah
    invoke-virtual v1, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v0
    const-string/jumbo v1, toByteArray(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    invoke-static v6, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    return-object v0
    move-exception v0
    throw v0
    move-exception v1
    invoke-static v6, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    :try_start_0x2
    :try_start_0x29
.end method

.method private final scrollWebViewToFile(java.lang.String)void
    .registers 14
    # ins_size=2
    const-string v1, "\"
    const-string v2, "\\"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "'"
    const-string v8, "\'"
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, "
"
    const-string v2, "\n"
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, scrollToFile('
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v2, "')"
    invoke-virtual v13, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v0, v13, v1, Landroid/webkit/WebView;->evaluateJavascript(Ljava/lang/String; Landroid/webkit/ValueCallback;)V
    return-void 
.end method

.method private final showDiffError()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->layoutError Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_DiffViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 13
    # ins_size=2
    invoke-super v11, v12, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v12, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_diff_view I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->setContentView(I)V
    sget v12, Lcom/bytedance/trae/conversation/R$id;->webview_diff I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    const-string v0, "findViewById(...)"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/webkit/WebView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/ProgressBar;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->progressBar Landroid/widget/ProgressBar;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->layout_error I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/LinearLayout;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->layoutError Landroid/widget/LinearLayout;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_retry I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->btnRetry Landroid/view/View;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->ivBack Landroid/view/View;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Landroid/widget/TextView;
    iput-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->tvTitle Landroid/widget/TextView;
    sget v12, Lcom/bytedance/trae/conversation/R$id;->toolbar I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroidx/appcompat/widget/Toolbar;
    check-cast v12, Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v12, v0, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View; Landroidx/core/view/OnApplyWindowInsetsListener;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->ivBack Landroid/view/View;
    const/4 v0, 0
    if-nez v12, +008h
    const-string v12, "ivBack"
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda2;
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity;)V
    invoke-virtual v12, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v12, Lcom/bytedance/trae/conversation/R$id;->btn_extend I
    invoke-virtual v11, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v12
    new-instance v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda3;
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity;)V
    invoke-virtual v12, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
    if-nez v12, +009h
    const-string/jumbo v12, webView
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v12, v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$onCreate$4;
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity$onCreate$4;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity;)V
    check-cast v1, Landroid/webkit/WebChromeClient;
    invoke-virtual v12, v1, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v12
    const-string v1, "extra_task_name"
    invoke-virtual v12, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    const-string v1, ""
    if-nez v12, +003h
    move-object v12, v1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_chat_session_id"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v8, v1
    goto +2h
    move-object v8, v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_turn_id"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v9, v1
    goto +2h
    move-object v9, v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_cli_type"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v10, v1
    goto +2h
    move-object v10, v2
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_message_id"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    iput-object v2, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->messageId Ljava/lang/String;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_conversation_id"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    iput-object v1, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->conversationId Ljava/lang/String;
    iget-object v1, v11, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->btnRetry Landroid/view/View;
    if-nez v1, +008h
    const-string v1, "btnRetry"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    new-instance v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda4;
    move-object v2, v1
    move-object v3, v11
    move-object v4, v10
    move-object v5, v8
    move-object v6, v9
    move-object v7, v12
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/products/DiffViewActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v11, v10, v8, v9, v12, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->loadDiffView(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->webView Landroid/webkit/WebView;
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
    invoke-static v0, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->com_bytedance_trae_conversation_products_DiffViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/DiffViewActivity;)V
    return-void 
.end method
