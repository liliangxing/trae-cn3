package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend;
import com.bytedance.sdk.xbridge.cn.auth.loader.PermissionConfigLoaderChain;
import com.bytedance.sdk.xbridge.cn.utils.BDXInitOpt;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXBridgePermission.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/BDXBridgePermission;", "", "()V", "_triggerInit", "", "currentPermissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "getCurrentPermissionConfigProvider$anniex_release", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "setCurrentPermissionConfigProvider$anniex_release", "(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V", "enablePermission", "getEnablePermission$anniex_release", "()Z", "setEnablePermission$anniex_release", "(Z)V", "publicMethodSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "getPublicMethodSet", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "safeHostSet", "getSafeHostSet", "hasTriggerInit", "init", "", "permissionConfigProvider", "isLazyParse", "updateRemoteConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BDXBridgePermission {
    private static boolean _triggerInit;
    private static IPermissionConfigProvider currentPermissionConfigProvider;
    public static final BDXBridgePermission INSTANCE = new BDXBridgePermission();
    private static final CopyOnWriteArraySet<String> safeHostSet = new CopyOnWriteArraySet<>();
    private static final CopyOnWriteArraySet<String> publicMethodSet = new CopyOnWriteArraySet<>();
    private static boolean enablePermission = true;

    private BDXBridgePermission() {
    }

    public final CopyOnWriteArraySet<String> getSafeHostSet() {
        return safeHostSet;
    }

    public final CopyOnWriteArraySet<String> getPublicMethodSet() {
        return publicMethodSet;
    }

    public final boolean getEnablePermission$anniex_release() {
        return enablePermission;
    }

    public final void setEnablePermission$anniex_release(boolean z) {
        enablePermission = z;
    }

    public final IPermissionConfigProvider getCurrentPermissionConfigProvider$anniex_release() {
        return currentPermissionConfigProvider;
    }

    public final void setCurrentPermissionConfigProvider$anniex_release(IPermissionConfigProvider iPermissionConfigProvider) {
        currentPermissionConfigProvider = iPermissionConfigProvider;
    }

    public final boolean hasTriggerInit() {
        return _triggerInit;
    }

    public final void init(IPermissionConfigProvider permissionConfigProvider) {
        Intrinsics.checkNotNullParameter(permissionConfigProvider, "permissionConfigProvider");
        init(permissionConfigProvider, false);
    }

    public static /* synthetic */ void init$default(BDXBridgePermission bDXBridgePermission, IPermissionConfigProvider iPermissionConfigProvider, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        bDXBridgePermission.init(iPermissionConfigProvider, z);
    }

    public final void init(IPermissionConfigProvider permissionConfigProvider, boolean isLazyParse) {
        Intrinsics.checkNotNullParameter(permissionConfigProvider, "permissionConfigProvider");
        if (BDXInitOpt.isBDXOptEnable() && _triggerInit) {
            return;
        }
        _triggerInit = true;
        currentPermissionConfigProvider = permissionConfigProvider;
        PermissionConfigV2Parser.INSTANCE.setLogDepend(new ILogDepend() { // from class: com.bytedance.sdk.xbridge.cn.auth.BDXBridgePermission$init$1
            @Override // com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend
            public void log(String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                XBridge.log(tag + ": " + msg);
            }
        });
        PermissionConfigLoaderChain.INSTANCE.createLoaderChain(false, permissionConfigProvider, isLazyParse).load();
        updateRemoteConfig(permissionConfigProvider);
    }

    public final void updateRemoteConfig(IPermissionConfigProvider permissionConfigProvider) {
        Intrinsics.checkNotNullParameter(permissionConfigProvider, "permissionConfigProvider");
        final PermissionConfigLoaderChain createLoaderChain = PermissionConfigLoaderChain.INSTANCE.createLoaderChain(true, permissionConfigProvider, false);
        permissionConfigProvider.doRequestRemoteConfigAsync(new Runnable() { // from class: com.bytedance.sdk.xbridge.cn.auth.BDXBridgePermission$updateRemoteConfig$1
            @Override // java.lang.Runnable
            public final void run() {
                PermissionConfigLoaderChain.this.load();
                if (BDXInitOpt.isBDXOptEnable()) {
                    BDXInitOpt.setLocalData(null);
                }
            }
        });
    }
}
