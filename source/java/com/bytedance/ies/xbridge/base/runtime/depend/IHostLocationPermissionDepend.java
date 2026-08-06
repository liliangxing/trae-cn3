package com.bytedance.ies.xbridge.base.runtime.depend;

import android.app.Activity;
import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;

/* compiled from: IHostPermissionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostLocationPermissionDepend;", "", "requestPermission", "", "activity", "Landroid/app/Activity;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/xbridge/base/runtime/depend/OnPermissionGrantCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostLocationPermissionDepend {
    void requestPermission(Activity activity, OnPermissionGrantCallback callback);
}
