package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.ttm.player.C;

/* loaded from: classes7.dex */
public class AndroidUnknownSourcePlan extends AbsDevicePlan {
    public AndroidUnknownSourcePlan(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.mContext.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        return intent;
    }
}
