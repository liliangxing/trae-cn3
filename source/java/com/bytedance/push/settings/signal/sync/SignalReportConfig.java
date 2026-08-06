package com.bytedance.push.settings.signal.sync;

import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.utils.GsonUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class SignalReportConfig {

    @SerializedName(ISignalReportConstants.KEY_SIGNAL_NAME)
    public String signalName;

    @SerializedName("report_interval")
    public long signalReportInterval;

    @SerializedName("signal_type")
    public int signalType;

    @SerializedName("signal_scene")
    public List<String> signalScene = new ArrayList();

    @SerializedName("extra_config")
    public Map<String, String> extraConfig = new HashMap();

    public String toString() {
        return GsonUtils.toJson(this);
    }
}
