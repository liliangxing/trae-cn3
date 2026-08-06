package com.bytedance.push.event.sync.adapter;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RingTonesInfoReporter extends AbsSignalReporterAdapter {
    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_RINGTONES_INFO;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.RingTonesInfoReporter.1
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject audioFeature = RingTonesInfoReporter.this.getAudioFeature((AudioManager) AppProvider.getApp().getSystemService("audio"));
                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.RingTonesInfoReporter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(RingTonesInfoReporter.this.mSignalReportConfig, RingTonesInfoReporter.this.getSignalName(), RingTonesInfoReporter.this.mTriggerScene, audioFeature);
                    }
                });
            }
        });
    }

    public JSONObject getAudioFeature(AudioManager audioManager) {
        JSONObject jSONObject = new JSONObject();
        if (audioManager == null) {
            return jSONObject;
        }
        add(jSONObject, FeatureConnectionConstant.CUR_CALL_VOICE, audioManager.getStreamVolume(0));
        add(jSONObject, FeatureConnectionConstant.MAX_CALL_VOICE, audioManager.getStreamMaxVolume(0));
        add(jSONObject, FeatureConnectionConstant.CUR_RING_VOICE, audioManager.getStreamVolume(2));
        add(jSONObject, FeatureConnectionConstant.MAX_RING_VOICE, audioManager.getStreamMaxVolume(2));
        add(jSONObject, FeatureConnectionConstant.CUR_MUSIC_VOICE, audioManager.getStreamVolume(3));
        add(jSONObject, FeatureConnectionConstant.MAX_MUSIC_VOICE, audioManager.getStreamMaxVolume(3));
        add(jSONObject, FeatureConnectionConstant.CUR_ALARM_VOICE, audioManager.getStreamVolume(4));
        add(jSONObject, FeatureConnectionConstant.MAX_ALARM_VOICE, audioManager.getStreamMaxVolume(4));
        add(jSONObject, FeatureConnectionConstant.CUR_NOTIFICATION_VOICE, audioManager.getStreamVolume(5));
        add(jSONObject, FeatureConnectionConstant.MAX_NOTIFICATION_VOICE, audioManager.getStreamMaxVolume(5));
        add(jSONObject, FeatureConnectionConstant.RING_MODE, audioManager.getRingerMode());
        return jSONObject;
    }
}
