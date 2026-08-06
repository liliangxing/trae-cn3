package com.bytedance.geckox.policy.probe;

import android.content.Context;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.debug.GeckoKitDebug;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTaskManager;
import com.bytedance.geckox.utils.SPManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.settings.SettingsExtra;
import com.bytedance.iesgurd.statistic.UploadStatistic;
import com.bytedance.ttnet.utils.RetrofitUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ProbeManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fH\u0002J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0004H\u0002J \u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/bytedance/geckox/policy/probe/ProbeManager;", "", "()V", "PROBE_BUSINESS_SPLIT", "", "PROBE_GECKO_UID", "PROBE_PARAM_SPLIT", "PROBE_REQ_GECKO_SETTINGS", "PROBE_REQ_QUERY", "PROBE_RESPONSE_HEADER_NAME", "PROBE_SP", "config", "Lcom/bytedance/geckox/GeckoGlobalConfig;", "context", "Landroid/content/Context;", "probeCache", "<set-?>", "probeHeaderCache", "getProbeHeaderCache", "()Ljava/lang/String;", "cleanCache", "", "executeProbeTask", "", "probe", "isProbeEnable", "parseProbe", "url", "headerVal", "randomDelayTask", "fetch", "Lkotlin/Function0;", "registerProbeListener", "storeProbe", "newProbe", "uploadProbeEvent", "event", "extra", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProbeManager {
    public static final ProbeManager INSTANCE = new ProbeManager();
    private static final String PROBE_BUSINESS_SPLIT = ";";
    private static final String PROBE_GECKO_UID = "10001";
    private static final String PROBE_PARAM_SPLIT = "@";
    private static final String PROBE_REQ_GECKO_SETTINGS = "2";
    private static final String PROBE_REQ_QUERY = "1";
    public static final String PROBE_RESPONSE_HEADER_NAME = "x-tlb-probe";
    private static final String PROBE_SP = "tlb_probe";
    private static GeckoGlobalConfig config;
    private static Context context;
    private static volatile String probeCache;
    private static volatile String probeHeaderCache;

    private ProbeManager() {
    }

    public final String getProbeHeaderCache() {
        return probeHeaderCache;
    }

    public final void registerProbeListener(Context context2, GeckoGlobalConfig config2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(config2, "config");
        if (!isProbeEnable()) {
            uploadProbeEvent("registerProbeListener_error", "", null);
            GeckoLogger.m296d("[gecko probe] disabled");
            return;
        }
        context = context2;
        config = config2;
        probeCache = SPManager.inst().getString(context2, PROBE_SP, null);
        GeckoLogger.m296d("[gecko probe] request interceptor registered,old probe:" + probeCache);
        RetrofitUtils.addInterceptor(new ProbeInterceptor());
    }

    public final void parseProbe(final String url, final String headerVal) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(headerVal, "headerVal");
        HandlerTimerTaskManager.inst().schedule(new HandlerTask<Object>() { // from class: com.bytedance.geckox.policy.probe.ProbeManager$parseProbe$1
            @Override // com.bytedance.geckox.task.HandlerTask
            public int taskType() {
                return 7;
            }

            @Override // com.bytedance.geckox.task.HandlerTask
            public void execute() {
                String str;
                String str2;
                String str3;
                String str4;
                boolean executeProbeTask;
                String str5;
                String str6;
                for (String str7 : StringsKt.split$default(headerVal, new String[]{";"}, false, 0, 6, (Object) null)) {
                    String str8 = null;
                    if (StringsKt.startsWith$default(str7, "10001", false, 2, (Object) null)) {
                        int indexOf$default = StringsKt.indexOf$default(str7, "@", 0, false, 6, (Object) null);
                        if (indexOf$default == -1) {
                            ProbeManager.INSTANCE.uploadProbeEvent("split_error_0", str7, null);
                            return;
                        }
                        int i = indexOf$default + 1;
                        if (str7 != null) {
                            String substring = str7.substring(i);
                            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                            ProbeManager probeManager = ProbeManager.INSTANCE;
                            str = ProbeManager.probeCache;
                            if (Intrinsics.areEqual(str, substring)) {
                                return;
                            }
                            ProbeManager probeManager2 = ProbeManager.INSTANCE;
                            ProbeManager probeManager3 = ProbeManager.INSTANCE;
                            str2 = ProbeManager.probeCache;
                            probeManager2.uploadProbeEvent("receive_probe_change", substring, str2);
                            ProbeManager probeManager4 = ProbeManager.INSTANCE;
                            str3 = ProbeManager.probeCache;
                            if (str3 != null) {
                                int indexOf$default2 = StringsKt.indexOf$default(str3, "@", 0, false, 6, (Object) null);
                                int indexOf$default3 = StringsKt.indexOf$default(substring, "@", 0, false, 6, (Object) null);
                                if (indexOf$default2 == -1 || indexOf$default3 == -1) {
                                    ProbeManager probeManager5 = ProbeManager.INSTANCE;
                                    ProbeManager probeManager6 = ProbeManager.INSTANCE;
                                    str5 = ProbeManager.probeCache;
                                    probeManager5.uploadProbeEvent("split_error", substring, str5);
                                    return;
                                }
                                try {
                                    if (str3 != null) {
                                        String substring2 = str3.substring(0, indexOf$default2);
                                        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        try {
                                            if (substring != null) {
                                                str6 = substring.substring(0, indexOf$default3);
                                                Intrinsics.checkExpressionValueIsNotNull(str6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                                try {
                                                    if (Long.parseLong(substring2) > Long.parseLong(str6)) {
                                                        ProbeManager.INSTANCE.uploadProbeEvent("timestamp_error", substring, substring2 + '-' + str6);
                                                        return;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    e = e;
                                                    str8 = substring2;
                                                    ProbeManager.INSTANCE.uploadProbeEvent("catch_error", substring, e.getMessage());
                                                    GeckoLogger.m296d("[gecko probe] number format exception,old probe timestamp:" + str8 + ",new probe timestamp:" + str6 + ",url:" + url);
                                                    return;
                                                }
                                            } else {
                                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                            }
                                        } catch (NumberFormatException e2) {
                                            e = e2;
                                            str6 = null;
                                        }
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                } catch (NumberFormatException e3) {
                                    e = e3;
                                    str6 = null;
                                }
                            }
                            StringBuilder sb = new StringBuilder("[gecko probe] old probe:");
                            ProbeManager probeManager7 = ProbeManager.INSTANCE;
                            str4 = ProbeManager.probeCache;
                            GeckoLogger.m296d(sb.append(str4).append(",new probe:").append(substring).append(",url:").append(url).toString());
                            ProbeManager probeManager8 = ProbeManager.INSTANCE;
                            ProbeManager.probeHeaderCache = headerVal;
                            executeProbeTask = ProbeManager.INSTANCE.executeProbeTask(substring);
                            if (executeProbeTask) {
                                ProbeManager.INSTANCE.storeProbe(substring);
                                return;
                            }
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean executeProbeTask(final String probe) {
        String str = probe;
        if (StringsKt.indexOf$default(str, PROBE_PARAM_SPLIT, 0, false, 6, (Object) null) == -1) {
            uploadProbeEvent("split_error_1", probe, null);
            return false;
        }
        String str2 = (String) StringsKt.split$default(str, new String[]{PROBE_PARAM_SPLIT}, false, 0, 6, (Object) null).get(1);
        int hashCode = str2.hashCode();
        if (hashCode == 49) {
            if (str2.equals("1")) {
                return randomDelayTask(probe, new Function0<Unit>() { // from class: com.bytedance.geckox.policy.probe.ProbeManager$executeProbeTask$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m546invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m546invoke() {
                        ProbeManager probeManager = ProbeManager.INSTANCE;
                        String str3 = probe;
                        GeckoGlobalManager inst = GeckoGlobalManager.inst();
                        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                        probeManager.uploadProbeEvent("after_random", str3, inst.getAccessKeyDirs().keySet().toString());
                        GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
                        Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
                        if (!inst2.isGeckoEnable()) {
                            GeckoLogger.m296d("[gecko probe] gecko disable, request cancel, probe:" + probe);
                            return;
                        }
                        GeckoLogger.m296d("[gecko probe] query request send,probe:" + probe);
                        RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(ReqType.PROBE);
                        requestBodyUpdate.initCustom();
                        UpdateRequest updateRequest = new UpdateRequest(requestBodyUpdate);
                        updateRequest.setProbe(probe);
                        updateRequest.start();
                    }
                });
            }
        } else if (hashCode == 50 && str2.equals("2")) {
            return randomDelayTask(probe, new Function0<Unit>() { // from class: com.bytedance.geckox.policy.probe.ProbeManager$executeProbeTask$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m547invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m547invoke() {
                    GeckoLogger.m296d("[gecko probe] gecko settings request send,probe:" + probe);
                    GlobalSettingsManager.INSTANCE.fetchGlobalSettings(ReqType.PROBE, probe);
                }
            });
        }
        return false;
    }

    private final boolean randomDelayTask(final String probe, final Function0<Unit> fetch) {
        SettingsExtra.ProbeInfo probeInfo;
        if (!isProbeEnable()) {
            uploadProbeEvent("before_random_error_not_enable", probe, null);
            return false;
        }
        SettingsExtra settingsExtra = GlobalSettingsManager.INSTANCE.getSettingsExtra();
        if (settingsExtra != null && (probeInfo = settingsExtra.getProbeInfo()) != null) {
            if (probeInfo.getProbeThreshold() <= 0) {
                probeInfo.setProbeThreshold(60);
            }
            int nextInt = Random.Default.nextInt(0, probeInfo.getProbeThreshold());
            long currentTimeMillis = System.currentTimeMillis();
            GeckoGlobalConfig geckoGlobalConfig = config;
            if (geckoGlobalConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            }
            int appColdStartTime = (int) ((currentTimeMillis - geckoGlobalConfig.getAppColdStartTime()) / 1000);
            if (appColdStartTime + nextInt < 60) {
                INSTANCE.uploadProbeEvent("before_random_error_delay_too_short", probe, "delay: " + nextInt + ", duration: " + appColdStartTime);
                nextInt = 60 - appColdStartTime;
            }
            int i = GeckoKitDebug.INSTANCE.isUnitTest() ? 0 : nextInt;
            INSTANCE.uploadProbeEvent("before_random", probe, "delay: " + i + ", duration: " + appColdStartTime);
            GeckoLogger.m296d("[gecko probe] request delay:" + i + 's');
            HandlerTimerTaskManager.inst().schedule(new HandlerTask<Object>() { // from class: com.bytedance.geckox.policy.probe.ProbeManager$randomDelayTask$$inlined$let$lambda$1
                @Override // com.bytedance.geckox.task.HandlerTask
                public int taskType() {
                    return 7;
                }

                @Override // com.bytedance.geckox.task.HandlerTask
                public void execute() {
                    GeckoLogger.m296d("[gecko probe] delay task execute");
                    fetch.invoke();
                }
            }, i * 1000);
            return true;
        }
        uploadProbeEvent("before_random_error_no_extra", probe, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void storeProbe(String newProbe) {
        probeCache = newProbe;
        SPManager inst = SPManager.inst();
        Context context2 = context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        inst.putString(context2, PROBE_SP, newProbe);
    }

    private final boolean isProbeEnable() {
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        AppSettingsManager.IGeckoAppSettings geckoAppSettings = inst.getGeckoAppSettings();
        return geckoAppSettings != null && geckoAppSettings.isProbeEnable();
    }

    public final void uploadProbeEvent(String event, String probe, String extra) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        Intrinsics.checkParameterIsNotNull(probe, "probe");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", event);
            jSONObject.put("probe", probe);
            if (extra != null) {
                jSONObject.put("extra", extra);
            }
            UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_probe_debug_stats", jSONObject);
        } catch (Throwable th) {
            GeckoLogger.m303w("uploadProbeEvent error: " + th.getMessage(), th);
        }
    }

    public final void cleanCache() {
        probeCache = null;
    }
}
