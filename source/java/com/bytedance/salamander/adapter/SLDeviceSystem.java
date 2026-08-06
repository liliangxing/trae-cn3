package com.bytedance.salamander.adapter;

import kotlin.Metadata;

/* compiled from: FoundationDevice.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/salamander/adapter/SLDeviceSystem;", "", "()V", "mImpl", "Lcom/bytedance/salamander/adapter/DeviceSystemImpl;", "systemName", "", "systemVersion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class SLDeviceSystem {
    private DeviceSystemImpl mImpl = new DeviceSystemImpl();

    public String systemVersion() {
        return this.mImpl.systemVersion();
    }

    public String systemName() {
        return this.mImpl.systemName();
    }
}
