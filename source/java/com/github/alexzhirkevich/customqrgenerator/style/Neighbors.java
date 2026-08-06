package com.github.alexzhirkevich.customqrgenerator.style;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Neighbors.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006+"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "", "topLeft", "", "topRight", "left", "top", "right", "bottomLeft", "bottom", "bottomRight", "(ZZZZZZZZ)V", "getBottom", "()Z", "getBottomLeft", "getBottomRight", "hasAll", "getHasAll", "hasAllNearest", "getHasAllNearest", "hasAny", "getHasAny", "getLeft", "getRight", "getTop", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Neighbors {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Neighbors Empty = new Neighbors(false, false, false, false, false, false, false, false, 255, null);
    private final boolean bottom;
    private final boolean bottomLeft;
    private final boolean bottomRight;
    private final boolean left;
    private final boolean right;
    private final boolean top;
    private final boolean topLeft;
    private final boolean topRight;

    public Neighbors() {
        this(false, false, false, false, false, false, false, false, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getTopRight() {
        return this.topRight;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getLeft() {
        return this.left;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getTop() {
        return this.top;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRight() {
        return this.right;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getBottomLeft() {
        return this.bottomLeft;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getBottom() {
        return this.bottom;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getBottomRight() {
        return this.bottomRight;
    }

    public final Neighbors copy(boolean topLeft, boolean topRight, boolean left, boolean top, boolean right, boolean bottomLeft, boolean bottom, boolean bottomRight) {
        return new Neighbors(topLeft, topRight, left, top, right, bottomLeft, bottom, bottomRight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Neighbors)) {
            return false;
        }
        Neighbors neighbors = (Neighbors) other;
        return this.topLeft == neighbors.topLeft && this.topRight == neighbors.topRight && this.left == neighbors.left && this.top == neighbors.top && this.right == neighbors.right && this.bottomLeft == neighbors.bottomLeft && this.bottom == neighbors.bottom && this.bottomRight == neighbors.bottomRight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z = this.topLeft;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.topRight;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.left;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.top;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.right;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        ?? r25 = this.bottomLeft;
        int i10 = r25;
        if (r25 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        ?? r26 = this.bottom;
        int i12 = r26;
        if (r26 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z2 = this.bottomRight;
        return i13 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "Neighbors(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottomLeft=" + this.bottomLeft + ", bottom=" + this.bottom + ", bottomRight=" + this.bottomRight + ')';
    }

    public Neighbors(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.topLeft = z;
        this.topRight = z2;
        this.left = z3;
        this.top = z4;
        this.right = z5;
        this.bottomLeft = z6;
        this.bottom = z7;
        this.bottomRight = z8;
    }

    public /* synthetic */ Neighbors(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7, (i & 128) == 0 ? z8 : false);
    }

    public final boolean getTopLeft() {
        return this.topLeft;
    }

    public final boolean getTopRight() {
        return this.topRight;
    }

    public final boolean getLeft() {
        return this.left;
    }

    public final boolean getTop() {
        return this.top;
    }

    public final boolean getRight() {
        return this.right;
    }

    public final boolean getBottomLeft() {
        return this.bottomLeft;
    }

    public final boolean getBottom() {
        return this.bottom;
    }

    public final boolean getBottomRight() {
        return this.bottomRight;
    }

    /* compiled from: Neighbors.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors$Companion;", "", "()V", "Empty", "Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "getEmpty", "()Lcom/github/alexzhirkevich/customqrgenerator/style/Neighbors;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Neighbors getEmpty() {
            return Neighbors.Empty;
        }
    }

    public final boolean getHasAny() {
        return this.topLeft || this.topRight || this.left || this.top || this.right || this.bottomLeft || this.bottom || this.bottomRight;
    }

    public final boolean getHasAllNearest() {
        return this.top && this.bottom && this.left && this.right;
    }

    public final boolean getHasAll() {
        return this.topLeft && this.topRight && this.left && this.top && this.right && this.bottomLeft && this.bottom && this.bottomRight;
    }
}
