package com.ss.alive.monitor;

import android.app.servertransaction.ClientTransaction;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.LaunchActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import com.ss.alive.monitor.p002db.MonitorLiveDBHelperDBHelper;
import com.ss.alive.monitor.p002db.ProcessStartDbInfo;
import com.ss.alive.monitor.reflect.FieldUtils;
import com.ss.alive.monitor.reflect.MethodUtils;
import com.ss.alive.monitor.track.ActivityAliveTracker;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ActivityThreadHandler {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int EXECUTE_TRANSACTION = 159;
    public static final int LAUNCH_ACTIVITY = 100;
    public static final int MAX_LOG_NUM = 3;
    public static final int RECEIVER = 113;
    public static final int SERVICE_ARGS = 115;
    public static final int START_BY_ACTIVITY = 3;
    public static final int START_BY_OTHER = 0;
    public static final int START_BY_RECEIVER = 2;
    public static final int START_BY_SERVICE = 1;
    private static final String TAG = "ActivityThreadHandler";
    private static int sStartType;
    private final ActivityAliveTracker mActivityAliveTracker;
    private Context mContext;
    private int mLogNum = 0;
    private boolean mIsFirst = true;
    private boolean mIsEndLog = false;
    private String mProcessName = "";
    private ProcessStartInfo mProcessStartInfo = new ProcessStartInfo();
    private List<Integer> filterList = new ArrayList();
    private boolean mWriteSuccess = false;
    private final Object mWriteLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityThreadHandler(Context context, ActivityAliveTracker activityAliveTracker) {
        this.mContext = context;
        this.mActivityAliveTracker = activityAliveTracker;
        this.filterList.add(100);
        this.filterList.add(113);
        this.filterList.add(114);
        this.filterList.add(115);
        this.filterList.add(121);
        if (Build.VERSION.SDK_INT >= 28) {
            this.filterList.add(159);
        }
    }

    public void handleMessage(Message message) {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "handleMessage:  " + message.what);
            }
            if (this.mIsEndLog) {
                return;
            }
            if (this.mIsFirst && !this.filterList.contains(Integer.valueOf(message.what)) && this.mProcessStartInfo.messageStrList.size() < 10) {
                Logger.d(TAG, "handleMessage: ignore " + message.what);
                return;
            }
            if (this.mIsFirst) {
                this.mIsFirst = false;
                this.mProcessStartInfo.startTime = ToolUtils.currentTimeMillis();
                if (message.what == 114) {
                    sStartType = 1;
                } else if (message.what == 113) {
                    sStartType = 2;
                } else if (message.what == 100) {
                    sStartType = 3;
                } else if (message.what == 159) {
                    sStartType = parseTransaction(message.obj);
                }
            }
            int i = this.mLogNum;
            if (i > 3) {
                Logger.d(TAG, "handleMessage: out LogNum");
                processLogEnd();
                return;
            }
            this.mLogNum = i + 1;
            if (TextUtils.isEmpty(this.mProcessName)) {
                this.mProcessName = com.ss.alive.monitor.util.ToolUtils.getCurProcessName(this.mContext);
            }
            this.mProcessStartInfo.process = this.mProcessName;
            this.mProcessStartInfo.messageStrList.add(message.toString());
            PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
            if (pushCommonConfiguration != null && !pushCommonConfiguration.mIPushCommonConfiguration.optActivityThreadHandlerGetScreenState()) {
                this.mProcessStartInfo.screenState = com.ss.alive.monitor.util.ToolUtils.getScreenState(this.mContext);
            } else {
                this.mProcessStartInfo.screenState = 0;
            }
            int i2 = sStartType;
            if (i2 == 1) {
                processService(message);
                return;
            }
            if (i2 == 2) {
                processReceiver(message);
            } else if (i2 == 3) {
                processActivity(message);
                this.mActivityAliveTracker.trackPackageName(this.mContext, this.mProcessStartInfo, new PkgTrackListener() { // from class: com.ss.alive.monitor.ActivityThreadHandler.1
                    @Override // com.ss.alive.monitor.PkgTrackListener
                    public void onTrackSuccess(String str) {
                        ActivityThreadHandler.this.mProcessStartInfo.referrer = str;
                        ActivityThreadHandler.this.updateLog();
                    }
                });
            } else {
                this.mProcessStartInfo.startFlag = 5;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private int parseTransaction(Object obj) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (obj instanceof ClientTransaction) {
            return MethodUtils.getMethodWithAccessible(ClientTransaction.class, "getLifecycleStateRequest", new Class[0]).invoke(obj, new Object[0]) instanceof ResumeActivityItem ? 3 : 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLog() {
        final String jSONObject = this.mProcessStartInfo.toJson().toString();
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.ActivityThreadHandler.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    synchronized (ActivityThreadHandler.this.mWriteLock) {
                        if (ActivityThreadHandler.this.mWriteSuccess) {
                            ProcessStartDbInfo lastProcessStartDbInfo = MonitorLiveDBHelperDBHelper.getInstance(ActivityThreadHandler.this.mContext).getLastProcessStartDbInfo();
                            Logger.d(ActivityThreadHandler.TAG, "updateLog() called processStartDbInfo = " + lastProcessStartDbInfo);
                            if (lastProcessStartDbInfo != null) {
                                lastProcessStartDbInfo.dataJson = jSONObject;
                                Logger.d(ActivityThreadHandler.TAG, "updateLog() called update = " + lastProcessStartDbInfo);
                                boolean updateProcessStartDbInfo = MonitorLiveDBHelperDBHelper.getInstance(ActivityThreadHandler.this.mContext).updateProcessStartDbInfo(lastProcessStartDbInfo);
                                if (Logger.debug()) {
                                    Logger.d(ActivityThreadHandler.TAG, "updateLog: result = " + updateProcessStartDbInfo);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void processService(Message message) {
        if (sStartType != 1) {
            return;
        }
        try {
            Object obj = message.obj;
            if (message.what == 114) {
                Field declaredField = obj.getClass().getDeclaredField(DBDefinition.SEGMENT_INFO);
                declaredField.setAccessible(true);
                this.mProcessStartInfo.serviceInfo = (ServiceInfo) declaredField.get(obj);
            } else if (message.what == 115) {
                Field declaredField2 = obj.getClass().getDeclaredField("args");
                declaredField2.setAccessible(true);
                this.mProcessStartInfo.mIntent = (Intent) declaredField2.get(obj);
                this.mProcessStartInfo.startFlag = 1;
                processLogEnd();
            } else if (message.what == 121) {
                Field declaredField3 = obj.getClass().getDeclaredField(Constants.INTENT);
                declaredField3.setAccessible(true);
                this.mProcessStartInfo.mIntent = (Intent) declaredField3.get(obj);
                this.mProcessStartInfo.startFlag = 2;
                processLogEnd();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            processLogEnd();
        }
    }

    private void processReceiver(Message message) {
        if (sStartType != 2) {
            return;
        }
        Object obj = message.obj;
        try {
            if (message.what == 113) {
                Field declaredField = obj.getClass().getDeclaredField(Constants.INTENT);
                declaredField.setAccessible(true);
                Intent intent = (Intent) declaredField.get(obj);
                this.mProcessStartInfo.startFlag = 3;
                this.mProcessStartInfo.mIntent = intent;
                processLogEnd();
            }
        } catch (Throwable unused) {
        }
    }

    private void processActivity(Message message) {
        ClientTransactionItem clientTransactionItem;
        if (sStartType != 3) {
            return;
        }
        Object obj = message.obj;
        try {
            if (message.what == 100) {
                Field declaredField = obj.getClass().getDeclaredField(Constants.INTENT);
                declaredField.setAccessible(true);
                Intent intent = (Intent) declaredField.get(obj);
                this.mProcessStartInfo.startFlag = 4;
                this.mProcessStartInfo.mIntent = intent;
                processLogEnd();
                return;
            }
            if (message.what == 159 && (obj instanceof ClientTransaction) && (MethodUtils.getMethodWithAccessible(ClientTransaction.class, "getLifecycleStateRequest", new Class[0]).invoke(obj, new Object[0]) instanceof ResumeActivityItem)) {
                Method declaredMethod = ClientTransaction.class.getDeclaredMethod("getCallbacks", new Class[0]);
                declaredMethod.setAccessible(true);
                Iterator it = ((List) declaredMethod.invoke(obj, new Object[0])).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        clientTransactionItem = null;
                        break;
                    } else {
                        clientTransactionItem = (ClientTransactionItem) it.next();
                        if (TextUtils.equals(clientTransactionItem.getClass().getCanonicalName(), LaunchActivityItem.class.getCanonicalName())) {
                            break;
                        }
                    }
                }
                if (clientTransactionItem != null) {
                    Field field = FieldUtils.getField(LaunchActivityItem.class, "mIntent");
                    Field field2 = FieldUtils.getField(LaunchActivityItem.class, "mInfo");
                    field.setAccessible(true);
                    field2.setAccessible(true);
                    Intent intent2 = (Intent) field.get(clientTransactionItem);
                    intent2.setExtrasClassLoader(getClass().getClassLoader());
                    this.mProcessStartInfo.startFlag = 4;
                    this.mProcessStartInfo.mIntent = intent2;
                    processLogEnd();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void processLogEnd() {
        this.mIsEndLog = true;
        Logger.d(TAG, "processLogEnd,mProcessStartInfo is " + this.mProcessStartInfo.toJson().toString());
        if (MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel().isMonitorAliveEnable && AliveMonitorManager.inst(this.mContext).isFirstProcess()) {
            final String jSONObject = this.mProcessStartInfo.toJson().toString();
            if (Logger.debug()) {
                Logger.e(TAG, "processLogEnd: " + jSONObject);
            }
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.ActivityThreadHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (ActivityThreadHandler.this.mWriteLock) {
                            ProcessStartDbInfo processStartDbInfo = new ProcessStartDbInfo();
                            processStartDbInfo.dataJson = jSONObject;
                            processStartDbInfo.endTime = ToolUtils.currentTimeMillis();
                            MonitorLiveDBHelperDBHelper.getInstance(ActivityThreadHandler.this.mContext).insertProcessStartDbInfo(processStartDbInfo);
                            ActivityThreadHandler.this.mWriteSuccess = true;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private String codeToString(int i) {
        if (i == 100) {
            return "LAUNCH_ACTIVITY";
        }
        switch (i) {
            case 113:
                return "RECEIVER";
            case 114:
                return "CREATE_SERVICE";
            case 115:
                return "SERVICE_ARGS";
            default:
                return Integer.toString(i);
        }
    }

    public ProcessStartInfo getProcessStartInfo() {
        return this.mProcessStartInfo;
    }

    public JSONObject getProcessStartInfoObject() {
        ProcessStartInfo processStartInfo = this.mProcessStartInfo;
        if (processStartInfo == null) {
            return null;
        }
        return processStartInfo.toJson();
    }
}
