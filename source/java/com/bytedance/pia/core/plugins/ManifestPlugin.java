package com.bytedance.pia.core.plugins;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ManifestPlugin extends PiaPlugin {
    public static final String KEY_CACHE_V2 = "manifestV2";
    public static final String KEY_CACHE_V3 = "manifestV3";
    private final AtomicReference<JsonObject> theUsedManifest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri lambda$preloadByManifest$0(Uri uri) {
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return ErrorType.MANIFEST;
    }

    public ManifestPlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
        this.theUsedManifest = new AtomicReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void initialize() {
        JsonObject jsonObject;
        if (Settings.openManifestCache(this.runtime.getName())) {
            this.runtime.getOnlineTrace().updateExtras(KEY_CACHE_V3, "1");
            JsonObject jsonObject2 = (JsonObject) this.runtime.getPageStorage().get(KEY_CACHE_V2, JsonObject.class);
            if (jsonObject2 != null) {
                preloadByManifest(jsonObject2);
            }
        }
        if (Settings.isOpenManifestCachePage(this.runtime.getName()) && !Settings.inOpenManifestCacheSample()) {
            this.runtime.getOnlineTrace().updateExtras(KEY_CACHE_V2, ViewVisibleBridge.INVISIBLE);
            this.runtime.getOnlineTrace().updateExtras(KEY_CACHE_V3, ViewVisibleBridge.INVISIBLE);
        }
        if (this.runtime.getConfig().isManifestCacheEnabled() && (jsonObject = (JsonObject) this.runtime.getPageStorage().get(ErrorType.MANIFEST, JsonObject.class)) != null) {
            try {
                if (jsonObject.get(IPiaCacheProvider.CacheConfig.FIELD_VERSION).getAsString().equals(this.runtime.getConfig().getVersion())) {
                    jsonObject.add(PraiseDialogConstant.FROM, new JsonPrimitive("cache"));
                    tryUseManifest(jsonObject);
                }
            } catch (Throwable th) {
                Logger.m179e("[Manifest] Get cached manifest version failed:", th);
            }
        }
    }

    private void preloadByManifest(JsonObject jsonObject) {
        try {
            String asString = jsonObject.get(ErrorType.PREFETCH).getAsJsonObject().get("url").getAsString();
            if (!TextUtils.isEmpty(asString)) {
                final Uri parse = Uri.parse(asString);
                this.runtime.getTrace().traceWithArgs(EventName.WorkerScriptRequestStart).appendArg("url", asString).flush(false);
                this.runtime.getResource().loadAsync(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.plugins.ManifestPlugin$$ExternalSyntheticLambda2
                    @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                    /* renamed from: getUrl */
                    public final Uri get$uri() {
                        return ManifestPlugin.lambda$preloadByManifest$0(parse);
                    }
                }, new IConsumer() { // from class: com.bytedance.pia.core.plugins.ManifestPlugin$$ExternalSyntheticLambda3
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj) {
                        ManifestPlugin.this.m167x34b73b05((IResourceResponse) obj);
                    }
                }, new IConsumer() { // from class: com.bytedance.pia.core.plugins.ManifestPlugin$$ExternalSyntheticLambda4
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj) {
                        Logger.m176d("[manifest] load worker.js from cache error", (Throwable) obj);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.m176d("[manifest] load worker.js from cache error", th);
        }
        PiaPlugin plugin = this.runtime.getPlugin(ResourceInfo.RESOURCE_FROM_PRELOAD);
        if (plugin instanceof PreloadPlugin) {
            ((PreloadPlugin) plugin).onEvent(PiaRuntime.EVENT_ON_MANIFEST_READY, jsonObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$preloadByManifest$1$com-bytedance-pia-core-plugins-ManifestPlugin */
    public /* synthetic */ void m167x34b73b05(IResourceResponse iResourceResponse) {
        this.runtime.getOnlineTrace().updateExtras(KEY_CACHE_V2, "1");
        Logger.m175d("[manifest] load worker.js from cache success");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onEvent(String str, Object... objArr) {
        JsonElement jsonElement;
        if (PiaRuntime.EVENT_ON_MANIFEST_IN_HTML_READY.equals(str)) {
            boolean z = false;
            final Object obj = objArr[0];
            if (obj instanceof JsonObject) {
                if (this.runtime.getConfig().isManifestCacheEnabled()) {
                    this.runtime.getPageStorage().put(ErrorType.MANIFEST, obj);
                }
                if (Settings.openManifestCache(this.runtime.getName())) {
                    try {
                        JsonElement jsonElement2 = ((JsonObject) obj).get("cache");
                        z = (jsonElement2 == null || !jsonElement2.isJsonObject() || (jsonElement = jsonElement2.getAsJsonObject().get(ErrorType.MANIFEST)) == null || !jsonElement.isJsonPrimitive()) ? true : jsonElement.getAsBoolean();
                    } catch (Exception unused) {
                    }
                    if (z) {
                        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.plugins.ManifestPlugin$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                ManifestPlugin.this.m752lambda$onEvent$3$combytedancepiacorepluginsManifestPlugin(obj);
                            }
                        });
                    } else {
                        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.plugins.ManifestPlugin$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ManifestPlugin.this.m753lambda$onEvent$4$combytedancepiacorepluginsManifestPlugin();
                            }
                        });
                    }
                }
                tryUseManifest((JsonObject) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onEvent$3$com-bytedance-pia-core-plugins-ManifestPlugin, reason: not valid java name */
    public /* synthetic */ void m752lambda$onEvent$3$combytedancepiacorepluginsManifestPlugin(Object obj) {
        this.runtime.getPageStorage().put(KEY_CACHE_V2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onEvent$4$com-bytedance-pia-core-plugins-ManifestPlugin, reason: not valid java name */
    public /* synthetic */ void m753lambda$onEvent$4$combytedancepiacorepluginsManifestPlugin() {
        this.runtime.getPageStorage().remove(KEY_CACHE_V2);
    }

    private void tryUseManifest(JsonObject jsonObject) {
        if (jsonObject != null && UByte$.ExternalSyntheticBackport0.m(this.theUsedManifest, (Object) null, jsonObject)) {
            Logger.m181i("[manifest] use manifest:" + jsonObject);
            this.runtime.sendEvent(PiaRuntime.EVENT_ON_MANIFEST_READY, jsonObject);
            PiaPlugin plugin = this.runtime.getPlugin(PiaPropsPlugin.NAME);
            if (plugin instanceof PiaPropsPlugin) {
                ((PiaPropsPlugin) plugin).addProps(PiaPropsPlugin.PROPS_NAME_MANIFEST, jsonObject.toString());
            }
        }
    }
}
