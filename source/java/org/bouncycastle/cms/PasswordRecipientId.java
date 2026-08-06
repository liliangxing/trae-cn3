package org.bouncycastle.cms;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class PasswordRecipientId extends RecipientId {
    public PasswordRecipientId() {
        super(3);
    }

    @Override // org.bouncycastle.cms.RecipientId, org.bouncycastle.util.Selector
    public Object clone() {
        return new PasswordRecipientId();
    }

    public boolean equals(Object obj) {
        return obj instanceof PasswordRecipientId;
    }

    public int hashCode() {
        return 3;
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object obj) {
        return obj instanceof PasswordRecipientInformation;
    }
}
