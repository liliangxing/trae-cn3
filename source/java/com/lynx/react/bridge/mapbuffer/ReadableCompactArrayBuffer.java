package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.mapbuffer.CompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableBaseBuffer;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ReadableCompactArrayBuffer extends ReadableBaseBuffer implements CompactArrayBuffer {
    private static final int BUCKET_SIZE = 8;
    private static final int TYPE_OFFSET = 0;
    private static final int VALUE_OFFSET = 0;

    @Override // com.lynx.react.bridge.mapbuffer.ReadableBaseBuffer
    protected int getKeyOffsetForBucketIndex(int i) {
        return (i * 8) + 8;
    }

    private ReadableCompactArrayBuffer(ByteBuffer byteBuffer, int i) {
        super(byteBuffer, i, 0, 0);
    }

    public static ReadableCompactArrayBuffer fromByteBufferWithCount(byte[] bArr, int i) {
        if (bArr == null) {
            return null;
        }
        return new ReadableCompactArrayBuffer(ByteBuffer.wrap(bArr), i);
    }

    @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer
    public int getInt(int i) {
        return readIntValue(getKeyOffsetForBucketIndex(i));
    }

    @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer
    public long getLong(int i) {
        return readLongValue(getKeyOffsetForBucketIndex(i));
    }

    @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer
    public double getDouble(int i) {
        return readDoubleValue(getKeyOffsetForBucketIndex(i));
    }

    @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer
    public String getString(int i) {
        return readStringValue(getKeyOffsetForBucketIndex(i));
    }

    @Override // java.lang.Iterable
    public Iterator<CompactArrayBuffer.Entry> iterator() {
        return new Iterator<CompactArrayBuffer.Entry>() { // from class: com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer.1
            Iterator<ReadableBaseBuffer.BaseBufferEntry> iterator;

            {
                this.iterator = ReadableCompactArrayBuffer.this.baseIterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public CompactArrayBuffer.Entry next() {
                return this.iterator.next();
            }
        };
    }
}
