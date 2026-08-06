package com.bytedance.platform.godzilla.plugin;

import android.app.Application;

/* loaded from: classes4.dex */
public abstract class BasePlugin {
    private PluginState mState;

    public abstract String getName();

    public void init(Application application) {
        this.mState = PluginState.INITIALIZED;
    }

    public void start() {
        this.mState = PluginState.STARTED;
    }

    public void stop() {
        this.mState = PluginState.STOPPED;
    }

    public void destroy() {
        this.mState = PluginState.DESTROYED;
    }

    public StartType startType() {
        return StartType.IMMEDIATE;
    }

    public final PluginState getState() {
        return this.mState;
    }
}
