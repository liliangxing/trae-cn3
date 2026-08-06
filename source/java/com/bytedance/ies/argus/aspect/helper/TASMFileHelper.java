package com.bytedance.ies.argus.aspect.helper;

import android.util.Base64;
import android.util.Log;
import com.bytedance.ies.argus.bean.DigestAlgorithm;
import com.bytedance.ies.argus.bean.EncryptAlgorithm;
import com.bytedance.ies.argus.bean.SignAlgorithm;
import com.bytedance.ies.argus.bean.SignSuiteV2;
import com.bytedance.ies.argus.bean.TASMEncryptInfo;
import com.bytedance.ies.argus.bean.TASMVerifyType;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TASMFileHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ies/argus/aspect/helper/TASMFileHelper;", "", "()V", "APP_ID_BYTES", "", "SIGNATURE_LENGTH_BYTES", "SIGN_ALGORITHM_BYTES", "SIGN_SUITE_NUMBER_BYTES", "TOTAL_LENGTH_BYTES", "getRangeBytes", "", "bytes", "offset", "length", "parse", "Lcom/bytedance/ies/argus/bean/TASMEncryptInfo;", "byteArray", "parseAppId", "", "parseLittleEndian", "", "parseMagicNumber", "Lcom/bytedance/ies/argus/bean/TASMVerifyType;", "parseSignAlgorithm", "Lcom/bytedance/ies/argus/bean/SignAlgorithm;", "parseSignLength", "parseSignSuitesNum", "parseSignature", "parseTotalLength", "verifyFileBySign", "", "tasm", "file", "publicKey", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TASMFileHelper {
    private static final int APP_ID_BYTES = 8;
    public static final TASMFileHelper INSTANCE = new TASMFileHelper();
    private static final int SIGNATURE_LENGTH_BYTES = 4;
    private static final int SIGN_ALGORITHM_BYTES = 1;
    private static final int SIGN_SUITE_NUMBER_BYTES = 1;
    private static final int TOTAL_LENGTH_BYTES = 4;

    /* compiled from: TASMFileHelper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TASMVerifyType.values().length];
            try {
                iArr[TASMVerifyType.SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TASMFileHelper() {
    }

    public final TASMEncryptInfo parse(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        try {
            TASMVerifyType parseMagicNumber = parseMagicNumber(byteArray);
            if ((parseMagicNumber == null ? -1 : WhenMappings.$EnumSwitchMapping$0[parseMagicNumber.ordinal()]) == 1) {
                int parseSignSuitesNum = parseSignSuitesNum(byteArray);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (int i2 = 0; i2 < parseSignSuitesNum; i2++) {
                    byte[] parseSignature$default = parseSignature$default(this, byteArray, 0, 2, null);
                    arrayList.add(new SignSuiteV2(parseSignAlgorithm(byteArray, i), parseSignature$default));
                    i += parseSignature$default.length + 5;
                }
                return new TASMEncryptInfo(parseMagicNumber, parseTotalLength(byteArray), parseAppId(byteArray), Integer.valueOf(parseSignSuitesNum(byteArray)), arrayList);
            }
            return new TASMEncryptInfo(null, parseTotalLength(byteArray), null, null, null, 29, null);
        } catch (Exception e) {
            Log.e("lisheng", "tasm file parse error:" + e.getMessage());
            return null;
        }
    }

    public final boolean verifyFileBySign(TASMEncryptInfo tasm, byte[] file, String publicKey) {
        boolean z;
        Intrinsics.checkNotNullParameter(tasm, "tasm");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        List<SignSuiteV2> signSuites = tasm.getSignSuites();
        if (signSuites == null) {
            return false;
        }
        List<SignSuiteV2> list = signSuites;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (SignSuiteV2 signSuiteV2 : list) {
            if (DigestAlgorithm.SHA256 == signSuiteV2.getSignAlgorithm().getDigestAlgorithm() && EncryptAlgorithm.RSA == signSuiteV2.getSignAlgorithm().getEncryptAlgorithm()) {
                Signature signature = Signature.getInstance("SHA256withRSA");
                signature.initVerify(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(publicKey, 0))));
                signature.update(file, 4, (file.length - tasm.getTotalLength()) - 4);
                z = signature.verify(signSuiteV2.getSignature());
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private final TASMVerifyType parseMagicNumber(byte[] bytes) {
        return TASMVerifyType.INSTANCE.getType((int) parseLittleEndian$default(this, bytes, -4, 0, 4, null));
    }

    private final int parseTotalLength(byte[] bytes) {
        return (int) parseLittleEndian(bytes, -8, 4);
    }

    private final String parseAppId(byte[] bytes) {
        return String.valueOf(parseLittleEndian(bytes, -16, 8));
    }

    private final int parseSignSuitesNum(byte[] bytes) {
        return (int) parseLittleEndian(bytes, -17, 1);
    }

    static /* synthetic */ SignAlgorithm parseSignAlgorithm$default(TASMFileHelper tASMFileHelper, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return tASMFileHelper.parseSignAlgorithm(bArr, i);
    }

    private final SignAlgorithm parseSignAlgorithm(byte[] bytes, int offset) {
        return SignAlgorithm.INSTANCE.parse((byte) parseLittleEndian(bytes, (-18) - offset, 1));
    }

    static /* synthetic */ int parseSignLength$default(TASMFileHelper tASMFileHelper, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return tASMFileHelper.parseSignLength(bArr, i);
    }

    private final int parseSignLength(byte[] bytes, int offset) {
        return (int) parseLittleEndian(bytes, (-22) - offset, 4);
    }

    static /* synthetic */ byte[] parseSignature$default(TASMFileHelper tASMFileHelper, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return tASMFileHelper.parseSignature(bArr, i);
    }

    private final byte[] parseSignature(byte[] bytes, int offset) {
        int parseSignLength = parseSignLength(bytes, offset);
        return getRangeBytes(bytes, ((-22) - parseSignLength) - offset, parseSignLength);
    }

    private final byte[] getRangeBytes(byte[] bytes, int offset, int length) {
        if (offset < 0) {
            offset += bytes.length;
        }
        return ArraysKt.copyOfRange(bytes, offset, length + offset);
    }

    static /* synthetic */ long parseLittleEndian$default(TASMFileHelper tASMFileHelper, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        return tASMFileHelper.parseLittleEndian(bArr, i, i2);
    }

    private final long parseLittleEndian(byte[] bytes, int offset, int length) {
        if (offset < 0) {
            offset += bytes.length;
        }
        int i = offset + length;
        if (i > bytes.length || length < 0) {
            i = bytes.length;
        }
        long j = 0;
        for (int i2 = 0; i2 < i - offset; i2++) {
            j |= (bytes[offset + i2] & 255) << (i2 * 8);
        }
        return j;
    }
}
