package com.bytedance.sdk.xbridge.cn.platform.web.protocol;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeCall;
import com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol;
import com.bytedance.tracing.log.Fields;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: JSB2Impl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/protocol/JSB2Impl;", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeProtocol;", LynxBridgeCall.NAME_SPACE, "", "(Ljava/lang/String;)V", "createBridgeCall", "Lcom/bytedance/sdk/xbridge/cn/platform/web/WebBridgeCall;", "msg", "createCallbackMessage", "call", "data", "Lorg/json/JSONObject;", "invokeMethod", "", "invocation", "onSetUp", "view", "Landroid/webkit/WebView;", "sendEvent", Fields.EVENT, "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class JSB2Impl extends WebBridgeProtocol {

    @Deprecated
    public static final String BRIDGE_OBJECT_NAME = "ToutiaoJSBridge";
    private static final Companion Companion = new Companion(null);

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSB2Impl() {
        this(r0, 1, r0);
        String str = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSB2Impl(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, LynxBridgeCall.NAME_SPACE);
    }

    public /* synthetic */ JSB2Impl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    /* compiled from: JSB2Impl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/platform/web/protocol/JSB2Impl$Companion;", "", "()V", "BRIDGE_OBJECT_NAME", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void onSetUp(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.addJavascriptInterface(this, BRIDGE_OBJECT_NAME);
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public WebBridgeCall createBridgeCall(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        JSONObject jSONObject = new JSONObject(msg);
        String optString = jSONObject.optString("func");
        String webViewUrlSync = getWebViewUrlSync();
        if (webViewUrlSync == null) {
            webViewUrlSync = "";
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        Intrinsics.checkNotNullExpressionValue(optString, "bridgeName");
        WebBridgeCall webBridgeCall = new WebBridgeCall(optString, optJSONObject, webViewUrlSync);
        String optString2 = jSONObject.optString("__callback_id");
        Intrinsics.checkNotNullExpressionValue(optString2, "request.optString(\"__callback_id\")");
        webBridgeCall.setCallbackId(optString2);
        String optString3 = jSONObject.optString("__msg_type");
        Intrinsics.checkNotNullExpressionValue(optString3, "request.optString(\"__msg_type\")");
        webBridgeCall.setMsgType(optString3);
        webBridgeCall.setTimestamp(jSONObject.optLong("__timestamp", System.currentTimeMillis()));
        String optString4 = jSONObject.optString("JSSDK");
        Intrinsics.checkNotNullExpressionValue(optString4, "request.optString(\"JSSDK\")");
        webBridgeCall.setSdkVersion(optString4);
        String optString5 = jSONObject.optString(LynxBridgeCall.NAME_SPACE, getDefaultNameSpace());
        Intrinsics.checkNotNullExpressionValue(optString5, "request.optString(\"namespace\", defaultNameSpace)");
        webBridgeCall.setNamespace(wrapHostNamespace$anniex_release(optString5));
        String optString6 = jSONObject.optString("__iframe_url");
        Intrinsics.checkNotNullExpressionValue(optString6, "request.optString(\"__iframe_url\")");
        webBridgeCall.setFrameUrl(optString6);
        webBridgeCall.setRawReq(msg);
        webBridgeCall.setAppId(Integer.valueOf(jSONObject.optInt("appID", 0)));
        webBridgeCall.setWebAuthUrlType(getWebAuthUrlType());
        webBridgeCall.setProtocolVersion(OnekeyLoginConstants.UNICOM_TYPE);
        return webBridgeCall;
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public String createCallbackMessage(WebBridgeCall call, JSONObject data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__callback_id", call.getCallbackId());
        jSONObject.put("__params", data);
        jSONObject.put("__msg_type", "callback");
        if (!TextUtils.isEmpty(call.getFrameUrl())) {
            String frameUrl = call.getFrameUrl();
            Charset charset = Charsets.UTF_8;
            if (frameUrl == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = frameUrl.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(iFrameUrl…eArray(), Base64.NO_WRAP)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{frameUrl}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Charset charset2 = Charsets.UTF_8;
            if (format != null) {
                byte[] bytes2 = format.getBytes(charset2);
                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                String encodeToString2 = Base64.encodeToString(bytes2, 2);
                Intrinsics.checkNotNullExpressionValue(encodeToString2, "encodeToString(\n        …e64.NO_WRAP\n            )");
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Arrays.copyOf(new Object[]{encodeToString2, jSONObject, encodeToString}, 3));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                return format2;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.platform.web.WebBridgeProtocol
    public void sendEvent(String event, JSONObject data) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            jSONObject.put("__msg_type", Fields.EVENT);
            jSONObject.put("__event_id", event);
            jSONObject.put("__params", data);
            WebBridgeProtocol.evaluateJavaScript$default(this, "javascript:window.ToutiaoJSBridge && ToutiaoJSBridge._handleMessageFromToutiao && ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject + ')', null, 2, null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable th2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
            if (th2 != null) {
                Log.e("JSB2Impl", "parse event failed,reason=" + th2.getMessage());
            }
        }
    }

    @JavascriptInterface
    public final void invokeMethod(String invocation) {
        handleJSMessage(invocation);
    }
}
