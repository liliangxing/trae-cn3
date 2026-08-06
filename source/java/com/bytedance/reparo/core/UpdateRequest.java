package com.bytedance.reparo.core;

import android.text.TextUtils;
import com.bytedance.reparo.core.common.utils.StringUtils;
import com.bytedance.reparo.core.parse.PatchRecordInfo;
import java.io.File;

/* loaded from: classes4.dex */
public class UpdateRequest {
    private String mHostAppVersion;
    private boolean mIsAsyncLoad;
    private boolean mIsSupportSubProcess;
    private String mIssueId;
    private File mPatchFile;
    private String mPatchId;
    private String mPatchMd5;
    private String mPatchVersion;

    private UpdateRequest() {
        this.mPatchMd5 = "";
        this.mPatchVersion = "";
        this.mPatchId = "";
        this.mIssueId = "";
        this.mHostAppVersion = "";
        this.mIsAsyncLoad = true;
    }

    public File getPatchFile() {
        return this.mPatchFile;
    }

    public String getPatchMd5() {
        return this.mPatchMd5;
    }

    public String getPatchVersion() {
        return this.mPatchVersion;
    }

    public String getPatchId() {
        return this.mPatchId;
    }

    public String getIssueId() {
        return this.mIssueId;
    }

    public String getHostAppVersion() {
        return this.mHostAppVersion;
    }

    public boolean isIsAsyncLoad() {
        return this.mIsAsyncLoad;
    }

    public boolean isSupportSubProcess() {
        return this.mIsSupportSubProcess;
    }

    public PatchRecordInfo parse() {
        PatchRecordInfo patchRecordInfo = new PatchRecordInfo();
        patchRecordInfo.setPatchMd5(getPatchMd5());
        patchRecordInfo.setPatchVersion(getPatchVersion());
        patchRecordInfo.setPatchId(getPatchId());
        patchRecordInfo.setIssueId(getIssueId());
        patchRecordInfo.setHostAppVersion(getHostAppVersion());
        patchRecordInfo.setAsyncLoad(isIsAsyncLoad());
        patchRecordInfo.setSupportSubProcess(isSupportSubProcess());
        return patchRecordInfo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{patchId = ");
        sb.append(this.mPatchId).append(", issueId = ").append(this.mIssueId).append(", md5 = ").append(this.mPatchMd5).append(", hostAppVersion = ").append(this.mHostAppVersion).append(", isAsyncLoad = ").append(this.mIsAsyncLoad).append(", isSupportSubProcess = ").append(this.mIsSupportSubProcess).append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getConfigId() {
        return StringUtils.notNull(getPatchMd5()) + "_" + StringUtils.notNull(getHostAppVersion()) + "_" + StringUtils.notNull(getPatchId()) + "_" + StringUtils.notNull(getPatchVersion()) + "_" + (isIsAsyncLoad() ? "1" : "0") + "_" + (isSupportSubProcess() ? "1" : "0");
    }

    public boolean equals(PatchRecordInfo patchRecordInfo) {
        return TextUtils.equals(getPatchMd5(), patchRecordInfo.getPatchMd5()) && TextUtils.equals(getHostAppVersion(), patchRecordInfo.getHostAppVersion()) && TextUtils.equals(getPatchId(), patchRecordInfo.getPatchId()) && TextUtils.equals(getIssueId(), patchRecordInfo.getIssueId()) && TextUtils.equals(getPatchVersion(), patchRecordInfo.getPatchVersion()) && isIsAsyncLoad() == patchRecordInfo.isAsyncLoad() && isSupportSubProcess() == patchRecordInfo.isSupportSubProcess();
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private String mHostAppVersion;
        private boolean mIsAsyncLoad = true;
        private String mIssueId;
        private File mPatchFile;
        private String mPatchId;
        private String mPatchMd5;
        private String mPatchVersion;
        private boolean mSupportSubProcess;

        public Builder setPatchFile(File file) {
            this.mPatchFile = file;
            return this;
        }

        public Builder setPatchMd5(String str) {
            this.mPatchMd5 = str;
            return this;
        }

        public Builder setPatchVersion(String str) {
            this.mPatchVersion = str;
            return this;
        }

        public Builder setPatchId(String str) {
            this.mPatchId = str;
            return this;
        }

        public Builder setIssueId(String str) {
            this.mIssueId = str;
            return this;
        }

        public Builder setHostAppVersion(String str) {
            this.mHostAppVersion = str;
            return this;
        }

        public Builder setAsyncLoad(boolean z) {
            this.mIsAsyncLoad = z;
            return this;
        }

        public Builder setSupportSubProcess(boolean z) {
            this.mSupportSubProcess = z;
            return this;
        }

        public UpdateRequest build() {
            checkArgument();
            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.mPatchFile = this.mPatchFile;
            updateRequest.mPatchMd5 = this.mPatchMd5;
            updateRequest.mPatchVersion = this.mPatchVersion;
            updateRequest.mPatchId = this.mPatchId;
            updateRequest.mIssueId = this.mIssueId;
            updateRequest.mHostAppVersion = this.mHostAppVersion;
            updateRequest.mIsAsyncLoad = this.mIsAsyncLoad;
            updateRequest.mIsSupportSubProcess = this.mSupportSubProcess;
            return updateRequest;
        }

        private void checkArgument() {
            if (this.mPatchFile == null) {
                throw new IllegalArgumentException("patch file is null");
            }
            if (TextUtils.isEmpty(this.mPatchMd5)) {
                throw new IllegalArgumentException("patch md5 is empty");
            }
            if (TextUtils.isEmpty(this.mHostAppVersion)) {
                throw new IllegalArgumentException("host app version is empty");
            }
        }
    }
}
