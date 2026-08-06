package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"com/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;", "onError", "", "errorCode", "", "onMetadataLoaded", "durationMs", "", "onPlaybackPositionUpdated", "positionMs", "onPlaybackStarted", "onPlaybackPaused", "onPlaybackResumed", "onPlaybackCompleted", "playAgain", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewViewModel$playerListener$1 implements VideoArtifactPlayer.Listener {
    final /* synthetic */ VideoArtifactPreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoArtifactPreviewViewModel$playerListener$1(VideoArtifactPreviewViewModel videoArtifactPreviewViewModel) {
        this.this$0 = videoArtifactPreviewViewModel;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onError(int errorCode) {
        MutableStateFlow mutableStateFlow;
        mutableStateFlow = this.this$0._state;
        mutableStateFlow.setValue(new VideoArtifactPreviewState.Failed(errorCode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready onMetadataLoaded$lambda$0(long j, VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "it");
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : RangesKt.coerceAtLeast(j, 0L), (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onMetadataLoaded(final long durationMs) {
        this.this$0.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                VideoArtifactPreviewState.Ready onMetadataLoaded$lambda$0;
                onMetadataLoaded$lambda$0 = VideoArtifactPreviewViewModel$playerListener$1.onMetadataLoaded$lambda$0(durationMs, (VideoArtifactPreviewState.Ready) obj);
                return onMetadataLoaded$lambda$0;
            }
        });
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onPlaybackPositionUpdated(final long positionMs) {
        final VideoArtifactPreviewViewModel videoArtifactPreviewViewModel = this.this$0;
        videoArtifactPreviewViewModel.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                VideoArtifactPreviewState.Ready onPlaybackPositionUpdated$lambda$1;
                onPlaybackPositionUpdated$lambda$1 = VideoArtifactPreviewViewModel$playerListener$1.onPlaybackPositionUpdated$lambda$1(positionMs, videoArtifactPreviewViewModel, (VideoArtifactPreviewState.Ready) obj);
                return onPlaybackPositionUpdated$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready onPlaybackPositionUpdated$lambda$1(long j, VideoArtifactPreviewViewModel videoArtifactPreviewViewModel, VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "ready");
        if (j < ready.getDurationMs()) {
            videoArtifactPreviewViewModel.playbackCompleted = false;
        }
        if (ready.isDragging()) {
            return ready;
        }
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : RangesKt.coerceIn(j, 0L, RangesKt.coerceAtLeast(ready.getDurationMs(), j)), (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready onPlaybackStarted$lambda$2(VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "it");
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : true, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onPlaybackStarted() {
        this.this$0.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                VideoArtifactPreviewState.Ready onPlaybackStarted$lambda$2;
                onPlaybackStarted$lambda$2 = VideoArtifactPreviewViewModel$playerListener$1.onPlaybackStarted$lambda$2((VideoArtifactPreviewState.Ready) obj);
                return onPlaybackStarted$lambda$2;
            }
        });
        this.this$0.seekAfterPlaybackStartedIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready onPlaybackPaused$lambda$3(VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "it");
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onPlaybackPaused() {
        this.this$0.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                VideoArtifactPreviewState.Ready onPlaybackPaused$lambda$3;
                onPlaybackPaused$lambda$3 = VideoArtifactPreviewViewModel$playerListener$1.onPlaybackPaused$lambda$3((VideoArtifactPreviewState.Ready) obj);
                return onPlaybackPaused$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready onPlaybackResumed$lambda$4(VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "it");
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : true, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onPlaybackResumed() {
        this.this$0.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                VideoArtifactPreviewState.Ready onPlaybackResumed$lambda$4;
                onPlaybackResumed$lambda$4 = VideoArtifactPreviewViewModel$playerListener$1.onPlaybackResumed$lambda$4((VideoArtifactPreviewState.Ready) obj);
                return onPlaybackResumed$lambda$4;
            }
        });
        this.this$0.seekAfterPlaybackStartedIfNeeded();
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer.Listener
    public void onPlaybackCompleted(final boolean playAgain) {
        int i;
        this.this$0.playbackCompleted = !playAgain;
        this.this$0.pendingSeekAfterPlaybackStarted = null;
        VideoArtifactPreviewViewModel videoArtifactPreviewViewModel = this.this$0;
        i = videoArtifactPreviewViewModel.latestSeekGeneration;
        videoArtifactPreviewViewModel.latestSeekGeneration = i + 1;
        this.this$0.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                VideoArtifactPreviewState.Ready onPlaybackCompleted$lambda$5;
                onPlaybackCompleted$lambda$5 = VideoArtifactPreviewViewModel$playerListener$1.onPlaybackCompleted$lambda$5(playAgain, (VideoArtifactPreviewState.Ready) obj);
                return onPlaybackCompleted$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready onPlaybackCompleted$lambda$5(boolean z, VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "it");
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : ready.getDurationMs(), (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : z, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }
}
