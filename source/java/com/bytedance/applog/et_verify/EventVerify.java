package com.bytedance.applog.et_verify;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.concurrent.AppLogExecutors;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.util.IEventsSender;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.bdinstall.Level;
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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventVerify implements Runnable, IEventsSender {
    private static final String KEY_LOGIN_ET_APP_ID = "app_id";
    private static final String KEY_LOGIN_ET_DEVICE_ID = "device_id";
    private static final String KEY_LOGIN_ET_DEVICE_MODEL = "device_model";
    private static final String KEY_SCHEME_CALLBACK_URL = "callback_url";
    private static final String KEY_SCHEME_REPORT_INTERVAL = "report_interval";
    private static final String KEY_SCHEME_SCREENSHOT_ENABLE = "screenshot";
    private static final String KEY_SCHEME_SCREENSHOT_INTERVAL = "screenshot_interval";
    private static final int MAX_QUEUE_SIZE = 1000;
    private static final String PATH_APP_LOG_VERIFY = "/service/2/app_log_test/";
    private static final String TAG = "EventVerify";
    private static final String TYPE_EVENT_SIGN = "_event_v3";
    private static final String TYPE_EVENT_V1 = "event";
    private static final String TYPE_EVENT_V3 = "event_v3";
    private static final String TYPE_ITEM_IMPRESSION = "item_impression";
    private static final String TYPE_LAUNCH = "launch";
    private static final String TYPE_LOG_DATA = "log_data";
    private static final String TYPE_TERMINATE = "terminate";
    private static volatile String mEventVerifyUrl;
    private final AppLogInstance appLogInstance;
    private List<String> mSpecialKeys;
    private volatile boolean mEnable = false;
    private volatile long mEventVerifyInterval = 200;
    private volatile Context mContext = null;
    private final BlockingQueue<EventItem> mEventQueue = new LinkedBlockingQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class EventItem {
        JSONArray mEventJsonArray;
        String mEventType;

        public EventItem(String str, JSONArray jSONArray) {
            this.mEventType = str;
            this.mEventJsonArray = jSONArray;
        }

        public String toString() {
            return "EventItem{mEventType='" + this.mEventType + "', mEventJsonArray=" + this.mEventJsonArray + '}';
        }
    }

    public EventVerify(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    @Override // com.bytedance.applog.util.IEventsSender
    public void putEvent(String str, JSONArray jSONArray) {
        addEventToQueue(new EventItem(str, jSONArray));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(16:3|4|5|(1:7)|8|(1:10)(1:42)|11|12|(5:14|(1:16)|17|(1:19)|20)(6:32|(1:34)|35|(1:37)|38|(1:40))|21|(1:23)|24|(1:26)|27|28|29)|45|(0)|8|(0)(0)|11|12|(0)(0)|21|(0)|24|(0)|27|28|29) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f A[Catch: JSONException -> 0x00d3, TryCatch #0 {JSONException -> 0x00d3, blocks: (B:12:0x0037, B:14:0x003f, B:16:0x0045, B:17:0x004c, B:19:0x005a, B:20:0x0064, B:23:0x00a6, B:24:0x00ac, B:26:0x00b8, B:27:0x00be, B:32:0x0075, B:34:0x0088, B:37:0x0093, B:40:0x009d), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[Catch: JSONException -> 0x00d3, TryCatch #0 {JSONException -> 0x00d3, blocks: (B:12:0x0037, B:14:0x003f, B:16:0x0045, B:17:0x004c, B:19:0x005a, B:20:0x0064, B:23:0x00a6, B:24:0x00ac, B:26:0x00b8, B:27:0x00be, B:32:0x0075, B:34:0x0088, B:37:0x0093, B:40:0x009d), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b8 A[Catch: JSONException -> 0x00d3, TryCatch #0 {JSONException -> 0x00d3, blocks: (B:12:0x0037, B:14:0x003f, B:16:0x0045, B:17:0x004c, B:19:0x005a, B:20:0x0064, B:23:0x00a6, B:24:0x00ac, B:26:0x00b8, B:27:0x00be, B:32:0x0075, B:34:0x0088, B:37:0x0093, B:40:0x009d), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075 A[Catch: JSONException -> 0x00d3, TryCatch #0 {JSONException -> 0x00d3, blocks: (B:12:0x0037, B:14:0x003f, B:16:0x0045, B:17:0x004c, B:19:0x005a, B:20:0x0064, B:23:0x00a6, B:24:0x00ac, B:26:0x00b8, B:27:0x00be, B:32:0x0075, B:34:0x0088, B:37:0x0093, B:40:0x009d), top: B:11:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void putEvent(String str, String str2, String str3, long j, long j2, long j3, long j4, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str4;
        String userUniqueID;
        if (jSONObject != null) {
            try {
                jSONObject2 = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            if ("event_v3".equals(str)) {
                jSONObject3 = jSONObject2;
                str4 = "event";
            } else {
                jSONObject3 = new JSONObject();
                str4 = "event_v3";
            }
            if (!"event_v3".equals(str)) {
                if (jSONObject2.has("nt")) {
                    jSONObject3.put("nt", jSONObject2.optInt("nt"));
                }
                jSONObject2.remove("nt");
                jSONObject2.remove(TYPE_EVENT_SIGN);
                if (jSONObject2.has(Api.KEY_AB_SDK_VERSION)) {
                    jSONObject3.put(Api.KEY_AB_SDK_VERSION, jSONObject2.optString(Api.KEY_AB_SDK_VERSION));
                    jSONObject2.remove(Api.KEY_AB_SDK_VERSION);
                }
                jSONObject3.put("event", str2);
                jSONObject3.put("params", jSONObject2);
                jSONObject3.put(Api.KEY_LOCAL_TIME_MS, j4);
            } else {
                jSONObject3.put("category", str);
                jSONObject3.put(Api.COL_TAG, str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject3.put(Api.COL_LABEL, str3);
                }
                if (j != 0) {
                    jSONObject3.put("value", j);
                }
                if (j2 != 0) {
                    jSONObject3.put(Api.COL_EXT_VALUE, j2);
                }
            }
            if (j3 > 0) {
                jSONObject3.put("user_id", j3);
            }
            userUniqueID = this.appLogInstance.getUserUniqueID();
            if (!TextUtils.isEmpty(userUniqueID)) {
                jSONObject3.put("user_unique_id", userUniqueID);
            }
            jSONObject3.put("session_id", this.appLogInstance.getSessionId());
            jSONObject3.put(Api.KEY_DATETIME, BaseData.formatDateMS(j4));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject3);
            addEventToQueue(new EventItem(str4, jSONArray));
        }
        jSONObject2 = null;
        if (jSONObject2 == null) {
        }
        if ("event_v3".equals(str)) {
        }
        if (!"event_v3".equals(str)) {
        }
        if (j3 > 0) {
        }
        userUniqueID = this.appLogInstance.getUserUniqueID();
        if (!TextUtils.isEmpty(userUniqueID)) {
        }
        jSONObject3.put("session_id", this.appLogInstance.getSessionId());
        jSONObject3.put(Api.KEY_DATETIME, BaseData.formatDateMS(j4));
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject3);
        addEventToQueue(new EventItem(str4, jSONArray2));
    }

    @Override // com.bytedance.applog.util.IEventsSender
    public boolean isEnable() {
        return this.mEnable;
    }

    @Override // com.bytedance.applog.util.IEventsSender
    public void setEventVerifyUrl(String str) {
        mEventVerifyUrl = str + PATH_APP_LOG_VERIFY;
    }

    @Override // com.bytedance.applog.util.IEventsSender
    public synchronized void setEnable(boolean z, Context context) {
        this.appLogInstance.getLogger().info(6, "setEnable = {}", Boolean.valueOf(z));
        if (context != null && this.mContext == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.mContext = context;
        }
        if (!z) {
            synchronized (this.mEventQueue) {
                this.mEventQueue.clear();
            }
        }
        if (this.mEnable == z) {
            return;
        }
        this.mEnable = z;
        if (this.mEnable) {
            AppLogExecutors.getNormalExecutor().submit(this);
        }
    }

    @Override // com.bytedance.applog.util.IEventsSender
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
                buildUpon.appendQueryParameter("app_id", this.appLogInstance.getAid());
                buildUpon.appendQueryParameter("device_id", this.appLogInstance.getDid());
                buildUpon.appendQueryParameter("device_model", Build.MODEL);
                final String uri = buildUpon.build().toString();
                AppLogExecutors.getSingleExecutor().submit(new Runnable() { // from class: com.bytedance.applog.et_verify.EventVerify.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        JSONObject jSONObject = null;
                        try {
                            str2 = EventVerify.this.appLogInstance.getNetClient().get(uri, null);
                        } catch (Exception e) {
                            EventVerify.this.appLogInstance.getLogger().error(6, "login et failed", e, new Object[0]);
                            str2 = null;
                        }
                        EventVerify.this.appLogInstance.getLogger().debug(6, "login et resp: {}", str2);
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
                        EventVerify.this.setEnable(true, context);
                    }
                });
                return;
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error(6, "login et", th, new Object[0]);
                return;
            }
        }
        this.appLogInstance.getLogger().error(6, "login et", new RuntimeException("scheme is null"), new Object[0]);
    }

    @Override // com.bytedance.applog.util.IEventsSender
    public void setEventVerifyInterval(long j) {
        if (j >= 0) {
            this.mEventVerifyInterval = j;
        }
    }

    @Override // com.bytedance.applog.util.IEventsSender
    public void setSpecialKeys(List<String> list) {
        this.mSpecialKeys = new CopyOnWriteArrayList(list);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:8|(18:23|24|4f|29|(4:32|(1:76)(4:34|(3:38|(4:41|(3:43|(4:46|(2:52|(4:56|57|58|60))|61|44)|69)(1:71)|70|39)|72)|73|74)|75|30)|77|78|(4:81|(3:83|84|85)(1:87)|86|79)|88|89|(2:110|111)|91|(2:93|(1:95)(1:108))(1:109)|96|97|98|(3:100|101|103)(1:107)|21)|16|17|18|20|21) */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String post;
        List<String> list;
        while (true) {
            int i = 0;
            try {
                if (Thread.interrupted()) {
                    this.appLogInstance.getLogger().error(6, "interrupted", new Object[0]);
                    return;
                }
                if (!this.mEnable) {
                    return;
                }
                JSONObject transferHeader = SensitiveUtils.transferHeader(this.appLogInstance.getHeader());
                if (transferHeader != null && !transferHeader.isNull("device_id") && !TextUtils.isEmpty(mEventVerifyUrl)) {
                    EventItem take = this.mEventQueue.take();
                    ArrayList<EventItem> arrayList = new ArrayList();
                    arrayList.add(take);
                    synchronized (this.mEventQueue) {
                        this.mEventQueue.drainTo(arrayList);
                    }
                    HashMap hashMap = new HashMap();
                    for (EventItem eventItem : arrayList) {
                        if (eventItem != null) {
                            JSONArray jSONArray = eventItem.mEventJsonArray;
                            if (jSONArray != null && jSONArray.length() > 0) {
                                int i2 = i;
                                while (i2 < jSONArray.length()) {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                                    if (optJSONObject != null) {
                                        Iterator<String> keys = optJSONObject.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            if (!TextUtils.isEmpty(next) && (((list = this.mSpecialKeys) != null && list.contains(next)) || next.contains("url"))) {
                                                String optString = optJSONObject.optString(next);
                                                if (!TextUtils.isEmpty(optString) && optString.contains("?")) {
                                                    IAppLogLogger logger = this.appLogInstance.getLogger();
                                                    Object[] objArr = new Object[1];
                                                    objArr[i] = optString;
                                                    logger.debug(6, "original value = {}", objArr);
                                                    String encode = Uri.encode(optString);
                                                    this.appLogInstance.getLogger().debug(6, "encode value = {}", encode);
                                                    try {
                                                        optJSONObject.put(next, encode);
                                                    } catch (JSONException unused) {
                                                    }
                                                }
                                            }
                                            i = 0;
                                        }
                                    }
                                    i2++;
                                    i = 0;
                                }
                            }
                            hashMap.put(eventItem.mEventType, appendJsonArray((JSONArray) hashMap.get(eventItem.mEventType), jSONArray));
                        }
                        i = 0;
                    }
                    try {
                        String addNetCommonParams = this.appLogInstance.addNetCommonParams(this.mContext, Uri.parse(mEventVerifyUrl).buildUpon().toString(), true, Level.L0);
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            if (entry != null) {
                                jSONObject.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        IHeaderCustomTimelyCallback headerCustomCallback = this.appLogInstance.getHeaderCustomCallback();
                        if (headerCustomCallback != null) {
                            try {
                                headerCustomCallback.updateHeader(transferHeader);
                            } catch (Throwable th) {
                                this.appLogInstance.getLogger().error(6, "send event verify", th, new Object[0]);
                            }
                        }
                        jSONObject.put("header", transferHeader);
                        jSONObject.put(Api.KEY_LOCAL_TIME, System.currentTimeMillis() / 1000);
                        jSONObject.put("magic_tag", "ss_app_log");
                        jSONObject.put(Api.KEY_TIME_SYNC, this.appLogInstance.getApi().mTimeSync);
                        byte[] bytes = jSONObject.toString().getBytes(UrlUtils.UTF_8);
                        if (this.appLogInstance.getEncryptAndCompress()) {
                            JSONObject eventVerify = this.appLogInstance.getApi().eventVerify(addNetCommonParams, jSONObject);
                            post = eventVerify != null ? eventVerify.toString() : null;
                        } else {
                            post = this.appLogInstance.getNetClient().post(addNetCommonParams, bytes, "application/json; charset=utf-8");
                        }
                        this.appLogInstance.getLogger().debug(6, "send event verify resp: {}", post);
                    } catch (Throwable th2) {
                        this.appLogInstance.getLogger().error(6, "send event verify", th2, new Object[0]);
                    }
                    if (this.mEventVerifyInterval > 0) {
                        try {
                            Thread.sleep(this.mEventVerifyInterval);
                        } catch (InterruptedException e) {
                            this.appLogInstance.getLogger().error(6, "wait next event verify exception", e, new Object[0]);
                        }
                    }
                }
                Thread.sleep(1000L);
            } catch (Throwable th3) {
                this.appLogInstance.getLogger().error(6, "out exception =", th3, new Object[0]);
                return;
            }
        }
    }

    private void addEventToQueue(EventItem eventItem) {
        synchronized (this.mEventQueue) {
            if (this.mEventQueue.size() >= 1000) {
                this.appLogInstance.getLogger().warn(6, "event item cache poll drop: {}", this.mEventQueue.poll());
            }
            this.mEventQueue.add(eventItem);
        }
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
