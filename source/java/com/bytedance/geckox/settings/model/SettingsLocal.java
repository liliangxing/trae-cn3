package com.bytedance.geckox.settings.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsLocal.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/geckox/settings/model/SettingsLocal;", "", "env", "", "appVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getEnv", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class SettingsLocal {

    @SerializedName("app_version")
    private final String appVersion;

    @SerializedName("env")
    private final String env;

    public SettingsLocal(String env, String appVersion) {
        Intrinsics.checkParameterIsNotNull(env, "env");
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        this.env = env;
        this.appVersion = appVersion;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }
}
