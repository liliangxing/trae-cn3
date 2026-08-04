# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;
.super Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;
.source "VideoArtifactPreview.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $animationScope:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic $currentOnClose$delegate:Landroidx/compose/runtime/State;
.field final synthetic $dismissDistancePx:F
.field final synthetic $dismissVelocityThresholdPx:F
.field final synthetic $dragOffsetY$delegate:Landroidx/compose/runtime/MutableFloatState;
.field final synthetic $resetAnimationJob$delegate:Landroidx/compose/runtime/MutableState;
.field  F$0:F
.field  J$0:J
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I


.method constructor <init>(float  float  kotlinx.coroutines.CoroutineScope  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.State  kotlin.coroutines.Continuation)void
    .registers 8
    # ins_size=8
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dismissDistancePx F
    iput v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dismissVelocityThresholdPx F
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$animationScope Lkotlinx/coroutines/CoroutineScope;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$currentOnClose$delegate Landroidx/compose/runtime/State;
    const/4 v1, 2
    invoke-direct v0, v1, v7, Lkotlin/coroutines/jvm/internal/RestrictedSuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 12
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;
    iget v1, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dismissDistancePx F
    iget v2, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dismissVelocityThresholdPx F
    iget-object v3, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$animationScope Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    iget-object v5, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    iget-object v6, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$currentOnClose$delegate Landroidx/compose/runtime/State;
    move-object v0, v8
    move-object v7, v11
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;-><init>(F F Lkotlinx/coroutines/CoroutineScope; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/State; Lkotlin/coroutines/Continuation;)V
    iput-object v10, v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public final invoke(androidx.compose.ui.input.pointer.AwaitPointerEventScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->invoke(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 20
    # ins_size=2
    move-object/from16 v0, v18
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->label I
    const/4 v3, 2
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 1
    if-eqz v2, +02fh
    if-eq v2, v7, +023h
    if-ne v2, v3, +019h
    iget v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->F$0 F
    iget-wide v8, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->J$0 J
    iget-object v10, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$2 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    iget-object v11, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$1 Ljava/lang/Object;
    check-cast v11, Landroidx/compose/ui/input/pointer/util/VelocityTracker;
    iget-object v12, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v12, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v13, v19
    move-object v14, v0
    goto +68h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v2, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v8, v19
    goto +18h
    invoke-static/range v19, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$0 Ljava/lang/Object;
    check-cast v2, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;
    sget-object v8, Landroidx/compose/ui/input/pointer/PointerEventPass;->Initial Landroidx/compose/ui/input/pointer/PointerEventPass;
    move-object v9, v0
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$0 Ljava/lang/Object;
    iput v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->label I
    invoke-static v2, v6, v8, v9, Landroidx/compose/foundation/gestures/TapGestureDetectorKt;->awaitFirstDown(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope; Z Landroidx/compose/ui/input/pointer/PointerEventPass; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Landroidx/compose/ui/input/pointer/PointerInputChange;
    new-instance v9, Landroidx/compose/ui/input/pointer/util/VelocityTracker;
    invoke-direct v9, Landroidx/compose/ui/input/pointer/util/VelocityTracker;-><init>()V
    invoke-virtual v8, Landroidx/compose/ui/input/pointer/PointerInputChange;->getUptimeMillis()J
    move-result-wide v10
    invoke-virtual v8, Landroidx/compose/ui/input/pointer/PointerInputChange;->getPosition-F1C5BW0()J
    move-result-wide v12
    invoke-virtual v9, v10, v11, v12, v13, Landroidx/compose/ui/input/pointer/util/VelocityTracker;->addPosition-Uv8p0NA(J J)V
    sget-object v8, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Undecided Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    sget-object v10, Landroidx/compose/ui/geometry/Offset;->Companion Landroidx/compose/ui/geometry/Offset$Companion;
    invoke-virtual v10, Landroidx/compose/ui/geometry/Offset$Companion;->getZero-F1C5BW0()J
    move-result-wide v10
    move-object v14, v0
    move-object v12, v2
    move v2, v5
    move v13, v6
    move-wide/from16 v16, v10
    move-object v10, v8
    move-object v11, v9
    move-wide/from16 v8, v16
    if-nez v13, +0e2h
    sget-object v13, Landroidx/compose/ui/input/pointer/PointerEventPass;->Initial Landroidx/compose/ui/input/pointer/PointerEventPass;
    move-object v15, v14
    check-cast v15, Lkotlin/coroutines/Continuation;
    iput-object v12, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$0 Ljava/lang/Object;
    iput-object v11, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$1 Ljava/lang/Object;
    iput-object v10, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->L$2 Ljava/lang/Object;
    iput-wide v8, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->J$0 J
    iput v2, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->F$0 F
    iput v3, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->label I
    invoke-interface v12, v13, v15, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;->awaitPointerEvent(Landroidx/compose/ui/input/pointer/PointerEventPass; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v1, +003h
    return-object v1
    check-cast v13, Landroidx/compose/ui/input/pointer/PointerEvent;
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerEvent;->getChanges()Ljava/util/List;
    move-result-object v15
    invoke-interface v15, Ljava/util/List;->size()I
    move-result v15
    if-eq v15, v7, +004h
    sget-object v10, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Rejected Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerEvent;->getChanges()Ljava/util/List;
    move-result-object v13
    invoke-static v13, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Landroidx/compose/ui/input/pointer/PointerInputChange;
    if-nez v13, +004h
    goto/16 +0aeh
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerInputChange;->getPressed()Z
    move-result v15
    xor-int/2addr v15, v7
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerInputChange;->getUptimeMillis()J
    move-result-wide v3
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerInputChange;->getPosition-F1C5BW0()J
    move-result-wide v6
    invoke-virtual v11, v3, v4, v6, v7, Landroidx/compose/ui/input/pointer/util/VelocityTracker;->addPosition-Uv8p0NA(J J)V
    if-nez v15, +092h
    invoke-static v13, Landroidx/compose/ui/input/pointer/PointerEventKt;->positionChange(Landroidx/compose/ui/input/pointer/PointerInputChange;)J
    move-result-wide v3
    invoke-static v8, v9, v3, v4, Landroidx/compose/ui/geometry/Offset;->plus-MK-Hz9U(J J)J
    move-result-wide v8
    sget-object v3, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Undecided Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    const-wide v6, 4294967295
    if-ne v10, v3, +062h
    const/16 v3, 32
    shr-long v3, v8, v3
    long-to-int v3, v3
    invoke-static v3, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v4
    invoke-static v4, Ljava/lang/Math;->abs(F)F
    move-result v4
    move-object/from16 v19, v1
    and-long v0, v8, v6
    long-to-int v0, v0
    invoke-static v0, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v1
    invoke-static v1, Ljava/lang/Math;->abs(F)F
    move-result v1
    invoke-static v4, v1, Ljava/lang/Math;->max(F F)F
    move-result v1
    invoke-interface v12, Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;->getViewConfiguration()Landroidx/compose/ui/platform/ViewConfiguration;
    move-result-object v4
    invoke-interface v4, Landroidx/compose/ui/platform/ViewConfiguration;->getTouchSlop()F
    move-result v4
    cmpl-float v1, v1, v4
    if-lez v1, +03ah
    invoke-static v0, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v1
    cmpl-float v1, v1, v5
    if-lez v1, +02ch
    invoke-static v0, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v0
    invoke-static v0, Ljava/lang/Math;->abs(F)F
    move-result v0
    invoke-static v3, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v1
    invoke-static v1, Ljava/lang/Math;->abs(F)F
    move-result v1
    cmpl-float v0, v0, v1
    if-lez v0, +018h
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$4(Landroidx/compose/runtime/MutableState;)Lkotlinx/coroutines/Job;
    move-result-object v0
    if-eqz v0, +007h
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v2
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->VerticalDown Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->Rejected Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    move-object v10, v0
    goto +3h
    move-object/from16 v19, v1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->VerticalDown Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    if-ne v10, v0, +016h
    invoke-virtual v13, Landroidx/compose/ui/input/pointer/PointerInputChange;->consume()V
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    and-long v3, v8, v6
    long-to-int v1, v3
    invoke-static v1, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v1
    add-float/2addr v1, v2
    invoke-static v1, v5, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$2(Landroidx/compose/runtime/MutableFloatState; F)V
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    goto +5h
    move-object/from16 v19, v1
    move-object/from16 v0, v18
    move v13, v15
    const/4 v3, 2
    const/4 v6, 0
    const/4 v7, 1
    goto/16 -0e0h
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;->VerticalDown Lcom/bytedance/trae/kmp/artifacts/video/PreviewDismissGestureDirection;
    if-ne v10, v0, +041h
    invoke-virtual v11, Landroidx/compose/ui/input/pointer/util/VelocityTracker;->calculateVelocity-9UxMQ8M()J
    move-result-wide v0
    invoke-static v0, v1, Landroidx/compose/ui/unit/Velocity;->getY-impl(J)F
    move-result v0
    iget-object v1, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v1
    iget v2, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dismissDistancePx F
    cmpl-float v1, v1, v2
    if-gtz v1, +023h
    iget v1, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dismissVelocityThresholdPx F
    cmpl-float v0, v0, v1
    if-lez v0, +003h
    goto +1bh
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    iget-object v1, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$animationScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1;
    iget-object v5, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    const/4 v6, 0
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$1;-><init>(Landroidx/compose/runtime/MutableFloatState; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$5(Landroidx/compose/runtime/MutableState; Lkotlinx/coroutines/Job;)V
    goto +47h
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$currentOnClose$delegate Landroidx/compose/runtime/State;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$6(Landroidx/compose/runtime/State;)Lkotlin/jvm/functions/Function0;
    move-result-object v0
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +3dh
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$1(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v0
    cmpg-float v0, v0, v5
    if-nez v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-nez v2, +02fh
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$4(Landroidx/compose/runtime/MutableState;)Lkotlinx/coroutines/Job;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-interface v0, Lkotlinx/coroutines/Job;->isActive()Z
    move-result v0
    const/4 v1, 1
    if-ne v0, v1, +004h
    move v6, v1
    goto +2h
    const/4 v6, 0
    if-nez v6, +01bh
    iget-object v0, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    iget-object v1, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$animationScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;
    iget-object v5, v14, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    const/4 v6, 0
    invoke-direct v4, v5, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1$2;-><init>(Landroidx/compose/runtime/MutableFloatState; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoArtifactPreviewScreen$lambda$5(Landroidx/compose/runtime/MutableState; Lkotlinx/coroutines/Job;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method
