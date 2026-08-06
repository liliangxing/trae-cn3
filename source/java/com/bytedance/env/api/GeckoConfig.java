package com.bytedance.env.api;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/env/api/GeckoConfig;", "", "accessKeyType", "Lcom/bytedance/env/api/AccessKeyType;", "envLane", "", "(Lcom/bytedance/env/api/AccessKeyType;Ljava/lang/String;)V", "getAccessKeyType", "()Lcom/bytedance/env/api/AccessKeyType;", "setAccessKeyType", "(Lcom/bytedance/env/api/AccessKeyType;)V", "getEnvLane", "()Ljava/lang/String;", "setEnvLane", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GeckoConfig {

    @SerializedName("accessKeyType")
    private AccessKeyType accessKeyType;

    @SerializedName("envLane")
    private String envLane;

    /* JADX WARN: Multi-variable type inference failed */
    public GeckoConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GeckoConfig copy$default(GeckoConfig geckoConfig, AccessKeyType accessKeyType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            accessKeyType = geckoConfig.accessKeyType;
        }
        if ((i & 2) != 0) {
            str = geckoConfig.envLane;
        }
        return geckoConfig.copy(accessKeyType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final AccessKeyType getAccessKeyType() {
        return this.accessKeyType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEnvLane() {
        return this.envLane;
    }

    public final GeckoConfig copy(AccessKeyType accessKeyType, String envLane) {
        Intrinsics.checkParameterIsNotNull(accessKeyType, "accessKeyType");
        Intrinsics.checkParameterIsNotNull(envLane, "envLane");
        return new GeckoConfig(accessKeyType, envLane);
    }

    public String toString() {
        return "GeckoConfig(accessKeyType=" + this.accessKeyType + ", envLane=" + this.envLane + ")";
    }

    public GeckoConfig(AccessKeyType accessKeyType, String envLane) {
        Intrinsics.checkParameterIsNotNull(accessKeyType, "accessKeyType");
        Intrinsics.checkParameterIsNotNull(envLane, "envLane");
        this.accessKeyType = accessKeyType;
        this.envLane = envLane;
    }

    public /* synthetic */ GeckoConfig(AccessKeyType accessKeyType, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AccessKeyType.INHOUSE : accessKeyType, (i & 2) != 0 ? "" : str);
    }

    public final AccessKeyType getAccessKeyType() {
        return this.accessKeyType;
    }

    public final void setAccessKeyType(AccessKeyType accessKeyType) {
        Intrinsics.checkParameterIsNotNull(accessKeyType, "<set-?>");
        this.accessKeyType = accessKeyType;
    }

    public final String getEnvLane() {
        return this.envLane;
    }

    public final void setEnvLane(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.envLane = str;
    }

    public boolean equals(Object other) {
        GeckoConfig geckoConfig = (GeckoConfig) (!(other instanceof GeckoConfig) ? null : other);
        if (geckoConfig != null) {
            return this.accessKeyType == geckoConfig.accessKeyType && Intrinsics.areEqual(this.envLane, geckoConfig.envLane);
        }
        return super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
