package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.runtime.p011default.DefaultHostGeckoDepend;
import com.bytedance.sdk.xbridge.cn.runtime.p011default.DefaultHostThreadPoolExecutorDepend;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBaseRuntime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00109\u001a\u00020\u0011J\b\u0010:\u001a\u0004\u0018\u00010\u0013J\b\u0010;\u001a\u0004\u0018\u00010\u0004J\b\u0010<\u001a\u0004\u0018\u00010\u0006J\b\u0010=\u001a\u0004\u0018\u00010\bJ\b\u0010>\u001a\u0004\u0018\u00010\nJ\b\u0010?\u001a\u0004\u0018\u00010\fJ\b\u0010@\u001a\u0004\u0018\u00010\u000eJ\b\u0010A\u001a\u0004\u0018\u00010\u0015J\b\u0010B\u001a\u0004\u0018\u00010\u0017J\b\u0010C\u001a\u0004\u0018\u00010\u0019J\b\u0010D\u001a\u0004\u0018\u00010\u001bJ\b\u0010E\u001a\u0004\u0018\u00010\u001dJ\b\u0010F\u001a\u0004\u0018\u00010\u001fJ\b\u0010G\u001a\u0004\u0018\u00010!J\b\u0010H\u001a\u0004\u0018\u00010$J\b\u0010I\u001a\u0004\u0018\u00010&J\b\u0010J\u001a\u0004\u0018\u00010(J\b\u0010K\u001a\u0004\u0018\u00010*J\b\u0010L\u001a\u0004\u0018\u00010$J\b\u0010M\u001a\u0004\u0018\u00010.J\b\u0010N\u001a\u0004\u0018\u000100J\b\u0010O\u001a\u0004\u0018\u000102J\u0006\u0010P\u001a\u000204J\b\u0010Q\u001a\u0004\u0018\u000106J\b\u0010R\u001a\u0004\u0018\u000108J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010Y\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\\\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010_\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010`\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010a\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!H\u0007J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$J\u000e\u0010c\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000e\u0010d\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J\u000e\u0010h\u001a\u00020\u00002\u0006\u0010/\u001a\u000200J\u000e\u0010i\u001a\u00020\u00002\u0006\u00101\u001a\u000202J\u000e\u0010j\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u000206J\u000e\u0010m\u001a\u00020\u00002\u0006\u00107\u001a\u000208R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0002R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XBaseRuntime;", "", "()V", "hostALogDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostALogDepend;", "hostCacheDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCacheDepend;", "hostCalendarDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostCalendarDepend;", "hostContextDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;", "hostExternalStorageDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostExternalStorageDepend;", "hostFrameworkDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostFrameworkDepend;", "getHostFrameworkDepend$annotations", "hostGeckoDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostGeckoDepend;", "hostHeadSetDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostHeadSetDepend;", "hostLocationPermissionDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLocationPermissionDepend;", "hostLogDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDepend;", "hostLogDependV2", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLogDependV2;", "hostMediaDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDepend;", "hostMediaDependV2", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV2;", "hostMediaDependV3", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV3;", "hostNaviDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNaviDepend;", "getHostNaviDepend$annotations", "hostNetworkDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "hostNetworkDependV2", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDependV2;", "hostOpenDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend;", "hostPermissionDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "hostPureNetworkDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPureNetworkDepend;", "hostRouterDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostRouterDepend;", "hostStyleUIDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostStyleUIDepend;", "hostSystemActionDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostSystemActionDepend;", "hostThreadPoolExecutorDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostThreadPoolExecutorDepend;", "hostUserDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend;", "memoryWaringDepend", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMemoryWaringDepend;", "getGeckoDepend", "getHeadSetDepend", "getHostALogDepend", "getHostCacheDepend", "getHostCalendarDepend", "getHostContextDepend", "getHostExternalStorageDepend", "getHostFrameworkDepend", "getHostLocationPermissionDepend", "getHostLogDepend", "getHostLogDependV2", "getHostMediaDepend", "getHostMediaDependV2", "getHostMediaDependV3", "getHostNaviDepend", "getHostNetworkDepend", "getHostNetworkDependV2", "getHostOpenDepend", "getHostPermissionDepend", "getHostPureNetworkDepend", "getHostRouterDepend", "getHostStyleUIDepend", "getHostSystemActionDepend", "getHostThreadPoolExecutorDepend", "getHostUserDepend", "getMemoryWaringDepend", "setHeadsetDepend", "setHostALogDepend", "setHostCacheDepend", "setHostCalendarDepend", "setHostContextDepend", "setHostExternalStorageDepend", "setHostFrameworkDepend", "setHostGeckoDepend", "setHostLocationPermissionDepend", "setHostLogDepend", "setHostLogDependV2", "setHostMediaDepend", "setHostMediaDependV2", "setHostMediaDependV3", "setHostNaviDepend", "setHostNetworkDepend", "setHostNetworkDependV2", "setHostOpenDepend", "setHostPermissionDepend", "setHostPureNetworkDepend", "setHostRouterDepend", "setHostStyleUIDepend", "setHostSystemActionDepend", "setHostThreadPoolExecutorDepend", "setHostUserDepend", "userDepend", "setMemoryWarningDepend", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBaseRuntime {
    public static final XBaseRuntime INSTANCE = new XBaseRuntime();
    private static IHostALogDepend hostALogDepend;
    private static IHostCacheDepend hostCacheDepend;
    private static IHostCalendarDepend hostCalendarDepend;
    private static IHostContextDepend hostContextDepend;
    private static IHostExternalStorageDepend hostExternalStorageDepend;
    private static IHostFrameworkDepend hostFrameworkDepend;
    private static IHostGeckoDepend hostGeckoDepend;
    private static IHostHeadSetDepend hostHeadSetDepend;
    private static IHostLocationPermissionDepend hostLocationPermissionDepend;
    private static IHostLogDepend hostLogDepend;
    private static IHostLogDependV2 hostLogDependV2;
    private static IHostMediaDepend hostMediaDepend;
    private static IHostMediaDependV2 hostMediaDependV2;
    private static IHostMediaDependV3 hostMediaDependV3;
    private static IHostNaviDepend hostNaviDepend;
    private static IHostNetworkDepend hostNetworkDepend;
    private static IHostNetworkDependV2 hostNetworkDependV2;
    private static IHostOpenDepend hostOpenDepend;
    private static IHostPermissionDepend hostPermissionDepend;
    private static IHostPureNetworkDepend hostPureNetworkDepend;
    private static IHostRouterDepend hostRouterDepend;
    private static IHostStyleUIDepend hostStyleUIDepend;
    private static IHostSystemActionDepend hostSystemActionDepend;
    private static IHostThreadPoolExecutorDepend hostThreadPoolExecutorDepend;
    private static IHostUserDepend hostUserDepend;
    private static IHostMemoryWaringDepend memoryWaringDepend;

    @Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "this depend is no need to inject", imports = {}))
    private static /* synthetic */ void getHostFrameworkDepend$annotations() {
    }

    @Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "this depend is no need to inject", imports = {}))
    private static /* synthetic */ void getHostNaviDepend$annotations() {
    }

    private XBaseRuntime() {
    }

    public final IHostCacheDepend getHostCacheDepend() {
        return hostCacheDepend;
    }

    public final IHostFrameworkDepend getHostFrameworkDepend() {
        return hostFrameworkDepend;
    }

    public final IHostLogDepend getHostLogDepend() {
        return hostLogDepend;
    }

    public final IHostLogDependV2 getHostLogDependV2() {
        return hostLogDependV2;
    }

    public final IHostMediaDepend getHostMediaDepend() {
        return hostMediaDepend;
    }

    public final IHostMediaDependV2 getHostMediaDependV2() {
        return hostMediaDependV2;
    }

    public final IHostMediaDependV3 getHostMediaDependV3() {
        return hostMediaDependV3;
    }

    public final IHostUserDepend getHostUserDepend() {
        return hostUserDepend;
    }

    public final IHostNetworkDepend getHostNetworkDepend() {
        return hostNetworkDepend;
    }

    public final IHostNetworkDependV2 getHostNetworkDependV2() {
        return hostNetworkDependV2;
    }

    public final IHostNetworkDepend getHostPureNetworkDepend() {
        return hostPureNetworkDepend;
    }

    public final IHostPermissionDepend getHostPermissionDepend() {
        return hostPermissionDepend;
    }

    public final IHostLocationPermissionDepend getHostLocationPermissionDepend() {
        return hostLocationPermissionDepend;
    }

    public final IHostRouterDepend getHostRouterDepend() {
        return hostRouterDepend;
    }

    public final IHostCalendarDepend getHostCalendarDepend() {
        return hostCalendarDepend;
    }

    public final IHostContextDepend getHostContextDepend() {
        return hostContextDepend;
    }

    public final IHostStyleUIDepend getHostStyleUIDepend() {
        return hostStyleUIDepend;
    }

    public final IHostThreadPoolExecutorDepend getHostThreadPoolExecutorDepend() {
        IHostThreadPoolExecutorDepend iHostThreadPoolExecutorDepend = hostThreadPoolExecutorDepend;
        return iHostThreadPoolExecutorDepend == null ? new DefaultHostThreadPoolExecutorDepend() : iHostThreadPoolExecutorDepend;
    }

    public final IHostOpenDepend getHostOpenDepend() {
        return hostOpenDepend;
    }

    public final IHostHeadSetDepend getHeadSetDepend() {
        return hostHeadSetDepend;
    }

    public final IHostExternalStorageDepend getHostExternalStorageDepend() {
        return hostExternalStorageDepend;
    }

    public final IHostNaviDepend getHostNaviDepend() {
        return hostNaviDepend;
    }

    public final IHostSystemActionDepend getHostSystemActionDepend() {
        return hostSystemActionDepend;
    }

    public final IHostALogDepend getHostALogDepend() {
        return hostALogDepend;
    }

    public final IHostMemoryWaringDepend getMemoryWaringDepend() {
        return memoryWaringDepend;
    }

    public final IHostGeckoDepend getGeckoDepend() {
        IHostGeckoDepend iHostGeckoDepend = hostGeckoDepend;
        return iHostGeckoDepend == null ? new DefaultHostGeckoDepend() : iHostGeckoDepend;
    }

    @Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "IHostFrameworkDepend is no need to inject", imports = {}))
    public final XBaseRuntime setHostFrameworkDepend(IHostFrameworkDepend hostFrameworkDepend2) {
        Intrinsics.checkNotNullParameter(hostFrameworkDepend2, "hostFrameworkDepend");
        hostFrameworkDepend = hostFrameworkDepend2;
        return this;
    }

    @Deprecated(message = "Please use IHostLogDependV2", replaceWith = @ReplaceWith(expression = "use IHostLogDependV2 instead", imports = {}))
    public final XBaseRuntime setHostLogDepend(IHostLogDepend hostLogDepend2) {
        Intrinsics.checkNotNullParameter(hostLogDepend2, "hostLogDepend");
        hostLogDepend = hostLogDepend2;
        return this;
    }

    public final XBaseRuntime setHostLogDependV2(IHostLogDependV2 hostLogDependV22) {
        Intrinsics.checkNotNullParameter(hostLogDependV22, "hostLogDependV2");
        hostLogDependV2 = hostLogDependV22;
        return this;
    }

    public final XBaseRuntime setHostMediaDepend(IHostMediaDepend hostMediaDepend2) {
        Intrinsics.checkNotNullParameter(hostMediaDepend2, "hostMediaDepend");
        hostMediaDepend = hostMediaDepend2;
        return this;
    }

    public final XBaseRuntime setHostMediaDependV2(IHostMediaDependV2 hostMediaDependV22) {
        Intrinsics.checkNotNullParameter(hostMediaDependV22, "hostMediaDependV2");
        hostMediaDependV2 = hostMediaDependV22;
        return this;
    }

    public final XBaseRuntime setHostMediaDependV3(IHostMediaDependV3 hostMediaDependV32) {
        Intrinsics.checkNotNullParameter(hostMediaDependV32, "hostMediaDependV3");
        hostMediaDependV3 = hostMediaDependV32;
        return this;
    }

    public final XBaseRuntime setHostContextDepend(IHostContextDepend hostContextDepend2) {
        Intrinsics.checkNotNullParameter(hostContextDepend2, "hostContextDepend");
        hostContextDepend = hostContextDepend2;
        return this;
    }

    public final XBaseRuntime setHostRouterDepend(IHostRouterDepend hostRouterDepend2) {
        Intrinsics.checkNotNullParameter(hostRouterDepend2, "hostRouterDepend");
        hostRouterDepend = hostRouterDepend2;
        return this;
    }

    public final XBaseRuntime setHostCalendarDepend(IHostCalendarDepend hostCalendarDepend2) {
        Intrinsics.checkNotNullParameter(hostCalendarDepend2, "hostCalendarDepend");
        hostCalendarDepend = hostCalendarDepend2;
        return this;
    }

    public final XBaseRuntime setHostStyleUIDepend(IHostStyleUIDepend hostStyleUIDepend2) {
        Intrinsics.checkNotNullParameter(hostStyleUIDepend2, "hostStyleUIDepend");
        hostStyleUIDepend = hostStyleUIDepend2;
        return this;
    }

    public final XBaseRuntime setHostNetworkDepend(IHostNetworkDepend hostNetworkDepend2) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend2, "hostNetworkDepend");
        hostNetworkDepend = hostNetworkDepend2;
        return this;
    }

    public final XBaseRuntime setHostNetworkDependV2(IHostNetworkDependV2 hostNetworkDependV22) {
        Intrinsics.checkNotNullParameter(hostNetworkDependV22, "hostNetworkDependV2");
        hostNetworkDependV2 = hostNetworkDependV22;
        return this;
    }

    public final XBaseRuntime setHostPureNetworkDepend(IHostPureNetworkDepend hostPureNetworkDepend2) {
        Intrinsics.checkNotNullParameter(hostPureNetworkDepend2, "hostPureNetworkDepend");
        hostPureNetworkDepend = hostPureNetworkDepend2;
        return this;
    }

    public final XBaseRuntime setHostPermissionDepend(IHostPermissionDepend hostPermissionDepend2) {
        Intrinsics.checkNotNullParameter(hostPermissionDepend2, "hostPermissionDepend");
        hostPermissionDepend = hostPermissionDepend2;
        return this;
    }

    public final XBaseRuntime setHostLocationPermissionDepend(IHostLocationPermissionDepend hostLocationPermissionDepend2) {
        Intrinsics.checkNotNullParameter(hostLocationPermissionDepend2, "hostLocationPermissionDepend");
        hostLocationPermissionDepend = hostLocationPermissionDepend2;
        return this;
    }

    public final XBaseRuntime setHostUserDepend(IHostUserDepend userDepend) {
        Intrinsics.checkNotNullParameter(userDepend, "userDepend");
        hostUserDepend = userDepend;
        return this;
    }

    public final XBaseRuntime setHostThreadPoolExecutorDepend(IHostThreadPoolExecutorDepend hostThreadPoolExecutorDepend2) {
        Intrinsics.checkNotNullParameter(hostThreadPoolExecutorDepend2, "hostThreadPoolExecutorDepend");
        hostThreadPoolExecutorDepend = hostThreadPoolExecutorDepend2;
        return this;
    }

    public final XBaseRuntime setHostOpenDepend(IHostOpenDepend hostOpenDepend2) {
        Intrinsics.checkNotNullParameter(hostOpenDepend2, "hostOpenDepend");
        hostOpenDepend = hostOpenDepend2;
        return this;
    }

    public final XBaseRuntime setHostExternalStorageDepend(IHostExternalStorageDepend hostExternalStorageDepend2) {
        Intrinsics.checkNotNullParameter(hostExternalStorageDepend2, "hostExternalStorageDepend");
        hostExternalStorageDepend = hostExternalStorageDepend2;
        return this;
    }

    @Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "IHostNaviDepend is no need to inject", imports = {}))
    public final XBaseRuntime setHostNaviDepend(IHostNaviDepend hostNaviDepend2) {
        Intrinsics.checkNotNullParameter(hostNaviDepend2, "hostNaviDepend");
        hostNaviDepend = hostNaviDepend2;
        return this;
    }

    public final XBaseRuntime setHostSystemActionDepend(IHostSystemActionDepend hostSystemActionDepend2) {
        Intrinsics.checkNotNullParameter(hostSystemActionDepend2, "hostSystemActionDepend");
        hostSystemActionDepend = hostSystemActionDepend2;
        return this;
    }

    public final XBaseRuntime setHeadsetDepend(IHostHeadSetDepend hostHeadSetDepend2) {
        Intrinsics.checkNotNullParameter(hostHeadSetDepend2, "hostHeadSetDepend");
        hostHeadSetDepend = hostHeadSetDepend2;
        return this;
    }

    public final XBaseRuntime setHostALogDepend(IHostALogDepend hostALogDepend2) {
        Intrinsics.checkNotNullParameter(hostALogDepend2, "hostALogDepend");
        hostALogDepend = hostALogDepend2;
        return this;
    }

    public final XBaseRuntime setMemoryWarningDepend(IHostMemoryWaringDepend memoryWaringDepend2) {
        Intrinsics.checkNotNullParameter(memoryWaringDepend2, "memoryWaringDepend");
        memoryWaringDepend = memoryWaringDepend2;
        return this;
    }

    public final XBaseRuntime setHostCacheDepend(IHostCacheDepend hostCacheDepend2) {
        Intrinsics.checkNotNullParameter(hostCacheDepend2, "hostCacheDepend");
        hostCacheDepend = hostCacheDepend2;
        return this;
    }

    public final XBaseRuntime setHostGeckoDepend(IHostGeckoDepend hostGeckoDepend2) {
        Intrinsics.checkNotNullParameter(hostGeckoDepend2, "hostGeckoDepend");
        hostGeckoDepend = hostGeckoDepend2;
        return this;
    }
}
