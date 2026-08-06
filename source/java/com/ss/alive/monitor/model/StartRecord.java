package com.ss.alive.monitor.model;

import com.bytedance.common.process.cross.CrossProcessDatabaseHelper;
import com.bytedance.common.push.BaseJson;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class StartRecord extends BaseJson {
    private long mClientTime;
    private boolean mIsActive;
    private boolean mIsForeGround;
    private String mProcess;
    private StackTraceElement[] mStackTrace;
    private String mStackTraceStr;
    private StartType mStartType;
    private String mTargetComponent;
    private String mTargetPkg;

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "start_type", this.mStartType.startType);
        add(jSONObject, "is_fore_ground", this.mIsForeGround ? 1L : 0L);
        add(jSONObject, "is_active", this.mIsActive ? 1L : 0L);
        add(jSONObject, "target_pkg", this.mTargetPkg);
        add(jSONObject, "target_component", this.mTargetComponent);
        add(jSONObject, "client_time", this.mClientTime);
        add(jSONObject, "process", this.mProcess);
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] stackTraceElementArr = this.mStackTrace;
        if (stackTraceElementArr != null) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                JSONObject jSONObject2 = new JSONObject();
                add(jSONObject2, "class_name", stackTraceElement.getClassName());
                add(jSONObject2, "file_name", stackTraceElement.getFileName());
                add(jSONObject2, CrossProcessDatabaseHelper.COL_METHOD_NAME, stackTraceElement.getMethodName());
                add(jSONObject2, "line_number", stackTraceElement.getLineNumber());
                jSONArray.put(jSONObject2);
            }
        }
        add(jSONObject, CrashHianalyticsData.STACK_TRACE, jSONArray.toString());
        return jSONObject;
    }

    public StartType getStartType() {
        return this.mStartType;
    }

    public StartRecord setStartType(StartType startType) {
        this.mStartType = startType;
        return this;
    }

    public boolean isForeGround() {
        return this.mIsForeGround;
    }

    public StartRecord setIsForeGround(boolean z) {
        this.mIsForeGround = z;
        return this;
    }

    public String getTargetPkg() {
        return this.mTargetPkg;
    }

    public StartRecord setTargetPkg(String str) {
        this.mTargetPkg = str;
        return this;
    }

    public String getTargetComponent() {
        return this.mTargetComponent;
    }

    public StartRecord setTargetComponent(String str) {
        this.mTargetComponent = str;
        return this;
    }

    public long getClientTime() {
        return this.mClientTime;
    }

    public StartRecord setClientTime(long j) {
        this.mClientTime = j;
        return this;
    }

    public void setStackTrace(StackTraceElement[] stackTraceElementArr, String str) {
        this.mStackTrace = stackTraceElementArr;
        this.mStackTraceStr = str;
    }

    public StackTraceElement[] getStackTrace() {
        return this.mStackTrace;
    }

    public String getProcess() {
        return this.mProcess;
    }

    public StartRecord setProcess(String str) {
        this.mProcess = str;
        return this;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public StartRecord setActive(boolean z) {
        this.mIsActive = z;
        return this;
    }

    public String getStackTraceStr() {
        return this.mStackTraceStr;
    }
}
