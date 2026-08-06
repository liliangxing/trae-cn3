package com.bytedance.gkfs.io.segmental;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.GkFSLogger;
import com.ss.android.download.api.constant.Downloads;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SegmentalByteArray.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010(\n\u0002\b\u0004\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0004J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J,\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004J,\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004J\b\u0010\u001f\u001a\u00020\u0015H\u0004J\u0011\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0004H\u0086\u0002J\u0006\u0010\"\u001a\u00020\u0011J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$H\u0096\u0002J\u0019\u0010%\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0007H\u0086\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray;", "", "", "size", "", "init", "Lkotlin/Function1;", "", "(ILkotlin/jvm/functions/Function1;)V", "(I)V", "container", "Ljava/util/LinkedList;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "getSize", "()I", "contentEquals", "", PreloadConfig.KEY_OTHER, "contentHashCode", "copyFrom", "", "src", "off", "start", "length", "copyInto", Downloads.Impl.COLUMN_DESTINATION, "destinationOffset", "startIndex", "endIndex", "finalize", "get", "index", "isNotEmpty", "iterator", "", "set", "value", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class SegmentalByteArray implements Iterable<byte[]>, KMappedMarker {
    private static final int MAX_POOL_SIZE = 125;
    private final LinkedList<byte[]> container;
    private final GkFSLogger logger;
    private final int size;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LinkedList<byte[]> bytesPool = new LinkedList<>();

    public SegmentalByteArray(int i) {
        this.size = i;
        this.logger = new GkFSLogger();
        LinkedList<byte[]> linkedList = new LinkedList<>();
        int i2 = (i / 4096) + (i % 4096 == 0 ? 0 : 1);
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 != i2 - 1) {
                linkedList.add(INSTANCE.obtainSegment(4096));
            } else {
                Integer valueOf = Integer.valueOf(this.size % 4096);
                valueOf = valueOf.intValue() != 0 ? valueOf : null;
                linkedList.add(INSTANCE.obtainSegment(valueOf != null ? valueOf.intValue() : 4096));
            }
        }
        this.container = linkedList;
    }

    public final int getSize() {
        return this.size;
    }

    /* compiled from: SegmentalByteArray.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/gkfs/io/segmental/SegmentalByteArray$Companion;", "", "()V", "MAX_POOL_SIZE", "", "bytesPool", "Ljava/util/LinkedList;", "", "obtainSegment", "size", "returnSegment", "", "b", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final byte[] obtainSegment(int size) {
            byte[] bArr;
            if (size == 4096) {
                synchronized (SegmentalByteArray.bytesPool) {
                    bArr = (byte[]) SegmentalByteArray.bytesPool.poll();
                    if (bArr == null) {
                        bArr = new byte[4096];
                    }
                }
                return bArr;
            }
            return new byte[size];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void returnSegment(byte[] b) {
            if (b.length != 4096) {
                return;
            }
            synchronized (SegmentalByteArray.bytesPool) {
                if (SegmentalByteArray.bytesPool.size() < 125) {
                    Arrays.fill(b, (byte) 0);
                    SegmentalByteArray.bytesPool.offer(b);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SegmentalByteArray(int i, Function1<? super Integer, Byte> init) {
        this(i);
        Intrinsics.checkParameterIsNotNull(init, "init");
        for (int i2 = 0; i2 < i; i2++) {
            set(i2, init.invoke(Integer.valueOf(i2)).byteValue());
        }
    }

    public final byte get(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("index " + index + " is larger than array size " + this.size);
        }
        int i = index / 4096;
        return this.container.get(i)[index - (i * 4096)];
    }

    public final void set(int index, byte value) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException("index " + index + " is larger than array size " + this.size);
        }
        int i = index / 4096;
        this.container.get(i)[index - (i * 4096)] = value;
    }

    public static /* synthetic */ byte[] copyInto$default(SegmentalByteArray segmentalByteArray, byte[] bArr, int i, int i2, int i3, int i4, Object obj) throws IndexOutOfBoundsException {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = segmentalByteArray.size;
        }
        return segmentalByteArray.copyInto(bArr, i, i2, i3);
    }

    public final byte[] copyInto(byte[] destination, int destinationOffset, int startIndex, int endIndex) throws IndexOutOfBoundsException {
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        if (endIndex > this.size) {
            throw new IndexOutOfBoundsException("endIndex " + endIndex + " larger than array size " + this.size);
        }
        int i = endIndex - startIndex;
        int size = this.container.size();
        int i2 = 0;
        for (int i3 = startIndex / 4096; i3 < size && i2 < i; i3++) {
            int i4 = (startIndex + i2) % 4096;
            int min = Math.min(this.container.get(i3).length - i4, i - i2);
            System.arraycopy(this.container.get(i3), i4, destination, destinationOffset + i2, min);
            i2 += min;
        }
        if (i2 != i) {
            GkFSLogger.w$default(this.logger, "SegmentalByteArray", "except copy " + i + " bytes but only copied " + i2, 0, null, false, 28, null);
        }
        return destination;
    }

    public static /* synthetic */ SegmentalByteArray copyInto$default(SegmentalByteArray segmentalByteArray, SegmentalByteArray segmentalByteArray2, int i, int i2, int i3, int i4, Object obj) throws IndexOutOfBoundsException {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = segmentalByteArray.size;
        }
        return segmentalByteArray.copyInto(segmentalByteArray2, i, i2, i3);
    }

    public final SegmentalByteArray copyInto(SegmentalByteArray destination, int destinationOffset, int startIndex, int endIndex) throws IndexOutOfBoundsException {
        Intrinsics.checkParameterIsNotNull(destination, "destination");
        if (endIndex > this.size) {
            throw new IndexOutOfBoundsException("endIndex " + endIndex + " larger than array size " + this.size);
        }
        int i = endIndex - startIndex;
        int size = this.container.size();
        int i2 = 0;
        for (int i3 = startIndex / 4096; i3 < size && i2 < i; i3++) {
            int i4 = (startIndex + i2) % 4096;
            int min = Math.min(this.container.get(i3).length - i4, i - i2);
            byte[] bArr = this.container.get(i3);
            Intrinsics.checkExpressionValueIsNotNull(bArr, "container[i]");
            destination.copyFrom(bArr, i4, destinationOffset + i2, min);
            i2 += min;
        }
        if (i2 != i) {
            GkFSLogger.w$default(this.logger, "SegmentalByteArray", "except copy " + i + " bytes but only copied " + i2, 0, null, false, 28, null);
        }
        return destination;
    }

    public final void copyFrom(byte[] src, int off, int start, int length) throws IndexOutOfBoundsException {
        Intrinsics.checkParameterIsNotNull(src, "src");
        if (off + length > src.length) {
            throw new IndexOutOfBoundsException("copy length larger than available size of src!");
        }
        if (start + length > this.size) {
            throw new IndexOutOfBoundsException("copy length larger than available size of dest!");
        }
        int size = this.container.size();
        int i = 0;
        for (int i2 = start / 4096; i2 < size && i < length; i2++) {
            int i3 = (start + i) % 4096;
            int min = Math.min(this.container.get(i2).length - i3, length - i);
            System.arraycopy(src, off + i, this.container.get(i2), i3, min);
            i += min;
        }
        if (i != length) {
            GkFSLogger.w$default(this.logger, "SegmentalByteArray", "except copy " + length + " bytes but only copied " + i, 0, null, false, 28, null);
        }
    }

    public final int contentHashCode() {
        return this.container.hashCode();
    }

    public final boolean contentEquals(SegmentalByteArray other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (this == other) {
            return true;
        }
        if (this.size != other.size) {
            return false;
        }
        int size = this.container.size();
        for (int i = 0; i < size; i++) {
            byte[] bArr = this.container.get(i);
            Intrinsics.checkExpressionValueIsNotNull(bArr, "container[i]");
            byte[] bArr2 = other.container.get(i);
            Intrinsics.checkExpressionValueIsNotNull(bArr2, "other.container[i]");
            if (!Arrays.equals(bArr, bArr2)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        Iterator<byte[]> it = this.container.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "container.iterator()");
        return it;
    }

    public final boolean isNotEmpty() {
        return this.size != 0;
    }

    protected final void finalize() {
        Iterator<T> it = this.container.iterator();
        while (it.hasNext()) {
            INSTANCE.returnSegment((byte[]) it.next());
        }
    }
}
