package com.bytedance.ttnet.retrofit;

import android.text.TextUtils;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes4.dex */
public class RequestDelayHelper {
    private static final String TAG = "RequestDelayHelper";
    private static final String ZERO_TIME_STRING = "00:00:00";

    public static int getRandomDelayTime(int i) {
        return new Random(UUID.randomUUID().hashCode()).nextInt(i);
    }

    public static boolean isInDelayAPIList(String str, Set<String> set) {
        if (!StringUtils.isEmpty(str) && set != null) {
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    if (!Logger.debug()) {
                        return true;
                    }
                    Logger.d(TAG, "app delay, matched, rule is " + str2 + " request path is " + str);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isInDelayTimeRange(String str, String str2) {
        if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(str2)) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.PATTERN_HOUR);
                Date parse = simpleDateFormat.parse(str);
                Date parse2 = simpleDateFormat.parse(str2);
                long currentTimeMillis = System.currentTimeMillis();
                Date date = new Date(currentTimeMillis);
                parse2.setDate(date.getDate());
                parse2.setMonth(date.getMonth());
                parse2.setYear(date.getYear());
                parse.setDate(date.getDate());
                parse.setMonth(date.getMonth());
                parse.setYear(date.getYear());
                if (parse.before(parse2)) {
                    return currentTimeMillis >= parse.getTime() && currentTimeMillis <= parse2.getTime();
                }
                Date parse3 = simpleDateFormat.parse(ZERO_TIME_STRING);
                Date parse4 = simpleDateFormat.parse(ZERO_TIME_STRING);
                parse4.setDate(date.getDate());
                parse4.setMonth(date.getMonth());
                parse4.setYear(date.getYear());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(5, 1);
                Date time = calendar.getTime();
                parse3.setDate(time.getDate());
                parse3.setMonth(time.getMonth());
                parse3.setYear(time.getYear());
                return (currentTimeMillis >= parse4.getTime() && currentTimeMillis <= parse2.getTime()) || (currentTimeMillis >= parse.getTime() && currentTimeMillis < parse3.getTime());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
