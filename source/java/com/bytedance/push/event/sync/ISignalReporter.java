package com.bytedance.push.event.sync;

import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface ISignalReporter {

    /* loaded from: classes4.dex */
    public interface ISignalReporterListener {
        void onFinished(boolean z, String str);
    }

    void reportSignal(SignalReportConfig signalReportConfig, String str, String str2, JSONObject jSONObject);

    void reportSignal(SignalReportConfig signalReportConfig, String str, String str2, JSONObject jSONObject, ISignalReporterListener iSignalReporterListener);

    boolean reporterSignalByHttp(String str, JSONObject jSONObject);
}
