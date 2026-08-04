# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Landroidx/compose/ui/input/pointer/PointerInputScope;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:J
.field public final synthetic f$3:Landroidx/compose/runtime/MutableState;


.method public synthetic constructor <init>(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  long  androidx.compose.runtime.MutableState)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$0 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function1;
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$2 J
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$3 Landroidx/compose/runtime/MutableState;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=3
    iget-object v0, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$0 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function1;
    iget-wide v2, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$2 J
    iget-object v4, v7, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2;->f$3 Landroidx/compose/runtime/MutableState;
    move-object v5, v8
    check-cast v5, Landroidx/compose/ui/input/pointer/PointerInputChange;
    check-cast v9, Ljava/lang/Float;
    invoke-virtual v9, Ljava/lang/Float;->floatValue()F
    move-result v6
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$2$1;->$r8$lambda$Sk4L7YNyRrGY0z0ag-YJkapA43U(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; J Landroidx/compose/runtime/MutableState; Landroidx/compose/ui/input/pointer/PointerInputChange; F)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
