package com.bytedance.trae.conversation.fileupload;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ResourceUploadUtil.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0000\u001a\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0000\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003¨\u0006 "}, d2 = {"TRAE_MAGIC_NUMBER_V1", "", "getTRAE_MAGIC_NUMBER_V1", "()[B", "TRAE_MAGIC_NUMBER_V2", "getTRAE_MAGIC_NUMBER_V2", "TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX", "getTRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX", "TRAE_XOR_KEY_V2", "getTRAE_XOR_KEY_V2", "hasMagicNumberV1", "", ReportConstant.COMMON_CONTENT, "stripMagicNumberV1", "getUploadMagicNumber", "enableMagic", "useV2", "calculateChecksums", "Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;", MessagePart.TYPE_FILE, "Ljava/io/File;", "decodeContent", "encoded", "findV2Magic", "Lcom/bytedance/trae/conversation/fileupload/V2MagicMatch;", "hasMagicAt", "offset", "", "magic", "urlEncode", "", "value", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ResourceUploadUtilKt {
    private static final byte[] TRAE_MAGIC_NUMBER_V1 = {-122, -82, -58, 27};
    private static final byte[] TRAE_MAGIC_NUMBER_V2 = {27, -58, -82, -122};
    private static final byte[] TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX = {0, 0, 0, 0, 27, -58, -82, -122};
    private static final byte[] TRAE_XOR_KEY_V2 = {-22, -97, -70, -58, -107, -55, -123, -22, -99, -119, 32, -31, -75, -69, -62, -89, 32, -22, -99, -119, -58, -107, -30, -126, -84, 32, -61, -97, -30, -126, -84, -62, -89, -22, -99, -119, 33};

    public static final byte[] getTRAE_MAGIC_NUMBER_V1() {
        return TRAE_MAGIC_NUMBER_V1;
    }

    public static final byte[] getTRAE_MAGIC_NUMBER_V2() {
        return TRAE_MAGIC_NUMBER_V2;
    }

    public static final byte[] getTRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX() {
        return TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX;
    }

    public static final byte[] getTRAE_XOR_KEY_V2() {
        return TRAE_XOR_KEY_V2;
    }

    public static final boolean hasMagicNumberV1(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, ReportConstant.COMMON_CONTENT);
        int length = bArr.length;
        byte[] bArr2 = TRAE_MAGIC_NUMBER_V1;
        if (length < bArr2.length) {
            return false;
        }
        int length2 = bArr2.length;
        for (int i = 0; i < length2; i++) {
            if (bArr[i] != TRAE_MAGIC_NUMBER_V1[i]) {
                return false;
            }
        }
        return true;
    }

    public static final byte[] stripMagicNumberV1(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, ReportConstant.COMMON_CONTENT);
        return !hasMagicNumberV1(bArr) ? bArr : ArraysKt.copyOfRange(bArr, TRAE_MAGIC_NUMBER_V1.length, bArr.length);
    }

    public static final byte[] getUploadMagicNumber(boolean z, boolean z2) {
        return !z ? new byte[0] : z2 ? TRAE_MAGIC_NUMBER_V2 : TRAE_MAGIC_NUMBER_V1;
    }

    public static /* synthetic */ ContentChecksums calculateChecksums$default(File file, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return calculateChecksums(file, z, z2);
    }

    public static final ContentChecksums calculateChecksums(File file, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        CRC32 crc32 = new CRC32();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] uploadMagicNumber = getUploadMagicNumber(z, z2);
        if (!(uploadMagicNumber.length == 0)) {
            crc32.update(uploadMagicNumber);
            messageDigest.update(uploadMagicNumber);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            byte[] bArr = new byte[FConstants.DOWNLOAD_BUFFER_SIZE];
            long j = 0;
            while (true) {
                int read = fileInputStream2.read(bArr);
                if (read > 0) {
                    if (z2 && z) {
                        for (int i = 0; i < read; i++) {
                            bArr[i] = (byte) (bArr[i] ^ TRAE_XOR_KEY_V2[(int) (j % r13.length)]);
                            j++;
                        }
                    }
                    crc32.update(bArr, 0, read);
                    messageDigest.update(bArr, 0, read);
                    if (!z2 || !z) {
                        j += read;
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                    String hexString = Long.toHexString(crc32.getValue());
                    byte[] digest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                    String joinToString$default = ArraysKt.joinToString$default(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            CharSequence calculateChecksums$lambda$1;
                            calculateChecksums$lambda$1 = ResourceUploadUtilKt.calculateChecksums$lambda$1(((Byte) obj).byteValue());
                            return calculateChecksums$lambda$1;
                        }
                    }, 30, (Object) null);
                    long length = file.length() + uploadMagicNumber.length;
                    Intrinsics.checkNotNull(hexString);
                    return new ContentChecksums(hexString, joinToString$default, length);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence calculateChecksums$lambda$1(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final byte[] decodeContent(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "encoded");
        V2MagicMatch findV2Magic = findV2Magic(bArr);
        if (findV2Magic == null) {
            return hasMagicNumberV1(bArr) ? stripMagicNumberV1(bArr) : bArr;
        }
        byte[] copyOfRange = ArraysKt.copyOfRange(bArr, findV2Magic.getPayloadOffset(), bArr.length);
        int length = copyOfRange.length;
        for (int i = 0; i < length; i++) {
            copyOfRange[i] = (byte) (copyOfRange[i] ^ TRAE_XOR_KEY_V2[(int) (i % r3.length)]);
        }
        return copyOfRange;
    }

    private static final V2MagicMatch findV2Magic(byte[] bArr) {
        byte[] bArr2 = TRAE_MAGIC_NUMBER_V2_WITH_ZERO_PREFIX;
        if (hasMagicAt(bArr, 0, bArr2)) {
            return new V2MagicMatch(bArr2.length);
        }
        byte[] bArr3 = TRAE_MAGIC_NUMBER_V2;
        if (hasMagicAt(bArr, 0, bArr3)) {
            return new V2MagicMatch(bArr3.length);
        }
        return null;
    }

    private static final boolean hasMagicAt(byte[] bArr, int i, byte[] bArr2) {
        if (bArr.length < bArr2.length + i) {
            return false;
        }
        return Arrays.equals(ArraysKt.copyOfRange(bArr, i, bArr2.length + i), bArr2);
    }

    public static final String urlEncode(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        String encode = URLEncoder.encode(str, "UTF-8");
        Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
        return encode;
    }
}
