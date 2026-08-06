package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes8.dex */
public interface ASN1TaggedObjectParser extends ASN1Encodable, InMemoryRepresentable {
    ASN1Encodable getObjectParser(int i, boolean z) throws IOException;

    int getTagNo();
}
