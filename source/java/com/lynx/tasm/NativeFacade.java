package com.lynx.tasm;

import android.os.Bundle;
import android.text.TextUtils;
import com.lynx.BuildConfig;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.lepus.LynxLepusModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxInternalEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.theme.LynxTheme;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NativeFacade implements EventEmitter.LynxEventReporter {
    private static final String TAG = "NativeFacade";
    private Callback mCallback;
    private LynxViewClient mClient;
    private boolean mEnableJSRuntime;
    protected WeakReference<LynxEngineProxy> mEngineProxy;
    private WeakReference<JSProxy> mJSProxy;
    private WeakReference<LynxContext> mLynxContext;
    private LynxModuleFactory mModuleFactory = null;
    private int mSize;
    private String mUrl;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Callback {
        void onCallJSBFinished(Map<String, Object> map);

        void onClearNativePipelineTimingInfo();

        void onDataUpdated();

        void onDynamicComponentPerfReady(HashMap<String, Object> hashMap);

        void onErrorOccurred(LynxError lynxError);

        void onEventBubble(long j, boolean z, long j2);

        void onEventCapture(long j, boolean z, long j2);

        void onEventFire(long j, boolean z, long j2);

        void onJSBInvoked(Map<String, Object> map);

        void onLoaded(int i);

        void onLynxEvent(ReadableMap readableMap);

        void onModuleFunctionInvoked(String str, String str2, int i);

        void onPageChanged(boolean z);

        void onPageConfigDecoded(PageConfig pageConfig);

        void onReceiveMessageEvent(ReadableMap readableMap);

        void onRunPipelineFinished();

        void onRuntimeReady();

        void onSSRHydrateFinished();

        void onTASMFinishedByNative();

        void onTemplateBundleReady(TemplateBundle templateBundle);

        void onThemeUpdatedByJs(LynxTheme lynxTheme);

        void onUIMethodInvoked(int i, JavaOnlyMap javaOnlyMap);

        void onUpdateDataWithoutChange();

        void onUpdateI18nResource(String str, String str2, int i);

        String translateResourceForTheme(String str, String str2);
    }

    @Override // com.lynx.tasm.EventEmitter.LynxEventReporter
    public void onInternalEvent(LynxInternalEvent lynxInternalEvent) {
    }

    public NativeFacade(boolean z) {
        this.mEnableJSRuntime = z;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setTemplateLoadClient(LynxViewClient lynxViewClient) {
        this.mClient = lynxViewClient;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setJSProxy(JSProxy jSProxy) {
        this.mJSProxy = new WeakReference<>(jSProxy);
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public void setEngineProxy(LynxEngineProxy lynxEngineProxy) {
        this.mEngineProxy = new WeakReference<>(lynxEngineProxy);
    }

    public void setLynxContext(LynxContext lynxContext) {
        this.mLynxContext = new WeakReference<>(lynxContext);
    }

    public WeakReference<LynxContext> getLynxContext() {
        return this.mLynxContext;
    }

    public boolean getEnableJSRuntime() {
        return this.mEnableJSRuntime;
    }

    public void setModuleFactory(LynxModuleFactory lynxModuleFactory) {
        this.mModuleFactory = lynxModuleFactory;
    }

    public LynxModuleFactory getModuleFactory() {
        return this.mModuleFactory;
    }

    @Override // com.lynx.tasm.EventEmitter.LynxEventReporter
    public boolean onLynxEvent(LynxEvent lynxEvent) {
        LynxContext lynxContext;
        if (this.mClient != null && (lynxContext = this.mLynxContext.get()) != null && lynxContext.getLynxUIOwner() != null) {
            if (lynxEvent.getType() == LynxEvent.LynxEventType.kTouch && (lynxEvent instanceof LynxTouchEvent)) {
                LynxTouchEvent lynxTouchEvent = (LynxTouchEvent) lynxEvent;
                if (lynxTouchEvent.getIsMultiTouch()) {
                    JavaOnlyMap uITouchMap = lynxTouchEvent.getUITouchMap();
                    Iterator<Map.Entry<String, Object>> it = uITouchMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Object> next = it.next();
                        EventTarget eventTarget = (EventTarget) lynxTouchEvent.getActiveTargetMap().get(Integer.valueOf(Integer.parseInt(next.getKey())));
                        if (eventTarget != null) {
                            HashMap hashMap = new HashMap();
                            Iterator<Object> it2 = ((JavaOnlyArray) next.getValue()).iterator();
                            while (it2.hasNext()) {
                                JavaOnlyArray javaOnlyArray = (JavaOnlyArray) it2.next();
                                hashMap.put((Integer) javaOnlyArray.get(0), new LynxTouchEvent.Point(((Float) javaOnlyArray.get(5)).floatValue(), ((Float) javaOnlyArray.get(6)).floatValue()));
                            }
                            LynxEventDetail lynxEventDetail = new LynxEventDetail(new LynxTouchEvent(eventTarget.getSign(), lynxEvent.getName(), hashMap), eventTarget, lynxContext.getLynxView());
                            lynxEventDetail.setMotionEvent(lynxTouchEvent.getMotionEvent());
                            if (eventTarget.dispatchEvent(lynxEventDetail)) {
                                it.remove();
                            } else {
                                this.mClient.onLynxEvent(lynxEventDetail);
                            }
                        }
                    }
                    return uITouchMap.size() == 0;
                }
            }
            EventTarget target = lynxEvent.getTarget();
            if (target == null) {
                return false;
            }
            LynxEventDetail lynxEventDetail2 = new LynxEventDetail(lynxEvent, target, lynxContext.getLynxView());
            if (lynxEvent.getType() == LynxEvent.LynxEventType.kTouch && (lynxEvent instanceof LynxTouchEvent)) {
                lynxEventDetail2.setMotionEvent(((LynxTouchEvent) lynxEvent).getMotionEvent());
            }
            if (target.dispatchEvent(lynxEventDetail2)) {
                return true;
            }
            this.mClient.onLynxEvent(lynxEventDetail2);
        }
        return false;
    }

    public String translateResourceForTheme(String str, String str2) {
        Callback callback = this.mCallback;
        if (callback != null) {
            return callback.translateResourceForTheme(str, str2);
        }
        return null;
    }

    private void onConfigUpdatedByJS(String str, Object obj) {
        if (str == null || obj == null || !(obj instanceof HashMap)) {
            return;
        }
        HashMap hashMap = (HashMap) obj;
        if ("theme".equals(str)) {
            LynxTheme lynxTheme = new LynxTheme();
            for (Map.Entry entry : hashMap.entrySet()) {
                lynxTheme.update((String) entry.getKey(), (String) entry.getValue());
            }
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onThemeUpdatedByJs(lynxTheme);
            }
        }
    }

    public void destroyAnyThreadPart() {
        LynxModuleFactory lynxModuleFactory = this.mModuleFactory;
        if (lynxModuleFactory != null) {
            if (this.mEnableJSRuntime) {
                lynxModuleFactory.retainJniObject();
            } else {
                lynxModuleFactory.destroy();
            }
            this.mModuleFactory = null;
        }
    }

    public void destroyUiThreadPart() {
        LynxViewClient lynxViewClient = this.mClient;
        if (lynxViewClient != null) {
            lynxViewClient.onDestroy();
            this.mClient = null;
        }
    }

    private void onRuntimeReady() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onRuntimeReady();
        }
    }

    private void onDataUpdated() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDataUpdated();
        }
    }

    private void onPageChanged(boolean z) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPageChanged(z);
        }
    }

    public void reportError(LynxError lynxError) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onErrorOccurred(lynxError);
        }
    }

    private void dispatchOnLoaded() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onLoaded(this.mSize);
        }
    }

    private void onSSRHydrateFinished() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onSSRHydrateFinished();
        }
    }

    private void onTASMFinishedByNative() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTASMFinishedByNative();
        }
    }

    private void onTimingSetup(ReadableMap readableMap) {
        LynxViewClient lynxViewClient = this.mClient;
        if (lynxViewClient == null) {
            return;
        }
        lynxViewClient.onTimingSetup(readableMap.asHashMap());
    }

    private void onTimingUpdate(ReadableMap readableMap, ReadableMap readableMap2, String str) {
        if (this.mClient == null) {
            return;
        }
        Object obj = readableMap2.asHashMap().get(str);
        if (obj instanceof HashMap) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if ((key instanceof String) && (value instanceof Long)) {
                    hashMap.put((String) key, (Long) value);
                }
            }
            this.mClient.onTimingUpdate(readableMap.asHashMap(), hashMap, str);
        }
    }

    private void onDynamicComponentPerfReady(ReadableMap readableMap) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDynamicComponentPerfReady(readableMap.asHashMap());
        }
    }

    private void onModuleFunctionInvoked(String str, String str2, int i) {
        Callback callback = this.mCallback;
        if (callback != null) {
            try {
                callback.onModuleFunctionInvoked(str, str2, i);
            } catch (Exception e) {
                LynxError lynxError = new LynxError(LynxSubErrorCode.E_NATIVE_MODULES_EXCEPTION, "Callback 'onModuleFunctionInvoked' called after method '" + str2 + "' in module '" + str + "' threw an exception: " + e.getMessage());
                lynxError.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(e));
                reportError(lynxError);
            }
        }
    }

    private void onUpdateDataWithoutChange() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onUpdateDataWithoutChange();
        }
    }

    public void onPageConfigDecoded(ReadableMap readableMap) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onPageConfigDecoded(new PageConfig(readableMap));
        }
    }

    public void onRunPipelineFinished() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onRunPipelineFinished();
        }
    }

    public ByteBuffer triggerLepusBridge(String str, Object obj) {
        return LepusBuffer.INSTANCE.encodeMessage(LynxLepusModule.triggerLepusBridge(str, obj, this.mModuleFactory));
    }

    public void triggerLepusBridgeAsync(String str, Object obj) {
        WeakReference<LynxEngineProxy> weakReference = this.mEngineProxy;
        LynxLepusModule.triggerLepusBridgeAsync(str, obj, weakReference != null ? weakReference.get() : null, this.mModuleFactory);
    }

    private void flushJSBTiming(ReadableMap readableMap) {
        Callback callback;
        if (BuildConfig.enable_lite.booleanValue() || (callback = this.mCallback) == null || readableMap == null) {
            return;
        }
        callback.onJSBInvoked(JavaOnlyMap.from(readableMap.getMap("info").asHashMap()));
        if (readableMap.getMap("info").getInt("jsb_status_code", 0) != 1) {
            return;
        }
        this.mCallback.onCallJSBFinished(readableMap.asHashMap());
    }

    public void getI18nResourceByNative(String str, String str2) {
        LynxContext lynxContext = this.mLynxContext.get();
        if (lynxContext != null) {
            LynxResourceProvider providerByKey = lynxContext.getProviderRegistry().getProviderByKey("I18N_TEXT");
            if (providerByKey == null) {
                lynxContext.reportResourceError(LynxSubErrorCode.E_RESOURCE_I18N, str, "I18nResource", "no i18n provider found");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("fallbackUrl", str2);
            providerByKey.request(new LynxResourceRequest(str.toLowerCase(), bundle), new C15061(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.NativeFacade$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C15061 extends LynxResourceCallback<String> {
        final /* synthetic */ String val$channelOrUrl;
        final WeakReference<NativeFacade> weakFacade;

        C15061(String str) {
            this.val$channelOrUrl = str;
            this.weakFacade = new WeakReference<>(NativeFacade.this);
        }

        public void onResponse(final LynxResourceResponse<String> lynxResourceResponse) {
            super.onResponse(lynxResourceResponse);
            if (!UIThreadUtils.isOnUiThread()) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.NativeFacade.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C15061.this.callbackResponse(lynxResourceResponse);
                    }
                });
            } else {
                callbackResponse(lynxResourceResponse);
            }
        }

        void callbackResponse(LynxResourceResponse<String> lynxResourceResponse) {
            LynxContext lynxContext;
            NativeFacade nativeFacade = this.weakFacade.get();
            if (nativeFacade != null) {
                if (TextUtils.isEmpty((CharSequence) lynxResourceResponse.getData()) && (lynxContext = (LynxContext) nativeFacade.mLynxContext.get()) != null) {
                    lynxContext.reportResourceError(LynxSubErrorCode.E_RESOURCE_I18N, this.val$channelOrUrl, "I18nResource", "empty i18n resource return");
                    nativeFacade.mCallback.onUpdateI18nResource(this.val$channelOrUrl, "", -1);
                } else {
                    nativeFacade.mCallback.onUpdateI18nResource(this.val$channelOrUrl, (String) lynxResourceResponse.getData(), lynxResourceResponse.getCode());
                }
            }
        }
    }

    private void InvokeUIMethod(LynxGetUIResult lynxGetUIResult, String str, JavaOnlyMap javaOnlyMap, final int i) {
        LynxContext lynxContext;
        WeakReference<LynxContext> weakReference = this.mLynxContext;
        if (weakReference == null || (lynxContext = weakReference.get()) == null || lynxContext.getLynxUIOwner() == null) {
            return;
        }
        lynxContext.getLynxUIOwner().invokeUIMethodForSelectorQuery(lynxGetUIResult.getUiArray().getInt(0), str, javaOnlyMap, new com.lynx.react.bridge.Callback() { // from class: com.lynx.tasm.NativeFacade.2
            @Override // com.lynx.react.bridge.Callback
            public void invoke(Object... objArr) {
                if (i < 0) {
                    return;
                }
                JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
                javaOnlyMap2.putInt("code", ((Integer) objArr[0]).intValue());
                if (objArr.length > 1) {
                    javaOnlyMap2.put("data", objArr[1]);
                }
                if (NativeFacade.this.mCallback != null) {
                    NativeFacade.this.mCallback.onUIMethodInvoked(i, javaOnlyMap2);
                }
            }
        });
    }

    public int getInstanceId() {
        LynxContext lynxContext = this.mLynxContext.get();
        if (lynxContext == null) {
            return -1;
        }
        return lynxContext.getInstanceId();
    }

    private void onTemplateBundleReady(TemplateBundle templateBundle) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTemplateBundleReady(templateBundle);
        }
    }

    private void onReceiveMessageEvent(ReadableMap readableMap) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onReceiveMessageEvent(readableMap);
        }
    }

    void onEventCapture(long j, boolean z, long j2) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onEventCapture(j, z, j2);
        }
    }

    void onEventBubble(long j, boolean z, long j2) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onEventBubble(j, z, j2);
        }
    }

    void onEventFire(long j, boolean z, long j2) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onEventFire(j, z, j2);
        }
    }

    void onLynxEvent(ReadableMap readableMap) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onLynxEvent(readableMap);
        }
    }

    public void clearNativePipelineTimingInfo() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onClearNativePipelineTimingInfo();
        }
    }
}
