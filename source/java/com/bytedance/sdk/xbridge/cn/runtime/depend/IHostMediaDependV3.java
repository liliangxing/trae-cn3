package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.bytedance.android.anniex.ability.service.IAnnieXActivityResult;
import com.bytedance.sdk.xbridge.cn.runtime.model.XChooseMediaParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostMediaDependV3.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDependV3;", "", "handleJsInvoke", "", "context", "Landroid/content/Context;", "params", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/XChooseMediaParams;", "callback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IChooseMediaResultCallback;", "outerActivityResult", "Lcom/bytedance/android/anniex/ability/service/IAnnieXActivityResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHostMediaDependV3 {
    void handleJsInvoke(Context context, XChooseMediaParams params, IChooseMediaResultCallback callback, IAnnieXActivityResult outerActivityResult);

    /* compiled from: IHostMediaDependV3.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static void handleJsInvoke(IHostMediaDependV3 iHostMediaDependV3, Context context, XChooseMediaParams xChooseMediaParams, IChooseMediaResultCallback iChooseMediaResultCallback, IAnnieXActivityResult iAnnieXActivityResult) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(xChooseMediaParams, "params");
            Intrinsics.checkNotNullParameter(iChooseMediaResultCallback, "callback");
        }

        public static /* synthetic */ void handleJsInvoke$default(IHostMediaDependV3 iHostMediaDependV3, Context context, XChooseMediaParams xChooseMediaParams, IChooseMediaResultCallback iChooseMediaResultCallback, IAnnieXActivityResult iAnnieXActivityResult, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleJsInvoke");
            }
            if ((i & 8) != 0) {
                iAnnieXActivityResult = null;
            }
            iHostMediaDependV3.handleJsInvoke(context, xChooseMediaParams, iChooseMediaResultCallback, iAnnieXActivityResult);
        }
    }
}
