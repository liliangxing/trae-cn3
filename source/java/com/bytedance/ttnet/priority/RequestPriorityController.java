package com.bytedance.ttnet.priority;

import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestPriorityController {
    private Set<String> mHighList = new CopyOnWriteArraySet();
    private Set<String> mNormalList = new CopyOnWriteArraySet();
    private Set<String> mLowList = new CopyOnWriteArraySet();

    public void initWithTncConfig(JSONObject jSONObject) {
        this.mHighList = TTHttpCallPriorityControl.getSetFromJSONArray(jSONObject, "high");
        this.mNormalList = TTHttpCallPriorityControl.getSetFromJSONArray(jSONObject, "normal");
        this.mLowList = TTHttpCallPriorityControl.getSetFromJSONArray(jSONObject, LynxImageService.PRIORITY_LOW);
    }

    public void initWithLocal(Set<String> set, Set<String> set2, Set<String> set3) {
        this.mHighList.clear();
        this.mNormalList.clear();
        this.mLowList.clear();
        this.mHighList.addAll(set);
        this.mNormalList.addAll(set2);
        this.mLowList.addAll(set3);
    }

    public Request setPriorityToRequest(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        if (setPriorityToRequestInternal(this.mHighList, request.getPath(), newBuilder, 3, 4)) {
            return newBuilder.build();
        }
        if (setPriorityToRequestInternal(this.mLowList, request.getPath(), newBuilder, -1, 1)) {
            return newBuilder.build();
        }
        int priorityLevel = request.getPriorityLevel();
        if (priorityLevel >= 3) {
            priorityLevel = 1;
        }
        if (priorityLevel <= -1) {
            priorityLevel = 0;
        }
        int i = priorityLevel;
        int requestPriorityLevel = request.getRequestPriorityLevel();
        if (requestPriorityLevel >= 4) {
            requestPriorityLevel = 3;
        }
        if (requestPriorityLevel >= 1) {
            requestPriorityLevel = 2;
        }
        if (setPriorityToRequestInternal(this.mNormalList, request.getPath(), newBuilder, i, requestPriorityLevel)) {
            return newBuilder.build();
        }
        return newBuilder.priorityLevel(1).requestPriorityLevel(3).build();
    }

    private boolean setPriorityToRequestInternal(Set<String> set, String str, Request.Builder builder, int i, int i2) {
        if (!TTHttpCallPriorityControl.isMatch(set, str)) {
            return false;
        }
        builder.priorityLevel(i);
        builder.requestPriorityLevel(i2);
        return true;
    }
}
