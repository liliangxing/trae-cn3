# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:J


.method public synthetic constructor <init>(long)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda0;->f$0 J
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$$ExternalSyntheticLambda0;->f$0 J
    check-cast v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;->$r8$lambda$sbvPXOZr_zEQ1Idns9K06L2Wtw0(J Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v3
    return-object v3
.end method
