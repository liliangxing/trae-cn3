package com.bytedance.sdk.xbridge.cn.auth.respository;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import kotlin.Metadata;

/* compiled from: PermissionConfigParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/respository/PermissionConfigParser;", "", "()V", "HOST_NAMESPACE", "", "WEBCAST_HOST_NAMESPACE", "WEBCAST_NAMESPACE", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "getPermissionConfigProvider", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "setPermissionConfigProvider", "(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V", RLMonitorReporter.PARSE, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionConfigParser {
    public static final String HOST_NAMESPACE = "";
    public static final PermissionConfigParser INSTANCE = new PermissionConfigParser();
    public static final String WEBCAST_HOST_NAMESPACE = "host";
    public static final String WEBCAST_NAMESPACE = "webcast";
    private static IPermissionConfigProvider permissionConfigProvider;

    private PermissionConfigParser() {
    }

    public final IPermissionConfigProvider getPermissionConfigProvider() {
        return permissionConfigProvider;
    }

    public final void setPermissionConfigProvider(IPermissionConfigProvider iPermissionConfigProvider) {
        permissionConfigProvider = iPermissionConfigProvider;
    }

    public final void parse() {
        PermissionConfigRepository.INSTANCE.setPermissionConfigProvider(permissionConfigProvider);
    }
}
