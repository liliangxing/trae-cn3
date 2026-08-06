package org.bouncycastle.math.ec;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractECLookupTable implements ECLookupTable {
    @Override // org.bouncycastle.math.ec.ECLookupTable
    public ECPoint lookupVar(int i) {
        return lookup(i);
    }
}
