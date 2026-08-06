package com.bytedance.ies.web.jsbridge2;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public interface IBridgePermissionConfigurator {

    /* loaded from: classes4.dex */
    public interface LocalStorage {

        /* loaded from: classes4.dex */
        public interface ValueCallback {
            void onValue(String str);
        }

        default String read(String str, String str2) {
            return null;
        }

        void read(String str, ValueCallback valueCallback);

        void write(String str, String str2);
    }

    /* loaded from: classes4.dex */
    public interface NetworkCallback {
        void onFailed(Throwable th);

        void onSucceed(String str);
    }

    /* loaded from: classes4.dex */
    public interface OpenJsbPermissionValidator {
        boolean shouldIntercept(String str, String str2);

        boolean shouldValidateUrl(String str);
    }

    /* loaded from: classes4.dex */
    public interface PermissionCheckUrlFilter {
        String filterUrl(String str);
    }

    /* loaded from: classes4.dex */
    public interface PermissionCheckingListener {
        void onFinishChecking(boolean z, String str, String str2, String str3);

        void onStartChecking(String str, String str2);
    }

    void doPost(String str, Map<String, String> map, String str2, byte[] bArr, NetworkCallback networkCallback);

    int provideAppId();

    String provideAppVersion();

    String provideDeviceId();

    String provideGeckoAccessKey();

    default String provideHostPermissionFetchUrl() {
        return null;
    }

    LocalStorage provideLocalStorage();

    Collection<String> provideNamespaces();

    int providePermissionCacheCapacity();

    default PermissionCheckUrlFilter providePermissionCheckUrlFilter() {
        return null;
    }

    String providePermissionConfigResponse();

    RegionConfig provideRegionConfig();

    Executor provideWorkerExecutor();

    /* loaded from: classes4.dex */
    public enum RegionConfig {
        CN("https://jsb.snssdk.com/src/server/v2/package");

        String url;

        RegionConfig(String str) {
            this.url = str;
        }

        String getUrl() {
            return this.url;
        }
    }
}
