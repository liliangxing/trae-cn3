package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.collector.PageHolder;
import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.log.AbstractAppLogLogger;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.monitor.p006v3.MonitorV3Utils;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.util.Utils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseData implements Cloneable {
    static final String COL_AB = "ab_sdk_version";
    static final String COL_APP_ID = "_app_id";
    static final String COL_DATE_TIME = "datetime";
    static final String COL_EID = "tea_event_index";
    static final String COL_EVENT_ID = "event_id";
    static final String COL_FORWARD = "forward";
    static final String COL_ID = "_id";
    static final String COL_LOCAL_EVENT_ID = "_local_event_id";
    static final String COL_MONITOR_ID = "monitor_id";
    static final String COL_NT = "nt";
    static final String COL_PRIORITY = "priority";
    static final String COL_SENTRY_STAINED = "event_stained";
    static final String COL_SID = "session_id";
    static final String COL_TS = "local_time_ms";
    static final String COL_UID = "uid";
    static final String COL_USER_ID = "user_id";
    static final String COL_USER_IS_AUTH = "user_is_auth";
    static final String COL_USER_IS_LOGIN = "user_is_login";
    static final String COL_USER_TYPE = "user_type";
    static final String COL_UUID = "user_unique_id";
    private static final String KEY_CLASS = "k_cls";
    public String abSdkVersion;
    protected String appId;
    long dbId;
    public long eid;
    protected List<String> loggerTags;
    String mDT;

    /* renamed from: nt */
    public int f79nt;
    protected PageHolder.PageInfo pageInfo;
    public String sid;

    /* renamed from: ts */
    public long f80ts;
    public long uid;
    public long user_id;
    public String uuid;
    private static final SimpleDateFormat DATE_FORMAT_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private static final AbsSingleton<HashMap<String, BaseData>> ZYGOTES = new AbsSingleton<HashMap<String, BaseData>>() { // from class: com.bytedance.applog.store.BaseData.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.applog.log.AbsSingleton
        public HashMap<String, BaseData> create(Object... objArr) {
            return BaseData.getAllBaseDataObj();
        }
    };
    public int userType = 0;
    public int userIsLogin = 0;
    public int userIsAuth = 0;
    int priority = -1;

    @Deprecated
    int forward = 0;
    public long eventId = 0;
    public long monitorId = 0;
    public int sentryStained = 0;

    public String getContent() {
        return null;
    }

    public abstract String getEventName();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String getTableName();

    protected abstract JSONObject writePack() throws JSONException;

    public BaseData() {
        setTs(0L);
        initEventId();
        this.loggerTags = Collections.singletonList(getTableName());
    }

    public void initEventId() {
        long newMonitorId = MonitorV3Utils.getNewMonitorId();
        this.eventId = newMonitorId;
        this.monitorId = newMonitorId;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setTs(long j) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        this.f80ts = j;
    }

    public void setPageInfo(PageHolder.PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public static HashMap<String, BaseData> getAllBaseDataObj() {
        HashMap<String, BaseData> hashMap = new HashMap<>();
        registerZygote(hashMap, new Page());
        registerZygote(hashMap, new Launch());
        registerZygote(hashMap, new Terminate());
        registerZygote(hashMap, new Pack());
        for (BaseData baseData : getAllEventObj()) {
            registerZygote(hashMap, baseData);
        }
        return hashMap;
    }

    public static BaseData[] getAllEventObj() {
        return new BaseData[]{new Event(), new EventV3(null, null, false, null), new EventMisc(null, "", new JSONObject())};
    }

    private static void registerZygote(HashMap<String, BaseData> hashMap, BaseData baseData) {
        hashMap.put(baseData.getTableName(), baseData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<String> getColumnDef() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", WsChannelMultiProcessSharedProvider.INT_TYPE, "tea_event_index", WsChannelMultiProcessSharedProvider.INT_TYPE, COL_NT, WsChannelMultiProcessSharedProvider.INT_TYPE, "user_id", WsChannelMultiProcessSharedProvider.INT_TYPE, "uid", WsChannelMultiProcessSharedProvider.INT_TYPE, "session_id", "varchar", "user_unique_id", "varchar", "ab_sdk_version", "varchar", "user_type", WsChannelMultiProcessSharedProvider.INT_TYPE, "user_is_login", WsChannelMultiProcessSharedProvider.INT_TYPE, "user_is_auth", WsChannelMultiProcessSharedProvider.INT_TYPE, COL_APP_ID, "varchar", "priority", WsChannelMultiProcessSharedProvider.INT_TYPE, "forward", WsChannelMultiProcessSharedProvider.INT_TYPE, COL_LOCAL_EVENT_ID, "varchar", "monitor_id", WsChannelMultiProcessSharedProvider.INT_TYPE, "event_stained", WsChannelMultiProcessSharedProvider.INT_TYPE);
    }

    public int readDb(Cursor cursor) {
        this.dbId = cursor.getLong(0);
        this.f80ts = cursor.getLong(1);
        this.eid = cursor.getLong(2);
        this.f79nt = cursor.getInt(3);
        this.user_id = cursor.getLong(4);
        this.uid = cursor.getLong(5);
        this.sid = cursor.getString(6);
        this.uuid = cursor.getString(7);
        this.abSdkVersion = cursor.getString(8);
        this.userType = cursor.getInt(9);
        this.userIsLogin = cursor.getInt(10);
        this.userIsAuth = cursor.getInt(11);
        this.appId = cursor.getString(12);
        this.priority = cursor.getInt(13);
        this.forward = cursor.getInt(14);
        String string = cursor.getString(15);
        if (Utils.isNotEmpty(string)) {
            try {
                this.eventId = Long.parseLong(string);
            } catch (Throwable unused) {
            }
        }
        this.monitorId = cursor.getLong(16);
        this.sentryStained = cursor.getInt(17);
        return 18;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeDb(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.f80ts));
        contentValues.put("tea_event_index", Long.valueOf(this.eid));
        contentValues.put(COL_NT, Integer.valueOf(this.f79nt));
        contentValues.put("user_id", Long.valueOf(this.user_id));
        contentValues.put("uid", Long.valueOf(this.uid));
        contentValues.put("session_id", this.sid);
        contentValues.put("user_unique_id", this.uuid);
        contentValues.put("ab_sdk_version", this.abSdkVersion);
        contentValues.put("user_type", Integer.valueOf(this.userType));
        contentValues.put("user_is_login", Integer.valueOf(this.userIsLogin));
        contentValues.put("user_is_auth", Integer.valueOf(this.userIsAuth));
        contentValues.put(COL_APP_ID, this.appId);
        contentValues.put("priority", Integer.valueOf(this.priority));
        contentValues.put("forward", Integer.valueOf(this.forward));
        contentValues.put(COL_LOCAL_EVENT_ID, String.valueOf(this.eventId));
        contentValues.put("monitor_id", Long.valueOf(this.monitorId));
        contentValues.put("event_stained", Integer.valueOf(this.sentryStained));
    }

    public static String formatDateMS(long j) {
        return DATE_FORMAT_MS.format(new Date(j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeIpc(JSONObject jSONObject) throws JSONException {
        jSONObject.put("local_time_ms", this.f80ts);
        jSONObject.put(COL_APP_ID, this.appId);
        jSONObject.put("priority", this.priority);
        jSONObject.put("forward", this.forward);
        jSONObject.put(COL_LOCAL_EVENT_ID, this.eventId);
        jSONObject.put("monitor_id", this.monitorId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseData readIpc(JSONObject jSONObject) {
        this.f80ts = jSONObject.optLong("local_time_ms", 0L);
        this.dbId = 0L;
        this.eid = 0L;
        this.f79nt = 0;
        this.user_id = 0L;
        this.uid = 0L;
        this.sid = null;
        this.uuid = null;
        this.abSdkVersion = null;
        this.userType = 0;
        this.userIsLogin = 0;
        this.userIsAuth = 0;
        this.appId = jSONObject.optString(COL_APP_ID);
        this.priority = jSONObject.optInt("priority", -1);
        this.forward = jSONObject.optInt("forward");
        this.eventId = jSONObject.optLong(COL_LOCAL_EVENT_ID, 0L);
        this.monitorId = jSONObject.optLong("monitor_id", 0L);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ContentValues toValues(ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        writeDb(contentValues);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String createTable() {
        List<String> columnDef = getColumnDef();
        if (columnDef == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(getTableName()).append("(");
        for (int i = 0; i < columnDef.size(); i += 2) {
            sb.append(columnDef.get(i)).append(" ").append(columnDef.get(i + 1)).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public long size() {
        long length = Utils.isNotEmpty(getDetail()) ? 0 + r0.length() : 0L;
        return Utils.isNotEmpty(getContent()) ? length + r0.length() : length;
    }

    public final JSONObject toIpcJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CLASS, getTableName());
            writeIpc(jSONObject);
        } catch (Throwable th) {
            getLogger().error(4, this.loggerTags, "toIpcJson failed", th, new Object[0]);
        }
        return jSONObject;
    }

    public final JSONObject toPackJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            this.mDT = formatDateMS(this.f80ts);
            return writePack();
        } catch (Throwable th) {
            AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(this.appId);
            if (instanceByAppId != null) {
                instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                if (th instanceof JSONException) {
                    instanceByAppId.getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                }
                instanceByAppId.getMonitorHelper().sendError(getTableName() + " to pack json failed", th);
            }
            getLogger().error(4, this.loggerTags, "toPackJson failed", th, new Object[0]);
            return jSONObject;
        }
    }

    public static BaseData fromIpc(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            BaseData baseData = ZYGOTES.get(new Object[0]).get(jSONObject.optString(KEY_CLASS, ""));
            if (baseData == null) {
                LoggerImpl.global().warn(4, "from ipc class not recognized", new Object[0]);
                return null;
            }
            return baseData.m432clone().readIpc(jSONObject);
        } catch (Throwable th) {
            LoggerImpl.global().error(4, "from ipc failed", th, new Object[0]);
            return null;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BaseData m432clone() {
        try {
            BaseData baseData = (BaseData) super.clone();
            baseData.initEventId();
            return baseData;
        } catch (Throwable th) {
            getLogger().error(4, this.loggerTags, "Clone data failed", th, new Object[0]);
            return null;
        }
    }

    public String toString() {
        String tableName = getTableName();
        if (!getClass().getSimpleName().equalsIgnoreCase(tableName)) {
            tableName = tableName + ", " + getClass().getSimpleName();
        }
        String str = this.sid;
        String str2 = "-";
        if (str != null) {
            int indexOf = str.indexOf("-");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            str2 = str;
        }
        return "{" + tableName + ", " + getDetail() + ", " + str2 + ", " + this.f80ts + ", id=" + this.eventId + "}";
    }

    public String getDetail() {
        return "sid:" + this.sid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void fillUserInfo(JSONObject jSONObject) throws JSONException {
        AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(this.appId);
        boolean z = instanceByAppId != null && instanceByAppId.getEnableEventUserId();
        if (z || this.user_id > 0) {
            jSONObject.put("user_id", this.user_id);
        }
        if (z || this.uid > 0) {
            jSONObject.put("uid", this.uid);
        }
        if (z || this.userType > 0) {
            jSONObject.put("user_type", this.userType);
        }
        if (z || this.userIsLogin > 0) {
            jSONObject.put("user_is_login", this.userIsLogin);
        }
        if (z || this.userIsAuth > 0) {
            jSONObject.put("user_is_auth", this.userIsAuth);
        }
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setForward(int i) {
        this.forward = i;
    }

    public int getForward() {
        return this.forward;
    }

    public long getDbId() {
        return this.dbId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IAppLogLogger getLogger() {
        IAppLogLogger logger = AbstractAppLogLogger.getLogger(this.appId);
        return logger != null ? logger : LoggerImpl.global();
    }
}
