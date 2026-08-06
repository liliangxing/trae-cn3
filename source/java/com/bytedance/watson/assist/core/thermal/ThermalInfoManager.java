package com.bytedance.watson.assist.core.thermal;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.BaseInfoManager;

/* loaded from: classes6.dex */
public class ThermalInfoManager extends BaseInfoManager {
    private PowerManager mPowerManager;

    public ThermalInfoManager(Context context, IAssistStat iAssistStat) {
        super(context, iAssistStat);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    public int getCurrentThermalStatus() {
        PowerManager powerManager;
        if (Build.VERSION.SDK_INT < 29 || (powerManager = this.mPowerManager) == null) {
            return -1;
        }
        return powerManager.getCurrentThermalStatus();
    }
}
