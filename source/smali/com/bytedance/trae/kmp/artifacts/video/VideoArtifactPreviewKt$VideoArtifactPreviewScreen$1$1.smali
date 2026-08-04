# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;
.super Ljava/lang/Object;
.source "VideoArtifactPreview.kt"

.implements Landroidx/compose/ui/input/pointer/PointerInputEventHandler;

.field final synthetic $animationScope:Lkotlinx/coroutines/CoroutineScope;
.field final synthetic $currentOnClose$delegate:Landroidx/compose/runtime/State;
.field final synthetic $dismissDistancePx:F
.field final synthetic $dismissVelocityThresholdPx:F
.field final synthetic $dragOffsetY$delegate:Landroidx/compose/runtime/MutableFloatState;
.field final synthetic $resetAnimationJob$delegate:Landroidx/compose/runtime/MutableState;


.method constructor <init>(float  float  kotlinx.coroutines.CoroutineScope  androidx.compose.runtime.MutableState  androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.State)void
    .registers 7
    # ins_size=7
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$dismissDistancePx F
    iput v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$dismissVelocityThresholdPx F
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$animationScope Lkotlinx/coroutines/CoroutineScope;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$currentOnClose$delegate Landroidx/compose/runtime/State;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;
    iget v1, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$dismissDistancePx F
    iget v2, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$dismissVelocityThresholdPx F
    iget-object v3, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$animationScope Lkotlinx/coroutines/CoroutineScope;
    iget-object v4, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$resetAnimationJob$delegate Landroidx/compose/runtime/MutableState;
    iget-object v5, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$dragOffsetY$delegate Landroidx/compose/runtime/MutableFloatState;
    iget-object v6, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1;->$currentOnClose$delegate Landroidx/compose/runtime/State;
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$1$1$1;-><init>(F F Lkotlinx/coroutines/CoroutineScope; Landroidx/compose/runtime/MutableState; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/State; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/jvm/functions/Function2;
    invoke-static v10, v8, v11, Landroidx/compose/foundation/gestures/ForEachGestureKt;->awaitEachGesture(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v11
    if-ne v10, v11, +003h
    return-object v10
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method
