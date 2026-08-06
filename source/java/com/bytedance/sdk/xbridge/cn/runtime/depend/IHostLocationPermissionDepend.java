package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.Metadata;

/* compiled from: IHostPermissionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostLocationPermissionDepend;", "", "requestPermission", "", "activity", "Landroid/app/Activity;", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeName", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionGrantCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostLocationPermissionDepend {
    void requestPermission(Activity activity, IBDXBridgeContext bridgeContext, String bridgeName, OnPermissionGrantCallback callback);
}
