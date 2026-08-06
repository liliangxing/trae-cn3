package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.server.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Launch extends BaseData {
    static final String COL_BG = "is_background";
    private static final String COL_FLAT_PARAMS = "flat_params";
    private static final String COL_LAST_SESSION = "last_session";
    private static final String COL_VER_CODE = "ver_code";
    private static final String COL_VER_NAME = "ver_name";
    static final String TABLE = "launch";
    public String flatParams;
    public String lastSession;
    public boolean mBg;
    public long verCode;
    public String verName;

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return "launch";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return "launch";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        List<String> columnDef = super.getColumnDef();
        ArrayList arrayList = new ArrayList(columnDef.size());
        arrayList.addAll(columnDef);
        arrayList.addAll(Arrays.asList(COL_VER_NAME, "varchar", COL_VER_CODE, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_LAST_SESSION, "varchar", "is_background", WsChannelMultiProcessSharedProvider.INT_TYPE, COL_FLAT_PARAMS, "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        int readDb = super.readDb(cursor);
        int i = readDb + 1;
        this.verName = cursor.getString(readDb);
        int i2 = i + 1;
        this.verCode = cursor.getLong(i);
        int i3 = i2 + 1;
        this.lastSession = cursor.getString(i2);
        int i4 = i3 + 1;
        this.mBg = cursor.getInt(i3) == 1;
        int i5 = i4 + 1;
        this.flatParams = cursor.getString(i4);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        super.writeDb(contentValues);
        contentValues.put(COL_VER_NAME, this.verName);
        contentValues.put(COL_VER_CODE, Long.valueOf(this.verCode));
        contentValues.put(COL_LAST_SESSION, this.lastSession);
        contentValues.put("is_background", Integer.valueOf(this.mBg ? 1 : 0));
        contentValues.put(COL_FLAT_PARAMS, this.flatParams);
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
        fillUserInfo(jSONObject);
        if (!TextUtils.isEmpty(this.uuid)) {
            jSONObject.put("user_unique_id", this.uuid);
        }
        if (this.mBg) {
            jSONObject.put("is_background", true);
        }
        jSONObject.put(Api.KEY_DATETIME, this.mDT);
        if (!TextUtils.isEmpty(this.abSdkVersion)) {
            jSONObject.put(Api.KEY_AB_SDK_VERSION, this.abSdkVersion);
        }
        if (!TextUtils.isEmpty(this.lastSession)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.lastSession);
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
                        getLogger().warn(4, this.loggerTags, "Add params to launch conflict: {} - {}", next, jSONObject2.opt(next));
                    }
                }
            } catch (Throwable th) {
                getLogger().error(4, this.loggerTags, "Add flat params: {} to launch error", th, this.flatParams);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        getLogger().error(4, this.loggerTags, "read ipc not implemented", new Object[0]);
        return null;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return this.mBg ? "bg" : "fg";
    }
}
