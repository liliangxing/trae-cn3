package com.bytedance.platform.godzilla.plugin;

import android.app.Application;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class PluginGroup extends BasePlugin {
    private List<BasePlugin> mPluginList;
    private XHookPlugin xHookPlugin;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public abstract String getName();

    protected abstract List<BasePlugin> getPluginList();

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void init(Application application) {
        super.init(application);
        List<BasePlugin> pluginList = getPluginList();
        this.mPluginList = pluginList;
        Iterator<BasePlugin> it = pluginList.iterator();
        while (it.hasNext()) {
            it.next().init(application);
        }
    }

    public final void start(StartType startType) {
        for (BasePlugin basePlugin : this.mPluginList) {
            if (basePlugin.startType() == startType) {
                basePlugin.start();
                if (basePlugin instanceof XHookPlugin) {
                    this.xHookPlugin = (XHookPlugin) basePlugin;
                }
            }
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void start() {
        super.start();
        Iterator<BasePlugin> it = this.mPluginList.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void stop() {
        super.stop();
        Iterator<BasePlugin> it = this.mPluginList.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void destroy() {
        super.destroy();
        Iterator<BasePlugin> it = this.mPluginList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public XHookPlugin getXHookPlugin() {
        return this.xHookPlugin;
    }

    public void setXHookPlugin(XHookPlugin xHookPlugin) {
        this.xHookPlugin = xHookPlugin;
    }
}
