package com.bytedance.ies.bullet.service.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: CommonConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/BridgeAuthRecoveryConfig;", "", "()V", "authRequestInterval", "", "getAuthRequestInterval", "()J", "setAuthRequestInterval", "(J)V", "closeAuthUrls", "", "", "getCloseAuthUrls", "()Ljava/util/List;", "setCloseAuthUrls", "(Ljava/util/List;)V", "enableAuthConfigRequest", "", "getEnableAuthConfigRequest", "()Z", "setEnableAuthConfigRequest", "(Z)V", "enableConfigUpdate", "getEnableConfigUpdate", "setEnableConfigUpdate", "isCloseAllAuth", "setCloseAllAuth", "settingsVersion", "", "getSettingsVersion", "()I", "setSettingsVersion", "(I)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BridgeAuthRecoveryConfig {

    @SerializedName("open_config_update")
    private boolean enableConfigUpdate;

    @SerializedName("is_close_auth")
    private boolean isCloseAllAuth;

    @SerializedName("settings_version")
    private int settingsVersion;

    @SerializedName("close_auth_urls")
    private List<String> closeAuthUrls = CollectionsKt.listOf(new String[]{"^https://i.snssdk.com/magic/eco/runtime/release", "^https://i.snssdk.com/magic/eco/runtime/beta", "^https://aweme.snssdk.com/magic/eco/runtime/release", "^https://aweme.snssdk.com/magic/eco/runtime/beta", "^https://hotsoon.snssdk.com/magic/eco/runtime/release", "^https://hotsoon.snssdk.com/magic/eco/runtime/beta", "^https://reading.snssdk.com/magic/eco/runtime/release", "^https://reading.snssdk.com/magic/eco/runtime/beta", "^https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source", "^https://lf-dy-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source", "^https://test-aweme.snssdk.com/falcon/jsb_tester_web/dmt"});

    @SerializedName("open_auto_config_request")
    private boolean enableAuthConfigRequest = true;

    @SerializedName("auto_request_internal")
    private long authRequestInterval = 3600;

    public final int getSettingsVersion() {
        return this.settingsVersion;
    }

    public final void setSettingsVersion(int i) {
        this.settingsVersion = i;
    }

    public final List<String> getCloseAuthUrls() {
        return this.closeAuthUrls;
    }

    public final void setCloseAuthUrls(List<String> list) {
        this.closeAuthUrls = list;
    }

    /* renamed from: isCloseAllAuth, reason: from getter */
    public final boolean getIsCloseAllAuth() {
        return this.isCloseAllAuth;
    }

    public final void setCloseAllAuth(boolean z) {
        this.isCloseAllAuth = z;
    }

    public final boolean getEnableConfigUpdate() {
        return this.enableConfigUpdate;
    }

    public final void setEnableConfigUpdate(boolean z) {
        this.enableConfigUpdate = z;
    }

    public final boolean getEnableAuthConfigRequest() {
        return this.enableAuthConfigRequest;
    }

    public final void setEnableAuthConfigRequest(boolean z) {
        this.enableAuthConfigRequest = z;
    }

    public final long getAuthRequestInterval() {
        return this.authRequestInterval;
    }

    public final void setAuthRequestInterval(long j) {
        this.authRequestInterval = j;
    }
}
