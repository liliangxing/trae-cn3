package org.bouncycastle.asn1.p003x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f */
    protected ECFieldElement f585f;

    public X9FieldElement(int i, int i2, int i3, int i4, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i, i2, i3, i4, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.C0564Fp(bigInteger, new BigInteger(1, aSN1OctetString.getOctets())));
    }

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f585f = eCFieldElement;
    }

    public ECFieldElement getValue() {
        return this.f585f;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f585f.toBigInteger(), converter.getByteLength(this.f585f)));
    }
}
