package com.bytedance.timonbase.apicache;

import com.xiaomi.mipush.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toStoreKey", "", "Lcom/bytedance/timonbase/apicache/ApiArgs;", "timonbase_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class ApiArgsKt {
    public static final String toStoreKey(ApiArgs toStoreKey) {
        Intrinsics.checkParameterIsNotNull(toStoreKey, "$this$toStoreKey");
        StringBuilder sb = new StringBuilder();
        if (toStoreKey.getParameters() != null) {
            if (!(toStoreKey.getParameters().length == 0)) {
                for (Object obj : toStoreKey.getParameters()) {
                    if ((obj instanceof String) || (obj instanceof Number)) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER + obj);
                    }
                }
            }
        }
        return toStoreKey.getClassName() + '-' + toStoreKey.getMemberName() + ((Object) sb);
    }
}
