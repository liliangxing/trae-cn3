package com.bytedance.ies.argus.base;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.apm.block.LooperObserverMonitor;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.api.interfaces.SecureReportInfo;
import com.bytedance.ies.argus.aspect.eventCenter.BaseViewContext;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.bean.ArgusMonitorKeyName;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.IArgusAspect;
import com.bytedance.ies.argus.bean.IArgusVerifyReason;
import com.bytedance.ies.argus.bean.ReportConfig;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.AspectConfigInfo;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.lynx.tasm.LynxView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ArgusMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u0016\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160!H\u0002J\u0016\u0010\"\u001a\u00020\u00162\u000e\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0015J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0015J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J4\u0010-\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u00101\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J,\u00102\u001a\u0004\u0018\u00010\u00042\u0018\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000405042\u0006\u00106\u001a\u00020\nH\u0002J \u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0015H\u0002J\u0018\u0010;\u001a\u00020\u00162\u000e\u0010#\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$H\u0002J\u0016\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0015J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0015H\u0002J\u001c\u0010@\u001a\u00020\u00152\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020B0AH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R)\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R3\u0010\u0013\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001d¨\u0006C"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusMonitor;", "", "()V", "ERROR_DEFAULT_BID", "", "TAG", "VERIFY_ERROR_EVENT_NAME", "VERIFY_EVENT_NAME", "aspectLimitRemainCounter", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getAspectLimitRemainCounter", "()Ljava/util/concurrent/ConcurrentHashMap;", "aspectLimitRemainCounter$delegate", "Lkotlin/Lazy;", "reportConfig", "Lcom/bytedance/ies/argus/bean/ReportConfig;", "getReportConfig", "()Lcom/bytedance/ies/argus/bean/ReportConfig;", "teaReporter", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "getTeaReporter", "()Lkotlin/jvm/functions/Function2;", "teaReporter$delegate", "threadExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadExecutor$delegate", "asyncReport", "task", "Lkotlin/Function0;", "asyncReportAspect", "context", "Lcom/bytedance/ies/argus/bean/AspectContext;", "asyncReportInnerError", "categoryObj", "asyncReportLifeCycle", "data", "checkCanReport", "", "aspect", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "checkShouldReportTea", "enableReport", "bid", "sceneTag", "initTeaReporter", "joinVerifyResult", "resultList", "", "Lkotlin/Pair;", "minSize", "printDebugLog", "event", "obj", "metric", "reportContext", "reportTea", "eventName", "transformJsonToString", "json", "transformMetrics", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusMonitor {
    public static final String ERROR_DEFAULT_BID = "argus_hybrid_error";
    private static final String TAG = "Monitor";
    private static final String VERIFY_ERROR_EVENT_NAME = "argus_error";
    private static final String VERIFY_EVENT_NAME = "argus_verify";
    public static final ArgusMonitor INSTANCE = new ArgusMonitor();

    /* renamed from: teaReporter$delegate, reason: from kotlin metadata */
    private static final Lazy teaReporter = LazyKt.lazy(new Function0<Function2<? super String, ? super JSONObject, ? extends Unit>>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$teaReporter$2
        public final Function2<String, JSONObject, Unit> invoke() {
            Function2<String, JSONObject, Unit> initTeaReporter;
            initTeaReporter = ArgusMonitor.INSTANCE.initTeaReporter();
            return initTeaReporter;
        }
    });

    /* renamed from: aspectLimitRemainCounter$delegate, reason: from kotlin metadata */
    private static final Lazy aspectLimitRemainCounter = LazyKt.lazy(new Function0<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$aspectLimitRemainCounter$2
        public final ConcurrentHashMap<String, Integer> invoke() {
            ReportConfig reportConfig;
            Map<String, Integer> aspectMaxLimit;
            reportConfig = ArgusMonitor.INSTANCE.getReportConfig();
            if (reportConfig == null || (aspectMaxLimit = reportConfig.getAspectMaxLimit()) == null) {
                return null;
            }
            return new ConcurrentHashMap<>(aspectMaxLimit);
        }
    });

    /* renamed from: threadExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy threadExecutor = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$threadExecutor$2
        public final ThreadPoolExecutor invoke() {
            return new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        }
    });

    /* compiled from: ArgusMonitor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArgusVerifyAction.values().length];
            try {
                iArr[ArgusVerifyAction.BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArgusVerifyAction.REWRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ArgusMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<String, JSONObject, Unit> getTeaReporter() {
        return (Function2) teaReporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReportConfig getReportConfig() {
        ArgusGlobalCommonConfig argusSecuritySettingConfig = ArgusConfigManager.INSTANCE.getInstance().getArgusSecuritySettingConfig();
        if (argusSecuritySettingConfig != null) {
            return argusSecuritySettingConfig.getReportConfig();
        }
        return null;
    }

    private final ConcurrentHashMap<String, Integer> getAspectLimitRemainCounter() {
        return (ConcurrentHashMap) aspectLimitRemainCounter.getValue();
    }

    private final ThreadPoolExecutor getThreadExecutor() {
        return (ThreadPoolExecutor) threadExecutor.getValue();
    }

    public final void asyncReportInnerError(final JSONObject categoryObj) {
        Intrinsics.checkNotNullParameter(categoryObj, "categoryObj");
        asyncReport(new Function0<Unit>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$asyncReportInnerError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m606invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m606invoke() {
                SecureReportInfo secureReportInfo = new SecureReportInfo("argus_inner_error");
                secureReportInfo.setCategory(categoryObj);
                secureReportInfo.setSampleLevel(0);
                secureReportInfo.setBid("argus_hybrid_error");
                ArgusSlardarMonitor.INSTANCE.report(secureReportInfo);
            }
        });
    }

    public final void asyncReportAspect(final AspectContext<?, ?> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.getReportParams().getNeedReport()) {
            asyncReport(new Function0<Unit>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$asyncReportAspect$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m605invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m605invoke() {
                    boolean checkCanReport;
                    if (!context.getVerifyResult().isBlock()) {
                        checkCanReport = ArgusMonitor.INSTANCE.checkCanReport(context.getCallingAspect());
                        if (!checkCanReport) {
                            return;
                        }
                    }
                    ArgusMonitor.INSTANCE.reportContext(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.bytedance.ies.argus.api.params.BaseAspectParams] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.bytedance.ies.argus.api.params.BaseAspectParams] */
    public final void reportContext(AspectContext<?, ?> context) {
        ArgusReportParams reportParams;
        Object obj;
        JSONObject jSONObject;
        ArgusVerifyAction action;
        String stringValue;
        JSONObject monitorObject;
        JSONObject aLogObject;
        String str;
        BaseViewContext<?> viewContext$anniex_release;
        try {
            reportParams = context.getReportParams();
            Function0<JSONObject> addReportDataBlock = reportParams.getAddReportDataBlock();
            obj = null;
            jSONObject = addReportDataBlock != null ? (JSONObject) addReportDataBlock.invoke() : null;
            action = context.getVerifyResult().getAction();
            stringValue = context.getCallingAspect().getStringValue();
            monitorObject = context.getVerifyResult().toMonitorObject(action);
            aLogObject = context.getCallerParams().toALogObject(action);
        } catch (Exception e) {
            e = e;
        }
        try {
            String str2 = "finish verify " + stringValue + ": result[" + transformJsonToString(monitorObject) + "] params[" + (aLogObject != null ? INSTANCE.transformJsonToString(aLogObject) : null) + ']';
            if (context.getVerifyResult().isPass()) {
                ArgusLog.i$default(ArgusLog.INSTANCE, TAG, str2, null, 4, null);
            } else {
                Iterator it = StringsKt.chunked(str2, 4096).iterator();
                while (it.hasNext()) {
                    ArgusLog.i$default(ArgusLog.INSTANCE, TAG, (String) it.next(), null, 4, null);
                }
            }
            JSONObject monitorObject2 = context.getCallerParams().toMonitorObject(action);
            String argusBizId = context.getArgusBizId();
            String argusSceneTag = context.getArgusSceneTag();
            JSONObject safelyPut = JSONUtilsKt.safelyPut(new JSONObject(), ArgusMonitorKeyName.SEC_EVENT_TYPE, stringValue);
            if (monitorObject2 == null) {
                monitorObject2 = ArgusGsonUtils.INSTANCE.safeToJSONObject$anniex_release(context.getCallerParams());
            }
            JSONObject mergeStrValueJSONObject = JSONUtilsKt.mergeStrValueJSONObject(JSONUtilsKt.mergeStrValueJSONObject(JSONUtilsKt.mergeStrValueJSONObject(safelyPut, monitorObject2), jSONObject), monitorObject);
            AspectConfigItem aspectConfig = context.getAspectConfig();
            JSONObject safelyPutWithDefault = JSONUtilsKt.safelyPutWithDefault(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPutWithDefault(mergeStrValueJSONObject, "switch_mode", aspectConfig != null ? Integer.valueOf(aspectConfig.getSwitch()) : null), "container_config_version", ArgusConfigManager.INSTANCE.getInstance().getContainerConfigVersionDesc()), "container_config_source", ArgusConfigManager.INSTANCE.getInstance().getContainerConfigSource()), ArgusConstants.ARGUS_CID_KEY_NAME, argusBizId);
            AspectConfigInfo aspectConfigInfo$anniex_release = context.getAspectConfigInfo$anniex_release();
            JSONObject safelyPut2 = JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPutWithDefault(safelyPutWithDefault, "config_cid", aspectConfigInfo$anniex_release != null ? aspectConfigInfo$anniex_release.getCId() : null), "argus_scene", argusSceneTag);
            BaseViewContext<?> viewContext$anniex_release2 = context.getViewContext$anniex_release();
            JSONObject safelyPut3 = JSONUtilsKt.safelyPut(safelyPut2, "view_trace_id", viewContext$anniex_release2 != null ? viewContext$anniex_release2.getTraceId() : null);
            ContainerContext containerContext = context.getContainerContext();
            JSONObject safelyPut4 = JSONUtilsKt.safelyPut(safelyPut3, "container_trace_id", containerContext != null ? containerContext.getTraceId() : null);
            List<IArgusVerifyReason> innerErrorCodeTrace$anniex_release = context.getVerifyResult().getInnerErrorCodeTrace$anniex_release();
            int i = 0;
            if (!(innerErrorCodeTrace$anniex_release.size() > 1)) {
                innerErrorCodeTrace$anniex_release = null;
            }
            if (innerErrorCodeTrace$anniex_release != null) {
                List<IArgusVerifyReason> list = innerErrorCodeTrace$anniex_release;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((IArgusVerifyReason) it2.next()).getStrValue());
                }
                str = CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<String, CharSequence>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$reportContext$2$categoryObj$3
                    public final CharSequence invoke(String str3) {
                        Intrinsics.checkNotNullParameter(str3, "it");
                        return ",";
                    }
                }, 31, (Object) null);
            } else {
                str = null;
            }
            JSONObject safelyPut5 = JSONUtilsKt.safelyPut(safelyPut4, "inner_err_msg", str);
            ArgusMonitor argusMonitor = INSTANCE;
            int i2 = 2;
            JSONObject safelyPut6 = JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(safelyPut5, "verify_record", argusMonitor.joinVerifyResult(context.getRealVerifyResultRecord(), 2)), "report_record", argusMonitor.joinVerifyResult(context.getReportOnlyVerifyResultRecord(), 1)), "anniex_version", AnnieXMonitorConstants.ANNIEX_VERSION);
            JSONObject transformMetrics = argusMonitor.transformMetrics(context.getMetric());
            if (reportParams.getShouldReportSlardar()) {
                String str3 = SecureReportInfo.DEFAULT_BID;
                int i3 = WhenMappings.$EnumSwitchMapping$0[context.getVerifyResult().getAction().ordinal()];
                if (i3 == 1) {
                    str3 = "argus_hybrid_error";
                    i2 = 0;
                } else if (i3 != 2) {
                    i2 = 3;
                } else {
                    str3 = SecureReportInfo.REWRITE_BID;
                }
                if (reportParams.getForceHighFrequency()) {
                    str3 = SecureReportInfo.FORCE_HIGH_BID;
                } else {
                    i = i2;
                }
                SecureReportInfo secureReportInfo = new SecureReportInfo("argus_verify_" + stringValue);
                secureReportInfo.setSampleLevel(i);
                secureReportInfo.setCategory(safelyPut6);
                secureReportInfo.setMetrics(transformMetrics);
                secureReportInfo.setBid(str3);
                if (reportParams.getUseView() && (viewContext$anniex_release = context.getViewContext$anniex_release()) != null) {
                    obj = viewContext$anniex_release.getView();
                }
                if (obj instanceof WebView) {
                    ArgusSlardarMonitor.INSTANCE.report((WebView) obj, secureReportInfo);
                } else if (obj instanceof LynxView) {
                    ArgusSlardarMonitor.INSTANCE.report((LynxView) obj, secureReportInfo);
                } else {
                    ArgusSlardarMonitor.INSTANCE.report(secureReportInfo);
                }
            }
            argusMonitor.printDebugLog(stringValue, safelyPut6, transformMetrics);
            argusMonitor.checkShouldReportTea(context.getCallingAspect(), safelyPut6, reportParams.getShouldReportTea(), argusBizId, argusSceneTag);
        } catch (Exception e2) {
            e = e2;
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "report error " + e, null, null, 12, null);
        }
    }

    private final void asyncReport(final Function0<Unit> task) {
        getThreadExecutor().submit(new Runnable() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$asyncReport$1
            @Override // java.lang.Runnable
            public final void run() {
                task.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkCanReport(IArgusAspect aspect) {
        String stringValue;
        Integer num;
        ConcurrentHashMap<String, Integer> aspectLimitRemainCounter2 = getAspectLimitRemainCounter();
        if (aspectLimitRemainCounter2 == null || (num = aspectLimitRemainCounter2.get((stringValue = aspect.getStringValue()))) == null) {
            return true;
        }
        if (num.intValue() == 0) {
            return false;
        }
        ConcurrentHashMap<String, Integer> aspectLimitRemainCounter3 = INSTANCE.getAspectLimitRemainCounter();
        if (aspectLimitRemainCounter3 == null) {
            return true;
        }
        aspectLimitRemainCounter3.put(stringValue, Integer.valueOf(num.intValue() - 1));
        return true;
    }

    private final String joinVerifyResult(List<Pair<String, String>> resultList, int minSize) {
        List<Pair> list;
        if (!(resultList.size() >= minSize)) {
            resultList = null;
        }
        if (resultList == null || (list = CollectionsKt.toList(resultList)) == null) {
            return null;
        }
        String str = "";
        for (Pair pair : list) {
            str = str + "key=" + ((String) pair.component1()) + ',' + ((String) pair.component2()) + LooperObserverMonitor.START;
        }
        return str.length() > 0 ? StringsKt.dropLast(str, 1) : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if (r5 == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void checkShouldReportTea(IArgusAspect aspect, JSONObject data, boolean enableReport, String bid, String sceneTag) {
        ReportConfig reportConfig;
        Map<String, String[]> teaEventMapping;
        boolean z = true;
        if (!enableReport && sceneTag == null) {
            ReportConfig reportConfig2 = getReportConfig();
            if (reportConfig2 != null) {
                if (!reportConfig2.getEnableAllReportTea()) {
                    List<String> enableTeaReportCidList = reportConfig2.getEnableTeaReportCidList();
                    if (enableTeaReportCidList != null) {
                        if (bid == null) {
                            bid = "host";
                        }
                        boolean z2 = enableTeaReportCidList.contains(bid);
                    }
                }
            }
            z = false;
        }
        if (!z || (reportConfig = getReportConfig()) == null || (teaEventMapping = reportConfig.getTeaEventMapping()) == null) {
            return;
        }
        for (Map.Entry<String, String[]> entry : teaEventMapping.entrySet()) {
            String key = entry.getKey();
            if (ArraysKt.contains(entry.getValue(), aspect.getStringValue())) {
                INSTANCE.reportTea(key, data);
            }
        }
    }

    public final void asyncReportLifeCycle(final JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        asyncReport(new Function0<Unit>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$asyncReportLifeCycle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m607invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m607invoke() {
                Function2 teaReporter2;
                teaReporter2 = ArgusMonitor.INSTANCE.getTeaReporter();
                if (teaReporter2 != null) {
                    teaReporter2.invoke("argus_life_cycle", data);
                }
            }
        });
    }

    public final void reportTea(String eventName, JSONObject data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        Function2<String, JSONObject, Unit> teaReporter2 = getTeaReporter();
        if (teaReporter2 != null) {
            teaReporter2.invoke(eventName, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<String, JSONObject, Unit> initTeaReporter() {
        final Method method = Class.forName("com.ss.android.common.lib.AppLogNewUtils").getMethod("onEventV3", String.class, JSONObject.class);
        return new Function2<String, JSONObject, Unit>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$initTeaReporter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (JSONObject) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, JSONObject jSONObject) {
                try {
                    method.invoke(null, str, jSONObject);
                } catch (Exception unused) {
                    ArgusLog.e$default(ArgusLog.INSTANCE, "Monitor", "has no tea reporter.", null, null, 12, null);
                }
            }
        };
    }

    private final JSONObject transformMetrics(Map<String, long[]> metric) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : MapsKt.toMap(metric).entrySet()) {
            String str = (String) entry.getKey();
            long[] jArr = (long[]) entry.getValue();
            if (jArr.length == 2) {
                long j = jArr[1] - jArr[0];
                if (j >= 0) {
                    JSONUtilsKt.safelyPut(jSONObject, str, Long.valueOf(j));
                }
            }
        }
        return jSONObject;
    }

    private final void printDebugLog(String event, JSONObject obj, JSONObject metric) {
        ArgusInitConfig.AppEnv env = ArgusEnv.INSTANCE.getInstance().getEnv();
        boolean z = false;
        if (env != null && env.getDebuggable()) {
            z = true;
        }
        if (z) {
            try {
                Result.Companion companion = Result.Companion;
                Gson create = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
                ArgusLog.d$default(ArgusLog.INSTANCE, "Monitor[report]", "————————————————————————  new event [" + event + "] ——————————————————————\n" + create.toJson(new JsonParser().parse(metric.toString())) + "\n\n" + create.toJson(new JsonParser().parse(obj.toString())) + "\n————————————————————————  end event ——————————————————————", null, 4, null);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    private final String transformJsonToString(JSONObject json) {
        try {
            final StringBuilder sb = new StringBuilder();
            JsonUtilsKt.forEach(json, new Function2<String, Object, Unit>() { // from class: com.bytedance.ies.argus.base.ArgusMonitor$transformJsonToString$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(String str, Object obj) {
                    String obj2;
                    Intrinsics.checkNotNullParameter(str, "k");
                    if (obj == null || (obj2 = obj.toString()) == null) {
                        return;
                    }
                    sb.append(str + '=' + obj2 + ',');
                }
            });
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return StringsKt.dropLast(sb2, 1);
        } catch (Exception e) {
            return "append error: " + e.getMessage();
        }
    }
}
