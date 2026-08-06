package com.ss.android.common.applog.task;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.common.applog.TaskSessionDao;
import com.ss.android.common.applog.TeaThread;
import com.ss.android.common.util.TeaLog;
import com.ss.android.deviceregister.base.AppLogConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TaskModel {
    private static final String KEY_TASK_SESSION = "key_task_session";
    private Context context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskModel(Context context) {
        init(context);
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();
        TaskSessionDao.inst(context);
        TeaThread.getInst().ensureTeaThreadLite(new Runnable() { // from class: com.ss.android.common.applog.task.TaskModel.1
            @Override // java.lang.Runnable
            public void run() {
                TaskSession savedTaskSessionInSp = TaskModel.this.getSavedTaskSessionInSp();
                if (savedTaskSessionInSp != null) {
                    TaskModel.this.saveTaskSessionToDb(savedTaskSessionInSp);
                }
                TaskModel.this.clearSessionSp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TaskSession getSavedTaskSessionInSp() {
        return TaskSession.fromString(this.context.getSharedPreferences(AppLogConstants.getSPName(), 0).getString(KEY_TASK_SESSION, ""));
    }

    public void saveTaskSessionToDb(TaskSession taskSession) {
        TaskSessionDao.inst(this.context).saveTaskSession(taskSession);
    }

    public void saveTaskSessionToSp(TaskSession taskSession) {
        if (taskSession == null) {
            return;
        }
        TeaLog.Task.m83d("saveTaskSessionToSp : " + taskSession);
        saveTaskSessionToSp(taskSession.toJsonString());
    }

    private void saveTaskSessionToSp(String str) {
        if (str == null) {
            str = "";
        }
        try {
            SharedPreferences.Editor edit = this.context.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
            edit.putString(KEY_TASK_SESSION, str);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public void clearSessionSp() {
        TeaLog.Task.m83d("clear task session sp");
        saveTaskSessionToSp("");
    }
}
