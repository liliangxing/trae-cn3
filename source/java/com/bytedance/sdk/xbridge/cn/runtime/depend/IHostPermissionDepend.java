package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.Metadata;

/* compiled from: IHostPermissionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH&¢\u0006\u0002\u0010\tJA\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDepend;", "", "isPermissionAllGranted", "", "context", "Landroid/content/Context;", "permission", "", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "requestPermission", "", "activity", "Landroid/app/Activity;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeName", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionCallback;", "(Landroid/app/Activity;Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;Ljava/lang/String;[Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionCallback;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostPermissionDepend {
    boolean isPermissionAllGranted(Context context, String... permission);

    void requestPermission(Activity activity, IBDXBridgeContext bridgeContext, String bridgeName, String[] permission, OnPermissionCallback callback);
}
