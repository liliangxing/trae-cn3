package com.bytedance.upc.cache;

import android.util.Pair;
import com.bytedance.helios.statichook.api.ActionInvoker;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.mt.protector.ThrowableDisposer;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiActionInvoker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Ja\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013JY\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000b\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/upc/cache/ApiActionInvoker;", "Lcom/bytedance/helios/statichook/api/ActionInvoker;", "()V", "postInvoke", "", "id", "", PushClientConstants.TAG_CLASS_NAME, "", "memberName", "thisOrClass", "", "parameters", "", "result", "extraInfo", "Lcom/bytedance/helios/statichook/api/ExtraInfo;", "isOriginalCalled", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/Object;Lcom/bytedance/helios/statichook/api/ExtraInfo;Z)V", "preInvoke", "Lcom/bytedance/helios/statichook/api/Result;", ThrowableDisposer.ConfItem.RETURN_TYPE, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Lcom/bytedance/helios/statichook/api/ExtraInfo;)Lcom/bytedance/helios/statichook/api/Result;", com.bytedance.upc.BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ApiActionInvoker implements ActionInvoker {
    @Override // com.bytedance.helios.statichook.api.ActionInvoker
    public Result preInvoke(int id, String className, String memberName, Object thisOrClass, Object[] parameters, String returnType, ExtraInfo extraInfo) {
        Pair<Boolean, String> preHandle = ApiHookManager.preHandle(className, memberName, parameters);
        Object obj = preHandle.first;
        Intrinsics.checkExpressionValueIsNotNull(obj, "result.first");
        return new Result(((Boolean) obj).booleanValue(), preHandle.second);
    }

    @Override // com.bytedance.helios.statichook.api.ActionInvoker
    public void postInvoke(int id, String className, String memberName, Object thisOrClass, Object[] parameters, Object result, ExtraInfo extraInfo, boolean isOriginalCalled) {
        ApiHookManager.postHandle(className, memberName, parameters, result);
    }
}
