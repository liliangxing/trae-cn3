# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "MultiImagePreviewActivity.kt"

.field private static final ANIM_DURATION:J
.field public static final Companion:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
.field private static final DOUBLE_TAP_SCALE:F
.field private static final DOWNLOAD_URL_MAX_RETRIES:I
.field private static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_CREATED_TIME:Ljava/lang/String;
.field private static final EXTRA_CURRENT_INDEX:Ljava/lang/String;
.field private static final EXTRA_DISPLAY_NAMES:Ljava/lang/String;
.field private static final EXTRA_MESSAGE_ID:Ljava/lang/String;
.field private static final EXTRA_PATHS:Ljava/lang/String;
.field private static final EXTRA_RESOLVE_MODE:Ljava/lang/String;
.field private static final EXTRA_TURN_ID:Ljava/lang/String;
.field private static final IMAGE_EXTENSIONS:Ljava/util/Set;
.field private static final LOCAL_IMAGE_DOWNLOAD_CACHE_DIR:Ljava/lang/String;
.field private static final MAX_SCALE:F
.field private static final MIN_SCALE:F
.field private static final REMOTE_RESOURCE_CACHE_DIR:Ljava/lang/String;
.field private static final REMOTE_RESOURCE_PREFIX:Ljava/lang/String;
.field private static final RESOLVE_MODE_ARTIFACT:Ljava/lang/String;
.field private static final RESOLVE_MODE_IMAGE_ID:Ljava/lang/String;
.field private static final RESOLVE_MODE_LOCAL_ARTIFACT:Ljava/lang/String;
.field private static final RESOLVE_MODE_LOCAL_URI:Ljava/lang/String;
.field private static final RESOLVE_MODE_REMOTE_RESOURCE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private btnBack:Landroid/widget/ImageView;
.field private btnDownload:Landroid/widget/FrameLayout;
.field private chatSessionId:Ljava/lang/String;
.field private cliType:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private createdTime:J
.field private currentIndex:I
.field private displayNames:Ljava/util/List;
.field private final downloadFinishCallback:Lkotlin/jvm/functions/Function3;
.field private final fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field private final imageUploadApi$delegate:Lkotlin/Lazy;
.field private final imageUrls:Ljava/util/Map;
.field private isTopBarVisible:Z
.field private messageId:Ljava/lang/String;
.field private paths:Ljava/util/List;
.field private progressBar:Landroid/widget/ProgressBar;
.field private resolveMode:Ljava/lang/String;
.field private final resourceUploadApi$delegate:Lkotlin/Lazy;
.field private topBar:Landroid/view/View;
.field private topBarAnimator:Landroid/animation/ValueAnimator;
.field private tvGeneratedByAi:Landroid/widget/TextView;
.field private tvIndicator:Landroid/widget/TextView;
.field private viewPager:Landroidx/viewpager2/widget/ViewPager2;


