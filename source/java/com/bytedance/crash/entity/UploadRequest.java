package com.bytedance.crash.entity;

import java.util.List;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class UploadRequest {
    private String aid;
    private List<String> alogFiles;
    private String did;
    private String dumpFilePath;
    private boolean encrypt;
    private String processName;
    private JSONObject uploadBody;
    private String uploadUrl;

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public void setUploadUrl(String str) {
        this.uploadUrl = str;
    }

    public JSONObject getUploadBody() {
        return this.uploadBody;
    }

    public void setUploadBody(JSONObject jSONObject) {
        this.uploadBody = jSONObject;
    }

    public String getDumpFilePath() {
        return this.dumpFilePath;
    }

    public void setDumpFilePath(String str) {
        this.dumpFilePath = str;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public List<String> getAlogFiles() {
        return this.alogFiles;
    }

    public void setAlogFiles(List<String> list) {
        this.alogFiles = list;
    }
}
