package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.ttm.player.C0968C;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class V4DevicePlan extends AbsDevicePlan {
    public static final int SAVE_PATH_IN_EXTERNAL_PRIMARY = 2;
    public static final int SAVE_PATH_IN_EXTERNAL_PUBIC = 1;
    public static final int SAVE_PATH_NOT_MATCH = 0;
    private static final String TAG = "V4DevicePlan";
    public static String V4_REQUIRE_PATH_1;
    public static String V4_REQUIRE_PATH_2;

    static {
        try {
            V4_REQUIRE_PATH_1 = DownloadDirUtils.getExtPublicDownloadPath();
            V4_REQUIRE_PATH_2 = DownloadDirUtils.getExternalStorageDirectory(false).getAbsolutePath() + "/Android/data";
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "init", "Error:" + th);
        }
    }

    public V4DevicePlan(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String str;
        Uri parse;
        String optString = this.mSetting.optString("s");
        String decrypt = DecryptUtils.decrypt(this.mSetting.optString("bq"), optString);
        String decrypt2 = DecryptUtils.decrypt(this.mSetting.optString("bp_1"), optString);
        String decrypt3 = DecryptUtils.decrypt(this.mSetting.optString("bp_2"), optString);
        int checkSavePathLocation = checkSavePathLocation(this.mJumpPath);
        String str2 = "";
        if (checkSavePathLocation == 1) {
            try {
                str2 = this.mJumpPath.replace(V4_REQUIRE_PATH_1, "");
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                str = str2.replace("/", "%2f");
            } catch (Exception unused) {
                str = str2;
            }
            parse = Uri.parse(decrypt2 + str);
        } else {
            if (checkSavePathLocation == 2 && V4_REQUIRE_PATH_2 != null) {
                String[] split = this.mJumpPath.replace(V4_REQUIRE_PATH_2, "").split("/");
                if (!TextUtils.isEmpty(decrypt3)) {
                    StringBuilder sb = new StringBuilder(decrypt3);
                    for (String str3 : split) {
                        if (str3.length() != 0) {
                            sb.append("%2F").append(str3);
                        }
                    }
                    parse = Uri.parse(sb.toString());
                }
            }
            parse = null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(parse, decrypt);
        intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }

    public static boolean isSavePathCorrect(DownloadInfo downloadInfo) {
        File parentFile;
        if (downloadInfo == null) {
            return false;
        }
        DownloadFile downloadFile = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
        if (downloadFile.getFile() == null || (parentFile = downloadFile.getFile().getParentFile()) == null) {
            return false;
        }
        String absolutePath = parentFile.getAbsolutePath();
        return !TextUtils.isEmpty(absolutePath) && checkSavePathLocation(absolutePath) > 0;
    }

    private static int checkSavePathLocation(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String str2 = V4_REQUIRE_PATH_1;
        if (str2 != null && str.startsWith(str2)) {
            return 1;
        }
        String str3 = V4_REQUIRE_PATH_2;
        return (str3 == null || !str.startsWith(str3)) ? 0 : 2;
    }
}
