package com.bytedance.trae.conversation.devices;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DirectoryNode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003Jy\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001aR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001aR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001a¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "", "id", "", "name", "path", "depth", "", "parentId", "hasChildren", "", "isExpanded", "isLoading", "childrenLoaded", "isEditing", "isSelected", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZZZZ)V", "getId", "()Ljava/lang/String;", "getName", "getPath", "getDepth", "()I", "getParentId", "getHasChildren", "()Z", "getChildrenLoaded", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DirectoryNode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_NEW_FOLDER_NAME = "未命名文件夹";
    private final boolean childrenLoaded;
    private final int depth;
    private final boolean hasChildren;
    private final String id;
    private final boolean isEditing;
    private final boolean isExpanded;
    private final boolean isLoading;
    private final boolean isSelected;
    private final String name;
    private final String parentId;
    private final String path;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsEditing() {
        return this.isEditing;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    /* renamed from: component5, reason: from getter */
    public final String getParentId() {
        return this.parentId;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasChildren() {
        return this.hasChildren;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getChildrenLoaded() {
        return this.childrenLoaded;
    }

    public final DirectoryNode copy(String id, String name, String path, int depth, String parentId, boolean hasChildren, boolean isExpanded, boolean isLoading, boolean childrenLoaded, boolean isEditing, boolean isSelected) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        return new DirectoryNode(id, name, path, depth, parentId, hasChildren, isExpanded, isLoading, childrenLoaded, isEditing, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryNode)) {
            return false;
        }
        DirectoryNode directoryNode = (DirectoryNode) other;
        return Intrinsics.areEqual(this.id, directoryNode.id) && Intrinsics.areEqual(this.name, directoryNode.name) && Intrinsics.areEqual(this.path, directoryNode.path) && this.depth == directoryNode.depth && Intrinsics.areEqual(this.parentId, directoryNode.parentId) && this.hasChildren == directoryNode.hasChildren && this.isExpanded == directoryNode.isExpanded && this.isLoading == directoryNode.isLoading && this.childrenLoaded == directoryNode.childrenLoaded && this.isEditing == directoryNode.isEditing && this.isSelected == directoryNode.isSelected;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.path.hashCode()) * 31) + Integer.hashCode(this.depth)) * 31;
        String str = this.parentId;
        return ((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.hasChildren)) * 31) + Boolean.hashCode(this.isExpanded)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.childrenLoaded)) * 31) + Boolean.hashCode(this.isEditing)) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DirectoryNode(id=");
        sb.append(this.id).append(", name=").append(this.name).append(", path=").append(this.path).append(", depth=").append(this.depth).append(", parentId=").append(this.parentId).append(", hasChildren=").append(this.hasChildren).append(", isExpanded=").append(this.isExpanded).append(", isLoading=").append(this.isLoading).append(", childrenLoaded=").append(this.childrenLoaded).append(", isEditing=").append(this.isEditing).append(", isSelected=").append(this.isSelected).append(')');
        return sb.toString();
    }

    public DirectoryNode(String id, String name, String path, int i, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(path, "path");
        this.id = id;
        this.name = name;
        this.path = path;
        this.depth = i;
        this.parentId = str;
        this.hasChildren = z;
        this.isExpanded = z2;
        this.isLoading = z3;
        this.childrenLoaded = z4;
        this.isEditing = z5;
        this.isSelected = z6;
    }

    public /* synthetic */ DirectoryNode(String str, String str2, String str3, int i, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? true : z, (i2 & 64) != 0 ? false : z2, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? false : z5, (i2 & 1024) != 0 ? false : z6);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final boolean getHasChildren() {
        return this.hasChildren;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean getChildrenLoaded() {
        return this.childrenLoaded;
    }

    public final boolean isEditing() {
        return this.isEditing;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    /* compiled from: DirectoryNode.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;", "", "<init>", "()V", "DEFAULT_NEW_FOLDER_NAME", "", "newFolderPlaceholder", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "parentId", "depth", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DirectoryNode newFolderPlaceholder(String parentId, int depth) {
            return new DirectoryNode("new_folder_" + System.currentTimeMillis(), DirectoryNode.DEFAULT_NEW_FOLDER_NAME, "", depth, parentId, false, false, false, false, true, false);
        }
    }
}
