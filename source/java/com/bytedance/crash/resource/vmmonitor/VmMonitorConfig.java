package com.bytedance.crash.resource.vmmonitor;

import com.bytedance.crash.NpthBus;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import com.bytedance.upc.Constants;
import com.ss.android.update.UpdateDialogNewBase;
import com.ss.ttm.player.MediaPlayer;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class VmMonitorConfig extends ResourceMonitorConfig {
    public static final int DEFAULT_SLEEP_TIME_DURING_MONITOR = 3000;
    private static final int INDEX_JAVA_STACK = 3;
    private static final int INDEX_MEM_SIZE = 1;
    private static final int INDEX_MEM_TYPE = 0;
    private static final int INDEX_MONITOR_RULES = 4;
    private static final int INDEX_NATIVE_STACK = 2;
    private static final int JAVA_STACK_BIT = 1;
    private static final int NATIVE_STACK_BIT = 0;
    public static final long SIZE_K = 1024;
    public static final long SLEEP_TIME_BEFORE_RECOVER = 60000;
    private String mBacktraceRule;
    protected boolean mDebug;
    private int mDumpSizeMB;
    protected boolean mEnablePhyMode;
    private String mMemSize;
    private String mMemType;
    private String mMonitorRules;
    protected final int mMonitorType;
    protected int mMprotectProts;
    protected int mSleepTime;
    private int mWaterLineMB;

    public VmMonitorConfig(int i, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONArray jSONArray4) {
        super(23, 35, 3);
        this.mWaterLineMB = 350;
        this.mDumpSizeMB = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE;
        this.mSleepTime = 3000;
        this.mMprotectProts = 0;
        this.mDebug = false;
        this.mEnablePhyMode = false;
        this.mMemType = "test";
        this.mMemSize = "0";
        this.mBacktraceRule = "0";
        this.mMonitorRules = "0";
        if (RuntimeConfig.isLocalTest()) {
            this.mMonitorType = 3;
            this.mWaterLineMB = 0;
            this.mDumpSizeMB = 200;
            this.mSleepTime = 1000;
            this.mMemType = "new_test";
            this.mBacktraceRule = "3";
            this.mMonitorRules = Constants.CONTENT_RICHNESS_EXPANSION_FREQUENCY;
            this.mMprotectProts = 32;
            this.mEnablePhyMode = true;
            this.mDebug = true;
            return;
        }
        this.mMonitorType = i;
        if (jSONArray != null && jSONArray.length() == 2) {
            this.mWaterLineMB = jSONArray.optInt(0);
            this.mDumpSizeMB = jSONArray.optInt(1);
        }
        parseMmapMonitorParams(jSONArray2);
        parseMprotectMonitorParams(jSONArray3);
        parseMmapPhyConfigs(jSONArray4);
    }

    private void parseMprotectMonitorParams(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.mMprotectProts = 0;
            for (int i = 0; i < jSONArray.length(); i++) {
                this.mMprotectProts |= 1 << jSONArray.optInt(i);
            }
        }
    }

    private void parseMmapMonitorParams(JSONArray jSONArray) {
        int parseInt;
        if (jSONArray == null || jSONArray.length() != 5) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            if (i2 == 0) {
                this.mMemType = optString;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    parseInt = Integer.parseInt(optString) << 0;
                } else if (i2 == 3) {
                    parseInt = Integer.parseInt(optString) << 1;
                } else if (i2 == 4) {
                    this.mMonitorRules = optString;
                }
                i |= parseInt;
            } else {
                this.mMemSize = getMonitorMmapSize(optString);
            }
        }
        this.mBacktraceRule = String.valueOf(i);
    }

    private void parseMmapPhyConfigs(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() != 2) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (i == 0) {
                this.mEnablePhyMode = "1".equals(optString);
            } else if (i == 1 && this.mEnablePhyMode) {
                this.mMemType = optString;
            }
        }
    }

    public long getWaterLineKB() {
        return this.mWaterLineMB * 1024;
    }

    public long getDumpSizeKB() {
        return this.mDumpSizeMB * 1024;
    }

    private static String getMonitorMmapSize(String str) {
        Long valueOf;
        if (str == null) {
            return null;
        }
        try {
            if (str.endsWith("M")) {
                valueOf = Long.valueOf(Long.parseLong(str.substring(0, str.indexOf("M"))) * 1024 * 1024);
            } else if (str.endsWith(NpthBus.UUID_SUFIX_3_1_3)) {
                valueOf = Long.valueOf(Long.parseLong(str.substring(0, str.indexOf(NpthBus.UUID_SUFIX_3_1_3))) * 1024 * 1024 * 1024);
            } else {
                valueOf = str.endsWith("K") ? Long.valueOf(Long.parseLong(str.substring(0, str.indexOf("K"))) * 1024) : null;
            }
            if (valueOf == null) {
                return null;
            }
            return valueOf.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "monitorType=" + this.mMonitorType + "\nwaterLineMB=" + this.mWaterLineMB + "\ndumpSizeMB=" + this.mDumpSizeMB + "\nmprotectProts=" + this.mMprotectProts + "\nmemType=" + this.mMemType + "\nmemSize=" + this.mMemSize + "\nbacktraceRules=" + this.mBacktraceRule + "\nmonitorRules=" + this.mMonitorRules + "\nsleepTime=" + this.mSleepTime + "\ndebug=" + this.mDebug + "\npEnable=" + this.mEnablePhyMode + UpdateDialogNewBase.TYPE;
    }
}
