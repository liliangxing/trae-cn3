package io.noties.markwon.html.customdata;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlockContent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/html/customdata/BlockContent;", "", "()V", "content", "", "(Ljava/lang/String;)V", "lineCount", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "string", "getString", "()Ljava/lang/String;", "add", "", "line", "", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class BlockContent {
    private int lineCount;
    private final StringBuilder sb;

    public BlockContent() {
        this.sb = new StringBuilder();
    }

    public BlockContent(String str) {
        if (str == null) {
            Intrinsics.throwNpe();
        }
        this.sb = new StringBuilder(str);
    }

    public final void add(CharSequence line) {
        if (this.lineCount != 0) {
            this.sb.append('\n');
        }
        this.sb.append(line);
        this.lineCount++;
    }

    public final String getString() {
        String sb = this.sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "sb.toString()");
        return sb;
    }
}
