# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$1:Landroidx/compose/ui/input/pointer/PointerInputScope;
.field public final synthetic f$2:J


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  androidx.compose.ui.input.pointer.PointerInputScope  long)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;->f$1 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;->f$2 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;->f$1 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iget-wide v2, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0;->f$2 J
    check-cast v5, Landroidx/compose/ui/geometry/Offset;
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoProgressBar$1$1;->$r8$lambda$_ZM5JbF2U2JXzblmkfEjkIZikxc(Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/input/pointer/PointerInputScope; J Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v5
    return-object v5
.end method
