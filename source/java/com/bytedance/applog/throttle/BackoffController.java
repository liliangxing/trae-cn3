package com.bytedance.applog.throttle;

import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.priority.EventPriorityItem;
import java.util.Collections;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BackoffController {
    private static final int BACK_OFF_DENOMINATOR = 10000;
    private static final String KEY_BACK_OFF_RATIO = "backoff_ratio";
    private static final String KEY_DISABLE_SESSION_END_REQUEST = "disable_session_end_request";
    private static final String KEY_DISABLE_SESSION_START_REQUEST = "disable_session_start_request";
    private static final String KEY_MAX_REQUEST_FREQUENCY = "max_request_frequency";
    private final AppLogInstance appLogInstance;
    private final ConfigManager mConfig;
    private long mEventInterval;
    private int mMaxRequestFrequency;
    private int mBackoffRatio = 0;
    private long mBackoffWindowStartTime = 0;
    private int mBackoffWindowSendCount = 0;
    private int mDisableSessionStartRequest = 0;
    private int mDisableSessionEndRequest = 0;

    public BackoffController(AppLogInstance appLogInstance, ConfigManager configManager, long j) {
        this.appLogInstance = appLogInstance;
        this.mConfig = configManager;
        this.mEventInterval = j;
    }

    public void parseBackoffControllerFromResp(JSONObject jSONObject, long j, EventPriorityItem eventPriorityItem) {
        int i;
        this.mEventInterval = j;
        int optInt = jSONObject.optInt(KEY_BACK_OFF_RATIO, 0);
        this.mBackoffRatio = optInt;
        if (optInt < 0 || optInt > 10000) {
            this.mBackoffRatio = 0;
        }
        int optInt2 = jSONObject.optInt(KEY_MAX_REQUEST_FREQUENCY, getDefaultMaxRequestFrequency(eventPriorityItem));
        this.mMaxRequestFrequency = optInt2;
        if (optInt2 <= 0) {
            this.mMaxRequestFrequency = 12;
        }
        int i2 = this.mBackoffRatio;
        if (i2 > 0 && this.mBackoffWindowStartTime == 0) {
            this.mBackoffWindowStartTime = System.currentTimeMillis();
            this.mBackoffWindowSendCount = 1;
        } else if (i2 == 0) {
            this.mBackoffWindowStartTime = 0L;
            this.mBackoffWindowSendCount = 0;
        }
        this.mDisableSessionStartRequest = jSONObject.optInt(KEY_DISABLE_SESSION_START_REQUEST, 0);
        this.mDisableSessionEndRequest = jSONObject.optInt(KEY_DISABLE_SESSION_END_REQUEST, 0);
        if (this.mBackoffRatio == 0 && (i = this.mMaxRequestFrequency) > 0) {
            this.mConfig.updateCongestionMaxRequestFrequency(eventPriorityItem, i);
        }
        this.appLogInstance.getLogger().debug(Collections.singletonList("BackoffController"), "parseBackoffControllerFromResp mEventInterval: " + this.mEventInterval + ", mBackoffRatio: " + this.mBackoffRatio + ", mMaxRequestFrequency: " + this.mMaxRequestFrequency + ", mBackoffWindowStartTime: " + this.mBackoffWindowStartTime + ", mBackoffWindowSendCount: " + this.mBackoffWindowSendCount + ", mDisableSessionStartRequest: " + this.mDisableSessionStartRequest + ", mDisableSessionEndRequest: " + this.mDisableSessionEndRequest, new Object[0]);
    }

    public boolean backoffLogRequestAsRatio(int i) {
        if (this.mBackoffRatio > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mBackoffWindowStartTime;
            long j2 = this.mEventInterval;
            if (currentTimeMillis < j + j2) {
                int i2 = this.mBackoffWindowSendCount;
                if (i2 >= this.mMaxRequestFrequency) {
                    return true;
                }
                this.mBackoffWindowSendCount = i2 + 1;
            } else {
                this.mBackoffWindowStartTime = j + (((currentTimeMillis - j) / j2) * j2);
                this.mBackoffWindowSendCount = 1;
            }
        }
        int i3 = this.mBackoffRatio;
        if (i3 >= 10000) {
            return true;
        }
        if (i3 <= 0 || i3 >= 10000 || new Random().nextInt(10000) >= this.mBackoffRatio) {
            return (this.mDisableSessionStartRequest > 0 && 1 == i) || (this.mDisableSessionEndRequest > 0 && 3 == i);
        }
        return true;
    }

    private int getDefaultMaxRequestFrequency(EventPriorityItem eventPriorityItem) {
        if (eventPriorityItem == null || -1 == eventPriorityItem.getPriority()) {
            return 12;
        }
        if (eventPriorityItem.getPriority() == 0) {
            return CongestionController.MAX_REQUEST_FREQUENCY_REALTIME;
        }
        return 60;
    }
}
