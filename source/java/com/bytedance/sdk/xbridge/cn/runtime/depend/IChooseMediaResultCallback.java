package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.runtime.model.XChooseMediaResults;
import kotlin.Metadata;

/* compiled from: IHostMediaDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IChooseMediaResultCallback;", "", "onFailure", "", "code", "", "msg", "", "onSuccess", "result", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/XChooseMediaResults;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IChooseMediaResultCallback {
    void onFailure(int code, String msg);

    void onSuccess(XChooseMediaResults result, String msg);

    /* compiled from: IHostMediaDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSuccess$default(IChooseMediaResultCallback iChooseMediaResultCallback, XChooseMediaResults xChooseMediaResults, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
            if ((i & 2) != 0) {
                str = "";
            }
            iChooseMediaResultCallback.onSuccess(xChooseMediaResults, str);
        }

        public static /* synthetic */ void onFailure$default(IChooseMediaResultCallback iChooseMediaResultCallback, int i, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
            }
            if ((i2 & 2) != 0) {
                str = "";
            }
            iChooseMediaResultCallback.onFailure(i, str);
        }
    }
}
