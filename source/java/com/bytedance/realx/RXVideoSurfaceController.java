package com.bytedance.realx;

import android.view.Surface;

/* loaded from: classes4.dex */
public class RXVideoSurfaceController {
    private static RXVideoSurfaceController instance = new RXVideoSurfaceController();
    private boolean usePassSurfaceMode = false;
    private RXSurfaceListener mSurfaceLisener = null;

    /* loaded from: classes4.dex */
    public interface RXSurfaceListener {
        void onSurfaceAvailable(Surface surface);
    }

    private RXVideoSurfaceController() {
    }

    public static RXVideoSurfaceController getInstance() {
        return instance;
    }

    public void setSurfaceListener(RXSurfaceListener listener) {
        this.mSurfaceLisener = listener;
    }

    public void setSurface(Surface surface) {
        RXSurfaceListener rXSurfaceListener = this.mSurfaceLisener;
        if (rXSurfaceListener != null) {
            rXSurfaceListener.onSurfaceAvailable(surface);
        }
    }

    public void setPassSurfaceMode(boolean enable) {
        this.usePassSurfaceMode = enable;
    }

    public boolean usePassSurfaceMode() {
        return this.usePassSurfaceMode;
    }
}
