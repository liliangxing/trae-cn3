package com.google.android.gms.internal.p036authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class zzaa extends zzi {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(zzab zzabVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p036authapiphone.zzj
    public final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }
}
