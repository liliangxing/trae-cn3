package com.bytedance.pia.core.runtime;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.plugins.ManifestPlugin;
import com.bytedance.pia.core.service.EnvService;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.storage.PageStorage;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.Logger;
import com.google.gson.JsonObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ManifestCacheTask {
    private Throwable error;
    private IConsumer<Throwable> reject;
    private IReleasable releasable;
    private IConsumer<IResourceResponse> resolve;
    private IResourceResponse response;
    private String traceV2;
    private String traceV3;
    private String url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri lambda$start$0(Uri uri) {
        return uri;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void start(String str, String str2, Object obj) {
        IResourceLoader create;
        JsonObject jsonObject;
        if (Settings.openManifestCache(str)) {
            IFactory<IResourceLoader> resourceLoaderFactory = EnvService.getInstance().getEnv(str2).getResourceLoaderFactory();
            String str3 = null;
            if (resourceLoaderFactory != null) {
                try {
                    create = resourceLoaderFactory.create(obj);
                } catch (Throwable th) {
                    Logger.m179e("[Runtime] create ResourceLoader error:", th);
                }
                DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader(create);
                this.traceV3 = "1";
                jsonObject = (JsonObject) new PageStorage(str).get(ManifestPlugin.KEY_CACHE_V2, JsonObject.class);
                if (jsonObject != null) {
                    this.traceV2 = "1";
                    try {
                        str3 = jsonObject.get(ErrorType.PREFETCH).getAsJsonObject().get("url").getAsString();
                    } catch (Throwable th2) {
                        Logger.m176d("[manifest] load worker.js from cache error", th2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        this.url = str3;
                        final Uri parse = Uri.parse(str3);
                        this.releasable = defaultResourceLoader.loadAsync(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.runtime.ManifestCacheTask$$ExternalSyntheticLambda0
                            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                            /* renamed from: getUrl */
                            public final Uri get$uri() {
                                return ManifestCacheTask.lambda$start$0(parse);
                            }
                        }, new IConsumer() { // from class: com.bytedance.pia.core.runtime.ManifestCacheTask$$ExternalSyntheticLambda1
                            @Override // com.bytedance.pia.core.api.utils.IConsumer
                            public final void accept(Object obj2) {
                                ManifestCacheTask.this.m755lambda$start$1$combytedancepiacoreruntimeManifestCacheTask((IResourceResponse) obj2);
                            }
                        }, new IConsumer() { // from class: com.bytedance.pia.core.runtime.ManifestCacheTask$$ExternalSyntheticLambda2
                            @Override // com.bytedance.pia.core.api.utils.IConsumer
                            public final void accept(Object obj2) {
                                ManifestCacheTask.this.m756lambda$start$2$combytedancepiacoreruntimeManifestCacheTask((Throwable) obj2);
                            }
                        });
                    }
                }
            }
            create = null;
            DefaultResourceLoader defaultResourceLoader2 = new DefaultResourceLoader(create);
            this.traceV3 = "1";
            jsonObject = (JsonObject) new PageStorage(str).get(ManifestPlugin.KEY_CACHE_V2, JsonObject.class);
            if (jsonObject != null) {
            }
        }
        if (!Settings.isOpenManifestCachePage(str) || Settings.inOpenManifestCacheSample()) {
            return;
        }
        this.traceV2 = ViewVisibleBridge.INVISIBLE;
        this.traceV3 = ViewVisibleBridge.INVISIBLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$1$com-bytedance-pia-core-runtime-ManifestCacheTask, reason: not valid java name */
    public /* synthetic */ void m755lambda$start$1$combytedancepiacoreruntimeManifestCacheTask(IResourceResponse iResourceResponse) {
        synchronized (this) {
            Logger.m175d("[manifest] load worker.js from cache success");
            IConsumer<IResourceResponse> iConsumer = this.resolve;
            if (iConsumer != null) {
                iConsumer.accept(iResourceResponse);
            } else {
                this.response = iResourceResponse;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$2$com-bytedance-pia-core-runtime-ManifestCacheTask, reason: not valid java name */
    public /* synthetic */ void m756lambda$start$2$combytedancepiacoreruntimeManifestCacheTask(Throwable th) {
        Logger.m176d("[manifest] load worker.js from cache error", th);
        synchronized (this) {
            IConsumer<Throwable> iConsumer = this.reject;
            if (iConsumer != null) {
                iConsumer.accept(th);
            } else {
                this.error = th;
            }
        }
    }

    public boolean check(String str, PiaContext piaContext) {
        if (this.traceV2 != null) {
            piaContext.getOnlineTrace().updateExtras(ManifestPlugin.KEY_CACHE_V2, this.traceV2);
        }
        if (this.traceV3 != null) {
            piaContext.getOnlineTrace().updateExtras(ManifestPlugin.KEY_CACHE_V3, this.traceV3);
        }
        return !TextUtils.isEmpty(this.url) && TextUtils.equals(str, this.url);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:22:0x0004, B:24:0x0008, B:6:0x0012, B:8:0x0016, B:10:0x001d, B:11:0x0021, B:12:0x0023), top: B:21:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IReleasable subscribe(IConsumer<IResourceResponse> iConsumer, IConsumer<Throwable> iConsumer2) {
        boolean z;
        IReleasable iReleasable;
        Throwable th;
        synchronized (this) {
            boolean z2 = true;
            if (iConsumer != null) {
                try {
                    IResourceResponse iResourceResponse = this.response;
                    if (iResourceResponse != null) {
                        iConsumer.accept(iResourceResponse);
                        z = true;
                        if (iConsumer2 != null || (th = this.error) == null) {
                            z2 = z;
                        } else {
                            iConsumer2.accept(th);
                        }
                        if (!z2) {
                            this.resolve = iConsumer;
                            this.reject = iConsumer2;
                        }
                        iReleasable = this.releasable;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            z = false;
            if (iConsumer2 != null) {
            }
            z2 = z;
            if (!z2) {
            }
            iReleasable = this.releasable;
        }
        return iReleasable;
    }
}
