# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;
.super Ljava/lang/Object;
.source "TraeActivityIndicator.kt"

.field private static final ActivityIndicatorRotationDurationMillis:I
.field private static final ActivityIndicatorSpokeAlphas:[F
.field private static final ActivityIndicatorSpokeCount:I


.method public static synthetic $r8$lambda$F4AEyUovVmxOQG1wvxLxkN4X55w(long  androidx.compose.ui.graphics.drawscope.DrawScope)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->TraeActivityIndicator_iJQMabo$lambda$3$lambda$2(J Landroidx/compose/ui/graphics/drawscope/DrawScope;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xWswRpXUUlf9pV2pZ0LbhG1wR84(androidx.compose.ui.Modifier  long  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->TraeActivityIndicator_iJQMabo$lambda$4(Landroidx/compose/ui/Modifier; J I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    const/16 v0, 8
    new-array v0, v0, [F
    fill-array-data v0, +0000006h
    sput-object v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->ActivityIndicatorSpokeAlphas [F
    return-void 
    fill-array-data-payload b'\x00\x00\x80?\xcd\xccL?333?\x9a\x99\x19?\x00\x00\x00?\xcd\xcc\xcc>\x9a\x99\x99>\xcd\xccL>' | \x00\x00\x80\x3f\xcd\xcc\x4c\x3f\x33\x33\x33\x3f\x9a\x99\x19\x3f\x00\x00\x00\x3f\xcd\xcc\xcc\x3e\x9a\x99\x99\x3e\xcd\xcc\x4c\x3e
.end method

.method public static final TraeActivityIndicator-iJQMabo(androidx.compose.ui.Modifier  long  androidx.compose.runtime.Composer  int  int)void
    .registers 28
    # ins_size=6
    const v0, -399389136
    move-object/from16 v1, v25
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v9
    and-int/lit8 v1, v27, 1
    const/4 v2, 2
    if-eqz v1, +008h
    or-int/lit8 v3, v26, 6
    move v4, v3
    move-object/from16 v3, v22
    goto +17h
    and-int/lit8 v3, v26, 6
    if-nez v3, +010h
    move-object/from16 v3, v22
    invoke-interface v9, v3, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    const/4 v4, 4
    goto +2h
    move v4, v2
    or-int v4, v26, v4
    goto +5h
    move-object/from16 v3, v22
    move/from16 v4, v26
    and-int/lit8 v5, v26, 48
    const/16 v10, 32
    if-nez v5, +016h
    and-int/lit8 v5, v27, 2
    if-nez v5, +00ch
    move-wide/from16 v5, v23
    invoke-interface v9, v5, v6, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v7
    if-eqz v7, +006h
    move v7, v10
    goto +5h
    move-wide/from16 v5, v23
    const/16 v7, 16
    or-int/2addr v4, v7
    goto +3h
    move-wide/from16 v5, v23
    and-int/lit8 v7, v4, 19
    const/16 v8, 18
    if-ne v7, v8, +010h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v7
    if-nez v7, +003h
    goto +8h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v1, v3
    move-wide v2, v5
    goto/16 +0cch
    invoke-interface v9, Landroidx/compose/runtime/Composer;->startDefaults()V
    and-int/lit8 v7, v26, 1
    if-eqz v7, +014h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getDefaultsInvalid()Z
    move-result v7
    if-eqz v7, +003h
    goto +ch
    invoke-interface v9, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    and-int/lit8 v1, v27, 2
    if-eqz v1, +004h
    and-int/lit8 v4, v4, -113
    move-object v11, v3
    goto +1bh
    if-eqz v1, +007h
    sget-object v1, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v1, Landroidx/compose/ui/Modifier;
    goto +2h
    move-object v1, v3
    and-int/lit8 v3, v27, 2
    if-eqz v3, +00fh
    sget-object v3, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    const/4 v5, 6
    invoke-virtual v3, v9, v5, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/design/compose/TraeColors;->getIconIconDefault-0d7_KjU()J
    move-result-wide v5
    and-int/lit8 v4, v4, -113
    move-object v11, v1
    move v14, v4
    move-wide v12, v5
    invoke-interface v9, Landroidx/compose/runtime/Composer;->endDefaults()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +008h
    const/4 v1, -1
    const-string v3, "com.bytedance.trae.design.compose.TraeActivityIndicator (TraeActivityIndicator.kt:28)"
    invoke-static v0, v14, v1, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const/4 v0, 0
    const/4 v15, 0
    const/4 v8, 1
    invoke-static v0, v9, v15, v8, Landroidx/compose/animation/core/InfiniteTransitionKt;->rememberInfiniteTransition(Ljava/lang/String; Landroidx/compose/runtime/Composer; I I)Landroidx/compose/animation/core/InfiniteTransition;
    move-result-object v1
    const/4 v3, 0
    const/high16 v4, 1135869952
    const/16 v5, 800
    invoke-static Landroidx/compose/animation/core/EasingKt;->getLinearEasing()Landroidx/compose/animation/core/Easing;
    move-result-object v6
    invoke-static v5, v15, v6, v2, v0, Landroidx/compose/animation/core/AnimationSpecKt;->tween$default(I I Landroidx/compose/animation/core/Easing; I Ljava/lang/Object;)Landroidx/compose/animation/core/TweenSpec;
    move-result-object v0
    move-object/from16 v16, v0
    check-cast v16, Landroidx/compose/animation/core/DurationBasedAnimationSpec;
    const/16 v17, 0
    const-wide/16 v18, 0
    const/16 v20, 6
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/animation/core/AnimationSpecKt;->infiniteRepeatable-9IiC70o$default(Landroidx/compose/animation/core/DurationBasedAnimationSpec; Landroidx/compose/animation/core/RepeatMode; J I Ljava/lang/Object;)Landroidx/compose/animation/core/InfiniteRepeatableSpec;
    move-result-object v0
    const/4 v5, 0
    sget v2, Landroidx/compose/animation/core/InfiniteTransition;->$stable I
    or-int/lit16 v2, v2, 432
    sget v6, Landroidx/compose/animation/core/InfiniteRepeatableSpec;->$stable I
    shl-int/lit8 v6, v6, 9
    or-int v7, v2, v6
    const/16 v16, 8
    move v2, v3
    move v3, v4
    move-object v4, v0
    move-object v6, v9
    move v0, v8
    move/from16 v8, v16
    invoke-static/range v1 ... v8, Landroidx/compose/animation/core/InfiniteTransitionKt;->animateFloat(Landroidx/compose/animation/core/InfiniteTransition; F F Landroidx/compose/animation/core/InfiniteRepeatableSpec; Ljava/lang/String; Landroidx/compose/runtime/Composer; I I)Landroidx/compose/runtime/State;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->TraeActivityIndicator_iJQMabo$lambda$0(Landroidx/compose/runtime/State;)F
    move-result v1
    invoke-static v11, v1, Landroidx/compose/ui/draw/RotateKt;->rotate(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v1
    const v2, 1056548667
    invoke-interface v9, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit8 v2, v14, 112
    xor-int/lit8 v2, v2, 48
    if-le v2, v10, +008h
    invoke-interface v9, v12, v13, Landroidx/compose/runtime/Composer;->changed(J)Z
    move-result v2
    if-nez v2, +006h
    and-int/lit8 v2, v14, 48
    if-ne v2, v10, +004h
    move v8, v0
    goto +2h
    move v8, v15
    invoke-interface v9, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v0
    if-nez v8, +00ah
    sget-object v2, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v2, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v2
    if-ne v0, v2, +00ah
    new-instance v0, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda0;
    invoke-direct v0, v12, v13, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda0;-><init>(J)V
    invoke-interface v9, v0, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v0, Lkotlin/jvm/functions/Function1;
    invoke-interface v9, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v1, v0, v9, v15, Landroidx/compose/foundation/CanvasKt;->Canvas(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/Composer; I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object v1, v11
    move-wide v2, v12
    invoke-interface v9, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v6
    if-eqz v6, +00fh
    new-instance v7, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;
    move-object v0, v7
    move/from16 v4, v26
    move/from16 v5, v27
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt$$ExternalSyntheticLambda1;-><init>(Landroidx/compose/ui/Modifier; J I I)V
    invoke-interface v6, v7, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TraeActivityIndicator_iJQMabo$lambda$0(androidx.compose.runtime.State)float
    .registers 1
    # ins_size=1
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->floatValue()F
    move-result v0
    return v0
.end method

.method private static final TraeActivityIndicator_iJQMabo$lambda$3$lambda$2(long  androidx.compose.ui.graphics.drawscope.DrawScope)kotlin.Unit
    .registers 27
    # ins_size=3
    const-string v0, "$this$Canvas"
    move-object/from16 v15, v26
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface/range v26, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getSize-NH-jbRc()J
    move-result-wide v0
    invoke-static v0, v1, Landroidx/compose/ui/geometry/Size;->getMinDimension-impl(J)F
    move-result v0
    const v1, 1033476506
    mul-float/2addr v0, v1
    invoke-interface/range v26, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getSize-NH-jbRc()J
    move-result-wide v1
    invoke-static v1, v2, Landroidx/compose/ui/geometry/Size;->getMinDimension-impl(J)F
    move-result v1
    const/high16 v2, 1048576000
    mul-float v14, v1, v2
    invoke-interface/range v26, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getSize-NH-jbRc()J
    move-result-wide v1
    invoke-static v1, v2, Landroidx/compose/ui/geometry/Size;->getMinDimension-impl(J)F
    move-result v1
    const/high16 v2, 1052770304
    mul-float v13, v1, v2
    const/4 v1, 0
    move v12, v1
    const/16 v1, 8
    if-ge v12, v1, +0beh
    int-to-double v2, v12
    const-wide/high16 v4, 4611686018427387904
    mul-double/2addr v2, v4
    const-wide v4, 4614256656552045848
    mul-double/2addr v2, v4
    int-to-double v4, v1
    div-double/2addr v2, v4
    const-wide v4, -4613618979930100456
    sub-double/2addr v4, v2
    invoke-static/range v24 ... v25, Landroidx/compose/ui/graphics/Color;->getAlpha-impl(J)F
    move-result v1
    sget-object v2, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->ActivityIndicatorSpokeAlphas [F
    aget v2, v2, v12
    mul-float v18, v1, v2
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 14
    const/16 v23, 0
    move-wide/from16 v16, v24
    invoke-static/range v16 ... v23, Landroidx/compose/ui/graphics/Color;->copy-wmQWz5c$default(J F F F F I Ljava/lang/Object;)J
    move-result-wide v2
    invoke-interface/range v26, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getCenter-F1C5BW0()J
    move-result-wide v6
    invoke-static v4, v5, Ljava/lang/Math;->cos(D)D
    move-result-wide v8
    float-to-double v10, v14
    mul-double/2addr v8, v10
    double-to-float v1, v8
    invoke-static v4, v5, Ljava/lang/Math;->sin(D)D
    move-result-wide v8
    mul-double/2addr v8, v10
    double-to-float v8, v8
    invoke-static v1, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v1
    int-to-long v9, v1
    invoke-static v8, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v1
    move/from16 v16, v12
    int-to-long v11, v1
    const/16 v1, 32
    shl-long v8, v9, v1
    const-wide v17, 4294967295
    and-long v10, v11, v17
    or-long/2addr v8, v10
    invoke-static v8, v9, Landroidx/compose/ui/geometry/Offset;->constructor-impl(J)J
    move-result-wide v8
    invoke-static v6, v7, v8, v9, Landroidx/compose/ui/geometry/Offset;->plus-MK-Hz9U(J J)J
    move-result-wide v6
    invoke-interface/range v26, Landroidx/compose/ui/graphics/drawscope/DrawScope;->getCenter-F1C5BW0()J
    move-result-wide v8
    invoke-static v4, v5, Ljava/lang/Math;->cos(D)D
    move-result-wide v10
    move-wide/from16 v19, v2
    float-to-double v1, v13
    mul-double/2addr v10, v1
    double-to-float v10, v10
    invoke-static v4, v5, Ljava/lang/Math;->sin(D)D
    move-result-wide v4
    mul-double/2addr v4, v1
    double-to-float v1, v4
    invoke-static v10, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v2
    int-to-long v4, v2
    invoke-static v1, Ljava/lang/Float;->floatToRawIntBits(F)I
    move-result v1
    int-to-long v1, v1
    const/16 v3, 32
    shl-long v3, v4, v3
    and-long v1, v1, v17
    or-long/2addr v1, v3
    invoke-static v1, v2, Landroidx/compose/ui/geometry/Offset;->constructor-impl(J)J
    move-result-wide v1
    invoke-static v8, v9, v1, v2, Landroidx/compose/ui/geometry/Offset;->plus-MK-Hz9U(J J)J
    move-result-wide v8
    sget-object v1, Landroidx/compose/ui/graphics/StrokeCap;->Companion Landroidx/compose/ui/graphics/StrokeCap$Companion;
    invoke-virtual v1, Landroidx/compose/ui/graphics/StrokeCap$Companion;->getRound-KaPHkGw()I
    move-result v10
    const/4 v11, 0
    const/4 v12, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v21, 480
    const/16 v22, 0
    move-object/from16 v1, v26
    move-wide/from16 v2, v19
    move-wide v4, v6
    move-wide v6, v8
    move v8, v0
    move v9, v10
    move-object v10, v11
    move v11, v12
    move-object/from16 v12, v17
    move/from16 v17, v13
    move/from16 v13, v18
    move/from16 v18, v14
    move/from16 v14, v21
    move-object/from16 v15, v22
    invoke-static/range v1 ... v15, Landroidx/compose/ui/graphics/drawscope/DrawScope;->drawLine-NGM6Ib0$default(Landroidx/compose/ui/graphics/drawscope/DrawScope; J J J F I Landroidx/compose/ui/graphics/PathEffect; F Landroidx/compose/ui/graphics/ColorFilter; I I Ljava/lang/Object;)V
    add-int/lit8 v12, v16, 1
    move-object/from16 v15, v26
    move/from16 v13, v17
    move/from16 v14, v18
    goto/16 -0beh
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final TraeActivityIndicator_iJQMabo$lambda$4(androidx.compose.ui.Modifier  long  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 13
    # ins_size=7
    or-int/lit8 v9, v9, 1
    invoke-static v9, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v4
    move-object v0, v6
    move-wide v1, v7
    move-object v3, v11
    move v5, v10
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraeActivityIndicatorKt;->TraeActivityIndicator-iJQMabo(Landroidx/compose/ui/Modifier; J Landroidx/compose/runtime/Composer; I I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
