package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: JSBCallStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R(\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/JSBAuthConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "enableWebForcePrivate", "", "webPublicMethods", "", "", "enableLynxForcePrivate", "lynxPublicMethods", "commonSecureMethods", "", "", "enableLynxJsbAuth", "enableLynxJsbCallLimit", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/Boolean;[Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCommonSecureMethods", "()Ljava/util/Map;", "setCommonSecureMethods", "(Ljava/util/Map;)V", "getEnableLynxForcePrivate", "()Ljava/lang/Boolean;", "setEnableLynxForcePrivate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnableLynxJsbAuth", "getEnableLynxJsbCallLimit", "getEnableWebForcePrivate", "setEnableWebForcePrivate", "getLynxPublicMethods", "()[Ljava/lang/String;", "setLynxPublicMethods", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getWebPublicMethods", "setWebPublicMethods", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class JSBAuthConfig extends BaseStrategyConfig {

    @SerializedName("common_secure_method")
    private Map<String, Integer> commonSecureMethods;

    @SerializedName("enable_lynx_force_private")
    private Boolean enableLynxForcePrivate;

    @SerializedName("enable_lynx_jsb_auth")
    private final Boolean enableLynxJsbAuth;

    @SerializedName("enable_lynx_jsb_call_limit")
    private final Boolean enableLynxJsbCallLimit;

    @SerializedName("enable_web_force_private")
    private Boolean enableWebForcePrivate;

    @SerializedName("lynx_public_method")
    private String[] lynxPublicMethods;

    @SerializedName("web_public_method")
    private String[] webPublicMethods;

    public JSBAuthConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ JSBAuthConfig(Boolean bool, String[] strArr, Boolean bool2, String[] strArr2, Map map, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? new String[0] : strArr, (i & 4) != 0 ? true : bool2, (i & 8) != 0 ? new String[0] : strArr2, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? null : bool3, (i & 64) != 0 ? null : bool4);
    }

    public final Boolean getEnableWebForcePrivate() {
        return this.enableWebForcePrivate;
    }

    public final void setEnableWebForcePrivate(Boolean bool) {
        this.enableWebForcePrivate = bool;
    }

    public final String[] getWebPublicMethods() {
        return this.webPublicMethods;
    }

    public final void setWebPublicMethods(String[] strArr) {
        this.webPublicMethods = strArr;
    }

    public final Boolean getEnableLynxForcePrivate() {
        return this.enableLynxForcePrivate;
    }

    public final void setEnableLynxForcePrivate(Boolean bool) {
        this.enableLynxForcePrivate = bool;
    }

    public final String[] getLynxPublicMethods() {
        return this.lynxPublicMethods;
    }

    public final void setLynxPublicMethods(String[] strArr) {
        this.lynxPublicMethods = strArr;
    }

    public final Map<String, Integer> getCommonSecureMethods() {
        return this.commonSecureMethods;
    }

    public final void setCommonSecureMethods(Map<String, Integer> map) {
        this.commonSecureMethods = map;
    }

    public final Boolean getEnableLynxJsbAuth() {
        return this.enableLynxJsbAuth;
    }

    public final Boolean getEnableLynxJsbCallLimit() {
        return this.enableLynxJsbCallLimit;
    }

    public JSBAuthConfig(Boolean bool, String[] strArr, Boolean bool2, String[] strArr2, Map<String, Integer> map, Boolean bool3, Boolean bool4) {
        this.enableWebForcePrivate = bool;
        this.webPublicMethods = strArr;
        this.enableLynxForcePrivate = bool2;
        this.lynxPublicMethods = strArr2;
        this.commonSecureMethods = map;
        this.enableLynxJsbAuth = bool3;
        this.enableLynxJsbCallLimit = bool4;
    }
}
