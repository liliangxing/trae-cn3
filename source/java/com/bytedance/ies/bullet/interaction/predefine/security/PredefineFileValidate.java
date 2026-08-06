package com.bytedance.ies.bullet.interaction.predefine.security;

import android.text.TextUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: PredefineFileValidate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate;", "", "()V", "convertValidateType", "Lcom/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate$TypeEnum;", "type", "", "getFileSignature", "file", "Ljava/io/File;", "typeEnum", "signType", "getFileSignatureBySize", "validateFile", "", "standardStr", "fileToCheck", "TypeEnum", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PredefineFileValidate {
    public static final PredefineFileValidate INSTANCE = new PredefineFileValidate();

    /* compiled from: PredefineFileValidate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate$TypeEnum;", "", "(Ljava/lang/String;I)V", "MD5", "SHA256", "SIZE_SHA256", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum TypeEnum {
        MD5,
        SHA256,
        SIZE_SHA256
    }

    /* compiled from: PredefineFileValidate.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypeEnum.values().length];
            try {
                iArr[TypeEnum.MD5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeEnum.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypeEnum.SIZE_SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PredefineFileValidate() {
    }

    public final TypeEnum convertValidateType(String type) {
        if (Intrinsics.areEqual(type, "sha256")) {
            return TypeEnum.SHA256;
        }
        if (Intrinsics.areEqual(type, "md5")) {
            return TypeEnum.MD5;
        }
        if (Intrinsics.areEqual(type, "size_sha256")) {
            return TypeEnum.SIZE_SHA256;
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "type " + type + " not support", null, null, 12, null);
        return null;
    }

    public final boolean validateFile(TypeEnum typeEnum, String standardStr, File fileToCheck) {
        Intrinsics.checkNotNullParameter(typeEnum, "typeEnum");
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(standardStr) || fileToCheck == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "MD5 string empty or updateFile null", null, null, 12, null);
            return false;
        }
        String fileSignature = getFileSignature(fileToCheck, typeEnum);
        if (TextUtils.isEmpty(fileSignature)) {
            HybridLogger.d$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "calculatedDigest null", null, null, 12, null);
            return false;
        }
        boolean equals = StringsKt.equals(fileSignature, standardStr, true);
        HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "validateFile result " + equals, MapsKt.mapOf(new Pair[]{TuplesKt.to("standardStr", standardStr), TuplesKt.to("result", Boolean.valueOf(equals)), TuplesKt.to(LynxTimingPerformanceReportProcessor.KEY_DURATION, Long.valueOf(System.currentTimeMillis() - currentTimeMillis))}), null, 8, null);
        return equals;
    }

    private final String getFileSignature(File file, TypeEnum typeEnum) {
        String fileSignature;
        int i = WhenMappings.$EnumSwitchMapping$0[typeEnum.ordinal()];
        if (i == 1) {
            fileSignature = getFileSignature(file, "MD5");
        } else if (i == 2) {
            fileSignature = getFileSignature(file, "SHA-256");
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            fileSignature = getFileSignatureBySize(file, "SHA-256");
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "fileSignature call", MapsKt.mapOf(new Pair[]{TuplesKt.to("res", fileSignature), TuplesKt.to("type", typeEnum.name())}), null, 8, null);
        return fileSignature;
    }

    private final String getFileSignature(File file, String signType) {
        MessageDigest messageDigest;
        int i;
        try {
            messageDigest = MessageDigest.getInstance(signType);
            Intrinsics.checkNotNullExpressionValue(messageDigest, "{\n            MessageDig…tance(signType)\n        }");
        } catch (NoSuchAlgorithmException unused) {
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[8192];
                    int read = fileInputStream.read(bArr);
                    while (true) {
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                        read = fileInputStream.read(bArr);
                    }
                    byte[] digest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        int i2 = b & 255;
                        if (i2 < 16) {
                            sb.append(ViewVisibleBridge.INVISIBLE);
                        }
                        sb.append(Integer.toHexString(i2));
                    }
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception on closing input stream", null, null, 12, null);
                    }
                    return sb2;
                } catch (IOException unused3) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Unable to process file ", null, null, 12, null);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception on closing input stream", null, null, 12, null);
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception on closing input stream", null, null, 12, null);
                }
                throw th;
            }
        } catch (FileNotFoundException unused6) {
            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception while getting FileInputStream", null, null, 12, null);
            return null;
        }
    }

    private final String getFileSignatureBySize(File file, String signType) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(signType);
            Intrinsics.checkNotNullExpressionValue(messageDigest, "{\n            MessageDig…tance(signType)\n        }");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    try {
                        String valueOf = String.valueOf(fileInputStream.getChannel().size());
                        Charset charset = Charsets.UTF_8;
                        if (valueOf == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        byte[] bytes = valueOf.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        messageDigest.update(bytes);
                        byte[] digest = messageDigest.digest();
                        Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            int i = b & 255;
                            if (i < 16) {
                                sb.append(ViewVisibleBridge.INVISIBLE);
                            }
                            sb.append(Integer.toHexString(i));
                        }
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception on closing input stream", null, null, 12, null);
                        }
                        return sb2;
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                            HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception on closing input stream", null, null, 12, null);
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Unable to process file ", null, null, 12, null);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception on closing input stream", null, null, 12, null);
                    }
                    return null;
                }
            } catch (FileNotFoundException unused5) {
                HybridLogger.e$default(HybridLogger.INSTANCE, HybridLoggerConst.MODULE_PREDEFINE, "Exception while getting FileInputStream", null, null, 12, null);
                return null;
            }
        } catch (NoSuchAlgorithmException unused6) {
        }
    }
}
