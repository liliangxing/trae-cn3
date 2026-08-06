package com.bytedance.ies.bullet.kit.resourceloader;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceMetaData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceMetaData;", "", "sourceUri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "metaInfo", "Lcom/bytedance/ies/bullet/kit/resourceloader/BasicMetaInfo;", "getMetaInfo", "()Lcom/bytedance/ies/bullet/kit/resourceloader/BasicMetaInfo;", "setMetaInfo", "(Lcom/bytedance/ies/bullet/kit/resourceloader/BasicMetaInfo;)V", "getSourceUri", "()Landroid/net/Uri;", "asFileMeta", "Lcom/bytedance/ies/bullet/kit/resourceloader/FileMetaInfo;", "asStreamMeta", "Lcom/bytedance/ies/bullet/kit/resourceloader/StreamMetaInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceMetaData {
    private BasicMetaInfo metaInfo;
    private final Uri sourceUri;

    public ResourceMetaData(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "sourceUri");
        this.sourceUri = uri;
    }

    public final Uri getSourceUri() {
        return this.sourceUri;
    }

    public final BasicMetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    public final void setMetaInfo(BasicMetaInfo basicMetaInfo) {
        this.metaInfo = basicMetaInfo;
    }

    public final FileMetaInfo asFileMeta() {
        BasicMetaInfo basicMetaInfo = this.metaInfo;
        if (!(basicMetaInfo instanceof FileMetaInfo)) {
            basicMetaInfo = null;
        }
        if (basicMetaInfo != null) {
            return (FileMetaInfo) basicMetaInfo;
        }
        return null;
    }

    public final StreamMetaInfo asStreamMeta() {
        BasicMetaInfo basicMetaInfo = this.metaInfo;
        if (!(basicMetaInfo instanceof StreamMetaInfo)) {
            basicMetaInfo = null;
        }
        if (basicMetaInfo != null) {
            return (StreamMetaInfo) basicMetaInfo;
        }
        return null;
    }
}
