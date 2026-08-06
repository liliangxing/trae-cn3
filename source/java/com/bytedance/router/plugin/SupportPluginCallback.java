package com.bytedance.router.plugin;

import java.util.List;

/* loaded from: classes4.dex */
public interface SupportPluginCallback {
    default ClassLoader getClassLoader(String str) {
        return null;
    }

    List<Plugin> initPlugins();

    void loadPlugin(Plugin plugin, String str);
}
