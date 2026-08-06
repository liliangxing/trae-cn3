package com.google.android.gms.internal.p035authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-auth@@20.5.0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class zbk extends zbd {
    private final BaseImplementation.ResultHolder zba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zbk(BaseImplementation.ResultHolder resultHolder) {
        this.zba = resultHolder;
    }

    @Override // com.google.android.gms.internal.p035authapi.zbd, com.google.android.gms.internal.p035authapi.zbs
    public final void zbc(Status status) {
        this.zba.setResult(status);
    }
}
