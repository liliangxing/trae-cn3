package com.google.android.gms.internal.p035authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.5.0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class zbf extends zbd {
    final /* synthetic */ zbg zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbf(zbg zbgVar) {
        this.zba = zbgVar;
    }

    @Override // com.google.android.gms.internal.p035authapi.zbd, com.google.android.gms.internal.p035authapi.zbs
    public final void zbb(Status status, Credential credential) {
        this.zba.setResult((zbg) new zbe(status, credential));
    }

    @Override // com.google.android.gms.internal.p035authapi.zbd, com.google.android.gms.internal.p035authapi.zbs
    public final void zbc(Status status) {
        this.zba.setResult((zbg) new zbe(status, null));
    }
}
