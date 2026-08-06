package com.bytedance.apm.entity;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BatteryLogEntity {
    private long accumulation;
    private boolean deleteFlag;
    private boolean front;
    private long id;
    private boolean mainProcess;
    private String processName;
    private String scene;
    private String source;
    private String startUuid;
    private boolean status;
    public long time;
    public String type;
    private long versionId;

    public BatteryLogEntity(boolean z, long j, String str, boolean z2, long j2, String str2) {
        this.front = z;
        this.time = j;
        this.type = str;
        this.status = z2;
        this.accumulation = j2;
        this.scene = str2;
    }

    public BatteryLogEntity(boolean z, long j, String str, boolean z2, long j2, String str2, String str3) {
        this.front = z;
        this.time = j;
        this.type = str;
        this.status = z2;
        this.accumulation = j2;
        this.scene = str2;
        this.source = str3;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public boolean isFront() {
        return this.front;
    }

    public boolean isBack() {
        return !this.front;
    }

    public boolean isOn() {
        return this.status;
    }

    public boolean isOff() {
        return !this.status;
    }

    public long getAccumulation() {
        return this.accumulation;
    }

    public long getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSource() {
        return this.source;
    }

    public void setVersionId(long j) {
        this.versionId = j;
    }

    public long getVersionId() {
        return this.versionId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public boolean isMainProcess() {
        return this.mainProcess;
    }

    public void setMainProcess(boolean z) {
        this.mainProcess = z;
    }

    public String getStartUuid() {
        return this.startUuid;
    }

    public void setStartUuid(String str) {
        this.startUuid = str;
    }

    public boolean isDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(boolean z) {
        this.deleteFlag = z;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setAccumulation(long j) {
        this.accumulation = j;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.id + ", front=" + this.front + ", time=" + this.time + ", type='" + this.type + "', status=" + this.status + ", scene='" + this.scene + "', accumulation=" + this.accumulation + ", source='" + this.source + "', versionId=" + this.versionId + ", processName='" + this.processName + "', mainProcess=" + this.mainProcess + ", startUuid='" + this.startUuid + "', deleteFlag=" + this.deleteFlag + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject simpleJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("front", this.front);
        jSONObject.put("time", this.time);
        jSONObject.put("type", this.type);
        jSONObject.put("scene", this.scene);
        jSONObject.put("processName", this.processName);
        return jSONObject;
    }
}
