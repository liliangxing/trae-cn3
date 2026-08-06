package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.repository.BaseRemoteConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusSettingsConfigModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusGlobalCommonConfig;", "Lcom/bytedance/ies/argus/repository/BaseRemoteConfig;", "reportConfig", "Lcom/bytedance/ies/argus/bean/ReportConfig;", "globalDef", "Lcom/bytedance/ies/argus/bean/GlobalDefinition;", "innerInitSettings", "Lcom/bytedance/ies/argus/bean/ArgusInitSetting;", "forceHttpsSetting", "Lcom/bytedance/ies/argus/bean/ForceHttpsSetting;", "injectSecurityContextJsbList", "", "", "(Lcom/bytedance/ies/argus/bean/ReportConfig;Lcom/bytedance/ies/argus/bean/GlobalDefinition;Lcom/bytedance/ies/argus/bean/ArgusInitSetting;Lcom/bytedance/ies/argus/bean/ForceHttpsSetting;Ljava/util/List;)V", "getForceHttpsSetting", "()Lcom/bytedance/ies/argus/bean/ForceHttpsSetting;", "getGlobalDef", "()Lcom/bytedance/ies/argus/bean/GlobalDefinition;", "getInjectSecurityContextJsbList", "()Ljava/util/List;", "getInnerInitSettings", "()Lcom/bytedance/ies/argus/bean/ArgusInitSetting;", "getReportConfig", "()Lcom/bytedance/ies/argus/bean/ReportConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ArgusGlobalCommonConfig extends BaseRemoteConfig {

    @SerializedName("force_https_config")
    private final ForceHttpsSetting forceHttpsSetting;

    @SerializedName("global_def")
    private final GlobalDefinition globalDef;

    @SerializedName("inject_security_context_jsb_list")
    private final List<String> injectSecurityContextJsbList;

    @SerializedName("inner_init_settings")
    private final ArgusInitSetting innerInitSettings;

    @SerializedName("report")
    private final ReportConfig reportConfig;

    public ArgusGlobalCommonConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ArgusGlobalCommonConfig copy$default(ArgusGlobalCommonConfig argusGlobalCommonConfig, ReportConfig reportConfig, GlobalDefinition globalDefinition, ArgusInitSetting argusInitSetting, ForceHttpsSetting forceHttpsSetting, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            reportConfig = argusGlobalCommonConfig.reportConfig;
        }
        if ((i & 2) != 0) {
            globalDefinition = argusGlobalCommonConfig.globalDef;
        }
        GlobalDefinition globalDefinition2 = globalDefinition;
        if ((i & 4) != 0) {
            argusInitSetting = argusGlobalCommonConfig.innerInitSettings;
        }
        ArgusInitSetting argusInitSetting2 = argusInitSetting;
        if ((i & 8) != 0) {
            forceHttpsSetting = argusGlobalCommonConfig.forceHttpsSetting;
        }
        ForceHttpsSetting forceHttpsSetting2 = forceHttpsSetting;
        if ((i & 16) != 0) {
            list = argusGlobalCommonConfig.injectSecurityContextJsbList;
        }
        return argusGlobalCommonConfig.copy(reportConfig, globalDefinition2, argusInitSetting2, forceHttpsSetting2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final ReportConfig getReportConfig() {
        return this.reportConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final GlobalDefinition getGlobalDef() {
        return this.globalDef;
    }

    /* renamed from: component3, reason: from getter */
    public final ArgusInitSetting getInnerInitSettings() {
        return this.innerInitSettings;
    }

    /* renamed from: component4, reason: from getter */
    public final ForceHttpsSetting getForceHttpsSetting() {
        return this.forceHttpsSetting;
    }

    public final List<String> component5() {
        return this.injectSecurityContextJsbList;
    }

    public final ArgusGlobalCommonConfig copy(ReportConfig reportConfig, GlobalDefinition globalDef, ArgusInitSetting innerInitSettings, ForceHttpsSetting forceHttpsSetting, List<String> injectSecurityContextJsbList) {
        return new ArgusGlobalCommonConfig(reportConfig, globalDef, innerInitSettings, forceHttpsSetting, injectSecurityContextJsbList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgusGlobalCommonConfig)) {
            return false;
        }
        ArgusGlobalCommonConfig argusGlobalCommonConfig = (ArgusGlobalCommonConfig) other;
        return Intrinsics.areEqual(this.reportConfig, argusGlobalCommonConfig.reportConfig) && Intrinsics.areEqual(this.globalDef, argusGlobalCommonConfig.globalDef) && Intrinsics.areEqual(this.innerInitSettings, argusGlobalCommonConfig.innerInitSettings) && Intrinsics.areEqual(this.forceHttpsSetting, argusGlobalCommonConfig.forceHttpsSetting) && Intrinsics.areEqual(this.injectSecurityContextJsbList, argusGlobalCommonConfig.injectSecurityContextJsbList);
    }

    public int hashCode() {
        ReportConfig reportConfig = this.reportConfig;
        int hashCode = (reportConfig == null ? 0 : reportConfig.hashCode()) * 31;
        GlobalDefinition globalDefinition = this.globalDef;
        int hashCode2 = (hashCode + (globalDefinition == null ? 0 : globalDefinition.hashCode())) * 31;
        ArgusInitSetting argusInitSetting = this.innerInitSettings;
        int hashCode3 = (hashCode2 + (argusInitSetting == null ? 0 : argusInitSetting.hashCode())) * 31;
        ForceHttpsSetting forceHttpsSetting = this.forceHttpsSetting;
        int hashCode4 = (hashCode3 + (forceHttpsSetting == null ? 0 : forceHttpsSetting.hashCode())) * 31;
        List<String> list = this.injectSecurityContextJsbList;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ArgusGlobalCommonConfig(reportConfig=" + this.reportConfig + ", globalDef=" + this.globalDef + ", innerInitSettings=" + this.innerInitSettings + ", forceHttpsSetting=" + this.forceHttpsSetting + ", injectSecurityContextJsbList=" + this.injectSecurityContextJsbList + ')';
    }

    public /* synthetic */ ArgusGlobalCommonConfig(ReportConfig reportConfig, GlobalDefinition globalDefinition, ArgusInitSetting argusInitSetting, ForceHttpsSetting forceHttpsSetting, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : reportConfig, (i & 2) != 0 ? null : globalDefinition, (i & 4) != 0 ? null : argusInitSetting, (i & 8) != 0 ? null : forceHttpsSetting, (i & 16) != 0 ? null : list);
    }

    public final ReportConfig getReportConfig() {
        return this.reportConfig;
    }

    public final GlobalDefinition getGlobalDef() {
        return this.globalDef;
    }

    public final ArgusInitSetting getInnerInitSettings() {
        return this.innerInitSettings;
    }

    public final ForceHttpsSetting getForceHttpsSetting() {
        return this.forceHttpsSetting;
    }

    public final List<String> getInjectSecurityContextJsbList() {
        return this.injectSecurityContextJsbList;
    }

    public ArgusGlobalCommonConfig(ReportConfig reportConfig, GlobalDefinition globalDefinition, ArgusInitSetting argusInitSetting, ForceHttpsSetting forceHttpsSetting, List<String> list) {
        super(null, 1, null);
        this.reportConfig = reportConfig;
        this.globalDef = globalDefinition;
        this.innerInitSettings = argusInitSetting;
        this.forceHttpsSetting = forceHttpsSetting;
        this.injectSecurityContextJsbList = list;
    }
}
