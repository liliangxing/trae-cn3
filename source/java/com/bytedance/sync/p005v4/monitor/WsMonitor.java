package com.bytedance.sync.p005v4.monitor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IWsStatusService;
import com.bytedance.sync.p005v4.net.WsStatusKeeper;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WsMonitor implements LifecycleObserver {
    private boolean mHasActive;
    private final AtomicBoolean mMonitored = new AtomicBoolean(false);
    private long sStartTs;

    public void monitorStart() {
        this.sStartTs = SystemClock.elapsedRealtime();
        final IWsStatusService iWsStatusService = (IWsStatusService) UgBusFramework.getService(IWsStatusService.class);
        if (iWsStatusService.isConnect()) {
            monitorConnected(0L);
        } else {
            iWsStatusService.addWsStatusChangedListener(new WsStatusKeeper.OnWsStatusChangedListener() { // from class: com.bytedance.sync.v4.monitor.WsMonitor.1
                @Override // com.bytedance.sync.v4.net.WsStatusKeeper.OnWsStatusChangedListener
                public void onWsStatusChanged(boolean z) {
                    synchronized (this) {
                        long j = WsMonitor.this.sStartTs;
                        if (z && j > 0) {
                            WsMonitor.this.sStartTs = 0L;
                            iWsStatusService.removeWsStatusChangedListener(this);
                            Handler handler = new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), null);
                            final long elapsedRealtime = SystemClock.elapsedRealtime() - j;
                            handler.post(new Runnable() { // from class: com.bytedance.sync.v4.monitor.WsMonitor.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    WsMonitor.this.monitorConnected(elapsedRealtime);
                                }
                            });
                            WsMonitor.this.runOnMainThread(new Runnable() { // from class: com.bytedance.sync.v4.monitor.WsMonitor.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        ProcessLifecycleOwner.get().getLifecycle().removeObserver(WsMonitor.this);
                                    } catch (Exception unused) {
                                        LogUtils.m186e("there is something wrong when remove life cycle Observer,maybe someone add addObserver in work thread");
                                    }
                                }
                            });
                        }
                    }
                }
            });
            registerLifeCycleListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorConnected(long j) {
        if (this.mMonitored.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("socket_connected_when_start", j <= 0);
                jSONObject.put("foreground_may_launch", this.mHasActive);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(DBData.FIELD_TIME, j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            SyncMonitor.monitor("sync_sdk_ws_connect_ts", jSONObject, jSONObject2, null);
        }
    }

    private void registerLifeCycleListener() {
        runOnMainThread(new Runnable() { // from class: com.bytedance.sync.v4.monitor.WsMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ProcessLifecycleOwner.get().getLifecycle().addObserver(WsMonitor.this);
                } catch (Exception unused) {
                    LogUtils.m186e("there is something wrong when add life cycle Observer,maybe someone add addObserver in work thread");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnMainThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void onAnyActivityStart() {
        LogUtils.m185d("WsMonitor ON_START");
        this.mHasActive = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onAnyActivityResume() {
        LogUtils.m185d("WsMonitor ON_RESUME");
        this.mHasActive = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void onAnyActivityPause() {
        LogUtils.m185d("WsMonitor ON_PAUSE");
        this.mHasActive = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void onAnyActivityStop() {
        LogUtils.m185d("WsMonitor ON_STOP");
        this.mHasActive = true;
    }
}
