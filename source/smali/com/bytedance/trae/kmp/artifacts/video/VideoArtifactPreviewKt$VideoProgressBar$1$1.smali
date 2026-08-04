# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;
.super Ljava/lang/Object;
.source "VideoArtifactPreview.kt"

.implements Landroidx/compose/ui/input/pointer/PointerInputEventHandler;

.field final synthetic $durationMs:J
.field final synthetic $onSeek:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$_ZM5JbF2U2JXzblmkfEjkIZikxc(kotlin.jvm.functions.Function1  androidx.compose.ui.input.pointer.PointerInputScope  long  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;->invoke$lambda$0(Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/input/pointer/PointerInputScope; J Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(kotlin.jvm.functions.Function1  long)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;->$onSeek Lkotlin/jvm/functions/Function1;
    iput-wide v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;->$durationMs J
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$0(kotlin.jvm.functions.Function1  androidx.compose.ui.input.pointer.PointerInputScope  long  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 8
    # ins_size=5
    invoke-virtual v7, Landroidx/compose/ui/geometry/Offset;->unbox-impl()J
    move-result-wide v0
    const/16 v7, 32
    shr-long/2addr v0, v7
    long-to-int v0, v0
    invoke-static v0, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v0
    invoke-interface v4, Landroidx/compose/ui/input/pointer/PointerInputScope;->getSize-YbymL2g()J
    move-result-wide v1
    shr-long/2addr v1, v7
    long-to-int v4, v1
    invoke-static v5, v6, v0, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->access$VideoProgressBar$targetFor(J F I)J
    move-result-wide v4
    invoke-static v4, v5, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v4
    invoke-interface v3, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method public final invoke(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=3
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;->$onSeek Lkotlin/jvm/functions/Function1;
    iget-wide v4, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;->$durationMs J
    new-instance v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;
    invoke-direct v6, v0, v10, v4, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/input/pointer/PointerInputScope; J)V
    const/4 v7, 7
    const/4 v8, 0
    move-object v0, v10
    move-object v4, v6
    move-object v5, v11
    move v6, v7
    move-object v7, v8
    invoke-static/range v0 ... v7, Landroidx/compose/foundation/gestures/TapGestureDetectorKt;->detectTapGestures$default(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v11
    if-ne v10, v11, +003h
    return-object v10
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v10
.end method
