package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class O3DevicePlan extends AbsDevicePlan {
    private String mApkName;
    private String mContentUri;

    public O3DevicePlan(Context context, DownloadSetting downloadSetting, String str, String str2, String str3) {
        super(context, downloadSetting, str);
        this.mContentUri = str2;
        this.mApkName = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String str;
        String optString = this.mSetting.optString("s");
        String decrypt = DecryptUtils.decrypt(this.mSetting.optString("ak"), optString);
        String decrypt2 = DecryptUtils.decrypt(this.mSetting.optString("am"), optString);
        String decrypt3 = DecryptUtils.decrypt(this.mSetting.optString("an"), optString);
        String str2 = null;
        if (!TextUtils.isEmpty(decrypt3) && decrypt3.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
            String[] split = decrypt3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            String decrypt4 = DecryptUtils.decrypt(this.mSetting.optString("al"), optString);
            String decrypt5 = DecryptUtils.decrypt(this.mSetting.optString("ao"), optString);
            if (!TextUtils.isEmpty(decrypt5) && decrypt5.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
                String[] split2 = decrypt5.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                JSONObject optJSONObject = this.mSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
                if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
                    if (!TextUtils.isEmpty(optString2) && optString2.contains("%s")) {
                        try {
                            str = String.format(optString2, this.mApkName);
                        } catch (Throwable unused) {
                            str = this.mApkName;
                        }
                    } else {
                        str = this.mApkName;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = decrypt4.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(decrypt);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(decrypt2, this.mContentUri);
                intent.putExtra(decrypt4, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
