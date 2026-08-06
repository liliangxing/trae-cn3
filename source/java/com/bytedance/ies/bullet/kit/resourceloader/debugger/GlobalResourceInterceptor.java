package com.bytedance.ies.bullet.kit.resourceloader.debugger;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalResourceInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012J\u0016\u0010\u001a\u001a\u00020\f2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0005J\u0016\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/debugger/GlobalResourceInterceptor;", "", "()V", "hookers", "", "Lcom/bytedance/ies/bullet/kit/resourceloader/debugger/ResourceLoaderHooker;", "loaders", "Ljava/lang/Class;", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/IXResourceLoader;", "getLoaders", "()Ljava/util/List;", "clear", "", "hookUrl", "Landroid/net/Uri;", "url", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "loadFailed", "resInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "taskConfig", "e", "", "loadSuccess", "registerLoader", "lClazz", "registerMonitor", "monitor", "startLoad", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GlobalResourceInterceptor {
    public static final GlobalResourceInterceptor INSTANCE = new GlobalResourceInterceptor();
    private static final List<Class<? extends IXResourceLoader>> loaders = new ArrayList();
    private static final List<ResourceLoaderHooker> hookers = new ArrayList();

    private GlobalResourceInterceptor() {
    }

    public final List<Class<? extends IXResourceLoader>> getLoaders() {
        return loaders;
    }

    public final void registerLoader(Class<? extends IXResourceLoader> lClazz) {
        Intrinsics.checkNotNullParameter(lClazz, "lClazz");
        loaders.add(lClazz);
    }

    public final void registerMonitor(ResourceLoaderHooker monitor) {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        hookers.add(monitor);
    }

    public final void clear() {
        loaders.clear();
        hookers.clear();
    }

    public final void startLoad(ResourceInfo resInfo, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Iterator<T> it = hookers.iterator();
        while (it.hasNext()) {
            ((ResourceLoaderHooker) it.next()).onLoadStart(resInfo, taskConfig);
        }
    }

    public final void loadSuccess(ResourceInfo resInfo, TaskConfig taskConfig) {
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Iterator<T> it = hookers.iterator();
        while (it.hasNext()) {
            ((ResourceLoaderHooker) it.next()).onLoadSuccess(resInfo, taskConfig);
        }
    }

    public final void loadFailed(ResourceInfo resInfo, TaskConfig taskConfig, Throwable e) {
        Intrinsics.checkNotNullParameter(resInfo, "resInfo");
        Intrinsics.checkNotNullParameter(taskConfig, "taskConfig");
        Intrinsics.checkNotNullParameter(e, "e");
        Iterator<T> it = hookers.iterator();
        while (it.hasNext()) {
            ((ResourceLoaderHooker) it.next()).onLoadFailed(resInfo, taskConfig, e);
        }
    }

    public final Uri hookUrl(String url, TaskConfig config) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(config, "config");
        Iterator<T> it = hookers.iterator();
        while (it.hasNext()) {
            Uri hookUrl = ((ResourceLoaderHooker) it.next()).hookUrl(url, config);
            if (hookUrl != null) {
                return hookUrl;
            }
        }
        return null;
    }
}
