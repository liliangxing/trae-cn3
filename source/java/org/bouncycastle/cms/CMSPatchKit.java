package org.bouncycastle.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class CMSPatchKit {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    private static class DLSignerInformation extends SignerInformation {
        protected DLSignerInformation(SignerInformation signerInformation) {
            super(signerInformation);
        }

        @Override // org.bouncycastle.cms.SignerInformation
        public byte[] getEncodedSignedAttributes() throws IOException {
            return this.signedAttributeSet.getEncoded(ASN1Encoding.f489DL);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    private static class ModEncAlgSignerInformation extends SignerInformation {
        protected ModEncAlgSignerInformation(SignerInformation signerInformation, AlgorithmIdentifier algorithmIdentifier) {
            super(signerInformation, editEncAlg(signerInformation.info, algorithmIdentifier));
        }

        private static SignerInfo editEncAlg(SignerInfo signerInfo, AlgorithmIdentifier algorithmIdentifier) {
            return new SignerInfo(signerInfo.getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), algorithmIdentifier, signerInfo.getEncryptedDigest(), signerInfo.getUnauthenticatedAttributes());
        }
    }

    public static SignerInformation createNonDERSignerInfo(SignerInformation signerInformation) {
        return new DLSignerInformation(signerInformation);
    }

    public static SignerInformation createWithSignatureAlgorithm(SignerInformation signerInformation, AlgorithmIdentifier algorithmIdentifier) {
        return new ModEncAlgSignerInformation(signerInformation, algorithmIdentifier);
    }
}
