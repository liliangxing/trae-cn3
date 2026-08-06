package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.BaseStatefulMethod;
import com.bytedance.ies.web.jsbridge2.LegacySupportStub;
import com.bytedance.ies.web.jsbridge2.PermissionConfig;
import com.bytedance.ies.web.jsbridge2.PermissionConfigRepository;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class CallHandler implements PermissionConfigRepository.FetchCallback {
    private IAsyncMethodRegister asyncMethodRegister;
    private final AbstractBridge bridge;
    private final DataConverterActual dataConverter;
    private final boolean enablePermissionCheck;
    private final Environment environment;
    private final Set<IMethodInvocationListener> methodInvocationListeners;
    private final PermissionChecker permissionChecker;
    private final Map<String, BaseMethod> methodMap = new ConcurrentHashMap();
    private final Map<String, BaseStatefulMethod.Provider> providerMap = new ConcurrentHashMap();
    private final List<Js2JavaCall> pendingCallList = new ArrayList();
    private final Set<BaseStatefulMethod> unfinishedStatefulMethodSet = Collections.newSetFromMap(new ConcurrentHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallHandler(Environment environment, AbstractBridge abstractBridge, PermissionConfig permissionConfig) {
        this.bridge = abstractBridge;
        this.environment = environment;
        this.dataConverter = environment.dataConverter;
        PermissionChecker permissionChecker = new PermissionChecker(permissionConfig, environment.safeHostSet, environment.publicMethodSet, environment.enforceHttp);
        this.permissionChecker = permissionChecker;
        permissionChecker.addFetchCallback(this);
        permissionChecker.addOpenJsbValidator(environment.jsbPermissionValidator);
        permissionChecker.addPermissionCheckingListener(environment.permissionCheckingListener);
        this.methodInvocationListeners = environment.methodInvocationListeners;
        this.enablePermissionCheck = environment.enablePermissionCheck;
        this.asyncMethodRegister = environment.asyncMethodRegister;
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.CONFIG, Boolean.valueOf(permissionConfig != null)).bind(TimeLineEvent.Constants.LABEL_CREATE_CALL_HANDLER, environment.jsbInstanceTimeLineEvents);
    }

    private void checkAsyncMethod() {
        IAsyncMethodRegister iAsyncMethodRegister = this.asyncMethodRegister;
        if (iAsyncMethodRegister != null) {
            iAsyncMethodRegister.ensureFinished();
            this.asyncMethodRegister = null;
        }
    }

    private boolean disableAllPermissionCheck() {
        Environment environment = this.environment;
        if (environment == null) {
            return false;
        }
        return environment.disableAllPermissionCheck;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallResult handleJsCallJava(Js2JavaCall js2JavaCall, CallContext callContext) throws Exception {
        checkAsyncMethod();
        BaseMethod baseMethod = this.methodMap.get(js2JavaCall.methodName);
        try {
            String str = callContext.url;
            if (TextUtils.isEmpty(str) || TimeLineEvent.Constants.ABOUT_BLANK.equals(str)) {
                String url = this.bridge.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    callContext.url = url;
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.URL, url).bind(TimeLineEvent.Constants.LABEL_CALL_NEW_URL, js2JavaCall.jsbCallTimeLineEvents);
                }
            }
            if (baseMethod != null) {
                PermissionGroup checkPermission = checkPermission(callContext, baseMethod, js2JavaCall.jsbCallTimeLineEvents);
                callContext.permissionGroup = checkPermission;
                if (checkPermission == null) {
                    String str2 = TimeLineEvent.Constants.REASON_PERMISSION_EMPTY_1;
                    if (TextUtils.isEmpty(callContext.url) || TimeLineEvent.Constants.ABOUT_BLANK.equals(callContext.url)) {
                        str2 = TimeLineEvent.Constants.REASON_ABOUT_BLANK_1;
                    }
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REASON, TimeLineEvent.Constants.REASON_PERMISSION_EMPTY_1).bind(TimeLineEvent.Constants.LABEL_CALL_HANDLER_REJECT, js2JavaCall.jsbCallTimeLineEvents);
                    callbackCallRejected(callContext.url, js2JavaCall.methodName, 1, str2, js2JavaCall.jsbCallTimeLineEvents);
                    callbackRejected(js2JavaCall, 1);
                    DebugUtil.m65i("Permission denied, call: " + js2JavaCall);
                    throw new JsBridgeException(-1, "Permission denied");
                }
                TimeLineEvent.Builder.instance().bind(TimeLineEvent.Constants.LABEL_PRE_HANDLE_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
                if (baseMethod instanceof BaseStatelessMethod) {
                    DebugUtil.m65i("Processing stateless call: " + js2JavaCall);
                    if (JsBridge2.globalCallListenerLazy.get() != null) {
                        JsBridge2.globalCallListenerLazy.get().onStatelessCall(js2JavaCall, (BaseStatelessMethod) baseMethod, callContext);
                    }
                    return handleStateless(js2JavaCall, (BaseStatelessMethod) baseMethod, callContext);
                }
                if (baseMethod instanceof BaseRawMethod) {
                    DebugUtil.m65i("Processing raw call: " + js2JavaCall);
                    if (JsBridge2.globalCallListenerLazy.get() != null) {
                        JsBridge2.globalCallListenerLazy.get().onRawCall(js2JavaCall, (BaseRawMethod) baseMethod, callContext);
                    }
                    return handleRaw(js2JavaCall, (BaseRawMethod) baseMethod, checkPermission);
                }
            }
            BaseStatefulMethod.Provider provider = this.providerMap.get(js2JavaCall.methodName);
            if (provider != null) {
                BaseStatefulMethod provideMethod = provider.provideMethod();
                provideMethod.setName(js2JavaCall.methodName);
                PermissionGroup checkPermission2 = checkPermission(callContext, provideMethod, js2JavaCall.jsbCallTimeLineEvents);
                callContext.permissionGroup = checkPermission2;
                if (checkPermission2 == null) {
                    String str3 = TimeLineEvent.Constants.REASON_PERMISSION_EMPTY_2;
                    if (TextUtils.isEmpty(callContext.url) || TimeLineEvent.Constants.ABOUT_BLANK.equals(callContext.url)) {
                        str3 = TimeLineEvent.Constants.REASON_ABOUT_BLANK_2;
                    }
                    TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REASON, TimeLineEvent.Constants.REASON_PERMISSION_EMPTY_2).bind(TimeLineEvent.Constants.LABEL_CALL_HANDLER_REJECT, js2JavaCall.jsbCallTimeLineEvents);
                    callbackCallRejected(callContext.url, js2JavaCall.methodName, 1, str3, js2JavaCall.jsbCallTimeLineEvents);
                    callbackRejected(js2JavaCall, 1);
                    DebugUtil.m65i("Permission denied, call: " + js2JavaCall);
                    provideMethod.onDestroy();
                    throw new JsBridgeException(-1, "Permission denied");
                }
                DebugUtil.m65i("Processing stateful call: " + js2JavaCall);
                TimeLineEvent.Builder.instance().bind(TimeLineEvent.Constants.LABEL_PRE_HANDLE_ORIGIN_URL, js2JavaCall.jsbCallTimeLineEvents);
                if (JsBridge2.globalCallListenerLazy.get() != null) {
                    JsBridge2.globalCallListenerLazy.get().onStatefulCall(js2JavaCall, provideMethod, callContext);
                }
                return handleStateful(js2JavaCall, provideMethod, callContext);
            }
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.REASON, isNotRegisterByRelease()).bind(TimeLineEvent.Constants.LABEL_CALL_HANDLER_REJECT, js2JavaCall.jsbCallTimeLineEvents);
            callbackCallRejected(callContext.url, js2JavaCall.methodName, 2, isNotRegisterByRelease(), js2JavaCall.jsbCallTimeLineEvents);
            DebugUtil.m66w("Received call: " + js2JavaCall + ", but not registered.");
            return null;
        } catch (PermissionConfig.IllegalRemoteConfigException e) {
            DebugUtil.m67w("No remote permission config fetched, call pending: " + js2JavaCall, e);
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.EXCEPTION_NAME, e.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.EXCEPTION_MESSAGE, e.getMessage()).bind(TimeLineEvent.Constants.LABEL_CALL_PENDING, js2JavaCall.jsbCallTimeLineEvents);
            this.pendingCallList.add(js2JavaCall);
            return new CallResult(false, SerializeHelper.getEmptyString());
        }
    }

    private String isNotRegisterByRelease() {
        if (this.methodMap.isEmpty() || this.providerMap.isEmpty()) {
            AbstractBridge abstractBridge = this.bridge;
            if (abstractBridge != null && abstractBridge.released) {
                return TimeLineEvent.Constants.REASON_NOT_REGISTERED_2 + "_release_empty";
            }
            return TimeLineEvent.Constants.REASON_NOT_REGISTERED_2 + "empty";
        }
        AbstractBridge abstractBridge2 = this.bridge;
        if (abstractBridge2 != null && abstractBridge2.released) {
            return TimeLineEvent.Constants.REASON_NOT_REGISTERED_2 + "_release";
        }
        return TimeLineEvent.Constants.REASON_NOT_REGISTERED_2 + "_re";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void onSendJsEvent(String str, T t) {
        this.bridge.sendJsEvent(str, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerStatelessMethod(String str, BaseStatelessMethod<?, ?> baseStatelessMethod) {
        baseStatelessMethod.setName(str);
        this.methodMap.put(str, baseStatelessMethod);
        DebugUtil.m65i("JsBridge stateless method registered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerStatefulMethod(String str, BaseStatefulMethod.Provider provider) {
        this.providerMap.put(str, provider);
        DebugUtil.m65i("JsBridge stateful method registered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerRawMethod(String str, BaseRawMethod baseRawMethod) {
        baseRawMethod.setName(str);
        this.methodMap.put(str, baseRawMethod);
        DebugUtil.m65i("JsBridge raw method registered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterMethod(String str) {
        this.methodMap.remove(str);
        this.providerMap.remove(str);
        DebugUtil.m65i("JsBridge method unregistered: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PermissionChecker getPermissionChecker() {
        return this.permissionChecker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        Iterator<BaseStatefulMethod> it = this.unfinishedStatefulMethodSet.iterator();
        while (it.hasNext()) {
            it.next().terminateActual();
        }
        this.unfinishedStatefulMethodSet.clear();
        this.methodMap.clear();
        this.providerMap.clear();
        this.permissionChecker.removeFetchCallback(this);
    }

    private void callbackCallRejected(String str, String str2, int i, String str3, List<TimeLineEvent> list) {
        Iterator<IMethodInvocationListener> it = this.methodInvocationListeners.iterator();
        while (it.hasNext()) {
            it.next().onRejected(str, str2, i, str3, new TimeLineEventSummary(JsBridge2.sdkInitTimeLineEvents, this.bridge.jsbInstanceTimeLineEvents, list));
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

    private CallResult handleStateless(Js2JavaCall js2JavaCall, BaseStatelessMethod baseStatelessMethod, CallContext callContext) throws Exception {
        DebugUtil.m65i("StatelessMethod===>" + baseStatelessMethod);
        Object invoke = baseStatelessMethod.invoke(createParamObject(js2JavaCall.params, baseStatelessMethod), callContext);
        JSONObject successResponseJson = SerializeHelper.getSuccessResponseJson(invoke);
        boolean z = true;
        if (successResponseJson != null) {
            return new CallResult(z, successResponseJson);
        }
        return new CallResult(z, SerializeHelper.getSuccessResponse(this.dataConverter, invoke));
    }

    private CallResult handleStateful(final Js2JavaCall js2JavaCall, final BaseStatefulMethod baseStatefulMethod, CallContext callContext) throws Exception {
        DebugUtil.m65i("StatefulMethod===>" + baseStatefulMethod);
        this.unfinishedStatefulMethodSet.add(baseStatefulMethod);
        baseStatefulMethod.invokeActual(createParamObject(js2JavaCall.params, baseStatefulMethod), callContext, new BaseStatefulMethod.Callback() { // from class: com.bytedance.ies.web.jsbridge2.CallHandler.1
            @Override // com.bytedance.ies.web.jsbridge2.BaseStatefulMethod.Callback
            public void onSucceed(Object obj) {
                if (CallHandler.this.bridge == null) {
                    return;
                }
                JSONObject successResponseJson = SerializeHelper.getSuccessResponseJson(obj);
                if (successResponseJson != null) {
                    CallHandler.this.bridge.finishCall(successResponseJson, js2JavaCall);
                } else {
                    CallHandler.this.bridge.finishCall(SerializeHelper.getSuccessResponse(CallHandler.this.dataConverter, obj), js2JavaCall);
                }
                CallHandler.this.unfinishedStatefulMethodSet.remove(baseStatefulMethod);
            }

            @Override // com.bytedance.ies.web.jsbridge2.BaseStatefulMethod.Callback
            public void onFailed(Throwable th) {
                if (CallHandler.this.bridge == null) {
                    return;
                }
                CallHandler.this.bridge.finishCall(SerializeHelper.getErrorResponse(th), js2JavaCall);
                CallHandler.this.unfinishedStatefulMethodSet.remove(baseStatefulMethod);
            }

            @Override // com.bytedance.ies.web.jsbridge2.BaseStatefulMethod.Callback
            public void onRawResult(JSONObject jSONObject) {
                if (CallHandler.this.bridge == null) {
                    return;
                }
                CallHandler.this.bridge.finishCall(jSONObject, js2JavaCall);
                CallHandler.this.unfinishedStatefulMethodSet.remove(baseStatefulMethod);
            }
        });
        return new CallResult(false, SerializeHelper.getEmptyString());
    }

    private CallResult handleRaw(final Js2JavaCall js2JavaCall, BaseRawMethod baseRawMethod, PermissionGroup permissionGroup) throws Exception {
        baseRawMethod.invoke(js2JavaCall, new LegacySupportStub(js2JavaCall.methodName, permissionGroup, new LegacySupportStub.Callback() { // from class: com.bytedance.ies.web.jsbridge2.CallHandler.2
            @Override // com.bytedance.ies.web.jsbridge2.LegacySupportStub.Callback
            public void onResponse(String str) {
                if (str == null || CallHandler.this.bridge == null) {
                    return;
                }
                CallHandler.this.bridge.finishCall(str, js2JavaCall);
            }
        }));
        return new CallResult(false, SerializeHelper.getEmptyString());
    }

    @Override // com.bytedance.ies.web.jsbridge2.PermissionConfigRepository.FetchCallback
    public void onPermissionConfigFetched() {
        ArrayList arrayList = new ArrayList();
        LinkedList<Js2JavaCall> linkedList = new LinkedList(this.pendingCallList);
        this.pendingCallList.clear();
        for (Js2JavaCall js2JavaCall : linkedList) {
            this.bridge.handleCall(js2JavaCall);
            arrayList.add(js2JavaCall.toString());
        }
        TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.LIST, arrayList).bind(TimeLineEvent.Constants.LABEL_PENDING_CALL_LIST, JsBridge2.sdkInitTimeLineEvents);
    }

    private Object createParamObject(String str, BaseMethod baseMethod) throws JSONException {
        return this.dataConverter.fromRawData(str, getTypesFromMethod(baseMethod)[0]);
    }

    private PermissionGroup checkPermission(CallContext callContext, BaseMethod baseMethod, List<TimeLineEvent> list) {
        if (disableAllPermissionCheck() || !callContext.needCheckPermission) {
            TimeLineEvent.Builder.instance().setExtraItem(TimeLineEvent.Constants.URL, callContext.url).setExtraItem(TimeLineEvent.Constants.METHOD_NAME, baseMethod.getName()).setExtraItem(TimeLineEvent.Constants.METHOD_CLASS, baseMethod.getClass().getSimpleName()).setExtraItem(TimeLineEvent.Constants.METHOD_PERMISSION_GROUP, baseMethod.getPermissionGroup()).setExtraItem(TimeLineEvent.Constants.DISABLE_ALL_PERMISSION_CHECK, true).setExtraItem(TimeLineEvent.Constants.CALL_PERMISSION_GROUP, PermissionGroup.PRIVATE.toString()).bind(TimeLineEvent.Constants.LABEL_PERMISSION_CHECKER, list);
            return PermissionGroup.PRIVATE;
        }
        return this.permissionChecker.shouldIntercept(this.enablePermissionCheck, callContext.url, baseMethod, list);
    }

    private static Type[] getTypesFromMethod(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class CallResult {
        boolean needCallback;
        String result;
        JSONObject resultObj;

        private CallResult(boolean z, String str) {
            this.needCallback = z;
            this.result = str;
        }

        private CallResult(boolean z, JSONObject jSONObject) {
            this.needCallback = z;
            this.resultObj = jSONObject;
        }
    }
}
