package com.bytedance.applog.task;

import android.os.Handler;
import android.os.Message;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.collector.NavigatorCallback;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TaskPresenter {
    private static final long IGNORE_BG_TASK_THRESHOLD = 30000;
    private static final long MERGE_BG_TASK_THRESHOLD = 15000;
    private static final int MESSAGE_CODE_UPDATE_SESSION = 1;
    private static final long REFRESH_SESSION_INTERVAL = 5000;
    private static final String TASK_ACTIVITY_NAME = "__bg_session";
    private static final List<String> logTags = Collections.singletonList("TaskPresenter");
    private final AppLogInstance appLogInstance;
    private TaskSession currentSession;
    private volatile NavigatorCallback sNavigatorCallback;
    private volatile BgSessionTaskCallback sTaskCallback;
    private final BgSessionTaskModel taskModel;
    private Handler teaThreadHandler;
    private boolean hasRunningTask = false;
    private volatile boolean isTaskRunning = false;
    private boolean isBackground = true;
    private long lastEnterBgTime = System.currentTimeMillis();
    private final List<TaskSession> pendingSessions = new ArrayList();
    private boolean isTaskSessionFired = false;
    private final Runnable closeCurrentSession = new Runnable() { // from class: com.bytedance.applog.task.TaskPresenter.2
        @Override // java.lang.Runnable
        public void run() {
            TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] closeCurrentSession currentSession is null : " + (TaskPresenter.this.currentSession == null), new Object[0]);
            if (TaskPresenter.this.currentSession != null) {
                if (TaskPresenter.this.isTaskSessionFired) {
                    TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] is fired : so save session to Db", new Object[0]);
                    TaskPresenter.this.taskModel.saveTaskSessionToDb(TaskPresenter.this.currentSession);
                } else {
                    TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] is not fired : so save session in pendingSessions", new Object[0]);
                    TaskPresenter.this.pendingSessions.add(TaskPresenter.this.currentSession);
                }
                TaskPresenter.this.currentSession = null;
                TaskPresenter.this.taskModel.clearSessionSp();
                return;
            }
            TaskPresenter.this.appLogInstance.getLogger().warn(TaskPresenter.logTags, "[Task] closeCurrentSession found that currentSession is null", new Object[0]);
        }
    };
    private final Runnable firePendingSessions = new Runnable() { // from class: com.bytedance.applog.task.TaskPresenter.3
        @Override // java.lang.Runnable
        public void run() {
            TaskPresenter.this.isTaskSessionFired = true;
            TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] fire pending Sessions", new Object[0]);
            Iterator it = new ArrayList(TaskPresenter.this.pendingSessions).iterator();
            while (it.hasNext()) {
                TaskPresenter.this.taskModel.saveTaskSessionToDb((TaskSession) it.next());
            }
            TaskPresenter.this.pendingSessions.clear();
        }
    };

    public void registerTaskCallback(BgSessionTaskCallback bgSessionTaskCallback) {
        this.sTaskCallback = bgSessionTaskCallback;
    }

    public void setBgSessionTaskNavigatorCallback(NavigatorCallback navigatorCallback) {
        this.sNavigatorCallback = navigatorCallback;
    }

    private Handler createHandler() {
        return new Handler(TeaThread.getInst().getLooper()) { // from class: com.bytedance.applog.task.TaskPresenter.1
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
                        boolean equals = Utils.equals(str, TaskPresenter.this.currentSession.getSessionId());
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
        BgSessionTaskCallback bgSessionTaskCallback = this.sTaskCallback;
        if (bgSessionTaskCallback == null || this.isTaskRunning == (isTaskRunning = bgSessionTaskCallback.isTaskRunning())) {
            return;
        }
        this.appLogInstance.getLogger().info(logTags, "[Task] tryCorrectTaskState newIsTaskRunning : " + isTaskRunning, new Object[0]);
        if (isTaskRunning) {
            onTaskResume();
        } else {
            onTaskPause();
        }
    }

    public TaskPresenter(AppLogInstance appLogInstance, DbStore dbStore, DeviceManager deviceManager) {
        this.appLogInstance = appLogInstance;
        this.taskModel = new BgSessionTaskModel(appLogInstance, dbStore, deviceManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.hasRunningTask = false;
        this.pendingSessions.clear();
        this.isTaskSessionFired = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRefreshSessionMsg(String str) {
        Handler teaThreadHandler = getTeaThreadHandler();
        teaThreadHandler.removeMessages(1);
        teaThreadHandler.sendMessageDelayed(Message.obtain(teaThreadHandler, 1, str), 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRefreshSession() {
        getTeaThreadHandler().removeMessages(1);
    }

    public void onTaskResume() {
        final long currentTimeMillis = System.currentTimeMillis();
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.bytedance.applog.task.TaskPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                if (TaskPresenter.this.isTaskRunning) {
                    return;
                }
                TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] onTaskResume", new Object[0]);
                TaskPresenter.this.isTaskRunning = true;
                if (TaskPresenter.this.isBackground) {
                    TaskPresenter.this.hasRunningTask = true;
                    if (TaskPresenter.this.currentSession != null) {
                        long latestEndTime = currentTimeMillis - TaskPresenter.this.currentSession.getLatestEndTime();
                        if (latestEndTime <= 15000) {
                            TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] task time diff " + latestEndTime + " , is less than 15000 so , merge in previous session", new Object[0]);
                            TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                            TaskPresenter.this.currentSession.addNonTaskTime(latestEndTime);
                            TaskPresenter.this.currentSession.setLatestEndTime(currentTimeMillis);
                            TaskPresenter.this.taskModel.saveTaskSessionToSp(TaskPresenter.this.currentSession);
                            TaskPresenter taskPresenter = TaskPresenter.this;
                            taskPresenter.sendRefreshSessionMsg(taskPresenter.currentSession.getSessionId());
                        } else {
                            TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] task time diff " + latestEndTime + " , is bigger than 15000 so close current session and create new session", new Object[0]);
                            TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                            TaskPresenter.this.closeCurrentSession.run();
                            TaskPresenter.this.currentSession = new TaskSession(currentTimeMillis, TaskPresenter.this.appLogInstance.getNextEventIndex());
                            TaskPresenter.this.taskModel.clearSessionSp();
                            TaskPresenter taskPresenter2 = TaskPresenter.this;
                            taskPresenter2.sendRefreshSessionMsg(taskPresenter2.currentSession.getSessionId());
                        }
                    } else {
                        TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] pure bg launch , so create a new task session", new Object[0]);
                        TaskPresenter.this.currentSession = new TaskSession(currentTimeMillis, TaskPresenter.this.appLogInstance.getNextEventIndex());
                        TaskPresenter.this.taskModel.clearSessionSp();
                        TaskPresenter taskPresenter3 = TaskPresenter.this;
                        taskPresenter3.sendRefreshSessionMsg(taskPresenter3.currentSession.getSessionId());
                    }
                    if (TaskPresenter.this.currentSession == null || TaskPresenter.this.sNavigatorCallback == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    TaskPresenter.this.sNavigatorCallback.onResume(TaskPresenter.TASK_ACTIVITY_NAME, jSONObject);
                    if (jSONObject.length() > 0) {
                        TaskPresenter.this.currentSession.addFlatParams(jSONObject);
                    }
                }
            }
        });
    }

    public void onTaskPause() {
        final long currentTimeMillis = System.currentTimeMillis();
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.bytedance.applog.task.TaskPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                if (TaskPresenter.this.isTaskRunning) {
                    TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] onTaskPause", new Object[0]);
                    TaskPresenter.this.isTaskRunning = false;
                    if (TaskPresenter.this.isBackground) {
                        if (TaskPresenter.this.currentSession != null) {
                            TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] wait 15000 to close current session", new Object[0]);
                            TaskPresenter.this.currentSession.setLatestEndTime(currentTimeMillis);
                            if (TaskPresenter.this.sNavigatorCallback != null) {
                                JSONObject jSONObject = new JSONObject();
                                TaskPresenter.this.sNavigatorCallback.onPause(TaskPresenter.TASK_ACTIVITY_NAME, jSONObject);
                                if (jSONObject.length() > 0) {
                                    TaskPresenter.this.currentSession.addFlatParams(jSONObject);
                                }
                            }
                            TeaThread.getInst().repost(TaskPresenter.this.closeCurrentSession, 15000L);
                            TaskPresenter.this.taskModel.saveTaskSessionToSp(TaskPresenter.this.currentSession);
                            TaskPresenter.this.cancelRefreshSession();
                            if (TaskPresenter.this.appLogInstance.isEnableBgSessionTaskReportOnPause() && TaskPresenter.this.taskModel.report(TaskPresenter.this.currentSession)) {
                                TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                                TaskPresenter.this.currentSession = null;
                                return;
                            }
                            return;
                        }
                        TaskPresenter.this.appLogInstance.getLogger().warn(TaskPresenter.logTags, "[Task] onTaskPause when bg, but no session available", new Object[0]);
                    }
                }
            }
        });
    }

    public void onExitBg(final long j, final String str) {
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.bytedance.applog.task.TaskPresenter.6
            @Override // java.lang.Runnable
            public void run() {
                TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] onExitBg", new Object[0]);
                if (TaskPresenter.this.isBackground) {
                    TaskPresenter.this.isBackground = false;
                    TeaThread.getInst().removeCallbacks(TaskPresenter.this.firePendingSessions);
                    TeaThread.getInst().removeCallbacks(TaskPresenter.this.closeCurrentSession);
                    TaskPresenter.this.cancelRefreshSession();
                    TaskPresenter.this.taskModel.clearSessionSp();
                    if (TaskPresenter.this.hasRunningTask) {
                        if (j - TaskPresenter.this.lastEnterBgTime > 30000) {
                            if (TaskPresenter.this.currentSession != null) {
                                TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] close current session", new Object[0]);
                                if (TaskPresenter.this.isTaskRunning) {
                                    TaskPresenter.this.currentSession.setEndSessionId(str);
                                    TaskPresenter.this.currentSession.setLatestEndTime(j);
                                }
                                TaskPresenter.this.taskModel.saveTaskSessionToDb(TaskPresenter.this.currentSession);
                                TaskPresenter.this.currentSession = null;
                            }
                            TaskPresenter.this.firePendingSessions.run();
                        } else {
                            TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] time diff is less than 30000 , so clear current session", new Object[0]);
                            TaskPresenter.this.pendingSessions.clear();
                            TaskPresenter.this.currentSession = null;
                        }
                    }
                    TaskPresenter.this.clearState();
                }
            }
        });
    }

    public void onEnterBg(final long j, final String str) {
        TeaThread.getInst().ensureTeaThread(new Runnable() { // from class: com.bytedance.applog.task.TaskPresenter.7
            @Override // java.lang.Runnable
            public void run() {
                TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] onEnterBg", new Object[0]);
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
                        TaskPresenter.this.appLogInstance.getLogger().warn(TaskPresenter.logTags, "[Task] enter bg , bug there is already a bg task is running", new Object[0]);
                    }
                    TaskPresenter.this.appLogInstance.getLogger().debug(TaskPresenter.logTags, "[Task] task is running , so create a new task session", new Object[0]);
                    TaskPresenter.this.currentSession = new TaskSession(j, TaskPresenter.this.appLogInstance.getNextEventIndex());
                    TaskPresenter.this.currentSession.setFrontSessionId(str);
                    TaskPresenter taskPresenter = TaskPresenter.this;
                    taskPresenter.sendRefreshSessionMsg(taskPresenter.currentSession.getSessionId());
                }
            }
        });
    }
}
