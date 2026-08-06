package com.bytedance.ies.bullet.service.base.resourceloader.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceLoaderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/RLDownLoadInfo;", "", "filePath", "", "isCache", "", "(Ljava/lang/String;Z)V", "getFilePath", "()Ljava/lang/String;", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class RLDownLoadInfo {
    private final String filePath;
    private final boolean isCache;

    public RLDownLoadInfo(String filePath, boolean z) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
        this.isCache = z;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: isCache, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }
}
