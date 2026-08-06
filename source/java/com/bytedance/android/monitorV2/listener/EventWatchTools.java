package com.bytedance.android.monitorV2.listener;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.entity.ContainerBase;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.bytedance.android.monitorV2.lifecycle.MonitorLifecycleManager;
import com.bytedance.android.monitorV2.lifecycle.OnApplicationBackgroundListener;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.util.ReportDataUtils;
import com.bytedance.apm.block.BlockConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.applog.GameReportHelper;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.localstorage.DbManager;
import com.bytedance.crash.util.DateUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: EventWatchTools.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u001c\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00192\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002J\u0010\u0010/\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00102\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00103\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u00104\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u000208H\u0002J \u00109\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/bytedance/android/monitorV2/listener/EventWatchTools;", "Lcom/bytedance/android/monitorV2/listener/IHybridEventListener;", "()V", "backgroundHandler", "Landroid/os/Handler;", "createPhase", "", "eventCountMap", "", "", "eventCreateSet", "", "foregroundHandler", "handlerThread", "Landroid/os/HandlerThread;", "isReport", "", "settingsFilter", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "getSettingsFilter", "()Lcom/bytedance/android/monitorV2/hybridSetting/entity/CheckFilter;", "settingsFilter$delegate", "Lkotlin/Lazy;", "startTs", "translateMap", "", "backgroundFlushTask", "", "checkAndUpload", "checkSettings", DbManager.KEY_SETTINGS, "ensureContainer", Api.KEY_ENCRYPT_RESP_KEY, "flush", "flushToLocal", "foregroundFlushTask", "generateCategory", "keyStr", "generateKey", "event", "Lcom/bytedance/android/monitorV2/event/HybridEvent;", "getContainerName", "getContainerType", "getFieldMap", "getKeyStr", "getPhase", "phase", "onEventCreated", "onEventSampled", "onEventTerminated", "onEventUpdated", "onEventUploaded", "putEvent", "realFlush", "realUpload", "jsonObject", "Lorg/json/JSONObject;", "updateEventCount", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class EventWatchTools implements IHybridEventListener {
    public static final String BID = "bid";
    public static final String CONTAINER_NAME = "containerName";
    public static final String CONTAINER_TYPE = "containerType";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_KEY = "==";
    public static final String EVENT_TYPE = "eventType";
    public static final String FILTER_ID = "id";
    public static final String MAGIC_KEY = "@@";
    public static final String SDK_VERSION = "sdkVersion";
    public static final String TAG = "EventWatchTools";
    private static boolean isInit;
    private Handler backgroundHandler;
    private Handler foregroundHandler;
    private boolean isReport;
    private final Map<String, Map<String, Long>> eventCountMap = new ConcurrentHashMap();
    private final long startTs = System.currentTimeMillis();
    private final HandlerThread handlerThread = new HandlerThread("MonitorEventWatch");

    /* renamed from: settingsFilter$delegate, reason: from kotlin metadata */
    private final Lazy settingsFilter = LazyKt.lazy(new Function0<CheckFilter>() { // from class: com.bytedance.android.monitorV2.listener.EventWatchTools$settingsFilter$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final CheckFilter m338invoke() {
            return HybridMultiMonitor.getInstance().getHybridSettingManager().getCheckFilter();
        }
    });
    private final Set<String> eventCreateSet = new LinkedHashSet();
    private final String createPhase = PerfConsts.PERF_DISK_TOTAL;
    private final Map<String, String> translateMap = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(HybridEvent.EventPhase.EVENT_CREATE.name(), PerfConsts.PERF_DISK_TOTAL), TuplesKt.to(HybridEvent.EventPhase.EVENT_UPLOAD.name(), "upload"), TuplesKt.to(HybridEvent.EventPhase.SAMPLE_THROW.name(), "unsample"), TuplesKt.to(HybridEvent.TerminateType.SWITCH_OFF.name(), "switch_off"), TuplesKt.to(HybridEvent.TerminateType.PARAM_EXCEPTION.name(), "type_invalid"), TuplesKt.to(HybridEvent.TerminateType.CATCH_EXCEPTION.name(), "exception"), TuplesKt.to(HybridEvent.TerminateType.EVENT_REPEATED.name(), "repeat"), TuplesKt.to(HybridEvent.TerminateType.INVALID_CASE.name(), "invalid_case"), TuplesKt.to(HybridEvent.TerminateType.BLOCK_LIST.name(), "block_list")});

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventUpdated(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public EventWatchTools() {
        MonitorLifecycleManager.INSTANCE.getForegroundManager().addOnApplicationBackgroundListener(new OnApplicationBackgroundListener() { // from class: com.bytedance.android.monitorV2.listener.EventWatchTools.1
            @Override // com.bytedance.android.monitorV2.lifecycle.OnApplicationBackgroundListener
            public void onApplicationBackground(Context context) {
                EventWatchTools.this.flush();
            }
        });
    }

    private final CheckFilter getSettingsFilter() {
        Object value = this.settingsFilter.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-settingsFilter>(...)");
        return (CheckFilter) value;
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventCreated(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Set<String> set = this.eventCreateSet;
        String uuid = event.getEventId().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
        set.add(uuid);
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventTerminated(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        updateEventCount(event, generateKey(event), getPhase(String.valueOf(event.getState().getTerminateType())));
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventSampled(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        updateEventCount(event, generateKey(event), getPhase(String.valueOf(event.getState().getEventPhase())));
    }

    @Override // com.bytedance.android.monitorV2.listener.IHybridEventListener
    public void onEventUploaded(HybridEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        updateEventCount(event, generateKey(event), getPhase(String.valueOf(event.getState().getEventPhase())));
    }

    private final void checkAndUpload() {
        long j = MonitorGlobalSp.getLong(MonitorGlobalSp.MONITOR_EVENT_FLUSH_TIME, 0L);
        if (j == 0) {
            return;
        }
        if (this.startTs - j <= DateUtils.DAY) {
            String string = MonitorGlobalSp.getString(MonitorGlobalSp.MONITOR_EVENT_DETAILS, "");
            if (string.length() > 0) {
                JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(string);
                Intrinsics.checkNotNullExpressionValue(safeToJsonOb, "jsonObj");
                realUpload(safeToJsonOb);
            }
        }
        MonitorGlobalSp.putString(MonitorGlobalSp.MONITOR_EVENT_DETAILS, "");
    }

    private final void realUpload(JSONObject jsonObject) {
        try {
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "ctKey");
                Map<String, String> generateCategory = generateCategory(next);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(jsonObject, next);
                Iterator<String> keys2 = safeOptJsonObj.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "mKey");
                    linkedHashMap.put(next2, Long.valueOf(JsonUtils.safeOptLong(safeOptJsonObj, next2)));
                }
                InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_REPORT_CHECK_PLUS, generateCategory, linkedHashMap);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    private final String generateKey(HybridEvent event) {
        if (!this.isReport) {
            checkAndUpload();
            this.isReport = true;
        }
        return !checkSettings(getSettingsFilter()) ? "" : getKeyStr(event);
    }

    private final boolean checkSettings(CheckFilter settings) {
        Iterator<Map.Entry<String, List<String>>> it = settings.getFilter().entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final String getKeyStr(HybridEvent event) {
        Map<String, String> fieldMap = getFieldMap(event);
        boolean z = false;
        String str = "";
        for (String str2 : ReportConst.ReportCheck.FILTER_LIST) {
            List<String> list = getSettingsFilter().getFilter().get(str2);
            Intrinsics.checkNotNull(list);
            List<String> list2 = list;
            if (z) {
                str = str + MAGIC_KEY;
            }
            if ((!list2.isEmpty()) && !CollectionsKt.contains(list2, fieldMap.get(str2))) {
                return "";
            }
            str = str + (list2.isEmpty() ? DEFAULT_KEY : fieldMap.get(str2));
            z = true;
        }
        return str;
    }

    private final Map<String, String> getFieldMap(HybridEvent event) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("containerName", getContainerName(event)), TuplesKt.to("bid", ReportDataUtils.INSTANCE.getBid(event)), TuplesKt.to("eventType", event.getEventType()), TuplesKt.to("containerType", getContainerType(event)), TuplesKt.to("sdkVersion", AnnieXMonitorConstants.ANNIEX_VERSION)});
    }

    private final void updateEventCount(HybridEvent event, String key, String phase) {
        try {
            String uuid = event.getEventId().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "event.eventId.toString()");
            if (key.length() == 0) {
                this.eventCreateSet.remove(uuid);
                return;
            }
            putEvent(key, phase);
            if (this.eventCreateSet.contains(uuid)) {
                putEvent(key, this.createPhase);
                this.eventCreateSet.remove(uuid);
            }
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    private final void putEvent(String key, String phase) {
        if (ensureContainer(key).containsKey(phase)) {
            Map<String, Long> ensureContainer = ensureContainer(key);
            Long l = ensureContainer(key).get(phase);
            Intrinsics.checkNotNull(l);
            ensureContainer.put(phase, Long.valueOf(l.longValue() + 1));
        } else {
            ensureContainer(key).put(phase, 1L);
        }
        flushToLocal();
    }

    private final Map<String, Long> ensureContainer(String key) {
        if (this.eventCountMap.get(key) == null) {
            this.eventCountMap.put(key, new ConcurrentHashMap());
        }
        Map<String, Long> map = this.eventCountMap.get(key);
        Intrinsics.checkNotNull(map);
        return map;
    }

    private final Map<String, String> generateCategory(String keyStr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List split$default = StringsKt.split$default(keyStr, new String[]{MAGIC_KEY}, false, 0, 6, (Object) null);
        List<String> category = getSettingsFilter().getCategory();
        int size = split$default.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual(split$default.get(i), DEFAULT_KEY) && category.contains(ReportConst.ReportCheck.FILTER_LIST.get(i))) {
                String str = ReportConst.ReportCheck.FILTER_LIST.get(i);
                Intrinsics.checkNotNullExpressionValue(str, "ReportCheck.FILTER_LIST[i]");
                linkedHashMap.put(str, split$default.get(i));
            }
        }
        linkedHashMap.put("id", MonitorGlobalSp.getString(MonitorGlobalSp.MONITOR_EVENT_FILTER_ID, ""));
        return linkedHashMap;
    }

    private final String getContainerName(HybridEvent event) {
        ContainerBase containerBase = event.getContainerBase();
        String safeOptStr = JsonUtils.safeOptStr(containerBase != null ? containerBase.toJsonObject() : null, "container_name");
        Intrinsics.checkNotNullExpressionValue(safeOptStr, "safeOptStr(event.contain…nst.FIELD_CONTAINER_NAME)");
        return safeOptStr;
    }

    private final String getContainerType(HybridEvent event) {
        ContainerBase containerBase = event.getContainerBase();
        String safeOptStr = JsonUtils.safeOptStr(containerBase != null ? containerBase.toJsonObject() : null, "container_type");
        Intrinsics.checkNotNullExpressionValue(safeOptStr, "safeOptStr(event.contain…nst.FIELD_CONTAINER_TYPE)");
        return safeOptStr;
    }

    private final String getPhase(String phase) {
        String str = this.translateMap.get(phase);
        return str == null ? "unknown_phase" : str;
    }

    private final void flushToLocal() {
        if (this.foregroundHandler == null) {
            this.handlerThread.start();
            this.foregroundHandler = new Handler(this.handlerThread.getLooper());
            foregroundFlushTask();
        }
        if (MonitorLifecycleManager.INSTANCE.getForegroundManager().getIsApplicationBackgrounded()) {
            backgroundFlushTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void foregroundFlushTask() {
        Handler handler = this.foregroundHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.bytedance.android.monitorV2.listener.EventWatchTools$foregroundFlushTask$1
                @Override // java.lang.Runnable
                public final void run() {
                    EventWatchTools.this.realFlush();
                    EventWatchTools.this.foregroundFlushTask();
                }
            }, BlockConstants.BUFFER_SIZE);
        }
    }

    private final void backgroundFlushTask() {
        if (this.backgroundHandler == null) {
            this.backgroundHandler = new Handler(this.handlerThread.getLooper());
        }
        Handler handler = this.backgroundHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.backgroundHandler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.android.monitorV2.listener.EventWatchTools$backgroundFlushTask$1
                @Override // java.lang.Runnable
                public final void run() {
                    EventWatchTools.this.realFlush();
                }
            }, 2000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void realFlush() {
        MonitorLog.m26d(TAG, "realFlush");
        Map<String, Map<String, Long>> map = this.eventCountMap;
        if (!(map instanceof Map)) {
            map = null;
        }
        if (map != null) {
            String jSONObject = new JSONObject(map).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(it).toString()");
            MonitorGlobalSp.putString(MonitorGlobalSp.MONITOR_EVENT_DETAILS, jSONObject);
        }
        MonitorGlobalSp.putLong(MonitorGlobalSp.MONITOR_EVENT_FLUSH_TIME, System.currentTimeMillis());
        MonitorGlobalSp.putString(MonitorGlobalSp.MONITOR_EVENT_FILTER_ID, getSettingsFilter().getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flush() {
        Handler handler = this.foregroundHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.listener.EventWatchTools$flush$1
                @Override // java.lang.Runnable
                public final void run() {
                    EventWatchTools.this.realFlush();
                }
            });
        }
    }

    /* compiled from: EventWatchTools.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/listener/EventWatchTools$Companion;", "", "()V", "BID", "", "CONTAINER_NAME", "CONTAINER_TYPE", "DEFAULT_KEY", "EVENT_TYPE", "FILTER_ID", "MAGIC_KEY", "SDK_VERSION", "TAG", "isInit", "", GameReportHelper.REGISTER, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void register() {
            if (!EventWatchTools.isInit && HybridMultiMonitor.getInstance().getHybridSettingManager().getSwitch().isEnableCheckSelf()) {
                HybridMultiMonitor.getInstance().registerHybridEventListener(new EventWatchTools());
                EventWatchTools.isInit = true;
            }
        }
    }
}
