package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.openid.appauth.BuildConfig;

/* compiled from: UIntRange.kt */
@Metadata(m4d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u0010\u0010\r\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0010\u0010\t\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\r\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, m5d2 = {"Lkotlin/ranges/UIntProgressionIterator;", BuildConfig.FLAVOR, "Lkotlin/UInt;", "first", "last", "step", BuildConfig.FLAVOR, "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", BuildConfig.FLAVOR, "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, m6k = 1, m7mv = {2, 1, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public /* synthetic */ UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m468boximpl(m1616nextpVg5ArA());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0014, code lost:
    
        if (r2 >= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (r2 <= 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private UIntProgressionIterator(int i, int i2, int i3) {
        int compare;
        int compare2;
        this.finalElement = i2;
        boolean z = true;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        } else {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        }
        this.hasNext = z;
        this.step = UInt.m474constructorimpl(i3);
        this.next = this.hasNext ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    /* renamed from: next-pVg5ArA, reason: not valid java name */
    public int m1616nextpVg5ArA() {
        int i = this.next;
        if (i == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = UInt.m474constructorimpl(this.step + i);
        }
        return i;
    }
}
