package com.bytedance.pia.core.service;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.services.IPiaRenderingService;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.cache.PIACacheManager;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.bytedance.pia.core.plugins.ManifestPlugin;
import com.bytedance.pia.core.plugins.RenderingPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.runtime.PiaRuntimeFactory;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.UrlUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RenderingService implements IPiaRenderingService {
    private static final Map<String, PiaRuntime> runtimes = new HashMap();

    public static RenderingService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.bytedance.pia.core.api.services.IPiaRenderingService
    public IReleasable execute(String str, String str2, Map<String, ?> map, IConsumer<Map<String, ?>> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        return execute(str, str2, null, map, iConsumer, iConsumer2);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaRenderingService
    public IReleasable execute(String str, String str2, Object obj, Map<String, ?> map, final IConsumer<Map<String, ?>> iConsumer, final IConsumer<PiaMethod.Error> iConsumer2) {
        if (!Settings.get().getIsCacheEnabled()) {
            if (iConsumer2 != null) {
                iConsumer2.accept(new PiaMethod.SettingDisableError());
            }
            return null;
        }
        if (str == null) {
            iConsumer2.accept(new PiaMethod.SettingDisableError());
            return null;
        }
        Config config = Config.get(Uri.parse(str));
        if (config == null || !config.isNsrEnabled()) {
            iConsumer2.accept(new PiaMethod.SettingDisableError());
            return null;
        }
        PiaRuntime create = PiaRuntimeFactory.getInstance().create(str, str2, null, config, false);
        if (create == null) {
            if (iConsumer2 != null) {
                iConsumer2.accept(new PiaMethod.Error("Create runtime error!"));
            }
            return null;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final String obj2 = create.toString();
        runtimes.put(obj2, create);
        final IReleasable iReleasable = new IReleasable() { // from class: com.bytedance.pia.core.service.RenderingService$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IReleasable
            public final void release() {
                RenderingService.lambda$execute$0(atomicBoolean, obj2);
            }
        };
        IConsumer iConsumer3 = new IConsumer() { // from class: com.bytedance.pia.core.service.RenderingService$$ExternalSyntheticLambda1
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj3) {
                RenderingService.lambda$execute$1(atomicBoolean, iReleasable, iConsumer, (Map) obj3);
            }
        };
        IConsumer iConsumer4 = new IConsumer() { // from class: com.bytedance.pia.core.service.RenderingService$$ExternalSyntheticLambda2
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj3) {
                RenderingService.lambda$execute$2(atomicBoolean, iReleasable, iConsumer2, (PiaMethod.Error) obj3);
            }
        };
        create.installPlugin(HtmlPlugin.class);
        create.installPlugin(ManifestPlugin.class);
        create.installPlugin(RenderingPlugin.class, new RenderingPlugin.Params(map, iConsumer3, iConsumer4));
        create.initialize();
        return iReleasable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$execute$0(AtomicBoolean atomicBoolean, String str) {
        PiaRuntime remove;
        if (atomicBoolean.compareAndSet(false, true) && (remove = runtimes.remove(str)) != null) {
            remove.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$execute$1(AtomicBoolean atomicBoolean, IReleasable iReleasable, IConsumer iConsumer, Map map) {
        if (atomicBoolean.compareAndSet(false, true)) {
            iReleasable.release();
            if (iConsumer != null) {
                iConsumer.accept(map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$execute$2(AtomicBoolean atomicBoolean, IReleasable iReleasable, IConsumer iConsumer, PiaMethod.Error error) {
        if (atomicBoolean.compareAndSet(false, true)) {
            iReleasable.release();
            if (iConsumer != null) {
                iConsumer.accept(error);
            }
        }
    }

    @Override // com.bytedance.pia.core.api.services.IPiaRenderingService
    public boolean isCacheExist(Uri uri, List<String> list) {
        IPiaCacheProvider.CacheConfig queryHeaders;
        JsonObject meta;
        if (uri == null) {
            return false;
        }
        String normalizeUrl = UrlUtils.normalizeUrl(uri, list);
        if (TextUtils.isEmpty(normalizeUrl) || (queryHeaders = PIACacheManager.queryHeaders(normalizeUrl, null)) == null || (meta = queryHeaders.getMeta()) == null) {
            return false;
        }
        return TextUtils.equals("nsr", meta.get("type").getAsString());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static final RenderingService INSTANCE = new RenderingService();

        private InstanceHolder() {
        }
    }
}
