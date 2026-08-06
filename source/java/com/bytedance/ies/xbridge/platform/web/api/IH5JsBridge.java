package com.bytedance.ies.xbridge.platform.web.api;

import com.bytedance.ies.web.jsbridge.IJavaMethod;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IH5JsBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/xbridge/platform/web/api/IH5JsBridge;", "", "invokeJsCallback", "", "callBackId", "", "result", "Lorg/json/JSONObject;", "registerJavaMethod", "method", "func", "Lcom/bytedance/ies/web/jsbridge/IJavaMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IH5JsBridge {
    void invokeJsCallback(String callBackId, JSONObject result);

    Object registerJavaMethod(String method, IJavaMethod func);
}
