package com.bytedance.salamander.adapter;

import com.bytedance.bdturing.EventReport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationDevice.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/salamander/adapter/SLDevice;", "", "()V", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class SLDevice {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SLDeviceInfo info = new SLDeviceInfo();
    private static SLDeviceOrientation orientation = new SLDeviceOrientation();
    private static SLDeviceSystem system = new SLDeviceSystem();

    /* compiled from: FoundationDevice.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/salamander/adapter/SLDevice$Companion;", "", "()V", "info", "Lcom/bytedance/salamander/adapter/SLDeviceInfo;", "getInfo", "()Lcom/bytedance/salamander/adapter/SLDeviceInfo;", "setInfo", "(Lcom/bytedance/salamander/adapter/SLDeviceInfo;)V", EventReport.SCREEN_ORIENTATION, "Lcom/bytedance/salamander/adapter/SLDeviceOrientation;", "getOrientation", "()Lcom/bytedance/salamander/adapter/SLDeviceOrientation;", "setOrientation", "(Lcom/bytedance/salamander/adapter/SLDeviceOrientation;)V", "system", "Lcom/bytedance/salamander/adapter/SLDeviceSystem;", "getSystem", "()Lcom/bytedance/salamander/adapter/SLDeviceSystem;", "setSystem", "(Lcom/bytedance/salamander/adapter/SLDeviceSystem;)V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public SLDeviceInfo getInfo() {
            return SLDevice.info;
        }

        public void setInfo(SLDeviceInfo sLDeviceInfo) {
            Intrinsics.checkNotNullParameter(sLDeviceInfo, "<set-?>");
            SLDevice.info = sLDeviceInfo;
        }

        public SLDeviceOrientation getOrientation() {
            return SLDevice.orientation;
        }

        public void setOrientation(SLDeviceOrientation sLDeviceOrientation) {
            Intrinsics.checkNotNullParameter(sLDeviceOrientation, "<set-?>");
            SLDevice.orientation = sLDeviceOrientation;
        }

        public SLDeviceSystem getSystem() {
            return SLDevice.system;
        }

        public void setSystem(SLDeviceSystem sLDeviceSystem) {
            Intrinsics.checkNotNullParameter(sLDeviceSystem, "<set-?>");
            SLDevice.system = sLDeviceSystem;
        }
    }
}
