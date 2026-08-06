package com.bytedance.crash.resource.gwpasan;

import android.util.Log;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.update.UpdateDialogNewBase;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class GwpAsanConfig extends ResourceMonitorConfig {
    private static final String LOG_TAG = "XASAN";
    private String mConfigStr;
    private final String[] xasan_cfg_name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GwpAsanConfig(JSONArray jSONArray) {
        super(21, 33, 0);
        this.mConfigStr = null;
        this.xasan_cfg_name = new String[]{"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};
        if (jSONArray == null || jSONArray.length() >= 10) {
            Log.e(LOG_TAG, "Config Init fail");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            String[] strArr = this.xasan_cfg_name;
            if (i >= strArr.length) {
                break;
            }
            sb.append(strArr[i]);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(jSONArray.optString(i));
            sb.append(UpdateDialogNewBase.TYPE);
        }
        this.mConfigStr = sb.toString();
        Log.d(LOG_TAG, "Config Init:" + this.mConfigStr);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return this.mConfigStr;
    }
}
