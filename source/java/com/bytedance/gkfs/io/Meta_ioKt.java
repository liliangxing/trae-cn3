package com.bytedance.gkfs.io;

import com.bytedance.apm6.cpu.collect.ProcessCpuTracer;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta_io.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\fH\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002\u001a\u0014\u0010\u001d\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002\u001a\u0014\u0010\u001f\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010 \u001a\u00020\u0003H\u0002\u001a\u0014\u0010!\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010 \u001a\u00020\u0003H\u0002\u001a\u0014\u0010\"\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002\u001a\u0014\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010 \u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"GKFS_FILE_EXTENSION", "", "GKFS_VERSION", "", "MAGIC_NUMBER", "", "MIN_SUPPORT_GKFS_VERSION", "read", "", "pos", "readChar", "", "Ljava/io/InputStream;", "readChunkId", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "readUInt", "Lkotlin/UInt;", "(Ljava/io/InputStream;)I", "([BI)I", "readULong", "Lkotlin/ULong;", "(Ljava/io/InputStream;)J", "readUShort", "Lkotlin/UShort;", "(Ljava/io/InputStream;)S", "writeChar", "", "Ljava/io/OutputStream;", "c", "writeChunkId", "id", "writeUChar", "i", "writeUInt", "writeULong", "l", "", "writeUShort", "geckox_noasanRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Meta_ioKt {
    public static final String GKFS_FILE_EXTENSION = ".gkfsf";
    public static final int GKFS_VERSION = 1;
    private static final char[] MAGIC_NUMBER = {'G', 'K', 'F', 'S'};
    private static final int MIN_SUPPORT_GKFS_VERSION = 1;

    private static final int read(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final char readChar(InputStream inputStream) {
        return (char) inputStream.read();
    }

    private static final char readChar(byte[] bArr, int i) {
        return (char) read(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final short readUShort(InputStream inputStream) {
        return UShort.constructor-impl((short) UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 8) + UInt.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int readUInt(InputStream inputStream) {
        return UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 24) + UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 16)) + UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 8)) + UInt.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int readUInt(byte[] bArr, int i) {
        return UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) read(bArr, i)) & 255) << 24) + UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) read(bArr, i + 1)) & 255) << 16)) + UInt.constructor-impl(UInt.constructor-impl(UByte.constructor-impl((byte) read(bArr, i + 2)) & 255) << 8)) + UInt.constructor-impl(UByte.constructor-impl((byte) read(bArr, i + 3)) & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long readULong(InputStream inputStream) {
        return ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 56) + ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 48)) + ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 40)) + ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 32)) + ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 24)) + ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 16)) + ULong.constructor-impl(ULong.constructor-impl(UByte.constructor-impl((byte) inputStream.read()) & 255) << 8)) + ULong.constructor-impl(255 & UByte.constructor-impl((byte) inputStream.read())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChunkIdentifier readChunkId(InputStream inputStream) {
        StringBuilder sb = new StringBuilder(40);
        for (int i = 0; i < 40; i++) {
            sb.append(readChar(inputStream));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return new ChunkIdentifier(sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChunkIdentifier readChunkId(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(40);
        for (int i2 = 0; i2 < 40; i2++) {
            sb.append(readChar(bArr, i + i2));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return new ChunkIdentifier(sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeChar(OutputStream outputStream, char c) {
        outputStream.write(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeUChar(OutputStream outputStream, int i) {
        outputStream.write(i & ProcessCpuTracer.PROC_TERM_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeUShort(OutputStream outputStream, int i) {
        outputStream.write(new byte[]{(byte) (i >>> 8), (byte) i});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeUInt(OutputStream outputStream, int i) {
        outputStream.write(new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeULong(OutputStream outputStream, long j) {
        outputStream.write(new byte[]{(byte) (j >>> 56), (byte) (j >>> 48), (byte) (j >>> 40), (byte) (j >>> 32), (byte) (j >>> 24), (byte) (j >>> 16), (byte) (j >>> 8), (byte) j});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeChunkId(OutputStream outputStream, ChunkIdentifier chunkIdentifier) {
        String value = chunkIdentifier.getValue();
        if (value == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        char[] charArray = value.toCharArray();
        Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
        for (char c : charArray) {
            writeChar(outputStream, c);
        }
    }
}
