package com.bytedance.android.monitorV2.webview;

import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.checker.DoubleReportChecker;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.dataprocessor.IDataHandler;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.standard.ContainerDataCache;
import com.bytedance.android.monitorV2.standard.ContainerStandardConst;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.HybridBidFinder;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import com.bytedance.android.monitorV2.util.Utilities;
import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;
import com.bytedance.android.monitorV2.webview.cache.impl.WebNativeCommon;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: WebDataHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/WebDataHandler;", "", "mNavigation", "Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;", "(Lcom/bytedance/android/monitorV2/webview/NavigationDataManager;)V", "mDataType", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType;", "typedDataDispatcher", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher;", "checkSample", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "getBid", "Lkotlin/Triple;", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "hitSample", "bidConfig", "logForBlank", "", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "notifyAllEvents", "postEvent", "processCommonEvent", "processCustomEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "useConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class WebDataHandler {
    private final TypedDataDispatcher.DataType mDataType;
    private final NavigationDataManager mNavigation;
    private final TypedDataDispatcher typedDataDispatcher;

    public WebDataHandler(NavigationDataManager navigationDataManager) {
        Intrinsics.checkNotNullParameter(navigationDataManager, "mNavigation");
        this.mNavigation = navigationDataManager;
        TypedDataDispatcher typedDataDispatcher = new TypedDataDispatcher();
        this.typedDataDispatcher = typedDataDispatcher;
        TypedDataDispatcher.DataType dataType = TypedDataDispatcher.DataType.WEB_VIEW;
        this.mDataType = dataType;
        typedDataDispatcher.setDataHandler(dataType, new IDataHandler() { // from class: com.bytedance.android.monitorV2.webview.WebDataHandler.1
            @Override // com.bytedance.android.monitorV2.dataprocessor.IDataHandler
            public void onDataDispatch(Object data) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (data instanceof CommonEvent) {
                    WebDataHandler.this.processCommonEvent((CommonEvent) data);
                }
                if (data instanceof CustomEvent) {
                    WebDataHandler.this.processCustomEvent((CustomEvent) data);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processCommonEvent(CommonEvent event) {
        CommonEvent commonEvent = event;
        boolean checkSample = checkSample(commonEvent);
        if (!checkSample && Utilities.INSTANCE.isOnlineEnv()) {
            event.onEventSampled();
            return;
        }
        WebCommonFieldHandler.INSTANCE.addWebCommonField(null, this.mNavigation.getWebViewDataManager().getWebView(), event.getNativeBase());
        event.setContainerBase(this.mNavigation.getMContainerBase());
        event.setJsBase(JsonUtils.merge(event.getJsBase(), this.mNavigation.getJsConfig()));
        event.getTags().put("jsb_bid", this.mNavigation.getBid());
        Map<String, Object> tags = event.getTags();
        IWebViewMonitorHelper.Config config = this.mNavigation.getWebViewDataManager().getConfig();
        tags.put("config_bid", config != null ? config.mBid : null);
        event.setFullLinkId(this.mNavigation.getWebViewDataManager().getMonitorId());
        useConfig(commonEvent);
        if (!checkSample) {
            event.onEventSampled();
            return;
        }
        if (Intrinsics.areEqual(event.getEventType(), ReportConst.Event.JSB_PAGE_VISIT)) {
            DoubleReportChecker.INSTANCE.reportJsbPvV2(event, (String) getBid(commonEvent).getFirst());
            return;
        }
        DataReporter dataReporter = DataReporter.INSTANCE;
        IWebViewMonitorHelper.Config config2 = this.mNavigation.getWebViewDataManager().getConfig();
        dataReporter.reportCommonEvent(event, config2 != null ? config2.sourceMonitor : null, false);
        logForBlank(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processCustomEvent(CustomEvent event) {
        CustomEvent customEvent = event;
        boolean checkSample = checkSample(customEvent);
        if (!checkSample && Utilities.INSTANCE.isOnlineEnv()) {
            event.onEventSampled();
            return;
        }
        IWebViewMonitorHelper.Config config = this.mNavigation.getWebViewDataManager().getConfig();
        String str = config != null ? config.virtualAid : null;
        String url = this.mNavigation.getUrl();
        JSONObject common = event.getCustomInfo().getCommon();
        JSONObject jsConfig = this.mNavigation.getJsConfig();
        JsonUtils.safePut(common, "virtual_aid", str);
        JsonUtils.safePut(common, "platform", 0);
        WebCommonFieldHandler.INSTANCE.addWebCommonField(null, this.mNavigation.getWebViewDataManager().getWebView(), this.mNavigation.getWebNativeCommon());
        WebNativeCommon webNativeCommon = this.mNavigation.getWebNativeCommon();
        ContainerBase containerBase = this.mNavigation.getWebViewDataManager().getContainerBase();
        String url2 = event.getCustomInfo().getUrl();
        if (url2 == null || url2.length() == 0) {
            event.getCustomInfo().setUrl(url);
        }
        event.setJsBase(jsConfig);
        JsonUtils.deepCopy(webNativeCommon.context, event.getNativeBase().context);
        event.setNativeBase(webNativeCommon);
        event.setContainerBase(containerBase);
        event.getTags().put("jsb_bid", this.mNavigation.getBid());
        Map<String, Object> tags = event.getTags();
        IWebViewMonitorHelper.Config config2 = this.mNavigation.getWebViewDataManager().getConfig();
        tags.put("config_bid", config2 != null ? config2.mBid : null);
        event.setFullLinkId(this.mNavigation.getWebViewDataManager().getMonitorId());
        useConfig(customEvent);
        if (!checkSample) {
            event.onEventSampled();
        } else {
            DataReporter.INSTANCE.reportCustomEvent(event, false);
        }
    }

    public final void notifyAllEvents() {
        this.typedDataDispatcher.notifyAllEvents();
    }

    public final void postEvent(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TypedDataDispatcher.enqueue$default(this.typedDataDispatcher, this.mDataType, event, false, 4, null);
    }

    private final boolean checkSample(HybridEvent event) {
        event.setPreSample(HostExperimentManager.INSTANCE.getEnablePreSample());
        if (!HostExperimentManager.INSTANCE.getEnablePreSample() || Intrinsics.areEqual(event.getEventType(), ReportConst.Event.JSB_PAGE_VISIT)) {
            return true;
        }
        event.getNativeBase().addContext("pre_sample", "1");
        boolean z = event instanceof CommonEvent;
        if (z ? true : event instanceof CustomEvent) {
            Triple<String, String, BidInfo.BidConfig> bid = getBid(event);
            String str = (String) bid.component1();
            String str2 = (String) bid.component2();
            BidInfo.BidConfig bidConfig = (BidInfo.BidConfig) bid.component3();
            if (z && Intrinsics.areEqual(this.mNavigation.getNavigationBid(), BidInfo.DEFAULT)) {
                this.mNavigation.getDataHandlerPostProcessor().invoke(str, bidConfig, str2);
            }
            event.setBid(str);
            event.setBidSource(str2);
            if (hitSample(event, bidConfig)) {
                event.setHitSample(true);
                return true;
            }
        }
        return false;
    }

    private final boolean hitSample(HybridEvent event, BidInfo.BidConfig bidConfig) {
        if (event instanceof CommonEvent) {
            return ConvertUtil.isReportForWebSample(event.getEventType(), bidConfig);
        }
        if (event instanceof CustomEvent) {
            return DataReporter.INSTANCE.checkEventSample((CustomEvent) event);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Triple<String, String, BidInfo.BidConfig> getBid(HybridEvent event) {
        String str;
        String str2;
        String bid;
        boolean isBlank = StringsKt.isBlank("");
        String str3 = ReportConst.BidSourceInfo.CUSTOM_BID;
        String str4 = "default_bid";
        if (isBlank && (event instanceof CustomEvent)) {
            CustomEvent customEvent = (CustomEvent) event;
            String bid2 = customEvent.getCustomInfo().getBid();
            if (!(bid2 == null || bid2.length() == 0)) {
                String monitorId = customEvent.getCustomInfo().getMonitorId();
                if (monitorId == null || monitorId.length() == 0) {
                    str = customEvent.getCustomInfo().getBid();
                    Intrinsics.checkNotNullExpressionValue(str, "event.customInfo.bid");
                    str2 = ReportConst.BidSourceInfo.CUSTOM_BID;
                    if (StringsKt.isBlank(str)) {
                        str = this.mNavigation.getBid();
                        str2 = "jsb_bid";
                    }
                    if (StringsKt.isBlank(str)) {
                        ConcurrentHashMap<String, Object> ensureContainerBase = ContainerDataCache.INSTANCE.ensureContainerBase(this.mNavigation.getWebViewDataManager().getMonitorId());
                        String valueOf = String.valueOf(ensureContainerBase.get("schema"));
                        String url = this.mNavigation.getUrl();
                        String str5 = url;
                        if (str5 == null || StringsKt.isBlank(str5)) {
                            url = String.valueOf(ensureContainerBase.get("url"));
                        }
                        AbsBidFinder.BidMatchResult findBid = HybridBidFinder.INSTANCE.findBid(url, valueOf);
                        if (findBid.isSuccess()) {
                            str = findBid.getBid();
                            str2 = findBid.getSource();
                        }
                    }
                    if (StringsKt.isBlank(str)) {
                        IWebViewMonitorHelper.Config config = this.mNavigation.getWebViewDataManager().getConfig();
                        String str6 = config != null ? config.mBid : null;
                        str2 = "config_bid";
                        str = str6 != null ? str6 : "";
                    }
                    if (StringsKt.isBlank(str) && (event instanceof CustomEvent)) {
                        CustomEvent customEvent2 = (CustomEvent) event;
                        bid = customEvent2.getCustomInfo().getBid();
                        if (!(bid != null || bid.length() == 0)) {
                            str = customEvent2.getCustomInfo().getBid();
                            Intrinsics.checkNotNullExpressionValue(str, "event.customInfo.bid");
                            if (StringsKt.isBlank(str)) {
                                str = BidInfo.DEFAULT;
                                Intrinsics.checkNotNullExpressionValue(str, "DEFAULT");
                            } else {
                                str4 = str3;
                            }
                            event.setBid(str);
                            event.setBidSource(str4);
                            return new Triple<>(str, str4, ReportDataUtils.INSTANCE.determineBidConfig(str));
                        }
                    }
                    str3 = str2;
                    if (StringsKt.isBlank(str)) {
                    }
                    event.setBid(str);
                    event.setBidSource(str4);
                    return new Triple<>(str, str4, ReportDataUtils.INSTANCE.determineBidConfig(str));
                }
            }
        }
        str = "";
        str2 = "default_bid";
        if (StringsKt.isBlank(str)) {
        }
        if (StringsKt.isBlank(str)) {
        }
        if (StringsKt.isBlank(str)) {
        }
        if (StringsKt.isBlank(str)) {
            CustomEvent customEvent22 = (CustomEvent) event;
            bid = customEvent22.getCustomInfo().getBid();
            if (!(bid != null || bid.length() == 0)) {
            }
        }
        str3 = str2;
        if (StringsKt.isBlank(str)) {
        }
        event.setBid(str);
        event.setBidSource(str4);
        return new Triple<>(str, str4, ReportDataUtils.INSTANCE.determineBidConfig(str));
    }

    private final void useConfig(HybridEvent event) {
        IWebViewMonitorHelper.Config config;
        String str;
        JSONObject jSONObject;
        IWebViewMonitorHelper.Config config2 = this.mNavigation.getWebViewDataManager().getConfig();
        if (config2 != null && (jSONObject = config2.mContext) != null) {
            JsonUtils.merge(event.getNativeBase().context, jSONObject);
        }
        NativeCommon nativeBase = event.getNativeBase();
        IWebViewMonitorHelper.Config config3 = this.mNavigation.getWebViewDataManager().getConfig();
        nativeBase.virtualAid = config3 != null ? config3.virtualAid : null;
        if (!StringsKt.isBlank(this.mNavigation.getWebViewDataManager().getMonitorId()) || (config = this.mNavigation.getWebViewDataManager().getConfig()) == null || (str = config.fallbackContainerName) == null) {
            return;
        }
        if ((StringsKt.isBlank(str) ^ true ? str : null) != null) {
            event.setContainerBase(new ContainerBase((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to("container_name", ContainerStandardConst.DEFAULT_CONTAINER_NAME))));
        }
    }

    private final void logForBlank(CommonEvent event) {
        if (CollectionsKt.listOf(new String[]{ReportConst.Event.JS_EXCEPTION, ReportConst.Event.STATIC, "nativeError"}).contains(event.getEventType())) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", event.getFullLinkId());
            jSONObject.put("event_type", event.getEventType());
            jSONObject.put("url", this.mNavigation.getUrl());
            MonitorLog.m29i("WebDataHandler", jSONObject.toString());
        }
    }
}
