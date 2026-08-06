package com.bytedance.falconx.statistic;

import com.bytedance.bdturing.setting.SettingsManager;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
public class StatisticData {
    public static final String ERROR_CODE_IO_ERROR = "101";
    public static final String ERROR_CODE_NOT_FOUND = "100";

    @SerializedName(SettingsManager.COMMON_SERVICE)
    public Common mCommon;

    @SerializedName("offline")
    public List<InterceptorModel> offline;
}
