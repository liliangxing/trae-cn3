package com.bytedance.reparo.model;

import android.text.TextUtils;
import com.bytedance.reparo.core.UpdateRequest;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import com.google.gson.annotations.SerializedName;
import java.io.File;

/* loaded from: classes4.dex */
public class PatchFetchInfo {

    @SerializedName("update_version_code")
    private String hostAppVersion;

    @SerializedName("async_load")
    private boolean isAsyncLoad = true;

    @SerializedName("support_sub_process")
    private boolean isSupportSubProcess;

    @SerializedName("hotfix_id")
    private String issueId;
    private String md5;
    private String name;
    private boolean offline;

    @SerializedName("patch_id")
    private int patchId;

    @SerializedName("patch_name")
    private String patchName;
    private String url;

    @SerializedName("versioncode")
    private int versionCode;
    private boolean wifiOnly;

    public String getMd5() {
        String str = this.md5;
        return str == null ? "" : str.toLowerCase();
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getPatchId() {
        return this.patchId;
    }

    public void setPatchId(int i) {
        this.patchId = i;
    }

    public String getPatchName() {
        return this.patchName;
    }

    public void setPatchName(String str) {
        this.patchName = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public void setOffline(boolean z) {
        this.offline = z;
    }

    public boolean isWifiOnly() {
        return this.wifiOnly;
    }

    public void setWifiOnly(boolean z) {
        this.wifiOnly = z;
    }

    public String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public void setHostAppVersion(String str) {
        this.hostAppVersion = str;
    }

    public void setAsyncLoad(boolean z) {
        this.isAsyncLoad = z;
    }

    public void setSupportSubProcess(boolean z) {
        this.isSupportSubProcess = z;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public void setIssueId(String str) {
        this.issueId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return 527 + getMd5().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PatchFetchInfo patchFetchInfo = (PatchFetchInfo) obj;
        return TextUtils.equals(this.md5, patchFetchInfo.md5) && TextUtils.equals(this.issueId, patchFetchInfo.issueId) && TextUtils.equals(this.hostAppVersion, patchFetchInfo.hostAppVersion) && TextUtils.equals(this.url, patchFetchInfo.url) && this.versionCode == patchFetchInfo.versionCode && this.patchId == patchFetchInfo.patchId && this.isAsyncLoad == patchFetchInfo.isAsyncLoad && this.isSupportSubProcess == patchFetchInfo.isSupportSubProcess;
    }

    public boolean equals(PatchRecordInfo patchRecordInfo) {
        return TextUtils.equals(String.valueOf(this.patchId), patchRecordInfo.getPatchId());
    }

    public boolean isSupportSubProcess() {
        return this.isSupportSubProcess;
    }

    public boolean isAsyncLoad() {
        return this.isAsyncLoad;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{patchName = ");
        sb.append(this.patchName).append(", patchId = ").append(this.patchId).append(", issueId = ").append(this.issueId).append(", md5 = ").append(this.md5).append(", hostAppVersion = ").append(this.hostAppVersion).append(", isAsyncLoad = ").append(this.isAsyncLoad).append(", isSupportSubProcess = ").append(this.isSupportSubProcess).append("}");
        return sb.toString();
    }

    public UpdateRequest convertToUpdateRequest(File file) {
        return new UpdateRequest.Builder().setPatchFile(file).setPatchMd5(getMd5()).setPatchVersion(String.valueOf(this.versionCode)).setPatchId(String.valueOf(this.patchId)).setIssueId(this.issueId).setHostAppVersion(this.hostAppVersion).setAsyncLoad(this.isAsyncLoad).setSupportSubProcess(isSupportSubProcess()).build();
    }
}
