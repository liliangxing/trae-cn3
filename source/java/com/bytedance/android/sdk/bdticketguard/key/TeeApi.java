package com.bytedance.android.sdk.bdticketguard.key;

import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.bdturing.setting.SettingsManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.bytedance.zdplib.Delta;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

/* compiled from: TeeKeyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0007J0\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J0\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0014H\u0007J \u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0007¨\u0006$"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/key/TeeApi;", "", "()V", "containsAlias", "", "keystoreAlias", "", "sp", "Landroid/content/SharedPreferences;", "spKeyPublic", "spKeyPrivate", "genCsr", "keyPair", "Ljava/security/KeyPair;", "principal", "genKeyPair", "editor", "Landroid/content/SharedPreferences$Editor;", "isKeyMatch", "cert", "", "privateKey", "Ljava/security/PrivateKey;", "loadKeyPair", "parse04PublicKey", "ecPublicKey", "Ljava/security/interfaces/ECPublicKey;", "parseBase64PublicKey", "parseCertificate", "Ljava/security/cert/X509Certificate;", TicketGuardProviderKt.PATH_SIGN, "data", SettingsManager.VERIFY_SERVICE, "certificate", "Ljava/security/cert/Certificate;", "signature", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TeeApi {
    public static final TeeApi INSTANCE = new TeeApi();

    private TeeApi() {
    }

    @JvmStatic
    public static final KeyPair genKeyPair(String keystoreAlias, SharedPreferences.Editor editor, String spKeyPublic, String spKeyPrivate) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Intrinsics.checkParameterIsNotNull(editor, "editor");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(TeeKeyHelperKt.KEY_PAIR_ALGORITHM, TeeKeyHelperKt.KEY_STORE_PROVIDER_ANDROID);
        Intrinsics.checkExpressionValueIsNotNull(keyPairGenerator, "KeyPairGenerator.getInst…Y_STORE_PROVIDER_ANDROID)");
        if (keystoreAlias == null) {
            Intrinsics.throwNpe();
        }
        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(keystoreAlias, 4).setDigests("SHA-256").build());
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        Intrinsics.checkExpressionValueIsNotNull(generateKeyPair, "keyGen.generateKeyPair()");
        return generateKeyPair;
    }

    @JvmStatic
    public static final String genCsr(KeyPair keyPair, String principal) throws OperatorCreationException, IOException {
        Intrinsics.checkParameterIsNotNull(keyPair, "keyPair");
        ContentSigner build = new JcaContentSignerBuilder(TeeKeyHelperKt.SIGNATURE_ALGORITHM).build(keyPair.getPrivate());
        PKCS10CertificationRequestBuilder jcaPKCS10CertificationRequestBuilder = new JcaPKCS10CertificationRequestBuilder(new X500Name(principal), keyPair.getPublic());
        ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
        extensionsGenerator.addExtension(Extension.basicConstraints, true, new BasicConstraints(true));
        jcaPKCS10CertificationRequestBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extensionsGenerator.generate());
        PKCS10CertificationRequest build2 = jcaPKCS10CertificationRequestBuilder.build(build);
        Intrinsics.checkExpressionValueIsNotNull(build2, TicketGuardProviderKt.COL_CSR);
        PemObjectGenerator pemObject = new PemObject("CERTIFICATE REQUEST", build2.getEncoded());
        StringWriter stringWriter = new StringWriter();
        PemWriter pemWriter = new PemWriter(stringWriter);
        pemWriter.writeObject(pemObject);
        pemWriter.close();
        stringWriter.close();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }

    @JvmStatic
    public static final boolean containsAlias(String keystoreAlias, SharedPreferences sp, String spKeyPublic, String spKeyPrivate) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        Intrinsics.checkParameterIsNotNull(sp, "sp");
        KeyStore keyStore = KeyStore.getInstance(TeeKeyHelperKt.KEY_STORE_PROVIDER_ANDROID);
        keyStore.load(null);
        return keyStore.containsAlias(keystoreAlias);
    }

    @JvmStatic
    public static final KeyPair loadKeyPair(String keystoreAlias, SharedPreferences sp, String spKeyPublic, String spKeyPrivate) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableEntryException, InvalidKeySpecException {
        PrivateKey privateKey;
        PublicKey publicKey;
        Intrinsics.checkParameterIsNotNull(sp, "sp");
        KeyStore keyStore = KeyStore.getInstance(TeeKeyHelperKt.KEY_STORE_PROVIDER_ANDROID);
        keyStore.load(null);
        KeyStore.Entry entry = keyStore.getEntry(keystoreAlias, null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
            Certificate certificate = privateKeyEntry.getCertificate();
            Intrinsics.checkExpressionValueIsNotNull(certificate, "entry.certificate");
            publicKey = certificate.getPublicKey();
            privateKey = privateKeyEntry.getPrivateKey();
        } else {
            privateKey = null;
            publicKey = null;
        }
        if (publicKey == null || privateKey == null) {
            return null;
        }
        return new KeyPair(publicKey, privateKey);
    }

    @JvmStatic
    public static final byte[] sign(PrivateKey privateKey, byte[] data) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Intrinsics.checkParameterIsNotNull(privateKey, "privateKey");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Signature signature = Signature.getInstance(TeeKeyHelperKt.SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        byte[] sign = signature.sign();
        Intrinsics.checkExpressionValueIsNotNull(sign, "s.sign()");
        return sign;
    }

    @JvmStatic
    public static final boolean verify(Certificate certificate, byte[] data, byte[] signature) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Intrinsics.checkParameterIsNotNull(certificate, "certificate");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        Signature signature2 = Signature.getInstance(TeeKeyHelperKt.SIGNATURE_ALGORITHM);
        signature2.initVerify(certificate);
        signature2.update(data);
        return signature2.verify(signature);
    }

    @JvmStatic
    public static final X509Certificate parseCertificate(byte[] cert) throws IOException, CertificateException {
        Intrinsics.checkParameterIsNotNull(cert, "cert");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cert);
        Certificate generateCertificate = CertificateFactory.getInstance(TeeKeyHelperKt.CERTIFICATE_TYPE).generateCertificate(byteArrayInputStream);
        byteArrayInputStream.close();
        if (generateCertificate instanceof X509Certificate) {
            return (X509Certificate) generateCertificate;
        }
        return null;
    }

    @JvmStatic
    public static final boolean isKeyMatch(byte[] cert, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, IOException, CertificateException {
        Intrinsics.checkParameterIsNotNull(cert, "cert");
        Intrinsics.checkParameterIsNotNull(privateKey, "privateKey");
        byte[] bytes = "test".getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] sign = sign(privateKey, bytes);
        X509Certificate parseCertificate = parseCertificate(cert);
        if (parseCertificate == null) {
            return false;
        }
        boolean verify = verify(parseCertificate, bytes, sign);
        if (!verify) {
            TicketGuardEventHelper.monitorKeyNotMatch();
        }
        return verify;
    }

    @JvmStatic
    public static final String parse04PublicKey(ECPublicKey ecPublicKey) {
        Intrinsics.checkParameterIsNotNull(ecPublicKey, "ecPublicKey");
        ECPoint w = ecPublicKey.getW();
        Intrinsics.checkExpressionValueIsNotNull(w, "point");
        byte[] byteArray = w.getAffineX().toByteArray();
        byte[] byteArray2 = w.getAffineY().toByteArray();
        if (byteArray[0] == 0) {
            byteArray = Arrays.copyOfRange(byteArray, 1, byteArray.length);
        }
        if (byteArray2[0] == 0) {
            byteArray2 = Arrays.copyOfRange(byteArray2, 1, byteArray2.length);
        }
        return "04" + Delta.bytearrayToHexString(byteArray) + Delta.bytearrayToHexString(byteArray2);
    }

    @JvmStatic
    public static final String parseBase64PublicKey(ECPublicKey ecPublicKey) {
        Intrinsics.checkParameterIsNotNull(ecPublicKey, "ecPublicKey");
        String encodeToString = Base64.encodeToString(Delta.hexStringToByteArray(parse04PublicKey(ecPublicKey)), 0);
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(De…y(pub04), Base64.DEFAULT)");
        return encodeToString;
    }
}
