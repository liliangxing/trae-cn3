package com.bytedance.apm.entity;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UploadRequest {
    private String aid;
    private List<String> alogFiles;
    private JSONObject commonParams;
    private String did;
    private String processName;

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

    public JSONObject getCommonParams() {
        return this.commonParams;
    }

    public void setCommonParams(JSONObject jSONObject) {
        this.commonParams = jSONObject;
    }
}
