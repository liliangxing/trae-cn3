package com.ss.alive.monitor;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.Logger;
import com.lynx.tasm.gesture.handler.GestureConstants;
import com.ss.alive.monitor.p002db.MonitorLiveDBHelperDBHelper;
import com.ss.alive.monitor.p002db.ProcessStartDbInfo;
import com.ss.android.message.util.ToolUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MonitorLiveTimeHelper implements WeakHandler.IHandler {
    private static final int MSG_ON_MONITOR = 0;
    private static final String TAG = "MonitorLiveTimeHelper";
    private static MonitorLiveTimeHelper sMonitorLiveTimeHelper;
    private Context mContext;
    private WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private HandleMessageThread mHandlerThread;

    public static MonitorLiveTimeHelper inst(Context context) {
        if (sMonitorLiveTimeHelper == null) {
            sMonitorLiveTimeHelper = new MonitorLiveTimeHelper(context);
        }
        return sMonitorLiveTimeHelper;
    }

    private MonitorLiveTimeHelper(Context context) {
        HandleMessageThread handleMessageThread = new HandleMessageThread();
        this.mHandlerThread = handleMessageThread;
        handleMessageThread.start();
        this.mContext = context;
    }

    public void startMonitorLiveTime() {
        this.mHandler.sendEmptyMessageDelayed(0, 10000L);
    }

    public void handleMsg(Message message) {
        if (message != null && message.what == 0) {
            saveLiveTime();
        }
    }

    private void saveLiveTime() {
        try {
            if (MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel().isMonitorAliveEnable) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.alive.monitor.MonitorLiveTimeHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MonitorLiveTimeHelper.this.saveLiveTimeInternal();
                        }
                    });
                } else {
                    saveLiveTimeInternal();
                }
                this.mHandler.sendEmptyMessageDelayed(0, MonitorLiveSetting.getInstance(this.mContext).getMonitorAliveConfigModel().monitorLiveIntervalSecond * 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLiveTimeInternal() {
        try {
            ProcessStartDbInfo lastProcessStartDbInfo = MonitorLiveDBHelperDBHelper.getInstance(this.mContext).getLastProcessStartDbInfo();
            if (Logger.debug()) {
                Logger.d(TAG, "saveLiveTimeInternal() called processStartDbInfo = " + lastProcessStartDbInfo);
            }
            if (lastProcessStartDbInfo != null) {
                lastProcessStartDbInfo.endTime = ToolUtils.currentTimeMillis();
                boolean updateProcessStartDbInfo = MonitorLiveDBHelperDBHelper.getInstance(this.mContext).updateProcessStartDbInfo(lastProcessStartDbInfo);
                if (Logger.debug()) {
                    Logger.d(TAG, "saveLiveTime: result = " + updateProcessStartDbInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class HandleMessageThread extends Thread {
        private HandleMessageThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (Logger.debug()) {
                Logger.d(MonitorLiveTimeHelper.TAG, GestureConstants.ON_START);
            }
            try {
                Thread.currentThread().setName("MonitorLiveTimeHelperThread");
                Looper.prepare();
                MonitorLiveTimeHelper.this.mHandler = new WeakHandler(Looper.myLooper(), MonitorLiveTimeHelper.this);
                Looper.loop();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (Logger.debug()) {
                Logger.d(MonitorLiveTimeHelper.TAG, GestureConstants.ON_END);
            }
        }
    }
}
