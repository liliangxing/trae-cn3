package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.content.Intent;
import com.ss.ttm.player.C0968C;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class M1UnknownSourcePlan extends AbsDevicePlan {
    public M1UnknownSourcePlan(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
