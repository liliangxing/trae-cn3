# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;


.method constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$0(androidx.compose.runtime.State)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState
    .registers 1
    # ins_size=1
    invoke-interface v0, Landroidx/compose/runtime/State;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Landroidx/compose/runtime/Composer;
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->invoke(Landroidx/compose/runtime/Composer; I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(androidx.compose.runtime.Composer  int)void
    .registers 16
    # ins_size=3
    and-int/lit8 v0, v15, 3
    const/4 v1, 2
    if-ne v0, v1, +00eh
    invoke-interface v14, Landroidx/compose/runtime/Composer;->getSkipping()Z
    move-result v0
    if-nez v0, +003h
    goto +6h
    invoke-interface v14, Landroidx/compose/runtime/Composer;->skipToGroupEnd()V
    goto/16 +185h
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v0
    if-eqz v0, +00bh
    const/4 v0, -1
    const-string v1, "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (VideoArtifactPreviewActivity.kt:58)"
    const v2, -132786844
    invoke-static v2, v15, v0, v1, Landroidx/compose/runtime/ComposerKt;->traceEventStart(I I I Ljava/lang/String;)V
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getPreviewViewModel$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    move-result-object v15
    const/4 v0, 0
    const-string/jumbo v1, previewViewModel
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v0
    invoke-virtual v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->getState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 7
    move-object v6, v14
    invoke-static/range v2 ... v8, Landroidx/lifecycle/compose/FlowExtKt;->collectAsStateWithLifecycle(Lkotlinx/coroutines/flow/StateFlow; Landroidx/lifecycle/LifecycleOwner; Landroidx/lifecycle/Lifecycle$State; Lkotlin/coroutines/CoroutineContext; Landroidx/compose/runtime/Composer; I I)Landroidx/compose/runtime/State;
    move-result-object v15
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->invoke$lambda$0(Landroidx/compose/runtime/State;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;
    move-result-object v2
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getPreviewViewModel$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v0
    const v3, -1564640322
    invoke-interface v14, v3, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v3
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v4
    if-nez v3, +00ah
    sget-object v3, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v3, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v3
    if-ne v4, v3, +00dh
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$1$1;
    invoke-direct v3, v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$1$1;-><init>(Ljava/lang/Object;)V
    move-object v4, v3
    check-cast v4, Lkotlin/reflect/KFunction;
    invoke-interface v14, v4, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v4, Lkotlin/reflect/KFunction;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v3, v4
    check-cast v3, Lkotlin/jvm/functions/Function1;
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getPreviewViewModel$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v0
    const v4, -1564637986
    invoke-interface v14, v4, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v4
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v5
    if-nez v4, +00ah
    sget-object v4, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v4, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v4
    if-ne v5, v4, +00dh
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$2$1;
    invoke-direct v4, v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$2$1;-><init>(Ljava/lang/Object;)V
    move-object v5, v4
    check-cast v5, Lkotlin/reflect/KFunction;
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v5, Lkotlin/reflect/KFunction;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v4, v5
    check-cast v4, Lkotlin/jvm/functions/Function1;
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getPreviewViewModel$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v0
    const v5, -1564635483
    invoke-interface v14, v5, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v5
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v6
    if-nez v5, +00ah
    sget-object v5, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v5, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v5
    if-ne v6, v5, +00dh
    new-instance v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$3$1;
    invoke-direct v5, v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$3$1;-><init>(Ljava/lang/Object;)V
    move-object v6, v5
    check-cast v6, Lkotlin/reflect/KFunction;
    invoke-interface v14, v6, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v6, Lkotlin/reflect/KFunction;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v5, v6
    check-cast v5, Lkotlin/jvm/functions/Function0;
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getPreviewViewModel$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v15, v0
    const v6, -1564632664
    invoke-interface v14, v6, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v6
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v7
    if-nez v6, +00ah
    sget-object v6, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v6, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v6
    if-ne v7, v6, +00dh
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$4$1;
    invoke-direct v6, v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$4$1;-><init>(Ljava/lang/Object;)V
    move-object v7, v6
    check-cast v7, Lkotlin/reflect/KFunction;
    invoke-interface v14, v7, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v7, Lkotlin/reflect/KFunction;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v6, v7
    check-cast v6, Lkotlin/jvm/functions/Function0;
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-static v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getPreviewViewModel$p(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    move-result-object v15
    if-nez v15, +006h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v0, v15
    const v15, -1564630214
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v15
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v15, +00ah
    sget-object v15, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v15, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v15
    if-ne v1, v15, +00dh
    new-instance v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$5$1;
    invoke-direct v15, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$5$1;-><init>(Ljava/lang/Object;)V
    move-object v1, v15
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v14, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function1;
    iget-object v15, v13, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    const v0, -1564628242
    invoke-interface v14, v0, Landroidx/compose/runtime/Composer;->startReplaceGroup(I)V
    invoke-interface v14, v15, Landroidx/compose/runtime/Composer;->changedInstance(Ljava/lang/Object;)Z
    move-result v0
    invoke-interface v14, Landroidx/compose/runtime/Composer;->rememberedValue()Ljava/lang/Object;
    move-result-object v1
    if-nez v0, +00ah
    sget-object v0, Landroidx/compose/runtime/Composer;->Companion Landroidx/compose/runtime/Composer$Companion;
    invoke-virtual v0, Landroidx/compose/runtime/Composer$Companion;->getEmpty()Ljava/lang/Object;
    move-result-object v0
    if-ne v1, v0, +00dh
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$6$1;
    invoke-direct v0, v15, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$onCreate$2$1$1$6$1;-><init>(Ljava/lang/Object;)V
    move-object v1, v0
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v14, v1, Landroidx/compose/runtime/Composer;->updateRememberedValue(Ljava/lang/Object;)V
    check-cast v1, Lkotlin/reflect/KFunction;
    invoke-interface v14, Landroidx/compose/runtime/Composer;->endReplaceGroup()V
    move-object v8, v1
    check-cast v8, Lkotlin/jvm/functions/Function0;
    const/4 v9, 0
    const/4 v11, 0
    const/16 v12, 128
    move-object v10, v14
    invoke-static/range v2 ... v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->VideoArtifactPreviewScreen(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; Landroidx/compose/runtime/Composer; I I)V
    invoke-static Landroidx/compose/runtime/ComposerKt;->isTraceInProgress()Z
    move-result v14
    if-eqz v14, +005h
    invoke-static Landroidx/compose/runtime/ComposerKt;->traceEventEnd()V
    return-void 
.end method
