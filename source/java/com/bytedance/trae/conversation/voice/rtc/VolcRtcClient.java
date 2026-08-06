package com.bytedance.trae.conversation.voice.rtc;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.data.AudioPropertiesConfig;
import com.ss.bytertc.engine.data.AudioPropertiesInfo;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.LocalAudioPropertiesInfo;
import com.ss.bytertc.engine.type.AnsMode;
import com.ss.bytertc.engine.type.AudioDeviceType;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.NetworkQualityStats;
import com.ss.bytertc.engine.type.RoomProfile;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VolcRtcClient.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004ABCDB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u001c\u0010\u000f\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b J\u001f\u0010!\u001a\u00020\f2\u0010\u0010\"\u001a\f\u0012\u0006\b\u0001\u0012\u00020$\u0018\u00010#H\u0002¢\u0006\u0002\u0010%J(\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0013H\u0002J\f\u0010,\u001a\u00020-*\u00020.H\u0002J\u0016\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aJ\u000e\u00106\u001a\u0002072\u0006\u00101\u001a\u00020\u001aJ\u0006\u00108\u001a\u00020\fJ\u0006\u00109\u001a\u00020\fJ\b\u0010:\u001a\u00020\u001aH\u0002J\u0006\u0010;\u001a\u00020\fJ\u0006\u0010<\u001a\u00020\fJ\f\u0010=\u001a\u000202*\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;", "", "<init>", "()V", "currentCaller", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;", "callerLock", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;", "addListener", "", "listener", "removeListener", "notifyListeners", "action", "Lkotlin/Function1;", "liveListenerCount", "", "engine", "Lcom/ss/bytertc/engine/RTCEngine;", "rtcRoom", "Lcom/ss/bytertc/engine/RTCRoom;", "preloadEngine", "appId", "", "join", "", "voiceChat", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "caller", "join$conversation_mainlandRelease", "notifyLocalAudioProperties", "audioPropertiesInfos", "", "Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;", "([Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;)V", "notifyAudioInputDeviceState", "deviceId", "deviceType", "Lcom/ss/bytertc/engine/type/AudioDeviceType;", "deviceState", "deviceError", "toRtcNetworkQuality", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;", "Lcom/ss/bytertc/engine/type/NetworkQualityStats;", "sendUserBinaryMessageToBot", "botUserId", "message", "", "setServerParams", "signature", IWeixinService.ResponseConstants.URL, "sendServerMessage", "", "startAudioCapture", "stopAudioCapture", "audioCaptureStateSummary", "leaveRoom", "leave", "toByteArraySafely", "Ljava/nio/ByteBuffer;", "rtcDiag", "TAG", "RtcLocalAudioProperties", "RtcNetworkQuality", "CallerType", "Listener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VolcRtcClient {
    private static final String TAG = "VolcRtcClient";
    private static volatile CallerType currentCaller;
    private static RTCEngine engine;
    private static RTCRoom rtcRoom;
    public static final VolcRtcClient INSTANCE = new VolcRtcClient();
    private static final Object callerLock = new Object();
    private static final CopyOnWriteArrayList<WeakReference<Listener>> listeners = new CopyOnWriteArrayList<>();

    /* compiled from: VolcRtcClient.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0016J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;", "", "onJoinedRoom", "", "roomId", "", "onRoomBinaryMessage", "uid", "message", "", "onUserMessage", "onError", "error", "", "onServerParamsSetResult", "", "onLocalAudioLevel", "volume", "onLocalAudioProperties", "properties", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;", "onNetworkQuality", "local", "Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;", "remotes", "", "onAudioInputDeviceStateChanged", "deviceId", "state", "onRemoteUserJoined", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface Listener {

        /* compiled from: VolcRtcClient.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class DefaultImpls {
            public static void onAudioInputDeviceStateChanged(Listener listener, String str, int i, int i2) {
                Intrinsics.checkNotNullParameter(str, "deviceId");
            }

            public static void onLocalAudioLevel(Listener listener, int i) {
            }

            public static void onLocalAudioProperties(Listener listener, RtcLocalAudioProperties rtcLocalAudioProperties) {
                Intrinsics.checkNotNullParameter(rtcLocalAudioProperties, "properties");
            }

            public static void onNetworkQuality(Listener listener, RtcNetworkQuality rtcNetworkQuality, List<RtcNetworkQuality> list) {
                Intrinsics.checkNotNullParameter(rtcNetworkQuality, "local");
                Intrinsics.checkNotNullParameter(list, "remotes");
            }

            public static void onRemoteUserJoined(Listener listener, String str) {
                Intrinsics.checkNotNullParameter(str, "uid");
            }
        }

        void onAudioInputDeviceStateChanged(String deviceId, int state, int error);

        void onError(Throwable error);

        void onJoinedRoom(String roomId);

        void onLocalAudioLevel(int volume);

        void onLocalAudioProperties(RtcLocalAudioProperties properties);

        void onNetworkQuality(RtcNetworkQuality local, List<RtcNetworkQuality> remotes);

        void onRemoteUserJoined(String uid);

        void onRoomBinaryMessage(String uid, byte[] message);

        void onServerParamsSetResult(int error);

        void onUserMessage(String uid, String message);
    }

    private VolcRtcClient() {
    }

    /* compiled from: VolcRtcClient.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;", "", "linearVolume", "", "nonlinearVolume", "vad", "timestampMs", "", "<init>", "(IIIJ)V", "getLinearVolume", "()I", "getNonlinearVolume", "getVad", "getTimestampMs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RtcLocalAudioProperties {
        private final int linearVolume;
        private final int nonlinearVolume;
        private final long timestampMs;
        private final int vad;

        public static /* synthetic */ RtcLocalAudioProperties copy$default(RtcLocalAudioProperties rtcLocalAudioProperties, int i, int i2, int i3, long j, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = rtcLocalAudioProperties.linearVolume;
            }
            if ((i4 & 2) != 0) {
                i2 = rtcLocalAudioProperties.nonlinearVolume;
            }
            int i5 = i2;
            if ((i4 & 4) != 0) {
                i3 = rtcLocalAudioProperties.vad;
            }
            int i6 = i3;
            if ((i4 & 8) != 0) {
                j = rtcLocalAudioProperties.timestampMs;
            }
            return rtcLocalAudioProperties.copy(i, i5, i6, j);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLinearVolume() {
            return this.linearVolume;
        }

        /* renamed from: component2, reason: from getter */
        public final int getNonlinearVolume() {
            return this.nonlinearVolume;
        }

        /* renamed from: component3, reason: from getter */
        public final int getVad() {
            return this.vad;
        }

        /* renamed from: component4, reason: from getter */
        public final long getTimestampMs() {
            return this.timestampMs;
        }

        public final RtcLocalAudioProperties copy(int linearVolume, int nonlinearVolume, int vad, long timestampMs) {
            return new RtcLocalAudioProperties(linearVolume, nonlinearVolume, vad, timestampMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RtcLocalAudioProperties)) {
                return false;
            }
            RtcLocalAudioProperties rtcLocalAudioProperties = (RtcLocalAudioProperties) other;
            return this.linearVolume == rtcLocalAudioProperties.linearVolume && this.nonlinearVolume == rtcLocalAudioProperties.nonlinearVolume && this.vad == rtcLocalAudioProperties.vad && this.timestampMs == rtcLocalAudioProperties.timestampMs;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.linearVolume) * 31) + Integer.hashCode(this.nonlinearVolume)) * 31) + Integer.hashCode(this.vad)) * 31) + Long.hashCode(this.timestampMs);
        }

        public String toString() {
            return "RtcLocalAudioProperties(linearVolume=" + this.linearVolume + ", nonlinearVolume=" + this.nonlinearVolume + ", vad=" + this.vad + ", timestampMs=" + this.timestampMs + ')';
        }

        public RtcLocalAudioProperties(int i, int i2, int i3, long j) {
            this.linearVolume = i;
            this.nonlinearVolume = i2;
            this.vad = i3;
            this.timestampMs = j;
        }

        public final int getLinearVolume() {
            return this.linearVolume;
        }

        public final int getNonlinearVolume() {
            return this.nonlinearVolume;
        }

        public final int getVad() {
            return this.vad;
        }

        public /* synthetic */ RtcLocalAudioProperties(int i, int i2, int i3, long j, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, i3, (i4 & 8) != 0 ? System.currentTimeMillis() : j);
        }

        public final long getTimestampMs() {
            return this.timestampMs;
        }
    }

    /* compiled from: VolcRtcClient.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality;", "", "uid", "", "fractionLost", "", "rtt", "", "totalBandwidth", "txQuality", "rxQuality", "<init>", "(Ljava/lang/String;DIIII)V", "getUid", "()Ljava/lang/String;", "getFractionLost", "()D", "getRtt", "()I", "getTotalBandwidth", "getTxQuality", "getRxQuality", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RtcNetworkQuality {
        private final double fractionLost;
        private final int rtt;
        private final int rxQuality;
        private final int totalBandwidth;
        private final int txQuality;
        private final String uid;

        public static /* synthetic */ RtcNetworkQuality copy$default(RtcNetworkQuality rtcNetworkQuality, String str, double d, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = rtcNetworkQuality.uid;
            }
            if ((i5 & 2) != 0) {
                d = rtcNetworkQuality.fractionLost;
            }
            double d2 = d;
            if ((i5 & 4) != 0) {
                i = rtcNetworkQuality.rtt;
            }
            int i6 = i;
            if ((i5 & 8) != 0) {
                i2 = rtcNetworkQuality.totalBandwidth;
            }
            int i7 = i2;
            if ((i5 & 16) != 0) {
                i3 = rtcNetworkQuality.txQuality;
            }
            int i8 = i3;
            if ((i5 & 32) != 0) {
                i4 = rtcNetworkQuality.rxQuality;
            }
            return rtcNetworkQuality.copy(str, d2, i6, i7, i8, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        /* renamed from: component2, reason: from getter */
        public final double getFractionLost() {
            return this.fractionLost;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRtt() {
            return this.rtt;
        }

        /* renamed from: component4, reason: from getter */
        public final int getTotalBandwidth() {
            return this.totalBandwidth;
        }

        /* renamed from: component5, reason: from getter */
        public final int getTxQuality() {
            return this.txQuality;
        }

        /* renamed from: component6, reason: from getter */
        public final int getRxQuality() {
            return this.rxQuality;
        }

        public final RtcNetworkQuality copy(String uid, double fractionLost, int rtt, int totalBandwidth, int txQuality, int rxQuality) {
            return new RtcNetworkQuality(uid, fractionLost, rtt, totalBandwidth, txQuality, rxQuality);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RtcNetworkQuality)) {
                return false;
            }
            RtcNetworkQuality rtcNetworkQuality = (RtcNetworkQuality) other;
            return Intrinsics.areEqual(this.uid, rtcNetworkQuality.uid) && Double.compare(this.fractionLost, rtcNetworkQuality.fractionLost) == 0 && this.rtt == rtcNetworkQuality.rtt && this.totalBandwidth == rtcNetworkQuality.totalBandwidth && this.txQuality == rtcNetworkQuality.txQuality && this.rxQuality == rtcNetworkQuality.rxQuality;
        }

        public int hashCode() {
            String str = this.uid;
            return ((((((((((str == null ? 0 : str.hashCode()) * 31) + Double.hashCode(this.fractionLost)) * 31) + Integer.hashCode(this.rtt)) * 31) + Integer.hashCode(this.totalBandwidth)) * 31) + Integer.hashCode(this.txQuality)) * 31) + Integer.hashCode(this.rxQuality);
        }

        public String toString() {
            return "RtcNetworkQuality(uid=" + this.uid + ", fractionLost=" + this.fractionLost + ", rtt=" + this.rtt + ", totalBandwidth=" + this.totalBandwidth + ", txQuality=" + this.txQuality + ", rxQuality=" + this.rxQuality + ')';
        }

        public RtcNetworkQuality(String str, double d, int i, int i2, int i3, int i4) {
            this.uid = str;
            this.fractionLost = d;
            this.rtt = i;
            this.totalBandwidth = i2;
            this.txQuality = i3;
            this.rxQuality = i4;
        }

        public final String getUid() {
            return this.uid;
        }

        public final double getFractionLost() {
            return this.fractionLost;
        }

        public final int getRtt() {
            return this.rtt;
        }

        public final int getTotalBandwidth() {
            return this.totalBandwidth;
        }

        public final int getTxQuality() {
            return this.txQuality;
        }

        public final int getRxQuality() {
            return this.rxQuality;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: VolcRtcClient.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;", "", "<init>", "(Ljava/lang/String;I)V", "Brainstorm", "Transcription", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CallerType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CallerType[] $VALUES;
        public static final CallerType Brainstorm = new CallerType("Brainstorm", 0);
        public static final CallerType Transcription = new CallerType("Transcription", 1);

        private static final /* synthetic */ CallerType[] $values() {
            return new CallerType[]{Brainstorm, Transcription};
        }

        public static EnumEntries<CallerType> getEntries() {
            return $ENTRIES;
        }

        static {
            CallerType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private CallerType(String str, int i) {
        }

        public static CallerType valueOf(String str) {
            return (CallerType) Enum.valueOf(CallerType.class, str);
        }

        public static CallerType[] values() {
            return (CallerType[]) $VALUES.clone();
        }
    }

    public final void addListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(new WeakReference<>(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeListener$lambda$0(Listener listener, WeakReference weakReference) {
        return weakReference.get() == listener;
    }

    public final void removeListener(final Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CollectionsKt.removeAll(listeners, new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean removeListener$lambda$0;
                removeListener$lambda$0 = VolcRtcClient.removeListener$lambda$0(VolcRtcClient.Listener.this, (WeakReference) obj);
                return Boolean.valueOf(removeListener$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListeners(Function1<? super Listener, Unit> action) {
        Iterator<WeakReference<Listener>> it = listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference<Listener> next = it.next();
            Listener listener = next.get();
            if (listener != null) {
                action.invoke(listener);
            } else {
                listeners.remove(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int liveListenerCount() {
        CopyOnWriteArrayList<WeakReference<Listener>> copyOnWriteArrayList = listeners;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return 0;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            if ((((WeakReference) it.next()).get() != null) && (i = i + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public final void preloadEngine(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        String str = AppHost.INSTANCE.isOversea() ? "AREA_CODE_OVERSEA" : "AREA_CODE_CN";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mediaAreaList", new JSONArray().put(str));
        jSONObject.put("dataAreaList", new JSONArray().put(str));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("direction", 1);
        jSONObject2.put("support_sentence_id", true);
        EngineConfig engineConfig = new EngineConfig();
        engineConfig.context = AppHost.INSTANCE.getApplication();
        engineConfig.appID = appId;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("rtc.area_code", jSONObject);
        jSONObject3.put("rtc.fg_config", "aigc_media_360=true");
        jSONObject3.put("rtc.set_audio_burst_mode", jSONObject2);
        engineConfig.parameters = jSONObject3;
        RTCEngine createRTCEngine = RTCEngine.createRTCEngine(engineConfig, new VolcRtcClient$preloadEngine$engineHandler$1());
        engine = createRTCEngine;
        if (createRTCEngine != null) {
            createRTCEngine.setAnsMode(AnsMode.ANS_MODE_AUTOMATIC);
        }
        RTCEngine rTCEngine = engine;
        if (rTCEngine != null) {
            rTCEngine.setAudioScenario(AudioScenarioType.GAMESTREAMING);
        }
        RTCEngine rTCEngine2 = engine;
        if (rTCEngine2 != null) {
            rTCEngine2.enableAudioPropertiesReport(new AudioPropertiesConfig(100, false, true));
        }
    }

    public final boolean join$conversation_mainlandRelease(StartVoiceChatData voiceChat, Listener listener, CallerType caller) {
        Intrinsics.checkNotNullParameter(voiceChat, "voiceChat");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(caller, "caller");
        String appId = voiceChat.getAppId();
        if (appId == null) {
            appId = "";
        }
        String roomId = voiceChat.getRoomId();
        if (roomId == null) {
            roomId = "";
        }
        String userId = voiceChat.getUserId();
        if (userId == null) {
            userId = "";
        }
        String token = voiceChat.getToken();
        if (token == null) {
            token = "";
        }
        FLogger.INSTANCE.d(TAG, rtcDiag("join begin: caller=" + caller + ", appId=" + appId + ", roomId=" + roomId + ", userId=" + userId + ", taskId=" + voiceChat.getTaskId() + ", tokenLength=" + token.length() + ", tokenHash=" + token.hashCode() + ", currentCaller=" + currentCaller + ", engineExists=" + (engine != null) + ", roomExists=" + (rtcRoom != null)));
        if (StringsKt.isBlank(appId) || StringsKt.isBlank(roomId) || StringsKt.isBlank(userId) || StringsKt.isBlank(token)) {
            FLogger.INSTANCE.w(TAG, rtcDiag("join invalid voiceChat data: appId=" + appId + ", roomId=" + roomId + ", userId=" + userId + ", hasToken=" + (!StringsKt.isBlank(token))));
            listener.onError(new IllegalArgumentException("invalid voiceChat data: " + voiceChat));
            return false;
        }
        synchronized (callerLock) {
            CallerType callerType = currentCaller;
            if (callerType != null && callerType != caller) {
                FLogger.INSTANCE.w(TAG, INSTANCE.rtcDiag("join refused: currentCaller=" + callerType + " busy, requested caller=" + caller));
                return false;
            }
            VolcRtcClient volcRtcClient = INSTANCE;
            currentCaller = caller;
            Unit unit = Unit.INSTANCE;
            addListener(listener);
            VolcRtcClient$join$engineHandler$1 volcRtcClient$join$engineHandler$1 = new VolcRtcClient$join$engineHandler$1();
            String str = AppHost.INSTANCE.isOversea() ? "AREA_CODE_OVERSEA" : "AREA_CODE_CN";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mediaAreaList", new JSONArray().put(str));
            jSONObject.put("dataAreaList", new JSONArray().put(str));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("direction", 1);
            jSONObject2.put("support_sentence_id", true);
            EngineConfig engineConfig = new EngineConfig();
            engineConfig.context = AppHost.INSTANCE.getApplication();
            engineConfig.appID = appId;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("rtc.area_code", jSONObject);
            jSONObject3.put("rtc.fg_config", "aigc_media_360=true");
            jSONObject3.put("rtc.set_audio_burst_mode", jSONObject2);
            engineConfig.parameters = jSONObject3;
            RTCEngine createRTCEngine = RTCEngine.createRTCEngine(engineConfig, volcRtcClient$join$engineHandler$1);
            engine = createRTCEngine;
            if (createRTCEngine != null) {
                createRTCEngine.setAudioScenario(AudioScenarioType.GAMESTREAMING);
            }
            RTCEngine rTCEngine = engine;
            if (rTCEngine != null) {
                rTCEngine.enableAudioPropertiesReport(new AudioPropertiesConfig(100, false, true));
            }
            RTCEngine rTCEngine2 = engine;
            if (rTCEngine2 != null) {
                rTCEngine2.startAudioCapture();
            }
            RTCEngine rTCEngine3 = engine;
            RTCRoom rTCRoom = null;
            RTCRoom createRTCRoom = rTCEngine3 != null ? rTCEngine3.createRTCRoom(roomId) : null;
            if (createRTCRoom != null) {
                createRTCRoom.setRTCRoomEventHandler(new VolcRtcClient$join$2$1(roomId));
                int joinRoom = createRTCRoom.joinRoom(token, new UserInfo(userId, ""), true, new RTCRoomConfig(RoomProfile.CHAT_ROOM, true, false, true, false, true, FileUploadService.LOG_CHUNK_SIZE));
                FLogger.INSTANCE.d(TAG, volcRtcClient.rtcDiag("joinRoom result: roomId=" + roomId + ", userId=" + userId + ", result=" + joinRoom));
                if (joinRoom != 0) {
                    FLogger.INSTANCE.e(TAG, volcRtcClient.rtcDiag("joinRoom returned non-zero: roomId=" + roomId + ", userId=" + userId + ", result=" + joinRoom));
                }
                rTCRoom = createRTCRoom;
            }
            rtcRoom = rTCRoom;
            if (rTCRoom == null) {
                FLogger.INSTANCE.e(TAG, rtcDiag("join skipped: createRTCRoom returned null, roomId=" + roomId + ", engineExists=" + (engine != null)));
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyLocalAudioProperties(LocalAudioPropertiesInfo[] audioPropertiesInfos) {
        LocalAudioPropertiesInfo localAudioPropertiesInfo;
        final AudioPropertiesInfo audioPropertiesInfo;
        if (audioPropertiesInfos == null || (localAudioPropertiesInfo = (LocalAudioPropertiesInfo) ArraysKt.firstOrNull(audioPropertiesInfos)) == null || (audioPropertiesInfo = localAudioPropertiesInfo.audioPropertiesInfo) == null) {
            return;
        }
        notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit notifyLocalAudioProperties$lambda$10;
                notifyLocalAudioProperties$lambda$10 = VolcRtcClient.notifyLocalAudioProperties$lambda$10(audioPropertiesInfo, (VolcRtcClient.Listener) obj);
                return notifyLocalAudioProperties$lambda$10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notifyLocalAudioProperties$lambda$10(AudioPropertiesInfo audioPropertiesInfo, Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onLocalAudioLevel(audioPropertiesInfo.linearVolume);
        listener.onLocalAudioProperties(new RtcLocalAudioProperties(audioPropertiesInfo.linearVolume, audioPropertiesInfo.nonlinearVolume, audioPropertiesInfo.vad, 0L, 8, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAudioInputDeviceState(final String deviceId, AudioDeviceType deviceType, final int deviceState, final int deviceError) {
        if (deviceType == AudioDeviceType.AUDIO_DEVICE_TYPE_CAPTURE_DEVICE) {
            notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit notifyAudioInputDeviceState$lambda$11;
                    notifyAudioInputDeviceState$lambda$11 = VolcRtcClient.notifyAudioInputDeviceState$lambda$11(deviceId, deviceState, deviceError, (VolcRtcClient.Listener) obj);
                    return notifyAudioInputDeviceState$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notifyAudioInputDeviceState$lambda$11(String str, int i, int i2, Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onAudioInputDeviceStateChanged(str, i, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RtcNetworkQuality toRtcNetworkQuality(NetworkQualityStats networkQualityStats) {
        return new RtcNetworkQuality(networkQualityStats.uid, networkQualityStats.fractionLost, networkQualityStats.rtt, networkQualityStats.totalBandwidth, networkQualityStats.txQuality, networkQualityStats.rxQuality);
    }

    public final void sendUserBinaryMessageToBot(String botUserId, byte[] message) {
        Intrinsics.checkNotNullParameter(botUserId, "botUserId");
        Intrinsics.checkNotNullParameter(message, "message");
        RTCRoom rTCRoom = rtcRoom;
        if (rTCRoom == null) {
            FLogger.INSTANCE.e(TAG, rtcDiag("rtcRoom is null, cannot send message to bot, botUserId=" + botUserId + ", size=" + message.length));
            return;
        }
        try {
            rTCRoom.sendUserBinaryMessage(botUserId, message, MessageConfig.RELIABLE_ORDERED);
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, rtcDiag("sendUserBinaryMessageToBot failed: botUserId=" + botUserId + ", size=" + message.length), th);
        }
    }

    public final void setServerParams(String signature, String url) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        RTCEngine rTCEngine = engine;
        if (rTCEngine == null) {
            FLogger.INSTANCE.e(TAG, rtcDiag("engine is null, cannot setServerParams, signatureLength=" + signature.length() + ", url=" + url));
            return;
        }
        try {
            rTCEngine.setServerParams(signature, url);
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, rtcDiag("setServerParams failed: signatureLength=" + signature.length() + ", url=" + url), th);
        }
    }

    public final long sendServerMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        RTCEngine rTCEngine = engine;
        if (rTCEngine == null) {
            FLogger.INSTANCE.e(TAG, rtcDiag("engine is null, cannot sendServerMessage, length=" + message.length() + ", hash=" + message.hashCode()));
            return -1L;
        }
        try {
            return rTCEngine.sendServerMessage(message);
        } catch (Throwable th) {
            FLogger.INSTANCE.w(TAG, rtcDiag("sendServerMessage failed: length=" + message.length() + ", hash=" + message.hashCode()), th);
            return -1L;
        }
    }

    public final void startAudioCapture() {
        FLogger.INSTANCE.d(TAG, rtcDiag("startAudioCapture: " + audioCaptureStateSummary()));
        RTCEngine rTCEngine = engine;
        if (rTCEngine != null) {
            rTCEngine.startAudioCapture();
        }
    }

    public final void stopAudioCapture() {
        FLogger.INSTANCE.d(TAG, rtcDiag("stopAudioCapture: " + audioCaptureStateSummary()));
        RTCEngine rTCEngine = engine;
        if (rTCEngine != null) {
            rTCEngine.stopAudioCapture();
        }
    }

    private final String audioCaptureStateSummary() {
        RTCEngine rTCEngine = engine;
        RTCRoom rTCRoom = rtcRoom;
        return "caller=" + currentCaller + ", engineExists=" + (rTCEngine != null) + ", roomExists=" + (rTCRoom != null) + ", engineHash=" + (rTCEngine != null ? Integer.valueOf(System.identityHashCode(rTCEngine)) : null) + ", roomHash=" + (rTCRoom != null ? Integer.valueOf(System.identityHashCode(rTCRoom)) : null);
    }

    public final void leaveRoom() {
        final RTCRoom rTCRoom = rtcRoom;
        rtcRoom = null;
        FLogger.INSTANCE.d(TAG, rtcDiag("leaveRoom: roomExists=" + (rTCRoom != null) + ", engineExists=" + (engine != null) + ", caller=" + currentCaller));
        synchronized (callerLock) {
            currentCaller = null;
            Unit unit = Unit.INSTANCE;
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                VolcRtcClient.leaveRoom$lambda$18(rTCRoom);
            }
        });
        newSingleThreadExecutor.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void leaveRoom$lambda$18(RTCRoom rTCRoom) {
        if (rTCRoom != null) {
            try {
                rTCRoom.destroy();
            } catch (Throwable unused) {
            }
        }
    }

    public final void leave() {
        final RTCRoom rTCRoom = rtcRoom;
        rtcRoom = null;
        engine = null;
        FLogger.INSTANCE.d(TAG, rtcDiag("leave: roomExists=" + (rTCRoom != null) + ", caller=" + currentCaller));
        synchronized (callerLock) {
            currentCaller = null;
            Unit unit = Unit.INSTANCE;
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        newSingleThreadExecutor.execute(new Runnable() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                VolcRtcClient.leave$lambda$20(rTCRoom);
            }
        });
        newSingleThreadExecutor.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void leave$lambda$20(RTCRoom rTCRoom) {
        if (rTCRoom != null) {
            try {
                rTCRoom.destroy();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
                Unit unit2 = Unit.INSTANCE;
            }
        }
        try {
            RTCEngine.destroyRTCEngine();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] toByteArraySafely(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String rtcDiag(String message) {
        return "RTC_DIAG " + message;
    }
}
