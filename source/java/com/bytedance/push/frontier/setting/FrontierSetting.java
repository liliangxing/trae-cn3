package com.bytedance.push.frontier.setting;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class FrontierSetting {
    public int aid;
    public String appKey;
    public int pid;
    public List<String> urls;

    public static FrontierSetting parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FrontierSetting frontierSetting = new FrontierSetting();
        JSONArray optJSONArray = jSONObject.optJSONArray(MonitorConstants.URLS);
        if (optJSONArray != null) {
            frontierSetting.urls = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    if (!optString.endsWith("/ws/v2")) {
                        if (optString.endsWith("/")) {
                            optString = optString + "ws/v2";
                        } else {
                            optString = optString + "/ws/v2";
                        }
                    }
                    frontierSetting.urls.add(optString);
                }
            }
        }
        frontierSetting.aid = jSONObject.optInt("aid");
        frontierSetting.pid = jSONObject.optInt("pid");
        frontierSetting.appKey = jSONObject.optString(WsConstants.KEY_APP_KEY);
        return frontierSetting;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", this.aid);
            jSONObject.put("pid", this.pid);
            jSONObject.put(WsConstants.KEY_APP_KEY, this.appKey);
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.urls;
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            jSONObject.put(MonitorConstants.URLS, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean isValid() {
        List<String> list;
        return (this.aid == 0 || this.pid == 0 || TextUtils.isEmpty(this.appKey) || (list = this.urls) == null || list.size() <= 0) ? false : true;
    }
}
