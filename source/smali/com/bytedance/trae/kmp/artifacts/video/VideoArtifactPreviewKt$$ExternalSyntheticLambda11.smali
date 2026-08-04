# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;->f$1 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda11;->f$1 Lkotlin/jvm/functions/Function0;
    check-cast v3, Lcom/bytedance/vcloud/uniplayer/UniWindowClient;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$-X1HpUr1LFIvCLfPzhQfAYZsclo(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lcom/bytedance/vcloud/uniplayer/UniWindowClient;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
