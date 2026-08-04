# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MargeViewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "MargeViewActivity.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;
.field private static final EVENT_MERGE_DIFF:Ljava/lang/String;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_MERGE_DATA_JSON:Ljava/lang/String;
.field private static final EXTRA_TASK_NAME:Ljava/lang/String;
.field private btnRetry:Landroid/view/View;
.field private diffFiles:Ljava/util/List;
.field private ivBack:Landroid/view/View;
.field private layoutError:Landroid/widget/LinearLayout;
.field private progressBar:Landroid/widget/ProgressBar;
.field private tvSubtitle:Landroid/widget/TextView;
.field private tvTitle:Landroid/widget/TextView;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$0IJfJ43mN7KobWoBdAa9Kh7zbmg(com.bytedance.trae.conversation.products.MargeViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->onCreate$lambda$1(Lcom/bytedance/trae/conversation/products/MargeViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$6-03F29uX7gDeF4eJx7YAq2ikME(java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData)org.json.JSONObject
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->handleResult$lambda$7(Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)Lorg/json/JSONObject;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XktQp3sc73eWSIGNK2p1hL2UCFE(android.view.View  androidx.core.view.WindowInsetsCompat)androidx.core.view.WindowInsetsCompat
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->onCreate$lambda$0(Landroid/view/View; Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$b6FjAKzqBDNYxj-D3uLOIxolWmc(com.bytedance.trae.conversation.products.MargeViewActivity  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->onCreate$lambda$3$lambda$2(Lcom/bytedance/trae/conversation/products/MargeViewActivity; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ii8-E2LNjbEnOf_8WHoZA8XFx9s(com.bytedance.trae.conversation.products.MargeViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/products/MargeViewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sH9AmYZUGOyH3GJXehLlN_Z9BsI(com.bytedance.trae.conversation.products.MargeViewActivity  java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->onCreate$lambda$5(Lcom/bytedance/trae/conversation/products/MargeViewActivity; Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->Companion Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->diffFiles Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.products.MargeViewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.products.MargeViewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$handleResult(com.bytedance.trae.conversation.products.MargeViewActivity  java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String  com.bytedance.trae.network.response.HttpDataResult)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->handleResult(Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String; Lcom/bytedance/trae/network/response/HttpDataResult;)V
    return-void 
.end method

.method public static com_bytedance_trae_conversation_products_MargeViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.MargeViewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->com_bytedance_trae_conversation_products_MargeViewActivity__onStop$___twin___()V
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

.method private final handleResult(java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String  com.bytedance.trae.network.response.HttpDataResult)void
    .registers 26
    # ins_size=5
    move-object/from16 v1, v21
    move-object/from16 v0, v25
    new-instance v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda4;
    move-object/from16 v3, v22
    move-object/from16 v4, v23
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda4;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v4, "reason"
    const-string v5, "fail"
    const/4 v6, 0
    const-string/jumbo v7, status
    const-string v8, "merge_diff_result"
    if-eqz v3, +139h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
    if-nez v3, +035h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v3, Lorg/json/JSONObject;
    invoke-direct v3, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v3, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "data_null"
    invoke-virtual v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lorg/json/JSONObject;
    invoke-virtual v0, v8, v3, v6, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->showError()V
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->getDiffFiles()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v0, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +07eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/products/DiffFile;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewPath()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->isNewFile()Z
    move-result v9
    if-eqz v9, +006h
    const-string v9, "added"
    move-object v13, v9
    goto +2ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewContent()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    const/4 v10, 1
    const/4 v11, 0
    if-nez v9, +004h
    move v9, v10
    goto +2h
    move v9, v11
    if-eqz v9, +015h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getOldContent()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-lez v9, +003h
    goto +2h
    move v10, v11
    if-eqz v10, +005h
    const-string v9, "deleted"
    goto -27h
    const-string v9, "modified"
    goto -2ah
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getInsertLineCount()I
    move-result v9
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getDeleteLineCount()I
    move-result v10
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getOldContent()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->getNewContent()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/DiffFile;->isConflict()Z
    move-result v5
    new-instance v11, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v16
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v17
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    const/16 v18, 0
    const/16 v19, 128
    const/16 v20, 0
    move-object v9, v11
    move-object/from16 v10, v16
    move-object v6, v11
    move-object/from16 v11, v17
    move-object/from16 v16, v5
    move-object/from16 v17, v18
    move/from16 v18, v19
    move-object/from16 v19, v20
    invoke-direct/range v9 ... v19, Lcom/bytedance/trae/im/model/FileDiffInfo;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v4, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/4 v6, 0
    goto/16 -080h
    check-cast v4, Ljava/util/List;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->diffFiles Ljava/util/List;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v4, Lorg/json/JSONObject;
    invoke-direct v4, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v5, success
    invoke-virtual v4, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string v6, "diff_file_count"
    iget-object v7, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->diffFiles Ljava/util/List;
    invoke-interface v7, Ljava/util/List;->size()I
    move-result v7
    invoke-virtual v5, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lorg/json/JSONObject;
    invoke-virtual v0, v8, v4, v5, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->INSTANCE Lcom/bytedance/trae/conversation/products/DiffViewerHelper;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
    if-nez v2, +00ah
    const-string/jumbo v2, webView
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v6, 0
    goto +2h
    move-object v6, v2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->diffFiles Ljava/util/List;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;->getTaskName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v6, v2, v3, Lcom/bytedance/trae/conversation/products/DiffViewerHelper;->showDiff(Landroid/webkit/WebView; Ljava/util/List; Ljava/lang/String;)V
    goto +59h
    instance-of v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +057h
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    sget-object v3, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v6, v7, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v5, request_error
    invoke-virtual v6, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v4, "error_code"
    move-object v5, v0
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v5
    invoke-static v5, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v6, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lorg/json/JSONObject;
    const-string v5, "error_message"
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v5, v0, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Lorg/json/JSONObject;
    const/4 v4, 0
    invoke-virtual v3, v8, v6, v4, v2, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->showError()V
    return-void 
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    :try_start_0x2d
    :try_start_0xfa
    :try_start_0x156
.end method

.method private static final handleResult$lambda$7(java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData)org.json.JSONObject
    .registers 5
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string v1, "chat_session_id"
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getSourceBranchHash()Ljava/lang/String;
    move-result-object v3
    const-string v1, ""
    if-nez v3, +003h
    move-object v3, v1
    const-string/jumbo v2, source_branch_hash
    invoke-virtual v0, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getTargetBranchHash()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v1, v3
    const-string/jumbo v3, target_branch_hash
    invoke-virtual v0, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    return-object v0
.end method

.method private final loadMergeDiffs(java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String)void
    .registers 14
    # ins_size=4
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->layoutError Landroid/widget/LinearLayout;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v0, v10
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$loadMergeDiffs$1;
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v11
    move-object v6, v12
    move-object v7, v13
    move-object v8, v10
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity$loadMergeDiffs$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/MargeViewActivity; Lkotlin/coroutines/Continuation;)V
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

.method private static final onCreate$lambda$1(com.bytedance.trae.conversation.products.MargeViewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.products.MargeViewActivity  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->diffFiles Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +018h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->diffFiles Ljava/util/List;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda5;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)V
    invoke-virtual v3, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;->newInstance(Ljava/util/List; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v2
    const-string v0, "FileTreeBottomSheet"
    invoke-virtual v3, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String;)V
    return-void 
.end method

.method private static final onCreate$lambda$3$lambda$2(com.bytedance.trae.conversation.products.MargeViewActivity  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->scrollWebViewToFile(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.conversation.products.MargeViewActivity  java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->loadMergeDiffs(Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String;)V
    return-void 
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
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
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

.method private final showError()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +009h
    const-string/jumbo v0, webView
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->layoutError Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutError"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_MargeViewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 11
    # ins_size=2
    invoke-super v9, v10, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v10, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_diff_view I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->setContentView(I)V
    sget v10, Lcom/bytedance/trae/conversation/R$id;->webview_diff I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    const-string v0, "findViewById(...)"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/webkit/WebView;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/ProgressBar;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->progressBar Landroid/widget/ProgressBar;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->layout_error I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/LinearLayout;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->layoutError Landroid/widget/LinearLayout;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->btn_retry I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->btnRetry Landroid/view/View;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->ivBack Landroid/view/View;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/TextView;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->tvTitle Landroid/widget/TextView;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v10, Landroid/widget/TextView;
    iput-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->tvSubtitle Landroid/widget/TextView;
    sget v10, Lcom/bytedance/trae/conversation/R$id;->toolbar I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Landroidx/appcompat/widget/Toolbar;
    check-cast v10, Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v10, v0, Landroidx/core/view/ViewCompat;->setOnApplyWindowInsetsListener(Landroid/view/View; Landroidx/core/view/OnApplyWindowInsetsListener;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->ivBack Landroid/view/View;
    const/4 v0, 0
    if-nez v10, +008h
    const-string v10, "ivBack"
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)V
    invoke-virtual v10, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v10, Lcom/bytedance/trae/conversation/R$id;->btn_extend I
    invoke-virtual v9, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v10
    new-instance v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda2;
    invoke-direct v1, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)V
    invoke-virtual v10, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
    if-nez v10, +009h
    const-string/jumbo v10, webView
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v10, v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$onCreate$4;
    invoke-direct v1, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity$onCreate$4;-><init>(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)V
    check-cast v1, Landroid/webkit/WebChromeClient;
    invoke-virtual v10, v1, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v10
    const-string v1, "extra_task_name"
    invoke-virtual v10, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    const-string v1, ""
    if-nez v10, +003h
    move-object v10, v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v2
    const-string v3, "extra_chat_session_id"
    invoke-virtual v2, v3, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v3
    const-string v4, "extra_merge_data_json"
    invoke-virtual v3, v4, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    move-object v3, v1
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v9
    check-cast v4, Lcom/bytedance/trae/conversation/products/MargeViewActivity;
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v4, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v4
    const-class v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    invoke-virtual v4, v3, v5, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    if-nez v3, +006h
    invoke-direct v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->showError()V
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getSourceBranch()Ljava/lang/String;
    move-result-object v4
    const-string v5, "origin/"
    if-eqz v4, +00ah
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v4, v6, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    if-nez v4, +003h
    move-object v4, v1
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getTargetBranch()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +009h
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v6, v5, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    goto +2h
    move-object v1, v5
    iget-object v5, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->tvTitle Landroid/widget/TextView;
    if-nez v5, +009h
    const-string/jumbo v5, tvTitle
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v0
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_merge_title I
    const/4 v7, 2
    new-array v7, v7, [Ljava/lang/Object;
    const/4 v8, 0
    aput-object v4, v7, v8
    const/4 v4, 1
    aput-object v1, v7, v4
    invoke-virtual v9, v6, v7, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v5, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->btnRetry Landroid/view/View;
    if-nez v1, +008h
    const-string v1, "btnRetry"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v1
    new-instance v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;
    invoke-direct v1, v9, v2, v3, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/products/MargeViewActivity; Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v9, v2, v3, v10, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->loadMergeDiffs(Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Ljava/lang/String;)V
    return-void 
    :try_start_0xd2
.end method

.method protected onDestroy()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->webView Landroid/webkit/WebView;
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
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->com_bytedance_trae_conversation_products_MargeViewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/MargeViewActivity;)V
    return-void 
.end method
