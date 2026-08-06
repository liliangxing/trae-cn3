package com.bytedance.vcloud.uniplayer;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: SoundPool.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&¨\u0006!"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/SoundPool;", "Ljava/lang/AutoCloseable;", "clearAll", "", "close", "getCurrentPos", "", "soundId", "", "load", "source", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "config", "Lcom/bytedance/vcloud/uniplayer/SoundConfig;", "url", "", "newConfig", SchemaConstants.QUERY_KEY_REUSE, "", "pause", "play", "release", "seek", "positionMs", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/vcloud/uniplayer/SoundSeekCallback;", "setVolume", "volume", "", "subscribe", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/vcloud/uniplayer/SoundPoolListener;", "unsubscribe", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface SoundPool extends AutoCloseable {
    void clearAll();

    @Override // java.lang.AutoCloseable
    void close();

    long getCurrentPos(int soundId);

    int load(VideoModel source, SoundConfig config);

    int load(String url, SoundConfig config);

    SoundConfig newConfig(boolean reuse);

    void pause(int soundId);

    void play(int soundId);

    void release(int soundId);

    int seek(int soundId, long positionMs, SoundSeekCallback callback);

    void setVolume(int soundId, float volume);

    void subscribe(SoundPoolListener listener);

    void unsubscribe(SoundPoolListener listener);

    /* compiled from: SoundPool.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ int load$default(SoundPool soundPool, VideoModel videoModel, SoundConfig soundConfig, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
            }
            if ((i & 2) != 0) {
                soundConfig = null;
            }
            return soundPool.load(videoModel, soundConfig);
        }

        public static /* synthetic */ int load$default(SoundPool soundPool, String str, SoundConfig soundConfig, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: load");
            }
            if ((i & 2) != 0) {
                soundConfig = null;
            }
            return soundPool.load(str, soundConfig);
        }

        public static /* synthetic */ int seek$default(SoundPool soundPool, int i, long j, SoundSeekCallback soundSeekCallback, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seek");
            }
            if ((i2 & 4) != 0) {
                soundSeekCallback = null;
            }
            return soundPool.seek(i, j, soundSeekCallback);
        }
    }
}
