# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
.field public final synthetic f$1:Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;


.method public synthetic constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->$r8$lambda$hHJ1J6oYlHReGDrWjrbaSXdnFJc(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity; Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;)V
    return-void 
.end method
