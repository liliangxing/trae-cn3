package androidx.compose.p001ui.node;

import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0012\u0010\u0012\u001a\u00020\u00138Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\u0088\u0001\u0002¨\u0006)"}, d2 = {"Landroidx/compose/ui/node/Snake;", "", Constants.KEY_DATA, "", "constructor-impl", "([I)[I", "getData", "()[I", "startX", "", "getStartX-impl", "([I)I", "startY", "getStartY-impl", "endX", "getEndX-impl", "endY", "getEndY-impl", "reverse", "", "getReverse-impl", "([I)Z", "diagonalSize", "getDiagonalSize-impl", "hasAdditionOrRemoval", "getHasAdditionOrRemoval-impl", "isAddition", "isAddition-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "equals", "other", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Snake {
    private final int[] data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m1633boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m1634constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1635equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m1647unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1636equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1644hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public boolean equals(Object other) {
        return m1635equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m1644hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m1647unboximpl() {
        return this.data;
    }

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    public final int[] getData() {
        return this.data;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m1642getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m1643getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m1638getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m1639getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m1641getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1646toStringimpl(int[] iArr) {
        return "Snake(" + iArr[0] + ',' + iArr[1] + ',' + iArr[2] + ',' + iArr[3] + ',' + (iArr[4] != 0) + ')';
    }

    public String toString() {
        return m1646toStringimpl(this.data);
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m1637getDiagonalSizeimpl(int[] iArr) {
        return Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m1640getHasAdditionOrRemovalimpl(int[] iArr) {
        return iArr[3] - iArr[1] != iArr[2] - iArr[0];
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m1645isAdditionimpl(int[] iArr) {
        return iArr[3] - iArr[1] > iArr[2] - iArr[0];
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m1632addDiagonalToStackimpl(int[] iArr, IntStack intStack) {
        int i;
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (m1640getHasAdditionOrRemovalimpl(iArr)) {
            i = Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
            i2 += ((iArr[4] != 0 ? 1 : 0) | (m1645isAdditionimpl(iArr) ? 1 : 0)) ^ 1;
            i3 += ((!m1645isAdditionimpl(iArr) ? 1 : 0) | (iArr[4] != 0 ? 1 : 0)) ^ 1;
        } else {
            i = iArr[2] - iArr[0];
        }
        intStack.pushDiagonal(i2, i3, i);
    }
}
