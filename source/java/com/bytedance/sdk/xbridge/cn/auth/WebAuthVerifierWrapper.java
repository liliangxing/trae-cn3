package com.bytedance.sdk.xbridge.cn.auth;

import android.net.Uri;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.BridgeInfo;
import com.bytedance.sdk.xbridge.cn.auth.depend.ILogDepend;
import com.bytedance.sdk.xbridge.cn.auth.depend.IReportDepend;
import com.bytedance.sdk.xbridge.cn.auth.entity.PermissionConfigNamespace;
import com.bytedance.sdk.xbridge.cn.auth.entity.PermissionRule;
import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigRepository;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebAuthVerifierWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifierWrapper;", "", "()V", "authVerifierV2", "Lcom/bytedance/sdk/xbridge/cn/auth/WebAuthVerifier;", "addLogDepend", "", MessagePart.TYPE_LOG, "Lcom/bytedance/sdk/xbridge/cn/auth/depend/ILogDepend;", "addReportDepend", "report", "Lcom/bytedance/sdk/xbridge/cn/auth/depend/IReportDepend;", "checkAuth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "method", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "doAuth", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class WebAuthVerifierWrapper {
    private final WebAuthVerifier authVerifierV2;

    public WebAuthVerifierWrapper() {
        WebAuthVerifier webAuthVerifier = new WebAuthVerifier();
        webAuthVerifier.setReportPV(false);
        this.authVerifierV2 = webAuthVerifier;
    }

    public final void addLogDepend(ILogDepend log) {
        Intrinsics.checkNotNullParameter(log, MessagePart.TYPE_LOG);
        this.authVerifierV2.addLogDepend(log);
    }

    public final void addReportDepend(IReportDepend report) {
        Intrinsics.checkNotNullParameter(report, "report");
        this.authVerifierV2.addReportDepend(report);
    }

    public final AuthResult doAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(method, "method");
        try {
            BridgeInfo bridgeInfo = new BridgeInfo(method.getName(), AuthBridgeAccess.INSTANCE.getAccess(method.getAccess().getValue()), call.convertParamsToJSONObject());
            bridgeInfo.setUrl(call.getUrl());
            bridgeInfo.setContainerType(AuthConfigType.WEB);
            bridgeInfo.setAuthFeId(call.getAuthFeId());
            if (AuthStrategyRepository.INSTANCE.getEnableAuthV3()) {
                XBridge.log("WebAuthVerifierWrapper.doAuth: use V3");
                return this.authVerifierV2.checkBridgeAuthNew(String.valueOf(call.getAppId()), bridgeInfo, call.getNamespace());
            }
            if (this.authVerifierV2.isUseAuthV2(call.getAppId(), call.getNamespace())) {
                String valueOf = String.valueOf(call.getAppId());
                if (PermissionConfigV2Parser.INSTANCE.getAuthConfig(valueOf, call.getNamespace()) != null) {
                    XBridge.log("WebAuthVerifierWrapper.doAuth: use V2");
                    WebAuthVerifier webAuthVerifier = this.authVerifierV2;
                    if (valueOf == null) {
                        valueOf = "";
                    }
                    AuthResult checkBridgeAuth = webAuthVerifier.checkBridgeAuth(valueOf, bridgeInfo, call.getNamespace());
                    checkBridgeAuth.setAuthMode(AuthMode.INTERNAL_H5_APPID);
                    return checkBridgeAuth;
                }
            }
            XBridge.log("WebAuthVerifierWrapper.doAuth: use V1");
            AuthResult checkAuth = checkAuth(call, method);
            checkAuth.setAuthMode(AuthMode.INTERNAL_H5_OLD);
            checkAuth.setAuthFeId(OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW);
            checkAuth.setPackageVersion(PermissionConfigV2Parser.INSTANCE.getPackageVersion(call.getNamespace()));
            return checkAuth;
        } catch (Exception e) {
            XBridge.log("WebAuthVerifierWrapper.doAuth error: " + e.getMessage());
            e.printStackTrace();
            return new AuthResult(true, false, "unexpected error: " + e.getMessage(), null, AuthSuccessCode.LOGIC_ERROR, false, 42, null);
        }
    }

    private final AuthResult checkAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
        PermissionRule rule;
        if (call.getPlatformType() == PlatformType.WEB) {
            String url = call.getUrl();
            String host = Uri.parse(url).getHost();
            String namespace = call.getNamespace();
            String methodName = call.getMethodName();
            if (host == null) {
                boolean z = method.getAccess() == IDLXBridgeMethod.Access.PUBLIC;
                XBridge.log("JSB Authenticate: Empty host :" + url);
                return new AuthResult(z, false, "JSB Authenticate: Empty host :" + url, null, null, false, 58, null);
            }
            PermissionConfigNamespace configByNamespace = PermissionConfigRepository.INSTANCE.getConfigByNamespace(namespace);
            if (configByNamespace == null) {
                if (BDXBridgePermission.INSTANCE.hasTriggerInit() && PermissionConfigRepository.INSTANCE.isPermissionConfigEmpty()) {
                    XBridge.log("JSB Authenticate: all permission config not found, pass auth");
                    return new AuthResult(true, false, "all permission config not found", null, null, false, 58, null);
                }
                return new AuthResult(false, false, "permission Config not found", null, null, false, 58, null);
            }
            if (Intrinsics.areEqual(namespace, "webcast")) {
                rule = configByNamespace.getRuleMix(url);
            } else {
                rule = configByNamespace.getRule(url);
            }
            if (method.getAccess() == IDLXBridgeMethod.Access.SECURE && !rule.getIncludedMethods().contains(methodName)) {
                return new AuthResult(false, false, "method is secure,and not in include method,fail", null, null, false, 58, null);
            }
            if (rule.getExcludedMethods().contains(methodName)) {
                return new AuthResult(false, false, "method in exclude methods", null, null, false, 58, null);
            }
            if (rule.getIncludedMethods().contains(methodName)) {
                return new AuthResult(true, true, null, null, null, false, 60, null);
            }
            if (rule.getAccess().compareTo(method.getAccess()) >= 0) {
                return new AuthResult(true, false, null, null, null, false, 62, null);
            }
            return new AuthResult(false, false, "rule.access:" + rule.getAccess() + ", method.access:" + method.getAccess() + ", rule < method", null, null, false, 58, null);
        }
        return new AuthResult(true, false, null, null, null, false, 62, null);
    }
}
