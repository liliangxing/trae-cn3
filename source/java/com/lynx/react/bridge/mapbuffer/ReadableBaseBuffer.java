package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.mapbuffer.MapBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes6.dex */
public abstract class ReadableBaseBuffer {
    protected static final int HEADER_SIZE = 8;
    private static final int UNSET_COUNT = -1;
    protected ByteBuffer mBuffer;
    private int mCount;
    private int mOffsetForDynamicData;
    private int mTypeOffset;
    private int mValueOffset;

    protected abstract int getKeyOffsetForBucketIndex(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public ReadableBaseBuffer(ByteBuffer byteBuffer, int i, int i2, int i3) {
        this.mBuffer = byteBuffer;
        this.mCount = i;
        this.mTypeOffset = i2;
        this.mValueOffset = i3;
        readHeader();
    }

    private void readHeader() {
        ByteBuffer byteBuffer = this.mBuffer;
        if (byteBuffer != null) {
            byteBuffer.order(ByteOrder.nativeOrder());
            if (this.mCount == -1) {
                this.mBuffer.position(2);
                this.mCount = readUnsignedShort(this.mBuffer.position());
            }
            this.mOffsetForDynamicData = getKeyOffsetForBucketIndex(this.mCount);
        }
    }

    public int count() {
        return this.mCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public short readUnsignedShort(int i) {
        return this.mBuffer.getShort(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int readIntValue(int i) {
        return this.mBuffer.getInt(i);
    }

    protected byte[] readBufferValue(int i) {
        int i2 = this.mOffsetForDynamicData + this.mBuffer.getInt(i);
        int i3 = this.mBuffer.getInt(i2);
        byte[] bArr = new byte[i3];
        this.mBuffer.position(i2 + 4);
        this.mBuffer.get(bArr, 0, i3);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String readStringValue(int i) {
        return new String(readBufferValue(i), Charset.defaultCharset());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public double readDoubleValue(int i) {
        return this.mBuffer.getDouble(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long readLongValue(int i) {
        return this.mBuffer.getLong(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean readBooleanValue(int i) {
        return readIntValue(i) == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReadableMapBuffer readMapBufferValue(int i) {
        return new ReadableMapBuffer(ByteBuffer.wrap(readBufferValue(i)), -1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReadableBaseBuffer readableBaseBuffer = (ReadableBaseBuffer) obj;
        return count() == readableBaseBuffer.count() && Objects.equals(this.mBuffer, readableBaseBuffer.mBuffer);
    }

    public int hashCode() {
        this.mBuffer.rewind();
        return this.mBuffer.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public class BaseBufferEntry implements MapBuffer.Entry {
        protected int bucketOffset;

        /* JADX INFO: Access modifiers changed from: package-private */
        public BaseBufferEntry(int i) {
            this.bucketOffset = i;
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.Entry
        public int getKey() {
            return ReadableBaseBuffer.this.readUnsignedShort(this.bucketOffset);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.Entry
        public MapBuffer.DataType getType() {
            MapBuffer.DataType[] values = MapBuffer.DataType.values();
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return values[readableBaseBuffer.readUnsignedShort(this.bucketOffset + readableBaseBuffer.mTypeOffset)];
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.Entry
        public boolean getBoolean() {
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return readableBaseBuffer.readBooleanValue(this.bucketOffset + readableBaseBuffer.mValueOffset);
        }

        @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer.Entry
        public int getInt() {
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return readableBaseBuffer.readIntValue(this.bucketOffset + readableBaseBuffer.mValueOffset);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.Entry, com.lynx.react.bridge.mapbuffer.CompactArrayBuffer.Entry
        public long getLong() {
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return readableBaseBuffer.readLongValue(this.bucketOffset + readableBaseBuffer.mValueOffset);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.Entry, com.lynx.react.bridge.mapbuffer.CompactArrayBuffer.Entry
        public double getDouble() {
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return readableBaseBuffer.readDoubleValue(this.bucketOffset + readableBaseBuffer.mValueOffset);
        }

        @Override // com.lynx.react.bridge.mapbuffer.CompactArrayBuffer.Entry
        public String getString() {
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return readableBaseBuffer.readStringValue(this.bucketOffset + readableBaseBuffer.mValueOffset);
        }

        @Override // com.lynx.react.bridge.mapbuffer.MapBuffer.Entry
        public MapBuffer getMapBuffer() {
            ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
            return readableBaseBuffer.readMapBufferValue(this.bucketOffset + readableBaseBuffer.mValueOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterator<BaseBufferEntry> baseIterator() {
        return new Iterator<BaseBufferEntry>() { // from class: com.lynx.react.bridge.mapbuffer.ReadableBaseBuffer.1
            int current = 0;
            final int last;

            {
                this.last = ReadableBaseBuffer.this.count();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.current < this.last;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public BaseBufferEntry next() {
                ReadableBaseBuffer readableBaseBuffer = ReadableBaseBuffer.this;
                int i = this.current;
                this.current = i + 1;
                return new BaseBufferEntry(readableBaseBuffer.getKeyOffsetForBucketIndex(i));
            }
        };
    }
}
