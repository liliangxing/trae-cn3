package com.bytedance.trae.conversation.products;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactListAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactItem;", "", "name", "", "iconResId", "", "path", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "getIconResId", "()I", "getPath", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ArtifactItem {
    private final int iconResId;
    private final String name;
    private final String path;

    public static /* synthetic */ ArtifactItem copy$default(ArtifactItem artifactItem, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = artifactItem.name;
        }
        if ((i2 & 2) != 0) {
            i = artifactItem.iconResId;
        }
        if ((i2 & 4) != 0) {
            str2 = artifactItem.path;
        }
        return artifactItem.copy(str, i, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIconResId() {
        return this.iconResId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final ArtifactItem copy(String name, int iconResId, String path) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        return new ArtifactItem(name, iconResId, path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactItem)) {
            return false;
        }
        ArtifactItem artifactItem = (ArtifactItem) other;
        return Intrinsics.areEqual(this.name, artifactItem.name) && this.iconResId == artifactItem.iconResId && Intrinsics.areEqual(this.path, artifactItem.path);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Integer.hashCode(this.iconResId)) * 31) + this.path.hashCode();
    }

    public String toString() {
        return "ArtifactItem(name=" + this.name + ", iconResId=" + this.iconResId + ", path=" + this.path + ')';
    }

    public ArtifactItem(String name, int i, String path) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.name = name;
        this.iconResId = i;
        this.path = path;
    }

    public /* synthetic */ ArtifactItem(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? "" : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final String getPath() {
        return this.path;
    }
}
