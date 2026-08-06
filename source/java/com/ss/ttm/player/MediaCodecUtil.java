package com.ss.ttm.player;

import android.util.Log;
import android.util.Pair;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public final class MediaCodecUtil {
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";

    static {
        HashMap hashMap = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = hashMap;
        hashMap.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1);
        hashMap.put("02", 2);
        hashMap.put("03", 4);
        hashMap.put("04", 8);
        hashMap.put("05", 16);
        hashMap.put("06", 32);
        hashMap.put("07", 64);
        hashMap.put("08", 128);
        hashMap.put("09", 256);
        HashMap hashMap2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = hashMap2;
        hashMap2.put("00", 1);
        hashMap2.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 2);
        hashMap2.put("02", 4);
        hashMap2.put("03", 8);
        hashMap2.put("04", 16);
        hashMap2.put("05", 32);
        hashMap2.put("06", 64);
        hashMap2.put("07", 128);
        hashMap2.put("08", 256);
        hashMap2.put("09", 512);
    }

    public static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String codec, String[] parts) {
        if (parts == null || parts.length < 3) {
            Log.w(TAG, "Ignoring malformed Dolby Vision codec string: " + codec);
            return null;
        }
        try {
            Matcher matcher = PROFILE_PATTERN.matcher(parts[1]);
            if (!matcher.matches()) {
                Log.w(TAG, "Ignoring malformed Dolby Vision codec string: " + codec);
                return null;
            }
            String group = matcher.group(1);
            Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(group);
            if (num == null) {
                Log.w(TAG, "Unknown Dolby Vision profile string: " + group);
                return null;
            }
            String str = parts[2];
            Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str);
            if (num2 == null) {
                Log.w(TAG, "Unknown Dolby Vision level string: " + str);
                return null;
            }
            return new Pair<>(num, num2);
        } catch (Exception e) {
            e.printStackTrace();
            Log.w(TAG, "profile pattern match error");
            return null;
        }
    }

    public static String getDolbyCodecs(int dvProfile, int dvLevel) {
        String str;
        if (dvProfile == 4 || dvProfile == 5 || dvProfile == 7) {
            str = "dvhe";
        } else if (dvProfile == 8) {
            str = "hev1";
        } else {
            if (dvProfile != 9) {
                return null;
            }
            str = "avc3";
        }
        return str + ".0" + dvProfile + ".0" + dvLevel;
    }
}
