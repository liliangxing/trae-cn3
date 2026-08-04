# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/PluginTagSpan;
.super Landroid/text/style/ReplacementSpan;
.source "PluginTagSpan.kt"

.implements Lcom/bytedance/trae/conversation/widget/InputTagSpan;

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/PluginTagSpan$Companion;
.field private static final SVG_DRAWABLE_FACTORY:Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;
.field private activeDataSource:Lcom/facebook/datasource/DataSource;
.field private final appContext:Landroid/content/Context;
.field private final bgPaint:Landroid/graphics/Paint;
.field private final cornerRadius:F
.field private final iconMarginEnd:F
.field private final iconRes:I
.field private final iconSize:F
.field private final iconUrl:Ljava/lang/String;
.field private loadedDrawable:Landroid/graphics/drawable/Drawable;
.field private final parentView:Ljava/lang/ref/WeakReference;
.field private final pluginItem:Lcom/bytedance/trae/conversation/widget/PluginTagItem;
.field private final pluginName:Ljava/lang/String;
.field private spanWidth:I
.field private final tagBgColor:I
.field private final tagPaddingH:F
.field private final tagPaddingV:F
.field private final tagTextColor:I
.field private final tagTextSize:F
.field private final textPaint:Landroid/graphics/Paint;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->Companion Lcom/bytedance/trae/conversation/widget/PluginTagSpan$Companion;
    new-instance v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;
    invoke-direct v0, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->SVG_DRAWABLE_FACTORY Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.lang.String  int  com.bytedance.trae.conversation.widget.PluginTagItem  java.lang.String  java.lang.ref.WeakReference  float  float  float  float  float  int  int  float)void
    .registers 16
    # ins_size=15
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pluginName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "pluginItem"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Landroid/text/style/ReplacementSpan;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->pluginName Ljava/lang/String;
    iput v4, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconRes I
    iput-object v5, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->pluginItem Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconUrl Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->parentView Ljava/lang/ref/WeakReference;
    iput v8, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagTextSize F
    iput v9, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingH F
    iput v10, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingV F
    iput v11, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconSize F
    iput v12, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconMarginEnd F
    iput v13, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagBgColor I
    iput v14, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagTextColor I
    iput v15, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->cornerRadius F
    invoke-virtual v2, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "getApplicationContext(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->appContext Landroid/content/Context;
    new-instance v2, Landroid/graphics/Paint;
    const/4 v3, 1
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v2, v8, Landroid/graphics/Paint;->setTextSize(F)V
    invoke-virtual v2, v14, Landroid/graphics/Paint;->setColor(I)V
    sget-object v4, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->textPaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, v3, Landroid/graphics/Paint;-><init>(I)V
    invoke-virtual v2, v13, Landroid/graphics/Paint;->setColor(I)V
    sget-object v4, Landroid/graphics/Paint$Style;->FILL Landroid/graphics/Paint$Style;
    invoke-virtual v2, v4, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->bgPaint Landroid/graphics/Paint;
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00ah
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +005h
    invoke-direct v1, v6, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->fetchIconFromUrl(Ljava/lang/String;)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.String  int  com.bytedance.trae.conversation.widget.PluginTagItem  java.lang.String  java.lang.ref.WeakReference  float  float  float  float  float  int  int  float  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 32
    # ins_size=17
    move-object/from16 v1, v16
    move/from16 v0, v30
    and-int/lit8 v2, v0, 16
    const/4 v3, 0
    if-eqz v2, +004h
    move-object v5, v3
    goto +3h
    move-object/from16 v5, v20
    and-int/lit8 v2, v0, 32
    if-eqz v2, +004h
    move-object v6, v3
    goto +3h
    move-object/from16 v6, v21
    and-int/lit8 v2, v0, 64
    if-eqz v2, +00ah
    const/high16 v2, 1096810496
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v7, v2
    goto +3h
    move/from16 v7, v22
    and-int/lit16 v2, v0, 128
    if-eqz v2, +00ah
    const/high16 v2, 1092616192
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v8, v2
    goto +3h
    move/from16 v8, v23
    and-int/lit16 v2, v0, 256
    const/high16 v3, 1082130432
    if-eqz v2, +008h
    invoke-static v3, v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v9, v2
    goto +3h
    move/from16 v9, v24
    and-int/lit16 v2, v0, 512
    if-eqz v2, +00ah
    const/high16 v2, 1098907648
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v10, v2
    goto +3h
    move/from16 v10, v25
    and-int/lit16 v2, v0, 1024
    if-eqz v2, +008h
    invoke-static v3, v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v2
    move v11, v2
    goto +3h
    move/from16 v11, v26
    and-int/lit16 v2, v0, 2048
    if-eqz v2, +00ah
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_accent_accent_skill I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    move v12, v2
    goto +3h
    move/from16 v12, v27
    and-int/lit16 v2, v0, 4096
    if-eqz v2, +00ah
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    move v13, v2
    goto +3h
    move/from16 v13, v28
    and-int/lit16 v0, v0, 8192
    if-eqz v0, +00ah
    const/high16 v0, 1086324736
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/SkillTagSpanKt;->dp(F Landroid/content/Context;)F
    move-result v0
    move v14, v0
    goto +3h
    move/from16 v14, v29
    move-object v0, v15
    move-object/from16 v1, v16
    move-object/from16 v2, v17
    move/from16 v3, v18
    move-object/from16 v4, v19
    invoke-direct/range v0 ... v14, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;-><init>(Landroid/content/Context; Ljava/lang/String; I Lcom/bytedance/trae/conversation/widget/PluginTagItem; Ljava/lang/String; Ljava/lang/ref/WeakReference; F F F F F I I F)V
    return-void 
