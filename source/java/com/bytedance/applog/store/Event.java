package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.batch.PackCalculator;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.server.Api;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Event extends BaseData {
    private static final String COL_CAT = "category";
    private static final String COL_EXT_VALUE = "ext_value";
    private static final String COL_LABEL = "label";
    private static final String COL_PARAM = "params";
    private static final String COL_TAG = "tag";
    private static final String COL_VALUE = "value";
    static final String TABLE = "event";
    public String category;
    public long extValue;
    public String label;
    public String param;
    public String tag;
    public long value;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return "event";
    }

    public Event(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        setTs(0L);
        this.category = str2;
        this.tag = str3;
        this.label = str4;
        this.value = j;
        this.extValue = j2;
        this.param = str5;
        this.appId = str;
    }

    public Event(String str, String str2, String str3) {
        setTs(0L);
        this.appId = str;
        this.category = str2;
        this.tag = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Event() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        List<String> columnDef = super.getColumnDef();
        ArrayList arrayList = new ArrayList(columnDef.size());
        arrayList.addAll(columnDef);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", "value", WsChannelMultiProcessSharedProvider.INT_TYPE, "ext_value", WsChannelMultiProcessSharedProvider.INT_TYPE, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        int readDb = super.readDb(cursor);
        int i = readDb + 1;
        this.category = cursor.getString(readDb);
        int i2 = i + 1;
        this.tag = cursor.getString(i);
        int i3 = i2 + 1;
        this.value = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.extValue = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.param = cursor.getString(i4);
        int i6 = i5 + 1;
        this.label = cursor.getString(i5);
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        super.writeDb(contentValues);
        contentValues.put("category", this.category);
        contentValues.put("tag", this.tag);
        contentValues.put("value", Long.valueOf(this.value));
        contentValues.put("ext_value", Long.valueOf(this.extValue));
        if (PackOptConfig.packByLengthEnabled) {
            contentValues.put("params", PackCalculator.checkJSONLengthAndReplace(this.appId, StageEventType.V1_EVENT, this.tag, this.param));
        } else {
            contentValues.put("params", this.param);
        }
        contentValues.put("label", this.label);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeIpc(JSONObject jSONObject) throws JSONException {
        super.writeIpc(jSONObject);
        jSONObject.put(Api.KEY_EVENT_INDEX, this.eid);
        jSONObject.put("category", this.category);
        jSONObject.put("tag", this.tag);
        jSONObject.put("value", this.value);
        jSONObject.put("ext_value", this.extValue);
        jSONObject.put("params", this.param);
        jSONObject.put("label", this.label);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        super.readIpc(jSONObject);
        this.eid = jSONObject.optLong(Api.KEY_EVENT_INDEX, 0L);
        this.category = jSONObject.optString("category", null);
        this.tag = jSONObject.optString("tag", null);
        this.value = jSONObject.optLong("value", 0L);
        this.extValue = jSONObject.optLong("ext_value", 0L);
        this.param = jSONObject.optString("params", null);
        this.label = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.bytedance.applog.store.BaseData
    protected JSONObject writePack() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.param) ? new JSONObject(this.param) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put(Api.KEY_LOCAL_TIME_MS, this.f80ts);
        jSONObject.put(Api.KEY_EVENT_INDEX, this.eid);
        jSONObject.put("session_id", this.sid);
        fillUserInfo(jSONObject);
        if (this.f79nt != NetworkUtils.NetworkType.UNKNOWN.getValue()) {
            jSONObject.put("nt", this.f79nt);
        }
        if (!TextUtils.isEmpty(this.uuid)) {
            jSONObject.put("user_unique_id", this.uuid);
        }
        jSONObject.put("category", this.category);
        jSONObject.put("tag", this.tag);
        jSONObject.put("value", this.value);
        jSONObject.put("ext_value", this.extValue);
        jSONObject.put("label", this.label);
        jSONObject.put(Api.KEY_DATETIME, this.mDT);
        if (!TextUtils.isEmpty(this.abSdkVersion)) {
            jSONObject.put(Api.KEY_AB_SDK_VERSION, this.abSdkVersion);
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

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return this.tag;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return "" + this.tag + ", " + this.label;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getContent() {
        return this.param;
    }
}
