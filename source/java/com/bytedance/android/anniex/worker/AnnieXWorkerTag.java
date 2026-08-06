package com.bytedance.android.anniex.worker;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXJSWorker.kt */
@Deprecated(message = "仅用于告知JSB环境这是全局的端智能Worker")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXWorkerTag;", "", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AnnieXWorkerTag {
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnieXWorkerTag() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnnieXWorkerTag copy$default(AnnieXWorkerTag annieXWorkerTag, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = annieXWorkerTag.tag;
        }
        return annieXWorkerTag.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    public final AnnieXWorkerTag copy(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new AnnieXWorkerTag(tag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AnnieXWorkerTag) && Intrinsics.areEqual(this.tag, ((AnnieXWorkerTag) other).tag);
    }

    public int hashCode() {
        return this.tag.hashCode();
    }

    public String toString() {
        return "AnnieXWorkerTag(tag=" + this.tag + ')';
    }

    public AnnieXWorkerTag(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    public /* synthetic */ AnnieXWorkerTag(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "AnnieXJSWorker" : str);
    }

    public final String getTag() {
        return this.tag;
    }
}
