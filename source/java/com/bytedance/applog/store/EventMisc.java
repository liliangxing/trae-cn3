package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.batch.PackCalculator;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.server.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventMisc extends BaseData {
    static final String COL_LOG_TYPE = "log_type";
    static final String COL_PARAM = "params";
    static final String TABLE = "event_misc";
    private String logType;
    private String param;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return TABLE;
    }

    public EventMisc(String str, String str2, JSONObject jSONObject) {
        this.logType = str2;
        this.param = jSONObject.toString();
        this.appId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        List<String> columnDef = super.getColumnDef();
        ArrayList arrayList = new ArrayList(columnDef.size());
        arrayList.addAll(columnDef);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        int readDb = super.readDb(cursor);
        int i = readDb + 1;
        this.param = cursor.getString(readDb);
        int i2 = i + 1;
        this.logType = cursor.getString(i);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        super.writeDb(contentValues);
        if (PackOptConfig.packByLengthEnabled) {
            contentValues.put("params", PackCalculator.checkJSONLengthAndReplace(this.appId, StageEventType.LOG_DATA, this.logType, this.param));
        } else {
            contentValues.put("params", this.param);
        }
        contentValues.put("log_type", this.logType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeIpc(JSONObject jSONObject) throws JSONException {
        super.writeIpc(jSONObject);
        jSONObject.put("params", this.param);
        jSONObject.put("log_type", this.logType);
    }

    @Override // com.bytedance.applog.store.BaseData
    protected JSONObject writePack() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Api.KEY_LOCAL_TIME_MS, this.f80ts);
        jSONObject.put(Api.KEY_EVENT_INDEX, this.eid);
        jSONObject.put("session_id", this.sid);
        fillUserInfo(jSONObject);
        if (!TextUtils.isEmpty(this.uuid)) {
            jSONObject.put("user_unique_id", this.uuid);
        }
        jSONObject.put("log_type", this.logType);
        try {
            JSONObject jSONObject2 = new JSONObject(this.param);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    getLogger().warn(4, this.loggerTags, "misc event exists key already!", new Object[0]);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            getLogger().error(4, "parse misc event params failed", e, new Object[0]);
        }
        if (this.eventId > 0) {
            jSONObject.put("event_id", this.eventId);
        }
        if (this.monitorId > 0) {
            jSONObject.put(SqliteDatabaseKt.colMonitorId, String.valueOf(this.monitorId));
        }
        if (this.sentryStained > 0) {
            jSONObject.put("event_stained", this.sentryStained);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        super.readIpc(jSONObject);
        this.param = jSONObject.optString("params", null);
        this.logType = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return this.logType;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return "param:" + this.param + " logType:" + this.logType;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getContent() {
        return this.param;
    }

    public String getLogType() {
        return this.logType;
    }
}
