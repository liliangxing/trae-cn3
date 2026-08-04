# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;
.super Ljava/lang/Object;
.source "BlurView.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;-><init>()V
    return-void 
.end method

.method public static final varargs synthetic access$calcMixedColor(com.bytedance.trae.conversation.widget.blur.BlurView$Companion  int[])int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;->calcMixedColor([I)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$colorWithAlpha(com.bytedance.trae.conversation.widget.blur.BlurView$Companion  int  float)int
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/blur/BlurView$Companion;->colorWithAlpha(I F)I
    move-result v0
    return v0
.end method

.method private final varargs calcMixedColor(int[])int
    .registers 9
    # ins_size=2
    array-length v0, v8
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +003h
    goto +34h
    array-length v0, v8
    if-ne v0, v1, +005h
    aget v2, v8, v2
    goto +2eh
    array-length v0, v8
    move v1, v2
    if-ge v2, v0, +02ah
    aget v3, v8, v2
    if-nez v3, +003h
    goto +21h
    if-nez v1, +004h
    move v1, v3
    goto +1dh
    invoke-static v3, Landroid/graphics/Color;->red(I)I
    move-result v4
    invoke-static v3, Landroid/graphics/Color;->green(I)I
    move-result v5
    invoke-static v3, Landroid/graphics/Color;->blue(I)I
    move-result v6
    invoke-static v4, v5, v6, Landroid/graphics/Color;->rgb(I I I)I
    move-result v4
    invoke-static v3, Landroid/graphics/Color;->alpha(I)I
    move-result v3
    int-to-float v3, v3
    const/high16 v5, 1132396544
    div-float/2addr v3, v5
    invoke-static v1, v4, v3, Landroidx/core/graphics/ColorUtils;->blendARGB(I I F)I
    move-result v1
    add-int/lit8 v2, v2, 1
    goto -29h
    move v2, v1
    return v2
.end method

.method private final colorWithAlpha(int  float)int
    .registers 5
    # ins_size=3
    const/4 v0, 0
    const/high16 v1, 1065353216
    invoke-static v4, v0, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v4
    const/16 v0, 255
    int-to-float v0, v0
    mul-float/2addr v4, v0
    invoke-static v4, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v4
    invoke-static v3, v4, Landroidx/core/graphics/ColorUtils;->setAlphaComponent(I I)I
    move-result v3
    return v3
.end method
