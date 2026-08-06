package com.bytedance.push.monitor;

import android.app.servertransaction.ClientTransaction;
import android.app.servertransaction.ClientTransactionItem;
import android.app.servertransaction.LaunchActivityItem;
import android.app.servertransaction.ResumeActivityItem;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.platform.thread.Constants;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.proxy.AbsMethodInvokeProxy;
import com.bytedance.push.proxy.ActivityThreadHooker;
import com.bytedance.push.proxy.MethodProxyResult;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProcessStartMonitor extends AbsMethodInvokeProxy implements Handler.Callback, Observer {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int EXECUTE_TRANSACTION = 159;
    public static final int LAUNCH_ACTIVITY = 100;
    public static final int RECEIVER = 113;
    public static final int SERVICE_ARGS = 115;
    public static final int START_BY_ACTIVITY = 3;
    public static final int START_BY_OTHER = 0;
    public static final int START_BY_PROVIDER = 4;
    public static final int START_BY_RECEIVER = 2;
    public static final int START_BY_SERVICE = 1;
    private static volatile ProcessStartMonitor processStartMonitor;
    private long mComponentStartTimeStamp;
    private String mLaunchComponent;
    private long mProcessStartTimeStamp;
    private final String TAG = "ProcessStartMonitor";
    private final int MSG_WHAT_DETECT_START_COMPONENT_TIME_OUT = 4141031;
    private final int MSG_WHAT_TO_FOREGROUND_TIME_OUT = 4141032;
    private final long detectStartComponentTimeout = Constants.TASK_WAIT_THRESHOLD;
    private final long toForeGroundTimeout = Constants.TASK_RUN_THRESHOLD;
    private int mStartType = 0;
    private boolean mHasDetectedStartComponent = false;
    private boolean mHasReportLaunch = false;
    private Handler mHandler = PushThreadHandlerManager.inst().getHandler(this);

    public static ProcessStartMonitor getInstance() {
        if (processStartMonitor == null) {
            synchronized (ProcessStartMonitor.class) {
                if (processStartMonitor == null) {
                    processStartMonitor = new ProcessStartMonitor();
                }
            }
        }
        return processStartMonitor;
    }

    private ProcessStartMonitor() {
    }

    public void startMonitor() {
        Logger.m268d("ProcessStartMonitor", "[startMonitor]");
        if (this.mProcessStartTimeStamp == 0) {
            this.mProcessStartTimeStamp = System.currentTimeMillis();
        }
        this.mHandler.sendEmptyMessageDelayed(4141031, Constants.TASK_WAIT_THRESHOLD);
        AppStatusObserverForChildProcess.getIns().addObserver(this);
        ActivityThreadHooker.getInstance().addMethodInvokeProxy(this);
    }

    @Override // com.bytedance.push.proxy.AbsMethodInvokeProxy
    public MethodProxyResult proxyMethodInvoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        try {
            if (!this.mHasDetectedStartComponent && TextUtils.equals(method.getName(), "handleMessage")) {
                Message message = (Message) objArr[0];
                int i = message.what;
                if (i == 100) {
                    Logger.m268d("ProcessStartMonitor", "handleMessage:LAUNCH_ACTIVITY");
                    processActivity(message);
                } else if (i == 121) {
                    Logger.m268d("ProcessStartMonitor", "handleMessage:BIND_SERVICE");
                    processService(message);
                } else if (i == 159) {
                    Logger.m268d("ProcessStartMonitor", "handleMessage:EXECUTE_TRANSACTION");
                    try {
                        Method method2 = DoubleReflectUtils.getMethod(ClientTransaction.class, "getLifecycleStateRequest", new Class[0]);
                        method2.setAccessible(true);
                        if (method2.invoke(message.obj, new Object[0]) instanceof ResumeActivityItem) {
                            Logger.m268d("ProcessStartMonitor", "handleMessage:EXECUTE_TRANSACTION-->LAUNCH_ACTIVITY");
                            processActivity(message);
                        }
                    } catch (Throwable th) {
                        Logger.m272e("ProcessStartMonitor", "handleMessage:error when parse EXECUTE_TRANSACTION", th);
                    }
                } else {
                    switch (i) {
                        case 113:
                            Logger.m268d("ProcessStartMonitor", "handleMessage:RECEIVER");
                            processReceiver(message);
                            break;
                        case 114:
                            Logger.m268d("ProcessStartMonitor", "handleMessage:CREATE_SERVICE");
                            processService(message);
                            break;
                        case 115:
                            Logger.m268d("ProcessStartMonitor", "handleMessage:SERVICE_ARGS");
                            processService(message);
                            break;
                        default:
                            Logger.m268d("ProcessStartMonitor", String.format("handleMessage:%s", Integer.valueOf(message.what)));
                            break;
                    }
                }
            }
        } catch (Throwable th2) {
            Logger.m272e("ProcessStartMonitor", "error when handleMessage ", th2);
        }
        return new MethodProxyResult();
    }

    private void processService(Message message) {
        try {
            Object obj = message.obj;
            if (message.what == 114) {
                Field declaredField = obj.getClass().getDeclaredField("info");
                declaredField.setAccessible(true);
                ServiceInfo serviceInfo = (ServiceInfo) declaredField.get(obj);
                Logger.m268d("ProcessStartMonitor", "[processService]ServiceInfo:" + serviceInfo);
                finishedDetect(1, serviceInfo.name);
            } else if (message.what == 115) {
                Field declaredField2 = obj.getClass().getDeclaredField("args");
                declaredField2.setAccessible(true);
                Intent intent = (Intent) declaredField2.get(obj);
                Logger.m268d("ProcessStartMonitor", "[processService]intent:" + intent);
                finishedDetect(1, intentToString(intent));
            } else if (message.what == 121) {
                Field declaredField3 = obj.getClass().getDeclaredField("intent");
                declaredField3.setAccessible(true);
                Intent intent2 = (Intent) declaredField3.get(obj);
                Logger.m268d("ProcessStartMonitor", "[processService]intent:" + intent2);
                finishedDetect(1, intentToString(intent2));
            }
        } catch (Throwable th) {
            Logger.m272e("ProcessStartMonitor", "error when processService", th);
        }
    }

    private void processReceiver(Message message) {
        Object obj = message.obj;
        try {
            if (message.what == 113) {
                Field declaredField = obj.getClass().getDeclaredField("intent");
                declaredField.setAccessible(true);
                Intent intent = (Intent) declaredField.get(obj);
                Logger.m268d("ProcessStartMonitor", "[processReceiver]intent:" + intent);
                finishedDetect(2, intentToString(intent));
            }
        } catch (Throwable th) {
            Logger.m272e("ProcessStartMonitor", "error when processReceiver", th);
        }
    }

    private void processActivity(Message message) {
        ClientTransactionItem clientTransactionItem;
        Object obj = message.obj;
        try {
            if (message.what == 100) {
                Field declaredField = obj.getClass().getDeclaredField("intent");
                declaredField.setAccessible(true);
                Intent intent = (Intent) declaredField.get(obj);
                Logger.m268d("ProcessStartMonitor", "[processActivity]intent:" + intent);
                finishedDetect(3, intentToString(intent));
                return;
            }
            if (message.what == 159 && (obj instanceof ClientTransaction) && (DoubleReflectUtils.getAccessibleMethod(ClientTransaction.class, "getLifecycleStateRequest", new Class[0]).invoke(obj, new Object[0]) instanceof ResumeActivityItem)) {
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
                    Field accessibleField = DoubleReflectUtils.getAccessibleField(LaunchActivityItem.class, "mIntent");
                    Field accessibleField2 = DoubleReflectUtils.getAccessibleField(LaunchActivityItem.class, "mInfo");
                    accessibleField.setAccessible(true);
                    accessibleField2.setAccessible(true);
                    Intent intent2 = (Intent) accessibleField.get(clientTransactionItem);
                    intent2.setExtrasClassLoader(getClass().getClassLoader());
                    Logger.m268d("ProcessStartMonitor", "[processActivity]intent:" + intent2);
                    finishedDetect(3, intentToString(intent2));
                }
            }
        } catch (Throwable th) {
            Logger.m272e("ProcessStartMonitor", "error when processActivity ", th);
            th.printStackTrace();
        }
    }

    private void finishedDetect(int i, String str) {
        if (this.mHasDetectedStartComponent) {
            return;
        }
        this.mHasDetectedStartComponent = true;
        Logger.m268d("ProcessStartMonitor", String.format("[finishedDetect] startType is %s startComponent is %s", Integer.valueOf(i), str));
        this.mStartType = i;
        this.mLaunchComponent = str;
        this.mComponentStartTimeStamp = System.currentTimeMillis();
        this.mHandler.removeMessages(4141031);
        this.mHandler.sendEmptyMessageDelayed(4141032, Constants.TASK_RUN_THRESHOLD);
    }

    private String intentToString(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            return component.toShortString();
        }
        return intent.getAction();
    }

    private void printExtras(Bundle bundle) {
        Logger.m268d("ProcessStartMonitor", "bundle is :" + bundleToString(bundle));
    }

    private String bundleToString(Bundle bundle) {
        Set<String> keySet;
        if (bundle == null || (keySet = bundle.keySet()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : keySet) {
            Object obj = bundle.get(str);
            if (obj instanceof Intent) {
                sb.append(String.format("%s--%s\n", str, bundleToString(((Intent) obj).getExtras())));
            } else {
                sb.append(String.format("%s--%s\n", str, obj));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a5, code lost:
    
        return false;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 4141031:
                Logger.m268d("ProcessStartMonitor", "on MSG_WHAT_DETECT_START_COMPONENT_TIME_OUT");
                onLaunchEvent(true, AppStatusObserverForChildProcess.getIns().getFirstToForeGroundTimeStamp() > 0, 0L, 0L, PushServiceManager.get().getIRedBadgeExternalService().getBadgeNumberWhenAppLaunch(AppProvider.getApp()));
                break;
            case 4141032:
                Logger.m268d("ProcessStartMonitor", "on MSG_WHAT_TO_FOREGROUND_TIME_OUT");
                long firstToForeGroundTimeStamp = AppStatusObserverForChildProcess.getIns().getFirstToForeGroundTimeStamp();
                int badgeNumberWhenAppLaunch = PushServiceManager.get().getIRedBadgeExternalService().getBadgeNumberWhenAppLaunch(AppProvider.getApp());
                if (firstToForeGroundTimeStamp > 0) {
                    long j = firstToForeGroundTimeStamp - this.mProcessStartTimeStamp;
                    long j2 = firstToForeGroundTimeStamp - this.mComponentStartTimeStamp;
                    Logger.m268d("ProcessStartMonitor", String.format("on MSG_WHAT_TO_FOREGROUND_TIME_OUT:app success to foreground,processLaunchToForegroundTimeCost is %s,mLaunchComponent is %s,componentStartToForegroundTimeCost is %s, badgeNumberWhenAppLaunch is %s", Long.valueOf(j), this.mLaunchComponent, Long.valueOf(j2), Integer.valueOf(badgeNumberWhenAppLaunch)));
                    onLaunchEvent(false, true, j, j2, badgeNumberWhenAppLaunch);
                    break;
                } else {
                    Logger.m268d("ProcessStartMonitor", "on MSG_WHAT_TO_FOREGROUND_TIME_OUT:app failed to foreground");
                    onLaunchEvent(false, false, 0L, 0L, badgeNumberWhenAppLaunch);
                    break;
                }
        }
    }

    private void onLaunchEvent(boolean z, boolean z2, long j, long j2, int i) {
        boolean curProcessIsFirstProcess = PushServiceManager.get().getAliveMonitorService().curProcessIsFirstProcess(AppProvider.getApp());
        Logger.m268d("ProcessStartMonitor", "onLaunchEvent,mHasReportLaunch is " + this.mHasReportLaunch + " successToForeGround:" + z2 + " mStartType:" + this.mStartType + " mLaunchComponent:" + this.mLaunchComponent + " curProcessIsFirstProcess:" + curProcessIsFirstProcess);
        if (this.mHasReportLaunch) {
            return;
        }
        this.mHasReportLaunch = true;
        PushSupporter.get().getPushSdkMonitorService().onLaunchEvent(z, z2, j, j2, i, this.mStartType, this.mLaunchComponent);
        PushSupporter.get().getPushSdkMonitorService().onProcessStartEvent(z, z2, j, j2, i, this.mStartType, this.mLaunchComponent, curProcessIsFirstProcess);
        if (z2 || !curProcessIsFirstProcess) {
            return;
        }
        PushServiceManager.get().getIAllianceService().onBackgroundProcessAlive(this.mLaunchComponent);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Logger.m268d("ProcessStartMonitor", "[update]isInBackGround:" + booleanValue);
        if (booleanValue) {
            return;
        }
        if (this.mStartType != 0) {
            this.mHandler.sendEmptyMessage(4141032);
        }
        AppStatusObserverForChildProcess.getIns().deleteObserver(this);
    }

    public void onContentProviderLaunch(String str, String str2) {
        if (this.mHasDetectedStartComponent) {
            return;
        }
        Logger.m268d("ProcessStartMonitor", "[onContentProviderLaunch]launchMethod:" + str2 + " providerName:" + str);
        finishedDetect(4, str2 + "$" + str);
    }
}
