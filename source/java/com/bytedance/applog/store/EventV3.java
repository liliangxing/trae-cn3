package com.bytedance.applog.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.batch.PackCalculator;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.collector.PageHolder;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.priority.EventPriority;
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
public class EventV3 extends BaseData {
    static final String COL_BAV = "is_bav";
    static final String COL_DISABLE_PERSONALIZATION = "disable_personalization";
    static final String COL_EVENT = "event";
    static final String COL_PAGE_INFO = "page_info";
    static final String COL_PARAM = "params";
    static final String TABLE = "eventv3";
    protected boolean bav;
    public String disablePersonalization;
    protected String event;
    protected String param;

    protected void fillParam() throws JSONException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.store.BaseData
    public String getTableName() {
        return TABLE;
    }

    public EventV3(String str, String str2, boolean z, String str3) {
        this.appId = str;
        this.event = str2;
        this.bav = z;
        this.param = str3;
        AppLogInstance instanceByAppId = AppLogHelper.getInstanceByAppId(str);
        if (instanceByAppId == null || instanceByAppId.getDisablePersonalization() == null) {
            return;
        }
        this.disablePersonalization = String.valueOf(instanceByAppId.getDisablePersonalization());
    }

    public EventV3(String str, String str2) {
        this.appId = str;
        this.event = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public List<String> getColumnDef() {
        List<String> columnDef = super.getColumnDef();
        ArrayList arrayList = new ArrayList(columnDef.size());
        arrayList.addAll(columnDef);
        arrayList.addAll(Arrays.asList("event", "varchar", "params", "varchar", COL_BAV, WsChannelMultiProcessSharedProvider.INT_TYPE, "disable_personalization", "varchar", COL_PAGE_INFO, "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.applog.store.BaseData
    public int readDb(Cursor cursor) {
        int readDb = super.readDb(cursor);
        int i = readDb + 1;
        this.event = cursor.getString(readDb);
        int i2 = i + 1;
        this.param = cursor.getString(i);
        int i3 = i2 + 1;
        this.bav = cursor.getInt(i2) == 1;
        int i4 = i3 + 1;
        this.disablePersonalization = cursor.getString(i3);
        int i5 = i4 + 1;
        String string = cursor.getString(i4);
        this.pageInfo = TextUtils.isEmpty(string) ? null : PageHolder.PageInfo.INSTANCE.parse(string);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeDb(ContentValues contentValues) {
        super.writeDb(contentValues);
        contentValues.put("event", this.event);
        if (this.bav && this.param == null) {
            try {
                fillParam();
            } catch (JSONException e) {
                getLogger().error(4, this.loggerTags, "write db failed", e, new Object[0]);
            }
        }
        if (PackOptConfig.packByLengthEnabled) {
            contentValues.put("params", PackCalculator.checkJSONLengthAndReplace(this.appId, StageEventType.V3_EVENT, this.event, this.param));
        } else {
            contentValues.put("params", this.param);
        }
        contentValues.put(COL_BAV, Integer.valueOf(this.bav ? 1 : 0));
        contentValues.put("disable_personalization", this.disablePersonalization);
        contentValues.put(COL_PAGE_INFO, this.pageInfo != null ? this.pageInfo.toJsonString() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public void writeIpc(JSONObject jSONObject) throws JSONException {
        super.writeIpc(jSONObject);
        jSONObject.put("event", this.event);
        if (this.bav && this.param == null) {
            fillParam();
        }
        jSONObject.put("params", this.param);
        jSONObject.put(COL_BAV, this.bav);
        jSONObject.put("disable_personalization", this.disablePersonalization);
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
        jSONObject.put("event", this.event);
        if (this.bav) {
            jSONObject.put(COL_BAV, 1);
        }
        if (!TextUtils.isEmpty(this.param)) {
            jSONObject.put("params", new JSONObject(this.param));
        }
        if (this.f79nt != NetworkUtils.NetworkType.UNKNOWN.getValue()) {
            jSONObject.put("nt", this.f79nt);
        }
        jSONObject.put(Api.KEY_DATETIME, this.mDT);
        if (!TextUtils.isEmpty(this.abSdkVersion)) {
            jSONObject.put(Api.KEY_AB_SDK_VERSION, this.abSdkVersion);
        }
        if (!TextUtils.isEmpty(this.disablePersonalization)) {
            jSONObject.put("disable_personalization", Integer.valueOf(this.disablePersonalization));
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
        if (this.pageInfo != null) {
            this.pageInfo.appendToJson(jSONObject);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.applog.store.BaseData
    public BaseData readIpc(JSONObject jSONObject) {
        super.readIpc(jSONObject);
        this.event = jSONObject.optString("event", null);
        this.param = jSONObject.optString("params", null);
        this.bav = jSONObject.optBoolean(COL_BAV, false);
        this.disablePersonalization = jSONObject.optString("disable_personalization", null);
        return this;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getEventName() {
        return this.event;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getDetail() {
        return this.event;
    }

    public String getEvent() {
        return this.event;
    }

    @Override // com.bytedance.applog.store.BaseData
    public String getContent() {
        return this.param;
    }

    public void updateEventPriority(EventPriority eventPriority) {
        if (eventPriority != null) {
            this.priority = eventPriority.getPriorityOfEvent(this.event, this.param);
        }
    }

    public void setParams(String str) {
        this.param = str;
    }
}
