package com.bytedance.sdk.xbridge.cn.protocol.auth;

import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.auth.XBridgeAuthRecoveryManager;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeAuthManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/auth/XBridgeAuthManager;", "", "()V", "authenticatorList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/Authenticator;", "addAuthenticator", "", "authenticator", "priority", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthPriority;", "doAuth", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthResult;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "method", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeAuthManager {
    private final CopyOnWriteArrayList<Authenticator> authenticatorList = new CopyOnWriteArrayList<>();

    /* compiled from: XBridgeAuthManager.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthPriority.values().length];
            try {
                iArr[AuthPriority.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void addAuthenticator(Authenticator authenticator) {
        Intrinsics.checkNotNullParameter(authenticator, "authenticator");
        addAuthenticator$default(this, authenticator, null, 2, null);
    }

    public static /* synthetic */ void addAuthenticator$default(XBridgeAuthManager xBridgeAuthManager, Authenticator authenticator, AuthPriority authPriority, int i, Object obj) {
        if ((i & 2) != 0) {
            authPriority = AuthPriority.LOW;
        }
        xBridgeAuthManager.addAuthenticator(authenticator, authPriority);
    }

    public final void addAuthenticator(Authenticator authenticator, AuthPriority priority) {
        Intrinsics.checkNotNullParameter(authenticator, "authenticator");
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (WhenMappings.$EnumSwitchMapping$0[priority.ordinal()] == 1) {
            this.authenticatorList.add(0, authenticator);
        } else {
            this.authenticatorList.add(authenticator);
        }
    }

    public final AuthResult doAuth(BaseBridgeCall<?> call, IDLXBridgeMethod method) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(method, "method");
        if (!XBridge.INSTANCE.getConfig().getEnableAuth()) {
            XBridge.log("XBridgeAuthManager.doAuth: skip by disable auth");
            return new AuthResult(true, false, "XBridge unable auth", null, AuthSuccessCode.DISABLE_AUTH, false, 42, null);
        }
        if (XBridgeAuthRecoveryManager.INSTANCE.skipAuth(call.getUrl())) {
            XBridge.log("XBridgeAuthManager.doAuth: skip by auth recovery");
            AuthResult authResult = new AuthResult(true, false, "recovery over auth", null, AuthSuccessCode.MATCH_RECOVERY_CONFIG, false, 42, null);
            authResult.setAuthUrl(call.getUrl());
            return authResult;
        }
        Iterator<Authenticator> it = this.authenticatorList.iterator();
        AuthResult authResult2 = null;
        while (it.hasNext()) {
            authResult2 = it.next().doAuth(call, method);
            if (authResult2.getInterrupt() || !authResult2.getPassed()) {
                return authResult2;
            }
        }
        return authResult2 == null ? new AuthResult(true, false, null, null, null, false, 62, null) : authResult2;
    }
}
