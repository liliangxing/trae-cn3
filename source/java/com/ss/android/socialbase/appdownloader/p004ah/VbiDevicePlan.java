package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VbiDevicePlan extends AbsDevicePlan {
    public VbiDevicePlan(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String optString = this.mSetting.optString("s");
        String decrypt = DecryptUtils.decrypt(this.mSetting.optString("bb"), optString);
        if (!TextUtils.isEmpty(decrypt) && decrypt.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
            String decrypt2 = DecryptUtils.decrypt(this.mSetting.optString("bc"), optString);
            if (!TextUtils.isEmpty(decrypt2) && decrypt2.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == 2) {
                String[] split = decrypt.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String[] split2 = decrypt2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                String decrypt3 = DecryptUtils.decrypt(this.mSetting.optString("bd"), optString);
                String decrypt4 = DecryptUtils.decrypt(this.mSetting.optString("be"), optString);
                String decrypt5 = DecryptUtils.decrypt(this.mSetting.optString("bf"), optString);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(decrypt3, this.mJumpPath);
                Intent intent = new Intent();
                intent.setAction(decrypt5);
                intent.setData(Uri.parse(decrypt4 + getUrlParamsByMap(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String getUrlParamsByMap(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()));
            sb.append("&");
        }
        String sb2 = sb.toString();
        return sb2.endsWith("&") ? sb2.substring(0, sb2.length() - 1) : sb2;
    }
}
