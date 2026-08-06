package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
class LMOtsPrivateKey {

    /* renamed from: I */
    private final byte[] f1360I;
    private final byte[] masterSecret;
    private final LMOtsParameters parameter;

    /* renamed from: q */
    private final int f1361q;

    public LMOtsPrivateKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        this.parameter = lMOtsParameters;
        this.f1360I = bArr;
        this.f1361q = i;
        this.masterSecret = bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SeedDerive getDerivationFunction() {
        SeedDerive seedDerive = new SeedDerive(this.f1360I, this.masterSecret, DigestUtil.getDigest(this.parameter.getDigestOID()));
        seedDerive.setQ(this.f1361q);
        return seedDerive;
    }

    public byte[] getI() {
        return this.f1360I;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f1361q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LMSContext getSignatureContext(LMSigParameters lMSigParameters, byte[][] bArr) {
        byte[] bArr2 = new byte[32];
        SeedDerive derivationFunction = getDerivationFunction();
        derivationFunction.setJ(-3);
        derivationFunction.deriveSeed(bArr2, false);
        Digest digest = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(getI(), digest);
        LmsUtils.u32str(getQ(), digest);
        LmsUtils.u16str((short) -32383, digest);
        LmsUtils.byteArray(bArr2, digest);
        return new LMSContext(this, lMSigParameters, digest, bArr2, bArr);
    }
}
