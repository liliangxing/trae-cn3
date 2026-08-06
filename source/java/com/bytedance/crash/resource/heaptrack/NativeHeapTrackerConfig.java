package com.bytedance.crash.resource.heaptrack;

import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import com.ss.android.update.UpdateDialogNewBase;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class NativeHeapTrackerConfig extends ResourceMonitorConfig {
    protected int mBtFlag;
    protected int mBtSize;
    protected int mCollectSizeMB;
    boolean mDebug;
    protected int mMonitorSize;
    protected int mMonitorType;
    protected boolean mNeedDumpMemInfo;
    protected int mPollSeconds;
    protected int mWaterLineMB;

    public NativeHeapTrackerConfig(JSONArray jSONArray) {
        super(21, 35, 1);
        this.mBtFlag = 3;
        this.mBtSize = 500;
        this.mDebug = false;
        if (RuntimeConfig.isLocalTest()) {
            this.mMonitorType = 0;
            this.mWaterLineMB = 30;
            this.mCollectSizeMB = 300;
            this.mPollSeconds = 1;
            this.mNeedDumpMemInfo = false;
            this.mMonitorSize = 2;
            this.mDebug = true;
            this.mBtSize = 4;
            this.mBtFlag = 3;
            return;
        }
        this.mPollSeconds = jSONArray.optInt(0);
        this.mWaterLineMB = jSONArray.optInt(1);
        this.mCollectSizeMB = jSONArray.optInt(2);
        this.mNeedDumpMemInfo = jSONArray.optBoolean(3);
        this.mMonitorSize = jSONArray.optInt(5);
        this.mMonitorType = jSONArray.optInt(6);
        if (jSONArray.length() >= 9) {
            this.mBtFlag = jSONArray.optInt(7);
            this.mBtSize = jSONArray.optInt(8);
        }
        this.mPollSeconds = Math.max(4, this.mPollSeconds);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "pollSecond=" + this.mPollSeconds + "\nwaterLineMB=" + this.mWaterLineMB + "\ncollectSizeMB=" + this.mCollectSizeMB + "\nneedDumpMemInfo=" + this.mNeedDumpMemInfo + "\ndebug=" + this.mDebug + "\nmonitorSize=" + this.mMonitorSize + "\nmonitorType=" + this.mMonitorType + "\nbtFlag=" + this.mBtFlag + "\nbtSize=" + this.mBtSize + UpdateDialogNewBase.TYPE;
    }
}
