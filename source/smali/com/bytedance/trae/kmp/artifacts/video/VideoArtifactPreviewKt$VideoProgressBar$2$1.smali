# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;
.super Ljava/lang/Object;
.source "VideoArtifactPreview.kt"

.implements Landroidx/compose/ui/input/pointer/PointerInputEventHandler;

.field final synthetic $durationMs:J
.field final synthetic $onDragPosition:Lkotlin/jvm/functions/Function1;
.field final synthetic $onSeek:Lkotlin/jvm/functions/Function1;
.field final synthetic $pendingSeekMs$delegate:Landroidx/compose/runtime/MutableState;


.method public static synthetic $r8$lambda$CbC4eQzbFS1UbmWQ1nV_Y6lHzEk(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->invoke$lambda$0(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Sk4L7YNyRrGY0z0ag-YJkapA43U(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState  androidx.compose.ui.input.pointer.PointerInputChange  float)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->invoke$lambda$2(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/input/pointer/PointerInputChange; F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$gNE7pJpSCmlbZR4NwbOLqPNgVdM(kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->invoke$lambda$1(Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState  kotlin.jvm.functions.Function1)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$onDragPosition Lkotlin/jvm/functions/Function1;
    iput-wide v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$durationMs J
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$pendingSeekMs$delegate Landroidx/compose/runtime/MutableState;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$onSeek Lkotlin/jvm/functions/Function1;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$0(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 9
    # ins_size=6
    invoke-virtual v8, Landroidx/compose/ui/geometry/Offset;->unbox-impl()J
    move-result-wide v0
    const/16 v8, 32
    shr-long/2addr v0, v8
    long-to-int v0, v0
    invoke-static v0, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v0
    invoke-interface v3, Landroidx/compose/ui/input/pointer/PointerInputScope;->getSize-YbymL2g()J
    move-result-wide v1
    shr-long/2addr v1, v8
    long-to-int v3, v1
    invoke-static v5, v6, v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$targetFor(J F I)J
    move-result-wide v5
    invoke-static v7, v5, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$lambda$87(Landroidx/compose/runtime/MutableState; J)V
    invoke-static v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$lambda$86(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v4, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final invoke$lambda$1(kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableState)kotlin.Unit
    .registers 4
    # ins_size=2
    invoke-static v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$lambda$86(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v2, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final invoke$lambda$2(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState  androidx.compose.ui.input.pointer.PointerInputChange  float)kotlin.Unit
    .registers 10
    # ins_size=7
    const-string v9, "change"
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Landroidx/compose/ui/input/pointer/PointerInputChange;->consume()V
    invoke-virtual v8, Landroidx/compose/ui/input/pointer/PointerInputChange;->getPosition-F1C5BW0()J
    move-result-wide v8
    const/16 v0, 32
    shr-long/2addr v8, v0
    long-to-int v8, v8
    invoke-static v8, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v8
    invoke-interface v3, Landroidx/compose/ui/input/pointer/PointerInputScope;->getSize-YbymL2g()J
    move-result-wide v1
    shr-long v0, v1, v0
    long-to-int v3, v0
    invoke-static v5, v6, v8, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$targetFor(J F I)J
    move-result-wide v5
    invoke-static v7, v5, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$lambda$87(Landroidx/compose/runtime/MutableState; J)V
    invoke-static v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$lambda$86(Landroidx/compose/runtime/MutableState;)J
    move-result-wide v5
    invoke-static v5, v6, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v3
    invoke-interface v4, v3, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public final invoke(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=3
    move-object v0, v15
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$onDragPosition Lkotlin/jvm/functions/Function1;
    iget-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$durationMs J
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$pendingSeekMs$delegate Landroidx/compose/runtime/MutableState;
    new-instance v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;
    move-object v1, v8
    move-object/from16 v2, v16
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;-><init>(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState;)V
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$onSeek Lkotlin/jvm/functions/Function1;
    iget-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$pendingSeekMs$delegate Landroidx/compose/runtime/MutableState;
    new-instance v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda1;
    invoke-direct v9, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableState;)V
    const/4 v10, 0
    iget-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$onDragPosition Lkotlin/jvm/functions/Function1;
    iget-wide v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$durationMs J
    iget-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$pendingSeekMs$delegate Landroidx/compose/runtime/MutableState;
    new-instance v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;
    move-object v1, v11
    move-object/from16 v2, v16
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;-><init>(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState;)V
    const/4 v13, 4
    const/4 v14, 0
    move-object/from16 v7, v16
    move-object/from16 v12, v17
    invoke-static/range v7 ... v14, Landroidx/compose/foundation/gestures/DragGestureDetectorKt;->detectHorizontalDragGestures$default(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    if-ne v1, v2, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method
