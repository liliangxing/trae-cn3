package com.bytedance.geckox.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: MD5Utils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bJ\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b\u000bJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0007J\"\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/geckox/utils/MD5Utils;", "", "()V", "HEX_CHARS", "", "check", "", "file", "Ljava/io/File;", "md5", "", "check$geckox_noasanRelease", "inputStream", "Ljava/io/InputStream;", "getHash", "hashType", "inStream", "getMD5", "getMD5$geckox_noasanRelease", "stringToMd5", "str", "toHexString", "bytes", "", "off", "", "len", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class MD5Utils {
    public static final MD5Utils INSTANCE = new MD5Utils();
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5Utils() {
    }

    public final String getMD5(InputStream inStream) throws Exception {
        Intrinsics.checkParameterIsNotNull(inStream, "inStream");
        return getHash(inStream, "MD5");
    }

    @JvmStatic
    public static final String stringToMd5(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkParameterIsNotNull(str, "str");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        return INSTANCE.toHexString(digest, 0, digest.length);
    }

    public final String getMD5$geckox_noasanRelease(File file) throws Exception {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return getHash(file, "MD5");
    }

    public final void check$geckox_noasanRelease(InputStream inputStream, String md5) throws Exception {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        if (md5 == null) {
            throw new RuntimeException("md5 check failed: md5 == null");
        }
        String md52 = getMD5(inputStream);
        if (!Intrinsics.areEqual(md52, md5)) {
            throw new RuntimeException("md5 check failed file: local md5:" + md52 + " expect md5:" + md5);
        }
    }

    public final void check$geckox_noasanRelease(File file, String md5) throws Exception {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!file.isFile() || md5 == null) {
            throw new RuntimeException("md5 check failed: file.isFile() == false || md5 == null");
        }
        String mD5$geckox_noasanRelease = getMD5$geckox_noasanRelease(file);
        if (!Intrinsics.areEqual(mD5$geckox_noasanRelease, md5)) {
            throw new RuntimeException("md5 check failed file:" + file.getPath() + ", local md5:" + mD5$geckox_noasanRelease + ", expect md5:" + md5);
        }
    }

    private final String getHash(File file, String hashType) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String hash = getHash(fileInputStream2, hashType);
                CloseableUtils.close(fileInputStream2);
                return hash;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                CloseableUtils.close(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final String getHash(InputStream inStream, String hashType) throws Exception {
        byte[] bArr = new byte[8192];
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(hashType);
                while (true) {
                    int read = inStream.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        byte[] digest = messageDigest.digest();
                        return toHexString(digest, 0, digest.length);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("getHash error: " + e.getMessage());
            }
        } finally {
            CloseableUtils.close(inStream);
        }
    }

    private final String toHexString(byte[] bytes, int off, int len) {
        if (bytes == null) {
            throw new NullPointerException("bytes is null");
        }
        if (off < 0 || off + len > bytes.length) {
            throw new IndexOutOfBoundsException();
        }
        int i = len * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < len; i3++) {
            int i4 = bytes[i3 + off] & UByte.MAX_VALUE;
            int i5 = i2 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }
}
