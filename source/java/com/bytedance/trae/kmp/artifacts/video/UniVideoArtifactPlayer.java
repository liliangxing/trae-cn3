package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer;
import com.bytedance.vcloud.uniplayer.BufferingReason;
import com.bytedance.vcloud.uniplayer.PlaybackListener;
import com.bytedance.vcloud.uniplayer.SeekMode;
import com.bytedance.vcloud.uniplayer.UniAVEngine;
import com.bytedance.vcloud.uniplayer.UniGearStreamType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoArtifactPreview.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;", "engine", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "<init>", "(Lcom/bytedance/vcloud/uniplayer/UniAVEngine;)V", "getEngine", "()Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "listener", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;", "playbackListener", "com/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1", "Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;", "setListener", "", "play", "pause", "stop", "seek", "", "positionMs", "", "completion", "Lkotlin/Function1;", "", "setSpeed", "speed", "", "release", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UniVideoArtifactPlayer implements VideoArtifactPlayer {
    public static final int $stable = 8;
    private final UniAVEngine engine;
    private VideoArtifactPlayer.Listener listener;
    private final UniVideoArtifactPlayer$playbackListener$1 playbackListener;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer$playbackListener$1] */
    public UniVideoArtifactPlayer(UniAVEngine uniAVEngine) {
        Intrinsics.checkNotNullParameter(uniAVEngine, "engine");
        this.engine = uniAVEngine;
        ?? r0 = new PlaybackListener() { // from class: com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer$playbackListener$1
            public void onBufferingEnded() {
            }

            public void onBufferingStarted(BufferingReason reason) {
                Intrinsics.checkNotNullParameter(reason, ISignalReportConstants.KEY_REASON);
            }

            public void onFirstVideoFrameDrew() {
            }

            public void onVideoSizeChanged(int newWidth, int newHeight) {
            }

            public void onAudioReady() {
                PlaybackListener.DefaultImpls.onAudioReady(this);
            }

            public void onCacheUpdate(int i) {
                PlaybackListener.DefaultImpls.onCacheUpdate(this, i);
            }

            public void onGearSelected(String str, long j, UniGearStreamType uniGearStreamType) {
                PlaybackListener.DefaultImpls.onGearSelected(this, str, j, uniGearStreamType);
            }

            public void onLoopEnd(boolean z) {
                PlaybackListener.DefaultImpls.onLoopEnd(this, z);
            }

            public void onPlaybackStopped() {
                PlaybackListener.DefaultImpls.onPlaybackStopped(this);
            }

            public void onError(int errorCode) {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onError(errorCode);
                }
            }

            public void onMetadataLoaded(long metadataDurationMs) {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onMetadataLoaded(metadataDurationMs);
                }
            }

            public void onPlaybackPositionUpdated(long position) {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onPlaybackPositionUpdated(position);
                }
            }

            public void onPlaybackStarted() {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onPlaybackStarted();
                }
            }

            public void onPlaybackPaused() {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onPlaybackPaused();
                }
            }

            public void onPlaybackResumed() {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onPlaybackResumed();
                }
            }

            public void onPlaybackCompleted(boolean playAgain) {
                VideoArtifactPlayer.Listener listener;
                listener = UniVideoArtifactPlayer.this.listener;
                if (listener != null) {
                    listener.onPlaybackCompleted(playAgain);
                }
            }
        };
        this.playbackListener = r0;
        uniAVEngine.addListener((PlaybackListener) r0);
    }

    public final UniAVEngine getEngine() {
        return this.engine;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public void setListener(VideoArtifactPlayer.Listener listener) {
        this.listener = listener;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public void play() {
        this.engine.play();
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public void pause() {
        this.engine.pause();
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public void stop() {
        this.engine.stop(false);
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public int seek(long positionMs, final Function1<? super Boolean, Unit> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return this.engine.seek(positionMs, SeekMode.UniSeekModeAny, new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit seek$lambda$0;
                seek$lambda$0 = UniVideoArtifactPlayer.seek$lambda$0(completion, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
                return seek$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit seek$lambda$0(Function1 function1, int i, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public void setSpeed(float speed) {
        this.engine.setSpeed(speed);
    }

    @Override // com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer
    public void release() {
        this.engine.removeListener(this.playbackListener);
        this.engine.release();
    }
}
