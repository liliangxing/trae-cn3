package org.bouncycastle.jcajce.provider.asymmetric.p007dh;

import java.math.BigInteger;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Fingerprint;
import org.bouncycastle.util.Strings;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
class DHUtil {
    DHUtil() {
    }

    private static String generateKeyFingerprint(BigInteger bigInteger, DHParameters dHParameters) {
        return new Fingerprint(Arrays.concatenate(bigInteger.toByteArray(), dHParameters.getP().toByteArray(), dHParameters.getG().toByteArray())).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String privateKeyToString(String str, BigInteger bigInteger, DHParameters dHParameters) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        BigInteger modPow = dHParameters.getG().modPow(bigInteger, dHParameters.getP());
        stringBuffer.append(str);
        stringBuffer.append(" Private Key [").append(generateKeyFingerprint(modPow, dHParameters)).append("]").append(lineSeparator);
        stringBuffer.append("              Y: ").append(modPow.toString(16)).append(lineSeparator);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String publicKeyToString(String str, BigInteger bigInteger, DHParameters dHParameters) {
        StringBuffer stringBuffer = new StringBuffer();
        String lineSeparator = Strings.lineSeparator();
        stringBuffer.append(str);
        stringBuffer.append(" Public Key [").append(generateKeyFingerprint(bigInteger, dHParameters)).append("]").append(lineSeparator);
        stringBuffer.append("             Y: ").append(bigInteger.toString(16)).append(lineSeparator);
        return stringBuffer.toString();
    }
}
