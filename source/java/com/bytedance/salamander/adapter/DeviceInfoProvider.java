package com.bytedance.salamander.adapter;

import com.xiaomi.mipush.sdk.Constants;
import kotlin.Metadata;

/* compiled from: FoundationDeviceInterface.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/salamander/adapter/DeviceInfoProvider;", "", Constants.PHONE_BRAND, "", "isSimulator", "", "modelID", "modelName", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface DeviceInfoProvider {
    String brand();

    boolean isSimulator();

    String modelID();

    String modelName();
}
