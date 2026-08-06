package org.bouncycastle.math.field;

/* loaded from: classes8.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
