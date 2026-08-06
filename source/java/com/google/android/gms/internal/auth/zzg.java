package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface zzg extends HasApiKey {
    Task zza(zzbw zzbwVar);

    Task zzb(AccountChangeEventsRequest accountChangeEventsRequest);

    Task zzc(Account account, String str, Bundle bundle);

    Task zzd(Account account);

    Task zze(String str);
}
