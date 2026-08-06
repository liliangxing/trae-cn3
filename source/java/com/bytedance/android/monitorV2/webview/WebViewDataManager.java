package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorWebViewBridge;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.FallBackInfo;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.SwitchConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.settings.MonitorConfig;
import com.bytedance.android.monitorV2.settings.MonitorSettingsCenter;
import com.bytedance.android.monitorV2.settings.WebBlankConfig;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.ExtensionKt;
import com.bytedance.android.monitorV2.util.JsonAccessor;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelperImpl;
import com.bytedance.android.monitorV2.webview.base.IWebBlankCallback;
import com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle;
import com.bytedance.android.monitorV2.webview.blank.DetectResult;
import com.bytedance.android.monitorV2.webview.blank.WebViewBlankDetector;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import com.bytedance.android.monitorV2.webview.ttweb.KernelReporter;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.android.monitorV2.webview.ttweb.TTWebViewCallback;
import com.bytedance.android.monitorV2.webview.ttweb.TTWebViewTimingImpl;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.applog.server.Api;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.extension.TTWebViewExtension;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.webx.blankdetect.BlankUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebViewDataManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u009e\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0016J\u001a\u0010K\u001a\u00020H2\b\u0010L\u001a\u0004\u0018\u00010\t2\u0006\u0010M\u001a\u00020%H\u0016J\u0016\u0010N\u001a\u00020H2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\tJ\u0010\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020\u0013H\u0002J\u0010\u0010V\u001a\u00020H2\u0006\u0010W\u001a\u00020\u0013H\u0002J\u0010\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020\tH\u0016J\u0006\u0010Z\u001a\u00020PJ\n\u0010[\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\\\u001a\u0004\u0018\u00010]J\b\u0010^\u001a\u0004\u0018\u00010_J\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%0aJ\b\u0010b\u001a\u00020HH\u0002J3\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020%2!\u0010e\u001a\u001d\u0012\u0013\u0012\u00110P¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(i\u0012\u0004\u0012\u00020H0fH\u0016J\n\u0010j\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u0004\u0018\u00010\u0004J\b\u0010n\u001a\u00020\tH\u0002J\b\u0010o\u001a\u00020HH\u0002J\u001a\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010t\u001a\u00020H2\u0006\u0010u\u001a\u00020vH\u0016J,\u0010w\u001a\u00020H2\u0006\u0010Q\u001a\u00020\t2\u0006\u0010x\u001a\u00020\t2\u0014\u0010y\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020z\u0018\u00010aJ\b\u0010{\u001a\u00020\u0013H\u0002J\b\u0010|\u001a\u00020\u0013H\u0002J\u0006\u0010*\u001a\u00020\u0013J\u0010\u0010}\u001a\u00020H2\b\u0010s\u001a\u0004\u0018\u00010PJ\u0010\u0010~\u001a\u00020H2\u0006\u0010\u007f\u001a\u00020-H\u0002J\u0011\u0010\u0080\u0001\u001a\u00020\u00132\u0006\u0010x\u001a\u00020\tH\u0002J\u001b\u0010\u0081\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u00020\u00132\u0007\u0010\u0083\u0001\u001a\u000200H\u0002J\t\u0010\u0084\u0001\u001a\u00020HH\u0016J\t\u0010\u0085\u0001\u001a\u00020HH\u0002J\t\u0010\u0086\u0001\u001a\u00020HH\u0016J\t\u0010\u0087\u0001\u001a\u00020HH\u0002J\t\u0010\u0088\u0001\u001a\u00020HH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020H2\u0007\u0010\u008a\u0001\u001a\u00020\u0004H\u0002J\u0011\u0010\u008b\u0001\u001a\u00020H2\u0006\u0010x\u001a\u00020\tH\u0016J\u0011\u0010\u008c\u0001\u001a\u00020H2\u0006\u0010x\u001a\u00020\tH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020H2\u0006\u0010q\u001a\u00020rH\u0016J\u0012\u0010\u008e\u0001\u001a\u00020H2\u0007\u0010\u008f\u0001\u001a\u00020%H\u0016J\t\u0010\u0090\u0001\u001a\u00020HH\u0016J\t\u0010\u0091\u0001\u001a\u00020HH\u0016J\t\u0010\u0092\u0001\u001a\u00020HH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020H2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J-\u0010\u0096\u0001\u001a\u00020H2\u0007\u0010\u0097\u0001\u001a\u00020\t2\u0007\u0010\u0098\u0001\u001a\u00020\t2\u0007\u0010\u0099\u0001\u001a\u00020\t2\u0007\u0010\u009a\u0001\u001a\u00020\tH\u0016J%\u0010\u009b\u0001\u001a\u00020H2\u0006\u0010q\u001a\u00020r2\u0007\u0010\u009c\u0001\u001a\u00020%2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b \u0010!R*\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%0$j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%`&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130$j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013`&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010,\u001a\u001e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0$j\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.`&X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002000$j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000200`&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bC\u0010DR\u000e\u0010F\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009f\u0001"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;", "Lcom/bytedance/android/monitorV2/webview/base/IWebViewLifeCycle;", "webViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/webkit/WebView;", "webViewMonitorHelperImpl", "Lcom/bytedance/android/monitorV2/webview/WebViewMonitorHelperImpl;", "(Ljava/lang/ref/WeakReference;Lcom/bytedance/android/monitorV2/webview/WebViewMonitorHelperImpl;)V", "TAG", "", "autoReportListener", "Lcom/bytedance/android/monitorV2/webview/WebViewDataManager$OnAutoReportListener;", "blankConfig", "Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "getBlankConfig", "()Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "blankConfig$delegate", "Lkotlin/Lazy;", "checkDetached", "", "config", "Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;", "getConfig", "()Lcom/bytedance/android/monitorV2/webview/IWebViewMonitorHelper$Config;", "config$delegate", "currentNavigation", "Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;", "getCurrentNavigation", "()Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;", "setCurrentNavigation", "(Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;)V", "enableKernelBlankLog", "getEnableKernelBlankLog", "()Z", "enableKernelBlankLog$delegate", "extraEventInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "finalDetected", "isBlankDetectedMap", "isFirstNavigation", "isTTWebView", "kernelBlankDetectResult", "lifeDateMap", "Lcom/bytedance/android/monitorV2/webview/WebViewLifeState;", "Lcom/bytedance/android/monitorV2/webview/WebViewLifeData;", "loadTimeMap", "", "loadUrlCount", "mainHandler", "Landroid/os/Handler;", "monitorId", "getMonitorId", "()Ljava/lang/String;", "setMonitorId", "(Ljava/lang/String;)V", "previousNavigation", "switchConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "getSwitchConfig", "()Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;", "setSwitchConfig", "(Lcom/bytedance/android/monitorV2/hybridSetting/entity/SwitchConfig;)V", "webViewLifeState", "webViewRootManager", "Lcom/bytedance/android/monitorV2/webview/WebViewRootManager;", "getWebViewRootManager", "()Lcom/bytedance/android/monitorV2/webview/WebViewRootManager;", "webViewRootManager$delegate", "webViewVersion", "addContext", "", Api.KEY_ENCRYPT_RESP_KEY, "value", "addExtraEventInfo", "type", "state", "cover", "json", "Lorg/json/JSONObject;", "eventType", "customReport", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "disableFinalDetectWhenDetached", "finalDetect", "check", "forceReport", "reportType", "generateWebViewNativeBase", "getClientConfig", "getContainerBase", "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "getContainerInfo", "Lcom/bytedance/android/monitorV2/entity/ContainerInfo;", "getExtraEventInfo", "", "getKernelErrorInfo", "getPerformance", "waitCompleteData", "performanceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "performanceResult", "getPrevNavigationManager", "getUnifyInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "getWebView", "getWebViewVersion", "handleBlankDetect", "handleNativeInfo", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "jsonObject", "handleRenderProcessGone", "webdetail", "Landroid/webkit/RenderProcessGoneDetail;", "handleSPPMonitorInfo", "url", "params", "", "isDestroy", "isReuse", "jsReport", "markLifeCycle", "lifeState", "needHandleBlankWhenLoadUrl", "obtainLatestJsCacheData", "isReport", "waitTime", "onAttachedToWindow", "onAttachedToWindowInner", "onDestroy", "onDetachedToWindow", "onGoBack", "onKernelDetected", "webView", "onLoadUrl", "onPageFinished", "onPageStarted", "onProgressChanged", "newProgress", "onReload", "onViewCreate", "registerJsInterface", "reportFallbackPage", "fallBackInfo", "Lcom/bytedance/android/monitorV2/entity/FallBackInfo;", "reportGeckoInfo", "resStatus", "resType", "resUrl", "resVersion", "updateUnifyError", AlogMonitor.ALOG_RESULT_CODE, "message", "OnAutoReportListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebViewDataManager implements IWebViewLifeCycle {
    private final String TAG;
    private OnAutoReportListener autoReportListener;

    /* renamed from: blankConfig$delegate, reason: from kotlin metadata */
    private final Lazy blankConfig;
    private boolean checkDetached;

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config;
    private NavigationDataManager currentNavigation;

    /* renamed from: enableKernelBlankLog$delegate, reason: from kotlin metadata */
    private final Lazy enableKernelBlankLog;
    private final HashMap<String, Integer> extraEventInfo;
    private boolean finalDetected;
    private final HashMap<String, Boolean> isBlankDetectedMap;
    private boolean isFirstNavigation;
    private boolean isTTWebView;
    private boolean kernelBlankDetectResult;
    private HashMap<WebViewLifeState, WebViewLifeData> lifeDateMap;
    private HashMap<String, Long> loadTimeMap;
    private int loadUrlCount;
    private final Handler mainHandler;
    private String monitorId;
    private NavigationDataManager previousNavigation;
    private SwitchConfig switchConfig;
    private WebViewLifeState webViewLifeState;
    private WebViewMonitorHelperImpl webViewMonitorHelperImpl;
    private WeakReference<WebView> webViewRef;

    /* renamed from: webViewRootManager$delegate, reason: from kotlin metadata */
    private final Lazy webViewRootManager;
    private final String webViewVersion;

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onReload() {
    }

    public WebViewDataManager(WeakReference<WebView> weakReference, WebViewMonitorHelperImpl webViewMonitorHelperImpl) {
        Intrinsics.checkNotNullParameter(weakReference, "webViewRef");
        Intrinsics.checkNotNullParameter(webViewMonitorHelperImpl, "webViewMonitorHelperImpl");
        this.webViewRef = weakReference;
        this.webViewMonitorHelperImpl = webViewMonitorHelperImpl;
        this.TAG = "WebViewDataManager";
        this.monitorId = "";
        SwitchConfig switchConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch();
        Intrinsics.checkNotNullExpressionValue(switchConfig, "getInstance().hybridSettingManager.switch");
        this.switchConfig = switchConfig;
        this.config = LazyKt.lazy(new Function0<IWebViewMonitorHelper.Config>() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IWebViewMonitorHelper.Config m385invoke() {
                IWebViewMonitorHelper.Config clientConfig;
                clientConfig = WebViewDataManager.this.getClientConfig();
                return clientConfig;
            }
        });
        this.lifeDateMap = new HashMap<>();
        this.loadTimeMap = new HashMap<>();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.extraEventInfo = new HashMap<>();
        this.webViewVersion = getWebViewVersion();
        this.isFirstNavigation = true;
        this.kernelBlankDetectResult = true;
        this.webViewRootManager = LazyKt.lazy(new Function0<WebViewRootManager>() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$webViewRootManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WebViewRootManager m387invoke() {
                IWebViewMonitorHelper.Config config = WebViewDataManager.this.getConfig();
                return new WebViewRootManager(config != null ? config.mBid : null);
            }
        });
        this.blankConfig = LazyKt.lazy(new Function0<WebBlankConfig>() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$blankConfig$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WebBlankConfig m384invoke() {
                WebBlankConfig webBlankConfig;
                MonitorSettingsCenter settingsCenter = SettingsParseManager.INSTANCE.getSettingsCenter();
                return (settingsCenter == null || (webBlankConfig = (WebBlankConfig) settingsCenter.obtainSettings(WebBlankConfig.class)) == null) ? WebBlankConfig.INSTANCE.getDEFAULT() : webBlankConfig;
            }
        });
        this.enableKernelBlankLog = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$enableKernelBlankLog$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m386invoke() {
                MonitorConfig monitorConfig;
                MonitorSettingsCenter settingsCenter = SettingsParseManager.INSTANCE.getSettingsCenter();
                return Boolean.valueOf((settingsCenter == null || (monitorConfig = (MonitorConfig) settingsCenter.obtainSettings(MonitorConfig.class)) == null) ? true : monitorConfig.getEnableKernelBlankLog());
            }
        });
        this.isBlankDetectedMap = new HashMap<>();
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final void setMonitorId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.monitorId = str;
    }

    public final SwitchConfig getSwitchConfig() {
        return this.switchConfig;
    }

    public final void setSwitchConfig(SwitchConfig switchConfig) {
        Intrinsics.checkNotNullParameter(switchConfig, "<set-?>");
        this.switchConfig = switchConfig;
    }

    public final IWebViewMonitorHelper.Config getConfig() {
        return (IWebViewMonitorHelper.Config) this.config.getValue();
    }

    public final NavigationDataManager getCurrentNavigation() {
        return this.currentNavigation;
    }

    public final void setCurrentNavigation(NavigationDataManager navigationDataManager) {
        this.currentNavigation = navigationDataManager;
    }

    private final WebViewRootManager getWebViewRootManager() {
        return (WebViewRootManager) this.webViewRootManager.getValue();
    }

    public final WebBlankConfig getBlankConfig() {
        return (WebBlankConfig) this.blankConfig.getValue();
    }

    private final boolean getEnableKernelBlankLog() {
        return ((Boolean) this.enableKernelBlankLog.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onViewCreate() {
        this.currentNavigation = new NavigationDataManager(this);
        markLifeCycle(WebViewLifeState.CREATED);
        WebView webView = getWebView();
        if (webView != null) {
            if (this.autoReportListener == null) {
                this.autoReportListener = new OnAutoReportListener();
            }
            OnAutoReportListener onAutoReportListener = this.autoReportListener;
            if (onAutoReportListener != null) {
                onAutoReportListener.bindWebView(webView);
            }
        }
        registerJsInterface();
        WebView webView2 = getWebView();
        if (webView2 != null) {
            new TTWebViewExtension(webView2).setPerformanceTimingListener(new TTWebViewTimingImpl(new TTWebViewCallback() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$onViewCreate$2$1
                @Override // com.bytedance.android.monitorV2.webview.ttweb.TTWebViewCallback
                public void blankDetect(boolean result) {
                    WebViewDataManager.this.kernelBlankDetectResult = result;
                }
            }));
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onAttachedToWindow() {
        if (this.autoReportListener == null) {
            MonitorLog.m27e(this.TAG, "handleViewCreated not work, onAttachedToWindow invoked");
            registerJsInterface();
            onAttachedToWindowInner();
        }
        WebView webView = getWebView();
        if (webView != null) {
            ContainerDataCache.INSTANCE.getAttachedMonitorIdAsync(webView, new ContainerDataCache.IdQueryCallback() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$onAttachedToWindow$1$1
                @Override // com.bytedance.android.monitorV2.standard.ContainerDataCache.IdQueryCallback
                public void onIdQueryFinished(String monitorId) {
                    Intrinsics.checkNotNullParameter(monitorId, "monitorId");
                    WebViewDataManager.this.setMonitorId(monitorId);
                }
            });
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onProgressChanged(int newProgress) {
        WebView webView = getWebView();
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.onProgressChanged(newProgress);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onLoadUrl(String url) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        boolean z = true;
        this.loadUrlCount++;
        this.loadTimeMap.put(url, Long.valueOf(System.currentTimeMillis()));
        if (needHandleBlankWhenLoadUrl(url)) {
            obtainLatestJsCacheData(false, 30L);
            handleBlankDetect();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("engine_type", "web");
        linkedHashMap.put("url", url);
        WebView webView = this.webViewRef.get();
        if (webView != null) {
            List<String> attachedMonitorId = ContainerDataCache.INSTANCE.getAttachedMonitorId(webView);
            List<String> list = attachedMonitorId;
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (!z && (obj = ContainerDataCache.INSTANCE.getContainerBase(attachedMonitorId.get(0)).get("container_name")) != null) {
                linkedHashMap.put("container_name", (String) obj);
            }
        }
        InternalWatcher.notice$default(InternalWatcher.INSTANCE, null, InternalWatcher.EVENT_URL_LOAD, linkedHashMap, null, 8, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if (r9.loadTimeMap.remove(r0) == null) goto L34;
     */
    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageStarted(CommonEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String str = event.getNativeBase().url;
        NavigationDataManager previousNavigation = getPreviousNavigation();
        if (previousNavigation != null) {
            previousNavigation.handlePageExit();
        }
        if (this.previousNavigation != null) {
            this.previousNavigation = null;
        }
        if (WebViewMonitorConstant.Web.BLOCK_LIST.contains(str)) {
            this.currentNavigation = null;
            this.previousNavigation = null;
            event.onEventTerminated(HybridEvent.TerminateType.BLOCK_LIST);
            return;
        }
        Long l = this.loadTimeMap.get(str);
        if (l != null) {
            if (this.currentNavigation == null) {
                Intrinsics.checkNotNullExpressionValue(str, "url");
                this.currentNavigation = new NavigationDataManager(this, str);
            }
            if (!this.isFirstNavigation) {
                Intrinsics.checkNotNullExpressionValue(str, "url");
                this.currentNavigation = new NavigationDataManager(this, str);
            }
            NavigationDataManager navigationDataManager = this.currentNavigation;
            if (navigationDataManager != null) {
                String url = navigationDataManager.getUrl();
                if (url == null || url.length() == 0) {
                    navigationDataManager.setUrl(str);
                }
                navigationDataManager.markFirstPageStart(true);
                navigationDataManager.markLoadUrl(l.longValue());
            }
        }
        Intrinsics.checkNotNullExpressionValue(str, "url");
        NavigationDataManager navigationDataManager2 = new NavigationDataManager(this, str);
        this.currentNavigation = navigationDataManager2;
        navigationDataManager2.markLoadUrl(System.currentTimeMillis());
        Unit unit = Unit.INSTANCE;
        NavigationDataManager previousNavigation2 = getPreviousNavigation();
        if (previousNavigation2 != null && TextUtils.equals(str, previousNavigation2.getUrl()) && !previousNavigation2.isPageStartValidate()) {
            NavigationDataManager navigationDataManager3 = this.currentNavigation;
            if (navigationDataManager3 != null) {
                navigationDataManager3.setInjectJs(false);
            }
            HashMap hashMap = new HashMap();
            Intrinsics.checkNotNullExpressionValue(str, "url");
            hashMap.put(InternalWatcher.PARAM_REPEAT_PAGE_START_URL, str);
            InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_REPEAT_PAGE_START, hashMap, null);
            return;
        }
        NavigationDataManager navigationDataManager4 = this.currentNavigation;
        if (navigationDataManager4 != null) {
            navigationDataManager4.onPageStarted(event);
        }
        this.previousNavigation = this.currentNavigation;
        this.isFirstNavigation = false;
        this.checkDetached = true;
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onPageFinished(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.onPageFinished();
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void handleRenderProcessGone(RenderProcessGoneDetail webdetail) {
        Intrinsics.checkNotNullParameter(webdetail, "webdetail");
        WebView webView = getWebView();
        if (webView == null) {
            return;
        }
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url) || url == null) {
            return;
        }
        if (this.currentNavigation == null) {
            this.currentNavigation = new NavigationDataManager(this, url);
        }
        MonitorLog.m26d(this.TAG, "handleRenderProcessGone: ");
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void customReport(CustomEvent customEvent) {
        Unit unit;
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.postCustomEvent(customEvent);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            customEvent.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void addContext(String key, String value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.addContext(key, value);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void forceReport(String reportType) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        if (Intrinsics.areEqual("report_blank_detect", reportType)) {
            handleBlankDetect();
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void reportGeckoInfo(String resStatus, String resType, String resUrl, String resVersion) {
        Intrinsics.checkNotNullParameter(resStatus, "resStatus");
        Intrinsics.checkNotNullParameter(resType, "resType");
        Intrinsics.checkNotNullParameter(resUrl, "resUrl");
        Intrinsics.checkNotNullParameter(resVersion, "resVersion");
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "res_status", resStatus);
        JsonUtils.safePut(jSONObject, "res_type", resType);
        JsonUtils.safePut(jSONObject, "res_url", resUrl);
        JsonUtils.safePut(jSONObject, "container", "web");
        JsonUtils.safePut(jSONObject, "res_version", resVersion);
        CustomInfo build = new CustomInfo.Builder("bd_monitor_get_resource").setBid("").setCategory(jSONObject).setMetric(null).setExtra(null).setCommon(new JSONObject()).setSample(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "customInfo");
        customReport(new CustomEvent(build));
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void addExtraEventInfo(String type, int state) {
        if (type != null) {
            this.extraEventInfo.put(type, Integer.valueOf(state));
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void reportFallbackPage(FallBackInfo fallBackInfo) {
        Intrinsics.checkNotNullParameter(fallBackInfo, "fallBackInfo");
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "source_container", fallBackInfo.sourceContainer);
        JsonUtils.safePut(jSONObject, "source_url", fallBackInfo.sourceUrl);
        JsonUtils.safePut(jSONObject, "fallback_type", fallBackInfo.fallbackType);
        JsonUtils.safePut(jSONObject, "target_container", fallBackInfo.targetContainer);
        JsonUtils.safePut(jSONObject, "target_url", fallBackInfo.targetUrl);
        CustomInfo build = new CustomInfo.Builder("bd_monitor_fallback_page").setBid("").setCategory(jSONObject).setMetric(null).setExtra(null).setCommon(new JSONObject()).setSample(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "customInfo");
        customReport(new CustomEvent(build));
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void handleNativeInfo(CommonEvent event, JSONObject jsonObject) {
        Unit unit;
        Intrinsics.checkNotNullParameter(event, "event");
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.postNativeEvent(event, jsonObject);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            event.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void getPerformance(int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.getPerformance(waitCompleteData, performanceCallback);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            performanceCallback.invoke(new JSONObject());
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public EngineInfo getUnifyInfo() {
        EngineInfo unifyInfo;
        NavigationDataManager navigationDataManager = this.currentNavigation;
        return (navigationDataManager == null || (unifyInfo = navigationDataManager.getUnifyInfo()) == null) ? new EngineInfo(new NativeCommon()) : unifyInfo;
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void updateUnifyError(CommonEvent event, int code, String message) {
        Intrinsics.checkNotNullParameter(event, "event");
        NavigationDataManager navigationDataManager = this.currentNavigation;
        if (navigationDataManager != null) {
            navigationDataManager.updateUnifyError(event, code, message);
        }
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onDestroy() {
        OnAutoReportListener onAutoReportListener;
        finalDetect(true);
        markLifeCycle(WebViewLifeState.DESTROYED);
        WebView webView = getWebView();
        if (webView == null || (onAutoReportListener = this.autoReportListener) == null) {
            return;
        }
        onAutoReportListener.unbindWebView(webView);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebViewLifeCycle
    public void onGoBack() {
        handleBlankDetect();
        obtainLatestJsCacheData(false, 30L);
    }

    public final WebView getWebView() {
        WebView webView = this.webViewRef.get();
        if (webView == null) {
            MonitorLog.m27e(this.TAG, "get webView from weakRef: null");
        }
        return webView;
    }

    public final void cover(JSONObject json, String eventType) {
        NavigationDataManager navigationDataManager;
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (!Intrinsics.areEqual(eventType, "perf") || (navigationDataManager = this.currentNavigation) == null) {
            return;
        }
        navigationDataManager.coverPerfData(json);
    }

    public final boolean isTTWebView() {
        try {
            WebView webView = getWebView();
            if (webView != null) {
                return TTWebSdk.isTTWebView(webView);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final ContainerBase getContainerBase() {
        ContainerBase containerBaseByView;
        WebView webView = getWebView();
        if (webView == null || (containerBaseByView = ContainerDataCache.INSTANCE.getContainerBaseByView(webView)) == null) {
            return null;
        }
        return containerBaseByView;
    }

    public final ContainerInfo getContainerInfo() {
        ContainerInfo containerInfoByView;
        WebView webView = getWebView();
        if (webView == null || (containerInfoByView = ContainerDataCache.INSTANCE.getContainerInfoByView(webView)) == null) {
            return null;
        }
        return containerInfoByView;
    }

    public final Map<String, Integer> getExtraEventInfo() {
        return MapsKt.toMap(this.extraEventInfo);
    }

    public final JSONObject generateWebViewNativeBase() {
        JSONObject jSONObject = new JSONObject();
        WebViewLifeData webViewLifeData = this.lifeDateMap.get(WebViewLifeState.ATTACHED);
        JsonUtils.safePut(jSONObject, "attach_ts", webViewLifeData != null ? Long.valueOf(webViewLifeData.getTimestamp()) : null);
        WebViewLifeData webViewLifeData2 = this.lifeDateMap.get(WebViewLifeState.DETACHED);
        JsonUtils.safePut(jSONObject, "detach_ts", webViewLifeData2 != null ? Long.valueOf(webViewLifeData2.getTimestamp()) : null);
        WebViewLifeData webViewLifeData3 = this.lifeDateMap.get(WebViewLifeState.CREATED);
        JsonUtils.safePut(jSONObject, "container_init_ts", webViewLifeData3 != null ? Long.valueOf(webViewLifeData3.getTimestamp()) : null);
        JsonUtils.safePut(jSONObject, "container_reuse", Boolean.valueOf(isReuse()));
        JsonUtils.safePut(jSONObject, ReportConst.WEB_VERSION, this.webViewVersion);
        return jSONObject;
    }

    public final void jsReport(JSONObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        String safeOptStr = JsonUtils.safeOptStr(jsonObject, "serviceType");
        if (Intrinsics.areEqual(safeOptStr, "")) {
            NavigationDataManager navigationDataManager = this.currentNavigation;
            if (navigationDataManager != null) {
                navigationDataManager.postCustomInfo(jsonObject);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(safeOptStr, "perf")) {
            JsonUtils.safeOptStr(jsonObject, "url");
            NavigationDataManager navigationDataManager2 = this.currentNavigation;
            if (navigationDataManager2 != null) {
                navigationDataManager2.coverPerfData(jsonObject);
                return;
            }
            return;
        }
        NavigationDataManager navigationDataManager3 = this.currentNavigation;
        if (navigationDataManager3 != null) {
            navigationDataManager3.postJsData(safeOptStr, jsonObject);
        }
    }

    private final void markLifeCycle(WebViewLifeState lifeState) {
        this.webViewLifeState = lifeState;
        this.lifeDateMap.put(lifeState, new WebViewLifeData(System.currentTimeMillis()));
    }

    /* renamed from: getPrevNavigationManager, reason: from getter */
    private final NavigationDataManager getPreviousNavigation() {
        return this.previousNavigation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAttachedToWindowInner() {
        markLifeCycle(WebViewLifeState.ATTACHED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDetachedToWindow() {
        markLifeCycle(WebViewLifeState.DETACHED);
        if (disableFinalDetectWhenDetached()) {
            return;
        }
        finalDetect(this.checkDetached);
    }

    private final boolean disableFinalDetectWhenDetached() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            WebView webView = this.webViewRef.get();
            obj = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(Uri.parse(webView != null ? webView.getUrl() : null).getQueryParameter("disable_final_detect_when_detached"), "1")));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    private final boolean needHandleBlankWhenLoadUrl(String url) {
        if (!TextUtils.isEmpty(url) && !Intrinsics.areEqual("about:blank", url)) {
            return false;
        }
        NavigationDataManager navigationDataManager = this.currentNavigation;
        String url2 = navigationDataManager != null ? navigationDataManager.getUrl() : null;
        return (TextUtils.isEmpty(url2) || Intrinsics.areEqual(url2, "about:blank")) ? false : true;
    }

    private final boolean isReuse() {
        return this.loadUrlCount > 1;
    }

    private final boolean isDestroy() {
        WebViewLifeState webViewLifeState = this.webViewLifeState;
        return (webViewLifeState != null ? webViewLifeState.ordinal() : WebViewLifeState.CREATED.ordinal()) >= WebViewLifeState.DESTROYED.ordinal();
    }

    public final void handleSPPMonitorInfo(String eventType, String url, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(url, "url");
        getWebViewRootManager().handleSPPMonitorInfo(eventType, this.currentNavigation, url, params);
    }

    private final void handleBlankDetect() {
        Object obj;
        CommonEvent create$default;
        DetectResult detectResult;
        IWebBlankCallback iWebBlankCallback;
        boolean z;
        NavigationDataManager navigationDataManager;
        BidInfo.BidConfig navigationBidConfig;
        try {
            Result.Companion companion = Result.Companion;
            create$default = CommonEvent.Companion.create$default(CommonEvent.INSTANCE, "blank", null, 2, null);
            if (HostExperimentManager.INSTANCE.getEnablePreSample()) {
                NavigationDataManager navigationDataManager2 = this.currentNavigation;
                if (navigationDataManager2 != null && navigationDataManager2.getBidExactly()) {
                    NavigationDataManager navigationDataManager3 = this.currentNavigation;
                    if (!Intrinsics.areEqual(navigationDataManager3 != null ? navigationDataManager3.getNavigationBid() : null, BidInfo.DEFAULT) && (navigationDataManager = this.currentNavigation) != null && (navigationBidConfig = navigationDataManager.getNavigationBidConfig()) != null) {
                        if (!ConvertUtil.isReportForWebSample("blank", navigationBidConfig)) {
                            create$default.onEventSampled();
                            MonitorLog.m29i(this.TAG, "WebView blank detect canceled due to sampling");
                            return;
                        }
                        create$default.setHitSample(true);
                    }
                }
            }
            NavigationDataManager navigationDataManager4 = this.currentNavigation;
            if (navigationDataManager4 != null) {
                InternalWatcher.notice$default(InternalWatcher.INSTANCE, navigationDataManager4.getWebNativeCommon().navigationId, InternalWatcher.EVENT_BLANK_CHECK, null, null, 12, null);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (isDestroy()) {
            create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
            return;
        }
        WebView webView = getWebView();
        if (webView == null) {
            WebViewDataManager webViewDataManager = this;
            create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
            return;
        }
        if (webView.getUrl() != null && !Intrinsics.areEqual(webView.getUrl(), "about:blank")) {
            HashMap<String, Boolean> hashMap = this.isBlankDetectedMap;
            String url = webView.getUrl();
            Intrinsics.checkNotNull(url);
            if (Intrinsics.areEqual(hashMap.get(url), true)) {
                create$default.onEventTerminated(HybridEvent.TerminateType.EVENT_REPEATED);
                return;
            }
            HashMap<String, Boolean> hashMap2 = this.isBlankDetectedMap;
            String url2 = webView.getUrl();
            Intrinsics.checkNotNull(url2);
            hashMap2.put(url2, true);
            if (!this.switchConfig.isWebEnableBlank()) {
                create$default.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
                return;
            }
            NavigationDataManager navigationDataManager5 = this.currentNavigation;
            if (navigationDataManager5 != null) {
                String[] urlBlockList = getBlankConfig().getUrlBlockList();
                int length = urlBlockList.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    String str = urlBlockList[i];
                    String url3 = navigationDataManager5.getUrl();
                    if (url3 == null) {
                        url3 = "";
                    }
                    if (StringsKt.contains$default(url3, str, false, 2, (Object) null)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
                    return;
                } else if (System.currentTimeMillis() - navigationDataManager5.getInitTime() < getBlankConfig().getStayDuration()) {
                    create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
                    return;
                }
            }
            if (getBlankConfig().getUseMonitorDetect()) {
                if (!HostExperimentManager.INSTANCE.getEnableKernelBlankDetect() && getBlankConfig().getMonitorDetectType() != 1) {
                    MonitorLog.m29i(this.TAG, "final pixel detect");
                    detectResult = WebViewBlankDetector.INSTANCE.pixelDetect(webView);
                }
                MonitorLog.m29i(this.TAG, "kernel detect is blank: " + this.kernelBlankDetectResult);
                detectResult = new DetectResult();
                detectResult.setBlankState(this.kernelBlankDetectResult ? 1 : 2);
            } else {
                detectResult = new DetectResult();
                BlankUtils.DetectorResult detectorResultFast = BlankUtils.getDetectorResultFast(webView);
                detectResult.setBlankState(detectorResultFast.blankState);
                detectResult.setCostTime(detectorResultFast.costTime);
                detectResult.setErrorCode(detectorResultFast.errorCode);
                detectResult.setErrorMsg(detectorResultFast.errorMsg);
            }
            JSONObject jSONObject = new JSONObject();
            JsonUtils.safePut(jSONObject, "event_type", "blank");
            JsonUtils.safePut(jSONObject, "is_blank", detectResult.getBlankState() == 1 ? 1 : 0);
            JsonUtils.safePut(jSONObject, "detect_type", getBlankConfig().getMonitorDetectType());
            JsonUtils.safePut(jSONObject, "cost_time", detectResult.getCostTime());
            JsonUtils.safePut(jSONObject, "collect_time", detectResult.getCollectTime());
            JsonUtils.safePut(jSONObject, "calculate_time", detectResult.getCalculateTime());
            if (detectResult.getBlankState() == 3) {
                JsonUtils.safePut(jSONObject, "error_code", detectResult.getErrorCode());
                JsonUtils.safePut(jSONObject, "error_msg", detectResult.getErrorMsg());
            }
            IWebViewMonitorHelper.Config config = getConfig();
            if (config != null && (iWebBlankCallback = config.mWebBlankCallback) != null) {
                Intrinsics.checkNotNullExpressionValue(iWebBlankCallback, "mWebBlankCallback");
                iWebBlankCallback.onDetectCost(webView, detectResult.getCostTime());
                iWebBlankCallback.onDetectResult(webView, detectResult.getBlankState());
            }
            JsonUtils.safePut(jSONObject, "detect_start_time", System.currentTimeMillis() - detectResult.getCostTime());
            NavigationDataManager navigationDataManager6 = this.currentNavigation;
            if (navigationDataManager6 != null) {
                JsonUtils.safePut(jSONObject, WebViewMonitorConstant.Blank.PAGE_STAY_DURATION, System.currentTimeMillis() - navigationDataManager6.getInitTime());
            }
            try {
                int i2 = TTNetInit.getNetworkQuality().httpRttMs;
                int i3 = TTNetInit.getNetworkQuality().transportRttMs;
                JSONObject jSONObject2 = new JSONObject();
                if (i2 != 0) {
                    JsonUtils.safePut(jSONObject2, "http_rtt_ms", i2);
                }
                if (i3 != 0) {
                    JsonUtils.safePut(jSONObject2, "transport_rtt_ms", i3);
                }
                Unit unit = Unit.INSTANCE;
                JsonUtils.safePut(jSONObject, MonitorConstant.ASSIST_INFO, jSONObject2);
            } catch (Throwable unused) {
                MonitorLog.m29i(this.TAG, "CronetEngine is not created maybe");
            }
            NavigationDataManager navigationDataManager7 = this.currentNavigation;
            if (navigationDataManager7 != null) {
                JsonUtils.merge(jSONObject, navigationDataManager7.getEngineInfo().toJsonObject());
            }
            NavigationDataManager navigationDataManager8 = this.currentNavigation;
            if (navigationDataManager8 != null) {
                navigationDataManager8.postNativeEvent(create$default, jSONObject);
            }
            NavigationDataManager navigationDataManager9 = this.currentNavigation;
            if (navigationDataManager9 != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int blankState = detectResult.getBlankState();
                if (blankState == 1) {
                    linkedHashMap.put("result", "1");
                    InternalWatcher.notice$default(InternalWatcher.INSTANCE, navigationDataManager9.getWebNativeCommon().navigationId, InternalWatcher.EVENT_BLANK_RESULT, linkedHashMap, null, 8, null);
                } else if (blankState != 2) {
                    linkedHashMap.put(InternalWatcher.PARAM_SPEC_ERROR_MSG, "code:" + detectResult.getErrorCode() + ", msg:" + detectResult.getErrorMsg());
                    linkedHashMap.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, "web blank check fail");
                    InternalWatcher.notice$default(InternalWatcher.INSTANCE, navigationDataManager9.getWebNativeCommon().navigationId, InternalWatcher.EVENT_INTERNAL_ERROR, linkedHashMap, null, 8, null);
                } else {
                    linkedHashMap.put("result", "0");
                    InternalWatcher.notice$default(InternalWatcher.INSTANCE, navigationDataManager9.getWebNativeCommon().navigationId, InternalWatcher.EVENT_BLANK_RESULT, linkedHashMap, null, 8, null);
                }
            }
            onKernelDetected(webView);
            MonitorLog.m26d(this.TAG, "handleBlankDetect: session: " + this.monitorId + ", webView url: " + webView.getUrl() + ", result: " + (detectResult.getBlankState() == 1));
            obj = Result.constructor-impl(Unit.INSTANCE);
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                ExceptionUtil.handleException(th2);
                return;
            }
            return;
        }
        create$default.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
    }

    private final void onKernelDetected(WebView webView) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hm_webView_visibility", webView.getVisibility() == 0);
        jSONObject.put("hm_webView_reuse", isReuse());
        jSONObject.put("hm_webView_load", this.loadUrlCount);
        JSONObject jSONObject2 = new JSONObject();
        WebViewLifeData webViewLifeData = this.lifeDateMap.get(WebViewLifeState.CREATED);
        jSONObject2.put("hm_webView_sd", System.currentTimeMillis() - (webViewLifeData != null ? webViewLifeData.getTimestamp() : System.currentTimeMillis()));
        jSONObject2.put("hm_webView_width", webView.getWidth());
        jSONObject2.put("hm_webView_height", webView.getHeight());
        KernelReporter.INSTANCE.reportKernelBlankDetect(webView, this.kernelBlankDetectResult, getBlankConfig(), jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IWebViewMonitorHelper.Config getClientConfig() {
        WebViewMonitorHelperImpl.ConfigObj config = this.webViewMonitorHelperImpl.getConfig(getWebView());
        MonitorLog.m29i(this.TAG, "use config " + config);
        IWebViewMonitorHelper.Config config2 = config.getConfig();
        if ((config2 != null ? config2.sourceMonitor : null) != null && getWebView() != null) {
            HashMap hashMap = new HashMap();
            WebView webView = getWebView();
            hashMap.put(InternalWatcher.PARAM_CONFIG_FROM_CLASS, String.valueOf(webView != null ? webView.getClass() : null));
            InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_INTERFACE_MONITOR, hashMap, null);
        }
        return config.getConfig();
    }

    private final void registerJsInterface() {
        String str;
        WebViewMonitorJsBridge webViewMonitorJsBridge = new WebViewMonitorJsBridge(this);
        WebView webView = getWebView();
        if (webView != null) {
            if (!webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            MonitorLog.m29i(this.TAG, "registerJsInterface");
            webView.addJavascriptInterface(webViewMonitorJsBridge, "iesJsBridgeTransferMonitor");
            IWebViewMonitorHelper.Config config = getConfig();
            if (config == null || (str = config.mSessionId) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(str, "mSessionId");
            webView.addJavascriptInterface(new SLMonitorWebViewBridge(str), "hybridMonitor");
        }
    }

    private final void obtainLatestJsCacheData(boolean isReport, long waitTime) {
        WebView webView = getWebView();
        if (webView == null) {
            return;
        }
        String str = isReport ? "true" : "false";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(" javascript: (function () {\n                    var target = {}\n                    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n                    var performacess = SlardarHybrid('getLatestPerformance');\n                    var resourcess = SlardarHybrid('getLatestResource');\n                    var cacheData = SlardarHybrid('flushCacheData');\n                    target.performance = performacess;\n                    target.resource = resourcess;\n                    target.cacheData = cacheData;\n                    target.needReport = %s;\n                    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n                })()", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        webView.evaluateJavascript(format, null);
    }

    private final void finalDetect(boolean check) {
        WebDataHandler dataHandler;
        if (check && !this.finalDetected) {
            this.finalDetected = true;
            obtainLatestJsCacheData(true, 30L);
            getKernelErrorInfo();
            handleBlankDetect();
            NavigationDataManager navigationDataManager = this.currentNavigation;
            if (navigationDataManager != null && (dataHandler = navigationDataManager.getDataHandler()) != null) {
                dataHandler.notifyAllEvents();
            }
            this.mainHandler.postDelayed(new Runnable() { // from class: com.bytedance.android.monitorV2.webview.WebViewDataManager$finalDetect$1
                @Override // java.lang.Runnable
                public final void run() {
                    NavigationDataManager currentNavigation = WebViewDataManager.this.getCurrentNavigation();
                    if (currentNavigation != null) {
                        currentNavigation.handlePageExit();
                    }
                }
            }, 150L);
        }
    }

    private final String getWebViewVersion() {
        WebSettings settings;
        try {
            WebView webView = getWebView();
            String userAgentString = (webView == null || (settings = webView.getSettings()) == null) ? null : settings.getUserAgentString();
            if (userAgentString == null) {
                userAgentString = "";
            }
            int indexOf$default = StringsKt.indexOf$default(userAgentString, "Chrome/", 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                indexOf$default += 7;
            }
            String substring = userAgentString.substring(indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            List split$default = StringsKt.split$default(substring, new String[]{" "}, false, 0, 6, (Object) null);
            return split$default.isEmpty() ^ true ? (String) split$default.get(0) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private final void getKernelErrorInfo() {
        JSONArray jArr$default;
        WebView webView = getWebView();
        if (webView != null) {
            JSONObject tTWebViewMetrics = TTUtils.INSTANCE.getTTWebViewMetrics(webView, TTUtils.MetricsArgs.Errors);
            NavigationDataManager navigationDataManager = this.currentNavigation;
            if (navigationDataManager != null) {
                JsonAccessor jsonAccessor = new JsonAccessor(tTWebViewMetrics);
                EngineInfo engineInfo = navigationDataManager.getEngineInfo();
                String str$default = JsonAccessor.getStr$default(jsonAccessor, "webview_error.render_status", null, 2, null);
                if (str$default == null) {
                    str$default = "";
                }
                engineInfo.setRenderStatus$anniex_release(str$default);
                EngineInfo engineInfo2 = navigationDataManager.getEngineInfo();
                String str$default2 = JsonAccessor.getStr$default(jsonAccessor, "webview_error.dom_state", null, 2, null);
                if (str$default2 == null) {
                    str$default2 = "";
                }
                engineInfo2.setDomState$anniex_release(str$default2);
                EngineInfo engineInfo3 = navigationDataManager.getEngineInfo();
                String str$default3 = JsonAccessor.getStr$default(jsonAccessor, "webview_error.rendering_phase", null, 2, null);
                if (str$default3 == null) {
                    str$default3 = "";
                }
                engineInfo3.setRenderingPhase$anniex_release(str$default3);
                EngineInfo engineInfo4 = navigationDataManager.getEngineInfo();
                String str$default4 = JsonAccessor.getStr$default(jsonAccessor, "webview_error.js_hang", null, 2, null);
                engineInfo4.setJsHang$anniex_release(str$default4 != null ? str$default4 : "");
                JSONObject jObj$default = ExtensionKt.getJObj$default(tTWebViewMetrics, "webview_error", null, 2, null);
                if (jObj$default != null && (jArr$default = ExtensionKt.getJArr$default(jObj$default, "js_error", null, 2, null)) != null) {
                    EngineInfo engineInfo5 = navigationDataManager.getEngineInfo();
                    engineInfo5.setJsExceptionCount$anniex_release(engineInfo5.getJsExceptionCount() + jArr$default.length());
                }
            }
            if (getEnableKernelBlankLog()) {
                MonitorLog.m29i(this.TAG, "KernelErrorInfo: WebView: " + webView + ", Url: " + webView.getUrl() + ", KernelInfo: " + tTWebViewMetrics);
            }
        }
    }

    /* compiled from: WebViewDataManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebViewDataManager$OnAutoReportListener;", "Landroid/view/View$OnAttachStateChangeListener;", "(Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;)V", "bindWebView", "", "webView", "Landroid/webkit/WebView;", "onViewAttachedToWindow", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "unbindWebView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final class OnAutoReportListener implements View.OnAttachStateChangeListener {
        public OnAutoReportListener() {
        }

        public final void bindWebView(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            OnAutoReportListener onAutoReportListener = this;
            webView.removeOnAttachStateChangeListener(onAutoReportListener);
            webView.addOnAttachStateChangeListener(onAutoReportListener);
        }

        public final void unbindWebView(WebView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            webView.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            MonitorLog.m26d(WebViewDataManager.this.TAG, "onViewAttachedToWindow() called with: v = " + v);
            if (v instanceof WebView) {
                WebViewDataManager.this.onAttachedToWindowInner();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            MonitorLog.m26d(WebViewDataManager.this.TAG, "onViewDetachedFromWindow() called with: v = " + v);
            if (v instanceof WebView) {
                WebViewDataManager.this.onDetachedToWindow();
            }
        }
    }
}
