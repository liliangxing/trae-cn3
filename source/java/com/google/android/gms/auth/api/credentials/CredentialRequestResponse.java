package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;

/* compiled from: com.google.android.gms:play-services-auth@@20.5.0 */
@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    public Credential getCredential() {
        return getResult().getCredential();
    }
}
