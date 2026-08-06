package com.bytedance.vcloud.uniplayer;

import com.ss.ttm.player.MediaFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAVEngine.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0003H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0012H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0012H&J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H\u0016J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH&¨\u0006$"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/PlaybackListener;", "", "onAudioReady", "", "onBufferingEnded", "onBufferingStarted", "reason", "Lcom/bytedance/vcloud/uniplayer/BufferingReason;", "onCacheUpdate", "percent", "", "onError", "errorCode", "onFirstVideoFrameDrew", "onGearSelected", "gearId", "", MediaFormat.KEY_BIT_RATE, "", "streamType", "Lcom/bytedance/vcloud/uniplayer/UniGearStreamType;", "onLoopEnd", "playAgain", "", "onMetadataLoaded", "durationMs", "onPlaybackCompleted", "onPlaybackPaused", "onPlaybackPositionUpdated", "position", "onPlaybackResumed", "onPlaybackStarted", "onPlaybackStopped", "onVideoSizeChanged", "newWidth", "newHeight", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface PlaybackListener {

    /* compiled from: UniAVEngine.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static void onAudioReady(PlaybackListener playbackListener) {
        }

        public static void onCacheUpdate(PlaybackListener playbackListener, int i) {
        }

        public static void onGearSelected(PlaybackListener playbackListener, String gearId, long j, UniGearStreamType streamType) {
            Intrinsics.checkNotNullParameter(gearId, "gearId");
            Intrinsics.checkNotNullParameter(streamType, "streamType");
        }

        public static void onLoopEnd(PlaybackListener playbackListener, boolean z) {
        }

        public static void onPlaybackPaused(PlaybackListener playbackListener) {
        }

        public static void onPlaybackResumed(PlaybackListener playbackListener) {
        }

        public static void onPlaybackStopped(PlaybackListener playbackListener) {
        }
    }

    void onAudioReady();

    void onBufferingEnded();

    void onBufferingStarted(BufferingReason reason);

    void onCacheUpdate(int percent);

    void onError(int errorCode);

    void onFirstVideoFrameDrew();

    void onGearSelected(String gearId, long bitrate, UniGearStreamType streamType);

    void onLoopEnd(boolean playAgain);

    void onMetadataLoaded(long durationMs);

    void onPlaybackCompleted(boolean playAgain);

    void onPlaybackPaused();

    void onPlaybackPositionUpdated(long position);

    void onPlaybackResumed();

    void onPlaybackStarted();

    void onPlaybackStopped();

    void onVideoSizeChanged(int newWidth, int newHeight);
}
