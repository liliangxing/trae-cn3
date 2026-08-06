package com.bytedance.ies.bullet.kit.web.jsbridge;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.LruCache;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import bolts.Task;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.web.jsbridge.MonitorModel;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.web.jsbridge.IESJsBridge;
import com.bytedance.ies.web.jsbridge.hook.ISendMsgHook;
import com.bytedance.ies.web.jsbridge.hook.Js2MsgData;
import com.bytedance.ies.web.jsbridge2.CallbackHook;
import com.bytedance.ies.web.jsbridge2.ISafeWebView;
import com.bytedance.ies.web.jsbridge2.Js2JavaCall;
import com.bytedance.ies.web.jsbridge2.JsBridge2;
import com.bytedance.ies.web.jsbridge2.XBridgeSupport;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.push.interfaze.ISignalReportService;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: JSB4Support.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0007J\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0010\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\nJ \u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\n2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010+J \u0010,\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\n2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010+H\u0002J \u0010-\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\nJ\n\u00101\u001a\u0004\u0018\u00010\nH\u0002J.\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u00010$2\b\u00105\u001a\u0004\u0018\u00010$2\b\u00106\u001a\u0004\u0018\u00010$H\u0002J\u000e\u00107\u001a\u00020\u001e2\u0006\u0010#\u001a\u000208J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$J\u0016\u0010;\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/JSB4Support;", "", "webView", "Landroid/webkit/WebView;", "jsBridge2", "Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "iesJsBridge", "Lcom/bytedance/ies/web/jsbridge/IESJsBridge;", "(Landroid/webkit/WebView;Lcom/bytedance/ies/web/jsbridge2/JsBridge2;Lcom/bytedance/ies/web/jsbridge/IESJsBridge;)V", "channel", "", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "hostAid", "getHostAid", "setHostAid", "getIesJsBridge", "()Lcom/bytedance/ies/web/jsbridge/IESJsBridge;", "getJsBridge2", "()Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "monitorPool", "Landroid/util/LruCache;", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/MonitorModel$Builder;", "getWebView", "()Landroid/webkit/WebView;", "xBridgeSupport", "Lcom/bytedance/ies/web/jsbridge2/XBridgeSupport;", "_invokeMethod", "", "invocation", "callbackToFront", "call", "Lcom/bytedance/ies/web/jsbridge2/Js2JavaCall;", "data", "Lorg/json/JSONObject;", "createCallbackMessage", "createJsb2Call", "msg", "evaluateJavaScript", "url", "callback", "Landroid/webkit/ValueCallback;", "evaluateJavaScriptInternal", SccResult.MESSAGE_FAIL, "code", "", "message", "getUrl", "monitorEvent", SchemaConstants.INNER_PARAM_EVENT_NAME, "category", "metric", "logExtra", "report", "Lcom/bytedance/ies/bullet/kit/web/jsbridge/MonitorModel;", "sendEvent", ISignalReportService.BODY_KEY_EVENT, "success", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JSB4Support {

    @Deprecated
    public static final String BRIDGE_OBJECT_NAME = "BDXBridge";
    private static final Companion Companion = new Companion(null);
    private static final String SERVICE_NAME = "bdxbridge_performance";

    @Deprecated
    public static final String jsb4_type = "bdxbridge";
    private String channel;
    private String hostAid;
    private final IESJsBridge iesJsBridge;
    private final JsBridge2 jsBridge2;
    private final LruCache<String, MonitorModel.Builder> monitorPool;
    private final WebView webView;
    private final XBridgeSupport xBridgeSupport;

    public JSB4Support(WebView webView, JsBridge2 jsBridge2, IESJsBridge iESJsBridge) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
        this.jsBridge2 = jsBridge2;
        this.iesJsBridge = iESJsBridge;
        XBridgeSupport xBridgeSupport = new XBridgeSupport();
        this.xBridgeSupport = xBridgeSupport;
        this.monitorPool = new LruCache<>(64);
        webView.addJavascriptInterface(this, BRIDGE_OBJECT_NAME);
        xBridgeSupport.setJsBridge2(jsBridge2);
        this.hostAid = BulletEnv.INSTANCE.getInstance().getAppId();
        this.channel = BulletEnv.INSTANCE.getInstance().getChannel();
    }

    /* compiled from: JSB4Support.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/jsbridge/JSB4Support$Companion;", "", "()V", "BRIDGE_OBJECT_NAME", "", "SERVICE_NAME", "jsb4_type", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final IESJsBridge getIesJsBridge() {
        return this.iesJsBridge;
    }

    public final JsBridge2 getJsBridge2() {
        return this.jsBridge2;
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final String getHostAid() {
        return this.hostAid;
    }

    public final void setHostAid(String str) {
        this.hostAid = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        this.channel = str;
    }

    public final Js2JavaCall createJsb2Call(String msg) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(msg);
        String url = getUrl();
        String string = jSONObject.getString("__msg_type");
        Intrinsics.checkNotNullExpressionValue(string, "request.getString(\"__msg_type\")");
        String string2 = jSONObject.getString("params");
        Intrinsics.checkNotNullExpressionValue(string2, "request.getString(\"params\")");
        String string3 = jSONObject.getString("JSSDK");
        Intrinsics.checkNotNullExpressionValue(string3, "request.getString(\"JSSDK\")");
        String optString = jSONObject.optString("namespace", "");
        Intrinsics.checkNotNullExpressionValue(optString, "request.optString(\"namespace\", \"\")");
        String optString2 = jSONObject.optString("__iframe_url");
        Intrinsics.checkNotNullExpressionValue(optString2, "request.optString(\"__iframe_url\")");
        String str = jsb4_type + jSONObject.optString("__callback_id");
        String optString3 = jSONObject.optString("func");
        long optLong = jSONObject.optLong("__timestamp", System.currentTimeMillis());
        int i = 0;
        boolean optBoolean = jSONObject.optBoolean("shouldHook", false);
        MonitorModel.Builder builder = new MonitorModel.Builder(jsb4_type);
        builder.setRequestDecodeDuration(System.currentTimeMillis() - currentTimeMillis);
        builder.setRequestSendTimestamp(optLong);
        builder.setRequestReceiveTimestamp(currentTimeMillis);
        builder.setRequestDuration();
        if (msg != null) {
            byte[] bytes = msg.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            if (bytes != null) {
                i = bytes.length;
            }
        }
        builder.setRequestDataLength(i);
        Intrinsics.checkNotNullExpressionValue(optString3, "bridgeName");
        builder.setMethod(optString3);
        if (url == null) {
            url = "";
        }
        builder.setURL(url);
        builder.setAppID(String.valueOf(this.hostAid));
        this.monitorPool.put(str, builder);
        Js2JavaCall build = Js2JavaCall.builder().setVersion(string3).setType(string).setMethodName(optString3).setParams(string2).setCallbackId(str).setNamespace(optString).setIFrameUrl(optString2).shouldHook(Boolean.valueOf(optBoolean)).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder()\n            .s…ook)\n            .build()");
        return build;
    }

    public final String createCallbackMessage(Js2JavaCall call, JSONObject data) {
        String str;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObject = new JSONObject();
        String str2 = call.callbackId;
        Intrinsics.checkNotNullExpressionValue(str2, "call.callbackId");
        if (StringsKt.startsWith$default(str2, jsb4_type, false, 2, (Object) null)) {
            String str3 = call.callbackId;
            Intrinsics.checkNotNullExpressionValue(str3, "call.callbackId");
            str = str3.substring(9);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
        } else {
            str = call.callbackId;
        }
        jSONObject.put("__msg_type", "callback");
        jSONObject.put("__callback_id", str);
        jSONObject.put("__params", data);
        jSONObject.put("__timestamp", System.currentTimeMillis());
        jSONObject.put("__sdk_version", "4.0");
        if (!TextUtils.isEmpty(call.iFrameUrl)) {
            String str4 = call.iFrameUrl;
            Intrinsics.checkNotNullExpressionValue(str4, "call.iFrameUrl");
            byte[] bytes = str4.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(iFrameUrl…eArray(), Base64.NO_WRAP)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("iframe[src=\"%s\"", Arrays.copyOf(new Object[]{str4}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Charset charset = Charsets.UTF_8;
            if (format != null) {
                byte[] bytes2 = format.getBytes(charset);
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
        return "javascript:BDXBridge._handleMessageFromApp(" + jSONObject + ')';
    }

    public final void sendEvent(String event, JSONObject data) {
        Object obj;
        JSONObject put;
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            if (data != null) {
                put = new JSONObject(data.toString());
                if (!put.has("code")) {
                    put.put("code", 1);
                }
            } else {
                put = new JSONObject().put("code", 1);
            }
            jSONObject.put("__msg_type", ISignalReportService.BODY_KEY_EVENT);
            jSONObject.put("__event_id", event);
            jSONObject.put("__params", put);
            jSONObject.put("__timestamp", System.currentTimeMillis());
            jSONObject.put("__sdk_version", "4.0");
            evaluateJavaScript$default(this, "javascript:window.BDXBridge && BDXBridge._handleMessageFromApp && BDXBridge._handleMessageFromApp(" + jSONObject + ')', null, 2, null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            Log.e("JSB4Support", "parse event failed,reason=" + th2.getMessage());
        }
    }

    public final void callbackToFront(final Js2JavaCall call, JSONObject data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        evaluateJavaScript(createCallbackMessage(call, data), new ValueCallback() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.JSB4Support$callbackToFront$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String str) {
                Object obj;
                LruCache lruCache;
                LruCache lruCache2;
                if (str == null || str.equals("null")) {
                    return;
                }
                JSB4Support jSB4Support = JSB4Support.this;
                Js2JavaCall js2JavaCall = call;
                try {
                    Result.Companion companion = Result.Companion;
                    JSONObject jSONObject = new JSONObject(str);
                    lruCache = jSB4Support.monitorPool;
                    MonitorModel.Builder builder = (MonitorModel.Builder) lruCache.get(js2JavaCall.callbackId);
                    if (builder != null) {
                        Intrinsics.checkNotNullExpressionValue(builder, "builder");
                        builder.setResponseReceiveTimestamp(jSONObject.optLong("__timestamp"));
                        builder.setResponseDuration();
                        builder.setDuration();
                        byte[] bytes = str.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        builder.setResponseDataLength(bytes.length);
                        builder.setContainerType("h5");
                        String channel = jSB4Support.getChannel();
                        if (channel != null) {
                            builder.setChannel(channel);
                        }
                    }
                    jSB4Support.report(builder.build());
                    lruCache2 = jSB4Support.monitorPool;
                    obj = Result.constructor-impl((MonitorModel.Builder) lruCache2.remove(js2JavaCall.callbackId));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    th2.printStackTrace();
                }
            }
        });
    }

    public static /* synthetic */ void fail$default(JSB4Support jSB4Support, Js2JavaCall js2JavaCall, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        jSB4Support.fail(js2JavaCall, i, str);
    }

    public final void fail(Js2JavaCall call, int code, String message) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("msg", message);
        Unit unit = Unit.INSTANCE;
        callbackToFront(call, jSONObject);
    }

    public final void success(Js2JavaCall call, JSONObject data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        evaluateJavaScript$default(this, createCallbackMessage(call, data), null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void evaluateJavaScript$default(JSB4Support jSB4Support, String str, ValueCallback valueCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            valueCallback = null;
        }
        jSB4Support.evaluateJavaScript(str, valueCallback);
    }

    public final void evaluateJavaScript(final String url, final ValueCallback<String> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            evaluateJavaScriptInternal(url, callback);
        } else {
            this.webView.post(new Runnable() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.JSB4Support$evaluateJavaScript$1
                @Override // java.lang.Runnable
                public final void run() {
                    JSB4Support.this.evaluateJavaScriptInternal(url, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void evaluateJavaScriptInternal(String url, ValueCallback<String> callback) {
        this.webView.evaluateJavascript(url, callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getUrl() {
        WebView webView = this.webView;
        if (webView instanceof ISafeWebView) {
            Intrinsics.checkNotNull(webView, "null cannot be cast to non-null type com.bytedance.ies.web.jsbridge2.ISafeWebView");
            String safeUrl = ((ISafeWebView) webView).getSafeUrl();
            return TextUtils.isEmpty(safeUrl) ? this.webView.getUrl() : safeUrl;
        }
        return webView.getUrl();
    }

    @JavascriptInterface
    public final void _invokeMethod(String invocation) {
        final Js2JavaCall createJsb2Call = createJsb2Call(invocation);
        this.xBridgeSupport.invoke(createJsb2Call);
        this.xBridgeSupport.setCallbackHook(new CallbackHook() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.JSB4Support$_invokeMethod$1
            @Override // com.bytedance.ies.web.jsbridge2.CallbackHook
            public final void onBridgeReject(Js2JavaCall js2JavaCall, int i) {
                if (i == 1) {
                    JSB4Support jSB4Support = JSB4Support.this;
                    Intrinsics.checkNotNullExpressionValue(js2JavaCall, "call");
                    JSB4Support.fail$default(jSB4Support, js2JavaCall, -1, null, 4, null);
                } else {
                    JSB4Support jSB4Support2 = JSB4Support.this;
                    Intrinsics.checkNotNullExpressionValue(js2JavaCall, "call");
                    JSB4Support.fail$default(jSB4Support2, js2JavaCall, -2, null, 4, null);
                }
            }
        });
        IESJsBridge iESJsBridge = this.iesJsBridge;
        if (iESJsBridge != null) {
            iESJsBridge.setHook(new ISendMsgHook() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.JSB4Support$_invokeMethod$2
                @Override // com.bytedance.ies.web.jsbridge.hook.ISendMsgHook
                public final Js2MsgData beforeSendJsMsg(String str, JSONObject jSONObject, int i) {
                    if (i == 1 && str != null && StringsKt.startsWith$default(str, JSB4Support.jsb4_type, false, 2, (Object) null)) {
                        String substring = str.substring(9);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                        JSB4Support jSB4Support = JSB4Support.this;
                        Js2JavaCall js2JavaCall = createJsb2Call;
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "result");
                        jSB4Support.success(js2JavaCall, jSONObject);
                        return new Js2MsgData(substring, jSONObject);
                    }
                    if (i != 2) {
                        return null;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("jsMsg");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("callback_id");
                        Intrinsics.checkNotNullExpressionValue(optString, "callbackId");
                        if (StringsKt.startsWith$default(optString, JSB4Support.jsb4_type, false, 2, (Object) null)) {
                            String substring2 = optString.substring(9);
                            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                            optJSONObject.put("callback_id", substring2);
                        }
                    }
                    JSB4Support jSB4Support2 = JSB4Support.this;
                    Intrinsics.checkNotNullExpressionValue(str, "id");
                    jSB4Support2.sendEvent(str, jSONObject);
                    return null;
                }
            });
        }
    }

    public final void report(MonitorModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("code", data.getCode());
        jSONObject.put("app_id", data.getAppID());
        jSONObject.put("url", data.getUrl());
        jSONObject.put("channel", data.getChannel());
        jSONObject.put("method", data.getMethod());
        jSONObject.put("container_type", data.getContainerType());
        jSONObject.put("protocol_version", data.getProtocolVersion());
        jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, data.getDuration());
        jSONObject2.put("request_data_length", data.getRequest_data_length());
        jSONObject2.put("request_send_timestamp", data.getRequest_send_timestamp());
        jSONObject2.put("request_receive_timestamp", data.getRequest_receive_timestamp());
        jSONObject2.put("request_decode_duration", data.getRequest_decode_duration());
        jSONObject2.put("request_duration", data.getRequest_duration());
        jSONObject2.put("response_data_length", data.getResponse_data_length());
        jSONObject2.put("response_send_timestamp", data.getResponse_send_timestamp());
        jSONObject2.put("response_receive_timestamp", data.getResponse_receive_timestamp());
        jSONObject2.put("response_encode_duration", data.getResponse_encode_duration());
        jSONObject2.put("response_duration", data.getResponse_duration());
        monitorEvent(SERVICE_NAME, jSONObject, jSONObject2, null);
    }

    private final void monitorEvent(String eventName, JSONObject category, JSONObject metric, JSONObject logExtra) {
        final ReportInfo reportInfo = new ReportInfo(eventName, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setUrl(category != null ? category.optString(reportInfo.getUrl()) : null);
        reportInfo.setCategory(category);
        reportInfo.setMetrics(metric);
        reportInfo.setExtra(logExtra);
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.kit.web.jsbridge.JSB4Support$monitorEvent$1
            @Override // java.util.concurrent.Callable
            public final Unit call() {
                IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(IMonitorReportService.class);
                if (iMonitorReportService == null) {
                    return null;
                }
                iMonitorReportService.report(ReportInfo.this);
                return Unit.INSTANCE;
            }
        });
    }
}
