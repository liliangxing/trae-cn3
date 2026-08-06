package com.bytedance.bdinstall;

import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InstallWaitingLock {
    private final Object mLock = new Object();
    private volatile boolean mHasInstallFinished = false;
    private final AtomicBoolean mHasRegisterEvent = new AtomicBoolean(false);
    private final ThreadLocal<Boolean> sIsRequesting = new ThreadLocal<>();
    private volatile boolean sIsOldWayNotWaiting = false;
    private volatile boolean sLoadingOnlineConfig = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRequestingActive(boolean z) {
        if (z) {
            this.sIsRequesting.set(Boolean.valueOf(z));
        } else {
            this.sIsRequesting.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRequestingRegister(boolean z) {
        this.sLoadingOnlineConfig = z;
        if (z) {
            this.sIsRequesting.set(Boolean.valueOf(z));
            return;
        }
        this.sIsRequesting.remove();
        this.sIsOldWayNotWaiting = true;
        DrLog.m139d("tryWaitingForInstallFinishWithOldWay finish because request finished");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tryWaitingForInstallFinish(long j, Integer num) throws InterruptedException {
        if (this.sIsRequesting.get() != null) {
            return;
        }
        synchronized (this.mLock) {
            tryRegisterInstallEvent(num);
            if (Looper.myLooper() == ExecutorUtil.getLooper(String.valueOf(num))) {
                DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));
            }
            if (!this.mHasInstallFinished) {
                this.mLock.wait(j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tryWaitingForInstallFinishInOldWay(Integer num) {
        if (num == null || this.sIsRequesting.get() != null) {
            return;
        }
        DrLog.m139d("tryWaitingForInstallFinishWithOldWay");
        synchronized (this.mLock) {
            tryRegisterInstallEvent(num);
            if (this.sIsOldWayNotWaiting) {
                return;
            }
            if (Looper.myLooper() == ExecutorUtil.getLooper(String.valueOf(num))) {
                DrLog.ysnp(new RuntimeException("did generate at this thread,you shouldn't block this thread"));
            }
            long j = this.sLoadingOnlineConfig ? 4000L : 1500L;
            if (!this.mHasInstallFinished) {
                try {
                    this.mLock.wait(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.sIsOldWayNotWaiting = true;
            DrLog.m139d("tryWaitingForInstallFinishWithOldWay finish");
        }
    }

    private void tryRegisterInstallEvent(Integer num) {
        if (num != null && this.mHasRegisterEvent.compareAndSet(false, true)) {
            DrLog.m139d("start register install event");
            BdInstallInstance bdInstallInstance = (BdInstallInstance) BDInstall.getInstance(String.valueOf(num));
            bdInstallInstance.addInstallListener(false, new IInstallListener() { // from class: com.bytedance.bdinstall.InstallWaitingLock.1
                @Override // com.bytedance.bdinstall.IInstallListener
                public void installFinished(InstallInfo installInfo) {
                    InstallWaitingLock.this.notifyInstallFinish();
                }
            });
            InstallInfo installInfo = bdInstallInstance.getInstallInfo();
            if (installInfo == null || TextUtils.isEmpty(installInfo.getDid()) || TextUtils.isEmpty(installInfo.getIid())) {
                return;
            }
            notifyInstallFinish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInstallFinish() {
        synchronized (this.mLock) {
            this.mHasInstallFinished = true;
            this.mLock.notifyAll();
        }
    }

    void reset() {
        synchronized (this.mLock) {
            this.mHasInstallFinished = false;
        }
    }
}
