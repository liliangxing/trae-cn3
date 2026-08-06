package com.bytedance.android.anniex.scene.connect;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.scene.core.SceneFingerprint;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.android.anniex.scene.data.SceneQueryInfo;
import com.bytedance.android.anniex.scene.utils.CompressionUtils;
import com.bytedance.android.anniex.scene.utils.SceneLoggerUtils;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SceneConnectCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003J(\u0010\u000f\u001a\u00020\u00102\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\nH\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u001e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J \u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/anniex/scene/connect/SceneConnectCenter;", "", "()V", "EVENT_ANNIE_X_NEXT_SCENE_VISIBLE", "", "MONITOR_ANNIE_X_NEXT_GOTO_FEATURE", "MONITOR_ANNIE_X_NEXT_SCENE_FEATURE", "MONITOR_ANNIE_X_NEXT_SQLITE_ERROR", "MONITOR_ANNIE_X_NEXT_SQLITE_STATUS", "combineSceneFeature", "", "currentScene", "Lcom/bytedance/android/anniex/scene/core/SceneFingerprint;", "sceneQueryInfo", "Lcom/bytedance/android/anniex/scene/data/SceneQueryInfo;", "convertMapToJsonArray", "Lorg/json/JSONArray;", "nextMap", "Lkotlin/Pair;", "", "", "reportSqliteError", "", "errorMsg", "reportSqliteStatus", "sceneTableSize", "transTableSize", "dbFileSize", "sendSceneFeature", "sendSceneFeatureEvent", "sendSceneGotoFeature", "fromScene", "toScene", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SceneConnectCenter {
    private static final String EVENT_ANNIE_X_NEXT_SCENE_VISIBLE = "annie_next_scene_visible";
    public static final SceneConnectCenter INSTANCE = new SceneConnectCenter();
    private static final String MONITOR_ANNIE_X_NEXT_GOTO_FEATURE = "bdx_monitor_annie_next_scene_goto_feature";
    private static final String MONITOR_ANNIE_X_NEXT_SCENE_FEATURE = "bdx_monitor_annie_next_scene_feature";
    private static final String MONITOR_ANNIE_X_NEXT_SQLITE_ERROR = "bdx_monitor_next_sqlite_error";
    private static final String MONITOR_ANNIE_X_NEXT_SQLITE_STATUS = "bdx_monitor_next_sqlite_status";

    private SceneConnectCenter() {
    }

    public final void sendSceneFeature(SceneFingerprint currentScene, SceneQueryInfo sceneQueryInfo) {
        Intrinsics.checkNotNullParameter(currentScene, "currentScene");
        Intrinsics.checkNotNullParameter(sceneQueryInfo, "sceneQueryInfo");
        final Map<String, Object> combineSceneFeature = combineSceneFeature(currentScene, sceneQueryInfo);
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(MONITOR_ANNIE_X_NEXT_SCENE_FEATURE, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            reportInfo.setCategory(new JSONObject(combineSceneFeature));
            iMonitorReportService.report(reportInfo);
        }
        SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.connect.SceneConnectCenter$sendSceneFeature$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return "发送场景信息ALog annie_next_scene_feature category: " + combineSceneFeature;
            }
        });
    }

    public final void sendSceneGotoFeature(SceneFingerprint fromScene, SceneFingerprint toScene, SceneQueryInfo sceneQueryInfo) {
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        Intrinsics.checkNotNullParameter(toScene, "toScene");
        Intrinsics.checkNotNullParameter(sceneQueryInfo, "sceneQueryInfo");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pre_pathname", CompressionUtils.INSTANCE.decompressSceneId(fromScene.getSceneId()));
        linkedHashMap.put("pathname", CompressionUtils.INSTANCE.decompressSceneId(toScene.getSceneId()));
        linkedHashMap.put("pv", Integer.valueOf(sceneQueryInfo.getCurrentCount()));
        Pair<Integer, Double> pair = sceneQueryInfo.getTransitions().get(toScene.getSceneId());
        linkedHashMap.put("clickRate", Double.valueOf(pair != null ? ((Number) pair.getSecond()).doubleValue() : 0.0d));
        linkedHashMap.put("pre_attach_scene", fromScene.getAttachScene());
        linkedHashMap.put(SceneDbContract.Scenes.COLUMN_ATTACH_SCENE, toScene.getAttachScene());
        Integer viewCount = toScene.getViewCount();
        if (viewCount != null) {
            linkedHashMap.put(SceneDbContract.Scenes.COLUMN_VIEW_COUNT, Integer.valueOf(viewCount.intValue()));
        }
        String clientComponent = toScene.getClientComponent();
        if (clientComponent != null) {
            linkedHashMap.put(SceneDbContract.Scenes.COLUMN_CLIENT_COMPONENT, clientComponent);
        }
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(MONITOR_ANNIE_X_NEXT_GOTO_FEATURE, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            reportInfo.setCategory(new JSONObject(linkedHashMap));
            iMonitorReportService.report(reportInfo);
        }
        SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.connect.SceneConnectCenter$sendSceneGotoFeature$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return "发送跳转埋点ALog annie_next_scene_goto_feature category: " + linkedHashMap;
            }
        });
    }

    public final void sendSceneFeatureEvent(SceneFingerprint currentScene, SceneQueryInfo sceneQueryInfo) {
        Intrinsics.checkNotNullParameter(currentScene, "currentScene");
        Intrinsics.checkNotNullParameter(sceneQueryInfo, "sceneQueryInfo");
        final Map<String, Object> combineSceneFeature = combineSceneFeature(currentScene, sceneQueryInfo);
        Event event = new Event(EVENT_ANNIE_X_NEXT_SCENE_VISIBLE, System.currentTimeMillis(), (XReadableMap) null, 4, (DefaultConstructorMarker) null);
        event.setMapParams(combineSceneFeature);
        EventCenter.enqueueEvent(event);
        SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.connect.SceneConnectCenter$sendSceneFeatureEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return "发送Worker监听事件 annie_next_scene_visible category: " + combineSceneFeature;
            }
        });
    }

    private final Map<String, Object> combineSceneFeature(SceneFingerprint currentScene, SceneQueryInfo sceneQueryInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("path_name", CompressionUtils.INSTANCE.decompressSceneId(currentScene.getSceneId()));
        linkedHashMap.put("pv", Integer.valueOf(sceneQueryInfo.getCurrentCount()));
        linkedHashMap.put("next", INSTANCE.convertMapToJsonArray(sceneQueryInfo.getTransitions()));
        linkedHashMap.put(SceneDbContract.Scenes.COLUMN_ATTACH_SCENE, currentScene.getAttachScene());
        Integer viewCount = currentScene.getViewCount();
        if (viewCount != null) {
            linkedHashMap.put(SceneDbContract.Scenes.COLUMN_VIEW_COUNT, Integer.valueOf(viewCount.intValue()));
        }
        String clientComponent = currentScene.getClientComponent();
        if (clientComponent != null) {
            linkedHashMap.put(SceneDbContract.Scenes.COLUMN_CLIENT_COMPONENT, clientComponent);
        }
        JSONObject bcmChain = currentScene.getBcmChain();
        if (bcmChain != null) {
            linkedHashMap.put("bcm_chain", bcmChain);
        }
        return linkedHashMap;
    }

    private final JSONArray convertMapToJsonArray(Map<String, Pair<Integer, Double>> nextMap) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, Pair<Integer, Double>> entry : nextMap.entrySet()) {
            String key = entry.getKey();
            Pair<Integer, Double> value = entry.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pathname", key);
            jSONObject.put("pv", ((Number) value.getFirst()).intValue());
            jSONObject.put("clickRate", ((Number) value.getSecond()).doubleValue());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public final void reportSqliteStatus(final int sceneTableSize, final int transTableSize, final int dbFileSize) {
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(MONITOR_ANNIE_X_NEXT_SQLITE_STATUS, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_table_size", sceneTableSize);
            jSONObject.put("trans_table_size", transTableSize);
            jSONObject.put("db_file_size", dbFileSize);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
        SceneLoggerUtils.INSTANCE.debugLog(SceneManager.INSTANCE.getTAG(), new Function0<String>() { // from class: com.bytedance.android.anniex.scene.connect.SceneConnectCenter$reportSqliteStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return "数据库异常监控埋点上报 scene_table_size：" + sceneTableSize + ", trans_table_size: " + transTableSize + ", db_file_size: " + dbFileSize;
            }
        });
    }

    public final void reportSqliteError(String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo(MONITOR_ANNIE_X_NEXT_SQLITE_ERROR, (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(StrategyConstants.ERROR_MSG, errorMsg);
            jSONObject.put("version", ExifInterface.GPS_MEASUREMENT_3D);
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }
}
