package com.bytedance.ug.sdk.share.impl.utils;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.helper.ClipboardHelper;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClipboardCompat {
    private static final String TAG = "ClipboardCompat";
    private static final String TYPE_ADDRESS = "add";
    private static final String TYPE_DATE = "date";
    private static final String TYPE_DATE_TIME = "time";
    private static final String TYPE_EMAIL = "mail";
    private static final String TYPE_FLIGHT_NUMBER = "fnum";
    private static final String TYPE_PHONE = "tel";
    private static final String TYPE_URL = "url";
    private static final ClipboardHelper sHelper = new ClipboardHelper();
    private static long clipboardTimeStamp = -1;
    public static int CLOP_BOARD_ERR_CODE_SUCCESS = 0;
    public static int CLOP_BOARD_ERR_CODE_EMPTY = 1;
    public static int CLOP_BOARD_ERR_CODE_PATTERN = 2;
    public static int CLOP_BOARD_ERR_CODE_SELF = 3;
    public static int CLOP_BOARD_ERR_CODE_EXPIRED = 4;
    public static int CLOP_BOARD_ERR_CODE_OTHER_APP = 5;
    public static int CLOP_BOARD_ERR_CODE_OTHER = 6;

    public static void setText(Context context, String str, String str2) {
        if (context == null || str == null || str2 == null) {
            return;
        }
        try {
            if (ShareConfigManager.getInstance().useHostClipboard() && ShareConfigManager.getInstance().getClipboardConfig() != null) {
                ShareConfigManager.getInstance().getClipboardConfig().writeClipBoard(context, str2);
            } else {
                sHelper.setText(context, str, str2);
            }
            Logger.m463d(TAG, "clipboard set text success" + str2);
        } catch (Throwable unused) {
            Logger.m463d(TAG, "clipboard set text failed" + str2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0115, code lost:
    
        if (r0.getConfidenceScore("datetime") == 1.0f) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0117, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0121, code lost:
    
        if (r0.getConfidenceScore("email") == 1.0f) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012c, code lost:
    
        if (r0.getConfidenceScore("flight") == 1.0f) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0135, code lost:
    
        if (r0.getConfidenceScore(com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat.TYPE_DATE) == 1.0f) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013e, code lost:
    
        if (r0.getConfidenceScore("url") == 1.0f) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014a, code lost:
    
        if (r0.getConfidenceScore(com.bytedance.trae.login.traeauth.TraeAuthManager.PLATFORM_PHONE) == 1.0f) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0155, code lost:
    
        if (r0.getConfidenceScore("address") == 1.0f) goto L68;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x00b8. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0108. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[LOOP:0: B:25:0x008d->B:67:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String tryGetClipBoardText(Context context) {
        boolean isEnableUseTimon = ShareSdkManager.getInstance().isEnableUseTimon();
        Logger.m469i(TAG, "tryGetClipBoardText() Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT + "， useTimon = " + isEnableUseTimon);
        if (Build.VERSION.SDK_INT >= 31 && !isEnableUseTimon) {
            Logger.m469i(TAG, "tryGetClipBoardText() 系统版本大于等于12，且use_timon开关没开，走sdk内部的规则pattern校验");
            ClipboardManager clipboardManager = sHelper.getClipboardManager(context);
            if (clipboardManager == null) {
                return "";
            }
            ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
            if (primaryClipDescription == null) {
                Logger.m469i(TAG, "clipDescription 为空");
                return "";
            }
            if (clipboardTimeStamp == primaryClipDescription.getTimestamp()) {
                Logger.m469i(TAG, "剪切板内容没有发生变化");
                return "";
            }
            clipboardTimeStamp = primaryClipDescription.getTimestamp();
            if (primaryClipDescription.getClassificationStatus() == 1 || primaryClipDescription.getClassificationStatus() == 2) {
                Logger.m469i(TAG, "分类未进行或未结束");
                return "";
            }
            List<List<String>> android12TokenDetectStrategy = ShareSdkManager.getInstance().getAndroid12TokenDetectStrategy();
            if (android12TokenDetectStrategy == null || android12TokenDetectStrategy.isEmpty()) {
                Logger.m469i(TAG, "未下发口令检测策略");
                ShareEvent.sendAndroid12TokenDetectStrategyResultEvent(2);
                return "";
            }
            Iterator<List<String>> it = android12TokenDetectStrategy.iterator();
            boolean z = true;
            while (it.hasNext()) {
                boolean z2 = true;
                for (String str : it.next()) {
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case 96417:
                            if (str.equals(TYPE_ADDRESS)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 114715:
                            if (str.equals(TYPE_PHONE)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 116079:
                            if (str.equals("url")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 3076014:
                            if (str.equals(TYPE_DATE)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3148128:
                            if (str.equals(TYPE_FLIGHT_NUMBER)) {
                                c = 4;
                                break;
                            }
                            break;
                        case 3343799:
                            if (str.equals(TYPE_EMAIL)) {
                                c = 5;
                                break;
                            }
                            break;
                        case 3560141:
                            if (str.equals(TYPE_DATE_TIME)) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        default:
                            z2 = false;
                            break;
                    }
                    if (!z2) {
                        z = z2;
                        if (!z) {
                            if (!z) {
                                Logger.m469i(TAG, "剪切板内容匹配检测成功");
                                ShareEvent.sendAndroid12TokenDetectStrategyResultEvent(0);
                                return getClipBoardText(context);
                            }
                            Logger.m469i(TAG, "剪切板内容匹配检测失败");
                            ShareEvent.sendAndroid12TokenDetectStrategyResultEvent(1);
                            return "";
                        }
                    }
                }
                z = z2;
                if (!z) {
                }
            }
            if (!z) {
            }
        } else {
            Logger.m469i(TAG, "tryGetClipBoardText() 系统版本小于12，或者use_timon开关为true，走宿主读取剪切板");
            return getClipBoardText(context);
        }
    }

    private static String getClipBoardText(Context context) {
        if (ShareConfigManager.getInstance().useHostClipboard() && ShareConfigManager.getInstance().getClipboardConfig() != null) {
            return ShareConfigManager.getInstance().getClipboardConfig().readClipBoard(context);
        }
        return sHelper.getClipBoardText(context);
    }

    public static void clearClipBoard() {
        Logger.m463d(TAG, "clipboard clear");
        try {
            SharePrefHelper.getInstance().removePref(SharePrefHelper.SP_USER_COPY_CONTENT);
            if (Build.VERSION.SDK_INT >= 28) {
                sHelper.clearPrimaryClip(ShareSdkManager.getInstance().getAppContext());
            } else {
                setText(ShareSdkManager.getInstance().getAppContext(), "", "");
            }
        } catch (Exception unused) {
            setText(ShareSdkManager.getInstance().getAppContext(), "", "");
        }
    }

    public static void onClipBoardResult(int i, String str) {
        if (!ShareConfigManager.getInstance().useHostClipboard() || ShareConfigManager.getInstance().getClipboardConfig() == null) {
            return;
        }
        ShareConfigManager.getInstance().getClipboardConfig().onClipBoardResult(i, str);
    }
}
