package com.bytedance.env.api;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnvManagerApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J%\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\nHÆ\u0003JM\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\nHÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0007J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/env/api/EnvConfig;", "", "env", "Lcom/bytedance/env/api/EnvType;", "lane", "", "enabledBOE2", "", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Lcom/bytedance/env/api/EnvType;Ljava/lang/String;ZLjava/util/HashMap;)V", "getEnabledBOE2", "()Z", "setEnabledBOE2", "(Z)V", "getEnv", "()Lcom/bytedance/env/api/EnvType;", "setEnv", "(Lcom/bytedance/env/api/EnvType;)V", "getHeaders", "()Ljava/util/HashMap;", "setHeaders", "(Ljava/util/HashMap;)V", "getLane", "()Ljava/lang/String;", "setLane", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "needLane", "toString", "env_platform_api_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class EnvConfig {

    @SerializedName("enabledBOE2")
    private boolean enabledBOE2;

    @SerializedName("env")
    private EnvType env;
    private transient HashMap<String, String> headers;

    @SerializedName("lane")
    private String lane;

    public EnvConfig() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EnvConfig copy$default(EnvConfig envConfig, EnvType envType, String str, boolean z, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            envType = envConfig.env;
        }
        if ((i & 2) != 0) {
            str = envConfig.lane;
        }
        if ((i & 4) != 0) {
            z = envConfig.enabledBOE2;
        }
        if ((i & 8) != 0) {
            hashMap = envConfig.headers;
        }
        return envConfig.copy(envType, str, z, hashMap);
    }

    /* renamed from: component1, reason: from getter */
    public final EnvType getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLane() {
        return this.lane;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnabledBOE2() {
        return this.enabledBOE2;
    }

    public final HashMap<String, String> component4() {
        return this.headers;
    }

    public final EnvConfig copy(EnvType env, String lane, boolean enabledBOE2, HashMap<String, String> headers) {
        Intrinsics.checkParameterIsNotNull(env, "env");
        Intrinsics.checkParameterIsNotNull(lane, "lane");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        return new EnvConfig(env, lane, enabledBOE2, headers);
    }

    public String toString() {
        return "EnvConfig(env=" + this.env + ", lane=" + this.lane + ", enabledBOE2=" + this.enabledBOE2 + ", headers=" + this.headers + ")";
    }

    public EnvConfig(EnvType env, String lane, boolean z, HashMap<String, String> headers) {
        Intrinsics.checkParameterIsNotNull(env, "env");
        Intrinsics.checkParameterIsNotNull(lane, "lane");
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        this.env = env;
        this.lane = lane;
        this.enabledBOE2 = z;
        this.headers = headers;
    }

    public /* synthetic */ EnvConfig(EnvType envType, String str, boolean z, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EnvType.PRODUCT : envType, (i & 2) != 0 ? EnvManagerApiKt.DEFAULT_LANE : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? new HashMap() : hashMap);
    }

    public final EnvType getEnv() {
        return this.env;
    }

    public final void setEnv(EnvType envType) {
        Intrinsics.checkParameterIsNotNull(envType, "<set-?>");
        this.env = envType;
    }

    public final String getLane() {
        return this.lane;
    }

    public final void setLane(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.lane = str;
    }

    public final boolean getEnabledBOE2() {
        return this.enabledBOE2;
    }

    public final void setEnabledBOE2(boolean z) {
        this.enabledBOE2 = z;
    }

    public final HashMap<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(HashMap<String, String> hashMap) {
        Intrinsics.checkParameterIsNotNull(hashMap, "<set-?>");
        this.headers = hashMap;
    }

    public boolean equals(Object other) {
        EnvConfig envConfig = (EnvConfig) (!(other instanceof EnvConfig) ? null : other);
        if (envConfig != null) {
            if (needLane()) {
                if (this.env == envConfig.env && Intrinsics.areEqual(this.lane, envConfig.lane) && this.enabledBOE2 == envConfig.enabledBOE2) {
                    return true;
                }
            } else if (this.env == envConfig.env) {
                return true;
            }
            return false;
        }
        return super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final boolean needLane() {
        return (this.env == EnvType.PRODUCT || this.env == EnvType.CANARY) ? false : true;
    }
}
