package com.ss.bytertc.engine.utils;

/* loaded from: classes7.dex */
public class DevicePerformanceInfo {
    public int cpuCores;
    public float cpuFrequency;
    public String cpuModel;
    public int cpuThreads;
    public String deviceModel;
    public String gpuModel;
    public float memory;
    public String os;
    public String osVersion;

    public DevicePerformanceInfo(float memory, int cpuCores, int cpuThreads, float cpuFrequency, String cpuModel, String gpuModel, String os, String osVersion, String deviceModel) {
        this.memory = memory;
        this.cpuCores = cpuCores;
        this.cpuThreads = cpuThreads;
        this.cpuFrequency = cpuFrequency;
        this.cpuModel = cpuModel;
        this.gpuModel = gpuModel;
        this.os = os;
        this.osVersion = osVersion;
        this.deviceModel = deviceModel;
    }

    private static DevicePerformanceInfo create(float memory, int cpuCores, int cpuThreads, float cpuFrequency, String cpuModel, String gpuModel, String os, String osVersion, String deviceModel) {
        return new DevicePerformanceInfo(memory, cpuCores, cpuThreads, cpuFrequency, cpuModel, gpuModel, os, osVersion, deviceModel);
    }
}