.end method

.method public static final synthetic access$notifySpanChanged(com.bytedance.trae.conversation.widget.PluginTagSpan)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->notifySpanChanged()V
    return-void 
.end method

.method public static final synthetic access$setActiveDataSource$p(com.bytedance.trae.conversation.widget.PluginTagSpan  com.facebook.datasource.DataSource)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->activeDataSource Lcom/facebook/datasource/DataSource;
    return-void 
.end method

.method public static final synthetic access$setLoadedDrawable$p(com.bytedance.trae.conversation.widget.PluginTagSpan  android.graphics.drawable.Drawable)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->loadedDrawable Landroid/graphics/drawable/Drawable;
    return-void 
.end method

.method public static final synthetic access$toDrawable(com.bytedance.trae.conversation.widget.PluginTagSpan  com.facebook.imagepipeline.image.CloseableImage)android.graphics.drawable.Drawable
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->toDrawable(Lcom/facebook/imagepipeline/image/CloseableImage;)Landroid/graphics/drawable/Drawable;
    move-result-object v0
    return-object v0
.end method

.method private final fetchIconFromUrl(java.lang.String)void
    .registers 4
    # ins_size=2
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    invoke-static v3, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->newBuilderWithSource(Landroid/net/Uri;)Lcom/facebook/imagepipeline/request/ImageRequestBuilder;
    move-result-object v3
    invoke-virtual v3, Lcom/facebook/imagepipeline/request/ImageRequestBuilder;->build()Lcom/facebook/imagepipeline/request/ImageRequest;
    move-result-object v3
    invoke-static Lcom/facebook/drawee/backends/pipeline/Fresco;->getImagePipeline()Lcom/facebook/imagepipeline/core/ImagePipeline;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->appContext Landroid/content/Context;
    invoke-virtual v0, v3, v1, Lcom/facebook/imagepipeline/core/ImagePipeline;->fetchDecodedImage(Lcom/facebook/imagepipeline/request/ImageRequest; Ljava/lang/Object;)Lcom/facebook/datasource/DataSource;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->activeDataSource Lcom/facebook/datasource/DataSource;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan$fetchIconFromUrl$1;-><init>(Lcom/bytedance/trae/conversation/widget/PluginTagSpan;)V
    check-cast v0, Lcom/facebook/datasource/DataSubscriber;
    invoke-static Lcom/facebook/common/executors/UiThreadImmediateExecutorService;->getInstance()Lcom/facebook/common/executors/UiThreadImmediateExecutorService;
    move-result-object v1
    check-cast v1, Ljava/util/concurrent/Executor;
    invoke-interface v3, v0, v1, Lcom/facebook/datasource/DataSource;->subscribe(Lcom/facebook/datasource/DataSubscriber; Ljava/util/concurrent/Executor;)V
    return-void 
