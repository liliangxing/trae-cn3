package com.bytedance.ies.bullet.service.base.resourceloader.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/RLOptimiseConfig;", "", "()V", "specifiedPrefix", "", "", "getSpecifiedPrefix", "()Ljava/util/List;", "setSpecifiedPrefix", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RLOptimiseConfig {
    private List<String> specifiedPrefix = CollectionsKt.emptyList();

    public final List<String> getSpecifiedPrefix() {
        return this.specifiedPrefix;
    }

    public final void setSpecifiedPrefix(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.specifiedPrefix = list;
    }
}
