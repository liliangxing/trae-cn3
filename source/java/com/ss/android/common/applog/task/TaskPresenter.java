package com.ss.android.common.applog.task;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.ss.android.common.applog.TeaThread;
import com.ss.android.common.applog.TeaUtils;
import com.ss.android.common.util.TeaLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TaskPresenter {
    private static final long IGNORE_BG_TASK_THRESHOLD = 30000;
    private static final long MERGE_BG_TASK_THRESHOLD = 15000;
    private static final int MESSAGE_CODE_UPDATE_SESSION = 1;
    private static final long REFRESH_SESSION_INTERVAL = 5000;
    private static final String TAG = "TaskPresenter";
    private static volatile TaskPresenter sInstance;
    private static volatile TaskCallback sTaskCallback;
    private Context context;
    private TaskSession currentSession;
    private TaskModel taskModel;
    private Handler teaThreadHandler;
    private boolean hasRunningTask = false;
    private volatile boolean isTaskRunning = false;
    private boolean isBackground = true;
    private long lastEnterBgTime = TeaUtils.now();
    private final List<TaskSession> pendingSessions = new ArrayList();
    private boolean isTaskSessionFired = false;
    private final Runnable closeCurrentSession = new Runnable() { // from class: com.ss.android.common.applog.task.TaskPresenter.3
        @Override // java.lang.Runnable
        public void run() {
            TeaLog.Task.m83d("closeCurrentSession currentSession is null : " + (TaskPresenter.this.currentSession == null));
            if (TaskPresenter.this.currentSession != null) {
                if (TaskPresenter.this.isTaskSessionFired) {
                    TeaLog.Task.m84i("is fired : so save session to Db");
                    TaskPresenter.this.taskModel.saveTaskSessionToDb(TaskPresenter.this.currentSession);
                } else {
                    TeaLog.Task.m84i("is not fired : so save session in pendingSessions");
                    TaskPresenter.this.pendingSessions.add(TaskPresenter.this.currentSession);
                }
                TaskPresenter.this.currentSession = null;
                TaskPresenter.this.taskModel.clearSessionSp();
                return;
            }
            TeaLog.Task.m85w("closeCurrentSession found that currentSession is null");
        }
    };
    private final Runnable firePendingSessions = new Runnable() { // from class: com.ss.android.common.applog.task.TaskPresenter.4
        @Override // java.lang.Runnable
        public void run() {
            TaskPresenter.this.isTaskSessionFired = true;
            TeaLog.Task.m84i("fire pending Sessions");
            Iterator it = new ArrayList(TaskPresenter.this.pendingSessions).iterator();
            while (it.hasNext()) {
                TaskPresenter.this.taskModel.saveTaskSessionToDb((TaskSession) it.next());
            }
            TaskPresenter.this.pendingSessions.clear();
        }
    };

    private Handler createHandler() {
        return new Handler(TeaThread.getInst().getLooper()) { // from class: com.ss.android.common.applog.task.TaskPresenter.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                if (TaskPresenter.this.currentSession != null) {
                    Object obj = message.obj;
                    if (obj instanceof String) {
                        String str = (String) obj;
                        boolean equals = TeaUtils.equals(str, TaskPresenter.this.currentSession.getSessionId());
                        boolean z = TaskPresenter.this.isBackground && TaskPresenter.this.isTaskRunning;
                        if (equals && z) {
                            TaskPresenter.this.currentSession.setLatestEndTime(System.currentTimeMillis());
                            TaskPresenter.this.taskModel.saveTaskSessionToSp(TaskPresenter.this.currentSession);
                            TaskPresenter.this.sendRefreshSessionMsg(str);
                            TaskPresenter.this.tryCorrectTaskState();
                            return;
                        }
                    }
                }
                TaskPresenter.this.taskModel.clearSessionSp();
                TaskPresenter.this.tryCorrectTaskState();
            }
        };
    }

    private Handler getTeaThreadHandler() {
        if (this.teaThreadHandler == null) {
            synchronized (this) {
                if (this.teaThreadHandler == null) {
                    this.teaThreadHandler = createHandler();
                }
            }
        }
        return this.teaThreadHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryCorrectTaskState() {
        boolean isTaskRunning;
        TaskCallback taskCallback = sTaskCallback;
        if (taskCallback == null || this.isTaskRunning == (isTaskRunning = taskCallback.isTaskRunning())) {
            return;
        }
        TeaLog.Task.m84i("tryCorrectTaskState newIsTaskRunning : " + isTaskRunning);
        if (isTaskRunning) {
            onTaskResume();
        } else {
            onTaskPause();
        }
    }

    private TaskPresenter(Context context) {
        this.context = context.getApplicationContext();
        this.taskModel = new TaskModel(context);
    }

    public static TaskPresenter inst(Context context) {
        if (sInstance == null) {
            synchronized (TaskPresenter.class) {
                if (sInstance == null) {
                    sInstance = new TaskPresenter(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    public void onExitBg(final long j, final String str) {
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.ss.android.common.applog.task.TaskPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                TeaLog.Task.m83d("onExitBg");
                if (TaskPresenter.this.isBackground) {
                    TaskPresenter.this.isBackground = false;
                    TeaThread.getInst().removeCallbacks(TaskPresenter.this.firePendingSessions);
                    TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                    TaskPresenter.this.cancelRefreshSession();
                    TaskPresenter.this.taskModel.clearSessionSp();
                    if (TaskPresenter.this.hasRunningTask) {
                        if (j - TaskPresenter.this.lastEnterBgTime > TaskPresenter.IGNORE_BG_TASK_THRESHOLD) {
                            if (TaskPresenter.this.currentSession != null) {
                                TeaLog.Task.m84i("close current session");
                                if (TaskPresenter.this.isTaskRunning) {
                                    TaskPresenter.this.currentSession.setEndSessionId(str);
                                    TaskPresenter.this.currentSession.setLatestEndTime(j);
                                }
                                TaskPresenter.this.taskModel.saveTaskSessionToDb(TaskPresenter.this.currentSession);
                                TaskPresenter.this.currentSession = null;
                            }
                            TaskPresenter.this.firePendingSessions.run();
                        } else {
                            TeaLog.Task.m84i("time diff is less than 30000 , so clear current session");
                            TaskPresenter.this.pendingSessions.clear();
                            TaskPresenter.this.currentSession = null;
                        }
                    }
                    TaskPresenter.this.clearState();
                }
            }
        });
    }

    public void onTaskPause() {
        final long now = TeaUtils.now();
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.ss.android.common.applog.task.TaskPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                if (TaskPresenter.this.isTaskRunning) {
                    TeaLog.Task.m83d("onTaskPause");
                    TaskPresenter.this.isTaskRunning = false;
                    if (TaskPresenter.this.isBackground) {
                        if (TaskPresenter.this.currentSession != null) {
                            TeaLog.Task.m84i("wait 15000 to close current session");
                            TaskPresenter.this.currentSession.setLatestEndTime(now);
                            TeaThread.getInst().repost(TaskPresenter.this.closeCurrentSession, 15000L);
                            TaskPresenter.this.taskModel.saveTaskSessionToSp(TaskPresenter.this.currentSession);
                            TaskPresenter.this.cancelRefreshSession();
                            return;
                        }
                        TeaLog.Task.m85w("onTaskPause when bg, but no session available");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.hasRunningTask = false;
        this.pendingSessions.clear();
        this.isTaskSessionFired = false;
    }

    public void onEnterBg(final long j, final String str) {
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.ss.android.common.applog.task.TaskPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                TeaLog.Task.m83d("onEnterBg");
                if (TaskPresenter.this.isBackground) {
                    return;
                }
                TaskPresenter.this.clearState();
                TeaThread.getInst().repost(TaskPresenter.this.firePendingSessions, 30010L);
                TaskPresenter.this.lastEnterBgTime = j;
                TaskPresenter.this.isBackground = true;
                if (TaskPresenter.this.isTaskRunning) {
                    TaskPresenter.this.hasRunningTask = true;
                    if (TaskPresenter.this.currentSession != null) {
                        TeaLog.Task.m85w("enter bg , bug there is already a bg task is running");
                    }
                    TeaLog.Task.m84i("task is running , so create a new task session");
                    TaskPresenter.this.currentSession = new TaskSession(j);
                    TaskPresenter.this.currentSession.setFrontSessionId(str);
                    TaskPresenter taskPresenter = TaskPresenter.this;
                    taskPresenter.sendRefreshSessionMsg(taskPresenter.currentSession.getSessionId());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRefreshSessionMsg(String str) {
        Handler teaThreadHandler = getTeaThreadHandler();
        teaThreadHandler.removeMessages(1);
        teaThreadHandler.sendMessageDelayed(Message.obtain(teaThreadHandler, 1, str), REFRESH_SESSION_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefreshSession() {
        getTeaThreadHandler().removeMessages(1);
    }

    public void onTaskResume() {
        final long now = TeaUtils.now();
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.ss.android.common.applog.task.TaskPresenter.7
            @Override // java.lang.Runnable
            public void run() {
                if (TaskPresenter.this.isTaskRunning) {
                    return;
                }
                TeaLog.Task.m83d("onTaskResume");
                TaskPresenter.this.isTaskRunning = true;
                if (TaskPresenter.this.isBackground) {
                    TaskPresenter.this.hasRunningTask = true;
                    if (TaskPresenter.this.currentSession != null) {
                        long latestEndTime = now - TaskPresenter.this.currentSession.getLatestEndTime();
                        if (latestEndTime <= 15000) {
                            TeaLog.Task.m84i("task time diff " + latestEndTime + " , is less than 15000 so , merge in previous session");
                            TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                            TaskPresenter.this.currentSession.addNonTaskTime(latestEndTime);
                            TaskPresenter.this.currentSession.setLatestEndTime(now);
                            TaskPresenter.this.taskModel.saveTaskSessionToSp(TaskPresenter.this.currentSession);
                            TaskPresenter taskPresenter = TaskPresenter.this;
                            taskPresenter.sendRefreshSessionMsg(taskPresenter.currentSession.getSessionId());
                            return;
                        }
                        TeaLog.Task.m84i("task time diff " + latestEndTime + " , is bigger than 15000 so close current session and create new session");
                        TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                        TaskPresenter.this.closeCurrentSession.run();
                        TaskPresenter.this.currentSession = new TaskSession(now);
                        TaskPresenter.this.taskModel.clearSessionSp();
                        TaskPresenter taskPresenter2 = TaskPresenter.this;
                        taskPresenter2.sendRefreshSessionMsg(taskPresenter2.currentSession.getSessionId());
                        return;
                    }
                    TeaLog.Task.m84i("pure bg launch , so create a new task session");
                    TaskPresenter.this.currentSession = new TaskSession(now);
                    TaskPresenter.this.taskModel.clearSessionSp();
                    TaskPresenter taskPresenter3 = TaskPresenter.this;
                    taskPresenter3.sendRefreshSessionMsg(taskPresenter3.currentSession.getSessionId());
                }
            }
        });
    }

    public static void registerTaskCallback(TaskCallback taskCallback) {
        sTaskCallback = taskCallback;
    }
}
