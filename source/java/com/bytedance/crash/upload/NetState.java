package com.bytedance.crash.upload;

import com.bytedance.crash.util.DateUtils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetState {
    static final String AID = "aid";
    static final String ALOG_STRATEGY = "alog_strategy";
    static final String PATH = "path";
    static final String REDIRECT = "redirect";
    static final String RETREAT_COUNT = "retreatCount";
    static final String STRATEGY = "strategy";
    static final String UPDATE_TIME = "update_time";
    static final String UPDATE_TIME_FORMAT = "update_time_format";
    private String mAid;
    private int mAlogStrategy;
    private long mDelayTime;
    private JSONObject mJson;
    private String mKeyId;
    private String mPath;
    private String mRedirect;
    private int mRetreatCount;
    private int mStrategy;
    private long mUpdateTime;
    private String mUpdateTimeFormat;

    public NetState(String str, String str2) {
        this.mAid = str;
        this.mPath = str2;
        this.mStrategy = 0;
        this.mAlogStrategy = 0;
        this.mUpdateTime = 0L;
        this.mUpdateTimeFormat = "";
        this.mRetreatCount = 0;
        this.mDelayTime = 0L;
        this.mRedirect = "";
        this.mJson = new JSONObject();
        this.mKeyId = NetworkDisasterManager.getNetKeyId(this.mAid, this.mPath);
        try {
            this.mJson.put("aid", this.mAid);
            this.mJson.put("path", this.mPath);
        } catch (Throwable unused) {
        }
    }

    public NetState(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            throw new IllegalArgumentException("json can't be null");
        }
        this.mAid = jSONObject.optString("aid");
        this.mPath = jSONObject.optString("path");
        this.mStrategy = jSONObject.optInt(STRATEGY);
        this.mAlogStrategy = jSONObject.optInt(ALOG_STRATEGY);
        this.mUpdateTime = jSONObject.optLong(UPDATE_TIME);
        this.mUpdateTimeFormat = jSONObject.optString(UPDATE_TIME_FORMAT);
        this.mRetreatCount = jSONObject.optInt(RETREAT_COUNT);
        this.mRedirect = jSONObject.optString("redirect");
        this.mJson = new JSONObject(jSONObject.toString());
        this.mKeyId = NetworkDisasterManager.getNetKeyId(this.mAid, this.mPath);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            this.mJson.put("aid", this.mAid);
            this.mJson.put("path", this.mPath);
            this.mJson.put(UPDATE_TIME, this.mUpdateTime);
            try {
                this.mJson.put(UPDATE_TIME_FORMAT, DateUtils.getFileDateInstanceMs().format(new Date(this.mUpdateTime)));
            } catch (Throwable unused) {
                this.mJson.put(UPDATE_TIME_FORMAT, "");
            }
            this.mJson.put(STRATEGY, this.mStrategy);
            this.mJson.put(ALOG_STRATEGY, this.mAlogStrategy);
            this.mJson.put(RETREAT_COUNT, this.mRetreatCount);
            this.mJson.put("redirect", this.mRedirect);
            jSONObject.put(this.mKeyId, this.mJson);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    public int getRetreatCount() {
        int i = this.mStrategy;
        if (i == 1 || i == 0) {
            return 0;
        }
        return this.mRetreatCount;
    }

    public void setStrategy(int i) {
        if (i == 1 || i == 0) {
            this.mRetreatCount = 0;
        } else if (i != this.mStrategy) {
            this.mRetreatCount = 1;
        } else {
            this.mRetreatCount++;
        }
        this.mStrategy = i;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public void setAlogStrategy(int i) {
        this.mAlogStrategy = i;
    }

    public int getAlogStrategy() {
        return this.mAlogStrategy;
    }

    public void setDelayTime(long j) {
        this.mDelayTime = j;
    }

    public long getDelayTime() {
        return this.mDelayTime;
    }

    public void setUpdateTime(long j) {
        this.mUpdateTime = j;
        try {
            this.mUpdateTimeFormat = DateUtils.getFileDateInstanceMs().format(new Date(this.mUpdateTime));
        } catch (Throwable unused) {
        }
    }

    public long getUpdateTime() {
        return this.mUpdateTime;
    }

    public String getAid() {
        return this.mAid;
    }

    public String getPath() {
        return this.mPath;
    }

    public String toString() {
        return "[" + this.mKeyId + " " + this.mStrategy + " " + this.mAlogStrategy + " " + this.mRetreatCount + " " + this.mDelayTime + "]";
    }
}
