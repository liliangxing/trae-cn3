package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class SecP521R1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: Q */
    public static final BigInteger f1274Q = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x */
    protected int[] f1275x;

    public SecP521R1FieldElement() {
        this.f1275x = Nat.create(17);
    }

    public SecP521R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f1274Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f1275x = SecP521R1Field.fromBigInteger(bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP521R1FieldElement(int[] iArr) {
        this.f1275x = iArr;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.add(this.f1275x, ((SecP521R1FieldElement) eCFieldElement).f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] create = Nat.create(17);
        SecP521R1Field.addOne(this.f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.inv(((SecP521R1FieldElement) eCFieldElement).f1275x, create);
        SecP521R1Field.multiply(create, this.f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SecP521R1FieldElement) {
            return Nat.m342eq(17, this.f1275x, ((SecP521R1FieldElement) obj).f1275x);
        }
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP521R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return f1274Q.bitLength();
    }

    public int hashCode() {
        return f1274Q.hashCode() ^ Arrays.hashCode(this.f1275x, 0, 17);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] create = Nat.create(17);
        SecP521R1Field.inv(this.f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(17, this.f1275x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(17, this.f1275x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.multiply(this.f1275x, ((SecP521R1FieldElement) eCFieldElement).f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] create = Nat.create(17);
        SecP521R1Field.negate(this.f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] iArr = this.f1275x;
        if (Nat.isZero(17, iArr) || Nat.isOne(17, iArr)) {
            return this;
        }
        int[] create = Nat.create(17);
        int[] create2 = Nat.create(17);
        SecP521R1Field.squareN(iArr, 519, create);
        SecP521R1Field.square(create, create2);
        if (Nat.m342eq(17, iArr, create2)) {
            return new SecP521R1FieldElement(create);
        }
        return null;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] create = Nat.create(17);
        SecP521R1Field.square(this.f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.subtract(this.f1275x, ((SecP521R1FieldElement) eCFieldElement).f1275x, create);
        return new SecP521R1FieldElement(create);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat.getBit(this.f1275x, 0) == 1;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(17, this.f1275x);
    }
}
