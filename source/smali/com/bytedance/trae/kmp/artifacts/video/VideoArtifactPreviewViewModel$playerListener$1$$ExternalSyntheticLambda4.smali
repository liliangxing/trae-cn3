# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:J
.field public final synthetic f$1:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;


.method public synthetic constructor <init>(long  com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;->f$0 J
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-wide v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;->f$0 J
    iget-object v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    check-cast v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->$r8$lambda$xR964hkUbJDw4kWQGhnYNAZA7VE(J Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel; Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v4
    return-object v4
.end method
