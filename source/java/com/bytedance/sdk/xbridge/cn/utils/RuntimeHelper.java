package com.bytedance.sdk.xbridge.cn.utils;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCacheDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostFrameworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV3;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNaviDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XDefaultHostNetworkDependImpl;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuntimeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010&\u001a\u0004\u0018\u00010'¨\u0006("}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/RuntimeHelper;", "", "()V", "getCacheDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCacheDepend;", "getExecutorService", "Ljava/util/concurrent/ExecutorService;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "getExternalStorageDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostExternalStorageDepend;", "getFrameworkDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostFrameworkDepend;", "getLocationPermissionDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLocationPermissionDepend;", "getLogDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "getMediaDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDepend;", "getMediaDependInstanceV3", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV3;", "getNaviDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNaviDepend;", "getNetworkDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "getNetworkDependInstanceV2", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDependV2;", "getOpenDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend;", "getPermissionDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "getPureNetworkDependInstance", "getRouterDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostRouterDepend;", "getThreadPoolDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostThreadPoolExecutorDepend;", "getUIDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostStyleUIDepend;", "getUserDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RuntimeHelper {
    public static final RuntimeHelper INSTANCE = new RuntimeHelper();

    private RuntimeHelper() {
    }

    public final IHostStyleUIDepend getUIDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostStyleUIDepend();
    }

    public final IHostNaviDepend getNaviDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostNaviDepend();
    }

    public final IHostUserDepend getUserDependInstance() {
        return XBaseRuntime.INSTANCE.getHostUserDepend();
    }

    public final IHostLogDepend getLogDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        IHostLogDependV2 hostLogDependV2 = XBaseRuntime.INSTANCE.getHostLogDependV2();
        return hostLogDependV2 != null ? hostLogDependV2 : XBaseRuntime.INSTANCE.getHostLogDepend();
    }

    public final IHostFrameworkDepend getFrameworkDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostFrameworkDepend();
    }

    public final IHostRouterDepend getRouterDependInstance() {
        return XBaseRuntime.INSTANCE.getHostRouterDepend();
    }

    public final IHostMediaDepend getMediaDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostMediaDepend();
    }

    public final IHostMediaDependV3 getMediaDependInstanceV3(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostMediaDependV3();
    }

    public final IHostPermissionDepend getPermissionDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostPermissionDepend();
    }

    public final IHostOpenDepend getOpenDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostOpenDepend();
    }

    public final IHostNetworkDepend getNetworkDependInstance(IBDXBridgeContext bridgeContext) {
        IHostNetworkDepend hostNetworkDepend = XBaseRuntime.INSTANCE.getHostNetworkDepend();
        return hostNetworkDepend == null ? new XDefaultHostNetworkDependImpl() : hostNetworkDepend;
    }

    public final IHostNetworkDependV2 getNetworkDependInstanceV2(IBDXBridgeContext bridgeContext) {
        return XBaseRuntime.INSTANCE.getHostNetworkDependV2();
    }

    public final IHostNetworkDepend getPureNetworkDependInstance(IBDXBridgeContext bridgeContext) {
        IHostNetworkDepend hostPureNetworkDepend = XBaseRuntime.INSTANCE.getHostPureNetworkDepend();
        return hostPureNetworkDepend == null ? new XDefaultHostNetworkDependImpl() : hostPureNetworkDepend;
    }

    public final ExecutorService getExecutorService(IBDXBridgeContext bridgeContext) {
        ExecutorService normalThreadExecutor;
        IHostThreadPoolExecutorDepend hostThreadPoolExecutorDepend = XBaseRuntime.INSTANCE.getHostThreadPoolExecutorDepend();
        if (hostThreadPoolExecutorDepend != null && (normalThreadExecutor = hostThreadPoolExecutorDepend.getNormalThreadExecutor()) != null) {
            return normalThreadExecutor;
        }
        ExecutorService normalExecutor = TTExecutors.getNormalExecutor();
        Intrinsics.checkNotNullExpressionValue(normalExecutor, "getNormalExecutor()");
        return normalExecutor;
    }

    public final IHostExternalStorageDepend getExternalStorageDependInstance() {
        return XBaseRuntime.INSTANCE.getHostExternalStorageDepend();
    }

    public final IHostCacheDepend getCacheDependInstance() {
        return XBaseRuntime.INSTANCE.getHostCacheDepend();
    }

    public final IHostThreadPoolExecutorDepend getThreadPoolDepend(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostThreadPoolExecutorDepend();
    }

    public final IHostLocationPermissionDepend getLocationPermissionDependInstance(IBDXBridgeContext bridgeContext) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        return XBaseRuntime.INSTANCE.getHostLocationPermissionDepend();
    }
}
