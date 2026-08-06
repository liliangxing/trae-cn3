package com.ss.bduploader.logupload;

import android.text.TextUtils;
import android.util.Log;
import com.ss.bduploader.BDUploadLog;
import com.ss.bduploader.BDUploadUtil;
import com.ss.bduploader.UploadEventManager;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AppLogEngineUploader implements VideoEventEngineUploader {
    private static final String APPLOG_CLASS_NAME = "com.ss.android.common.applog.AppLog";
    private static final String APPLOG_NEW_UTILS_CLASS_NAME = "com.ss.android.common.lib.AppLogNewUtils";
    private static final String APPLOG_WRAPPER = "com.pandora.common.applog.AppLogWrapper";
    private static final String TAG = "ttmn";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class Holder {
        private static final AppLogEngineUploader instance = new AppLogEngineUploader();

        private Holder() {
        }
    }

    public static AppLogEngineUploader getInstance() {
        return Holder.instance;
    }

    private AppLogEngineUploader() {
    }

    @Override // com.ss.bduploader.logupload.VideoEventEngineUploader
    public void onEventV3(String str, JSONObject jSONObject) {
        Log.i(TAG, "onEventV3 monitorName " + str);
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        logPrint(jSONObject);
        if (BDUploadUtil.eventEngineUploader != null) {
            BDUploadUtil.eventEngineUploader.onEventV3(str, setJsonValue(jSONObject, "upload_log_type", "2"));
            return;
        }
        try {
            Class.forName(APPLOG_NEW_UTILS_CLASS_NAME).getMethod("onEventV3", String.class, JSONObject.class).invoke(null, str, setJsonValue(jSONObject, "upload_log_type", "1"));
        } catch (Exception e) {
            UploadEventManager.instance.putEvent(setJsonValue(jSONObject, "upload_log_type", "0"));
            e.printStackTrace();
            Log.e(TAG, "upload error " + e);
        }
    }

    private JSONObject setJsonValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
            Log.d(TAG, "key" + str + "value" + str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static void logPrint(final JSONObject jSONObject) {
        BDUploadThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.bduploader.logupload.AppLogEngineUploader.1
            @Override // java.lang.Runnable
            public void run() {
                if (jSONObject == null) {
                    return;
                }
                BDUploadLog.i(AppLogEngineUploader.TAG, "++++++++++++++++");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        if (next != null) {
                            BDUploadLog.i(AppLogEngineUploader.TAG, "++++:" + next + Constants.COLON_SEPARATOR + jSONObject.get(next));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                BDUploadLog.i(AppLogEngineUploader.TAG, "++++++++++++++++++++");
            }
        });
    }
}
