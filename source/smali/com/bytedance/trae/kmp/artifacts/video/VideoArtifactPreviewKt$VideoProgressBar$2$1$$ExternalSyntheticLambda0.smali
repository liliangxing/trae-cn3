# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroidx/compose/ui/input/pointer/PointerInputScope;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:J
.field public final synthetic f$3:Landroidx/compose/runtime/MutableState;


.method public synthetic constructor <init>(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$0 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function1;
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$2 J
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$3 Landroidx/compose/runtime/MutableState;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$0 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iget-object v1, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/functions/Function1;
    iget-wide v2, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$2 J
    iget-object v4, v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0;->f$3 Landroidx/compose/runtime/MutableState;
    move-object v5, v7
    check-cast v5, Landroidx/compose/ui/geometry/Offset;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$r8$lambda$CbC4eQzbFS1UbmWQ1nV_Y6lHzEk(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
