package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.server.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Page extends BaseData {
    private static final String COL_BACK = "is_back";
    static final String COL_DURATION = "duration";
    private static final String COL_FLAT_PARAMS = "flat_params";
    private static final String COL_FROM = "refer_page_key";
    private static final String COL_LAST_SESSION = "last_session";
    static final String COL_NAME = "page_key";
    static final String TABLE = "page";
    public int back;
    public long duration;
    public String flatParams;
    public String last;
    public String lastSession;
    public String name;

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return TABLE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        List<String> columnDef = super.getColumnDef();
        ArrayList arrayList = new ArrayList(columnDef.size());
        arrayList.addAll(columnDef);
        arrayList.addAll(Arrays.asList(COL_NAME, "varchar", COL_FROM, "varchar", "duration", WsChannelMultiProcessSharedProvider.INT_TYPE, COL_BACK, WsChannelMultiProcessSharedProvider.INT_TYPE, COL_LAST_SESSION, "varchar", COL_FLAT_PARAMS, "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        int readDb = super.readDb(cursor);
        int i = readDb + 1;
        this.name = cursor.getString(readDb);
        int i2 = i + 1;
        this.last = cursor.getString(i);
        int i3 = i2 + 1;
        this.duration = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.back = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.lastSession = cursor.getString(i4);
        int i6 = i5 + 1;
        this.flatParams = cursor.getString(i5);
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        super.writeDb(contentValues);
        contentValues.put(COL_NAME, this.name);
        contentValues.put(COL_FROM, this.last);
        contentValues.put("duration", Long.valueOf(this.duration));
        contentValues.put(COL_BACK, Integer.valueOf(this.back));
        contentValues.put(COL_LAST_SESSION, this.lastSession);
        contentValues.put(COL_FLAT_PARAMS, this.flatParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeIpc(JSONObject jSONObject) throws JSONException {
        super.writeIpc(jSONObject);
        jSONObject.put(COL_NAME, this.name);
        jSONObject.put(COL_FROM, this.last);
        jSONObject.put("duration", this.duration);
        jSONObject.put(COL_BACK, this.back);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        super.readIpc(jSONObject);
        this.name = jSONObject.optString(COL_NAME, null);
        this.last = jSONObject.optString(COL_FROM, null);
        this.duration = jSONObject.optLong("duration", 0L);
        this.back = jSONObject.optInt(COL_BACK, 0);
        return this;
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
        jSONObject.put("event", "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", fillParam());
        jSONObject.put(Api.KEY_DATETIME, this.mDT);
        if (this.eventId > 0) {
            jSONObject.put("event_id", this.eventId);
        }
        return jSONObject;
    }

    private JSONObject fillParam() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(COL_NAME, this.name);
        jSONObject.put(COL_FROM, this.last);
        jSONObject.put(COL_BACK, this.back);
        jSONObject.put("duration", this.duration);
        return jSONObject;
    }

    public boolean isResumeEvent() {
        return this.duration == -1;
    }

    public boolean isActivity() {
        return this.name.contains(":");
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return this.name + ", " + this.duration;
    }
}
