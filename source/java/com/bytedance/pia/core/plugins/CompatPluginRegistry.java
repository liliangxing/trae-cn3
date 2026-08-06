package com.bytedance.pia.core.plugins;

import android.net.Uri;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.runtime.PluginRegistry;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CompatPluginRegistry extends PluginRegistry {
    @Override // com.bytedance.pia.core.runtime.PluginRegistry
    public void register(PiaRuntime piaRuntime) {
        PiaManifest create;
        super.register(piaRuntime);
        if (piaRuntime.isSchemeV2()) {
            return;
        }
        piaRuntime.getMetrics().onPvEvent(PvEventType.NSR_ENABLED, 0);
        piaRuntime.getMetrics().onPvEvent(PvEventType.SNAPSHOT_ENABLED, 0);
        piaRuntime.getMetrics().onPvEvent(PvEventType.PREFETCH_ENABLED, 0);
        if (!piaRuntime.getOriginUrl().getBooleanQueryParameter(PiaRuntime.SCHEMA_V1, false) || (create = PiaManifest.INSTANCE.create(piaRuntime.getOriginUrl().toString(), piaRuntime)) == null) {
            return;
        }
        Uri publicPath = create.getPublicPath();
        if (!Settings.get().isDomainAllowed(publicPath)) {
            Logger.m187w("[CompatPluginRegistry]: register failed, public path not support. Public path = " + publicPath);
            return;
        }
        piaRuntime.installPlugin(BridgePlugin.class);
        piaRuntime.installPlugin(BridgeDowngradePlugin.class, create);
        if (create.getEnableNsr() && Settings.get().getIsNsrV1Enabled()) {
            piaRuntime.installPlugin(NsrPlugin.class, create);
            piaRuntime.getMetrics().onPvEvent(PvEventType.NSR_ENABLED, 1);
        }
        if (create.getEnableSnapshot() && Settings.get().getIsSnapshotV1Enabled()) {
            piaRuntime.installPlugin(SnapshotPlugin.class, create);
            piaRuntime.getMetrics().onPvEvent(PvEventType.SNAPSHOT_ENABLED, 1);
        }
        if (create.getEnableWorker() && Settings.get().getIsPrefetchV1Enabled()) {
            piaRuntime.installPlugin(PrefetchPlugin.class, create);
            piaRuntime.getMetrics().onPvEvent(PvEventType.PREFETCH_ENABLED, 1);
        }
        Logger.m187w("[CompatPluginRegistry]: register success.");
    }
}
