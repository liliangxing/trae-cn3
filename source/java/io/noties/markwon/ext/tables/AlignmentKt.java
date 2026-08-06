package io.noties.markwon.ext.tables;

import android.text.Layout;
import kotlin.Metadata;
import org.commonmark.ext.gfm.tables.TableCell;

/* compiled from: Alignment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ALIGN_CENTER", "", "ALIGN_LEFT", "ALIGN_RIGHT", "layoutAlignment", "Landroid/text/Layout$Alignment;", "alignment", "tableCellAlignment", "Lorg/commonmark/ext/gfm/tables/TableCell$Alignment;", "markwon-ext-tables_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class AlignmentKt {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            iArr[TableCell.Alignment.RIGHT.ordinal()] = 2;
        }
    }

    public static final Layout.Alignment layoutAlignment(int i) {
        if (i == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (i == 2) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public static final int tableCellAlignment(TableCell.Alignment alignment) {
        if (alignment == null) {
            return 0;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[alignment.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }
}
