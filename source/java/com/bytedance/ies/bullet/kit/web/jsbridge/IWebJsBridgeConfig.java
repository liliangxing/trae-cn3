package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IWebJsBridgeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0019\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH&J\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH&J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig;", "", "addCustomAuthenticator", "", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthPriority;", "bridgeScheme", "", "disableAllPermissionCheck", "", "uri", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIgnoreGeckoSafeHost", "", "getProtectedFunc", "getPublicFunc", "getSafeHost", "getShouldBlockJsbCallListener", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IShouldBlockJsbCallListener;", "jsBridgeDebug", "()Ljava/lang/Boolean;", "jsObjectName", "openJsbPermissionValidator", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig$IOpenJsbPermissionValidator;", "permissionCheckingListener", "Lcom/bytedance/ies/web/jsbridge2/IBridgePermissionConfigurator$PermissionCheckingListener;", "IOpenJsbPermissionValidator", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IWebJsBridgeConfig {

    /* compiled from: IWebJsBridgeConfig.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static Map<Authenticator, AuthPriority> addCustomAuthenticator(IWebJsBridgeConfig iWebJsBridgeConfig) {
            return null;
        }

        public static IShouldBlockJsbCallListener getShouldBlockJsbCallListener(IWebJsBridgeConfig iWebJsBridgeConfig) {
            return null;
        }

        public static IOpenJsbPermissionValidator openJsbPermissionValidator(IWebJsBridgeConfig iWebJsBridgeConfig) {
            return null;
        }

        public static IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener(IWebJsBridgeConfig iWebJsBridgeConfig) {
            return null;
        }
    }

    /* compiled from: IWebJsBridgeConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig$IOpenJsbPermissionValidator;", "", "shouldIntercept", "", "url", "", "methodName", "shouldValidateUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IOpenJsbPermissionValidator {
        boolean shouldIntercept(String url, String methodName);

        boolean shouldValidateUrl(String url);
    }

    Map<Authenticator, AuthPriority> addCustomAuthenticator();

    String bridgeScheme();

    Boolean disableAllPermissionCheck(String uri);

    List<String> getIgnoreGeckoSafeHost();

    List<String> getProtectedFunc();

    List<String> getPublicFunc();

    List<String> getSafeHost();

    IShouldBlockJsbCallListener getShouldBlockJsbCallListener();

    Boolean jsBridgeDebug();

    String jsObjectName();

    IOpenJsbPermissionValidator openJsbPermissionValidator();

    IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener();
}
