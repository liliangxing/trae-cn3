package com.ss.bytertc.engine;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class SysStats {
    public double cpuAppUsage;
    public int cpuCores;
    public double cpuTotalUsage;
    public long freeMemory;
    public long fullMemory;
    public double memoryRatio;
    public double memoryUsage;
    public double totalMemoryRatio;
    public long totalMemoryUsage;

    public SysStats() {
    }

    public SysStats(int cpuCores, double cpuAppUsage, double cpuTotalUsage, double memoryUsage, long fullMemory, long totalMemoryUsage, long freeMemory, double memoryRatio, double totalMemoryRatio) {
        this.cpuCores = cpuCores;
        this.cpuAppUsage = cpuAppUsage;
        this.cpuTotalUsage = cpuTotalUsage;
        this.memoryUsage = memoryUsage;
        this.fullMemory = fullMemory;
        this.totalMemoryUsage = totalMemoryUsage;
        this.freeMemory = freeMemory;
        this.memoryRatio = memoryRatio;
        this.totalMemoryRatio = totalMemoryRatio;
    }

    public String toString() {
        return "SysStats{cpu_cores=" + this.cpuCores + "' cpu_app_usage=" + this.cpuAppUsage + "', cpu_total_usage=" + this.cpuTotalUsage + ", memory_usage=" + this.memoryUsage + "full_memory=" + this.fullMemory + "'total_memory_usage=" + this.totalMemoryUsage + "'free_memory=" + this.freeMemory + "'memory_ratio=" + this.memoryRatio + "'total_memory_ratio=" + this.totalMemoryRatio + AbstractJsonLexerKt.END_OBJ;
    }

    private static SysStats create(int cpuCores, double cpuAppUsage, double cpuTotalUsage, double memoryUsage, long fullMemory, long totalMemoryUsage, long freeMemory, double memoryRatio, double totalMemoryRatio) {
        return new SysStats(cpuCores, cpuAppUsage, cpuTotalUsage, memoryUsage, fullMemory, totalMemoryUsage, freeMemory, memoryRatio, totalMemoryRatio);
    }
}
