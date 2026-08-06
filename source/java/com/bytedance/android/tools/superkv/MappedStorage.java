package com.bytedance.android.tools.superkv;

import com.bytedance.android.tools.superkv.IStorage;
import com.bytedance.android.tools.superkv.proto.FastProtoWriter;
import com.bytedance.android.tools.superkv.proto.KVProto;
import com.bytedance.android.tools.superkv.proto.ProtoReader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MappedStorage implements IStorage {
    private static final byte BIT_INVALID = 0;
    private static final byte BIT_VALID = 1;
    private static final String DATA_EXT = ".mapped.data";
    private static final int ENTRY_INFO_SIZE = 16;
    private static final int FILE_INFO_SIZE = 16;
    static int INITIAL_MAPPED_SIZE = 32768;
    static int TARGET_ENTRY_SIZE = 8192;
    private final FileChannel dataFileChannel;
    private final IStorage.DataInvalidCallback dataInvalidCallback;
    private final RandomAccessFile dataRandomAccessFile;
    private volatile MappedByteBuffer mappedByteBuffer;
    private final boolean multiProcess;
    private final Lockable readLock;
    private final Lockable writeLock;
    private volatile int dataSize = 16;
    private volatile int version = -1;
    private final Map<String, EntryInfo> entryMap = new LinkedHashMap();
    private final ProtoReader protoReader = new ProtoReader();
    private final FastProtoWriter protoWriter = new FastProtoWriter();
    private final KVProto sharedProto = new KVProto();
    private final FastBufferedSource fastBufferedSource = new FastBufferedSource();
    private final ThreadLocal<byte[]> sharedByteArrayThreadLocal = new ThreadLocal<byte[]>() { // from class: com.bytedance.android.tools.superkv.MappedStorage.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public byte[] initialValue() {
            return new byte[MappedStorage.TARGET_ENTRY_SIZE];
        }
    };
    private EntryInfoReceiver withoutTrimReceiver = new EntryInfoReceiver() { // from class: com.bytedance.android.tools.superkv.MappedStorage.3
        @Override // com.bytedance.android.tools.superkv.MappedStorage.EntryInfoReceiver
        public void onModify(String str, EntryInfo entryInfo) {
            MappedStorage.this.entryMap.put(str, entryInfo);
            MappedStorage.this.dataInvalidCallback.onItemInvalid(str);
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.EntryInfoReceiver
        public void onRemove(String str, EntryInfo entryInfo) {
            MappedStorage.this.entryMap.remove(str);
            MappedStorage.this.dataInvalidCallback.onItemInvalid(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface EntryInfoReceiver {
        void onModify(String str, EntryInfo entryInfo);

        void onRemove(String str, EntryInfo entryInfo);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private interface Lockable {
        void lock();

        void unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MappedStorage(String str, boolean z, IStorage.DataInvalidCallback dataInvalidCallback) throws IOException {
        this.multiProcess = z;
        this.dataInvalidCallback = dataInvalidCallback;
        File file = new File(str + DATA_EXT);
        if (!file.exists()) {
            file.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.dataRandomAccessFile = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.dataFileChannel = channel;
        this.mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0L, channel.size() > 0 ? (int) channel.size() : INITIAL_MAPPED_SIZE);
        if (z) {
            this.readLock = new MultiProcessReadLock(channel);
            this.writeLock = new MultiProcessWriteLock(channel);
        } else {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            this.readLock = new SingleProcessReadLock(reentrantReadWriteLock);
            this.writeLock = new SingleProcessWriteLock(reentrantReadWriteLock);
        }
        this.readLock.lock();
        ensureUpToDate(true);
        this.readLock.unlock();
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public void release() {
        Utils.releaseMappedByteBuffer(this.mappedByteBuffer);
        try {
            this.dataFileChannel.close();
        } catch (Exception e) {
            Debug.m57e("Failed to close dataFileChannel", e);
        }
        try {
            this.dataRandomAccessFile.close();
        } catch (Exception unused) {
            Debug.m56e("Failed to close dataRandomAccessFile");
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, boolean z) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 3;
            this.sharedProto.booleanValue = z;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, int i) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 4;
            this.sharedProto.intValue = i;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, long j) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 5;
            this.sharedProto.longValue = j;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, float f) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 6;
            this.sharedProto.floatValue = f;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, double d) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 7;
            this.sharedProto.doubleValue = d;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, byte[] bArr) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 9;
            this.sharedProto.bytesValue = bArr;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, String str2) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 8;
            this.sharedProto.stringValue = str2;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public int put(String str, List<String> list) {
        this.writeLock.lock();
        try {
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 10;
            this.sharedProto.stringListValue = list;
            return putInternal(str, BIT_VALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public void ensureUpToDate() {
        ensureUpToDate(false);
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public KVProto get(String str) {
        EntryInfo entryInfo;
        this.readLock.lock();
        try {
            try {
                if (this.multiProcess) {
                    ensureUpToDate(false);
                }
                entryInfo = this.entryMap.get(str);
            } catch (Exception e) {
                Debug.tryThrow("Failed to read local data!", e);
            }
            if (entryInfo == null) {
                Debug.m60w("Item does not exist, key: " + str);
                return null;
            }
            return KVProto.Adapter.fastDecode(this.protoReader.setup(this.fastBufferedSource.setup(this.mappedByteBuffer, entryInfo.dataOffset, entryInfo.dataLength)), this.sharedProto);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // com.bytedance.android.tools.superkv.IStorage
    public void remove(String str) {
        this.writeLock.lock();
        try {
            if (this.multiProcess) {
                ensureUpToDate(false);
            }
            if (this.entryMap.remove(str) == null) {
                Debug.m60w("Tried to remove item doesn't exist, key: " + str);
                return;
            }
            this.sharedProto.resetValues();
            this.sharedProto.key = str;
            this.sharedProto.type = 0;
            putInternal(str, BIT_INVALID);
        } finally {
            this.writeLock.unlock();
        }
    }

    private boolean reloadWithTrim(boolean z, int i) {
        this.entryMap.clear();
        final int[] iArr = new int[1];
        if (loadData(16, i, new EntryInfoReceiver() { // from class: com.bytedance.android.tools.superkv.MappedStorage.2
            @Override // com.bytedance.android.tools.superkv.MappedStorage.EntryInfoReceiver
            public void onModify(String str, EntryInfo entryInfo) {
                MappedStorage.this.entryMap.put(str, entryInfo);
                int[] iArr2 = iArr;
                iArr2[0] = iArr2[0] + 1;
            }

            @Override // com.bytedance.android.tools.superkv.MappedStorage.EntryInfoReceiver
            public void onRemove(String str, EntryInfo entryInfo) {
                MappedStorage.this.entryMap.remove(str);
                int[] iArr2 = iArr;
                iArr2[0] = iArr2[0] + 1;
            }
        })) {
            iArr[0] = -1;
        }
        if ((iArr[0] == this.entryMap.size() || !z) && iArr[0] != -1) {
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(this.mappedByteBuffer.capacity() - 16);
        this.mappedByteBuffer.position(16);
        byte[] array = allocate.array();
        int i2 = 0;
        for (EntryInfo entryInfo : this.entryMap.values()) {
            this.mappedByteBuffer.position(entryInfo.dataOffset - 16);
            this.mappedByteBuffer.get(array, i2, entryInfo.dataLength + 16);
            entryInfo.dataOffset = i2 + 16 + 16;
            i2 += entryInfo.dataLength + 16;
        }
        this.mappedByteBuffer.position(16);
        this.mappedByteBuffer.put(array, 0, allocate.capacity());
        this.dataSize = i2 + 16;
        this.dataInvalidCallback.onAllInvalid();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x014f, code lost:
    
        com.bytedance.android.tools.superkv.Debug.m56e("Broken entry info at " + r4 + "! Skipping all the rest...");
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean loadData(int i, int i2, EntryInfoReceiver entryInfoReceiver) {
        byte[] array = ByteBuffer.allocateDirect(i2 - i).array();
        int i3 = 0;
        boolean z = false;
        int i4 = i;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            this.mappedByteBuffer.position(i4);
            this.mappedByteBuffer.get(array, i3, 16);
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            int i7 = ((array[i3] & 255) << 24) | ((array[i5] & 255) << 16);
            int i8 = i6 + 1;
            int i9 = i7 | ((array[i6] & 255) << 8);
            int i10 = i8 + 1;
            int i11 = i9 | (array[i8] & 255);
            int i12 = i10 + 1;
            byte b = array[i10];
            int i13 = i12 + 1;
            if (array[i12] != -1) {
                break;
            }
            int i14 = i13 + 1;
            if (array[i13] != -1) {
                break;
            }
            int i15 = i14 + 1;
            if (array[i14] != -1) {
                break;
            }
            int i16 = i15 + 1 + 1 + 1;
            long j = ((array[r7] & 255) << 48) | ((array[i15] & 255) << 56) | ((array[r17] & 255) << 40);
            long j2 = j | ((array[i16] & 255) << 32) | ((array[r12] & 255) << 24);
            long j3 = j2 | ((array[r12] & 255) << 16);
            long j4 = j3 | ((array[r9] & 255) << 8);
            int i17 = i16 + 1 + 1 + 1 + 1 + 1;
            long j5 = j4 | (array[r12] & 255);
            if (i11 <= 0) {
                Debug.m56e("Unexpected EOF at " + i17 + "!");
                break;
            }
            this.mappedByteBuffer.get(array, i17, i11);
            if (Adler32Java.calc(array, i17, i11) != j5) {
                Debug.m56e("Checksum failed at position: " + i4 + ", expected: " + j5 + ", found: " + Adler32Java.calc(array, i17, i11) + ", skipping...");
                i4 += i11 + 16;
                i3 = i17;
                z = true;
            } else {
                try {
                    int i18 = i4 + 16;
                    String fastGetKey = KVProto.Adapter.fastGetKey(this.fastBufferedSource.setup(this.mappedByteBuffer, i18, i11));
                    if ((1 & b) != 0) {
                        entryInfoReceiver.onModify(fastGetKey, new EntryInfo(i18, i11));
                    } else {
                        entryInfoReceiver.onRemove(fastGetKey, null);
                    }
                    i4 = i18 + i11;
                    i3 = i11 + i17;
                } catch (Exception unused) {
                    Debug.m56e("Failed to decode data at: " + i4);
                    i4 += i11 + 16;
                    z = true;
                    i3 = i17;
                }
            }
        }
        this.dataSize = i4;
        return z;
    }

    private void ensureUpToDate(boolean z) {
        byte[] sharedByteArray = getSharedByteArray();
        this.mappedByteBuffer.position(0);
        this.mappedByteBuffer.get(sharedByteArray, 0, 16);
        int i = 1;
        int i2 = ((sharedByteArray[0] & 255) << 24) | ((sharedByteArray[1] & 255) << 16) | ((sharedByteArray[2] & 255) << 8) | (sharedByteArray[3] & 255);
        int i3 = (sharedByteArray[7] & 255) | ((sharedByteArray[4] & 255) << 24) | ((sharedByteArray[5] & 255) << 16) | ((sharedByteArray[6] & 255) << 8);
        if (i2 <= 0 || i3 <= 0) {
            updateFileInfo(1, 16);
        } else {
            if (this.version < i2) {
                if (reloadWithTrim(z, i3)) {
                    i = i2 + 1;
                    updateFileInfo(i, this.dataSize);
                }
            } else if (this.dataSize < i3) {
                loadData(this.dataSize, i3, this.withoutTrimReceiver);
            }
            i = i2;
        }
        this.version = i;
    }

    private void updateFileInfo(int i, int i2) {
        byte[] sharedByteArray = getSharedByteArray();
        sharedByteArray[0] = (byte) (i >>> 24);
        sharedByteArray[1] = (byte) (i >>> 16);
        sharedByteArray[2] = (byte) (i >>> 8);
        sharedByteArray[3] = (byte) i;
        sharedByteArray[4] = (byte) (i2 >>> 24);
        sharedByteArray[5] = (byte) (i2 >>> 16);
        sharedByteArray[6] = (byte) (i2 >>> 8);
        sharedByteArray[7] = (byte) i2;
        this.mappedByteBuffer.position(0);
        this.mappedByteBuffer.put(sharedByteArray, 0, 16);
    }

    private void ensureEnoughSpace(int i) {
        int capacity = this.mappedByteBuffer.capacity();
        while (capacity < i) {
            capacity = (int) (capacity * 1.5f);
        }
        try {
            Utils.releaseMappedByteBuffer(this.mappedByteBuffer);
            this.mappedByteBuffer = this.dataFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, capacity);
        } catch (Exception e) {
            Debug.m57e("Failed to resize mapped buffer", e);
        }
    }

    private int putInternal(String str, byte b) {
        byte[] sharedByteArray = getSharedByteArray();
        if (this.multiProcess) {
            ensureUpToDate(false);
        }
        EntryInfo entryInfo = new EntryInfo();
        int i = this.dataSize;
        int encodedSize = KVProto.Adapter.encodedSize(this.sharedProto);
        entryInfo.dataLength = encodedSize;
        entryInfo.dataOffset = i + 16;
        int i2 = encodedSize + 16;
        if (i2 > sharedByteArray.length) {
            sharedByteArray = new byte[i2];
        }
        KVProto.Adapter.fastEncode(this.protoWriter.setup(sharedByteArray, 16), this.sharedProto);
        long calc = Adler32Java.calc(sharedByteArray, 16, encodedSize);
        sharedByteArray[0] = (byte) (encodedSize >>> 24);
        sharedByteArray[1] = (byte) (encodedSize >>> 16);
        sharedByteArray[2] = (byte) (encodedSize >>> 8);
        sharedByteArray[3] = (byte) encodedSize;
        sharedByteArray[4] = b;
        sharedByteArray[7] = -1;
        sharedByteArray[6] = -1;
        sharedByteArray[5] = -1;
        sharedByteArray[8] = (byte) (calc >>> 56);
        sharedByteArray[9] = (byte) (calc >>> 48);
        sharedByteArray[10] = (byte) (calc >>> 40);
        sharedByteArray[11] = (byte) (calc >>> 32);
        sharedByteArray[12] = (byte) (calc >>> 24);
        sharedByteArray[13] = (byte) (calc >>> 16);
        sharedByteArray[14] = (byte) (calc >>> 8);
        sharedByteArray[15] = (byte) calc;
        if (this.mappedByteBuffer.capacity() < entryInfo.dataOffset + encodedSize) {
            ensureEnoughSpace(entryInfo.dataOffset + encodedSize);
        }
        this.mappedByteBuffer.position(i);
        this.mappedByteBuffer.put(sharedByteArray, 0, i2);
        this.dataSize = i + i2;
        updateFileInfo(this.version, this.dataSize);
        if (b == 1) {
            this.entryMap.put(str, entryInfo);
        }
        return entryInfo.dataLength;
    }

    private byte[] getSharedByteArray() {
        return this.sharedByteArrayThreadLocal.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class EntryInfo {
        volatile int dataLength;
        volatile int dataOffset;

        EntryInfo() {
        }

        EntryInfo(int i, int i2) {
            this.dataOffset = i;
            this.dataLength = i2;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class SingleProcessReadLock implements Lockable {
        private ReentrantReadWriteLock lock;

        private SingleProcessReadLock(ReentrantReadWriteLock reentrantReadWriteLock) {
            this.lock = reentrantReadWriteLock;
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.Lockable
        public void lock() {
            this.lock.readLock().lock();
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.Lockable
        public void unlock() {
            this.lock.readLock().unlock();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class SingleProcessWriteLock implements Lockable {
        private ReentrantReadWriteLock lock;

        private SingleProcessWriteLock(ReentrantReadWriteLock reentrantReadWriteLock) {
            this.lock = reentrantReadWriteLock;
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.Lockable
        public void lock() {
            this.lock.writeLock().lock();
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.Lockable
        public void unlock() {
            this.lock.writeLock().unlock();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static abstract class MultiProcessLock implements Lockable {
        final FileChannel fileChannel;
        FileLock fileLock;
        final ReentrantLock reentrantLock = new ReentrantLock();

        abstract void lockFile();

        MultiProcessLock(FileChannel fileChannel) {
            this.fileChannel = fileChannel;
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.Lockable
        public final void lock() {
            this.reentrantLock.lock();
            lockFile();
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.Lockable
        public final void unlock() {
            try {
                this.fileLock.release();
            } catch (Exception e) {
                Debug.tryThrow("Failed to release FileLock", e);
            }
            this.reentrantLock.unlock();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class MultiProcessWriteLock extends MultiProcessLock {
        MultiProcessWriteLock(FileChannel fileChannel) {
            super(fileChannel);
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.MultiProcessLock
        void lockFile() {
            try {
                this.fileLock = this.fileChannel.lock();
            } catch (Exception e) {
                Debug.tryThrow("Failed to lock FileLock", e);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static final class MultiProcessReadLock extends MultiProcessLock {
        MultiProcessReadLock(FileChannel fileChannel) {
            super(fileChannel);
        }

        @Override // com.bytedance.android.tools.superkv.MappedStorage.MultiProcessLock
        void lockFile() {
            try {
                this.fileLock = this.fileChannel.lock(0L, Long.MAX_VALUE, true);
            } catch (Exception e) {
                Debug.tryThrow("Failed to lock FileLock", e);
            }
        }
    }
}
