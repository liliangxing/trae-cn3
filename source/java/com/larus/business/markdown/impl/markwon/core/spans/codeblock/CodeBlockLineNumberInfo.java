package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockSpanInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockLineNumberInfo;", "", "startToLineNumber", "", "", "maxLine", "lineNumberColor", "(Ljava/util/Map;II)V", "getLineNumberColor", "()I", "getMaxLine", "getStartToLineNumber", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class CodeBlockLineNumberInfo {
    private final int lineNumberColor;
    private final int maxLine;
    private final Map<Integer, Integer> startToLineNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CodeBlockLineNumberInfo copy$default(CodeBlockLineNumberInfo codeBlockLineNumberInfo, Map map, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = codeBlockLineNumberInfo.startToLineNumber;
        }
        if ((i3 & 2) != 0) {
            i = codeBlockLineNumberInfo.maxLine;
        }
        if ((i3 & 4) != 0) {
            i2 = codeBlockLineNumberInfo.lineNumberColor;
        }
        return codeBlockLineNumberInfo.copy(map, i, i2);
    }

    public final Map<Integer, Integer> component1() {
        return this.startToLineNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxLine() {
        return this.maxLine;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLineNumberColor() {
        return this.lineNumberColor;
    }

    public final CodeBlockLineNumberInfo copy(Map<Integer, Integer> startToLineNumber, int maxLine, int lineNumberColor) {
        Intrinsics.checkNotNullParameter(startToLineNumber, "startToLineNumber");
        return new CodeBlockLineNumberInfo(startToLineNumber, maxLine, lineNumberColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodeBlockLineNumberInfo)) {
            return false;
        }
        CodeBlockLineNumberInfo codeBlockLineNumberInfo = (CodeBlockLineNumberInfo) other;
        return Intrinsics.areEqual(this.startToLineNumber, codeBlockLineNumberInfo.startToLineNumber) && this.maxLine == codeBlockLineNumberInfo.maxLine && this.lineNumberColor == codeBlockLineNumberInfo.lineNumberColor;
    }

    public int hashCode() {
        return (((this.startToLineNumber.hashCode() * 31) + Integer.hashCode(this.maxLine)) * 31) + Integer.hashCode(this.lineNumberColor);
    }

    public String toString() {
        return "CodeBlockLineNumberInfo(startToLineNumber=" + this.startToLineNumber + ", maxLine=" + this.maxLine + ", lineNumberColor=" + this.lineNumberColor + ')';
    }

    public CodeBlockLineNumberInfo(Map<Integer, Integer> startToLineNumber, int i, int i2) {
        Intrinsics.checkNotNullParameter(startToLineNumber, "startToLineNumber");
        this.startToLineNumber = startToLineNumber;
        this.maxLine = i;
        this.lineNumberColor = i2;
    }

    public final Map<Integer, Integer> getStartToLineNumber() {
        return this.startToLineNumber;
    }

    public final int getMaxLine() {
        return this.maxLine;
    }

    public final int getLineNumberColor() {
        return this.lineNumberColor;
    }
}
