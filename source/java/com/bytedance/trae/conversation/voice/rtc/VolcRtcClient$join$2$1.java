package com.bytedance.trae.conversation.voice.rtc;

import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.UserInfo;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.type.NetworkQualityStats;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: VolcRtcClient.kt */
@Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J%\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0018H\u0016¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"com/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1", "Lcom/ss/bytertc/engine/handler/IRTCRoomEventHandler;", "onUserJoined", "", "userInfo", "Lcom/ss/bytertc/engine/UserInfo;", "onRoomStateChanged", "roomId", "", "uid", "state", "", "extraInfo", "onRoomBinaryMessageReceived", "message", "Ljava/nio/ByteBuffer;", "onUserBinaryMessageReceived", "onUserMessageReceived", "msgid", "", "onNetworkQuality", "localQuality", "Lcom/ss/bytertc/engine/type/NetworkQualityStats;", "remoteQualities", "", "(Lcom/ss/bytertc/engine/type/NetworkQualityStats;[Lcom/ss/bytertc/engine/type/NetworkQualityStats;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VolcRtcClient$join$2$1 extends IRTCRoomEventHandler {
    final /* synthetic */ String $roomId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VolcRtcClient$join$2$1(String str) {
        this.$roomId = str;
    }

    public void onUserJoined(UserInfo userInfo) {
        int liveListenerCount;
        String rtcDiag;
        RTCRoom rTCRoom;
        String rtcDiag2;
        RTCEngine rTCEngine;
        final String str;
        FLogger fLogger = FLogger.INSTANCE;
        VolcRtcClient volcRtcClient = VolcRtcClient.INSTANCE;
        StringBuilder append = new StringBuilder("onUserJoined: roomId=").append(this.$roomId).append(", uid=").append(userInfo != null ? userInfo.uid : null).append(", listenerCount=");
        liveListenerCount = VolcRtcClient.INSTANCE.liveListenerCount();
        rtcDiag = volcRtcClient.rtcDiag(append.append(liveListenerCount).toString());
        fLogger.d("VolcRtcClient", rtcDiag);
        if (userInfo != null && (str = userInfo.uid) != null) {
            VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onUserJoined$lambda$1$lambda$0;
                    onUserJoined$lambda$1$lambda$0 = VolcRtcClient$join$2$1.onUserJoined$lambda$1$lambda$0(str, (VolcRtcClient.Listener) obj);
                    return onUserJoined$lambda$1$lambda$0;
                }
            });
        }
        rTCRoom = VolcRtcClient.rtcRoom;
        if (rTCRoom != null) {
            rTCRoom.publishScreenAudio(true);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_cache_audio_data", false);
            jSONObject2.put("cache_audio_data_ms", 0);
            jSONObject.put("rtc.pre_cache_config", jSONObject2);
            rTCEngine = VolcRtcClient.engine;
            if (rTCEngine != null) {
                rTCEngine.setRuntimeParameters(jSONObject);
            }
        } catch (Throwable th) {
            FLogger fLogger2 = FLogger.INSTANCE;
            rtcDiag2 = VolcRtcClient.INSTANCE.rtcDiag("set pre cache runtime parameters failed");
            fLogger2.w("VolcRtcClient", rtcDiag2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUserJoined$lambda$1$lambda$0(String str, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onRemoteUserJoined(str);
        return Unit.INSTANCE;
    }

    public void onRoomStateChanged(final String roomId, String uid, int state, String extraInfo) {
        int liveListenerCount;
        String rtcDiag;
        String rtcDiag2;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        FLogger fLogger = FLogger.INSTANCE;
        VolcRtcClient volcRtcClient = VolcRtcClient.INSTANCE;
        StringBuilder append = new StringBuilder("onRoomStateChanged: roomId=").append(roomId).append(", uid=").append(uid).append(", state=").append(state).append(", listenerCount=");
        liveListenerCount = VolcRtcClient.INSTANCE.liveListenerCount();
        rtcDiag = volcRtcClient.rtcDiag(append.append(liveListenerCount).append(", extra=").append(extraInfo).toString());
        fLogger.d("VolcRtcClient", rtcDiag);
        if (state == 0) {
            VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit onRoomStateChanged$lambda$2;
                    onRoomStateChanged$lambda$2 = VolcRtcClient$join$2$1.onRoomStateChanged$lambda$2(roomId, (VolcRtcClient.Listener) obj);
                    return onRoomStateChanged$lambda$2;
                }
            });
            return;
        }
        FLogger fLogger2 = FLogger.INSTANCE;
        rtcDiag2 = VolcRtcClient.INSTANCE.rtcDiag("onRoomStateChanged non-success: roomId=" + roomId + ", uid=" + uid + ", state=" + state + ", extra=" + extraInfo);
        fLogger2.w("VolcRtcClient", rtcDiag2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRoomStateChanged$lambda$2(String str, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onJoinedRoom(str);
        return Unit.INSTANCE;
    }

    public void onRoomBinaryMessageReceived(final String uid, ByteBuffer message) {
        final byte[] byteArraySafely;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, "message");
        byteArraySafely = VolcRtcClient.INSTANCE.toByteArraySafely(message);
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onRoomBinaryMessageReceived$lambda$3;
                onRoomBinaryMessageReceived$lambda$3 = VolcRtcClient$join$2$1.onRoomBinaryMessageReceived$lambda$3(uid, byteArraySafely, (VolcRtcClient.Listener) obj);
                return onRoomBinaryMessageReceived$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRoomBinaryMessageReceived$lambda$3(String str, byte[] bArr, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onRoomBinaryMessage(str, bArr);
        return Unit.INSTANCE;
    }

    public void onUserBinaryMessageReceived(final String uid, ByteBuffer message) {
        final byte[] byteArraySafely;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, "message");
        byteArraySafely = VolcRtcClient.INSTANCE.toByteArraySafely(message);
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onUserBinaryMessageReceived$lambda$4;
                onUserBinaryMessageReceived$lambda$4 = VolcRtcClient$join$2$1.onUserBinaryMessageReceived$lambda$4(uid, byteArraySafely, (VolcRtcClient.Listener) obj);
                return onUserBinaryMessageReceived$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUserBinaryMessageReceived$lambda$4(String str, byte[] bArr, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onRoomBinaryMessage(str, bArr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUserMessageReceived$lambda$5(String str, String str2, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onUserMessage(str, str2);
        return Unit.INSTANCE;
    }

    public void onUserMessageReceived(final String uid, final String message) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, "message");
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onUserMessageReceived$lambda$5;
                onUserMessageReceived$lambda$5 = VolcRtcClient$join$2$1.onUserMessageReceived$lambda$5(uid, message, (VolcRtcClient.Listener) obj);
                return onUserMessageReceived$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUserMessageReceived$lambda$6(String str, String str2, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onUserMessage(str, str2);
        return Unit.INSTANCE;
    }

    public void onUserMessageReceived(long msgid, final String uid, final String message) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, "message");
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit onUserMessageReceived$lambda$6;
                onUserMessageReceived$lambda$6 = VolcRtcClient$join$2$1.onUserMessageReceived$lambda$6(uid, message, (VolcRtcClient.Listener) obj);
                return onUserMessageReceived$lambda$6;
            }
        });
    }

    public void onNetworkQuality(final NetworkQualityStats localQuality, final NetworkQualityStats[] remoteQualities) {
        Intrinsics.checkNotNullParameter(localQuality, "localQuality");
        Intrinsics.checkNotNullParameter(remoteQualities, "remoteQualities");
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$2$1$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit onNetworkQuality$lambda$8;
                onNetworkQuality$lambda$8 = VolcRtcClient$join$2$1.onNetworkQuality$lambda$8(localQuality, remoteQualities, (VolcRtcClient.Listener) obj);
                return onNetworkQuality$lambda$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onNetworkQuality$lambda$8(NetworkQualityStats networkQualityStats, NetworkQualityStats[] networkQualityStatsArr, VolcRtcClient.Listener listener) {
        VolcRtcClient.RtcNetworkQuality rtcNetworkQuality;
        VolcRtcClient.RtcNetworkQuality rtcNetworkQuality2;
        Intrinsics.checkNotNullParameter(listener, "it");
        rtcNetworkQuality = VolcRtcClient.INSTANCE.toRtcNetworkQuality(networkQualityStats);
        ArrayList arrayList = new ArrayList(networkQualityStatsArr.length);
        for (NetworkQualityStats networkQualityStats2 : networkQualityStatsArr) {
            rtcNetworkQuality2 = VolcRtcClient.INSTANCE.toRtcNetworkQuality(networkQualityStats2);
            arrayList.add(rtcNetworkQuality2);
        }
        listener.onNetworkQuality(rtcNetworkQuality, arrayList);
        return Unit.INSTANCE;
    }
}
