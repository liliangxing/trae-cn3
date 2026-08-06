package com.bytedance.pia.core.plugins;

import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.pia.core.api.resource.IPiaPreloader;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PreloadPlugin extends PiaPlugin {
    private final IPiaPreloader preloader;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return ResourceInfo.RESOURCE_FROM_PRELOAD;
    }

    public PreloadPlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
        this.preloader = IPiaPreloader.get(piaRuntime.getCustomContext());
    }

    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onEvent(String str, Object... objArr) {
        Map<String, ?> map;
        if (PiaRuntime.EVENT_ON_MANIFEST_READY.equals(str)) {
            Object obj = objArr[0];
            if (obj instanceof JsonObject) {
                JsonElement jsonElement = ((JsonObject) obj).get("resources");
                if (jsonElement instanceof JsonObject) {
                    try {
                        map = (Map) GsonUtils.getGson().fromJson(jsonElement, Map.class);
                    } catch (Throwable th) {
                        Logger.m179e("[Preload] parse preload config error", th);
                        map = null;
                    }
                    if (map == null) {
                        return;
                    }
                    this.preloader.setPerfListener(new IConsumer() { // from class: com.bytedance.pia.core.plugins.PreloadPlugin$$ExternalSyntheticLambda0
                        @Override // com.bytedance.pia.core.api.utils.IConsumer
                        public final void accept(Object obj2) {
                            PreloadPlugin.this.m754lambda$onEvent$0$combytedancepiacorepluginsPreloadPlugin((IPiaPreloader.PerfInfo) obj2);
                        }
                    });
                    this.preloader.preload(this.runtime.getOriginUrl().toString(), map);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onEvent$0$com-bytedance-pia-core-plugins-PreloadPlugin, reason: not valid java name */
    public /* synthetic */ void m754lambda$onEvent$0$combytedancepiacorepluginsPreloadPlugin(IPiaPreloader.PerfInfo perfInfo) {
        this.runtime.getTrace().traceWithArgs(EventName.PreloadResourceStart, perfInfo.getPreloadStart()).appendArg("url", perfInfo.getUrl()).flush();
        this.runtime.getTrace().traceWithArgs(EventName.PreloadResourceEnd, perfInfo.getPreloadEnd()).appendArg("url", perfInfo.getUrl()).flush();
    }

    @Override // com.bytedance.pia.core.runtime.PiaPlugin, com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        IPiaPreloader iPiaPreloader = this.preloader;
        if (iPiaPreloader instanceof IReleasable) {
            ((IReleasable) iPiaPreloader).release();
        }
    }
}
