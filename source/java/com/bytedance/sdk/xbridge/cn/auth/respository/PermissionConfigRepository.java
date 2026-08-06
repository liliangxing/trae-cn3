package com.bytedance.sdk.xbridge.cn.auth.respository;

import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.IPermissionConfigProvider;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigV1Bean;
import com.bytedance.sdk.xbridge.cn.auth.entity.PermissionConfigNamespace;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionConfigRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/respository/PermissionConfigRepository;", "", "()V", "configMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/auth/entity/PermissionConfigNamespace;", "permissionConfigProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "getPermissionConfigProvider", "()Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "setPermissionConfigProvider", "(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V", "getConfigByNamespace", LynxBridgeCall.NAME_SPACE, "getUpdatedConfig", "isPermissionConfigEmpty", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionConfigRepository {
    public static final PermissionConfigRepository INSTANCE = new PermissionConfigRepository();
    private static final ConcurrentHashMap<String, PermissionConfigNamespace> configMap = new ConcurrentHashMap<>();
    private static IPermissionConfigProvider permissionConfigProvider;

    private PermissionConfigRepository() {
    }

    public final IPermissionConfigProvider getPermissionConfigProvider() {
        return permissionConfigProvider;
    }

    public final void setPermissionConfigProvider(IPermissionConfigProvider iPermissionConfigProvider) {
        permissionConfigProvider = iPermissionConfigProvider;
    }

    public final boolean isPermissionConfigEmpty() {
        return configMap.isEmpty();
    }

    public final PermissionConfigNamespace getConfigByNamespace(String namespace) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        PermissionConfigNamespace updatedConfig = getUpdatedConfig(namespace);
        return updatedConfig == null ? getUpdatedConfig("") : updatedConfig;
    }

    private final PermissionConfigNamespace getUpdatedConfig(String namespace) {
        ConcurrentHashMap<String, PermissionConfigNamespace> concurrentHashMap = configMap;
        PermissionConfigNamespace permissionConfigNamespace = concurrentHashMap.get(namespace);
        Map<String, List<AuthConfigV1Bean>> contentAuthConfig = PermissionConfigV2Parser.INSTANCE.getContentAuthConfig(namespace);
        if (contentAuthConfig != null) {
            if (permissionConfigNamespace == null) {
                IPermissionConfigProvider iPermissionConfigProvider = permissionConfigProvider;
                permissionConfigNamespace = new PermissionConfigNamespace(namespace, iPermissionConfigProvider != null ? iPermissionConfigProvider.provideCacheConfigPermissionCapacity() : 32, contentAuthConfig);
                concurrentHashMap.put(namespace, permissionConfigNamespace);
                XBridge.log("create config for namespace: " + namespace);
            } else {
                permissionConfigNamespace.update(contentAuthConfig);
                XBridge.log("update config for namespace: " + namespace);
            }
        }
        return permissionConfigNamespace;
    }
}
