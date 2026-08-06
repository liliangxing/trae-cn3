package com.bytedance.android.tools.superkv.proto;

import com.bytedance.android.tools.superkv.FastBufferedSource;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes3.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private int recursionDepth;
    private FastBufferedSource source;
    private long pos = 0;
    private long limit = Long.MAX_VALUE;
    private int state = 2;
    private int tag = -1;
    private long pushedLimit = -1;

    public ProtoReader() {
    }

    public ProtoReader(FastBufferedSource fastBufferedSource) {
        this.source = fastBufferedSource;
    }

    public ProtoReader setup(FastBufferedSource fastBufferedSource) {
        this.source = fastBufferedSource;
        this.pos = 0L;
        this.limit = Long.MAX_VALUE;
        this.recursionDepth = 0;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1L;
        return this;
    }

    public long beginMessage() throws IOException {
        if (this.state != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i = this.recursionDepth + 1;
        this.recursionDepth = i;
        if (i > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return j;
    }

    public int nextTag() throws IOException {
        int i = this.state;
        if (i == 7) {
            this.state = 2;
            return this.tag;
        }
        if (i != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = internalReadVarint32 >> 3;
            this.tag = i2;
            int i3 = internalReadVarint32 & 7;
            if (i3 == 0) {
                this.state = 0;
                return i2;
            }
            if (i3 == 1) {
                this.state = 1;
                return i2;
            }
            if (i3 == 2) {
                this.state = 2;
                int internalReadVarint322 = internalReadVarint32();
                if (internalReadVarint322 < 0) {
                    throw new ProtocolException("Negative length: " + internalReadVarint322);
                }
                if (this.pushedLimit != -1) {
                    throw new IllegalStateException();
                }
                long j = this.limit;
                this.pushedLimit = j;
                long j2 = this.pos + internalReadVarint322;
                this.limit = j2;
                if (j2 > j) {
                    throw new EOFException();
                }
                return this.tag;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i3 == 5) {
                    this.state = 5;
                    return i2;
                }
                throw new ProtocolException("Unexpected field encoding: " + i3);
            }
            skipGroup(i2);
        }
        return -1;
    }

    private void skipGroup(int i) throws IOException {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i2 = internalReadVarint32 >> 3;
            int i3 = internalReadVarint32 & 7;
            if (i3 == 0) {
                this.state = 0;
                readVarint64();
            } else if (i3 == 1) {
                this.state = 1;
                readFixed64();
            } else if (i3 == 2) {
                long internalReadVarint322 = internalReadVarint32();
                this.pos += internalReadVarint322;
                this.source.skip(internalReadVarint322);
            } else if (i3 == 3) {
                skipGroup(i2);
            } else if (i3 == 4) {
                if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i3 == 5) {
                this.state = 5;
                readFixed32();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i3);
            }
        }
        throw new EOFException();
    }

    public byte[] readByteArray() throws IOException {
        return this.source.readByteArray(beforeLengthDelimitedScalar());
    }

    public String readString() throws IOException {
        return this.source.readUtf8(beforeLengthDelimitedScalar());
    }

    public int readVarint32() throws IOException {
        int i = this.state;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int internalReadVarint32 = internalReadVarint32();
        afterPackableScalar(0);
        return internalReadVarint32;
    }

    private int internalReadVarint32() throws IOException {
        int i;
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i2 = readByte & Byte.MAX_VALUE;
        this.pos++;
        byte readByte2 = this.source.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            i2 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << 14;
            } else {
                i2 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.pos++;
                byte readByte4 = this.source.readByte();
                if (readByte4 < 0) {
                    int i3 = i2 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    this.pos++;
                    byte readByte5 = this.source.readByte();
                    int i4 = i3 | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        this.pos++;
                        if (this.source.readByte() >= 0) {
                            return i4;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i = readByte4 << 21;
            }
        }
        return i2 | i;
    }

    public long readVarint64() throws IOException {
        int i = this.state;
        if (i != 0 && i != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        long j = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            this.pos++;
            j |= (r4 & Byte.MAX_VALUE) << i2;
            if ((this.source.readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                afterPackableScalar(0);
                return j;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public int readFixed32() throws IOException {
        int i = this.state;
        if (i != 5 && i != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
        }
        this.pos += 4;
        int readIntLe = this.source.readIntLe();
        afterPackableScalar(5);
        return readIntLe;
    }

    public long readFixed64() throws IOException {
        int i = this.state;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.pos += 8;
        long readLongLe = this.source.readLongLe();
        afterPackableScalar(1);
        return readLongLe;
    }

    private void afterPackableScalar(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
            return;
        }
        long j = this.pos;
        long j2 = this.limit;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        if (j == j2) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            this.state = 6;
            return;
        }
        this.state = 7;
    }

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
        }
        long j = this.limit;
        long j2 = j - this.pos;
        this.state = 6;
        this.pos = j;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1L;
        return j2;
    }
}
