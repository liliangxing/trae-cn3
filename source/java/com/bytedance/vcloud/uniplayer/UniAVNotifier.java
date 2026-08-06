package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;

/* compiled from: UniAVEngine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAVNotifier;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PLAYER_ON_ERROR", "METADATA_LOADED", "CACHED_BUFFER_UPDATE", "BUFFERING_START", "BUFFERING_END", "VIDEO_SIZE_CHANGED", "PLAYER_PAUSED", "SEEK_COMPLETE", "PLAY_COMPLETED", "FIRST_VIDEO_DREW", "POSITION_UPDATE", "PLAYER_RESUMED", "PLAYER_STOPPED", "AUDIO_INTERRUPTED", "PLAYER_STARTED", "PLAY_LOOP_END", "AUDIO_READY", "VIDEO_MODEL_FETCHED", "GEAR_SELECTED", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public enum UniAVNotifier {
    PLAYER_ON_ERROR(0),
    METADATA_LOADED(2),
    CACHED_BUFFER_UPDATE(3),
    BUFFERING_START(4),
    BUFFERING_END(5),
    VIDEO_SIZE_CHANGED(6),
    PLAYER_PAUSED(11),
    SEEK_COMPLETE(12),
    PLAY_COMPLETED(13),
    FIRST_VIDEO_DREW(30),
    POSITION_UPDATE(38),
    PLAYER_RESUMED(76),
    PLAYER_STOPPED(79),
    AUDIO_INTERRUPTED(89),
    PLAYER_STARTED(93),
    PLAY_LOOP_END(111),
    AUDIO_READY(600),
    VIDEO_MODEL_FETCHED(601),
    GEAR_SELECTED(602);

    private final int value;

    UniAVNotifier(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
