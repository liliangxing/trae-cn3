package com.bytedance.ies.bullet.service.base.resourceloader.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtraInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ExtraInfo;", "", "prefixFromSchema", "", "(Ljava/lang/String;)V", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtraInfo {
    private String prefix;

    public ExtraInfo(String prefixFromSchema) {
        Intrinsics.checkNotNullParameter(prefixFromSchema, "prefixFromSchema");
        this.prefix = prefixFromSchema;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final void setPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prefix = str;
    }
}
