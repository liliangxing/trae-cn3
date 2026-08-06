package com.bytedance.sdk.xbridge.cn.auth;

import java.util.List;
import kotlin.Metadata;

/* compiled from: XBridgeAuthRecoveryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/XBridgeRecoveryConfigProvider;", "", "authRequestInterval", "", "enableAuthConfigRequest", "", "enableConfigUpdate", "getCloseAuthUrls", "", "", "getSettingsVersion", "", "isCloseAllAuth", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface XBridgeRecoveryConfigProvider {
    long authRequestInterval();

    boolean enableAuthConfigRequest();

    boolean enableConfigUpdate();

    List<String> getCloseAuthUrls();

    int getSettingsVersion();

    boolean isCloseAllAuth();
}
