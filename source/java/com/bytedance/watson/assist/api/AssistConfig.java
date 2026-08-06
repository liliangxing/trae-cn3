package com.bytedance.watson.assist.api;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class AssistConfig {
    public static AssistConfig DEFAULT = new AssistConfig();
    private CpuAbnormalConfig cpuAbnormalConfig;
    private int cpuSampleBatteryLevel;
    private int cpuSampleBatteryTemp;
    public boolean enableProcessCpuUsageStat;
    public boolean enableProcessTimeFreqPercent;
    public boolean enableSystemCpuTimeFreqPercent;
    public boolean enableSystemCpuUsageStat;
    public boolean enableThreadCpuUsageStat;

    public AssistConfig() {
        this.enableProcessCpuUsageStat = false;
        this.enableThreadCpuUsageStat = false;
        this.enableSystemCpuUsageStat = false;
        this.enableProcessTimeFreqPercent = false;
        this.enableSystemCpuTimeFreqPercent = false;
        this.cpuSampleBatteryTemp = 37;
        this.cpuSampleBatteryLevel = 30;
        this.cpuAbnormalConfig = new CpuAbnormalConfig();
    }

    public AssistConfig(CpuAbnormalConfig cpuAbnormalConfig) {
        this.enableProcessCpuUsageStat = false;
        this.enableThreadCpuUsageStat = false;
        this.enableSystemCpuUsageStat = false;
        this.enableProcessTimeFreqPercent = false;
        this.enableSystemCpuTimeFreqPercent = false;
        this.cpuSampleBatteryTemp = 37;
        this.cpuSampleBatteryLevel = 30;
        new CpuAbnormalConfig();
        this.cpuAbnormalConfig = cpuAbnormalConfig;
    }

    public CpuAbnormalConfig getCpuAbnormalConfig() {
        return this.cpuAbnormalConfig;
    }

    public void setCpuAbnormalConfig(CpuAbnormalConfig cpuAbnormalConfig) {
        this.cpuAbnormalConfig = cpuAbnormalConfig;
    }

    public int getCpuSampleBatteryTemp() {
        return this.cpuSampleBatteryTemp;
    }

    public void setCpuSampleBatteryTemp(int i) {
        this.cpuSampleBatteryTemp = i;
    }

    public int getCpuSampleBatteryLevel() {
        return this.cpuSampleBatteryLevel;
    }

    public void setCpuSampleBatteryLevel(int i) {
        this.cpuSampleBatteryLevel = i;
    }

    public void setEnableCpuUsageStat(boolean z) {
        this.enableProcessCpuUsageStat = z;
    }

    public void setEnableThreadCpuUsageStat(boolean z) {
        this.enableThreadCpuUsageStat = z;
    }

    public void setEnableSystemCpuUsageStat(boolean z) {
        this.enableSystemCpuUsageStat = z;
    }

    public void setEnableProcessTimeFreqPercent(boolean z) {
        this.enableProcessTimeFreqPercent = z;
    }

    public void setEnableSystemCpuTimeFreqPercent(boolean z) {
        this.enableSystemCpuTimeFreqPercent = z;
    }

    public boolean isEnableCpuUsageStat() {
        return this.enableProcessCpuUsageStat;
    }

    public boolean isEnableThreadCpuUsageStat() {
        return this.enableThreadCpuUsageStat;
    }

    public boolean isEnableSystemCpuUsageStat() {
        return this.enableSystemCpuUsageStat;
    }

    public boolean isEnableProcessTimeFreqPercent() {
        return this.enableProcessTimeFreqPercent;
    }

    public boolean isEnableSystemCpuTimeFreqPercent() {
        return this.enableSystemCpuTimeFreqPercent;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.enableProcessCpuUsageStat + ", enableThreadCpuUsageStat=" + this.enableThreadCpuUsageStat + ", enableSystemCpuUsageStat=" + this.enableSystemCpuUsageStat + ", enableProcessTimeFreqPercent=" + this.enableProcessTimeFreqPercent + ", enableSystemCpuTimeFreqPercent=" + this.enableSystemCpuTimeFreqPercent + ", cpuSampleBatteryTemp=" + this.cpuSampleBatteryTemp + ", cpuSampleBatteryLevel=" + this.cpuSampleBatteryLevel + ", cpuAbnormalConfig=" + this.cpuAbnormalConfig + AbstractJsonLexerKt.END_OBJ;
    }

    /* loaded from: classes6.dex */
    public static class CpuAbnormalConfig {
        private float BigCpuCoreTimePercent;
        private String cpuHardWare;
        private float cpuSpeed;
        private float middleCpuCoreTimePercent;
        private String scene;
        private float smallCpuCoreTimePercent;

        public CpuAbnormalConfig() {
            this.cpuHardWare = "unknown";
            this.scene = "default";
            this.cpuSpeed = 0.0f;
            this.smallCpuCoreTimePercent = 0.0f;
            this.middleCpuCoreTimePercent = 0.0f;
            this.BigCpuCoreTimePercent = 0.0f;
        }

        public CpuAbnormalConfig(String str, String str2) {
            this.cpuSpeed = 0.0f;
            this.smallCpuCoreTimePercent = 0.0f;
            this.middleCpuCoreTimePercent = 0.0f;
            this.BigCpuCoreTimePercent = 0.0f;
            this.scene = str;
            this.cpuHardWare = str2;
        }

        public String getCpuHardWare() {
            return this.cpuHardWare;
        }

        public void setCpuHardWare(String str) {
            this.cpuHardWare = str;
        }

        public String getScene() {
            return this.scene;
        }

        public void setScene(String str) {
            this.scene = str;
        }

        public float getCpuSpeed() {
            return this.cpuSpeed;
        }

        public void setCpuSpeed(float f) {
            this.cpuSpeed = f;
        }

        public float getSmallCpuCoreTimePercent() {
            return this.smallCpuCoreTimePercent;
        }

        public void setSmallCpuCoreTimePercent(float f) {
            this.smallCpuCoreTimePercent = f;
        }

        public float getMiddleCpuCoreTimePercent() {
            return this.middleCpuCoreTimePercent;
        }

        public void setMiddleCpuCoreTimePercent(float f) {
            this.middleCpuCoreTimePercent = f;
        }

        public float getBigCpuCoreTimePercent() {
            return this.BigCpuCoreTimePercent;
        }

        public void setBigCpuCoreTimePercent(float f) {
            this.BigCpuCoreTimePercent = f;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.cpuHardWare + "', scene='" + this.scene + "', cpuSpeed=" + this.cpuSpeed + ", smallCpuCoreTimePercent=" + this.smallCpuCoreTimePercent + ", middleCpuCoreTimePercent=" + this.middleCpuCoreTimePercent + ", BigCpuCoreTimePercent=" + this.BigCpuCoreTimePercent + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
