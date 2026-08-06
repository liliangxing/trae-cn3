package com.bytedance.push.helper;

import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.Observable;
import java.util.Observer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SysDialogResultDetectHelper implements Observer {
    private long lastBackgroundTimeStamp;
    private IDetectListener mIDetectListener;
    private final int STATUS_INIT = 1;
    private final int STATUS_WAIT_FOR_SHOW = 2;
    private final int STATUS_SHOWING = 3;
    private int dialogStatus = 1;
    private long dialogStatusUpdateTimeCost = 500;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IDetectListener {
        void onDialogDismiss();

        void onDialogShow();

        void onDialogShowFailed(String str);
    }

    public SysDialogResultDetectHelper(IDetectListener iDetectListener) {
        this.mIDetectListener = iDetectListener;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            fromForegroundToBackground();
        } else {
            fromBackgroundToForeground();
        }
    }

    public boolean startDetect(long j) {
        if (this.dialogStatus != 1) {
            return false;
        }
        this.dialogStatus = 2;
        SysDialogActivityLifecycleObserver.getIns().addObserver(this);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.helper.SysDialogResultDetectHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (SysDialogResultDetectHelper.this.dialogStatus == 2) {
                    SysDialogResultDetectHelper.this.mIDetectListener.onDialogShowFailed("time out");
                    SysDialogResultDetectHelper.this.dialogStatus = 1;
                }
            }
        }, this.dialogStatusUpdateTimeCost);
        return true;
    }

    private void fromForegroundToBackground() {
        if (this.dialogStatus == 2) {
            this.lastBackgroundTimeStamp = System.currentTimeMillis();
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.helper.SysDialogResultDetectHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (SysDialogResultDetectHelper.this.dialogStatus == 3) {
                        SysDialogResultDetectHelper.this.mIDetectListener.onDialogShow();
                    } else {
                        SysDialogResultDetectHelper.this.mIDetectListener.onDialogShowFailed("dismiss after show too short");
                    }
                }
            }, this.dialogStatusUpdateTimeCost);
            this.dialogStatus = 3;
        }
    }

    private void fromBackgroundToForeground() {
        if (this.dialogStatus == 3) {
            this.dialogStatus = 1;
            long currentTimeMillis = System.currentTimeMillis() - this.lastBackgroundTimeStamp;
            Logger.m268d("SysDialogResultDetectHelper", "[fromBackgroundToForeground]backgroundToForegroundTimeCost:" + currentTimeMillis);
            if (currentTimeMillis >= this.dialogStatusUpdateTimeCost) {
                this.mIDetectListener.onDialogDismiss();
            }
        }
    }
}
