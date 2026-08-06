package com.bytedance.ies.bullet.preloadv2;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.preloadv2.cache.ByteArrayPreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.HighSubResourceMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadItem;
import com.bytedance.ies.bullet.preloadv2.cache.PreloadResourceType;
import com.bytedance.ies.bullet.preloadv2.cache.SubResourceMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.TemplateMemCache;
import com.bytedance.ies.bullet.preloadv2.cache.TemplatePreloadItem;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadHelper;
import com.bytedance.ies.bullet.preloadv2.utils.PreloadLogger;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreloadLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J@\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u000bH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/PreloadLoader;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "()V", "cancelLoad", "", "loadAsync", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "resolve", "Lkotlin/Function1;", "reject", "", "loadFromPreloadV2", CDNLoader.STEP_NAME_SYNC, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadLoader extends IXResourceLoader {
    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void cancelLoad() {
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public ResourceInfo loadSync(ResourceInfo input, TaskConfig config) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        ResourceInfo loadFromPreloadV2 = loadFromPreloadV2(input, config);
        if (loadFromPreloadV2 == null) {
            PreloadLogger.INSTANCE.m41d("PreloadLoader miss " + input.getSrcUri());
        } else {
            PreloadLogger.INSTANCE.m41d("PreloadLoader hit " + input.getSrcUri());
        }
        return loadFromPreloadV2;
    }

    @Override // com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader
    public void loadAsync(ResourceInfo input, TaskConfig config, Function1<? super ResourceInfo, Unit> resolve, Function1<? super Throwable, Unit> reject) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        ResourceInfo loadFromPreloadV2 = loadFromPreloadV2(input, config);
        if (loadFromPreloadV2 == null) {
            PreloadLogger.INSTANCE.m41d("PreloadLoader miss " + input.getSrcUri());
            reject.invoke(new Throwable(input.getPreloadFailMessage()));
        } else {
            PreloadLogger.INSTANCE.m41d("PreloadLoader hit " + input.getSrcUri());
            resolve.invoke(loadFromPreloadV2);
        }
    }

    private final ResourceInfo loadFromPreloadV2(ResourceInfo input, TaskConfig config) {
        ResourceInfo resourceInfo;
        ResourceInfo resourceInfo2 = null;
        resourceInfo2 = null;
        resourceInfo2 = null;
        resourceInfo2 = null;
        resourceInfo2 = null;
        resourceInfo2 = null;
        if (!PreloadV2.INSTANCE.getEnablePreload()) {
            input.setPreloadFailMessage("disable by settings");
            return null;
        }
        if (config.getIsPreload()) {
            input.setPreloadFailMessage("preload process");
            return null;
        }
        PreloadHelper preloadHelper = PreloadHelper.INSTANCE;
        String uri = input.getSrcUri().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "input.srcUri.toString()");
        String generateKey = preloadHelper.generateKey(config, null, uri);
        PreloadLogger.INSTANCE.m41d("PreloadLoader " + generateKey);
        if (Intrinsics.areEqual(config.getResTag(), "template")) {
            PreloadItem cache = TemplateMemCache.INSTANCE.getCache(generateKey);
            if (cache != null) {
                ResourceInfo resourceInfo3 = cache.getResourceInfo();
                if (resourceInfo3 != null) {
                    TemplatePreloadItem templatePreloadItem = cache instanceof TemplatePreloadItem ? (TemplatePreloadItem) cache : null;
                    resourceInfo3.setByteArray(templatePreloadItem != null ? templatePreloadItem.getByteArray() : null);
                    resourceInfo3.setUsePreloadCache(true);
                    resourceInfo3.setFromMemory(true);
                    resourceInfo2 = resourceInfo3;
                }
                TemplateMemCache.INSTANCE.removeCache(generateKey);
            }
        } else {
            PreloadItem cache2 = HighSubResourceMemCache.INSTANCE.getCache(generateKey);
            if (cache2 == null) {
                cache2 = SubResourceMemCache.INSTANCE.getCache(generateKey);
            }
            if (cache2 != null) {
                boolean z = cache2 instanceof ByteArrayPreloadItem;
                if (z) {
                    ResourceInfo resourceInfo4 = cache2.getResourceInfo();
                    if (resourceInfo4 != null) {
                        PreloadLogger.INSTANCE.m43i("命中内存缓存 byteArray " + cache2.getType().getTag() + ' ' + generateKey);
                        ByteArrayPreloadItem byteArrayPreloadItem = z ? (ByteArrayPreloadItem) cache2 : null;
                        resourceInfo4.setByteArray(byteArrayPreloadItem != null ? byteArrayPreloadItem.getByteArray() : null);
                        resourceInfo4.setUsePreloadCache(true);
                        resourceInfo4.setFromMemory(true);
                        resourceInfo2 = resourceInfo4;
                    }
                } else if ((cache2.getType() == PreloadResourceType.Lottie || cache2.getType() == PreloadResourceType.Any) && (resourceInfo = cache2.getResourceInfo()) != null) {
                    PreloadLogger.INSTANCE.m43i("命中磁盘缓存 lottie " + cache2.getType().getTag() + ' ' + generateKey);
                    resourceInfo.setUsePreloadCache(true);
                    resourceInfo.setFromMemory(true);
                    resourceInfo2 = resourceInfo;
                }
            }
        }
        if (resourceInfo2 == null) {
            input.setPreloadFailMessage("preload mem miss");
        }
        return resourceInfo2;
    }
}
