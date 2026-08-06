package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* compiled from: SecuritySettingConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R(\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/MethodAuthTypeSetting;", "", "()V", "commonSecureMethods", "", "", "", "getCommonSecureMethods", "()Ljava/util/Map;", "setCommonSecureMethods", "(Ljava/util/Map;)V", "enableLynxForcePrivate", "", "getEnableLynxForcePrivate", "()Z", "setEnableLynxForcePrivate", "(Z)V", "enableWebForcePrivate", "getEnableWebForcePrivate", "setEnableWebForcePrivate", "lynxPublicMethods", "", "getLynxPublicMethods", "()[Ljava/lang/String;", "setLynxPublicMethods", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "webPublicMethods", "getWebPublicMethods", "setWebPublicMethods", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class MethodAuthTypeSetting {

    @SerializedName("enable_web_force_private")
    private boolean enableWebForcePrivate;

    @SerializedName("web_public_method")
    private String[] webPublicMethods = new String[0];

    @SerializedName("enable_lynx_force_private")
    private boolean enableLynxForcePrivate = true;

    @SerializedName("lynx_public_method")
    private String[] lynxPublicMethods = new String[0];

    @SerializedName("common_secure_method")
    private Map<String, Integer> commonSecureMethods = MapsKt.emptyMap();

    public final boolean getEnableWebForcePrivate() {
        return this.enableWebForcePrivate;
    }

    public final void setEnableWebForcePrivate(boolean z) {
        this.enableWebForcePrivate = z;
    }

    public final String[] getWebPublicMethods() {
        return this.webPublicMethods;
    }

    public final void setWebPublicMethods(String[] strArr) {
        this.webPublicMethods = strArr;
    }

    public final boolean getEnableLynxForcePrivate() {
        return this.enableLynxForcePrivate;
    }

    public final void setEnableLynxForcePrivate(boolean z) {
        this.enableLynxForcePrivate = z;
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
}
