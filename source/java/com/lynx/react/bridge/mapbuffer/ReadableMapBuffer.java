package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableBaseBuffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class ReadableMapBuffer extends ReadableBaseBuffer implements MapBuffer {
    private static final int BUCKET_SIZE = 12;
    public static final int INDEX_UN_EXISTED = -1;
    private static final int TYPE_OFFSET = 2;
    private static final int VALUE_OFFSET = 4;

    private List<ReadableMapBuffer> readMapBufferListValue(int i) {
        return null;
    }

    @Override // com.lynx.react.bridge.mapbuffer.ReadableBaseBuffer
    protected int getKeyOffsetForBucketIndex(int i) {
        return (i * 12) + 8;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public List<MapBuffer> getMapBufferList(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadableMapBuffer(ByteBuffer byteBuffer, int i) {
        super(byteBuffer, i, 2, 4);
    }

    static ReadableMapBuffer fromByteBufferWithCount(byte[] bArr, int i) {
        if (bArr == null) {
            return null;
        }
        return new ReadableMapBuffer(ByteBuffer.wrap(bArr), i);
    }

    private int getBucketIndexForKey(int i) {
        int count = count() - 1;
        int i2 = 0;
        while (i2 <= count) {
            int i3 = (i2 + count) >> 1;
            short readUnsignedShort = readUnsignedShort(getKeyOffsetForBucketIndex(i3));
            if (readUnsignedShort < i) {
                i2 = i3 + 1;
            } else {
                if (readUnsignedShort <= i) {
                    return i3;
                }
                count = i3 - 1;
            }
        }
        return -1;
    }

    private MapBuffer.DataType readDataType(int i) {
        return MapBuffer.DataType.values()[readUnsignedShort(getKeyOffsetForBucketIndex(i) + 2)];
    }

    private int getTypedValueOffsetForKey(int i, MapBuffer.DataType dataType) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        if (bucketIndexForKey == -1) {
            return -1;
        }
        MapBuffer.DataType readDataType = readDataType(bucketIndexForKey);
        if (readDataType != dataType) {
            throw new RuntimeException("Expected " + dataType + " for key: " + i + ", found " + readDataType + " instead.");
        }
        return getKeyOffsetForBucketIndex(bucketIndexForKey) + 4;
    }

    private int getTypedValueOffsetForBucketIndex(int i, MapBuffer.DataType dataType) {
        MapBuffer.DataType readDataType = readDataType(i);
        if (readDataType != dataType) {
            throw new RuntimeException("Expected " + dataType + ", found " + readDataType + " instead.");
        }
        return getKeyOffsetForBucketIndex(i) + 4;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public boolean contains(int i) {
        return getBucketIndexForKey(i) != -1;
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public int getKeyOffset(int i) {
        return getBucketIndexForKey(i);
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public MapBuffer.Entry entryAt(int i) {
        return new ReadableBaseBuffer.BaseBufferEntry(getKeyOffsetForBucketIndex(i));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public MapBuffer.DataType getType(int i) {
        return readDataType(getBucketIndexForKey(i));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public int getInt(int i) {
        return readIntValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.INT));
    }

    public int getInt(int i, int i2) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        return bucketIndexForKey == -1 ? i2 : readIntValue(getTypedValueOffsetForBucketIndex(bucketIndexForKey, MapBuffer.DataType.INT));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public long getLong(int i) {
        return readLongValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.LONG));
    }

    public long getLong(int i, long j) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        return bucketIndexForKey == -1 ? j : readLongValue(getTypedValueOffsetForBucketIndex(bucketIndexForKey, MapBuffer.DataType.LONG));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public double getDouble(int i) {
        return readDoubleValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.DOUBLE));
    }

    public double getDouble(int i, double d) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        return bucketIndexForKey == -1 ? d : readDoubleValue(getTypedValueOffsetForBucketIndex(bucketIndexForKey, MapBuffer.DataType.DOUBLE));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public String getString(int i) {
        return readStringValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.STRING));
    }

    public String getString(int i, String str) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        return bucketIndexForKey == -1 ? str : readStringValue(getTypedValueOffsetForBucketIndex(bucketIndexForKey, MapBuffer.DataType.STRING));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public boolean getBoolean(int i) {
        return readBooleanValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.BOOL));
    }

    public boolean getBoolean(int i, boolean z) {
        int bucketIndexForKey = getBucketIndexForKey(i);
        return bucketIndexForKey == -1 ? z : readBooleanValue(getTypedValueOffsetForBucketIndex(bucketIndexForKey, MapBuffer.DataType.BOOL));
    }

    @Override // com.lynx.react.bridge.mapbuffer.MapBuffer
    public ReadableMapBuffer getMapBuffer(int i) {
        return readMapBufferValue(getTypedValueOffsetForKey(i, MapBuffer.DataType.ARRAY));
    }

    @Override // java.lang.Iterable
    public Iterator<MapBuffer.Entry> iterator() {
        return new Iterator<MapBuffer.Entry>() { // from class: com.lynx.react.bridge.mapbuffer.ReadableMapBuffer.1
            Iterator<ReadableBaseBuffer.BaseBufferEntry> iterator;

            {
                this.iterator = ReadableMapBuffer.this.baseIterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public MapBuffer.Entry next() {
                return this.iterator.next();
            }
        };
    }
}
