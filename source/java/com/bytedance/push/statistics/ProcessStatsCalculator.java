package com.bytedance.push.statistics;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.log.ILogger;
import com.ss.android.message.util.ToolUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ProcessStatsCalculator implements Observer, Handler.Callback {
    private static final int MSG_START = 10085;
    private static final int MSG_WHAT_APP_STATS_CHANGED = 10086;
    private static final int MSG_WHAT_POLL = 10087;
    private static final int MSG_WHAT_UPLOAD_LAST = 10089;
    private static final int MSG_WHAT_ZONE_TIME = 10088;
    static final String TAG = "push_proc_stat";
    private AliveData mAliveData;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this);
    private final ILogger mLogger;
    private final IConfigProvider mProvider;
    private boolean mStartCalc;
    private long mStartTs;
    private boolean mStartUpload;

    public ProcessStatsCalculator(IConfigProvider iConfigProvider, ILogger iLogger) {
        this.mProvider = iConfigProvider;
        this.mLogger = iLogger;
    }

    public void start() {
        if (this.mStartCalc) {
            return;
        }
        this.mStartCalc = true;
        this.mHandler.sendEmptyMessage(10085);
    }

    public void tryStartUpload() {
        this.mHandler.sendEmptyMessageDelayed(MSG_WHAT_UPLOAD_LAST, new Random().nextInt(60000));
    }

    private boolean isBackground() {
        return ActivityLifecycleObserver.getIns().isBackGround();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof Boolean) {
            this.mHandler.sendEmptyMessage(10086);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        switch (message.what) {
            case 10085:
                this.mLogger.mo245d(TAG, "onStart");
                onStart();
                break;
            case 10086:
                this.mLogger.mo245d(TAG, "APP_STATS_CHANGED");
                doSave(false);
                pollSample();
                break;
            case MSG_WHAT_POLL /* 10087 */:
                this.mLogger.mo245d(TAG, "POLL");
                doSave(false);
                pollSample();
                break;
            case MSG_WHAT_ZONE_TIME /* 10088 */:
                this.mLogger.mo245d(TAG, "ZONE_TIME");
                doSave(true);
                pollSample();
                break;
            case MSG_WHAT_UPLOAD_LAST /* 10089 */:
                this.mLogger.mo245d(TAG, "UPLOAD_LAST");
                this.mStartUpload = true;
                this.mProvider.submitAndUpload(false);
                break;
        }
        return false;
    }

    private void doSave(boolean z) {
        this.mAliveData.endTs = ToolUtils.currentTimeMillis();
        this.mAliveData.endElapsedRealTime = SystemClock.elapsedRealtime();
        AliveData aliveData = this.mAliveData;
        this.mLogger.mo245d(TAG, "save: aliveTs = " + aliveData + ", duration = " + aliveData.getAliveTime());
        this.mProvider.save(aliveData, z && this.mStartUpload, true);
    }

    private void onStart() {
        this.mStartTs = SystemClock.elapsedRealtime();
        ActivityLifecycleObserver.getIns().addObserver(this);
        forceReportWhenZoneTime();
        pollSample();
    }

    private void forceReportWhenZoneTime() {
        long currentTimeMillis = ToolUtils.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, 1);
        long timeInMillis = calendar.getTimeInMillis();
        if (this.mLogger.debug()) {
            this.mLogger.mo245d(TAG, "next zone time = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timeInMillis)));
        }
        this.mHandler.sendEmptyMessageDelayed(MSG_WHAT_ZONE_TIME, ((timeInMillis - currentTimeMillis) - TimeUnit.MINUTES.toMillis(15L)) + new Random().nextInt((int) TimeUnit.MINUTES.toMillis(5L)));
    }

    private void pollSample() {
        AliveData aliveData = new AliveData();
        aliveData.startElapsedRealTime = SystemClock.elapsedRealtime();
        aliveData.startTs = ToolUtils.currentTimeMillis();
        aliveData.isBackground = isBackground();
        long defaultBackgroundInterval = aliveData.isBackground ? this.mProvider.getDefaultBackgroundInterval() : this.mProvider.getDefaultForegroundInterval();
        if (this.mStartUpload || SystemClock.elapsedRealtime() - this.mStartTs > 60000) {
            defaultBackgroundInterval = aliveData.isBackground ? this.mProvider.getBackgroundInterval() : this.mProvider.getForegroundInterval();
        }
        aliveData.delay = defaultBackgroundInterval;
        if (!this.mProvider.isMainProcess()) {
            aliveData.isForeground = this.mProvider.isAppForeground();
            aliveData.isScreenOn = this.mProvider.isScreenOn();
            aliveData.isUsbCharging = this.mProvider.isUsbCharging();
        }
        this.mAliveData = aliveData;
        this.mLogger.mo245d(TAG, "pollSample: start_ts = " + aliveData + ", mIsBg = " + aliveData.isBackground + ", delay = " + defaultBackgroundInterval);
        this.mHandler.removeMessages(MSG_WHAT_POLL);
        this.mHandler.sendEmptyMessageDelayed(MSG_WHAT_POLL, defaultBackgroundInterval);
    }
}
