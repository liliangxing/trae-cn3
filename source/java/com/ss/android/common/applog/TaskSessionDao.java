package com.ss.android.common.applog;

import android.content.Context;
import android.util.Pair;
import com.ss.android.common.applog.task.TaskSession;
import com.ss.android.common.util.TeaLog;
import java.util.ConcurrentModificationException;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TaskSessionDao {
    private static volatile TaskSessionDao inst;
    private Context context;

    private TaskSessionDao(Context context) {
        this.context = context.getApplicationContext();
    }

    public static TaskSessionDao inst(Context context) {
        if (inst == null) {
            synchronized (TaskSessionDao.class) {
                if (inst == null) {
                    inst = new TaskSessionDao(context);
                }
            }
        }
        return inst;
    }

    public void saveTaskSession(TaskSession taskSession) {
        TaskSession copyOf = TaskSession.copyOf(taskSession);
        if (copyOf != null) {
            LogQueueSaveAndSendTaskSession logQueueSaveAndSendTaskSession = new LogQueueSaveAndSendTaskSession();
            logQueueSaveAndSendTaskSession.taskSession = copyOf;
            AppLog appLog = AppLog.getInstance(this.context);
            if (appLog != null) {
                appLog.enqueue(logQueueSaveAndSendTaskSession);
            }
        }
    }

    public Pair<Long, String> saveTaskSession(TaskSession taskSession, JSONObject jSONObject) {
        String jSONObject2;
        if (taskSession == null) {
            return null;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("magic_tag", "ss_app_log");
            jSONObject3.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(AppLog.KEY_DATETIME, AppLog.formatDate(taskSession.getStartTime()));
            jSONObject4.put(AppLog.KEY_LOCAL_TIME_MS, System.currentTimeMillis());
            jSONObject4.put(AppLog.KEY_SESSION_ID, taskSession.getSessionId());
            jSONObject4.put("bg_session", 1);
            if (taskSession.hasFrontSession()) {
                jSONObject4.put("from_session", taskSession.getFrontSessionId());
            }
            if (taskSession.hasEndSession()) {
                jSONObject4.put("to_session", taskSession.getEndSessionId());
            }
            jSONObject4.put("duration", taskSession.getDurationInSecond());
            jSONObject4.put("session_type", taskSession.getSessionType());
            jSONObject4.put("is_background", false);
            AppLog.tryPutEventIndex(jSONObject4);
            jSONArray.put(jSONObject4);
            jSONObject3.put("terminate", jSONArray);
            TeaLog.Task.m83d("save task session to db : " + taskSession.toString());
            try {
                jSONObject2 = jSONObject3.toString();
            } catch (ConcurrentModificationException unused) {
                jSONObject2 = jSONObject3.toString();
            }
            return Pair.create(Long.valueOf(DBHelper.getInstance(this.context).insertLog(jSONObject2, 0)), jSONObject2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String genSessionId() {
        return AppLog.genSession();
    }

    public static long genTeaEventIndex() {
        return AppLog.genEventIndex();
    }
}
