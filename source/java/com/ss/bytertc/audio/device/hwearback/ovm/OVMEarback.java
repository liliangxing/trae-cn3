package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import com.ss.bytertc.audio.device.hwearback.BaseEarback;
import com.ss.bytertc.audio.device.hwearback.SlientPlayer;
import com.ss.bytertc.audio.device.hwearback.ovm.HardwareEarbackParams;
import com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class OVMEarback extends BaseEarback {
    private static final String TAG = "OVMEarback";
    private final OVMClient client;
    private boolean isAudioParamsSupported;
    private boolean isRecordingStarted;
    private final SlientPlayer slientPlayer;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return -1;
    }

    public OVMEarback(Context context, WebRtcAudioEarBack webRtcAudioEarBack) {
        super(context, webRtcAudioEarBack);
        this.isRecordingStarted = true;
        this.isAudioParamsSupported = false;
        this.client = OVMClient.initialize(context);
        this.slientPlayer = new SlientPlayer();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    protected void onInit() {
        this.client.setAuthCallback(new OVMAuthManager.AuthCallback() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMEarback$$ExternalSyntheticLambda0
            @Override // com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager.AuthCallback
            public final void onResult(int i) {
                OVMEarback.this.m171xfbbc3014(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onInit$0$com-ss-bytertc-audio-device-hwearback-ovm-OVMEarback */
    public /* synthetic */ void m171xfbbc3014(int i) {
        RXLogging.i(TAG, "connection result: " + i);
        if (i == 1001) {
            this.client.openKTVDevice();
            this.client.resetKTVParamsAndUpdate();
            this.webRtcAudioEarBack.onHardwareEarbackSupportParamsGet(getReportParameters());
            this.isAudioParamsSupported = checkAudioParams();
            onInitResult(true);
            return;
        }
        onInitResult(false);
    }

    private String getReportParameters() {
        String karaokeSupportParameters = this.client.getKaraokeSupportParameters();
        try {
            JSONObject jSONObject = new JSONObject(karaokeSupportParameters);
            jSONObject.put(Constants.VERSION, this.client.getVersion());
            return jSONObject.toString();
        } catch (Throwable unused) {
            RXLogging.e(TAG, "parse report params error, not json format");
            return karaokeSupportParameters;
        }
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    protected void onRelease() {
        this.client.setPlayFeedbackParam(0);
        this.client.setMixerSoundType(0);
        this.client.setEqualizerType(0);
        this.client.closeKTVDevice();
        this.client.release();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    protected boolean onIsSupportCall() {
        return this.client.isSupportedAndAuth() && this.isAudioParamsSupported;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    protected boolean onOpen() {
        this.client.setPlayFeedbackParam(1);
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    protected boolean onClose() {
        this.client.setPlayFeedbackParam(0);
        return true;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.BaseEarback
    protected synchronized void onStateChanged(BaseEarback.EarbackState oldState, BaseEarback.EarbackState newState) {
        super.onStateChanged(oldState, newState);
        updatePlayerState();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int value) {
        this.client.setMixerSoundType(value);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int value) {
        this.client.setEqualizerType(value);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int volume) {
        int i = ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.OP ? 12 : 15;
        this.client.setMicVolParam(Math.max(Math.min((int) ((volume / 100.0f) * i), i), 0));
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean recordStart) {
        if (recordStart) {
            this.isRecordingStarted = true;
            updatePlayerState();
        } else {
            this.isRecordingStarted = false;
            updatePlayerState();
        }
    }

    private boolean checkAudioParams() {
        boolean z;
        boolean z2;
        StringBuffer stringBuffer = new StringBuffer("parse params: ");
        String karaokeSupportParameters = this.client.getKaraokeSupportParameters();
        stringBuffer.append(this.client.getKaraokeSupportParameters());
        HardwareEarbackParams parse = new DefaultHardwareParamsParser().parse(karaokeSupportParameters);
        if (parse != null) {
            if (parse.playParamsList != null && parse.playParamsList.size() > 0) {
                stringBuffer.append(", playout params size: ").append(parse.playParamsList.size());
                Iterator<HardwareEarbackParams.Play> it = parse.playParamsList.iterator();
                boolean z3 = false;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HardwareEarbackParams.Play next = it.next();
                    stringBuffer.append("{streamType: ").append(next.streamType).append(", sampleRate: ").append(next.sampleRate).append(", format: ").append(next.format).append(", flags: ").append(next.flags).append("}");
                    boolean z4 = next.streamType == 3 && next.format == 2 && (next.sampleRate == 44100 || next.sampleRate == 48000);
                    if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.XM || ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.RM) {
                        z4 &= next.version > 0;
                    }
                    z3 |= z4;
                    if (z3) {
                        RXLogging.i(TAG, "updating slientPlayer params: " + next.sampleRate + ", " + next.flags);
                        this.slientPlayer.setSampleRate(next.sampleRate);
                        this.slientPlayer.setRequireDeepBuffer((next.flags & 8) == 8);
                    }
                }
                z2 = true & z3;
            } else {
                stringBuffer.append(", playout params parsed null.");
                z2 = false;
            }
            if (parse.recordParamsList != null && parse.recordParamsList.size() > 0) {
                stringBuffer.append(", record params size: ").append(parse.recordParamsList.size());
                boolean z5 = false;
                for (HardwareEarbackParams.Record record : parse.recordParamsList) {
                    stringBuffer.append("{sampleRate: ").append(record.sampleRate).append(", format: ").append(record.format).append(", audioSource: ").append(record.source).append(", flags: ").append(record.flags).append("}");
                    boolean z6 = record.format == 2 && record.sampleRate == 48000 && (record.source == 1 || record.source == 0) && (record.flags & 1) == 1;
                    if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.XM || ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.RM) {
                        z6 &= record.version > 0;
                    }
                    z5 |= z6;
                }
                z = z2 & z5;
                stringBuffer.append(", canOpenEarback: ").append(z);
                RXLogging.i(TAG, stringBuffer.toString());
                return z;
            }
            stringBuffer.append(", record params parsed null.");
        }
        z = false;
        stringBuffer.append(", canOpenEarback: ").append(z);
        RXLogging.i(TAG, stringBuffer.toString());
        return z;
    }

    private synchronized void updatePlayerState() {
        SlientPlayer slientPlayer = this.slientPlayer;
        if (slientPlayer == null) {
            return;
        }
        if ((slientPlayer.isPlaying() && this.isRecordingStarted) || getState() == BaseEarback.EarbackState.RUNNING) {
            this.slientPlayer.play();
        } else {
            this.slientPlayer.stop();
        }
    }
}
