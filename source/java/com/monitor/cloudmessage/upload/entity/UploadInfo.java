package com.monitor.cloudmessage.upload.entity;

import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class UploadInfo {
    protected String commandId;
    protected boolean isUploading;
    protected long lastUploadTime;
    protected long operateTime;
    protected HashMap<String, String> specificParams;
    protected int cloudMsgResponseCode = 2;
    protected String errorMsg = "no error";

    public UploadInfo(long j, boolean z, String str, HashMap<String, String> hashMap) {
        this.operateTime = 0L;
        this.specificParams = null;
        this.lastUploadTime = j;
        this.isUploading = z;
        this.commandId = str;
        this.operateTime = System.currentTimeMillis();
        this.specificParams = hashMap;
    }

    public long getLastUploadTime() {
        return this.lastUploadTime;
    }

    public void setLastUploadTime(long j) {
        this.lastUploadTime = j;
    }

    public boolean isUploading() {
        return this.isUploading;
    }

    public void setUploading(boolean z) {
        this.isUploading = z;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String str) {
        this.commandId = str;
    }

    public int getCloudMsgResponseCode() {
        return this.cloudMsgResponseCode;
    }

    public void setCloudMsgResponseCode(int i) {
        this.cloudMsgResponseCode = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    public void setOperateTime(long j) {
        this.operateTime = j;
    }

    public HashMap<String, String> getSpecificParams() {
        return this.specificParams;
    }

    public void setSpecificParams(HashMap<String, String> hashMap) {
        this.specificParams = hashMap;
    }

    public String toString() {
        return "UploadInfo{lastUploadTime=" + this.lastUploadTime + ", isUploading=" + this.isUploading + ", commandId='" + this.commandId + "', cloudMsgResponseCode=" + this.cloudMsgResponseCode + ", errorMsg='" + this.errorMsg + "', operateTime=" + this.operateTime + ", specificParams=" + this.specificParams + AbstractJsonLexerKt.END_OBJ;
    }
}
