package io.noties.markwon.maybe;

import kotlin.Metadata;
import org.commonmark.internal.util.Parsing;

/* compiled from: MaybeFencedCodeBlockParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"checkOpener", "Lio/noties/markwon/maybe/MaybeFencedCodeBlockParser;", "line", "", "index", "", "indent", "markwon-maybe_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class MaybeFencedCodeBlockParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MaybeFencedCodeBlockParser checkOpener(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = i; i5 < length; i5++) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '`') {
                i3++;
            } else {
                if (charAt != '~') {
                    break;
                }
                i4++;
            }
        }
        if (i3 >= 3 && i4 == 0) {
            if (Parsing.find('`', charSequence, i + i3) != -1) {
                return null;
            }
            return new MaybeFencedCodeBlockParser('`', i3, i2);
        }
        if (i4 < 3 || i3 != 0) {
            return null;
        }
        return new MaybeFencedCodeBlockParser('~', i4, i2);
    }
}
