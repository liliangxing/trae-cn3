# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;
.super Ljava/lang/Object;
.source "VideoArtifactPreview.kt"

.implements Lcom/bytedance/vcloud/uniplayer/PlaybackListener;

.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;


.method constructor <init>(com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAudioReady()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/vcloud/uniplayer/PlaybackListener$DefaultImpls;->onAudioReady(Lcom/bytedance/vcloud/uniplayer/PlaybackListener;)V
    return-void 
.end method

.method public onBufferingEnded()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onBufferingStarted(com.bytedance.vcloud.uniplayer.BufferingReason)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, reason
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onCacheUpdate(int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/vcloud/uniplayer/PlaybackListener$DefaultImpls;->onCacheUpdate(Lcom/bytedance/vcloud/uniplayer/PlaybackListener; I)V
    return-void 
.end method

.method public onError(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onError(I)V
    return-void 
.end method

.method public onFirstVideoFrameDrew()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onGearSelected(java.lang.String  long  com.bytedance.vcloud.uniplayer.UniGearStreamType)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/vcloud/uniplayer/PlaybackListener$DefaultImpls;->onGearSelected(Lcom/bytedance/vcloud/uniplayer/PlaybackListener; Ljava/lang/String; J Lcom/bytedance/vcloud/uniplayer/UniGearStreamType;)V
    return-void 
.end method

.method public onLoopEnd(boolean)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/vcloud/uniplayer/PlaybackListener$DefaultImpls;->onLoopEnd(Lcom/bytedance/vcloud/uniplayer/PlaybackListener; Z)V
    return-void 
.end method

.method public onMetadataLoaded(long)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onMetadataLoaded(J)V
    return-void 
.end method

.method public onPlaybackCompleted(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onPlaybackCompleted(Z)V
    return-void 
.end method

.method public onPlaybackPaused()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onPlaybackPaused()V
    return-void 
.end method

.method public onPlaybackPositionUpdated(long)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onPlaybackPositionUpdated(J)V
    return-void 
.end method

.method public onPlaybackResumed()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onPlaybackResumed()V
    return-void 
.end method

.method public onPlaybackStarted()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-static v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->access$getListener$p(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;->onPlaybackStarted()V
    return-void 
.end method

.method public onPlaybackStopped()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/vcloud/uniplayer/PlaybackListener$DefaultImpls;->onPlaybackStopped(Lcom/bytedance/vcloud/uniplayer/PlaybackListener;)V
    return-void 
.end method

.method public onVideoSizeChanged(int  int)void
    .registers 3
    # ins_size=3
    return-void 
.end method
