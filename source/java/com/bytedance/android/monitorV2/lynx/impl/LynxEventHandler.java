package com.bytedance.android.monitorV2.lynx.impl;

import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.checker.DoubleReportChecker;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.dataprocessor.IDataHandler;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.lynx.config.LynxViewMonitorConfig;
import com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData;
import com.bytedance.android.monitorV2.standard.ContainerStandardConst;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import com.bytedance.android.monitorV2.util.ConvertUtil;
import com.bytedance.android.monitorV2.util.HybridBidFinder;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import com.bytedance.android.monitorV2.util.Utilities;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxEventHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/LynxEventHandler;", "", "mNavigation", "Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;", "(Lcom/bytedance/android/monitorV2/lynx/impl/LynxViewNavigationDataManager;)V", "mDataType", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType;", "typedDataDispatcher", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher;", "afterReport", "", "event", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "checkSample", "", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "getBid", "Lkotlin/Triple;", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "hitSample", "bidConfig", "logForBlank", "notifyAllEvents", "postEvent", "useConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LynxEventHandler {
    private final TypedDataDispatcher.DataType mDataType;
    private final LynxViewNavigationDataManager mNavigation;
    private final TypedDataDispatcher typedDataDispatcher;

    public LynxEventHandler(LynxViewNavigationDataManager lynxViewNavigationDataManager) {
        Intrinsics.checkNotNullParameter(lynxViewNavigationDataManager, "mNavigation");
        this.mNavigation = lynxViewNavigationDataManager;
        TypedDataDispatcher typedDataDispatcher = new TypedDataDispatcher();
        this.typedDataDispatcher = typedDataDispatcher;
        TypedDataDispatcher.DataType dataType = TypedDataDispatcher.DataType.LYNX_VIEW;
        this.mDataType = dataType;
        typedDataDispatcher.setDataHandler(dataType, new IDataHandler() { // from class: com.bytedance.android.monitorV2.lynx.impl.LynxEventHandler.1
            @Override // com.bytedance.android.monitorV2.dataprocessor.IDataHandler
            public void onDataDispatch(Object data) {
                String variable;
                String variable2;
                String variable3;
                String variable4;
                Intrinsics.checkNotNullParameter(data, "data");
                if (data instanceof HybridEvent) {
                    LynxViewMonitorConfig viewConf = LynxEventHandler.this.mNavigation.getLynxViewDataManager().getViewConf();
                    LynxCommonData commonProps = LynxEventHandler.this.mNavigation.getLynxViewDataManager().getCommonProps();
                    ContainerVariablesRef containerVariablesRef = LynxEventHandler.this.mNavigation.getContainerVariablesRef();
                    HybridEvent hybridEvent = (HybridEvent) data;
                    boolean z = true;
                    if (hybridEvent.terminateIf(!viewConf.getEnableMonitor(), HybridEvent.TerminateType.SWITCH_OFF)) {
                        return;
                    }
                    boolean checkSample = LynxEventHandler.this.checkSample(hybridEvent);
                    if (!checkSample && Utilities.INSTANCE.isOnlineEnv()) {
                        hybridEvent.onEventSampled();
                        return;
                    }
                    hybridEvent.getTags().put("config_bid", viewConf.getBid());
                    hybridEvent.getTags().put("jsb_bid", LynxEventHandler.this.mNavigation.getNaviBid());
                    hybridEvent.setJsBase(LynxEventHandler.this.mNavigation.getJsConf());
                    commonProps.virtualAid = viewConf.getVirtualAID();
                    JsonUtils.deepCopy(commonProps.context, hybridEvent.getNativeBase().context);
                    hybridEvent.setNativeBase(commonProps);
                    hybridEvent.setFullLinkId(LynxEventHandler.this.mNavigation.getMonitorId());
                    if (LynxEventHandler.this.mNavigation.getHostView() != null) {
                        hybridEvent.setContainerBase(new ContainerBase((Map<String, ? extends Object>) containerVariablesRef.getVariablesBase()));
                        NativeCommon nativeBase = hybridEvent.getNativeBase();
                        Intrinsics.checkNotNull(nativeBase, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData");
                        LynxCommonData lynxCommonData = (LynxCommonData) nativeBase;
                        String str = lynxCommonData.url;
                        if ((str == null || str.length() == 0) && (variable4 = containerVariablesRef.getVariable("url")) != null) {
                            hybridEvent.getNativeBase().url = variable4;
                        }
                        String str2 = lynxCommonData.nativePage;
                        if ((str2 == null || str2.length() == 0) && (variable3 = containerVariablesRef.getVariable("native_page")) != null) {
                            hybridEvent.getNativeBase().nativePage = variable3;
                        }
                        if ((lynxCommonData.getPageVersion().length() == 0) && (variable2 = containerVariablesRef.getVariable("page_version")) != null) {
                            NativeCommon nativeBase2 = hybridEvent.getNativeBase();
                            Intrinsics.checkNotNull(nativeBase2, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData");
                            ((LynxCommonData) nativeBase2).setPageVersion(variable2);
                        }
                        String str3 = lynxCommonData.containerType;
                        if ((str3 == null || str3.length() == 0) && (variable = containerVariablesRef.getVariable("container_type")) != null) {
                            hybridEvent.getNativeBase().containerType = variable;
                        }
                    }
                    LynxEventHandler.this.useConfig(hybridEvent);
                    if (!checkSample) {
                        hybridEvent.onEventSampled();
                        return;
                    }
                    if (data instanceof CommonEvent) {
                        if (Intrinsics.areEqual(hybridEvent.getEventType(), ReportConst.Event.JSB_PAGE_VISIT)) {
                            DoubleReportChecker.INSTANCE.reportJsbPvV2((CommonEvent) data, (String) LynxEventHandler.this.getBid(hybridEvent).getFirst());
                            return;
                        }
                        CommonEvent commonEvent = (CommonEvent) data;
                        DataReporter.INSTANCE.reportCommonEvent(commonEvent, null, false);
                        LynxEventHandler.this.logForBlank(commonEvent);
                        LynxEventHandler.this.afterReport(commonEvent);
                        return;
                    }
                    if (data instanceof CustomEvent) {
                        CustomEvent customEvent = (CustomEvent) data;
                        CustomInfo customInfo = customEvent.getCustomInfo();
                        LynxEventHandler lynxEventHandler = LynxEventHandler.this;
                        String vid = customInfo.getVid();
                        customInfo.setVid(vid == null || vid.length() == 0 ? commonProps.virtualAid : customInfo.getVid());
                        String url = customInfo.getUrl();
                        if (url != null && url.length() != 0) {
                            z = false;
                        }
                        customInfo.setUrl(z ? lynxEventHandler.mNavigation.getTemplateUrl() : customInfo.getUrl());
                        JsonUtils.safePut(customInfo.getCommon(), "platform", 3);
                        DataReporter.INSTANCE.reportCustomEvent(customEvent, false);
                    }
                }
            }
        });
    }

    public final void postEvent(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TypedDataDispatcher.enqueue$default(this.typedDataDispatcher, this.mDataType, event, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkSample(HybridEvent event) {
        event.setPreSample(HostExperimentManager.INSTANCE.getEnablePreSample());
        if (!HostExperimentManager.INSTANCE.getEnablePreSample() || Intrinsics.areEqual(event.getEventType(), ReportConst.Event.JSB_PAGE_VISIT)) {
            return true;
        }
        event.getNativeBase().addContext("pre_sample", "1");
        boolean z = event instanceof CommonEvent;
        if (!(z ? true : event instanceof CustomEvent)) {
            return false;
        }
        Triple<String, String, BidInfo.BidConfig> bid = getBid(event);
        String str = (String) bid.component1();
        String str2 = (String) bid.component2();
        BidInfo.BidConfig bidConfig = (BidInfo.BidConfig) bid.component3();
        if (z && Intrinsics.areEqual(this.mNavigation.getNavigationBid(), BidInfo.DEFAULT)) {
            this.mNavigation.getDataHandlerPostProcessor().invoke(str, bidConfig, str2);
        }
        event.setBid(str);
        event.setBidSource(str2);
        if (!hitSample(event, bidConfig)) {
            return false;
        }
        event.setHitSample(true);
        return true;
    }

    private final boolean hitSample(HybridEvent event, BidInfo.BidConfig bidConfig) {
        if (event instanceof CommonEvent) {
            return ConvertUtil.isSampleForLynx(event.getEventType(), bidConfig);
        }
        if (event instanceof CustomEvent) {
            return DataReporter.INSTANCE.checkEventSample((CustomEvent) event);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Triple<String, String, BidInfo.BidConfig> getBid(HybridEvent event) {
        String str;
        String bid;
        String str2 = "";
        boolean isBlank = StringsKt.isBlank("");
        String str3 = ReportConst.BidSourceInfo.CUSTOM_BID;
        String str4 = "default_bid";
        if (isBlank && (event instanceof CustomEvent)) {
            CustomEvent customEvent = (CustomEvent) event;
            String bid2 = customEvent.getCustomInfo().getBid();
            if (!(bid2 == null || bid2.length() == 0)) {
                String monitorId = customEvent.getCustomInfo().getMonitorId();
                if (monitorId == null || monitorId.length() == 0) {
                    str2 = customEvent.getCustomInfo().getBid();
                    Intrinsics.checkNotNullExpressionValue(str2, "event.customInfo.bid");
                    str = ReportConst.BidSourceInfo.CUSTOM_BID;
                    if (StringsKt.isBlank(str2)) {
                        str2 = this.mNavigation.getNaviBid();
                        str = "jsb_bid";
                    }
                    if (StringsKt.isBlank(str2)) {
                        Map<String, Object> variablesBase = this.mNavigation.getContainerVariablesRef().getVariablesBase();
                        String valueOf = String.valueOf(variablesBase.get("schema"));
                        String templateUrl = this.mNavigation.getTemplateUrl();
                        String str5 = templateUrl;
                        if (str5 == null || StringsKt.isBlank(str5)) {
                            templateUrl = String.valueOf(variablesBase.get("url"));
                        }
                        AbsBidFinder.BidMatchResult findBid = HybridBidFinder.INSTANCE.findBid(templateUrl, valueOf);
                        if (findBid.isSuccess()) {
                            str2 = findBid.getBid();
                            str = findBid.getSource();
                        }
                    }
                    if (StringsKt.isBlank(str2)) {
                        str2 = this.mNavigation.getLynxViewDataManager().getViewConf().getBid();
                        str = "config_bid";
                    }
                    if (StringsKt.isBlank(str2) && (event instanceof CustomEvent)) {
                        CustomEvent customEvent2 = (CustomEvent) event;
                        bid = customEvent2.getCustomInfo().getBid();
                        if (!(bid != null || bid.length() == 0)) {
                            str2 = customEvent2.getCustomInfo().getBid();
                            Intrinsics.checkNotNullExpressionValue(str2, "event.customInfo.bid");
                            if (StringsKt.isBlank(str2)) {
                                str2 = BidInfo.DEFAULT;
                                Intrinsics.checkNotNullExpressionValue(str2, "DEFAULT");
                            } else {
                                str4 = str3;
                            }
                            event.setBid(str2);
                            event.setBidSource(str4);
                            return new Triple<>(str2, str4, ReportDataUtils.INSTANCE.determineBidConfig(str2));
                        }
                    }
                    str3 = str;
                    if (StringsKt.isBlank(str2)) {
                    }
                    event.setBid(str2);
                    event.setBidSource(str4);
                    return new Triple<>(str2, str4, ReportDataUtils.INSTANCE.determineBidConfig(str2));
                }
            }
        }
        str = "default_bid";
        if (StringsKt.isBlank(str2)) {
        }
        if (StringsKt.isBlank(str2)) {
        }
        if (StringsKt.isBlank(str2)) {
        }
        if (StringsKt.isBlank(str2)) {
            CustomEvent customEvent22 = (CustomEvent) event;
            bid = customEvent22.getCustomInfo().getBid();
            if (!(bid != null || bid.length() == 0)) {
            }
        }
        str3 = str;
        if (StringsKt.isBlank(str2)) {
        }
        event.setBid(str2);
        event.setBidSource(str4);
        return new Triple<>(str2, str4, ReportDataUtils.INSTANCE.determineBidConfig(str2));
    }

    public final void notifyAllEvents() {
        this.typedDataDispatcher.notifyAllEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void useConfig(HybridEvent event) {
        if (StringsKt.isBlank(this.mNavigation.getMonitorId())) {
            String fallbackContainerName = this.mNavigation.getLynxViewDataManager().getViewConf().getFallbackContainerName();
            if (!(!StringsKt.isBlank(fallbackContainerName))) {
                fallbackContainerName = null;
            }
            if (fallbackContainerName != null) {
                event.setContainerBase(new ContainerBase((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to("container_name", ContainerStandardConst.DEFAULT_CONTAINER_NAME))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logForBlank(CommonEvent event) {
        if (CollectionsKt.listOf(new String[]{ReportConst.Event.JS_EXCEPTION, ReportConst.Event.STATIC, "nativeError"}).contains(event.getEventType())) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("session_id", event.getFullLinkId());
            jSONObject.put("event_type", event.getEventType());
            jSONObject.put("url", this.mNavigation.getTemplateUrl());
            MonitorLog.m29i("LynxEventHandler", jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void afterReport(CommonEvent event) {
        if (Intrinsics.areEqual(event.getEventType(), "navigationStart")) {
            this.mNavigation.getLynxViewDataManager().getCommonProps().setAnnieXContainerReuse(true);
        }
    }
}
