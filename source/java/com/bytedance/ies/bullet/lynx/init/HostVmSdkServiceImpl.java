package com.bytedance.ies.bullet.lynx.init;

import com.bytedance.vmsdk.service.IVmSdkHostService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/HostVmSdkServiceImpl;", "Lcom/bytedance/vmsdk/service/IVmSdkHostService;", "mEnableVmSdk", "", "(Z)V", "TAG", "", "getLynxPluginName", "getV8PluginName", "getVmSdkPluginName", "isPluginInstalled", DBDefinition.PACKAGE_NAME, "isVmSdkPluginSettingsEnable", "loadPlugin", "setAsHostClassLoader", "setAsPluginClassLoader", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class HostVmSdkServiceImpl implements IVmSdkHostService {
    private final String TAG = "HostVmSdkServiceImpl";
    private final boolean mEnableVmSdk;

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public String getLynxPluginName() {
        return "m.l.lynx.svs.impl";
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public String getV8PluginName() {
        return "com.ss.android.ugc.aweme.v8";
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public String getVmSdkPluginName() {
        return "com.ss.android.ugc.aweme.vmsdk_plugin";
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public boolean isPluginInstalled(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return true;
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public boolean loadPlugin(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return true;
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public boolean setAsHostClassLoader(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return true;
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    public boolean setAsPluginClassLoader(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return true;
    }

    public HostVmSdkServiceImpl(boolean z) {
        this.mEnableVmSdk = z;
    }

    @Override // com.bytedance.vmsdk.service.IVmSdkHostService
    /* renamed from: isVmSdkPluginSettingsEnable, reason: from getter */
    public boolean getMEnableVmSdk() {
        return this.mEnableVmSdk;
    }
}