.method public static synthetic $r8$lambda$74dyc5ZfSl594B0W_UbE3tEEkRc(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->onCreate$lambda$5(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$D2TjtlWHL6PdzdSXP_jYVqR1sYk(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->onCreate$lambda$6(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HWU7sZU94GMDWM8pDmfDK3bKRk8(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->downloadFinishCallback$lambda$4(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$XZNGdaz4bLzfHIH9MwYN9urCO-0()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUploadApi_delegate$lambda$1$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$iadXPOu2BAvqIVR4DeEZyTu5czU()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resourceUploadApi_delegate$lambda$3()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jbu7MOuNxADDPUrrvHUN7WjVcRw()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resourceUploadApi_delegate$lambda$3$lambda$2()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$sDsGbCN_1x4AhgM52SYaz5Ct0Xo(int  int  android.view.ViewGroup$MarginLayoutParams  com.bytedance.trae.conversation.products.MultiImagePreviewActivity  float  float  android.animation.ValueAnimator)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->setTopBarVisible$lambda$8$lambda$7(I I Landroid/view/ViewGroup$MarginLayoutParams; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; F F Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uWnHQpEk4Lld6M09v0P6zEcH6uU()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUploadApi_delegate$lambda$1()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 10
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    const-string v2, "jpg"
    const-string v3, "jpeg"
    const-string v4, "png"
    const-string v5, "gif"
    const-string/jumbo v6, webp
    const-string v7, "bmp"
    const-string v8, "heic"
    const-string v9, "heif"
    filled-new-array/range v2 ... v9, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->IMAGE_EXTENSIONS Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->displayNames Ljava/util/List;
    const-string v0, "artifact"
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUrls Ljava/util/Map;
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->isTopBarVisible Z
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUploadApi$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda4;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda4;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resourceUploadApi$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda5;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    return-void 
.end method

.method public static final synthetic access$buildFileUrl(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->buildFileUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$copyLocalUriToCache(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  android.net.Uri  java.lang.String)java.io.File
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->copyLocalUriToCache(Landroid/net/Uri; Ljava/lang/String;)Ljava/io/File;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchDownloadUrlsWithRetry(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fetchDownloadUrlsWithRetry(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchLocalArtifactUrls(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fetchLocalArtifactUrls(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchRemoteResourceUrls(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fetchRemoteResourceUrls(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getChatSessionId$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCliType$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getDownloadFinishCallback$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)kotlin.jvm.functions.Function3
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public static final synthetic access$getFileDownloadHelper$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)com.bytedance.trae.conversation.products.FileDownloadHelper
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-object v0
.end method

.method public static final synthetic access$getImageUploadApi(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getImageUploadApi()Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getImageUrls$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUrls Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$getMessageId$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getPaths$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getResolveMode$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getTopBar$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)android.view.View
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBar Landroid/view/View;
    return-object v0
.end method

.method public static final synthetic access$getViewPager$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)androidx.viewpager2.widget.ViewPager2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    return-object v0
.end method

.method public static final synthetic access$normalizeFilePath(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setCurrentIndex$p(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    return-void 
.end method

.method public static final synthetic access$toggleTopBar(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->toggleTopBar()V
    return-void 
.end method

.method public static final synthetic access$updateIndicator(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->updateIndicator()V
    return-void 
.end method

.method private final buildFileUrl(java.lang.String  java.lang.String)java.lang.String
    .registers 9
    # ins_size=3
    const-string v0, "UTF-8"
    invoke-static v8, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    const/4 v3, 1
    new-array v3, v3, [C
    const/4 v4, 0
    const/16 v5, 47
    aput-char v5, v3, v4
    invoke-static v7, v3, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v2, "/file/"
    invoke-virtual v7, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, "?download=true&authorization="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v2, "Cloud-IDE-JWT "
    invoke-direct v8, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v0, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    return-object v7
.end method

.method public static com_bytedance_trae_conversation_products_MultiImagePreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.MultiImagePreviewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->com_bytedance_trae_conversation_products_MultiImagePreviewActivity__onStop$___twin___()V
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

.method private final copyLocalUriToCache(android.net.Uri  java.lang.String)java.io.File
    .registers 12
    # ins_size=3
    const/16 v0, 47
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v11, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const/16 v3, 92
    invoke-static v0, v3, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    new-instance v3, Ljava/io/File;
    new-instance v4, Ljava/io/File;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getCacheDir()Ljava/io/File;
    move-result-object v5
    const-string v6, "multi_image_local_download"
    invoke-direct v4, v5, v6, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-direct v3, v4, v0, Ljava/io/File;-><init>(Ljava/io/File; Ljava/lang/String;)V
    invoke-virtual v3, Ljava/io/File;->getParentFile()Ljava/io/File;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Ljava/io/File;->mkdirs()Z
    const/4 v0, 0
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v4, v9
    check-cast v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-virtual v10, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v4
    const-string v5, "file"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +04ah
    new-instance v4, Ljava/io/File;
    invoke-virtual v10, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +036h
    invoke-direct v4, v5, Ljava/io/File;-><init>(Ljava/lang/String;)V
    new-instance v5, Ljava/io/FileInputStream;
    invoke-direct v5, v4, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    check-cast v5, Ljava/io/Closeable;
    move-object v4, v5
    check-cast v4, Ljava/io/FileInputStream;
    new-instance v6, Ljava/io/FileOutputStream;
    invoke-direct v6, v3, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v6, Ljava/io/Closeable;
    move-object v7, v6
    check-cast v7, Ljava/io/FileOutputStream;
    check-cast v4, Ljava/io/InputStream;
    check-cast v7, Ljava/io/OutputStream;
    invoke-static v4, v7, v0, v2, v1, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    move-result-wide v7
    invoke-static v6, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v5, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +40h
    move-exception v2
    throw v2
    move-exception v4
    invoke-static v6, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    move-exception v2
    throw v2
    move-exception v4
    invoke-static v5, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    const-string v2, "Required value was null."
    new-instance v4, Ljava/lang/IllegalArgumentException;
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v4, v2, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v4
    invoke-virtual v4, v10, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    move-result-object v4
    if-eqz v4, +034h
    check-cast v4, Ljava/io/Closeable;
    move-object v5, v4
    check-cast v5, Ljava/io/InputStream;
    new-instance v6, Ljava/io/FileOutputStream;
    invoke-direct v6, v3, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    check-cast v6, Ljava/io/Closeable;
    move-object v7, v6
    check-cast v7, Ljava/io/FileOutputStream;
    check-cast v7, Ljava/io/OutputStream;
    invoke-static v5, v7, v0, v2, v1, Lkotlin/io/ByteStreamsKt;->copyTo$default(Ljava/io/InputStream; Ljava/io/OutputStream; I I Ljava/lang/Object;)J
    move-result-wide v7
    invoke-static v6, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v4, v1, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    invoke-static v7, v8, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +1bh
    move-exception v2
    throw v2
    move-exception v5
    invoke-static v6, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v5
    move-exception v2
    throw v2
    move-exception v5
    invoke-static v4, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v5
    return-object v1
    move-exception v2
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    if-eqz v2, +026h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "copyLocalUriToCache failed: uri="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    const-string v4, ", fileName="
    invoke-virtual v10, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string v11, "MultiImagePreviewActivity"
    invoke-virtual v0, v11, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-virtual v3, Ljava/io/File;->delete()Z
    return-object v1
    invoke-virtual v3, Ljava/io/File;->exists()Z
    move-result v10
    if-eqz v10, +00dh
    invoke-virtual v3, Ljava/io/File;->length()J
    move-result-wide v10
    const-wide/16 v4, 0
    cmp-long v10, v10, v4
    if-lez v10, +003h
    const/4 v0, 1
    if-eqz v0, +003h
    move-object v1, v3
    return-object v1
    :try_start_0x28
    :try_start_0x4b
    :try_start_0x55
    :try_start_0x60
    :try_start_0x63
    :try_start_0x68
    :try_start_0x6a
    :try_start_0x6f
    :try_start_0x71
    :try_start_0x8d
    :try_start_0x97
    :try_start_0xa0
    :try_start_0xa3
    :try_start_0xb0
    :try_start_0xb2
    :try_start_0xb7
    :try_start_0xb9
.end method

.method private final displayNameForIndex(int)java.lang.String
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->displayNames Ljava/util/List;
    invoke-static v0, v3, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    const/4 v0, 0
    if-eqz v3, +01ah
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    move-object v0, v3
    return-object v0
.end method

.method private final downloadCurrentImage()void
    .registers 14
    # ins_size=1
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    iget v1, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUrls Ljava/util/Map;
    invoke-interface v1, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Ljava/lang/String;
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-eqz v1, +00fh
    move-object v0, v13
    check-cast v0, Landroid/content/Context;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v13, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
    iget v1, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    invoke-direct v13, v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->downloadFileName(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v6
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    const-string v1, "local_uri"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const-string v1, "local_artifact"
    const/4 v5, 0
    if-nez v0, +00ah
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +022h
    invoke-direct v13, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->isLocalUri(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +01ch
    move-object v0, v13
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    const/4 v8, 0
    const/4 v9, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;
    invoke-direct v0, v13, v6, v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$downloadCurrentImage$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v10, v0
    check-cast v10, Lkotlin/jvm/functions/Function2;
    const/4 v11, 3
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v7
    const v8, -1228798510
    const-string v9, "artifact"
    if-eq v7, v8, +01fh
    const v8, -843977753
    if-eq v7, v8, +00fh
    const v8, -471957466
    if-eq v7, v8, +003h
    goto +19h
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ch
    goto +12h
    const-string v1, "remote_resource"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +9h
    move v0, v3
    goto +1dh
    invoke-virtual v0, v9, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    move v0, v2
    goto +15h
    iget-object v0, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->cliType Ljava/lang/String;
    if-nez v0, +008h
    const-string v0, "cliType"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v5
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    iget-object v2, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    invoke-static v1, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ch
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v1, +00ah
    const-string v1, "chatSessionId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +4h
    const-string v1, ""
    move-object v5, v1
    move-object v1, v13
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    iget-wide v10, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->createdTime J
    iget-object v8, v13, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    move-object v3, v13
    check-cast v3, Landroid/content/Context;
    move-object v7, v1
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    move v9, v0
    invoke-virtual/range v2 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    return-void 
.end method

.method private final downloadFileName(java.lang.String  int)java.lang.String
    .registers 6
    # ins_size=3
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->displayNameForIndex(I)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +04dh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const v2, -1204869480
    if-eq v1, v2, +021h
    const v2, -859601281
    if-eq v1, v2, +011h
    const v2, -843977753
    if-eq v1, v2, +003h
    goto +37h
    const-string v1, "remote_resource"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ch
    goto +2eh
    const-string v1, "image_id"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +25h
    const/4 v4, 0
    goto +23h
    const-string v1, "local_uri"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1ah
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    const-string v1, "parse(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->queryDisplayName(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +00bh
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-virtual v4, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->sanitizeImageFileName(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method private static final downloadFinishCallback$lambda$4(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    const-string/jumbo v3, savedPath
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v1, +02eh
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
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getString(I)Ljava/lang/String;
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
    goto +dh
    move-object v1, v0
    check-cast v1, Landroid/content/Context;
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_download_failed I
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final fallbackImageFileName(int)java.lang.String
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, trae_image_
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    add-int/lit8 v3, v3, 1
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v0, ".jpg"
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final fetchAllImageUrls()void
    .registers 12
    # ins_size=1
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const-string v2, "progressBar"
    const/4 v3, 0
    const/4 v4, 0
    sparse-switch v1, +00000d6h
    goto/16 +0cfh
    const-string v1, "local_artifact"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0c5h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v5, v0
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;
    invoke-direct v0, v11, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto/16 +0a2h
    const-string v1, "remote_resource"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +095h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v5, v0
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$3;
    invoke-direct v0, v11, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$3;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto/16 +072h
    const-string v1, "image_id"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +65h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, v3, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v0, v11
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v5, v0
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    const/4 v6, 0
    const/4 v7, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2;
    invoke-direct v0, v11, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$2;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v8, v0
    check-cast v8, Lkotlin/jvm/functions/Function2;
    const/4 v9, 3
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    goto +43h
    const-string v1, "local_uri"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +37h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    iget-object v2, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUrls Ljava/util/Map;
    invoke-interface v2, v1, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -11h
    iget-object v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    if-nez v0, +009h
    const-string/jumbo v0, viewPager
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    invoke-virtual v0, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v1, +005h
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v4, +009h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->notifyDataSetChanged()V
    goto +4h
    invoke-direct v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fetchArtifactImageUrls()V
    return-void 
    sparse-switch-payload -47d0d968 -333c7981 -324e1419 -1c217fda
.end method

.method private final fetchArtifactImageUrls()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    move-object v0, v8
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final fetchDownloadUrlsWithRetry(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=3
    instance-of v0, v15, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;
    if-eqz v0, +012h
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v15, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->label I
    sub-int/2addr v15, v2
    iput v15, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;
    invoke-direct v0, v13, v15, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->label I
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v2, +02bh
    if-eq v2, v6, +01bh
    if-ne v2, v4, +011h
    iget v14, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->I$0 I
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/util/List;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c8h
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v15, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v15, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    iget v14, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->I$0 I
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/util/List;
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2bh
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v2, v13
    move v15, v5
    const/16 v7, 21
    if-ge v15, v7, +0c3h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v7
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$result$1;
    invoke-direct v8, v14, v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$result$1;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$1 Ljava/lang/Object;
    iput v15, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->I$0 I
    iput v6, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->label I
    invoke-static v7, v8, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v12, v2
    move-object v2, v14
    move v14, v15
    move-object v15, v7
    move-object v7, v12
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v8, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v8, +08dh
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v8, +007h
    invoke-virtual v8, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v8
    goto +2h
    move-object v8, v3
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/util/Map;->isEmpty()Z
    move-result v9
    if-eqz v9, +003h
    goto +3h
    move v9, v5
    goto +2h
    move v9, v6
    if-nez v9, +03dh
    new-instance v14, Ljava/util/LinkedHashMap;
    invoke-direct v14, Ljava/util/LinkedHashMap;-><init>()V
    invoke-interface v8, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v15
    invoke-interface v15, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +027h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v6
    goto +2h
    move v1, v5
    if-eqz v1, -01dh
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    invoke-virtual v14, v1, v0, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -2ah
    check-cast v14, Ljava/util/Map;
    return-object v14
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v8
    const-wide/16 v10, 202
    cmp-long v15, v8, v10
    if-nez v15, +01dh
    const/16 v15, 20
    if-ge v14, v15, +013h
    iput-object v7, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->L$1 Ljava/lang/Object;
    iput v14, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->I$0 I
    iput v4, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchDownloadUrlsWithRetry$1;->label I
    const-wide/16 v8, 2000
    invoke-static v8, v9, v0, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v1, +003h
    return-object v1
    add-int/lit8 v15, v14, 1
    move-object v14, v2
    move-object v2, v7
    goto/16 -0afh
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v14
    return-object v14
    instance-of v14, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v14, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v14
    return-object v14
    new-instance v14, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v14, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v14
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v14
    return-object v14
.end method

.method private final fetchLocalArtifactUrls(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v20
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->label I
    const/4 v6, 2
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v4, +037h
    if-eq v4, v7, +022h
    if-ne v4, v6, +018h
    iget v4, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->I$0 I
    iget-object v9, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/util/Map;
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/util/Map;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v10
    move-object v10, v9
    move-object v9, v11
    goto/16 +1d1h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget v4, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->I$0 I
    iget-object v9, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/util/Map;
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/util/Map;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +105h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "chatSessionId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +00ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->conversationId Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "conversationId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v8
    check-cast v1, Ljava/lang/String;
    move-object/from16 v4, v19
    check-cast v4, Ljava/lang/Iterable;
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +039h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    sget-object v12, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->requestTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    iget-object v13, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    sget-object v14, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v14
    invoke-virtual v14, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;
    move-result-object v14
    const-string v15, "getApplicationContext(...)"
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, v14, v1, v12, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getCachedFile(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Ljava/io/File;
    move-result-object v12
    if-eqz v12, +00fh
    invoke-static v12, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v12
    invoke-virtual v12, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-static v11, v12, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v11
    goto +2h
    move-object v11, v8
    if-eqz v11, -037h
    invoke-interface v9, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ch
    check-cast v9, Ljava/util/List;
    check-cast v9, Ljava/lang/Iterable;
    invoke-static v9, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v1
    new-instance v9, Ljava/util/ArrayList;
    invoke-direct v9, Ljava/util/ArrayList;-><init>()V
    check-cast v9, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +014h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Ljava/lang/String;
    invoke-interface v1, v11, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v11
    xor-int/2addr v11, v7
    if-eqz v11, -012h
    invoke-interface v9, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v9, Ljava/util/List;
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    return-object v1
    check-cast v9, Ljava/lang/Iterable;
    sget-object v4, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    new-instance v10, Ljava/util/LinkedHashMap;
    const/16 v11, 10
    invoke-static v9, v11, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v11
    invoke-static v11, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v11
    const/16 v12, 16
    invoke-static v11, v12, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v11
    invoke-direct v10, v11, Ljava/util/LinkedHashMap;-><init>(I)V
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +014h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v12, v10
    check-cast v12, Ljava/util/Map;
    move-object v13, v11
    check-cast v13, Ljava/lang/String;
    invoke-virtual v4, v13, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->requestTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-interface v12, v11, v13, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -17h
    check-cast v10, Ljava/util/Map;
    move-object v9, v0
    const/4 v4, 0
    const/16 v11, 21
    if-ge v4, v11, +0e7h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v11
    check-cast v11, Lkotlin/coroutines/CoroutineContext;
    new-instance v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;
    invoke-direct v12, v10, v9, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1;-><init>(Ljava/util/Map; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    iput-object v9, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$0 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$1 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$2 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->I$0 I
    iput v7, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->label I
    invoke-static v11, v12, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v3, +003h
    return-object v3
    move-object/from16 v17, v10
    move-object v10, v1
    move-object v1, v11
    move-object v11, v9
    move-object/from16 v9, v17
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v12, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v12, +0b1h
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v12
    goto +2h
    move-object v12, v8
    if-eqz v12, +00bh
    invoke-interface v12, Ljava/util/Map;->isEmpty()Z
    move-result v13
    if-eqz v13, +003h
    goto +3h
    const/4 v13, 0
    goto +2h
    move v13, v7
    if-nez v13, +066h
    new-instance v13, Ljava/util/ArrayList;
    invoke-direct v13, Ljava/util/ArrayList;-><init>()V
    check-cast v13, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v14
    invoke-interface v14, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v15
    if-eqz v15, +03dh
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/util/Map$Entry;
    invoke-interface v15, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v16
    move-object/from16 v5, v16
    check-cast v5, Ljava/lang/String;
    invoke-interface v15, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    invoke-interface v12, v15, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    if-nez v15, +00bh
    invoke-interface v12, v5, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    if-nez v15, +003h
    goto +bh
    move-object/from16 v16, v15
    check-cast v16, Ljava/lang/CharSequence;
    invoke-static/range v16, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v16
    if-eqz v16, +004h
    move-object v5, v8
    goto +5h
    invoke-static v5, v15, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    if-eqz v5, -03bh
    invoke-interface v13, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -40h
    check-cast v13, Ljava/util/List;
    check-cast v13, Ljava/lang/Iterable;
    invoke-static v13, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v5
    invoke-interface v5, Ljava/util/Map;->isEmpty()Z
    move-result v12
    xor-int/2addr v12, v7
    if-eqz v12, +007h
    invoke-static v10, v5, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v1
    return-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v12
    const-wide/16 v14, 202
    cmp-long v1, v12, v14
    if-nez v1, +01ch
    const/16 v1, 20
    if-ge v4, v1, +018h
    iput-object v11, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$0 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$1 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->L$2 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->I$0 I
    iput v6, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchLocalArtifactUrls$1;->label I
    const-wide/16 v12, 2000
    invoke-static v12, v13, v2, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, -1d1h
    return-object v3
    add-int/2addr v4, v7
    goto/16 -0dbh
    return-object v10
    instance-of v1, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +003h
    return-object v10
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    return-object v1
.end method

.method private final fetchRemoteResourceUrls(java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    const/4 v3, 1
    if-eqz v2, +018h
    if-ne v2, v3, +00eh
    iget-object v7, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/util/List;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +5ch
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v7
    check-cast v8, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v8
    invoke-interface v8, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v7
    return-object v7
    invoke-direct v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getResourceUploadApi()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v2
    new-instance v4, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    sget-object v5, Lcom/bytedance/trae/conversation/fileupload/BizType;->RemoteResource Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v4, v8, v5, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->L$0 Ljava/lang/Object;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchRemoteResourceUrls$1;->label I
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->getResourceUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v0, v6
    check-cast v8, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;->getUrlMap()Ljava/util/Map;
    move-result-object v8
    check-cast v7, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02bh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    if-nez v3, +003h
    goto +16h
    invoke-interface v8, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +00bh
    invoke-interface v8, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    goto +5h
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    if-eqz v4, -029h
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2eh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v7
    return-object v7
.end method

.method private final getImageUploadApi()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->imageUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    return-object v0
.end method

.method private final getResourceUploadApi()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resourceUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    return-object v0
.end method

.method private static final imageUploadApi_delegate$lambda$1()com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda1;
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda1;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final imageUploadApi_delegate$lambda$1$lambda$0()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final indicatorFileName(java.lang.String  int)java.lang.String
    .registers 6
    # ins_size=3
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->displayNameForIndex(I)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +040h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    const-string v1, "local_uri"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +010h
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v0
    const-string v2, "parse(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->queryDisplayName(Landroid/net/Uri;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +024h
    const/16 v0, 63
    const/4 v2, 2
    invoke-static v4, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const/16 v0, 47
    invoke-static v4, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const/16 v0, 92
    invoke-static v4, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +006h
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fallbackImageFileName(I)Ljava/lang/String;
    move-result-object v4
    move-object v0, v4
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method private final isLocalUri(java.lang.String)boolean
    .registers 6
    # ins_size=2
    const-string v0, "content://"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +00ah
    const-string v0, "file://"
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    const/4 v1, 1
    return v1
.end method

.method private final normalizeFilePath(java.lang.String  java.lang.String)java.lang.String
    .registers 11
    # ins_size=3
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    const-string/jumbo v3, substring(...)
    const/4 v4, 0
    const-string v5, "/"
    const/4 v6, 2
    if-nez v0, +059h
    invoke-static v10, v5, v2, v6, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    move-object v0, v10
    goto +14h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v7, 47
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v10, v5, v2, v6, v4, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +006h
    invoke-static v10, v1, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v10
    new-array v7, v6, [Ljava/lang/String;
    aput-object v0, v7, v2
    aput-object v10, v7, v1
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +020h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    invoke-static v9, v0, v2, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, -010h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v10
    invoke-virtual v9, v10, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v9, v5, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v9
    return-object v9
    invoke-static v9, v5, v2, v6, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +009h
    invoke-virtual v9, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v9
.end method

.method static synthetic normalizeFilePath$default(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  java.lang.String  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final normalizeRemoteResourceId(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-eqz v3, +00dh
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    if-nez v3, +004h
    const-string v3, ""
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, trae-res://remote_resource/
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v3, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v3
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    move-object v0, v3
    return-object v0
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->finish()V
    return-void 
.end method

.method private static final onCreate$lambda$6(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->downloadCurrentImage()V
    return-void 
.end method

.method private final queryDisplayName(android.net.Uri)java.lang.String
    .registers 11
    # ins_size=2
    const-string v0, "_display_name"
    invoke-virtual v10, Landroid/net/Uri;->getScheme()Ljava/lang/String;
    move-result-object v1
    const-string v2, "content"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 0
    if-nez v1, +003h
    return-object v2
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v3
    filled-new-array v0, [Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    move-object v4, v10
    invoke-virtual/range v3 ... v8, Landroid/content/ContentResolver;->query(Landroid/net/Uri; [Ljava/lang/String; Ljava/lang/String; [Ljava/lang/String; Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v10
    if-eqz v10, +022h
    check-cast v10, Ljava/io/Closeable;
    move-object v1, v10
    check-cast v1, Landroid/database/Cursor;
    invoke-interface v1, Landroid/database/Cursor;->moveToFirst()Z
    move-result v3
    if-eqz v3, +00bh
    invoke-interface v1, v0, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I
    move-result v0
    invoke-interface v1, v0, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v2
    invoke-static v10, v2, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    goto +9h
    move-exception v0
    throw v0
    move-exception v1
    invoke-static v10, v0, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v1
    move-object v0, v2
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    goto +ch
    move-exception v10
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v10, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    invoke-static v10, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    move-object v10, v2
    check-cast v10, Ljava/lang/String;
    if-eqz v10, +00eh
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v2, v10
    return-object v2
    :try_start_0x10
    :try_start_0x29
    :try_start_0x3c
    :try_start_0x41
    :try_start_0x43
.end method

.method private static final resourceUploadApi_delegate$lambda$3()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda2;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final resourceUploadApi_delegate$lambda$3$lambda$2()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final sanitizeImageFileName(java.lang.String  int)java.lang.String
    .registers 6
    # ins_size=3
    const/4 v0, 0
    if-eqz v4, +025h
    const/16 v1, 63
    const/4 v2, 2
    invoke-static v4, v1, v0, v2, v0, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +01ch
    const/16 v1, 47
    invoke-static v4, v1, v0, v2, v0, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +014h
    const/16 v1, 92
    invoke-static v4, v1, v0, v2, v0, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +00ch
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v4, ""
    if-nez v0, +003h
    move-object v0, v4
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fallbackImageFileName(I)Ljava/lang/String;
    move-result-object v4
    return-object v4
    const/16 v1, 46
    invoke-static v0, v1, v4, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->IMAGE_EXTENSIONS Ljava/util/Set;
    invoke-interface v1, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fallbackImageFileName(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final setTopBarVisible(boolean)void
    .registers 14
    # ins_size=2
    iget-boolean v0, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->isTopBarVisible Z
    if-ne v0, v13, +003h
    return-void 
    iput-boolean v13, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->isTopBarVisible Z
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBarAnimator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewPager
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroidx/viewpager2/widget/ViewPager2;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    const-string v2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;
    iget v4, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    const/4 v2, 0
    if-eqz v13, +00eh
    invoke-virtual v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_multi_image_preview_title_bar_height I
    invoke-virtual v3, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    move v10, v3
    goto +2h
    move v10, v2
    iget-object v3, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBar Landroid/view/View;
    const-string/jumbo v5, topBar
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    invoke-virtual v3, Landroid/view/View;->getAlpha()F
    move-result v8
    if-eqz v13, +005h
    const/high16 v3, 1065353216
    goto +2h
    const/4 v3, 0
    move v11, v3
    if-eqz v13, +00eh
    iget-object v3, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBar Landroid/view/View;
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    invoke-virtual v1, v2, Landroid/view/View;->setVisibility(I)V
    const/4 v1, 2
    new-array v1, v1, [F
    fill-array-data v1, +0000038h
    invoke-static v1, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v1
    const-wide/16 v2, 250
    invoke-virtual v1, v2, v3, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v2, Landroid/view/animation/DecelerateInterpolator;
    invoke-direct v2, Landroid/view/animation/DecelerateInterpolator;-><init>()V
    check-cast v2, Landroid/animation/TimeInterpolator;
    invoke-virtual v1, v2, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;
    move-object v3, v2
    move v5, v10
    move-object v6, v0
    move-object v7, v12
    move v9, v11
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda0;-><init>(I I Landroid/view/ViewGroup$MarginLayoutParams; Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; F F)V
    invoke-virtual v1, v2, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    new-instance v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;
    move-object v3, v2
    move-object v4, v0
    move-object v6, v12
    move v7, v11
    move v8, v13
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setTopBarVisible$1$2;-><init>(Landroid/view/ViewGroup$MarginLayoutParams; I Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; F Z)V
    check-cast v2, Landroid/animation/Animator$AnimatorListener;
    invoke-virtual v1, v2, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V
    invoke-virtual v1, Landroid/animation/ValueAnimator;->start()V
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBarAnimator Landroid/animation/ValueAnimator;
    return-void 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method private static final setTopBarVisible$lambda$8$lambda$7(int  int  android.view.ViewGroup$MarginLayoutParams  com.bytedance.trae.conversation.products.MultiImagePreviewActivity  float  float  android.animation.ValueAnimator)void
    .registers 8
    # ins_size=7
    const-string v0, "animator"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v7
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Ljava/lang/Float;
    invoke-virtual v7, Ljava/lang/Float;->floatValue()F
    move-result v7
    sub-int/2addr v2, v1
    int-to-float v2, v2
    mul-float/2addr v2, v7
    float-to-int v2, v2
    add-int/2addr v1, v2
    iput v1, v3, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin I
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    const/4 v2, 0
    if-nez v1, +009h
    const-string/jumbo v1, viewPager
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Landroidx/viewpager2/widget/ViewPager2;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBar Landroid/view/View;
    if-nez v1, +009h
    const-string/jumbo v1, topBar
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v1
    sub-float/2addr v6, v5
    mul-float/2addr v6, v7
    add-float/2addr v5, v6
    invoke-virtual v2, v5, Landroid/view/View;->setAlpha(F)V
    return-void 
.end method

.method private final setupViewPager()void
    .registers 6
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-direct v0, v5, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    const/4 v2, 0
    const-string/jumbo v3, viewPager
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v1, v0, Landroidx/viewpager2/widget/ViewPager2;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget v1, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    const/4 v4, 0
    invoke-virtual v0, v1, v4, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItem(I Z)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setupViewPager$1;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$setupViewPager$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    check-cast v0, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;
    invoke-virtual v2, v0, Landroidx/viewpager2/widget/ViewPager2;->registerOnPageChangeCallback(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V
    return-void 
.end method

.method private final toggleTopBar()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->isTopBarVisible Z
    xor-int/lit8 v0, v0, 1
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->setTopBarVisible(Z)V
    return-void 
.end method

.method private final updateIndicator()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    iget v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-nez v0, +003h
    return-void 
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->tvIndicator Landroid/widget/TextView;
    if-nez v1, +009h
    const-string/jumbo v1, tvIndicator
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    iget v2, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->indicatorFileName(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_MultiImagePreviewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method public getDecorViewBackgroundColor()int
    .registers 2
    # ins_size=1
    const/high16 v0, -16777216
    return v0
.end method

.method public isLightStatusBar()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v5, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_multi_image_preview I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->setContentView(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_chat_session_id"
    invoke-virtual v5, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v0, ""
    if-nez v5, +003h
    move-object v5, v0
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->chatSessionId Ljava/lang/String;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v1, "extra_cli_type"
    invoke-virtual v5, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v0
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->cliType Ljava/lang/String;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v1, "extra_message_id"
    invoke-virtual v5, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    move-object v5, v0
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->messageId Ljava/lang/String;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v1, "extra_conversation_id"
    invoke-virtual v5, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v0, v5
    iput-object v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_created_time"
    const-wide/16 v1, 0
    invoke-virtual v5, v0, v1, v2, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v0
    iput-wide v0, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->createdTime J
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_paths"
    invoke-virtual v5, v0, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v5
    if-eqz v5, +005h
    check-cast v5, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_display_names"
    invoke-virtual v5, v0, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v5
    if-eqz v5, +005h
    check-cast v5, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->displayNames Ljava/util/List;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_current_index"
    const/4 v1, 0
    invoke-virtual v5, v0, v1, Landroid/content/Intent;->getIntExtra(Ljava/lang/String; I)I
    move-result v5
    iput v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->currentIndex I
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v5
    const-string v0, "extra_resolve_mode"
    invoke-virtual v5, v0, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v0, "artifact"
    if-nez v5, +003h
    move-object v5, v0
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->paths Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v5
    if-eqz v5, +006h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->finish()V
    return-void 
    sget v5, Lcom/bytedance/trae/conversation/R$id;->view_pager I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v2, "findViewById(...)"
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroidx/viewpager2/widget/ViewPager2;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->topBar Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/ImageView;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->btnBack Landroid/widget/ImageView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/FrameLayout;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->btnDownload Landroid/widget/FrameLayout;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tv_indicator I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->tvIndicator Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tv_generated_by_ai I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->tvGeneratedByAi Landroid/widget/TextView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/ProgressBar;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->progressBar Landroid/widget/ProgressBar;
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->btnBack Landroid/widget/ImageView;
    const/4 v2, 0
    if-nez v5, +008h
    const-string v5, "btnBack"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    new-instance v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda6;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    invoke-virtual v5, v3, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->btnDownload Landroid/widget/FrameLayout;
    if-nez v5, +008h
    const-string v5, "btnDownload"
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v2
    new-instance v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda7;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    invoke-virtual v5, v3, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->tvGeneratedByAi Landroid/widget/TextView;
    if-nez v5, +009h
    const-string/jumbo v5, tvGeneratedByAi
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v5
    iget-object v5, v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->resolveMode Ljava/lang/String;
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    const/16 v1, 8
    invoke-virtual v2, v1, Landroid/widget/TextView;->setVisibility(I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->setupViewPager()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->updateIndicator()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->fetchAllImageUrls()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->com_bytedance_trae_conversation_products_MultiImagePreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)V
    return-void 
.end method
