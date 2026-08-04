# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
.super Landroid/widget/FrameLayout;
.source "PureShowWidgetInlineView.kt"

.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;
.field private static final HEIGHT_CACHE:Ljava/util/LinkedHashMap;
.field public static final HEIGHT_CACHE_MAX_SIZE:I
.field public static final HEIGHT_CHANGE_THRESHOLD_PX:I
.field private static final HEIGHT_CHECK_DELAYS_MS:[J
.field public static final HEIGHT_SCRIPT:Ljava/lang/String;
.field public static final LOADING_MESSAGE_INTERVAL_MS:J
.field public static final MIN_RENDERED_HEIGHT_PX:I
.field public static final TAG:Ljava/lang/String;
.field private final bootstrapHeightPx:I
.field private currentHeightCacheKey:Ljava/lang/String;
.field private currentHeightPx:I
.field private currentLoadingMessages:Ljava/util/List;
.field private final fullscreenButton:Landroidx/appcompat/widget/AppCompatImageButton;
.field private fullscreenPayload:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
.field private final handler:Landroid/os/Handler;
.field private hasLoggedFinishedRegression:Z
.field private final heightCheckRunnable:Ljava/lang/Runnable;
.field private heightMeasuredForCurrentLoad:Z
.field private lastWidgetCode:Ljava/lang/String;
.field private final loadingContainer:Landroid/widget/LinearLayout;
.field private final loadingIconView:Landroid/widget/ImageView;
.field private loadingMessageIndex:I
.field private loadingMessageRotationActive:Z
.field private final loadingMessageRunnable:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
.field private final loadingTextView:Landroid/widget/TextView;
.field private pendingHeightCheckCount:I
.field private pendingHeightChecksAfterAttach:Z
.field private final presentationState:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;
.field private released:Z
.field private renderProcessFailed:Z
.field private final tapSlopPx:I
.field private touchDownX:F
.field private touchDownY:F
.field private webView:Landroid/webkit/WebView;


.method public static synthetic $r8$lambda$4U-eKrDVOZX0cX1KjltGEQyb52w(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->_init_$lambda$7(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$ZI1_J1HLsvsac03FDgxyvwsSMXY(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.webkit.WebView  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->updateHeightFromContent$lambda$16(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/webkit/WebView; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$eNpMHp46H_Do2dywJPPXoNQ6WT0(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable$lambda$6(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jHWPSPDGF-aoynvvVh-aWQlt5k4(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->attachNewWebView$lambda$9(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$yZKe1PRBr9ZtYDcdJ0r5YufjPXY(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton$lambda$5$lambda$4(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;
    const/4 v0, 6
    new-array v0, v0, [J
    fill-array-data v0, +000000fh
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->HEIGHT_CHECK_DELAYS_MS [J
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion$HEIGHT_CACHE$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion$HEIGHT_CACHE$1;-><init>()V
    check-cast v0, Ljava/util/LinkedHashMap;
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->HEIGHT_CACHE Ljava/util/LinkedHashMap;
    return-void 
    fill-array-data-payload b'P\x00\x00\x00\x00\x00\x00\x00\xc8\x00\x00\x00\x00\x00\x00\x00\x90\x01\x00\x00\x00\x00\x00\x00 \x03\x00\x00\x00\x00\x00\x00\xb0\x04\x00\x00\x00\x00\x00\x00\xd0\x07\x00\x00\x00\x00\x00\x00' | \x50\x00\x00\x00\x00\x00\x00\x00\xc8\x00\x00\x00\x00\x00\x00\x00\x90\x01\x00\x00\x00\x00\x00\x00\x20\x03\x00\x00\x00\x00\x00\x00\xb0\x04\x00\x00\x00\x00\x00\x00\xd0\x07\x00\x00\x00\x00\x00\x00
.end method

.method public constructor <init>(android.content.Context)void
    .registers 12
    # ins_size=2
    const-string v0, "context"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v10, v11, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    iput-object v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_pure_show_widget_bootstrap_height I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    iput v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->bootstrapHeightPx I
    invoke-static v11, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    move-result-object v1
    invoke-virtual v1, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I
    move-result v1
    iput v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->tapSlopPx I
    new-instance v1, Landroid/widget/ImageView;
    invoke-direct v1, v11, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v2, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->status_loading_anim I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    iput-object v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingIconView Landroid/widget/ImageView;
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v11, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v11, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v2, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_md_font_size_sp I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimension(I)F
    move-result v3
    const/4 v4, 0
    invoke-virtual v2, v4, v3, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v2, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v3, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-static v2, v3, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v2, v5, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    sget v5, Lcom/bytedance/trae/conversation/R$string;->trae_artifact_loading I
    invoke-virtual v11, v5, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v2, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iput-object v2, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingTextView Landroid/widget/TextView;
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v6, 16
    invoke-virtual v5, v6, Landroid/widget/LinearLayout;->setGravity(I)V
    check-cast v1, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v5, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_20 I
    invoke-virtual v7, v8, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    invoke-virtual v5, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v9, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_20 I
    invoke-virtual v8, v9, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    invoke-direct v6, v7, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v1, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v2, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v6, 1065353216
    const/4 v7, -2
    invoke-direct v1, v4, v7, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-virtual v5, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_4 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v2, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v5, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    new-instance v1, Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-direct v1, v11, Landroidx/appcompat/widget/AppCompatImageButton;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_maximize I
    invoke-virtual v1, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setImageResource(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_expand_button_ripple I
    invoke-virtual v1, v2, Landroidx/appcompat/widget/AppCompatImageButton;->setBackgroundResource(I)V
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_web I
    invoke-virtual v11, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v11
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v1, v11, Landroidx/appcompat/widget/AppCompatImageButton;->setContentDescription(Ljava/lang/CharSequence;)V
    sget-object v11, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE Landroid/widget/ImageView$ScaleType;
    invoke-virtual v1, v11, Landroidx/appcompat/widget/AppCompatImageButton;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    invoke-virtual v1, Landroidx/appcompat/widget/AppCompatImageButton;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_4 I
    invoke-virtual v11, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v11
    invoke-virtual v1, v11, v11, v11, v11, Landroidx/appcompat/widget/AppCompatImageButton;->setPadding(I I I I)V
    const/16 v11, 8
    invoke-virtual v1, v11, Landroidx/appcompat/widget/AppCompatImageButton;->setVisibility(I)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda2;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    invoke-virtual v1, v11, Landroidx/appcompat/widget/AppCompatImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iput-object v1, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;
    invoke-direct v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;-><init>()V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->presentationState Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;
    iput v0, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v11
    iput-object v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda3;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable Ljava/lang/Runnable;
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    iput-object v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRunnable Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
    new-instance v11, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v0, -1
    invoke-direct v11, v0, v7, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda4;
    invoke-direct v11, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    invoke-virtual v10, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->attachNewWebView()Landroid/webkit/WebView;
    check-cast v5, Landroid/view/View;
    new-instance v11, Landroid/widget/FrameLayout$LayoutParams;
    const v2, 8388659
    invoke-direct v11, v0, v7, v2, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v5, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    new-instance v11, Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_32 I
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_32 I
    invoke-virtual v2, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    const v4, 8388661
    invoke-direct v11, v0, v2, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    iput v0, v11, Landroid/widget/FrameLayout$LayoutParams;->topMargin I
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-virtual v11, v0, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v1, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v11, 0
    invoke-static v10, v11, v3, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showLoading$default(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Ljava/util/List; I Ljava/lang/Object;)V
    return-void 
.end method

.method private static final _init_$lambda$7(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->openFullscreenPreview()V
    return-void 
.end method

.method public static final synthetic access$getCurrentLoadingMessages$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)java.util.List
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    return-object v0
.end method

.method public static final synthetic access$getHEIGHT_CACHE$cp()java.util.LinkedHashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->HEIGHT_CACHE Ljava/util/LinkedHashMap;
    return-object v0
.end method

.method public static final synthetic access$getHEIGHT_CHECK_DELAYS_MS$cp()long[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->HEIGHT_CHECK_DELAYS_MS [J
    return-object v0
.end method

.method public static final synthetic access$getHandler$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)android.os.Handler
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    return-object v0
.end method

.method public static final synthetic access$getLoadingContainer$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)android.widget.LinearLayout
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    return-object v0
.end method

.method public static final synthetic access$getLoadingMessageIndex$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    return v0
.end method

.method public static final synthetic access$getReleased$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    return v0
.end method

.method public static final synthetic access$getWebView$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)android.webkit.WebView
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    return-object v0
.end method

.method public static final synthetic access$handleRenderProcessGone(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.webkit.WebView  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handleRenderProcessGone(Landroid/webkit/WebView; Z)V
    return-void 
.end method

.method public static final synthetic access$scheduleHeightChecks(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->scheduleHeightChecks()V
    return-void 
.end method

.method public static final synthetic access$setLoadingMessageIndex$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    return-void 
.end method

.method public static final synthetic access$setLoadingMessageRotationActive$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRotationActive Z
    return-void 
.end method

.method public static final synthetic access$setPendingHeightChecksAfterAttach$p(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightChecksAfterAttach Z
    return-void 
.end method

.method public static final synthetic access$updateLoadingMessage(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->updateLoadingMessage()V
    return-void 
.end method

.method private final attachNewWebView()android.webkit.WebView
    .registers 6
    # ins_size=1
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "getContext(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->createWebView(Landroid/content/Context;)Landroid/webkit/WebView;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda1;
    invoke-direct v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    move-object v1, v0
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v3, -1
    iget v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    invoke-direct v2, v3, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    const/4 v3, 0
    invoke-virtual v5, v1, v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->addView(Landroid/view/View; I Landroid/view/ViewGroup$LayoutParams;)V
    return-object v0
.end method

.method private static final attachNewWebView$lambda$9(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handleWebViewTouch(Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method private final createWebView(android.content.Context)android.webkit.WebView
    .registers 8
    # ins_size=2
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    new-instance v2, Landroid/webkit/WebView;
    invoke-direct v2, v7, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "[InlineView] WebView(context) costMs="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v4
    sub-long/2addr v4, v0
    invoke-virtual v3, v4, v5, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "PureShowWidget"
    invoke-virtual v7, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v7, 0
    invoke-virtual v2, v7, Landroid/webkit/WebView;->setBackgroundColor(I)V
    invoke-virtual v2, v7, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V
    invoke-virtual v2, v7, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V
    const/4 v7, 2
    invoke-virtual v2, v7, Landroid/webkit/WebView;->setOverScrollMode(I)V
    invoke-direct v6, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setupSettings(Landroid/webkit/WebView;)V
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$createWebView$1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;)V
    check-cast v7, Landroid/webkit/WebViewClient;
    invoke-virtual v2, v7, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V
    return-object v2
.end method

.method private final destroyWebView(android.webkit.WebView  boolean)void
    .registers 6
    # ins_size=3
    invoke-virtual v4, Landroid/webkit/WebView;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    move-object v0, v2
    if-eqz v0, +008h
    move-object v1, v4
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V
    if-nez v5, +00bh
    invoke-virtual v4, v2, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    invoke-virtual v4, Landroid/webkit/WebView;->stopLoading()V
    invoke-virtual v4, Landroid/webkit/WebView;->removeAllViews()V
    invoke-virtual v4, Landroid/webkit/WebView;->destroy()V
    return-void 
.end method

.method static synthetic destroyWebView$default(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.webkit.WebView  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->destroyWebView(Landroid/webkit/WebView; Z)V
    return-void 
.end method

.method private static final fullscreenButton$lambda$5$lambda$4(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->openFullscreenPreview()V
    return-void 
.end method

.method private final handleRenderProcessGone(android.webkit.WebView  boolean)void
    .registers 6
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[InlineView] WebView render process gone, didCrash="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ", widgetId="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetId()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v2
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v1, "PureShowWidget"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->e(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    const/4 v0, 1
    if-ne v4, v5, +01dh
    iput-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    const/4 v1, 0
    if-eqz v5, +004h
    move v5, v0
    goto +2h
    move v5, v1
    iput-boolean v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->renderProcessFailed Z
    iput-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable Ljava/lang/Runnable;
    invoke-virtual v5, v2, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    iput v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightChecksAfterAttach Z
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightMeasuredForCurrentLoad Z
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->destroyWebView(Landroid/webkit/WebView; Z)V
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-nez v4, +009h
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->renderProcessFailed Z
    if-eqz v4, +005h
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showRenderProcessFailure()V
    return-void 
.end method

.method private final handleWebViewTouch(android.view.MotionEvent)boolean
    .registers 7
    # ins_size=2
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    if-eqz v0, +02ch
    const/4 v2, 1
    if-eq v0, v2, +003h
    goto +33h
    invoke-virtual v6, Landroid/view/MotionEvent;->getX()F
    move-result v0
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->touchDownX F
    sub-float/2addr v0, v3
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v0
    invoke-virtual v6, Landroid/view/MotionEvent;->getY()F
    move-result v6
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->touchDownY F
    sub-float/2addr v6, v3
    invoke-static v6, Ljava/lang/Math;->abs(F)F
    move-result v6
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->tapSlopPx I
    int-to-float v4, v3
    cmpg-float v0, v0, v4
    if-gtz v0, +017h
    int-to-float v0, v3
    cmpg-float v6, v6, v0
    if-gtz v6, +012h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->performClick()Z
    return v2
    invoke-virtual v6, Landroid/view/MotionEvent;->getX()F
    move-result v0
    iput v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->touchDownX F
    invoke-virtual v6, Landroid/view/MotionEvent;->getY()F
    move-result v6
    iput v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->touchDownY F
    return v1
.end method

.method private static final heightCheckRunnable$lambda$6(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView)void
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    if-lez v0, +006h
    add-int/lit8 v0, v0, -1
    iput v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->updateHeightFromContent()V
    return-void 
.end method

.method private final loadWidgetCode(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload  java.lang.String)void
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-nez v0, +003h
    return-void 
    iput-object v8, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable Ljava/lang/Runnable;
    invoke-virtual v1, v2, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v1, 0
    iput v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightChecksAfterAttach Z
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightMeasuredForCurrentLoad Z
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;
    invoke-virtual v2, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;->buildHeightCacheKey(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    iput-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightCacheKey Ljava/lang/String;
    invoke-virtual v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;->getCachedHeight(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +3h
    iget v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->bootstrapHeightPx I
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->resetWebViewHeight(I)V
    const-string v7, "https://widget.traecontent.com/"
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;
    invoke-virtual v2, v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetHtml;->build(Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, text/html
    const-string v4, "UTF-8"
    const/4 v5, 0
    move-object v1, v7
    invoke-virtual/range v0 ... v5, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final notifyContentChanged()void
    .registers 4
    # ins_size=1
    move-object v0, v3
    check-cast v0, Landroid/view/View;
    if-eqz v0, +022h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v0, v1, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v1
    const/4 v2, 0
    invoke-static v1, v2, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v2
    if-eqz v2, +008h
    check-cast v1, Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/View;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/View;
    goto -1fh
    const/4 v0, 0
    goto -21h
    return-void 
.end method

.method private final notifyInlineViewCreated()void
    .registers 5
    # ins_size=1
    move-object v0, v4
    check-cast v0, Landroid/view/View;
    if-eqz v0, +02bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tag_on_pure_show_widget_inline_view_created I
    invoke-virtual v0, v1, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v1
    const/4 v2, 1
    invoke-static v1, v2, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v3
    if-eqz v3, +011h
    const-string v0, "null cannot be cast to non-null type kotlin.Function1<com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView, kotlin.Unit>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, v2, Lkotlin/jvm/internal/TypeIntrinsics;->beforeCheckcastToFunctionOfArity(Ljava/lang/Object; I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlin/jvm/functions/Function1;
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    invoke-virtual v0, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/View;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/View;
    goto -28h
    const/4 v0, 0
    goto -2ah
    return-void 
.end method

.method private final openFullscreenPreview()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    if-nez v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "getContext(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;->start$conversation_mainlandRelease(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;)V
    return-void 
.end method

.method private final parseHeightMeasurement(java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.HeightMeasurement
    .registers 13
    # ins_size=2
    const/4 v0, 0
    if-eqz v12, +059h
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v12, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +04dh
    const/4 v1, 1
    new-array v2, v1, [C
    const/16 v3, 34
    const/4 v4, 0
    aput-char v3, v2, v4
    invoke-static v12, v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +03fh
    move-object v5, v12
    check-cast v5, Ljava/lang/CharSequence;
    const-string v12, ","
    filled-new-array v12, [Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 6
    const/4 v10, 0
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v12
    invoke-static v12, v4, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-eqz v2, +026h
    invoke-static v2, Lkotlin/text/StringsKt;->toFloatOrNull(Ljava/lang/String;)Ljava/lang/Float;
    move-result-object v2
    if-eqz v2, +020h
    invoke-virtual v2, Ljava/lang/Float;->floatValue()F
    move-result v0
    invoke-static v12, v1, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Ljava/lang/String;
    if-eqz v12, +00dh
    invoke-static v12, Lkotlin/text/StringsKt;->toFloatOrNull(Ljava/lang/String;)Ljava/lang/Float;
    move-result-object v12
    if-eqz v12, +007h
    invoke-virtual v12, Ljava/lang/Float;->floatValue()F
    move-result v12
    goto +2h
    const/4 v12, 0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
    invoke-direct v1, v0, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;-><init>(F F)V
    return-object v1
    return-object v0
.end method

.method private final resetWebViewHeight(int)void
    .registers 4
    # ins_size=2
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    sub-int v0, v3, v0
    invoke-static v0, Ljava/lang/Math;->abs(I)I
    move-result v0
    const/4 v1, 1
    if-gt v0, v1, +003h
    return-void 
    iput v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-eqz v0, +00eh
    invoke-virtual v0, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v0, v1, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v0, Landroid/webkit/WebView;->requestLayout()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->requestLayout()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->notifyContentChanged()V
    return-void 
.end method

.method static synthetic resetWebViewHeight$default(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  int  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->bootstrapHeightPx I
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->resetWebViewHeight(I)V
    return-void 
.end method

.method private final scheduleHeightChecks()void
    .registers 8
    # ins_size=1
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->HEIGHT_CHECK_DELAYS_MS [J
    array-length v1, v0
    iput v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    array-length v1, v0
    const/4 v2, 0
    if-ge v2, v1, +00eh
    aget-wide v3, v0, v2
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable Ljava/lang/Runnable;
    invoke-virtual v5, v6, v3, v4, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    add-int/lit8 v2, v2, 1
    goto -dh
    return-void 
.end method

.method private final setupSettings(android.webkit.WebView)void
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;
    move-result-object v3
    const/4 v0, 1
    invoke-virtual v3, v0, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    invoke-virtual v3, v0, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V
    const-string v1, "UTF-8"
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setDefaultTextEncodingName(Ljava/lang/String;)V
    invoke-virtual v3, v0, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V
    const/4 v1, 0
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V
    invoke-virtual v3, v0, Landroid/webkit/WebSettings;->setMixedContentMode(I)V
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setSupportZoom(Z)V
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setDisplayZoomControls(Z)V
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setAllowContentAccess(Z)V
    invoke-virtual v3, v1, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V
    invoke-virtual v3, v0, Landroid/webkit/WebSettings;->setMediaPlaybackRequiresUserGesture(Z)V
    return-void 
.end method

.method private final showLoading(java.util.List)void
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v0
    const/4 v1, 0
    const/4 v2, 1
    const/16 v3, 8
    if-nez v0, +019h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/webkit/WebView;->getVisibility()I
    move-result v0
    goto +2h
    move v0, v3
    if-ne v0, v3, +00dh
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v0, Landroidx/appcompat/widget/AppCompatImageButton;->getVisibility()I
    move-result v0
    if-eq v0, v3, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    check-cast v8, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +016h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Ljava/lang/String;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v2
    if-eqz v6, -014h
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v4, Ljava/util/List;
    iget-object v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    invoke-static v4, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    xor-int/2addr v8, v2
    if-eqz v8, +007h
    iput-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    iput v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    goto +21h
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    xor-int/2addr v2, v4
    if-eqz v2, +017h
    iget v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    if-lt v2, v4, +00dh
    iget v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->size()I
    move-result v4
    rem-int/2addr v2, v4
    iput v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->updateLoadingMessage()V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingIconView Landroid/widget/ImageView;
    invoke-virtual v2, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v2, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v2, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-eqz v1, +005h
    invoke-virtual v1, v3, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v1, v3, Landroidx/appcompat/widget/AppCompatImageButton;->setVisibility(I)V
    if-nez v8, +006h
    iget-boolean v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRotationActive Z
    if-nez v8, +005h
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->startLoadingMessageRotation()V
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->startLoadingAnimation()V
    if-eqz v0, +005h
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->notifyContentChanged()V
    return-void 
.end method

.method static synthetic showLoading$default(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  java.util.List  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showLoading(Ljava/util/List;)V
    return-void 
.end method

.method private final showRenderProcessFailure()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +004h
    move v0, v2
    goto +2h
    move v0, v1
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v3, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v3
    if-nez v3, +011h
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-nez v3, +00dh
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v3, Landroidx/appcompat/widget/AppCompatImageButton;->getVisibility()I
    move-result v3
    if-eq v3, v0, +003h
    goto +3h
    move v3, v2
    goto +2h
    const/4 v3, 1
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingAnimation()V
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingMessageRotation()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    iput-object v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    iput v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingIconView Landroid/widget/ImageView;
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingTextView Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_chat_artifact_preview_failed I
    invoke-virtual v1, v4, Landroid/widget/TextView;->setText(I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v1, v0, Landroidx/appcompat/widget/AppCompatImageButton;->setVisibility(I)V
    if-eqz v3, +005h
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->notifyContentChanged()V
    return-void 
.end method

.method private final showWebView()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-nez v0, +006h
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->attachNewWebView()Landroid/webkit/WebView;
    move-result-object v0
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    const/4 v2, 0
    const/16 v3, 8
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v4, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v4
    if-ne v4, v3, +013h
    invoke-virtual v0, Landroid/webkit/WebView;->getVisibility()I
    move-result v4
    if-nez v4, +00dh
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v4, Landroidx/appcompat/widget/AppCompatImageButton;->getVisibility()I
    move-result v4
    if-eq v4, v1, +003h
    goto +3h
    move v4, v2
    goto +2h
    const/4 v4, 1
    iget-object v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingAnimation()V
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingMessageRotation()V
    invoke-virtual v0, v2, Landroid/webkit/WebView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v0, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setVisibility(I)V
    if-eqz v4, +005h
    invoke-direct v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->notifyContentChanged()V
    return-void 
.end method

.method private final startLoadingAnimation()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->isAttachedToWindow()Z
    move-result v0
    if-eqz v0, +025h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v0
    if-eqz v0, +003h
    goto +1bh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingIconView Landroid/widget/ImageView;
    invoke-virtual v0, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v1, v0, Landroid/graphics/drawable/AnimationDrawable;
    if-eqz v1, +005h
    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Landroid/graphics/drawable/AnimationDrawable;->isRunning()Z
    move-result v1
    if-nez v1, +005h
    invoke-virtual v0, Landroid/graphics/drawable/AnimationDrawable;->start()V
    return-void 
.end method

.method private final startLoadingMessageRotation()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRunnable Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
    check-cast v1, Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRotationActive Z
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->isAttachedToWindow()Z
    move-result v0
    if-eqz v0, +021h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v0
    if-nez v0, +019h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    const/4 v1, 1
    if-gt v0, v1, +003h
    goto +eh
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRotationActive Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRunnable Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
    check-cast v1, Ljava/lang/Runnable;
    const-wide/16 v2, 3000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method

.method private final stopLoadingAnimation()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingIconView Landroid/widget/ImageView;
    invoke-virtual v0, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;
    move-result-object v0
    instance-of v1, v0, Landroid/graphics/drawable/AnimationDrawable;
    if-eqz v1, +005h
    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/graphics/drawable/AnimationDrawable;->stop()V
    return-void 
.end method

.method private final stopLoadingMessageRotation()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRunnable Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$loadingMessageRunnable$1;
    check-cast v1, Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageRotationActive Z
    return-void 
.end method

.method private final updateHeightFromContent()void
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-eqz v0, +003h
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-nez v0, +003h
    return-void 
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->isAttachedToWindow()Z
    move-result v1
    if-eqz v1, +015h
    invoke-virtual v0, Landroid/webkit/WebView;->getVisibility()I
    move-result v1
    if-eqz v1, +003h
    goto +dh
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightCacheKey Ljava/lang/String;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;
    invoke-direct v2, v3, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/webkit/WebView; Ljava/lang/String;)V
    const-string v1, "
            (function() {
                var doc = document.documentElement || {};
                var root = document.getElementById('trae-widget-root');
                if (!root || !root.getBoundingClientRect) {
                    return '0,0';
                }
                var rootRect = root.getBoundingClientRect();
                var height = Math.max(rootRect.height || 0, root.scrollHeight || 0, root.offsetHeight || 0);
                var children = root.children || [];
                for (var i = 0; i < children.length; i++) {
                    var childRect = children[i].getBoundingClientRect();
                    height = Math.max(height, childRect.bottom - rootRect.top);
                }
                var viewportWidth = window.innerWidth || doc.clientWidth || rootRect.width || 0;
                return height + ',' + viewportWidth;
            })();
        "
    invoke-virtual v0, v1, v2, Landroid/webkit/WebView;->evaluateJavascript(Ljava/lang/String; Landroid/webkit/ValueCallback;)V
    return-void 
.end method

.method private static final updateHeightFromContent$lambda$16(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.webkit.WebView  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=4
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-nez v0, +09fh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-ne v0, v4, +09bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->isAttachedToWindow()Z
    move-result v0
    if-eqz v0, +095h
    invoke-virtual v4, Landroid/webkit/WebView;->getVisibility()I
    move-result v0
    if-eqz v0, +004h
    goto/16 +08dh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightCacheKey Ljava/lang/String;
    invoke-static v0, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-direct v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->parseHeightMeasurement(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;
    move-result-object v6
    if-nez v6, +003h
    return-void 
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->getHeightCss()F
    move-result v0
    const/4 v1, 0
    cmpg-float v0, v0, v1
    if-lez v0, +074h
    invoke-virtual v4, Landroid/webkit/WebView;->getWidth()I
    move-result v0
    if-gtz v0, +003h
    goto +6ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->getViewportWidthCss()F
    move-result v0
    invoke-static v0, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->floatValue()F
    move-result v2
    cmpl-float v1, v2, v1
    const/4 v2, 1
    if-lez v1, +004h
    move v1, v2
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +00fh
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->floatValue()F
    move-result v0
    invoke-virtual v4, Landroid/webkit/WebView;->getWidth()I
    move-result v1
    int-to-float v1, v1
    div-float/2addr v1, v0
    goto +bh
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v1, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/HeightMeasurement;->getHeightCss()F
    move-result v6
    mul-float/2addr v6, v1
    float-to-double v0, v6
    invoke-static v0, v1, Ljava/lang/Math;->ceil(D)D
    move-result-wide v0
    double-to-float v6, v0
    float-to-int v6, v6
    invoke-static v2, v6, Ljava/lang/Math;->max(I I)I
    move-result v6
    iput-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightMeasuredForCurrentLoad Z
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;
    invoke-virtual v0, v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;->putCachedHeight(Ljava/lang/String; I)V
    iget v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    sub-int v5, v6, v5
    invoke-static v5, Ljava/lang/Math;->abs(I)I
    move-result v5
    if-le v5, v2, +018h
    iput v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    invoke-virtual v4, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v5
    iget v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentHeightPx I
    iput v6, v5, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v4, v5, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v4, Landroid/webkit/WebView;->requestLayout()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->requestLayout()V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->notifyContentChanged()V
    return-void 
.end method

.method private final updateLoadingMessage()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingTextView Landroid/widget/TextView;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    iget v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingMessageIndex I
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-eqz v1, +005h
    check-cast v1, Ljava/lang/CharSequence;
    goto +12h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_artifact_loading I
    invoke-virtual v1, v2, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "getString(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload  boolean)void
    .registers 8
    # ins_size=3
    const-string v0, "payload"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-eqz v0, +003h
    return-void 
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetCode()Ljava/lang/String;
    move-result-object v0
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->presentationState Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetId()Ljava/lang/String;
    move-result-object v2
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    const/4 v4, 1
    xor-int/2addr v3, v4
    invoke-virtual v1, v2, v7, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->resolve(Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;->getWidgetChanged()Z
    move-result v1
    const/4 v2, 0
    const/4 v3, 0
    if-eqz v1, +014h
    iput-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->renderProcessFailed Z
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-nez v1, +005h
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->attachNewWebView()Landroid/webkit/WebView;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    iput-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->hasLoggedFinishedRegression Z
    invoke-static v5, v3, v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->resetWebViewHeight$default(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; I I Ljava/lang/Object;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;->getMode()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    move-result-object v7
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->ordinal()I
    move-result v7
    aget v7, v1, v7
    if-eq v7, v4, +05fh
    const/4 v1, 2
    if-eq v7, v1, +040h
    const/4 v0, 3
    if-ne v7, v0, +037h
    iget-boolean v7, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->hasLoggedFinishedRegression Z
    if-nez v7, +01eh
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "[InlineView] keep completed content after groupFinished regression, widgetId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v0, "PureShowWidget"
    invoke-virtual v7, v0, v6, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String;)V
    iput-boolean v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->hasLoggedFinishedRegression Z
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    if-eqz v6, +003h
    goto +2h
    move v4, v3
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setClickable(Z)V
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->renderProcessFailed Z
    if-eqz v6, +006h
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showRenderProcessFailure()V
    goto +33h
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showWebView()V
    goto +2fh
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    iput-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setClickable(Z)V
    iget-boolean v7, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->renderProcessFailed Z
    if-eqz v7, +006h
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showRenderProcessFailure()V
    goto +1ch
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showWebView()V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +012h
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadWidgetCode(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload; Ljava/lang/String;)V
    goto +dh
    iput-object v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    invoke-virtual v5, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setClickable(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getLoadingMessages()Ljava/util/List;
    move-result-object v6
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->showLoading(Ljava/util/List;)V
    return-void 
.end method

.method protected onAttachedToWindow()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroid/widget/FrameLayout;->onAttachedToWindow()V
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-eqz v0, +003h
    return-void 
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->notifyInlineViewCreated()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->loadingContainer Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getVisibility()I
    move-result v0
    if-nez v0, +008h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->startLoadingAnimation()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->startLoadingMessageRotation()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/webkit/WebView;->getVisibility()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +017h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    if-eqz v0, +013h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightChecksAfterAttach Z
    if-nez v0, +00ah
    iget v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    if-gtz v0, +006h
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightMeasuredForCurrentLoad Z
    if-nez v0, +007h
    iput-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightChecksAfterAttach Z
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->scheduleHeightChecks()V
    return-void 
.end method

.method protected onDetachedFromWindow()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightCheckRunnable Ljava/lang/Runnable;
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingAnimation()V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingMessageRotation()V
    invoke-super v2, Landroid/widget/FrameLayout;->onDetachedFromWindow()V
    return-void 
.end method

.method public final release()void
    .registers 5
    # ins_size=1
    iget-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    if-eqz v0, +003h
    return-void 
    const/4 v0, 1
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->released Z
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->handler Landroid/os/Handler;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V
    const/4 v0, 0
    iput v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightCheckCount I
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->pendingHeightChecksAfterAttach Z
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->heightMeasuredForCurrentLoad Z
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingAnimation()V
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->stopLoadingMessageRotation()V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenPayload Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->lastWidgetCode Ljava/lang/String;
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->renderProcessFailed Z
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->presentationState Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->reset()V
    iput-boolean v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->hasLoggedFinishedRegression Z
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iput-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->currentLoadingMessages Ljava/util/List;
    invoke-virtual v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->fullscreenButton Landroidx/appcompat/widget/AppCompatImageButton;
    invoke-virtual v2, v1, Landroidx/appcompat/widget/AppCompatImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->webView Landroid/webkit/WebView;
    if-eqz v2, +006h
    const/4 v3, 2
    invoke-static v4, v2, v0, v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->destroyWebView$default(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/webkit/WebView; Z I Ljava/lang/Object;)V
    return-void 
.end method
