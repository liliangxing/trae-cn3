package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.AbsHybridViewLazy;
import com.bytedance.ies.web.jsbridge2.CallHandler;
import com.bytedance.ies.web.jsbridge2.IGlobalBridgeInterceptor;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.push.interfaze.ISignalReportService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbstractBridge {
    private static final Pattern ILLEGAL_CALLBACK_ID_MATCHER = Pattern.compile("^[0-9a-zA-Z.]+$");
    private String bizKey;
    CallHandler callHandler;
    protected Context context;
    protected DataConverterActual dataConverterActual;
    protected AbsHybridViewLazy hybridViewLazy;
    IMethodWithNamespaceInvocationListener invocationListener;
    protected List<TimeLineEvent> jsbInstanceTimeLineEvents;
    protected Set<IMethodInvocationListener> methodInvocationListeners;
    protected String namespace;
    protected Handler mainHandler = new Handler(Looper.getMainLooper());
    protected volatile boolean released = false;
    private final Map<String, CallHandler> externalHandlers = new HashMap();
    private final IGlobalBridgeInterceptor.GlobalBridgeInterceptorCallback globalBridgeInterceptorCallback = new IGlobalBridgeInterceptor.GlobalBridgeInterceptorCallback() { // from class: com.bytedance.ies.web.jsbridge2.AbstractBridge.1
        @Override // com.bytedance.ies.web.jsbridge2.IGlobalBridgeInterceptor.GlobalBridgeInterceptorCallback
        public void invokeJsCallback(String str, Js2JavaCall js2JavaCall) {
            AbstractBridge.this.finishCall(str, js2JavaCall);
        }

        @Override // com.bytedance.ies.web.jsbridge2.IGlobalBridgeInterceptor.GlobalBridgeInterceptorCallback
        public void invokeOrigin(Js2JavaCall js2JavaCall) {
            AbstractBridge.this.handleCall(js2JavaCall, false);
        }

        @Override // com.bytedance.ies.web.jsbridge2.IGlobalBridgeInterceptor.GlobalBridgeInterceptorCallback
        public <T> void sendJsEvent(String str, T t) {
            AbstractBridge.this.sendJsEvent(str, t);
        }
    };

    protected abstract Context getContext(Environment environment);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getUrl();

    protected abstract void init(Environment environment);

    protected abstract void invokeJs(String str);

    public String getBizKey() {
        String str = this.bizKey;
        return (str == null || str.isEmpty()) ? "host" : this.bizKey;
    }

    protected void invokeJs(JSONObject jSONObject) {
        invokeJs(jSONObject.toString());
    }

    public View getHybridView() {
        return this.hybridViewLazy.getHybridView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeMethod(final String str) {
        if (this.released) {
            return;
        }
        final TimeLineEvent build = TimeLineEvent.Builder.instance().setTime().setLabel(TimeLineEvent.Constants.LABEL_PRE_CALL_ORIGIN_URL).build();
        DebugUtil.m65i("Received call: " + str);
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.AbstractBridge.2
            @Override // java.lang.Runnable
            public void run() {
                Js2JavaCall js2JavaCall;
                if (AbstractBridge.this.released) {
                    return;
                }
                try {
                    js2JavaCall = AbstractBridge.this.createCall(new JSONObject(str));
                } catch (JSONException e) {
                    DebugUtil.m64e("Exception thrown while parsing function.", e);
                    js2JavaCall = null;
                }
                if (js2JavaCall != null) {
                    js2JavaCall.jsbCallTimeLineEvents.add(build);
                }
                if (!Js2JavaCall.isInvalid(js2JavaCall)) {
                    AbstractBridge.this.invokeMethodInternal(js2JavaCall);
                    return;
                }
                DebugUtil.m65i("By pass invalid call: " + js2JavaCall);
                if (js2JavaCall != null) {
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.VALUE, str).setExtraItem(TimeLineEvent.Constants.REASON, TimeLineEvent.Constants.REASON_CALL_INVALID_1).bind(TimeLineEvent.Constants.LABEL_ABSTRACT_BRIDGE_REJECT, js2JavaCall.jsbCallTimeLineEvents);
                    AbstractBridge abstractBridge = AbstractBridge.this;
                    abstractBridge.callbackCallRejected(abstractBridge.getUrl(), js2JavaCall.methodName, 3, TimeLineEvent.Constants.REASON_CALL_INVALID_1, js2JavaCall.jsbCallTimeLineEvents);
                    AbstractBridge.this.finishCall(SerializeHelper.getErrorResponse(new JsBridgeException(js2JavaCall.code, "Failed to parse invocation.")), js2JavaCall);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeMethodInternal(Js2JavaCall js2JavaCall) {
        IMethodWithNamespaceInvocationListener iMethodWithNamespaceInvocationListener;
        IGlobalBridgeInterceptor iGlobalBridgeInterceptor = JsBridge2.globalBridgeInterceptor.get();
        if (iGlobalBridgeInterceptor != null && iGlobalBridgeInterceptor.shouldIntercept(this.hybridViewLazy.getHybridView(), getUrl(), js2JavaCall)) {
            iGlobalBridgeInterceptor.intercept(this.hybridViewLazy.getHybridView(), getUrl(), js2JavaCall, this.globalBridgeInterceptorCallback);
        } else {
            handleCall(js2JavaCall);
        }
        if (js2JavaCall == null || TextUtils.isEmpty(js2JavaCall.namespace) || (iMethodWithNamespaceInvocationListener = this.invocationListener) == null) {
            return;
        }
        iMethodWithNamespaceInvocationListener.onInvoke(js2JavaCall.namespace, js2JavaCall.methodName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeMethod(final Js2JavaCall js2JavaCall) {
        if (this.released) {
            return;
        }
        final TimeLineEvent build = TimeLineEvent.Builder.instance().setTime().setLabel(TimeLineEvent.Constants.LABEL_PRE_CALL_ORIGIN_URL).build();
        this.mainHandler.post(new Runnable() { // from class: com.bytedance.ies.web.jsbridge2.AbstractBridge.3
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractBridge.this.released) {
                    return;
                }
                Js2JavaCall js2JavaCall2 = js2JavaCall;
                if (js2JavaCall2 != null) {
                    js2JavaCall2.jsbCallTimeLineEvents.add(build);
                }
                if (!Js2JavaCall.isInvalid(js2JavaCall)) {
                    AbstractBridge.this.invokeMethodInternal(js2JavaCall);
                    return;
                }
                DebugUtil.m65i("By pass invalid call: " + js2JavaCall);
                if (js2JavaCall != null) {
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REASON, TimeLineEvent.Constants.REASON_CALL_INVALID_2).bind(TimeLineEvent.Constants.LABEL_ABSTRACT_BRIDGE_REJECT, js2JavaCall.jsbCallTimeLineEvents);
                    AbstractBridge abstractBridge = AbstractBridge.this;
                    abstractBridge.callbackCallRejected(abstractBridge.getUrl(), js2JavaCall.methodName, 3, TimeLineEvent.Constants.REASON_CALL_INVALID_2, js2JavaCall.jsbCallTimeLineEvents);
                    AbstractBridge.this.finishCall(SerializeHelper.getErrorResponse(new JsBridgeException(js2JavaCall.code, "Failed to parse invocation.")), js2JavaCall);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeJsCallback(String str, Js2JavaCall js2JavaCall) {
        invokeJs(str);
    }

    protected void invokeJsCallback(JSONObject jSONObject, Js2JavaCall js2JavaCall) {
        invokeJsCallback(jSONObject.toString(), js2JavaCall);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release() {
        this.callHandler.release();
        Iterator<CallHandler> it = this.externalHandlers.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.mainHandler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void handleCall(Js2JavaCall js2JavaCall) {
        handleCall(js2JavaCall, true);
    }

    protected final void handleCall(Js2JavaCall js2JavaCall, boolean z) {
        String url;
        if (this.released) {
            return;
        }
        if (js2JavaCall.safeV1AuthUrl == null || js2JavaCall.safeV1AuthUrl.isEmpty()) {
            url = getUrl();
        } else {
            url = js2JavaCall.safeV1AuthUrl;
        }
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.URL, url == null ? TimeLineEvent.Constants.NULL : url).bind(TimeLineEvent.Constants.LABEL_CALL_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
        if (url == null) {
            return;
        }
        CallHandler callHandlerWithNamespace = getCallHandlerWithNamespace(js2JavaCall.namespace);
        if (callHandlerWithNamespace == null) {
            DebugUtil.m66w("Received call with unknown namespace, " + js2JavaCall);
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REASON, TimeLineEvent.Constants.REASON_UNKNOWN_NAMESPACE).bind(TimeLineEvent.Constants.LABEL_ABSTRACT_BRIDGE_REJECT, js2JavaCall.jsbCallTimeLineEvents);
            callbackCallRejected(getUrl(), js2JavaCall.methodName, 2, TimeLineEvent.Constants.REASON_UNKNOWN_NAMESPACE, js2JavaCall.jsbCallTimeLineEvents);
            callbackRejected(js2JavaCall, 2);
            finishCall(SerializeHelper.getErrorResponse(new JsBridgeException(-4, "Namespace " + js2JavaCall.namespace + " unknown.")), js2JavaCall);
            return;
        }
        CallContext callContext = new CallContext();
        callContext.url = url;
        callContext.context = this.context;
        callContext.callHandler = callHandlerWithNamespace;
        callContext.hybridView = this.hybridViewLazy.getHybridView();
        callContext.needCheckPermission = z;
        callContext.bizKey = this.bizKey;
        try {
            CallHandler.CallResult handleJsCallJava = callHandlerWithNamespace.handleJsCallJava(js2JavaCall, callContext);
            if (handleJsCallJava == null) {
                DebugUtil.m66w("Received call but not registered, " + js2JavaCall);
                TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REASON, isNotRegisterByRelease()).bind(TimeLineEvent.Constants.LABEL_ABSTRACT_BRIDGE_REJECT, js2JavaCall.jsbCallTimeLineEvents);
                callbackCallRejected(getUrl(), js2JavaCall.methodName, 2, isNotRegisterByRelease(), js2JavaCall.jsbCallTimeLineEvents);
                callbackRejected(js2JavaCall, 2);
                finishCall(SerializeHelper.getErrorResponse(new JsBridgeException(-2, "Function " + js2JavaCall.methodName + " is not registered.")), js2JavaCall);
                return;
            }
            if (handleJsCallJava.needCallback) {
                if (handleJsCallJava.resultObj != null) {
                    finishCall(handleJsCallJava.resultObj, js2JavaCall);
                } else {
                    finishCall(handleJsCallJava.result, js2JavaCall);
                }
            }
            callbackCallInvoked(getUrl(), js2JavaCall.methodName, js2JavaCall.jsbCallTimeLineEvents);
        } catch (Exception e) {
            DebugUtil.m67w("call finished with error, " + js2JavaCall, e);
            finishCall(SerializeHelper.getErrorResponse(e), js2JavaCall);
        }
    }

    private String isNotRegisterByRelease() {
        if (this.released) {
            return TimeLineEvent.Constants.REASON_NOT_REGISTERED_1 + "_release";
        }
        return TimeLineEvent.Constants.REASON_NOT_REGISTERED_1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initActual(Environment environment, PermissionConfig permissionConfig) {
        this.context = getContext(environment);
        this.dataConverterActual = environment.dataConverter;
        this.methodInvocationListeners = environment.methodInvocationListeners;
        this.callHandler = new CallHandler(environment, this, permissionConfig);
        this.namespace = environment.namespace;
        this.jsbInstanceTimeLineEvents = environment.jsbInstanceTimeLineEvents;
        this.hybridViewLazy = environment.webView != null ? new AbsHybridViewLazy.WebViewLazy(environment.webView) : environment.hybridViewLazy;
        this.bizKey = environment.getBizKey();
        init(environment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> void sendJsEvent(String str, T t) {
        String str2;
        JSONObject jSONObject;
        if (this.released) {
            return;
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__msg_type", ISignalReportService.BODY_KEY_EVENT);
                jSONObject2.put("__event_id", str);
                jSONObject2.put("__params", t);
                invokeJs(jSONObject2);
                return;
            } catch (JSONException unused) {
            }
        }
        String rawData = this.dataConverterActual.toRawData(t);
        DebugUtil.m65i("Sending js event: " + str);
        if (JsBridge2.switchConfigLazy.get() != null && JsBridge2.switchConfigLazy.get().optSwitch(SwitchConfigEnum.XSS_CALLBACK_ID_SWITCH)) {
            try {
                jSONObject = new JSONObject(rawData);
            } catch (Exception unused2) {
                jSONObject = new JSONObject();
            }
            str2 = Java2JsMsg.create().putParam("__msg_type", ISignalReportService.BODY_KEY_EVENT).putParam("__event_id", str).putParam("__params", jSONObject).toJsonString();
        } else {
            str2 = "{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + rawData + "}";
        }
        invokeJs(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addExternalHandler(String str, CallHandler callHandler) {
        this.externalHandlers.put(str, callHandler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void finishCall(JSONObject jSONObject, Js2JavaCall js2JavaCall) {
        if (this.released) {
            return;
        }
        if (TextUtils.isEmpty(js2JavaCall.callbackId)) {
            DebugUtil.m65i("By passing js callback due to empty callback: " + jSONObject);
            return;
        }
        if (js2JavaCall.shouldHook != null && js2JavaCall.shouldHook.booleanValue()) {
            DebugUtil.m65i("hook by BDXBridge: " + js2JavaCall.toString());
            return;
        }
        TimeLineEvent.Builder.instance().bind(TimeLineEvent.Constants.LABEL_PRE_CALLBACK_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
        DebugUtil.m65i("Invoking js callback: " + js2JavaCall.callbackId);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", js2JavaCall.callbackId);
            jSONObject2.put("__params", jSONObject);
            invokeJsCallback(jSONObject2, js2JavaCall);
            TimeLineEvent.Builder.instance().bind(TimeLineEvent.Constants.LABEL_POST_CALLBACK_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
        } catch (JSONException unused) {
            finishCall(jSONObject.toString(), js2JavaCall);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void finishCall(String str, Js2JavaCall js2JavaCall) {
        JSONObject jSONObject;
        String jsonString;
        if (this.released) {
            return;
        }
        if (TextUtils.isEmpty(js2JavaCall.callbackId)) {
            DebugUtil.m65i("By passing js callback due to empty callback: " + str);
            return;
        }
        if (js2JavaCall.shouldHook != null && js2JavaCall.shouldHook.booleanValue()) {
            DebugUtil.m65i("hook by BDXBridge: " + js2JavaCall.toString());
            return;
        }
        TimeLineEvent.Builder.instance().bind(TimeLineEvent.Constants.LABEL_PRE_CALLBACK_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
        if (!str.startsWith("{") || !str.endsWith("}")) {
            DebugUtil.throwRuntimeException(new IllegalArgumentException("Illegal callback data: " + str));
        }
        DebugUtil.m65i("Invoking js callback: " + js2JavaCall.callbackId);
        if (!ILLEGAL_CALLBACK_ID_MATCHER.matcher(js2JavaCall.callbackId).matches() || (JsBridge2.switchConfigLazy.get() != null && JsBridge2.switchConfigLazy.get().optSwitch(SwitchConfigEnum.XSS_CALLBACK_ID_SWITCH))) {
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
            jsonString = Java2JsMsg.create().putParam("__msg_type", "callback").putParam("__callback_id", js2JavaCall.callbackId).putParam("__params", jSONObject).toJsonString();
        } else {
            jsonString = "{\"__msg_type\":\"callback\",\"__callback_id\":\"" + js2JavaCall.callbackId + "\",\"__params\":" + str + "}";
        }
        invokeJsCallback(jsonString, js2JavaCall);
        TimeLineEvent.Builder.instance().bind(TimeLineEvent.Constants.LABEL_POST_CALLBACK_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void finishCallWithId(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        if (this.released) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            DebugUtil.m65i("By passing js callback due to empty callback: " + str2);
            return;
        }
        if (!str2.startsWith("{") || !str2.endsWith("}")) {
            DebugUtil.throwRuntimeException(new IllegalArgumentException("Illegal callback data: " + str2));
        }
        DebugUtil.m65i("Invoking js callback: " + str);
        if (JsBridge2.switchConfigLazy.get() != null && JsBridge2.switchConfigLazy.get().optSwitch(SwitchConfigEnum.XSS_CALLBACK_ID_SWITCH)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Exception unused) {
                jSONObject = new JSONObject();
            }
            str3 = Java2JsMsg.create().putParam("__msg_type", "callback").putParam("__callback_id", str).putParam("__params", jSONObject).toJsonString();
        } else {
            str3 = "{\"__msg_type\":\"callback\",\"__callback_id\":\"" + str + "\",\"__params\":" + str2 + "}";
        }
        invokeJsCallback(str3, (Js2JavaCall) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Js2JavaCall createCall(JSONObject jSONObject) {
        if (this.released) {
            return null;
        }
        String optString = jSONObject.optString("__callback_id");
        String optString2 = jSONObject.optString("func");
        String url = getUrl();
        if (url == null) {
            callbackCallRejected(null, null, 3, TimeLineEvent.Constants.REASON_URL_EMPTY, null);
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String string2 = jSONObject.getString("params");
            String string3 = jSONObject.getString("JSSDK");
            String optString3 = jSONObject.optString("namespace");
            String optString4 = jSONObject.optString("__iframe_url");
            return Js2JavaCall.builder().setVersion(string3).setType(string).setMethodName(optString2).setParams(string2).setCallbackId(optString).setNamespace(optString3).setIFrameUrl(optString4).shouldHook(Boolean.valueOf(jSONObject.optBoolean("shouldHook", false))).build();
        } catch (JSONException e) {
            DebugUtil.m64e("Failed to create call.", e);
            callbackCallRejected(url, optString2, 3, TimeLineEvent.Constants.REASON_PARAMS_INVALID, null);
            return Js2JavaCall.invalidCall(optString, -5);
        }
    }

    private CallHandler getCallHandlerWithNamespace(String str) {
        if (TextUtils.equals(str, this.namespace) || TextUtils.isEmpty(str)) {
            return this.callHandler;
        }
        return this.externalHandlers.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackCallRejected(String str, String str2, int i, String str3, List<TimeLineEvent> list) {
        Iterator<IMethodInvocationListener> it = this.methodInvocationListeners.iterator();
        while (it.hasNext()) {
            it.next().onRejected(str, str2, i, str3, new TimeLineEventSummary(JsBridge2.sdkInitTimeLineEvents, this.jsbInstanceTimeLineEvents, list));
        }
    }

    private void callbackRejected(Js2JavaCall js2JavaCall, int i) {
        Iterator<IMethodInvocationListener> it = this.methodInvocationListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onRejected(js2JavaCall, i, (Object) null);
            } catch (AbstractMethodError e) {
                DebugUtil.m63e("onRejected AbstractMethodError" + e.getMessage());
            } catch (Throwable th) {
                DebugUtil.m63e("onRejected error" + th.getMessage());
            }
        }
    }

    private void callbackCallInvoked(String str, String str2, List<TimeLineEvent> list) {
        Iterator<IMethodInvocationListener> it = this.methodInvocationListeners.iterator();
        while (it.hasNext()) {
            it.next().onInvoked(str, str2, new TimeLineEventSummary(JsBridge2.sdkInitTimeLineEvents, this.jsbInstanceTimeLineEvents, list));
        }
    }
}
