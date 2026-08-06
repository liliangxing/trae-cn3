package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class CertificateBase extends ASN1Object {
    private CertificateType type;
    private byte[] version;

    /* JADX INFO: Access modifiers changed from: protected */
    public CertificateBase(ASN1Sequence aSN1Sequence) {
    }

    public static CertificateBase getInstance(Object obj) {
        if (obj instanceof ImplicitCertificate) {
            return (ImplicitCertificate) obj;
        }
        if (obj instanceof ExplicitCertificate) {
            return (ExplicitCertificate) obj;
        }
        if (obj == null) {
            return null;
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(obj);
        if (aSN1Sequence.getObjectAt(1).equals(CertificateType.Implicit)) {
            return ImplicitCertificate.getInstance(aSN1Sequence);
        }
        if (aSN1Sequence.getObjectAt(1).equals(CertificateType.Explicit)) {
            return ExplicitCertificate.getInstance(aSN1Sequence);
        }
        throw new IllegalArgumentException("unknown certificate type");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1EncodableVector());
    }
}
