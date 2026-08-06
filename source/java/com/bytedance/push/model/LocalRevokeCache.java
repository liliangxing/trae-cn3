package com.bytedance.push.model;

import com.ss.android.pushmanager.PushCommonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LocalRevokeCache {
    public long receiveTimeStamp;
    public long revokeId;
    public long rid;
    public int sender;

    public static LocalRevokeCache parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LocalRevokeCache localRevokeCache = new LocalRevokeCache();
        localRevokeCache.receiveTimeStamp = jSONObject.optLong("ts");
        localRevokeCache.rid = jSONObject.optLong(PushCommonConstants.KEY_RID);
        localRevokeCache.revokeId = jSONObject.optLong("revoke_id");
        localRevokeCache.sender = jSONObject.optInt("sender");
        return localRevokeCache;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ts", this.receiveTimeStamp);
            jSONObject.put(PushCommonConstants.KEY_RID, this.rid);
            jSONObject.put("revoke_id", this.revokeId);
            jSONObject.put("sender", this.sender);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
