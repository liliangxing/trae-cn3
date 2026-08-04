# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;
.super Ljava/lang/Object;
.source "VoiceSummaryRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field private static final COLOR_CARD_BG:I
.field private static final COLOR_CARD_DIVIDER:I
.field private static final COLOR_CARD_HEADER_BG:I
.field private static final COLOR_CARD_STROKE:I
.field private static final COLOR_DIVIDER:I
.field private static final COLOR_HEADING:I
.field private static final COLOR_TEXT_PRIMARY:I
.field private static final COLOR_TEXT_SECONDARY:I
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;
.field private static final HEADING_STYLE_CONFIG:Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
.field private static final SECTION_HEADING_REGEX:Lkotlin/text/Regex;
.field private static final TAG_BOTTOM:Ljava/lang/String;
.field private static final TAG_FOOTER_CONTAINER:Ljava/lang/String;
.field private static final TAG_HEADER:Ljava/lang/String;
.field private static final TAG_MARKDOWN_CONTAINER:Ljava/lang/String;


.method public static synthetic $r8$lambda$KSYhGc9gSTAM3NmizLRWX1G2Bzo(android.content.Context  java.lang.String  java.lang.String  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createHistoryButton$lambda$20$lambda$19(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 8
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "^#{1,2}\s+.+"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->SECTION_HEADING_REGEX Lkotlin/text/Regex;
    const-string v0, "#171717"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_TEXT_PRIMARY I
    const-string v0, "#737373"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_TEXT_SECONDARY I
    const-string v0, "#000000"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_HEADING I
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    const/4 v2, 6
    new-array v3, v2, [Lkotlin/Pair;
    const/4 v4, 1
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/high16 v6, 1099956224
    invoke-static v6, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v7, 0
    aput-object v5, v3, v7
    const/4 v5, 2
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v7, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v3, v4
    const/4 v4, 3
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v7, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v3, v5
    const/4 v5, 4
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const/high16 v7, 1099431936
    invoke-static v7, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v3, v4
    const/4 v4, 5
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const/high16 v7, 1098907648
    invoke-static v7, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v3, v5
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/high16 v5, 1097859072
    invoke-static v5, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v5
    invoke-static v2, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v3, v4
    invoke-static v3, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;-><init>(Ljava/util/Map; Ljava/lang/Integer;)V
    sput-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->HEADING_STYLE_CONFIG Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    const-string v0, "#1F4D6B99"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_DIVIDER I
    const/16 v0, 244
    invoke-static v0, v0, v0, Landroid/graphics/Color;->rgb(I I I)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_BG I
    const-string v0, "#14737373"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_HEADER_BG I
    const-string v0, "#2E737373"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_STROKE I
    const-string v0, "#2E4D6B99"
    invoke-static v0, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v0
    sput v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_DIVIDER I
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getCOLOR_DIVIDER$cp()int
    .registers 1
    # ins_size=0
    sget v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_DIVIDER I
    return v0
.end method

.method private final bind(android.widget.LinearLayout  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummary  android.widget.TextView  android.widget.LinearLayout  android.widget.TextView)void
    .registers 9
    # ins_size=6
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getHeader()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v6, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getHeader()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    invoke-virtual v6, v0, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getBottom()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v8, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getBottom()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move v1, v2
    invoke-virtual v8, v1, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getTrackingId()Ljava/lang/String;
    move-result-object v6
    const/4 v8, 0
    if-nez v6, +010h
    sget v6, Lcom/bytedance/trae/conversation/R$id;->tag_summary_tracking_id I
    invoke-virtual v4, v6, Landroid/widget/LinearLayout;->getTag(I)Ljava/lang/Object;
    move-result-object v6
    instance-of v0, v6, Ljava/lang/String;
    if-eqz v0, +005h
    check-cast v6, Ljava/lang/String;
    goto +2h
    move-object v6, v8
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;
    move-object v1, v4
    check-cast v1, Landroid/view/View;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;->cancelTypewriter(Landroid/view/View;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getMarkdown()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getFinished()Z
    move-result v1
    invoke-direct v3, v7, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->renderMarkdownSections(Landroid/widget/LinearLayout; Ljava/lang/String; Z)V
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->renderFooter(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->tag_on_content_changed I
    invoke-virtual v4, v7, Landroid/widget/LinearLayout;->getTag(I)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/TypeIntrinsics;->isFunctionOfArity(Ljava/lang/Object; I)Z
    move-result v7
    if-eqz v7, +005h
    move-object v8, v4
    check-cast v8, Lkotlin/jvm/functions/Function0;
    if-eqz v8, +005h
    invoke-interface v8, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getMarkdown()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    const/4 v2, 1
    if-eqz v2, +012h
    sget-object v4, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v4, v6, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markFirstChar(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getFinished()Z
    move-result v4
    if-eqz v4, +007h
    sget-object v4, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->INSTANCE Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;
    invoke-virtual v4, v6, Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;->markLastChar(Ljava/lang/String;)V
    return-void 
.end method

.method private final createBodyText(android.content.Context  float  float)android.widget.TextView
    .registers 6
    # ins_size=4
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v3, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_TEXT_PRIMARY I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v1, 2
    invoke-virtual v0, v1, v4, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v4, sans-serif
    const/4 v1, 0
    invoke-static v4, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v4
    invoke-virtual v0, v4, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    invoke-direct v2, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->spToPx(Landroid/content/Context; F)I
    move-result v3
    invoke-static v0, v3, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    return-object v0
.end method

.method private final createCardBackground(float  int)android.graphics.drawable.GradientDrawable
    .registers 5
    # ins_size=3
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v0, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    invoke-virtual v0, v3, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    sget v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_BG I
    invoke-virtual v0, v3, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    sget v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_STROKE I
    invoke-virtual v0, v4, v3, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    return-object v0
.end method

.method private final createCardHeader(android.content.Context  float)android.widget.LinearLayout
    .registers 9
    # ins_size=3
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 16
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v3, 12
    int-to-float v3, v3
    mul-float/2addr v3, v0
    invoke-static v3, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v0
    invoke-static v3, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v3
    invoke-virtual v1, v0, v2, v3, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v0, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v0, v2, Landroid/graphics/drawable/GradientDrawable;->setShape(I)V
    sget v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_HEADER_BG I
    invoke-virtual v0, v3, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v3, 8
    new-array v3, v3, [F
    aput v8, v3, v2
    const/4 v4, 1
    aput v8, v3, v4
    const/4 v4, 2
    aput v8, v3, v4
    const/4 v5, 3
    aput v8, v3, v5
    const/4 v8, 4
    const/4 v5, 0
    aput v5, v3, v8
    const/4 v8, 5
    aput v5, v3, v8
    const/4 v8, 6
    aput v5, v3, v8
    const/4 v8, 7
    aput v5, v3, v8
    invoke-virtual v0, v3, Landroid/graphics/drawable/GradientDrawable;->setCornerRadii([F)V
    check-cast v0, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v0, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v8, Landroid/widget/TextView;
    invoke-direct v8, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_discussion_results I
    invoke-virtual v8, v0, Landroid/widget/TextView;->setText(I)V
    sget v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_TEXT_SECONDARY I
    invoke-virtual v8, v0, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v0, 1097859072
    invoke-virtual v8, v4, v0, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v0, sans-serif
    invoke-static v0, v2, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v8, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v8, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const/high16 v0, 1101004800
    invoke-direct v6, v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->spToPx(Landroid/content/Context; F)I
    move-result v7
    invoke-static v8, v7, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    check-cast v8, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v0, -2
    invoke-direct v7, v0, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v8, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-object v1
.end method

.method private final createDivider(android.content.Context  int)android.view.View
    .registers 5
    # ins_size=3
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v3, Landroid/view/View;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v4, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    const/4 v1, 1
    invoke-direct v3, v4, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-object v0
.end method

.method static synthetic createDivider$default(com.bytedance.trae.conversation.chat.block.renderer.VoiceSummaryRenderer  android.content.Context  int  int  java.lang.Object)android.view.View
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    sget v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_DIVIDER I
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createDivider(Landroid/content/Context; I)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method private final createHistoryButton(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummary)android.widget.TextView
    .registers 10
    # ins_size=3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getFinished()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getHistorySessionId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +0a2h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const/4 v3, 1
    xor-int/2addr v2, v3
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    if-nez v0, +004h
    goto/16 +091h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getConversationId()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +08bh
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v3
    if-eqz v2, +003h
    goto +2h
    move-object v9, v1
    if-nez v9, +003h
    goto +7bh
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v8, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_view_voice_history I
    invoke-virtual v2, v4, Landroid/widget/TextView;->setText(I)V
    const/16 v4, 17
    invoke-virtual v2, v4, Landroid/widget/TextView;->setGravity(I)V
    sget v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_TEXT_PRIMARY I
    invoke-virtual v2, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v4, 2
    const/high16 v5, 1099431936
    invoke-virtual v2, v4, v5, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v4, sans-serif-medium
    const/4 v5, 0
    invoke-static v4, v5, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v4
    invoke-virtual v2, v4, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v2, v5, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const/high16 v4, 1103101952
    invoke-direct v7, v8, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->spToPx(Landroid/content/Context; F)I
    move-result v4
    invoke-static v2, v4, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_view_voice_history_btn I
    invoke-virtual v2, v4, Landroid/widget/TextView;->setBackgroundResource(I)V
    new-instance v4, Landroid/util/TypedValue;
    invoke-direct v4, Landroid/util/TypedValue;-><init>()V
    invoke-virtual v8, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;
    move-result-object v5
    const v6, 16843534
    invoke-virtual v5, v6, v4, v3, Landroid/content/res/Resources$Theme;->resolveAttribute(I Landroid/util/TypedValue; Z)Z
    iget v4, v4, Landroid/util/TypedValue;->resourceId I
    invoke-virtual v8, v4, Landroid/content/Context;->getDrawable(I)Landroid/graphics/drawable/Drawable;
    move-result-object v4
    invoke-virtual v2, v4, Landroid/widget/TextView;->setForeground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, v3, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v2, v3, Landroid/widget/TextView;->setFocusable(Z)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v4, 36
    int-to-float v4, v4
    mul-float/2addr v4, v1
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    const/4 v4, -1
    invoke-direct v3, v4, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;
    invoke-direct v1, v8, v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;-><init>(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, v1, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-object v2
    return-object v1
.end method

.method private static final createHistoryButton$lambda$20$lambda$19(android.content.Context  java.lang.String  java.lang.String  android.view.View)void
    .registers 5
    # ins_size=4
    instance-of v4, v1, Landroidx/fragment/app/FragmentActivity;
    if-eqz v4, +005h
    check-cast v1, Landroidx/fragment/app/FragmentActivity;
    goto +2h
    const/4 v1, 0
    if-nez v1, +003h
    return-void 
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;
    invoke-virtual v1, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v1
    const-string v0, "getSupportFragmentManager(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$Companion;->show(Landroidx/fragment/app/FragmentManager; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final createMarkdownView(android.content.Context)com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView
    .registers 9
    # ins_size=2
    new-instance v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_TEXT_PRIMARY I
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextColor(I)V
    const/4 v0, 2
    const/high16 v1, 1098907648
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setTextSize(I F)V
    const/4 v0, 0
    const/high16 v1, 1065353216
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setLineSpacing(F F)V
    move-object v0, v6
    check-cast v0, Landroid/widget/TextView;
    const/high16 v1, 1102053376
    invoke-direct v7, v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->spToPx(Landroid/content/Context; F)I
    move-result v8
    invoke-static v0, v8, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->HEADING_STYLE_CONFIG Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    invoke-virtual v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->setHeadingStyle(Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;)V
    return-object v6
.end method

.method private final createSummaryCard(android.content.Context)android.widget.LinearLayout
    .registers 15
    # ins_size=2
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    const/high16 v1, 1098907648
    mul-float/2addr v1, v0
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    int-to-float v4, v3
    mul-float/2addr v4, v0
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    invoke-direct v13, v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createCardBackground(F I)Landroid/graphics/drawable/GradientDrawable;
    move-result-object v4
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setClipToOutline(Z)V
    invoke-direct v13, v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createCardHeader(Landroid/content/Context; F)Landroid/widget/LinearLayout;
    move-result-object v1
    check-cast v1, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v5, 40
    int-to-float v5, v5
    mul-float/2addr v5, v0
    invoke-static v5, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v5
    const/4 v6, -1
    invoke-direct v4, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 12
    int-to-float v4, v4
    mul-float/2addr v4, v0
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v0
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v5
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v7
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    invoke-virtual v1, v0, v5, v7, v4, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const-string/jumbo v4, voice_summary_markdown_container
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    check-cast v0, Landroid/view/View;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 7
    const/4 v12, 0
    move-object v7, v13
    invoke-static/range v7 ... v12, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp$default(Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer; F F F I Ljava/lang/Object;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v4
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const-string/jumbo v14, voice_summary_footer_container
    invoke-virtual v0, v14, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    check-cast v0, Landroid/view/View;
    invoke-static/range v7 ... v12, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp$default(Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer; F F F I Ljava/lang/Object;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v14
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v0, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    new-instance v14, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v0, -2
    invoke-direct v14, v6, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v1, v14, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-object v2
.end method

.method private final matchWrapLp(float  float  float)android.widget.LinearLayout$LayoutParams
    .registers 7
    # ins_size=4
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    mul-float/2addr v4, v6
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    iput v4, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    mul-float/2addr v5, v6
    invoke-static v5, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    iput v4, v0, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    return-object v0
.end method

.method static synthetic matchWrapLp$default(com.bytedance.trae.conversation.chat.block.renderer.VoiceSummaryRenderer  float  float  float  int  java.lang.Object)android.widget.LinearLayout$LayoutParams
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    const/high16 v4, 1065353216
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp(F F F)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v1
    return-object v1
.end method

.method private final renderFooter(android.widget.LinearLayout  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummary)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, voice_summary_footer_container
    invoke-virtual v6, v0, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/LinearLayout;
    if-nez v6, +003h
    return-void 
    invoke-virtual v6, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v6, Landroid/widget/LinearLayout;->removeAllViews()V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createHistoryButton(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;)Landroid/widget/TextView;
    move-result-object v7
    if-nez v7, +003h
    return-void 
    sget v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_DIVIDER I
    invoke-direct v5, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createDivider(Landroid/content/Context; I)Landroid/view/View;
    move-result-object v0
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v3, 1056964608
    mul-float/2addr v3, v1
    invoke-static v3, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v3
    const/4 v4, 1
    invoke-static v4, v3, Ljava/lang/Math;->max(I I)I
    move-result v3
    const/4 v4, -1
    invoke-direct v2, v4, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v3, 16
    int-to-float v3, v3
    mul-float/2addr v3, v1
    invoke-static v3, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    iput v1, v2, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v7, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-static v3, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v7, Landroid/view/View;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v7, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final renderMarkdownSections(android.widget.LinearLayout  java.lang.String  boolean)void
    .registers 16
    # ins_size=4
    invoke-virtual v13, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v13, Landroid/widget/LinearLayout;->removeAllViews()V
    invoke-direct v12, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->splitMarkdownSections(Ljava/lang/String;)Ljava/util/List;
    move-result-object v14
    check-cast v14, Ljava/lang/Iterable;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    const/4 v2, 0
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +06bh
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    add-int/lit8 v4, v2, 1
    if-gez v2, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v3, Ljava/lang/String;
    if-lez v2, +034h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->COLOR_CARD_DIVIDER I
    invoke-direct v12, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createDivider(Landroid/content/Context; I)Landroid/view/View;
    move-result-object v2
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v6, 1056964608
    mul-float/2addr v6, v1
    invoke-static v6, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v6
    const/4 v7, 1
    invoke-static v7, v6, Ljava/lang/Math;->max(I I)I
    move-result v6
    const/4 v7, -1
    invoke-direct v5, v7, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v6, 12
    int-to-float v6, v6
    mul-float/2addr v6, v1
    invoke-static v6, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v7
    iput v7, v5, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-static v6, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v6
    iput v6, v5, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v2, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v12, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createMarkdownView(Landroid/content/Context;)Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/view/View;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 7
    const/4 v11, 0
    move-object v6, v12
    invoke-static/range v6 ... v11, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp$default(Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer; F F F I Ljava/lang/Object;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v6
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v5, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;
    invoke-virtual v6, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->taskListAsBulletList(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;->TEXT_COLOR_DISC Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;
    invoke-virtual v5, v2, v3, v15, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper;->setMarkdownContent(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$ListBulletStyle;)V
    move v2, v4
    goto -6eh
    return-void 
.end method

.method private final spToPx(android.content.Context  float)int
    .registers 4
    # ins_size=3
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    const/4 v0, 2
    invoke-static v0, v3, v2, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v2
    invoke-static v2, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v2
    return v2
.end method

.method private final splitMarkdownSections(java.lang.String)java.util.List
    .registers 16
    # ins_size=2
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v15
    return-object v15
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    invoke-static v15, Lkotlin/text/StringsKt;->lines(Ljava/lang/CharSequence;)Ljava/util/List;
    move-result-object v15
    check-cast v15, Ljava/lang/Iterable;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +058h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->SECTION_HEADING_REGEX Lkotlin/text/Regex;
    move-object v6, v2
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v5, v6, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +039h
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    instance-of v6, v5, Ljava/util/Collection;
    if-eqz v6, +00ch
    move-object v6, v5
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +003h
    goto +1bh
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +012h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/2addr v6, v4
    if-eqz v6, -013h
    move v3, v4
    if-eqz v3, +00ch
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -5dh
    move-object v15, v1
    check-cast v15, Ljava/lang/Iterable;
    instance-of v2, v15, Ljava/util/Collection;
    if-eqz v2, +00ch
    move-object v2, v15
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +1bh
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v4
    if-eqz v2, -013h
    move v3, v4
    if-eqz v3, +005h
    invoke-interface v0, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    check-cast v0, Ljava/lang/Iterable;
    new-instance v15, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v15, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v15, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    const-string v1, "
"
    move-object v6, v1
    check-cast v6, Ljava/lang/CharSequence;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/16 v12, 62
    const/4 v13, 0
    invoke-static/range v5 ... v13, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-interface v15, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2dh
    check-cast v15, Ljava/util/List;
    check-cast v15, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +016h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v4
    if-eqz v2, -014h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummary)android.view.View
    .registers 19
    # ins_size=3
    move-object/from16 v6, v16
    move-object/from16 v7, v17
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    move-object/from16 v8, v18
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v9, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v10, Landroid/widget/LinearLayout;
    invoke-direct v10, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v10, v0, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v1, 8
    int-to-float v1, v1
    mul-float/2addr v1, v9
    invoke-static v1, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    iput v1, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_summary_tracking_id I
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;->getTrackingId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v10, v0, v1, Landroid/widget/LinearLayout;->setTag(I Ljava/lang/Object;)V
    const/high16 v11, 1099431936
    const/high16 v12, 1103101952
    invoke-direct v6, v7, v11, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createBodyText(Landroid/content/Context; F F)Landroid/widget/TextView;
    move-result-object v13
    const-string/jumbo v0, voice_summary_header
    invoke-virtual v13, v0, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V
    move-object v14, v13
    check-cast v14, Landroid/view/View;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object/from16 v0, v16
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp$default(Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer; F F F I Ljava/lang/Object;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v0
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v14, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct/range v16 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createSummaryCard(Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v0
    const-string/jumbo v1, voice_summary_markdown_container
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/LinearLayout;
    if-nez v1, +007h
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    move-object v14, v1
    move-object v15, v0
    check-cast v15, Landroid/view/View;
    const/high16 v1, 1098907648
    const/4 v2, 0
    const/4 v4, 2
    const/4 v5, 0
    move-object/from16 v0, v16
    move v3, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp$default(Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer; F F F I Ljava/lang/Object;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v0
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v15, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v6, v7, v11, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->createBodyText(Landroid/content/Context; F F)Landroid/widget/TextView;
    move-result-object v7
    const-string/jumbo v0, voice_summary_bottom
    invoke-virtual v7, v0, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V
    move-object v11, v7
    check-cast v11, Landroid/view/View;
    move-object/from16 v0, v16
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->matchWrapLp$default(Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer; F F F I Ljava/lang/Object;)Landroid/widget/LinearLayout$LayoutParams;
    move-result-object v0
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v10, v11, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object/from16 v0, v16
    move-object v1, v10
    move-object/from16 v2, v18
    move-object v3, v13
    move-object v4, v14
    move-object v5, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->bind(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/TextView;)V
    check-cast v10, Landroid/view/View;
    return-object v10
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$VoiceSummary)void
    .registers 9
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v7, Landroid/widget/LinearLayout;
    if-eqz v0, +005h
    check-cast v7, Landroid/widget/LinearLayout;
    goto +2h
    const/4 v7, 0
    move-object v1, v7
    if-nez v1, +003h
    return-void 
    const-string/jumbo v7, voice_summary_header
    invoke-virtual v1, v7, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v7
    move-object v3, v7
    check-cast v3, Landroid/widget/TextView;
    if-nez v3, +003h
    return-void 
    const-string/jumbo v7, voice_summary_markdown_container
    invoke-virtual v1, v7, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v7
    move-object v4, v7
    check-cast v4, Landroid/widget/LinearLayout;
    if-nez v4, +003h
    return-void 
    const-string/jumbo v7, voice_summary_bottom
    invoke-virtual v1, v7, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;
    move-result-object v7
    move-object v5, v7
    check-cast v5, Landroid/widget/TextView;
    if-nez v5, +003h
    return-void 
    move-object v0, v6
    move-object v2, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->bind(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/TextView;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;)V
    return-void 
.end method
