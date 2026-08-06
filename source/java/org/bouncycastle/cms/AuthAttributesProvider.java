package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
interface AuthAttributesProvider {
    ASN1Set getAuthAttributes();

    boolean isAead();
}
