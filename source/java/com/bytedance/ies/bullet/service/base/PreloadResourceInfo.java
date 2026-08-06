package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadResourceInfo;", "", "srcUri", "Landroid/net/Uri;", "filePath", "", "isCache", "", "(Landroid/net/Uri;Ljava/lang/String;Z)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "()Z", "setCache", "(Z)V", "getSrcUri", "()Landroid/net/Uri;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class PreloadResourceInfo {
    private String filePath;
    private boolean isCache;
    private final Uri srcUri;

    public PreloadResourceInfo(Uri srcUri, String str, boolean z) {
        Intrinsics.checkNotNullParameter(srcUri, "srcUri");
        this.srcUri = srcUri;
        this.filePath = str;
        this.isCache = z;
    }

    public /* synthetic */ PreloadResourceInfo(Uri uri, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z);
    }

    public final Uri getSrcUri() {
        return this.srcUri;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final void setFilePath(String str) {
        this.filePath = str;
    }

    /* renamed from: isCache, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    public final void setCache(boolean z) {
        this.isCache = z;
    }
}
