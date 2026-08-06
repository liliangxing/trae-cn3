package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f496a;

    /* renamed from: b */
    ASN1Integer f497b;

    /* renamed from: p */
    ASN1Integer f498p;

    /* renamed from: q */
    ASN1Integer f499q;

    /* renamed from: x */
    ASN1Integer f500x;

    /* renamed from: y */
    ASN1Integer f501y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f496a = new ASN1Integer(bigInteger);
        this.f497b = new ASN1Integer(bigInteger2);
        this.f498p = new ASN1Integer(bigInteger3);
        this.f499q = new ASN1Integer(bigInteger4);
        this.f500x = new ASN1Integer(i);
        this.f501y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f496a = (ASN1Integer) objects.nextElement();
        this.f497b = (ASN1Integer) objects.nextElement();
        this.f498p = (ASN1Integer) objects.nextElement();
        this.f499q = (ASN1Integer) objects.nextElement();
        this.f500x = (ASN1Integer) objects.nextElement();
        this.f501y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.f496a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f498p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f499q.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.f496a);
        aSN1EncodableVector.add(this.f497b);
        aSN1EncodableVector.add(this.f498p);
        aSN1EncodableVector.add(this.f499q);
        aSN1EncodableVector.add(this.f500x);
        aSN1EncodableVector.add(this.f501y);
        return new DERSequence(aSN1EncodableVector);
    }
}
