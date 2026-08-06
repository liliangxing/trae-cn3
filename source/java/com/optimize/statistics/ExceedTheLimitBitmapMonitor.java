package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.deviceregister.utils.RomUtils;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ExceedTheLimitBitmapMonitor {
    private static final int BIG_REASON_FILE_TOO_LARGE = 1;
    private static final int BIG_REASON_RAM_TOO_LARGE = 3;
    private static final int BIG_REASON_RESOLUTION_TOO_LARGE = 2;
    private static final int DEFAULT_LIMIT_BITMAP_CONTRAST = 2;
    private static final long DEFAULT_LIMIT_FILE_SIZE = 20971520;
    private static final long DEFAULT_LIMIT_RAM_SIZE;
    private static CustomExceedLimit mCustomExceedLimit;
    private static boolean sExceedTheLimitBitmapMonitorEnabled;
    private static int sLimitBitmapContrast;
    private static long sLimitFileSize;
    private static long sLimitRamSize;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface CustomExceedLimit {
        Pair<Integer, String> isBigImg(String str, int i, int i2, int i3);
    }

    static {
        long screenPixelMemory = getScreenPixelMemory();
        DEFAULT_LIMIT_RAM_SIZE = screenPixelMemory;
        sLimitBitmapContrast = 2;
        sLimitFileSize = DEFAULT_LIMIT_FILE_SIZE;
        sLimitRamSize = screenPixelMemory;
        sExceedTheLimitBitmapMonitorEnabled = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void checkAndReport(ImageRequest imageRequest, String str, int i, String str2, String str3, String str4, long j, String str5) {
        int i2;
        int i3;
        int i4;
        String str6;
        String str7;
        String str8;
        String str9;
        Pair size;
        SizeDeterminer sizeDeterminer = imageRequest.getSizeDeterminer();
        int i5 = -1;
        if (sizeDeterminer == null || (size = sizeDeterminer.getSize()) == null) {
            i2 = -1;
            i3 = -1;
        } else {
            int intValue = ((Integer) size.first).intValue();
            i3 = ((Integer) size.second).intValue();
            i2 = intValue;
        }
        Pair<Integer, Integer> segmentAndCheckSize = segmentAndCheckSize(str4);
        if (segmentAndCheckSize != null) {
            i5 = ((Integer) segmentAndCheckSize.first).intValue();
            i4 = ((Integer) segmentAndCheckSize.second).intValue();
        } else {
            i4 = -1;
        }
        long parseLong = TextUtils.isEmpty(str5) ? 0L : Long.parseLong(str5);
        int checkLimit = checkLimit(i2, i3, i5, i4, j, parseLong);
        boolean z = checkLimit > 0;
        Pair<String, String> dealBigReason2 = dealBigReason2(checkLimit);
        String str10 = (String) dealBigReason2.first;
        String str11 = (String) dealBigReason2.second;
        CustomExceedLimit customExceedLimit = mCustomExceedLimit;
        if (customExceedLimit != null) {
            Pair<Integer, String> isBigImg = customExceedLimit.isBigImg(str, i, i5, i4);
            z |= isBigImg != null;
            if (isBigImg != null) {
                if (TextUtils.isEmpty(str10)) {
                    str8 = String.valueOf(((Integer) isBigImg.first).intValue() + 10000);
                } else {
                    str8 = str10 + Constants.ACCEPT_TIME_SEPARATOR_SP + (((Integer) isBigImg.first).intValue() + 10000);
                }
                String replace = isBigImg.second == null ? "" : ((String) isBigImg.second).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "，");
                if (TextUtils.isEmpty(str11)) {
                    str9 = (((Integer) isBigImg.first).intValue() + 10000) + RomUtils.SEPARATOR + replace;
                } else {
                    str9 = str11 + Constants.ACCEPT_TIME_SEPARATOR_SP + (((Integer) isBigImg.first).intValue() + 10000) + RomUtils.SEPARATOR + replace;
                }
                str6 = str9;
                str10 = str8;
                if (z) {
                    return;
                }
                String uri = imageRequest.getSourceUri().toString();
                String viewInfo = sizeDeterminer != null ? ViewUtils.getViewInfo(sizeDeterminer.getView()) : null;
                if (sizeDeterminer != null && sizeDeterminer.getView() != null && sizeDeterminer.getView().getContext() != null) {
                    Context context = sizeDeterminer.getView().getContext();
                    if (context instanceof Activity) {
                        str7 = ((Activity) context).getClass().getSimpleName();
                        doReport(uri, str, i, str10, str6, str2, str3, str7, j, i2, i3, i5, i4, parseLong, viewInfo);
                        return;
                    }
                }
                str7 = null;
                doReport(uri, str, i, str10, str6, str2, str3, str7, j, i2, i3, i5, i4, parseLong, viewInfo);
                return;
            }
        }
        str6 = str11;
        if (z) {
        }
    }

    public static boolean isExceedTheLimitBitmapMonitorEnabled() {
        return sExceedTheLimitBitmapMonitorEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBitmapMonitorLimit(long j, int i, long j2) {
        sLimitBitmapContrast = i;
        sLimitFileSize = j;
        sLimitRamSize = j2;
        PipelineDraweeController.setLimit(i, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setExceedTheLimitBitmapMonitorEnabled(boolean z) {
        sExceedTheLimitBitmapMonitorEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCustomExceedLimit(CustomExceedLimit customExceedLimit) {
        mCustomExceedLimit = customExceedLimit;
    }

    private static int checkLimit(int i, int i2, int i3, int i4, long j, long j2) {
        int i5 = j >= sLimitFileSize ? 1 : 0;
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0 && i3 * i4 > i * i2 * sLimitBitmapContrast) {
            i5 |= 10;
        }
        return j2 >= sLimitRamSize ? i5 | 100 : i5;
    }

    private static Pair<String, String> dealBigReason2(int i) {
        String str;
        String str2;
        if (i == 1) {
            str = PushClient.DEFAULT_REQUEST_ID;
            str2 = "1_filesize";
        } else if (i == 10) {
            str = "2";
            str2 = "2_resolution";
        } else if (i == 11) {
            str = "1,2";
            str2 = "1_filesize,2_resolution";
        } else if (i == 100) {
            str = "3";
            str2 = "3_ramsize";
        } else if (i == 101) {
            str = "1,3";
            str2 = "1_filesize,3_ramsize";
        } else if (i == 110) {
            str = "2,3";
            str2 = "2_resolution,3_ramsize";
        } else if (i != 111) {
            str = "";
            str2 = "";
        } else {
            str = "1,2,3";
            str2 = "1_filesize,2_resolution,3_ramsize";
        }
        return new Pair<>(str, str2);
    }

    private static void doReport(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, long j, int i2, int i3, int i4, int i5, long j2, String str8) {
        if (MonitorUtils.getLogTypeSwitch(FrescoMonitorConst.MONITOR_IMAGE_Exceed_Limit_V2)) {
            int computerContrast = computerContrast(i2, i3, i4, i5);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put(FrescoMonitorConst.IMAGE_TYPE, str2);
                jSONObject.put(FrescoMonitorConst.IMAGE_COUNT, i);
                jSONObject.put("bigimage_reason", str3);
                jSONObject.put("description", str4);
                jSONObject.put("biz_tag", str5);
                jSONObject.put(FrescoMonitorConst.SCENE_TAG, str6);
                jSONObject.put("page_tag", str7);
                jSONObject.put(FrescoMonitorConst.FILE_SIZE, j);
                jSONObject.put("view_width", i2);
                jSONObject.put("view_height", i3);
                jSONObject.put("image_width", i4);
                jSONObject.put("image_height", i5);
                jSONObject.put("ram_size", j2);
                jSONObject.put("contrast", computerContrast);
                jSONObject.put("view_info", str8);
                jSONObject.put(FrescoMonitorConst.IMAGE_SDK_VERSION, BuildConfig.FRESCOVERSION);
            } catch (JSONException unused) {
            }
            MonitorUtils.monitorCommonLog(FrescoMonitorConst.MONITOR_IMAGE_Exceed_Limit_V2, jSONObject);
            FrescoMonitor.onExceedLimitCallback(jSONObject);
        }
    }

    private static Pair<Integer, Integer> segmentAndCheckSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("x");
        if (split.length != 2) {
            return null;
        }
        try {
            return new Pair<>(Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static int computerContrast(int i, int i2, int i3, int i4) {
        return Math.min((i3 * 1000) / i, (i4 * 1000) / i2);
    }

    private static long getScreenPixelMemory() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return displayMetrics.heightPixels * displayMetrics.widthPixels * 4;
    }
}
