package com.bytedance.ies.bullet.service.base.resourceloader.config;

import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.TimeInterval;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IXResourceLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H&J@\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00140\u001bH&J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", EventConstants.PARAM_SOURCE_INTERVAL, "Lcom/bytedance/ies/bullet/kit/resourceloader/TimeInterval;", "getInterval", "()Lcom/bytedance/ies/bullet/kit/resourceloader/TimeInterval;", "setInterval", "(Lcom/bytedance/ies/bullet/kit/resourceloader/TimeInterval;)V", "service", "Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "getService", "()Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;", "setService", "(Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderService;)V", "cancelLoad", "", "loadAsync", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "resolve", "Lkotlin/Function1;", "reject", "", CDNLoader.STEP_NAME_SYNC, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class IXResourceLoader {
    private final String TAG;
    private TimeInterval interval;
    public ResourceLoaderService service;

    public abstract void cancelLoad();

    public abstract void loadAsync(ResourceInfo input, TaskConfig config, Function1<? super ResourceInfo, Unit> resolve, Function1<? super Throwable, Unit> reject);

    public abstract ResourceInfo loadSync(ResourceInfo input, TaskConfig config);

    public IXResourceLoader() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        this.TAG = simpleName;
        this.interval = new TimeInterval();
    }

    public final ResourceLoaderService getService() {
        ResourceLoaderService resourceLoaderService = this.service;
        if (resourceLoaderService != null) {
            return resourceLoaderService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("service");
        return null;
    }

    public final void setService(ResourceLoaderService resourceLoaderService) {
        Intrinsics.checkNotNullParameter(resourceLoaderService, "<set-?>");
        this.service = resourceLoaderService;
    }

    public String getTAG() {
        return this.TAG;
    }

    public final TimeInterval getInterval() {
        return this.interval;
    }

    public final void setInterval(TimeInterval timeInterval) {
        Intrinsics.checkNotNullParameter(timeInterval, "<set-?>");
        this.interval = timeInterval;
    }
}
