package com.bytedance.ies.bullet.service.monitor.fluency;

import android.util.Log;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* compiled from: FluencyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\b\u0010$\u001a\u00020\u000fH\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/fluency/FluencyHelper;", "", "()V", "AFTER_FMP", "", "BEFORE_FMP", "BLOCK_PER_SECOND", "DROP_RATE", "ERROR_STAGE", "FPS", "HIGH_DROPFRAME_RATIO", "LIGHT_DROPFRAME_RATIO", "MIDDLE_DROPFRAME_RATIO", "REFRESH_RATE", "REFRESH_RATE_120", "", "REFRESH_RATE_60", "REFRESH_RATE_90", "SLIGHT_DROPFRAME_RATIO", "STAGE", "TAG", "TAG_NAME", "VIEW_TYPE", "virtualRefreshRate", "calcuteDropFrameMetrics", "Lorg/json/JSONObject;", "fps", "", "dropFrames", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "collectFluencyMetrics", "getBlockThresholdFrames", "getHighDropFrameLevel", "getLightDropFrameLevel", "getMiddleDropFrameLevel", "getSLightDropFrameLevel", "setVirtualRefreshRate", "", "refreshRate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FluencyHelper {
    public static final String AFTER_FMP = "after_fmp";
    public static final String BEFORE_FMP = "before_fmp";
    public static final String BLOCK_PER_SECOND = "block_per_second";
    public static final String DROP_RATE = "drop_rate";
    public static final String ERROR_STAGE = "error_stage";
    public static final String FPS = "fps";
    public static final String HIGH_DROPFRAME_RATIO = "high_dropframe_ratio";
    public static final String LIGHT_DROPFRAME_RATIO = "light_dropframe_ratio";
    public static final String MIDDLE_DROPFRAME_RATIO = "middle_dropframe_ratio";
    public static final String REFRESH_RATE = "refresh_rate";
    private static final int REFRESH_RATE_120 = 120;
    private static final int REFRESH_RATE_60 = 60;
    private static final int REFRESH_RATE_90 = 90;
    public static final String SLIGHT_DROPFRAME_RATIO = "slight_dropframe_ratio";
    public static final String STAGE = "stage";
    private static final String TAG = "FluencyMonitor";
    public static final String TAG_NAME = "tag_name";
    public static final String VIEW_TYPE = "view_type";
    public static final FluencyHelper INSTANCE = new FluencyHelper();
    private static int virtualRefreshRate = -1;

    private final int getSLightDropFrameLevel() {
        return 1;
    }

    private FluencyHelper() {
    }

    private final int getLightDropFrameLevel() {
        int i = virtualRefreshRate;
        if (i == 60) {
            return 3;
        }
        if (i != 90) {
            return i != 120 ? 3 : 7;
        }
        return 5;
    }

    private final int getMiddleDropFrameLevel() {
        int i = virtualRefreshRate;
        if (i == 60) {
            return 7;
        }
        if (i != 90) {
            return i != 120 ? 7 : 15;
        }
        return 11;
    }

    private final int getHighDropFrameLevel() {
        int i = virtualRefreshRate;
        if (i == 60) {
            return 14;
        }
        if (i != 90) {
            return i != 120 ? 14 : 31;
        }
        return 23;
    }

    private final int getBlockThresholdFrames() {
        int i = virtualRefreshRate;
        if (i == 60) {
            return 3;
        }
        if (i != 90) {
            return i != 120 ? 3 : 7;
        }
        return 5;
    }

    public final void setVirtualRefreshRate(int refreshRate) {
        virtualRefreshRate = refreshRate;
    }

    public final JSONObject calcuteDropFrameMetrics(double fps, JSONObject dropFrames, long duration) {
        Iterator<String> keys;
        JSONObject jSONObject = dropFrames;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        int i = 0;
        String format = String.format("calcute the info of dropframe:%s, duration:%s, fps:%s", Arrays.copyOf(new Object[]{jSONObject, Long.valueOf(duration), Double.valueOf(fps)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Log.i(TAG, format);
        if (jSONObject == null || (keys = dropFrames.keys()) == null) {
            return null;
        }
        int blockThresholdFrames = getBlockThresholdFrames();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "key");
            int parseInt = Integer.parseInt(next);
            int optInt = jSONObject.optInt(next);
            if (optInt > 0) {
                if (parseInt >= blockThresholdFrames) {
                    i += optInt;
                }
                i3 += optInt;
                if (parseInt != 0) {
                    if (parseInt < getLightDropFrameLevel()) {
                        i4 += optInt;
                    } else if (parseInt < getMiddleDropFrameLevel()) {
                        i5 += optInt;
                    } else if (parseInt < getHighDropFrameLevel()) {
                        i6 += optInt;
                    } else {
                        i7 += optInt;
                    }
                    i2 += parseInt * optInt;
                }
                jSONObject = dropFrames;
            }
        }
        if (i3 <= 0) {
            return null;
        }
        int i8 = i4 + i5 + i6 + i7;
        double d = i2;
        double d2 = (((duration * fps) * 1.0d) / (BytePatchException.ErrorCode.paramsError * 1.0d)) + d;
        JSONObject jSONObject2 = new JSONObject();
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("drop_rate: dropFrameNumber:%s, sumTheoreticalFrames:%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
        Log.i(TAG, format2);
        jSONObject2.put(DROP_RATE, i2 > 0 ? d / d2 : 0.0d);
        if (i8 > 0 && d2 > 0) {
            double d3 = i8 * 1.0d;
            jSONObject2.put(SLIGHT_DROPFRAME_RATIO, i4 / d3);
            jSONObject2.put(LIGHT_DROPFRAME_RATIO, i5 / d3);
            jSONObject2.put(MIDDLE_DROPFRAME_RATIO, i6 / d3);
            jSONObject2.put(HIGH_DROPFRAME_RATIO, i7 / d3);
        } else {
            jSONObject2.put(SLIGHT_DROPFRAME_RATIO, 0);
            jSONObject2.put(LIGHT_DROPFRAME_RATIO, 0);
            jSONObject2.put(MIDDLE_DROPFRAME_RATIO, 0);
            jSONObject2.put(HIGH_DROPFRAME_RATIO, 0);
        }
        jSONObject2.put(BLOCK_PER_SECOND, (int) ((i * BytePatchException.ErrorCode.paramsError) / duration));
        return jSONObject2;
    }

    public final JSONObject collectFluencyMetrics(double fps, JSONObject dropFrames, long duration) {
        Log.i(TAG, "collectFluencyMetrics");
        int refreshRate = FpsUtil.getRefreshRate();
        setVirtualRefreshRate(refreshRate);
        JSONObject wrap = JsonUtilsKt.wrap(new JSONObject(), calcuteDropFrameMetrics(fps, dropFrames, duration));
        wrap.put("fps", fps);
        wrap.put("refresh_rate", refreshRate);
        return wrap;
    }
}
