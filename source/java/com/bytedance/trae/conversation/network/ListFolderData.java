package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.model.MessagePart;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Models.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/network/ListFolderData;", "", MessagePart.TYPE_FOLDER, "Lcom/bytedance/trae/conversation/network/FolderNode;", "<init>", "(Lcom/bytedance/trae/conversation/network/FolderNode;)V", "getFolder", "()Lcom/bytedance/trae/conversation/network/FolderNode;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ListFolderData {

    @SerializedName(MessagePart.TYPE_FOLDER)
    private final FolderNode folder;

    /* JADX WARN: Multi-variable type inference failed */
    public ListFolderData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ListFolderData copy$default(ListFolderData listFolderData, FolderNode folderNode, int i, Object obj) {
        if ((i & 1) != 0) {
            folderNode = listFolderData.folder;
        }
        return listFolderData.copy(folderNode);
    }

    /* renamed from: component1, reason: from getter */
    public final FolderNode getFolder() {
        return this.folder;
    }

    public final ListFolderData copy(FolderNode folder) {
        return new ListFolderData(folder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ListFolderData) && Intrinsics.areEqual(this.folder, ((ListFolderData) other).folder);
    }

    public int hashCode() {
        FolderNode folderNode = this.folder;
        if (folderNode == null) {
            return 0;
        }
        return folderNode.hashCode();
    }

    public String toString() {
        return "ListFolderData(folder=" + this.folder + ')';
    }

    public ListFolderData(FolderNode folderNode) {
        this.folder = folderNode;
    }

    public /* synthetic */ ListFolderData(FolderNode folderNode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : folderNode);
    }

    public final FolderNode getFolder() {
        return this.folder;
    }
}
