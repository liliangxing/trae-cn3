package com.bytedance.sdk.xbridge.cn.platform.web.protocol;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.tracing.log.Fields;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: JSB3Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/protocol/JSB3Impl;", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeProtocol;", LynxBridgeCall.NAME_SPACE, "", "(Ljava/lang/String;)V", "TAG", "native2JsModuleName", "newJsNativeProtocol", "_invokeMethod", "message", "call", "bridgeName", "createBridgeCall", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeCall;", "msg", "createCallMsg", "Lorg/json/JSONObject;", "createCallbackJsStr", "obj", "createCallbackMessage", "data", "invoke", "", "onSetUp", "view", "Landroid/webkit/WebView;", "sendEvent", Fields.EVENT, "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JSB3Impl extends WebBridgeProtocol {

    @Deprecated
    public static final String BRIDGE_OBJECT_NAME = "JS2NativeBridge";
    private static final Companion Companion = new Companion(null);
    private final String TAG;
    private final String native2JsModuleName;
    private final String newJsNativeProtocol;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSB3Impl() {
        this(r0, 1, r0);
        String str = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSB3Impl(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, LynxBridgeCall.NAME_SPACE);
        this.TAG = "JSB3Impl";
        this.newJsNativeProtocol = "JSBridge";
        this.native2JsModuleName = "Native2JSBridge";
    }

    public /* synthetic */ JSB3Impl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    /* compiled from: JSB3Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/protocol/JSB3Impl$Companion;", "", "()V", "BRIDGE_OBJECT_NAME", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public WebBridgeCall createBridgeCall(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        JSONObject jSONObject = new JSONObject(msg);
        String optString = jSONObject.optString("func");
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String webViewUrlSync = getWebViewUrlSync();
        if (webViewUrlSync == null) {
            webViewUrlSync = "";
        }
        Intrinsics.checkNotNullExpressionValue(optString, "bridgeName");
        WebBridgeCall webBridgeCall = new WebBridgeCall(optString, optJSONObject, webViewUrlSync);
        String optString2 = jSONObject.optString("__callback_id");
        Intrinsics.checkNotNullExpressionValue(optString2, "obj.optString(\"__callback_id\")");
        webBridgeCall.setCallbackId(optString2);
        String optString3 = jSONObject.optString("__msg_type");
        Intrinsics.checkNotNullExpressionValue(optString3, "obj.optString(\"__msg_type\")");
        webBridgeCall.setMsgType(optString3);
        webBridgeCall.setTimestamp(jSONObject.optLong("__timestamp", System.currentTimeMillis()));
        String optString4 = jSONObject.optString("JSSDK");
        Intrinsics.checkNotNullExpressionValue(optString4, "obj.optString(\"JSSDK\")");
        webBridgeCall.setSdkVersion(optString4);
        String optString5 = jSONObject.optString(LynxBridgeCall.NAME_SPACE, getDefaultNameSpace());
        Intrinsics.checkNotNullExpressionValue(optString5, "obj.optString(\"namespace\", defaultNameSpace)");
        webBridgeCall.setNamespace(wrapHostNamespace$anniex_release(optString5));
        String optString6 = jSONObject.optString("__iframe_url");
        Intrinsics.checkNotNullExpressionValue(optString6, "obj.optString(\"__iframe_url\")");
        webBridgeCall.setFrameUrl(optString6);
        webBridgeCall.setAppId(Integer.valueOf(jSONObject.optInt("appID", 0)));
        webBridgeCall.setRawReq(msg);
        webBridgeCall.setWebAuthUrlType(getWebAuthUrlType());
        webBridgeCall.setProtocolVersion(OnekeyLoginConstants.TELECOM_TYPE);
        return webBridgeCall;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void onSetUp(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.addJavascriptInterface(this, BRIDGE_OBJECT_NAME);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public String createCallbackMessage(WebBridgeCall call, JSONObject data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__callback_id", call.getCallbackId());
            jSONObject.put("__params", data);
            jSONObject.put("__msg_type", "callback");
            return createCallbackJsStr(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 == null) {
                return "";
            }
            th2.printStackTrace();
            return "";
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void sendEvent(String event, JSONObject data) {
        Object obj;
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            if (data != null) {
                jSONObject.put("data", data);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", Fields.EVENT);
            jSONObject2.put("__event_id", event);
            jSONObject2.put("__callback_id", event);
            jSONObject2.put("__params", jSONObject);
            WebBridgeProtocol.evaluateJavaScript$default(this, createCallbackJsStr(jSONObject2), null, 2, null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            Log.e(this.TAG, "parse event failed,reason=" + th2.getMessage());
        }
    }

    static /* synthetic */ String createCallbackJsStr$default(JSB3Impl jSB3Impl, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = null;
        }
        return jSB3Impl.createCallbackJsStr(jSONObject);
    }

    private final String createCallbackJsStr(JSONObject obj) {
        return "javascript:if(window." + this.newJsNativeProtocol + " && window." + this.newJsNativeProtocol + "._handleMessageFromApp){ window." + this.newJsNativeProtocol + " && window." + this.newJsNativeProtocol + "._handleMessageFromApp(" + obj + ")} else if(window." + this.native2JsModuleName + " && window." + this.native2JsModuleName + "._handleMessageFromApp){ window." + this.native2JsModuleName + " && window." + this.native2JsModuleName + "._handleMessageFromApp(" + obj + ")}";
    }

    @JavascriptInterface
    public final String call(String bridgeName, String message) {
        invoke(bridgeName, message);
        return null;
    }

    @JavascriptInterface
    public final String _invokeMethod(String message) {
        invoke(null, message);
        return null;
    }

    private final void invoke(String bridgeName, String message) {
        try {
            handleJSMessage(createCallMsg(bridgeName, message).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final JSONObject createCallMsg(String bridgeName, String message) {
        Intrinsics.checkNotNull(message);
        JSONObject jSONObject = new JSONObject(message);
        if (jSONObject.opt("func") == null) {
            String optString = jSONObject.optString(LynxBridgeCall.NAME_SPACE, "");
            Intrinsics.checkNotNullExpressionValue(optString, "msg.optString(\"namespace\", \"\")");
            if (!(optString.length() == 0)) {
                bridgeName = jSONObject.optString(LynxBridgeCall.NAME_SPACE, "") + '.' + bridgeName;
            }
            jSONObject.put("func", bridgeName);
        }
        return jSONObject;
    }
}
