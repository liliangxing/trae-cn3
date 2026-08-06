package com.bytedance.push;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.common.push.BaseJson;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.ss.android.pushmanager.PushCommonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PushNotificationMessage extends BaseJson {
    public long arriveTime;
    public long expireTime;
    public int from;
    public boolean handleBySdk;
    public boolean hasShown;
    private long messageId;
    private PushBody pushBody;
    private String pushBodyStr;
    private final String PARAMS_KEY_CLIENT_TIME = "client_time";
    private final String PARAMS_KEY_RUN_TYPE = "run_type";
    private final String PARAMS_KEY_CLIENT_FEATURE = "client_feature";
    private final String PARAMS_KEY_EXPIRE_TIME = "expire_time";

    public PushNotificationMessage(Cursor cursor) {
        this.messageId = cursor.getLong(0);
        this.arriveTime = cursor.getLong(1);
        this.expireTime = cursor.getLong(2);
        this.from = cursor.getInt(3);
        this.handleBySdk = cursor.getInt(4) == 1;
        this.hasShown = cursor.getInt(5) == 1;
        String string = cursor.getString(6);
        this.pushBodyStr = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.pushBody = new PushBody(new JSONObject(this.pushBodyStr));
        } catch (JSONException e) {
            e.printStackTrace();
            this.pushBody = null;
        }
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID, Long.valueOf(getServerMessageId()));
        contentValues.put(MultiProcessPushMessageDatabaseHelper.COL_ARRIVE_TIME, Long.valueOf(this.arriveTime));
        contentValues.put(MultiProcessPushMessageDatabaseHelper.COL_CLIENT_INTELLIGENCE_EXPIRE_TIME, Long.valueOf(this.expireTime));
        contentValues.put("sender", Integer.valueOf(this.from));
        contentValues.put(MultiProcessPushMessageDatabaseHelper.COL_HANDLE_BY_SDK, Integer.valueOf(this.handleBySdk ? 1 : 0));
        contentValues.put(MultiProcessPushMessageDatabaseHelper.HAS_BEEN_SHOWN, Integer.valueOf(this.hasShown ? 1 : 0));
        contentValues.put("push_body", getPushBodyStr());
        return contentValues;
    }

    public PushNotificationMessage(int i, long j, long j2, long j3, boolean z, boolean z2, String str) {
        this.from = i;
        this.messageId = j;
        this.arriveTime = j2;
        this.expireTime = j3;
        this.handleBySdk = z;
        this.hasShown = z2;
        this.pushBodyStr = str;
    }

    public PushNotificationMessage(int i, long j, long j2, long j3, boolean z, boolean z2, PushBody pushBody) {
        this.from = i;
        this.messageId = j;
        this.arriveTime = j2;
        this.expireTime = j3;
        this.handleBySdk = z;
        this.hasShown = z2;
        this.pushBody = pushBody;
        this.pushBodyStr = pushBody.getOriginData();
    }

    public String getPushBodyStr() {
        PushBody pushBody;
        if (TextUtils.isEmpty(this.pushBodyStr) && (pushBody = this.pushBody) != null) {
            this.pushBodyStr = pushBody.getOriginData();
        }
        return this.pushBodyStr;
    }

    public PushBody getPushBody() {
        if (this.pushBody == null) {
            try {
                this.pushBody = new PushBody(new JSONObject(this.pushBodyStr));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.pushBody;
    }

    public PushNotificationMessage setPushBody(PushBody pushBody) {
        this.pushBody = pushBody;
        return this;
    }

    public long getServerMessageId() {
        return this.messageId;
    }

    public long getLocalMessageId() {
        return this.arriveTime;
    }

    public JSONObject buildPitayaTaskParams() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "run_type", "show_push");
        add(jSONObject, "client_time", System.currentTimeMillis());
        add(jSONObject, "expire_time", this.expireTime);
        add(jSONObject, "rule_id", this.pushBody.id);
        add(jSONObject, PushCommonConstants.KEY_RULE_ID64, this.pushBody.rid64);
        add(jSONObject, "client_feature", PushServiceManager.get().getPushExternalService().getClientFeatureService().getClientFeatureSync(IClientFeatureService.INVOKE_SCENE_PITAYA));
        return jSONObject;
    }
}
