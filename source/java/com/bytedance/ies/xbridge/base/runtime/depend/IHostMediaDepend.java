package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ies.xbridge.base.runtime.model.XChooseMediaParams;
import kotlin.Metadata;

/* compiled from: IHostMediaDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMediaDepend;", "", "handleJsInvoke", "", "context", "Landroid/content/Context;", "params", "Lcom/bytedance/ies/xbridge/base/runtime/model/XChooseMediaParams;", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ies/xbridge/base/runtime/depend/IChooseMediaResultCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostMediaDepend {
    void handleJsInvoke(Context context, XChooseMediaParams params, IChooseMediaResultCallback callback);
}