.end method

.method private final notifySpanChanged()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->parentView Ljava/lang/ref/WeakReference;
    const/4 v1, 0
    if-eqz v0, +009h
    invoke-virtual v0, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    goto +2h
    move-object v0, v1
    instance-of v2, v0, Landroid/widget/EditText;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Landroid/widget/EditText;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Landroid/widget/EditText;->getEditableText()Landroid/text/Editable;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-interface v0, v4, Landroid/text/Editable;->getSpanStart(Ljava/lang/Object;)I
    move-result v1
    invoke-interface v0, v4, Landroid/text/Editable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v2
    if-ltz v1, +00bh
    if-le v2, v1, +009h
    invoke-interface v0, v4, Landroid/text/Editable;->getSpanFlags(Ljava/lang/Object;)I
    move-result v3
    invoke-interface v0, v4, v1, v2, v3, Landroid/text/Editable;->setSpan(Ljava/lang/Object; I I I)V
    return-void 
.end method

.method private final toDrawable(com.facebook.imagepipeline.image.CloseableImage)android.graphics.drawable.Drawable
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/facebook/imagepipeline/image/CloseableBitmap;
    const/4 v1, 0
    if-eqz v0, +006h
    move-object v0, v5
    check-cast v0, Lcom/facebook/imagepipeline/image/CloseableBitmap;
    goto +2h
    move-object v0, v1
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/facebook/imagepipeline/image/CloseableBitmap;->getUnderlyingBitmap()Landroid/graphics/Bitmap;
    move-result-object v1
    if-eqz v1, +01dh
    invoke-virtual v1, Landroid/graphics/Bitmap;->isRecycled()Z
    move-result v0
    if-nez v0, +017h
    new-instance v5, Landroid/graphics/drawable/BitmapDrawable;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->appContext Landroid/content/Context;
    invoke-virtual v0, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888 Landroid/graphics/Bitmap$Config;
    const/4 v3, 0
    invoke-virtual v1, v2, v3, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config; Z)Landroid/graphics/Bitmap;
    move-result-object v1
    invoke-direct v5, v0, v1, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources; Landroid/graphics/Bitmap;)V
    check-cast v5, Landroid/graphics/drawable/Drawable;
    return-object v5
    sget-object v0, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->SVG_DRAWABLE_FACTORY Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;
    invoke-virtual v0, v5, Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;->createDrawable(Lcom/facebook/imagepipeline/image/CloseableImage;)Landroid/graphics/drawable/Drawable;
    move-result-object v5
    return-object v5
.end method

