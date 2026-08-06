package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.ss.android.download.api.constant.Downloads;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", Downloads.Impl.COLUMN_DELETED, "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m6686updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m6516getLengthimpl;
        int m6518getMinimpl = TextRange.m6518getMinimpl(j);
        int m6517getMaximpl = TextRange.m6517getMaximpl(j);
        if (TextRange.m6522intersects5zctL8(j2, j)) {
            if (TextRange.m6510contains5zctL8(j2, j)) {
                m6518getMinimpl = TextRange.m6518getMinimpl(j2);
                m6517getMaximpl = m6518getMinimpl;
            } else {
                if (TextRange.m6510contains5zctL8(j, j2)) {
                    m6516getLengthimpl = TextRange.m6516getLengthimpl(j2);
                } else if (TextRange.m6511containsimpl(j2, m6518getMinimpl)) {
                    m6518getMinimpl = TextRange.m6518getMinimpl(j2);
                    m6516getLengthimpl = TextRange.m6516getLengthimpl(j2);
                } else {
                    m6517getMaximpl = TextRange.m6518getMinimpl(j2);
                }
                m6517getMaximpl -= m6516getLengthimpl;
            }
        } else if (m6517getMaximpl > TextRange.m6518getMinimpl(j2)) {
            m6518getMinimpl -= TextRange.m6516getLengthimpl(j2);
            m6516getLengthimpl = TextRange.m6516getLengthimpl(j2);
            m6517getMaximpl -= m6516getLengthimpl;
        }
        return TextRangeKt.TextRange(m6518getMinimpl, m6517getMaximpl);
    }
}
