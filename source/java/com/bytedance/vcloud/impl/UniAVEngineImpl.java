package com.bytedance.vcloud.impl;

import com.bytedance.vcloud.uniplayer.BufferingReason;
import com.bytedance.vcloud.uniplayer.PlayLoopListener;
import com.bytedance.vcloud.uniplayer.PlaybackListener;
import com.bytedance.vcloud.uniplayer.SeekMode;
import com.bytedance.vcloud.uniplayer.UniAVEngine;
import com.bytedance.vcloud.uniplayer.UniAVNotifier;
import com.bytedance.vcloud.uniplayer.UniAbConfig;
import com.bytedance.vcloud.uniplayer.UniAvExtraListener;
import com.bytedance.vcloud.uniplayer.UniDynIntCtrl;
import com.bytedance.vcloud.uniplayer.UniGearStreamType;
import com.bytedance.vcloud.uniplayer.UniGetFltKey;
import com.bytedance.vcloud.uniplayer.UniGetInt64Key;
import com.bytedance.vcloud.uniplayer.UniGetIntKey;
import com.bytedance.vcloud.uniplayer.UniInstConfig;
import com.bytedance.vcloud.uniplayer.UniWindowBinder;
import com.bytedance.vcloud.uniplayer.VideoModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.impl.markwon.customdata.CustomDataTagHandler;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniInternal.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 [2\u00020\u0001:\u0001[B#\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u0007\b\u0002¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+H\u0016J\u0018\u0010/\u001a\u00020%2\u0006\u0010,\u001a\u0002002\u0006\u0010.\u001a\u00020%H\u0016J\u0018\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u0002022\u0006\u0010.\u001a\u00020\u001fH\u0016J\u0006\u00103\u001a\u000204J\b\u00105\u001a\u00020\u001cH\u0016J(\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u00020\u001aH\u0016J\b\u0010=\u001a\u00020\u001aH\u0016J\b\u0010>\u001a\u00020\u001aH\u0016J\b\u0010?\u001a\u00020\u001aH\u0016J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0014H\u0016J:\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020D2 \u0010E\u001a\u001c\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001ej\u0004\u0018\u0001` H\u0016J\u0010\u0010F\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0011H\u0017J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u001cH\u0016J\u0018\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020\u001fH\u0016J\u0010\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020\u001cH\u0016J\u0010\u0010N\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0014H\u0017J\u0010\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u001cH\u0016J\u0010\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020+H\u0016J\u0010\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020+H\u0016J\u0010\u0010U\u001a\u00020\u001a2\u0006\u0010V\u001a\u00020\u001cH\u0016J\u001b\u0010W\u001a\u00020\u001a2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\bYJ\b\u0010Z\u001a\u00020%H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001ej\u0004\u0018\u0001` X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAVEngineImpl;", "Lcom/bytedance/vcloud/uniplayer/UniAVEngine;", "videoModel", "Lcom/bytedance/vcloud/uniplayer/VideoModel;", "abConfig", "Lcom/bytedance/vcloud/uniplayer/UniAbConfig;", "instConfig", "Lcom/bytedance/vcloud/uniplayer/UniInstConfig;", "(Lcom/bytedance/vcloud/uniplayer/VideoModel;Lcom/bytedance/vcloud/uniplayer/UniAbConfig;Lcom/bytedance/vcloud/uniplayer/UniInstConfig;)V", "()V", "bridge", "Lcom/bytedance/vcloud/impl/UniAvEngineNative;", "getBridge$uniplayer_release", "()Lcom/bytedance/vcloud/impl/UniAvEngineNative;", "setBridge$uniplayer_release", "(Lcom/bytedance/vcloud/impl/UniAvEngineNative;)V", "extraListener", "Lcom/bytedance/vcloud/uniplayer/UniAvExtraListener;", "playbackListenerSet", "Ljava/util/LinkedHashSet;", "Lcom/bytedance/vcloud/uniplayer/PlaybackListener;", "Lkotlin/collections/LinkedHashSet;", "playbackListeners", "", "releaseGate", "Lkotlin/Function0;", "", "released", "", "seekCompletionHandler", "Lkotlin/Function2;", "", "Lcom/bytedance/vcloud/uniplayer/UniSeekCompletion;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "clearListeners", "currentPosition", "", "dynIntCtrl", "ctrl", "Lcom/bytedance/vcloud/uniplayer/UniDynIntCtrl;", CustomDataTagHandler.VALUE_ATTRIBUTE, "getFloatValue", "", "key", "Lcom/bytedance/vcloud/uniplayer/UniGetFltKey;", "defaultValue", "getInt64Value", "Lcom/bytedance/vcloud/uniplayer/UniGetInt64Key;", "getIntValue", "Lcom/bytedance/vcloud/uniplayer/UniGetIntKey;", "getWindowBinder", "Lcom/bytedance/vcloud/uniplayer/UniWindowBinder;", "isPlaying", "notify", "what", "param1", "param2", "info", "", "pause", "play", "prepare", "release", "removeListener", "seek", "seekTimeMs", "seekMode", "Lcom/bytedance/vcloud/uniplayer/SeekMode;", "completionHandler", "setExtraListener", "setLoop", "loop", "setLoopRange", "startMs", "endMs", "setMute", "mute", "setPlaybackListener", "setRadio", "radio", "setSpeed", "speed", "setVolume", "volume", "stop", "savePosition", "updateReleaseGate", "gate", "updateReleaseGate$uniplayer_release", "watchedDuration", "Companion", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UniAVEngineImpl implements UniAVEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public UniAvEngineNative bridge;
    private UniAvExtraListener extraListener;
    private final LinkedHashSet<PlaybackListener> playbackListenerSet;
    private List<? extends PlaybackListener> playbackListeners;
    private Function0<Unit> releaseGate;
    private boolean released;
    private Function2<? super Integer, ? super Boolean, Unit> seekCompletionHandler;

    public /* synthetic */ UniAVEngineImpl(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private UniAVEngineImpl() {
        this.playbackListenerSet = new LinkedHashSet<>();
        this.playbackListeners = CollectionsKt.emptyList();
    }

    public final UniAvEngineNative getBridge$uniplayer_release() {
        UniAvEngineNative uniAvEngineNative = this.bridge;
        if (uniAvEngineNative != null) {
            return uniAvEngineNative;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bridge");
        return null;
    }

    public final void setBridge$uniplayer_release(UniAvEngineNative uniAvEngineNative) {
        Intrinsics.checkNotNullParameter(uniAvEngineNative, "<set-?>");
        this.bridge = uniAvEngineNative;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UniAVEngineImpl(VideoModel videoModel, UniAbConfig uniAbConfig, UniInstConfig uniInstConfig) {
        this();
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        setBridge$uniplayer_release(UniAVEngine_androidKt.createNativeEngine(videoModel, uniAbConfig, uniInstConfig, this));
        if (uniInstConfig != null) {
            uniInstConfig.close();
        }
    }

    /* compiled from: UniInternal.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/vcloud/impl/UniAVEngineImpl$Companion;", "", "()V", "attach", "Lcom/bytedance/vcloud/impl/UniAVEngineImpl;", "enginePtr", "", "releaseGate", "Lkotlin/Function0;", "", "attach$uniplayer_release", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniAVEngineImpl attach$uniplayer_release(long enginePtr, Function0<Unit> releaseGate) {
            Intrinsics.checkNotNullParameter(releaseGate, "releaseGate");
            UniAVEngineImpl uniAVEngineImpl = new UniAVEngineImpl(null);
            uniAVEngineImpl.setBridge$uniplayer_release(UniAVEngine_androidKt.attachNativeEngine(enginePtr, uniAVEngineImpl));
            uniAVEngineImpl.releaseGate = releaseGate;
            return uniAVEngineImpl;
        }
    }

    public final void updateReleaseGate$uniplayer_release(Function0<Unit> gate) {
        Intrinsics.checkNotNullParameter(gate, "gate");
        if (this.released) {
            return;
        }
        this.releaseGate = gate;
    }

    public final UniWindowBinder getWindowBinder() {
        return new UniWindowBinder(getBridge$uniplayer_release().getMNativeEngine(), new Function1<Long, Unit>() { // from class: com.bytedance.vcloud.impl.UniAVEngineImpl$getWindowBinder$1
            public final void invoke(long j) {
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void prepare() {
        getBridge$uniplayer_release().prepare();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void play() {
        getBridge$uniplayer_release().play();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void pause() {
        getBridge$uniplayer_release().pause();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void stop(boolean savePosition) {
        getBridge$uniplayer_release().stop(savePosition);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.seekCompletionHandler = null;
        this.extraListener = null;
        clearListeners();
        Function0<Unit> function0 = this.releaseGate;
        if (function0 != null) {
            this.releaseGate = null;
            function0.invoke();
        }
        getBridge$uniplayer_release().close();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public boolean isPlaying() {
        return getBridge$uniplayer_release().isPlaying();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public long currentPosition() {
        return getBridge$uniplayer_release().currentPosition();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public long watchedDuration() {
        return getBridge$uniplayer_release().watchedDuration();
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void setLoopRange(int startMs, int endMs) {
        getBridge$uniplayer_release().doExecute(UniDynIntCtrl.LOOP_START_TIME_MS.getValue(), startMs, 0L);
        getBridge$uniplayer_release().doExecute(UniDynIntCtrl.LOOP_END_TIME_MS.getValue(), endMs, 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void dynIntCtrl(UniDynIntCtrl ctrl, int value) {
        Intrinsics.checkNotNullParameter(ctrl, "ctrl");
        getBridge$uniplayer_release().doExecute(ctrl.getValue(), value, 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public int seek(long seekTimeMs, SeekMode seekMode, final Function2<? super Integer, ? super Boolean, Unit> completionHandler) {
        Function2<? super Integer, ? super Boolean, Unit> function2;
        Intrinsics.checkNotNullParameter(seekMode, "seekMode");
        final int seek = getBridge$uniplayer_release().seek(seekTimeMs, seekMode);
        if (seek >= 0 && (function2 = this.seekCompletionHandler) != null && function2 != null) {
            function2.invoke(-1, false);
        }
        this.seekCompletionHandler = new Function2<Integer, Boolean, Unit>() { // from class: com.bytedance.vcloud.impl.UniAVEngineImpl$seek$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, boolean z) {
                int i2 = i == -1 ? seek : i;
                Function2<Integer, Boolean, Unit> function22 = completionHandler;
                if (function22 != null) {
                    function22.invoke(Integer.valueOf(i2), Boolean.valueOf(seek == i && z));
                }
            }
        };
        return seek;
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void setLoop(boolean loop) {
        getBridge$uniplayer_release().doExecute(UniActionKey.CHANGE_LOOP_STATUS.getValue(), UniInternalKt.toLong(loop), 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void setMute(boolean mute) {
        getBridge$uniplayer_release().doExecute(UniActionKey.CHANGE_MUTE_STATUS.getValue(), UniInternalKt.toLong(mute), 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void setRadio(boolean radio) {
        getBridge$uniplayer_release().doExecute(UniActionKey.CHANGE_RADIO_MODE.getValue(), UniInternalKt.toLong(radio), 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void setSpeed(float speed) {
        getBridge$uniplayer_release().doExecute(UniActionKey.CHANGE_PLAY_SPEED.getValue(), speed * 1000, 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void setVolume(float volume) {
        getBridge$uniplayer_release().doExecute(UniActionKey.CHANGE_AUDIO_VOLUME.getValue(), volume * 1000, 0L);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public int getIntValue(UniGetIntKey key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getBridge$uniplayer_release().getIntValue(key.getValue(), defaultValue);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public long getInt64Value(UniGetInt64Key key, long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getBridge$uniplayer_release().getInt64Value(key.getValue(), defaultValue);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public float getFloatValue(UniGetFltKey key, float defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getBridge$uniplayer_release().getFloatValue(key.getValue(), defaultValue);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    @Deprecated(message = "Deprecated. Will be removed in a future release.")
    public void setExtraListener(UniAvExtraListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.released) {
            return;
        }
        this.extraListener = listener;
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    @Deprecated(message = "Use addListener/removeListener/clearListeners instead.", replaceWith = @ReplaceWith(expression = "addListener(listener)", imports = {}))
    public void setPlaybackListener(PlaybackListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        addListener(listener);
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void addListener(PlaybackListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.released && this.playbackListenerSet.add(listener)) {
            this.playbackListeners = CollectionsKt.toList(this.playbackListenerSet);
        }
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void removeListener(PlaybackListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.playbackListenerSet.remove(listener)) {
            this.playbackListeners = CollectionsKt.toList(this.playbackListenerSet);
        }
    }

    @Override // com.bytedance.vcloud.uniplayer.UniAVEngine
    public void clearListeners() {
        if (!this.playbackListenerSet.isEmpty()) {
            this.playbackListenerSet.clear();
            this.playbackListeners = CollectionsKt.emptyList();
        }
    }

    public final void notify(int what, long param1, long param2, String info) {
        PlayLoopListener playLoopListener;
        if (this.released) {
            return;
        }
        List<? extends PlaybackListener> list = this.playbackListeners;
        if (what == UniAVNotifier.SEEK_COMPLETE.getValue()) {
            Function2<? super Integer, ? super Boolean, Unit> function2 = this.seekCompletionHandler;
            if (function2 != null) {
                function2.invoke(Integer.valueOf((int) param1), Boolean.valueOf(param2 == 1));
            }
            this.seekCompletionHandler = null;
            return;
        }
        if (what != UniAVNotifier.PLAYER_ON_ERROR.getValue()) {
            if (what != UniAVNotifier.METADATA_LOADED.getValue()) {
                if (what != UniAVNotifier.CACHED_BUFFER_UPDATE.getValue()) {
                    if (what != UniAVNotifier.BUFFERING_START.getValue()) {
                        if (what != UniAVNotifier.BUFFERING_END.getValue()) {
                            if (what != UniAVNotifier.VIDEO_SIZE_CHANGED.getValue()) {
                                if (what != UniAVNotifier.FIRST_VIDEO_DREW.getValue()) {
                                    if (what != UniAVNotifier.POSITION_UPDATE.getValue()) {
                                        if (what != UniAVNotifier.PLAYER_STARTED.getValue()) {
                                            if (what != UniAVNotifier.PLAYER_PAUSED.getValue()) {
                                                if (what != UniAVNotifier.PLAYER_STOPPED.getValue()) {
                                                    if (what != UniAVNotifier.PLAYER_RESUMED.getValue()) {
                                                        if (what != UniAVNotifier.PLAY_COMPLETED.getValue()) {
                                                            if (what != UniAVNotifier.PLAY_LOOP_END.getValue()) {
                                                                if (what != UniAVNotifier.AUDIO_READY.getValue()) {
                                                                    if (what == UniAVNotifier.GEAR_SELECTED.getValue()) {
                                                                        if (info == null) {
                                                                            info = "";
                                                                        }
                                                                        UniGearStreamType fromValue = UniGearStreamType.INSTANCE.fromValue((int) param2);
                                                                        Iterator<T> it = list.iterator();
                                                                        while (it.hasNext()) {
                                                                            ((PlaybackListener) it.next()).onGearSelected(info, param1, fromValue);
                                                                        }
                                                                        return;
                                                                    }
                                                                    System.out.println((Object) ("notify what:" + what + ",param1:" + param1 + ",param2:" + param2));
                                                                    return;
                                                                }
                                                                Iterator<T> it2 = list.iterator();
                                                                while (it2.hasNext()) {
                                                                    ((PlaybackListener) it2.next()).onAudioReady();
                                                                }
                                                                return;
                                                            }
                                                            Iterator<T> it3 = list.iterator();
                                                            while (it3.hasNext()) {
                                                                ((PlaybackListener) it3.next()).onLoopEnd(param1 > 0);
                                                            }
                                                            UniAvExtraListener uniAvExtraListener = this.extraListener;
                                                            if (uniAvExtraListener == null || (playLoopListener = uniAvExtraListener.getPlayLoopListener()) == null) {
                                                                return;
                                                            }
                                                            playLoopListener.onLoopEnd(param1 > 0);
                                                            return;
                                                        }
                                                        Iterator<T> it4 = list.iterator();
                                                        while (it4.hasNext()) {
                                                            ((PlaybackListener) it4.next()).onPlaybackCompleted(param1 > 0);
                                                        }
                                                        return;
                                                    }
                                                    Iterator<T> it5 = list.iterator();
                                                    while (it5.hasNext()) {
                                                        ((PlaybackListener) it5.next()).onPlaybackResumed();
                                                    }
                                                    return;
                                                }
                                                Iterator<T> it6 = list.iterator();
                                                while (it6.hasNext()) {
                                                    ((PlaybackListener) it6.next()).onPlaybackStopped();
                                                }
                                                return;
                                            }
                                            Iterator<T> it7 = list.iterator();
                                            while (it7.hasNext()) {
                                                ((PlaybackListener) it7.next()).onPlaybackPaused();
                                            }
                                            return;
                                        }
                                        Iterator<T> it8 = list.iterator();
                                        while (it8.hasNext()) {
                                            ((PlaybackListener) it8.next()).onPlaybackStarted();
                                        }
                                        return;
                                    }
                                    Iterator<T> it9 = list.iterator();
                                    while (it9.hasNext()) {
                                        ((PlaybackListener) it9.next()).onPlaybackPositionUpdated(param1);
                                    }
                                    return;
                                }
                                Iterator<T> it10 = list.iterator();
                                while (it10.hasNext()) {
                                    ((PlaybackListener) it10.next()).onFirstVideoFrameDrew();
                                }
                                return;
                            }
                            Iterator<T> it11 = list.iterator();
                            while (it11.hasNext()) {
                                ((PlaybackListener) it11.next()).onVideoSizeChanged((int) param1, (int) param2);
                            }
                            return;
                        }
                        Iterator<T> it12 = list.iterator();
                        while (it12.hasNext()) {
                            ((PlaybackListener) it12.next()).onBufferingEnded();
                        }
                        return;
                    }
                    Iterator<T> it13 = list.iterator();
                    while (it13.hasNext()) {
                        ((PlaybackListener) it13.next()).onBufferingStarted(BufferingReason.Default);
                    }
                    return;
                }
                Iterator<T> it14 = list.iterator();
                while (it14.hasNext()) {
                    ((PlaybackListener) it14.next()).onCacheUpdate((int) param1);
                }
                return;
            }
            Iterator<T> it15 = list.iterator();
            while (it15.hasNext()) {
                ((PlaybackListener) it15.next()).onMetadataLoaded(param1);
            }
            return;
        }
        Iterator<T> it16 = list.iterator();
        while (it16.hasNext()) {
            ((PlaybackListener) it16.next()).onError((int) param1);
        }
    }
}
