package org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class CertificateID {
    public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);

    /* renamed from: id */
    private final CertID f588id;

    public CertificateID(CertID certID) {
        if (certID == null) {
            throw new IllegalArgumentException("'id' cannot be null");
        }
        this.f588id = certID;
    }

    public CertificateID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) throws OCSPException {
        this.f588id = createCertID(digestCalculator, x509CertificateHolder, new ASN1Integer(bigInteger));
    }

    private static CertID createCertID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, ASN1Integer aSN1Integer) throws OCSPException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(x509CertificateHolder.toASN1Structure().getSubject().getEncoded(ASN1Encoding.DER));
            outputStream.close();
            DEROctetString dEROctetString = new DEROctetString(digestCalculator.getDigest());
            SubjectPublicKeyInfo subjectPublicKeyInfo = x509CertificateHolder.getSubjectPublicKeyInfo();
            OutputStream outputStream2 = digestCalculator.getOutputStream();
            outputStream2.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            outputStream2.close();
            return new CertID(digestCalculator.getAlgorithmIdentifier(), dEROctetString, new DEROctetString(digestCalculator.getDigest()), aSN1Integer);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.f588id.getHashAlgorithm(), certificateID.f588id.getIssuerNameHash(), certificateID.f588id.getIssuerKeyHash(), new ASN1Integer(bigInteger)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificateID) {
            return this.f588id.toASN1Primitive().equals(((CertificateID) obj).f588id.toASN1Primitive());
        }
        return false;
    }

    public ASN1ObjectIdentifier getHashAlgOID() {
        return this.f588id.getHashAlgorithm().getAlgorithm();
    }

    public byte[] getIssuerKeyHash() {
        return this.f588id.getIssuerKeyHash().getOctets();
    }

    public byte[] getIssuerNameHash() {
        return this.f588id.getIssuerNameHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.f588id.getSerialNumber().getValue();
    }

    public int hashCode() {
        return this.f588id.toASN1Primitive().hashCode();
    }

    public boolean matchesIssuer(X509CertificateHolder x509CertificateHolder, DigestCalculatorProvider digestCalculatorProvider) throws OCSPException {
        try {
            return createCertID(digestCalculatorProvider.get(this.f588id.getHashAlgorithm()), x509CertificateHolder, this.f588id.getSerialNumber()).equals(this.f588id);
        } catch (OperatorCreationException e) {
            throw new OCSPException("unable to create digest calculator: " + e.getMessage(), e);
        }
    }

    public CertID toASN1Primitive() {
        return this.f588id;
    }
}
