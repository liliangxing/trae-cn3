package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CodedInputStream {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface RefillCallback {
        void onRefill();
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream, 4096);
    }

    static CodedInputStream newInstance(InputStream inputStream, int i) {
        return new CodedInputStream(inputStream, i);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        return newInstance(bArr, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(byte[] bArr, int i, int i2, boolean z) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2, z);
        try {
            codedInputStream.pushLimit(i2);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        byte[] bArr = new byte[duplicate.remaining()];
        duplicate.get(bArr);
        return newInstance(bArr);
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        if (this.lastTag != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getLastTag() {
        return this.lastTag;
    }

    public boolean skipField(int i) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            skipRawVarint();
            return true;
        }
        if (tagWireType == 1) {
            skipRawBytes(8);
            return true;
        }
        if (tagWireType == 2) {
            skipRawBytes(readRawVarint32());
            return true;
        }
        if (tagWireType == 3) {
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType == 5) {
            skipRawBytes(4);
            return true;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        }
        if (tagWireType == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        }
        if (tagWireType == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        }
        if (tagWireType == 3) {
            codedOutputStream.writeRawVarint32(i);
            skipMessage(codedOutputStream);
            int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
            checkLastTagWas(makeTag);
            codedOutputStream.writeRawVarint32(makeTag);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType == 5) {
            int readRawLittleEndian32 = readRawLittleEndian32();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
            return true;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag, codedOutputStream));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class SkippedDataSink implements RefillCallback {
        private ByteArrayOutputStream byteArrayStream;
        private int lastPos;

        private SkippedDataSink() {
            this.lastPos = CodedInputStream.this.bufferPos;
        }

        @Override // com.google.protobuf.CodedInputStream.RefillCallback
        public void onRefill() {
            if (this.byteArrayStream == null) {
                this.byteArrayStream = new ByteArrayOutputStream();
            }
            this.byteArrayStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
            this.lastPos = 0;
        }

        ByteBuffer getSkippedData() {
            ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
            if (byteArrayOutputStream == null) {
                return ByteBuffer.wrap(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos - this.lastPos);
            }
            byteArrayOutputStream.write(CodedInputStream.this.buffer, this.lastPos, CodedInputStream.this.bufferPos);
            return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        if (readRawVarint32 <= i - this.bufferPos && readRawVarint32 > 0) {
            String str = new String(this.buffer, this.bufferPos, readRawVarint32, Internal.UTF_8);
            this.bufferPos += readRawVarint32;
            return str;
        }
        if (readRawVarint32 == 0) {
            return "";
        }
        if (readRawVarint32 <= i) {
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.bufferPos, readRawVarint32, Internal.UTF_8);
            this.bufferPos += readRawVarint32;
            return str2;
        }
        return new String(readRawBytesSlowPath(readRawVarint32), Internal.UTF_8);
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] readRawBytesSlowPath;
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferPos;
        int i2 = this.bufferSize;
        if (readRawVarint32 <= i2 - i && readRawVarint32 > 0) {
            readRawBytesSlowPath = this.buffer;
            this.bufferPos = i + readRawVarint32;
        } else {
            if (readRawVarint32 == 0) {
                return "";
            }
            i = 0;
            if (readRawVarint32 <= i2) {
                refillBuffer(readRawVarint32);
                readRawBytesSlowPath = this.buffer;
                this.bufferPos = readRawVarint32 + 0;
            } else {
                readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32);
            }
        }
        if (!Utf8.isValidUtf8(readRawBytesSlowPath, i, i + readRawVarint32)) {
            throw InvalidProtocolBufferException.invalidUtf8();
        }
        return new String(readRawBytesSlowPath, i, readRawVarint32, Internal.UTF_8);
    }

    public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i, 4));
        this.recursionDepth--;
    }

    public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.recursionDepth;
        if (i2 >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i2 + 1;
        T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i, 4));
        this.recursionDepth--;
        return parsePartialFrom;
    }

    @Deprecated
    public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
        readGroup(i, builder, (ExtensionRegistryLite) null);
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = pushLimit(readRawVarint32);
        this.recursionDepth++;
        T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(pushLimit);
        return parsePartialFrom;
    }

    public ByteString readBytes() throws IOException {
        ByteString copyFrom;
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(readRawBytesSlowPath(readRawVarint32));
        }
        if (this.bufferIsImmutable && this.enableAliasing) {
            copyFrom = ByteString.wrap(this.buffer, i2, readRawVarint32);
        } else {
            copyFrom = ByteString.copyFrom(this.buffer, i2, readRawVarint32);
        }
        this.bufferPos += readRawVarint32;
        return copyFrom;
    }

    public byte[] readByteArray() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32);
            this.bufferPos += readRawVarint32;
            return copyOfRange;
        }
        return readRawBytesSlowPath(readRawVarint32);
    }

    public ByteBuffer readByteBuffer() throws IOException {
        ByteBuffer wrap;
        int readRawVarint32 = readRawVarint32();
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32));
        }
        if (this.input == null && !this.bufferIsImmutable && this.enableAliasing) {
            wrap = ByteBuffer.wrap(this.buffer, i2, readRawVarint32).slice();
        } else {
            wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32));
        }
        this.bufferPos += readRawVarint32;
        return wrap;
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readRawVarint32() throws IOException {
        int i;
        int i2 = this.bufferPos;
        int i3 = this.bufferSize;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.bufferPos = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            byte b2 = bArr[i5];
                            i = (i9 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i7;
                }
                this.bufferPos = i5;
                return i;
            }
        }
        return (int) readRawVarint64SlowPath();
    }

    private void skipRawVarint() throws IOException {
        int i = this.bufferSize;
        int i2 = this.bufferPos;
        if (i - i2 >= 10) {
            byte[] bArr = this.buffer;
            int i3 = 0;
            while (i3 < 10) {
                int i4 = i2 + 1;
                if (bArr[i2] >= 0) {
                    this.bufferPos = i4;
                    return;
                } else {
                    i3++;
                    i2 = i4;
                }
            }
        }
        skipRawVarintSlowPath();
    }

    private void skipRawVarintSlowPath() throws IOException {
        for (int i = 0; i < 10; i++) {
            if (readRawByte() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(read, inputStream);
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (read & 127) << i3;
            if ((read & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
    
        if (r2[r0] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readRawVarint64() throws IOException {
        long j;
        long j2;
        long j3;
        int i;
        int i2 = this.bufferPos;
        int i3 = this.bufferSize;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.bufferPos = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        i5 = i7;
                        j = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            long j4 = i9;
                            int i10 = i5 + 1;
                            long j5 = j4 ^ (bArr[i5] << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i5 = i10 + 1;
                                long j6 = j5 ^ (bArr[i10] << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i10 = i5 + 1;
                                    j5 = j6 ^ (bArr[i5] << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i5 = i10 + 1;
                                        j6 = j5 ^ (bArr[i10] << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i11 = i5 + 1;
                                            long j7 = (j6 ^ (bArr[i5] << 56)) ^ 71499008037633920L;
                                            i5 = j7 < 0 ? i11 + 1 : i11;
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i5 = i10;
                        }
                    }
                    this.bufferPos = i5;
                    return j;
                }
                i = i6 ^ (-128);
                j = i;
                this.bufferPos = i5;
                return j;
            }
        }
        return readRawVarint64SlowPath();
    }

    long readRawVarint64SlowPath() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & Byte.MAX_VALUE) << i;
            if ((readRawByte() & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readRawLittleEndian32() throws IOException {
        int i = this.bufferPos;
        if (this.bufferSize - i < 4) {
            refillBuffer(4);
            i = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i = this.bufferPos;
        if (this.bufferSize - i < 8) {
            refillBuffer(8);
            i = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    private CodedInputStream(byte[] bArr, int i, int i2, boolean z) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 100;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.refillCallback = null;
        this.buffer = bArr;
        this.bufferSize = i2 + i;
        this.bufferPos = i;
        this.totalBytesRetired = -i;
        this.input = null;
        this.bufferIsImmutable = z;
    }

    private CodedInputStream(InputStream inputStream, int i) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 100;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.refillCallback = null;
        this.buffer = new byte[i];
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    public void enableAliasing(boolean z) {
        this.enableAliasing = z;
    }

    public int setRecursionLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i;
        return i2;
    }

    public int setSizeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + i);
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i;
        return i2;
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = i + this.totalBytesRetired + this.bufferPos;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    private void recomputeBufferSizeAfterLimit() {
        int i = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i;
        int i2 = this.totalBytesRetired + i;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.bufferSizeAfterLimit = i4;
            this.bufferSize = i - i4;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        int i = this.currentLimit;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    private void refillBuffer(int i) throws IOException {
        if (!tryRefillBuffer(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private boolean tryRefillBuffer(int i) throws IOException {
        int i2 = this.bufferPos;
        if (i2 + i <= this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        if (this.totalBytesRetired + i2 + i > this.currentLimit) {
            return false;
        }
        RefillCallback refillCallback = this.refillCallback;
        if (refillCallback != null) {
            refillCallback.onRefill();
        }
        if (this.input != null) {
            int i3 = this.bufferPos;
            if (i3 > 0) {
                int i4 = this.bufferSize;
                if (i4 > i3) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                }
                this.totalBytesRetired += i3;
                this.bufferSize -= i3;
                this.bufferPos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i5 = this.bufferSize;
            int read = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            if (read > 0) {
                this.bufferSize += read;
                if ((this.totalBytesRetired + i) - this.sizeLimit > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                recomputeBufferSizeAfterLimit();
                if (this.bufferSize >= i) {
                    return true;
                }
                return tryRefillBuffer(i);
            }
        }
        return false;
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public byte[] readRawBytes(int i) throws IOException {
        int i2 = this.bufferPos;
        if (i <= this.bufferSize - i2 && i > 0) {
            int i3 = i + i2;
            this.bufferPos = i3;
            return Arrays.copyOfRange(this.buffer, i2, i3);
        }
        return readRawBytesSlowPath(i);
    }

    private byte[] readRawBytesSlowPath(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired;
        int i3 = this.bufferPos;
        int i4 = i2 + i3 + i;
        if (i4 > this.sizeLimit) {
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }
        int i5 = this.currentLimit;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        InputStream inputStream = this.input;
        if (inputStream == null) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.bufferSize;
        int i7 = i6 - i3;
        this.totalBytesRetired = i2 + i6;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int i8 = i - i7;
        if (i8 < 4096 || i8 <= inputStream.available()) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, i3, bArr, 0, i7);
            while (i7 < i) {
                int read = this.input.read(bArr, i7, i - i7);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read;
                i7 += read;
            }
            return bArr;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i8 > 0) {
            int min = Math.min(i8, 4096);
            byte[] bArr2 = new byte[min];
            int i9 = 0;
            while (i9 < min) {
                int read2 = this.input.read(bArr2, i9, min - i9);
                if (read2 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read2;
                i9 += read2;
            }
            i8 -= min;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(this.buffer, i3, bArr3, 0, i7);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, i7, bArr4.length);
            i7 += bArr4.length;
        }
        return bArr3;
    }

    public void skipRawBytes(int i) throws IOException {
        int i2 = this.bufferSize;
        int i3 = this.bufferPos;
        if (i <= i2 - i3 && i >= 0) {
            this.bufferPos = i3 + i;
        } else {
            skipRawBytesSlowPath(i);
        }
    }

    private void skipRawBytesSlowPath(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired;
        int i3 = this.bufferPos;
        int i4 = i2 + i3 + i;
        int i5 = this.currentLimit;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.bufferSize;
        int i7 = i6 - i3;
        this.bufferPos = i6;
        refillBuffer(1);
        while (true) {
            int i8 = i - i7;
            int i9 = this.bufferSize;
            if (i8 > i9) {
                i7 += i9;
                this.bufferPos = i9;
                refillBuffer(1);
            } else {
                this.bufferPos = i8;
                return;
            }
        }
    }
}
