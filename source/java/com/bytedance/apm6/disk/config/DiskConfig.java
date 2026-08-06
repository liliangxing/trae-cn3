package com.bytedance.apm6.disk.config;

import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class DiskConfig {
    private List<String> complianceRelativePaths;
    private List<String> customRelativePaths;
    private long diskThresholdBytes;
    private long fileThresholdBytes;
    private long folderThresholdBytes;
    private List<String> ignoredRelativePaths;
    private boolean isSample;
    private long outdatedIntervalMs;
    private int reportExceptionDirMaxCount;
    private int reportMaxCount;
    private int reportMaxOutdatedCount;
    private int reportMaxTopCount;

    public void setSample(boolean z) {
        this.isSample = z;
    }

    public boolean isSample() {
        return this.isSample;
    }

    public long getDiskThresholdBytes() {
        return this.diskThresholdBytes;
    }

    public void setDiskThresholdBytes(long j) {
        this.diskThresholdBytes = j;
    }

    public long getFolderThresholdBytes() {
        return this.folderThresholdBytes;
    }

    public void setFolderThresholdBytes(long j) {
        this.folderThresholdBytes = j;
    }

    public long getFileThresholdBytes() {
        return this.fileThresholdBytes;
    }

    public void setFileThresholdBytes(long j) {
        this.fileThresholdBytes = j;
    }

    public int getReportMaxCount() {
        return this.reportMaxCount;
    }

    public void setReportMaxCount(int i) {
        this.reportMaxCount = i;
    }

    public int getReportMaxOutdatedCount() {
        return this.reportMaxOutdatedCount;
    }

    public void setReportMaxOutdatedCount(int i) {
        this.reportMaxOutdatedCount = i;
    }

    public int getReportMaxTopCount() {
        return this.reportMaxTopCount;
    }

    public void setReportMaxTopCount(int i) {
        this.reportMaxTopCount = i;
    }

    public int getReportExceptionDirMaxCount() {
        return this.reportExceptionDirMaxCount;
    }

    public void setReportExceptionDirMaxCount(int i) {
        this.reportExceptionDirMaxCount = i;
    }

    public void setOutdatedIntervalMs(long j) {
        this.outdatedIntervalMs = j;
    }

    public long getOutdatedIntervalMs() {
        return this.outdatedIntervalMs;
    }

    public List<String> getCustomRelativePaths() {
        return this.customRelativePaths;
    }

    public void setCustomRelativePaths(List<String> list) {
        this.customRelativePaths = list;
    }

    public List<String> getIgnoredRelativePaths() {
        return this.ignoredRelativePaths;
    }

    public List<String> getComplianceRelativePaths() {
        return this.complianceRelativePaths;
    }

    public void setIgnoredRelativePaths(List<String> list) {
        this.ignoredRelativePaths = list;
    }

    public void setComplianceRelativePaths(List<String> list) {
        this.complianceRelativePaths = list;
    }

    public String toString() {
        return "DiskConfig{diskThresholdBytes=" + this.diskThresholdBytes + ", folderThresholdBytes=" + this.folderThresholdBytes + ", fileThresholdBytes=" + this.fileThresholdBytes + ", reportMaxCount=" + this.reportMaxCount + ", reportMaxOutdatedCount=" + this.reportMaxOutdatedCount + ", reportMaxTopCount=" + this.reportMaxTopCount + ", reportExceptionDirMaxCount=" + this.reportExceptionDirMaxCount + ", outdatedIntervalMs=" + this.outdatedIntervalMs + ", customRelativePaths=" + this.customRelativePaths + ", ignoredRelativePaths=" + this.ignoredRelativePaths + ", complianceRelativePaths=" + this.complianceRelativePaths + ", isSample=" + this.isSample + AbstractJsonLexerKt.END_OBJ;
    }
}
