package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.SoundConfig;
import com.bytedance.vcloud.uniplayer.SoundPool;
import com.bytedance.vcloud.uniplayer.SoundPoolListener;
import com.bytedance.vcloud.uniplayer.SoundSeekCallback;
import com.bytedance.vcloud.uniplayer.UniAVNotifier;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.VideoModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoundPoolImpl.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0016H\u0002J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\"\u0010&\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010)\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J \u0010-\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020 H\u0002J\u0010\u00100\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u00101\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u00103\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u00104\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\"\u00105\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u00107\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\rH\u0016J\u0010\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/vcloud/impl/UniSoundPoolImpl;", "Lcom/bytedance/vcloud/uniplayer/SoundPool;", "tag", "", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "(Ljava/lang/String;Lcom/bytedance/vcloud/uniplayer/UniInstConfig;)V", "bridge", "Lcom/bytedance/vcloud/impl/SoundPoolBridge;", "callback", "Lcom/bytedance/vcloud/impl/SoundPoolCallbackBridge;", "listeners", "", "Lcom/bytedance/vcloud/uniplayer/SoundPoolListener;", "seekCbs", "", "", "Lcom/bytedance/vcloud/uniplayer/SoundSeekCallback;", "clearAll", "", "close", "getCurrentPos", "", "soundId", "load", "source", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "config", "Lcom/bytedance/vcloud/uniplayer/SoundConfig;", "url", "newConfig", "reuse", "", "onMetaLoaded", "durationMs", "onPositionUpdate", "pos", "onReadyToPlay", "onSoundError", "code", "info", "onSoundFinished", "playAgain", "onSoundPaused", "onSoundResumed", "onSoundSeekEnd", "seekId", "ok", "onSoundStarted", "onSoundStopped", "pause", "play", "release", "seek", "positionMs", "setVolume", "volume", "", "subscribe", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unsubscribe", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniSoundPoolImpl implements SoundPool {
    private final SoundPoolBridge bridge;
    private final SoundPoolCallbackBridge callback;
    private final Set<SoundPoolListener> listeners;
    private final Map<Integer, SoundSeekCallback> seekCbs;

    public UniSoundPoolImpl(String str, UniInstConfig uniInstConfig) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(uniInstConfig, "instConfig");
        SoundPoolBridge newSoundPoolBridge = SoundPool_androidKt.newSoundPoolBridge(str, uniInstConfig);
        this.bridge = newSoundPoolBridge;
        this.listeners = new LinkedHashSet();
        this.seekCbs = new LinkedHashMap();
        SoundPoolCallbackBridge soundPoolCallbackBridge = new SoundPoolCallbackBridge() { // from class: com.bytedance.vcloud.impl.UniSoundPoolImpl$$ExternalSyntheticLambda0
            @Override // com.bytedance.vcloud.impl.SoundPoolCallbackBridge
            public final void onNotify(int i, int i2, long j, long j2, String str2) {
                UniSoundPoolImpl.callback$lambda$0(UniSoundPoolImpl.this, i, i2, j, j2, str2);
            }
        };
        this.callback = soundPoolCallbackBridge;
        newSoundPoolBridge.attachCallback(soundPoolCallbackBridge);
        uniInstConfig.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callback$lambda$0(UniSoundPoolImpl uniSoundPoolImpl, int i, int i2, long j, long j2, String str) {
        if (i2 == UniAVNotifier.PLAYER_ON_ERROR.getValue()) {
            uniSoundPoolImpl.onSoundError(i, (int) j, str);
            return;
        }
        if (i2 == UniAVNotifier.METADATA_LOADED.getValue()) {
            uniSoundPoolImpl.onMetaLoaded(i, j);
            return;
        }
        if (i2 == UniAVNotifier.PLAYER_STARTED.getValue()) {
            uniSoundPoolImpl.onSoundStarted(i);
            return;
        }
        if (i2 == UniAVNotifier.AUDIO_READY.getValue()) {
            uniSoundPoolImpl.onReadyToPlay(i);
            return;
        }
        if (i2 == UniAVNotifier.SEEK_COMPLETE.getValue()) {
            uniSoundPoolImpl.onSoundSeekEnd(i, (int) j, j2 != 0);
            return;
        }
        if (i2 == UniAVNotifier.PLAY_COMPLETED.getValue()) {
            uniSoundPoolImpl.onSoundFinished(i, j != 0);
            return;
        }
        if (i2 == UniAVNotifier.PLAYER_STOPPED.getValue()) {
            uniSoundPoolImpl.onSoundStopped(i);
            return;
        }
        if (i2 == UniAVNotifier.POSITION_UPDATE.getValue()) {
            uniSoundPoolImpl.onPositionUpdate(i, j);
        } else if (i2 == UniAVNotifier.PLAYER_PAUSED.getValue()) {
            uniSoundPoolImpl.onSoundPaused(i);
        } else if (i2 == UniAVNotifier.PLAYER_RESUMED.getValue()) {
            uniSoundPoolImpl.onSoundResumed(i);
        }
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public SoundConfig newConfig(boolean reuse) {
        return new SoundConfigImpl(reuse);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public int load(VideoModel source, SoundConfig config) {
        Intrinsics.checkNotNullParameter(source, "source");
        SoundConfigImpl soundConfigImpl = config instanceof SoundConfigImpl ? (SoundConfigImpl) config : null;
        int load = this.bridge.load(source, soundConfigImpl != null ? soundConfigImpl.getMConfig() : null);
        if (soundConfigImpl != null) {
            soundConfigImpl.markUsed$uniplayer_release();
        }
        return load;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public int load(String url, SoundConfig config) {
        Intrinsics.checkNotNullParameter(url, "url");
        VideoModel fromKeyUrl$default = VideoModel.Companion.fromKeyUrl$default(VideoModel.INSTANCE, url, url, null, false, null, null, 60, null);
        int load = load(fromKeyUrl$default, config);
        fromKeyUrl$default.close();
        return load;
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void play(int soundId) {
        this.bridge.play(soundId);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void setVolume(int soundId, float volume) {
        this.bridge.setVolume(soundId, volume);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public int seek(int soundId, long positionMs, final SoundSeekCallback callback) {
        SoundSeekCallback remove = this.seekCbs.remove(Integer.valueOf(soundId));
        final int seek = this.bridge.seek(soundId, positionMs);
        if (remove != null) {
            remove.invoke(soundId, 0, false);
        }
        if (seek < 0) {
            if (callback != null) {
                callback.invoke(soundId, seek, false);
            }
        } else if (callback != null) {
            SoundSeekCallback soundSeekCallback = new SoundSeekCallback() { // from class: com.bytedance.vcloud.impl.UniSoundPoolImpl$$ExternalSyntheticLambda1
                @Override // com.bytedance.vcloud.uniplayer.SoundSeekCallback
                public final void invoke(int i, int i2, boolean z) {
                    UniSoundPoolImpl.seek$lambda$2(seek, callback, i, i2, z);
                }
            };
            this.seekCbs.put(Integer.valueOf(soundId), soundSeekCallback);
        }
        return seek;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void seek$lambda$2(int i, SoundSeekCallback soundSeekCallback, int i2, int i3, boolean z) {
        Integer valueOf = Integer.valueOf(i3);
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        }
        soundSeekCallback.invoke(i2, i, z);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public long getCurrentPos(int soundId) {
        return this.bridge.getCurrentPos(soundId);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void pause(int soundId) {
        this.bridge.pause(soundId);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void release(int soundId) {
        this.bridge.release(soundId);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void clearAll() {
        this.bridge.clearAll();
        this.listeners.clear();
        this.seekCbs.clear();
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool, java.lang.AutoCloseable
    public void close() {
        clearAll();
        this.bridge.close();
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void subscribe(SoundPoolListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.add(listener);
    }

    @Override // com.bytedance.vcloud.uniplayer.SoundPool
    public void unsubscribe(SoundPoolListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listeners.remove(listener);
    }

    private final void onMetaLoaded(int soundId, long durationMs) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onMetaLoaded(soundId, durationMs);
        }
    }

    private final void onReadyToPlay(int soundId) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onReadyToPlay(soundId);
        }
    }

    private final void onSoundStarted(int soundId) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onSoundStarted(soundId);
        }
    }

    private final void onSoundSeekEnd(int soundId, int seekId, boolean ok) {
        SoundSeekCallback remove = this.seekCbs.remove(Integer.valueOf(soundId));
        if (remove != null) {
            remove.invoke(soundId, seekId, ok);
        }
    }

    private final void onSoundFinished(int soundId, boolean playAgain) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onSoundFinished(soundId, playAgain);
        }
    }

    private final void onSoundPaused(int soundId) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onSoundPaused(soundId);
        }
    }

    private final void onSoundResumed(int soundId) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onSoundResumed(soundId);
        }
    }

    private final void onSoundStopped(int soundId) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onSoundStopped(soundId);
        }
    }

    private final void onSoundError(int soundId, int code, String info) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onSoundError(soundId, code, info);
        }
    }

    private final void onPositionUpdate(int soundId, long pos) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((SoundPoolListener) it.next()).onPositionUpdate(soundId, pos);
        }
    }
}
