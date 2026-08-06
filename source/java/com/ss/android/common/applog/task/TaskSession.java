package com.ss.android.common.applog.task;

import android.text.TextUtils;
import com.ss.android.common.applog.TaskSessionDao;
import com.ss.android.common.applog.TeaUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class TaskSession {
    private String endSessionId;
    private String frontSessionId;
    private boolean isEndContinuous;
    private boolean isFrontContinuous;
    private long latestEndTime;
    private long nonTaskTime;
    private String sessionId;
    private long startTime;
    private long teaEventIndex;

    public boolean hasFrontSession() {
        return !TextUtils.isEmpty(this.frontSessionId);
    }

    public boolean hasEndSession() {
        return !TextUtils.isEmpty(this.endSessionId);
    }

    public boolean isFrontContinuous() {
        return this.isFrontContinuous;
    }

    public String getFrontSessionId() {
        return this.frontSessionId;
    }

    public boolean isEndContinuous() {
        return this.isEndContinuous;
    }

    public String getEndSessionId() {
        return this.endSessionId;
    }

    public static TaskSession copyOf(TaskSession taskSession) {
        if (taskSession == null) {
            return null;
        }
        TaskSession taskSession2 = new TaskSession();
        taskSession2.startTime = taskSession.startTime;
        taskSession2.sessionId = taskSession.sessionId;
        taskSession2.isFrontContinuous = taskSession.isFrontContinuous;
        taskSession2.frontSessionId = taskSession.frontSessionId;
        taskSession2.isEndContinuous = taskSession.isEndContinuous;
        taskSession2.endSessionId = taskSession.endSessionId;
        taskSession2.latestEndTime = taskSession.latestEndTime;
        taskSession2.nonTaskTime = taskSession.nonTaskTime;
        taskSession2.teaEventIndex = taskSession.teaEventIndex;
        return taskSession2;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start_time", this.startTime);
            jSONObject.put("session_id", this.sessionId);
            jSONObject.put("is_front_continuous", this.isFrontContinuous);
            jSONObject.put("front_session_id", this.frontSessionId);
            jSONObject.put("is_end_continuous", this.isEndContinuous);
            jSONObject.put("end_session_id", this.endSessionId);
            jSONObject.put("latest_end_time", this.latestEndTime);
            jSONObject.put("non_task_time", this.nonTaskTime);
            jSONObject.put("tea_event_index", this.teaEventIndex);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static TaskSession fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("session_id", "");
            TaskSession taskSession = new TaskSession();
            taskSession.sessionId = optString;
            taskSession.startTime = TeaUtils.optLong(jSONObject, "start_time");
            taskSession.isFrontContinuous = jSONObject.optBoolean("is_front_continuous", false);
            taskSession.frontSessionId = jSONObject.optString("front_session_id", "");
            taskSession.isEndContinuous = jSONObject.optBoolean("is_end_continuous", false);
            taskSession.endSessionId = jSONObject.optString("end_session_id", "");
            taskSession.latestEndTime = TeaUtils.optLong(jSONObject, "latest_end_time");
            taskSession.nonTaskTime = TeaUtils.optLong(jSONObject, "non_task_time");
            taskSession.teaEventIndex = TeaUtils.optLong(jSONObject, "tea_event_index");
            return taskSession;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private TaskSession() {
        this.isFrontContinuous = false;
        this.frontSessionId = null;
        this.isEndContinuous = false;
        this.endSessionId = null;
        this.nonTaskTime = 0L;
        this.teaEventIndex = 0L;
    }

    public TaskSession(long j) {
        this.isFrontContinuous = false;
        this.frontSessionId = null;
        this.isEndContinuous = false;
        this.endSessionId = null;
        this.nonTaskTime = 0L;
        this.teaEventIndex = 0L;
        this.startTime = j;
        this.sessionId = TaskSessionDao.genSessionId();
        this.teaEventIndex = TaskSessionDao.genTeaEventIndex();
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getSessionType() {
        boolean z = this.isFrontContinuous;
        boolean z2 = this.isEndContinuous;
        if (!z && !z2) {
            return 1;
        }
        if (!z || z2) {
            return (z || !z2) ? 4 : 3;
        }
        return 2;
    }

    public void setFrontSessionId(String str) {
        this.isFrontContinuous = true;
        this.frontSessionId = str;
    }

    public void setEndSessionId(String str) {
        this.isEndContinuous = true;
        this.endSessionId = str;
    }

    public void setLatestEndTime(long j) {
        this.latestEndTime = j;
    }

    public long getLatestEndTime() {
        return this.latestEndTime;
    }

    public void addNonTaskTime(long j) {
        this.nonTaskTime += j;
    }

    public long getDuration() {
        return Math.max(0L, (this.latestEndTime - this.startTime) - this.nonTaskTime);
    }

    public long getDurationInSecond() {
        return Math.max(1L, getDuration() / 1000);
    }

    public String toString() {
        return toJsonString();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEventIndex() {
        return this.teaEventIndex;
    }
}
