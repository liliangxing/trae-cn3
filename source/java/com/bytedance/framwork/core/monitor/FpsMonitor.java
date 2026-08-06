package com.bytedance.framwork.core.monitor;

@Deprecated
/* loaded from: classes2.dex */
public class FpsMonitor {

    /* loaded from: classes2.dex */
    public interface IFPSCallBack {
        void fpsCallBack(String str, double d);
    }

    /* loaded from: classes2.dex */
    public interface IFrameCallBack {
        void onFrame(String str, long j);
    }

    public static void start(String str) {
    }

    public static void stop() {
    }

    public boolean getMonitorFPSStatus(String str) {
        return false;
    }

    public void setIFPSCallBack(IFPSCallBack iFPSCallBack) {
    }

    public void setIFrameCallBack(IFrameCallBack iFrameCallBack) {
    }
}
