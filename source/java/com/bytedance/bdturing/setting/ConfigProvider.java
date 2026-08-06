package com.bytedance.bdturing.setting;

import android.os.Looper;
import com.bytedance.bdturing.ttnet.HttpClient;
import kotlin.Metadata;

/* compiled from: ConfigProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/bdturing/setting/ConfigProvider;", "", "getAppId", "", "getAppName", "getAppVersion", "getAppVersionCode", "getChannel", "getDeviceId", "getHttpClient", "Lcom/bytedance/bdturing/ttnet/HttpClient;", "getInstallId", "getLang", "getRegion", "getSDKVersion", "getServiceInterceptor", "Lcom/bytedance/bdturing/setting/ServiceInterceptor;", "getWorkerLooper", "Landroid/os/Looper;", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ConfigProvider {
    String getAppId();

    String getAppName();

    String getAppVersion();

    String getAppVersionCode();

    String getChannel();

    String getDeviceId();

    HttpClient getHttpClient();

    String getInstallId();

    String getLang();

    String getRegion();

    String getSDKVersion();

    ServiceInterceptor getServiceInterceptor();

    Looper getWorkerLooper();
}
