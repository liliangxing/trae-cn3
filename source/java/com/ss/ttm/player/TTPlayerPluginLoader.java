package com.ss.ttm.player;

/* loaded from: classes7.dex */
public class TTPlayerPluginLoader {
    public static final int PLUGIN_INTERTRUST_DRM = 100;
    private static IPluginLoader mPluginLoader;

    public static void setPluginLoader(IPluginLoader pluginLoader) {
        mPluginLoader = pluginLoader;
    }

    public static ClassLoader loadPlugin(int pluginType) {
        IPluginLoader iPluginLoader = mPluginLoader;
        if (iPluginLoader != null) {
            return iPluginLoader.loadPlugin(pluginType);
        }
        return null;
    }
}
