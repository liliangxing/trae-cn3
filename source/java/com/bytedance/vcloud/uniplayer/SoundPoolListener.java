package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;

/* compiled from: SoundPool.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/SoundPoolListener;", "", "onMetaLoaded", "", "soundId", "", "durationMs", "", "onPositionUpdate", "positionMs", "onReadyToPlay", "onSoundError", "code", "info", "", "onSoundFinished", "playAgain", "", "onSoundPaused", "onSoundResumed", "onSoundStarted", "onSoundStopped", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SoundPoolListener {

    /* compiled from: SoundPool.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static void onMetaLoaded(SoundPoolListener soundPoolListener, int i, long j) {
        }

        public static void onPositionUpdate(SoundPoolListener soundPoolListener, int i, long j) {
        }

        public static void onReadyToPlay(SoundPoolListener soundPoolListener, int i) {
        }

        public static void onSoundError(SoundPoolListener soundPoolListener, int i, int i2, String str) {
        }

        public static void onSoundFinished(SoundPoolListener soundPoolListener, int i, boolean z) {
        }

        public static void onSoundPaused(SoundPoolListener soundPoolListener, int i) {
        }

        public static void onSoundResumed(SoundPoolListener soundPoolListener, int i) {
        }

        public static void onSoundStarted(SoundPoolListener soundPoolListener, int i) {
        }

        public static void onSoundStopped(SoundPoolListener soundPoolListener, int i) {
        }
    }

    void onMetaLoaded(int soundId, long durationMs);

    void onPositionUpdate(int soundId, long positionMs);

    void onReadyToPlay(int soundId);

    void onSoundError(int soundId, int code, String info);

    void onSoundFinished(int soundId, boolean playAgain);

    void onSoundPaused(int soundId);

    void onSoundResumed(int soundId);

    void onSoundStarted(int soundId);

    void onSoundStopped(int soundId);
}
