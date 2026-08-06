package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.ies.xbridge.utils.IXLogService;
import com.bytedance.ies.xbridge.utils.XServiceManager;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBaseRuntime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u0004\u0018\u00010\fJ\b\u0010*\u001a\u0004\u0018\u00010\u0004J\b\u0010+\u001a\u0004\u0018\u00010\u0006J\b\u0010,\u001a\u0004\u0018\u00010\bJ\b\u0010-\u001a\u0004\u0018\u00010\nJ\b\u0010.\u001a\u0004\u0018\u00010\u000eJ\b\u0010/\u001a\u0004\u0018\u00010\u0010J\b\u00100\u001a\u0004\u0018\u00010\u0012J\b\u00101\u001a\u0004\u0018\u00010\u0014J\b\u00102\u001a\u0004\u0018\u00010\u0016J\b\u00103\u001a\u0004\u0018\u00010\u0018J\b\u00104\u001a\u0004\u0018\u00010\u001aJ\b\u00105\u001a\u0004\u0018\u00010\u0016J\b\u00106\u001a\u0004\u0018\u00010\u001eJ\b\u00107\u001a\u0004\u0018\u00010 J\b\u00108\u001a\u0004\u0018\u00010\"J\b\u00109\u001a\u0004\u0018\u00010$J\b\u0010:\u001a\u0004\u0018\u00010&J\b\u0010;\u001a\u0004\u0018\u00010(J\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020&J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/XBaseRuntime;", "", "()V", "hostCalendarDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostCalendarDependOld;", "hostContextDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostContextDepend;", "hostExternalStorageDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostExternalStorageDepend;", "hostFrameworkDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostFrameworkDepend;", "hostHeadSetDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostHeadSetDepend;", "hostLocationPermissionDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLocationPermissionDepend;", "hostLogDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLogDepend;", "hostMediaDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMediaDepend;", "hostNaviDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostNaviDepend;", "hostNetworkDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostNetworkDepend;", "hostOpenDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend;", "hostPermissionDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostPermissionDepend;", "hostPureNetworkDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostPureNetworkDepend;", "hostRouterDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostRouterDepend;", "hostStyleUIDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostStyleUIDepend;", "hostSystemActionDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostSystemActionDepend;", "hostThreadPoolExecutorDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostThreadPoolExecutorDepend;", "hostUserDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostUserDepend;", "memoryWaringDepend", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend;", "getHeadSetDepend", "getHostCalendarDepend", "getHostContextDepend", "getHostExternalStorageDepend", "getHostFrameworkDepend", "getHostLocationPermissionDepend", "getHostLogDepend", "getHostMediaDepend", "getHostNaviDepend", "getHostNetworkDepend", "getHostOpenDepend", "getHostPermissionDepend", "getHostPureNetworkDepend", "getHostRouterDepend", "getHostStyleUIDepend", "getHostSystemActionDepend", "getHostThreadPoolExecutorDepend", "getHostUserDepend", "getMemoryWaringDepend", EventConstants.PARAM_SOURCE_INIT, "", "setHeadsetDepend", "setHostCalendarDepend", "setHostContextDepend", "setHostExternalStorageDepend", "setHostFrameworkDepend", "setHostLocationPermissionDepend", "setHostLogDepend", "setHostMediaDepend", "setHostNaviDepend", "setHostNetworkDepend", "setHostOpenDepend", "setHostPermissionDepend", "setHostPureNetworkDepend", "setHostRouterDepend", "setHostStyleUIDepend", "setHostSystemActionDepend", "setHostThreadPoolExecutorDepend", "setHostUserDepend", "userDepend", "setMemoryWarningDepend", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBaseRuntime {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static XBaseRuntime INSTANCE;
    private IHostCalendarDependOld hostCalendarDepend;
    private IHostContextDepend hostContextDepend;
    private IHostExternalStorageDepend hostExternalStorageDepend;
    private IHostFrameworkDepend hostFrameworkDepend;
    private IHostHeadSetDepend hostHeadSetDepend;
    private IHostLocationPermissionDepend hostLocationPermissionDepend;
    private IHostLogDepend hostLogDepend;
    private IHostMediaDepend hostMediaDepend;
    private IHostNaviDepend hostNaviDepend;
    private IHostNetworkDepend hostNetworkDepend;
    private IHostOpenDepend hostOpenDepend;
    private IHostPermissionDepend hostPermissionDepend;
    private IHostPureNetworkDepend hostPureNetworkDepend;
    private IHostRouterDepend hostRouterDepend;
    private IHostStyleUIDepend hostStyleUIDepend;
    private IHostSystemActionDepend hostSystemActionDepend;
    private IHostThreadPoolExecutorDepend hostThreadPoolExecutorDepend;
    private IHostUserDepend hostUserDepend;
    private IHostMemoryWaringDepend memoryWaringDepend;

    public /* synthetic */ XBaseRuntime(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: XBaseRuntime.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/XBaseRuntime$Companion;", "", "()V", "<set-?>", "Lcom/bytedance/ies/xbridge/base/runtime/depend/XBaseRuntime;", "INSTANCE", "getINSTANCE", "()Lcom/bytedance/ies/xbridge/base/runtime/depend/XBaseRuntime;", "create", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final XBaseRuntime getINSTANCE() {
            return XBaseRuntime.INSTANCE;
        }

        public final XBaseRuntime create() {
            return new XBaseRuntime(null);
        }
    }

    private XBaseRuntime() {
    }

    public final IHostFrameworkDepend getHostFrameworkDepend() {
        return this.hostFrameworkDepend;
    }

    public final IHostLogDepend getHostLogDepend() {
        return this.hostLogDepend;
    }

    public final IHostMediaDepend getHostMediaDepend() {
        return this.hostMediaDepend;
    }

    public final IHostUserDepend getHostUserDepend() {
        return this.hostUserDepend;
    }

    public final IHostNetworkDepend getHostNetworkDepend() {
        return this.hostNetworkDepend;
    }

    public final IHostNetworkDepend getHostPureNetworkDepend() {
        return this.hostPureNetworkDepend;
    }

    public final IHostPermissionDepend getHostPermissionDepend() {
        return this.hostPermissionDepend;
    }

    public final IHostLocationPermissionDepend getHostLocationPermissionDepend() {
        return this.hostLocationPermissionDepend;
    }

    public final IHostRouterDepend getHostRouterDepend() {
        return this.hostRouterDepend;
    }

    public final IHostContextDepend getHostContextDepend() {
        return this.hostContextDepend;
    }

    public final IHostStyleUIDepend getHostStyleUIDepend() {
        return this.hostStyleUIDepend;
    }

    public final IHostThreadPoolExecutorDepend getHostThreadPoolExecutorDepend() {
        return this.hostThreadPoolExecutorDepend;
    }

    public final IHostOpenDepend getHostOpenDepend() {
        return this.hostOpenDepend;
    }

    /* renamed from: getHeadSetDepend, reason: from getter */
    public final IHostHeadSetDepend getHostHeadSetDepend() {
        return this.hostHeadSetDepend;
    }

    public final IHostExternalStorageDepend getHostExternalStorageDepend() {
        return this.hostExternalStorageDepend;
    }

    public final IHostNaviDepend getHostNaviDepend() {
        return this.hostNaviDepend;
    }

    public final IHostSystemActionDepend getHostSystemActionDepend() {
        return this.hostSystemActionDepend;
    }

    public final IHostMemoryWaringDepend getMemoryWaringDepend() {
        return this.memoryWaringDepend;
    }

    public final IHostCalendarDependOld getHostCalendarDepend() {
        return this.hostCalendarDepend;
    }

    public final XBaseRuntime setHostFrameworkDepend(IHostFrameworkDepend hostFrameworkDepend) {
        Intrinsics.checkNotNullParameter(hostFrameworkDepend, "hostFrameworkDepend");
        this.hostFrameworkDepend = hostFrameworkDepend;
        return this;
    }

    public final XBaseRuntime setHostLogDepend(IHostLogDepend hostLogDepend) {
        Intrinsics.checkNotNullParameter(hostLogDepend, "hostLogDepend");
        this.hostLogDepend = hostLogDepend;
        return this;
    }

    public final XBaseRuntime setHostMediaDepend(IHostMediaDepend hostMediaDepend) {
        Intrinsics.checkNotNullParameter(hostMediaDepend, "hostMediaDepend");
        this.hostMediaDepend = hostMediaDepend;
        return this;
    }

    public final XBaseRuntime setHostContextDepend(IHostContextDepend hostContextDepend) {
        Intrinsics.checkNotNullParameter(hostContextDepend, "hostContextDepend");
        this.hostContextDepend = hostContextDepend;
        return this;
    }

    public final XBaseRuntime setHostRouterDepend(IHostRouterDepend hostRouterDepend) {
        Intrinsics.checkNotNullParameter(hostRouterDepend, "hostRouterDepend");
        this.hostRouterDepend = hostRouterDepend;
        return this;
    }

    public final XBaseRuntime setHostStyleUIDepend(IHostStyleUIDepend hostStyleUIDepend) {
        Intrinsics.checkNotNullParameter(hostStyleUIDepend, "hostStyleUIDepend");
        this.hostStyleUIDepend = hostStyleUIDepend;
        return this;
    }

    public final XBaseRuntime setHostCalendarDepend(IHostCalendarDependOld hostCalendarDepend) {
        Intrinsics.checkNotNullParameter(hostCalendarDepend, "hostCalendarDepend");
        this.hostCalendarDepend = hostCalendarDepend;
        return this;
    }

    public final XBaseRuntime setHostNetworkDepend(IHostNetworkDepend hostNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostNetworkDepend, "hostNetworkDepend");
        this.hostNetworkDepend = hostNetworkDepend;
        return this;
    }

    public final XBaseRuntime setHostPureNetworkDepend(IHostPureNetworkDepend hostPureNetworkDepend) {
        Intrinsics.checkNotNullParameter(hostPureNetworkDepend, "hostPureNetworkDepend");
        this.hostPureNetworkDepend = hostPureNetworkDepend;
        return this;
    }

    public final XBaseRuntime setHostPermissionDepend(IHostPermissionDepend hostPermissionDepend) {
        Intrinsics.checkNotNullParameter(hostPermissionDepend, "hostPermissionDepend");
        this.hostPermissionDepend = hostPermissionDepend;
        return this;
    }

    public final XBaseRuntime setHostLocationPermissionDepend(IHostLocationPermissionDepend hostLocationPermissionDepend) {
        Intrinsics.checkNotNullParameter(hostLocationPermissionDepend, "hostLocationPermissionDepend");
        this.hostLocationPermissionDepend = hostLocationPermissionDepend;
        return this;
    }

    public final XBaseRuntime setHostUserDepend(IHostUserDepend userDepend) {
        Intrinsics.checkNotNullParameter(userDepend, "userDepend");
        this.hostUserDepend = userDepend;
        return this;
    }

    public final XBaseRuntime setHostThreadPoolExecutorDepend(IHostThreadPoolExecutorDepend hostThreadPoolExecutorDepend) {
        Intrinsics.checkNotNullParameter(hostThreadPoolExecutorDepend, "hostThreadPoolExecutorDepend");
        this.hostThreadPoolExecutorDepend = hostThreadPoolExecutorDepend;
        return this;
    }

    public final XBaseRuntime setHostOpenDepend(IHostOpenDepend hostOpenDepend) {
        Intrinsics.checkNotNullParameter(hostOpenDepend, "hostOpenDepend");
        this.hostOpenDepend = hostOpenDepend;
        return this;
    }

    public final XBaseRuntime setHostExternalStorageDepend(IHostExternalStorageDepend hostExternalStorageDepend) {
        Intrinsics.checkNotNullParameter(hostExternalStorageDepend, "hostExternalStorageDepend");
        this.hostExternalStorageDepend = hostExternalStorageDepend;
        return this;
    }

    public final XBaseRuntime setHostNaviDepend(IHostNaviDepend hostNaviDepend) {
        Intrinsics.checkNotNullParameter(hostNaviDepend, "hostNaviDepend");
        this.hostNaviDepend = hostNaviDepend;
        return this;
    }

    public final XBaseRuntime setHostSystemActionDepend(IHostSystemActionDepend hostSystemActionDepend) {
        Intrinsics.checkNotNullParameter(hostSystemActionDepend, "hostSystemActionDepend");
        this.hostSystemActionDepend = hostSystemActionDepend;
        return this;
    }

    public final XBaseRuntime setHeadsetDepend(IHostHeadSetDepend hostHeadSetDepend) {
        Intrinsics.checkNotNullParameter(hostHeadSetDepend, "hostHeadSetDepend");
        this.hostHeadSetDepend = hostHeadSetDepend;
        return this;
    }

    public final XBaseRuntime setMemoryWarningDepend(IHostMemoryWaringDepend memoryWaringDepend) {
        Intrinsics.checkNotNullParameter(memoryWaringDepend, "memoryWaringDepend");
        this.memoryWaringDepend = memoryWaringDepend;
        return this;
    }

    public final synchronized void init() {
        if (INSTANCE == null) {
            INSTANCE = this;
            XServiceManager xServiceManager = XServiceManager.INSTANCE;
            IHostLogDepend iHostLogDepend = this.hostLogDepend;
            xServiceManager.bind(IXLogService.class, iHostLogDepend != null ? iHostLogDepend.getLogService() : null);
        }
    }
}
