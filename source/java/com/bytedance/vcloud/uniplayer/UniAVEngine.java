package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.impl.UniAVEngineImpl;
import com.bytedance.vcloud.uniplayer.VideoModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniAVEngine.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u0000 82\u00020\u0001:\u00018J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000fH&J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00162\b\b\u0002\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J:\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!2 \u0010\"\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010#j\u0004\u0018\u0001`$H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020&H'J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0018H&J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0018H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0018H&J\u0010\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u000fH&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u000fH&J\u0012\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u0018H&J\b\u00107\u001a\u00020\bH&¨\u00069"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/vcloud/uniplayer/PlaybackListener;", "clearListeners", "currentPosition", "", "dynIntCtrl", "ctrl", "Lcom/bytedance/vcloud/uniplayer/UniDynIntCtrl;", CustomDataTagHandler.VALUE_ATTRIBUTE, "", "getFloatValue", "", "key", "Lcom/bytedance/vcloud/uniplayer/UniGetFltKey;", "defaultValue", "getInt64Value", "Lcom/bytedance/vcloud/uniplayer/UniGetInt64Key;", "getIntValue", "Lcom/bytedance/vcloud/uniplayer/UniGetIntKey;", "isPlaying", "", "pause", "play", "prepare", "release", "removeListener", "seek", "seekTimeMs", "seekMode", "Lcom/bytedance/vcloud/uniplayer/SeekMode;", "completionHandler", "Lkotlin/Function2;", "Lcom/bytedance/vcloud/uniplayer/UniSeekCompletion;", "setExtraListener", "Lcom/bytedance/vcloud/uniplayer/UniAvExtraListener;", "setLoop", "loop", "setLoopRange", "startMs", "endMs", "setMute", "mute", "setPlaybackListener", "setRadio", "radio", "setSpeed", "speed", "setVolume", "volume", "stop", "savePosition", "watchedDuration", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface UniAVEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void addListener(PlaybackListener listener);

    void clearListeners();

    long currentPosition();

    void dynIntCtrl(UniDynIntCtrl ctrl, int value);

    float getFloatValue(UniGetFltKey key, float defaultValue);

    long getInt64Value(UniGetInt64Key key, long defaultValue);

    int getIntValue(UniGetIntKey key, int defaultValue);

    boolean isPlaying();

    void pause();

    void play();

    void prepare();

    void release();

    void removeListener(PlaybackListener listener);

    int seek(long seekTimeMs, SeekMode seekMode, Function2<? super Integer, ? super Boolean, Unit> completionHandler);

    @Deprecated(message = "Deprecated. Will be removed in a future release.")
    void setExtraListener(UniAvExtraListener listener);

    void setLoop(boolean loop);

    void setLoopRange(int startMs, int endMs);

    void setMute(boolean mute);

    @Deprecated(message = "Use addListener/removeListener/clearListeners instead.", replaceWith = @ReplaceWith(expression = "addListener(listener)", imports = {}))
    void setPlaybackListener(PlaybackListener listener);

    void setRadio(boolean radio);

    void setSpeed(float speed);

    void setVolume(float volume);

    void stop(boolean savePosition);

    long watchedDuration();

    /* compiled from: UniAVEngine.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void stop$default(UniAVEngine uniAVEngine, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stop");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            uniAVEngine.stop(z);
        }

        public static /* synthetic */ int getIntValue$default(UniAVEngine uniAVEngine, UniGetIntKey uniGetIntKey, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntValue");
            }
            if ((i2 & 2) != 0) {
                i = Integer.MIN_VALUE;
            }
            return uniAVEngine.getIntValue(uniGetIntKey, i);
        }

        public static /* synthetic */ long getInt64Value$default(UniAVEngine uniAVEngine, UniGetInt64Key uniGetInt64Key, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInt64Value");
            }
            if ((i & 2) != 0) {
                j = Long.MIN_VALUE;
            }
            return uniAVEngine.getInt64Value(uniGetInt64Key, j);
        }

        public static /* synthetic */ float getFloatValue$default(UniAVEngine uniAVEngine, UniGetFltKey uniGetFltKey, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatValue");
            }
            if ((i & 2) != 0) {
                f = Float.MIN_VALUE;
            }
            return uniAVEngine.getFloatValue(uniGetFltKey, f);
        }
    }

    /* compiled from: UniAVEngine.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/UniAVEngine$Companion;", "", "()V", "create", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "abConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "url", "", "createVideoModelFromUrl", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final VideoModel createVideoModelFromUrl(String url) {
            return VideoModel.Companion.fromKeyUrl$default(VideoModel.INSTANCE, url, url, null, false, null, null, 60, null);
        }

        public final UniAVEngine create(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            UniAbConfig create = UniAbConfig.INSTANCE.create();
            VideoModel createVideoModelFromUrl = createVideoModelFromUrl(url);
            UniAVEngineImpl uniAVEngineImpl = new UniAVEngineImpl(createVideoModelFromUrl, create, null);
            create.close();
            createVideoModelFromUrl.close();
            return uniAVEngineImpl;
        }

        public final UniAVEngine create(String url, UniAbConfig abConfig) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(abConfig, "abConfig");
            VideoModel createVideoModelFromUrl = createVideoModelFromUrl(url);
            UniAVEngineImpl uniAVEngineImpl = new UniAVEngineImpl(createVideoModelFromUrl, abConfig, null);
            createVideoModelFromUrl.close();
            return uniAVEngineImpl;
        }

        public final UniAVEngine create(String url, UniAbConfig abConfig, UniInstConfig instConfig) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(abConfig, "abConfig");
            Intrinsics.checkNotNullParameter(instConfig, "instConfig");
            VideoModel createVideoModelFromUrl = createVideoModelFromUrl(url);
            UniAVEngineImpl uniAVEngineImpl = new UniAVEngineImpl(createVideoModelFromUrl, abConfig, instConfig);
            createVideoModelFromUrl.close();
            return uniAVEngineImpl;
        }

        public final UniAVEngine create(VideoModel videoModel) {
            Intrinsics.checkNotNullParameter(videoModel, "videoModel");
            UniAbConfig create = UniAbConfig.INSTANCE.create();
            UniAVEngineImpl uniAVEngineImpl = new UniAVEngineImpl(videoModel, create, null);
            create.close();
            return uniAVEngineImpl;
        }

        public final UniAVEngine create(VideoModel videoModel, UniInstConfig instConfig) {
            Intrinsics.checkNotNullParameter(videoModel, "videoModel");
            Intrinsics.checkNotNullParameter(instConfig, "instConfig");
            return new UniAVEngineImpl(videoModel, null, instConfig);
        }

        public final UniAVEngine create(VideoModel videoModel, UniAbConfig abConfig) {
            Intrinsics.checkNotNullParameter(videoModel, "videoModel");
            Intrinsics.checkNotNullParameter(abConfig, "abConfig");
            return new UniAVEngineImpl(videoModel, abConfig, null);
        }

        public final UniAVEngine create(VideoModel videoModel, UniAbConfig abConfig, UniInstConfig instConfig) {
            Intrinsics.checkNotNullParameter(videoModel, "videoModel");
            Intrinsics.checkNotNullParameter(abConfig, "abConfig");
            Intrinsics.checkNotNullParameter(instConfig, "instConfig");
            return new UniAVEngineImpl(videoModel, abConfig, instConfig);
        }
    }
}
