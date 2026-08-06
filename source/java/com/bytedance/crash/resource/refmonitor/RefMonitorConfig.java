package com.bytedance.crash.resource.refmonitor;

import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import com.bytedance.vcloud.strategy.StrategyCenter;
import com.ss.android.update.UpdateDialogNewBase;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class RefMonitorConfig extends ResourceMonitorConfig {
    private final int GLOBAL_LIMIT_MIN;
    private final int LOCAL_LIMIT_MIN;
    protected int mBtFlag;
    protected int mDebugType;
    protected int mGlobalLimit;
    protected int mLocalLimit;
    protected int mMonitorType;
    protected int mWeakGlobalLimit;

    public RefMonitorConfig(int i, JSONArray jSONArray, int i2) {
        super(23, 33, 5);
        this.mMonitorType = 0;
        this.mBtFlag = 0;
        this.mDebugType = 0;
        this.mGlobalLimit = StrategyCenter.GLOBAL_OPTION_START;
        this.mWeakGlobalLimit = StrategyCenter.GLOBAL_OPTION_START;
        this.mLocalLimit = 500;
        this.GLOBAL_LIMIT_MIN = 1000;
        this.LOCAL_LIMIT_MIN = 500;
        if (RuntimeConfig.isLocalTest()) {
            this.mMonitorType = 7;
            this.mBtFlag = 3;
            this.mGlobalLimit = 1000;
            this.mWeakGlobalLimit = 1000;
            this.mLocalLimit = 350;
            this.mDebugType = 4;
            return;
        }
        this.mMonitorType = i;
        this.mBtFlag = i2;
        int length = jSONArray.length();
        if (length >= 2) {
            this.mGlobalLimit = jSONArray.optInt(0);
            this.mWeakGlobalLimit = jSONArray.optInt(1);
            if (length == 3) {
                this.mLocalLimit = jSONArray.optInt(2);
            }
        }
        this.mGlobalLimit = Math.max(1000, this.mGlobalLimit);
        this.mWeakGlobalLimit = Math.max(1000, this.mWeakGlobalLimit);
        this.mLocalLimit = Math.max(500, this.mLocalLimit);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "monitorType=" + this.mMonitorType + "\nlimitGlobal=" + this.mGlobalLimit + "\nlimitWeak=" + this.mWeakGlobalLimit + "\nlimitLocal=" + this.mLocalLimit + "\nbtFlag=" + this.mBtFlag + "\ndebugType=" + this.mDebugType + UpdateDialogNewBase.TYPE;
    }
}
