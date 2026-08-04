# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.super Landroidx/appcompat/widget/AppCompatTextView;
.source "SimpleMarkdownTextView.kt"

.implements Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;
.field private static final defaultHeaderConfig:Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
.field private _content:Lcom/larus/business/markdown/impl/markwon/MarkwonContent;
.field private final bgPaint:Landroid/graphics/Paint;
.field private final bgRect:Landroid/graphics/RectF;
.field private final codePaint:Landroid/graphics/Paint;
.field private headerStyleConfig:Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
.field private inlineCodeBgColor:I
.field private inlineCodeCornerRadius:F
.field private inlineCodeHPadding:F
.field private inlineCodeVPadding:F
.field private markdownWidth:I
.field private pendingStripResult:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
.field private final reusableFm:Landroid/graphics/Paint$FontMetrics;
.field private final traeRefRenderer:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;
.field private webReferences:Ljava/util/List;


.method public static synthetic $r8$lambda$Va3W2CL2CHoSLTDHywBt7fxiPWo(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->traeRefRenderer$lambda$1(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 8
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    const/4 v2, 6
    new-array v3, v2, [Lkotlin/Pair;
    const/4 v4, 1
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/high16 v6, 1101004800
    invoke-static v6, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v6
    invoke-static v5, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    const/4 v6, 0
    aput-object v5, v3, v6
    const/4 v5, 2
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const/high16 v7, 1100480512
    invoke-static v7, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v3, v4
    const/4 v4, 3
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    const/high16 v7, 1099956224
    invoke-static v7, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
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
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;-><init>(Ljava/util/Map; Ljava/lang/Integer;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->defaultHeaderConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, v4, Landroidx/appcompat/widget/AppCompatTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->defaultHeaderConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->headerStyleConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bgPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/RectF;
    invoke-direct v2, Landroid/graphics/RectF;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bgRect Landroid/graphics/RectF;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, Landroid/graphics/Paint;-><init>()V
    sget-object v3, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->codePaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint$FontMetrics;
    invoke-direct v2, Landroid/graphics/Paint$FontMetrics;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->reusableFm Landroid/graphics/Paint$FontMetrics;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$$ExternalSyntheticLambda0;
    invoke-direct v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->traeRefRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method public static final synthetic access$getDefaultHeaderConfig$cp()com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->defaultHeaderConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    return-object v0
.end method

.method private final bindHeadingStyles(android.text.Spanned)void
    .registers 5
    # ins_size=2
    invoke-interface v4, Landroid/text/Spanned;->length()I
    move-result v0
    const-class v1, Lio/noties/markwon/core/spans/HeadingSpan;
    const/4 v2, 0
    invoke-interface v4, v2, v0, v1, Landroid/text/Spanned;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v4
    check-cast v4, [Lio/noties/markwon/core/spans/HeadingSpan;
    const/4 v0, 1
    if-eqz v4, +00ah
    array-length v1, v4
    if-nez v1, +004h
    move v1, v0
    goto +2h
    move v1, v2
    if-eqz v1, +003h
    move v2, v0
    if-eqz v2, +003h
    return-void 
    invoke-static v4, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00eh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lio/noties/markwon/core/spans/HeadingSpan;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->headerStyleConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/markdown/MarkdownHeaderFactoryHooker;->bindHeadingStyle(Lio/noties/markwon/core/spans/HeadingSpan; Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;)V
    goto -11h
    return-void 
.end method

.method private final drawInlineCodeBackgrounds(android.graphics.Canvas)void
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getLayout()Landroid/text/Layout;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getText()Ljava/lang/CharSequence;
    move-result-object v3
    instance-of v4, v3, Landroid/text/Spanned;
    if-eqz v4, +005h
    check-cast v3, Landroid/text/Spanned;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    invoke-interface v3, Landroid/text/Spanned;->length()I
    move-result v4
    const-class v5, Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;
    const/4 v6, 0
    invoke-interface v3, v6, v4, v5, Landroid/text/Spanned;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v4
    check-cast v4, [Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;
    if-eqz v4, +00dh
    array-length v7, v4
    if-nez v7, +004h
    const/4 v7, 1
    goto +2h
    move v7, v6
    if-eqz v7, +003h
    goto +3h
    move v7, v6
    goto +2h
    const/4 v7, 1
    if-eqz v7, +003h
    return-void 
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bgPaint Landroid/graphics/Paint;
    iget v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeBgColor I
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setColor(I)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->codePaint Landroid/graphics/Paint;
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getPaint()Landroid/text/TextPaint;
    move-result-object v8
    invoke-virtual v8, Landroid/text/TextPaint;->getTextSize()F
    move-result v8
    invoke-virtual v7, v8, Landroid/graphics/Paint;->setTextSize(F)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->codePaint Landroid/graphics/Paint;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->reusableFm Landroid/graphics/Paint$FontMetrics;
    invoke-virtual v7, v8, Landroid/graphics/Paint;->getFontMetrics(Landroid/graphics/Paint$FontMetrics;)F
    invoke-virtual/range v19, Landroid/graphics/Canvas;->save()I
    move-result v7
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getTotalPaddingLeft()I
    move-result v8
    int-to-float v8, v8
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getTotalPaddingTop()I
    move-result v9
    int-to-float v9, v9
    invoke-virtual v1, v8, v9, Landroid/graphics/Canvas;->translate(F F)V
    invoke-static v4, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +0aah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/chat/block/renderer/InlineCodeSpan;
    invoke-interface v3, v8, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I
    move-result v9
    invoke-interface v3, v8, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I
    move-result v8
    if-ltz v9, -014h
    if-ltz v8, -016h
    if-lt v9, v8, +003h
    goto -1ah
    invoke-virtual v2, v9, Landroid/text/Layout;->getLineForOffset(I)I
    move-result v10
    invoke-virtual v2, v8, Landroid/text/Layout;->getLineForOffset(I)I
    move-result v11
    if-gt v10, v11, -023h
    move v12, v10
    invoke-virtual v2, v12, Landroid/text/Layout;->getLineStart(I)I
    move-result v13
    invoke-virtual v2, v12, Landroid/text/Layout;->getLineEnd(I)I
    move-result v14
    invoke-static v13, v9, Ljava/lang/Math;->max(I I)I
    move-result v13
    invoke-static v14, v8, Ljava/lang/Math;->min(I I)I
    move-result v14
    if-ge v13, v14, +068h
    invoke-virtual v2, v13, Landroid/text/Layout;->getPrimaryHorizontal(I)F
    move-result v13
    iget v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeHPadding F
    sub-float/2addr v13, v15
    const/4 v15, 0
    invoke-static v15, v13, Ljava/lang/Math;->max(F F)F
    move-result v13
    if-ne v12, v11, +005h
    const/16 v16, 1
    goto +3h
    move/from16 v16, v6
    if-nez v16, +00ah
    invoke-virtual v2, v12, Landroid/text/Layout;->getLineRight(I)F
    move-result v14
    iget v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeHPadding F
    add-float/2addr v14, v5
    goto +8h
    invoke-virtual v2, v14, Landroid/text/Layout;->getPrimaryHorizontal(I)F
    move-result v5
    iget v14, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeHPadding F
    add-float/2addr v14, v5
    if-ne v12, v10, +005h
    iget v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeVPadding F
    goto +2h
    move v5, v15
    if-eqz v16, +004h
    iget v15, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeVPadding F
    invoke-virtual v2, v12, Landroid/text/Layout;->getLineBaseline(I)I
    move-result v6
    int-to-float v6, v6
    move-object/from16 v17, v3
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->reusableFm Landroid/graphics/Paint$FontMetrics;
    iget v3, v3, Landroid/graphics/Paint$FontMetrics;->ascent F
    add-float/2addr v3, v6
    sub-float/2addr v3, v5
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->reusableFm Landroid/graphics/Paint$FontMetrics;
    iget v5, v5, Landroid/graphics/Paint$FontMetrics;->descent F
    add-float/2addr v6, v5
    add-float/2addr v6, v15
    if-le v12, v10, +00bh
    invoke-virtual v2, v12, Landroid/text/Layout;->getLineTop(I)I
    move-result v5
    int-to-float v5, v5
    invoke-static v3, v5, Ljava/lang/Math;->max(F F)F
    move-result v3
    if-ge v12, v11, +00bh
    invoke-virtual v2, v12, Landroid/text/Layout;->getLineBottom(I)I
    move-result v5
    int-to-float v5, v5
    invoke-static v6, v5, Ljava/lang/Math;->min(F F)F
    move-result v6
    iget-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bgRect Landroid/graphics/RectF;
    invoke-virtual v5, v13, v3, v14, v6, Landroid/graphics/RectF;->set(F F F F)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bgRect Landroid/graphics/RectF;
    iget v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeCornerRadius F
    iget-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bgPaint Landroid/graphics/Paint;
    invoke-virtual v1, v3, v5, v5, v6, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    goto +3h
    move-object/from16 v17, v3
    if-eq v12, v11, +009h
    add-int/lit8 v12, v12, 1
    move-object/from16 v3, v17
    const/4 v6, 0
    goto/16 -081h
    move-object/from16 v3, v17
    const/4 v6, 0
    goto/16 -0ach
    invoke-virtual v1, v7, Landroid/graphics/Canvas;->restoreToCount(I)V
    return-void 
.end method

.method private static final traeRefRenderer$lambda$1(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefGroup)void
    .registers 5
    # ins_size=3
    const-string v0, "anchor"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "group"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v3
    const-string v1, "getContext(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->webReferences Ljava/util/List;
    invoke-virtual v0, v3, v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->show(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Ljava/util/List;)V
    return-void 
.end method

.method public asTextView()android.widget.TextView
    .registers 2
    # ins_size=1
    move-object v0, v1
    check-cast v0, Landroid/widget/TextView;
    return-object v0
.end method

.method public getMarkdownContent()com.larus.business.markdown.api.model.MarkdownContent
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->_content Lcom/larus/business/markdown/impl/markwon/MarkwonContent;
    check-cast v0, Lcom/larus/business/markdown/api/model/MarkdownContent;
    return-object v0
.end method

.method public getMarkdownWidth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->markdownWidth I
    return v0
.end method

.method public getSelectedColor()int
    .registers 2
    # ins_size=1
    const v0, 1719254015
    return v0
.end method

.method public isSelected(int  int)boolean
    .registers 3
    # ins_size=3
    const/4 v1, 0
    return v1
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 3
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeBgColor I
    if-eqz v0, +005h
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->drawInlineCodeBackgrounds(Landroid/graphics/Canvas;)V
    invoke-super v1, v2, Landroidx/appcompat/widget/AppCompatTextView;->onDraw(Landroid/graphics/Canvas;)V
    return-void 
.end method

.method public final setHeadingStyle(com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig)void
    .registers 3
    # ins_size=2
    const-string v0, "config"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->headerStyleConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->headerStyleConfig Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getText()Ljava/lang/CharSequence;
    move-result-object v2
    if-eqz v2, +017h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->getText()Ljava/lang/CharSequence;
    move-result-object v2
    instance-of v0, v2, Landroid/text/Spanned;
    if-eqz v0, +005h
    check-cast v2, Landroid/text/Spanned;
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    return-void 
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bindHeadingStyles(Landroid/text/Spanned;)V
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->requestLayout()V
    return-void 
.end method

.method public final setInlineCodeStyle(int  float  float  float)void
    .registers 5
    # ins_size=5
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeBgColor I
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeCornerRadius F
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeHPadding F
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->inlineCodeVPadding F
    return-void 
.end method

.method public setMarkdown(com.larus.business.markdown.api.model.MarkdownContent)void
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/larus/business/markdown/impl/markwon/MarkwonContent;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v6, Lcom/larus/business/markdown/impl/markwon/MarkwonContent;
    goto +2h
    move-object v6, v1
    iput-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->_content Lcom/larus/business/markdown/impl/markwon/MarkwonContent;
    if-eqz v6, +03fh
    invoke-virtual v6, Lcom/larus/business/markdown/impl/markwon/MarkwonContent;->getMarkdown()Landroid/text/SpannableStringBuilder;
    move-result-object v0
    if-nez v0, +003h
    goto +37h
    check-cast v0, Landroid/text/Spanned;
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->bindHeadingStyles(Landroid/text/Spanned;)V
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->pendingStripResult Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    if-eqz v2, +01dh
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->traeRefRenderer Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;
    move-object v4, v5
    check-cast v4, Landroid/widget/TextView;
    invoke-virtual v3, v4, v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->applyOnSpanned(Landroid/widget/TextView; Landroid/text/Spanned; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;)Landroid/text/Spanned;
    move-result-object v0
    iput-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->pendingStripResult Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    invoke-virtual v6, Lcom/larus/business/markdown/impl/markwon/MarkwonContent;->getMarkwonStruct()Lcom/larus/business/markdown/api/model/IMarkwonStruct;
    move-result-object v6
    if-eqz v6, +01eh
    invoke-interface v6, Lcom/larus/business/markdown/api/model/IMarkwonStruct;->getMarkwon()Lio/noties/markwon/Markwon;
    move-result-object v6
    if-eqz v6, +018h
    invoke-virtual v6, v4, v0, v1, Lio/noties/markwon/Markwon;->setParsedMarkdown(Landroid/widget/TextView; Landroid/text/Spanned; Lio/noties/markwon/SetMarkdownCallback;)V
    goto +13h
    invoke-virtual v6, Lcom/larus/business/markdown/impl/markwon/MarkwonContent;->getMarkwonStruct()Lcom/larus/business/markdown/api/model/IMarkwonStruct;
    move-result-object v6
    if-eqz v6, +00eh
    invoke-interface v6, Lcom/larus/business/markdown/api/model/IMarkwonStruct;->getMarkwon()Lio/noties/markwon/Markwon;
    move-result-object v6
    if-eqz v6, +008h
    move-object v2, v5
    check-cast v2, Landroid/widget/TextView;
    invoke-virtual v6, v2, v0, v1, Lio/noties/markwon/Markwon;->setParsedMarkdown(Landroid/widget/TextView; Landroid/text/Spanned; Lio/noties/markwon/SetMarkdownCallback;)V
    return-void 
.end method

.method public setMarkdownWidth(int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->markdownWidth I
    return-void 
.end method

.method public final setRefStripResult(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$StripResult)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->pendingStripResult Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    return-void 
.end method

.method public final setWebReferenceDescription(java.util.List)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->webReferences Ljava/util/List;
    return-void 
.end method
