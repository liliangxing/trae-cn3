package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestDropController {
    private final Set<String> mDropList = new CopyOnWriteArraySet();

    public void initWithTncConfig(JSONObject jSONObject) {
        this.mDropList.clear();
        JSONArray optJSONArray = jSONObject.optJSONArray("dl");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.mDropList.add(optString);
                }
            }
        }
    }

    public void initWithLocal(Set<String> set) {
        this.mDropList.clear();
        this.mDropList.addAll(set);
    }

    public void raiseExceptionIfDrop(Request request) throws DroppedByThrottleControlException {
        if (TTHttpCallPriorityControl.isMatch(this.mDropList, request.getPath())) {
            if (Logger.debug()) {
                Logger.d("RequestDropController", "check drop and match " + request.getPath());
            }
            throw new DroppedByThrottleControlException();
        }
    }

    public boolean isValid() {
        return this.mDropList.size() > 0;
    }
}
