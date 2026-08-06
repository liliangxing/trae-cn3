package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/network/FolderNode;", "", "name", "", "path", "children", "", "hasChildren", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getName", "()Ljava/lang/String;", "getPath", "getChildren", "()Ljava/util/List;", "getHasChildren", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FolderNode {

    @SerializedName("children")
    private final List<FolderNode> children;

    @SerializedName("has_children")
    private final boolean hasChildren;

    @SerializedName("name")
    private final String name;

    @SerializedName("path")
    private final String path;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FolderNode copy$default(FolderNode folderNode, String str, String str2, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = folderNode.name;
        }
        if ((i & 2) != 0) {
            str2 = folderNode.path;
        }
        if ((i & 4) != 0) {
            list = folderNode.children;
        }
        if ((i & 8) != 0) {
            z = folderNode.hasChildren;
        }
        return folderNode.copy(str, str2, list, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final List<FolderNode> component3() {
        return this.children;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasChildren() {
        return this.hasChildren;
    }

    public final FolderNode copy(String name, String path, List<FolderNode> children, boolean hasChildren) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        return new FolderNode(name, path, children, hasChildren);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderNode)) {
            return false;
        }
        FolderNode folderNode = (FolderNode) other;
        return Intrinsics.areEqual(this.name, folderNode.name) && Intrinsics.areEqual(this.path, folderNode.path) && Intrinsics.areEqual(this.children, folderNode.children) && this.hasChildren == folderNode.hasChildren;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.path.hashCode()) * 31;
        List<FolderNode> list = this.children;
        return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.hasChildren);
    }

    public String toString() {
        return "FolderNode(name=" + this.name + ", path=" + this.path + ", children=" + this.children + ", hasChildren=" + this.hasChildren + ')';
    }

    public FolderNode(String name, String path, List<FolderNode> list, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.name = name;
        this.path = path;
        this.children = list;
        this.hasChildren = z;
    }

    public /* synthetic */ FolderNode(String str, String str2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final List<FolderNode> getChildren() {
        return this.children;
    }

    public final boolean getHasChildren() {
        return this.hasChildren;
    }
}
