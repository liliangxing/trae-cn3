# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;
.super Ljava/lang/Object;
.source "SettingsEntry.kt"

.implements Lkotlin/jvm/functions/Function3;

.field final synthetic $colors:Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
.field final synthetic $contentScrollState:Landroidx/compose/foundation/ScrollState;
.field final synthetic $density:Landroidx/compose/ui/unit/Density;
.field final synthetic $dismissPopupClickHandler:Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
.field final synthetic $languageAnchorTop$delegate:Landroidx/compose/runtime/MutableState;
.field final synthetic $logoutDialogVisible$delegate:Landroidx/compose/runtime/MutableState;
.field final synthetic $onEditProfile:Lkotlin/jvm/functions/Function0;
.field final synthetic $onItemClick:Lkotlin/jvm/functions/Function1;
.field final synthetic $onLanguageSelected:Lkotlin/jvm/functions/Function1;
.field final synthetic $onOpenAbout:Lkotlin/jvm/functions/Function0;
.field final synthetic $onOpenDeviceManagement:Lkotlin/jvm/functions/Function0;
.field final synthetic $onThemeSelected:Lkotlin/jvm/functions/Function1;
.field final synthetic $popupType$delegate:Landroidx/compose/runtime/MutableState;
.field final synthetic $state:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
.field final synthetic $themeAnchorTop$delegate:Landroidx/compose/runtime/MutableState;


