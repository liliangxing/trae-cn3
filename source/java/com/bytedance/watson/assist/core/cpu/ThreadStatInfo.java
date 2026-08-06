package com.bytedance.watson.assist.core.cpu;

/* loaded from: classes6.dex */
public class ThreadStatInfo extends ProcStatInfo {
    @Override // com.bytedance.watson.assist.core.cpu.ProcStatInfo
    public String toString() {
        StringBuilder sb = new StringBuilder("thread_stat:{tid=");
        sb.append(this.pid).append(" thread_name:").append(this.processName).append(" cpu_time:").append(getDeltaCpuTime()).append(" cpu_usage:").append(this.cpuUsage * 100.0d).append("% cpu_speed:").append(this.cpuSpeed).append("}");
        return sb.toString();
    }

    @Override // com.bytedance.watson.assist.core.cpu.ProcStatInfo
    public String toMergeString() {
        StringBuilder sb = new StringBuilder("thread_stat:{tid=");
        sb.append(this.pid).append(" thread_name:").append(this.processName).append(" cpu_time:").append(getMergedCpuTime()).append(" cpu_usage:").append(this.mergeCpuUsage * 100.0d).append("% cpu_speed:").append(this.mergeCpuSpeed).append("}");
        return sb.toString();
    }
}
