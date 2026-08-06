package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: IPermissionConfigProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0016H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;", "", "doPost", "", "urlString", "headerMap", "", CMSAttributeTableGenerator.CONTENT_TYPE, ReportConst.ValidationReport.BODY, "", "doRequestRemoteConfigAsync", "", "runnable", "Ljava/lang/Runnable;", "provideAppId", "", "provideAppVersion", "provideBuiltInPermissionConfig", "provideCacheConfigPermissionCapacity", "provideDeviceId", "provideGeckoAccessKey", "provideLocalStorage", "Lcom/bytedance/sdk/xbridge/cn/auth/ILocalStorage;", "provideNamespaces", "", "provideRemoteConfigUrl", "provideWorkerExecutor", "Ljava/util/concurrent/Executor;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IPermissionConfigProvider {
    String doPost(String urlString, Map<String, String> headerMap, String contentType, byte[] body);

    void doRequestRemoteConfigAsync(Runnable runnable);

    int provideAppId();

    String provideAppVersion();

    String provideBuiltInPermissionConfig();

    int provideCacheConfigPermissionCapacity();

    String provideDeviceId();

    String provideGeckoAccessKey();

    ILocalStorage provideLocalStorage();

    List<String> provideNamespaces();

    String provideRemoteConfigUrl();

    Executor provideWorkerExecutor();
}
