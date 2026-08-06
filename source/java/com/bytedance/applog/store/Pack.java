package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.CompressResult;
import com.bytedance.applog.engine.Session;
import com.bytedance.applog.filter.SamplingFilter;
import com.bytedance.applog.forward.EventForwardLoader;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.isolate.DataIsolateUtils;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.p006v3.MonitorConfigManager;
import com.bytedance.applog.monitor.p006v3.MonitorV3Helper;
import com.bytedance.applog.monitor.p006v3.StageEventBasic;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.priority.EventPriorityLoader;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.sampling.EventSampling;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.util.DateUtils;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Pack extends BaseData {
    private static final String COL_DATA = "_data";
    private static final String COL_DATA_JSON = "data_json";
    private static final String COL_ENCODE_HEADERS = "encode_headers";
    private static final String COL_ENCODE_TYPE = "encode_type";
    static final String COL_EVENT_COUNT = "event_count";
    public static final String COL_EVENT_LOCAL_IDS = "e_ids";
    static final String COL_EVENT_MISC_COUNT = "_event_misc_count";
    public static final String COL_EVENT_SENTRY_STAINED_EVENTS = "sentry_stained_ids";
    static final String COL_EVENT_V1_COUNT = "_event_v1_count";
    static final String COL_EVENT_V3_COUNT = "_event_v3_count";
    static final String COL_FAIL = "_fail";
    static final String COL_IMPRESSION_COUNT = "_impression_count";
    static final String COL_ISOLATE_KEY = "isolate_key";
    static final String COL_ISOLATE_KEY_VALUE = "isolate_key_value";
    private static final String COL_IV_ENCRYPT_LOG_RESP = "iv";
    private static final String COL_KEY_ENCRYPT_LOG_RESP = "key";
    static final String COL_LAUNCH_COUNT = "_launch_count";
    static final String COL_TERMINATE_COUNT = "_terminate_count";
    private static final SimpleDateFormat DATE_FORMAT_LAUNCH = DateUtils.getDateFormat();
    private static final String FLAG_FOREGROUND_LAUNCH = "foreground_launch";
    static final String JSON_PARAM_EVENT_V1_COUNT = "EVENT_V1";
    static final String JSON_PARAM_EVENT_V3_COUNT = "EVENT_V3";
    public static final String JSON_PARAM_IMPRESSION_COUNT = "IMPRESSION";
    static final String JSON_PARAM_LAUNCH_COUNT = "LAUNCH";
    static final String JSON_PARAM_MISC_COUNT = "MISC";
    static final String JSON_PARAM_PAGE_COUNT = "PAGE";
    static final String JSON_PARAM_TERMINATE_COUNT = "TERMINATE";
    private static final String KEY_HEADER = "header";
    static final String KEY_IMPRESSION = "item_impression";
    private static final String KEY_LAUNCH = "launch";
    private static final String KEY_LAUNCH_FROM = "launch_from";
    private static final String KEY_MISC = "log_data";
    private static final String KEY_PAGES = "activites";
    private static final String KEY_REQUEST_FROM = "request_from";
    private static final String KEY_TERMINATE = "terminate";
    private static final String KEY_V1 = "event";
    private static final String KEY_V3 = "event_v3";
    public static final int REQUEST_FROM_BACKGROUND_SESSION_START = 9;
    public static final int REQUEST_FROM_BACKGROUND_TIMER = 6;
    public static final int REQUEST_FROM_EMPTY = 0;
    public static final int REQUEST_FROM_EVENT_SIZE_OVERFLOW = 5;
    public static final int REQUEST_FROM_FLUSH = 4;
    public static final int REQUEST_FROM_FORGROUND_SESSION_END = 3;
    public static final int REQUEST_FROM_FORGROUND_SESSION_START = 1;
    public static final int REQUEST_FROM_HUNGER_REPORT = 12;
    public static final int REQUEST_FROM_OLD_APPLOG_DATA = 11;
    public static final int REQUEST_FROM_REAL_TIME = 8;
    public static final int REQUEST_FROM_START_WITH_DID = 7;
    public static final int REQUEST_FROM_SWITCH_UUID = 10;
    public static final int REQUEST_FROM_TIMER = 2;
    static final String TABLE = "pack";
    public byte[] data;
    public String encodeHeaders;
    public int encodeType;
    private String eventLocalIds;
    private int eventMiscCount;
    private String eventStainedEvents;
    private int eventV1Count;
    private int eventV3Count;
    int fail;
    public int failHttpCode;
    private int impressionCount;
    private String isolateKey;
    private String isolateKeyValue;
    private int launchCount;
    JSONArray mEventMiscs;
    JSONArray mEventV3s;
    JSONArray mEvents;
    private JSONObject mHeader;
    private JSONArray mImpression;
    private String mIvEncryptLogResp;
    private String mKeyEncryptLogResp;
    Launch mLaunch;
    long mMaxEventId;
    long mMaxEventV3Id;
    long mMaxMiscId;
    JSONArray mPages;
    private int mRequestFrom = 0;
    Terminate mTerm;
    private String mTerminateJsonStr;
    private JSONObject migrateValue;
    private EventPriorityItem priorityItem;
    private int terminateCount;
    private JSONArray terminateJsonArray;

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return TABLE;
    }

    public static Pack fromMigrateValue(String str, JSONObject jSONObject, long j, JSONObject jSONObject2) {
        Pack pack = new Pack();
        pack.setTs(j);
        pack.setAppId(str);
        pack.setHeader(jSONObject);
        pack.setMigrateValue(jSONObject2);
        return pack;
    }

    public static Pack fromTerminateArray(String str, JSONObject jSONObject, JSONArray jSONArray, int i) {
        Pack pack = new Pack();
        pack.setTs(0L);
        pack.setAppId(str);
        pack.setHeader(jSONObject);
        pack.setRequestFrom(i);
        pack.setTerminateJsonArray(jSONArray);
        return pack;
    }

    public static Pack realTimePack(AppLogInstance appLogInstance, List<BaseData> list, JSONObject jSONObject, EventPriorityItem eventPriorityItem) {
        Pack pack = new Pack();
        try {
            JSONArray[] jSONArrayArr = {null, new JSONArray(), null};
            long[] jArr = new long[3];
            Iterator<BaseData> it = list.iterator();
            while (it.hasNext()) {
                jSONArrayArr[1].put(it.next().toPackJson());
            }
            pack.setData(appLogInstance.getAppId(), jSONObject, null, null, null, jSONArrayArr, jArr, null, eventPriorityItem, 8);
            pack.toBytes();
            sendRealtimeEvents2Devtools(appLogInstance.getAppId(), list);
        } catch (Throwable th) {
            appLogInstance.getLogger().error(4, "pack real time failed", th, new Object[0]);
        }
        return pack;
    }

    public void setData(String str, JSONObject jSONObject, Launch launch, Terminate terminate, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, JSONArray jSONArray2, EventPriorityItem eventPriorityItem, int i) {
        setTs(0L);
        this.mHeader = jSONObject;
        this.mLaunch = launch;
        this.mTerm = terminate;
        this.mPages = jSONArray;
        this.mEvents = jSONArrayArr[0];
        this.mMaxEventId = jArr[0];
        this.mEventV3s = jSONArrayArr[1];
        this.mMaxEventV3Id = jArr[1];
        this.mEventMiscs = jSONArrayArr[2];
        this.mMaxMiscId = jArr[2];
        this.mImpression = jSONArray2;
        this.priorityItem = eventPriorityItem;
        if (eventPriorityItem != null) {
            this.priority = eventPriorityItem.getPriority();
        } else {
            this.priority = -1;
        }
        this.mRequestFrom = i;
        this.appId = str;
        this.mTerminateJsonStr = null;
        this.encodeType = 0;
        this.encodeHeaders = null;
        this.mKeyEncryptLogResp = null;
        this.mIvEncryptLogResp = null;
        this.eventLocalIds = null;
        this.eventStainedEvents = null;
        this.isolateKey = null;
        this.isolateKeyValue = null;
        this.migrateValue = null;
        this.fail = 0;
        this.data = null;
        this.launchCount = this.mLaunch != null ? 1 : 0;
        this.terminateCount = this.mTerm == null ? 0 : 1;
        JSONArray jSONArray3 = this.mEvents;
        this.eventV1Count = jSONArray3 != null ? jSONArray3.length() : 0;
        JSONArray jSONArray4 = this.mEventV3s;
        this.eventV3Count = jSONArray4 != null ? jSONArray4.length() : 0;
        JSONArray jSONArray5 = this.mEventMiscs;
        this.eventMiscCount = jSONArray5 != null ? jSONArray5.length() : 0;
        JSONArray jSONArray6 = this.mImpression;
        this.impressionCount = jSONArray6 != null ? jSONArray6.length() : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        return Arrays.asList("_id", "integer primary key autoincrement", Api.KEY_LOCAL_TIME_MS, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_DATA, "blob", "session_id", "varchar", COL_FAIL, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_EVENT_COUNT, "varchar", "key", "varchar", "iv", "varchar", COL_DATA_JSON, "text", "_app_id", "varchar", COL_ENCODE_TYPE, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_ENCODE_HEADERS, "varchar", "priority", WsChannelMultiProcessSharedProvider.INT_TYPE, Api.COL_FORWARD, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_EVENT_LOCAL_IDS, "varchar", COL_ISOLATE_KEY, "varchar", COL_ISOLATE_KEY_VALUE, "varchar", COL_LAUNCH_COUNT, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_TERMINATE_COUNT, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_EVENT_V1_COUNT, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_EVENT_V3_COUNT, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_EVENT_MISC_COUNT, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_IMPRESSION_COUNT, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_EVENT_SENTRY_STAINED_EVENTS, "varchar");
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        this.dbId = cursor.getLong(0);
        this.f80ts = cursor.getLong(1);
        this.data = cursor.getBlob(2);
        this.sid = cursor.getString(3);
        this.fail = cursor.getInt(4);
        cursor.getString(5);
        this.mKeyEncryptLogResp = cursor.getString(6);
        this.mIvEncryptLogResp = cursor.getString(7);
        this.mTerminateJsonStr = cursor.getString(8);
        this.appId = cursor.getString(9);
        this.encodeType = cursor.getInt(10);
        this.encodeHeaders = cursor.getString(11);
        this.priority = cursor.getInt(12);
        this.forward = cursor.getInt(13);
        this.eventLocalIds = cursor.getString(14);
        this.isolateKey = cursor.getString(15);
        this.isolateKeyValue = cursor.getString(16);
        this.launchCount = cursor.getInt(17);
        this.terminateCount = cursor.getInt(18);
        this.eventV1Count = cursor.getInt(19);
        this.eventV3Count = cursor.getInt(20);
        this.eventMiscCount = cursor.getInt(21);
        this.impressionCount = cursor.getInt(22);
        this.eventStainedEvents = cursor.getString(23);
        this.mHeader = null;
        this.mLaunch = null;
        this.mTerm = null;
        this.mPages = null;
        this.mEvents = null;
        this.mEventV3s = null;
        this.mEventMiscs = null;
        this.mImpression = null;
        return 24;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        try {
            contentValues.put(Api.KEY_LOCAL_TIME_MS, Long.valueOf(this.f80ts));
            contentValues.put(COL_DATA, toBytes());
            contentValues.put("session_id", this.sid);
            contentValues.put("key", this.mKeyEncryptLogResp);
            contentValues.put("iv", this.mIvEncryptLogResp);
            contentValues.put(COL_ENCODE_TYPE, Integer.valueOf(this.encodeType));
            contentValues.put(COL_ENCODE_HEADERS, this.encodeHeaders);
            contentValues.put(COL_DATA_JSON, this.mTerminateJsonStr);
            contentValues.put("_app_id", this.appId);
            contentValues.put("priority", Integer.valueOf(this.priority));
            contentValues.put(Api.COL_FORWARD, Integer.valueOf(this.forward));
            contentValues.put(COL_EVENT_LOCAL_IDS, this.eventLocalIds);
            contentValues.put(COL_ISOLATE_KEY, this.isolateKey);
            contentValues.put(COL_ISOLATE_KEY_VALUE, this.isolateKeyValue);
            contentValues.put(COL_LAUNCH_COUNT, Integer.valueOf(this.launchCount));
            contentValues.put(COL_TERMINATE_COUNT, Integer.valueOf(this.terminateCount));
            contentValues.put(COL_EVENT_V1_COUNT, Integer.valueOf(this.eventV1Count));
            contentValues.put(COL_EVENT_V3_COUNT, Integer.valueOf(this.eventV3Count));
            contentValues.put(COL_EVENT_MISC_COUNT, Integer.valueOf(this.eventMiscCount));
            contentValues.put(COL_IMPRESSION_COUNT, Integer.valueOf(this.impressionCount));
            contentValues.put(COL_EVENT_SENTRY_STAINED_EVENTS, this.eventStainedEvents);
        } catch (Throwable th) {
            getLogger().error(5, "write pack to db failed", th, new Object[0]);
        }
    }

    public byte[] toBytes() {
        try {
            return toBytes(toPackJson().toString());
        } catch (OutOfMemoryError unused) {
            AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(this.appId);
            if (instanceByAppId != null) {
                instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.MEM_ERROR_COUNT);
            }
            recordPackDetailLost();
            return null;
        }
    }

    public byte[] toBytes(String str) {
        AppLogInstance instanceByAppId;
        this.data = null;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str) && AppLogHelper.hasInstanceByAppId(this.appId) && (instanceByAppId = AppLogHelper.getInstanceByAppId(this.appId)) != null) {
            try {
                byte[] bytes = str.getBytes(UrlUtils.UTF_8);
                this.data = bytes;
                if (bytes != null && bytes.length > 0) {
                    if (instanceByAppId.getLogCompressor() != null) {
                        try {
                            CompressResult compress = instanceByAppId.getLogCompressor().compress(this.data);
                            this.data = compress.getData();
                            this.encodeType = compress.getEncodeType();
                            hashMap.putAll(compress.getHeaders());
                        } catch (Throwable th) {
                            getLogger().error(4, this.loggerTags, "log compress toBytes failed", th, new Object[0]);
                            instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.COMPRESS_ERROR_COUNT);
                        }
                    }
                    if (instanceByAppId.getEncryptAndCompress()) {
                        this.data = instanceByAppId.getApi().getEncryptUtils().encrypt(this.data);
                        hashMap.remove("Content-Encoding");
                        hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
                    }
                }
            } catch (Throwable th2) {
                getLogger().error(4, this.loggerTags, "toBytes failed", th2, new Object[0]);
                instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
            }
        }
        this.encodeHeaders = Utils.map2JsonString(hashMap);
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeIpc(JSONObject jSONObject) {
        getLogger().error(4, this.loggerTags, "write ipc not implemented", new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.bytedance.applog.priority.PriorityWrapper] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.applog.server.Api] */
    /* JADX WARN: Type inference failed for: r10v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v18, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v38, types: [org.json.JSONObject, java.lang.Object] */
    @Override // com.bytedance.applog.store.BaseData
    protected JSONObject writePack() throws JSONException {
        String str;
        AppLogInstance appLogInstance;
        ?? r5;
        String str2;
        String str3;
        AppLogInstance appLogInstance2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        JSONObject jSONObject = this.migrateValue;
        String str11 = "iv";
        if (jSONObject != null) {
            this.mKeyEncryptLogResp = jSONObject.optString("key");
            this.mIvEncryptLogResp = this.migrateValue.optString("iv");
            return this.migrateValue;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(this.appId);
        ?? jSONObject2 = new JSONObject();
        jSONObject2.put("magic_tag", "ss_app_log");
        jSONObject2.put("header", this.mHeader);
        if (instanceByAppId != null && instanceByAppId.getApi().mTimeSync != null) {
            jSONObject2.put(Api.KEY_TIME_SYNC, instanceByAppId.getApi().mTimeSync);
        }
        jSONObject2.put(Api.KEY_GEN_TIME, System.currentTimeMillis());
        Launch launch = this.mLaunch;
        this.launchCount = launch != null ? 1 : 0;
        if (launch != null) {
            if (launch.eventId > 0) {
                hashSet.add(Long.valueOf(this.mLaunch.eventId));
            }
            if (this.mLaunch.sentryStained > 0) {
                arrayList.add(new StageEventBasic("launch", String.valueOf(this.mLaunch.monitorId), this.mLaunch.f80ts, StageEventType.LAUNCH));
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.mLaunch.toPackJson());
            jSONObject2.put("launch", jSONArray);
        }
        Terminate terminate = this.mTerm;
        this.terminateCount = terminate != null ? 1 : 0;
        String str12 = "";
        if (terminate != null) {
            if (terminate.eventId > 0) {
                hashSet.add(Long.valueOf(this.mTerm.eventId));
            }
            if (this.mTerm.sentryStained > 0) {
                arrayList.add(new StageEventBasic("terminate", String.valueOf(this.mTerm.monitorId), this.mTerm.f80ts, StageEventType.TERMINATE));
            }
            ?? packJson = this.mTerm.toPackJson();
            ?? jSONObject3 = new JSONObject();
            jSONObject3.put("terminate", packJson);
            this.mTerminateJsonStr = jSONObject3.toString();
            JSONArray jSONArray2 = this.mPages;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i = 0;
            while (i < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject4 = new JSONObject(new JSONObject(this.mPages.optString(i)).optString("params"));
                jSONArray4.put(0, jSONObject4.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject4.optInt("duration", 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                i++;
                str11 = str11;
            }
            str = str11;
            if (length > 0) {
                packJson.put("activites", jSONArray3);
            }
            if (instanceByAppId != null && instanceByAppId.getLaunchFrom() > 0) {
                packJson.put("launch_from", instanceByAppId.getLaunchFrom());
                instanceByAppId.setLaunchFrom(0);
            }
            ?? jSONArray5 = new JSONArray();
            jSONArray5.put(packJson);
            jSONObject2.put("terminate", jSONArray5);
        } else {
            str = "iv";
        }
        JSONArray jSONArray6 = this.terminateJsonArray;
        if (jSONArray6 != null && jSONArray6.length() > 0) {
            JSONArray optJSONArray = jSONObject2.optJSONArray("terminate");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            for (int i2 = 0; i2 < this.terminateJsonArray.length(); i2++) {
                optJSONArray.put(this.terminateJsonArray.get(i2));
            }
            this.terminateCount += this.terminateJsonArray.length();
            jSONObject2.put("terminate", optJSONArray);
        }
        JSONArray jSONArray7 = this.mEvents;
        int length2 = jSONArray7 != null ? jSONArray7.length() : 0;
        this.eventV1Count = length2;
        String str13 = "event";
        String str14 = "event_stained";
        String str15 = "event_id";
        if (length2 > 0) {
            JSONArray jSONArray8 = new JSONArray();
            int i3 = 0;
            JSONObject jSONObject5 = jSONObject2;
            while (i3 < this.mEvents.length()) {
                JSONObject jSONObject6 = this.mEvents.getJSONObject(i3);
                AppLogInstance appLogInstance3 = instanceByAppId;
                JSONObject jSONObject7 = jSONObject5;
                long optLong = jSONObject6.optLong(str15, 0L);
                if (optLong > 0) {
                    hashSet.add(Long.valueOf(optLong));
                }
                if (jSONObject6.optInt(str14, 0) > 0) {
                    str9 = str14;
                    str10 = str15;
                    arrayList.add(new StageEventBasic(jSONObject6.optString(Api.COL_TAG, ""), String.valueOf(jSONObject6.optLong(SqliteDatabaseKt.colMonitorId, 0L)), jSONObject6.optLong(Api.KEY_LOCAL_TIME_MS, 0L), StageEventType.V1_EVENT));
                } else {
                    str9 = str14;
                    str10 = str15;
                }
                jSONArray8.put(jSONObject6);
                i3++;
                str14 = str9;
                instanceByAppId = appLogInstance3;
                jSONObject5 = jSONObject7;
                str15 = str10;
            }
            appLogInstance = instanceByAppId;
            JSONObject jSONObject8 = jSONObject5;
            str2 = str14;
            str3 = str15;
            jSONObject8.put("event", jSONArray8);
            r5 = jSONObject8;
        } else {
            appLogInstance = instanceByAppId;
            r5 = jSONObject2;
            str2 = "event_stained";
            str3 = "event_id";
        }
        JSONArray jSONArray9 = this.mEventV3s;
        int length3 = jSONArray9 != null ? jSONArray9.length() : 0;
        this.eventV3Count = length3;
        if (length3 > 0) {
            JSONArray jSONArray10 = new JSONArray();
            int i4 = 0;
            while (i4 < this.mEventV3s.length()) {
                JSONObject jSONObject9 = this.mEventV3s.getJSONObject(i4);
                AppLogInstance appLogInstance4 = appLogInstance;
                String str16 = str3;
                long optLong2 = jSONObject9.optLong(str16, 0L);
                if (optLong2 > 0) {
                    hashSet.add(Long.valueOf(optLong2));
                }
                if (jSONObject9.optInt(str2, 0) > 0) {
                    str7 = str13;
                    str8 = str12;
                    arrayList.add(new StageEventBasic(jSONObject9.optString(str13, str12), String.valueOf(jSONObject9.optLong(SqliteDatabaseKt.colMonitorId, 0L)), jSONObject9.optLong(Api.KEY_LOCAL_TIME_MS, 0L), StageEventType.V3_EVENT));
                } else {
                    str7 = str13;
                    str8 = str12;
                }
                jSONArray10.put(jSONObject9);
                i4++;
                str12 = str8;
                appLogInstance = appLogInstance4;
                str13 = str7;
                str3 = str16;
            }
            appLogInstance2 = appLogInstance;
            str4 = str3;
            str5 = str12;
            r5.put("event_v3", jSONArray10);
        } else {
            appLogInstance2 = appLogInstance;
            str4 = str3;
            str5 = "";
        }
        JSONArray jSONArray11 = this.mEventMiscs;
        int length4 = jSONArray11 != null ? jSONArray11.length() : 0;
        this.eventMiscCount = length4;
        if (length4 > 0) {
            JSONArray jSONArray12 = new JSONArray();
            int i5 = 0;
            while (i5 < this.mEventMiscs.length()) {
                JSONObject jSONObject10 = this.mEventMiscs.getJSONObject(i5);
                long optLong3 = jSONObject10.optLong(str4, 0L);
                if (optLong3 > 0) {
                    hashSet.add(Long.valueOf(optLong3));
                }
                if (jSONObject10.optInt(str2, 0) > 0) {
                    str6 = str2;
                    arrayList.add(new StageEventBasic(jSONObject10.optString("log_type", str5), String.valueOf(jSONObject10.optLong(SqliteDatabaseKt.colMonitorId, 0L)), jSONObject10.optLong(Api.KEY_LOCAL_TIME_MS, 0L), StageEventType.LOG_DATA));
                } else {
                    str6 = str2;
                }
                jSONArray12.put(jSONObject10);
                i5++;
                str2 = str6;
            }
            r5.put("log_data", jSONArray12);
        }
        JSONArray jSONArray13 = this.mImpression;
        int length5 = jSONArray13 != null ? jSONArray13.length() : 0;
        this.impressionCount = length5;
        if (length5 > 0) {
            r5.put("item_impression", this.mImpression);
        }
        this.eventLocalIds = generateEventIdString(hashSet);
        this.eventStainedEvents = generateStainedEventsString(arrayList);
        if (appLogInstance2 != null) {
            appLogInstance2.getApi().fillKeyIvForEncryptResp(r5, true);
            ?? jSONObject11 = new JSONObject();
            jSONObject11.put(KEY_REQUEST_FROM, this.mRequestFrom);
            if (appLogInstance2.getEventSamplingCapability() > 0) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put(EventSampling.KEY_SAMPLING_CAPABILITY, appLogInstance2.getEventSamplingCapability());
                SamplingFilter samplingFilter = appLogInstance2.getSamplingFilter();
                if (samplingFilter != null && samplingFilter.getEventSampling() != null) {
                    if (appLogInstance2.getEventSamplingCapability() == samplingFilter.getEventSampling().getCapability()) {
                        jSONObject12.put("version", samplingFilter.getEventSampling().getSamplingVersion());
                    }
                    jSONObject12.put(EventSampling.KEY_CONFIG_IDS, samplingFilter.getEventSampling().getConfigIdArray());
                }
                jSONObject11.put(EventSampling.KEY_SAMPLING, jSONObject12);
            }
            try {
                JSONObject expectedBatchInterval = appLogInstance2.getExpectedBatchInterval();
                if (expectedBatchInterval != null) {
                    jSONObject11.put(Api.KEY_EXPECTED_BATCH_INTERVAL, expectedBatchInterval);
                }
            } catch (Throwable th) {
                appLogInstance2.getLogger().error("build expected batch interval to pack failed", th, new Object[0]);
            }
            try {
                JSONObject logback = appLogInstance2.getLogback();
                if (logback != null) {
                    jSONObject11.put(Api.KEY_LOG_BACK, logback);
                }
            } catch (Throwable th2) {
                appLogInstance2.getLogger().error("build logback to pack failed", th2, new Object[0]);
            }
            if (appLogInstance2.isEnableEventPriority()) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("enable", 1);
                if (appLogInstance2.getEventPriority() != null) {
                    jSONObject13.put("version", appLogInstance2.getEventPriority().getVersion());
                }
                jSONObject13.put("value", this.priority);
                jSONObject11.put(EventPriorityLoader.KEY_APPLOG_PRIORITY, jSONObject13);
            }
            if (appLogInstance2.isEventForwardEnabled()) {
                try {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("enable", 1);
                    if (appLogInstance2.getEventForward() != null) {
                        jSONObject14.put("version", appLogInstance2.getEventForward().getVersion());
                    }
                    jSONObject11.put(EventForwardLoader.KEY_APPLOG_FORWARD, jSONObject14);
                } catch (Throwable th3) {
                    appLogInstance2.getLogger().error("build forward to pack failed", th3, new Object[0]);
                }
            }
            boolean isStageForAllEvents = appLogInstance2.getMonitorHelper().isStageForAllEvents();
            ?? r0 = isStageForAllEvents;
            if (appLogInstance2.getMonitorHelper().isDebugMode()) {
                r0 = (isStageForAllEvents ? 1 : 0) | 2;
            }
            if (r0 > 0) {
                jSONObject11.put(MonitorConfigManager.KEY_OPTIONS_SENTRY_STAINED, r0);
            }
            if (appLogInstance2.getPriorityWrapper() != null) {
                appLogInstance2.getPriorityWrapper().addDefaultPriorityOptions(jSONObject11);
            }
            r5.put(Api.KEY_OPTIONS, jSONObject11);
        }
        this.mKeyEncryptLogResp = r5.optString("key");
        this.mIvEncryptLogResp = r5.optString(str);
        getLogger().debug(4, "pack -> ts:{}, launch:{}, terminate:{}, v1:{}, v3:{}, misc:{}, impression:{}", Long.valueOf(this.f80ts), this.mLaunch, this.mTerm, Integer.valueOf(this.eventV1Count), Integer.valueOf(this.eventV3Count), Integer.valueOf(this.eventMiscCount), Integer.valueOf(this.impressionCount));
        return r5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        getLogger().error(4, this.loggerTags, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return String.valueOf(this.dbId);
    }

    public String[] getPackKeyAndIv() {
        return new String[]{this.mKeyEncryptLogResp, this.mIvEncryptLogResp};
    }

    public Set<Long> getEventLocalIds() {
        return parseIdsFromSetString(this.eventLocalIds);
    }

    public List<StageEventBasic> getEventStainedEvents() {
        return parseStageEventListFromString(this.eventStainedEvents);
    }

    private Set<Long> parseIdsFromSetString(String str) {
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        try {
            int indexOf = str.indexOf(":");
            if (indexOf < 0) {
                hashSet.add(Long.valueOf(Long.parseLong(str)));
            } else {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                hashSet.add(Long.valueOf(parseLong));
                for (String str2 : str.substring(indexOf + 1).split(",")) {
                    parseLong += Long.parseLong(str2);
                    hashSet.add(Long.valueOf(parseLong));
                }
            }
        } catch (Throwable th) {
            getLogger().error("Cannot parse set ids:{}!", str, th);
        }
        return hashSet;
    }

    private String generateEventIdString(Set<Long> set) {
        if (set.isEmpty()) {
            return "";
        }
        Long[] lArr = (Long[]) set.toArray(new Long[0]);
        Arrays.sort(lArr);
        StringBuilder sb = new StringBuilder();
        sb.append(lArr[0]);
        if (lArr.length > 1) {
            sb.append(":");
            for (int i = 1; i < lArr.length; i++) {
                sb.append(lArr[i].longValue() - lArr[i - 1].longValue());
                if (i != lArr.length - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private String generateStainedEventsString(List<StageEventBasic> list) {
        JSONArray jSONArray = new JSONArray();
        if (!list.isEmpty()) {
            Iterator<StageEventBasic> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray.toString();
    }

    private List<StageEventBasic> parseStageEventListFromString(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(new StageEventBasic(jSONArray.optJSONObject(i)));
            }
        } catch (Throwable th) {
            getLogger().error("Cannot parse stage events:{}!", str, th);
        }
        return arrayList;
    }

    public void recordPackReportedWithNewMonitor(MonitorV3Helper monitorV3Helper, boolean z) {
        if (this.launchCount > 0) {
            monitorV3Helper.increaseStats(z ? StatsCountKeys.REPORT_SUCCESS_LAUNCH_COUNT : StatsCountKeys.REPORT_FAILED_LAUNCH_COUNT, this.launchCount);
        }
        if (this.terminateCount > 0) {
            monitorV3Helper.increaseStats(z ? StatsCountKeys.REPORT_SUCCESS_TERMINATE_COUNT : StatsCountKeys.REPORT_FAILED_TERMINATE_COUNT, this.terminateCount);
        }
        int i = this.eventV1Count + this.eventV3Count + this.eventMiscCount;
        if (i > 0) {
            monitorV3Helper.increaseStats(z ? StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT : StatsCountKeys.REPORT_FAILED_EVENT_COUNT, i);
        }
    }

    public boolean interceptExpiredTerminate(Session session) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(this.mTerminateJsonStr)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(this.mTerminateJsonStr);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.isNull("terminate") || (optJSONObject = jSONObject.optJSONObject("terminate")) == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = DATE_FORMAT_LAUNCH;
        String format = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        if (format.equals(simpleDateFormat.format(Long.valueOf(session.getLatestForgroundSessionTime())))) {
            return false;
        }
        long optLong = optJSONObject.optLong(Api.KEY_LOCAL_TIME_MS, -1L);
        return (optLong < 0 || simpleDateFormat.format(new Date(optLong)).startsWith(format) || format.equals(simpleDateFormat.format(new Date(optJSONObject.optLong("stop_timestamp") * 1000)))) ? false : true;
    }

    public boolean hasLaunch() {
        return this.launchCount > 0;
    }

    public boolean hasTerminate() {
        return this.terminateCount > 0;
    }

    public void recordPackDetailLost() {
        AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(this.appId);
        if (instanceByAppId == null) {
            return;
        }
        if (this.launchCount > 0) {
            instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.CLEAN_UP_LAUNCH_COUNT, this.launchCount);
        }
        if (this.terminateCount > 0) {
            instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.CLEAN_UP_TERMINATE_COUNT, this.terminateCount);
        }
        int i = this.eventV1Count + this.eventV3Count + this.eventMiscCount;
        if (i > 0) {
            instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.CLEAN_UP_EVENT_COUNT, i);
        }
    }

    public DataIsolateKey getIsolateKey() {
        if (!Utils.isNotEmpty(this.isolateKey)) {
            return null;
        }
        try {
            return DataIsolateKey.fromKey(this.isolateKey);
        } catch (Throwable th) {
            getLogger().error("Cannot parse isolate key:{}!", this.isolateKey, th);
            return null;
        }
    }

    public String getIsolateKeyValue() {
        return this.isolateKeyValue;
    }

    public Collection<Pack> splitByIsolateKey(DataIsolateKey dataIsolateKey) {
        HashMap hashMap = new HashMap();
        for (int i = 0; !JsonUtils.isJsonArrayEmpty(this.mEvents) && i < this.mEvents.length(); i++) {
            JSONObject optJSONObject = this.mEvents.optJSONObject(i);
            String isolateKeyValue = DataIsolateUtils.getIsolateKeyValue(dataIsolateKey, optJSONObject, "");
            if (!hashMap.containsKey(isolateKeyValue)) {
                hashMap.put(isolateKeyValue, cloneNewPackByIsolateKey(dataIsolateKey, isolateKeyValue));
            }
            ((Pack) hashMap.get(isolateKeyValue)).mEvents.put(optJSONObject);
        }
        for (int i2 = 0; !JsonUtils.isJsonArrayEmpty(this.mEventV3s) && i2 < this.mEventV3s.length(); i2++) {
            JSONObject optJSONObject2 = this.mEventV3s.optJSONObject(i2);
            String isolateKeyValue2 = DataIsolateUtils.getIsolateKeyValue(dataIsolateKey, optJSONObject2, "");
            if (!hashMap.containsKey(isolateKeyValue2)) {
                hashMap.put(isolateKeyValue2, cloneNewPackByIsolateKey(dataIsolateKey, isolateKeyValue2));
            }
            ((Pack) hashMap.get(isolateKeyValue2)).mEventV3s.put(optJSONObject2);
        }
        for (int i3 = 0; !JsonUtils.isJsonArrayEmpty(this.mEventMiscs) && i3 < this.mEventMiscs.length(); i3++) {
            JSONObject optJSONObject3 = this.mEventMiscs.optJSONObject(i3);
            String isolateKeyValue3 = DataIsolateUtils.getIsolateKeyValue(dataIsolateKey, optJSONObject3, "");
            if (!hashMap.containsKey(isolateKeyValue3)) {
                hashMap.put(isolateKeyValue3, cloneNewPackByIsolateKey(dataIsolateKey, isolateKeyValue3));
            }
            ((Pack) hashMap.get(isolateKeyValue3)).mEventMiscs.put(optJSONObject3);
        }
        Launch launch = this.mLaunch;
        if (launch != null) {
            String isolateKeyValue4 = DataIsolateUtils.getIsolateKeyValue(dataIsolateKey, launch, "");
            if (!hashMap.containsKey(isolateKeyValue4)) {
                hashMap.put(isolateKeyValue4, cloneNewPackByIsolateKey(dataIsolateKey, isolateKeyValue4));
            }
            ((Pack) hashMap.get(isolateKeyValue4)).mLaunch = this.mLaunch;
        }
        if (this.mTerm != null) {
            if (hashMap.isEmpty()) {
                String isolateKeyValue5 = DataIsolateUtils.getIsolateKeyValue(dataIsolateKey, this.mTerm, "");
                hashMap.put(isolateKeyValue5, cloneNewPackByIsolateKey(dataIsolateKey, isolateKeyValue5));
            }
            Iterator it = hashMap.keySet().iterator();
            if (it.hasNext()) {
                String str = (String) it.next();
                ((Pack) hashMap.get(str)).mTerm = this.mTerm;
                if (!JsonUtils.isJsonArrayEmpty(this.mPages)) {
                    ((Pack) hashMap.get(str)).mPages = this.mPages;
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        if (hashMap.size() == 1) {
            this.isolateKey = dataIsolateKey.getKey();
            this.isolateKeyValue = ((String[]) hashMap.keySet().toArray(new String[0]))[0];
            return null;
        }
        return hashMap.values();
    }

    private Pack cloneNewPackByIsolateKey(DataIsolateKey dataIsolateKey, String str) {
        Pack pack = new Pack();
        String str2 = this.appId;
        JSONObject jSONObject = this.mHeader;
        JSONArray jSONArray = JsonUtils.isJsonArrayEmpty(this.mPages) ? null : new JSONArray();
        JSONArray[] jSONArrayArr = new JSONArray[3];
        jSONArrayArr[0] = JsonUtils.isJsonArrayEmpty(this.mEvents) ? null : new JSONArray();
        jSONArrayArr[1] = JsonUtils.isJsonArrayEmpty(this.mEventV3s) ? null : new JSONArray();
        jSONArrayArr[2] = JsonUtils.isJsonArrayEmpty(this.mEventMiscs) ? null : new JSONArray();
        pack.setData(str2, jSONObject, null, null, jSONArray, jSONArrayArr, new long[]{this.mMaxEventId, this.mMaxEventV3Id, this.mMaxMiscId}, this.mImpression, this.priorityItem, this.mRequestFrom);
        pack.sid = this.sid;
        pack.isolateKey = dataIsolateKey.getKey();
        pack.isolateKeyValue = str;
        return pack;
    }

    public List<Pack> splitBySizeLimited(long j) {
        ArrayList arrayList = new ArrayList();
        if (toPackJson().toString().length() < j) {
            arrayList.add(this);
            return arrayList;
        }
        long length = this.mHeader != null ? r2.toString().length() : 0L;
        Pack pack = new Pack();
        pack.setData(this.appId, this.mHeader, this.mLaunch, this.mTerm, this.mPages, new JSONArray[]{null, null, null}, new long[]{this.mMaxEventId, this.mMaxEventV3Id, this.mMaxMiscId}, this.mImpression, this.priorityItem, this.mRequestFrom);
        pack.sid = this.sid;
        pack.isolateKey = this.isolateKey;
        pack.isolateKeyValue = this.isolateKeyValue;
        arrayList.add(pack);
        long j2 = j - length;
        long length2 = this.mLaunch != null ? j2 - r5.toPackJson().toString().length() : j2;
        if (this.mTerm != null) {
            length2 -= r7.toPackJson().toString().length();
        }
        if (this.mImpression != null) {
            length2 -= r7.toString().length();
        }
        for (int i = 0; !JsonUtils.isJsonArrayEmpty(this.mEvents) && i < this.mEvents.length(); i++) {
            JSONObject optJSONObject = this.mEvents.optJSONObject(i);
            if (optJSONObject != null) {
                long length3 = optJSONObject.toString().length();
                length2 -= length3;
                if (length2 > 0) {
                    if (pack.mEvents == null) {
                        pack.mEvents = new JSONArray();
                    }
                    pack.mEvents.put(optJSONObject);
                } else {
                    pack = forkEmptyPack();
                    arrayList.add(pack);
                    JSONArray jSONArray = new JSONArray();
                    pack.mEvents = jSONArray;
                    jSONArray.put(optJSONObject);
                    length2 = j2 - length3;
                }
            }
        }
        for (int i2 = 0; !JsonUtils.isJsonArrayEmpty(this.mEventV3s) && i2 < this.mEventV3s.length(); i2++) {
            JSONObject optJSONObject2 = this.mEventV3s.optJSONObject(i2);
            if (optJSONObject2 != null) {
                long length4 = optJSONObject2.toString().length();
                length2 -= length4;
                if (length2 > 0) {
                    if (pack.mEventV3s == null) {
                        pack.mEventV3s = new JSONArray();
                    }
                    pack.mEventV3s.put(optJSONObject2);
                } else {
                    pack = forkEmptyPack();
                    arrayList.add(pack);
                    JSONArray jSONArray2 = new JSONArray();
                    pack.mEventV3s = jSONArray2;
                    jSONArray2.put(optJSONObject2);
                    length2 = j2 - length4;
                }
            }
        }
        for (int i3 = 0; !JsonUtils.isJsonArrayEmpty(this.mEventMiscs) && i3 < this.mEventMiscs.length(); i3++) {
            JSONObject optJSONObject3 = this.mEventMiscs.optJSONObject(i3);
            if (optJSONObject3 != null) {
                long length5 = optJSONObject3.toString().length();
                length2 -= length5;
                if (length2 > 0) {
                    if (pack.mEventMiscs == null) {
                        pack.mEventMiscs = new JSONArray();
                    }
                    pack.mEventMiscs.put(optJSONObject3);
                } else {
                    pack = forkEmptyPack();
                    arrayList.add(pack);
                    JSONArray jSONArray3 = new JSONArray();
                    pack.mEventMiscs = jSONArray3;
                    jSONArray3.put(optJSONObject3);
                    length2 = j2 - length5;
                }
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String toString() {
        return "pack:{id=" + this.dbId + ", ts=" + this.f80ts + ", sid:" + this.sid + ", e3_cnt:" + this.eventV3Count + ", e1_cnt:" + this.eventV1Count + ", l_cnt:" + this.launchCount + ", t_cnt:" + this.terminateCount + ", ipr_cnt:" + this.impressionCount + ", isolate:" + this.isolateKey + "->" + this.isolateKeyValue + "}";
    }

    public boolean isEmpty() {
        return this.mLaunch == null && this.mTerm == null && this.mImpression == null && this.mMaxEventId <= 0 && this.mMaxEventV3Id <= 0 && this.mMaxMiscId <= 0 && this.terminateJsonArray == null && this.migrateValue == null;
    }

    private Pack forkEmptyPack() {
        Pack pack = new Pack();
        pack.setData(this.appId, this.mHeader, null, null, null, new JSONArray[]{new JSONArray(), null, null}, new long[]{this.mMaxEventId, this.mMaxEventV3Id, this.mMaxMiscId}, null, this.priorityItem, this.mRequestFrom);
        pack.sid = this.sid;
        pack.isolateKey = this.isolateKey;
        pack.isolateKeyValue = this.isolateKeyValue;
        return pack;
    }

    private void setMigrateValue(JSONObject jSONObject) {
        this.migrateValue = jSONObject;
    }

    private void setHeader(JSONObject jSONObject) {
        this.mHeader = jSONObject;
    }

    private void setRequestFrom(int i) {
        this.mRequestFrom = i;
    }

    private void setTerminateJsonArray(JSONArray jSONArray) {
        this.terminateJsonArray = jSONArray;
    }

    public int getTotalEventCount() {
        return this.eventV1Count + this.eventV3Count + this.eventMiscCount;
    }

    private static void sendRealtimeEvents2Devtools(final String str, List<BaseData> list) {
        if (LogUtils.isDisabled() || list == null || list.isEmpty()) {
            return;
        }
        final JSONArray jSONArray = new JSONArray();
        for (BaseData baseData : list) {
            if (baseData != null && baseData.eventId > 0) {
                jSONArray.put(baseData.eventId);
            }
        }
        LogUtils.sendJsonFetcher("event_realtime_eid", new EventBus.DataFetcher() { // from class: com.bytedance.applog.store.Pack.1
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("$$APP_ID", str);
                    jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
    }
}
