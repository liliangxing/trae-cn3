# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1$1;
.super Ljava/lang/Object;
.source "TraeCmpContentFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic this$0:Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;


.method constructor <init>(com.bytedance.trae.kmp.cmp.TraeCmpContentFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1$1;->this$0 Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Landroidx/compose/runtime/Composer;
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1$1;->invoke(Landroidx/compose/runtime/Composer; I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(androidx.compose.runtime.Composer  int)void
    .registers 11
    # ins_size=3
    and-int/lit8 v0, v10, 3
    const/4 v1, 2
    if-ne v0, v1, +00eh
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v0
    if-nez v0, +003h
    goto +6h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +0e4h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v2, "com.bytedance.trae.kmp.cmp.TraeCmpContentFragment.onViewCreated.<anonymous>.<anonymous>.<anonymous> (TraeCmpContentFragment.kt:71)"
    const v3, 313320857
    invoke-static v3, v10, v0, v2, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    sget-object v10, Landroidx/compose/ui/Modifier;->Companion Landroidx/compose/ui/Modifier$Companion;
    check-cast v10, Landroidx/compose/ui/Modifier;
    const/4 v0, 0
    const/4 v2, 1
    const/4 v3, 0
    invoke-static v10, v0, v2, v3, Landroidx/compose/foundation/layout/SizeKt;->fillMaxSize$default(Landroidx/compose/ui/Modifier; F I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    const/4 v0, 0
    invoke-static v3, v9, v0, v2, Landroidx/compose/ui/platform/NestedScrollInteropConnectionKt;->rememberNestedScrollInteropConnection(Landroid/view/View; Landroidx/compose/runtime/Composer; I I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;
    move-result-object v2
    invoke-static v10, v2, v3, v1, v3, Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierKt;->nestedScroll$default(Landroidx/compose/ui/Modifier; Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection; Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher; I Ljava/lang/Object;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    iget-object v1, v8, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment$onViewCreated$2$1$1;->this$0 Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;
    const v2, 733328855
    const-string v3, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo"
    invoke-static v9, v2, v3, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v2, Landroidx/compose/ui/Alignment;->Companion Landroidx/compose/ui/Alignment$Companion;
    invoke-virtual v2, Landroidx/compose/ui/Alignment$Companion;->getTopStart()Landroidx/compose/ui/Alignment;
    move-result-object v2
    invoke-static v2, v0, Landroidx/compose/foundation/layout/BoxKt;->maybeCachedBoxMeasurePolicy(Landroidx/compose/ui/Alignment; Z)Landroidx/compose/ui/layout/MeasurePolicy;
    move-result-object v2
    const v3, -1323940314
    const-string v4, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh"
    invoke-static v9, v3, v4, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-static v9, v0, Landroidx/compose/runtime/ComposablesKt;->getCurrentCompositeKeyHash(Landroidx/compose/runtime/Composer; I)I
    move-result v3
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getCurrentCompositionLocalMap()Landroidx/compose/runtime/CompositionLocalMap;
    move-result-object v4
    invoke-static v9, v10, Landroidx/compose/ui/ComposedModifierKt;->materializeModifier(Landroidx/compose/runtime/Composer; Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;
    move-result-object v10
    sget-object v5, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v5, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getConstructor()Lkotlin/jvm/functions/Function0;
    move-result-object v5
    const v6, -692256719
    const-string v7, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp"
    invoke-static v9, v6, v7, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getApplier()Landroidx/compose/runtime/Applier;
    move-result-object v6
    instance-of v6, v6, Landroidx/compose/runtime/Applier;
    if-nez v6, +005h
    invoke-static Landroidx/compose/runtime/ComposablesKt;->invalidApplier()V
    invoke-interface v9, Landroidx/compose/runtime/Composer;->startReusableNode()V
    invoke-interface v9, Landroidx/compose/runtime/Composer;->getInserting()Z
    move-result v6
    if-eqz v6, +006h
    invoke-interface v9, v5, Landroidx/compose/runtime/Composer;->createNode(Lkotlin/jvm/functions/Function0;)V
    goto +4h
    invoke-interface v9, Landroidx/compose/runtime/Composer;->useNode()V
    invoke-static v9, Landroidx/compose/runtime/Updater;->constructor-impl(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;
    move-result-object v5
    sget-object v6, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v6, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetMeasurePolicy()Lkotlin/jvm/functions/Function2;
    move-result-object v6
    invoke-static v5, v2, v6, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetResolvedCompositionLocals()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v5, v4, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetCompositeKeyHash()Lkotlin/jvm/functions/Function2;
    move-result-object v2
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
    invoke-interface v5, v3, v2, Landroidx/compose/runtime/Composer;->apply(Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    sget-object v2, Landroidx/compose/ui/node/ComposeUiNode;->Companion Landroidx/compose/ui/node/ComposeUiNode$Companion;
    invoke-virtual v2, Landroidx/compose/ui/node/ComposeUiNode$Companion;->getSetModifier()Lkotlin/jvm/functions/Function2;
    move-result-object v2
    invoke-static v5, v10, v2, Landroidx/compose/runtime/Updater;->set-impl(Landroidx/compose/runtime/Composer; Ljava/lang/Object; Lkotlin/jvm/functions/Function2;)V
    const v10, -2146769399
    const-string v2, "C73@3429L9:Box.kt#2w3rfo"
    invoke-static v9, v10, v2, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerStart(Landroidx/compose/runtime/Composer; I Ljava/lang/String;)V
    sget-object v10, Landroidx/compose/foundation/layout/BoxScopeInstance;->INSTANCE Landroidx/compose/foundation/layout/BoxScopeInstance;
    check-cast v10, Landroidx/compose/foundation/layout/BoxScope;
    invoke-virtual v1, v9, v0, Lcom/bytedance/trae/kmp/cmp/TraeCmpContentFragment;->RenderCmpContent(Landroidx/compose/runtime/Composer; I)V
    invoke-static v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-interface v9, Landroidx/compose/runtime/Composer;->endNode()V
    invoke-static v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static v9, Landroidx/compose/runtime/ComposerKt;->sourceInformationMarkerEnd(Landroidx/compose/runtime/Composer;)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v9
    if-eqz v9, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-void 
.end method
