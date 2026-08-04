# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/widget/blur/BlurView;
.super Landroid/view/View;
.source "BlurView.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
.field private final blurCircleDrawable:Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
.field private blurCircleHighlight:Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
.field private blurRadius:F
.field private circleRectHeight:I
.field private coverColor:I
.field private final highlightRadius:F
.field private initialCircleScale:F
.field private final isHarmony:Z
.field private radiusWidthRatio:F
.field private shadowColors:[I
.field private showHighlight:Z
.field private final useRenderEffect:Z


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->Companion Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/blur/BlurView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/blur/BlurView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 25
    # ins_size=4
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    const-string v2, "context"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v21 ... v24, Landroid/view/View;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView;
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_brand_300 I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    const/4 v3, 3
    new-array v3, v3, [I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_brand I
    invoke-static v1, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    const/4 v5, 0
    aput v4, v3, v5
    sget-object v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->Companion Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
    const v6, 1058642330
    invoke-static v4, v2, v6, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;->access$colorWithAlpha(Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion; I F)I
    move-result v6
    const/4 v7, 1
    aput v6, v3, v7
    const/4 v6, 0
    invoke-static v4, v2, v6, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;->access$colorWithAlpha(Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion; I F)I
    move-result v2
    const/4 v4, 2
    aput v2, v3, v4
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->shadowColors [I
    const v2, 654311423
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->coverColor I
    const v2, 1061997773
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->radiusWidthRatio F
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    const/high16 v3, 1111490560
    mul-float/2addr v2, v3
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurRadius F
    const/high16 v2, 1065353216
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->initialCircleScale F
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v3, 31
    if-lt v2, v3, +004h
    move v2, v7
    goto +2h
    move v2, v5
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->useRenderEffect Z
    const/16 v2, 280
    int-to-float v2, v2
    invoke-virtual/range v21, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v3
    float-to-int v2, v2
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->circleRectHeight I
    iget v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurRadius F
    iput v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->highlightRadius F
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->shadowColors [I
    new-instance v3, Ljava/util/ArrayList;
    array-length v8, v2
    invoke-direct v3, v8, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    array-length v8, v2
    move v9, v5
    if-ge v9, v8, +01ch
    aget v10, v2, v9
    sget-object v11, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->Companion Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
    new-array v12, v4, [I
    aput v10, v12, v5
    iget v10, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->coverColor I
    aput v10, v12, v7
    invoke-static v11, v12, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;->access$calcMixedColor(Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion; [I)I
    move-result v10
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-interface v3, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v9, v9, 1
    goto -1bh
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/util/Collection;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toIntArray(Ljava/util/Collection;)[I
    move-result-object v9
    new-instance v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    iget v10, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurRadius F
    iget v11, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->radiusWidthRatio F
    iget v12, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->circleRectHeight I
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->useRenderEffect Z
    xor-int/lit8 v17, v3, 1
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->isHarmony Z
    const/16 v19, 240
    const/16 v20, 0
    move-object v8, v2
    move/from16 v18, v3
    invoke-direct/range v8 ... v20, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;-><init>([I F F I Landroid/graphics/Xfermode; F F F Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    iget v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->initialCircleScale F
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setCircleScale(F)V
    move-object v3, v0
    check-cast v3, Landroid/graphics/drawable/Drawable$Callback;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V
    iget v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->highlightRadius F
    cmpl-float v3, v2, v6
    if-lez v3, +039h
    int-to-float v3, v4
    mul-float/2addr v2, v3
    float-to-int v2, v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_brand I
    invoke-static v1, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    new-instance v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    new-array v9, v7, [I
    aput v1, v9, v5
    iget v10, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->highlightRadius F
    const/high16 v11, 1056964608
    new-instance v1, Landroid/graphics/PorterDuffXfermode;
    sget-object v4, Landroid/graphics/PorterDuff$Mode;->SRC_IN Landroid/graphics/PorterDuff$Mode;
    invoke-direct v1, v4, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V
    move-object v13, v1
    check-cast v13, Landroid/graphics/Xfermode;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->useRenderEffect Z
    xor-int/lit8 v17, v1, 1
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->isHarmony Z
    const/16 v19, 224
    const/16 v20, 0
    move-object v8, v3
    move v12, v2
    move/from16 v18, v1
    invoke-direct/range v8 ... v20, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;-><init>([I F F I Landroid/graphics/Xfermode; F F F Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v3, v5, v5, v2, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setBounds(I I I I)V
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->useRenderEffect Z
    if-eqz v1, +006h
    invoke-direct/range v21, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->applyRenderEffectBlur()V
    goto +5h
    const/4 v1, 0
    invoke-virtual v0, v7, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->setLayerType(I Landroid/graphics/Paint;)V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final applyRenderEffectBlur()void
    .registers 3
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    if-lt v0, v1, +00dh
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurRadius F
    sget-object v1, Landroid/graphics/Shader$TileMode;->DECAL Landroid/graphics/Shader$TileMode;
    invoke-static v0, v0, v1, Landroid/graphics/RenderEffect;->createBlurEffect(F F Landroid/graphics/Shader$TileMode;)Landroid/graphics/RenderEffect;
    move-result-object v0
    invoke-virtual v2, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->setRenderEffect(Landroid/graphics/RenderEffect;)V
    return-void 
.end method

.method public final dismissHighlight()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-nez v0, +003h
    return-void 
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->showHighlight Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->invalidate()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->invalidateSelf()V
    return-void 
.end method

.method public final getCircleRectHeight()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->circleRectHeight I
    return v0
.end method

.method public final getCircleScale()float
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->getCircleScale()F
    move-result v0
    return v0
.end method

.method protected onDraw(android.graphics.Canvas)void
    .registers 9
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v7, v8, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->showHighlight Z
    if-eqz v0, +029h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-nez v0, +003h
    goto +23h
    const/4 v2, 0
    const/4 v3, 0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->getWidth()I
    move-result v0
    int-to-float v4, v0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->getHeight()I
    move-result v0
    int-to-float v5, v0
    const/4 v6, 0
    move-object v1, v8
    invoke-virtual/range v1 ... v6, Landroid/graphics/Canvas;->saveLayer(F F F F Landroid/graphics/Paint;)I
    move-result v0
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v1, v8, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->draw(Landroid/graphics/Canvas;)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-eqz v1, +005h
    invoke-virtual v1, v8, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->draw(Landroid/graphics/Canvas;)V
    invoke-virtual v8, v0, Landroid/graphics/Canvas;->restoreToCount(I)V
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->draw(Landroid/graphics/Canvas;)V
    return-void 
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 5
    # ins_size=5
    invoke-super v0, v1, v2, v3, v4, Landroid/view/View;->onSizeChanged(I I I I)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    const/4 v4, 0
    invoke-virtual v3, v4, v4, v1, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setBounds(I I I I)V
    return-void 
.end method

.method public final varargs setCircleColor(int[])void
    .registers 10
    # ins_size=2
    const-string v0, "colors"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    array-length v1, v9
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    array-length v1, v9
    const/4 v2, 0
    move v3, v2
    const/4 v4, 1
    if-ge v3, v1, +01dh
    aget v5, v9, v3
    sget-object v6, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->Companion Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
    const/4 v7, 2
    new-array v7, v7, [I
    aput v5, v7, v2
    iget v5, v8, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->coverColor I
    aput v5, v7, v4
    invoke-static v6, v7, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;->access$calcMixedColor(Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion; [I)I
    move-result v4
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v3, v3, 1
    goto -1dh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toIntArray(Ljava/util/Collection;)[I
    move-result-object v9
    array-length v0, v9
    if-nez v0, +003h
    move v2, v4
    xor-int/lit8 v0, v2, 1
    if-eqz v0, +007h
    iget-object v0, v8, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v0, v9, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setCircleColor([I)V
    return-void 
.end method

.method public final varargs setCircleColorWithoutCover(int[])void
    .registers 4
    # ins_size=2
    const-string v0, "colors"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v3
    const/4 v1, 1
    if-nez v0, +004h
    move v0, v1
    goto +2h
    const/4 v0, 0
    xor-int/2addr v0, v1
    if-eqz v0, +007h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setCircleColor([I)V
    return-void 
.end method

.method public final setCircleScale(float)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setCircleScale(F)V
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->useRenderEffect Z
    if-eqz v0, +019h
    iget v0, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurRadius F
    mul-float/2addr v0, v3
    sget v3, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 31
    if-lt v3, v1, +010h
    const/4 v3, 0
    cmpl-float v3, v0, v3
    if-lez v3, +00bh
    sget-object v3, Landroid/graphics/Shader$TileMode;->DECAL Landroid/graphics/Shader$TileMode;
    invoke-static v0, v0, v3, Landroid/graphics/RenderEffect;->createBlurEffect(F F Landroid/graphics/Shader$TileMode;)Landroid/graphics/RenderEffect;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->setRenderEffect(Landroid/graphics/RenderEffect;)V
    return-void 
.end method

.method public final showHighlight(float  float)void
    .registers 7
    # ins_size=3
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-nez v0, +003h
    return-void 
    const/4 v1, 1
    iput-boolean v1, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->showHighlight Z
    if-eqz v0, +011h
    iget v1, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->highlightRadius F
    sub-float v2, v5, v1
    float-to-int v2, v2
    sub-float v3, v6, v1
    float-to-int v3, v3
    add-float/2addr v5, v1
    float-to-int v5, v5
    add-float/2addr v6, v1
    float-to-int v6, v6
    invoke-virtual v0, v2, v3, v5, v6, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->setBounds(I I I I)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-eqz v5, +005h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;->invalidateSelf()V
    return-void 
.end method

.method protected verifyDrawable(android.graphics.drawable.Drawable)boolean
    .registers 3
    # ins_size=2
    const-string/jumbo v0, who
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, Landroid/view/View;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    move-result v0
    if-nez v0, +00dh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleDrawable Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-eq v2, v0, +009h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView;->blurCircleHighlight Lcom/bytedance/trae/conversation/widget/blur/BlurCircleDrawable;
    if-ne v2, v0, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method
