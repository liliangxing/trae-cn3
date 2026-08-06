package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MixConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/MixConfig;", "", "()V", "routerAllowList", "", "", "getRouterAllowList", "()Ljava/util/List;", "setRouterAllowList", "(Ljava/util/List;)V", "routerBlockList", "getRouterBlockList", "setRouterBlockList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MixConfig {

    @SerializedName("routerBlockList")
    private List<String> routerBlockList = CollectionsKt.emptyList();

    @SerializedName("routerAllowList")
    private List<String> routerAllowList = CollectionsKt.emptyList();

    public final List<String> getRouterBlockList() {
        return this.routerBlockList;
    }

    public final void setRouterBlockList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.routerBlockList = list;
    }

    public final List<String> getRouterAllowList() {
        return this.routerAllowList;
    }

    public final void setRouterAllowList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.routerAllowList = list;
    }
}
