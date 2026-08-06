package com.bytedance.ies.bullet.kit.web.export;

import com.bytedance.ies.bullet.kit.web.jsbridge.IShouldBlockJsbCallListener;
import com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig;
import com.bytedance.ies.web.jsbridge2.IBridgePermissionConfigurator;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.protocol.auth.Authenticator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: BaseWebJsBridgeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0016J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/export/BaseWebJsBridgeConfig;", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/IWebJsBridgeConfig;", "()V", "bridgeScheme", "", "disableAllPermissionCheck", "", "uri", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIgnoreGeckoSafeHost", "", "getProtectedFunc", "getPublicFunc", "getSafeHost", "jsBridgeDebug", "()Ljava/lang/Boolean;", "jsObjectName", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseWebJsBridgeConfig implements IWebJsBridgeConfig {
    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public String bridgeScheme() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public Boolean disableAllPermissionCheck(String uri) {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public List<String> getIgnoreGeckoSafeHost() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public List<String> getProtectedFunc() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public List<String> getPublicFunc() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public List<String> getSafeHost() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public Boolean jsBridgeDebug() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public String jsObjectName() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public Map<Authenticator, AuthPriority> addCustomAuthenticator() {
        return IWebJsBridgeConfig.DefaultImpls.addCustomAuthenticator(this);
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public IShouldBlockJsbCallListener getShouldBlockJsbCallListener() {
        return IWebJsBridgeConfig.DefaultImpls.getShouldBlockJsbCallListener(this);
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public IWebJsBridgeConfig.IOpenJsbPermissionValidator openJsbPermissionValidator() {
        return IWebJsBridgeConfig.DefaultImpls.openJsbPermissionValidator(this);
    }

    @Override // com.bytedance.ies.bullet.kit.web.jsbridge.IWebJsBridgeConfig
    public IBridgePermissionConfigurator.PermissionCheckingListener permissionCheckingListener() {
        return IWebJsBridgeConfig.DefaultImpls.permissionCheckingListener(this);
    }
}
