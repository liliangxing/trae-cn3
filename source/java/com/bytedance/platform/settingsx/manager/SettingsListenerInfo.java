package com.bytedance.platform.settingsx.manager;

/* loaded from: classes4.dex */
public class SettingsListenerInfo {
    boolean callbackOnMainThread;
    SettingsUpdateListener listener;

    public SettingsListenerInfo(SettingsUpdateListener settingsUpdateListener, boolean z) {
        this.listener = settingsUpdateListener;
        this.callbackOnMainThread = z;
    }
}
