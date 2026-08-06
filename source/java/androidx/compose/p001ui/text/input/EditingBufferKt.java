package androidx.compose.p001ui.text.input;

import androidx.compose.p001ui.text.TextRange;
import androidx.compose.p001ui.text.TextRangeKt;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m2288updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m2118getLengthimpl;
        int m2120getMinimpl = TextRange.m2120getMinimpl(j);
        int m2119getMaximpl = TextRange.m2119getMaximpl(j);
        if (TextRange.m2124intersects5zctL8(j2, j)) {
            if (TextRange.m2112contains5zctL8(j2, j)) {
                m2120getMinimpl = TextRange.m2120getMinimpl(j2);
                m2119getMaximpl = m2120getMinimpl;
            } else {
                if (TextRange.m2112contains5zctL8(j, j2)) {
                    m2118getLengthimpl = TextRange.m2118getLengthimpl(j2);
                } else if (TextRange.m2113containsimpl(j2, m2120getMinimpl)) {
                    m2120getMinimpl = TextRange.m2120getMinimpl(j2);
                    m2118getLengthimpl = TextRange.m2118getLengthimpl(j2);
                } else {
                    m2119getMaximpl = TextRange.m2120getMinimpl(j2);
                }
                m2119getMaximpl -= m2118getLengthimpl;
            }
        } else if (m2119getMaximpl > TextRange.m2120getMinimpl(j2)) {
            m2120getMinimpl -= TextRange.m2118getLengthimpl(j2);
            m2118getLengthimpl = TextRange.m2118getLengthimpl(j2);
            m2119getMaximpl -= m2118getLengthimpl;
        }
        return TextRangeKt.TextRange(m2120getMinimpl, m2119getMaximpl);
    }
}
