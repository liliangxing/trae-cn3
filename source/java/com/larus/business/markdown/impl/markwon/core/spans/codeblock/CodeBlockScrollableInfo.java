package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import com.bytedance.forest.model.PreloadConfig;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockSpanInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockScrollableInfo;", "", "enableScroll", "", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "codeTextColor", "", "(ZLio/noties/markwon/scrollable/HorizontalScrollable;Lio/noties/markwon/scrollable/ScrollBarTheme;I)V", "getCodeTextColor", "()I", "getEnableScroll", "()Z", "getScrollBarTheme", "()Lio/noties/markwon/scrollable/ScrollBarTheme;", "getScrollable", "()Lio/noties/markwon/scrollable/HorizontalScrollable;", "component1", "component2", "component3", "component4", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CodeBlockScrollableInfo {
    private final int codeTextColor;
    private final boolean enableScroll;
    private final ScrollBarTheme scrollBarTheme;
    private final HorizontalScrollable scrollable;

    public static /* synthetic */ CodeBlockScrollableInfo copy$default(CodeBlockScrollableInfo codeBlockScrollableInfo, boolean z, HorizontalScrollable horizontalScrollable, ScrollBarTheme scrollBarTheme, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = codeBlockScrollableInfo.enableScroll;
        }
        if ((i2 & 2) != 0) {
            horizontalScrollable = codeBlockScrollableInfo.scrollable;
        }
        if ((i2 & 4) != 0) {
            scrollBarTheme = codeBlockScrollableInfo.scrollBarTheme;
        }
        if ((i2 & 8) != 0) {
            i = codeBlockScrollableInfo.codeTextColor;
        }
        return codeBlockScrollableInfo.copy(z, horizontalScrollable, scrollBarTheme, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    /* renamed from: component2, reason: from getter */
    public final HorizontalScrollable getScrollable() {
        return this.scrollable;
    }

    /* renamed from: component3, reason: from getter */
    public final ScrollBarTheme getScrollBarTheme() {
        return this.scrollBarTheme;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCodeTextColor() {
        return this.codeTextColor;
    }

    public final CodeBlockScrollableInfo copy(boolean enableScroll, HorizontalScrollable scrollable, ScrollBarTheme scrollBarTheme, int codeTextColor) {
        Intrinsics.checkNotNullParameter(scrollBarTheme, "scrollBarTheme");
        return new CodeBlockScrollableInfo(enableScroll, scrollable, scrollBarTheme, codeTextColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlockScrollableInfo)) {
            return false;
        }
        CodeBlockScrollableInfo codeBlockScrollableInfo = (CodeBlockScrollableInfo) other;
        return this.enableScroll == codeBlockScrollableInfo.enableScroll && Intrinsics.areEqual(this.scrollable, codeBlockScrollableInfo.scrollable) && Intrinsics.areEqual(this.scrollBarTheme, codeBlockScrollableInfo.scrollBarTheme) && this.codeTextColor == codeBlockScrollableInfo.codeTextColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.enableScroll;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        HorizontalScrollable horizontalScrollable = this.scrollable;
        return ((((i + (horizontalScrollable == null ? 0 : horizontalScrollable.hashCode())) * 31) + this.scrollBarTheme.hashCode()) * 31) + Integer.hashCode(this.codeTextColor);
    }

    public String toString() {
        return "CodeBlockScrollableInfo(enableScroll=" + this.enableScroll + ", scrollable=" + this.scrollable + ", scrollBarTheme=" + this.scrollBarTheme + ", codeTextColor=" + this.codeTextColor + ')';
    }

    public CodeBlockScrollableInfo(boolean z, HorizontalScrollable horizontalScrollable, ScrollBarTheme scrollBarTheme, int i) {
        Intrinsics.checkNotNullParameter(scrollBarTheme, "scrollBarTheme");
        this.enableScroll = z;
        this.scrollable = horizontalScrollable;
        this.scrollBarTheme = scrollBarTheme;
        this.codeTextColor = i;
    }

    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    public final HorizontalScrollable getScrollable() {
        return this.scrollable;
    }

    public final ScrollBarTheme getScrollBarTheme() {
        return this.scrollBarTheme;
    }

    public final int getCodeTextColor() {
        return this.codeTextColor;
    }
}
