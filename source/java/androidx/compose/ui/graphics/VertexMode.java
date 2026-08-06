package androidx.compose.ui.graphics;

import com.bytedance.forest.model.PreloadConfig;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VertexMode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class VertexMode {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Triangles = m4756constructorimpl(0);
    private static final int TriangleStrip = m4756constructorimpl(1);
    private static final int TriangleFan = m4756constructorimpl(2);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ VertexMode m4755boximpl(int i) {
        return new VertexMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4756constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4757equalsimpl(int i, Object obj) {
        return (obj instanceof VertexMode) && i == ((VertexMode) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4758equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4759hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m4757equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m4759hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ VertexMode(int i) {
        this.value = i;
    }

    /* compiled from: VertexMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/VertexMode$Companion;", "", "<init>", "()V", "Triangles", "Landroidx/compose/ui/graphics/VertexMode;", "getTriangles-c2xauaI", "()I", TextAttributes.INLINE_IMAGE_PLACEHOLDER, "TriangleStrip", "getTriangleStrip-c2xauaI", "TriangleFan", "getTriangleFan-c2xauaI", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getTriangles-c2xauaI, reason: not valid java name */
        public final int m4764getTrianglesc2xauaI() {
            return VertexMode.Triangles;
        }

        /* renamed from: getTriangleStrip-c2xauaI, reason: not valid java name */
        public final int m4763getTriangleStripc2xauaI() {
            return VertexMode.TriangleStrip;
        }

        /* renamed from: getTriangleFan-c2xauaI, reason: not valid java name */
        public final int m4762getTriangleFanc2xauaI() {
            return VertexMode.TriangleFan;
        }
    }

    public String toString() {
        return m4760toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4760toStringimpl(int i) {
        return m4758equalsimpl0(i, Triangles) ? "Triangles" : m4758equalsimpl0(i, TriangleStrip) ? "TriangleStrip" : m4758equalsimpl0(i, TriangleFan) ? "TriangleFan" : "Unknown";
    }
}
