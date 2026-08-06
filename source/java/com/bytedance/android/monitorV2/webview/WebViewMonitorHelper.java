package com.bytedance.android.monitorV2.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerNativeInfo;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.FallBackInfo;
import com.bytedance.android.monitorV2.entity.FetchError;
import com.bytedance.android.monitorV2.entity.JSBError;
import com.bytedance.android.monitorV2.entity.JSBInfo;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.event.PiaEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.standard.ContainerError;
import com.bytedance.android.monitorV2.standard.ContainerStandardApi;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import com.bytedance.android.monitorV2.webview.gecko.IHybridMonitorGeckoClient;
import com.bytedance.android.monitorV2.webview.util.EventTransUtils;
import java.lang.reflect.InvocationHandler;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WebViewMonitorHelper implements IWebViewMonitorHelper {
    private static final String TAG = "WebViewMonitorHelper";
    private static IWebViewMonitorHelper helper = new WebViewMonitorHelper();
    private boolean hasTTWebViewRegistered = false;
    private boolean isMonitorEnable = true;
    private boolean isTTWebDelegateEnable = true;
    private WebViewMonitorHelperImpl monitorHelperImpl = new WebViewMonitorHelperImpl();
    private boolean isMonitorEnableOldTmp = false;

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void handleCollectEvent(View view, String str, Object obj) {
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IDeprecated
    public void onClientOffline(WebView webView, String str, boolean z) {
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IDeprecated
    public void onOffline(WebView webView, String str, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reloadInner(WebView webView) {
    }

    @Override // com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper
    public void report(WebView webView) {
    }

    private WebViewMonitorHelper() {
        ContainerStandardApi.INSTANCE.registerAction("web", this);
        registerTTWebViewDelegate();
    }

    private void registerTTWebViewDelegate() {
        try {
            Class<?> cls = Class.forName("com.bytedance.lynx.webview.TTWebSdk");
            cls.getDeclaredMethod("registerGlobalWebViewHandler", InvocationHandler.class).invoke(null, new TTWebViewDelegateHandler());
            cls.getDeclaredMethod("registerGlobalWebViewHandler", InvocationHandler.class).invoke(null, new TTWebViewClientDelegateHandler());
            cls.getDeclaredMethod("registerGlobalWebViewHandler", InvocationHandler.class).invoke(null, new TTWebChromeClientDelegateHandler());
            this.hasTTWebViewRegistered = true;
        } catch (Throwable th) {
            this.hasTTWebViewRegistered = false;
            ExceptionUtil.handleException(th);
        }
    }

    private SwitchConfig getSwitchConfig() {
        return HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch();
    }

    @Override // com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper
    public HashMap<String, Object> getExtraInfo(WebView webView) {
        if (webView == null) {
            return new HashMap<>();
        }
        return this.monitorHelperImpl.getExtraInfo(webView);
    }

    public static IWebViewMonitorHelper getInstance() {
        return helper;
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleFetchSuccess(WebView webView) {
        isEnable();
    }

    @Override // com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper
    public void setGeckoClient(IHybridMonitorGeckoClient iHybridMonitorGeckoClient) {
        this.monitorHelperImpl.setGeckoClient(iHybridMonitorGeckoClient);
    }

    @Override // com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper
    public void setEnable(boolean z) {
        this.isMonitorEnable = z;
    }

    private boolean isEnable() {
        boolean z = this.isMonitorEnable && getSwitchConfig().isEnableMonitor() && getSwitchConfig().isWebEnableMonitor();
        if (this.isMonitorEnableOldTmp != z) {
            MonitorLog.m29i(TAG, "monitor enabled: " + z);
            this.isMonitorEnableOldTmp = z;
        }
        return z;
    }

    @Override // com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper
    public void setTTWebDelegateEnable(boolean z) {
        this.isTTWebDelegateEnable = z;
    }

    public boolean isTTWebEnable() {
        return this.hasTTWebViewRegistered && this.isTTWebDelegateEnable && getSwitchConfig().isWebEnableTTWebDelegate();
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void handleFetchError(WebView webView, FetchError fetchError) {
        CommonEvent commonEvent = new CommonEvent("fetchError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (!getSwitchConfig().isWebEnableFetch()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            fetchError.fillInJsonObject(jSONObject);
            handleNativeInfoInner(webView, commonEvent, jSONObject);
            updateUnifyInfo(webView, commonEvent, fetchError.requestErrorCode, fetchError.requestErrorMsg);
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        MonitorLog.m29i(TAG, "handleRequestError: " + MonitorLog.getSafeWebViewString(webView) + ", errorCode: " + webResourceError.getErrorCode());
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        handleRequestErrorInner(webView, webResourceRequest, webResourceError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRequestErrorInner(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        CommonEvent commonEvent = new CommonEvent("nativeError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null || webResourceRequest == null || webResourceError == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (isIcoNativeError(webResourceRequest)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
            } else if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, EventTransUtils.getNativeErrorJsonObj(webResourceRequest.getUrl().toString(), Boolean.valueOf(webResourceRequest.isForMainFrame()), Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription().toString(), 0));
                updateUnifyInfo(webView, commonEvent, webResourceError.getErrorCode(), webResourceError.getDescription().toString());
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void handleRequestError(WebView webView, int i, String str, String str2) {
        MonitorLog.m29i(TAG, "handleRequestError: " + MonitorLog.getSafeWebViewString(webView) + ", errorCode: " + i);
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        handleRequestErrorInner(webView, i, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRequestErrorInner(WebView webView, int i, String str, String str2) {
        CommonEvent commonEvent = new CommonEvent("nativeError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void handleRequestHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        MonitorLog.m29i(TAG, "handleRequestHttpError: " + MonitorLog.getSafeWebViewString(webView) + ", request: " + webResourceRequest + ", statusCode: " + webResourceResponse.getStatusCode());
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        handleRequestHttpErrorInner(webView, webResourceRequest, webResourceResponse);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRequestHttpErrorInner(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        CommonEvent commonEvent = new CommonEvent("nativeError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null || webResourceRequest == null || webResourceResponse == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (isIcoNativeError(webResourceRequest)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
            } else if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, EventTransUtils.getNativeErrorJsonObj(webResourceRequest.getUrl().toString(), Boolean.valueOf(webResourceRequest.isForMainFrame()), 0, webResourceResponse.getReasonPhrase(), Integer.valueOf(webResourceResponse.getStatusCode())));
                updateUnifyInfo(webView, commonEvent, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase());
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    private boolean isIcoNativeError(WebResourceRequest webResourceRequest) {
        Uri url;
        String path;
        if (webResourceRequest == null || webResourceRequest.isForMainFrame() || (url = webResourceRequest.getUrl()) == null || (path = url.getPath()) == null) {
            return false;
        }
        return path.endsWith("favicon.ico");
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void handleRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        MonitorLog.m29i(TAG, "handleRenderProcessGone: " + MonitorLog.getSafeWebViewString(webView) + ", detail: " + renderProcessGoneDetail);
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        handleRenderProcessGoneInner(webView, renderProcessGoneDetail);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleRenderProcessGoneInner(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        CommonEvent commonEvent = new CommonEvent("nativeError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView != null && renderProcessGoneDetail != null && !TextUtils.isEmpty(webView.getUrl())) {
                if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                    commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                    return;
                }
                this.monitorHelperImpl.handleRenderProcessGone(webView, renderProcessGoneDetail);
                String str = "";
                if (Build.VERSION.SDK_INT >= 26) {
                    str = renderProcessGoneDetail.didCrash() ? "cause by crash" : "cause by system";
                }
                handleNativeInfoInner(webView, commonEvent, EventTransUtils.getNativeErrorJsonObj(webView.getUrl(), null, -10000, str, null));
                updateUnifyInfo(webView, commonEvent, -10000, str);
                return;
            }
            commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleJSBError(WebView webView, JSBError jSBError) {
        MonitorLog.m29i(TAG, "handleJSBError: " + MonitorLog.getSafeWebViewString(webView));
        CommonEvent commonEvent = new CommonEvent("jsbError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else if (!getSwitchConfig().isWebEnableJSB()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, EventTransUtils.getJsbErrorJsonObj(jSBError));
                updateUnifyInfo(webView, commonEvent, jSBError.errorCode, jSBError.errorMessage);
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleJSBInfo(WebView webView, JSBInfo jSBInfo) {
        MonitorLog.m29i(TAG, "handleJSBInfo: " + MonitorLog.getSafeWebViewString(webView));
        CommonEvent commonEvent = new CommonEvent("jsbPerf");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else if (!getSwitchConfig().isWebEnableJSB()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, EventTransUtils.getJSBInfoJsonObj(jSBInfo));
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleJSBInfoV2(WebView webView, Map<String, Object> map) {
        CommonEvent commonEvent = new CommonEvent(ReportConst.Event.JSB_PER_V2);
        try {
            commonEvent.onEventCreated();
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else if (!getSwitchConfig().isWebEnableJSB()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, new JSONObject(map));
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleJSBPvV2(WebView webView, Map<String, Object> map) {
        CommonEvent commonEvent = new CommonEvent(ReportConst.Event.JSB_PAGE_VISIT);
        try {
            commonEvent.onEventCreated();
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
                return;
            }
            if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else if (!getSwitchConfig().isWebEnableJSB()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, new JSONObject(map));
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePiaInfo(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z;
        try {
            PiaEvent piaEvent = new PiaEvent(new CustomInfo.Builder("pia_" + str).setCategory(jSONObject).setMetric(jSONObject2).setExtra(null).setCommon(null).setSample(3).build());
            if (isEnable() && this.monitorHelperImpl.isNeedMonitor(webView)) {
                z = false;
                if (piaEvent.terminateIf(z, HybridEvent.TerminateType.SWITCH_OFF)) {
                    if (webView == null) {
                        DataReporter.INSTANCE.reportCustomEvent(piaEvent, true);
                        return;
                    } else {
                        this.monitorHelperImpl.customReport(webView, piaEvent);
                        return;
                    }
                }
                return;
            }
            z = true;
            if (piaEvent.terminateIf(z, HybridEvent.TerminateType.SWITCH_OFF)) {
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void reportEvent(WebView webView, String str, int i) {
        MonitorLog.m29i(TAG, "reportEvent: " + MonitorLog.getSafeWebViewString(webView) + ", type: " + str);
        try {
            if (isEnable() && webView != null && this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.addExtraEventInfo(webView, str, i);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void forceReport(WebView webView, String str) {
        MonitorLog.m29i(TAG, "forceReport: " + MonitorLog.getSafeWebViewString(webView) + ", reportType: " + str);
        try {
            if (isEnable() && webView != null && this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.forceReport(webView, str);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleNativeInfo(WebView webView, String str, JSONObject jSONObject) {
        MonitorLog.m29i(TAG, "handleNativeInfo: eventTYpe: " + str);
        CommonEvent commonEvent = new CommonEvent(str);
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (webView == null) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
            } else if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                handleNativeInfoInner(webView, commonEvent, jSONObject);
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebExtension
    public void handleSSPInfo(String str, String str2, String str3, Map<String, Object> map) {
        this.monitorHelperImpl.handleSPPMonitorInfo(str, str2, str3, map);
    }

    void handleNativeInfoInner(WebView webView, CommonEvent commonEvent, JSONObject jSONObject) {
        this.monitorHelperImpl.handleNativeInfo(webView, commonEvent, jSONObject);
    }

    void updateUnifyInfo(WebView webView, CommonEvent commonEvent, int i, String str) {
        this.monitorHelperImpl.updateUnifyError(webView, commonEvent, i, str);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void destroy(WebView webView) {
        MonitorLog.m29i(TAG, "destroy: " + MonitorLog.getSafeWebViewString(webView));
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        destroyInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyInner(WebView webView) {
        try {
            if (isEnable()) {
                this.monitorHelperImpl.onWebViewDestroyed(webView);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void reload(WebView webView) {
        MonitorLog.m29i(TAG, "reload: " + MonitorLog.getSafeWebViewString(webView));
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        reloadInner(webView);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void goBack(WebView webView) {
        MonitorLog.m29i(TAG, "goBack: " + MonitorLog.getSafeWebViewString(webView));
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        goBackInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goBackInner(WebView webView) {
        try {
            if (isEnable() && this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.onGoBack(webView);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IMonitorConfig
    public void addConfig(IWebViewMonitorHelper.Config config) {
        this.monitorHelperImpl.addConfig(config);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IMonitorConfig
    public void removeConfig(String... strArr) {
        this.monitorHelperImpl.removeConfig(strArr);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IDeprecated
    public void initConfig(IWebViewMonitorHelper.Config config) {
        try {
            addConfig(config);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IMonitorConfig
    public IWebViewMonitorHelper.Config buildConfig() {
        return new IWebViewMonitorHelper.Config();
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        onPageStarted(webView, str);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void onPageStarted(WebView webView, String str) {
        MonitorLog.m29i(TAG, "onPageStarted:" + str);
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        onPageStartedInner(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageStartedInner(WebView webView, String str) {
        CommonEvent commonEvent = new CommonEvent("navigationStart");
        try {
            commonEvent.onEventCreated();
            if (webView == null) {
                return;
            }
            if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            } else {
                commonEvent.getNativeBase().url = str;
                this.monitorHelperImpl.onPageStarted(webView, commonEvent);
            }
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void onPageFinished(WebView webView, String str) {
        MonitorLog.m29i(TAG, "onPageFinished: " + str);
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        onPageFinishedInner(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPageFinishedInner(WebView webView, String str) {
        try {
            if (this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.onPageFinished(webView, str);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void onProgressChanged(WebView webView, int i) {
        MonitorLog.m29i(TAG, "onProgressChanged: " + MonitorLog.getSafeWebViewString(webView) + ", newProgress: " + i);
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        onProgressChangedInner(webView, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onProgressChangedInner(WebView webView, int i) {
        try {
            if (isEnable()) {
                handleProgressChanged(webView, i);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    private void handleProgressChanged(WebView webView, int i) {
        if (webView == null) {
            return;
        }
        try {
            if (this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.onProgressChanged(webView, i);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void onLoadUrl(WebView webView, String str) {
        MonitorLog.m29i(TAG, "onLoadUrl: " + str);
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        onLoadUrlInner(webView, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLoadUrlInner(WebView webView, String str) {
        try {
            if (isEnable() && this.monitorHelperImpl.isNeedMonitor(webView) && !str.contains("javascript:")) {
                this.monitorHelperImpl.onLoadUrl(webView, str);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebCustom
    public void customReport(WebView webView, String str, String str2, String str3, String str4) {
        customReport(webView, null, null, str, str2, str3, str4);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebCustom
    public void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6) {
        customReport(webView, str, str2, JsonUtils.safeToJsonOb(str3), JsonUtils.safeToJsonOb(str4), JsonUtils.safeToJsonOb(str5), (JSONObject) null, 0);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebCustom
    public void customReport(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i) {
        customReportFinal(null, str, str2, str3, jSONObject, jSONObject2, jSONObject3, jSONObject4, i);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebCustom
    public void customReport(WebView webView, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i) {
        customReportFinal(webView, "", str, str2, jSONObject, jSONObject2, jSONObject3, jSONObject4, i);
    }

    private void customReportFinal(WebView webView, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, int i) {
        MonitorLog.m29i(TAG, "custom final: bid: " + str + ", url: " + str2 + ", eventName: " + str3);
        if (jSONObject4 == null) {
            jSONObject4 = new JSONObject();
        }
        if (i < 0 || i > 8) {
            i = 8;
        }
        customReport(webView, new CustomInfo.Builder(str3).setBid(str).setUrl(str2).setCategory(jSONObject).setMetric(jSONObject2).setExtra(jSONObject3).setCommon(jSONObject4).setSample(i).build());
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebCustom
    public void customReport(WebView webView, CustomInfo customInfo) {
        CustomEvent customEvent = new CustomEvent(customInfo);
        if (!isEnable()) {
            customEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
            return;
        }
        if (webView == null) {
            DataReporter.INSTANCE.reportCustomEvent(customEvent, true);
        } else if (!this.monitorHelperImpl.isNeedMonitor(webView)) {
            customEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
        } else {
            this.monitorHelperImpl.customReport(webView, customEvent);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IBusinessCustom
    public void reportGeckoInfo(WebView webView, String str, String str2, String str3) {
        reportGeckoInfo(webView, str, str2, str3, "0");
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IBusinessCustom
    public void reportGeckoInfo(WebView webView, String str, String str2, String str3, String str4) {
        MonitorLog.m29i(TAG, "reportGeckoInfo: " + MonitorLog.getSafeWebViewString(webView) + ", resUrl: " + str3);
        try {
            if (isEnable() && webView != null && !TextUtils.isEmpty(str3) && this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.reportGeckoInfo(webView, str, str2, str3, str4);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IBusinessCustom
    public void reportFallbackPage(WebView webView, FallBackInfo fallBackInfo) {
        try {
            if (isEnable() && webView != null && fallBackInfo != null && this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.reportFallbackPage(webView, fallBackInfo);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IBusinessCustom
    @Deprecated
    public void addContext(WebView webView, String str, Object obj) {
        addContext(webView, str, String.valueOf(obj));
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IBusinessCustom
    public void addContext(WebView webView, String str, String str2) {
        if (isEnable() && this.monitorHelperImpl.isNeedMonitor(webView)) {
            this.monitorHelperImpl.addContext(webView, str, str2);
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void handleContainerError(View view, String str, ContainerBase containerBase, ContainerError containerError) {
        CommonEvent commonEvent = new CommonEvent("containerError");
        commonEvent.onEventCreated();
        try {
            if (!isEnable()) {
                commonEvent.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            if (view != null) {
                if (view instanceof WebView) {
                    commonEvent.setContainerInfo(containerError.toContainerInfo());
                    handleNativeInfoInner((WebView) view, commonEvent, null);
                    return;
                }
                return;
            }
            commonEvent.setContainerBase(containerBase);
            commonEvent.setContainerInfo(containerError.toContainerInfo());
            WebNativeCommon webNativeCommon = new WebNativeCommon();
            webNativeCommon.virtualAid = containerError.getVirtualAid();
            webNativeCommon.containerType = "web";
            WebCommonFieldHandler.INSTANCE.addWebCommonField(str, null, webNativeCommon);
            commonEvent.setNativeBase(webNativeCommon);
            commonEvent.setNativeInfo(new ContainerNativeInfo());
            DataReporter.INSTANCE.reportCommonEvent(commonEvent, null);
        } catch (Throwable th) {
            commonEvent.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void handleViewCreate(WebView webView) {
        MonitorLog.m29i(TAG, "handleViewCreate: " + MonitorLog.getSafeWebViewString(webView));
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        handleViewCreateInner(webView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleViewCreateInner(WebView webView) {
        try {
            if (isEnable() && webView != null) {
                this.monitorHelperImpl.onWebViewCreated(webView);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.InterfaceC1204IWebviewLifeCycle
    public void onAttachedToWindow(WebView webView) {
        MonitorLog.m29i(TAG, webView.getClass().getSimpleName() + " attachToWindow, container: " + webView.getContext().getClass().getName() + ", isTTWebEnable: " + isTTWebEnable());
        if (isTTWebEnable() && this.monitorHelperImpl.isTTWebHookSuccess(webView)) {
            return;
        }
        onAttachedToWindowInner(webView);
    }

    private void onAttachedToWindowInner(WebView webView) {
        try {
            if (isEnable() && webView != null && this.monitorHelperImpl.isNeedMonitor(webView)) {
                this.monitorHelperImpl.onAttachedToWindow(webView);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void handleNativeInfo(View view, String str, JSONObject jSONObject) {
        if (view instanceof WebView) {
            handleNativeInfo((WebView) view, str, jSONObject);
        } else {
            MonitorLog.m27e(TAG, "handleNativeInfo: view not match WebView");
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void customReport(View view, CustomInfo customInfo) {
        if (view instanceof WebView) {
            customReport((WebView) view, customInfo);
        } else {
            MonitorLog.m27e(TAG, "customReport: view not match WebView");
        }
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public void getPerformance(View view, int i, Function1<? super JSONObject, Unit> function1) {
        if (view != null) {
            if (view instanceof WebView) {
                this.monitorHelperImpl.getPerformance((WebView) view, i, function1);
                return;
            } else {
                function1.invoke(new JSONObject());
                return;
            }
        }
        function1.invoke(new JSONObject());
    }

    @Override // com.bytedance.android.monitorV2.standard.ContainerStandardAction
    public EngineInfo getUnifyInfo(View view) {
        if (view != null) {
            if (view instanceof WebView) {
                return this.monitorHelperImpl.getUnifyInfo((WebView) view);
            }
            return new EngineInfo(new NativeCommon());
        }
        return new EngineInfo(new NativeCommon());
    }
}
