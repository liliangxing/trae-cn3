package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import kotlin.Metadata;
import net.openid.appauth.RegistrationRequest;

/* compiled from: PermissionExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0000¨\u0006\u0003"}, d2 = {"toAccess", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionExtKt {
    public static final IDLXBridgeMethod.Access toAccess(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -977423767:
                    if (str.equals(RegistrationRequest.SUBJECT_TYPE_PUBLIC)) {
                        return IDLXBridgeMethod.Access.PUBLIC;
                    }
                    break;
                case -906273929:
                    if (str.equals("secure")) {
                        return IDLXBridgeMethod.Access.SECURE;
                    }
                    break;
                case -608539730:
                    if (str.equals("protected")) {
                        return IDLXBridgeMethod.Access.PROTECT;
                    }
                    break;
                case -314497661:
                    if (str.equals("private")) {
                        return IDLXBridgeMethod.Access.PRIVATE;
                    }
                    break;
                case -309012785:
                    if (str.equals("protect")) {
                        return IDLXBridgeMethod.Access.PROTECT;
                    }
                    break;
            }
        }
        return IDLXBridgeMethod.Access.PUBLIC;
    }
}
