package com.bytedance.ttnet.priority;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.throttle.TTNetThrottle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RequestSpeedController {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static String TAG = "RequestSpeedController";
    private final Map<String, Integer> mRequestThrottleMap = new ConcurrentHashMap();
    private Set<String> mNormalUpHosts = new CopyOnWriteArraySet();
    private Set<String> mNormalDownHosts = new CopyOnWriteArraySet();
    private Set<String> mWsUpHosts = new CopyOnWriteArraySet();
    private Set<String> mWsDownHosts = new CopyOnWriteArraySet();
    private long mNormalUpSpeed = -1;
    private long mNormalDownSpeed = -1;
    private long mWsUpSpeed = -1;
    private long mWsDownSpeed = -1;

    public boolean initWithTncConfig(JSONObject jSONObject) {
        connectionThrottleStop();
        this.mRequestThrottleMap.clear();
        JSONObject optJSONObject = jSONObject.optJSONObject("throttle");
        if (optJSONObject == null) {
            return false;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_throttle");
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.mRequestThrottleMap.put(next, Integer.valueOf(optJSONObject2.optInt(next)));
            }
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("connection_throttle");
        if (optJSONObject3 == null) {
            return true;
        }
        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("normal_up");
        if (optJSONObject4 != null) {
            this.mNormalUpHosts = TTHttpCallPriorityControl.getSetFromJSONArray(optJSONObject4, "hosts");
            this.mNormalUpSpeed = optJSONObject4.optInt("speed", -1);
        }
        JSONObject optJSONObject5 = optJSONObject3.optJSONObject("normal_down");
        if (optJSONObject5 != null) {
            this.mNormalDownHosts = TTHttpCallPriorityControl.getSetFromJSONArray(optJSONObject5, "hosts");
            this.mNormalDownSpeed = optJSONObject5.optInt("speed", -1);
        }
        JSONObject optJSONObject6 = optJSONObject3.optJSONObject("ws_up");
        if (optJSONObject6 != null) {
            this.mWsUpHosts = TTHttpCallPriorityControl.getSetFromJSONArray(optJSONObject6, "hosts");
            this.mWsUpSpeed = optJSONObject6.optInt("speed", -1);
        }
        JSONObject optJSONObject7 = optJSONObject3.optJSONObject("ws_down");
        if (optJSONObject7 == null) {
            return true;
        }
        this.mWsDownHosts = TTHttpCallPriorityControl.getSetFromJSONArray(optJSONObject7, "hosts");
        this.mWsDownSpeed = optJSONObject7.optInt("speed", -1);
        return true;
    }

    public void initWithLocal(Map<String, Integer> map, Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4, long j, long j2, long j3, long j4) {
        this.mRequestThrottleMap.clear();
        this.mNormalUpHosts.clear();
        this.mNormalDownHosts.clear();
        this.mWsUpHosts.clear();
        this.mWsDownHosts.clear();
        this.mRequestThrottleMap.putAll(map);
        this.mNormalUpHosts.addAll(set);
        this.mNormalDownHosts.addAll(set2);
        this.mWsUpHosts.addAll(set3);
        Set<String> set5 = this.mWsDownHosts;
        set5.addAll(set5);
        this.mNormalUpSpeed = j;
        this.mNormalDownSpeed = j2;
        this.mWsUpSpeed = j3;
        this.mWsDownSpeed = j4;
    }

    public Request setThrottleSpeedToRequest(Request request) {
        Integer mapValueIfMatch = TTHttpCallPriorityControl.getMapValueIfMatch(this.mRequestThrottleMap, request.getPath());
        if (mapValueIfMatch == null) {
            return request;
        }
        Request.Builder newBuilder = request.newBuilder();
        Object extraInfo = request.getExtraInfo();
        if (extraInfo == null) {
            extraInfo = new RequestContext();
            newBuilder.setExtraInfo(extraInfo);
        }
        if (extraInfo instanceof BaseRequestContext) {
            ((BaseRequestContext) extraInfo).throttle_net_speed = mapValueIfMatch.longValue();
        }
        newBuilder.setExtraInfo(extraInfo);
        return newBuilder.build();
    }

    public void connectionThrottleStart() {
        if (Logger.debug()) {
            Logger.d(TAG, "connectionThrottleStart");
            Logger.d(TAG, "normal_up throttle " + this.mNormalUpHosts.size() + " speed " + this.mNormalUpSpeed);
            Logger.d(TAG, "normal_down throttle " + this.mNormalDownHosts.size() + " speed " + this.mNormalDownSpeed);
            Logger.d(TAG, "ws_up throttle " + this.mWsUpHosts.size() + " speed " + this.mWsUpSpeed);
            Logger.d(TAG, "ws_down throttle " + this.mWsDownHosts.size() + " speed " + this.mWsDownSpeed);
        }
        if (this.mNormalUpHosts.size() > 0 && this.mNormalUpSpeed > 0) {
            TTNetThrottle.start((String[]) this.mNormalUpHosts.toArray(EMPTY_STRING_ARRAY), 1, this.mNormalUpSpeed);
        }
        if (this.mNormalDownHosts.size() > 0 && this.mNormalDownSpeed > 0) {
            TTNetThrottle.start((String[]) this.mNormalDownHosts.toArray(EMPTY_STRING_ARRAY), 2, this.mNormalDownSpeed);
        }
        if (this.mWsUpHosts.size() > 0 && this.mWsUpSpeed > 0) {
            TTNetThrottle.start((String[]) this.mWsUpHosts.toArray(EMPTY_STRING_ARRAY), 4, this.mWsUpSpeed);
        }
        if (this.mWsDownHosts.size() <= 0 || this.mWsDownSpeed <= 0) {
            return;
        }
        TTNetThrottle.start((String[]) this.mWsDownHosts.toArray(EMPTY_STRING_ARRAY), 8, this.mWsDownSpeed);
    }

    public void connectionThrottleStop() {
        Set<String> set = this.mNormalUpHosts;
        String[] strArr = EMPTY_STRING_ARRAY;
        TTNetThrottle.stop((String[]) set.toArray(strArr), 1);
        TTNetThrottle.stop((String[]) this.mNormalDownHosts.toArray(strArr), 2);
        TTNetThrottle.stop((String[]) this.mWsUpHosts.toArray(strArr), 4);
        TTNetThrottle.stop((String[]) this.mWsDownHosts.toArray(strArr), 8);
    }
}
