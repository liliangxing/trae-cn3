package bytedance.jvm.time.format;

import com.bytedance.vcloud.strategy.StrategyCenter;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class DesugarDateTimeTextProviderHelper {
    public static void populateMonthStyleMap(Map<TextStyle, Map<Long, String>> map, DateFormatSymbols dateFormatSymbols, Locale locale) {
        int length = dateFormatSymbols.getMonths().length;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (long j = 1; j <= length; j++) {
            String computeStandaloneMonthName = computeStandaloneMonthName(j, "LLLL", locale);
            linkedHashMap.put(Long.valueOf(j), computeStandaloneMonthName);
            linkedHashMap2.put(Long.valueOf(j), firstCodePoint(computeStandaloneMonthName));
            linkedHashMap3.put(Long.valueOf(j), computeStandaloneMonthName(j, "LLL", locale));
        }
        if (length > 0) {
            map.put(TextStyle.FULL_STANDALONE, linkedHashMap);
            map.put(TextStyle.NARROW_STANDALONE, linkedHashMap2);
            map.put(TextStyle.SHORT_STANDALONE, linkedHashMap3);
            map.put(TextStyle.FULL, linkedHashMap);
            map.put(TextStyle.NARROW, linkedHashMap2);
            map.put(TextStyle.SHORT, linkedHashMap3);
        }
    }

    private static String computeStandaloneMonthName(long j, String str, Locale locale) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(0, (int) j, 0, 0, 0, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    private static String firstCodePoint(String str) {
        return str.substring(0, Character.charCount(str.codePointAt(0)));
    }

    private static String lastCodePoint(String str) {
        return new StringBuilder().appendCodePoint(str.codePointBefore(str.length())).toString();
    }

    public static void populateDayOfWeekStyleMap(Map<TextStyle, Map<Long, String>> map, DateFormatSymbols dateFormatSymbols, Locale locale) {
        int length = dateFormatSymbols.getWeekdays().length;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        boolean z = locale == Locale.SIMPLIFIED_CHINESE || locale == Locale.TRADITIONAL_CHINESE;
        for (long j = 1; j <= length; j++) {
            String computeStandaloneDayOfWeekName = computeStandaloneDayOfWeekName(j, "cccc", locale);
            linkedHashMap.put(Long.valueOf(j), computeStandaloneDayOfWeekName);
            linkedHashMap2.put(Long.valueOf(j), z ? lastCodePoint(computeStandaloneDayOfWeekName) : firstCodePoint(computeStandaloneDayOfWeekName));
            linkedHashMap3.put(Long.valueOf(j), computeStandaloneDayOfWeekName(j, "ccc", locale));
        }
        if (length > 0) {
            map.put(TextStyle.FULL_STANDALONE, linkedHashMap);
            map.put(TextStyle.NARROW_STANDALONE, linkedHashMap2);
            map.put(TextStyle.SHORT_STANDALONE, linkedHashMap3);
            map.put(TextStyle.FULL, linkedHashMap);
            map.put(TextStyle.NARROW, linkedHashMap2);
            map.put(TextStyle.SHORT, linkedHashMap3);
        }
    }

    private static String computeStandaloneDayOfWeekName(long j, String str, Locale locale) {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        calendar.set(StrategyCenter.EVENT_LOAD_CONTROL_VERSION, 1, (int) j, 0, 0, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    private DesugarDateTimeTextProviderHelper() {
    }
}
