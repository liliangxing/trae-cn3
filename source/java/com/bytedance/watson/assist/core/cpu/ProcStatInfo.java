package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;

/* loaded from: classes6.dex */
public class ProcStatInfo implements FileStatInfo {
    protected double cpuSpeed;
    protected long cpuTime;
    protected double cpuUsage;
    protected long deltaCpuTime;
    protected double mergeCpuSpeed;
    protected double mergeCpuUsage;
    protected long mergedCpuTime;
    protected int pid;
    protected String processName;

    public ProcStatInfo() {
        this.processName = null;
        this.pid = -1;
        this.cpuTime = 0L;
        this.deltaCpuTime = 0L;
        this.mergedCpuTime = 0L;
        this.cpuUsage = 0.0d;
        this.mergeCpuUsage = 0.0d;
        this.cpuSpeed = 0.0d;
        this.mergeCpuSpeed = 0.0d;
    }

    public ProcStatInfo(String str, int i) {
        this.cpuTime = 0L;
        this.deltaCpuTime = 0L;
        this.mergedCpuTime = 0L;
        this.cpuUsage = 0.0d;
        this.mergeCpuUsage = 0.0d;
        this.cpuSpeed = 0.0d;
        this.mergeCpuSpeed = 0.0d;
        this.processName = str;
        this.pid = i;
    }

    public long getDeltaCpuTime() {
        return this.deltaCpuTime;
    }

    public long getMergedCpuTime() {
        return this.mergedCpuTime;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public double getCpuSpeed() {
        return this.cpuSpeed;
    }

    public double getMergeCpuSpeed() {
        return this.mergeCpuSpeed;
    }

    public void setCpuUsage(long j) {
        if (this.deltaCpuTime < 0 || j <= 0) {
            return;
        }
        this.cpuUsage = getDeltaCpuTime() / j;
    }

    public void setMergedCpuUsage(long j) {
        if (this.mergedCpuTime < 0 || j <= 0) {
            return;
        }
        this.mergeCpuUsage = getMergedCpuTime() / j;
    }

    public void setCpuSpeed(long j) {
        if (this.deltaCpuTime < 0 || j <= 0) {
            return;
        }
        this.cpuSpeed = getDeltaCpuTime() / j;
    }

    public void setMergeCpuSpeed(long j) {
        if (this.mergedCpuTime < 0 || j <= 0) {
            return;
        }
        this.mergeCpuSpeed = getMergedCpuTime() / j;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo fileStatInfo) {
        long cpuTime = getCpuTime() - (fileStatInfo == null ? 0L : ((ProcStatInfo) fileStatInfo).getCpuTime());
        this.deltaCpuTime = cpuTime;
        if (this.mergedCpuTime == 0) {
            this.mergedCpuTime = cpuTime;
        }
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo fileStatInfo) {
        if (fileStatInfo == null) {
            return;
        }
        this.mergedCpuTime += ((ProcStatInfo) fileStatInfo).getMergedCpuTime();
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int i) {
        this.pid = i;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    public long getCpuTime() {
        return this.cpuTime;
    }

    public void setCpuTime(long j) {
        this.cpuTime = j;
    }

    public void reset() {
        this.processName = null;
        this.pid = -1;
        this.cpuTime = 0L;
        this.deltaCpuTime = 0L;
        this.mergedCpuTime = 0L;
        this.cpuUsage = 0.0d;
        this.mergeCpuUsage = 0.0d;
        this.cpuSpeed = 0.0d;
        this.mergeCpuSpeed = 0.0d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("proc_stat:{pid=");
        sb.append(this.pid).append(" process_name:").append(this.processName).append(" delta cpu_time:").append(getDeltaCpuTime()).append(" cpu_usage:").append(this.cpuUsage * 100.0d).append("% cpu_rate:").append(this.cpuSpeed).append("}");
        return sb.toString();
    }

    public String toMergeString() {
        StringBuilder sb = new StringBuilder("proc_stat:{pid=");
        sb.append(this.pid).append(" process_name:").append(this.processName).append(" merged cpu_time:").append(getMergedCpuTime()).append(" cpu_usage:").append(this.mergeCpuUsage * 100.0d).append("% cpu_rate:").append(this.mergeCpuSpeed).append("}");
        return sb.toString();
    }
}
