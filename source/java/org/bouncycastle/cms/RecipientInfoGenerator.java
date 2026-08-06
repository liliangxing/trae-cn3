package org.bouncycastle.cms;

import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.operator.GenericKey;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface RecipientInfoGenerator {
    RecipientInfo generate(GenericKey genericKey) throws CMSException;
}
