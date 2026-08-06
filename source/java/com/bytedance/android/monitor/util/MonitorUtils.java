package com.bytedance.android.monitor.util;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.monitor.HybridMonitor;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: MonitorUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitor/util/MonitorUtils;", "", "()V", "isCustomService", "", "eventType", "", "mapService", "containerType", "biz", "outputFile", "", "data", "Lorg/json/JSONObject;", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorUtils {
    public static final MonitorUtils INSTANCE = new MonitorUtils();

    private MonitorUtils() {
    }

    @JvmStatic
    public static final String mapService(String eventType, String containerType, String biz) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(containerType, "containerType");
        if (biz == null) {
            biz = "";
        }
        if (TextUtils.isEmpty(eventType)) {
            return eventType;
        }
        switch (eventType.hashCode()) {
            case -1349088399:
                if (eventType.equals("custom")) {
                    return "tt" + biz + "_webview_timing_monitor_custom_service";
                }
                break;
            case -136676079:
                if (eventType.equals("newcustom")) {
                    return "bd" + biz + "_hybrid_monitor_custom_service";
                }
                break;
            case 571840923:
                if (eventType.equals("samplecustom")) {
                    return "bd" + biz + "_hybrid_monitor_custom_sample_service";
                }
                break;
            case 831602183:
                if (eventType.equals("containerError")) {
                    return "bd_hybrid_monitor_service_containerError_" + biz;
                }
                break;
        }
        return "bd_hybrid_monitor_service_" + eventType + '_' + containerType + '_' + biz;
    }

    private final boolean isCustomService(String eventType) {
        return Intrinsics.areEqual("samplecustom", eventType) || Intrinsics.areEqual("newcustom", eventType) || Intrinsics.areEqual("custom", eventType);
    }

    @JvmStatic
    public static final void outputFile(String eventType, JSONObject data) {
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (INSTANCE.isCustomService(eventType)) {
            try {
                String optString = data.getJSONObject("extra").optString("url", "");
                HybridMonitor hybridMonitor = HybridMonitor.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(hybridMonitor, "HybridMonitor.getInstance()");
                File externalAppDir = FileUtils.getExternalAppDir(hybridMonitor.getApplication(), "monitor_data_debug");
                if (externalAppDir == null || !externalAppDir.exists()) {
                    return;
                }
                FileUtils.writeFile(new File(externalAppDir, "custom_with_" + Uri.parse(optString).getQueryParameter("bytest_case_id")).getAbsolutePath(), StringsKt.trimIndent("\n     " + data + "\n     \n     "), true);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            JSONObject jSONObject = data.getJSONObject("extra").getJSONObject("nativeBase");
            String string = jSONObject.getString("navigation_id");
            String optString2 = jSONObject.optString("url", "");
            HybridMonitor hybridMonitor2 = HybridMonitor.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hybridMonitor2, "HybridMonitor.getInstance()");
            File externalAppDir2 = FileUtils.getExternalAppDir(hybridMonitor2.getApplication(), "monitor_data_debug");
            if (externalAppDir2 == null || !externalAppDir2.exists()) {
                return;
            }
            FileUtils.writeFile(new File(externalAppDir2, string + "_with_" + Uri.parse(optString2).getQueryParameter("bytest_case_id")).getAbsolutePath(), StringsKt.trimIndent("\n     " + data + "\n     \n     "), true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
