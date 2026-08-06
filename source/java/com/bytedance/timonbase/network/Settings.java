package com.bytedance.timonbase.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.timonbase.TimonConstantKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Response.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timonbase/network/Settings;", "", "config", "Lcom/bytedance/timonbase/network/Settings$Config;", "validMark", "", "(Lcom/bytedance/timonbase/network/Settings$Config;Ljava/lang/String;)V", "getConfig", "()Lcom/bytedance/timonbase/network/Settings$Config;", "getValidMark", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Config", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class Settings {

    @SerializedName("custom_settings")
    private final Config config;

    @SerializedName("valid_mark")
    private final String validMark;

    /* JADX WARN: Multi-variable type inference failed */
    public Settings() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Settings copy$default(Settings settings, Config config, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            config = settings.config;
        }
        if ((i & 2) != 0) {
            str = settings.validMark;
        }
        return settings.copy(config, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Config getConfig() {
        return this.config;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValidMark() {
        return this.validMark;
    }

    public final Settings copy(Config config, String validMark) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        return new Settings(config, validMark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Settings)) {
            return false;
        }
        Settings settings = (Settings) other;
        return Intrinsics.areEqual(this.config, settings.config) && Intrinsics.areEqual(this.validMark, settings.validMark);
    }

    public int hashCode() {
        Config config = this.config;
        int hashCode = (config != null ? config.hashCode() : 0) * 31;
        String str = this.validMark;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "Settings(config=" + this.config + ", validMark=" + this.validMark + ")";
    }

    public Settings(Config config, String str) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        this.config = config;
        this.validMark = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Settings(Config config, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, str);
        config = (i & 1) != 0 ? new Config(null, null, null, null, 15, null) : config;
        if ((i & 2) != 0) {
            str = null;
        }
    }

    public final Config getConfig() {
        return this.config;
    }

    public final String getValidMark() {
        return this.validMark;
    }

    /* compiled from: Response.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/timonbase/network/Settings$Config;", "", "timonConfig", "", "rulerEngineConfig", "sensitivePathConfig", "timonEncryptionList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRulerEngineConfig", "()Ljava/lang/String;", "getSensitivePathConfig", "getTimonConfig", "getTimonEncryptionList", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final /* data */ class Config {

        @SerializedName(TimonConstantKt.RULER_RULE_KEY)
        private final String rulerEngineConfig;

        @SerializedName(TimonConstantKt.SENSITIVE_PATH_CONFIG_KEY)
        private final String sensitivePathConfig;

        @SerializedName("sdk_kit_config")
        private final String timonConfig;

        @SerializedName(TimonConstantKt.TIMON_ENCRYPTION_LIST)
        private final String timonEncryptionList;

        public Config() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = config.timonConfig;
            }
            if ((i & 2) != 0) {
                str2 = config.rulerEngineConfig;
            }
            if ((i & 4) != 0) {
                str3 = config.sensitivePathConfig;
            }
            if ((i & 8) != 0) {
                str4 = config.timonEncryptionList;
            }
            return config.copy(str, str2, str3, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTimonConfig() {
            return this.timonConfig;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRulerEngineConfig() {
            return this.rulerEngineConfig;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSensitivePathConfig() {
            return this.sensitivePathConfig;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTimonEncryptionList() {
            return this.timonEncryptionList;
        }

        public final Config copy(String timonConfig, String rulerEngineConfig, String sensitivePathConfig, String timonEncryptionList) {
            Intrinsics.checkParameterIsNotNull(timonConfig, "timonConfig");
            Intrinsics.checkParameterIsNotNull(rulerEngineConfig, "rulerEngineConfig");
            Intrinsics.checkParameterIsNotNull(sensitivePathConfig, "sensitivePathConfig");
            Intrinsics.checkParameterIsNotNull(timonEncryptionList, "timonEncryptionList");
            return new Config(timonConfig, rulerEngineConfig, sensitivePathConfig, timonEncryptionList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return Intrinsics.areEqual(this.timonConfig, config.timonConfig) && Intrinsics.areEqual(this.rulerEngineConfig, config.rulerEngineConfig) && Intrinsics.areEqual(this.sensitivePathConfig, config.sensitivePathConfig) && Intrinsics.areEqual(this.timonEncryptionList, config.timonEncryptionList);
        }

        public int hashCode() {
            String str = this.timonConfig;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.rulerEngineConfig;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.sensitivePathConfig;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.timonEncryptionList;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Config(timonConfig=" + this.timonConfig + ", rulerEngineConfig=" + this.rulerEngineConfig + ", sensitivePathConfig=" + this.sensitivePathConfig + ", timonEncryptionList=" + this.timonEncryptionList + ")";
        }

        public Config(String timonConfig, String rulerEngineConfig, String sensitivePathConfig, String timonEncryptionList) {
            Intrinsics.checkParameterIsNotNull(timonConfig, "timonConfig");
            Intrinsics.checkParameterIsNotNull(rulerEngineConfig, "rulerEngineConfig");
            Intrinsics.checkParameterIsNotNull(sensitivePathConfig, "sensitivePathConfig");
            Intrinsics.checkParameterIsNotNull(timonEncryptionList, "timonEncryptionList");
            this.timonConfig = timonConfig;
            this.rulerEngineConfig = rulerEngineConfig;
            this.sensitivePathConfig = sensitivePathConfig;
            this.timonEncryptionList = timonEncryptionList;
        }

        public final String getTimonConfig() {
            return this.timonConfig;
        }

        public final String getRulerEngineConfig() {
            return this.rulerEngineConfig;
        }

        public final String getSensitivePathConfig() {
            return this.sensitivePathConfig;
        }

        public /* synthetic */ Config(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
        }

        public final String getTimonEncryptionList() {
            return this.timonEncryptionList;
        }
    }
}
