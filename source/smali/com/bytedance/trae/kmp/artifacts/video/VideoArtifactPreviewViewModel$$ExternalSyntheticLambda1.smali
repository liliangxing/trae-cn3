# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:I
.field public final synthetic f$1:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
.field public final synthetic f$2:J


.method public synthetic constructor <init>(int  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel  long)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;->f$0 I
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;->f$2 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iget v0, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;->f$0 I
    iget-object v1, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;->f$1 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    iget-wide v2, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1;->f$2 J
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    invoke-static v0, v1, v2, v3, v5, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->$r8$lambda$bjGPNaEdpOp2BpXeqKFdIHEU6Z0(I Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; J Z)Lkotlin/Unit;
    move-result-object v5
    return-object v5
.end method
