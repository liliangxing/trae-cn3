package com.bytedance.android.monitor.webview.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.monitor.util.ExceptionUtil;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class MonitorJsUtils {
    private static String ANONYMOUS_PRE = " function(){ ";
    private static String ANONYMOUS_SUFFIX = " } ";
    private static String JSBRIDGE_PRE = " javascript:( ";
    private static String JSBRIDGE_SUFFIX = " )() ";
    private static String mBridgeJs = "";
    private static String mBridgeJsFileLocalPath = "webview_monitor_js_file/slardar_bridge.js";
    private static String mConfigJs = "";
    private static String mPerformanceJs = "";
    private static String mPerformanceJsFileLocalPath = "webview_monitor_js_file/slardar_sdk.js";

    public static String buildJs(Context context, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(mPerformanceJs)) {
            if (TextUtils.isEmpty(str)) {
                mPerformanceJs = readLocalFile(context, mPerformanceJsFileLocalPath, true);
            } else {
                mPerformanceJs = readLocalFile(context, str, false);
            }
        }
        if (TextUtils.isEmpty(mBridgeJs)) {
            mBridgeJs = readLocalFile(context, mBridgeJsFileLocalPath, true);
        }
        mConfigJs = str2;
        if (str2 == null) {
            str2 = "";
        }
        mConfigJs = str2;
        if (!z) {
            mPerformanceJs = "";
            mConfigJs = "";
            mBridgeJs = "";
        }
        return JSBRIDGE_PRE + ANONYMOUS_PRE + mPerformanceJs + mBridgeJs + mConfigJs + ANONYMOUS_SUFFIX + JSBRIDGE_SUFFIX;
    }

    private static String readLocalFile(Context context, String str, boolean z) {
        InputStream fileInputStream;
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            try {
                try {
                    if (z) {
                        fileInputStream = context.getAssets().open(str);
                    } else {
                        fileInputStream = new FileInputStream(str);
                    }
                    inputStream = fileInputStream;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (Exception e2) {
                ExceptionUtil.handleException(e2);
            }
            return byteArrayOutputStream.toString();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                    ExceptionUtil.handleException(e3);
                }
            }
            throw th;
        }
    }
}
