package com.bytedance.ies.xbridge.base.runtime.depend;

import kotlin.Metadata;

/* compiled from: IHostPermissionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/OnPermissionGrantCallback;", "", "onAllGranted", "", "onNotGranted", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface OnPermissionGrantCallback {
    void onAllGranted();

    void onNotGranted();
}
