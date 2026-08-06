package androidx.compose.ui.input.pointer;

import com.bytedance.forest.model.PreloadConfig;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PointerEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class PointerEventType {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unknown = m5579constructorimpl(0);
    private static final int Press = m5579constructorimpl(1);
    private static final int Release = m5579constructorimpl(2);
    private static final int Move = m5579constructorimpl(3);
    private static final int Enter = m5579constructorimpl(4);
    private static final int Exit = m5579constructorimpl(5);
    private static final int Scroll = m5579constructorimpl(6);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m5578boximpl(int i) {
        return new PointerEventType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m5579constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5580equalsimpl(int i, Object obj) {
        return (obj instanceof PointerEventType) && i == ((PointerEventType) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5581equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5582hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m5580equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m5582hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* compiled from: PointerEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType$Companion;", "", "<init>", "()V", "Unknown", "Landroidx/compose/ui/input/pointer/PointerEventType;", "getUnknown-7fucELk", "()I", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "Press", "getPress-7fucELk", "Release", "getRelease-7fucELk", "Move", "getMove-7fucELk", "Enter", "getEnter-7fucELk", "Exit", "getExit-7fucELk", "Scroll", "getScroll-7fucELk", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m5591getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }

        /* renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m5588getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m5589getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m5587getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m5585getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m5586getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m5590getScroll7fucELk() {
            return PointerEventType.Scroll;
        }
    }

    private /* synthetic */ PointerEventType(int i) {
        this.value = i;
    }

    public String toString() {
        return m5583toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5583toStringimpl(int i) {
        return m5581equalsimpl0(i, Press) ? "Press" : m5581equalsimpl0(i, Release) ? "Release" : m5581equalsimpl0(i, Move) ? "Move" : m5581equalsimpl0(i, Enter) ? "Enter" : m5581equalsimpl0(i, Exit) ? "Exit" : m5581equalsimpl0(i, Scroll) ? "Scroll" : "Unknown";
    }
}
