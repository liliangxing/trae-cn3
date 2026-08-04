# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt;
.super Ljava/lang/Object;
.source "SettingsAvatar.kt"


.method public static synthetic $r8$lambda$JpjGbk5epd5z3CXQSQnLnfZlPr8(java.lang.String  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt;->SettingsAvatar$lambda$0(Ljava/lang/String; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RLuorWcOTtMYORFAfMZdSUESIKo(java.lang.String  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt;->SettingsAvatar$lambda$1(Ljava/lang/String; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static final SettingsAvatar(java.lang.String  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 16
    # ins_size=5
    const-string v0, "avatarUrl"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 1895162476
    invoke-interface v13, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v13
    and-int/lit8 v1, v15, 1
    const/4 v2, 2
    if-eqz v1, +005h
    or-int/lit8 v1, v14, 6
    goto +11h
    and-int/lit8 v1, v14, 6
    if-nez v1, +00dh
    invoke-interface v13, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    move v1, v2
    or-int/2addr v1, v14
    goto +2h
    move v1, v14
    and-int/lit8 v3, v15, 2
    if-eqz v3, +005h
    or-int/lit8 v1, v1, 48
    goto +11h
    and-int/lit8 v4, v14, 48
    if-nez v4, +00eh
    invoke-interface v13, v12, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 32
    goto +3h
    const/16 v4, 16
    or-int/2addr v1, v4
    and-int/lit8 v4, v1, 19
    const/16 v5, 18
    if-ne v4, v5, +00eh
    invoke-interface v13, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +6h
    invoke-interface v13, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +0aeh
    if-eqz v3, +006h
    sget-object v12, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v12, Landroidx/compose/ui/Modifier;
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +008h
    const/4 v3, -1
    const-string v4, "com.bytedance.trae.home.solo.setting.ui.components.SettingsAvatar (SettingsAvatar.kt:19)"
    invoke-static v0, v1, v3, v4, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const v0, 129263519
    invoke-interface v13, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +040h
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_trae_default_avatar(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    const/4 v2, 0
    invoke-static v0, v13, v2, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v0
    sget-object v2, Landroidx/compose/ui/layout/ContentScale;->Companion Landroidx/compose/ui/layout/ContentScale$Companion;
    invoke-virtual v2, Landroidx/compose/ui/layout/ContentScale$Companion;->getCrop()Landroidx/compose/ui/layout/ContentScale;
    move-result-object v5
    const/4 v2, 0
    const/4 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    shl-int/lit8 v1, v1, 3
    and-int/lit16 v1, v1, 896
    or-int/lit16 v9, v1, 24624
    const/16 v10, 104
    move-object v1, v0
    move-object v3, v12
    move-object v8, v13
    invoke-static/range v1 ... v10, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v13
    if-eqz v13, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt$$ExternalSyntheticLambda0;
    invoke-direct v0, v11, v12, v14, v15, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v13, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v0, Lcom/bytedance/kmp/image/options/ImagePlaceholder;->Companion Lcom/bytedance/kmp/image/options/ImagePlaceholder$Companion;
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_trae_default_avatar(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v3
    const/4 v4, 0
    invoke-static v0, v3, v4, v2, v4, Lcom/bytedance/kmp/image/options/ImagePlaceholder$Companion;->ofResource$default(Lcom/bytedance/kmp/image/options/ImagePlaceholder$Companion; Lorg/jetbrains/compose/resources/DrawableResource; Lcom/bytedance/kmp/image/options/ImageScaleType; I Ljava/lang/Object;)Lcom/bytedance/kmp/image/options/ImagePlaceholder;
    move-result-object v0
    new-instance v2, Lcom/bytedance/kmp/image/options/UrlSource;
    invoke-direct v2, v11, Lcom/bytedance/kmp/image/options/UrlSource;-><init>(Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/kmp/image/options/ImageOptions;->Companion Lcom/bytedance/kmp/image/options/ImageOptions$Companion;
    invoke-virtual v3, Lcom/bytedance/kmp/image/options/ImageOptions$Companion;->newInstance()Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v3
    sget-object v4, Lcom/bytedance/kmp/image/options/ImageScaleType;->Companion Lcom/bytedance/kmp/image/options/ImageScaleType$Companion;
    invoke-virtual v4, Lcom/bytedance/kmp/image/options/ImageScaleType$Companion;->getCENTER_CROP()Lcom/bytedance/kmp/image/options/ImageScaleType;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/kmp/image/options/ImageOptions;->scaleType(Lcom/bytedance/kmp/image/options/ImageScaleType;)Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/kmp/image/options/ImageOptions;->borderAsCircle()Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v3
    invoke-virtual v3, v0, Lcom/bytedance/kmp/image/options/ImageOptions;->loadingPlaceHolder(Lcom/bytedance/kmp/image/options/ImagePlaceholder;)Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v3
    invoke-virtual v3, v0, Lcom/bytedance/kmp/image/options/ImageOptions;->errorPlaceHolder(Lcom/bytedance/kmp/image/options/ImagePlaceholder;)Lcom/bytedance/kmp/image/options/ImageOptions;
    move-result-object v4
    move-object v0, v2
    check-cast v0, Lcom/bytedance/kmp/image/options/KImageSource;
    const/4 v2, 0
    const/4 v3, 0
    shl-int/lit8 v1, v1, 9
    const v5, 57344
    and-int v7, v1, v5
    const/4 v8, 6
    move-object v1, v0
    move-object v5, v12
    move-object v6, v13
    invoke-static/range v1 ... v8, Lcom/bytedance/kmp/image/KImage_androidKt;->KImage(Lcom/bytedance/kmp/image/options/KImageSource; Ljava/lang/String; Landroidx/compose/ui/Alignment; Lcom/bytedance/kmp/image/options/ImageOptions; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v13, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v13
    if-eqz v13, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt$$ExternalSyntheticLambda1;
    invoke-direct v0, v11, v12, v14, v15, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v13, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsAvatar$lambda$0(java.lang.String  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v4, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt;->SettingsAvatar(Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final SettingsAvatar$lambda$1(java.lang.String  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v2, v2, 1
    invoke-static v2, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v2
    invoke-static v0, v1, v4, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/components/SettingsAvatarKt;->SettingsAvatar(Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method
