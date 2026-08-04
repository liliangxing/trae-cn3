# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;
.super Ljava/lang/Object;
.source "SettingsAbout.kt"

.field private static final AboutItemHeight:F


.method public static synthetic $r8$lambda$0RmTxTw0ZpvN5I5CGYGEhPoP36Y(androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->SettingsAboutContent$lambda$1$lambda$0(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$5g8KH2C_LjzO4292PogZxdyjDoo(kotlin.jvm.functions.Function2  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutRow$lambda$12$lambda$11(Lkotlin/jvm/functions/Function2; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LiUOdglIWdfSsgsNaN_WtnB1vsY(java.util.List  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemsGroup$lambda$9(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WTXG6gnIlulRPrf7R-79IiYP0lQ(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutLogo$lambda$5(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$f9Fg4cS3ZBetR7u0IwSzhEr33as(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutRow$lambda$14(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$jMXLfcxg0XEObcbAxYgTGhRFenM(java.util.List  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemsGroup$lambda$6(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$mc7H5NtBZhPfuYCvDirKBSOZyM0(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState  androidx.compose.ui.Modifier  kotlin.jvm.functions.Function2  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->SettingsAboutContent$lambda$3(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState; Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function2; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    const/16 v0, 56
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemHeight F
    return-void 
.end method

.method private static final AboutItemsGroup(java.util.List  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  androidx.compose.runtime.Composer  int)void
    .registers 23
    # ins_size=5
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    move/from16 v3, v22
    const v4, 1623992668
    move-object/from16 v5, v21
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v5
    and-int/lit8 v6, v3, 6
    const/4 v7, 4
    if-nez v6, +00dh
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v6, v7
    goto +2h
    const/4 v6, 2
    or-int/2addr v6, v3
    goto +2h
    move v6, v3
    and-int/lit8 v8, v3, 48
    const/16 v9, 16
    if-nez v8, +00dh
    invoke-interface v5, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 32
    goto +2h
    move v8, v9
    or-int/2addr v6, v8
    and-int/lit16 v8, v3, 384
    if-nez v8, +00eh
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +005h
    const/16 v8, 256
    goto +3h
    const/16 v8, 128
    or-int/2addr v6, v8
    and-int/lit16 v8, v6, 147
    const/16 v10, 146
    if-ne v8, v10, +00eh
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v8
    if-nez v8, +003h
    goto +6h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +146h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v8
    if-eqz v8, +008h
    const/4 v8, -1
    const-string v10, "com.bytedance.trae.home.solo.setting.ui.AboutItemsGroup (SettingsAbout.kt:126)"
    invoke-static v4, v6, v8, v10, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    invoke-interface/range v18, Ljava/util/List;->isEmpty()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v4
    if-eqz v4, +00ah
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda3;
    invoke-direct v5, v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda3;-><init>(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; I)V
    invoke-interface v4, v5, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    const/4 v8, 0
    const/4 v10, 1
    const/4 v11, 0
    invoke-static v4, v8, v10, v11, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    int-to-float v9, v9
    invoke-static v9, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v9
    invoke-static v9, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v9
    check-cast v9, Landroidx/compose/ui/graphics/Shape;
    invoke-static v4, v9, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v12
    invoke-virtual/range v19, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getSurface-0d7_KjU()J
    move-result-wide v13
    const/4 v15, 0
    const/16 v16, 2
    const/16 v17, 0
    invoke-static/range v12 ... v17, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    int-to-float v7, v7
    invoke-static v7, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static v4, v8, v7, v10, v11, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    const v7, 1341605231
    const-string v8, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v5, v7, v8, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v7, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v7, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v7
    sget-object v8, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v8, Landroidx/compose/ui/Alignment$Companion;->getStart()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v8
    const/4 v9, 0
    invoke-static v7, v8, v5, v9, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v7
    const v8, -1159599143
    const-string v10, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v5, v8, v10, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v5, v9, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v8
    invoke-static v8, v9, Ljava/lang/Long;->hashCode(J)I
    move-result v8
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v5, v4, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v4
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v10
    const v11, -553112988
    const-string v12, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v5, v11, v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v11
    instance-of v11, v11, Landroidx/compose/runtime/Applier;
    if-nez v11, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-eqz v11, +006h
    invoke-interface v5, v10, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v5, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v10
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v10, v7, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v10, v9, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v10, v8, v7, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v10, v4, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v4, 2093002350
    const-string v7, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v5, v4, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v4, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v4, Landroidx/compose/foundation/layout/ColumnScope;
    const v4, -1910951697
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    move-object v4, v0
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +011h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;
    and-int/lit8 v8, v6, 112
    and-int/lit16 v9, v6, 896
    or-int/2addr v8, v9
    invoke-static v7, v1, v2, v5, v8, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutRow(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    goto -14h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v5, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v4
    if-eqz v4, +00ah
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda4;
    invoke-direct v5, v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda4;-><init>(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; I)V
    invoke-interface v4, v5, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final AboutItemsGroup$lambda$6(java.util.List  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v3, v3, 1
    invoke-static v3, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v3
    invoke-static v0, v1, v2, v4, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemsGroup(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final AboutItemsGroup$lambda$9(java.util.List  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v3, v3, 1
    invoke-static v3, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v3
    invoke-static v0, v1, v2, v4, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemsGroup(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final AboutLogo(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  androidx.compose.runtime.Composer  int)void
    .registers 14
    # ins_size=3
    const v0, 994506512
    invoke-interface v12, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v12
    and-int/lit8 v1, v13, 6
    const/4 v2, 2
    if-nez v1, +00dh
    invoke-interface v12, v11, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    move v1, v2
    or-int/2addr v1, v13
    goto +2h
    move v1, v13
    and-int/lit8 v3, v1, 3
    if-ne v3, v2, +00eh
    invoke-interface v12, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v2
    if-nez v2, +003h
    goto +6h
    invoke-interface v12, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +123h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +008h
    const/4 v2, -1
    const-string v3, "com.bytedance.trae.home.solo.setting.ui.AboutLogo (SettingsAbout.kt:104)"
    invoke-static v0, v1, v2, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/16 v1, 96
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    invoke-static v0, v1, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const/16 v1, 24
    int-to-float v1, v1
    invoke-static v1, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v1
    invoke-static v1, Landroidx/compose/foundation/shape/RoundedCornerShapeKt;->RoundedCornerShape-0680j_4(F)Landroidx/compose/foundation/shape/RoundedCornerShape;
    move-result-object v1
    check-cast v1, Landroidx/compose/ui/graphics/Shape;
    invoke-static v0, v1, Landroidx/compose/ui/draw/ClipKt;->clip(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;
    move-result-object v2
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getLogoBackground-0d7_KjU()J
    move-result-wide v3
    const/4 v5, 0
    const/4 v6, 2
    const/4 v7, 0
    invoke-static/range v2 ... v7, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v1, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v1, Landroidx/compose/ui/Alignment$Companion;->getCenter()Landroidx/compose/ui/Alignment;
    move-result-object v1
    const v2, 1042775818
    const-string v3, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo"
    invoke-static v12, v2, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v2, 0
    invoke-static v1, v2, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v1
    const v3, -1159599143
    const-string v4, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v12, v3, v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v12, v2, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v3
    invoke-static v3, v4, Ljava/lang/Long;->hashCode(J)I
    move-result v3
    invoke-interface v12, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v4
    invoke-static v12, v0, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v0
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v5
    const v6, -553112988
    const-string v7, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v12, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v12, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v6
    instance-of v6, v6, Landroidx/compose/runtime/Applier;
    if-nez v6, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v12, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v12, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-eqz v6, +006h
    invoke-interface v12, v5, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v12, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v12, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v5, v1, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-static v5, v4, v1, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v4
    if-nez v4, +010h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v4
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +010h
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v5, v3, v1, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v1, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v1, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-static v5, v0, v1, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 1833054614
    const-string v1, "C72@3469L9:Box.kt#2w3rfo"
    invoke-static v12, v0, v1, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/BoxScope;
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_trae_color(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    invoke-static v0, v12, v2, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v1
    const/4 v2, 0
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    const/16 v3, 64
    int-to-float v3, v3
    invoke-static v3, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v3
    invoke-static v0, v3, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v3
    const/4 v4, 0
    sget-object v0, Landroidx/compose/ui/layout/ContentScale;->Companion Landroidx/compose/ui/layout/ContentScale$Companion;
    invoke-virtual v0, Landroidx/compose/ui/layout/ContentScale$Companion;->getFit()Landroidx/compose/ui/layout/ContentScale;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/16 v9, 25008
    const/16 v10, 104
    move-object v8, v12
    invoke-static/range v1 ... v10, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-static v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v12, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v12, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v12
    if-eqz v12, +00ah
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda0;
    invoke-direct v0, v11, v13, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; I)V
    invoke-interface v12, v0, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final AboutLogo$lambda$5(com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 4
    # ins_size=4
    or-int/lit8 v1, v1, 1
    invoke-static v1, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v1
    invoke-static v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutLogo(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final AboutRow(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  androidx.compose.runtime.Composer  int)void
    .registers 36
    # ins_size=5
    move-object/from16 v0, v31
    move-object/from16 v1, v32
    move-object/from16 v2, v33
    move/from16 v3, v35
    const v4, -1426957212
    move-object/from16 v5, v34
    invoke-interface v5, v4, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v5
    and-int/lit8 v6, v3, 6
    const/4 v7, 4
    if-nez v6, +016h
    and-int/lit8 v6, v3, 8
    if-nez v6, +007h
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v6
    goto +5h
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v6, v7
    goto +2h
    const/4 v6, 2
    or-int/2addr v6, v3
    goto +2h
    move v6, v3
    and-int/lit8 v9, v3, 48
    const/16 v10, 16
    if-nez v9, +00dh
    invoke-interface v5, v1, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +005h
    const/16 v9, 32
    goto +2h
    move v9, v10
    or-int/2addr v6, v9
    and-int/lit16 v9, v3, 384
    const/16 v11, 256
    if-nez v9, +00dh
    invoke-interface v5, v2, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +004h
    move v9, v11
    goto +3h
    const/16 v9, 128
    or-int/2addr v6, v9
    and-int/lit16 v9, v6, 147
    const/16 v12, 146
    if-ne v9, v12, +00fh
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v9
    if-nez v9, +003h
    goto +7h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object v15, v5
    goto/16 +1f6h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v9
    if-eqz v9, +008h
    const/4 v9, -1
    const-string v12, "com.bytedance.trae.home.solo.setting.ui.AboutRow (SettingsAbout.kt:150)"
    invoke-static v4, v6, v9, v12, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v9, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v4, v5, v9, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v4
    invoke-virtual/range v31, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    move-result-object v9
    invoke-static v9, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->titleResource(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v9
    const/4 v14, 0
    new-array v12, v14, [Ljava/lang/Object;
    invoke-static v9, v12, v5, v14, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v15
    invoke-virtual/range v31, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem;->getKey()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;
    move-result-object v9
    const v12, 456372021
    invoke-interface v5, v12, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v5, v9, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v9
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    const/4 v13, 1
    const/4 v14, 0
    if-nez v9, +00ah
    sget-object v9, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v9, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v9
    if-ne v12, v9, +00ah
    new-instance v12, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-direct v12, v14, v13, v14, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;-><init>(Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v12, Lcom/bytedance/trae/kmp/ui/KmpClickHandler;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    sget-object v9, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v9, Landroidx/compose/ui/Modifier;
    const/4 v8, 0
    invoke-static v9, v8, v13, v14, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    sget v13, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemHeight F
    invoke-static v9, v13, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v9
    const v13, 456378021
    invoke-interface v5, v13, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    and-int/lit16 v13, v6, 896
    if-ne v13, v11, +004h
    const/4 v11, 1
    goto +2h
    const/4 v11, 0
    and-int/lit8 v13, v6, 14
    if-eq v13, v7, +00fh
    and-int/lit8 v6, v6, 8
    if-eqz v6, +009h
    invoke-interface v5, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +3h
    const/4 v13, 0
    goto +2h
    const/4 v13, 1
    or-int v6, v11, v13
    invoke-interface v5, v15, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v7
    or-int/2addr v6, v7
    invoke-interface v5, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v6, +00ah
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v7, v6, +00ah
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda1;
    invoke-direct v7, v2, v0, v15, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function2; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Ljava/lang/String;)V
    invoke-interface v5, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v7, Lkotlin/jvm/functions/Function0;
    invoke-interface v5, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v9, v12, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt;->noRippleClickable(Landroidx/compose/ui/Modifier; Lcom/bytedance/trae/kmp/ui/KmpClickHandler; Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    int-to-float v13, v10
    invoke-static v13, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    const/4 v9, 2
    invoke-static v6, v7, v8, v9, v14, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    sget-object v7, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v7, Landroidx/compose/ui/Alignment$Companion;->getCenterVertically()Landroidx/compose/ui/Alignment$Vertical;
    move-result-object v7
    const v8, 844473419
    const-string v9, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo"
    invoke-static v5, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v8, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v8, Landroidx/compose/foundation/layout/Arrangement;->getStart()Landroidx/compose/foundation/layout/Arrangement$Horizontal;
    move-result-object v8
    const/16 v9, 48
    invoke-static v8, v7, v5, v9, Landroidx/compose/foundation/layout/RowKt;->rowMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Horizontal; Landroidx/compose/ui/Alignment$Vertical; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v7
    const v8, -1159599143
    const-string v9, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v5, v8, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    const/4 v14, 0
    invoke-static v5, v14, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v8
    invoke-static v8, v9, Ljava/lang/Long;->hashCode(J)I
    move-result v8
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v5, v6, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v10
    const v11, -553112988
    const-string v12, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v5, v11, v12, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v11
    instance-of v11, v11, Landroidx/compose/runtime/Applier;
    if-nez v11, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v5, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-eqz v11, +006h
    invoke-interface v5, v10, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v5, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v5, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v10
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v10, v7, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v10, v9, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v10, v8, v7, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v7, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v7, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v7
    invoke-static v10, v6, v7, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v6, 1456264949
    const-string v7, "C101@5233L9:Row.kt#2w3rfo"
    invoke-static v5, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v6, Landroidx/compose/foundation/layout/RowScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/RowScopeInstance;
    move-object/from16 v16, v6
    check-cast v16, Landroidx/compose/foundation/layout/RowScope;
    invoke-virtual/range v32, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getPrimaryText-0d7_KjU()J
    move-result-wide v7
    invoke-virtual v4, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodyBase()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    move-object/from16 v17, v4
    check-cast v17, Landroidx/compose/ui/Modifier;
    const/high16 v18, 1065353216
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/foundation/layout/RowScope;->weight$default(Landroidx/compose/foundation/layout/RowScope; Landroidx/compose/ui/Modifier; F Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v6
    sget-object v4, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v4, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v20
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v4, 0
    move/from16 v30, v13
    move-object v13, v4
    const-wide/16 v16, 0
    move-object v4, v15
    move-wide/from16 v14, v16
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const/16 v21, 0
    const/16 v22, 1
    const/16 v23, 0
    const/16 v24, 0
    const/16 v27, 0
    const/16 v28, 3120
    const v29, 55288
    move-object/from16 v34, v5
    move-object v5, v4
    move-object/from16 v26, v34
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v4, Lcom/bytedance/trae/home/generated/resources/Res$drawable;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$drawable;
    invoke-static v4, Lcom/bytedance/trae/home/generated/resources/Drawable0_commonMainKt;->getCmp_ic_setting_chevron_right(Lcom/bytedance/trae/home/generated/resources/Res$drawable;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v4
    move-object/from16 v15, v34
    const/4 v5, 0
    invoke-static v4, v15, v5, Lorg/jetbrains/compose/resources/ImageResources_androidKt;->painterResource(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/graphics/painter/Painter;
    move-result-object v5
    const/4 v6, 0
    sget-object v4, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v4, Landroidx/compose/ui/Modifier;
    invoke-static/range v30, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static v4, v7, Landroidx/compose/foundation/layout/SizeKt;->size-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    sget-object v16, Landroidx/compose/ui/graphics/ColorFilter;->Companion Landroidx/compose/ui/graphics/ColorFilter$Companion;
    invoke-virtual/range v32, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getIconTertiary-0d7_KjU()J
    move-result-wide v17
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/ui/graphics/ColorFilter$Companion;->tint-xETnrds$default(Landroidx/compose/ui/graphics/ColorFilter$Companion; J I I Ljava/lang/Object;)Landroidx/compose/ui/graphics/ColorFilter;
    move-result-object v11
    const/16 v13, 432
    const/16 v14, 56
    move-object v12, v15
    invoke-static/range v5 ... v14, Landroidx/compose/foundation/ImageKt;->Image(Landroidx/compose/ui/graphics/painter/Painter; Ljava/lang/String; Landroidx/compose/ui/Modifier; Landroidx/compose/ui/Alignment; Landroidx/compose/ui/layout/ContentScale; F Landroidx/compose/ui/graphics/ColorFilter; Landroidx/compose/runtime/Composer; I I)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v4
    if-eqz v4, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v4
    if-eqz v4, +00ah
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda2;
    invoke-direct v5, v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; I)V
    invoke-interface v4, v5, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final AboutRow$lambda$12$lambda$11(kotlin.jvm.functions.Function2  com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-interface v0, v1, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final AboutRow$lambda$14(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItem  com.bytedance.trae.home.solo.setting.ui.SettingsEntryPalette  kotlin.jvm.functions.Function2  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 6
    # ins_size=6
    or-int/lit8 v3, v3, 1
    invoke-static v3, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v3
    invoke-static v0, v1, v2, v4, v3, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutRow(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItem; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public static final SettingsAboutContent(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState  androidx.compose.ui.Modifier  kotlin.jvm.functions.Function2  androidx.compose.runtime.Composer  int  int)void
    .registers 39
    # ins_size=6
    move-object/from16 v1, v33
    move-object/from16 v3, v35
    move/from16 v4, v37
    const-string/jumbo v0, state
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onItemClick"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 170214363
    move-object/from16 v2, v36
    invoke-interface v2, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v2
    and-int/lit8 v5, v38, 1
    const/4 v6, 2
    if-eqz v5, +005h
    or-int/lit8 v5, v4, 6
    goto +11h
    and-int/lit8 v5, v4, 6
    if-nez v5, +00dh
    invoke-interface v2, v1, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +004h
    const/4 v5, 4
    goto +2h
    move v5, v6
    or-int/2addr v5, v4
    goto +2h
    move v5, v4
    and-int/lit8 v7, v38, 2
    const/16 v8, 16
    if-eqz v7, +005h
    or-int/lit8 v5, v5, 48
    goto +13h
    and-int/lit8 v9, v4, 48
    if-nez v9, +010h
    move-object/from16 v9, v34
    invoke-interface v2, v9, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +005h
    const/16 v10, 32
    goto +2h
    move v10, v8
    or-int/2addr v5, v10
    goto +3h
    move-object/from16 v9, v34
    and-int/lit8 v10, v38, 4
    if-eqz v10, +005h
    or-int/lit16 v5, v5, 384
    goto +11h
    and-int/lit16 v10, v4, 384
    if-nez v10, +00eh
    invoke-interface v2, v3, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +005h
    const/16 v10, 256
    goto +3h
    const/16 v10, 128
    or-int/2addr v5, v10
    move v15, v5
    and-int/lit16 v5, v15, 147
    const/16 v10, 146
    if-ne v5, v10, +010h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v5
    if-nez v5, +003h
    goto +8h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    move-object/from16 v31, v9
    goto/16 +214h
    if-eqz v7, +008h
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    move-object v13, v5
    goto +2h
    move-object v13, v9
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v5
    if-eqz v5, +008h
    const/4 v5, -1
    const-string v7, "com.bytedance.trae.home.solo.setting.ui.SettingsAboutContent (SettingsAbout.kt:61)"
    invoke-static v0, v15, v5, v7, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsScaffoldKt;->settingsEntryPalette(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;
    move-result-object v12
    const/4 v11, 1
    invoke-static v0, v2, v0, v11, Landroidx/compose/foundation/ScrollKt;->rememberScrollState(I Landroidx/compose/runtime/Composer; I I)Landroidx/compose/foundation/ScrollState;
    move-result-object v17
    const/4 v5, 0
    const/4 v7, 0
    invoke-static v13, v5, v11, v7, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v18
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getBackground-0d7_KjU()J
    move-result-wide v19
    const/16 v21, 0
    const/16 v22, 2
    const/16 v23, 0
    invoke-static/range v18 ... v23, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 14
    const/16 v22, 0
    invoke-static/range v16 ... v22, Landroidx/compose/foundation/ScrollKt;->verticalScroll$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Z Landroidx/compose/foundation/gestures/FlingBehavior; Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v9
    int-to-float v8, v8
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v10
    invoke-static v9, v10, v5, v6, v7, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4$default(Landroidx/compose/ui/Modifier; F F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const v6, -1388963199
    invoke-interface v2, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    sget-object v9, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v9, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v9
    if-ne v6, v9, +00ah
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda5;
    invoke-direct v6, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda5;-><init>()V
    invoke-interface v2, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lkotlin/jvm/functions/Function1;
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v5, v0, v6, v11, v7, Landroidx/compose/ui/semantics/SemanticsModifierKt;->semantics$default(Landroidx/compose/ui/Modifier; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v6, Landroidx/compose/ui/Alignment$Companion;->getCenterHorizontally()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v6
    const v7, 1341605231
    const-string v9, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v2, v7, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v7, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v7, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v7
    const/16 v9, 48
    invoke-static v7, v6, v2, v9, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v6
    const v7, -1159599143
    const-string v9, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v2, v7, v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v2, v0, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v9
    invoke-static v9, v10, Ljava/lang/Long;->hashCode(J)I
    move-result v7
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v9
    invoke-static v2, v5, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v5
    sget-object v10, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v10, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v10
    const v11, -553112988
    const-string v14, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v2, v11, v14, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v11
    instance-of v11, v11, Landroidx/compose/runtime/Applier;
    if-nez v11, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v11
    if-eqz v11, +006h
    invoke-interface v2, v10, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v2, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v2, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v10
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v10, v6, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v10, v9, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-interface v10, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v9
    if-nez v9, +010h
    invoke-interface v10, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v9
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v9, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +010h
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v9
    invoke-interface v10, v9, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-interface v10, v7, v6, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v10, v5, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v5, 2093002350
    const-string v6, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v2, v5, v6, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v5, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v5, Landroidx/compose/foundation/layout/ColumnScope;
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    const/16 v6, 20
    int-to-float v6, v6
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    const/4 v14, 6
    invoke-static v5, v2, v14, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-static v12, v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutLogo(Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Landroidx/compose/runtime/Composer; I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-static v8, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v2, v14, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v5, Lcom/bytedance/trae/design/compose/TraeTheme;->INSTANCE Lcom/bytedance/trae/design/compose/TraeTheme;
    sget v6, Lcom/bytedance/trae/design/compose/TraeTheme;->$stable I
    invoke-virtual v5, v2, v6, Lcom/bytedance/trae/design/compose/TraeTheme;->getTypography(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/design/compose/TraeTypography;
    move-result-object v30
    invoke-virtual/range v33, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->getAppName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getPrimaryText-0d7_KjU()J
    move-result-wide v7
    invoke-virtual/range v30, Lcom/bytedance/trae/design/compose/TraeTypography;->getHeadingXlStrong()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    sget-object v6, Landroidx/compose/ui/text/style/TextOverflow;->Companion Landroidx/compose/ui/text/style/TextOverflow$Companion;
    invoke-virtual v6, Landroidx/compose/ui/text/style/TextOverflow$Companion;->getEllipsis-gIe3tQ8()I
    move-result v20
    const/4 v6, 0
    const-wide/16 v9, 0
    const/4 v11, 0
    const/4 v0, 1
    const/16 v16, 0
    move-object/from16 v34, v12
    move-object/from16 v12, v16
    move-object/from16 v31, v13
    move-object/from16 v13, v16
    const-wide/16 v16, 0
    move/from16 v32, v15
    const/4 v0, 4
    move-wide/from16 v14, v16
    const/16 v16, 0
    const/16 v17, 0
    const-wide/16 v18, 0
    const/16 v21, 0
    const/16 v22, 1
    const/16 v23, 0
    const/16 v24, 0
    const/16 v27, 0
    const/16 v28, 3120
    const v29, 55290
    move-object/from16 v26, v2
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    invoke-static v5, v0, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const/4 v14, 6
    invoke-static v0, v2, v14, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v0, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_version(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v0
    const/4 v5, 1
    new-array v5, v5, [Ljava/lang/Object;
    invoke-virtual/range v33, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->getVersionName()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    aput-object v6, v5, v7
    invoke-static v0, v5, v2, v7, Lcom/bytedance/trae/kmp/ui/KmpStringResource_androidKt;->kmpStringResource(Lorg/jetbrains/compose/resources/StringResource; [Ljava/lang/Object; Landroidx/compose/runtime/Composer; I)Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    invoke-virtual/range v34, Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;->getTertiaryText-0d7_KjU()J
    move-result-wide v7
    const/4 v12, 0
    const/4 v13, 0
    const-wide/16 v15, 0
    move v0, v14
    move-wide v14, v15
    const/16 v16, 0
    const/16 v20, 0
    const/16 v22, 0
    invoke-virtual/range v30, Lcom/bytedance/trae/design/compose/TraeTypography;->getBodySm()Landroidx/compose/ui/text/TextStyle;
    move-result-object v25
    const/16 v28, 0
    const v29, 65530
    invoke-static/range v5 ... v29, Landroidx/compose/material3/TextKt;->Text--4IGK_g(Ljava/lang/String; Landroidx/compose/ui/Modifier; J J Landroidx/compose/ui/text/font/FontStyle; Landroidx/compose/ui/text/font/FontWeight; Landroidx/compose/ui/text/font/FontFamily; J Landroidx/compose/ui/text/style/TextDecoration; Landroidx/compose/ui/text/style/TextAlign; J I Z I I Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/text/TextStyle; Landroidx/compose/runtime/Composer; I I I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    const/16 v6, 40
    int-to-float v6, v6
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v7
    invoke-static v5, v7, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v2, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-virtual/range v33, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;->getItems()Ljava/util/List;
    move-result-object v5
    move/from16 v7, v32
    and-int/lit16 v7, v7, 896
    move-object/from16 v8, v34
    invoke-static v5, v8, v3, v2, v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->AboutItemsGroup(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I)V
    sget-object v5, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v5, Landroidx/compose/ui/Modifier;
    invoke-static v6, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v6
    invoke-static v5, v6, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v5
    invoke-static v5, v2, v0, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    invoke-interface v2, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v6
    if-eqz v6, +015h
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda6;
    move-object v0, v7
    move-object/from16 v1, v33
    move-object/from16 v2, v31
    move-object/from16 v3, v35
    move/from16 v4, v37
    move/from16 v5, v38
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState; Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function2; I I)V
    invoke-interface v6, v7, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final SettingsAboutContent$lambda$1$lambda$0(androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$semantics"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cmp_settings_about_root"
    invoke-static v1, v0, Landroidx/compose/ui/semantics/SemanticsPropertiesKt;->setContentDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final SettingsAboutContent$lambda$3(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutState  androidx.compose.ui.Modifier  kotlin.jvm.functions.Function2  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 13
    # ins_size=7
    or-int/lit8 v9, v9, 1
    invoke-static v9, Landroidx/compose/runtime/RecomposeScopeImplKt;->updateChangedFlags(I)I
    move-result v4
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v11
    move v5, v10
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt;->SettingsAboutContent(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState; Landroidx/compose/ui/Modifier; Lkotlin/jvm/functions/Function2; Landroidx/compose/runtime/Composer; I I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method private static final titleResource(com.bytedance.trae.home.solo.setting.viewmodel.SettingsAboutItemKey)org.jetbrains.compose.resources.StringResource
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/ui/SettingsAboutKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;->ordinal()I
    move-result v1
    aget v1, v0, v1
    packed-switch v1, +0000056h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_permission_usage(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +46h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_icp_filing(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +3fh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_business_license(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +38h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_share_list(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +31h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_personal_info_list(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +2ah
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_contact(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +23h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_community(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +1ch
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_help(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +15h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_opensource(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +eh
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_privacy(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    goto +7h
    sget-object v1, Lcom/bytedance/trae/home/generated/resources/Res$string;->INSTANCE Lcom/bytedance/trae/home/generated/resources/Res$string;
    invoke-static v1, Lcom/bytedance/trae/home/generated/resources/String0_commonMainKt;->getTrae_setting_about_terms(Lcom/bytedance/trae/home/generated/resources/Res$string;)Lorg/jetbrains/compose/resources/StringResource;
    move-result-object v1
    return-object v1
    packed-switch-payload 1 2 3 4 5 6 7 8 9 a b
.end method
