package com.bytedance.trae.kmp.artifacts.video;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;", "", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;", "play", "pause", "stop", "seek", "", "positionMs", "", "completion", "Lkotlin/Function1;", "", "setSpeed", "speed", "", "release", "Listener", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface VideoArtifactPlayer {

    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;", "", "onError", "", "errorCode", "", "onMetadataLoaded", "durationMs", "", "onPlaybackPositionUpdated", "positionMs", "onPlaybackStarted", "onPlaybackPaused", "onPlaybackResumed", "onPlaybackCompleted", "playAgain", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Listener {
        void onError(int errorCode);

        void onMetadataLoaded(long durationMs);

        void onPlaybackCompleted(boolean playAgain);

        void onPlaybackPaused();

        void onPlaybackPositionUpdated(long positionMs);

        void onPlaybackResumed();

        void onPlaybackStarted();
    }

    void pause();

    void play();

    void release();

    int seek(long positionMs, Function1<? super Boolean, Unit> completion);

    void setListener(Listener listener);

    void setSpeed(float speed);

    void stop();
}
