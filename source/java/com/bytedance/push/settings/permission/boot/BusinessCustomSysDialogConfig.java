package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.depths.RiskDeviceFilterConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class BusinessCustomSysDialogConfig {

    @SerializedName("custom_dialog_rs_config")
    public RiskDeviceFilterConfig mCustomDialogRiskDeviceFilterConfig;

    @SerializedName("support_dark_mode")
    public boolean supportDarkMode;

    @SerializedName("is_valid_settings")
    public boolean isValidSettings = false;

    @SerializedName("toast_dialog_interval")
    public int toastDialogInterval = 30000;

    @SerializedName("business_custom_sys_dialog_config_map")
    public Map<String, ItemBusinessCustomSysDialogConfig> businessCustomSysDialogConfigMap = new HashMap();
}
