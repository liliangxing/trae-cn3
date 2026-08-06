package com.bytedance.iesgurd.model;

import android.os.Build;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.trae.network.DebugSettings;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0010\u0010\u000e\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0002X\u0083D¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00068\u0002X\u0083D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/iesgurd/model/Common;", "", "()V", "appId", "", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "deviceId", "getDeviceId", "setDeviceId", "deviceModel", "osVersion", "platform", "sdkEnv", "sdkVersion", "getEncryptStr", "init", "", "config", "Lcom/bytedance/geckox/GeckoGlobalConfig;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class Common {

    @SerializedName("app_id")
    private long appId;

    @SerializedName("device_model")
    private final String deviceModel;

    @SerializedName("os_version")
    private final String osVersion;

    @SerializedName("sdk_version")
    private final String sdkVersion;

    @SerializedName("app_version")
    private String appVersion = "";

    @SerializedName("device_id")
    private String deviceId = "";

    @SerializedName("sdk_env")
    private String sdkEnv = "";

    @SerializedName("platform")
    private final String platform = "ANDROID";

    public Common() {
        String str = Build.MODEL;
        this.deviceModel = str == null ? "" : str;
        this.osVersion = String.valueOf(Build.VERSION.SDK_INT) + "";
        this.sdkVersion = "5.2.4";
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appVersion = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.deviceId = str;
    }

    public final void init(GeckoGlobalConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        this.appId = config.getAppId();
        String deviceId = config.getDeviceId();
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "config.deviceId");
        this.deviceId = deviceId;
        String appVersion = config.getAppVersion();
        Intrinsics.checkExpressionValueIsNotNull(appVersion, "config.appVersion");
        this.appVersion = appVersion;
        this.sdkEnv = config.getEnv() == GeckoGlobalConfig.ENVType.PROD ? DebugSettings.ENTERPRISE_ENV_ONLINE : "INHOUSE";
    }

    public final String getEncryptStr() {
        return this.appId + this.appVersion + this.platform + this.deviceModel + this.sdkVersion + this.osVersion;
    }
}
