# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;
.super Ljava/lang/Object;
.source "ConnectComputerGuidePage.kt"

.field private static final ConnectComputerGuideHorizontalPadding:F
.field private static final ConnectComputerGuideVerticalPadding:F


.method public static synthetic $r8$lambda$6GYgLGxvaj0lAZjM5E1ZuLI4c5k(androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideContent$lambda$1$lambda$0(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$leDoweE2aL-DdsIH1FZjfd5PnhA(java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideContent$lambda$3(Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    const/16 v0, 16
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideHorizontalPadding F
    const/16 v0, 24
    int-to-float v0, v0
    invoke-static v0, Landroidx/compose/ui/unit/Dp;->constructor-impl(F)F
    move-result v0
    sput v0, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideVerticalPadding F
    return-void 
.end method

.method public static final ConnectComputerGuideContent(java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  androidx.compose.runtime.Composer  int  int)void
    .registers 35
    # ins_size=6
    move-object/from16 v6, v29
    move-object/from16 v7, v30
    move/from16 v8, v33
    const-string v0, "displayUrl"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onCopyUrl"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const v0, 274879062
    move-object/from16 v1, v32
    invoke-interface v1, v0, Landroidx/compose/runtime/Composer;->startRestartGroup(I)Landroidx/compose/runtime/Composer;
    move-result-object v15
    and-int/lit8 v1, v34, 1
    if-eqz v1, +005h
    or-int/lit8 v1, v8, 6
    goto +11h
    and-int/lit8 v1, v8, 6
    if-nez v1, +00dh
    invoke-interface v15, v6, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 4
    goto +2h
    const/4 v1, 2
    or-int/2addr v1, v8
    goto +2h
    move v1, v8
    and-int/lit8 v2, v34, 2
    if-eqz v2, +005h
    or-int/lit8 v1, v1, 48
    goto +11h
    and-int/lit8 v2, v8, 48
    if-nez v2, +00eh
    invoke-interface v15, v7, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    const/16 v2, 32
    goto +3h
    const/16 v2, 16
    or-int/2addr v1, v2
    and-int/lit8 v2, v34, 4
    if-eqz v2, +005h
    or-int/lit16 v1, v1, 384
    goto +14h
    and-int/lit16 v3, v8, 384
    if-nez v3, +011h
    move-object/from16 v3, v31
    invoke-interface v15, v3, Landroidx/compose/runtime/Composer;->changed(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v4, 256
    goto +3h
    const/16 v4, 128
    or-int/2addr v1, v4
    goto +3h
    move-object/from16 v3, v31
    and-int/lit16 v4, v1, 147
    const/16 v5, 146
    if-ne v4, v5, +00eh
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v4
    if-nez v4, +003h
    goto +6h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +17bh
    if-eqz v2, +008h
    sget-object v2, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v2, Landroidx/compose/ui/Modifier;
    move-object v5, v2
    goto +2h
    move-object v5, v3
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v2
    if-eqz v2, +008h
    const/4 v2, -1
    const-string v3, "com.bytedance.trae.home.solo.setting.ui.ConnectComputerGuideContent (ConnectComputerGuidePage.kt:28)"
    invoke-static v0, v1, v2, v3, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    const/4 v0, 0
    invoke-static v15, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->deviceManagementPalette(Landroidx/compose/runtime/Composer; I)Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 1
    const/4 v9, 0
    invoke-static v5, v3, v4, v9, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v16
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette;->getBackground-0d7_KjU()J
    move-result-wide v17
    const/16 v19, 0
    const/16 v20, 2
    const/16 v21, 0
    invoke-static/range v16 ... v21, Landroidx/compose/foundation/BackgroundKt;->background-bw27NRU$default(Landroidx/compose/ui/Modifier; J Landroidx/compose/ui/graphics/Shape; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v22
    invoke-static v0, v15, v0, v4, Landroidx/compose/foundation/ScrollKt;->rememberScrollState(I Landroidx/compose/runtime/Composer; I I)Landroidx/compose/foundation/ScrollState;
    move-result-object v23
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 14
    const/16 v28, 0
    invoke-static/range v22 ... v28, Landroidx/compose/foundation/ScrollKt;->verticalScroll$default(Landroidx/compose/ui/Modifier; Landroidx/compose/foundation/ScrollState; Z Landroidx/compose/foundation/gestures/FlingBehavior; Z I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    sget v11, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideHorizontalPadding F
    sget v12, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideVerticalPadding F
    invoke-static v10, v11, v12, Landroidx/compose/foundation/layout/PaddingKt;->padding-VpY3zN4(Landroidx/compose/ui/Modifier; F F)Landroidx/compose/ui/Modifier;
    move-result-object v10
    const v11, 969526364
    invoke-interface v15, v11, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v11
    sget-object v12, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v12, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v12
    if-ne v11, v12, +00ah
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda0;
    invoke-direct v11, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda0;-><init>()V
    invoke-interface v15, v11, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v11, Lkotlin/jvm/functions/Function1;
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    invoke-static v10, v0, v11, v4, v9, Landroidx/compose/ui/semantics/SemanticsModifierKt;->semantics$default(Landroidx/compose/ui/Modifier; Z Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    sget-object v11, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v11, Landroidx/compose/ui/Alignment$Companion;->getCenterHorizontally()Landroidx/compose/ui/Alignment$Horizontal;
    move-result-object v11
    const v12, 1341605231
    const-string v13, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo"
    invoke-static v15, v12, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v12, Landroidx/compose/foundation/layout/Arrangement;->INSTANCE Landroidx/compose/foundation/layout/Arrangement;
    invoke-virtual v12, Landroidx/compose/foundation/layout/Arrangement;->getTop()Landroidx/compose/foundation/layout/Arrangement$Vertical;
    move-result-object v12
    const/16 v13, 48
    invoke-static v12, v11, v15, v13, Landroidx/compose/foundation/layout/ColumnKt;->columnMeasurePolicy(Landroidx/compose/foundation/layout/Arrangement$Vertical; Landroidx/compose/ui/Alignment$Horizontal; Landroidx/compose/runtime/Composer; I)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v11
    const v12, -1159599143
    const-string v13, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh"
    invoke-static v15, v12, v13, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v15, v0, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHashCode(Landroidx/compose/runtime/Composer; I)J
    move-result-wide v12
    invoke-static v12, v13, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v12
    invoke-static v15, v10, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    sget-object v13, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v13, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v13
    const v14, -553112988
    const-string v3, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp"
    invoke-static v15, v14, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v3
    instance-of v3, v3, Landroidx/compose/runtime/Applier;
    if-nez v3, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v3
    if-eqz v3, +006h
    invoke-interface v15, v13, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v15, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v15, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v3
    sget-object v13, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v13, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v13
    invoke-static v3, v11, v13, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-static v3, v12, v11, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v11, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v11, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v11
    invoke-interface v3, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v12
    if-nez v12, +010h
    invoke-interface v3, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v12
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-nez v12, +010h
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-interface v3, v12, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-interface v3, v0, v11, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v0, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v0, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v0
    invoke-static v3, v10, v0, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v0, 2093002350
    const-string v3, "C89@4557L9:Column.kt#2w3rfo"
    invoke-static v15, v0, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v0, Landroidx/compose/foundation/layout/ColumnScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/ColumnScopeInstance;
    check-cast v0, Landroidx/compose/foundation/layout/ColumnScope;
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->Work Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->guideHeroResource(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)Lorg/jetbrains/compose/resources/DrawableResource;
    move-result-object v0
    sget-object v3, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v3, Landroidx/compose/ui/Modifier;
    const/4 v10, 0
    invoke-static v3, v10, v4, v9, Landroidx/compose/foundation/layout/SizeKt;->fillMaxWidth$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v3
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->getDeviceGuideHeroHeight()F
    move-result v4
    invoke-static v3, v4, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v10
    const/4 v11, 0
    const/16 v13, 48
    const/4 v14, 4
    move-object v9, v0
    move-object v12, v15
    invoke-static/range v9 ... v14, Lcom/bytedance/trae/design/compose/TraeAnimatedGuideImageKt;->TraeAnimatedGuideImage-6a0pyJM(Lorg/jetbrains/compose/resources/DrawableResource; Landroidx/compose/ui/Modifier; F Landroidx/compose/runtime/Composer; I I)V
    sget-object v0, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v0, Landroidx/compose/ui/Modifier;
    invoke-static Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->getDeviceGuideStepsGap()F
    move-result v3
    invoke-static v0, v3, Landroidx/compose/foundation/layout/SizeKt;->height-3ABfNKs(Landroidx/compose/ui/Modifier; F)Landroidx/compose/ui/Modifier;
    move-result-object v0
    const/4 v3, 6
    invoke-static v0, v15, v3, Landroidx/compose/foundation/layout/SpacerKt;->Spacer(Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->Work Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    shl-int/lit8 v4, v1, 3
    and-int/lit8 v4, v4, 112
    or-int/2addr v4, v3
    shl-int/2addr v1, v3
    and-int/lit16 v1, v1, 7168
    or-int v9, v4, v1
    move-object/from16 v1, v29
    move-object/from16 v3, v30
    move-object v4, v15
    move-object v10, v5
    move v5, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->GuideSteps(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementPalette; Lkotlin/jvm/functions/Function0; Landroidx/compose/runtime/Composer; I)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v15, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    move-object v3, v10
    invoke-interface v15, Landroidx/compose/runtime/Composer;->endRestartGroup()Landroidx/compose/runtime/ScopeUpdateScope;
    move-result-object v9
    if-eqz v9, +013h
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;
    move-object v0, v10
    move-object/from16 v1, v29
    move-object/from16 v2, v30
    move/from16 v4, v33
    move/from16 v5, v34
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; I I)V
    invoke-interface v9, v10, Landroidx/compose/runtime/ScopeUpdateScope;->updateScope(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final ConnectComputerGuideContent$lambda$1$lambda$0(androidx.compose.ui.semantics.SemanticsPropertyReceiver)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$semantics"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cmp_connect_computer_guide_root"
    invoke-static v1, v0, Landroidx/compose/ui/semantics/SemanticsPropertiesKt;->setContentDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final ConnectComputerGuideContent$lambda$3(java.lang.String  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  int  int  androidx.compose.runtime.Composer  int)kotlin.Unit
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
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/ui/ConnectComputerGuidePageKt;->ConnectComputerGuideContent(Ljava/lang/String; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