.method public draw(android.graphics.Canvas  java.lang.CharSequence  int  int  float  int  int  int  android.graphics.Paint)void
    .registers 12
    # ins_size=10
    const-string v4, "canvas"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "paint"
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v4, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v4
    add-int/2addr v8, v10
    int-to-float v5, v8
    const/high16 v6, 1073741824
    div-float/2addr v5, v6
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconSize F
    iget v9, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingV F
    const/4 v10, 2
    int-to-float v10, v10
    mul-float/2addr v9, v10
    add-float/2addr v8, v9
    div-float/2addr v8, v10
    sub-float v9, v5, v8
    add-float/2addr v8, v5
    new-instance v11, Landroid/graphics/RectF;
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->spanWidth I
    int-to-float v0, v0
    add-float/2addr v0, v7
    invoke-direct v11, v7, v9, v0, v8, Landroid/graphics/RectF;-><init>(F F F F)V
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->cornerRadius F
    iget-object v9, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->bgPaint Landroid/graphics/Paint;
    invoke-virtual v3, v11, v8, v8, v9, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF; F F Landroid/graphics/Paint;)V
    iget-object v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->loadedDrawable Landroid/graphics/drawable/Drawable;
    if-nez v8, +00ah
    iget-object v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->appContext Landroid/content/Context;
    iget v9, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconRes I
    invoke-static v8, v9, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v8
    if-eqz v8, +019h
    iget v9, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingH F
    add-float/2addr v9, v7
    float-to-int v9, v9
    iget v11, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconSize F
    div-float v10, v11, v10
    sub-float v10, v5, v10
    float-to-int v10, v10
    int-to-float v0, v9
    add-float/2addr v0, v11
    float-to-int v0, v0
    int-to-float v1, v10
    add-float/2addr v1, v11
    float-to-int v11, v1
    invoke-virtual v8, v9, v10, v0, v11, Landroid/graphics/drawable/Drawable;->setBounds(I I I I)V
    invoke-virtual v8, v3, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingH F
    add-float/2addr v7, v8
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconSize F
    add-float/2addr v7, v8
    iget v8, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconMarginEnd F
    add-float/2addr v7, v8
    iget v8, v4, Landroid/graphics/Paint$FontMetricsInt;->top I
    iget v4, v4, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    add-int/2addr v8, v4
    int-to-float v4, v8
    div-float/2addr v4, v6
    sub-float/2addr v5, v4
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->pluginName Ljava/lang/String;
    iget-object v6, v2, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v3, v4, v7, v5, v6, Landroid/graphics/Canvas;->drawText(Ljava/lang/String; F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method public final getPluginItem()com.bytedance.trae.conversation.widget.PluginTagItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->pluginItem Lcom/bytedance/trae/conversation/widget/PluginTagItem;
    return-object v0
.end method

.method public getSize(android.graphics.Paint  java.lang.CharSequence  int  int  android.graphics.Paint$FontMetricsInt)int
    .registers 7
    # ins_size=6
    const-string v3, "paint"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->textPaint Landroid/graphics/Paint;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->pluginName Ljava/lang/String;
    invoke-virtual v2, v3, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v2
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingH F
    iget v4, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconSize F
    add-float/2addr v4, v3
    iget v5, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconMarginEnd F
    add-float/2addr v4, v5
    add-float/2addr v4, v2
    add-float/2addr v4, v3
    float-to-int v2, v4
    iput v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->spanWidth I
    if-eqz v6, +027h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->textPaint Landroid/graphics/Paint;
    invoke-virtual v2, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v2
    iget v3, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->iconSize F
    iget v4, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->tagPaddingV F
    const/4 v5, 2
    int-to-float v0, v5
    mul-float/2addr v4, v0
    add-float/2addr v3, v4
    float-to-int v3, v3
    iget v4, v2, Landroid/graphics/Paint$FontMetricsInt;->top I
    iget v2, v2, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    add-int/2addr v4, v2
    div-int/2addr v4, v5
    div-int/2addr v3, v5
    sub-int v2, v4, v3
    iput v2, v6, Landroid/graphics/Paint$FontMetricsInt;->top I
    add-int/2addr v4, v3
    iput v4, v6, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    iget v2, v6, Landroid/graphics/Paint$FontMetricsInt;->top I
    iput v2, v6, Landroid/graphics/Paint$FontMetricsInt;->ascent I
    iget v2, v6, Landroid/graphics/Paint$FontMetricsInt;->bottom I
    iput v2, v6, Landroid/graphics/Paint$FontMetricsInt;->descent I
    iget v2, v1, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->spanWidth I
    return v2
.end method

.method public final release()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->activeDataSource Lcom/facebook/datasource/DataSource;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/facebook/datasource/DataSource;->close()Z
    const/4 v0, 0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->activeDataSource Lcom/facebook/datasource/DataSource;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->loadedDrawable Landroid/graphics/drawable/Drawable;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/widget/PluginTagSpan;->loadedDrawable Landroid/graphics/drawable/Drawable;
    instance-of v2, v1, Landroid/graphics/drawable/BitmapDrawable;
    if-eqz v2, +018h
    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual v1, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;
    move-result-object v1
    if-eqz v1, +010h
    invoke-virtual v1, Landroid/graphics/Bitmap;->isRecycled()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    move-object v0, v1
    if-eqz v0, +005h
    invoke-virtual v0, Landroid/graphics/Bitmap;->recycle()V
    return-void 
.end method
