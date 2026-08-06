package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.MonitorService;
import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.checker.PerfMixHandler;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.debug.MonitorDebugConfig;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.EngineInfo;
import com.bytedance.android.monitorV2.entity.NativeInfo;
import com.bytedance.android.monitorV2.entity.PerfMixData;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.hybridSetting.IHybridSettingManager;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonAccessor;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.NavigationUtil;
import com.bytedance.android.monitorV2.util.TouchUtil;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.base.IWebNavigationLifeCycle;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import com.bytedance.android.monitorV2.webview.cache.impl.WebPerfReportData;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import com.bytedance.android.monitorV2.webview.service.IWebNavigationInfoCollector;
import com.bytedance.android.monitorV2.webview.ttweb.KernelReporter;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.android.monitorV2.webview.util.MonitorJsUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.applog.server.Api;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: NavigationDataManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ¦\u00012\u00020\u0001:\u0002¦\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010j\u001a\u00020\u001e2\u0006\u0010k\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0005J\u001a\u0010l\u001a\u00020\u001e2\b\u0010m\u001a\u0004\u0018\u00010\u00052\u0006\u0010n\u001a\u00020oH\u0002J\b\u0010p\u001a\u00020\u001eH\u0002J\b\u0010q\u001a\u00020\u001eH\u0002J3\u0010r\u001a\u00020\u001e2\u0006\u0010s\u001a\u0002002!\u0010t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(u\u0012\u0004\u0012\u00020\u001e0TH\u0002J\b\u0010v\u001a\u00020\u001eH\u0002J\u000e\u0010w\u001a\u00020\u001e2\u0006\u0010x\u001a\u000200J\u0010\u0010y\u001a\u00020\u001e2\u0006\u0010s\u001a\u000200H\u0002J\b\u0010z\u001a\u000200H\u0002J\u0010\u0010{\u001a\u00020\t2\u0006\u0010s\u001a\u000200H\u0002J1\u0010|\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020\t2!\u0010S\u001a\u001d\u0012\u0013\u0012\u001100¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(}\u0012\u0004\u0012\u00020\u001e0TJ\u0006\u0010~\u001a\u00020\"J\b\u0010\u007f\u001a\u00020\u001eH\u0002J\u0007\u0010\u0080\u0001\u001a\u00020\u001eJ\u0012\u0010\u0081\u0001\u001a\u00020\u001e2\u0007\u0010\u0082\u0001\u001a\u00020\u0012H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0001\u001a\u00020LH\u0002J\u001c\u0010\u0085\u0001\u001a\u00020\u001e2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0088\u0001\u001a\u00020\tH\u0002J\u0015\u0010\u0089\u0001\u001a\u00020\u001e2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002J\u0011\u0010\u008a\u0001\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020\u0012J\u0013\u0010\u008c\u0001\u001a\u00020\u00122\b\u0010\u008d\u0001\u001a\u00030\u0087\u0001H\u0002J\u0010\u0010\u008e\u0001\u001a\u00020\u001e2\u0007\u0010\u0082\u0001\u001a\u00020\u0012J\u0010\u0010\u008f\u0001\u001a\u00020\u001e2\u0007\u0010\u0090\u0001\u001a\u00020\u000bJ\u000f\u0010\u0091\u0001\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u000bJ\u0011\u0010\u0092\u0001\u001a\u00020\u001e2\b\u0010/\u001a\u0004\u0018\u000100J\t\u0010\u0093\u0001\u001a\u00020\u001eH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0001\u001a\u00020LH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0088\u0001\u001a\u00020\tH\u0016J\u0011\u0010\u0096\u0001\u001a\u00020\u001e2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u000f\u0010\u0099\u0001\u001a\u00020\u001e2\u0006\u0010s\u001a\u000200J\u001c\u0010\u009a\u0001\u001a\u00020\u001e2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010x\u001a\u0004\u0018\u000100J\u001b\u0010\u009c\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0001\u001a\u00020L2\t\u0010\u009d\u0001\u001a\u0004\u0018\u000100J\u001d\u0010\u009e\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0001\u001a\u00020L2\t\u0010\u009d\u0001\u001a\u0004\u0018\u000100H\u0002J\t\u0010\u009f\u0001\u001a\u00020\u001eH\u0002J\u0011\u0010 \u0001\u001a\u00020\u001e2\b\u0010x\u001a\u0004\u0018\u00010\u0005J\t\u0010¡\u0001\u001a\u00020\u001eH\u0002J\t\u0010¢\u0001\u001a\u00020\u001eH\u0002J$\u0010£\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0001\u001a\u00020L2\u0007\u0010¤\u0001\u001a\u00020\t2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR)\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000eR\u001e\u0010D\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000eR\u0016\u0010I\u001a\n J*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bM\u0010NR\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010S\u001a\u001f\u0012\u0013\u0012\u001100¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0004\u0012\u00020\u001e\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\\\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000e\"\u0004\b^\u0010\u0010R\u000e\u0010_\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010\u0007R\u000e\u0010i\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006§\u0001"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;", "Lcom/bytedance/android/monitorV2/webview/base/IWebNavigationLifeCycle;", "webViewDataManager", "Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;", "url", "", "(Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;Ljava/lang/String;)V", "(Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;)V", "PROGRESS_LIMIT", "", "actualFmp", "", "bid", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "<set-?>", "", "bidExactly", "getBidExactly", "()Z", "containerType", "dataHandler", "Lcom/bytedance/android/monitorV2/webview/WebDataHandler;", "getDataHandler", "()Lcom/bytedance/android/monitorV2/webview/WebDataHandler;", "dataHandlerPostProcessor", "Lkotlin/Function3;", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "", "getDataHandlerPostProcessor", "()Lkotlin/jvm/functions/Function3;", "engineInfo", "Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "getEngineInfo", "()Lcom/bytedance/android/monitorV2/entity/EngineInfo;", "fmp", "inHostWhiteList", "initTime", "getInitTime", "()J", "isClear", "isFirstPageStarted", "isInjectJs", "setInjectJs", "(Z)V", "jsConfig", "Lorg/json/JSONObject;", "getJsConfig", "()Lorg/json/JSONObject;", "setJsConfig", "(Lorg/json/JSONObject;)V", "loadTime", "mContainerBase", "Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "getMContainerBase", "()Lcom/bytedance/android/monitorV2/entity/ContainerBase;", "setMContainerBase", "(Lcom/bytedance/android/monitorV2/entity/ContainerBase;)V", "mContainerInfo", "Lcom/bytedance/android/monitorV2/entity/ContainerInfo;", "getMContainerInfo", "()Lcom/bytedance/android/monitorV2/entity/ContainerInfo;", "setMContainerInfo", "(Lcom/bytedance/android/monitorV2/entity/ContainerInfo;)V", "navigationBid", "getNavigationBid", "navigationBidConfig", "getNavigationBidConfig", "()Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "navigationBidSource", "getNavigationBidSource", "navigationId", "kotlin.jvm.PlatformType", "perfEvent", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "getPerfEvent", "()Lcom/bytedance/android/monitorV2/event/CommonEvent;", "perfEvent$delegate", "Lkotlin/Lazy;", "performance", "Lcom/bytedance/android/monitorV2/webview/cache/impl/WebPerfReportData;", "performanceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "performanceData", "performanceMix", "Lcom/bytedance/android/monitorV2/entity/PerfMixData;", "performanceMixHandler", "Lcom/bytedance/android/monitorV2/checker/PerfMixHandler;", "value", "getUrl", "setUrl", "waitCompleteData", "webNativeCommon", "Lcom/bytedance/android/monitorV2/webview/cache/impl/WebNativeCommon;", "getWebNativeCommon", "()Lcom/bytedance/android/monitorV2/webview/cache/impl/WebNativeCommon;", "setWebNativeCommon", "(Lcom/bytedance/android/monitorV2/webview/cache/impl/WebNativeCommon;)V", "getWebViewDataManager", "()Lcom/bytedance/android/monitorV2/webview/WebViewDataManager;", "setWebViewDataManager", "webViewType", "addContext", Api.KEY_ENCRYPT_RESP_KEY, "addExtraEventInfo", "type", "state", "", "addMonitorContext", "buildNewNavigation", "checkActualFmp", "jsonObject", "cb", "fmpTs", "clearNavigationData", "coverPerfData", "json", "coverPerfEvent", "createPerformanceResult", "getCanSample", "getPerformance", "performanceResult", "getUnifyInfo", "handlePageEnter", "handlePageExit", "handlePageStart", "isFirstPageStart", "handlePv", "event", "initJsMonitor", "view", "Landroid/webkit/WebView;", "progress", "injectJsScript", "isHostWhiteList", "isPageStartValidate", "isUseTTWebDelegate", "webView", "markFirstPageStart", "markInjectJS", "injectTime", "markLoadUrl", "mergeJsConfig", "onPageFinished", "onPageStarted", "onProgressChanged", "postCustomEvent", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "postCustomInfo", "postJsData", "eventType", "postNativeEvent", "dataJSON", "realUploadNativeEvent", "updateContainerData", "updateMonitorInitTimeData", "updateNativeBase", "updatePerfEvent", "updateUnifyError", AlogMonitor.ALOG_RESULT_CODE, "message", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class NavigationDataManager implements IWebNavigationLifeCycle {
    private static final String TAG = "NavigationDataManager";
    private final int PROGRESS_LIMIT;
    private long actualFmp;
    private String bid;
    private volatile boolean bidExactly;
    private final String containerType;
    private final WebDataHandler dataHandler;
    private final Function3<String, BidInfo.BidConfig, String, Unit> dataHandlerPostProcessor;
    private final EngineInfo engineInfo;
    private long fmp;
    private boolean inHostWhiteList;
    private final long initTime;
    private volatile boolean isClear;
    private boolean isFirstPageStarted;
    private boolean isInjectJs;
    private JSONObject jsConfig;
    private long loadTime;
    private ContainerBase mContainerBase;
    private ContainerInfo mContainerInfo;
    private volatile String navigationBid;
    private BidInfo.BidConfig navigationBidConfig;
    private String navigationBidSource;
    private final String navigationId;

    /* renamed from: perfEvent$delegate, reason: from kotlin metadata */
    private final Lazy perfEvent;
    private final WebPerfReportData performance;
    private Function1<? super JSONObject, Unit> performanceCallback;
    private final PerfMixData performanceMix;
    private PerfMixHandler performanceMixHandler;
    private String url;
    private int waitCompleteData;
    private WebNativeCommon webNativeCommon;
    private WebViewDataManager webViewDataManager;
    private String webViewType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<IWebNavigationInfoCollector> navigationInfoCollector$delegate = LazyKt.lazy(new Function0<IWebNavigationInfoCollector>() { // from class: com.bytedance.android.monitorV2.webview.NavigationDataManager$Companion$navigationInfoCollector$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IWebNavigationInfoCollector m382invoke() {
            Object obj = MonitorService.INSTANCE.getServiceMap().get(IWebNavigationInfoCollector.class);
            if (obj == null) {
                MonitorLog.m28e(MonitorService.TAG, "Cannot find service implementation of " + IWebNavigationInfoCollector.class, new Throwable());
            } else {
                if (!(obj instanceof IWebNavigationInfoCollector)) {
                    MonitorLog.m28e(MonitorService.TAG, "Internal error, service is not instance of " + IWebNavigationInfoCollector.class + ", is that call register and get in different classloader?", new Throwable());
                }
                return (IWebNavigationInfoCollector) obj;
            }
            obj = null;
            return (IWebNavigationInfoCollector) obj;
        }
    });

    public NavigationDataManager(WebViewDataManager webViewDataManager) {
        Intrinsics.checkNotNullParameter(webViewDataManager, "webViewDataManager");
        this.webViewDataManager = webViewDataManager;
        this.initTime = System.currentTimeMillis();
        this.bid = "";
        this.jsConfig = new JSONObject();
        this.webNativeCommon = new WebNativeCommon();
        this.engineInfo = new EngineInfo(this.webNativeCommon);
        this.dataHandler = new WebDataHandler(this);
        String str = BidInfo.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(str, "DEFAULT");
        this.navigationBid = str;
        this.navigationBidConfig = new BidInfo.BidConfig(BidInfo.DEFAULT);
        this.navigationBidSource = "default_bid";
        this.dataHandlerPostProcessor = new Function3<String, BidInfo.BidConfig, String, Unit>() { // from class: com.bytedance.android.monitorV2.webview.NavigationDataManager$dataHandlerPostProcessor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, (BidInfo.BidConfig) obj2, (String) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(String str2, BidInfo.BidConfig bidConfig, String str3) {
                Intrinsics.checkNotNullParameter(str2, "bid");
                Intrinsics.checkNotNullParameter(bidConfig, "bidConfig");
                Intrinsics.checkNotNullParameter(str3, "bidSource");
                NavigationDataManager.this.navigationBid = str2;
                NavigationDataManager.this.navigationBidConfig = bidConfig;
                NavigationDataManager.this.navigationBidSource = str3;
                NavigationDataManager.this.bidExactly = true;
            }
        };
        this.containerType = "web";
        this.webViewType = "web";
        this.inHostWhiteList = true;
        this.navigationId = NavigationUtil.generateID();
        this.PROGRESS_LIMIT = 15;
        this.performance = new WebPerfReportData(this.webNativeCommon, "perf");
        this.performanceMix = new PerfMixData();
        this.performanceMixHandler = new PerfMixHandler(CollectionsKt.listOf(new String[]{ReportConst.Event.RES_LOADER_PERF_TEMPLATE, ReportConst.Event.RES_LOADER_PERF, "jsbPerf"}));
        this.perfEvent = LazyKt.lazy(new Function0<CommonEvent>() { // from class: com.bytedance.android.monitorV2.webview.NavigationDataManager$perfEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CommonEvent m383invoke() {
                CommonEvent.Companion companion = CommonEvent.INSTANCE;
                final NavigationDataManager navigationDataManager = NavigationDataManager.this;
                return companion.create("perf", null, new Function1<CommonEvent, Unit>() { // from class: com.bytedance.android.monitorV2.webview.NavigationDataManager$perfEvent$2.1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CommonEvent) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CommonEvent commonEvent) {
                        Intrinsics.checkNotNullParameter(commonEvent, "it");
                        commonEvent.getNativeBase().url = NavigationDataManager.this.getUrl();
                        commonEvent.getNativeBase().containerType = "web";
                        commonEvent.onEventUpdated();
                    }
                });
            }
        });
        buildNewNavigation();
    }

    public final WebViewDataManager getWebViewDataManager() {
        return this.webViewDataManager;
    }

    public final void setWebViewDataManager(WebViewDataManager webViewDataManager) {
        Intrinsics.checkNotNullParameter(webViewDataManager, "<set-?>");
        this.webViewDataManager = webViewDataManager;
    }

    /* compiled from: NavigationDataManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/NavigationDataManager$Companion;", "", "()V", "TAG", "", "navigationInfoCollector", "Lcom/bytedance/android/monitorV2/webview/service/IWebNavigationInfoCollector;", "getNavigationInfoCollector", "()Lcom/bytedance/android/monitorV2/webview/service/IWebNavigationInfoCollector;", "navigationInfoCollector$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IWebNavigationInfoCollector getNavigationInfoCollector() {
            return (IWebNavigationInfoCollector) NavigationDataManager.navigationInfoCollector$delegate.getValue();
        }
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
        this.webNativeCommon.url = str;
    }

    public final long getInitTime() {
        return this.initTime;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final JSONObject getJsConfig() {
        return this.jsConfig;
    }

    public final void setJsConfig(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.jsConfig = jSONObject;
    }

    /* renamed from: isInjectJs, reason: from getter */
    public final boolean getIsInjectJs() {
        return this.isInjectJs;
    }

    public final void setInjectJs(boolean z) {
        this.isInjectJs = z;
    }

    public final WebNativeCommon getWebNativeCommon() {
        return this.webNativeCommon;
    }

    public final void setWebNativeCommon(WebNativeCommon webNativeCommon) {
        Intrinsics.checkNotNullParameter(webNativeCommon, "<set-?>");
        this.webNativeCommon = webNativeCommon;
    }

    public final ContainerBase getMContainerBase() {
        return this.mContainerBase;
    }

    public final void setMContainerBase(ContainerBase containerBase) {
        this.mContainerBase = containerBase;
    }

    public final ContainerInfo getMContainerInfo() {
        return this.mContainerInfo;
    }

    public final void setMContainerInfo(ContainerInfo containerInfo) {
        this.mContainerInfo = containerInfo;
    }

    public final EngineInfo getEngineInfo() {
        return this.engineInfo;
    }

    public final WebDataHandler getDataHandler() {
        return this.dataHandler;
    }

    public final String getNavigationBid() {
        return this.navigationBid;
    }

    public final BidInfo.BidConfig getNavigationBidConfig() {
        return this.navigationBidConfig;
    }

    public final String getNavigationBidSource() {
        return this.navigationBidSource;
    }

    public final boolean getBidExactly() {
        return this.bidExactly;
    }

    public final Function3<String, BidInfo.BidConfig, String, Unit> getDataHandlerPostProcessor() {
        return this.dataHandlerPostProcessor;
    }

    private final CommonEvent getPerfEvent() {
        return (CommonEvent) this.perfEvent.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationDataManager(WebViewDataManager webViewDataManager, String str) {
        this(webViewDataManager);
        Intrinsics.checkNotNullParameter(webViewDataManager, "webViewDataManager");
        Intrinsics.checkNotNullParameter(str, "url");
        setUrl(str);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebNavigationLifeCycle
    public void onPageStarted(CommonEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(this.url, "about:blank")) {
            return;
        }
        updateContainerData();
        updateNativeBase();
        event.setNativeBase(this.webNativeCommon);
        handlePageEnter();
        handlePageStart(this.isFirstPageStarted);
        handlePv(event);
        IWebNavigationInfoCollector navigationInfoCollector = INSTANCE.getNavigationInfoCollector();
        if (navigationInfoCollector != null) {
            String str = this.navigationId;
            Intrinsics.checkNotNullExpressionValue(str, "navigationId");
            navigationInfoCollector.onPageStart(str);
        }
        this.engineInfo.setStage(1);
        MonitorLog.m26d(TAG, "handlePageStart: url : " + this.url);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebNavigationLifeCycle
    public void onProgressChanged(int progress) {
        WebView webView = this.webViewDataManager.getWebView();
        if (webView != null) {
            initJsMonitor(webView, progress);
        }
        this.performance.handlePageProgress(progress);
    }

    @Override // com.bytedance.android.monitorV2.webview.base.IWebNavigationLifeCycle
    public void onPageFinished() {
        String channel;
        this.performance.handlePageFinish();
        WebView webView = this.webViewDataManager.getWebView();
        if (webView != null) {
            JSONObject tTWebViewMetrics$default = TTUtils.getTTWebViewMetrics$default(TTUtils.INSTANCE, webView, null, 2, null);
            HybridSettingInitConfig initConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig();
            if (initConfig != null && (channel = initConfig.getChannel()) != null) {
                if ((Intrinsics.areEqual(channel, "local_test") ? channel : null) != null) {
                    this.performance.setTTWebViewMetrics(tTWebViewMetrics$default);
                }
            }
            KernelReporter.INSTANCE.reportKernelMetrics(webView, tTWebViewMetrics$default);
        }
        updatePerfEvent();
        IWebNavigationInfoCollector navigationInfoCollector = INSTANCE.getNavigationInfoCollector();
        if (navigationInfoCollector != null) {
            String str = this.navigationId;
            Intrinsics.checkNotNullExpressionValue(str, "navigationId");
            navigationInfoCollector.onPageFinished(str);
        }
        this.engineInfo.setStage(3);
    }

    public final void mergeJsConfig(JSONObject jsConfig) {
        JSONObject merge = JsonUtils.merge(this.jsConfig, jsConfig);
        Intrinsics.checkNotNullExpressionValue(merge, "mergedObj");
        this.jsConfig = merge;
    }

    public final void markLoadUrl(long loadTime) {
        this.loadTime = loadTime;
    }

    public final void markFirstPageStart(boolean isFirstPageStart) {
        this.isFirstPageStarted = isFirstPageStart;
    }

    public final void addContext(String key, String value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        this.webNativeCommon.addContext(key, value);
    }

    public final boolean isPageStartValidate() {
        return this.webNativeCommon.getClickStartTime() != TouchUtil.getLastTouchTime();
    }

    public final void handlePageExit() {
        if (this.url == null || this.isClear) {
            return;
        }
        this.isClear = true;
        this.performance.handlePageExit();
        updatePerfEvent();
        clearNavigationData();
        this.dataHandler.notifyAllEvents();
        this.performanceCallback = null;
    }

    public final void updateMonitorInitTimeData(String json) {
        this.performance.updateMonitorInitTimeData(json);
        updatePerfEvent();
    }

    public final void markInjectJS(long injectTime) {
        this.isInjectJs = true;
        this.performance.injectJS(injectTime);
        updatePerfEvent();
    }

    public final void postCustomEvent(CustomEvent customEvent) {
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        CustomEvent customEvent2 = customEvent;
        this.dataHandler.postEvent(customEvent2);
        IWebNavigationInfoCollector navigationInfoCollector = INSTANCE.getNavigationInfoCollector();
        if (navigationInfoCollector != null) {
            navigationInfoCollector.onEventEnqueue(customEvent2);
        }
    }

    public final void postCustomInfo(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jsonObject, "category"));
        JSONObject safeToJsonOb2 = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jsonObject, "metrics"));
        JSONObject safeToJsonOb3 = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jsonObject, "timing"));
        JSONObject safeToJsonOb4 = JsonUtils.safeToJsonOb(JsonUtils.safeOptStr(jsonObject, "extra"));
        String safeOptStr = JsonUtils.safeOptStr(jsonObject, "bid");
        CustomInfo build = new CustomInfo.Builder(JsonUtils.safeOptStr(jsonObject, "eventName")).setCategory(safeToJsonOb).setExtra(safeToJsonOb4).setTiming(safeToJsonOb3).setMetric(safeToJsonOb2).setSample(getCanSample(jsonObject)).build();
        if (!TextUtils.isEmpty(safeOptStr)) {
            build.setBid(safeOptStr);
        }
        Intrinsics.checkNotNullExpressionValue(build, "customInfo");
        CustomEvent customEvent = new CustomEvent(build);
        Map<String, Object> tags = customEvent.getTags();
        IWebViewMonitorHelper.Config config = this.webViewDataManager.getConfig();
        tags.put("config_bid", config != null ? config.mBid : null);
        customEvent.getTags().put("jsb_bid", this.bid);
        customEvent.onEventCreated();
        postCustomEvent(customEvent);
    }

    public final void postJsData(String eventType, JSONObject json) {
        if (eventType != null) {
            CommonEvent commonEvent = new CommonEvent(eventType);
            commonEvent.onEventCreated();
            Map<String, Object> tags = commonEvent.getTags();
            IWebViewMonitorHelper.Config config = this.webViewDataManager.getConfig();
            tags.put("config_bid", config != null ? config.mBid : null);
            commonEvent.setNativeBase(this.webNativeCommon);
            commonEvent.setJsInfo(JsonUtils.safeOptJsonObj(json, "jsInfo"));
            commonEvent.setJsBase(JsonUtils.safeOptJsonObj(json, "jsBase"));
            CommonEvent commonEvent2 = commonEvent;
            this.dataHandler.postEvent(commonEvent2);
            IWebNavigationInfoCollector navigationInfoCollector = INSTANCE.getNavigationInfoCollector();
            if (navigationInfoCollector != null) {
                navigationInfoCollector.onEventEnqueue(commonEvent2);
            }
            this.engineInfo.update(commonEvent2);
            updateUnifyError(commonEvent, 0, "");
        }
        this.performance.addCount(eventType);
    }

    public final void postNativeEvent(CommonEvent event, JSONObject dataJSON) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual("blank", event.getEventType())) {
            JsonUtils.safePut(dataJSON, "enter_page_time", this.initTime);
        }
        realUploadNativeEvent(event, dataJSON);
    }

    private final void realUploadNativeEvent(CommonEvent event, JSONObject dataJSON) {
        event.setNativeBase(this.webNativeCommon);
        String eventType = event.getEventType();
        if (dataJSON == null) {
            dataJSON = new JSONObject();
        }
        event.setNativeInfo(new NativeInfo(eventType, dataJSON));
        CommonEvent commonEvent = event;
        this.dataHandler.postEvent(commonEvent);
        IWebNavigationInfoCollector navigationInfoCollector = INSTANCE.getNavigationInfoCollector();
        if (navigationInfoCollector != null) {
            navigationInfoCollector.onEventEnqueue(commonEvent);
        }
        this.engineInfo.update(commonEvent);
        this.performance.addCount(event.getEventType());
        this.performanceMixHandler.capture(event);
    }

    public final void coverPerfData(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.performance.saveJsData(json);
        coverPerfEvent(json);
    }

    public final void getPerformance(int waitCompleteData, Function1<? super JSONObject, Unit> performanceCallback) {
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        if (waitCompleteData == 0 || (((waitCompleteData == 1 && this.fmp > 0) || (waitCompleteData == 2 && this.actualFmp > 0)) && !this.performanceMixHandler.getWork().get())) {
            performanceCallback.invoke(createPerformanceResult());
        } else {
            this.waitCompleteData = waitCompleteData;
            this.performanceCallback = performanceCallback;
        }
    }

    public final EngineInfo getUnifyInfo() {
        return this.engineInfo;
    }

    public final void updateUnifyError(CommonEvent event, int code, String message) {
        Intrinsics.checkNotNullParameter(event, "event");
        EngineInfo engineInfo = this.engineInfo;
        if (message == null) {
            message = "";
        }
        engineInfo.updateRawError(event, code, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject createPerformanceResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("nativeBase", getPerfEvent().getNativeBase().toJsonObject());
        BaseNativeInfo nativeInfo = getPerfEvent().getNativeInfo();
        jSONObject.put("nativeInfo", nativeInfo != null ? nativeInfo.toJsonObject() : null);
        jSONObject.put("jsInfo", getPerfEvent().getJsInfo());
        jSONObject.put("jsBase", getPerfEvent().getJsBase());
        ContainerInfo containerInfo = getPerfEvent().getContainerInfo();
        jSONObject.put("containerInfo", containerInfo != null ? containerInfo.toJsonObject() : null);
        ContainerBase containerBase = getPerfEvent().getContainerBase();
        jSONObject.put("containerBase", containerBase != null ? containerBase.toJsonObject() : null);
        return jSONObject;
    }

    private final void buildNewNavigation() {
        MonitorLog.m26d(TAG, "buildNewNavigation cache new url : " + this.url);
        if (this.webViewDataManager.isTTWebView()) {
            this.webViewType = "ttweb";
        }
        Map<String, Integer> extraEventInfo = this.webViewDataManager.getExtraEventInfo();
        for (String str : extraEventInfo.keySet()) {
            Integer num = extraEventInfo.get(str);
            if (num != null) {
                addExtraEventInfo(str, Integer.valueOf(num.intValue()));
            }
        }
        updateContainerData();
        updateNativeBase();
    }

    private final void addExtraEventInfo(String type, Object state) {
        this.webNativeCommon.saveExtra(type, state);
    }

    private final void initJsMonitor(WebView view, int progress) {
        if (progress < this.PROGRESS_LIMIT) {
            return;
        }
        if (!view.getSettings().getJavaScriptEnabled()) {
            view.getSettings().setJavaScriptEnabled(true);
        }
        injectJsScript(view);
    }

    private final void injectJsScript(WebView view) {
        HybridSettingInitConfig initConfig;
        try {
            Intrinsics.checkNotNull(view);
            String url = view.getUrl();
            if (url == null || Intrinsics.areEqual(url, "about:blank") || this.isInjectJs) {
                return;
            }
            IWebViewMonitorHelper.Config config = this.webViewDataManager.getConfig();
            if (config == null || config.mIsNeedInjectBrowser) {
                if (!this.webViewDataManager.getSwitchConfig().isWebEnableInject() || !Switches.webDomainWhiteList.isEnabled() || MonitorDebugConfig.skipWhiteListInjectCheck() || isHostWhiteList(url)) {
                    IHybridSettingManager hybridSettingManager = HybridMultiMonitor.getInstance().getHybridSettingManager();
                    if ((hybridSettingManager != null && (initConfig = hybridSettingManager.getInitConfig()) != null && initConfig.getThirdConfig() != null && initConfig.getThirdConfig().isThirdPartyUrl(view.getUrl())) || TextUtils.isEmpty(url) || this.isInjectJs) {
                        return;
                    }
                    IWebViewMonitorHelper.Config config2 = this.webViewDataManager.getConfig();
                    view.evaluateJavascript(MonitorJsUtils.buildJs(view.getContext(), config2 == null ? "" : config2.mSlardarSDKPath, config2 == null ? WebViewMonitorConfig.buildDefaultConfig() : config2.mSlardarSDKConfig, this.webViewDataManager.getSwitchConfig().isWebEnableInject()), null);
                    markInjectJS(System.currentTimeMillis());
                    MonitorLog.m26d(TAG, "injectJsScript : " + url);
                    InternalWatcher.notice$default(InternalWatcher.INSTANCE, this.webNativeCommon.navigationId, InternalWatcher.EVENT_JSSDK_LOAD, null, null, 12, null);
                }
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
        }
    }

    private final boolean isHostWhiteList(String url) {
        String str;
        if (!this.inHostWhiteList) {
            return false;
        }
        try {
            String host = Uri.parse(url).getHost();
            List split$default = host != null ? StringsKt.split$default(host, new String[]{"."}, false, 0, 6, (Object) null) : null;
            String str2 = "";
            if (split$default != null) {
                int size = split$default.size();
                if (size >= 2) {
                    str = ((String) split$default.get(size - 2)) + '.' + ((String) split$default.get(size - 1));
                } else {
                    str = (String) CollectionsKt.last(split$default);
                }
                str2 = str;
            }
            if ((str2.length() > 0) && HybridMultiMonitor.getInstance().getHybridSettingManager().getHostWhiteSet().contains(str2)) {
                this.inHostWhiteList = true;
                return true;
            }
            this.inHostWhiteList = false;
            return false;
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            this.inHostWhiteList = false;
            return false;
        }
    }

    private final void handlePageEnter() {
        this.performance.handlePageEnter();
    }

    private final void handlePageStart(boolean isFirstPageStart) {
        this.performance.handlePageStart(isFirstPageStart);
        updatePerfEvent();
    }

    private final void handlePv(CommonEvent event) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.safePut(jSONObject, "invoke_ts", System.currentTimeMillis());
        postNativeEvent(event, jSONObject);
        MonitorLog.m26d(TAG, "handlePv");
    }

    private final void updateNativeBase() {
        this.webNativeCommon.saveCommonData(this.webViewDataManager.generateWebViewNativeBase());
        this.webNativeCommon.setContainerType(this.containerType);
        this.webNativeCommon.setWebViewType(this.webViewType);
        this.webNativeCommon.setUrlCache(this.url);
        this.webNativeCommon.setClickStartTime(TouchUtil.getLastTouchTime());
        this.webNativeCommon.setLoadUrlTime(this.loadTime);
        this.webNativeCommon.setNavigationIdCache(this.navigationId);
        addMonitorContext();
        WebView webView = this.webViewDataManager.getWebView();
        if (webView != null) {
            this.webNativeCommon.initNativePage(webView.getContext());
        }
    }

    private final void updateContainerData() {
        this.mContainerBase = this.webViewDataManager.getContainerBase();
        this.mContainerInfo = this.webViewDataManager.getContainerInfo();
    }

    private final void coverPerfEvent(JSONObject jsonObject) {
        if (this.isClear) {
            return;
        }
        getPerfEvent().setJsBase(jsonObject.optJSONObject("jsBase"));
        getPerfEvent().setJsInfo(jsonObject.optJSONObject("jsInfo"));
        JSONObject jsInfo = getPerfEvent().getJsInfo();
        if (jsInfo != null) {
            checkActualFmp(jsInfo, new Function1<Long, Unit>() { // from class: com.bytedance.android.monitorV2.webview.NavigationDataManager$coverPerfEvent$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0029, code lost:
                
                    if (r4 <= 0) goto L6;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(long j) {
                    PerfMixHandler perfMixHandler;
                    PerfMixData perfMixData;
                    int i;
                    int i2;
                    long j2;
                    Function1 function1;
                    JSONObject createPerformanceResult;
                    long j3;
                    perfMixHandler = NavigationDataManager.this.performanceMixHandler;
                    perfMixData = NavigationDataManager.this.performanceMix;
                    perfMixHandler.stop(j, perfMixData.getMixPerformance(), "web");
                    i = NavigationDataManager.this.waitCompleteData;
                    if (i == 1) {
                        j3 = NavigationDataManager.this.fmp;
                    }
                    i2 = NavigationDataManager.this.waitCompleteData;
                    if (i2 == 2) {
                        j2 = NavigationDataManager.this.actualFmp;
                        if (j2 <= 0) {
                            return;
                        }
                        function1 = NavigationDataManager.this.performanceCallback;
                        if (function1 != null) {
                            createPerformanceResult = NavigationDataManager.this.createPerformanceResult();
                            function1.invoke(createPerformanceResult);
                        }
                    }
                }
            });
        }
        getPerfEvent().onEventUpdated();
        JSONObject jsInfo2 = getPerfEvent().getJsInfo();
        if (jsInfo2 != null && jsInfo2.has("actual_fmp")) {
            this.engineInfo.setStage(4);
        }
        MonitorLog.m29i(TAG, "coverPerf " + getPerfEvent().hashCode());
    }

    private final void clearNavigationData() {
        MonitorLog.m29i(TAG, "clearNavigationData");
        updateNativeBase();
        updatePerfEvent();
        this.dataHandler.postEvent(getPerfEvent());
        IWebNavigationInfoCollector navigationInfoCollector = INSTANCE.getNavigationInfoCollector();
        if (navigationInfoCollector != null) {
            navigationInfoCollector.onEventEnqueue(getPerfEvent());
        }
    }

    private final void updatePerfEvent() {
        getPerfEvent().setContainerBase(this.mContainerBase);
        getPerfEvent().setContainerInfo(this.mContainerInfo);
        getPerfEvent().setNativeBase(this.webNativeCommon);
        this.performanceMix.setNativePerformance(this.performance.getNativeInfo());
        getPerfEvent().setNativeInfo(this.performanceMix);
        getPerfEvent().onEventUpdated();
    }

    private final int getCanSample(JSONObject jsonObject) {
        int safeOptInt = JsonUtils.safeOptInt(jsonObject, "level");
        int safeOptInt2 = JsonUtils.safeOptInt(jsonObject, "canSample");
        boolean safeOptBool = JsonUtils.safeOptBool(jsonObject, "canSample", true);
        if (jsonObject.has("level")) {
            return safeOptInt;
        }
        if (jsonObject.has("canSample")) {
            return (safeOptInt2 == 0 || !safeOptBool) ? 0 : 2;
        }
        return 2;
    }

    private final void addMonitorContext() {
        WebNativeCommon webNativeCommon = this.webNativeCommon;
        JSONObject jSONObject = new JSONObject();
        WebView webView = this.webViewDataManager.getWebView();
        if (webView != null) {
            jSONObject.put(WebViewMonitorConstant.Web.USE_TTWEB_HOOK, isUseTTWebDelegate(webView));
            jSONObject.put("webview_type", this.webViewType);
        }
        webNativeCommon.addContext(jSONObject);
    }

    private final boolean isUseTTWebDelegate(WebView webView) {
        IWebViewMonitorHelper webViewMonitorHelper = WebViewMonitorHelper.getInstance();
        Intrinsics.checkNotNull(webViewMonitorHelper, "null cannot be cast to non-null type com.bytedance.android.monitorV2.webview.WebViewMonitorHelper");
        return ((WebViewMonitorHelper) webViewMonitorHelper).isTTWebEnable() && TTUtils.INSTANCE.getTTWebHookState(webView);
    }

    private final void checkActualFmp(JSONObject jsonObject, Function1<? super Long, Unit> cb) {
        long currentTimeMillis;
        JsonAccessor jsonAccessor = new JsonAccessor(jsonObject);
        Long long$default = JsonAccessor.getLong$default(jsonAccessor, "actual_fmp", null, 2, null);
        long longValue = long$default != null ? long$default.longValue() : 0L;
        this.actualFmp = longValue;
        if (longValue == 0) {
            Long long$default2 = JsonAccessor.getLong$default(jsonAccessor, "fmp", null, 2, null);
            longValue = long$default2 != null ? long$default2.longValue() : 0L;
            this.fmp = longValue;
        }
        Long long$default3 = JsonAccessor.getLong$default(jsonAccessor, "timing.navigationStart", null, 2, null);
        long longValue2 = long$default3 != null ? long$default3.longValue() : 0L;
        if (longValue == 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = longValue2 == 0 ? System.currentTimeMillis() : longValue2 + longValue;
        }
        cb.invoke(Long.valueOf(currentTimeMillis));
    }
}
