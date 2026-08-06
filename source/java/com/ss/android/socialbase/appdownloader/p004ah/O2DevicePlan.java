package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.ttm.player.C0968C;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class O2DevicePlan extends AbsDevicePlan {
    public O2DevicePlan(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent intent = new Intent(DownloadConstants.LOWER_OPPO + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.mJumpPath);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
