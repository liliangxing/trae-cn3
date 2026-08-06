package com.bytedance.trae.conversation.chat.checkpoint;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckpointDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPageResult;", "", "pageIndex", "", "selectedLabels", "", "", "customInput", "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "getPageIndex", "()I", "getSelectedLabels", "()Ljava/util/List;", "getCustomInput", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class CheckpointPageResult {
    private final String customInput;
    private final int pageIndex;
    private final List<String> selectedLabels;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckpointPageResult copy$default(CheckpointPageResult checkpointPageResult, int i, List list, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = checkpointPageResult.pageIndex;
        }
        if ((i2 & 2) != 0) {
            list = checkpointPageResult.selectedLabels;
        }
        if ((i2 & 4) != 0) {
            str = checkpointPageResult.customInput;
        }
        return checkpointPageResult.copy(i, list, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final List<String> component2() {
        return this.selectedLabels;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCustomInput() {
        return this.customInput;
    }

    public final CheckpointPageResult copy(int pageIndex, List<String> selectedLabels, String customInput) {
        Intrinsics.checkNotNullParameter(selectedLabels, "selectedLabels");
        return new CheckpointPageResult(pageIndex, selectedLabels, customInput);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckpointPageResult)) {
            return false;
        }
        CheckpointPageResult checkpointPageResult = (CheckpointPageResult) other;
        return this.pageIndex == checkpointPageResult.pageIndex && Intrinsics.areEqual(this.selectedLabels, checkpointPageResult.selectedLabels) && Intrinsics.areEqual(this.customInput, checkpointPageResult.customInput);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.pageIndex) * 31) + this.selectedLabels.hashCode()) * 31;
        String str = this.customInput;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CheckpointPageResult(pageIndex=" + this.pageIndex + ", selectedLabels=" + this.selectedLabels + ", customInput=" + this.customInput + ')';
    }

    public CheckpointPageResult(int i, List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "selectedLabels");
        this.pageIndex = i;
        this.selectedLabels = list;
        this.customInput = str;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public /* synthetic */ CheckpointPageResult(int i, List list, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? null : str);
    }

    public final List<String> getSelectedLabels() {
        return this.selectedLabels;
    }

    public final String getCustomInput() {
        return this.customInput;
    }
}
