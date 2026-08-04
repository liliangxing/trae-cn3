# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
.super Ljava/lang/Object;
.source "ArtifactsRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final CODE_EXTENSIONS:Ljava/util/Set;
.field private static final COMPUTER_LINK_REGEX:Lkotlin/text/Regex;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$Companion;
.field private static final HTML_EXTENSIONS:Ljava/util/Set;
.field private static final IMAGE_PREVIEW_EXTENSIONS:Ljava/util/Set;
.field private static final MARKDOWN_EXTENSIONS:Ljava/util/Set;
.field public static final PREVIEW_MAX_CHARS:I
.field private static final TXT_EXTENSIONS:Ljava/util/Set;


.method public static synthetic $r8$lambda$-lA2HlPOMKldjz3F53qOpOA_yZg(android.view.View  android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMarkdownPreviewCard$lambda$48$lambda$47(Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$4Rfml5VAWt25nOwCf8LG6i4Ha-E(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSingleImagePreviewCard$lambda$124(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$4wmkrV2zLZalZ1UUm4spyHK6g9o(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.service.Conversation  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createChangedCodeSection$lambda$84$lambda$83(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/service/Conversation; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$8g7AY2_WxJJpZ52dBVQ23NxI-20(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.service.Conversation  java.lang.Long  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMtcCodeCard$lambda$92$lambda$91(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/Long; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$JoZXyaAPj4Pf6AoXozwlnleQpnw(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createFileCard$lambda$24$lambda$22(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$M_WbSUNKG2f1YejxPY0xVFz8528(android.widget.LinearLayout  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMarkdownPreviewCard$lambda$51(Landroid/widget/LinearLayout; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$V6fDipoC4QHZL9sGPRdfpRDSNvc(android.content.Context  com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->render$lambda$2$lambda$1(Landroid/content/Context; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ZrNwqG-04kiFVKeV3C-CarZCzIM(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createHtmlPreviewCard$lambda$76(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$eyGGVi_441i4CVtUg-uhKKTqKuU(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createPreviewCard$lambda$21$lambda$20$lambda$19(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$j4km-_fd8J7HJOZocwSgjEluhJY(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createHtmlArtifactCard$lambda$62$lambda$59(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$p22ilanSst1kGz4g4BmO5iYauJw(android.content.Context  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSkillCard$lambda$58$lambda$55(Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$t0aKRNPkE7lvRXFTk-UObouUmsw(android.widget.LinearLayout  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createHtmlPreviewCard$lambda$77(Landroid/widget/LinearLayout; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$tjnhMWVgMN7RKyWl9fBIdDBnutY(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.util.List  android.content.Context  int  android.view.View)void
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMultiImagePreviewCard$lambda$133$lambda$132(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/util/List; Landroid/content/Context; I Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$uqFQAh60aiJYYIV1Q20BIcPTlFk(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.im.model.MergeChangedFilesData  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMergeSection$lambda$100(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/im/model/MergeChangedFilesData; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$wvSPlnJCi6eKG-wHGfWfSzhGUvM(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMarkdownPreviewCard$lambda$50(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xb0J45txx_TmhAZeUuYhRBlTWww(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextPreviewCard$lambda$36(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 62
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$Companion;
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
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->IMAGE_PREVIEW_EXTENSIONS Ljava/util/Set;
    const-string v0, "markdown"
    const-string v1, "mdx"
    const-string v2, "md"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->MARKDOWN_EXTENSIONS Ljava/util/Set;
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
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->CODE_EXTENSIONS Ljava/util/Set;
    const-string v0, "csv"
    const-string/jumbo v1, tsv
    const-string/jumbo v2, txt
    const-string v3, "log"
    filled-new-array v2, v3, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->TXT_EXTENSIONS Ljava/util/Set;
    const-string v0, "htm"
    const-string/jumbo v1, xhtml
    const-string v2, "html"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->HTML_EXTENSIONS Ljava/util/Set;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "computer://([^\s)\]]+)"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->COMPUTER_LINK_REGEX Lkotlin/text/Regex;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$buildFileUrl(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->buildFileUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$collapseToFileCard(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->collapseToFileCard(Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method public static final synthetic access$downloadAndExtractHtml(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->downloadAndExtractHtml(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchHtmlArchiveUrl(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->fetchHtmlArchiveUrl(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchHtmlDownloadUrlWithRetry(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->fetchHtmlDownloadUrlWithRetry(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$normalizeFilePath(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$resolveImageUri(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->resolveImageUri(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setImageWithResize(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  int  android.net.Uri)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->setImageWithResize(Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Landroid/net/Uri;)V
    return-void 
.end method

.method public static final synthetic access$truncateForPreview(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->truncateForPreview(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final artifactCardBackgroundColor(android.content.Context)int
    .registers 3
    # ins_size=2
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    return v2
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

.method private final collapseToFileCard(android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View)void
    .registers 9
    # ins_size=6
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/view/View;->setVisibility(I)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->im_artifact_interceptor I
    invoke-virtual v4, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    if-eqz v4, +005h
    invoke-virtual v4, v0, Landroid/view/View;->setVisibility(I)V
    if-eqz v7, +005h
    invoke-virtual v7, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v5, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->density F
    const/16 v7, 12
    int-to-float v7, v7
    mul-float/2addr v7, v4
    float-to-int v7, v7
    invoke-virtual v5, v7, v7, v7, v7, Landroid/view/View;->setPadding(I I I I)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->img_im_artifact I
    invoke-virtual v5, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    instance-of v7, v5, Landroid/widget/FrameLayout;
    if-eqz v7, +005h
    check-cast v5, Landroid/widget/FrameLayout;
    goto +2h
    const/4 v5, 0
    const/4 v7, 0
    if-eqz v5, +028h
    const/16 v0, 50
    int-to-float v0, v0
    mul-float/2addr v0, v4
    float-to-int v0, v0
    const/16 v1, 40
    int-to-float v1, v1
    mul-float/2addr v1, v4
    float-to-int v1, v1
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v0, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v2, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v5, v7, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v5
    if-eqz v5, +00eh
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v2, 17
    invoke-direct v0, v1, v1, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v6, v7, Landroid/widget/TextView;->setVisibility(I)V
    if-eqz v8, +036h
    invoke-virtual v8, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v5
    new-instance v6, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v6, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->artifactCardBackgroundColor(Landroid/content/Context;)I
    move-result v7
    invoke-virtual v6, v7, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v7, 20
    int-to-float v7, v7
    mul-float/2addr v7, v4
    invoke-virtual v6, v7, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    const/4 v7, 1
    int-to-float v0, v7
    mul-float/2addr v0, v4
    float-to-int v4, v0
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v5, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v6, v4, v5, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v6, Landroid/graphics/drawable/Drawable;
    invoke-virtual v8, v6, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v8, v7, Landroid/view/View;->setClipToOutline(Z)V
    sget-object v4, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v8, v4, Landroid/view/View;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    return-void 
.end method

.method static synthetic collapseToFileCard$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  int  java.lang.Object)void
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 8
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    and-int/lit8 v11, v13, 16
    if-eqz v11, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v12
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->collapseToFileCard(Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method private final containsFilePath(com.bytedance.trae.im.model.ArtifactData  java.lang.String)boolean
    .registers 9
    # ins_size=3
    const/4 v0, 4
    new-array v0, v0, [Ljava/util/List;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedDocs()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const/4 v3, 0
    aput-object v1, v0, v3
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedImages()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const/4 v4, 1
    aput-object v1, v0, v4
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSheets()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v2
    const/4 v5, 2
    aput-object v1, v0, v5
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSlides()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v7
    goto +2h
    move-object v7, v2
    const/4 v1, 3
    aput-object v7, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->flatten(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    instance-of v0, v7, Ljava/util/Collection;
    if-eqz v0, +00ch
    move-object v0, v7
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +28h
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01fh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00fh
    check-cast v0, Ljava/lang/CharSequence;
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, v3, v5, v2, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v0
    if-ne v0, v4, +004h
    move v0, v4
    goto +2h
    move v0, v3
    if-eqz v0, -020h
    move v3, v4
    return v3
.end method

.method private final createArtifactLoadingView(android.content.Context  float)android.view.View
    .registers 18
    # ins_size=3
    move-object/from16 v0, v16
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v0, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 17
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v5, -1
    invoke-direct v4, v5, v5, v3, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v4, 20
    int-to-float v4, v4
    mul-float v4, v4, v17
    float-to-int v4, v4
    new-instance v6, Landroid/widget/ImageView;
    invoke-direct v6, v0, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_artifact_loading_spinner I
    invoke-virtual v6, v7, Landroid/widget/ImageView;->setImageResource(I)V
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v7, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v7, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/view/animation/RotateAnimation;
    const/4 v9, 0
    const/high16 v10, 1135869952
    const/4 v11, 1
    const/high16 v12, 1056964608
    const/4 v13, 1
    const/high16 v14, 1056964608
    move-object v8, v4
    invoke-direct/range v8 ... v14, Landroid/view/animation/RotateAnimation;-><init>(F F I F I F)V
    const-wide/16 v7, 1000
    invoke-virtual v4, v7, v8, Landroid/view/animation/RotateAnimation;->setDuration(J)V
    invoke-virtual v4, v5, Landroid/view/animation/RotateAnimation;->setRepeatCount(I)V
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;
    const/16 v7, 8
    invoke-direct v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;-><init>(I)V
    check-cast v5, Landroid/view/animation/Interpolator;
    invoke-virtual v4, v5, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V
    check-cast v4, Landroid/view/animation/Animation;
    invoke-virtual v6, v4, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V
    check-cast v6, Landroid/view/View;
    invoke-virtual v1, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v0, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_artifact_loading I
    invoke-virtual v0, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_disabled I
    invoke-static v0, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v0, 2
    const/high16 v5, 1097859072
    invoke-virtual v4, v0, v5, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v4, v3, Landroid/widget/TextView;->setGravity(I)V
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -2
    invoke-direct v0, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v2, v0, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    int-to-float v2, v7
    mul-float v2, v2, v17
    float-to-int v2, v2
    iput v2, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private final createCardContainer(android.content.Context  float)android.widget.LinearLayout
    .registers 8
    # ins_size=3
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 16
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v1, 12
    int-to-float v1, v1
    mul-float/2addr v1, v7
    float-to-int v1, v1
    invoke-virtual v0, v1, v1, v1, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v2, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->artifactCardBackgroundColor(Landroid/content/Context;)I
    move-result v3
    invoke-virtual v2, v3, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v3, 20
    int-to-float v3, v3
    mul-float/2addr v3, v7
    invoke-virtual v2, v3, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    const/4 v3, 1
    int-to-float v4, v3
    mul-float/2addr v4, v7
    float-to-int v7, v4
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v6, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v2, v7, v6, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    sget-object v6, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v0, v6, Landroid/widget/LinearLayout;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v7, -1
    const/4 v2, -2
    invoke-direct v6, v7, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v1, v6, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v6, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-object v0
.end method

.method private final createChangedCodeSection(android.content.Context  com.bytedance.trae.im.model.ChangedFileData  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 16
    # ins_size=5
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v0
    if-nez v0, +00ah
    new-instance v13, Landroid/widget/LinearLayout;
    invoke-direct v13, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    check-cast v13, Landroid/view/View;
    return-object v13
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v3
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ChangedFileData;->getTotalDiffInfo()Lcom/bytedance/trae/im/model/ArtifactDiffInfo;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +00dh
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ArtifactDiffInfo;->getInsertLineCount()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    move v1, v2
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ChangedFileData;->getTotalDiffInfo()Lcom/bytedance/trae/im/model/ArtifactDiffInfo;
    move-result-object v4
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ArtifactDiffInfo;->getDeleteLineCount()Ljava/lang/Integer;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    goto +2h
    move v4, v2
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v5
    if-eqz v5, +124h
    invoke-interface v5, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v6
    if-nez v6, +004h
    goto/16 +11ch
    const-string v5, "code"
    invoke-virtual v6, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v7
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    const/4 v7, 1
    if-eqz v5, +0d3h
    invoke-direct v11, v12, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createCardContainer(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v13
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->filetype_diff I
    invoke-direct v11, v12, v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v0
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_files_changed I
    new-array v8, v7, [Ljava/lang/Object;
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    aput-object v3, v8, v2
    invoke-virtual v12, v5, v8, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v5, "getString(...)"
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v12, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v3
    check-cast v3, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v5, 16
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v9, "+"
    invoke-direct v8, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v5, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_status_success_default I
    invoke-static v12, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v5, v1, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v1, 2
    const/high16 v8, 1095761920
    invoke-virtual v5, v1, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v5, v7, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, "-"
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v5, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    invoke-static v12, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v5, v4, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v5, v1, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v5, v7, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v5, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -2
    invoke-direct v1, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v7, 4
    int-to-float v7, v7
    mul-float/2addr v7, v14
    float-to-int v7, v7
    invoke-virtual v1, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v3, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v3, 1065353216
    invoke-direct v1, v2, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v2, 6
    int-to-float v2, v2
    mul-float/2addr v2, v14
    float-to-int v14, v2
    invoke-virtual v1, v14, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v14, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda6;
    invoke-direct v14, v15, v6, v11, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/service/Conversation; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context;)V
    invoke-virtual v13, v14, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v13, Landroid/view/View;
    return-object v13
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v1
    const/4 v4, 0
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v4
    move-object v5, v1
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    move v2, v7
    if-nez v2, +018h
    invoke-static v0, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/FileDiffInfo;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    invoke-direct v11, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findMTCLatestTime(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    move-object v7, v0
    goto +2h
    move-object v7, v4
    move-object v0, v11
    move-object v1, v12
    move v2, v14
    move-object v4, v13
    move-object v5, v15
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMtcCodeCard(Landroid/content/Context; F I Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/Long;)Landroid/view/View;
    move-result-object v12
    return-object v12
    new-instance v13, Landroid/widget/LinearLayout;
    invoke-direct v13, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    check-cast v13, Landroid/view/View;
    return-object v13
.end method

.method private static final createChangedCodeSection$lambda$84$lambda$83(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.service.Conversation  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  android.view.View)void
    .registers 15
    # ins_size=5
    sget-object v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v0, "diff"
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v14, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClickWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/products/DiffViewActivity;->Companion Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v14
    const-string v0, ""
    if-nez v14, +004h
    move-object v7, v0
    goto +2h
    move-object v7, v14
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v14
    if-nez v14, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v14
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v6
    invoke-direct v12, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getTitle(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Ljava/lang/String;
    move-result-object v12
    if-nez v12, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v12
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    move-object v3, v13
    invoke-virtual/range v2 ... v9, Lcom/bytedance/trae/conversation/products/DiffViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x0
.end method

.method private final createFileCard(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  boolean)android.view.View
    .registers 9
    # ins_size=7
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v8, +00fh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->MARKDOWN_EXTENSIONS Ljava/util/Set;
    invoke-interface v1, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +007h
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMarkdownPreviewCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v3
    return-object v3
    if-eqz v8, +01fh
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->CODE_EXTENSIONS Ljava/util/Set;
    invoke-interface v8, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +012h
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->TXT_EXTENSIONS Ljava/util/Set;
    invoke-interface v8, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +00ah
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->HTML_EXTENSIONS Ljava/util/Set;
    invoke-interface v8, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +007h
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextPreviewCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v3
    return-object v3
    invoke-direct v2, v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createCardContainer(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v8
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda15;
    invoke-direct v0, v4, v3, v7, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda15;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;)V
    invoke-virtual v8, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v7
    invoke-direct v2, v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getFileTypeIcon(Ljava/lang/String; Ljava/lang/String;)I
    move-result v5
    invoke-direct v2, v3, v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v5
    check-cast v5, Landroid/view/View;
    invoke-virtual v8, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v7
    invoke-direct v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-direct v2, v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v7
    check-cast v7, Landroid/view/View;
    invoke-virtual v5, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v4
    invoke-direct v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    move-object v7, v4
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    const/4 v0, 0
    if-lez v7, +004h
    const/4 v7, 1
    goto +2h
    move v7, v0
    if-eqz v7, +017h
    sget-object v7, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v7, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v7, toUpperCase(...)
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v3
    check-cast v3, Landroid/view/View;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v5, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -2
    const/high16 v7, 1065353216
    invoke-direct v3, v0, v4, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v4, 6
    int-to-float v4, v4
    mul-float/2addr v4, v6
    float-to-int v4, v4
    invoke-virtual v3, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v5, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v8, Landroid/view/View;
    return-object v8
.end method

.method static synthetic createFileCard$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  boolean  int  java.lang.Object)android.view.View
    .registers 16
    # ins_size=9
    and-int/lit8 v14, v14, 32
    if-eqz v14, +003h
    const/4 v13, 0
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createFileCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Z)Landroid/view/View;
    move-result-object v7
    return-object v7
.end method

.method private static final createFileCard$lambda$24$lambda$22(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View)void
    .registers 18
    # ins_size=5
    move-object v1, v14
    invoke-virtual v13, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    const/4 v2, 1
    if-eqz v2, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v14, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v14, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto/16 +0a5h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v2
    if-eqz v2, +09fh
    invoke-interface v2, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +097h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v4
    invoke-interface v4, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    if-nez v4, +003h
    return-void 
    move-object/from16 v5, v16
    invoke-direct v5, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findProducts(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +015h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move-object v5, v0
    goto +23h
    const/4 v5, 2
    const/4 v6, 0
    const-string v7, "/"
    invoke-static v0, v7, v3, v5, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ah
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files/"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v5, v3
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v3
    const-string v6, ""
    if-nez v3, +003h
    move-object v3, v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    move-object v10, v6
    goto +2h
    move-object v10, v4
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v11
    goto +3h
    const-wide/16 v11, 0
    move-object v1, v14
    move-object v2, v3
    move-object v3, v7
    move-object v4, v8
    move-object v6, v9
    move-object v7, v10
    move-wide v8, v11
    invoke-virtual/range v0 ... v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x86
.end method

.method private final createHtmlArtifactCard(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 8
    # ins_size=5
    invoke-direct v3, v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createCardContainer(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;
    invoke-direct v1, v5, v4, v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    invoke-direct v3, v4, v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v7
    check-cast v7, Landroid/view/View;
    invoke-virtual v0, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v7
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v3, v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v1
    check-cast v1, Landroid/view/View;
    invoke-virtual v7, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v5
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 0
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    if-eqz v1, +004h
    const-string v5, "html"
    check-cast v5, Ljava/lang/String;
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v4
    check-cast v4, Landroid/view/View;
    invoke-virtual v7, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v7, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    const/high16 v1, 1065353216
    invoke-direct v4, v2, v5, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v5, 6
    int-to-float v5, v5
    mul-float/2addr v5, v6
    float-to-int v5, v5
    invoke-virtual v4, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v7, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final createHtmlArtifactCard$lambda$62$lambda$59(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.view.View)void
    .registers 12
    # ins_size=5
    invoke-virtual v7, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    const/4 v7, 0
    goto +2h
    const/4 v7, 1
    if-eqz v7, +00ch
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v8, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v8, v7, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto +bh
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v9
    move-object v1, v8
    move-object v2, v10
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->openHtmlArtifactPreview$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Ljava/lang/String; Ljava/lang/Long; I Ljava/lang/Object;)V
    return-void 
.end method

.method private final createHtmlPreviewCard(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 20
    # ins_size=5
    move-object v11, v15
    move-object/from16 v1, v16
    move/from16 v0, v18
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v4, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v4, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-direct/range v15 ... v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->artifactCardBackgroundColor(Landroid/content/Context;)I
    move-result v5
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v5, 20
    int-to-float v5, v5
    mul-float/2addr v5, v0
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    int-to-float v5, v3
    mul-float/2addr v5, v0
    float-to-int v5, v5
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v1, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v4, v5, v6, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    sget-object v4, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -1
    const/4 v7, -2
    invoke-direct v4, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v8, 12
    int-to-float v8, v8
    mul-float/2addr v8, v0
    float-to-int v8, v8
    iput v8, v4, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct v4, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v9, 0
    invoke-virtual v4, v9, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v10, 16
    invoke-virtual v4, v10, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v10, v9
    mul-float/2addr v10, v0
    float-to-int v10, v10
    invoke-virtual v4, v8, v10, v10, v10, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v8
    invoke-direct v15, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getCodeFileIcon(Ljava/lang/String;)I
    move-result v8
    invoke-direct v15, v1, v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createPreviewIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v8
    check-cast v8, Landroid/view/View;
    invoke-virtual v4, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct/range v15 ... v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v8
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v10
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v15, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v10
    check-cast v10, Landroid/view/View;
    invoke-virtual v8, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v10
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    sget-object v12, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v10, v12, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v12, toUpperCase(...)
    invoke-static v10, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v15, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v10
    const/16 v12, 8
    invoke-virtual v10, v12, Landroid/widget/TextView;->setVisibility(I)V
    move-object v13, v10
    check-cast v13, Landroid/view/View;
    invoke-virtual v8, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v8, Landroid/view/View;
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v14, 1065353216
    invoke-direct v13, v9, v7, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v7, 6
    int-to-float v7, v7
    mul-float/2addr v7, v0
    float-to-int v7, v7
    invoke-virtual v13, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v8, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v7, v4
    check-cast v7, Landroid/view/View;
    invoke-virtual v2, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v8, Landroid/view/View;
    invoke-direct v8, v1, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v4, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v1, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v8, v4, Landroid/view/View;->setBackgroundColor(I)V
    invoke-virtual v2, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v4, Landroid/widget/FrameLayout;
    invoke-direct v4, v1, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v9, 151
    int-to-float v9, v9
    mul-float/2addr v9, v0
    float-to-int v9, v9
    invoke-direct v5, v6, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v5, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v5, Landroid/widget/FrameLayout;
    invoke-direct v5, v1, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v9, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v9, v6, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v9, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v15, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createArtifactLoadingView(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v9
    invoke-virtual v5, v9, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v9, Landroid/view/View;
    invoke-direct v9, v1, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v13, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v14, 40
    int-to-float v14, v14
    mul-float/2addr v14, v0
    float-to-int v0, v14
    const/16 v14, 80
    invoke-direct v13, v6, v0, v14, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v13, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_artifact_loading_gradient I
    invoke-virtual v9, v0, Landroid/view/View;->setBackgroundResource(I)V
    invoke-virtual v5, v9, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v4, v5, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v9, Landroid/webkit/WebView;
    invoke-direct v9, v1, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v0, v6, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v0, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v9, v12, Landroid/webkit/WebView;->setVisibility(I)V
    invoke-virtual v9, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v0
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V
    invoke-virtual v0, v3, Landroid/webkit/WebSettings;->setAllowContentAccess(Z)V
    const-string v12, "UTF-8"
    invoke-virtual v0, v12, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    new-instance v0, Landroid/webkit/WebChromeClient;
    invoke-direct v0, Landroid/webkit/WebChromeClient;-><init>()V
    invoke-virtual v9, v0, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V
    new-instance v0, Landroid/webkit/WebViewClient;
    invoke-direct v0, Landroid/webkit/WebViewClient;-><init>()V
    invoke-virtual v9, v0, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    move-object v0, v9
    check-cast v0, Landroid/view/View;
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v1, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v12, Lcom/bytedance/trae/conversation/R$id;->im_artifact_interceptor I
    invoke-virtual v0, v12, Landroid/view/View;->setId(I)V
    new-instance v12, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v12, v6, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v12, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v12, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, v3, Landroid/view/View;->setClickable(Z)V
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda2;
    move-object/from16 v12, v17
    move-object/from16 v13, v19
    invoke-direct v3, v12, v1, v15, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda3;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda3;-><init>(Landroid/widget/LinearLayout;)V
    invoke-virtual v0, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    move-object v14, v2
    check-cast v14, Landroid/view/View;
    move-object v0, v15
    move-object v2, v9
    move-object v3, v5
    move-object v5, v7
    move-object v6, v10
    move-object v7, v8
    move-object v8, v14
    move-object/from16 v9, v17
    move-object/from16 v10, v19
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->loadHtmlContentAsync(Landroid/content/Context; Landroid/webkit/WebView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    return-object v14
.end method

.method private static final createHtmlPreviewCard$lambda$76(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.view.View)void
    .registers 12
    # ins_size=5
    invoke-virtual v7, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Ljava/lang/CharSequence;
    if-eqz v7, +00bh
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v7
    if-nez v7, +003h
    goto +3h
    const/4 v7, 0
    goto +2h
    const/4 v7, 1
    if-eqz v7, +00ch
    sget v7, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v8, v7, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v8, v7, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto +bh
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v9
    move-object v1, v8
    move-object v2, v10
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->openHtmlArtifactPreview$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Ljava/lang/String; Ljava/lang/Long; I Ljava/lang/Object;)V
    return-void 
.end method

.method private static final createHtmlPreviewCard$lambda$77(android.widget.LinearLayout  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/widget/LinearLayout;->performClick()Z
    return-void 
.end method

.method private final createIconContainer(android.content.Context  float  int)android.widget.FrameLayout
    .registers 7
    # ins_size=4
    const/16 v0, 50
    int-to-float v0, v0
    mul-float/2addr v0, v5
    float-to-int v0, v0
    const/16 v1, 40
    int-to-float v1, v1
    mul-float/2addr v1, v5
    float-to-int v5, v1
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v4, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v0, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/ImageView;
    invoke-direct v0, v4, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v6, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v0, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v6, 17
    invoke-direct v4, v5, v5, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-object v1
.end method

.method private final createMarkdownPreviewCard(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 26
    # ins_size=6
    move-object/from16 v11, v20
    move-object/from16 v6, v21
    move/from16 v7, v24
    new-instance v8, Landroid/widget/LinearLayout;
    invoke-direct v8, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v9, 1
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v0, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-direct/range v20 ... v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->artifactCardBackgroundColor(Landroid/content/Context;)I
    move-result v1
    invoke-virtual v0, v1, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v1, 20
    int-to-float v1, v1
    mul-float/2addr v1, v7
    invoke-virtual v0, v1, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    int-to-float v1, v9
    mul-float/2addr v1, v7
    float-to-int v1, v1
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v6, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v1, v2, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v0, Landroid/graphics/drawable/Drawable;
    invoke-virtual v8, v0, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v8, v9, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    sget-object v0, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v8, v0, Landroid/widget/LinearLayout;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v10, -1
    const/4 v2, -2
    invoke-direct v0, v10, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v7
    float-to-int v3, v3
    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v12, 0
    invoke-virtual v0, v12, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v13, 16
    invoke-virtual v0, v13, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v4, v12
    mul-float/2addr v4, v7
    float-to-int v4, v4
    invoke-virtual v0, v3, v4, v4, v4, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v4, v23
    invoke-direct v11, v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getFileTypeIcon(Ljava/lang/String; Ljava/lang/String;)I
    move-result v3
    invoke-direct v11, v6, v7, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createPreviewIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v3
    check-cast v3, Landroid/view/View;
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct/range v20 ... v21, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v3
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v4
    invoke-direct v11, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v11, v6, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v4
    check-cast v4, Landroid/view/View;
    invoke-virtual v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v22, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v4
    invoke-direct v11, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    sget-object v5, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v5, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, toUpperCase(...)
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v6, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v14
    const/16 v15, 8
    invoke-virtual v14, v15, Landroid/widget/TextView;->setVisibility(I)V
    move-object v4, v14
    check-cast v4, Landroid/view/View;
    invoke-virtual v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v5, 1065353216
    invoke-direct v4, v12, v2, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v2, 6
    int-to-float v2, v2
    mul-float/2addr v2, v7
    float-to-int v2, v2
    invoke-virtual v4, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v5, v0
    check-cast v5, Landroid/view/View;
    invoke-virtual v8, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v4, Landroid/view/View;
    invoke-direct v4, v6, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v10, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v6, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v4, v0, Landroid/view/View;->setBackgroundColor(I)V
    invoke-virtual v8, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Landroid/widget/FrameLayout;
    invoke-direct v3, v6, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v1, 151
    int-to-float v1, v1
    mul-float/2addr v1, v7
    float-to-int v1, v1
    invoke-direct v0, v10, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v0, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v6, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v1, v10, v10, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v11, v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createArtifactLoadingView(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/view/View;
    invoke-direct v1, v6, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v9, 40
    int-to-float v9, v9
    mul-float/2addr v9, v7
    float-to-int v9, v9
    const/16 v13, 80
    invoke-direct v2, v10, v9, v13, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_artifact_loading_gradient I
    invoke-virtual v1, v2, Landroid/view/View;->setBackgroundResource(I)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    move-object v9, v0
    check-cast v9, Landroid/view/View;
    invoke-virtual v3, v9, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v2, 0
    const/16 v16, 0
    const/16 v17, 6
    const/16 v18, 0
    move-object v0, v13
    move-object/from16 v1, v21
    move-object/from16 v19, v3
    move/from16 v3, v16
    move-object/from16 v16, v4
    move/from16 v4, v17
    move-object/from16 v17, v5
    move-object/from16 v5, v18
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v0, v10, v10, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v13, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setVisibility(I)V
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setClickable(Z)V
    invoke-virtual v13, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setFocusable(Z)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda9;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda9;-><init>()V
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-virtual v13, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setMaxLines(I)V
    sget-object v0, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v13, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    const/16 v0, 16
    int-to-float v0, v0
    mul-float/2addr v0, v7
    float-to-int v0, v0
    invoke-virtual v13, v0, v12, v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setPadding(I I I I)V
    move-object v0, v13
    check-cast v0, Landroid/view/View;
    move-object/from16 v1, v19
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v6, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->im_artifact_interceptor I
    invoke-virtual v0, v2, Landroid/view/View;->setId(I)V
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v10, v10, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/view/View;->setClickable(Z)V
    invoke-virtual v1, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    move-object v4, v1
    check-cast v4, Landroid/view/View;
    invoke-virtual v8, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda10;
    move-object/from16 v10, v22
    move-object/from16 v12, v25
    invoke-direct v1, v10, v6, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;)V
    invoke-virtual v8, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda11;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda11;-><init>(Landroid/widget/LinearLayout;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    move-object v15, v8
    check-cast v15, Landroid/view/View;
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    move-object v2, v13
    move-object v3, v9
    move-object/from16 v5, v17
    move-object v6, v14
    move-object/from16 v7, v16
    move-object v8, v15
    move-object/from16 v9, v22
    move-object/from16 v10, v25
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->loadMarkdownContentAsync(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    return-object v15
.end method

.method private static final createMarkdownPreviewCard$lambda$48$lambda$47(android.view.View  android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    const/4 v0, 0
    return v0
.end method

.method private static final createMarkdownPreviewCard$lambda$50(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View)void
    .registers 18
    # ins_size=5
    move-object v1, v14
    invoke-virtual v13, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    const/4 v2, 1
    if-eqz v2, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v14, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v14, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto/16 +08ah
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v2
    if-eqz v2, +084h
    invoke-interface v2, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +07ch
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v4
    invoke-interface v4, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    if-nez v4, +003h
    return-void 
    move-object/from16 v5, v16
    invoke-direct v5, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findProducts(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v5
    if-eqz v5, +025h
    const/4 v5, 2
    const/4 v6, 0
    const-string v7, "/"
    invoke-static v0, v7, v3, v5, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ah
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files/"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v5, v3
    goto +2h
    move-object v5, v0
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v3
    const-string v6, ""
    if-nez v3, +003h
    move-object v3, v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    move-object v10, v6
    goto +2h
    move-object v10, v4
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v11
    goto +3h
    const-wide/16 v11, 0
    move-object v1, v14
    move-object v2, v3
    move-object v3, v7
    move-object v4, v8
    move-object v6, v9
    move-object v7, v10
    move-wide v8, v11
    invoke-virtual/range v0 ... v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x6b
.end method

.method private static final createMarkdownPreviewCard$lambda$51(android.widget.LinearLayout  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Landroid/widget/LinearLayout;->performClick()Z
    return-void 
.end method

.method private final createMergeSection(android.content.Context  com.bytedance.trae.im.model.MergeChangedFilesData  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 22
    # ins_size=5
    move-object/from16 v0, v17
    move-object/from16 v1, v18
    move/from16 v2, v20
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v4, 1
    invoke-virtual v3, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -1
    const/4 v7, -2
    invoke-direct v5, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getSourceBranch()Ljava/lang/String;
    move-result-object v5
    const-string v6, ""
    if-nez v5, +003h
    move-object v5, v6
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getBranchDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getTargetBranch()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v6, v8
    invoke-direct v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getBranchDisplayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getTotalDiffInfo()Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
    move-result-object v8
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v9
    if-nez v9, +005h
    check-cast v3, Landroid/view/View;
    return-object v3
    if-eqz v8, +00dh
    invoke-virtual v8, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->getChangedFilesCount()Ljava/lang/Integer;
    move-result-object v10
    if-eqz v10, +007h
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v9
    goto +5h
    invoke-interface v9, Ljava/util/List;->size()I
    move-result v9
    const/4 v10, 0
    if-eqz v8, +00dh
    invoke-virtual v8, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->getConflictCount()Ljava/lang/Integer;
    move-result-object v11
    if-eqz v11, +007h
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v11
    goto +2h
    move v11, v10
    if-eqz v8, +00dh
    invoke-virtual v8, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->getInsertLineCount()Ljava/lang/Integer;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v12, Ljava/lang/Integer;->intValue()I
    move-result v12
    goto +2h
    move v12, v10
    if-eqz v8, +00dh
    invoke-virtual v8, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->getDeleteLineCount()Ljava/lang/Integer;
    move-result-object v8
    if-eqz v8, +007h
    invoke-virtual v8, Ljava/lang/Integer;->intValue()I
    move-result v8
    goto +2h
    move v8, v10
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createCardContainer(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v13
    sget v14, Lcom/bytedance/trae/conversation/R$drawable;->filetype_diff I
    invoke-direct v0, v1, v2, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v14
    check-cast v14, Landroid/view/View;
    invoke-virtual v13, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct/range v17 ... v18, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v14
    sget v15, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_merge_title I
    const/4 v7, 2
    move-object/from16 v16, v3
    new-array v3, v7, [Ljava/lang/Object;
    aput-object v5, v3, v10
    aput-object v6, v3, v4
    invoke-virtual v1, v15, v3, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const-string v5, "getString(...)"
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v3
    check-cast v3, Landroid/view/View;
    invoke-virtual v14, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    if-lez v11, +017h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_merge_subtitle_conflict I
    new-array v5, v7, [Ljava/lang/Object;
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v5, v10
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v5, v4
    invoke-virtual v1, v3, v5, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    goto +fh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_merge_subtitle I
    new-array v5, v4, [Ljava/lang/Object;
    invoke-static v9, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v5, v10
    invoke-virtual v1, v3, v5, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v3
    check-cast v3, Landroid/view/View;
    invoke-virtual v14, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v14, Landroid/view/View;
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v5, 1065353216
    const/4 v6, -2
    invoke-direct v3, v10, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v5, 6
    int-to-float v5, v5
    mul-float/2addr v5, v2
    float-to-int v5, v5
    invoke-virtual v3, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v14, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v5, 16
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v9, "+"
    invoke-direct v6, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v12, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v5, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_status_success_default I
    invoke-static v1, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v5, v6, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v6, 1095761920
    invoke-virtual v5, v7, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v5, v4, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v9, Ljava/lang/StringBuilder;
    const-string v10, " -"
    invoke-direct v9, v10, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v5, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    invoke-static v1, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v5, v8, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v5, v7, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v5, v4, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 8
    int-to-float v5, v5
    mul-float/2addr v5, v2
    float-to-int v2, v5
    invoke-virtual v4, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;
    move-object/from16 v3, v19
    move-object/from16 v4, v21
    invoke-direct v2, v4, v1, v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V
    invoke-virtual v13, v2, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v13, Landroid/view/View;
    move-object/from16 v1, v16
    invoke-virtual v1, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    return-object v3
.end method

.method private static final createMergeSection$lambda$100(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  com.bytedance.trae.im.model.MergeChangedFilesData  android.view.View)void
    .registers 7
    # ins_size=5
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v0, "merge_view"
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClickWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/products/MargeViewActivity;->Companion Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getTitle(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getChatSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v6, v3, v4, v2, v5, Lcom/bytedance/trae/conversation/products/MargeViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/model/MergeChangedFilesData;)V
    return-void 
    :try_start_0x0
.end method

.method private final createMtcCodeCard(android.content.Context  float  int  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.service.Conversation  java.lang.Long)android.view.View
    .registers 18
    # ins_size=8
    move-object v2, v11
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-direct v6, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 0
    invoke-virtual v6, v0, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v1, 16
    invoke-virtual v6, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v1, 12
    int-to-float v1, v1
    mul-float/2addr v1, v12
    float-to-int v1, v1
    invoke-virtual v6, v1, v1, v1, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-direct v10, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->artifactCardBackgroundColor(Landroid/content/Context;)I
    move-result v4
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v4, 20
    int-to-float v4, v4
    mul-float/2addr v4, v12
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    const/4 v4, 1
    int-to-float v5, v4
    mul-float/2addr v5, v12
    float-to-int v5, v5
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v11, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v3, v5, v7, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v6, v3, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v6, v4, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    sget-object v3, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v6, v3, Landroid/widget/LinearLayout;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v7, -2
    invoke-direct v3, v5, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v1, v3, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v1, 50
    int-to-float v1, v1
    mul-float/2addr v1, v12
    float-to-int v1, v1
    const/16 v3, 40
    int-to-float v3, v3
    mul-float/2addr v3, v12
    float-to-int v3, v3
    new-instance v5, Landroid/widget/FrameLayout;
    invoke-direct v5, v11, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v8, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/ImageView;
    invoke-direct v1, v11, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v8, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_diff_large I
    invoke-virtual v1, v8, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v8, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v1, v8, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v1, Landroid/view/View;
    new-instance v8, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v9, 17
    invoke-direct v8, v3, v3, v9, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v1, v8, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v6, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_code_files I
    new-array v5, v4, [Ljava/lang/Object;
    invoke-static v13, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    aput-object v8, v5, v0
    invoke-virtual v11, v3, v5, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const-string v3, "#171717"
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    invoke-virtual v1, v3, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v3, 2
    const/high16 v5, 1099431936
    invoke-virtual v1, v3, v5, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v3, sans-serif
    invoke-static v3, v0, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v3
    invoke-virtual v1, v3, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v3, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v1, v0, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v4, 1065353216
    invoke-direct v3, v0, v7, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/16 v0, 8
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v0, v0
    invoke-virtual v3, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    invoke-virtual v6, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;
    move-object v0, v7
    move-object v1, v15
    move-object v3, v14
    move-object/from16 v4, v16
    move-object/from16 v5, v17
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Lcom/bytedance/trae/im/model/ChangedFileData; Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/Long;)V
    invoke-virtual v6, v7, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v6, Landroid/view/View;
    return-object v6
.end method

.method private static final createMtcCodeCard$lambda$92$lambda$91(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  com.bytedance.trae.im.model.ChangedFileData  com.bytedance.trae.im.service.Conversation  java.lang.Long  android.view.View)void
    .registers 19
    # ins_size=6
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v1, "diff"
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClickWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity;->Companion Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;
    invoke-virtual/range v16, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v0
    const-string v1, ""
    if-nez v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v0
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v16, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v8, v1
    goto +2h
    move-object v8, v0
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v16, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v10, v1
    goto +2h
    move-object v10, v0
    if-eqz v17, +007h
    invoke-virtual/range v17, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, 0
    move-wide v11, v0
    move-object v4, v14
    move-object v5, v15
    invoke-virtual/range v3 ... v12, Lcom/bytedance/trae/conversation/products/CodeChangedListActivity$Companion;->start(Landroid/content/Context; Lcom/bytedance/trae/im/model/ChangedFileData; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x0
.end method

.method private final createMultiImagePreviewCard(android.content.Context  java.util.List  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 25
    # ins_size=5
    move-object/from16 v7, v21
    move-object/from16 v8, v22
    invoke-interface/range v22, Ljava/util/List;->size()I
    move-result v0
    const/4 v9, 1
    const/4 v10, 0
    const/4 v11, 2
    if-ne v0, v11, +004h
    move v12, v9
    goto +2h
    move v12, v10
    if-eqz v12, +005h
    const/16 v0, 140
    goto +3h
    const/16 v0, 84
    int-to-float v0, v0
    mul-float v0, v0, v23
    float-to-int v0, v0
    move v13, v0
    const/16 v0, 20
    int-to-float v0, v0
    mul-float v14, v0, v23
    new-instance v15, Landroid/widget/LinearLayout;
    invoke-direct v15, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v15, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    if-eqz v12, +007h
    const/16 v0, 16
    invoke-virtual v15, v0, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v6, 12
    const/4 v5, -2
    if-eqz v12, +010h
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v1, v6
    mul-float v1, v1, v23
    float-to-int v1, v1
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    goto +8h
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v0, v5, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    move-object v4, v0
    check-cast v4, Ljava/util/List;
    move-object v0, v8
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v16
    move v3, v10
    invoke-interface/range v16, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +093h
    invoke-interface/range v16, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    add-int/lit8 v17, v3, 1
    if-gez v3, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/im/model/FileDiffInfo;
    new-instance v1, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v1, v7, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v13, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-interface/range v22, Ljava/util/List;->size()I
    move-result v18
    add-int/lit8 v5, v18, -1
    if-ge v3, v5, +00bh
    const/16 v5, 8
    int-to-float v5, v5
    mul-float v5, v5, v23
    float-to-int v5, v5
    invoke-virtual v0, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    invoke-virtual v1, Lcom/facebook/drawee/view/SimpleDraweeView;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-direct v0, v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;-><init>(Landroid/content/res/Resources;)V
    invoke-static v14, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v5
    invoke-virtual v0, v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v0
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_image_loading I
    sget-object v6, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v0, v5, v6, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setPlaceholderImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v0
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    sget-object v6, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v0, v5, v6, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setFailureImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v0
    if-eqz v12, +007h
    sget-object v5, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v0, v5, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    invoke-virtual v0, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->build()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->setHierarchy(Lcom/facebook/drawee/interfaces/DraweeHierarchy;)V
    invoke-interface v4, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    move-object v0, v1
    check-cast v0, Landroid/view/View;
    invoke-virtual v15, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;
    move-object v0, v6
    move-object v5, v1
    move-object/from16 v1, v24
    move/from16 v19, v3
    move-object/from16 v3, v20
    move-object v9, v4
    move-object/from16 v4, v22
    move-object v11, v5
    move-object/from16 v5, v21
    move-object v10, v6
    move/from16 v18, v13
    const/16 v13, 12
    move/from16 v6, v19
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/util/List; Landroid/content/Context; I)V
    invoke-virtual v11, v10, Lcom/facebook/drawee/view/SimpleDraweeView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    move-object v4, v9
    move v6, v13
    move/from16 v3, v17
    move/from16 v13, v18
    const/4 v5, -2
    const/4 v9, 1
    const/4 v10, 0
    const/4 v11, 2
    goto/16 -095h
    move-object/from16 v0, v20
    move-object/from16 v1, v24
    move-object v9, v4
    move v13, v6
    invoke-direct v0, v7, v9, v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->loadImagesAsync(Landroid/content/Context; Ljava/util/List; Ljava/util/List; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    if-eqz v12, +005h
    check-cast v15, Landroid/view/View;
    return-object v15
    new-instance v1, Landroid/widget/HorizontalScrollView;
    invoke-direct v1, v7, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/HorizontalScrollView;->setHorizontalScrollBarEnabled(Z)V
    const/4 v2, 2
    invoke-virtual v1, v2, Landroid/widget/HorizontalScrollView;->setOverScrollMode(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v3, v13
    mul-float v3, v3, v23
    float-to-int v3, v3
    iput v3, v2, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v2, Landroid/widget/HorizontalScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v15, Landroid/view/View;
    invoke-virtual v1, v15, Landroid/widget/HorizontalScrollView;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private static final createMultiImagePreviewCard$lambda$133$lambda$132(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.util.List  android.content.Context  int  android.view.View)void
    .registers 23
    # ins_size=7
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +0bdh
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +0b5h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    move-object/from16 v3, v18
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findProducts(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    move-object/from16 v3, v19
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +03eh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    if-nez v5, +003h
    goto +29h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v7
    if-eqz v7, +023h
    const/4 v7, 0
    const/4 v8, 2
    const-string v9, "/"
    invoke-static v5, v9, v7, v8, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +00ah
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "files"
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "files/"
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    move-object v6, v5
    if-eqz v6, -03ch
    invoke-interface v4, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -41h
    check-cast v4, Ljava/util/List;
    check-cast v4, Ljava/util/Collection;
    new-instance v10, Ljava/util/ArrayList;
    invoke-direct v10, v4, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v2
    const-string v3, ""
    if-nez v2, +004h
    move-object v7, v3
    goto +2h
    move-object v7, v2
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v9, v3
    goto +2h
    move-object v9, v2
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v13, v3
    goto +2h
    move-object v13, v1
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, 0
    move-wide v14, v0
    move-object/from16 v6, v20
    move/from16 v11, v21
    invoke-virtual/range v5 ... v15, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/ArrayList; I Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x80
.end method

.method private final createPreviewCard(android.content.Context  com.bytedance.trae.im.model.PreviewData  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 11
    # ins_size=5
    invoke-direct v6, v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createCardContainer(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_preview I
    invoke-direct v6, v7, v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v1
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_web I
    invoke-virtual v7, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v2
    const-string v3, "getString(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v8, Lcom/bytedance/trae/im/model/PreviewData;->getPreviewUrl()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +00bh
    invoke-direct v6, v7, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -2
    const/high16 v4, 1065353216
    const/4 v5, 0
    invoke-direct v2, v5, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v3, 6
    int-to-float v3, v3
    mul-float/2addr v3, v9
    float-to-int v9, v3
    invoke-virtual v2, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v8, Lcom/bytedance/trae/im/model/PreviewData;->getPreviewUrl()Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00ah
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;
    invoke-direct v9, v10, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Landroid/content/Context; Ljava/lang/String;)V
    invoke-virtual v0, v9, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final createPreviewCard$lambda$21$lambda$20$lambda$19(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  android.content.Context  java.lang.String  android.view.View)void
    .registers 12
    # ins_size=4
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v11
    if-eqz v11, +079h
    invoke-interface v11, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v11
    if-nez v11, +004h
    goto/16 +071h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +058h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +46h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v1, "http_url"
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v1, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClickWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity;->Companion Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;
    sget v8, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_web I
    invoke-virtual v9, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v8
    const-string v0, ""
    if-nez v8, +004h
    move-object v6, v0
    goto +2h
    move-object v6, v8
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +004h
    move-object v7, v0
    goto +2h
    move-object v7, v8
    move-object v3, v9
    move-object v4, v10
    invoke-virtual/range v2 ... v7, Lcom/bytedance/trae/conversation/products/PreviewWebViewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    goto +18h
    new-instance v8, Landroid/content/Intent;
    const-string v11, "android.intent.action.VIEW"
    invoke-static v10, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v10
    invoke-direct v8, v11, v10, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    instance-of v10, v9, Landroid/app/Activity;
    if-nez v10, +007h
    const/high16 v10, 268435456
    invoke-virtual v8, v10, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v9, v8, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v9, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v9, v8, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
    :try_start_0x2f
    :try_start_0x4d
    :try_start_0x5c
.end method

.method private final createPreviewIconContainer(android.content.Context  float  int)android.widget.FrameLayout
    .registers 7
    # ins_size=4
    const/16 v0, 36
    int-to-float v0, v0
    mul-float/2addr v0, v5
    float-to-int v5, v0
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v4, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -2
    invoke-direct v1, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/ImageView;
    invoke-direct v1, v4, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v6, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v1, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->img_im_artifact I
    invoke-virtual v0, v4, Landroid/widget/FrameLayout;->setId(I)V
    check-cast v1, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v6, 17
    invoke-direct v4, v5, v5, v6, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-object v0
.end method

.method private final createSingleImagePreviewCard(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 13
    # ins_size=5
    const/16 v0, 230
    int-to-float v0, v0
    mul-float/2addr v0, v11
    float-to-int v5, v0
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v9, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 12
    int-to-float v2, v2
    mul-float/2addr v2, v11
    float-to-int v2, v2
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v3, v9, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v2, -1
    invoke-direct v1, v2, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v1, Lcom/facebook/drawee/view/SimpleDraweeView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    invoke-virtual v3, Lcom/facebook/drawee/view/SimpleDraweeView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-direct v1, v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;-><init>(Landroid/content/res/Resources;)V
    const/16 v2, 20
    int-to-float v2, v2
    mul-float/2addr v2, v11
    invoke-static v2, Lcom/facebook/drawee/generic/RoundingParams;->fromCornersRadius(F)Lcom/facebook/drawee/generic/RoundingParams;
    move-result-object v11
    invoke-virtual v1, v11, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setRoundingParams(Lcom/facebook/drawee/generic/RoundingParams;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v11
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_image_loading I
    sget-object v2, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER_CROP Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v11, v1, v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setPlaceholderImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v11
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_image_break I
    sget-object v2, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->CENTER Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v11, v1, v2, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setFailureImage(I Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v11
    sget-object v1, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->FIT_CENTER Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v11, v1, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v11
    invoke-virtual v11, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->build()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    move-result-object v11
    check-cast v11, Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    invoke-virtual v3, v11, Lcom/facebook/drawee/view/SimpleDraweeView;->setHierarchy(Lcom/facebook/drawee/interfaces/DraweeHierarchy;)V
    move-object v11, v3
    check-cast v11, Landroid/view/View;
    invoke-virtual v0, v11, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;
    invoke-direct v11, v12, v10, v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context;)V
    invoke-virtual v3, v11, Lcom/facebook/drawee/view/SimpleDraweeView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    move-object v1, v8
    move-object v2, v9
    move-object v4, v0
    move-object v6, v10
    move-object v7, v12
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->loadSingleImageAsync(Landroid/content/Context; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final createSingleImagePreviewCard$lambda$124(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  android.view.View)void
    .registers 23
    # ins_size=5
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +096h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +08eh
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    if-nez v1, +003h
    return-void 
    invoke-virtual/range v19, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    move-object/from16 v3, v20
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findProducts(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v3
    const/4 v4, 0
    if-eqz v3, +024h
    const/4 v3, 2
    const/4 v5, 0
    const-string v6, "/"
    invoke-static v2, v6, v4, v3, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ah
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files/"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v2
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v5, v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v2
    const-string v5, ""
    if-nez v2, +004h
    move-object v9, v5
    goto +2h
    move-object v9, v2
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    move-object v11, v5
    goto +2h
    move-object v11, v2
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/String;
    aput-object v3, v2, v4
    invoke-static v2, Lkotlin/collections/CollectionsKt;->arrayListOf([Ljava/lang/Object;)Ljava/util/ArrayList;
    move-result-object v12
    const/4 v13, 0
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v15, v5
    goto +2h
    move-object v15, v1
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, 0
    move-wide/from16 v16, v0
    move-object/from16 v8, v21
    invoke-virtual/range v7 ... v17, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/ArrayList; I Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x50
.end method

.method private final createSkillCard(android.content.Context  com.bytedance.trae.im.model.SkillInfo  float)android.view.View
    .registers 8
    # ins_size=4
    invoke-direct v4, v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createCardContainer(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda8;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda8;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_skill I
    invoke-direct v4, v5, v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v1
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/im/model/SkillInfo;->getSkillName()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    invoke-direct v4, v5, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v2
    check-cast v2, Landroid/view/View;
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v6, Lcom/bytedance/trae/im/model/SkillInfo;->getFilePath()Ljava/lang/String;
    move-result-object v6
    if-eqz v6, +00bh
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v5
    check-cast v5, Landroid/view/View;
    invoke-virtual v1, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v1, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -2
    const/high16 v2, 1065353216
    const/4 v3, 0
    invoke-direct v5, v3, v6, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v6, 6
    int-to-float v6, v6
    mul-float/2addr v6, v7
    float-to-int v6, v6
    invoke-virtual v5, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final createSkillCard$lambda$58$lambda$55(android.content.Context  android.view.View)void
    .registers 2
    # ins_size=2
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method

.method private final createSubtitleText(android.content.Context  java.lang.String)android.widget.TextView
    .registers 4
    # ins_size=3
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v2, 2
    const/high16 v3, 1097859072
    invoke-virtual v0, v2, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    return-object v0
.end method

.method private final createTextContainer(android.content.Context)android.widget.LinearLayout
    .registers 3
    # ins_size=2
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v2, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    return-object v0
.end method

.method private final createTextPreviewCard(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  float  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 22
    # ins_size=6
    move-object/from16 v11, v16
    move-object/from16 v1, v17
    move/from16 v0, v20
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v4, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v4, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->artifactCardBackgroundColor(Landroid/content/Context;)I
    move-result v5
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v5, 20
    int-to-float v5, v5
    mul-float/2addr v5, v0
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    int-to-float v5, v3
    mul-float/2addr v5, v0
    float-to-int v5, v5
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v1, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v4, v5, v6, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    sget-object v3, Landroid/view/ViewOutlineProvider;->BACKGROUND Landroid/view/ViewOutlineProvider;
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOutlineProvider(Landroid/view/ViewOutlineProvider;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v6, -2
    invoke-direct v3, v4, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v7, 12
    int-to-float v7, v7
    mul-float/2addr v7, v0
    float-to-int v7, v7
    iput v7, v3, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v8, 0
    invoke-virtual v3, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v9, 16
    invoke-virtual v3, v9, Landroid/widget/LinearLayout;->setGravity(I)V
    int-to-float v10, v8
    mul-float/2addr v10, v0
    float-to-int v10, v10
    invoke-virtual v3, v7, v10, v10, v10, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v7
    move-object/from16 v10, v19
    invoke-direct v11, v10, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->getFileTypeIcon(Ljava/lang/String; Ljava/lang/String;)I
    move-result v7
    invoke-direct v11, v1, v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createPreviewIconContainer(Landroid/content/Context; F I)Landroid/widget/FrameLayout;
    move-result-object v7
    check-cast v7, Landroid/view/View;
    invoke-virtual v3, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTextContainer(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v7
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v10
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v11, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createTitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v10
    check-cast v10, Landroid/view/View;
    invoke-virtual v7, v10, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v10
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    sget-object v12, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v10, v12, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v12, toUpperCase(...)
    invoke-static v10, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v11, v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSubtitleText(Landroid/content/Context; Ljava/lang/String;)Landroid/widget/TextView;
    move-result-object v10
    const/16 v12, 8
    invoke-virtual v10, v12, Landroid/widget/TextView;->setVisibility(I)V
    move-object v13, v10
    check-cast v13, Landroid/view/View;
    invoke-virtual v7, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v7, Landroid/view/View;
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v14, 1065353216
    invoke-direct v13, v8, v6, v14, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v6, 6
    int-to-float v6, v6
    mul-float/2addr v6, v0
    float-to-int v6, v6
    invoke-virtual v13, v6, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v7, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v6, v3
    check-cast v6, Landroid/view/View;
    invoke-virtual v2, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v7, Landroid/view/View;
    invoke-direct v7, v1, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v3, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v1, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v7, v3, Landroid/view/View;->setBackgroundColor(I)V
    invoke-virtual v2, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v3, Landroid/widget/FrameLayout;
    invoke-direct v3, v1, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v13, 151
    int-to-float v13, v13
    mul-float/2addr v13, v0
    float-to-int v13, v13
    invoke-direct v5, v4, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v5, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v5, Landroid/widget/FrameLayout;
    invoke-direct v5, v1, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v13, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v13, v4, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v13, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v11, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createArtifactLoadingView(Landroid/content/Context; F)Landroid/view/View;
    move-result-object v13
    invoke-virtual v5, v13, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v13, Landroid/view/View;
    invoke-direct v13, v1, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v14, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v15, 40
    int-to-float v15, v15
    mul-float/2addr v15, v0
    float-to-int v15, v15
    const/16 v9, 80
    invoke-direct v14, v4, v15, v9, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v14, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v9, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_artifact_loading_gradient I
    invoke-virtual v13, v9, Landroid/view/View;->setBackgroundResource(I)V
    invoke-virtual v5, v13, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    check-cast v5, Landroid/view/View;
    invoke-virtual v3, v5, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    new-instance v9, Landroid/widget/TextView;
    invoke-direct v9, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v13, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v13, v4, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v13, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v9, v12, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v9, v12, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v9, v4, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v1, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v9, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v4, 2
    const/high16 v12, 1095761920
    invoke-virtual v9, v4, v12, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v9, v8, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const/16 v4, 16
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v0, v4
    invoke-virtual v9, v0, v8, v0, v0, Landroid/widget/TextView;->setPadding(I I I I)V
    move-object v0, v9
    check-cast v0, Landroid/view/View;
    invoke-virtual v3, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    move-object v4, v3
    check-cast v4, Landroid/view/View;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda13;
    move-object/from16 v12, v18
    move-object/from16 v13, v21
    invoke-direct v0, v12, v1, v13, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;)V
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    move-object v14, v2
    check-cast v14, Landroid/view/View;
    move-object/from16 v0, v16
    move-object v2, v9
    move-object v3, v5
    move-object v5, v6
    move-object v6, v10
    move-object v8, v14
    move-object/from16 v9, v18
    move-object/from16 v10, v21
    invoke-direct/range v0 ... v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->loadTextContentAsync(Landroid/content/Context; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/im/model/FileDiffInfo; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    return-object v14
.end method

.method private static final createTextPreviewCard$lambda$36(com.bytedance.trae.im.model.FileDiffInfo  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.view.View)void
    .registers 18
    # ins_size=5
    move-object v1, v14
    invoke-virtual v13, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    const/4 v2, 1
    if-eqz v2, +00dh
    sget v0, Lcom/bytedance/trae/multilanguage/R$string;->trae_skill_preview_unsupported I
    invoke-virtual v14, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v14, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; Ljava/lang/String;)V
    goto/16 +08ah
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v2
    if-eqz v2, +084h
    invoke-interface v2, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +07ch
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v4
    invoke-interface v4, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    if-nez v4, +003h
    return-void 
    move-object/from16 v5, v16
    invoke-direct v5, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findProducts(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v5
    if-eqz v5, +025h
    const/4 v5, 2
    const/4 v6, 0
    const-string v7, "/"
    invoke-static v0, v7, v3, v5, v6, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00ah
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v5, "files/"
    invoke-direct v3, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v5, v3
    goto +2h
    move-object v5, v0
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v3, v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v3
    const-string v6, ""
    if-nez v3, +003h
    move-object v3, v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v6
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    move-object v10, v6
    goto +2h
    move-object v10, v4
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v11
    goto +3h
    const-wide/16 v11, 0
    move-object v1, v14
    move-object v2, v3
    move-object v3, v7
    move-object v4, v8
    move-object v6, v9
    move-object v7, v10
    move-wide v8, v11
    invoke-virtual/range v0 ... v9, Lcom/bytedance/trae/conversation/products/ArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
    :try_start_0x6b
.end method

.method private final createTitleText(android.content.Context  java.lang.String)android.widget.TextView
    .registers 4
    # ins_size=3
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v2, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v2, 2
    const/high16 v3, 1099431936
    invoke-virtual v0, v2, v3, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v2, sans-serif
    const/4 v3, 0
    invoke-static v2, v3, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v0, v3, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    return-object v0
.end method

.method private final downloadAndExtractHtml(android.content.Context  java.lang.String  java.lang.String  java.lang.String  java.lang.String  org.json.JSONObject  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;
    const/4 v8, 0
    move-object v1, v9
    move-object v2, v15
    move-object v3, v12
    move-object v4, v14
    move-object v5, v13
    move-object/from16 v6, v16
    move-object v7, v11
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$downloadAndExtractHtml$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object/from16 v1, v17
    invoke-static v0, v9, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final extractFileExtension(java.lang.String)java.lang.String
    .registers 11
    # ins_size=2
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const-string v2, ""
    if-eqz v0, +003h
    return-object v2
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    move-object v3, v10
    check-cast v3, Ljava/lang/CharSequence;
    const/16 v4, 46
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-lez v0, +00dh
    add-int/2addr v0, v1
    invoke-virtual v10, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v10, substring(...)
    invoke-static v2, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final extractFileName(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    const/4 v2, 1
    if-eqz v2, +005h
    const-string v6, ""
    return-object v6
    const/16 v2, 92
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/16 v2, 47
    invoke-static v6, v2, v4, v3, v4, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private final extractPrimaryArtifactPath(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v6, +00bh
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v0
    goto +2h
    move v2, v1
    const/4 v3, 0
    if-eqz v2, +003h
    return-object v3
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->COMPUTER_LINK_REGEX Lkotlin/text/Regex;
    const/4 v4, 2
    invoke-static v2, v6, v0, v4, v3, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v6
    if-nez v6, +003h
    return-object v3
    invoke-interface v6, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v6
    invoke-interface v6, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    return-object v6
.end method

.method private final fetchHtmlArchiveUrl(java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 17
    # ins_size=7
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;
    const/4 v8, 0
    move-object v1, v9
    move-object v2, v12
    move-object v3, v11
    move-object v4, v13
    move-object v5, v10
    move-object v6, v14
    move-object v7, v15
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlArchiveUrl$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object/from16 v1, v16
    invoke-static v0, v9, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final fetchHtmlDownloadUrlWithRetry(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 25
    # ins_size=5
    move-object/from16 v0, v24
    instance-of v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->label I
    move-object/from16 v2, v20
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;
    move-object/from16 v2, v20
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v4, +038h
    if-eq v4, v6, +024h
    if-ne v4, v5, +01ah
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->I$0 I
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v15, v1
    move-object v14, v3
    move v0, v5
    move-object v3, v8
    move-object v1, v9
    goto/16 +0b3h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->I$0 I
    iget-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    check-cast v10, Ljava/lang/String;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +49h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    const/4 v0, 0
    move v4, v0
    move-object v15, v1
    move-object v14, v3
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    move-object/from16 v3, v23
    const/16 v8, 21
    if-ge v4, v8, +09bh
    sget-object v13, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v12, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v9
    const/16 v16, 0
    const/16 v17, 8
    const/16 v18, 0
    move-object v8, v12
    move-object v10, v1
    move-object v11, v3
    move-object v7, v12
    move-object/from16 v12, v16
    move-object v5, v13
    move/from16 v13, v17
    move-object/from16 v19, v14
    move-object/from16 v14, v18
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v1, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v3, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    iput v4, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->I$0 I
    iput v6, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->label I
    invoke-virtual v5, v7, v15, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    move-object/from16 v7, v19
    if-ne v5, v7, +003h
    return-object v7
    move-object v10, v0
    move-object v9, v1
    move-object v8, v3
    move-object v0, v5
    move-object v3, v7
    move-object v1, v15
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v5, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +052h
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
    invoke-interface v5, v10, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    goto +2h
    const/4 v5, 0
    if-eqz v5, +003h
    return-object v5
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v11
    const-wide/16 v13, 202
    cmp-long v0, v11, v13
    if-nez v0, +023h
    const/16 v0, 20
    if-ge v4, v0, +01fh
    iput-object v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$0 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$1 Ljava/lang/Object;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->L$2 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->I$0 I
    const/4 v0, 2
    iput v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1;->label I
    const-wide/16 v11, 2000
    invoke-static v11, v12, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v3, +003h
    return-object v3
    move-object v15, v1
    move-object v14, v3
    goto/16 -0b3h
    add-int/2addr v4, v6
    move v5, v0
    move-object v0, v10
    goto/16 -08dh
    const/4 v1, 0
    return-object v1
    const/4 v1, 0
    instance-of v0, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +003h
    return-object v1
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    const/4 v1, 0
    return-object v1
.end method

.method private final findMTCLatestTime(java.util.List  java.lang.String)java.lang.Long
    .registers 9
    # ins_size=3
    const/4 v0, 0
    check-cast v7, Ljava/lang/Iterable;
    invoke-static v7, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v7
    invoke-interface v7, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +0d1h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v2
    if-eqz v2, -010h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v2
    if-eqz v2, -016h
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, -04bh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v3
    if-nez v3, +003h
    goto -12h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v3
    if-eqz v3, -017h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-nez v3, +003h
    goto -1fh
    new-instance v4, Lcom/google/gson/Gson;
    invoke-direct v4, Lcom/google/gson/Gson;-><init>()V
    check-cast v3, Lcom/google/gson/JsonElement;
    const-class v5, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v4, v3, v5, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/FinishCardResult;->getData()Lcom/bytedance/trae/im/model/FinishCardResultData;
    move-result-object v4
    if-eqz v4, +008h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FinishCardResultData;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v4
    if-nez v4, +006h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/FinishCardResult;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v4
    if-eqz v4, -03fh
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedCodes()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v3
    goto +2h
    move-object v3, v0
    invoke-static v3, Lkotlin/collections/CollectionsKt;->listOfNotNull(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->flatten(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    instance-of v4, v3, Ljava/util/Collection;
    const/4 v5, 0
    if-eqz v4, +00ch
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +1ch
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +013h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -014h
    const/4 v5, 1
    if-eqz v5, -083h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v7
    invoke-static v7, v8, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    return-object v7
    return-object v0
    :try_start_0x1
    :try_start_0x72
    :try_start_0x81
.end method

.method private final findProducts(java.util.List  java.lang.String)java.lang.Long
    .registers 8
    # ins_size=3
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v6, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v6
    invoke-interface v6, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +093h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getTaskContent()Lcom/bytedance/trae/im/model/ParsedTaskContent;
    move-result-object v1
    if-eqz v1, -010h
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedTaskContent;->getMessages()Ljava/util/List;
    move-result-object v1
    if-eqz v1, -016h
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +012h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedPlanItemMessage;->getPlanItem()Lcom/bytedance/trae/im/model/ParsedPlanItem;
    move-result-object v3
    if-eqz v3, -010h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->reversed(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, -04bh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedPlanItem;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    if-nez v2, +003h
    goto -12h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getResult()Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v2
    if-eqz v2, -017h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    if-nez v2, +003h
    goto -1fh
    new-instance v3, Lcom/google/gson/Gson;
    invoke-direct v3, Lcom/google/gson/Gson;-><init>()V
    check-cast v2, Lcom/google/gson/JsonElement;
    const-class v4, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v3, v2, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/model/FinishCardResult;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FinishCardResult;->getData()Lcom/bytedance/trae/im/model/FinishCardResultData;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/FinishCardResultData;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v3
    if-nez v3, +006h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FinishCardResult;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v3
    if-eqz v3, -03fh
    invoke-direct v5, v3, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->containsFilePath(Lcom/bytedance/trae/im/model/ArtifactData; Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, -045h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getCreatedAt()J
    move-result-wide v6
    invoke-static v6, v7, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v6
    return-object v6
    const/4 v6, 0
    return-object v6
    :try_start_0x0
    :try_start_0x71
    :try_start_0x80
.end method

.method private final getBranchDisplayName(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "origin/"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v2, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method private final getCodeFileIcon(java.lang.String)int
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    return v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +0000194h
    goto/16 +18eh
    const-string v0, "markdown"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +13bh
    goto/16 +184h
    const-string/jumbo v0, yaml
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +06bh
    goto/16 +179h
    const-string/jumbo v0, scss
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00fh
    goto/16 +16eh
    const-string/jumbo v0, sass
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +163h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    goto/16 +161h
    const-string v0, "less"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +155h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    goto/16 +153h
    const-string v0, "json"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +147h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_json I
    goto/16 +145h
    const-string v0, "java"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +139h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    goto/16 +137h
    const-string v0, "html"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +12bh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_html I
    goto/16 +129h
    const-string v0, "bash"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +0ach
    goto/16 +11dh
    const-string/jumbo v0, yml
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +112h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_yaml I
    goto/16 +110h
    const-string/jumbo v0, xml
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +103h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_xml I
    goto/16 +101h
    const-string/jumbo v0, vue
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0f4h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_vue I
    goto/16 +0f2h
    const-string/jumbo v0, tsx
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0e5h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_react I
    goto/16 +0e3h
    const-string v0, "kts"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +09ah
    goto/16 +0d7h
    const-string v0, "jsx"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0cdh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_react I
    goto/16 +0cbh
    const-string v0, "hpp"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +0b2h
    goto/16 +0bfh
    const-string v0, "dts"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0b5h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_dts I
    goto/16 +0b3h
    const-string v0, "cxx"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +08eh
    goto/16 +0a7h
    const-string v0, "css"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +09dh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    goto/16 +09bh
    const-string v0, "cpp"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +076h
    goto/16 +08fh
    const-string/jumbo v0, ts
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +084h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_ts I
    goto/16 +082h
    const-string/jumbo v0, sh
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +075h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_bash I
    goto/16 +073h
    const-string/jumbo v0, rs
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +066h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_rs I
    goto/16 +064h
    const-string v0, "py"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +58h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_python I
    goto +57h
    const-string v0, "md"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4ch
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_markdown I
    goto +4bh
    const-string v0, "kt"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +40h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    goto +3fh
    const-string v0, "js"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +34h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_js I
    goto +33h
    const-string v0, "go"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +28h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_go I
    goto +27h
    const-string v0, "cc"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1ch
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_cpp I
    goto +1bh
    const-string v0, "h"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +10h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_header I
    goto +fh
    const-string v0, "c"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_c I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    return v2
    sparse-switch-payload 63 68 c60 ce8 d49 d69 d97 e09 e41 e55 e7f 181a3 18203 182a3 185e3 19468 19c4f 1a02a 1c1d9 1c986 1d017 1d3d8 2e06d4 3107ab 31aa22 31ece8 32a199 35c12e 35c8b0 387aa7 eb7fcef
.end method

.method private final getFileTypeIcon(java.lang.String  java.lang.String)int
    .registers 6
    # ins_size=3
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Ljava/lang/String;->hashCode()I
    move-result v0
    const-string v1, "jpeg"
    const-string v2, "jpg"
    sparse-switch v0, +00001f2h
    goto/16 +1ebh
    const-string/jumbo v5, slide
    invoke-virtual v4, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +1e0h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_ppt I
    goto/16 +1deh
    const-string/jumbo v5, sheet
    invoke-virtual v4, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +1d1h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_excel I
    goto/16 +1cfh
    const-string v0, "image"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +1c3h
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +00dh
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_png I
    goto/16 +1b4h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_jpg I
    goto/16 +1b0h
    const-string v5, "code"
    invoke-virtual v4, v5, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +1a4h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    goto/16 +1a2h
    const-string v0, "doc"
    invoke-virtual v4, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +196h
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v4
    sparse-switch v4, +00001aah
    goto/16 +18ah
    const-string v4, "markdown"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +16ah
    goto/16 +180h
    const-string/jumbo v4, xhtml
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +10eh
    goto/16 +175h
    const-string/jumbo v4, webp
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +130h
    goto/16 +16ah
    const-string/jumbo v4, webm
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +131h
    goto/16 +15fh
    const-string v4, "json"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +155h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_json I
    goto/16 +156h
    invoke-virtual v5, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0d4h
    goto/16 +149h
    const-string v4, "html"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0d8h
    goto/16 +13fh
    const-string v4, "flac"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +113h
    goto/16 +135h
    const-string v4, "docx"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0d9h
    goto/16 +12bh
    const-string/jumbo v4, zip
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +11fh
    goto/16 +120h
    const-string/jumbo v4, wav
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0f3h
    goto/16 +115h
    const-string/jumbo v4, txt
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0c4h
    goto/16 +10ah
    const-string/jumbo v4, tsv
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0b9h
    goto/16 +0ffh
    const-string/jumbo v4, tar
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0f3h
    goto/16 +0f4h
    const-string/jumbo v4, svg
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0afh
    goto/16 +0e9h
    const-string v4, "rar"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +0deh
    goto/16 +0dfh
    const-string v4, "png"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +09bh
    goto/16 +0d5h
    const-string v4, "pdf"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +0cbh
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_pdf I
    goto/16 +0cch
    const-string v4, "ogg"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +09bh
    goto/16 +0bdh
    const-string v4, "mov"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +085h
    goto/16 +0b3h
    const-string v4, "mp4"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +07bh
    goto/16 +0a9h
    const-string v4, "mp3"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +07dh
    goto/16 +09fh
    const-string v4, "mkv"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +067h
    goto/16 +095h
    const-string v4, "mdx"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +075h
    goto/16 +08bh
    const-string v4, "log"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +03bh
    goto/16 +081h
    invoke-virtual v5, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +079h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_jpg I
    goto/16 +07ah
    const-string v4, "htm"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +004h
    goto/16 +06bh
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_html I
    goto/16 +06ch
    const-string v4, "gif"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +023h
    goto/16 +05dh
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +55h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_doc I
    goto +57h
    const-string v4, "csv"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +49h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_txt I
    goto +4bh
    const-string v4, "bmp"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +3dh
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_png I
    goto +3fh
    const-string v4, "avi"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +31h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_video I
    goto +33h
    const-string v4, "aac"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +25h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_mp3 I
    goto +27h
    const-string v4, "md"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +19h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_markdown I
    goto +1bh
    const-string v4, "gz"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +00ch
    goto +dh
    const-string v4, "7z"
    invoke-virtual v5, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    goto +4h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_zip I
    goto +6h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_doc I
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_custom I
    return v4
    nop 
    sparse-switch-payload 18538 2eaded 5faa95b 6855d5f 6873db1
    sparse-switch-payload 723 cf3 d97 17843 17ad4 17d85 18206 18538 18fc4 194e1 19be1 1a344 1a5c1 1a698 1a6f0 1a6f1 1a714 1ad8f 1b0f2 1b229 1b823 1be64 1bfa5 1c1d7 1c270 1caec 1d721 2f2240 2fff68 3107ab 31e068 31ece8 379f99 379f9c 6cc0c23 eb7fcef
.end method

.method private final getTitle(com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)java.lang.String
    .registers 8
    # ins_size=2
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v7
    const/4 v1, 0
    if-eqz v7, +0bah
    invoke-interface v7, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v7
    if-nez v7, +004h
    goto/16 +0b2h
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +014h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -015h
    goto +2h
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-eqz v3, +08fh
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +087h
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +022h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ParsedChatMessage;->isUserMessage()Z
    move-result v4
    if-eqz v4, +004h
    const/4 v4, 1
    goto +2h
    const/4 v4, 0
    if-eqz v4, -020h
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -25h
    check-cast v2, Ljava/util/List;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;
    if-nez v7, +003h
    return-object v1
    invoke-virtual v7, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getQuery()Ljava/util/List;
    move-result-object v7
    if-eqz v7, +045h
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +017h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, text
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -018h
    goto +2h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/im/model/MessagePart;
    if-nez v0, +003h
    goto +1dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v7
    if-eqz v7, +018h
    const-string v0, "content"
    invoke-virtual v7, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    if-eqz v7, +010h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v7, v1
    if-eqz v7, +006h
    invoke-virtual v7, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private final loadHtmlContentAsync(android.content.Context  android.webkit.WebView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 31
    # ins_size=11
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +080h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +078h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    const-string v2, ""
    if-nez v1, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v6, v2
    goto +2h
    move-object v6, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v8, v2
    goto +2h
    move-object v8, v1
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual/range v29, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v11, v2
    goto +2h
    move-object v11, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v0
    if-eqz v0, +026h
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "/"
    const/4 v3, 0
    invoke-static v11, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ah
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "package"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "package/"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v7, v0
    goto +2h
    move-object v7, v11
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;
    move-object v3, v0
    move-object/from16 v4, v20
    move-object/from16 v10, v21
    move-object/from16 v12, v29
    move-object/from16 v13, v24
    move-object/from16 v14, v25
    move-object/from16 v15, v26
    move-object/from16 v16, v27
    move-object/from16 v17, v28
    move-object/from16 v18, v23
    move-object/from16 v19, v22
    invoke-direct/range v3 ... v19, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadHtmlContentAsync$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Landroid/content/Context; Ljava/lang/String; Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/webkit/WebView;)V
    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;
    move-object/from16 v1, v22
    invoke-virtual v1, v0, Landroid/webkit/WebView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    return-void 
.end method

.method private final loadImagesAsync(android.content.Context  java.util.List  java.util.List  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 17
    # ins_size=5
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +048h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-nez v0, +003h
    goto +40h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    const-string v2, ""
    if-nez v1, +004h
    move-object v7, v2
    goto +2h
    move-object v7, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v8, v2
    goto +2h
    move-object v8, v0
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v9
    invoke-interface v14, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    const/4 v0, 0
    move-object v1, v14
    invoke-interface v14, v0, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/facebook/drawee/view/SimpleDraweeView;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1;
    move-object v3, v2
    move-object v5, v15
    move-object v6, v14
    move-object v10, v12
    move-object v11, v13
    invoke-direct/range v3 ... v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadImagesAsync$1;-><init>(Ljava/lang/String; Ljava/util/List; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context;)V
    check-cast v2, Landroid/view/View$OnAttachStateChangeListener;
    invoke-virtual v0, v2, Lcom/facebook/drawee/view/SimpleDraweeView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    return-void 
.end method

.method private final loadMarkdownContentAsync(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 28
    # ins_size=11
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +07bh
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +073h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    const-string v2, ""
    if-nez v1, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v8, v2
    goto +2h
    move-object v8, v1
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v26, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v2, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v0
    if-eqz v0, +026h
    const/4 v0, 2
    const/4 v1, 0
    const-string v3, "/"
    const/4 v6, 0
    invoke-static v2, v3, v6, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ah
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "files"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "files/"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    goto +2h
    move-object v6, v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;
    move-object v3, v0
    move-object/from16 v9, v17
    move-object/from16 v10, v21
    move-object/from16 v11, v22
    move-object/from16 v12, v23
    move-object/from16 v13, v24
    move-object/from16 v14, v25
    move-object/from16 v15, v20
    move-object/from16 v16, v19
    invoke-direct/range v3 ... v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadMarkdownContentAsync$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;)V
    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;
    move-object/from16 v1, v19
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    return-void 
.end method

.method private final loadSingleImageAsync(android.content.Context  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  int  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 21
    # ins_size=7
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +041h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-nez v0, +003h
    goto +39h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    const-string v2, ""
    if-nez v1, +004h
    move-object v8, v2
    goto +2h
    move-object v8, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v7, v2
    goto +2h
    move-object v7, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v9, v2
    goto +2h
    move-object v9, v0
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v10
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;
    move-object v3, v0
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v19
    move-object/from16 v11, v16
    move-object/from16 v12, v17
    move/from16 v13, v18
    invoke-direct/range v3 ... v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadSingleImageAsync$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; I)V
    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;
    move-object/from16 v1, v16
    invoke-virtual v1, v0, Lcom/facebook/drawee/view/SimpleDraweeView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    return-void 
.end method

.method private final loadTextContentAsync(android.content.Context  android.widget.TextView  android.view.View  android.view.View  android.view.View  android.widget.TextView  android.view.View  android.view.View  com.bytedance.trae.im.model.FileDiffInfo  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 28
    # ins_size=11
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +07bh
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +073h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v1
    const-string v2, ""
    if-nez v1, +004h
    move-object v4, v2
    goto +2h
    move-object v4, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v5, v2
    goto +2h
    move-object v5, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v8, v2
    goto +2h
    move-object v8, v1
    invoke-virtual/range v27, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v26, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v2, v1
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->isLocal()Z
    move-result v0
    if-eqz v0, +026h
    const/4 v0, 2
    const/4 v1, 0
    const-string v3, "/"
    const/4 v6, 0
    invoke-static v2, v3, v6, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ah
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "files"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "files/"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    goto +2h
    move-object v6, v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1;
    move-object v3, v0
    move-object/from16 v9, v17
    move-object/from16 v10, v21
    move-object/from16 v11, v22
    move-object/from16 v12, v23
    move-object/from16 v13, v24
    move-object/from16 v14, v25
    move-object/from16 v15, v20
    move-object/from16 v16, v19
    invoke-direct/range v3 ... v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$loadTextContentAsync$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/widget/TextView;)V
    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;
    move-object/from16 v1, v19
    invoke-virtual v1, v0, Landroid/widget/TextView;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
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

.method static synthetic normalizeFilePath$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  java.lang.String  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final openHtmlArtifactPreview(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  java.lang.String  java.lang.Long)void
    .registers 20
    # ins_size=5
    move-object/from16 v11, v18
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +0ach
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getAllMessages()Ljava/util/List;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +0a4h
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v1
    if-eqz v1, +09ch
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v1
    if-nez v1, +004h
    goto/16 +094h
    move-object v12, v15
    if-nez v19, +007h
    invoke-direct v15, v0, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->findMTCLatestTime(Ljava/util/List; Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    goto +3h
    move-object/from16 v0, v19
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +015h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move-object v5, v11
    goto +24h
    const/4 v2, 2
    const/4 v3, 0
    const-string v4, "/"
    const/4 v5, 0
    invoke-static v11, v4, v5, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00ah
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "package"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "package/"
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object v5, v2
    sget-object v2, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity;->Companion Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v3
    const-string v4, ""
    if-nez v3, +003h
    move-object v3, v4
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +003h
    move-object v7, v4
    invoke-virtual/range v17, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v9
    if-nez v9, +003h
    move-object v9, v4
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v13
    goto +3h
    const-wide/16 v13, 0
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v10, v4
    goto +2h
    move-object v10, v0
    move-object v0, v2
    move-object/from16 v1, v16
    move-object v2, v3
    move-object v3, v6
    move-object v4, v7
    move-object v6, v8
    move-object v7, v9
    move-wide v8, v13
    move-object/from16 v11, v18
    invoke-virtual/range v0 ... v11, Lcom/bytedance/trae/conversation/products/HtmlArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; J Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    move-object v12, v15
    return-void 
    move-object v12, v15
    return-void 
.end method

.method static synthetic openHtmlArtifactPreview$default(com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer  android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts  java.lang.String  java.lang.Long  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->openHtmlArtifactPreview(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Ljava/lang/String; Ljava/lang/Long;)V
    return-void 
.end method

.method private static final render$lambda$2$lambda$1(android.content.Context  com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest)kotlin.Unit
    .registers 5
    # ins_size=2
    const-string/jumbo v0, request
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getFilePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactClick(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->Companion Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;->start(Landroid/content/Context; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private final resolveImageUri(android.content.Context  com.bytedance.trae.im.model.FileDiffInfo  java.lang.String  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 29
    # ins_size=8
    move-object/from16 v0, v21
    move-object/from16 v1, v25
    move-object/from16 v2, v28
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;
    if-eqz v3, +012h
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;
    iget v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    sub-int/2addr v2, v5
    iput v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Lkotlin/coroutines/Continuation;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    const/16 v6, 95
    const-string v7, ""
    const/4 v8, 3
    const/4 v9, 4
    const/4 v10, 2
    const/4 v11, 1
    const/4 v12, 0
    const/4 v13, 0
    if-eqz v5, +07bh
    if-eq v5, v11, +062h
    if-eq v5, v10, +03ch
    if-eq v5, v8, +015h
    if-ne v5, v9, +00bh
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    check-cast v1, Lorg/json/JSONObject;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +37ch
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->I$0 I
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$5 Ljava/lang/Object;
    check-cast v5, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v7, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$4 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v14, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$3 Ljava/lang/Object;
    check-cast v14, Lorg/json/JSONObject;
    iget-object v15, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    check-cast v15, Ljava/lang/String;
    iget-object v8, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    iget-object v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    check-cast v9, Landroid/content/Context;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v12, v7
    const/4 v2, 3
    move-object v7, v5
    move-object v5, v4
    move-object v4, v3
    move-object v3, v14
    goto/16 +242h
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->I$0 I
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$5 Ljava/lang/Object;
    check-cast v5, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v7, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$4 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    iget-object v8, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$3 Ljava/lang/Object;
    check-cast v8, Lorg/json/JSONObject;
    iget-object v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v14, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    check-cast v14, Ljava/lang/String;
    iget-object v15, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    check-cast v15, Landroid/content/Context;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v20, v14
    move-object v14, v8
    move-object/from16 v8, v20
    goto/16 +1b4h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    check-cast v1, Lorg/json/JSONObject;
    iget-object v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/im/model/FileDiffInfo;
    iget-object v3, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v20, v2
    move-object v2, v1
    move-object v1, v4
    move-object v4, v3
    move-object/from16 v3, v20
    goto +57h
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    const-string v5, "chatSessionId"
    invoke-virtual v2, v5, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "conversationId"
    move-object/from16 v8, v26
    invoke-virtual v2, v5, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "messageId"
    move-object/from16 v9, v27
    invoke-virtual v2, v5, v9, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v5, "path"
    invoke-virtual/range v23, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v2, v5, v14, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto +5h
    move-object/from16 v8, v26
    move-object/from16 v9, v27
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    move-object/from16 v14, v24
    invoke-static v14, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +101h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v5
    check-cast v5, Lkotlin/coroutines/CoroutineContext;
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$result$1;
    invoke-direct v8, v1, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    move-object/from16 v1, v23
    iput-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    iput-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    iput v11, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    invoke-static v5, v8, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v4, +003h
    return-object v4
    move-object v4, v0
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v5, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +082h
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v13
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v13
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    if-eqz v6, +00ah
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-nez v6, +003h
    goto +2h
    move v11, v12
    if-nez v11, +031h
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v8, "fetch_img_url"
    const-string v9, "remote"
    const-string/jumbo v10, success
    const-string v11, ""
    move-object/from16 v22, v6
    move-object/from16 v23, v8
    move-object/from16 v24, v9
    move-object/from16 v25, v10
    move-object/from16 v26, v11
    move-object/from16 v27, v2
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v7, v1
    invoke-direct v4, v7, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->normalizeFilePath(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-direct v4, v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->buildFileUrl(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    return-object v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v3, "fetch_img_url"
    const-string v4, "remote"
    const-string v5, "failed"
    const-string/jumbo v6, url_is_null
    move-object/from16 v22, v1
    move-object/from16 v23, v3
    move-object/from16 v24, v4
    move-object/from16 v25, v5
    move-object/from16 v26, v6
    move-object/from16 v27, v2
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto/16 +28eh
    instance-of v1, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +03dh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v4, "fetch_img_url"
    const-string v5, "remote"
    const-string v7, "failed"
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    move-object v9, v3
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v9
    invoke-virtual v8, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v6
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object/from16 v22, v1
    move-object/from16 v23, v4
    move-object/from16 v24, v5
    move-object/from16 v25, v7
    move-object/from16 v26, v3
    move-object/from16 v27, v2
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto/16 +24fh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v3, "fetch_img_url"
    const-string v4, "remote"
    const-string v5, "failed"
    const-string v6, "other"
    move-object/from16 v22, v1
    move-object/from16 v23, v3
    move-object/from16 v24, v4
    move-object/from16 v25, v5
    move-object/from16 v26, v6
    move-object/from16 v27, v2
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto/16 +234h
    move-object/from16 v1, v23
    invoke-virtual/range v23, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v7, v1
    const-string v1, "/"
    invoke-static v7, v1, v12, v10, v13, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00ah
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v5, "files"
    invoke-direct v1, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    goto +8h
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v5, "files/"
    invoke-direct v1, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    new-instance v5, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v5, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    move-object v7, v5
    move v14, v12
    const/4 v15, 4
    move-object v5, v4
    move-object v4, v3
    move-object v3, v2
    move-object v2, v1
    move-object/from16 v1, v22
    if-ge v14, v15, +120h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v15
    check-cast v15, Lkotlin/coroutines/CoroutineContext;
    new-instance v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$result$2;
    invoke-direct v12, v2, v8, v9, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$result$2;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v12, Lkotlin/jvm/functions/Function2;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    iput-object v8, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    iput-object v9, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$3 Ljava/lang/Object;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$4 Ljava/lang/Object;
    iput-object v7, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$5 Ljava/lang/Object;
    iput v14, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->I$0 I
    iput v10, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    invoke-static v15, v12, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    if-ne v12, v5, +003h
    return-object v5
    move-object v15, v1
    move v1, v14
    move-object v14, v3
    move-object v3, v4
    move-object v4, v5
    move-object v5, v7
    move-object v7, v2
    move-object v2, v12
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v12, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v12, +08fh
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v12
    invoke-virtual v12, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v12
    goto +2h
    move-object v12, v13
    if-eqz v12, +009h
    invoke-interface v12, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Ljava/lang/String;
    goto +2h
    move-object v12, v13
    iput-object v12, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v12, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v12, Ljava/lang/CharSequence;
    if-eqz v12, +00bh
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v12
    if-nez v12, +003h
    goto +3h
    const/4 v12, 0
    goto +2h
    move v12, v11
    if-eqz v12, +05bh
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v16
    const-wide/16 v18, 202
    cmp-long v2, v16, v18
    if-nez v2, +031h
    iput-object v15, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    iput-object v9, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    iput-object v14, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$3 Ljava/lang/Object;
    iput-object v7, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$4 Ljava/lang/Object;
    iput-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$5 Ljava/lang/Object;
    iput v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->I$0 I
    const/4 v2, 3
    iput v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    move-object v12, v7
    const-wide/16 v6, 50
    invoke-static v6, v7, v3, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v4, +003h
    return-object v4
    move-object v7, v5
    move-object v5, v4
    move-object v4, v3
    move-object v3, v14
    move-object/from16 v20, v15
    move-object v15, v9
    move-object/from16 v9, v20
    add-int/lit8 v14, v1, 1
    move-object v1, v9
    move-object v2, v12
    move-object v9, v15
    const/16 v6, 95
    const/4 v12, 0
    const/4 v15, 4
    goto/16 -0a1h
    move-object v12, v7
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v2, "fetch_img_url"
    const-string v6, "local"
    const-string v7, "failed"
    const-string/jumbo v9, url_is_null
    move-object/from16 v22, v1
    move-object/from16 v23, v2
    move-object/from16 v24, v6
    move-object/from16 v25, v7
    move-object/from16 v26, v9
    move-object/from16 v27, v14
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +5eh
    move-object v12, v7
    goto +5ch
    move-object v12, v7
    instance-of v1, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v1, +03fh
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v6, "fetch_img_url"
    const-string v7, "local"
    const-string v9, "failed"
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, Ljava/lang/StringBuilder;-><init>()V
    move-object/from16 v17, v2
    check-cast v17, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual/range v17, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v10
    invoke-virtual v11, v10, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v11, 95
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v10, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    move-object/from16 v22, v1
    move-object/from16 v23, v6
    move-object/from16 v24, v7
    move-object/from16 v25, v9
    move-object/from16 v26, v2
    move-object/from16 v27, v14
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +1ah
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v2, "fetch_img_url"
    const-string v6, "local"
    const-string v7, "failed"
    const-string v9, "other"
    move-object/from16 v22, v1
    move-object/from16 v23, v2
    move-object/from16 v24, v6
    move-object/from16 v25, v7
    move-object/from16 v26, v9
    move-object/from16 v27, v14
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    move-object v2, v4
    move-object v1, v14
    move-object v4, v3
    goto +6h
    move-object v15, v1
    move-object v12, v2
    move-object v1, v3
    move-object v2, v5
    move-object v5, v7
    iget-object v3, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v11, 0
    goto +2h
    const/4 v11, 1
    if-nez v11, +0c6h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v6, "fetch_img_url"
    const-string v7, "local"
    const-string/jumbo v9, success
    const-string v10, ""
    move-object/from16 v22, v3
    move-object/from16 v23, v6
    move-object/from16 v24, v7
    move-object/from16 v25, v9
    move-object/from16 v26, v10
    move-object/from16 v27, v1
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    iget-object v3, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    const-string v6, "content://"
    const/4 v7, 2
    const/4 v9, 0
    invoke-static v3, v6, v9, v7, v13, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +095h
    iget-object v3, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    const-string v6, "file://"
    invoke-static v3, v6, v9, v7, v13, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    goto/16 +087h
    new-instance v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;
    invoke-direct v3, Lcom/bytedance/trae/conversation/products/FileDownloadHelper;-><init>()V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v6
    check-cast v6, Lkotlin/coroutines/CoroutineContext;
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;
    const/4 v9, 0
    move-object/from16 v22, v7
    move-object/from16 v23, v3
    move-object/from16 v24, v15
    move-object/from16 v25, v5
    move-object/from16 v26, v8
    move-object/from16 v27, v12
    move-object/from16 v28, v9
    invoke-direct/range v22 ... v28, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$cacheFile$1;-><init>(Lcom/bytedance/trae/conversation/products/FileDownloadHelper; Landroid/content/Context; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/jvm/functions/Function2;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$0 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$1 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$2 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$3 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$4 Ljava/lang/Object;
    iput-object v13, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->L$5 Ljava/lang/Object;
    const/4 v3, 4
    iput v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$resolveImageUri$1;->label I
    invoke-static v6, v7, v4, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v2, +003h
    return-object v2
    move-object v2, v3
    check-cast v2, Ljava/io/File;
    if-eqz v2, +031h
    invoke-virtual v2, Ljava/io/File;->exists()Z
    move-result v3
    if-eqz v3, +02bh
    invoke-virtual v2, Ljava/io/File;->length()J
    move-result-wide v3
    const-wide/16 v5, 0
    cmp-long v3, v3, v5
    if-lez v3, +021h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v4, "download_img"
    const-string v5, "local"
    const-string/jumbo v6, success
    const-string v7, ""
    move-object/from16 v22, v3
    move-object/from16 v23, v4
    move-object/from16 v24, v5
    move-object/from16 v25, v6
    move-object/from16 v26, v7
    move-object/from16 v27, v1
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-static v2, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    move-result-object v1
    return-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;
    const-string v3, "download_img"
    const-string v4, "local"
    const-string v5, "failed"
    const-string v6, ""
    move-object/from16 v22, v2
    move-object/from16 v23, v3
    move-object/from16 v24, v4
    move-object/from16 v25, v5
    move-object/from16 v26, v6
    move-object/from16 v27, v1
    invoke-virtual/range v22 ... v27, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactFileUrlHelper;->reportApm(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +ah
    iget-object v1, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-static v1, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v1
    return-object v1
    return-object v13
    :try_start_0xb4
    :try_start_0xbd
    :try_start_0xc4
    :try_start_0x188
    :try_start_0x2db
.end method

.method private final setImageWithResize(com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  int  android.net.Uri)void
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;
    invoke-direct v0, v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$setImageWithResize$controllerListener$1;-><init>(I Landroid/widget/FrameLayout;)V
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->newDraweeControllerBuilder()Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v3
    invoke-virtual v3, v5, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setUri(Landroid/net/Uri;)Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    move-result-object v3
    check-cast v0, Lcom/facebook/drawee/controller/ControllerListener;
    invoke-virtual v3, v0, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setControllerListener(Lcom/facebook/drawee/controller/ControllerListener;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v2, Lcom/facebook/drawee/view/SimpleDraweeView;->getController()Lcom/facebook/drawee/interfaces/DraweeController;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->setOldController(Lcom/facebook/drawee/interfaces/DraweeController;)Lcom/facebook/drawee/controller/AbstractDraweeControllerBuilder;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;
    invoke-virtual v3, Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;->build()Lcom/facebook/drawee/controller/AbstractDraweeController;
    move-result-object v3
    check-cast v3, Lcom/facebook/drawee/interfaces/DraweeController;
    invoke-virtual v2, v3, Lcom/facebook/drawee/view/SimpleDraweeView;->setController(Lcom/facebook/drawee/interfaces/DraweeController;)V
    return-void 
.end method

.method private final truncateForPreview(java.lang.String)java.lang.String
    .registers 13
    # ins_size=2
    invoke-virtual v12, Ljava/lang/String;->length()I
    move-result v0
    const/16 v1, 300
    if-gt v0, v1, +003h
    return-object v12
    move-object v0, v12
    check-cast v0, Ljava/lang/CharSequence;
    const-string v3, "

"
    const/16 v4, 300
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v2
    const/16 v8, 100
    const-string/jumbo v9, substring(...)
    const/4 v10, 0
    if-le v2, v8, +00ah
    invoke-virtual v12, v10, v2, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v12
    const/16 v3, 10
    const/16 v4, 300
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-le v0, v8, +00ah
    invoke-virtual v12, v10, v0, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v12
    invoke-virtual v12, v10, v1, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v12
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)android.view.View
    .registers 33
    # ins_size=3
    move-object/from16 v9, v30
    move-object/from16 v10, v31
    move-object/from16 v11, v32
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ArtifactData;->getPreviews()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    goto +2h
    move v0, v1
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedDocs()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v0, v2
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedCodes()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v0, v2
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedImages()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v0, v2
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSheets()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v0, v2
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSlides()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v0, v2
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v2
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSkills()Lcom/bytedance/trae/im/model/ChangedSkillsData;
    move-result-object v2
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedSkillsData;->getSkills()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +007h
    invoke-interface v2, Ljava/util/List;->size()I
    move-result v2
    goto +2h
    move v2, v1
    add-int/2addr v0, v2
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[ArtifactsRenderer] render: artifacts="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v3, "AgentBlock"
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v31, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v12, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getProducts()Lcom/bytedance/trae/im/model/ArtifactData;
    move-result-object v13
    new-instance v14, Landroid/widget/LinearLayout;
    invoke-direct v14, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v15, 1
    invoke-virtual v14, v15, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -1
    const/4 v3, -2
    invoke-direct v0, v2, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedCodes()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;->splitChangedCodes(Lcom/bytedance/trae/im/model/ChangedFileData;)Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;
    move-result-object v16
    if-eqz v13, +007h
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getPreviews()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v15
    xor-int/lit8 v17, v0, 1
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedDocs()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    check-cast v0, Ljava/util/Collection;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v15
    xor-int/2addr v0, v15
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;->getHtmlPreviewFiles()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/lit8 v18, v2, 1
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;->getRegularChangedCodes()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    check-cast v2, Ljava/util/Collection;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v15
    xor-int/lit8 v19, v2, 1
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedImages()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    check-cast v2, Ljava/util/Collection;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    move v2, v15
    xor-int/2addr v2, v15
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSheets()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    check-cast v3, Ljava/util/Collection;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v3, v1
    goto +2h
    move v3, v15
    xor-int/2addr v3, v15
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSlides()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    check-cast v4, Ljava/util/Collection;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v15
    xor-int/2addr v4, v15
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSkills()Lcom/bytedance/trae/im/model/ChangedSkillsData;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/ChangedSkillsData;->getSkills()Ljava/util/List;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v15
    xor-int/lit8 v20, v5, 1
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getMergeProducts()Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    move-result-object v5
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    check-cast v5, Ljava/util/Collection;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v15
    xor-int/lit8 v21, v5, 1
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getVideoArtifacts()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/2addr v5, v15
    if-nez v17, +015h
    if-nez v0, +013h
    if-nez v19, +011h
    if-nez v18, +00fh
    if-nez v2, +00dh
    if-nez v3, +00bh
    if-nez v4, +009h
    if-nez v20, +007h
    if-eqz v5, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v15
    if-nez v0, +007h
    if-nez v21, +005h
    check-cast v14, Landroid/view/View;
    return-object v14
    if-eqz v5, +067h
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getIGetMessage()Lcom/bytedance/trae/conversation/chat/IMessageListener;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/IMessageListener;->getCurrentConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +059h
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getVideoArtifacts()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +049h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    const-string v6, ""
    if-nez v5, +005h
    move-object/from16 v23, v6
    goto +3h
    move-object/from16 v23, v5
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v24
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getCliConversationId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +005h
    move-object/from16 v25, v6
    goto +3h
    move-object/from16 v25, v5
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +005h
    move-object/from16 v26, v6
    goto +3h
    move-object/from16 v26, v5
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getTurnId()Ljava/lang/String;
    move-result-object v27
    move-object/from16 v22, v4
    invoke-static/range v22 ... v27, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactModelsKt;->toOpenRequest(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    move-result-object v5
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda4;
    invoke-direct v8, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$$ExternalSyntheticLambda4;-><init>(Landroid/content/Context;)V
    invoke-direct v6, v10, v4, v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/VideoArtifactCardView;-><init>(Landroid/content/Context; Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor; Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest; Lkotlin/jvm/functions/Function1;)V
    check-cast v6, Landroid/view/View;
    invoke-virtual v14, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -4ch
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    if-eqz v2, +0d0h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->getArtifactsRendererSettings()Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->getImagePreview()Z
    move-result v2
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedImages()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    move-object v4, v3
    check-cast v4, Ljava/util/Collection;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    move v4, v15
    if-nez v4, +0a9h
    if-eqz v2, +0a5h
    check-cast v3, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +02dh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v5
    invoke-direct v9, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    sget-object v6, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v6, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v6, toLowerCase(...)
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->IMAGE_PREVIEW_EXTENSIONS Ljava/util/Set;
    invoke-interface v6, v5, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +006h
    invoke-virtual v0, v4, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -2ch
    invoke-virtual v2, v4, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -30h
    new-instance v3, Lkotlin/Pair;
    invoke-direct v3, v0, v2, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    invoke-virtual v3, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-virtual v3, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v3
    if-ne v3, v15, +01dh
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/model/FileDiffInfo;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v0, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactShow(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, v10, v0, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSingleImagePreviewCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto +2fh
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    if-le v1, v15, +02ah
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/model/FileDiffInfo;
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v3, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactShow(Ljava/lang/String; Ljava/lang/String;)V
    goto -19h
    invoke-direct v9, v10, v0, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMultiImagePreviewCard(Landroid/content/Context; Ljava/util/List; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v8, v2
    goto +4h
    move-object v8, v3
    goto +2h
    move-object v8, v0
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    move-object v6, v0
    check-cast v6, Ljava/util/List;
    if-eqz v13, +02dh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedDocs()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v0
    if-eqz v0, +027h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +021h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +013h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/FileDiffInfo;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    const-string v3, "doc"
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String;)V
    invoke-interface v6, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -16h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    if-eqz v13, +02eh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSheets()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v0
    if-eqz v0, +028h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +022h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/FileDiffInfo;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    const-string/jumbo v3, sheet
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String;)V
    invoke-interface v6, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -17h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    if-eqz v13, +02eh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSlides()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v0
    if-eqz v0, +028h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ChangedFileData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +022h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/FileDiffInfo;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    const-string/jumbo v3, slide
    invoke-direct v2, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;-><init>(Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String;)V
    invoke-interface v6, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -17h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->getArtifactsRendererSettings()Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->getFilePreview()Z
    move-result v0
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getSummary()Ljava/lang/String;
    move-result-object v1
    invoke-direct v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->extractPrimaryArtifactPath(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    move-object v1, v6
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v15
    if-eqz v1, +036h
    if-eqz v0, +034h
    if-eqz v5, +029h
    move-object v0, v6
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getFile()Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -019h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    goto +8h
    invoke-static v6, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    move-object v4, v1
    goto +2h
    const/4 v4, 0
    if-eqz v4, +033h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getFile()Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactShow(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getFile()Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-result-object v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getType()Ljava/lang/String;
    move-result-object v3
    const/16 v22, 1
    move-object/from16 v0, v30
    move-object/from16 v1, v31
    move-object/from16 v28, v4
    move v4, v12
    move-object v7, v5
    move-object/from16 v5, v32
    move-object/from16 v24, v6
    move/from16 v6, v22
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createFileCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Z)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto +6h
    move-object/from16 v28, v4
    move-object v7, v5
    move-object/from16 v24, v6
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->getArtifactsRendererSettings()Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;->getHtmlPreview()Z
    move-result v0
    if-eqz v18, +02dh
    if-eqz v0, +02bh
    if-eqz v7, +029h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;->getHtmlPreviewFiles()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -015h
    move-object v7, v1
    goto +2h
    const/4 v7, 0
    check-cast v7, Lcom/bytedance/trae/im/model/FileDiffInfo;
    goto +2h
    const/4 v7, 0
    if-eqz v7, +016h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactShow(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, v10, v7, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createHtmlPreviewCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object v0, v8
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v15
    if-eqz v0, +03fh
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v22
    invoke-interface/range v22, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +033h
    invoke-interface/range v22, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/im/model/FileDiffInfo;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactShow(Ljava/lang/String; Ljava/lang/String;)V
    const-string v3, "image"
    const/4 v6, 0
    const/16 v8, 32
    const/16 v23, 0
    move-object/from16 v0, v30
    move-object/from16 v1, v31
    move v4, v12
    move-object/from16 v5, v32
    move-object/from16 v29, v7
    move v7, v8
    move-object/from16 v8, v23
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createFileCard$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer; Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Z I Ljava/lang/Object;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object/from16 v7, v29
    goto -36h
    move-object/from16 v29, v7
    move-object/from16 v6, v24
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +018h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    move-object/from16 v7, v28
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    xor-int/2addr v3, v15
    if-eqz v3, +005h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v28, v7
    goto -1bh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +031h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getFile()Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v2
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactShow(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getFile()Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer$render$TypedFile;->getType()Ljava/lang/String;
    move-result-object v3
    const/4 v6, 0
    move-object/from16 v0, v30
    move-object/from16 v1, v31
    move v4, v12
    move-object/from16 v5, v32
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createFileCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; Ljava/lang/String; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts; Z)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -34h
    if-eqz v17, +02fh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getPreviews()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +029h
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/PreviewData;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v3, "http_url"
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    invoke-direct v9, v10, v1, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createPreviewCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/PreviewData; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v1
    invoke-virtual v14, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -1eh
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    if-eqz v18, +04bh
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;->getHtmlPreviewFiles()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/im/model/FileDiffInfo;
    move-object/from16 v7, v29
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    xor-int/2addr v3, v15
    if-eqz v3, +005h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v29, v7
    goto -1bh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-direct v9, v10, v1, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createHtmlArtifactCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/FileDiffInfo; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v1
    invoke-virtual v14, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    if-eqz v20, +02ah
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getChangedSkills()Lcom/bytedance/trae/im/model/ChangedSkillsData;
    move-result-object v0
    if-eqz v0, +024h
    invoke-virtual v0, Lcom/bytedance/trae/im/model/ChangedSkillsData;->getSkills()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +01eh
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/model/SkillInfo;
    invoke-direct v9, v10, v1, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createSkillCard(Landroid/content/Context; Lcom/bytedance/trae/im/model/SkillInfo; F)Landroid/view/View;
    move-result-object v1
    invoke-virtual v14, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    if-eqz v19, +01bh
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v1, "diff"
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;->getRegularChangedCodes()Lcom/bytedance/trae/im/model/ChangedFileData;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v10, v0, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createChangedCodeSection(Landroid/content/Context; Lcom/bytedance/trae/im/model/ChangedFileData; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    if-eqz v21, +01bh
    invoke-virtual v13, Lcom/bytedance/trae/im/model/ArtifactData;->getMergeProducts()Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v9, v10, v0, v12, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->createMergeSection(Landroid/content/Context; Lcom/bytedance/trae/im/model/MergeChangedFilesData; F Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;
    const-string v1, "merge"
    invoke-virtual/range v32, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactTrack;->trackArtifactWithArtifactType(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v14, Landroid/view/View;
    return-object v14
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Artifacts)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactsRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Artifacts;)V
    return-void 
.end method
