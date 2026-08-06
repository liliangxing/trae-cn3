package com.bytedance.trae.conversation.voice.rtc;

import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.bytertc.engine.data.LocalAudioPropertiesInfo;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import com.ss.bytertc.engine.type.AudioDeviceType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VolcRtcClient.kt */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001f\u0010\n\u001a\u00020\u00032\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, d2 = {"com/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$engineHandler$1", "Lcom/ss/bytertc/engine/handler/IRTCEngineEventHandler;", "onError", "", "err", "", "onWarning", "warn", "onServerParamsSetResult", "error", "onLocalAudioPropertiesReport", "audioPropertiesInfos", "", "Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;", "([Lcom/ss/bytertc/engine/data/LocalAudioPropertiesInfo;)V", "onAudioDeviceStateChanged", "deviceID", "", "deviceType", "Lcom/ss/bytertc/engine/type/AudioDeviceType;", "deviceState", "deviceError", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VolcRtcClient$join$engineHandler$1 extends IRTCEngineEventHandler {
    public void onError(final int err) {
        String rtcDiag;
        FLogger fLogger = FLogger.INSTANCE;
        rtcDiag = VolcRtcClient.INSTANCE.rtcDiag("RTC onError: " + err);
        fLogger.e("VolcRtcClient", rtcDiag);
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$engineHandler$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onError$lambda$0;
                onError$lambda$0 = VolcRtcClient$join$engineHandler$1.onError$lambda$0(err, (VolcRtcClient.Listener) obj);
                return onError$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$0(int i, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onError(new RuntimeException("RTC onError: " + i));
        return Unit.INSTANCE;
    }

    public void onWarning(int warn) {
        String rtcDiag;
        FLogger fLogger = FLogger.INSTANCE;
        rtcDiag = VolcRtcClient.INSTANCE.rtcDiag("RTC onWarning: " + warn);
        fLogger.w("VolcRtcClient", rtcDiag);
    }

    public void onServerParamsSetResult(final int error) {
        String rtcDiag;
        if (error != 0) {
            FLogger fLogger = FLogger.INSTANCE;
            rtcDiag = VolcRtcClient.INSTANCE.rtcDiag("onServerParamsSetResult: error=" + error);
            fLogger.w("VolcRtcClient", rtcDiag);
        }
        VolcRtcClient.INSTANCE.notifyListeners(new Function1() { // from class: com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$join$engineHandler$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onServerParamsSetResult$lambda$1;
                onServerParamsSetResult$lambda$1 = VolcRtcClient$join$engineHandler$1.onServerParamsSetResult$lambda$1(error, (VolcRtcClient.Listener) obj);
                return onServerParamsSetResult$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onServerParamsSetResult$lambda$1(int i, VolcRtcClient.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "it");
        listener.onServerParamsSetResult(i);
        return Unit.INSTANCE;
    }

    public void onLocalAudioPropertiesReport(LocalAudioPropertiesInfo[] audioPropertiesInfos) {
        VolcRtcClient.INSTANCE.notifyLocalAudioProperties(audioPropertiesInfos);
    }

    public void onAudioDeviceStateChanged(String deviceID, AudioDeviceType deviceType, int deviceState, int deviceError) {
        Intrinsics.checkNotNullParameter(deviceID, "deviceID");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        VolcRtcClient.INSTANCE.notifyAudioInputDeviceState(deviceID, deviceType, deviceState, deviceError);
    }
}
