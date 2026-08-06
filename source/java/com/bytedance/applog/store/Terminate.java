package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.server.Api;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Terminate extends BaseData {
    private static final String COL_DURATION = "duration";
    static final String COL_STOP_TS = "stop_timestamp";
    static final String TABLE = "terminate";
    public Integer bgSession;
    public long duration;
    public String flatParams;
    public String fromSessionId;
    public String lastSession;
    public Integer sessionType;
    public long stopTs;
    public String toSessionId;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        return null;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return "terminate";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return "terminate";
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        getLogger().error(4, this.loggerTags, "read db not implemented", new Object[0]);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        getLogger().error(4, this.loggerTags, "write db not implemented", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeIpc(JSONObject jSONObject) {
        getLogger().error(4, this.loggerTags, "write ipc not implemented", new Object[0]);
    }

    @Override // com.bytedance.applog.store.BaseData
    protected JSONObject writePack() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Api.KEY_LOCAL_TIME_MS, this.f80ts);
        jSONObject.put(Api.KEY_EVENT_INDEX, this.eid);
        jSONObject.put("session_id", this.sid);
        jSONObject.put(COL_STOP_TS, this.stopTs / 1000);
        jSONObject.put("duration", this.duration / 1000);
        jSONObject.put(Api.KEY_DATETIME, this.mDT);
        fillUserInfo(jSONObject);
        if (!TextUtils.isEmpty(this.uuid)) {
            jSONObject.put("user_unique_id", this.uuid);
        }
        if (!TextUtils.isEmpty(this.abSdkVersion)) {
            jSONObject.put(Api.KEY_AB_SDK_VERSION, this.abSdkVersion);
        }
        if (!TextUtils.isEmpty(this.lastSession)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.lastSession, this.sid)) {
                jSONObject.put("original_session_id", this.lastSession);
            }
        }
        Integer num = this.sessionType;
        if (num != null) {
            jSONObject.put(Api.KEY_SESSION_TYPE, num);
        }
        if (!TextUtils.isEmpty(this.fromSessionId)) {
            jSONObject.put(Api.KEY_FROM_SESSION, this.fromSessionId);
        }
        if (!TextUtils.isEmpty(this.toSessionId)) {
            jSONObject.put(Api.KEY_TO_SESSION, this.toSessionId);
        }
        Integer num2 = this.bgSession;
        if (num2 != null) {
            jSONObject.put(Api.KEY_BG_SESSION, num2);
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
        if (!TextUtils.isEmpty(this.flatParams)) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.flatParams);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject.has(next)) {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } else {
                        getLogger().warn(4, this.loggerTags, "Add flat params to terminate conflict: {} - {}", next, jSONObject2.opt(next));
                    }
                }
            } catch (Throwable th) {
                getLogger().error(4, this.loggerTags, "Add params to terminate error", th, new Object[0]);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        getLogger().error(4, this.loggerTags, "read ipc not implemented", new Object[0]);
        return this;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return String.valueOf(this.duration);
    }
}
