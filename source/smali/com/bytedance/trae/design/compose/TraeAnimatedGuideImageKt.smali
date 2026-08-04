# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt;
.super Ljava/lang/Object;
.source "TraeAnimatedGuideImage.kt"


.method public static synthetic $r8$lambda$Z69jTO896fhfPDEyECRs5Z3ioro(org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.Modifier  float  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt;->TraeAnimatedGuideImage_6a0pyJM$lambda$2(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/Modifier; F I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$xl1vAr4CgqHsG04iN6TNKb59YZM(com.bytedance.kmp.image.options.ImageAnimationController)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt;->TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0(Lcom/bytedance/kmp/image/options/ImageAnimationController;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static final TraeAnimatedGuideImage-6a0pyJM(org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.Modifier  float  androidx.compose.runtime.Composer  int  int)void
    .registers 15
    # ins_size=6
    const-string/jumbo v0, resource
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, -285274387
    invoke-interface v12, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v12
    and-int/lit8 v1, v14, 1
    const/4 v2, 4
    if-eqz v1, +005h
    or-int/lit8 v1, v13, 6
    goto +11h
    and-int/lit8 v1, v13, 6
    if-nez v1, +00dh
    invoke-interface v12, v9, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    const/4 v1, 2
    or-int/2addr v1, v13
    goto +2h
    move v1, v13
    and-int/lit8 v3, v14, 2
    if-eqz v3, +005h
    or-int/lit8 v1, v1, 48
    goto +11h
    and-int/lit8 v4, v13, 48
    if-nez v4, +00eh
    invoke-interface v12, v10, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 32
    goto +3h
    const/16 v4, 16
    or-int/2addr v1, v4
    and-int/lit8 v4, v14, 4
    if-eqz v4, +005h
    or-int/lit16 v1, v1, 384
    goto +11h
    and-int/lit16 v5, v13, 384
    if-nez v5, +00eh
    invoke-interface v12, v11, Landroidx/compose/runtime/Composer;->changed(F)Z
    move-result v5
    if-eqz v5, +005h
    const/16 v5, 256
    goto +3h
    const/16 v5, 128
    or-int/2addr v1, v5
    and-int/lit16 v5, v1, 147
    const/16 v6, 146
    if-ne v5, v6, +010h
    invoke-interface v12, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v5
    if-nez v5, +003h
    goto +8h
    invoke-interface v12, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v3, v10
    move v4, v11
    goto/16 +08ah
    if-eqz v3, +006h
    sget-object v10, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v10, Landroidx/compose/ui/Modifier;
    if-eqz v4, +009h
    const/16 v11, 20
    int-to-float v11, v11
    invoke-static v11, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v11
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +008h
    const/4 v3, -1
    const-string v4, "com.bytedance.trae.design.compose.TraeAnimatedGuideImage (TraeAnimatedGuideImage.kt:22)"
    invoke-static v0, v1, v3, v4, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const v0, -2047180901
    invoke-interface v12, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit8 v0, v1, 14
    if-ne v0, v2, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    invoke-interface v12, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v0, +00ah
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v1, v0, +028h
    sget-object v0, Lcom/bytedance/kmp/image/options/ImageOptions;->Companion Lcom/bytedance/kmp/image/options/ImageOptions$Companion;
    invoke-virtual v0, Lcom/bytedance/kmp/image/options/ImageOptions$Companion;->newInstance()Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v0
    sget-object v1, Lcom/bytedance/kmp/image/options/ImageScaleType;->Companion Lcom/bytedance/kmp/image/options/ImageScaleType$Companion;
    invoke-virtual v1, Lcom/bytedance/kmp/image/options/ImageScaleType$Companion;->getCENTER_CROP()Lcom/bytedance/kmp/image/options/ImageScaleType;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/kmp/image/options/ImageOptions;->scaleType(Lcom/bytedance/kmp/image/options/ImageScaleType;)Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v0
    sget-object v1, Lcom/bytedance/kmp/image/options/AnimatedImageOptions;->Companion Lcom/bytedance/kmp/image/options/AnimatedImageOptions$Companion;
    invoke-virtual v1, Lcom/bytedance/kmp/image/options/AnimatedImageOptions$Companion;->newInstance()Lcom/bytedance/kmp/image/options/AnimatedImageOptions;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v1, v2, Lcom/bytedance/kmp/image/options/AnimatedImageOptions;->onControllerReady(Lkotlin/jvm/functions/Function1;)Lcom/bytedance/kmp/image/options/AnimatedImageOptions;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/kmp/image/options/ImageOptions;->animateImageOptions(Lcom/bytedance/kmp/image/options/AnimatedImageOptions;)Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v1
    invoke-interface v12, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v4, v1
    check-cast v4, Lcom/bytedance/kmp/image/options/ImageOptions;
    invoke-interface v12, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    new-instance v0, Lcom/bytedance/kmp/image/options/LocalResourceSource;
    invoke-direct v0, v9, Lcom/bytedance/kmp/image/options/LocalResourceSource;-><init>(Lorg/jetbrains/compose/resources/DrawableResource;)V
    invoke-static v11, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v1
    check-cast v1, Landroidx/compose/ui/graphics/Shape;
    invoke-static v10, v1, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    move-object v1, v0
    check-cast v1, Lcom/bytedance/kmp/image/options/KImageSource;
    const/4 v2, 0
    const/4 v3, 0
    const/16 v7, 48
    const/4 v8, 4
    move-object v6, v12
    invoke-static/range v1 ... v8, Lcom/bytedance/kmp/image/KImage_androidKt;->KImage(Lcom/bytedance/kmp/image/options/KImageSource; Ljava/lang/String; Landroidx/compose/ui/Alignment; Lcom/bytedance/kmp/image/options/ImageOptions; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, -085h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    goto/16 -08ah
    invoke-interface v12, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v10
    if-eqz v10, +00eh
    new-instance v11, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;
    move-object v1, v11
    move-object v2, v9
    move v5, v13
    move v6, v14
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1;-><init>(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/Modifier; F I I)V
    invoke-interface v10, v11, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0(com.bytedance.kmp.image.options.ImageAnimationController)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "controller"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, -1
    invoke-interface v1, v0, Lcom/bytedance/kmp/image/options/ImageAnimationController;->setRepeatCount(I)V
    invoke-interface v1, Lcom/bytedance/kmp/image/options/ImageAnimationController;->start()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final TraeAnimatedGuideImage_6a0pyJM$lambda$2(org.jetbrains.compose.resources.DrawableResource  androidx.compose.ui.Modifier  float  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 13
    # ins_size=7
    or-int/lit8 v9, v9, 1
    invoke-static v9, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v4
    move-object v0, v6
    move-object v1, v7
    move v2, v8
    move-object v3, v11
    move v5, v10
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt;->TraeAnimatedGuideImage-6a0pyJM(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/Modifier; F Landroidx/compose/runtime/Composer; I I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
