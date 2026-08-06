package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R2\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\"\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\n¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/JSBAuthStrategySetting;", "", "()V", "customMethodAuthTypeSetting", "", "", "Lcom/bytedance/ies/bullet/base/settings/MethodAuthTypeSetting;", "getCustomMethodAuthTypeSetting", "()Ljava/util/Map;", "setCustomMethodAuthTypeSetting", "(Ljava/util/Map;)V", "enableAutoMatchUrl", "", "getEnableAutoMatchUrl", "()Z", "setEnableAutoMatchUrl", "(Z)V", "enableJSBAuthV3", "getEnableJSBAuthV3", "setEnableJSBAuthV3", "enableSafeWebJSBAuth", "getEnableSafeWebJSBAuth", "setEnableSafeWebJSBAuth", "jsbAuthOnlyUseHostNamespace", "getJsbAuthOnlyUseHostNamespace$annotations", "getJsbAuthOnlyUseHostNamespace", "setJsbAuthOnlyUseHostNamespace", "jsbRequestCheck", "Lcom/bytedance/ies/bullet/base/settings/JSBRequestCheckConfig;", "getJsbRequestCheck", "()Lcom/bytedance/ies/bullet/base/settings/JSBRequestCheckConfig;", "setJsbRequestCheck", "(Lcom/bytedance/ies/bullet/base/settings/JSBRequestCheckConfig;)V", "privateDomains", "", "getPrivateDomains", "setPrivateDomains", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JSBAuthStrategySetting {

    @SerializedName("enable_auto_match_url")
    private boolean enableAutoMatchUrl;

    @SerializedName("enable_jsb_auth_v3")
    private boolean enableJSBAuthV3;

    @SerializedName("enable_safe_web_jsb_auth")
    private boolean enableSafeWebJSBAuth = true;

    @SerializedName("private_domains")
    private Map<String, String[]> privateDomains = MapsKt.emptyMap();

    @SerializedName("custom_method_auth_type_setting")
    private Map<String, MethodAuthTypeSetting> customMethodAuthTypeSetting = MapsKt.emptyMap();

    @SerializedName("jsb_request_check")
    private JSBRequestCheckConfig jsbRequestCheck = new JSBRequestCheckConfig();

    @SerializedName("jsb_auth_only_use_host_namespace")
    private boolean jsbAuthOnlyUseHostNamespace = true;

    @Deprecated(message = "临时开关，验证完后删除")
    public static /* synthetic */ void getJsbAuthOnlyUseHostNamespace$annotations() {
    }

    public final boolean getEnableSafeWebJSBAuth() {
        return this.enableSafeWebJSBAuth;
    }

    public final void setEnableSafeWebJSBAuth(boolean z) {
        this.enableSafeWebJSBAuth = z;
    }

    public final Map<String, String[]> getPrivateDomains() {
        return this.privateDomains;
    }

    public final void setPrivateDomains(Map<String, String[]> map) {
        this.privateDomains = map;
    }

    public final boolean getEnableJSBAuthV3() {
        return this.enableJSBAuthV3;
    }

    public final void setEnableJSBAuthV3(boolean z) {
        this.enableJSBAuthV3 = z;
    }

    public final boolean getEnableAutoMatchUrl() {
        return this.enableAutoMatchUrl;
    }

    public final void setEnableAutoMatchUrl(boolean z) {
        this.enableAutoMatchUrl = z;
    }

    public final Map<String, MethodAuthTypeSetting> getCustomMethodAuthTypeSetting() {
        return this.customMethodAuthTypeSetting;
    }

    public final void setCustomMethodAuthTypeSetting(Map<String, MethodAuthTypeSetting> map) {
        this.customMethodAuthTypeSetting = map;
    }

    public final JSBRequestCheckConfig getJsbRequestCheck() {
        return this.jsbRequestCheck;
    }

    public final void setJsbRequestCheck(JSBRequestCheckConfig jSBRequestCheckConfig) {
        this.jsbRequestCheck = jSBRequestCheckConfig;
    }

    public final boolean getJsbAuthOnlyUseHostNamespace() {
        return this.jsbAuthOnlyUseHostNamespace;
    }

    public final void setJsbAuthOnlyUseHostNamespace(boolean z) {
        this.jsbAuthOnlyUseHostNamespace = z;
    }
}
