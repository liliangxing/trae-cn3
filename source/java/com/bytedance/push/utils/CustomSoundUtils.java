package com.bytedance.push.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.push.notification.AsyncSoundDownloaderWrapper;
import com.bytedance.push.notification.SoundDownloadCallback;
import com.ss.android.message.util.ToolUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CustomSoundUtils {
    private static final String CUSTOM_SOUND = "custom_sound";
    public static final int ILLEGAL_ID = -1;
    private static final String TAG = "CustomSoundUtils";

    public static String getRemoteSoundFilePath(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_RINGTONES);
        if (!externalFilesDir.exists() && !externalFilesDir.mkdir()) {
            return "";
        }
        return externalFilesDir.getAbsolutePath() + "/" + str + ".mp3";
    }

    public static int getLocalSoundResourceId(String str, int[] iArr, String str2) {
        int parseSoundIndexFromChannelId = parseSoundIndexFromChannelId(str);
        if (parseSoundIndexFromChannelId == -1) {
            parseSoundIndexFromChannelId = parseSoundIndexFromSound(str2);
        }
        if (parseSoundIndexFromChannelId < 0 || iArr == null || iArr.length <= parseSoundIndexFromChannelId) {
            return -1;
        }
        return iArr[parseSoundIndexFromChannelId];
    }

    private static int parseSoundIndexFromSound(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int parseSoundIndexFromChannelId(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.startsWith(CUSTOM_SOUND)) {
            str = str.substring(str.length() - 1);
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static Uri getLocalSoundUri(Context context, int i) {
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + i);
    }

    public static Uri getRemoteSoundUri(Context context, String str) {
        if (ToolUtils.isTargetBrandDevice(ToolUtils.HW) || ToolUtils.isTargetBrandDevice(ToolUtils.HONOR) || ToolUtils.isTargetBrandDevice(ToolUtils.OPPO) || ToolUtils.isTargetBrandDevice(ToolUtils.VIVO)) {
            return Uri.fromFile(new File(str));
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".push.file_provider", new File(str));
    }

    public static boolean downLoadCustomSound(Context context, AsyncSoundDownloaderWrapper asyncSoundDownloaderWrapper, String str, String str2, SoundDownloadCallback soundDownloadCallback) {
        if (asyncSoundDownloaderWrapper != null && !TextUtils.isEmpty(str) && ((str.contains("http://") || str.contains("https://")) && str.endsWith("mp3"))) {
            try {
                String remoteSoundFilePath = getRemoteSoundFilePath(context, str2);
                if (TextUtils.isEmpty(remoteSoundFilePath)) {
                    return false;
                }
                if (new File(remoteSoundFilePath).exists()) {
                    soundDownloadCallback.onSuccess(remoteSoundFilePath);
                    return true;
                }
                asyncSoundDownloaderWrapper.downloadSound(str, remoteSoundFilePath, soundDownloadCallback);
                return true;
            } catch (Throwable th) {
                Logger.m274i(TAG, "Failed to create custom sound channel, create default channel！" + th.getMessage());
            }
        }
        return false;
    }
}
