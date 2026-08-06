package com.monitor.cloudmessage.internal.data.stat;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.monitor.cloudmessage.internal.data.IDataProvider;
import com.monitor.cloudmessage.utils.SystemUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SystemInfoDataProvider implements IDataProvider<JSONObject> {
    @Override // com.monitor.cloudmessage.internal.data.IDataProvider
    public JSONObject provideData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("used_memory", SystemUtils.getUseMemory() + "MB");
            jSONObject.put("total_memory", SystemUtils.getTotalMemory() + "MB");
            jSONObject.put("sd_all_size", SystemUtils.getSDCardMemory()[0] + "MB");
            jSONObject.put("sd_avail_size", SystemUtils.getSDCardMemory()[1] + "MB");
            String str = "";
            for (String str2 : SystemUtils.getCpuInfo()) {
                str = str + str2 + "  ";
            }
            jSONObject.put(MonitorConstant.BLANK_CPU_INFO, str);
            jSONObject.put("kernel_version", SystemUtils.getVersion()[0]);
            jSONObject.put("firmware_version", SystemUtils.getVersion()[1]);
            jSONObject.put(StrategyConstants.MODEL, SystemUtils.getVersion()[2]);
            jSONObject.put("system_version", SystemUtils.getVersion()[3]);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
