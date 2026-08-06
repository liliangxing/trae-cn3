package com.bytedance.pia.core.api.bridge;

import android.net.Uri;

@Deprecated
/* loaded from: classes4.dex */
public interface IAuthorizer {

    /* loaded from: classes4.dex */
    public enum Privilege {
        Public(0),
        Protected(1),
        Private(2);

        public int value;

        Privilege(int i) {
            this.value = i;
        }
    }

    default Privilege auth(Uri uri) {
        return Privilege.Public;
    }
}
