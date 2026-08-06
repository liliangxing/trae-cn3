package com.bytedance.apm.config;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FluencyConfig {
    private long atraceTag;
    private boolean blockDumpStackEnable;
    private boolean blockEnableUpload;
    private int blockMonitorMode;
    private long blockThreshold;
    private boolean dropEnableUpload;
    private boolean dropSlowMethodSwitch;
    private boolean enableGfxMonitor;
    private boolean enableStackSampling;
    private boolean enableTrace;
    private boolean fpsEnableUpload;
    private JSONObject mAllowScene;
    private boolean seriousBlockEnableUpload;
    private long seriousBlockThreshold;
    private long slowMethodDropThreshold;
    private boolean slowMethodEnableUpload;

    public boolean isEnableStackSampling() {
        return this.enableStackSampling;
    }

    public void setEnableStackSampling(boolean z) {
        this.enableStackSampling = z;
    }

    public boolean isEnableTrace() {
        return this.enableTrace;
    }

    public void setEnableTrace(boolean z) {
        this.enableTrace = z;
    }

    public long getAtraceTag() {
        return this.atraceTag;
    }

    public void setAtraceTag(long j) {
        this.atraceTag = j;
    }

    public boolean isBlockDumpStackEnable() {
        return this.blockDumpStackEnable;
    }

    public void setBlockDumpStackEnable(boolean z) {
        this.blockDumpStackEnable = z;
    }

    public boolean isEnableGfxMonitor() {
        return this.enableGfxMonitor;
    }

    public void setEnableGfxMonitor(boolean z) {
        this.enableGfxMonitor = z;
    }

    public int getBlockMonitorMode() {
        return this.blockMonitorMode;
    }

    public void setBlockMonitorMode(int i) {
        this.blockMonitorMode = i;
    }

    public boolean isSeriousBlockEnableUpload() {
        return this.seriousBlockEnableUpload;
    }

    public void setSeriousBlockEnableUpload(boolean z) {
        this.seriousBlockEnableUpload = z;
    }

    public long getSeriousBlockThreshold() {
        return this.seriousBlockThreshold;
    }

    public void setSeriousBlockThreshold(long j) {
        this.seriousBlockThreshold = j;
    }

    public boolean isSlowMethodEnableUpload() {
        return this.slowMethodEnableUpload;
    }

    public void setSlowMethodEnableUpload(boolean z) {
        this.slowMethodEnableUpload = z;
    }

    public boolean isDropEnableUpload() {
        return this.dropEnableUpload;
    }

    public void setDropEnableUpload(boolean z) {
        this.dropEnableUpload = z;
    }

    public boolean isFpsEnableUpload() {
        return this.fpsEnableUpload;
    }

    public void setFpsEnableUpload(boolean z) {
        this.fpsEnableUpload = z;
    }

    public long getBlockThreshold() {
        return this.blockThreshold;
    }

    public void setBlockThreshold(long j) {
        this.blockThreshold = j;
    }

    public long getSlowMethodDropThreshold() {
        return this.slowMethodDropThreshold;
    }

    public void setSlowMethodDropThreshold(long j) {
        this.slowMethodDropThreshold = j;
    }

    public boolean isBlockEnableUpload() {
        return this.blockEnableUpload;
    }

    public void setBlockEnableUpload(boolean z) {
        this.blockEnableUpload = z;
    }

    public boolean isDropSlowMethodSwitch() {
        return this.dropSlowMethodSwitch;
    }

    public void setDropSlowMethodSwitch(boolean z) {
        this.dropSlowMethodSwitch = z;
    }

    public boolean isAllowSceneEnable(String str) {
        JSONObject jSONObject = this.mAllowScene;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public void setAllowScene(JSONObject jSONObject) {
        this.mAllowScene = jSONObject;
    }

    public String toString() {
        return "FluencyConfig{enableStackSampling=" + this.enableStackSampling + ", enableTrace=" + this.enableTrace + ", atraceTag=" + this.atraceTag + ", blockDumpStackEnable=" + this.blockDumpStackEnable + ", enableGfxMonitor=" + this.enableGfxMonitor + ", blockMonitorMode=" + this.blockMonitorMode + ", seriousBlockEnableUpload=" + this.seriousBlockEnableUpload + ", seriousBlockThreshold=" + this.seriousBlockThreshold + ", slowMethodEnableUpload=" + this.slowMethodEnableUpload + ", dropEnableUpload=" + this.dropEnableUpload + ", fpsEnableUpload=" + this.fpsEnableUpload + ", blockThreshold=" + this.blockThreshold + ", slowMethodDropThreshold=" + this.slowMethodDropThreshold + ", blockEnableUpload=" + this.blockEnableUpload + ", dropSlowMethodSwitch=" + this.dropSlowMethodSwitch + AbstractJsonLexerKt.END_OBJ;
    }
}
