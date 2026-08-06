package com.bytedance.ies.bullet.service.monitor.intercept;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.BulletMonitorIntercept;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.settings.MonitorSettingsConfig;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: BulletTeaReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J1\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017J1\u0010\u0018\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017J*\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R9\u0010\u0005\u001a \u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/intercept/BulletTeaReporter;", "", "()V", "moduleName", "", "settingsTeaIntercept", "Lkotlin/Function3;", "", "getSettingsTeaIntercept", "()Lkotlin/jvm/functions/Function3;", "settingsTeaIntercept$delegate", "Lkotlin/Lazy;", "getTeaReporter", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "monitorConfig", "Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "matchChannels", "url", "originUrl", "channelWhiteList", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "matchUrls", "urlWhiteList", "reportTea", "config", "info", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", MetricConstant.FIELD_BIZ, "virtualAid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletTeaReporter {
    private static final String moduleName = "Monitor-Report";
    public static final BulletTeaReporter INSTANCE = new BulletTeaReporter();

    /* renamed from: settingsTeaIntercept$delegate, reason: from kotlin metadata */
    private static final Lazy settingsTeaIntercept = LazyKt.lazy(new Function0<Function3<? super String, ? super String, ? super String, ? extends Boolean>>() { // from class: com.bytedance.ies.bullet.service.monitor.intercept.BulletTeaReporter$settingsTeaIntercept$2
        public final Function3<String, String, String, Boolean> invoke() {
            return new Function3<String, String, String, Boolean>() { // from class: com.bytedance.ies.bullet.service.monitor.intercept.BulletTeaReporter$settingsTeaIntercept$2.1
                /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
                
                    if (r5 != false) goto L22;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean invoke(String str, String str2, String str3) {
                    MonitorSettingsConfig monitorSettingsConfig;
                    boolean matchUrls;
                    boolean matchChannels;
                    IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
                    if (iBulletSettingsService == null || (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) == null) {
                        monitorSettingsConfig = MonitorSettingsConfig.INSTANCE.getDEFAULT();
                    }
                    String[] eventBlackList = monitorSettingsConfig.getEventBlackList();
                    boolean z = false;
                    if (!(eventBlackList != null && ArraysKt.contains(eventBlackList, str))) {
                        String[] eventWhiteList = monitorSettingsConfig.getEventWhiteList();
                        if (!(eventWhiteList != null && ArraysKt.contains(eventWhiteList, str))) {
                            matchUrls = BulletTeaReporter.INSTANCE.matchUrls(str2, str3, monitorSettingsConfig.getUrlWhiteList());
                            if (!matchUrls) {
                                matchChannels = BulletTeaReporter.INSTANCE.matchChannels(str2, str3, monitorSettingsConfig.getChannelWhiteList());
                            }
                        }
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
        }
    });

    private BulletTeaReporter() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        if (r0 == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reportTea(MonitorConfig config, ReportInfo info, String biz, String virtualAid) {
        MonitorSettingsConfig monitorSettingsConfig;
        boolean z;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(info, "info");
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (monitorSettingsConfig = (MonitorSettingsConfig) iBulletSettingsService.obtainSettings(MonitorSettingsConfig.class)) == null) {
            monitorSettingsConfig = MonitorSettingsConfig.INSTANCE.getDEFAULT();
        }
        boolean z2 = false;
        try {
            String[] eventBlackList = monitorSettingsConfig.getEventBlackList();
            if (!(eventBlackList != null && ArraysKt.contains(eventBlackList, info.getEventName()))) {
                Function3<String, String, String, Boolean> settingsTeaIntercept2 = getSettingsTeaIntercept();
                String eventName = info.getEventName();
                String url = info.getUrl();
                Identifier pageIdentifier = info.getPageIdentifier();
                if (!((Boolean) settingsTeaIntercept2.invoke(eventName, url, pageIdentifier != null ? pageIdentifier.getFullUrl() : null)).booleanValue()) {
                    BulletMonitorIntercept intercept = config.getIntercept();
                    if (intercept != null) {
                        String eventName2 = info.getEventName();
                        String url2 = info.getUrl();
                        Identifier pageIdentifier2 = info.getPageIdentifier();
                        if (intercept.shouldReportToTea(eventName2, url2, pageIdentifier2 != null ? pageIdentifier2.getFullUrl() : null)) {
                            z = true;
                        }
                    }
                    z = false;
                }
                z2 = true;
            }
        } catch (Exception e) {
            BulletLogger.INSTANCE.printLog("BulletReportInterceptorDelegate reportTea failed: " + e, LogLevel.E, moduleName);
        }
        if (z2) {
            JSONObject jSONObject = new JSONObject();
            JsonUtilsKt.wrap(jSONObject, info.getCategory());
            JsonUtilsKt.wrap(jSONObject, info.getMetrics());
            JsonUtilsKt.wrap(jSONObject, info.getExtra());
            JsonUtilsKt.wrap(jSONObject, info.getCommon());
            jSONObject.put("bid", biz);
            jSONObject.put("virtual_aid", virtualAid);
            Function2<String, JSONObject, Unit> teaReporter = getTeaReporter(config);
            if (teaReporter != null) {
                teaReporter.invoke(info.getEventName(), jSONObject);
            }
        }
    }

    private final Function2<String, JSONObject, Unit> getTeaReporter(MonitorConfig monitorConfig) {
        Function2<String, JSONObject, Unit> teaReporter = monitorConfig.getTeaReporter();
        return teaReporter == null ? MonitorReportService.INSTANCE.getFallbackDefault().getConfig().getTeaReporter() : teaReporter;
    }

    private final Function3<String, String, String, Boolean> getSettingsTeaIntercept() {
        return (Function3) settingsTeaIntercept.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean matchUrls(String url, String originUrl, String[] urlWhiteList) {
        if (urlWhiteList == null) {
            return false;
        }
        Uri parse = originUrl != null ? Uri.parse(originUrl) : null;
        if (parse != null && parse.isHierarchical()) {
            Iterator it = ArrayIteratorKt.iterator(urlWhiteList);
            while (it.hasNext()) {
                if (url != null && StringsKt.contains$default(url, (String) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean matchChannels(String url, String originUrl, String[] channelWhiteList) {
        String str;
        if (channelWhiteList == null) {
            return false;
        }
        Uri parse = url != null ? Uri.parse(url) : null;
        String scheme = parse != null ? parse.getScheme() : null;
        if (scheme == null) {
            return false;
        }
        int hashCode = scheme.hashCode();
        if (hashCode == -1772600516) {
            if (scheme.equals("lynxview")) {
                return ArraysKt.contains(channelWhiteList, parse.getHost());
            }
            return false;
        }
        if (hashCode == 3213448) {
            str = "http";
        } else {
            if (hashCode != 99617003) {
                return false;
            }
            str = "https";
        }
        scheme.equals(str);
        return false;
    }
}
