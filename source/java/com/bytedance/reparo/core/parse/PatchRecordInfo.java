package com.bytedance.reparo.core.parse;

import android.text.TextUtils;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.common.utils.StringUtils;
import java.io.File;

/* loaded from: classes4.dex */
public class PatchRecordInfo {
    private boolean hasJavaPatch;
    private boolean hasSoLibraries;
    private String hostAppVersion;
    private transient File installDir;
    private boolean isSupportSubProcess;
    private String issueId;
    private transient File javaPatchRootDir;
    private String patchId;
    private String patchMd5;
    private String patchVersion;
    private transient File soInfoFile;
    private boolean hasNonSelfSo = false;
    private boolean isAsyncLoad = true;
    private boolean beIllegalNextStart = false;

    public PatchRecordInfo copy() {
        PatchRecordInfo patchRecordInfo = new PatchRecordInfo();
        patchRecordInfo.installDir = this.installDir;
        patchRecordInfo.hasJavaPatch = this.hasJavaPatch;
        patchRecordInfo.javaPatchRootDir = this.javaPatchRootDir;
        patchRecordInfo.hasSoLibraries = this.hasSoLibraries;
        patchRecordInfo.hasNonSelfSo = this.hasNonSelfSo;
        patchRecordInfo.soInfoFile = this.soInfoFile;
        patchRecordInfo.patchMd5 = this.patchMd5;
        patchRecordInfo.patchId = this.patchId;
        patchRecordInfo.issueId = this.issueId;
        patchRecordInfo.patchVersion = this.patchVersion;
        patchRecordInfo.hostAppVersion = this.hostAppVersion;
        patchRecordInfo.isAsyncLoad = this.isAsyncLoad;
        patchRecordInfo.isSupportSubProcess = this.isSupportSubProcess;
        patchRecordInfo.beIllegalNextStart = this.beIllegalNextStart;
        return patchRecordInfo;
    }

    public File getInstallDir() {
        return this.installDir;
    }

    public String getInstallDirPath() {
        File file = this.installDir;
        return file == null ? "" : file.getAbsolutePath();
    }

    public void setInstallDir(File file) {
        this.installDir = file;
    }

    public boolean isHasJavaPatch() {
        return this.hasJavaPatch;
    }

    public void setHasJavaPatch(boolean z) {
        this.hasJavaPatch = z;
    }

    public String getJavaPatchRootDirPath() {
        File file = this.javaPatchRootDir;
        return file == null ? "" : file.getAbsolutePath();
    }

    public void setJavaPatchRootDir(File file) {
        this.javaPatchRootDir = file;
    }

    public File getJavaPatchRootDir() {
        return this.javaPatchRootDir;
    }

    public boolean isHasSoLibraries() {
        return this.hasSoLibraries;
    }

    public boolean isHasNonSelfSo() {
        return this.hasNonSelfSo;
    }

    public void setHasSoLibraries(boolean z) {
        this.hasSoLibraries = z;
    }

    public void setHasNonSelfSo(boolean z) {
        this.hasNonSelfSo = z;
    }

    public File getSoInfoFile() {
        return this.soInfoFile;
    }

    public String getSoInfoFilePath() {
        File file = this.soInfoFile;
        return file == null ? "" : file.getAbsolutePath();
    }

    public void setSoInfoFile(File file) {
        this.soInfoFile = file;
    }

    public String getPatchMd5() {
        return this.patchMd5;
    }

    public void setPatchMd5(String str) {
        this.patchMd5 = str;
    }

    public void setIssueId(String str) {
        this.issueId = str;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public String getPatchVersion() {
        return this.patchVersion;
    }

    public void setPatchVersion(String str) {
        this.patchVersion = str;
    }

    public String getPatchId() {
        return this.patchId;
    }

    public void setPatchId(String str) {
        this.patchId = str;
    }

    public String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public void setHostAppVersion(String str) {
        this.hostAppVersion = str;
    }

    public void makeIllegalNextStart() {
        this.hostAppVersion += "_illegal";
        this.beIllegalNextStart = true;
    }

    public boolean illegalNextStart() {
        return this.beIllegalNextStart;
    }

    public boolean isAsyncLoad() {
        return this.isAsyncLoad;
    }

    public void setAsyncLoad(boolean z) {
        this.isAsyncLoad = z;
    }

    public boolean isSupportSubProcess() {
        return this.isSupportSubProcess;
    }

    public void setSupportSubProcess(boolean z) {
        this.isSupportSubProcess = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLegal() {
        boolean isExist = FileUtils.isExist(getInstallDir());
        if (this.hasJavaPatch && FileUtils.isEmpty(getJavaPatchRootDir())) {
            isExist = false;
        }
        if (!this.hasSoLibraries || FileUtils.isExist(getSoInfoFile())) {
            return isExist;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{issueId = ");
        sb.append(this.issueId).append(", patchId = ").append(this.patchId).append(", md5 = ").append(this.patchMd5).append(", hostAppVersion = ").append(this.hostAppVersion).append(", isAsyncLoad = ").append(this.isAsyncLoad).append(", isSupportSubProcess = ").append(this.isSupportSubProcess).append(", installPath = ").append(StringUtils.notNull(this.installDir)).append(", hasJavaPatch = ").append(this.hasJavaPatch).append(", hasSoLibraries = ").append(this.hasSoLibraries).append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 527 + this.patchMd5.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PatchRecordInfo)) {
            return false;
        }
        PatchRecordInfo patchRecordInfo = (PatchRecordInfo) obj;
        return FileUtils.equals(this.installDir, patchRecordInfo.installDir) && this.hasJavaPatch == patchRecordInfo.hasJavaPatch && FileUtils.equals(this.javaPatchRootDir, patchRecordInfo.javaPatchRootDir) && this.hasSoLibraries == patchRecordInfo.hasSoLibraries && FileUtils.equals(this.soInfoFile, patchRecordInfo.soInfoFile) && TextUtils.equals(this.patchMd5, patchRecordInfo.patchMd5) && TextUtils.equals(this.patchId, patchRecordInfo.patchId) && TextUtils.equals(this.issueId, patchRecordInfo.issueId) && TextUtils.equals(this.patchVersion, patchRecordInfo.patchVersion) && TextUtils.equals(this.hostAppVersion, patchRecordInfo.hostAppVersion) && this.isAsyncLoad == patchRecordInfo.isAsyncLoad && this.isSupportSubProcess == patchRecordInfo.isSupportSubProcess;
    }
}
