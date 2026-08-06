package com.bytedance.trae.kmp.artifacts.video;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceLease;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceResult;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewAction;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState;
import com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005*\u0001B\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002DEB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010'\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\u001a\u0010*\u001a\u00020%2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020%0\u0005J\u000e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0014J\u0016\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020%H\u0002J\b\u00107\u001a\u00020%H\u0002J\b\u00108\u001a\u00020%H\u0002J\u0018\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020%H\u0002J\u001c\u0010>\u001a\u00020%2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@0\u0005H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010C¨\u0006F"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "request", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "prepareOriginal", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult;", "", "<init>", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;Lkotlin/jvm/functions/Function1;)V", "getRequest", "()Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;", "Lkotlin/jvm/functions/Function1;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "lease", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;", "player", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;", "prepareJob", "Lkotlinx/coroutines/Job;", "closed", "", "playerWindowReady", "playRequested", "playbackCompleted", "pendingSeekAfterPlaybackStarted", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;", "latestSeekGeneration", "", "close", "", "attachPlayer", "detachPlayer", "onPlayerWindowReady", "onPlayerCreationFailed", "saveToMediaLibrary", "onComplete", "Lcom/bytedance/trae/kmp/host/KmpMediaLibrarySaveResult;", "onAction", "action", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewAction;", "prepare", "onCleared", "handleReady", "result", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;", "(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult$Ready;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseResources", "releasePlayer", "startPlaybackIfReady", "seekPlayer", "positionMs", "", "generation", "seekAfterPlaybackStartedIfNeeded", "updateReady", "transform", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;", "playerListener", "com/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1", "Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;", "Companion", "PendingSeek", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewViewModel extends ViewModel {
    public static final int PREPARATION_ERROR_CODE = -1;
    private static final String VIDEO_MIME_TYPE = "video/mp4";
    private final MutableStateFlow<VideoArtifactPreviewState> _state;
    private boolean closed;
    private int latestSeekGeneration;
    private ArtifactResourceLease lease;
    private PendingSeek pendingSeekAfterPlaybackStarted;
    private boolean playRequested;
    private boolean playbackCompleted;
    private VideoArtifactPlayer player;
    private final VideoArtifactPreviewViewModel$playerListener$1 playerListener;
    private boolean playerWindowReady;
    private Job prepareJob;
    private final Function1<Continuation<? super ArtifactResourceResult>, Object> prepareOriginal;
    private final ArtifactOpenRequest request;
    private final StateFlow<VideoArtifactPreviewState> state;
    public static final int $stable = 8;

    public final ArtifactOpenRequest getRequest() {
        return this.request;
    }

    public VideoArtifactPreviewViewModel(ArtifactOpenRequest artifactOpenRequest, Function1<? super Continuation<? super ArtifactResourceResult>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(artifactOpenRequest, "request");
        Intrinsics.checkNotNullParameter(function1, "prepareOriginal");
        this.request = artifactOpenRequest;
        this.prepareOriginal = function1;
        MutableStateFlow<VideoArtifactPreviewState> MutableStateFlow = StateFlowKt.MutableStateFlow(VideoArtifactPreviewState.Preparing.INSTANCE);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        prepare();
        this.playerListener = new VideoArtifactPreviewViewModel$playerListener$1(this);
    }

    public final StateFlow<VideoArtifactPreviewState> getState() {
        return this.state;
    }

    public final void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        Job job = this.prepareJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        releaseResources();
    }

    public final void attachPlayer(VideoArtifactPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (this.closed || !(this.state.getValue() instanceof VideoArtifactPreviewState.Ready)) {
            player.release();
            return;
        }
        boolean z = this.playerWindowReady;
        releasePlayer();
        this.playerWindowReady = z;
        this.player = player;
        player.setListener(this.playerListener);
        Object value = this.state.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState.Ready");
        player.setSpeed(((VideoArtifactPreviewState.Ready) value).getPlaybackSpeed());
        startPlaybackIfReady();
    }

    public final void detachPlayer(VideoArtifactPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        if (this.player != player) {
            return;
        }
        releasePlayer();
    }

    public final void onPlayerWindowReady() {
        this.playerWindowReady = true;
        startPlaybackIfReady();
    }

    public final void onPlayerCreationFailed() {
        releaseResources();
        this._state.setValue(new VideoArtifactPreviewState.Failed(-1));
    }

    public final void saveToMediaLibrary(Function1<? super KmpMediaLibrarySaveResult, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        Object value = this.state.getValue();
        VideoArtifactPreviewState.Ready ready = value instanceof VideoArtifactPreviewState.Ready ? (VideoArtifactPreviewState.Ready) value : null;
        if (ready == null) {
            onComplete.invoke(new KmpMediaLibrarySaveResult(false, "Video is not ready"));
        } else {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VideoArtifactPreviewViewModel$saveToMediaLibrary$1(onComplete, ready, this, null), 3, (Object) null);
        }
    }

    public final void onAction(VideoArtifactPreviewAction action) {
        VideoArtifactPreviewState.Ready copy;
        long coerceAtLeast;
        VideoArtifactPreviewState.Ready copy2;
        VideoArtifactPreviewState.Ready copy3;
        VideoArtifactPreviewState.Ready copy4;
        VideoArtifactPreviewState.Ready copy5;
        VideoArtifactPreviewState.Ready copy6;
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, VideoArtifactPreviewAction.Reload.INSTANCE)) {
            prepare();
            return;
        }
        Object value = this.state.getValue();
        VideoArtifactPreviewState.Ready ready = value instanceof VideoArtifactPreviewState.Ready ? (VideoArtifactPreviewState.Ready) value : null;
        if (ready == null || Intrinsics.areEqual(action, VideoArtifactPreviewAction.Reload.INSTANCE)) {
            return;
        }
        if (Intrinsics.areEqual(action, VideoArtifactPreviewAction.TogglePlayback.INSTANCE)) {
            if (ready.isPlaying()) {
                VideoArtifactPlayer videoArtifactPlayer = this.player;
                if (videoArtifactPlayer != null) {
                    videoArtifactPlayer.pause();
                    return;
                }
                return;
            }
            if (this.playbackCompleted) {
                this.playbackCompleted = false;
                this.pendingSeekAfterPlaybackStarted = null;
                this.latestSeekGeneration++;
                MutableStateFlow<VideoArtifactPreviewState> mutableStateFlow = this._state;
                copy6 = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
                mutableStateFlow.setValue(copy6);
                VideoArtifactPlayer videoArtifactPlayer2 = this.player;
                if (videoArtifactPlayer2 != null) {
                    videoArtifactPlayer2.stop();
                }
            }
            VideoArtifactPlayer videoArtifactPlayer3 = this.player;
            if (videoArtifactPlayer3 != null) {
                videoArtifactPlayer3.play();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(action, VideoArtifactPreviewAction.OpenSpeedMenu.INSTANCE)) {
            MutableStateFlow<VideoArtifactPreviewState> mutableStateFlow2 = this._state;
            copy5 = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : true);
            mutableStateFlow2.setValue(copy5);
            return;
        }
        if (Intrinsics.areEqual(action, VideoArtifactPreviewAction.DismissSpeedMenu.INSTANCE)) {
            MutableStateFlow<VideoArtifactPreviewState> mutableStateFlow3 = this._state;
            copy4 = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
            mutableStateFlow3.setValue(copy4);
            return;
        }
        if (action instanceof VideoArtifactPreviewAction.DragTo) {
            MutableStateFlow<VideoArtifactPreviewState> mutableStateFlow4 = this._state;
            copy3 = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : RangesKt.coerceAtLeast(((VideoArtifactPreviewAction.DragTo) action).getPositionMs(), 0L), (r24 & 16) != 0 ? ready.isDragging : true, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
            mutableStateFlow4.setValue(copy3);
            return;
        }
        if (action instanceof VideoArtifactPreviewAction.SeekTo) {
            if (ready.getDurationMs() > 0) {
                coerceAtLeast = RangesKt.coerceIn(((VideoArtifactPreviewAction.SeekTo) action).getPositionMs(), 0L, ready.getDurationMs());
            } else {
                coerceAtLeast = RangesKt.coerceAtLeast(((VideoArtifactPreviewAction.SeekTo) action).getPositionMs(), 0L);
            }
            boolean z = this.playbackCompleted && coerceAtLeast < ready.getDurationMs();
            MutableStateFlow<VideoArtifactPreviewState> mutableStateFlow5 = this._state;
            copy2 = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : coerceAtLeast, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
            mutableStateFlow5.setValue(copy2);
            if (z) {
                this.playbackCompleted = false;
                int i = this.latestSeekGeneration + 1;
                this.latestSeekGeneration = i;
                this.pendingSeekAfterPlaybackStarted = new PendingSeek(coerceAtLeast, i);
                VideoArtifactPlayer videoArtifactPlayer4 = this.player;
                if (videoArtifactPlayer4 != null) {
                    videoArtifactPlayer4.stop();
                }
                VideoArtifactPlayer videoArtifactPlayer5 = this.player;
                if (videoArtifactPlayer5 != null) {
                    videoArtifactPlayer5.play();
                    return;
                }
                return;
            }
            this.pendingSeekAfterPlaybackStarted = null;
            int i2 = this.latestSeekGeneration + 1;
            this.latestSeekGeneration = i2;
            seekPlayer(coerceAtLeast, i2);
            return;
        }
        if (!(action instanceof VideoArtifactPreviewAction.SelectSpeed)) {
            throw new NoWhenBranchMatchedException();
        }
        VideoArtifactPlayer videoArtifactPlayer6 = this.player;
        if (videoArtifactPlayer6 != null) {
            videoArtifactPlayer6.setSpeed(((VideoArtifactPreviewAction.SelectSpeed) action).getSpeed());
        }
        MutableStateFlow<VideoArtifactPreviewState> mutableStateFlow6 = this._state;
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : 0L, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : ((VideoArtifactPreviewAction.SelectSpeed) action).getSpeed(), (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        mutableStateFlow6.setValue(copy);
    }

    private final void prepare() {
        if (this.closed) {
            return;
        }
        Job job = this.prepareJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        releaseResources();
        this._state.setValue(VideoArtifactPreviewState.Preparing.INSTANCE);
        this.prepareJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VideoArtifactPreviewViewModel$prepare$1(this, null), 3, (Object) null);
    }

    protected void onCleared() {
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleReady(ArtifactResourceResult.Ready ready, Continuation<? super Unit> continuation) {
        boolean isLocalMediaSource;
        if (!this.closed) {
            isLocalMediaSource = VideoArtifactPreviewViewModelKt.isLocalMediaSource(ready.getLocalUri());
            if (isLocalMediaSource) {
                this.lease = ready.getLease();
                this._state.setValue(new VideoArtifactPreviewState.Ready(ready.getLocalUri(), 0L, 0L, 0L, false, false, 0.0f, false, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null));
                return Unit.INSTANCE;
            }
        }
        ready.getLease().release();
        if (!this.closed) {
            this._state.setValue(new VideoArtifactPreviewState.Failed(-1));
        }
        return Unit.INSTANCE;
    }

    private final void releaseResources() {
        releasePlayer();
        ArtifactResourceLease artifactResourceLease = this.lease;
        if (artifactResourceLease != null) {
            artifactResourceLease.release();
        }
        this.lease = null;
    }

    private final void releasePlayer() {
        VideoArtifactPlayer videoArtifactPlayer = this.player;
        if (videoArtifactPlayer != null) {
            videoArtifactPlayer.setListener(null);
        }
        VideoArtifactPlayer videoArtifactPlayer2 = this.player;
        if (videoArtifactPlayer2 != null) {
            videoArtifactPlayer2.release();
        }
        this.player = null;
        this.playerWindowReady = false;
        this.playRequested = false;
        this.playbackCompleted = false;
        this.pendingSeekAfterPlaybackStarted = null;
        this.latestSeekGeneration++;
    }

    private final void startPlaybackIfReady() {
        VideoArtifactPlayer videoArtifactPlayer = this.player;
        if (videoArtifactPlayer == null || !this.playerWindowReady || this.playRequested) {
            return;
        }
        this.playRequested = true;
        videoArtifactPlayer.play();
    }

    private final void seekPlayer(final long positionMs, final int generation) {
        VideoArtifactPlayer videoArtifactPlayer = this.player;
        if (videoArtifactPlayer != null) {
            videoArtifactPlayer.seek(positionMs, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit seekPlayer$lambda$1;
                    seekPlayer$lambda$1 = VideoArtifactPreviewViewModel.seekPlayer$lambda$1(generation, this, positionMs, ((Boolean) obj).booleanValue());
                    return seekPlayer$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit seekPlayer$lambda$1(int i, VideoArtifactPreviewViewModel videoArtifactPreviewViewModel, final long j, boolean z) {
        if (z && i == videoArtifactPreviewViewModel.latestSeekGeneration) {
            videoArtifactPreviewViewModel.updateReady(new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    VideoArtifactPreviewState.Ready seekPlayer$lambda$1$lambda$0;
                    seekPlayer$lambda$1$lambda$0 = VideoArtifactPreviewViewModel.seekPlayer$lambda$1$lambda$0(j, (VideoArtifactPreviewState.Ready) obj);
                    return seekPlayer$lambda$1$lambda$0;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoArtifactPreviewState.Ready seekPlayer$lambda$1$lambda$0(long j, VideoArtifactPreviewState.Ready ready) {
        VideoArtifactPreviewState.Ready copy;
        Intrinsics.checkNotNullParameter(ready, "it");
        copy = ready.copy((r24 & 1) != 0 ? ready.localSource : null, (r24 & 2) != 0 ? ready.durationMs : 0L, (r24 & 4) != 0 ? ready.positionMs : j, (r24 & 8) != 0 ? ready.dragPositionMs : 0L, (r24 & 16) != 0 ? ready.isDragging : false, (r24 & 32) != 0 ? ready.isPlaying : false, (r24 & 64) != 0 ? ready.playbackSpeed : 0.0f, (r24 & 128) != 0 ? ready.showSpeedMenu : false);
        return copy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekAfterPlaybackStartedIfNeeded() {
        PendingSeek pendingSeek = this.pendingSeekAfterPlaybackStarted;
        if (pendingSeek == null) {
            return;
        }
        this.pendingSeekAfterPlaybackStarted = null;
        seekPlayer(pendingSeek.getPositionMs(), pendingSeek.getGeneration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReady(Function1<? super VideoArtifactPreviewState.Ready, VideoArtifactPreviewState.Ready> transform) {
        Object value = this.state.getValue();
        VideoArtifactPreviewState.Ready ready = value instanceof VideoArtifactPreviewState.Ready ? (VideoArtifactPreviewState.Ready) value : null;
        if (ready == null) {
            return;
        }
        this._state.setValue(transform.invoke(ready));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoArtifactPreviewViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$PendingSeek;", "", "positionMs", "", "generation", "", "<init>", "(JI)V", "getPositionMs", "()J", "getGeneration", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class PendingSeek {
        private final int generation;
        private final long positionMs;

        public static /* synthetic */ PendingSeek copy$default(PendingSeek pendingSeek, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = pendingSeek.positionMs;
            }
            if ((i2 & 2) != 0) {
                i = pendingSeek.generation;
            }
            return pendingSeek.copy(j, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPositionMs() {
            return this.positionMs;
        }

        /* renamed from: component2, reason: from getter */
        public final int getGeneration() {
            return this.generation;
        }

        public final PendingSeek copy(long positionMs, int generation) {
            return new PendingSeek(positionMs, generation);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingSeek)) {
                return false;
            }
            PendingSeek pendingSeek = (PendingSeek) other;
            return this.positionMs == pendingSeek.positionMs && this.generation == pendingSeek.generation;
        }

        public int hashCode() {
            return (Long.hashCode(this.positionMs) * 31) + Integer.hashCode(this.generation);
        }

        public String toString() {
            return "PendingSeek(positionMs=" + this.positionMs + ", generation=" + this.generation + ')';
        }

        public PendingSeek(long j, int i) {
            this.positionMs = j;
            this.generation = i;
        }

        public final long getPositionMs() {
            return this.positionMs;
        }

        public final int getGeneration() {
            return this.generation;
        }
    }
}
