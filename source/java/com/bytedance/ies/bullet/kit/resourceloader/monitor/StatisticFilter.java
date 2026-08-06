package com.bytedance.ies.bullet.kit.resourceloader.monitor;

import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceUriHelperKt;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StatisticFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/StatisticFilter;", "", "()V", "filterScheme", "", "", "checkSample", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "url", "filterResult", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "resource", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StatisticFilter {
    public static final StatisticFilter INSTANCE = new StatisticFilter();
    private static final List<String> filterScheme;

    private StatisticFilter() {
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http");
        arrayList.add(ResourceUriHelperKt.SCHEME_FILE);
        arrayList.add(ResourceUriHelperKt.SCHEME_ASSETS);
        arrayList.add("https");
        arrayList.add("lynxview");
        filterScheme = arrayList;
    }

    public final ResourceInfo filterResult(ResourceInfo resource, TaskConfig config) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(config, "config");
        String scheme = resource.getSrcUri().getScheme();
        boolean z = true;
        if (!ResourceLoader.INSTANCE.isDebug() && !CollectionsKt.contains(filterScheme, scheme) && resource.getFrom() == null) {
            if (!(config.getChannel().length() > 0)) {
                z = false;
            }
        }
        resource.setStatisic(z);
        return resource;
    }

    public final boolean checkSample(ResourceLoaderConfig config, String url) {
        boolean z;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(url, "url");
        if (ResourceLoader.INSTANCE.isDebug()) {
            return false;
        }
        if (!config.getSampleWhiteList().isEmpty()) {
            Iterator<String> it = config.getSampleWhiteList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (StringsKt.contains$default(url, it.next(), false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return false;
            }
        }
        return true;
    }
}
