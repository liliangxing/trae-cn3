package com.bytedance.salamander.adapter;

import com.bytedance.bdturing.EventReport;
import kotlin.Metadata;

/* compiled from: FoundationDeviceInterface.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/salamander/adapter/DeviceOrientationProvider;", "", "isLandscape", "", "isPortrait", EventReport.SCREEN_ORIENTATION, "Lcom/bytedance/salamander/adapter/DeviceOrientations;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface DeviceOrientationProvider {
    boolean isLandscape();

    boolean isPortrait();

    DeviceOrientations orientation();
}
