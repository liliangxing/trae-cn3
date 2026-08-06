package com.bytedance.platform.godzilla;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.IReflectHackHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.plugin.PluginGroup;
import com.bytedance.platform.godzilla.plugin.StartType;
import com.bytedance.platform.godzilla.plugin.XHookPlugin;
import com.bytedance.platform.godzilla.utils.HackHelper;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Godzilla {
    private static final String TAG = "Godzilla";
    private static volatile Godzilla sInstance;
    private final Application application;
    private final HashMap<String, BasePlugin> plugins;

    public static Godzilla init(Godzilla godzilla) {
        if (godzilla == null) {
            throw new RuntimeException("Godzilla should not be null.");
        }
        synchronized (Godzilla.class) {
            if (sInstance == null) {
                sInstance = godzilla;
            } else {
                Logger.m197e(TAG, "Godzilla instance is already set. this invoking will be ignored");
            }
        }
        return sInstance;
    }

    public static Godzilla with() {
        if (sInstance == null) {
            throw new RuntimeException("Godzilla.init() method must be called first");
        }
        return sInstance;
    }

    public BasePlugin getPlugin(String str) {
        return this.plugins.get(str);
    }

    public void addPlugin(BasePlugin basePlugin) {
        if (getPlugin(basePlugin.getName()) == null) {
            stop();
            destroy();
            this.plugins.put(basePlugin.getName(), basePlugin);
            start(StartType.REGISTER_EXCEPTION);
        }
    }

    public void removePlugin(BasePlugin basePlugin) {
        if (getPlugin(basePlugin.getName()) != null) {
            stop();
            destroy();
            this.plugins.remove(basePlugin.getName());
            start(StartType.REGISTER_EXCEPTION);
        }
    }

    public void start() {
        start(StartType.IMMEDIATE);
    }

    public void start(StartType startType) {
        XHookPlugin xHookPlugin = null;
        for (BasePlugin basePlugin : this.plugins.values()) {
            if (basePlugin instanceof PluginGroup) {
                PluginGroup pluginGroup = (PluginGroup) basePlugin;
                pluginGroup.start(startType);
                if (pluginGroup.getXHookPlugin() != null) {
                    xHookPlugin = pluginGroup.getXHookPlugin();
                    pluginGroup.setXHookPlugin(null);
                }
            } else if (basePlugin.startType() == startType) {
                basePlugin.start();
                if (basePlugin instanceof XHookPlugin) {
                    xHookPlugin = (XHookPlugin) basePlugin;
                }
            }
        }
        if (xHookPlugin != null) {
            xHookPlugin.invokeXHookRefresh();
        }
    }

    public void stop() {
        Iterator<BasePlugin> it = this.plugins.values().iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
    }

    public void destroy() {
        Iterator<BasePlugin> it = this.plugins.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    private Godzilla(Application application, HashMap<String, BasePlugin> hashMap, ILog iLog, Logger.Level level, IReflectHackHelper iReflectHackHelper) {
        this.application = application;
        this.plugins = hashMap;
        GodzillaCore.INSTANCE.init(application, iLog, level);
        Iterator<BasePlugin> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().init(this.application);
        }
        HackHelper.init(iReflectHackHelper);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Builder {
        private final Application application;
        private ILog log;
        private Logger.Level logLevel;
        private final HashMap<String, BasePlugin> plugins = new HashMap<>();
        private IReflectHackHelper reflectHackHelper;

        public Builder(Application application) {
            if (application == null) {
                throw new RuntimeException("Godzilla init, application is null");
            }
            this.application = application;
        }

        public Builder plugin(BasePlugin basePlugin) {
            String name = basePlugin.getName();
            if (TextUtils.isEmpty(name)) {
                throw new RuntimeException(String.format("%s plugin name is null", basePlugin.getClass().getName()));
            }
            if (this.plugins.get(name) != null) {
                throw new RuntimeException(String.format("%s plugin is already exist", name));
            }
            this.plugins.put(name, basePlugin);
            return this;
        }

        public Builder setReflectHackHelper(IReflectHackHelper iReflectHackHelper) {
            this.reflectHackHelper = iReflectHackHelper;
            return this;
        }

        public Builder setLog(ILog iLog) {
            this.log = iLog;
            return this;
        }

        public Builder setLogLevel(Logger.Level level) {
            this.logLevel = level;
            return this;
        }

        public Godzilla build() {
            return new Godzilla(this.application, this.plugins, this.log, this.logLevel, this.reflectHackHelper);
        }
    }
}
