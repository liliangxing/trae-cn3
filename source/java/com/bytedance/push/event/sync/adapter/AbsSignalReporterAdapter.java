package com.bytedance.push.event.sync.adapter;

import android.content.Intent;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.utils.Logger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsSignalReporterAdapter extends BaseJson {
    protected SignalReportConfig mSignalReportConfig;
    protected String mTriggerScene;

    abstract String getSignalName();

    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        Logger.m268d("AbsSignalReporterAdapter", "[startSignalReport]signalName:" + getSignalName() + " triggerScene:" + str + " signalReportConfig:" + signalReportConfig);
        this.mSignalReportConfig = signalReportConfig;
        this.mTriggerScene = str;
        onSignalTrigger();
    }

    public void onReceiveSignal(Intent intent) {
        Logger.m268d("AbsSignalReporterAdapter", "[onReceiveSignal]intent:" + intent);
    }

    public void unregister() {
        Logger.m268d("AbsSignalReporterAdapter", "[onReceiveSignal]unregister");
    }

    public void onSignalTrigger() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, ISignalReportConstants.KEY_SIGNAL_NAME, getSignalName());
        PushSupporter.get().getMultiProcessMonitor().monitorEvent(ISignalReportConstants.MONITOR_NAME_BDPUSH_CLIENT_SIGNAL, jSONObject, (JSONObject) null, (JSONObject) null);
    }
}