.method public static synthetic $r8$lambda$D0-xZz1LPULhlXRfIgXoe9yX9jI(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$K4GClkJSEd9uI7ADRqZG-F-8BUM(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$20$lambda$11$lambda$10$lambda$9(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$ThRk56EEu4nnWQ7xy-U7Kaxv9B0(kotlin.jvm.functions.Function1  java.lang.String  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13(Lkotlin/jvm/functions/Function1; Ljava/lang/String; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$YZVlmr0xeK0V7089cVIVFLABv4E(androidx.compose.ui.unit.Density  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  float)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$6$lambda$5$lambda$4$lambda$3(Landroidx/compose/ui/unit/Density; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$bexuXizylmO6pmC98SgSWIcAarU(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$6$lambda$5$lambda$1$lambda$0(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$i4cwPa2d2o4jrIYesBwUPzaXb-0(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  java.lang.String  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$20$lambda$16$lambda$15$lambda$14(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Ljava/lang/String; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oeFyEBdwsk1meLwVk6wfrnvHsfE(androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$20$lambda$19$lambda$18$lambda$17(Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$tIzMfuFd8Bo-lOePPMlhzdz3woo(com.bytedance.trae.kmp.ui.KmpClickHandler  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke$lambda$20$lambda$19$lambda$18(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(androidx.compose.foundation.ScrollState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.unit.Density  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 16
    # ins_size=16
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$state Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$colors Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onEditProfile Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onOpenAbout Lkotlin/jvm/functions/Function0;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onOpenDeviceManagement Lkotlin/jvm/functions/Function0;
    iput-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onItemClick Lkotlin/jvm/functions/Function1;
    iput-object v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$density Landroidx/compose/ui/unit/Density;
    iput-object v9, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$popupType$delegate Landroidx/compose/runtime/MutableState;
    iput-object v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    iput-object v11, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$themeAnchorTop$delegate Landroidx/compose/runtime/MutableState;
    iput-object v12, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$languageAnchorTop$delegate Landroidx/compose/runtime/MutableState;
    iput-object v13, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$dismissPopupClickHandler Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iput-object v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onThemeSelected Lkotlin/jvm/functions/Function1;
    iput-object v15, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onLanguageSelected Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$20$lambda$11$lambda$10$lambda$9(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda7;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda7;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Landroidx/compose/runtime/MutableState;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$20$lambda$11$lambda$10$lambda$9$lambda$8(kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.viewmodel.SettingsThemeMode  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 4
    # ins_size=3
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$2(Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;)V
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$20$lambda$16$lambda$15$lambda$14(com.bytedance.trae.kmp.ui.KmpClickHandler  kotlin.jvm.functions.Function1  java.lang.String  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda5;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda5;-><init>(Lkotlin/jvm/functions/Function1; Ljava/lang/String; Landroidx/compose/runtime/MutableState;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$20$lambda$16$lambda$15$lambda$14$lambda$13(kotlin.jvm.functions.Function1  java.lang.String  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 4
    # ins_size=3
    const/4 v0, 0
    invoke-static v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$2(Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;)V
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$20$lambda$19$lambda$18(com.bytedance.trae.kmp.ui.KmpClickHandler  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda6;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda6;-><init>(Landroidx/compose/runtime/MutableState;)V
    invoke-virtual v1, v0, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;->tryHandle(Lkotlin/jvm/functions/Function0;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$20$lambda$19$lambda$18$lambda$17(androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$2(Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$6$lambda$5$lambda$1$lambda$0(kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey)kotlin.Unit
    .registers 9
    # ins_size=6
    const-string v0, "key"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 1
    if-eq v0, v1, +027h
    const/4 v2, 2
    if-eq v0, v2, +01eh
    const/4 v6, 3
    if-eq v0, v6, +017h
    const/4 v3, 4
    if-eq v0, v3, +010h
    const/4 v3, 5
    if-eq v0, v3, +006h
    invoke-interface v5, v8, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +1bh
    invoke-interface v5, v8, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v7, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$11(Landroidx/compose/runtime/MutableState; Z)V
    goto +14h
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +10h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +ch
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->Language Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    invoke-static v6, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$2(Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;)V
    goto +6h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->Theme Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    invoke-static v6, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$2(Landroidx/compose/runtime/MutableState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final invoke$lambda$6$lambda$5$lambda$4$lambda$3(androidx.compose.ui.unit.Density  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableState  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  float)kotlin.Unit
    .registers 6
    # ins_size=5
    const-string v0, "key"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, v5, Landroidx/compose/ui/unit/Density;->toDp-u2uoSUM(F)F
    move-result v1
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->ordinal()I
    move-result v4
    aget v4, v5, v4
    const/4 v5, 1
    if-eq v4, v5, +00ah
    const/4 v2, 2
    if-eq v4, v2, +003h
    goto +8h
    invoke-static v3, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$8(Landroidx/compose/runtime/MutableState; F)V
    goto +4h
    invoke-static v2, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$5(Landroidx/compose/runtime/MutableState; F)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Landroidx/compose/foundation/layout/BoxWithConstraintsScope;
    check-cast v2, Landroidx/compose/runtime/Composer;
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v3
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->invoke(Landroidx/compose/foundation/layout/BoxWithConstraintsScope; Landroidx/compose/runtime/Composer; I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope  androidx.compose.runtime.Composer  int)void
    .registers 38
    # ins_size=4
    move-object/from16 v0, v34
    move-object/from16 v1, v35
    move-object/from16 v9, v36
    const-string v2, "$this$BoxWithConstraints"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    and-int/lit8 v2, v37, 6
    const/4 v10, 2
    if-nez v2, +00eh
    invoke-interface v9, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 4
    goto +2h
    move v2, v10
    or-int v2, v37, v2
    goto +3h
    move/from16 v2, v37
    and-int/lit8 v3, v2, 19
    const/16 v4, 18
    if-ne v3, v4, +00eh
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v3
    if-nez v3, +003h
    goto +6h
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +4b1h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v3
    if-eqz v3, +00bh
    const/4 v3, -1
    const-string v4, "com.bytedance.trae.home.solo.setting.ui.SettingsEntryContent.<anonymous> (SettingsEntry.kt:190)"
    const v5, -108097301
    invoke-static v5, v2, v3, v4, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    const/4 v3, 0
    const/4 v11, 1
    const/4 v12, 0
    invoke-static v2, v3, v11, v12, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v13
    iget-object v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$contentScrollState Landroidx/compose/foundation/ScrollState;
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 14
    const/16 v19, 0
    invoke-static/range v13 ... v19, Landroidx/compose/foundation/ScrollKt;->verticalScroll$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Z Landroidx/compose/foundation/gestures/FlingBehavior; Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    const/16 v4, 16
    int-to-float v4, v4
    invoke-static v4, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v4
    invoke-static v2, v4, v3, v10, v12, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v2, 24
    int-to-float v2, v2
    invoke-static v2, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v17
    const/16 v18, 7
    invoke-static/range v13 ... v19, Landroidx/compose/foundation/layout/PaddingKt;->padding-qDBjuR0$default(Landroidx/compose/ui/Modifier; F F F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v3, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v3, Landroidx/compose/ui/Alignment$Companion;->getCenterHorizontally()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v3
    iget-object v13, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$state Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    iget-object v14, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$colors Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onEditProfile Lkotlin/jvm/functions/Function0;
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onOpenAbout Lkotlin/jvm/functions/Function0;
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onOpenDeviceManagement Lkotlin/jvm/functions/Function0;
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onItemClick Lkotlin/jvm/functions/Function1;
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$density Landroidx/compose/ui/unit/Density;
    iget-object v15, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$popupType$delegate Landroidx/compose/runtime/MutableState;
    iget-object v12, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$logoutDialogVisible$delegate Landroidx/compose/runtime/MutableState;
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$themeAnchorTop$delegate Landroidx/compose/runtime/MutableState;
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$languageAnchorTop$delegate Landroidx/compose/runtime/MutableState;
    const v1, 1341605231
    move-object/from16 v16, v15
    const-string v15, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v9, v1, v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v1, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v1, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v1
    const/16 v15, 48
    invoke-static v1, v3, v9, v15, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v1
    const v3, -1159599143
    const-string v15, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v9, v3, v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v3, 0
    invoke-static v9, v3, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v17
    invoke-static/range v17 ... v18, Ljava/lang/Long;->hashCode(J)I
    move-result v15
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v3
    invoke-static v9, v2, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    sget-object v17, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual/range v17, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    move-object/from16 v24, v10
    const v10, -553112988
    move-object/from16 v25, v11
    const-string v11, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v9, v10, v11, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v10
    instance-of v10, v10, Landroidx/compose/runtime/Applier;
    if-nez v10, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v10
    if-eqz v10, +006h
    invoke-interface v9, v0, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static/range v36, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v0
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v10
    invoke-static v0, v1, v10, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-static v0, v3, v1, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-interface v0, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v3
    if-nez v3, +010h
    invoke-interface v0, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v3
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-static v3, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +010h
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v15, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v0, v3, v1, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-static v0, v2, v1, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 2093002350
    const-string v1, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v9, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/ColumnScope;
    const/4 v0, 0
    invoke-static v13, v14, v4, v9, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$ProfileHeader(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    const v1, 540051626
    invoke-interface v9, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getGroups()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +09eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getMessageUnreadBadge()Ljava/lang/String;
    move-result-object v4
    const v3, 2084059247
    invoke-interface v9, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    invoke-interface v9, v7, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v10
    or-int/2addr v3, v10
    invoke-interface v9, v6, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v10
    or-int/2addr v3, v10
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v10
    if-nez v3, +00eh
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v10, v3, +003h
    goto +4h
    move-object/from16 v11, v16
    goto +16h
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;
    move-object/from16 v11, v16
    move-object v15, v10
    move-object/from16 v16, v8
    move-object/from16 v17, v7
    move-object/from16 v18, v6
    move-object/from16 v19, v11
    move-object/from16 v20, v12
    invoke-direct/range v15 ... v20, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState;)V
    invoke-interface v9, v10, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v10, Lkotlin/jvm/functions/Function1;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const v3, 2084081973
    invoke-interface v9, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v5, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v3
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v15
    if-nez v3, +010h
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v15, v3, +003h
    goto +6h
    move-object/from16 v3, v24
    move-object/from16 v0, v25
    goto +dh
    new-instance v15, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;
    move-object/from16 v3, v24
    move-object/from16 v0, v25
    invoke-direct v15, v5, v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda1;-><init>(Landroidx/compose/ui/unit/Density; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableState;)V
    invoke-interface v9, v15, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v15, Lkotlin/jvm/functions/Function2;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v16, 0
    move-object/from16 v17, v3
    move-object v3, v14
    move-object/from16 v18, v5
    move-object v5, v10
    move-object v10, v6
    move-object v6, v15
    move-object v15, v7
    move-object/from16 v7, v36
    move-object/from16 v19, v8
    move/from16 v8, v16
    invoke-static/range v2 ... v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsGroupView(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    move-object/from16 v25, v0
    move-object v6, v10
    move-object/from16 v16, v11
    move-object v7, v15
    move-object/from16 v24, v17
    move-object/from16 v5, v18
    move-object/from16 v8, v19
    const/4 v0, 0
    goto/16 -0a0h
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getFooter()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    move-result-object v0
    const/4 v1, 0
    invoke-static v0, v14, v9, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsFooter(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    invoke-static/range v36, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static/range v36, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v36, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static/range v36, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    move-object/from16 v0, v34
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$popupType$delegate Landroidx/compose/runtime/MutableState;
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$1(Landroidx/compose/runtime/MutableState;)Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;
    move-result-object v2
    if-nez v2, +004h
    goto/16 +2bch
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$state Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$colors Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$dismissPopupClickHandler Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$themeAnchorTop$delegate Landroidx/compose/runtime/MutableState;
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$languageAnchorTop$delegate Landroidx/compose/runtime/MutableState;
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onThemeSelected Lkotlin/jvm/functions/Function1;
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$popupType$delegate Landroidx/compose/runtime/MutableState;
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3;->$onLanguageSelected Lkotlin/jvm/functions/Function1;
    sget-object v12, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->ordinal()I
    move-result v13
    aget v12, v12, v13
    const/4 v13, 1
    if-eq v12, v13, +010h
    const/4 v13, 2
    if-ne v12, v13, +007h
    invoke-static v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$7(Landroidx/compose/runtime/MutableState;)F
    move-result v6
    goto +bh
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    invoke-static v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$SettingsEntryContent$lambda$4(Landroidx/compose/runtime/MutableState;)F
    move-result v6
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupAnchorYOffset$p()F
    move-result v7
    add-float/2addr v6, v7
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-interface/range v35, Landroidx/compose/foundation/layout/BoxWithConstraintsScope;->getMaxWidth-D9Ej5fM()F
    move-result v7
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupEndMargin$p()F
    move-result v12
    sub-float/2addr v7, v12
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupWidth$p()F
    move-result v12
    sub-float/2addr v7, v12
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->box-impl(F)Landroidx/compose/ui/unit/Dp;
    move-result-object v7
    int-to-float v12, v1
    invoke-static v12, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v12
    invoke-static v12, Landroidx/compose/ui/unit/Dp;->box-impl(F)Landroidx/compose/ui/unit/Dp;
    move-result-object v12
    invoke-static v7, v12, Lkotlin/ranges/RangesKt;->coerceAtLeast(Ljava/lang/Comparable; Ljava/lang/Comparable;)Ljava/lang/Comparable;
    move-result-object v7
    check-cast v7, Landroidx/compose/ui/unit/Dp;
    invoke-virtual v7, Landroidx/compose/ui/unit/Dp;->unbox-impl()F
    move-result v7
    sget-object v12, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;->ordinal()I
    move-result v2
    aget v2, v12, v2
    const/16 v12, 10
    const/4 v13, 1
    if-eq v2, v13, +105h
    const/4 v13, 2
    if-ne v2, v13, +0f3h
    const v2, -435419194
    invoke-interface v9, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    const/4 v2, 3
    new-array v2, v2, [Lkotlin/Pair;
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_lang_chinese(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    const-string/jumbo v8, zh
    invoke-static v8, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v2, v1
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_lang_english(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    const-string v8, "en"
    invoke-static v8, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v8, 1
    aput-object v3, v2, v8
    sget-object v3, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v3, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_lang_japanese(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v3
    const-string v8, "ja"
    invoke-static v8, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v8, 2
    aput-object v3, v2, v8
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-static v2, v12, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v8
    invoke-direct v3, v8, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +09bh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lkotlin/Pair;
    invoke-virtual v8, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Ljava/lang/String;
    invoke-virtual v8, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lorg/jetbrains/compose/resources/StringResource;
    const v13, 2084146671
    invoke-interface v9, v13, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v12, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v13
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v14
    if-nez v13, +00ah
    sget-object v13, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v13, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v13
    if-ne v14, v13, +00ch
    new-instance v14, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v13, 1
    const/4 v15, 0
    invoke-direct v14, v15, v13, v15, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v9, v14, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v14, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    new-instance v13, Ljava/lang/StringBuilder;
    const-string v15, "language_"
    invoke-direct v13, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v24
    new-array v13, v1, [Ljava/lang/Object;
    invoke-static v8, v13, v9, v1, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v25
    const v8, 2084154845
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v14, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v8
    invoke-interface v9, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v13
    or-int/2addr v8, v13
    invoke-interface v9, v12, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v13
    or-int/2addr v8, v13
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v13
    if-nez v8, +00ah
    sget-object v8, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v8, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v8
    if-ne v13, v8, +00ah
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda3;
    invoke-direct v13, v14, v11, v12, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Ljava/lang/String; Landroidx/compose/runtime/MutableState;)V
    invoke-interface v9, v13, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v26, v13
    check-cast v26, Lkotlin/jvm/functions/Function0;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 248
    const/16 v33, 0
    new-instance v8, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    move-object/from16 v23, v8
    invoke-direct/range v23 ... v33, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v3, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -09dh
    check-cast v3, Ljava/util/List;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    goto/16 +0d3h
    const v1, 540112318
    invoke-interface v9, v1, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    const v2, -436328641
    invoke-interface v9, v2, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;->getThemeMode()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$popupOptions(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-static v2, v12, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v11
    invoke-direct v3, v11, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +09ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    const v12, 2084116683
    invoke-interface v9, v12, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v12
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v13
    if-nez v12, +00dh
    sget-object v12, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v12, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v12
    if-ne v13, v12, +003h
    goto +3h
    const/4 v12, 1
    goto +bh
    new-instance v13, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    const/4 v12, 1
    const/4 v14, 0
    invoke-direct v13, v14, v12, v14, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v9, v13, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v13, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    new-instance v14, Ljava/lang/StringBuilder;
    const-string/jumbo v15, theme_
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->name()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v16
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$titleResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v14
    new-array v15, v1, [Ljava/lang/Object;
    invoke-static v14, v15, v9, v1, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v17
    const v14, 2084124950
    invoke-interface v9, v14, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v13, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v14
    invoke-interface v9, v8, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v15
    or-int/2addr v14, v15
    invoke-interface v9, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v15
    or-int/2addr v14, v15
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v15
    if-nez v14, +00ah
    sget-object v14, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v14, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v14
    if-ne v15, v14, +00ah
    new-instance v15, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;
    invoke-direct v15, v13, v8, v11, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Landroidx/compose/runtime/MutableState;)V
    invoke-interface v9, v15, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object/from16 v18, v15
    check-cast v18, Lkotlin/jvm/functions/Function0;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 248
    const/16 v25, 0
    new-instance v11, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;
    move-object v15, v11
    invoke-direct/range v15 ... v25, Lcom/bytedance/trae/design/compose/TraeContextMenuItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; Landroidx/compose/ui/graphics/Color; Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/graphics/Color; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v3, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -09ch
    check-cast v3, Ljava/util/List;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v1, v3
    new-instance v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;
    const/4 v3, 0
    invoke-direct v2, v7, v6, v3, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition$Fixed;-><init>(F F Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupWidth$p()F
    move-result v6
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupItemHeight$p()F
    move-result v7
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupCornerRadius$p()F
    move-result v8
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupElevation$p()F
    move-result v20
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt;->access$getSettingsPopupDividerHeight$p()F
    move-result v21
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getDivider-0d7_KjU()J
    move-result-wide v22
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getPrimaryText-0d7_KjU()J
    move-result-wide v32
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    const/high16 v4, 1065353216
    invoke-static v3, v4, Landroidx/compose/ui/ZIndexModifierKt;->zIndex(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v4
    check-cast v2, Lcom/bytedance/trae/design/compose/TraeContextMenuPosition;
    const v3, 540167267
    invoke-interface v9, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v9, v5, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v3
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    if-nez v3, +00ah
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v11, v3, +00ah
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda4;
    invoke-direct v11, v5, v10, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryKt$SettingsEntryContent$3$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Landroidx/compose/runtime/MutableState;)V
    invoke-interface v9, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    move-object v3, v11
    check-cast v3, Lkotlin/jvm/functions/Function0;
    invoke-interface/range v36, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const-wide/16 v24, 0
    const/16 v26, 0
    const v28, 115043328
    const/16 v29, 0
    const/16 v30, 0
    const v31, 6815232
    move v5, v6
    move v6, v7
    move v7, v8
    move/from16 v8, v20
    move/from16 v9, v21
    move-wide/from16 v20, v22
    move-wide/from16 v22, v32
    move-object/from16 v27, v36
    invoke-static/range v1 ... v31, Lcom/bytedance/trae/design/compose/TraeContextMenuPopupKt;->TraeContextMenuPopup-_G194Zc(Ljava/util/List; Lcom/bytedance/trae/design/compose/TraeContextMenuPosition; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; F F F F F Z Z Z F F F F F F Lcom/bytedance/trae/design/compose/TraeContextMenuShadowPadding; J J J Ljava/lang/String; Landroidx/compose/runtime/Composer; I I I I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v1
    if-eqz v1, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-void 
.end method
