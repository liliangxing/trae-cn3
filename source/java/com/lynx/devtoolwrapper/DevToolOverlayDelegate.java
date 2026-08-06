package com.lynx.devtoolwrapper;

import android.app.Dialog;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class DevToolOverlayDelegate {
    private OverlayService mService;

    private DevToolOverlayDelegate() {
    }

    /* loaded from: classes6.dex */
    private static class SingletonHelper {
        private static final DevToolOverlayDelegate INSTANCE = new DevToolOverlayDelegate();

        private SingletonHelper() {
        }
    }

    public static DevToolOverlayDelegate getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public ArrayList<Dialog> getGlobalOverlayNGView() {
        OverlayService overlayService = this.mService;
        if (overlayService != null) {
            return overlayService.getGlobalOverlayNGView();
        }
        return null;
    }

    public ArrayList<Integer> getAllVisibleOverlaySign() {
        OverlayService overlayService = this.mService;
        if (overlayService != null) {
            return overlayService.getAllVisibleOverlaySign();
        }
        return null;
    }

    public void init(OverlayService overlayService) {
        this.mService = overlayService;
    }
}
