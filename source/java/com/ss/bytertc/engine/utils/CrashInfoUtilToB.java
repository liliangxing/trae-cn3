package com.ss.bytertc.engine.utils;

import android.content.Context;
import com.apm.lite.IUploadCallback;
import com.apm.lite.MonitorCrash;
import com.ss.bytertc.base.utils.RtcContextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CrashInfoUtilToB {
    private static final String TAG = "CrashInfoUtilToB";
    private static final Context context = RtcContextUtils.getApplicationContext();
    private static MonitorCrash sdk = null;
    private static final String token = "d7271e1eac254529abcffc63e36b02c3";

    public static void initApm(String appId, final String did) {
        LogUtil.m215d(TAG, "initApm...");
        try {
            sdk = MonitorCrash.initSDK(context, MonitorCrash.Config.sdk("432410").token(token).versionName("1。0").versionCode(1L).dynamicParams(new MonitorCrash.Config.IDynamicParams() { // from class: com.ss.bytertc.engine.utils.CrashInfoUtilToB.1
                public String getUserId() {
                    return null;
                }

                public String getDid() {
                    return did;
                }
            }).channel("rtc_sdk").keyWords(new String[]{"bytertc", "com.ss.video.rtc.oner", "com.bytedance.ttgame.module.rtc.RtcService"}).soList(new String[]{"libbyteaudio.so", "libbytertc.so", "libagora.so", "libonerrtc.so", "libvolcenginertc.so", "libulien_audio.so"}).build());
        } catch (Exception e) {
            LogUtil.m216e(TAG, "initApm catch exception.\n" + e.getMessage());
        }
    }

    public static void addTagsReport(String params) {
        LogUtil.m215d(TAG, "addTagsReport...");
        try {
            JSONObject jSONObject = new JSONObject(params);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                sdk.addTags(next, jSONObject.getString(next));
            }
        } catch (Exception e) {
            LogUtil.m216e(TAG, "addTagsReport catch exception.\n" + e.getMessage());
        }
    }

    public static void onEventV3Report(String params) {
        LogUtil.m215d(TAG, "onEventV3Report...");
        try {
            JSONObject jSONObject = new JSONObject(params);
            Iterator<String> keys = jSONObject.keys();
            boolean z = false;
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                sdk.addPageViewTags(next, string);
                if (next.equals("rtc_room_id") && !string.equals("")) {
                    z = true;
                }
            }
            if (z) {
                sdk.addPageViewTags("rtc_session_type", "joinRoom");
            } else {
                sdk.addPageViewTags("rtc_session_type", "createEngine");
            }
            sdk.reportPageView((IUploadCallback) null);
        } catch (Exception e) {
            LogUtil.m216e(TAG, "onEventV3Report catch exception.\n" + e.getMessage());
        }
    }
}
