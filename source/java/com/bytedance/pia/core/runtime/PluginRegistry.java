package com.bytedance.pia.core.runtime;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.plugins.BootPlugin;
import com.bytedance.pia.core.plugins.BridgePlugin;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.bytedance.pia.core.plugins.ManifestPlugin;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.pia.core.plugins.PreloadPlugin;
import com.bytedance.pia.core.plugins.StreamingPlugin;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.worker.WarmupWorker;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PluginRegistry {
    private PluginRegistry next;
    private static final PluginRegistry rootRegistry = new PluginRegistry();
    private static final Set<Interceptor> interceptors = new HashSet();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Interceptor {
        boolean shouldIntercept(PiaRuntime piaRuntime);
    }

    public static void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public static void removeInterceptor(Interceptor interceptor) {
        interceptors.remove(interceptor);
    }

    public static void add(PluginRegistry pluginRegistry) {
        PluginRegistry pluginRegistry2 = rootRegistry;
        PluginRegistry pluginRegistry3 = pluginRegistry2.next;
        if (pluginRegistry3 == null) {
            pluginRegistry2.next = pluginRegistry;
            return;
        }
        PluginRegistry pluginRegistry4 = pluginRegistry3.next;
        while (true) {
            PluginRegistry pluginRegistry5 = pluginRegistry3;
            pluginRegistry3 = pluginRegistry4;
            if (pluginRegistry3 != null) {
                pluginRegistry4 = pluginRegistry3.next;
            } else {
                pluginRegistry5.next = pluginRegistry;
                return;
            }
        }
    }

    public static void remove(PluginRegistry pluginRegistry) {
        PluginRegistry pluginRegistry2 = rootRegistry;
        if (pluginRegistry == pluginRegistry2) {
            return;
        }
        PluginRegistry pluginRegistry3 = pluginRegistry2;
        while (true) {
            PluginRegistry pluginRegistry4 = pluginRegistry2.next;
            if (pluginRegistry4 == null) {
                return;
            }
            if (pluginRegistry2 == pluginRegistry) {
                pluginRegistry3.next = pluginRegistry4;
                return;
            } else {
                pluginRegistry3 = pluginRegistry2;
                pluginRegistry2 = pluginRegistry4;
            }
        }
    }

    public static PluginRegistry getRegistry() {
        return rootRegistry;
    }

    public void register(PiaRuntime piaRuntime) {
        Iterator<Interceptor> it = interceptors.iterator();
        while (it.hasNext()) {
            if (it.next().shouldIntercept(piaRuntime)) {
                return;
            }
        }
        PluginRegistry pluginRegistry = this.next;
        if (pluginRegistry != null) {
            pluginRegistry.register(piaRuntime);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class BaseRegistry extends PluginRegistry {
        @Override // com.bytedance.pia.core.runtime.PluginRegistry
        public void register(PiaRuntime piaRuntime) {
            super.register(piaRuntime);
            if (piaRuntime.isSchemeV2()) {
                piaRuntime.installPlugin(BridgePlugin.class);
                piaRuntime.installPlugin(PiaPropsPlugin.class);
                Uri uri = Uri.EMPTY;
                if (!TextUtils.isEmpty(piaRuntime.getConfig().getStreaming())) {
                    uri = Uri.parse(piaRuntime.getConfig().getStreaming());
                }
                boolean has = Settings.get().getIsMustFinishWarmup() ? WarmupWorker.has(uri) : true;
                if (Settings.openManifestCache(piaRuntime.getName())) {
                    piaRuntime.installPlugin(ManifestPlugin.class);
                }
                if (has && piaRuntime.getConfig().isStreamingEnabled()) {
                    piaRuntime.installPlugin(StreamingPlugin.class);
                } else {
                    WarmupWorker.release(uri);
                    piaRuntime.installPlugin(HtmlPlugin.class);
                    piaRuntime.installPlugin(BootPlugin.class);
                    if (Settings.openDefaultResourcePreload() || piaRuntime.getConfig().isPreloadEnabled()) {
                        piaRuntime.installPlugin(PreloadPlugin.class);
                    }
                }
                if (Settings.openManifestCache(piaRuntime.getName())) {
                    return;
                }
                piaRuntime.installPlugin(ManifestPlugin.class);
            }
        }
    }
}
