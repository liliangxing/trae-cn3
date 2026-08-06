package com.ss.bduploader;

import android.text.TextUtils;
import android.util.Log;
import com.ss.bduploader.logupload.AppLogEngineUploader;
import com.ss.bduploader.logupload.VideoEventEngineUploader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public enum UploadEventManager {
    instance;

    private static final String TAG = "UploadEventManager";
    private VideoEventEngineUploader mEngineUploader;
    private JSONArray mJsonArray = new JSONArray();
    private boolean mEnableUseEngineUploader = true;

    UploadEventManager() {
        setEngineUploader(AppLogEngineUploader.getInstance());
    }

    public void setUseEngineUploader(boolean z) {
        this.mEnableUseEngineUploader = z;
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader videoEventEngineUploader) {
        this.mEngineUploader = videoEventEngineUploader;
    }

    public JSONArray popAllEvents() {
        JSONArray jSONArray = this.mJsonArray;
        synchronized (UploadEventManager.class) {
            this.mJsonArray = new JSONArray();
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addEvent(JSONObject jSONObject) {
        String str;
        synchronized (UploadEventManager.class) {
            if (jSONObject != null) {
                if (this.mEngineUploader != null && this.mEnableUseEngineUploader) {
                    try {
                        str = jSONObject.getString("event");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.mEngineUploader.onEventV3(str, jSONObject);
                    }
                } else {
                    this.mJsonArray.put(jSONObject);
                }
            }
        }
    }

    public void putEvent(JSONObject jSONObject) {
        synchronized (UploadEventManager.class) {
            Log.d("ttmn", "putEvent");
            this.mJsonArray.put(jSONObject);
        }
    }
}
