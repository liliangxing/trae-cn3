package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g */
    private GF2Matrix f1416g;

    /* renamed from: n */
    private int f1417n;

    /* renamed from: t */
    private int f1418t;

    public McEliecePublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix) {
        super(false, null);
        this.f1417n = i;
        this.f1418t = i2;
        this.f1416g = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.f1416g;
    }

    public int getK() {
        return this.f1416g.getNumRows();
    }

    public int getN() {
        return this.f1417n;
    }

    public int getT() {
        return this.f1418t;
    }
}
