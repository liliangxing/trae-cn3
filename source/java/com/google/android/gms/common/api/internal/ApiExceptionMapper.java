package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ApiExceptionMapper implements StatusExceptionMapper {
    @Override // com.google.android.gms.common.api.internal.StatusExceptionMapper
    public final Exception getException(Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}
