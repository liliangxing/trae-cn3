package com.bytedance.salamander.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.bdturing.EventReport;
import com.bytedance.salamander.adapter.Salamander;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationDeviceImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/salamander/adapter/DeviceOrientationImpl;", "Lcom/bytedance/salamander/adapter/DeviceOrientationProvider;", "()V", "isLandscape", "", "isPortrait", EventReport.SCREEN_ORIENTATION, "Lcom/bytedance/salamander/adapter/DeviceOrientations;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public class DeviceOrientationImpl implements DeviceOrientationProvider {
    @Override // com.bytedance.salamander.adapter.DeviceOrientationProvider
    public DeviceOrientations orientation() {
        Salamander.Companion companion = Salamander.INSTANCE;
        Intrinsics.checkNotNull(companion);
        Context application = companion.getApplication();
        Intrinsics.checkNotNull(application);
        Object systemService = application.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Integer valueOf = defaultDisplay != null ? Integer.valueOf(defaultDisplay.getRotation()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            return DeviceOrientations.Portrait;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return DeviceOrientations.LandscapeLeft;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            return DeviceOrientations.PortraitUpsideDown;
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return DeviceOrientations.LandscapeRight;
        }
        return DeviceOrientations.Unknown;
    }

    @Override // com.bytedance.salamander.adapter.DeviceOrientationProvider
    public boolean isPortrait() {
        Configuration configuration;
        Salamander.Companion companion = Salamander.INSTANCE;
        Intrinsics.checkNotNull(companion);
        Context application = companion.getApplication();
        Intrinsics.checkNotNull(application);
        Resources resources = application.getResources();
        return (resources == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 1) ? false : true;
    }

    @Override // com.bytedance.salamander.adapter.DeviceOrientationProvider
    public boolean isLandscape() {
        Configuration configuration;
        Salamander.Companion companion = Salamander.INSTANCE;
        Intrinsics.checkNotNull(companion);
        Context application = companion.getApplication();
        Intrinsics.checkNotNull(application);
        Resources resources = application.getResources();
        return (resources == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
    }
}
