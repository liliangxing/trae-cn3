package com.bytedance.gkfs.io;

import com.bytedance.gkfs.GkFSLogger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta_io.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFileHeaderReader;", "", "()V", "read", "Lkotlin/Pair;", "Lcom/bytedance/gkfs/io/GkFSHeaderMeta;", "Lcom/bytedance/gkfs/io/GkFSChunkMetaDecoder;", "inputStream", "Ljava/io/InputStream;", "logger", "Lcom/bytedance/gkfs/GkFSLogger;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSFileHeaderReader {
    public static final GkFSFileHeaderReader INSTANCE = new GkFSFileHeaderReader();

    private GkFSFileHeaderReader() {
    }

    public final Pair<GkFSHeaderMeta, GkFSChunkMetaDecoder> read(InputStream inputStream, GkFSLogger logger) throws IOException {
        char[] cArr;
        long readULong;
        short readUShort;
        char readChar;
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        byte[] bArr = new byte[15];
        int read = inputStream.read(bArr);
        if (read < 15) {
            throw new IOException("read header meta failed, except  15 but received " + read);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        cArr = Meta_ioKt.MAGIC_NUMBER;
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            char c = cArr[i];
            readChar = Meta_ioKt.readChar(byteArrayInputStream);
            if (readChar != c) {
                throw new IOException("Read unexpected magic number value " + readChar + " in index " + i + ", " + c + " is correct!");
            }
        }
        int read2 = byteArrayInputStream.read();
        if (read2 < 1) {
            throw new IOException("Minimum version of SDK be able to support is 1, but file version is " + read2);
        }
        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
        readULong = Meta_ioKt.readULong(byteArrayInputStream2);
        if (readULong > 0) {
            readUShort = Meta_ioKt.readUShort(byteArrayInputStream2);
            int i2 = readUShort & 65535;
            if (i2 <= 0) {
                throw new IOException("Invalid chunk count " + i2 + '!');
            }
            int i3 = i2 * 44;
            byte[] bArr2 = new byte[i3];
            int read3 = inputStream.read(bArr2);
            if (read3 < i3) {
                throw new IOException("read chunks info failed, except " + i3 + " but received " + read3);
            }
            return TuplesKt.to(new GkFSHeaderMeta(read2, readULong, 15 + i3), new GkFSChunkMetaDecoder(bArr2, i2, logger));
        }
        throw new IOException("origin size from header is " + readULong + '!');
    }
}
