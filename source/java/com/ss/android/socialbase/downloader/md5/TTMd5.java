package com.ss.android.socialbase.downloader.md5;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;
import kotlin.UByte;

/* loaded from: classes7.dex */
public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String PROTOCOL = "ttmd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface CHECK_MD5_STATUS {
        public static final int FILE_NOT_EXIST = 5;
        public static final int GET_FILE_MD5_ERROR = 6;
        public static final int MD5_EMPTY = 2;
        public static final int MD5_MATCH = 0;
        public static final int MD5_NOT_MATCH = 1;
        public static final int TTMD5_TAG_PARSER_ERROR = 4;
        public static final int TTMD5_VERSION_NOT_SUPPORT = 3;
        public static final int UNKNOWN_ERROR = 99;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class FileRandomAccess implements IRandomAccess {
        private final RandomAccessFile accessFile;

        public FileRandomAccess(File file) throws FileNotFoundException {
            this.accessFile = new RandomAccessFile(file, DownloadFileUtils.MODE_READ);
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public long length() throws IOException {
            return this.accessFile.length();
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return this.accessFile.read(bArr, i, i2);
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public void seek(long j, long j2) throws IOException {
            this.accessFile.seek(j);
        }

        @Override // com.ss.android.socialbase.downloader.md5.IRandomAccess
        public void close() throws IOException {
            this.accessFile.close();
        }
    }

    public static String ttmd5(File file) {
        return ttmd5(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(File file, int i) {
        return ttmd5(file, i, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return _ttmd5(file, i, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static String md5(File file) {
        return ttmd5(file, -1, -1L);
    }

    public static String ttmd5(IRandomAccess iRandomAccess) {
        return ttmd5(iRandomAccess, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i) {
        return ttmd5(iRandomAccess, i, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i, long j) {
        if (iRandomAccess == null) {
            return "";
        }
        try {
            return _ttmd5(iRandomAccess, i, j);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int checkMd5(String str, File file) {
        return checkMd5(str, file, null);
    }

    public static int checkMd5(String str, File file, IRandomAccess iRandomAccess) {
        int i;
        long j;
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (iRandomAccess != null) {
                if (iRandomAccess.length() <= 0) {
                    try {
                        iRandomAccess.close();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                TTMd5Args parserTTMd5Args = parserTTMd5Args(str);
                if (parserTTMd5Args == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (parserTTMd5Args.versionMain > 1) {
                        return 3;
                    }
                    i = parserTTMd5Args.sampleCount;
                    j = parserTTMd5Args.sampleSize;
                }
                TTMd5Args tTMd5Args = null;
                try {
                    if (iRandomAccess != null) {
                        str2 = _ttmd5(iRandomAccess, i, j);
                    } else {
                        str2 = _ttmd5(file, i, j);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (parserTTMd5Args != null && (parserTTMd5Args.versionMain != 1 || parserTTMd5Args.versionSub != 1)) {
                        if (parserTTMd5Args.realMd5 != null) {
                            try {
                                tTMd5Args = parserTTMd5Args(str2);
                            } catch (Throwable unused2) {
                            }
                            if (tTMd5Args != null && parserTTMd5Args.sampleCount == tTMd5Args.sampleCount && parserTTMd5Args.sampleSize == tTMd5Args.sampleSize && parserTTMd5Args.realMd5.equals(tTMd5Args.realMd5)) {
                                return 0;
                            }
                        }
                    }
                    return str2.equals(str) ? 0 : 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    public static int checkMd5(File file, File file2) {
        if (file == null || file2 == null) {
            return 5;
        }
        try {
            if (file.exists() && file2.exists()) {
                if (file == file2) {
                    return 0;
                }
                return _ttmd5(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI).equals(_ttmd5(file2, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) ? 0 : 1;
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 99;
        }
    }

    private static String _ttmd5(File file, int i, long j) throws Exception {
        return _ttmd5(new FileRandomAccess(file), i, j);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|(6:13|14|(3:16|(1:18)|19)|(1:21)|22|(4:31|32|33|34)(3:26|27|28))|38|14|(0)|(0)|22|(1:24)|31|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[Catch: all -> 0x009d, TryCatch #3 {all -> 0x009d, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002d, B:16:0x003f, B:18:0x004b, B:21:0x0062, B:22:0x006c, B:31:0x007e), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[Catch: all -> 0x009d, TryCatch #3 {all -> 0x009d, blocks: (B:6:0x000d, B:10:0x001a, B:14:0x002d, B:16:0x003f, B:18:0x004b, B:21:0x0062, B:22:0x006c, B:31:0x007e), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String _ttmd5(IRandomAccess iRandomAccess, int i, long j) throws Exception {
        long j2;
        String hexString;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long length = iRandomAccess.length();
            if (i2 > 0 && j > 0 && i2 * j <= (8 * length) / 10) {
                j2 = j;
                byte[] bArr = new byte[8192];
                long j3 = 0;
                updateSample(iRandomAccess, messageDigest, bArr, 0L, j2);
                if (i2 > 2) {
                    int i3 = i2 - 1;
                    long j4 = (length - (i2 * j2)) / i3;
                    int i4 = 1;
                    while (i4 < i3) {
                        j3 += j2 + j4;
                        updateSample(iRandomAccess, messageDigest, bArr, j3, j2);
                        i4++;
                        i3 = i3;
                    }
                }
                if (i2 > 1) {
                    updateSample(iRandomAccess, messageDigest, bArr, length - j2, j2);
                }
                hexString = toHexString(messageDigest.digest());
                if (i2 != 1 && j2 == length) {
                    return hexString;
                }
                String str = generateTTMd5Tag(i2, j2) + ";" + hexString;
                iRandomAccess.close();
                return str;
            }
            j2 = length;
            i2 = 1;
            byte[] bArr2 = new byte[8192];
            long j32 = 0;
            updateSample(iRandomAccess, messageDigest, bArr2, 0L, j2);
            if (i2 > 2) {
            }
            if (i2 > 1) {
            }
            hexString = toHexString(messageDigest.digest());
            if (i2 != 1) {
            }
            String str2 = generateTTMd5Tag(i2, j2) + ";" + hexString;
            iRandomAccess.close();
            return str2;
        } finally {
            try {
                iRandomAccess.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void updateSample(IRandomAccess iRandomAccess, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        iRandomAccess.seek(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int read = iRandomAccess.read(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (read <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + read + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, read);
            j3 += read;
        }
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & UByte.MAX_VALUE;
            int i5 = i2 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String generateTTMd5Tag(int i, long j) {
        return "ttmd5:1:1:" + encryptionNum(i) + "g" + encryptionNum(j);
    }

    private static TTMd5Args parserTTMd5Args(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(Constants.COLON_SEPARATOR);
        TTMd5Args tTMd5Args = new TTMd5Args();
        tTMd5Args.versionMain = Integer.parseInt(split2[1]);
        if (tTMd5Args.versionMain > 1) {
            return tTMd5Args;
        }
        tTMd5Args.versionSub = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split("g");
        tTMd5Args.sampleCount = (int) decryptNum(split3[0]);
        tTMd5Args.sampleSize = decryptNum(split3[1]);
        tTMd5Args.realMd5 = split[1];
        return tTMd5Args;
    }

    private static String encryptionNum(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long decryptNum(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class TTMd5Args {
        private String realMd5;
        private int sampleCount;
        private long sampleSize;
        private int versionMain;
        private int versionSub;

        private TTMd5Args() {
        }
    }
}
