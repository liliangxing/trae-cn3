package com.bytedance.ies.argus.repository;

import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import kotlin.Metadata;

/* compiled from: GeckoConfigFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", "", "str", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", CDNLoader.PIPELINE_VALUE, "OFFLINE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusGeckoFetchType {
    CDN("cdn"),
    OFFLINE("offline");

    private final String str;

    ArgusGeckoFetchType(String str) {
        this.str = str;
    }

    public final String getStr() {
        return this.str;
    }
}
