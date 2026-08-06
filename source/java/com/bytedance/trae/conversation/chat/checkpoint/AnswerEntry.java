package com.bytedance.trae.conversation.chat.checkpoint;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckpointInteraction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/AnswerEntry;", "", "selectedOptions", "", "", "customInput", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getSelectedOptions", "()Ljava/util/List;", "getCustomInput", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class AnswerEntry {
    private final String customInput;
    private final List<String> selectedOptions;

    /* JADX WARN: Multi-variable type inference failed */
    public AnswerEntry() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnswerEntry copy$default(AnswerEntry answerEntry, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = answerEntry.selectedOptions;
        }
        if ((i & 2) != 0) {
            str = answerEntry.customInput;
        }
        return answerEntry.copy(list, str);
    }

    public final List<String> component1() {
        return this.selectedOptions;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCustomInput() {
        return this.customInput;
    }

    public final AnswerEntry copy(List<String> selectedOptions, String customInput) {
        Intrinsics.checkNotNullParameter(selectedOptions, "selectedOptions");
        return new AnswerEntry(selectedOptions, customInput);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnswerEntry)) {
            return false;
        }
        AnswerEntry answerEntry = (AnswerEntry) other;
        return Intrinsics.areEqual(this.selectedOptions, answerEntry.selectedOptions) && Intrinsics.areEqual(this.customInput, answerEntry.customInput);
    }

    public int hashCode() {
        int hashCode = this.selectedOptions.hashCode() * 31;
        String str = this.customInput;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AnswerEntry(selectedOptions=" + this.selectedOptions + ", customInput=" + this.customInput + ')';
    }

    public AnswerEntry(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "selectedOptions");
        this.selectedOptions = list;
        this.customInput = str;
    }

    public /* synthetic */ AnswerEntry(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : str);
    }

    public final List<String> getSelectedOptions() {
        return this.selectedOptions;
    }

    public final String getCustomInput() {
        return this.customInput;
    }
}
