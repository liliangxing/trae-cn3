package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.ttm.player.C0968C;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class V3DevicePlan extends AbsDevicePlan {
    public V3DevicePlan(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String optString = this.mSetting.optString("s");
        String decrypt = DecryptUtils.decrypt(this.mSetting.optString("ag"), optString);
        String decrypt2 = DecryptUtils.decrypt(this.mSetting.optString("ah"), optString);
        String decrypt3 = DecryptUtils.decrypt(this.mSetting.optString("ai"), optString);
        String decrypt4 = DecryptUtils.decrypt(this.mSetting.optString("aj"), optString);
        Intent intent = new Intent();
        intent.putExtra(decrypt, this.mJumpPath);
        intent.putExtra(decrypt2, "*/*");
        intent.putExtra(decrypt3, true);
        intent.setAction(decrypt4);
        intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        return intent;
    }
}
