package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.devices.DirectoryViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DirectoryViewModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rHÆ\u0003JO\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/trae/conversation/devices/DirectoryUiState;", "", "nodes", "", "Lcom/bytedance/trae/conversation/devices/DirectoryNode;", "title", "", "isRootLoading", "", "currentParentId", "currentDepth", "", "resolvedMode", "Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;", "<init>", "(Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ILcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)V", "getNodes", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "()Z", "getCurrentParentId", "getCurrentDepth", "()I", "getResolvedMode", "()Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class DirectoryUiState {
    private final int currentDepth;
    private final String currentParentId;
    private final boolean isRootLoading;
    private final List<DirectoryNode> nodes;
    private final DirectoryViewModel.Mode resolvedMode;
    private final String title;

    public DirectoryUiState() {
        this(null, null, false, null, 0, null, 63, null);
    }

    public static /* synthetic */ DirectoryUiState copy$default(DirectoryUiState directoryUiState, List list, String str, boolean z, String str2, int i, DirectoryViewModel.Mode mode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = directoryUiState.nodes;
        }
        if ((i2 & 2) != 0) {
            str = directoryUiState.title;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            z = directoryUiState.isRootLoading;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str2 = directoryUiState.currentParentId;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            i = directoryUiState.currentDepth;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            mode = directoryUiState.resolvedMode;
        }
        return directoryUiState.copy(list, str3, z2, str4, i3, mode);
    }

    public final List<DirectoryNode> component1() {
        return this.nodes;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsRootLoading() {
        return this.isRootLoading;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCurrentParentId() {
        return this.currentParentId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCurrentDepth() {
        return this.currentDepth;
    }

    /* renamed from: component6, reason: from getter */
    public final DirectoryViewModel.Mode getResolvedMode() {
        return this.resolvedMode;
    }

    public final DirectoryUiState copy(List<DirectoryNode> nodes, String title, boolean isRootLoading, String currentParentId, int currentDepth, DirectoryViewModel.Mode resolvedMode) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        Intrinsics.checkNotNullParameter(title, "title");
        return new DirectoryUiState(nodes, title, isRootLoading, currentParentId, currentDepth, resolvedMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryUiState)) {
            return false;
        }
        DirectoryUiState directoryUiState = (DirectoryUiState) other;
        return Intrinsics.areEqual(this.nodes, directoryUiState.nodes) && Intrinsics.areEqual(this.title, directoryUiState.title) && this.isRootLoading == directoryUiState.isRootLoading && Intrinsics.areEqual(this.currentParentId, directoryUiState.currentParentId) && this.currentDepth == directoryUiState.currentDepth && this.resolvedMode == directoryUiState.resolvedMode;
    }

    public int hashCode() {
        int hashCode = ((((this.nodes.hashCode() * 31) + this.title.hashCode()) * 31) + Boolean.hashCode(this.isRootLoading)) * 31;
        String str = this.currentParentId;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.currentDepth)) * 31;
        DirectoryViewModel.Mode mode = this.resolvedMode;
        return hashCode2 + (mode != null ? mode.hashCode() : 0);
    }

    public String toString() {
        return "DirectoryUiState(nodes=" + this.nodes + ", title=" + this.title + ", isRootLoading=" + this.isRootLoading + ", currentParentId=" + this.currentParentId + ", currentDepth=" + this.currentDepth + ", resolvedMode=" + this.resolvedMode + ')';
    }

    public DirectoryUiState(List<DirectoryNode> list, String str, boolean z, String str2, int i, DirectoryViewModel.Mode mode) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        Intrinsics.checkNotNullParameter(str, "title");
        this.nodes = list;
        this.title = str;
        this.isRootLoading = z;
        this.currentParentId = str2;
        this.currentDepth = i;
        this.resolvedMode = mode;
    }

    public /* synthetic */ DirectoryUiState(List list, String str, boolean z, String str2, int i, DirectoryViewModel.Mode mode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str2, (i2 & 16) == 0 ? i : 0, (i2 & 32) != 0 ? null : mode);
    }

    public final List<DirectoryNode> getNodes() {
        return this.nodes;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isRootLoading() {
        return this.isRootLoading;
    }

    public final String getCurrentParentId() {
        return this.currentParentId;
    }

    public final int getCurrentDepth() {
        return this.currentDepth;
    }

    public final DirectoryViewModel.Mode getResolvedMode() {
        return this.resolvedMode;
    }
}
