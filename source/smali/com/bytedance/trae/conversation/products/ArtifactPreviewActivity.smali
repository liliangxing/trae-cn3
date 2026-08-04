# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
.super Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;
.source "ArtifactPreviewActivity.kt"

.field private static final ANIM_DURATION:J
.field private static final CODE_EXTENSIONS:Ljava/util/Set;
.field public static final Companion:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
.field private static final DOUBLE_TAP_SCALE:F
.field private static final DOWNLOAD_URL_MAX_RETRIES:I
.field private static final DOWNLOAD_URL_RETRY_DELAY_MS:J
.field private static final EVENT_FETCH_FILE_URL:Ljava/lang/String;
.field private static final EXTRA_CHAT_SESSION_ID:Ljava/lang/String;
.field private static final EXTRA_CLI_TYPE:Ljava/lang/String;
.field private static final EXTRA_CONVERSATION_ID:Ljava/lang/String;
.field private static final EXTRA_CREATED_TIME:Ljava/lang/String;
.field private static final EXTRA_MESSAGE_ID:Ljava/lang/String;
.field private static final EXTRA_PATH:Ljava/lang/String;
.field private static final EXTRA_TURN_ID:Ljava/lang/String;
.field private static final HTML_EXTENSIONS:Ljava/util/Set;
.field private static final IMAGE_EXTENSIONS:Ljava/util/Set;
.field private static final MARKDOWN_EXTENSIONS:Ljava/util/Set;
.field private static final MAX_CODE_HIGHLIGHT_LENGTH:I
.field private static final MAX_SCALE:F
.field private static final MIN_SCALE:F
.field private static final TXT_EXTENSIONS:Ljava/util/Set;
.field private activePointerId:I
.field private btnBack:Landroid/widget/ImageView;
.field private btnDownload:Landroid/view/View;
.field private btnMainDownload:Landroid/widget/TextView;
.field private chatSessionId:Ljava/lang/String;
.field private cliType:Ljava/lang/String;
.field private conversationId:Ljava/lang/String;
.field private createdTime:J
.field private currentScale:F
.field private final downloadFinishCallback:Lkotlin/jvm/functions/Function3;
.field private downloadStatusTitle:Landroid/widget/TextView;
.field private final fileDownloadHelper:Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
.field private fileType:Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
.field private fileUrl:Ljava/lang/String;
.field private final gestureDetector$delegate:Lkotlin/Lazy;
.field private imageContainer:Landroid/widget/FrameLayout;
.field private isDeleted:Z
.field private isDragging:Z
.field private ivPreview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private lastTouchX:F
.field private lastTouchY:F
.field private layoutContent:Landroid/widget/LinearLayout;
.field private loadingDialog:Landroid/app/Dialog;
.field private messageId:Ljava/lang/String;
.field private path:Ljava/lang/String;
.field private progressBar:Landroid/widget/ProgressBar;
.field private scaleAnimator:Landroid/animation/ValueAnimator;
.field private final scaleGestureDetector$delegate:Lkotlin/Lazy;
.field private scrollMarkdown:Landroid/widget/ScrollView;
.field private scrollTxt:Landroid/widget/ScrollView;
.field private startTime:J
.field private tvMarkdown:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field private tvTitle:Landroid/widget/TextView;
.field private tvTxt:Landroid/widget/TextView;
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$-6otQbhqY8_i0rJAh3j-m44Gui4(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupBtnDownload$lambda$19(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$0dMmjh0COgZ3aAj_ywqQ6mDGIb4(float  float  com.bytedance.trae.conversation.products.ArtifactPreviewActivity  float  float  float  float  android.animation.ValueAnimator)void
    .registers 8
    # ins_size=8
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->animateToScale$lambda$23$lambda$22(F F Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; F F F F Landroid/animation/ValueAnimator;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$AUZ2V4oQIw-gMpyLr7vlNijBmhA(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fetchTextViaTTNet$lambda$9(Ljava/lang/String; Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$CIDZ2r5vkDFAfrprB-o1wWg0vek(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showDownloadOnly$lambda$14(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OdU2fJAZwcirL3iHWu22P2AX5LQ(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupImageTouchHandling$lambda$21(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$PINxM_Q1I916wlEyR3cPHw1S9RE(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  int  java.lang.String  long)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadFinishCallback$lambda$0(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; I Ljava/lang/String; J)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ajQaGiptURpESSDIb2a25I2bDRo(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupDownloadButtons$lambda$20(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$cgndx0CYqdW3aoFpNrFlgbZkEyA(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.view.ScaleGestureDetector
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scaleGestureDetector_delegate$lambda$1(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/view/ScaleGestureDetector;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$j84k0ZLpENlb9CWM8-L_Des69PE(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.view.GestureDetector
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->gestureDetector_delegate$lambda$2(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)Landroid/view/GestureDetector;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mUIZ-llQl5MF4M5wMgwopES9JIs(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showError$lambda$17(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$oacbAeyHBMNfTTe4fcRyZzsn8G4(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->onCreate$lambda$3(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 62
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
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
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->IMAGE_EXTENSIONS Ljava/util/Set;
    const-string v0, "markdown"
    const-string v1, "mdx"
    const-string v2, "md"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->MARKDOWN_EXTENSIONS Ljava/util/Set;
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
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->CODE_EXTENSIONS Ljava/util/Set;
    const-string v0, "csv"
    const-string/jumbo v1, tsv
    const-string/jumbo v2, txt
    const-string v3, "log"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->TXT_EXTENSIONS Ljava/util/Set;
    const-string v0, "htm"
    const-string/jumbo v1, xhtml
    const-string v2, "html"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->HTML_EXTENSIONS Ljava/util/Set;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda4;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    new-instance v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    const/high16 v0, 1065353216
    iput v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->currentScale F
    const/4 v0, -1
    iput v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->activePointerId I
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda5;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scaleGestureDetector$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda6;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->gestureDetector$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public static final synthetic access$animateToScale(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  float)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->animateToScale(F)V
    return-void 
.end method

.method public static final synthetic access$buildCodeHighlightHtml(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->buildCodeHighlightHtml(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$downloadAndShowTxt(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadAndShowTxt(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$fetchDownloadUrlWithRetry(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fetchDownloadUrlWithRetry(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchFileUrl(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fetchFileUrl(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchTextViaTTNet(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fetchTextViaTTNet(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getChatSessionId$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCliType$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getConversationId$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCreatedTime$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->createdTime J
    return-wide v0
.end method

.method public static final synthetic access$getCurrentScale$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)float
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->currentScale F
    return v0
.end method

.method public static final synthetic access$getDownloadFinishCallback$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)kotlin.jvm.functions.Function3
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public static final synthetic access$getFileDownloadHelper$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)com.bytedance.trae.conversation.products.FileDownloadHelper
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    return-object v0
.end method

.method public static final synthetic access$getFileType$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)com.bytedance.trae.conversation.products.ArtifactPreviewActivity$FileType
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileType Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    return-object v0
.end method

.method public static final synthetic access$getFileUrl$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileUrl Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getImageContainer$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.widget.FrameLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    return-object v0
.end method

.method public static final synthetic access$getIvPreview$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)com.facebook.drawee.view.SimpleDraweeView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    return-object v0
.end method

.method public static final synthetic access$getLayoutContent$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.widget.LinearLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public static final synthetic access$getMessageId$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getPath$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$getScaleAnimator$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.animation.ValueAnimator
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scaleAnimator Landroid/animation/ValueAnimator;
    return-object v0
.end method

.method public static final synthetic access$getScrollMarkdown$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.widget.ScrollView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scrollMarkdown Landroid/widget/ScrollView;
    return-object v0
.end method

.method public static final synthetic access$getScrollTxt$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.widget.ScrollView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scrollTxt Landroid/widget/ScrollView;
    return-object v0
.end method

.method public static final synthetic access$getTvMarkdown$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    return-object v0
.end method

.method public static final synthetic access$getTvTxt$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.widget.TextView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvTxt Landroid/widget/TextView;
    return-object v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$hideLoadingDialog(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->hideLoadingDialog()V
    return-void 
.end method

.method public static final synthetic access$isDeleted$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDeleted Z
    return v0
.end method

.method public static final synthetic access$loadImage(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.net.Uri)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadImage(Landroid/net/Uri;)V
    return-void 
.end method

.method public static final synthetic access$loadMarkdownPreview(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadMarkdownPreview(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$openFileWithExternalApp(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->openFileWithExternalApp(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$setCurrentScale$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  float)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->currentScale F
    return-void 
.end method

.method public static final synthetic access$setDragging$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDragging Z
    return-void 
.end method

.method public static final synthetic access$setFileUrl$p(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileUrl Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$setupDownloadButtons(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupDownloadButtons(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$setupImageTouchHandling(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupImageTouchHandling(Landroid/view/View;)V
    return-void 
.end method

.method public static final synthetic access$showArtifactDelete(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showArtifactDelete()V
    return-void 
.end method

.method public static final synthetic access$showCodePreview(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showCodePreview(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showDownloadWithUrl(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showDownloadWithUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showError(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showError()V
    return-void 
.end method

.method public static final synthetic access$showImagePreview(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showImagePreview(Ljava/lang/String;)V
    return-void 
.end method

.method public static final synthetic access$showLoadingDialog(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showLoadingDialog()V
    return-void 
.end method

.method private final animateToScale(float)void
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scaleAnimator Landroid/animation/ValueAnimator;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/animation/ValueAnimator;->cancel()V
    iget v2, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->currentScale F
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v1, 0
    const-string v3, "ivPreview"
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationX()F
    move-result v5
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
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
    new-instance v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda1;
    move-object v1, v9
    move v3, v11
    move-object v4, v10
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda1;-><init>(F F Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; F F F F)V
    invoke-virtual v0, v9, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    invoke-virtual v0, Landroid/animation/ValueAnimator;->start()V
    iput-object v0, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scaleAnimator Landroid/animation/ValueAnimator;
    return-void 
    nop 
    fill-array-data-payload b'\x00\x00\x00\x00\x00\x00\x80?' | \x00\x00\x00\x00\x00\x00\x80\x3f
.end method

.method private static final animateToScale$lambda$23$lambda$22(float  float  com.bytedance.trae.conversation.products.ArtifactPreviewActivity  float  float  float  float  android.animation.ValueAnimator)void
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
    iput v2, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->currentScale F
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v0, 0
    const-string v1, "ivPreview"
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleX(F)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v3, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v3, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->setScaleY(F)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v2, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    sub-float/2addr v6, v5
    mul-float/2addr v6, v9
    add-float/2addr v5, v6
    invoke-virtual v2, v5, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
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
    .registers 8
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v1
    int-to-double v1, v1
    const-wide v3, 4607632778762754458
    mul-double/2addr v1, v3
    double-to-int v1, v1
    add-int/lit16 v1, v1, 512
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(I)V
    const-string v1, "<!DOCTYPE html>
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
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const-string v7, "">"
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v7
    const/4 v1, 0
    if-ge v1, v7, +034h
    invoke-virtual v6, v1, Ljava/lang/String;->charAt(I)C
    move-result v2
    const/16 v3, 34
    if-eq v2, v3, +024h
    const/16 v3, 38
    if-eq v2, v3, +01ah
    const/16 v3, 60
    if-eq v2, v3, +010h
    const/16 v3, 62
    if-eq v2, v3, +006h
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    goto +18h
    const-string v2, "&gt;"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +12h
    const-string v2, "&lt;"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +ch
    const-string v2, "&amp;"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +6h
    const-string v2, "&quot;"
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    add-int/lit8 v1, v1, 1
    goto -33h
    const-string v6, "</code></pre>
<script>hljs.highlightAll();</script>
</body>
</html>"
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v7, toString(...)
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
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

.method public static com_bytedance_trae_conversation_products_ArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->com_bytedance_trae_conversation_products_ArtifactPreviewActivity__onStop$___twin___()V
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
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$downloadAndShowTxt$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$downloadAndShowTxt$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final downloadFinishCallback$lambda$0(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  int  java.lang.String  long)kotlin.Unit
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
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getString(I)Ljava/lang/String;
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
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v1, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final fetchDownloadUrlWithRetry(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v19
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    move-object/from16 v2, v17
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;
    move-object/from16 v2, v17
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    const/4 v5, 0
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v4, +02bh
    if-eq v4, v8, +01bh
    if-ne v4, v6, +011h
    iget v4, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iget-object v9, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0cch
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iget-object v9, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +44h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v18
    move-object v9, v2
    move v4, v5
    const/16 v10, 21
    if-ge v4, v10, +0beh
    sget-object v10, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v11, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    iget-object v13, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v13, +008h
    const-string v13, "conversationId"
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v7
    iget-object v14, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v14, +008h
    const-string v14, "messageId"
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v7
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v15
    invoke-direct v11, v12, v13, v14, v15, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    iput-object v9, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iput v8, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    invoke-virtual v10, v11, v1, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v3, +003h
    return-object v3
    move-object/from16 v16, v9
    move-object v9, v0
    move-object v0, v10
    move-object/from16 v10, v16
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v11, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v11, +075h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v11, +00fh
    invoke-virtual v11, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v11
    if-eqz v11, +009h
    invoke-interface v11, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    goto +2h
    move-object v11, v7
    if-eqz v11, +02ch
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v0
    if-eqz v0, +009h
    invoke-interface v0, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +00eh
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    move v5, v8
    if-eqz v5, +004h
    iput-boolean v8, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDeleted Z
    return-object v7
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v11
    const-wide/16 v13, 202
    cmp-long v0, v11, v13
    if-nez v0, +01ch
    const/16 v0, 20
    if-ge v4, v0, +013h
    iput-object v10, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->I$0 I
    iput v6, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchDownloadUrlWithRetry$1;->label I
    const-wide/16 v11, 2000
    invoke-static v11, v12, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v0, v9
    move-object v9, v10
    add-int/2addr v4, v8
    goto/16 -0b0h
    iput-boolean v8, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDeleted Z
    return-object v7
    instance-of v0, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +003h
    return-object v7
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    return-object v7
.end method

.method private final fetchFileUrl(kotlin.coroutines.Continuation)java.lang.Object
    .registers 30
    # ins_size=2
    move-object/from16 v0, v28
    move-object/from16 v1, v29
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->label I
    const-string v5, ""
    const/4 v6, 0
    const/4 v7, 2
    const-string v8, "conversationId"
    const-string v9, "messageId"
    const/4 v10, 1
    const-string v11, "path"
    const-string v12, "chatSessionId"
    const-string v13, "ArtifactPreviewActivity"
    const-string v14, "cliType"
    if-eqz v4, +033h
    if-eq v4, v10, +01fh
    if-ne v4, v7, +015h
    iget-wide v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->J$0 J
    iget-object v6, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$1 Ljava/lang/Object;
    check-cast v6, Ljava/util/Map;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v15, v2
    move-wide/from16 v19, v3
    const/4 v4, 0
    goto/16 +29bh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-wide v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->J$0 J
    iget-object v7, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$1 Ljava/lang/Object;
    check-cast v7, Ljava/util/Map;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-wide/from16 v22, v3
    move v15, v10
    goto/16 +0a1h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v1, 5
    new-array v1, v1, [Lkotlin/Pair;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-static v12, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v1, v6
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-static v14, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v1, v10
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-static v11, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v1, v7
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-static v9, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/16 v16, 3
    aput-object v4, v1, v16
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-static v8, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/16 v16, 4
    aput-object v4, v1, v16
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v6
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v15, Ljava/lang/StringBuilder;
    const-string v10, "fetchFileUrl paramsMap: "
    invoke-direct v15, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v15, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v4, v13, v10, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    sget-object v10, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v10
    invoke-static v4, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +1e3h
    sget-object v4, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v10, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$0 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$1 Ljava/lang/Object;
    iput-wide v6, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->J$0 J
    const/4 v15, 1
    iput v15, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->label I
    invoke-virtual v4, v10, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v3, +003h
    return-object v3
    move-wide/from16 v22, v6
    move-object v7, v1
    move-object v1, v2
    move-object v2, v0
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v6, "fetchFileUrl："
    invoke-direct v4, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v6, 32
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v13, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v10, "onCreate："
    invoke-direct v4, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v15, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v15, +006h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v15, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v15, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    iget-object v15, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v15, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v15, 0
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v13, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    instance-of v3, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v3, +10fh
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v4, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-direct v2, v4, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v15, "fetchFileUrl"
    invoke-direct v11, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v4, v13, v11, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v10, +006h
    invoke-static v12, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v10, 0
    invoke-virtual v11, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v11, +006h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v11, 0
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v11, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v11, 0
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    iget-object v9, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v9, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v9, 0
    invoke-virtual v6, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v4, v13, v6, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    const/4 v6, 0
    goto +2h
    const/4 v6, 1
    const-string v4, "ArtifactPreviewActivity:Success"
    const-string v8, "explorerUrl"
    if-eqz v6, +02bh
    invoke-static v7, v8, v5, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v1, Ljava/lang/Throwable;
    invoke-direct v1, Ljava/lang/Throwable;-><init>()V
    invoke-static v13, v1, v4, v7, Lcom/bytedance/crash/Ensure;->ensureNotReachHere(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/util/Map;)V
    const-string v19, "fail"
    const-string v20, "explorer_url_empty"
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v1, +008h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v1
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 48
    const/16 v27, 0
    move-object/from16 v18, v2
    invoke-static/range v18 ... v27, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->reportFetchFileUrlEvent$default(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +65h
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->buildFileUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v8, v3, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v3, "buildPath"
    invoke-static v7, v3, v1, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v3, Ljava/lang/Throwable;
    invoke-direct v3, Ljava/lang/Throwable;-><init>()V
    invoke-static v13, v3, v4, v7, Lcom/bytedance/crash/Ensure;->ensureNotReachHere(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/util/Map;)V
    const-string/jumbo v19, success
    const-string v20, ""
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v3, +008h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v3
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 48
    const/16 v27, 0
    move-object/from16 v18, v2
    invoke-static/range v18 ... v27, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->reportFetchFileUrlEvent$default(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    return-object v1
    instance-of v3, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +031h
    new-instance v3, Ljava/lang/Throwable;
    invoke-direct v3, Ljava/lang/Throwable;-><init>()V
    const-string v4, "ArtifactPreviewActivity:Error"
    invoke-static v13, v3, v4, v7, Lcom/bytedance/crash/Ensure;->ensureNotReachHere(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; Ljava/util/Map;)V
    const-string v19, "fail"
    const-string v20, "remote_request_error"
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v3, +008h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/16 v21, 0
    goto +3h
    move-object/from16 v21, v3
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-static v3, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v24
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v25
    move-object/from16 v18, v2
    invoke-direct/range v18 ... v25, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->reportFetchFileUrlEvent(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    return-object v4
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    const/4 v4, 0
    iget-object v8, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v8, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v4
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$0 Ljava/lang/Object;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->L$1 Ljava/lang/Object;
    iput-wide v6, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->J$0 J
    const/4 v9, 2
    iput v9, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$fetchFileUrl$1;->label I
    invoke-direct v0, v8, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fetchDownloadUrlWithRetry(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v3, +003h
    return-object v3
    move-object v15, v0
    move-wide/from16 v19, v6
    move-object v6, v1
    move-object v1, v2
    check-cast v1, Ljava/lang/String;
    const-string v2, "dowload_url"
    if-nez v1, +02ah
    invoke-static v6, v2, v5, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v16, "fail"
    iget-boolean v2, v15, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDeleted Z
    if-eqz v2, +005h
    const-string v2, "file_deleted"
    goto +3h
    const-string v2, "download_url_null"
    move-object/from16 v17, v2
    iget-object v2, v15, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v2, +008h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v18, v4
    goto +3h
    move-object/from16 v18, v2
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 48
    const/16 v24, 0
    invoke-static/range v15 ... v24, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->reportFetchFileUrlEvent$default(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +20h
    invoke-static v6, v2, v1, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v16, success
    const-string v17, ""
    iget-object v2, v15, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v2, +008h
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object/from16 v18, v4
    goto +3h
    move-object/from16 v18, v2
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 48
    const/16 v24, 0
    invoke-static/range v15 ... v24, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->reportFetchFileUrlEvent$default(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    new-instance v2, Ljava/lang/Throwable;
    invoke-direct v2, Ljava/lang/Throwable;-><init>()V
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "ArtifactPreviewActivity:Error "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v13, v2, v3, Lcom/bytedance/crash/Ensure;->ensureNotReachHereWithLogType(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    return-object v1
.end method

.method private final fetchTextViaTTNet(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    const/4 v0, 0
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    const-string v3, "cliType"
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +016h
    iget-object v2, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda9;
    invoke-direct v2, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda9;-><init>(Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    const-string v2, "https://placeholder.trae/"
    invoke-static v2, v1, v0, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$TxtFetchApi;
    invoke-virtual v1, v2, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$TxtFetchApi;
    if-nez v1, +003h
    return-object v0
    const/high16 v2, 31457280
    invoke-interface v1, v6, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$TxtFetchApi;->get(Ljava/lang/String; I)Lcom/bytedance/retrofit2/Call;
    move-result-object v6
    invoke-interface v6, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v6
    const-string v1, "execute(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/retrofit2/mime/TypedInput;
    if-nez v6, +005h
    const-string v6, ""
    return-object v6
    invoke-interface v6, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v6
    const-string v1, "in(...)"
    invoke-static v6, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->readAllBytes(Ljava/io/InputStream;)[B
    move-result-object v6
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +01fh
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v1, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +9h
    new-instance v1, Ljava/lang/String;
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v1, v6, v2, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v1
    new-instance v1, Ljava/lang/String;
    invoke-static v6, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v6
    sget-object v2, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v1, v6, v2, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    return-object v1
    return-object v0
    :try_start_0x1
    :try_start_0xe
.end method

.method private static final fetchTextViaTTNet$lambda$9(java.lang.String  com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
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

.method private static final gestureDetector_delegate$lambda$2(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.view.GestureDetector
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/view/GestureDetector;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$gestureDetector$2$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$gestureDetector$2$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    check-cast v2, Landroid/view/GestureDetector$OnGestureListener;
    invoke-direct v0, v1, v2, Landroid/view/GestureDetector;-><init>(Landroid/content/Context; Landroid/view/GestureDetector$OnGestureListener;)V
    return-object v0
.end method

.method private final getFileType(java.lang.String)com.bytedance.trae.conversation.products.ArtifactPreviewActivity$FileType
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
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->IMAGE_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->IMAGE Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    goto +2fh
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->MARKDOWN_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->MARKDOWN Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    goto +24h
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->CODE_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->CODE Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    goto +19h
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->TXT_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->TXT Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    goto +eh
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->HTML_EXTENSIONS Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->HTML Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->OTHER Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    return-object v3
.end method

.method private final getGestureDetector()android.view.GestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->gestureDetector$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/GestureDetector;
    return-object v0
.end method

.method private final getScaleGestureDetector()android.view.ScaleGestureDetector
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scaleGestureDetector$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/ScaleGestureDetector;
    return-object v0
.end method

.method private final hideLoadingDialog()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadingDialog Landroid/app/Dialog;
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/app/Dialog;->dismiss()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadingDialog Landroid/app/Dialog;
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
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
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
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    check-cast v4, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v1, v4, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method private final loadMarkdownPreview(java.lang.String  java.lang.String  java.lang.String)void
    .registers 14
    # ins_size=4
    move-object v0, v10
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$loadMarkdownPreview$1;
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v13
    move-object v6, v10
    move-object v7, v11
    move-object v8, v12
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$loadMarkdownPreview$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
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

.method static synthetic normalizeFilePath$default(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final onCreate$lambda$3(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 8
    # ins_size=2
    sget-object v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "path"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    iget-object v2, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v2, +008h
    const-string v2, "messageId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v2
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iget-wide v4, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->startTime J
    sub-long/2addr v2, v4
    invoke-virtual v7, v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClose(Ljava/lang/String; Ljava/lang/String; J)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->finish()V
    return-void 
    :try_start_0x0
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
    invoke-virtual v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getPackageName()Ljava/lang/String;
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
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->startActivity(Landroid/content/Intent;)V
    return-void 
    :try_start_0x0
.end method

.method private final preview()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
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
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$preview$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
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

.method private final reportFetchFileUrlEvent(java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String)void
    .registers 12
    # ins_size=8
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    const-string/jumbo v1, status
    invoke-virtual v0, v1, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "cli_type"
    invoke-virtual v0, v5, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v5, v6
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v7, 1
    const/4 v1, 0
    if-lez v5, +004h
    move v5, v7
    goto +2h
    move v5, v1
    if-eqz v5, +007h
    const-string v5, "reason"
    invoke-virtual v0, v5, v6, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, Lorg/json/JSONObject;-><init>()V
    const-string v6, "duration_ms"
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    sub-long/2addr v2, v8
    invoke-virtual v5, v6, v2, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    new-instance v6, Lorg/json/JSONObject;
    invoke-direct v6, Lorg/json/JSONObject;-><init>()V
    const-string v8, "chat_session_id"
    iget-object v9, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    const/4 v2, 0
    if-nez v9, +008h
    const-string v9, "chatSessionId"
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v2
    invoke-virtual v6, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "conversation_id"
    iget-object v9, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v9, +008h
    const-string v9, "conversationId"
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v2
    invoke-virtual v6, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v8, "message_id"
    iget-object v9, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v9, +008h
    const-string v9, "messageId"
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v2
    invoke-virtual v6, v8, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    iget-object v8, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    const-string v9, "path"
    if-nez v8, +006h
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v8
    invoke-virtual v6, v9, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v8, v10
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +3h
    move v8, v1
    goto +2h
    move v8, v7
    if-nez v8, +007h
    const-string v8, "error_code"
    invoke-virtual v6, v8, v10, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-object v8, v11
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00ah
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +003h
    goto +2h
    move v7, v1
    if-nez v7, +007h
    const-string v7, "error_message"
    invoke-virtual v6, v7, v11, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v7, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    const-string v8, "artifact_fetch_file_url"
    invoke-virtual v7, v8, v0, v5, v6, Lcom/bytedance/trae/platform/service/ApmService;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
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
    :try_start_0x72
.end method

.method static synthetic reportFetchFileUrlEvent$default(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String  long  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 16
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 32
    if-eqz v0, +004h
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move-object v4, v12
    move-object v5, v13
    move-wide v6, v14
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->reportFetchFileUrlEvent(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final scaleGestureDetector_delegate$lambda$1(com.bytedance.trae.conversation.products.ArtifactPreviewActivity)android.view.ScaleGestureDetector
    .registers 4
    # ins_size=1
    new-instance v0, Landroid/view/ScaleGestureDetector;
    move-object v1, v3
    check-cast v1, Landroid/content/Context;
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$scaleGestureDetector$2$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    check-cast v2, Landroid/view/ScaleGestureDetector$OnScaleGestureListener;
    invoke-direct v0, v1, v2, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context; Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    return-object v0
.end method

.method private final setupBtnDownload()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnDownload Landroid/view/View;
    if-nez v0, +008h
    const-string v0, "btnDownload"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    new-instance v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda3;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupBtnDownload$lambda$19(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 16
    # ins_size=2
    const-string v15, "path"
    const/4 v0, 0
    iget-object v1, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v1, +006h
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    const-string v2, ""
    const/16 v3, 46
    invoke-static v1, v3, v2, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v1, v2, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, toLowerCase(...)
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v3, "artifact_type"
    invoke-virtual v2, v3, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v3, "icube_artifact_download"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    new-instance v1, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v1, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    iget-object v2, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    const-string v3, "cliType"
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +019h
    iget-object v2, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    iput-boolean v2, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    iget-object v2, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileUrl Ljava/lang/String;
    if-eqz v2, +04ch
    const-string v3, "fileUrl"
    if-nez v2, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3ah
    iget-object v4, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    iget-object v2, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileUrl Ljava/lang/String;
    if-nez v2, +007h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    goto +2h
    move-object v6, v2
    iget-object v2, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v2, +009h
    const-string v2, "chatSessionId"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v0
    goto +2h
    move-object v7, v2
    iget-object v2, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v2, +007h
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    goto +2h
    move-object v8, v2
    iget-wide v12, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->createdTime J
    move-object v15, v14
    check-cast v15, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v15, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v15
    iget-object v10, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    iget-boolean v11, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    move-object v5, v14
    check-cast v5, Landroid/content/Context;
    move-object v9, v15
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    invoke-virtual/range v4 ... v13, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    goto +1ah
    move-object v15, v14
    check-cast v15, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v15, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v15
    move-object v2, v15
    check-cast v2, Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v15, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;
    invoke-direct v15, v14, v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$setupBtnDownload$1$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/coroutines/Continuation;)V
    move-object v5, v15
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    :try_start_0x3
.end method

.method private final setupDownloadButtons(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnDownload Landroid/view/View;
    const/4 v3, 0
    if-nez v2, +008h
    const-string v2, "btnDownload"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v3
    invoke-virtual v2, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v2, +008h
    const-string v2, "btnMainDownload"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v2
    invoke-virtual v3, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final setupDownloadButtons$lambda$20(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  java.lang.String  java.lang.String  java.lang.String  android.view.View)void
    .registers 15
    # ins_size=5
    iget-object v14, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    const/4 v0, 0
    const-string v1, "cliType"
    if-nez v14, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v14, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-nez v14, +01ah
    iget-object v14, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v14, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v14
    sget-object v14, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v14
    invoke-static v0, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +003h
    goto +3h
    const/4 v14, 0
    goto +2h
    const/4 v14, 1
    move v7, v14
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    move-object v14, v10
    check-cast v14, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v14, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v14
    iget-wide v8, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->createdTime J
    iget-object v6, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadFinishCallback Lkotlin/jvm/functions/Function3;
    move-object v1, v10
    check-cast v1, Landroid/content/Context;
    move-object v5, v14
    check-cast v5, Lkotlinx/coroutines/CoroutineScope;
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    invoke-virtual/range v0 ... v9, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->saveFileAndLoading(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/functions/Function3; Z J)V
    return-void 
.end method

.method private final setupImageTouchHandling(android.view.View)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda2;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-virtual v2, v0, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    return-void 
.end method

.method private static final setupImageTouchHandling$lambda$21(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View  android.view.MotionEvent)boolean
    .registers 10
    # ins_size=3
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getScaleGestureDetector()Landroid/view/ScaleGestureDetector;
    move-result-object v8
    invoke-virtual v8, v9, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getGestureDetector()Landroid/view/GestureDetector;
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
    iget v3, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->activePointerId I
    if-ne v2, v3, +094h
    if-nez v8, +003h
    move v0, v1
    invoke-virtual v9, Landroid/view/MotionEvent;->getPointerCount()I
    move-result v8
    if-ge v0, v8, +08bh
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getX(I)F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchX F
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getY(I)F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchY F
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->activePointerId I
    goto/16 +077h
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDragging Z
    goto/16 +073h
    iget-boolean v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDragging Z
    if-eqz v8, +06fh
    invoke-direct v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getScaleGestureDetector()Landroid/view/ScaleGestureDetector;
    move-result-object v8
    invoke-virtual v8, Landroid/view/ScaleGestureDetector;->isInProgress()Z
    move-result v8
    if-nez v8, +065h
    iget v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->activePointerId I
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->findPointerIndex(I)I
    move-result v8
    if-ltz v8, +05dh
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->getX(I)F
    move-result v0
    invoke-virtual v9, v8, Landroid/view/MotionEvent;->getY(I)F
    move-result v8
    iget v9, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchX F
    sub-float v9, v0, v9
    iget v2, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchY F
    sub-float v2, v8, v2
    iget v3, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->currentScale F
    const/high16 v4, 1065353216
    cmpl-float v3, v3, v4
    if-lez v3, +026h
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    const/4 v4, 0
    const-string v5, "ivPreview"
    if-nez v3, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationX()F
    move-result v6
    add-float/2addr v6, v9
    invoke-virtual v3, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationX(F)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    if-nez v9, +006h
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v9
    invoke-virtual v4, Lcom/facebook/drawee/view/SimpleDraweeView;->getTranslationY()F
    move-result v9
    add-float/2addr v9, v2
    invoke-virtual v4, v9, Lcom/facebook/drawee/view/SimpleDraweeView;->setTranslationY(F)V
    iput v0, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchX F
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchY F
    goto +1bh
    iput-boolean v0, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDragging Z
    const/4 v8, -1
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->activePointerId I
    goto +15h
    invoke-virtual v9, v0, Landroid/view/MotionEvent;->getPointerId(I)I
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->activePointerId I
    invoke-virtual v9, Landroid/view/MotionEvent;->getX()F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchX F
    invoke-virtual v9, Landroid/view/MotionEvent;->getY()F
    move-result v8
    iput v8, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->lastTouchY F
    iput-boolean v1, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->isDragging Z
    return v1
.end method

.method private final showArtifactDelete()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "downloadStatusTitle"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_artifact_delete I
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnMainDownload"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_trailing_actions I
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
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
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showCodePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final showDirError()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "downloadStatusTitle"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_artifact_dir_error I
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getString(I)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnMainDownload"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v2, Landroid/widget/TextView;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_trailing_actions I
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final showDownloadOnly()void
    .registers 9
    # ins_size=1
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
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
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$1;
    invoke-direct v0, v8, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v5, v0
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "btnMainDownload"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda7;
    invoke-direct v0, v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final showDownloadOnly$lambda$14(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 9
    # ins_size=2
    const-string v8, "path"
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v2, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v2, v0
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v3, +008h
    const-string v3, "messageId"
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactOpenLocal(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileDownloadHelper Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    check-cast v2, Landroid/content/Context;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v3, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v0
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;->getExistingFilePath(Landroid/content/Context; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +006h
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->openFileWithExternalApp(Ljava/lang/String;)V
    return-void 
    move-object v8, v7
    check-cast v8, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v8, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v8
    move-object v1, v8
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v8, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;
    invoke-direct v8, v7, v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showDownloadOnly$2$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Lkotlin/coroutines/Continuation;)V
    move-object v4, v8
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    :try_start_0x3
.end method

.method private final showDownloadWithUrl(java.lang.String  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v3, v4, v5, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupDownloadButtons(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final showError()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "layoutContent"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    if-nez v0, +008h
    const-string v0, "downloadStatusTitle"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_connect_error I
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    const-string v2, "btnMainDownload"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_doc_preview_retry I
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda8;
    invoke-direct v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final showError$lambda$17(com.bytedance.trae.conversation.products.ArtifactPreviewActivity  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    if-nez v2, +008h
    const-string v2, "layoutContent"
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->preview()V
    return-void 
.end method

.method private final showHtmlPreview(java.lang.String)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    const/4 v1, 0
    if-nez v0, +008h
    const-string v0, "progressBar"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    const-string/jumbo v2, webView
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    const/4 v3, 0
    invoke-virtual v0, v3, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-virtual v0, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    const/4 v3, 1
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    const-string v3, "UTF-8"
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v3, Landroid/webkit/WebChromeClient;
    invoke-direct v3, Landroid/webkit/WebChromeClient;-><init>()V
    invoke-virtual v0, v3, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v1, v0
    invoke-virtual v1, v5, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V
    return-void 
.end method

.method private final showImagePreview(java.lang.String)void
    .registers 11
    # ins_size=2
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    const-string v1, "cliType"
    const/4 v2, 0
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const-string v3, "parse(...)"
    const-string v4, "progressBar"
    const/16 v5, 8
    const-string v6, "imageContainer"
    const/4 v7, 0
    if-nez v0, +05fh
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v0, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +49h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v7, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-static v10, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadImage(Landroid/net/Uri;)V
    sget-object v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v0, +008h
    const-string v0, "path"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    iget-object v1, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v1, +008h
    const-string v1, "messageId"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    invoke-virtual v10, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactOpen(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    if-nez v10, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    check-cast v2, Landroid/view/View;
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupImageTouchHandling(Landroid/view/View;)V
    goto +2ch
    const-string v0, "content://"
    const/4 v1, 2
    invoke-static v10, v0, v7, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +025h
    const-string v0, "file://"
    invoke-static v10, v0, v7, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +1bh
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/LifecycleOwner;
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v3, v0
    check-cast v3, Lkotlinx/coroutines/CoroutineScope;
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;
    invoke-direct v0, v9, v10, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$showImagePreview$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    if-nez v0, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v2
    invoke-virtual v0, v7, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-static v10, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v10
    invoke-static v10, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadImage(Landroid/net/Uri;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    if-nez v10, +006h
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    check-cast v2, Landroid/view/View;
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupImageTouchHandling(Landroid/view/View;)V
    return-void 
.end method

.method private final showLoadingDialog()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadingDialog Landroid/app/Dialog;
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
    iput-object v0, v6, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->loadingDialog Landroid/app/Dialog;
    return-void 
.end method

.method public com_bytedance_trae_conversation_products_ArtifactPreviewActivity__onStop$___twin___()void
    .registers 1
    # ins_size=1
    invoke-super v0, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onStop()V
    return-void 
.end method

.method protected onCreate(android.os.Bundle)void
    .registers 15
    # ins_size=2
    invoke-super v13, v14, Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;->onCreate(Landroid/os/Bundle;)V
    sget v14, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_artifact_preview I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setContentView(I)V
    sget v14, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    const-string v0, "findViewById(...)"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/ImageView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnBack Landroid/widget/ImageView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/TextView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvTitle Landroid/widget/TextView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/ProgressBar;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->progressBar Landroid/widget/ProgressBar;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->image_container I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/FrameLayout;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->imageContainer Landroid/widget/FrameLayout;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->iv_preview I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/webkit/WebView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->webView Landroid/webkit/WebView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->scroll_markdown I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/ScrollView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scrollMarkdown Landroid/widget/ScrollView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->tv_markdown I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->scroll_txt I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/ScrollView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->scrollTxt Landroid/widget/ScrollView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->tv_txt I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/TextView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvTxt Landroid/widget/TextView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->layout_content I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/LinearLayout;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->layoutContent Landroid/widget/LinearLayout;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnDownload Landroid/view/View;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->btn_main_download I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/TextView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnMainDownload Landroid/widget/TextView;
    sget v14, Lcom/bytedance/trae/conversation/R$id;->download_status_tile I
    invoke-virtual v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->findViewById(I)Landroid/view/View;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v14, Landroid/widget/TextView;
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->downloadStatusTitle Landroid/widget/TextView;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v0, 0
    if-nez v14, +009h
    const-string/jumbo v14, tvMarkdown
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v1
    invoke-virtual v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v1, "extra_chat_session_id"
    invoke-virtual v14, v1, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    const-string v1, ""
    if-nez v14, +003h
    move-object v14, v1
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v2, "extra_cli_type"
    invoke-virtual v14, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    if-nez v14, +003h
    move-object v14, v1
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v2, "extra_path"
    invoke-virtual v14, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    if-nez v14, +003h
    move-object v14, v1
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v2, "extra_message_id"
    invoke-virtual v14, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    if-nez v14, +003h
    move-object v14, v1
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v2, "extra_conversation_id"
    invoke-virtual v14, v2, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    if-nez v14, +003h
    goto +2h
    move-object v1, v14
    iput-object v1, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getIntent()Landroid/content/Intent;
    move-result-object v14
    const-string v1, "extra_created_time"
    const-wide/16 v2, 0
    invoke-virtual v14, v1, v2, v3, Landroid/content/Intent;->getLongExtra(Ljava/lang/String; J)J
    move-result-wide v1
    iput-wide v1, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->createdTime J
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iput-wide v1, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->startTime J
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    const-string v1, "cliType"
    if-nez v14, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v14, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    const/4 v2, 2
    const/4 v3, 0
    const-string v4, "path"
    if-eqz v14, +016h
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v14, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    const-string v5, "/"
    invoke-static v14, v5, v3, v2, v0, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +006h
    invoke-direct v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showDirError()V
    return-void 
    sget-object v14, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "onCreate："
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    const-string v8, "chatSessionId"
    if-nez v7, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v7, v0
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const/16 v7, 32
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v9, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v9, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v0
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v9, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v9, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v0
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v9, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    const-string v10, "messageId"
    if-nez v9, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v0
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v9, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    const-string v11, "conversationId"
    if-nez v9, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v0
    invoke-virtual v5, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v9, "ArtifactPreviewActivity"
    invoke-virtual v14, v9, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v14, Ljava/lang/System;->out Ljava/io/PrintStream;
    const/4 v5, 1
    new-array v5, v5, [Ljava/lang/Object;
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v6, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->chatSessionId Ljava/lang/String;
    if-nez v6, +006h
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-virtual v12, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    iget-object v8, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->cliType Ljava/lang/String;
    if-nez v8, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v8, v0
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v6, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v6, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v6, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->messageId Ljava/lang/String;
    if-nez v6, +006h
    invoke-static v10, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v6, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->conversationId Ljava/lang/String;
    if-nez v6, +006h
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v6, v0
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    aput-object v1, v5, v3
    invoke-virtual v14, v9, v5, Ljava/io/PrintStream;->printf(Ljava/lang/String; [Ljava/lang/Object;)Ljava/io/PrintStream;
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->tvTitle Landroid/widget/TextView;
    if-nez v14, +009h
    const-string/jumbo v14, tvTitle
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    iget-object v1, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v0
    const/16 v3, 47
    invoke-static v1, v3, v0, v2, v0, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v14, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->btnBack Landroid/widget/ImageView;
    if-nez v14, +008h
    const-string v14, "btnBack"
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    new-instance v1, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda10;
    invoke-direct v1, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    invoke-virtual v14, v1, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->path Ljava/lang/String;
    if-nez v14, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v14, v0
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->getFileType(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    move-result-object v14
    iput-object v14, v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->fileType Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    if-nez v14, +008h
    const-string v14, "fileType"
    invoke-static v14, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v14
    sget-object v14, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;->OTHER Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$FileType;
    if-ne v0, v14, +006h
    invoke-direct v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->showDownloadOnly()V
    goto +4h
    invoke-direct v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->preview()V
    invoke-direct v13, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->setupBtnDownload()V
    return-void 
.end method

.method protected onStop()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->com_bytedance_trae_conversation_products_ArtifactPreviewActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;)V
    return-void 
.end method
