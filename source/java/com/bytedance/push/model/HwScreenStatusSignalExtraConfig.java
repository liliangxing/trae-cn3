package com.bytedance.push.model;

import android.text.TextUtils;
import com.bytedance.memory.dump.DumpFileController;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HwScreenStatusSignalExtraConfig {
    public static final String KEY_SCREEN_ACTION = "screen_action";
    public String callbackIntent;
    public long delayReportInMill;
    public boolean filterDebugDevice;
    public boolean filterSimCard;
    public int killProcessMode;
    public boolean killSelfAfterSignalReport;
    public long killSelfDelayInMill;
    public long minInstallTimeInMill;
    public long minSignalIntervalInMill;
    public String[] screenAction;
    public boolean unregisterForRiskSignal;
    public boolean unregisterForUnRiskSignal;
    final String KEY_CALLBACK_INTENT = "callback_intent";
    final String KEY_DELAY_REPORT_IN_MILL = "delay_report_in_mill";
    final String KEY_KILL_SELF_DELAY_IN_MILL = "kill_self_delay_in_mill";
    final String KEY_KILL_SELF_AFTER_SIGNAL_REPORT = "kill_self_after_signal_report";
    final String KEY_MIN_INSTALL_TIME_IN_MILL = "min_install_time_in_mill";
    final String KEY_FILTER_DEBUG_DEVICE = "filter_debug_device";
    final String KEY_MIN_SIGNAL_INTERVAL_IN_MILL = "min_signal_interval_in_mill";
    final String KEY_FILTER_SIM_CARD = "filter_sim_card";
    final String KEY_UNREGISTER_FOR_UN_RISK_SIGNAL = "unregister_for_un_risk_signal";
    final String KEY_UNREGISTER_FOR_RISK_SIGNAL = "unregister_for_risk_signal";
    final long VALUE_DEFAULT_MIN_SIGNAL_INTERVAL_IN_MILL = DumpFileController.HOUR;
    final long VALUE_DEFAULT_MIN_INSTALL_TIME_IN_MILL = 259200000;
    final long VALUE_DEFAULT_DELAY_REPORT_IN_MILL = 0;
    final long VALUE_DEFAULT_KILL_SELF_DELAY_IN_MILL = 6000;

    public HwScreenStatusSignalExtraConfig(Map<String, String> map) {
        Map<String, String> hashMap = map == null ? new HashMap() : map;
        this.callbackIntent = hashMap.get("callback_intent");
        String str = hashMap.get(KEY_SCREEN_ACTION);
        if (!TextUtils.isEmpty(str)) {
            this.screenAction = str.split(",");
        }
        this.delayReportInMill = ToolUtils.parseLong(hashMap.get("delay_report_in_mill"), 0L);
        this.killSelfDelayInMill = ToolUtils.parseLong(hashMap.get("kill_self_delay_in_mill"), 6000L);
        this.killSelfAfterSignalReport = ToolUtils.parseBool(hashMap.get("kill_self_after_signal_report"), true);
        this.minInstallTimeInMill = ToolUtils.parseLong(hashMap.get("min_install_time_in_mill"), 259200000L);
        this.minSignalIntervalInMill = ToolUtils.parseLong(hashMap.get("min_signal_interval_in_mill"), DumpFileController.HOUR);
        this.filterDebugDevice = ToolUtils.parseBool(hashMap.get("filter_debug_device"), true);
        this.filterSimCard = ToolUtils.parseBool(hashMap.get("filter_sim_card"), true);
        this.unregisterForRiskSignal = ToolUtils.parseBool(hashMap.get("unregister_for_risk_signal"), true);
        this.unregisterForUnRiskSignal = ToolUtils.parseBool(hashMap.get("unregister_for_un_risk_signal"), false);
        this.killProcessMode = ToolUtils.parseInt(hashMap.get(HeadSetStatusExtraConfig.KEY_KILL_PROCESS_MODE), 1);
    }

    public boolean isValidConfig() {
        return (TextUtils.isEmpty(this.callbackIntent) || this.screenAction == null) ? false : true;
    }
}
