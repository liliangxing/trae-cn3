package com.bytedance.forest.model;

import kotlin.Metadata;
import kotlin.TypeCastException;

/* compiled from: ResourceMetaData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/forest/model/ResourceMetaData;", "", "()V", "metaInfo", "Lcom/bytedance/forest/model/BasicMetaInfo;", "getMetaInfo", "()Lcom/bytedance/forest/model/BasicMetaInfo;", "setMetaInfo", "(Lcom/bytedance/forest/model/BasicMetaInfo;)V", "asFileMeta", "Lcom/bytedance/forest/model/FileMetaInfo;", "asStreamMeta", "Lcom/bytedance/forest/model/StreamMetaInfo;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ResourceMetaData {
    private BasicMetaInfo metaInfo;

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
        if (basicMetaInfo == null) {
            return null;
        }
        if (basicMetaInfo != null) {
            return (FileMetaInfo) basicMetaInfo;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.model.FileMetaInfo");
    }

    public final StreamMetaInfo asStreamMeta() {
        BasicMetaInfo basicMetaInfo = this.metaInfo;
        if (!(basicMetaInfo instanceof StreamMetaInfo)) {
            basicMetaInfo = null;
        }
        if (basicMetaInfo == null) {
            return null;
        }
        if (basicMetaInfo != null) {
            return (StreamMetaInfo) basicMetaInfo;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.model.StreamMetaInfo");
    }
}
