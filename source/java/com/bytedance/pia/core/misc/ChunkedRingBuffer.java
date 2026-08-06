package com.bytedance.pia.core.misc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes4.dex */
public class ChunkedRingBuffer {
    private static final int DEFAULT_CAPACITY = 16;
    private final InternalChunks chunks;
    private final ReentrantReadWriteLock.ReadLock readLock;
    private final ReentrantReadWriteLock.WriteLock writeLock;

    public ChunkedRingBuffer() {
        this(16);
    }

    public ChunkedRingBuffer(int i) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.chunks = new InternalChunks(i);
    }

    public void write(byte[] bArr, int i) {
        bArr.getClass();
        if (i < 0 || i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (bArr.length == 0 || i == 0) {
            return;
        }
        this.writeLock.lock();
        try {
            this.chunks.write(bArr, i);
        } finally {
            this.writeLock.unlock();
        }
    }

    public int read(int i, byte[] bArr, int i2, int i3) throws IOException {
        bArr.getClass();
        if (i < 0 || i3 < 0 || i2 > bArr.length || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        int min = Math.min(i3, bArr.length - i2);
        this.readLock.lock();
        try {
            Iterator<InternalChunk> read = this.chunks.read(i);
            int i4 = 0;
            while (i4 < min) {
                if (!read.hasNext()) {
                    break;
                }
                InternalChunk next = read.next();
                int count = next.getCount() - (i - next.getPosition());
                int i5 = count + i4;
                if (i5 <= min) {
                    System.arraycopy(next.getData(), i - next.getPosition(), bArr, i4 + i2, count);
                    i += count;
                    i4 = i5;
                } else {
                    int i6 = min - i4;
                    System.arraycopy(next.getData(), i - next.getPosition(), bArr, i4 + i2, i6);
                    i += i6;
                    i4 = min;
                }
            }
            return i4;
        } finally {
            this.readLock.unlock();
        }
    }

    public byte read(int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.readLock.lock();
        try {
            Iterator<InternalChunk> read = this.chunks.read(i);
            if (read.hasNext()) {
                InternalChunk next = read.next();
                return next.getData()[i - next.getPosition()];
            }
            throw new IndexOutOfBoundsException();
        } finally {
            this.readLock.unlock();
        }
    }

    public void clear(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.writeLock.lock();
        try {
            this.chunks.clear(i);
        } finally {
            this.writeLock.unlock();
        }
    }

    public int getStart() {
        int i;
        this.readLock.lock();
        try {
            InternalChunk internalChunk = this.chunks.chunks[this.chunks.head];
            if (internalChunk != null) {
                i = internalChunk.position;
            } else {
                i = this.chunks.length;
            }
            return i;
        } finally {
            this.readLock.unlock();
        }
    }

    public int getEnd() {
        this.readLock.lock();
        try {
            return this.chunks.length;
        } finally {
            this.readLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class InternalChunk {
        private final int count;
        private final byte[] data;
        private final int position;

        private InternalChunk(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.position = i;
            this.count = i2;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getPosition() {
            return this.position;
        }

        public int getCount() {
            return this.count;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class InternalChunks {
        private InternalChunk[] chunks;
        private int head = 0;
        private int count = 0;
        private int length = 0;

        public InternalChunks(int i) {
            this.chunks = new InternalChunk[i];
        }

        public void write(byte[] bArr, int i) {
            ensureCapacity();
            int i2 = this.head + this.count;
            InternalChunk[] internalChunkArr = this.chunks;
            internalChunkArr[i2 % internalChunkArr.length] = new InternalChunk(bArr, this.length, i);
            this.length += i;
            this.count++;
        }

        public void clear(int i) {
            int indexOf;
            if (i >= this.length) {
                indexOf = this.count;
            } else {
                indexOf = indexOf(i);
            }
            if (indexOf < 0) {
                return;
            }
            int i2 = this.head;
            int i3 = i2 + indexOf;
            InternalChunk[] internalChunkArr = this.chunks;
            if (i3 < internalChunkArr.length) {
                Arrays.fill(internalChunkArr, i2, i2 + indexOf, (Object) null);
                this.head += indexOf;
            } else {
                int length = indexOf - (internalChunkArr.length - i2);
                Arrays.fill(internalChunkArr, i2, internalChunkArr.length, (Object) null);
                Arrays.fill(this.chunks, 0, length, (Object) null);
                this.head = length;
            }
            this.count -= indexOf;
        }

        public Iterator<InternalChunk> read(int i) throws IOException {
            InternalChunk internalChunk = this.chunks[this.head];
            if ((internalChunk == null && i < this.length) || (internalChunk != null && i < internalChunk.getPosition())) {
                throw new IOException("Attempt to read the cache which has been cleared; Only clear the cache when it will not be read anymore!");
            }
            return new Iterator<InternalChunk>(i) { // from class: com.bytedance.pia.core.misc.ChunkedRingBuffer.InternalChunks.1
                int index;
                final /* synthetic */ int val$skip;

                {
                    this.val$skip = i;
                    this.index = InternalChunks.this.indexOf(i);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    int i2 = this.index;
                    return i2 >= 0 && i2 < InternalChunks.this.count;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public InternalChunk next() {
                    InternalChunk internalChunk2 = InternalChunks.this.get(this.index);
                    if (internalChunk2 != null) {
                        this.index++;
                    }
                    return internalChunk2;
                }
            };
        }

        private void ensureCapacity() {
            int i = this.count;
            InternalChunk[] internalChunkArr = this.chunks;
            if (i < internalChunkArr.length) {
                return;
            }
            InternalChunk[] internalChunkArr2 = new InternalChunk[internalChunkArr.length * 2];
            int i2 = this.head;
            System.arraycopy(internalChunkArr, i2, internalChunkArr2, 0, internalChunkArr.length - i2);
            InternalChunk[] internalChunkArr3 = this.chunks;
            int length = internalChunkArr3.length;
            int i3 = this.head;
            System.arraycopy(internalChunkArr3, 0, internalChunkArr2, length - i3, i3);
            this.chunks = internalChunkArr2;
            this.head = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int indexOf(int i) {
            int i2 = this.count - 1;
            int i3 = 0;
            while (i3 <= i2) {
                int i4 = ((i2 - i3) / 2) + i3;
                InternalChunk internalChunk = get(i4);
                if (i < internalChunk.getPosition()) {
                    i2 = i4 - 1;
                } else {
                    if (i < internalChunk.getPosition() + internalChunk.getCount()) {
                        return i4;
                    }
                    i3 = i4 + 1;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InternalChunk get(int i) {
            int i2 = this.head + i;
            InternalChunk[] internalChunkArr = this.chunks;
            return internalChunkArr[i2 % internalChunkArr.length];
        }
    }
}
