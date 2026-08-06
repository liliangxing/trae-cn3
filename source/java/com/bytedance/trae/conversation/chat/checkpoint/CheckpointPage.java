package com.bytedance.trae.conversation.chat.checkpoint;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckpointModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;", "", "question", "", "options", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;", "allowCustomInput", "", "multiSelect", "isSupplementaryPage", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZZ)V", "getQuestion", "()Ljava/lang/String;", "getOptions", "()Ljava/util/List;", "getAllowCustomInput", "()Z", "getMultiSelect", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckpointPage {
    private final boolean allowCustomInput;
    private final boolean isSupplementaryPage;
    private final boolean multiSelect;
    private final List<CheckpointOption> options;
    private final String question;

    public static /* synthetic */ CheckpointPage copy$default(CheckpointPage checkpointPage, String str, List list, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkpointPage.question;
        }
        if ((i & 2) != 0) {
            list = checkpointPage.options;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z = checkpointPage.allowCustomInput;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = checkpointPage.multiSelect;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            z3 = checkpointPage.isSupplementaryPage;
        }
        return checkpointPage.copy(str, list2, z4, z5, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    public final List<CheckpointOption> component2() {
        return this.options;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAllowCustomInput() {
        return this.allowCustomInput;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getMultiSelect() {
        return this.multiSelect;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSupplementaryPage() {
        return this.isSupplementaryPage;
    }

    public final CheckpointPage copy(String question, List<CheckpointOption> options, boolean allowCustomInput, boolean multiSelect, boolean isSupplementaryPage) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(options, "options");
        return new CheckpointPage(question, options, allowCustomInput, multiSelect, isSupplementaryPage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckpointPage)) {
            return false;
        }
        CheckpointPage checkpointPage = (CheckpointPage) other;
        return Intrinsics.areEqual(this.question, checkpointPage.question) && Intrinsics.areEqual(this.options, checkpointPage.options) && this.allowCustomInput == checkpointPage.allowCustomInput && this.multiSelect == checkpointPage.multiSelect && this.isSupplementaryPage == checkpointPage.isSupplementaryPage;
    }

    public int hashCode() {
        return (((((((this.question.hashCode() * 31) + this.options.hashCode()) * 31) + Boolean.hashCode(this.allowCustomInput)) * 31) + Boolean.hashCode(this.multiSelect)) * 31) + Boolean.hashCode(this.isSupplementaryPage);
    }

    public String toString() {
        return "CheckpointPage(question=" + this.question + ", options=" + this.options + ", allowCustomInput=" + this.allowCustomInput + ", multiSelect=" + this.multiSelect + ", isSupplementaryPage=" + this.isSupplementaryPage + ')';
    }

    public CheckpointPage(String question, List<CheckpointOption> options, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(options, "options");
        this.question = question;
        this.options = options;
        this.allowCustomInput = z;
        this.multiSelect = z2;
        this.isSupplementaryPage = z3;
    }

    public /* synthetic */ CheckpointPage(String str, List list, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3);
    }

    public final String getQuestion() {
        return this.question;
    }

    public final List<CheckpointOption> getOptions() {
        return this.options;
    }

    public final boolean getAllowCustomInput() {
        return this.allowCustomInput;
    }

    public final boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final boolean isSupplementaryPage() {
        return this.isSupplementaryPage;
    }
}
