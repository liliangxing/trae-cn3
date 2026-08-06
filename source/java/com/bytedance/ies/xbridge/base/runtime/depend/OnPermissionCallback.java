package com.bytedance.ies.xbridge.base.runtime.depend;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IHostPermissionDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/OnPermissionCallback;", "", "onResult", "", "allGranted", "", "result", "", "", "Lcom/bytedance/ies/xbridge/base/runtime/depend/PermissionState;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface OnPermissionCallback {
    void onResult(boolean allGranted, Map<String, ? extends PermissionState> result);
}
