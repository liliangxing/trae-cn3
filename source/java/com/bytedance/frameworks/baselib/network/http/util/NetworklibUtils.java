package com.bytedance.frameworks.baselib.network.http.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class NetworklibUtils {
    private static final String TAG = "NetworklibUtils";

    public static boolean splitStringIntoKeyValuePairs(String str, String str2, String str3, List<Pair<String, String>> list) {
        String[] split;
        String[] split2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || list == null || (split = str.split(str2)) == null) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i]) && (split2 = split[i].trim().split(str3)) != null && split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                list.add(new Pair<>(split2[0].trim(), split2[1].trim()));
            }
        }
        return list.size() != 0;
    }

    public static boolean splitUTCTimeSegmentToList(String str, List<Long> list) {
        if (TextUtils.isEmpty(str) || !str.contains(Constants.WAVE_SEPARATOR)) {
            return false;
        }
        String[] split = str.split(Constants.WAVE_SEPARATOR);
        if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
            if (list == null) {
                list = new ArrayList<>();
            }
            long parseUTCTimeToLocal = parseUTCTimeToLocal(split[0]);
            long parseUTCTimeToLocal2 = parseUTCTimeToLocal(split[1]);
            if (parseUTCTimeToLocal > 0 && parseUTCTimeToLocal2 > 0 && parseUTCTimeToLocal < parseUTCTimeToLocal2) {
                list.add(Long.valueOf(parseUTCTimeToLocal));
                list.add(Long.valueOf(parseUTCTimeToLocal2));
                return true;
            }
        }
        return false;
    }

    public static long parseUTCTimeToLocal(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "utcTime " + str);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date parse = simpleDateFormat.parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static boolean splitIso8601TimeSegmentToList(String str, List<Date> list) {
        if (TextUtils.isEmpty(str) || !str.contains(Constants.WAVE_SEPARATOR)) {
            return false;
        }
        String[] split = str.split(Constants.WAVE_SEPARATOR);
        if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
            Date parseIso8601TimeToDate = parseIso8601TimeToDate(split[0]);
            Date parseIso8601TimeToDate2 = parseIso8601TimeToDate(split[1]);
            if (parseIso8601TimeToDate != null && parseIso8601TimeToDate2 != null) {
                if (Logger.debug()) {
                    String str2 = TAG;
                    Logger.d(str2, "parse dateTime " + split[0] + " to " + parseIso8601TimeToDate);
                    Logger.d(str2, "parse dateTime " + split[1] + " to " + parseIso8601TimeToDate2);
                }
                list.add(parseIso8601TimeToDate);
                list.add(parseIso8601TimeToDate2);
                return true;
            }
        }
        return false;
    }

    public static Date parseIso8601TimeToDate(String str) {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "parse dateTime " + str + " sdk version >= N");
            }
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault()).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
