package com.unicom.online.account.kernel;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

/* renamed from: com.unicom.online.account.kernel.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1180l {

    /* renamed from: a */
    private static final byte[] f287a = "1234567812345678".getBytes();

    static {
        System.setProperty("org.bouncycastle.asn1.allow_unsafe_integer", "true");
    }

    /* renamed from: a */
    public static C1180l m540a() {
        return new C1180l();
    }

    /* renamed from: a */
    public static byte[] m541a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new C1183o(EnumC1178j.E10400);
        }
        if (bArr2 == null) {
            throw new C1183o(EnumC1178j.E10400);
        }
        if (bArr2.length == 0) {
            throw new C1183o(EnumC1178j.E10415);
        }
        if (bArr.length != 65) {
            throw new C1183o(EnumC1178j.E10417);
        }
        if (bArr[0] != 4) {
            throw new C1183o(EnumC1178j.E10403);
        }
        try {
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = new byte[32];
            System.arraycopy(bArr, 1, bArr3, 0, 32);
            System.arraycopy(bArr, 33, bArr4, 0, 32);
            ECPoint createPoint = ECNamedCurveTable.getParameterSpec("sm2p256v1").getCurve().createPoint(new BigInteger(1, bArr3), new BigInteger(1, bArr4));
            ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("sm2p256v1");
            ECPublicKeyParameters eCPublicKeyParameters = new ECPublicKeyParameters(createPoint, new ECDomainParameters(parameterSpec.getCurve(), parameterSpec.getG(), parameterSpec.getN(), parameterSpec.getH(), parameterSpec.getSeed()));
            SM2Engine sM2Engine = new SM2Engine();
            sM2Engine.init(true, new ParametersWithRandom(eCPublicKeyParameters, new SecureRandom()));
            try {
                byte[] processBlock = sM2Engine.processBlock(bArr2, 0, bArr2.length);
                if (processBlock == null || processBlock.length < 97) {
                    throw new C1183o(EnumC1178j.E10406);
                }
                byte[] bArr5 = new byte[processBlock.length];
                System.arraycopy(processBlock, 0, bArr5, 0, 65);
                System.arraycopy(processBlock, processBlock.length - 32, bArr5, 65, 32);
                System.arraycopy(processBlock, 65, bArr5, 97, processBlock.length - 97);
                return bArr5;
            } catch (InvalidCipherTextException e) {
                throw new C1183o(EnumC1178j.E10200, e);
            }
        } catch (Exception unused) {
            throw new C1183o(EnumC1178j.E10416);
        }
    }
}
