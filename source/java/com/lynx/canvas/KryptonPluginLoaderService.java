package com.lynx.canvas;

/* loaded from: classes6.dex */
public abstract class KryptonPluginLoaderService extends KryptonService {

    /* loaded from: classes6.dex */
    public interface Callback {
        void onFinish(boolean z, String str);
    }

    public abstract ClassLoader getClassLoader(String str);

    public abstract String getPluginPath(String str);

    public abstract void loadPluginAsync(String str, Callback callback);

    public abstract boolean loadPluginSync(String str);
}
