package com.bytedance.apm6.cpu.config;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class CpuExceptionConfig {
    private static final double DEFAULT_MAX_PROCESS_BACK_CPU_SPEED = 3.0d;
    private static final double DEFAULT_MAX_PROCESS_FORE_CPU_SPEED = 6.0d;
    private static final double DEFAULT_MAX_THREAD_CPU_RATE = 0.05d;
    private Map<String, Double> backSceneMaxSpeedMap;
    private Map<String, Double> foreSceneMaxSpeedMap;
    private Map<String, Double> maxThreadCpuRateMap;
    private int processDetectInterval;
    private int threadDetectInterval;
    private boolean isOpen = false;
    private boolean isCollectMainThread = false;
    private double maxProcessBackCpuSpeed = DEFAULT_MAX_PROCESS_BACK_CPU_SPEED;
    private double maxProcessForeCpuSpeed = DEFAULT_MAX_PROCESS_FORE_CPU_SPEED;
    private double maxThreadCpuRate = DEFAULT_MAX_THREAD_CPU_RATE;
    private boolean isCollectAllProcess = false;
    private boolean isCollectThreadStack = true;
    private boolean isCollectNativeThread = false;

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(boolean z) {
        this.isOpen = z;
    }

    public Map<String, Double> getBackSceneMaxSpeedMap() {
        return this.backSceneMaxSpeedMap;
    }

    public void setBackSceneMaxSpeedMap(Map<String, Double> map) {
        this.backSceneMaxSpeedMap = map;
    }

    public Map<String, Double> getForeSceneMaxSpeedMap() {
        return this.foreSceneMaxSpeedMap;
    }

    public void setForeSceneMaxSpeedMap(Map<String, Double> map) {
        this.foreSceneMaxSpeedMap = map;
    }

    public boolean isCollectMainThread() {
        return this.isCollectMainThread;
    }

    public void setCollectMainThread(boolean z) {
        this.isCollectMainThread = z;
    }

    public double getMaxProcessBackCpuSpeed() {
        return this.maxProcessBackCpuSpeed;
    }

    public void setMaxProcessBackCpuSpeed(double d) {
        this.maxProcessBackCpuSpeed = d;
    }

    public double getMaxThreadCpuRate() {
        return this.maxThreadCpuRate;
    }

    public void setMaxThreadCpuRate(double d) {
        this.maxThreadCpuRate = d;
    }

    public Map<String, Double> getMaxThreadCpuRateMap() {
        return this.maxThreadCpuRateMap;
    }

    public void setMaxThreadCpuRateMap(Map<String, Double> map) {
        this.maxThreadCpuRateMap = map;
    }

    public boolean isCollectAllProcess() {
        return this.isCollectAllProcess;
    }

    public void setCollectAllProcess(boolean z) {
        this.isCollectAllProcess = z;
    }

    public double getMaxProcessForeCpuSpeed() {
        return this.maxProcessForeCpuSpeed;
    }

    public void setMaxProcessForeCpuSpeed(double d) {
        this.maxProcessForeCpuSpeed = d;
    }

    public String toString() {
        return "CpuExceptionConfig{isOpen=" + this.isOpen + ", isCollectMainThread=" + this.isCollectMainThread + ", maxProcessBackCpuSpeed=" + this.maxProcessBackCpuSpeed + ", maxProcessForeCpuSpeed=" + this.maxProcessForeCpuSpeed + ", maxThreadCpuRate=" + this.maxThreadCpuRate + ", isCollectAllProcess=" + this.isCollectAllProcess + ", backSceneMaxSpeedMap=" + this.backSceneMaxSpeedMap + ", foreSceneMaxSpeedMap=" + this.foreSceneMaxSpeedMap + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean isCollectThreadStack() {
        return this.isCollectThreadStack;
    }

    public void setCollectThreadStack(boolean z) {
        this.isCollectThreadStack = z;
    }

    public int getProcessDetectInterval() {
        return this.processDetectInterval;
    }

    public void setProcessDetectInterval(int i) {
        this.processDetectInterval = i;
    }

    public int getThreadDetectInterval() {
        return this.threadDetectInterval;
    }

    public void setThreadDetectInterval(int i) {
        this.threadDetectInterval = i;
    }

    public boolean isCollectNativeThread() {
        return this.isCollectNativeThread;
    }

    public void setCollectNativeThread(boolean z) {
        this.isCollectNativeThread = z;
    }
}
