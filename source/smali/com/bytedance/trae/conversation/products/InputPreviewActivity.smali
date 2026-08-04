# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "InputPreviewActivity.kt"

.field private static final ANIM_DURATION:J
.field private static final CODE_EXTENSIONS:Ljava/util/Set;
.field public static final Companion:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;
.field private static final DOUBLE_TAP_SCALE:F
.field private static final DOWNLOAD_URL_MAX_RETRIES:I
.field private static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_FILE_NAME:Ljava/lang/String;
.field private static final EXTRA_MESSAGE_ID:Ljava/lang/String;
.field private static final EXTRA_MODE:Ljava/lang/String;
.field private static final EXTRA_OID_ID:Ljava/lang/String;
.field private static final HTML_EXTENSIONS:Ljava/util/Set;
.field private static final IMAGE_EXTENSIONS:Ljava/util/Set;
.field private static final MARKDOWN_EXTENSIONS:Ljava/util/Set;
.field private static final MAX_SCALE:F
.field private static final MIN_SCALE:F
.field private static final REMOTE_RESOURCE_PREFIX:Ljava/lang/String;
.field private static final TXT_EXTENSIONS:Ljava/util/Set;
.field private activePointerId:I
.field private btnBack:Landroid/widget/ImageView;
.field private btnDownload:Landroid/view/View;
.field private btnMainDownload:Landroid/widget/TextView;
.field private chatSessionId:Ljava/lang/String;
.field private cliType:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private currentScale:F
.field private final downloadFinishCallback:Lkotlin/jvm/functions/Function3;
.field private downloadStatusTitle:Landroid/widget/TextView;
.field private extraOidId:Ljava/lang/String;
.field private final fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field private fileName:Ljava/lang/String;
.field private fileType:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field private fileUrl:Ljava/lang/String;
.field private final gestureDetector$delegate:Lkotlin/Lazy;
.field private imageContainer:Landroid/widget/FrameLayout;
.field private isDragging:Z
.field private ivPreview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private lastTouchX:F
.field private lastTouchY:F
.field private layoutContent:Landroid/widget/LinearLayout;
.field private loadingDialog:Landroid/app/Dialog;
.field private messageId:Ljava/lang/String;
.field private mode:Ljava/lang/String;
.field private needDecode:Z
.field private oidId:Ljava/lang/String;
.field private progressBar:Landroid/widget/ProgressBar;
.field private final resourceUploadApi$delegate:Lkotlin/Lazy;
.field private scaleAnimator:Landroid/animation/ValueAnimator;
.field private final scaleGestureDetector$delegate:Lkotlin/Lazy;
.field private scrollMarkdown:Landroid/widget/ScrollView;
.field private scrollTxt:Landroid/widget/ScrollView;
.field private tvMarkdown:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field private tvTitle:Landroid/widget/TextView;
.field private tvTxt:Landroid/widget/TextView;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$-0TET6ix7f8yEIAeFwuNr9qoNP4(float  float  com.bytedance.trae.conversation.products.InputPreviewActivity  float  float  float  float  android.animation.ValueAnimator)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->animateToScale$lambda$21$lambda$20(F F Lcom/bytedance/trae/conversation/products/InputPreviewActivity; F F F F Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$0KonWTdURsqVfSe7Ylo-KNq3YS0(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupBtnDownload$lambda$17(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$5_tdiRjxr3fbXWtWCfNYyk8mHEY(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showError$lambda$16(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$9_dbB31n3BOKNh7iAIv6pKk0sy4(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupDownloadButtons$lambda$18(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$HRYfXEJpQNnCAQ4lbzWliUipSwI(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupImageTouchHandling$lambda$19(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$JGKzE7DbEhdx6nyEQ5n6zJLALVE(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchTextViaTTNet$lambda$8(Ljava/lang/String; Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$M-MxXWaeFCnyZxL-6YdfDvdV7yg(com.bytedance.trae.conversation.products.InputPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadFinishCallback$lambda$2(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$P8KHQ6li9e4KJbDS-XGPOXu2E1s(com.bytedance.trae.conversation.products.InputPreviewActivity)android.view.ScaleGestureDetector
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scaleGestureDetector_delegate$lambda$3(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/view/ScaleGestureDetector;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$clXmf8wk087UnqnYB2db7GclqKA(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showDownloadOnly$lambda$13(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gAclMJcV62lmxbds3wmnEhrwZU4()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->resourceUploadApi_delegate$lambda$1$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pRyyzPcLCZxNRTym3o41wzxF1jM(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->onCreate$lambda$5(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$qTC848Z-uMoL2ZT4ot1yNpWC8nQ(com.bytedance.trae.conversation.products.InputPreviewActivity)android.view.GestureDetector
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->gestureDetector_delegate$lambda$4(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)Landroid/view/GestureDetector;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rWANQGEzv6Yfqb4MpRMWuieKU2E()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->resourceUploadApi_delegate$lambda$1()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 62
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/InputPreviewActivity$Companion;
    const-string v2, "png"
    const-string v3, "jpg"
    const-string v4, "jpeg"
    const-string v5, "gif"
    const-string v6, "bmp"
    const-string/jumbo v7, webp
    const-string v8, "heif"
    const-string v9, "heic"
    filled-new-array/range v2 ... v9, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->IMAGE_EXTENSIONS Ljava/util/Set;
    const-string v0, "markdown"
    const-string v1, "mdx"
    const-string v2, "md"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->MARKDOWN_EXTENSIONS Ljava/util/Set;
    const-string v1, "kt"
    const-string v2, "java"
    const-string v3, "py"
    const-string v4, "js"
    const-string/jumbo v5, ts
    const-string/jumbo v6, tsx
    const-string v7, "jsx"
    const-string v8, "c"
    const-string v9, "cpp"
    const-string v10, "h"
    const-string v11, "hpp"
    const-string v12, "cs"
    const-string v13, "go"
    const-string/jumbo v14, rs
    const-string v15, "rb"
    const-string v16, "php"
    const-string/jumbo v17, swift
    const-string v18, "m"
    const-string v19, "mm"
    const-string/jumbo v20, scala
    const-string v21, "groovy"
    const-string/jumbo v22, sh
    const-string v23, "bash"
    const-string/jumbo v24, zsh
    const-string v25, "bat"
    const-string v26, "ps1"
    const-string v27, "pl"
    const-string v28, "lua"
    const-string v29, "r"
    const-string/jumbo v30, sql
    const-string v31, "css"
    const-string/jumbo v32, scss
    const-string v33, "less"
    const-string/jumbo v34, sass
    const-string/jumbo v35, xml
    const-string v36, "json"
    const-string/jumbo v37, yaml
    const-string/jumbo v38, yml
    const-string/jumbo v39, toml
    const-string v40, "ini"
    const-string v41, "cfg"
    const-string v42, "conf"
    const-string v43, "properties"
    const-string v44, "gradle"
    const-string v45, "cmake"
    const-string v46, "makefile"
    const-string v47, "dockerfile"
    const-string v48, "dart"
    const-string/jumbo v49, vue
    const-string/jumbo v50, svelte
    const-string/jumbo v51, zig
    const-string v52, "nim"
    const-string v53, "ex"
    const-string v54, "exs"
    const-string v55, "erl"
    const-string v56, "hs"
    const-string v57, "ml"
    const-string v58, "mli"
    const-string v59, "clj"
    const-string v60, "cljs"
    const-string v61, "elm"
    filled-new-array/range v1 ... v61, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->CODE_EXTENSIONS Ljava/util/Set;
    const-string v0, "csv"
    const-string/jumbo v1, tsv
    const-string/jumbo v2, txt
    const-string v3, "log"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->TXT_EXTENSIONS Ljava/util/Set;
    const-string v0, "htm"
    const-string/jumbo v1, xhtml
    const-string v2, "html"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->HTML_EXTENSIONS Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->extraOidId Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->chatSessionId Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->messageId Ljava/lang/String;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda11;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda11;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->resourceUploadApi$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda12;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    new-instance v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    const/high16 v0, 1065353216
    iput v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->currentScale F
    const/4 v0, -1
    iput v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->activePointerId I
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scaleGestureDetector$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda2;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->gestureDetector$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$animateToScale(com.bytedance.trae.conversation.products.InputPreviewActivity  float)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->animateToScale(F)V
    return-void 
.end method

.method public static final synthetic access$buildCodeHighlightHtml(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->buildCodeHighlightHtml(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$downloadAndShowTxt(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadAndShowTxt(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$fetchAssetDownloadUrlWithRetry(com.bytedance.trae.conversation.products.InputPreviewActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchAssetDownloadUrlWithRetry(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchFileUrl(com.bytedance.trae.conversation.products.InputPreviewActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchFileUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchRemoteResourceUrl(com.bytedance.trae.conversation.products.InputPreviewActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchRemoteResourceUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchTextViaTTNet(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchTextViaTTNet(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchUrl(com.bytedance.trae.conversation.products.InputPreviewActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.products.InputPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCurrentScale$p(com.bytedance.trae.conversation.products.InputPreviewActivity)float
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->currentScale F
    return v0
.end method

.method public static final synthetic access$getDownloadFinishCallback$p(com.bytedance.trae.conversation.products.InputPreviewActivity)kotlin.jvm.functions.Function3
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public static final synthetic access$getExtraOidId$p(com.bytedance.trae.conversation.products.InputPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->extraOidId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getFileDownloadHelper$p(com.bytedance.trae.conversation.products.InputPreviewActivity)com.bytedance.trae.conversation.products.FileDownloadHelper
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-object v0
.end method

.method public static final synthetic access$getFileName$p(com.bytedance.trae.conversation.products.InputPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getFileType$p(com.bytedance.trae.conversation.products.InputPreviewActivity)com.bytedance.trae.conversation.products.InputPreviewActivity$FileType
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileType Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    return-object v0
.end method

.method public static final synthetic access$getFileUrl$p(com.bytedance.trae.conversation.products.InputPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileUrl Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getImageContainer$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.widget.FrameLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    return-object v0
.end method

.method public static final synthetic access$getIvPreview$p(com.bytedance.trae.conversation.products.InputPreviewActivity)com.facebook.drawee.view.SimpleDraweeView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method public static final synthetic access$getNeedDecode$p(com.bytedance.trae.conversation.products.InputPreviewActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->needDecode Z
    return v0
.end method

.method public static final synthetic access$getOidId$p(com.bytedance.trae.conversation.products.InputPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getResourceUploadApi(com.bytedance.trae.conversation.products.InputPreviewActivity)com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getResourceUploadApi()Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getScaleAnimator$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.animation.ValueAnimator
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scaleAnimator Landroid/animation/ValueAnimator;
    return-object v0
.end method

.method public static final synthetic access$getScrollMarkdown$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.widget.ScrollView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scrollMarkdown Landroid/widget/ScrollView;
    return-object v0
.end method

.method public static final synthetic access$getScrollTxt$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.widget.ScrollView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scrollTxt Landroid/widget/ScrollView;
    return-object v0
.end method

.method public static final synthetic access$getTvMarkdown$p(com.bytedance.trae.conversation.products.InputPreviewActivity)com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    return-object v0
.end method

.method public static final synthetic access$getTvTxt$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvTxt Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.products.InputPreviewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$hideLoadingDialog(com.bytedance.trae.conversation.products.InputPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->hideLoadingDialog()V
    return-void 
.end method

.method public static final synthetic access$loadImage(com.bytedance.trae.conversation.products.InputPreviewActivity  android.net.Uri)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadImage(Landroid/net/Uri;)V
    return-void 
.end method

.method public static final synthetic access$loadMarkdownPreview(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadMarkdownPreview(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$openFileWithExternalApp(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->openFileWithExternalApp(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$setCurrentScale$p(com.bytedance.trae.conversation.products.InputPreviewActivity  float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->currentScale F
    return-void 
.end method

.method public static final synthetic access$setDragging$p(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->isDragging Z
    return-void 
.end method

.method public static final synthetic access$setFileUrl$p(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileUrl Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setupImageTouchHandling(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupImageTouchHandling(Landroid/view/View;)V
    return-void 
.end method

.method public static final synthetic access$showCodePreview(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showCodePreview(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showDownloadWithUrl(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showDownloadWithUrl(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showError(com.bytedance.trae.conversation.products.InputPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showError()V
    return-void 
.end method

.method public static final synthetic access$showImagePreview(com.bytedance.trae.conversation.products.InputPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showImagePreview(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showLoadingDialog(com.bytedance.trae.conversation.products.InputPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showLoadingDialog()V
    return-void 
.end method

.method private final animateToScale(float)void
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scaleAnimator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    iget v2, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->currentScale F
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v1, 0
    const-string v3, "ivPreview"
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationX()F
    move-result v5
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationY()F
    move-result v7
    const/high16 v0, 1065353216
    cmpg-float v0, v11, v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    const/4 v1, 0
    if-eqz v0, +004h
    move v6, v1
    goto +2h
    move v6, v5
    if-eqz v0, +004h
    move v8, v1
    goto +2h
    move v8, v7
    const/4 v0, 2
    new-array v0, v0, [F
    fill-array-data v0, +0000028h
    invoke-static v0, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;
    move-result-object v0
    const-wide/16 v3, 250
    invoke-virtual v0, v3, v4, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;
    invoke-direct v1, Landroid/view/animation/DecelerateInterpolator;-><init>()V
    check-cast v1, Landroid/animation/TimeInterpolator;
    invoke-virtual v0, v1, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V
    new-instance v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;
    move-object v1, v9
    move v3, v11
    move-object v4, v10
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda5;-><init>(F F Lcom/bytedance/trae/conversation/products/InputPreviewActivity; F F F F)V
    invoke-virtual v0, v9, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scaleAnimator Landroid/animation/ValueAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method private static final animateToScale$lambda$21$lambda$20(float  float  com.bytedance.trae.conversation.products.InputPreviewActivity  float  float  float  float  android.animation.ValueAnimator)void
    .registers 10
    # ins_size=8
    const-string v0, "animator"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;
    move-result-object v9
    const-string v0, "null cannot be cast to non-null type kotlin.Float"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Ljava/lang/Float;
    invoke-virtual v9, Ljava/lang/Float;->floatValue()F
    move-result v9
    sub-float/2addr v3, v2
    mul-float/2addr v3, v9
    add-float/2addr v2, v3
    iput v2, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->currentScale F
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v0, 0
    const-string v1, "ivPreview"
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleX(F)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleY(F)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    sub-float/2addr v6, v5
    mul-float/2addr v6, v9
    add-float/2addr v5, v6
    invoke-virtual v2, v5, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v2
    sub-float/2addr v8, v7
    mul-float/2addr v8, v9
    add-float/2addr v7, v8
    invoke-virtual v0, v7, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationY(F)V
    return-void 
.end method

.method private final buildCodeHighlightHtml(java.lang.String  java.lang.String)java.lang.String
    .registers 15
    # ins_size=3
    const-string v1, "&"
    const-string v2, "&amp;"
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v13
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "<"
    const-string v8, "&lt;"
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string v1, ">"
    const-string v2, "&gt;"
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    const-string v7, """
    const-string v8, "&quot;"
    invoke-static/range v6 ... v11, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "
            <!DOCTYPE html>
            <html>
            <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/github.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"></script>
            <style>
                body { margin: 0; padding: 12px; background: #F5F6F8; }
                pre { margin: 0; white-space: pre-wrap; word-wrap: break-word; }
                code { font-size: 13px; line-height: 1.5; font-family: monospace; }
            </style>
            </head>
            <body>
            <pre><code class="language-"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v0, "">"
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v14, "</code></pre>
            <script>hljs.highlightAll();</script>
            </body>
            </html>
        "
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v13
    invoke-static v13, Lkotlin/text/StringsKt;->trimIndent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method

.method public static com_bytedance_trae_conversation_products_InputPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.InputPreviewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->com_bytedance_trae_conversation_products_InputPreviewActivity__onStop$___twin___()V
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

.method private final downloadAndShowTxt(java.lang.String)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$downloadAndShowTxt$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final downloadFinishCallback$lambda$2(com.bytedance.trae.conversation.products.InputPreviewActivity  int  java.lang.String  long)kotlin.Unit
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
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getString(I)Ljava/lang/String;
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
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final fetchAssetDownloadUrlWithRetry(kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=2
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->label I
    const-string v5, "conversationId"
    const/4 v6, 2
    const-string v7, "InputPreviewActivity"
    const/4 v8, 1
    if-eqz v4, +02eh
    if-eq v4, v8, +01dh
    if-ne v4, v6, +013h
    iget v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->I$0 I
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v1, v10
    move-object v10, v11
    goto/16 +101h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->I$0 I
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +089h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v4, "asset"
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v4, +008h
    const-string v4, "oidId"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v10, "fetchAssetDownloadUrlWithRetry: target="
    invoke-direct v4, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v10, ", conversationId="
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v10, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v10, ", messageId="
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->messageId Ljava/lang/String;
    invoke-virtual v4, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v7, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    const/4 v4, 0
    move-object v10, v0
    const/16 v11, 31
    if-ge v4, v11, +0feh
    sget-object v11, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v15, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v13
    iget-object v12, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v12, +007h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v14, 0
    goto +2h
    move-object v14, v12
    iget-object v12, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->messageId Ljava/lang/String;
    const/16 v16, 0
    const/16 v17, 8
    const/16 v18, 0
    move-object/from16 v19, v12
    move-object v12, v15
    move-object v9, v15
    move-object/from16 v15, v19
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->I$0 I
    iput v8, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->label I
    invoke-virtual v11, v9, v2, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v3, +003h
    return-object v3
    move-object v11, v10
    move-object v10, v1
    move-object v1, v9
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v9, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string v12, ", msg="
    if-eqz v9, +08eh
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v9, +00fh
    invoke-virtual v9, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v9
    if-eqz v9, +009h
    invoke-interface v9, v10, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    goto +2h
    const/4 v9, 0
    if-eqz v9, +01eh
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v1, +010h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v1
    if-eqz v1, +00ah
    invoke-interface v1, v10, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Ljava/lang/String;
    goto +2h
    const/4 v9, 0
    return-object v9
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v13
    const-wide/16 v15, 202
    cmp-long v9, v13, v15
    if-nez v9, +016h
    iput-object v11, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->I$0 I
    iput v6, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchAssetDownloadUrlWithRetry$1;->label I
    const-wide/16 v12, 2000
    invoke-static v12, v13, v2, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, -100h
    return-object v3
    add-int/2addr v4, v8
    goto/16 -09bh
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "fetchAssetDownloadUrlWithRetry: unexpected code="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v13, v14, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +00ah
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v1, 0
    return-object v1
    instance-of v2, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +02bh
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "fetchAssetDownloadUrlWithRetry: error code="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v1
    invoke-static v7, v2, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto -2eh
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    const/4 v1, 0
    return-object v1
.end method

.method private final fetchFileUrl(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->extraOidId Ljava/lang/String;
    const-string/jumbo v1, trae-res://remote_resource/
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +009h
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->needDecode Z
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchRemoteResourceUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +027h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    sget-object v5, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +019h
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->needDecode Z
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->extraOidId Ljava/lang/String;
    const-string/jumbo v1, trae-res:
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +007h
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchAssetDownloadUrlWithRetry(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchRemoteResourceUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileType Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    if-nez v0, +008h
    const-string v0, "fileType"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v4
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->IMAGE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    if-ne v0, v3, +022h
    sget-object v0, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v3, +008h
    const-string v3, "oidId"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v3
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->get(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +008h
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    move v2, v1
    if-nez v2, +003h
    return-object v0
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fetchUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method private final fetchRemoteResourceUrl(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "oidId"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-nez v0, +01dh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->extraOidId Ljava/lang/String;
    const-string/jumbo v2, trae-res://remote_resource/
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v0, v2, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-nez v0, +003h
    return-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;
    invoke-direct v3, v4, v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchRemoteResourceUrl$2;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    invoke-static v2, v3, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    return-object v5
.end method

.method private final fetchTextViaTTNet(java.lang.String)java.lang.String
    .registers 9
    # ins_size=2
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->needDecode Z
    const-string v1, ""
    const-string v2, "in(...)"
    const-string v3, "execute(...)"
    const-string v4, "https://placeholder.trae/"
    const/4 v5, 0
    if-nez v0, +038h
    invoke-static v4, v5, v5, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;
    invoke-virtual v0, v4, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;
    if-nez v0, +003h
    return-object v5
    invoke-interface v0, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;->get(Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v8
    invoke-interface v8, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v8
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v8, +003h
    return-object v1
    invoke-interface v8, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v8
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->readAllBytes(Ljava/io/InputStream;)[B
    move-result-object v8
    new-instance v0, Ljava/lang/String;
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v8, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v0
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    new-instance v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda8;
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda8;-><init>(Ljava/lang/String;)V
    invoke-interface v0, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v4, v0, v5, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v0
    const-class v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;
    invoke-virtual v0, v4, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;
    if-nez v0, +003h
    return-object v5
    invoke-interface v0, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FetchApi;->get(Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v8
    invoke-interface v8, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v8
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v8, +003h
    return-object v1
    invoke-interface v8, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v8
    invoke-static v8, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->readAllBytes(Ljava/io/InputStream;)[B
    move-result-object v8
    new-instance v0, Ljava/lang/String;
    invoke-static v8, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v8
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v8, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v0
.end method

.method private static final fetchTextViaTTNet$lambda$8(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 5
    # ins_size=2
    if-eqz v4, +038h
    invoke-interface v4, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +003h
    goto +30h
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getUrl()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri$Builder;->clearQuery()Landroid/net/Uri$Builder;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v1, Landroid/net/Uri;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toString(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, v3, Lcom/bytedance/retrofit2/client/Request$Builder;->url(Ljava/lang/String;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v3
    invoke-interface v4, v3, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v3
    return-object v3
    const/4 v3, 0
    return-object v3
.end method

.method private final fetchUrl(kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->label I
    const-string v5, ", fileName="
    const-string v6, "InputPreviewActivity"
    const-string v7, "fileName"
    const-string v8, "oidId"
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v4, +014h
    if-ne v4, v9, +00ah
    iget-object v2, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +53h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->chatSessionId Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +02fh
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "fetchUrl: chatSessionId is blank, oidId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v3, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v10
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v3, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v10
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v10
    sget-object v1, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->chatSessionId Ljava/lang/String;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->L$0 Ljava/lang/Object;
    iput v9, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$fetchUrl$1;->label I
    invoke-virtual v1, v4, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v2, v0
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v3, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v3, +151h
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v3, +107h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +101h
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/2addr v4, v9
    if-eqz v4, +003h
    goto +2h
    move-object v3, v10
    if-nez v3, +004h
    goto/16 +0f1h
    const-string v4, "/"
    const/4 v5, 0
    const/4 v6, 2
    invoke-static v3, v4, v5, v6, v10, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    const/16 v5, 47
    if-eqz v4, +003h
    goto +12h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v10
    invoke-static v4, v5, v10, v6, v10, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const/16 v8, 46
    invoke-static v4, v8, v10, v6, v10, Lkotlin/text/StringsKt;->substringBeforeLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getUploadsPath()Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ".uploads"
    iget-object v2, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v2, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v10
    const-string v7, "UTF-8"
    invoke-static v2, v7, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    const-string v2, "encode(...)"
    invoke-static v11, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v12, "+"
    const-string v13, "%20"
    const/4 v14, 0
    const/4 v15, 4
    const/16 v16, 0
    invoke-static/range v11 ... v16, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v8, "file/"
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v4, 95
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v1, +008h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "/workspace"
    invoke-static v1, v7, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v4, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v3, +006h
    invoke-interface v3, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +004h
    const-string v10, ""
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "Cloud-IDE-JWT "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v7, Ljava/net/URLEncoder;->encode(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v4, "?cwd="
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, "&use_cache=1&authorization="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    return-object v1
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "fetchUrl: explorerUrl is blank, chatSessionId="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->chatSessionId Ljava/lang/String;
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ", oidId="
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v10
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    iget-object v2, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v2, +006h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v10
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v6, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v10
    instance-of v1, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +003h
    return-object v10
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method

.method private static final gestureDetector_delegate$lambda$4(com.bytedance.trae.conversation.products.InputPreviewActivity)android.view.GestureDetector
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/view/GestureDetector;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$gestureDetector$2$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    check-cast v2, Landroid/view/GestureDetector$OnGestureListener;
    invoke-direct v0, v1, v2, Landroid/view/GestureDetector;-><init>(Landroid/content/Context; Landroid/view/GestureDetector$OnGestureListener;)V
    return-object v0
.end method

.method private final getFileType(java.lang.String)com.bytedance.trae.conversation.products.InputPreviewActivity$FileType
    .registers 4
    # ins_size=2
    const/16 v0, 46
    const-string v1, ""
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->IMAGE_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->IMAGE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    goto +2fh
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->MARKDOWN_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->MARKDOWN Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    goto +24h
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->CODE_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->CODE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    goto +19h
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->TXT_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->TXT Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    goto +eh
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->HTML_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->HTML Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->OTHER Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    return-object v3
.end method

.method private final getGestureDetector()android.view.GestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->gestureDetector$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/GestureDetector;
    return-object v0
.end method

.method private final getResourceUploadApi()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->resourceUploadApi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    return-object v0
.end method

.method private final getScaleGestureDetector()android.view.ScaleGestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scaleGestureDetector$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/ScaleGestureDetector;
    return-object v0
.end method

.method private final hideLoadingDialog()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadingDialog Landroid/app/Dialog;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadingDialog Landroid/app/Dialog;
    return-void 
.end method

.method private final loadImage(android.net.Uri)void
    .registers 5
    # ins_size=2
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v0
    invoke-virtual v0, v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v4
    const/4 v0, 1
    invoke-virtual v4, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setAutoPlayAnimations(Z)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v4
    check-cast v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v1, 0
    const-string v2, "ivPreview"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v0
    invoke-virtual v4, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v4
    check-cast v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    check-cast v4, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v1, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method private final loadMarkdownPreview(java.lang.String)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$loadMarkdownPreview$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$loadMarkdownPreview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final onCreate$lambda$5(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->finish()V
    return-void 
.end method

.method private final openFileWithExternalApp(java.lang.String)void
    .registers 6
    # ins_size=2
    new-instance v0, Ljava/io/File;
    invoke-direct v0, v5, Ljava/io/File;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/io/File;->exists()Z
    move-result v1
    if-nez v1, +003h
    return-void 
    const-string v1, ""
    const/16 v2, 46
    invoke-static v5, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;
    move-result-object v1
    invoke-virtual v1, v5, Landroid/webkit/MimeTypeMap;->getMimeTypeFromExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    const-string v5, "application/octet-stream"
    move-object v1, v4
    check-cast v1, Landroid/content/Context;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getPackageName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ".uri.key"
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, v0, Landroidx/core/content/FileProvider;->getUriForFile(Landroid/content/Context; Ljava/lang/String; Ljava/io/File;)Landroid/net/Uri;
    move-result-object v0
    new-instance v1, Landroid/content/Intent;
    const-string v2, "android.intent.action.VIEW"
    invoke-direct v1, v2, Landroid/content/Intent;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, v5, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri; Ljava/lang/String;)Landroid/content/Intent;
    const/4 v5, 1
    invoke-virtual v1, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    const/high16 v5, 268435456
    invoke-virtual v1, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    const/4 v0, 0
    invoke-static v1, v0, Landroid/content/Intent;->createChooser(Landroid/content/Intent; Ljava/lang/CharSequence;)Landroid/content/Intent;
    move-result-object v0
    invoke-virtual v0, v5, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
.end method

.method private final preview()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
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
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$preview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
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

.method private static final resourceUploadApi_delegate$lambda$1()com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi
    .registers 7
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    new-instance v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda4;
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda4;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v6
.end method

.method private static final resourceUploadApi_delegate$lambda$1$lambda$0()java.lang.String
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final scaleGestureDetector_delegate$lambda$3(com.bytedance.trae.conversation.products.InputPreviewActivity)android.view.ScaleGestureDetector
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/view/ScaleGestureDetector;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$scaleGestureDetector$2$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$scaleGestureDetector$2$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    check-cast v2, Landroid/view/ScaleGestureDetector$OnScaleGestureListener;
    invoke-direct v0, v1, v2, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context; Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    return-object v0
.end method

.method private final setupBtnDownload()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnDownload Landroid/view/View;
    if-nez v1, +008h
    const-string v1, "btnDownload"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda9;
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z)V
    invoke-virtual v1, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupBtnDownload$lambda$17(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  android.view.View)void
    .registers 20
    # ins_size=3
    move-object/from16 v0, v17
    move/from16 v1, v18
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileUrl Ljava/lang/String;
    const/4 v3, 0
    if-eqz v2, +05bh
    const-string v4, "fileUrl"
    if-nez v2, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +49h
    iget-object v5, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileUrl Ljava/lang/String;
    if-nez v2, +007h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v3
    goto +2h
    move-object v7, v2
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v2, +009h
    const-string v2, "conversationId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v3
    goto +2h
    move-object v8, v2
    if-eqz v1, +009h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v1, +010h
    const-string v1, "oidId"
    goto +7h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v1, +009h
    const-string v1, "fileName"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v3
    goto +2h
    move-object v9, v1
    move-object v1, v0
    check-cast v1, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v1, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v1
    iget-boolean v12, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->needDecode Z
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    move-object v6, v0
    check-cast v6, Landroid/content/Context;
    move-object v10, v1
    check-cast v10, Lkotlinx/coroutines/CoroutineScope;
    const-wide/16 v13, 0
    const/16 v15, 128
    const/16 v16, 0
    invoke-static/range v5 ... v16, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J I Ljava/lang/Object;)V
    goto +1ah
    move-object v2, v0
    check-cast v2, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v2, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;
    invoke-direct v2, v0, v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$setupBtnDownload$1$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Lkotlin/coroutines/Continuation;)V
    move-object v7, v2
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final setupDownloadButtons(java.lang.String)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +012h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    new-instance v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnDownload Landroid/view/View;
    const/4 v0, 0
    if-nez v3, +008h
    const-string v3, "btnDownload"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v3, +008h
    const-string v3, "btnMainDownload"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v3
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupDownloadButtons$lambda$18(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  java.lang.String  android.view.View)void
    .registers 16
    # ins_size=4
    iget-object v0, v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v15, v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->conversationId Ljava/lang/String;
    const/4 v1, 0
    if-nez v15, +009h
    const-string v15, "conversationId"
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v1
    goto +2h
    move-object v3, v15
    iget-boolean v7, v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->needDecode Z
    if-eqz v13, +009h
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v13, +010h
    const-string v13, "oidId"
    goto +7h
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v13, +009h
    const-string v13, "fileName"
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v1
    goto +2h
    move-object v4, v13
    move-object v13, v12
    check-cast v13, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v13, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v13
    iget-object v6, v12, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    move-object v1, v12
    check-cast v1, Landroid/content/Context;
    move-object v5, v13
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    const-wide/16 v8, 0
    const/16 v10, 128
    const/4 v11, 0
    move-object v2, v14
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading$default(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J I Ljava/lang/Object;)V
    return-void 
.end method

.method private final setupImageTouchHandling(android.view.View)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda10;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    invoke-virtual v2, v0, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    return-void 
.end method

.method private static final setupImageTouchHandling$lambda$19(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View  android.view.MotionEvent)boolean
    .registers 10
    # ins_size=3
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getScaleGestureDetector()Landroid/view/ScaleGestureDetector;
    move-result-object v8
    invoke-virtual v8, v9, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getGestureDetector()Landroid/view/GestureDetector;
    move-result-object v8
    invoke-virtual v8, v9, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    invoke-virtual v9, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v8
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v8, +09ch
    if-eq v8, v1, +094h
    const/4 v2, 2
    if-eq v8, v2, +03ah
    const/4 v2, 3
    if-eq v8, v2, +08eh
    const/4 v2, 5
    if-eq v8, v2, +030h
    const/4 v2, 6
    if-eq v8, v2, +004h
    goto/16 +0a0h
    invoke-virtual v9, Landroid/view/MotionEvent;->getActionIndex()I
    move-result v8
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v2
    iget v3, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->activePointerId I
    if-ne v2, v3, +094h
    if-nez v8, +003h
    move v0, v1
    invoke-virtual v9, Landroid/view/MotionEvent;->getPointerCount()I
    move-result v8
    if-ge v0, v8, +08bh
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getX(I)F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchX F
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getY(I)F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchY F
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->activePointerId I
    goto/16 +077h
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->isDragging Z
    goto/16 +073h
    iget-boolean v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->isDragging Z
    if-eqz v8, +06fh
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getScaleGestureDetector()Landroid/view/ScaleGestureDetector;
    move-result-object v8
    invoke-virtual v8, Landroid/view/ScaleGestureDetector;->isInProgress()Z
    move-result v8
    if-nez v8, +065h
    iget v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->activePointerId I
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->findPointerIndex(I)I
    move-result v8
    if-ltz v8, +05dh
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->getX(I)F
    move-result v0
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->getY(I)F
    move-result v8
    iget v9, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchX F
    sub-float v9, v0, v9
    iget v2, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchY F
    sub-float v2, v8, v2
    iget v3, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->currentScale F
    const/high16 v4, 1065353216
    cmpl-float v3, v3, v4
    if-lez v3, +026h
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v4, 0
    const-string v5, "ivPreview"
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationX()F
    move-result v6
    add-float/2addr v6, v9
    invoke-virtual v3, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v9, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v9
    invoke-virtual v4, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationY()F
    move-result v9
    add-float/2addr v9, v2
    invoke-virtual v4, v9, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationY(F)V
    iput v0, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchX F
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchY F
    goto +1bh
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->isDragging Z
    const/4 v8, -1
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->activePointerId I
    goto +15h
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->activePointerId I
    invoke-virtual v9, Landroid/view/MotionEvent;->getX()F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchX F
    invoke-virtual v9, Landroid/view/MotionEvent;->getY()F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->lastTouchY F
    iput-boolean v1, v7, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->isDragging Z
    return v1
.end method

.method private final showCodePreview(java.lang.String)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showCodePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final showDownloadOnly()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$1;
    invoke-direct v0, v9, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +011h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v2, 1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnMainDownload"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda7;
    invoke-direct v0, v9, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final showDownloadOnly$lambda$13(com.bytedance.trae.conversation.products.InputPreviewActivity  boolean  android.view.View)void
    .registers 12
    # ins_size=3
    iget-object v11, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +008h
    const-string v1, "fileName"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v11, v0, v1, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExistingFilePath(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-eqz v11, +006h
    invoke-direct v9, v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->openFileWithExternalApp(Ljava/lang/String;)V
    return-void 
    move-object v11, v9
    check-cast v11, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v11, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v11
    move-object v3, v11
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;
    invoke-direct v11, v9, v10, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showDownloadOnly$2$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Z Lkotlin/coroutines/Continuation;)V
    move-object v6, v11
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final showDownloadWithUrl(java.lang.String)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupDownloadButtons(Ljava/lang/String;)V
    return-void 
.end method

.method private final showError()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "downloadStatusTitle"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_connect_error I
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    const-string v2, "btnMainDownload"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_retry I
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda6;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final showError$lambda$16(com.bytedance.trae.conversation.products.InputPreviewActivity  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v2, +008h
    const-string v2, "layoutContent"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->preview()V
    return-void 
.end method

.method private final showImagePreview(java.lang.String)void
    .registers 12
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, showImagePreview:
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "InputPreviewActivity"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v0, "content://"
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v11, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +042h
    const-string v0, "file://"
    invoke-static v11, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +38h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +011h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    sget-object v2, Lcom/bytedance/trae/im/service/Mode;->WORK Lcom/bytedance/trae/im/service/Mode;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    const/4 v1, 1
    move-object v0, v10
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Lkotlinx/coroutines/CoroutineScope;
    const/4 v5, 0
    const/4 v6, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;
    invoke-direct v0, v10, v11, v1, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$showImagePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity; Ljava/lang/String; Z Lkotlin/coroutines/Continuation;)V
    move-object v7, v0
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 3
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnDownload Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "btnDownload"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_trailing_actions I
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    const-string v2, "imageContainer"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v3
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-static v11, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v11
    const-string v0, "parse(...)"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadImage(Landroid/net/Uri;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    if-nez v11, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v11
    check-cast v3, Landroid/view/View;
    invoke-direct v10, v3, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupImageTouchHandling(Landroid/view/View;)V
    return-void 
.end method

.method private final showLoadingDialog()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadingDialog Landroid/app/Dialog;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/app/Dialog;->isShowing()Z
    move-result v0
    if-ne v0, v1, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    return-void 
    new-instance v0, Landroid/widget/ProgressBar;
    move-object v3, v6
    check-cast v3, Landroid/content/Context;
    invoke-direct v0, v3, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setIndeterminate(Z)V
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v3, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    const/16 v4, 24
    int-to-float v4, v4
    invoke-virtual v1, Landroid/widget/FrameLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v4, v5
    float-to-int v4, v4
    invoke-virtual v1, v4, v4, v4, v4, Landroid/widget/FrameLayout;->setPadding(I I I I)V
    check-cast v0, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v5, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 17
    iput v5, v4, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/app/Dialog;
    invoke-direct v0, v3, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/app/Dialog;->setContentView(Landroid/view/View;)V
    invoke-virtual v0, v2, Landroid/app/Dialog;->setCancelable(Z)V
    invoke-virtual v0, Landroid/app/Dialog;->getWindow()Landroid/view/Window;
    move-result-object v1
    if-eqz v1, +008h
    const v2, 17170445
    invoke-virtual v1, v2, Landroid/view/Window;->setBackgroundDrawableResource(I)V
    invoke-virtual v0, Landroid/app/Dialog;->show()V
    iput-object v0, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->loadingDialog Landroid/app/Dialog;
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_InputPreviewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 7
    # ins_size=2
    invoke-super v5, v6, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v6, Lcom/bytedance/trae/conversation/R$layout;->trae_input_preview I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setContentView(I)V
    sget v6, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    const-string v0, "findViewById(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/ImageView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnBack Landroid/widget/ImageView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvTitle Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/ProgressBar;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->image_container I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/FrameLayout;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->iv_preview I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/webkit/WebView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->webView Landroid/webkit/WebView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->scroll_markdown I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/ScrollView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scrollMarkdown Landroid/widget/ScrollView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->tv_markdown I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->scroll_txt I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/ScrollView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->scrollTxt Landroid/widget/ScrollView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->tv_txt I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvTxt Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->layout_content I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/LinearLayout;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnDownload Landroid/view/View;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->btn_main_download I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->download_status_tile I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/TextView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v0, 0
    if-nez v6, +009h
    const-string/jumbo v6, tvMarkdown
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v1
    invoke-virtual v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_oid_id"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    const-string v2, ""
    if-nez v6, +003h
    move-object v6, v2
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->extraOidId Ljava/lang/String;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v2
    const-string/jumbo v1, trae-res://remote_resource/
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v6, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v6
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    sget-object v6, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v3, "oidId:"
    invoke-direct v1, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    const-string v4, "oidId"
    if-nez v3, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v3, "InputPreviewActivity"
    invoke-virtual v6, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_file_name"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v2
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_conversation_id"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v2
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_chat_session_id"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v2
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->chatSessionId Ljava/lang/String;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_cli_type"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v2
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->cliType Ljava/lang/String;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_mode"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    move-object v6, v2
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->mode Ljava/lang/String;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v6
    const-string v1, "extra_message_id"
    invoke-virtual v6, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +2h
    move-object v2, v6
    iput-object v2, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->messageId Ljava/lang/String;
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->tvTitle Landroid/widget/TextView;
    if-nez v6, +009h
    const-string/jumbo v6, tvTitle
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    const-string v2, "fileName"
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +012h
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v1, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    const/16 v3, 47
    const/4 v4, 2
    invoke-static v1, v3, v0, v4, v0, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    goto +9h
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->oidId Ljava/lang/String;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v6, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->btnBack Landroid/widget/ImageView;
    if-nez v6, +008h
    const-string v6, "btnBack"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda0;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    invoke-virtual v6, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileName Ljava/lang/String;
    if-nez v6, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->getFileType(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    move-result-object v6
    iput-object v6, v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->fileType Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    if-nez v6, +008h
    const-string v6, "fileType"
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v6
    sget-object v6, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->OTHER Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    if-ne v0, v6, +006h
    invoke-direct v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->showDownloadOnly()V
    goto +4h
    invoke-direct v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->preview()V
    invoke-direct v5, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->setupBtnDownload()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity;->com_bytedance_trae_conversation_products_InputPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/InputPreviewActivity;)V
    return-void 
.end method
