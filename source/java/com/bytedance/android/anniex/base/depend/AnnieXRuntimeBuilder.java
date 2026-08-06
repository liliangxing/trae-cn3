package com.bytedance.android.anniex.base.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXRuntimeBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/AnnieXRuntimeBuilder;", "", "()V", "applicationDepend", "Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "getApplicationDepend$anniex_release", "()Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "setApplicationDepend$anniex_release", "(Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;)V", "deviceDepend", "Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "getDeviceDepend$anniex_release", "()Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "setDeviceDepend$anniex_release", "(Lcom/bytedance/android/anniex/base/depend/DeviceDepend;)V", "application", "device", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnieXRuntimeBuilder {
    private ApplicationDepend applicationDepend;
    private DeviceDepend deviceDepend;

    /* renamed from: getDeviceDepend$anniex_release, reason: from getter */
    public final DeviceDepend getDeviceDepend() {
        return this.deviceDepend;
    }

    public final void setDeviceDepend$anniex_release(DeviceDepend deviceDepend) {
        this.deviceDepend = deviceDepend;
    }

    /* renamed from: getApplicationDepend$anniex_release, reason: from getter */
    public final ApplicationDepend getApplicationDepend() {
        return this.applicationDepend;
    }

    public final void setApplicationDepend$anniex_release(ApplicationDepend applicationDepend) {
        this.applicationDepend = applicationDepend;
    }

    public final AnnieXRuntimeBuilder device(DeviceDepend deviceDepend) {
        Intrinsics.checkNotNullParameter(deviceDepend, "deviceDepend");
        this.deviceDepend = deviceDepend;
        return this;
    }

    public final AnnieXRuntimeBuilder application(ApplicationDepend applicationDepend) {
        Intrinsics.checkNotNullParameter(applicationDepend, "applicationDepend");
        this.applicationDepend = applicationDepend;
        return this;
    }
}
