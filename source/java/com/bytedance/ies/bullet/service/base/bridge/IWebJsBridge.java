package com.bytedance.ies.bullet.service.base.bridge;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IWebJsBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J-\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0014\"\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "", "checkJsEventEnable", "", "valueCallback", "Landroid/webkit/ValueCallback;", "getWebView", "Landroid/webkit/WebView;", "invokeJavaMethod", "url", "", "invokeJsCallback", "", "method", "Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "callBackId", "result", "Lorg/json/JSONObject;", "invokeJsMethod", "params", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "isSafeHost", "sendJsEvent", "event", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IWebJsBridge {
    boolean checkJsEventEnable(ValueCallback<Boolean> valueCallback);

    WebView getWebView();

    boolean invokeJavaMethod(String url);

    void invokeJsCallback(IGenericBridgeMethod method, String callBackId, JSONObject result);

    void invokeJsMethod(String method, String... params);

    boolean isSafeHost(String url);

    void sendJsEvent(String event, JSONObject params);
}
