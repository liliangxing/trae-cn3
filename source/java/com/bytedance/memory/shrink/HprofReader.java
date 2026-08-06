package com.bytedance.memory.shrink;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HprofReader {
    private int mIdSize = 0;
    private final InputStream mStreamIn;

    public HprofReader(InputStream inputStream) {
        this.mStreamIn = inputStream;
    }

    public void accept(HprofVisitor hprofVisitor) throws IOException {
        acceptHeader(hprofVisitor);
        acceptRecord(hprofVisitor);
        hprofVisitor.visitEnd();
    }

    private void acceptHeader(HprofVisitor hprofVisitor) throws IOException {
        String readNullTerminatedString = MemoryIOUtil.readNullTerminatedString(this.mStreamIn);
        int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
        if (readBEInt <= 0 || readBEInt >= 1073741823) {
            throw new IOException("bad idSize: " + readBEInt);
        }
        long readBELong = MemoryIOUtil.readBELong(this.mStreamIn);
        this.mIdSize = readBEInt;
        hprofVisitor.visitHeader(readNullTerminatedString, readBEInt, readBELong);
    }

    private void acceptRecord(HprofVisitor hprofVisitor) throws IOException {
        while (true) {
            try {
                int read = this.mStreamIn.read();
                int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
                long readBEInt2 = 4294967295L & MemoryIOUtil.readBEInt(this.mStreamIn);
                if (read == 1) {
                    acceptStringRecord(readBEInt, readBEInt2, hprofVisitor);
                } else if (read == 2) {
                    acceptLoadClassRecord(readBEInt, readBEInt2, hprofVisitor);
                } else if (read == 4) {
                    acceptStackFrameRecord(readBEInt, readBEInt2, hprofVisitor);
                } else if (read == 5) {
                    acceptStackTraceRecord(readBEInt, readBEInt2, hprofVisitor);
                } else if (read == 12 || read == 28) {
                    acceptHeapDumpRecord(read, readBEInt, readBEInt2, hprofVisitor);
                } else {
                    acceptUnconcernedRecord(read, readBEInt, readBEInt2, hprofVisitor);
                }
            } catch (EOFException unused) {
                return;
            }
        }
    }

    private void acceptStringRecord(int i, long j, HprofVisitor hprofVisitor) throws IOException {
        hprofVisitor.visitStringRecord(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readString(this.mStreamIn, j - this.mIdSize), i, j);
    }

    private void acceptLoadClassRecord(int i, long j, HprofVisitor hprofVisitor) throws IOException {
        hprofVisitor.visitLoadClassRecord(MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), i, j);
    }

    private void acceptStackFrameRecord(int i, long j, HprofVisitor hprofVisitor) throws IOException {
        hprofVisitor.visitStackFrameRecord(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readBEInt(this.mStreamIn), i, j);
    }

    private void acceptStackTraceRecord(int i, long j, HprofVisitor hprofVisitor) throws IOException {
        int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
        int readBEInt2 = MemoryIOUtil.readBEInt(this.mStreamIn);
        int readBEInt3 = MemoryIOUtil.readBEInt(this.mStreamIn);
        HprofID[] hprofIDArr = new HprofID[readBEInt3];
        for (int i2 = 0; i2 < readBEInt3; i2++) {
            hprofIDArr[i2] = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        }
        hprofVisitor.visitStackTraceRecord(readBEInt, readBEInt2, hprofIDArr, i, j);
    }

    private void acceptHeapDumpRecord(int i, int i2, long j, HprofVisitor hprofVisitor) throws IOException {
        int i3;
        HprofHeapDumpVisitorInterface visitHeapDumpRecord = hprofVisitor.visitHeapDumpRecord(i, i2, j);
        if (visitHeapDumpRecord == null) {
            MemoryIOUtil.skip(this.mStreamIn, j);
            return;
        }
        while (j > 0) {
            int read = this.mStreamIn.read();
            long j2 = j - 1;
            if (read == 144) {
                visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                i3 = this.mIdSize;
            } else if (read == 195) {
                i3 = acceptPrimitiveArrayDump(read, visitHeapDumpRecord);
            } else if (read == 254) {
                i3 = acceptHeapDumpInfo(visitHeapDumpRecord);
            } else if (read == 255) {
                visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                i3 = this.mIdSize;
            } else {
                switch (read) {
                    case 1:
                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                        MemoryIOUtil.skip(this.mStreamIn, this.mIdSize);
                        i3 = this.mIdSize << 1;
                        break;
                    case 2:
                        i3 = acceptJniLocal(visitHeapDumpRecord);
                        break;
                    case 3:
                        i3 = acceptJavaFrame(visitHeapDumpRecord);
                        break;
                    case 4:
                        i3 = acceptNativeStack(visitHeapDumpRecord);
                        break;
                    case 5:
                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                        i3 = this.mIdSize;
                        break;
                    case 6:
                        i3 = acceptThreadBlock(visitHeapDumpRecord);
                        break;
                    case 7:
                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                        i3 = this.mIdSize;
                        break;
                    case 8:
                        i3 = acceptThreadObject(visitHeapDumpRecord);
                        break;
                    default:
                        switch (read) {
                            case 32:
                                i3 = acceptClassDump(visitHeapDumpRecord);
                                break;
                            case 33:
                                i3 = acceptInstanceDump(visitHeapDumpRecord);
                                break;
                            case 34:
                                i3 = acceptObjectArrayDump(visitHeapDumpRecord);
                                break;
                            case 35:
                                i3 = acceptPrimitiveArrayDump(read, visitHeapDumpRecord);
                                break;
                            default:
                                switch (read) {
                                    case HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_INTERNED_STRING /* 137 */:
                                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                                        i3 = this.mIdSize;
                                        break;
                                    case HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_FINALIZING /* 138 */:
                                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                                        i3 = this.mIdSize;
                                        break;
                                    case HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_DEBUGGER /* 139 */:
                                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                                        i3 = this.mIdSize;
                                        break;
                                    case 140:
                                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                                        i3 = this.mIdSize;
                                        break;
                                    case HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_VM_INTERNAL /* 141 */:
                                        visitHeapDumpRecord.visitHeapDumpBasicObj(read, MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
                                        i3 = this.mIdSize;
                                        break;
                                    case HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_JNI_MONITOR /* 142 */:
                                        i3 = acceptJniMonitor(visitHeapDumpRecord);
                                        break;
                                    default:
                                        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + read + " with " + this.mStreamIn.available() + " bytes possibly remaining");
                                }
                        }
                }
            }
            j = j2 - i3;
        }
        visitHeapDumpRecord.visitEnd();
    }

    private void acceptUnconcernedRecord(int i, int i2, long j, HprofVisitor hprofVisitor) throws IOException {
        byte[] bArr = new byte[(int) j];
        MemoryIOUtil.readFully(this.mStreamIn, bArr, 0, j);
        hprofVisitor.visitUnconcernedRecord(i, i2, j, bArr);
    }

    private int acceptHeapDumpInfo(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpInfo(MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize));
        return this.mIdSize + 4;
    }

    private int acceptJniLocal(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpJniLocal(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readBEInt(this.mStreamIn));
        return this.mIdSize + 4 + 4;
    }

    private int acceptJavaFrame(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpJavaFrame(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readBEInt(this.mStreamIn));
        return this.mIdSize + 4 + 4;
    }

    private int acceptNativeStack(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpNativeStack(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn));
        return this.mIdSize + 4;
    }

    private int acceptThreadBlock(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpThreadBlock(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn));
        return this.mIdSize + 4;
    }

    private int acceptThreadObject(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpThreadObject(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readBEInt(this.mStreamIn));
        return this.mIdSize + 4 + 4;
    }

    private int acceptClassDump(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        HprofID readID = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
        HprofID readID2 = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        HprofID readID3 = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        MemoryIOUtil.skip(this.mStreamIn, this.mIdSize << 2);
        int readBEInt2 = MemoryIOUtil.readBEInt(this.mStreamIn);
        int i = (this.mIdSize * 7) + 4 + 4;
        short readBEShort = MemoryIOUtil.readBEShort(this.mStreamIn);
        int i2 = i + 2;
        for (int i3 = 0; i3 < readBEShort; i3++) {
            MemoryIOUtil.skip(this.mStreamIn, 2L);
            i2 += skipValue() + 2;
        }
        int readBEShort2 = MemoryIOUtil.readBEShort(this.mStreamIn);
        HprofField[] hprofFieldArr = new HprofField[readBEShort2];
        int i4 = i2 + 2;
        for (int i5 = 0; i5 < readBEShort2; i5++) {
            HprofID readID4 = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
            int read = this.mStreamIn.read();
            BaseType type = BaseType.getType(read);
            if (type == null) {
                throw new IllegalStateException("accept class failed, lost type def of typeId: " + read);
            }
            hprofFieldArr[i5] = new HprofField(read, readID4, MemoryIOUtil.readValue(this.mStreamIn, type, this.mIdSize));
            int i6 = this.mIdSize;
            i4 += i6 + 1 + type.getSize(i6);
        }
        int readBEShort3 = MemoryIOUtil.readBEShort(this.mStreamIn);
        HprofField[] hprofFieldArr2 = new HprofField[readBEShort3];
        int i7 = i4 + 2;
        for (int i8 = 0; i8 < readBEShort3; i8++) {
            hprofFieldArr2[i8] = new HprofField(this.mStreamIn.read(), MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), null);
            i7 += this.mIdSize + 1;
        }
        hprofHeapDumpVisitorInterface.visitHeapDumpClass(readID, readBEInt, readID2, readID3, readBEInt2, hprofFieldArr, hprofFieldArr2);
        return i7;
    }

    private int acceptInstanceDump(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        HprofID readID = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
        HprofID readID2 = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        int readBEInt2 = MemoryIOUtil.readBEInt(this.mStreamIn);
        byte[] bArr = new byte[readBEInt2];
        MemoryIOUtil.readFully(this.mStreamIn, bArr, 0, readBEInt2);
        hprofHeapDumpVisitorInterface.visitHeapDumpInstance(readID, readBEInt, readID2, bArr);
        int i = this.mIdSize;
        return i + 4 + i + 4 + readBEInt2;
    }

    private int acceptObjectArrayDump(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        HprofID readID = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
        int readBEInt2 = MemoryIOUtil.readBEInt(this.mStreamIn);
        HprofID readID2 = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        int i = this.mIdSize * readBEInt2;
        byte[] bArr = new byte[i];
        MemoryIOUtil.readFully(this.mStreamIn, bArr, 0, i);
        hprofHeapDumpVisitorInterface.visitHeapDumpObjectArray(readID, readBEInt, readBEInt2, readID2, bArr);
        int i2 = this.mIdSize;
        return i2 + 4 + 4 + i2 + i;
    }

    private int acceptPrimitiveArrayDump(int i, HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        HprofID readID = MemoryIOUtil.readID(this.mStreamIn, this.mIdSize);
        int readBEInt = MemoryIOUtil.readBEInt(this.mStreamIn);
        int readBEInt2 = MemoryIOUtil.readBEInt(this.mStreamIn);
        int read = this.mStreamIn.read();
        BaseType type = BaseType.getType(read);
        if (type == null) {
            throw new IllegalStateException("accept primitive array failed, lost type def of typeId: " + read);
        }
        int size = type.getSize(this.mIdSize) * readBEInt2;
        byte[] bArr = new byte[size];
        MemoryIOUtil.readFully(this.mStreamIn, bArr, 0, size);
        hprofHeapDumpVisitorInterface.visitHeapDumpPrimitiveArray(i, readID, readBEInt, readBEInt2, read, bArr);
        return this.mIdSize + 4 + 4 + 1 + size;
    }

    private int acceptJniMonitor(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) throws IOException {
        hprofHeapDumpVisitorInterface.visitHeapDumpJniMonitor(MemoryIOUtil.readID(this.mStreamIn, this.mIdSize), MemoryIOUtil.readBEInt(this.mStreamIn), MemoryIOUtil.readBEInt(this.mStreamIn));
        return this.mIdSize + 4 + 4;
    }

    private int skipValue() throws IOException {
        int read = this.mStreamIn.read();
        BaseType type = BaseType.getType(read);
        if (type == null) {
            throw new IllegalStateException("failure to skip type, cannot find type def of typeid: " + read);
        }
        int size = type.getSize(this.mIdSize);
        MemoryIOUtil.skip(this.mStreamIn, size);
        return size + 1;
    }
}
