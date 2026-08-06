package com.bytedance.trae.init.task.util;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;
import com.ss.android.common.util.ToolUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes5.dex */
public class Target28WebviewFixHelper {
    private static final List<String> HUAWEI_BRAND_LIST = Arrays.asList("huawei", "honor");
    private static final String HUAWEI_WEBVIEW_DIR = "/app_hws_webview";
    private static final String WEBVIEW_DATA_LOCK_FILE = "/webview_data.lock";
    private static final String WEBVIEW_DIR = "/app_webview";

    public static void initWebViewDataDirectory(boolean z, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            if (z) {
                checkWebViewDataLock(context, WEBVIEW_DIR);
                if (HUAWEI_BRAND_LIST.contains(Build.BRAND.toLowerCase(Locale.getDefault()))) {
                    checkWebViewDataLock(context, HUAWEI_WEBVIEW_DIR);
                    return;
                }
                return;
            }
            setWebViewDataDirectory(context);
        }
    }

    private static void checkWebViewDataLock(Context context, String str) {
        File file = new File(context.getDataDir().getAbsolutePath() + str + WEBVIEW_DATA_LOCK_FILE);
        if (file.exists()) {
            try {
                FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else {
                    tryCreateLockFile(file, file.delete());
                }
            } catch (Exception unused) {
                tryCreateLockFile(file, file.exists() ? file.delete() : false);
            }
        }
    }

    private static void setWebViewDataDirectory(Context context) {
        try {
            WebView.setDataDirectorySuffix(ToolUtils.getCurProcessName(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean tryCreateLockFile(File file, boolean z) {
        if (z && !file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
