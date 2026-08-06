package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.util.IEventsSender;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.ss.android.common.util.TLog;
import com.ss.android.http.legacy.protocol.HTTP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EventVerifyWrapper implements IEventsSender, Runnable {
    private static final String KEY_LOGIN_ET_APP_ID = "app_id";
    private static final String KEY_LOGIN_ET_DEVICE_ID = "device_id";
    private static final String KEY_LOGIN_ET_DEVICE_MODEL = "device_model";
    private static final String KEY_SCHEME_CALLBACK_URL = "callback_url";
    private static final String KEY_SCHEME_REPORT_INTERVAL = "report_interval";
    private static final String KEY_SCHEME_SCREENSHOT_ENABLE = "screenshot";
    private static final String KEY_SCHEME_SCREENSHOT_INTERVAL = "screenshot_interval";
    private static final String PATH_APP_LOG_VERIFY = "/service/2/app_log_test/";
    private static final String TAG = "EventVerifyWrapper";
    private String mEventVerifyUrl;
    private List<String> mSpecialKeys;
    private ThreadPlus mThreadPlus;
    private volatile boolean mEnable = false;
    private volatile long mEventVerifyInterval = 200;
    private BlockingQueue<EventItem> mEventQueue = new LinkedBlockingQueue();

    @Override // java.lang.Runnable
    public void run() {
        String doPost;
        List<String> list;
        while (!Thread.interrupted()) {
            try {
                if (!this.mEnable) {
                    return;
                }
                JSONObject headerCopy = AppLog.getHeaderCopy();
                if (headerCopy != null && !headerCopy.isNull("device_id") && !TextUtils.isEmpty(this.mEventVerifyUrl)) {
                    EventItem take = this.mEventQueue.take();
                    ArrayList<EventItem> arrayList = new ArrayList();
                    arrayList.add(take);
                    this.mEventQueue.drainTo(arrayList);
                    HashMap hashMap = new HashMap();
                    for (EventItem eventItem : arrayList) {
                        if (eventItem != null) {
                            JSONArray jSONArray = eventItem.mEventJsonArray;
                            if (jSONArray != null && jSONArray.length() > 0) {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                    if (optJSONObject != null) {
                                        Iterator<String> keys = optJSONObject.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            if (!TextUtils.isEmpty(next) && (((list = this.mSpecialKeys) != null && list.contains(next)) || next.contains("url"))) {
                                                String optString = optJSONObject.optString(next);
                                                if (!TextUtils.isEmpty(optString) && optString.contains("?")) {
                                                    TLog.m73d("EventVerifyWrapper original value = " + optString);
                                                    String encode = Uri.encode(optString);
                                                    TLog.m73d("EventVerifyWrapper encode value = " + encode);
                                                    try {
                                                        optJSONObject.put(next, encode);
                                                    } catch (JSONException unused) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            hashMap.put(eventItem.mEventType, appendJsonArray((JSONArray) hashMap.get(eventItem.mEventType), jSONArray));
                        }
                    }
                    try {
                        String addCommonParams = NetUtil.addCommonParams(Uri.parse(this.mEventVerifyUrl).buildUpon().toString(), true);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("header", AppLog.getHeaderCopy());
                        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
                        jSONObject.put("magic_tag", "ss_app_log");
                        jSONObject.put("time_sync", AppLog.getInstance(null).getTimeSync());
                        for (Map.Entry entry : hashMap.entrySet()) {
                            if (entry != null) {
                                jSONObject.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        byte[] bytes = jSONObject.toString().getBytes(HTTP.UTF_8);
                        Map<String, String> logHttpHeader = AppLog.getLogHttpHeader();
                        if (AppLog.getLogEncryptSwitch()) {
                            doPost = NetUtil.sendEncryptLog(AppLog.getLogCompressor(), addCommonParams, bytes, null, false, null, logHttpHeader, null, false, false);
                        } else {
                            doPost = NetUtil.doPost(AppLog.getLogCompressor(), addCommonParams, bytes, false, "application/octet-stream;tt-data=b", false, logHttpHeader, false, false);
                        }
                        TLog.m73d("EventVerifyWrapper send event verify resp: " + doPost);
                    } catch (Throwable th) {
                        TLog.m76e("EventVerifyWrapper send event verify", th);
                    }
                    if (this.mEventVerifyInterval > 0) {
                        try {
                            Thread.sleep(this.mEventVerifyInterval);
                        } catch (InterruptedException e) {
                            TLog.m76e("EventVerifyWrapper wait next event verify exception", e);
                        }
                    }
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused2) {
                }
            } catch (Throwable th2) {
                TLog.m74d("EventVerifyWrapper out exception =", th2);
                return;
            }
        }
        TLog.m73d("EventVerifyWrapper interrupted");
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class EventItem {
        JSONArray mEventJsonArray;
        String mEventType;

        public EventItem(String str, JSONArray jSONArray) {
            this.mEventType = str;
            this.mEventJsonArray = jSONArray;
        }
    }

    public void putEvent(String str, JSONArray jSONArray) {
        if (!this.mEnable || TextUtils.isEmpty(str) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.mEventQueue.add(new EventItem(str, jSONArray));
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEventVerifyUrl(String str) {
        this.mEventVerifyUrl = str + PATH_APP_LOG_VERIFY;
    }

    public void setEnable(boolean z, Context context) {
        if (this.mEnable == z) {
            return;
        }
        this.mEnable = z;
        if (this.mEnable) {
            ThreadPlus threadPlus = new ThreadPlus(this, TAG, true);
            this.mThreadPlus = threadPlus;
            threadPlus.start();
            return;
        }
        this.mThreadPlus = null;
    }

    public void loginEtWithScheme(String str, final Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter(KEY_SCHEME_REPORT_INTERVAL);
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        setEventVerifyInterval(Long.parseLong(queryParameter));
                    } catch (NumberFormatException unused) {
                    }
                }
                Uri.Builder buildUpon = Uri.parse(parse.getQueryParameter(KEY_SCHEME_CALLBACK_URL)).buildUpon();
                buildUpon.appendQueryParameter("app_id", String.valueOf(AppLog.getAppId()));
                buildUpon.appendQueryParameter("device_id", AppLog.getServerDeviceId());
                buildUpon.appendQueryParameter(KEY_LOGIN_ET_DEVICE_MODEL, Build.MODEL);
                final String uri = buildUpon.build().toString();
                new ThreadPlus(new Runnable() { // from class: com.ss.android.common.applog.EventVerifyWrapper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        JSONObject jSONObject = null;
                        try {
                            str2 = NetworkClient.getDefault().get(uri, (Map) null, (NetworkClient.ReqContext) null);
                        } catch (Exception e) {
                            TLog.m76e("EventVerifyWrapper login et", e);
                            str2 = null;
                        }
                        TLog.m73d("EventVerifyWrapper login et resp: " + str2);
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        try {
                            jSONObject = new JSONObject(str2);
                        } catch (JSONException unused2) {
                        }
                        if (jSONObject == null || jSONObject.optInt("status") != 200) {
                            return;
                        }
                        EventVerifyWrapper.this.setEnable(true, context);
                    }
                }, TAG, true).start();
                return;
            } catch (Throwable th) {
                TLog.m76e("EventVerifyWrapper login et", th);
                return;
            }
        }
        TLog.m76e("EventVerifyWrapper login et", new RuntimeException("scheme is null"));
    }

    public void setEventVerifyInterval(long j) {
        if (j >= 0) {
            this.mEventVerifyInterval = j;
        }
    }

    public void setSpecialKeys(List<String> list) {
        this.mSpecialKeys = new CopyOnWriteArrayList(list);
    }

    private JSONArray appendJsonArray(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return jSONArray;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            return jSONArray2;
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            jSONArray.put(jSONArray2.optJSONObject(i));
        }
        return jSONArray;
    }
}
