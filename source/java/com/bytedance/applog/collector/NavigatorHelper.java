package com.bytedance.applog.collector;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.store.Page;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NavigatorHelper implements Handler.Callback {
    private final AppLogInstance appLogInstance;
    private final Handler handler;
    private boolean isColdLaunch = true;
    private int existsPageCount = 0;
    private final int MSG_PAGE_PAUSE = 9999;
    private boolean isBackground = false;

    public NavigatorHelper(AppLogInstance appLogInstance, Looper looper) {
        this.appLogInstance = appLogInstance;
        this.handler = new Handler(looper, this);
    }

    public void onPageReceived(Page page) {
        if (page.duration > 0) {
            this.handler.sendEmptyMessageDelayed(9999, 500L);
            this.existsPageCount = Math.max(0, this.existsPageCount - 1);
            return;
        }
        this.handler.removeMessages(9999);
        this.existsPageCount++;
        if (this.isColdLaunch) {
            this.isColdLaunch = false;
            onAppColdLaunch();
        }
        if (this.isBackground) {
            this.isBackground = false;
            onAppHotLaunch();
        }
    }

    private void onAppHotLaunch() {
        this.appLogInstance.getLogger().debug("App back to frontend...", new Object[0]);
        if (this.appLogInstance.getInitConfig() == null || !this.appLogInstance.getInitConfig().isStopOnEnterBackgroundEnabled()) {
            return;
        }
        this.appLogInstance.start();
    }

    private void onAppColdLaunch() {
        this.appLogInstance.getLogger().debug("App first to frontend...", new Object[0]);
    }

    private void onAppToBackground() {
        this.appLogInstance.getLogger().debug("App enter to background...", new Object[0]);
        if (this.appLogInstance.getInitConfig() != null && this.appLogInstance.getInitConfig().isFlushOnEnterBackgroundEnabled()) {
            this.appLogInstance.flush();
        }
        if (this.appLogInstance.getInitConfig() != null && this.appLogInstance.getInitConfig().isStopOnEnterBackgroundEnabled()) {
            this.appLogInstance.stop();
        }
        this.appLogInstance.getMonitorHelper().flush();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 9999) {
            return false;
        }
        this.isBackground = true;
        onAppToBackground();
        return false;
    }
}
