package com.bytedance.android.monitorV2.util;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.RegexMatcher;
import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.entity.ContainerInfo;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.event.CommonEvent;
import com.bytedance.android.monitorV2.event.CustomEvent;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.experiment.HostExperimentManager;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.PreloadConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReportDataUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ0\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010$\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b.J\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010/\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u00101\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/android/monitorV2/util/ReportDataUtils;", "", "()V", "TAG", "", "bidPriorityRule", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bidRegexPattern", "pidRegexPattern", "addBidContext", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", Api.KEY_ENCRYPT_RESP_KEY, "commonEventToJsonObj", "Lorg/json/JSONObject;", "Lcom/bytedance/android/monitorV2/event/CommonEvent;", "customEventToJsonObj", "customEvent", "Lcom/bytedance/android/monitorV2/event/CustomEvent;", "determineBid", "determineBidConfig", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidInfo$BidConfig;", "bid", "eventToJsonObj", "extractBid", "eventType", "jsonObj", "getBid", "url", "schema", "defaultBid", "tryRegexListBidWhenMiss", "", "getBidFromTags", "match", "regexInputs", "", "regexPatterns", "parseBid", "regexInput", "Lcom/bytedance/android/monitorV2/util/ReportDataUtils$RegexInput;", "parsePid", "parseRegexBid", "parseRegexField", "parseRegexField$anniex_release", "parseRegexPid", "setRegexBid", "setRegexPid", "RegexInput", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ReportDataUtils {
    private static final String TAG = "ReportDataUtils";
    public static final ReportDataUtils INSTANCE = new ReportDataUtils();
    private static final ArrayList<String> bidPriorityRule = CollectionsKt.arrayListOf(new String[]{"jsb_bid", "regex_bid", "config_bid"});
    private static final ArrayList<String> bidRegexPattern = CollectionsKt.arrayListOf(new String[]{"[?&]bd_hybrid_monitor_bid=([^&#]+)", "[?&]bdhm_bid=([^&#]+)"});
    private static final ArrayList<String> pidRegexPattern = CollectionsKt.arrayListOf(new String[]{"[?&]bdhm_pid=([^&#]+)"});

    public final String getBid(String str, String str2, String str3) {
        return getBid$default(this, str, str2, str3, false, 8, null);
    }

    private ReportDataUtils() {
    }

    public final JSONObject eventToJsonObj(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event instanceof CommonEvent ? commonEventToJsonObj((CommonEvent) event) : event instanceof CustomEvent ? customEventToJsonObj((CustomEvent) event) : new JSONObject();
    }

    public final JSONObject commonEventToJsonObj(CommonEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        JSONObject jSONObject = new JSONObject();
        String determineBid = determineBid(event);
        BidInfo.BidConfig determineBidConfig = determineBidConfig(determineBid);
        JSONObject jSONObject2 = new JSONObject();
        Object obj = event.getTags().get("config_bid");
        if (obj == null) {
            obj = "";
        }
        event.getNativeBase().addContext(ReportConst.BidSourceInfo.BID_SOURCE, event.getBidSource());
        JsonUtils.safePut(jSONObject, "event_type", event.getEventType());
        JsonUtils.safePut(jSONObject, ReportConst.Params.FULL_LINK_ID, event.getFullLinkId());
        JSONObject jsonObject = event.getNativeBase().toJsonObject();
        JsonUtils.safePut(jSONObject, "nativeBase", jsonObject);
        JsonUtils.safePut(jsonObject, ReportConst.Params.BID_INFO, jSONObject2);
        JsonUtils.safePut(jSONObject2, "bid", determineBid);
        JsonUtils.safePut(jSONObject2, ReportConst.Params.SETTING_BID, determineBidConfig.bid);
        JsonUtils.safePut(jSONObject2, "hit_sample", determineBidConfig.hitSample);
        JsonUtils.safePut(jSONObject2, "setting_id", determineBidConfig.settingId);
        JsonUtils.safePut(jSONObject2, "config_bid", obj);
        if (event.getNativeInfo() != null) {
            BaseNativeInfo nativeInfo = event.getNativeInfo();
            JsonUtils.safePut(jSONObject, "nativeInfo", nativeInfo != null ? nativeInfo.toJsonObject() : null);
        }
        if (event.getJsInfo() != null) {
            JsonUtils.safePut(jSONObject, "jsInfo", event.getJsInfo());
        }
        if (event.getJsBase() != null) {
            JsonUtils.safePut(jSONObject, "jsBase", event.getJsBase());
        }
        if (event.getContainerBase() != null) {
            ContainerBase containerBase = event.getContainerBase();
            JsonUtils.safePut(jSONObject, "containerBase", containerBase != null ? containerBase.toJsonObject() : null);
        }
        if (event.getContainerInfo() != null) {
            ContainerInfo containerInfo = event.getContainerInfo();
            JsonUtils.safePut(jSONObject, "containerInfo", containerInfo != null ? containerInfo.toJsonObject() : null);
        }
        Map<String, Object> extra = event.getExtra();
        if (extra != null) {
            JsonUtils.safePut(jSONObject, "extra", new JSONObject(extra));
        }
        return jSONObject;
    }

    public final JSONObject customEventToJsonObj(CustomEvent customEvent) {
        Intrinsics.checkNotNullParameter(customEvent, "customEvent");
        String determineBid = determineBid(customEvent);
        customEvent.getCustomInfo().setBid(determineBid);
        BidInfo.BidConfig determineBidConfig = determineBidConfig(determineBid);
        JSONObject jSONObject = new JSONObject();
        Object obj = customEvent.getTags().get("config_bid");
        if (obj == null) {
            obj = "";
        }
        customEvent.getNativeBase().addContext(ReportConst.BidSourceInfo.BID_SOURCE, customEvent.getBidSource());
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.safePut(jSONObject2, ReportConst.Params.FULL_LINK_ID, customEvent.getFullLinkId());
        JsonUtils.safePut(jSONObject2, ReportConst.Params.BID_INFO, jSONObject);
        JsonUtils.safePut(jSONObject, "bid", determineBid);
        JsonUtils.safePut(jSONObject, ReportConst.Params.SETTING_BID, determineBidConfig.bid);
        JsonUtils.safePut(jSONObject, "hit_sample", determineBidConfig.hitSample);
        JsonUtils.safePut(jSONObject, "setting_id", determineBidConfig.settingId);
        JsonUtils.safePut(jSONObject, "config_bid", obj);
        JsonUtils.safePut(jSONObject, ReportConst.Params.CAN_SAMPLE, customEvent.getCustomInfo().getCanSample());
        if (customEvent.getCustomInfo().getCategory() != null) {
            JsonUtils.safePut(jSONObject2, "client_category", customEvent.getCustomInfo().getCategory());
        }
        if (customEvent.getCustomInfo().getMetric() != null) {
            JsonUtils.safePut(jSONObject2, "client_metric", customEvent.getCustomInfo().getMetric());
        }
        if (customEvent.getCustomInfo().getExtra() != null) {
            JsonUtils.safePut(customEvent.getCustomInfo().getExtra(), "event_name", customEvent.getCustomInfo().getEventName());
            JsonUtils.safePut(customEvent.getCustomInfo().getExtra(), "sdk_version", AnnieXMonitorConstants.ANNIEX_VERSION);
            JsonUtils.safePut(jSONObject2, "client_extra", customEvent.getCustomInfo().getExtra());
        }
        if (customEvent.getCustomInfo().getTiming() != null) {
            JsonUtils.safePut(jSONObject2, "client_timing", customEvent.getCustomInfo().getTiming());
        }
        JsonUtils.safePut(jSONObject2, "nativeBase", customEvent.getNativeBase().toJsonObject());
        if (customEvent.getContainerBase() != null) {
            ContainerBase containerBase = customEvent.getContainerBase();
            JsonUtils.safePut(jSONObject2, "containerBase", containerBase != null ? containerBase.toJsonObject() : null);
        }
        if (customEvent.getJsBase() != null) {
            JsonUtils.safePut(jSONObject2, "jsBase", customEvent.getJsBase());
        }
        String url = customEvent.getCustomInfo().getUrl();
        JsonUtils.safePut(jSONObject2, "url", url);
        if (url != null) {
            JsonUtils.safePut(jSONObject2, "host", UrlUtil.INSTANCE.getHost(url));
            JsonUtils.safePut(jSONObject2, "path", UrlUtil.INSTANCE.getPath(url));
        }
        JsonUtils.safePut(jSONObject2, "ev_type", "custom");
        JSONObject common = customEvent.getCustomInfo().getCommon();
        if (common != null && common.has("virtual_aid")) {
            common.remove("virtual_aid");
        }
        JsonUtils.deepCopy(jSONObject2, customEvent.getCustomInfo().getCommon());
        return jSONObject2;
    }

    public final String determineBid(Object event) {
        String bid;
        Intrinsics.checkNotNullParameter(event, "event");
        String str = "";
        if (HostExperimentManager.INSTANCE.getEnablePreSample()) {
            HybridEvent hybridEvent = event instanceof HybridEvent ? (HybridEvent) event : null;
            boolean z = false;
            if (hybridEvent != null && hybridEvent.getPreSample()) {
                z = true;
            }
            if (z) {
                if (event instanceof CommonEvent) {
                    return ((HybridEvent) event).getBid();
                }
                if (!(event instanceof CustomEvent)) {
                    return "";
                }
                HybridEvent hybridEvent2 = (HybridEvent) event;
                if (!Intrinsics.areEqual(hybridEvent2.getBid(), BidInfo.DEFAULT)) {
                    bid = hybridEvent2.getBid();
                } else {
                    CustomEvent customEvent = (CustomEvent) event;
                    if (!TextUtils.isEmpty(customEvent.getCustomInfo().getBid())) {
                        bid = customEvent.getCustomInfo().getBid();
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                if (ev…         }\n\n            }");
                    return str;
                }
                str = bid;
                Intrinsics.checkNotNullExpressionValue(str, "{\n                if (ev…         }\n\n            }");
                return str;
            }
        }
        if (event instanceof CommonEvent) {
            return getBidFromTags((HybridEvent) event);
        }
        if (!(event instanceof CustomEvent)) {
            return "";
        }
        CustomEvent customEvent2 = (CustomEvent) event;
        if (!TextUtils.isEmpty(customEvent2.getCustomInfo().getBid())) {
            String bid2 = customEvent2.getCustomInfo().getBid();
            Intrinsics.checkNotNullExpressionValue(bid2, "event.customInfo.bid");
            return bid2;
        }
        return getBidFromTags((HybridEvent) event);
    }

    public final BidInfo.BidConfig determineBidConfig(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        BidInfo.BidConfig bidConfig = HybridMultiMonitor.getInstance().getHybridSettingManager().getBidInfo().get(bid);
        Intrinsics.checkNotNullExpressionValue(bidConfig, "getInstance().hybridSett…gManager.bidInfo.get(bid)");
        return bidConfig;
    }

    public final String getBid(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return extractBid(event instanceof CustomEvent ? "custom" : "", eventToJsonObj(event));
    }

    public static /* synthetic */ String getBid$default(ReportDataUtils reportDataUtils, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return reportDataUtils.getBid(str, str2, str3, z);
    }

    public final String getBid(String url, String schema, String defaultBid, boolean tryRegexListBidWhenMiss) {
        LinkedList linkedList = new LinkedList();
        if (url != null) {
            linkedList.add(url);
        }
        if (schema != null) {
            linkedList.add(schema);
        }
        String match = match(linkedList, bidRegexPattern);
        if (StringsKt.isBlank(match) && url != null) {
            match = RegexMatcher.INSTANCE.matchBid(url, HybridMultiMonitor.getInstance().getHybridSettingManager().getRexList(), tryRegexListBidWhenMiss);
        }
        return (!StringsKt.isBlank(match) || defaultBid == null) ? match : defaultBid;
    }

    public final void parseRegexField$anniex_release(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        RegexInput regexInput = new RegexInput(event);
        parseBid(event, regexInput);
        parsePid(event, regexInput);
    }

    public final void parseRegexPid(HybridEvent event) {
        JSONObject jsBase;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullExpressionValue(JsonUtils.safeOptStr(event.getJsBase(), "pid"), "safeOptStr(event.jsBase, \"pid\")");
        if (!StringsKt.isBlank(r0)) {
            return;
        }
        if (event.getJsBase() == null) {
            event.setJsBase(new JSONObject());
        }
        RegexInput regexInput = new RegexInput(event);
        LinkedList linkedList = new LinkedList();
        linkedList.add(regexInput.getUrl());
        linkedList.add(regexInput.getSchema());
        String match = match(linkedList, pidRegexPattern);
        if (!(!StringsKt.isBlank(match)) || (jsBase = event.getJsBase()) == null) {
            return;
        }
        jsBase.put("pid", match);
    }

    private final void parseBid(HybridEvent event, RegexInput regexInput) {
        if (!HostExperimentManager.INSTANCE.getEnableBidRegexOptimize()) {
            setRegexBid(event, regexInput);
            return;
        }
        if (event instanceof CustomEvent) {
            CustomInfo customInfo = ((CustomEvent) event).getCustomInfo();
            if (!TextUtils.isEmpty(customInfo != null ? customInfo.getBid() : null)) {
                return;
            }
        }
        Iterator<String> it = bidPriorityRule.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (Intrinsics.areEqual("regex_bid", next)) {
                setRegexBid(event, regexInput);
            }
            if ((event.getTags().get(next) instanceof String) && (!StringsKt.isBlank((CharSequence) r1))) {
                return;
            }
        }
    }

    private final void parsePid(HybridEvent event, RegexInput regexInput) {
        Intrinsics.checkNotNullExpressionValue(JsonUtils.safeOptStr(event.getJsBase(), "pid"), "safeOptStr(event.jsBase, \"pid\")");
        if (!StringsKt.isBlank(r0)) {
            return;
        }
        setRegexPid(event, regexInput);
    }

    private final String extractBid(String eventType, JSONObject jsonObj) {
        if (!Intrinsics.areEqual("custom", eventType)) {
            try {
                String string = jsonObj.getJSONObject("nativeBase").getJSONObject(ReportConst.Params.BID_INFO).getString(ReportConst.Params.SETTING_BID);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getJSONObject(Re…Const.Params.SETTING_BID)");
                return string;
            } catch (JSONException e) {
                ExceptionUtil.handleException(e);
            }
        } else {
            try {
                String string2 = jsonObj.getJSONObject(ReportConst.Params.BID_INFO).getString(ReportConst.Params.SETTING_BID);
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getJSONObject(Re…Const.Params.SETTING_BID)");
                return string2;
            } catch (JSONException e2) {
                ExceptionUtil.handleException(e2);
            }
        }
        return "";
    }

    private final String getBidFromTags(HybridEvent event) {
        Map<String, Object> tags = event.getTags();
        Iterator<String> it = bidPriorityRule.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Object obj = tags.get(next);
            if ((obj instanceof String) && (!StringsKt.isBlank((CharSequence) obj))) {
                Intrinsics.checkNotNullExpressionValue(next, Api.KEY_ENCRYPT_RESP_KEY);
                addBidContext(event, next);
                return (String) obj;
            }
        }
        event.getNativeBase().addContext(ReportConst.BidSourceInfo.BID_SOURCE, "default_bid");
        return "";
    }

    private final void setRegexBid(HybridEvent event, RegexInput regexInput) {
        event.getTags().put("regex_bid", parseRegexBid(event, regexInput));
    }

    private final void setRegexPid(HybridEvent event, RegexInput regexInput) {
        JSONObject jsBase;
        if (event.getJsBase() == null) {
            event.setJsBase(new JSONObject());
        }
        String parseRegexPid = parseRegexPid(regexInput);
        if (!(!StringsKt.isBlank(parseRegexPid)) || (jsBase = event.getJsBase()) == null) {
            return;
        }
        jsBase.put("pid", parseRegexPid);
    }

    private final String parseRegexBid(HybridEvent event, RegexInput regexInput) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(regexInput.getUrl());
        linkedList.add(regexInput.getSchema());
        String match = match(linkedList, bidRegexPattern);
        event.putExtra(ReportConst.BidSourceInfo.BID_REGEX_SOURCE, ReportConst.BidSourceInfo.BID_SOURCE_REGEX_PARAM);
        if (StringsKt.isBlank(match) && (!StringsKt.isBlank(regexInput.getUrl()))) {
            match = RegexMatcher.matchBid$default(RegexMatcher.INSTANCE, regexInput.getUrl(), HybridMultiMonitor.getInstance().getHybridSettingManager().getRexList(), false, 4, null);
            event.putExtra(ReportConst.BidSourceInfo.BID_REGEX_SOURCE, ReportConst.BidSourceInfo.BID_SOURCE_REGEX_LIST);
        }
        MonitorLog.m29i(TAG, "regexMatcher: " + match);
        return match;
    }

    private final String parseRegexPid(RegexInput regexInput) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(regexInput.getUrl());
        linkedList.add(regexInput.getSchema());
        return match(linkedList, pidRegexPattern);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        if (r4 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String match(List<String> regexInputs, List<String> regexPatterns) {
        Object obj;
        String str;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        for (String str2 : regexInputs) {
            for (String str3 : regexPatterns) {
                if (!StringsKt.isBlank(str2)) {
                    try {
                        Result.Companion companion = Result.Companion;
                        ReportDataUtils reportDataUtils = this;
                        Matcher matcher = Pattern.compile(str3).matcher(str2);
                        if (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null) {
                                Intrinsics.checkNotNullExpressionValue(group, "group(1)");
                                String str4 = group;
                                int length = str4.length() - 1;
                                int i = 0;
                                boolean z = false;
                                while (i <= length) {
                                    boolean z2 = Intrinsics.compare(str4.charAt(!z ? i : length), 32) <= 0;
                                    if (z) {
                                        if (!z2) {
                                            break;
                                        }
                                        length--;
                                    } else if (z2) {
                                        i++;
                                    } else {
                                        z = true;
                                    }
                                }
                                str = str4.subSequence(i, length + 1).toString();
                            }
                            str = "";
                            objectRef.element = str;
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (!(!StringsKt.isBlank((CharSequence) objectRef.element))) {
                        obj = Result.constructor-impl(Unit.INSTANCE);
                        Throwable th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                            MonitorLog.m28e(TAG, "match error", th2);
                        }
                    } else {
                        return (String) objectRef.element;
                    }
                }
            }
        }
        return (String) objectRef.element;
    }

    private final void addBidContext(HybridEvent event, String key) {
        if (Intrinsics.areEqual("regex_bid", key)) {
            Map<String, Object> extra = event.getExtra();
            Object obj = extra != null ? extra.get(ReportConst.BidSourceInfo.BID_REGEX_SOURCE) : null;
            key = obj instanceof String ? (String) obj : null;
            if (key == null) {
                key = "";
            }
        }
        event.getNativeBase().addContext(ReportConst.BidSourceInfo.BID_SOURCE, key);
    }

    /* compiled from: ReportDataUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/monitorV2/util/ReportDataUtils$RegexInput;", "", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "(Lcom/bytedance/android/monitorV2/event/HybridEvent;)V", "schema", "", "getSchema", "()Ljava/lang/String;", "url", "getUrl", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class RegexInput {
        private final HybridEvent event;
        private final String schema;
        private final String url;

        /* renamed from: component1, reason: from getter */
        private final HybridEvent getEvent() {
            return this.event;
        }

        public static /* synthetic */ RegexInput copy$default(RegexInput regexInput, HybridEvent hybridEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                hybridEvent = regexInput.event;
            }
            return regexInput.copy(hybridEvent);
        }

        public final RegexInput copy(HybridEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new RegexInput(event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RegexInput) && Intrinsics.areEqual(this.event, ((RegexInput) other).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        public String toString() {
            return "RegexInput(event=" + this.event + ')';
        }

        public RegexInput(HybridEvent hybridEvent) {
            String url;
            Intrinsics.checkNotNullParameter(hybridEvent, "event");
            this.event = hybridEvent;
            String str = "";
            if (!(hybridEvent instanceof CommonEvent) ? !(!(hybridEvent instanceof CustomEvent) || (url = ((CustomEvent) hybridEvent).getCustomInfo().getUrl()) == null) : (url = hybridEvent.getNativeBase().url) != null) {
                str = url;
            }
            this.url = str;
            ContainerBase containerBase = hybridEvent.getContainerBase();
            String safeOptStr = JsonUtils.safeOptStr(containerBase != null ? containerBase.toJsonObject() : null, "schema");
            Intrinsics.checkNotNullExpressionValue(safeOptStr, "safeOptStr(\n            …st.FIELD_SCHEMA\n        )");
            this.schema = safeOptStr;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getSchema() {
            return this.schema;
        }
    }
}
