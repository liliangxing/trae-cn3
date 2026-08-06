package com.bytedance.android.live.core.setting.p027v2.tools;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.LiveSettingOldContext;
import com.bytedance.android.live.core.setting.p027v2.update.SettingIncStrategy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* compiled from: SettingV2Monitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u001eJ@\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004J&\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010'\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)H\u0007J?\u0010*\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/tools/SettingV2Monitor;", "", "()V", "NO_STICKY", "", "REPORT_TYPE_READ", "REPORT_TYPE_UPDATE", "SETTING_FAIL", "", "SETTING_SUCCESS", "SETTING_V2_COVER", "SETTING_V2_GET_VALUE_EXCEPTION", "SETTING_V2_READ_TIME", "SETTING_V2_TIME", "SETTING_V2_UPDATE_RESULT", "SETTING_V2_UPDATE_ROOM_RESULT", "STICKY", "localUpdateResult", "", "statusCode", "dataType", "updateType", "time", "", "updateSize", "deleteSize", NotificationCompat.CATEGORY_MESSAGE, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V", "localUpdateRoomResult", "roomId", "(Ljava/lang/Long;)V", "reportGetValueException", "key", "typeClass", "defaultValue", "originValue", "reportSettingCoverProbe", "version", "scene", "reportSettingReadTime", "isSticky", "", "reportSettingTimeProbe", "reportType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingV2Monitor {
    public static final SettingV2Monitor INSTANCE = new SettingV2Monitor();
    public static final String NO_STICKY = "no_sticky";
    public static final String REPORT_TYPE_READ = "read";
    public static final String REPORT_TYPE_UPDATE = "update";
    public static final int SETTING_FAIL = 1;
    public static final int SETTING_SUCCESS = 0;
    private static final String SETTING_V2_COVER = "ttlive_setting_cover_probe";
    private static final String SETTING_V2_GET_VALUE_EXCEPTION = "ttlive_setting_get_local_value_exception";
    private static final String SETTING_V2_READ_TIME = "ttlive_setting_read_time";
    private static final String SETTING_V2_TIME = "ttlive_setting_time_probe";
    private static final String SETTING_V2_UPDATE_RESULT = "ttlive_setting_update_v2";
    private static final String SETTING_V2_UPDATE_ROOM_RESULT = "ttlive_setting_update_room_result";
    public static final String STICKY = "sticky";

    private SettingV2Monitor() {
    }

    @JvmStatic
    public static final void reportSettingReadTime(String key, long time, String typeClass, boolean isSticky) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("typeClass", typeClass);
        jSONObject.put("isSticky", isSticky);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("time", time);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("key", key);
        LiveSettingOldContext.monitorEvent(SETTING_V2_READ_TIME, jSONObject, jSONObject2, jSONObject3);
    }

    @JvmStatic
    public static final void reportSettingCoverProbe(String version, String scene, String dataType) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", scene);
        jSONObject.put("version", version);
        jSONObject.put("data_type", dataType);
        LiveSettingOldContext.monitorEvent(SETTING_V2_COVER, jSONObject, new JSONObject(), new JSONObject());
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_SLADAR, "reportSettingTimeProbe: scene = " + scene + " version = " + version);
    }

    @JvmStatic
    public static final void reportSettingTimeProbe(String version, String scene, Long time, String dataType, String reportType) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("scene", scene);
        jSONObject.put("version", version);
        jSONObject.put("data_type", dataType);
        jSONObject.put("report_type", reportType);
        JSONObject jSONObject2 = new JSONObject();
        if (time != null) {
            jSONObject2.put("duration_time", time.longValue());
        }
        LiveSettingOldContext.monitorEvent(SETTING_V2_TIME, jSONObject, jSONObject2, new JSONObject());
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_SLADAR, "reportSettingTimeProbe: duration_time = " + time + ", scene = " + scene);
    }

    @JvmStatic
    public static final void localUpdateResult(int statusCode, String dataType, String updateType, Long time, int updateSize, int deleteSize, String msg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(StrategyConstants.STATUS_CODE, statusCode);
        jSONObject.put("data_type", dataType);
        jSONObject.put("update_type", updateType);
        JSONObject jSONObject2 = new JSONObject();
        if (time != null) {
            jSONObject2.put("update_time", time.longValue());
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("update_size", updateSize);
        jSONObject3.put("delete_size", deleteSize);
        jSONObject3.put(NotificationCompat.CATEGORY_MESSAGE, msg);
        LiveSettingOldContext.monitorEvent(SETTING_V2_UPDATE_RESULT, jSONObject, jSONObject2, jSONObject3);
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_SLADAR, "statusCode = " + statusCode + ", dataType = " + dataType + ", updateType = " + updateType + ", time = " + time + ", updateSize = " + updateSize + ",  deleteSize = " + deleteSize + ", msg = " + msg);
    }

    public final void localUpdateRoomResult(Long roomId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("update_success", SettingIncStrategy.INSTANCE.isIncUpdate());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("room_id", roomId);
        LiveSettingOldContext.monitorEvent(SETTING_V2_UPDATE_ROOM_RESULT, jSONObject, new JSONObject(), jSONObject2);
    }

    public final void reportGetValueException(int statusCode, String key, String typeClass, String defaultValue, String originValue, String msg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(StrategyConstants.STATUS_CODE, statusCode);
        jSONObject.put("key", key);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("default_value", defaultValue);
        jSONObject2.put("origin_value", originValue);
        jSONObject2.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, typeClass);
        jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, msg);
        LiveSettingOldContext.monitorEvent(SETTING_V2_GET_VALUE_EXCEPTION, jSONObject, null, jSONObject2);
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_SLADAR, "statusCode = " + statusCode + ", key = " + key + ", msg = " + msg + ", origin_value=" + originValue);
    }
}
