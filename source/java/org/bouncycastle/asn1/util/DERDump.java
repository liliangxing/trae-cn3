package org.bouncycastle.asn1.util;

import net.openid.appauth.BuildConfig;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class DERDump extends ASN1Dump {
    public static String dumpAsString(ASN1Encodable aSN1Encodable) {
        StringBuffer stringBuffer = new StringBuffer();
        _dumpAsString(BuildConfig.FLAVOR, false, aSN1Encodable.toASN1Primitive(), stringBuffer);
        return stringBuffer.toString();
    }

    public static String dumpAsString(ASN1Primitive aSN1Primitive) {
        StringBuffer stringBuffer = new StringBuffer();
        _dumpAsString(BuildConfig.FLAVOR, false, aSN1Primitive, stringBuffer);
        return stringBuffer.toString();
    }
}
