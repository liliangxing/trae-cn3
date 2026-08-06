package androidx.compose.p001ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.layout.Ruler;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LookaheadDelegate.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0014J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0014H\u0086\u0002J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\bH\u0086\u0002J8\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2 \u0010 \u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u0018\u00010!J\u0006\u0010\"\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/ui/node/RulerTrackingMap;", "", "<init>", "()V", "size", "", "rulers", "", "Landroidx/compose/ui/layout/Ruler;", "[Landroidx/compose/ui/layout/Ruler;", "values", "", "accessFlags", "", "layoutNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "Landroidx/compose/ui/node/LayoutNode;", "newRulers", "getOrDefault", "", "ruler", "defaultValue", "set", "", StrategyConstants.VALUE, "contains", "", "notifyChanged", "isLookingAhead", "node", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "clear", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RulerTrackingMap {
    private int size;
    private Ruler[] rulers = new Ruler[32];
    private float[] values = new float[32];
    private byte[] accessFlags = new byte[32];
    private MutableScatterSet<WeakReference<LayoutNode>> layoutNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<Ruler> newRulers = ScatterSetKt.mutableScatterSetOf();

    public final float getOrDefault(Ruler ruler, float defaultValue) {
        int indexOf = ArraysKt.indexOf(this.rulers, ruler);
        return indexOf < 0 ? defaultValue : this.values[indexOf];
    }

    public final void set(Ruler ruler, float value) {
        int indexOf = ArraysKt.indexOf(this.rulers, ruler);
        if (indexOf < 0) {
            int i = this.size;
            Ruler[] rulerArr = this.rulers;
            if (i == rulerArr.length) {
                int i2 = i * 2;
                Object[] copyOf = Arrays.copyOf(rulerArr, i2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.rulers = (Ruler[]) copyOf;
                float[] copyOf2 = Arrays.copyOf(this.values, i2);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                this.values = copyOf2;
                byte[] copyOf3 = Arrays.copyOf(this.accessFlags, i2);
                Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
                this.accessFlags = copyOf3;
            }
            this.rulers[i] = ruler;
            this.accessFlags[i] = 3;
            this.values[i] = value;
            this.size++;
            return;
        }
        float[] fArr = this.values;
        if (!(fArr[indexOf] == value)) {
            fArr[indexOf] = value;
            this.accessFlags[indexOf] = 1;
        } else {
            byte[] bArr = this.accessFlags;
            if (bArr[indexOf] == 2) {
                bArr[indexOf] = 0;
            }
        }
    }

    public final boolean contains(Ruler ruler) {
        return ArraysKt.contains(this.rulers, ruler);
    }

    public final void notifyChanged(boolean isLookingAhead, LookaheadCapablePlaceable node, MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders) {
        LayoutNode layoutNode;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            byte b = this.accessFlags[i2];
            if (b == 3) {
                MutableScatterSet<Ruler> mutableScatterSet = this.newRulers;
                Ruler ruler = this.rulers[i2];
                Intrinsics.checkNotNull(ruler);
                mutableScatterSet.plusAssign(ruler);
            } else if (b != 0 && rulerReaders != null) {
                Ruler ruler2 = this.rulers[i2];
                Intrinsics.checkNotNull(ruler2);
                ScatterSet scatterSet = (MutableScatterSet) rulerReaders.remove(ruler2);
                if (scatterSet != null) {
                    this.layoutNodes.plusAssign(scatterSet);
                }
            }
        }
        int i3 = this.size;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            byte[] bArr = this.accessFlags;
            if (bArr[i5] == 2) {
                i4++;
            } else if (i4 > 0) {
                Ruler[] rulerArr = this.rulers;
                rulerArr[i5 - i4] = rulerArr[i5];
            }
            bArr[i5] = 2;
        }
        int i6 = this.size;
        for (int i7 = i6 - i4; i7 < i6; i7++) {
            this.rulers[i7] = null;
        }
        this.size -= i4;
        LookaheadCapablePlaceable parent = node.getParent();
        ScatterSet scatterSet2 = this.newRulers;
        Object[] objArr = scatterSet2.elements;
        long[] jArr = scatterSet2.metadata;
        int length = jArr.length - 2;
        long j = 255;
        if (length >= 0) {
            int i8 = 0;
            while (true) {
                long j2 = jArr[i8];
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8 - ((~(i8 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j2 & j) < 128) {
                            (parent == null ? node : parent).invalidateChildrenOfDefiningRuler$ui_release((Ruler) objArr[(i8 << 3) + i10]);
                        }
                        j2 >>= 8;
                        i10++;
                        j = 255;
                    }
                    if (i9 != 8) {
                        break;
                    }
                }
                if (i8 == length) {
                    break;
                }
                i8++;
                j = 255;
            }
        }
        this.newRulers.clear();
        ScatterSet scatterSet3 = this.layoutNodes;
        Object[] objArr2 = scatterSet3.elements;
        long[] jArr2 = scatterSet3.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i11 = 0;
            while (true) {
                long j3 = jArr2[i11];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length2)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if (((j3 & 255) < 128) && (layoutNode = (LayoutNode) ((WeakReference) objArr2[(i11 << 3) + i13]).get()) != null) {
                            if (isLookingAhead) {
                                layoutNode.requestLookaheadRelayout$ui_release(false);
                            } else {
                                layoutNode.requestRelayout$ui_release(false);
                            }
                        }
                        j3 >>= 8;
                    }
                    if (i12 != 8) {
                        break;
                    }
                }
                if (i11 == length2) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.layoutNodes.clear();
    }

    public final void clear() {
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.rulers[i2] = null;
            this.values[i2] = Float.NaN;
            this.accessFlags[i2] = 0;
        }
        this.size = 0;
    }
}
