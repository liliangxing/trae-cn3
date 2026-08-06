package com.bytedance.crash.entity;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ScheduleMsgItem {
    public static final int SCHEDULE_TYPE_IDLE = 0;
    public static final int SCHEDULE_TYPE_LAST_LONG_MSG = 4;
    public static final int SCHEDULE_TYPE_LONG_IDLE = 1;
    public static final int SCHEDULE_TYPE_LONG_MSG = 8;
    public static final int SCHEDULE_TYPE_MSG = 2;
    public static final int SCHEDULE_TYPE_MSGS = 9;
    public static final int SCHEDULE_TYPE_MSGS_IDLE = 7;
    public static final int SCHEDULE_TYPE_MSGS_LONG_IDLE = 5;
    public static final int SCHEDULE_TYPE_MSG_IDLE = 3;
    public static final int SCHEDULE_TYPE_MSG_LONG_IDLE = 6;
    public String mBlockStack;
    public long mDuration;
    public long mDurationCpuTime;
    public long mDurationTick;
    public boolean mIncluseIdle;
    public int mMsgs;
    public String mScheduleMsg;
    public String mSeriousBlockStack;
    public int mType;
    public String uuid;

    public boolean isIdle() {
        int i = this.mType;
        return i == 0 || i == 1 || i == 3 || i == 6 || i == 7 || i == 5;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", this.mScheduleMsg);
            jSONObject.put("cpuDuration", this.mDurationCpuTime);
            jSONObject.put("duration", this.mDuration);
            jSONObject.put("type", this.mType);
            jSONObject.put("count", this.mMsgs);
            String str = this.mBlockStack;
            if (str != null) {
                jSONObject.put("block_stack", str);
                jSONObject.put("block_uuid", this.uuid);
            }
            String str2 = this.mSeriousBlockStack;
            if (str2 != null) {
                jSONObject.put("sblock_stack", str2);
                jSONObject.put("sblock_uuid", this.uuid);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        int i = this.mType;
        if (i == 0) {
            return "[[[ IDLE  ]]] mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime;
        }
        if (i == 1) {
            return "[[[ Long IDLE  ]]] mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime;
        }
        if (i == 2) {
            return "[[[  1 msg  ]]] mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime + ", msg:" + this.mScheduleMsg;
        }
        if (i == 3) {
            return "[[[ 1 msg + IDLE  ]]] mDuration：" + this.mDuration + ",cpuTime:" + this.mDurationCpuTime;
        }
        if (i == 4) {
            return "[[[ " + (this.mMsgs - 1) + " msgs  ]]] mDuration：" + this.mDuration + "cpuTime:" + this.mDurationCpuTime + " msg:" + this.mScheduleMsg;
        }
        if (i == 5) {
            return "[[[ " + this.mMsgs + " msgs ]]]  mDuration：" + this.mDuration + "cpuTime:" + this.mDurationCpuTime;
        }
        if (i == 6) {
            return "[[[  1 msg  ]]]  mDuration：" + this.mDuration + "cpuTime:" + this.mDurationCpuTime;
        }
        if (i == 7) {
            return "[[[ " + this.mMsgs + " msgs + IDLE  ]]] mDuration：" + this.mDuration + " cost cpuTime:" + this.mDurationCpuTime;
        }
        if (i == 8) {
            return "[[[ 1 msgs ]]] mDuration：" + this.mDuration + " cost cpuTime:" + this.mDurationCpuTime + " msg:" + this.mScheduleMsg;
        }
        if (i == 9) {
            return "[[[ " + this.mMsgs + " msgs ]]] mDuration：" + this.mDuration + " cost cpuTime:" + this.mDurationCpuTime;
        }
        return "=========   UNKNOW =========  Type: msgs:" + this.mMsgs;
    }
}
