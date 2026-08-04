# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt;
.super Ljava/lang/Object;
.source "SettingsScaffold.kt"


.method public static final noRippleClickable(androidx.compose.ui.Modifier  com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function0)androidx.compose.ui.Modifier
    .registers 4
    # ins_size=3
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clickHandler"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onClick"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt$noRippleClickable$1;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)V
    check-cast v0, Lkotlin/jvm/functions/Function3;
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v1, v3, v0, v2, v3, Landroidx/compose/ui/ComposedModifierKt;->composed$default(Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v1
    return-object v1
.end method

.method public static final settingsEntryPalette(androidx.compose.runtime.Composer  int)com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette
    .registers 45
    # ins_size=2
    move-object/from16 v0, v43
    const v1, -983321225
    invoke-interface v0, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +00ah
    const/4 v2, -1
    const-string v3, "com.bytedance.trae.home.solo.setting.ui.settingsEntryPalette (SettingsScaffold.kt:36)"
    move/from16 v4, v44
    invoke-static v1, v4, v2, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v2, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/design/compose/TraeTheme;->getColors(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeColors;
    move-result-object v1
    new-instance v42, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    move-object/from16 v2, v42
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgBaseSecondary-0d7_KjU()J
    move-result-wide v3
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgBaseDefault-0d7_KjU()J
    move-result-wide v5
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextDefault-0d7_KjU()J
    move-result-wide v7
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextTertiary-0d7_KjU()J
    move-result-wide v9
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgBrandPopup-0d7_KjU()J
    move-result-wide v11
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextBrand-0d7_KjU()J
    move-result-wide v13
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgOverlayL2-0d7_KjU()J
    move-result-wide v15
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextSecondary-0d7_KjU()J
    move-result-wide v17
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getStatusSuccessDefault-0d7_KjU()J
    move-result-wide v19
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getSpecialWhite-0d7_KjU()J
    move-result-wide v21
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgInvert-0d7_KjU()J
    move-result-wide v23
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getTextTextOnaccent-0d7_KjU()J
    move-result-wide v25
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getStatusPrimaryDefault-0d7_KjU()J
    move-result-wide v27
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getSpecialWhite-0d7_KjU()J
    move-result-wide v29
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgOverlayL2-0d7_KjU()J
    move-result-wide v31
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getIconIconDefault-0d7_KjU()J
    move-result-wide v33
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getIconIconTertiary-0d7_KjU()J
    move-result-wide v35
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBorderBorderNeutralL1-0d7_KjU()J
    move-result-wide v37
    invoke-virtual v1, Lcom/bytedance/trae/design/compose/TraeColors;->getBgBgWhite-0d7_KjU()J
    move-result-wide v39
    const/16 v41, 0
    invoke-direct/range v2 ... v41, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;-><init>(J J J J J J J J J J J J J J J J J J J Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface/range v43, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    return-object v42
.end method
