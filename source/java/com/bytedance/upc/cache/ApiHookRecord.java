package com.bytedance.upc.cache;

import android.content.Context;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.upc.cache.ApiMultiProcessSharedProvider;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.bytedance.upc.common.thread.ThreadPlus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ApiHookRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190\u001dJ\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0016\u0010*\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/upc/cache/ApiHookRecord;", "", "()V", "CHECK_DATE_INTERVAL", "", "DAY_TIME_MILLS", "KEY_ANDROID_ID", "", "KEY_DEVICE_ID", "KEY_IMEI", "KEY_IMSI", "KEY_MAC", "KEY_OAID", "SP_KEY_STATS_COUNT_PREFIX", "SP_KEY_STATS_DATES", "SP_KEY_STATS_TYPES_PREFIX", "SP_KEY_STATS_VALUE_PREFIX", "STATS_TYPES", "", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "dateFormat", "Ljava/text/SimpleDateFormat;", "getApiRecord", "", "limit", "", "callback", "Lkotlin/Function1;", "Lorg/json/JSONArray;", "getContext", "Landroid/content/Context;", "getSharedPreferences", "Lcom/bytedance/upc/cache/ApiMultiProcessSharedProvider$MultiProcessShared;", "keyCountByDateType", ApiHookRecord.SP_KEY_STATS_DATES, "type", "keyDates", "keyTypesByDate", "keyValueByDateType", "tryDeleteExpireData", "updateApiRecord", "value", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ApiHookRecord {
    private static final long CHECK_DATE_INTERVAL = 3600000;
    private static final long DAY_TIME_MILLS = 86400000;
    private static final String SP_KEY_STATS_COUNT_PREFIX = "count";
    private static final String SP_KEY_STATS_DATES = "date";
    private static final String SP_KEY_STATS_TYPES_PREFIX = "type";
    private static final String SP_KEY_STATS_VALUE_PREFIX = "value";
    public static final ApiHookRecord INSTANCE = new ApiHookRecord();
    public static final String KEY_IMEI = "IMEI";
    public static final String KEY_DEVICE_ID = "DEVICE_ID";
    public static final String KEY_IMSI = "IMSI";
    public static final String KEY_OAID = "OAID";
    public static final String KEY_MAC = "MAC_ADDRESS";
    public static final String KEY_ANDROID_ID = "ANDROID_ID";
    private static final Set<String> STATS_TYPES = SetsKt.setOf(new String[]{KEY_IMEI, KEY_DEVICE_ID, KEY_IMSI, KEY_OAID, KEY_MAC, KEY_ANDROID_ID});
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
    private static final Calendar calendar = Calendar.getInstance(Locale.US);

    /* JADX INFO: Access modifiers changed from: private */
    public final String keyDates() {
        return SP_KEY_STATS_DATES;
    }

    private ApiHookRecord() {
    }

    private final Context getContext() {
        try {
            return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApiMultiProcessSharedProvider.MultiProcessShared getSharedPreferences() {
        try {
            return ApiMultiProcessSharedProvider.getMultiprocessShared(getContext());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String keyTypesByDate(String date) {
        return "type#" + date;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String keyCountByDateType(String date, String type) {
        return "count#" + date + '#' + type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String keyValueByDateType(String date, String type) {
        return "value#" + date + '#' + type;
    }

    public final void updateApiRecord(final String type, final String value) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(value, "value");
        tryDeleteExpireData();
        ThreadPlus.INSTANCE.submit(new Function0<Unit>() { // from class: com.bytedance.upc.cache.ApiHookRecord$updateApiRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3486invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3486invoke() {
                ApiMultiProcessSharedProvider.MultiProcessShared sharedPreferences;
                SimpleDateFormat simpleDateFormat;
                Calendar calendar2;
                String keyCountByDateType;
                String keyDates;
                String keyTypesByDate;
                String keyCountByDateType2;
                String keyValueByDateType;
                try {
                    sharedPreferences = ApiHookRecord.INSTANCE.getSharedPreferences();
                    if (sharedPreferences != null) {
                        ApiHookRecord apiHookRecord = ApiHookRecord.INSTANCE;
                        simpleDateFormat = ApiHookRecord.dateFormat;
                        ApiHookRecord apiHookRecord2 = ApiHookRecord.INSTANCE;
                        calendar2 = ApiHookRecord.calendar;
                        Intrinsics.checkExpressionValueIsNotNull(calendar2, "calendar");
                        String format = simpleDateFormat.format(calendar2.getTime());
                        ApiHookRecord apiHookRecord3 = ApiHookRecord.INSTANCE;
                        Intrinsics.checkExpressionValueIsNotNull(format, "currentDate");
                        keyCountByDateType = apiHookRecord3.keyCountByDateType(format, type);
                        int i = sharedPreferences.getInt(keyCountByDateType, 0);
                        ApiMultiProcessSharedProvider.Editor edit = sharedPreferences.edit();
                        keyDates = ApiHookRecord.INSTANCE.keyDates();
                        Set<String> stringSet = sharedPreferences.getStringSet(keyDates, null);
                        if (stringSet == null) {
                            stringSet = SetsKt.emptySet();
                        }
                        if (!stringSet.contains(format)) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                            linkedHashSet.addAll(stringSet);
                            linkedHashSet.add(format);
                            if (edit != null) {
                                edit.putStringSet(keyDates, linkedHashSet);
                            }
                        }
                        keyTypesByDate = ApiHookRecord.INSTANCE.keyTypesByDate(format);
                        Set<String> stringSet2 = sharedPreferences.getStringSet(keyTypesByDate, null);
                        if (stringSet2 == null) {
                            stringSet2 = SetsKt.emptySet();
                        }
                        if (!stringSet2.contains(type)) {
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                            linkedHashSet2.addAll(stringSet2);
                            linkedHashSet2.add(type);
                            if (edit != null) {
                                edit.putStringSet(keyTypesByDate, linkedHashSet2);
                            }
                        }
                        keyCountByDateType2 = ApiHookRecord.INSTANCE.keyCountByDateType(format, type);
                        if (edit != null) {
                            edit.putInt(keyCountByDateType2, i + 1);
                        }
                        keyValueByDateType = ApiHookRecord.INSTANCE.keyValueByDateType(format, type);
                        if (edit != null) {
                            edit.putString(keyValueByDateType, value);
                        }
                        if (edit != null) {
                            edit.commit();
                        }
                    }
                } catch (Throwable th) {
                    LogUtils.e(th);
                }
            }
        });
    }

    public final void getApiRecord(final int limit, final Function1<? super JSONArray, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        tryDeleteExpireData();
        ThreadPlus.INSTANCE.submit(new Function0<Unit>() { // from class: com.bytedance.upc.cache.ApiHookRecord$getApiRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3484invoke();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x00d4 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0149  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x0161 A[Catch: all -> 0x01a4, TryCatch #0 {all -> 0x01a4, blocks: (B:11:0x0074, B:13:0x007c, B:14:0x0088, B:16:0x008e, B:18:0x00a0, B:19:0x00ad, B:21:0x00b3, B:27:0x00d4, B:31:0x00c9, B:35:0x00d8, B:36:0x00e4, B:40:0x00ef, B:41:0x0102, B:43:0x0108, B:45:0x0125, B:49:0x0135, B:50:0x013d, B:53:0x014e, B:55:0x015b, B:57:0x0161, B:60:0x017a, B:66:0x0188, B:72:0x014a, B:76:0x00dd), top: B:10:0x0074 }] */
            /* JADX WARN: Removed duplicated region for block: B:72:0x014a A[Catch: all -> 0x01a4, TryCatch #0 {all -> 0x01a4, blocks: (B:11:0x0074, B:13:0x007c, B:14:0x0088, B:16:0x008e, B:18:0x00a0, B:19:0x00ad, B:21:0x00b3, B:27:0x00d4, B:31:0x00c9, B:35:0x00d8, B:36:0x00e4, B:40:0x00ef, B:41:0x0102, B:43:0x0108, B:45:0x0125, B:49:0x0135, B:50:0x013d, B:53:0x014e, B:55:0x015b, B:57:0x0161, B:60:0x017a, B:66:0x0188, B:72:0x014a, B:76:0x00dd), top: B:10:0x0074 }] */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m3484invoke() {
                SimpleDateFormat simpleDateFormat;
                SimpleDateFormat simpleDateFormat2;
                ApiMultiProcessSharedProvider.MultiProcessShared sharedPreferences;
                Set<String> set;
                String keyDates;
                Set emptySet;
                int i;
                String keyDates2;
                Set<String> stringSet;
                String keyValueByDateType;
                String keyCountByDateType;
                boolean z;
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(11, 0);
                calendar2.set(12, 0);
                calendar2.set(13, 0);
                calendar2.set(14, 0);
                ApiHookRecord apiHookRecord = ApiHookRecord.INSTANCE;
                simpleDateFormat = ApiHookRecord.dateFormat;
                Intrinsics.checkExpressionValueIsNotNull(calendar2, "calendar");
                String format = simpleDateFormat.format(Long.valueOf(calendar2.getTimeInMillis() - 1));
                long timeInMillis = calendar2.getTimeInMillis();
                Integer valueOf = Integer.valueOf(limit);
                valueOf.intValue();
                if (!(limit > 0)) {
                    valueOf = null;
                }
                calendar2.setTimeInMillis(timeInMillis - ((valueOf != null ? valueOf.intValue() : 1) * 86400000));
                ApiHookRecord apiHookRecord2 = ApiHookRecord.INSTANCE;
                simpleDateFormat2 = ApiHookRecord.dateFormat;
                String format2 = simpleDateFormat2.format(calendar2.getTime());
                JSONArray jSONArray = new JSONArray();
                try {
                    sharedPreferences = ApiHookRecord.INSTANCE.getSharedPreferences();
                } catch (Throwable unused) {
                }
                if (sharedPreferences != null) {
                    ApiHookRecord apiHookRecord3 = ApiHookRecord.INSTANCE;
                    set = ApiHookRecord.STATS_TYPES;
                    for (String str : set) {
                        keyDates = ApiHookRecord.INSTANCE.keyDates();
                        Set<String> stringSet2 = sharedPreferences.getStringSet(keyDates, null);
                        if (stringSet2 == null) {
                            emptySet = SetsKt.emptySet();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : stringSet2) {
                                String str2 = format;
                                String str3 = (String) obj;
                                if (str3.compareTo(format2) >= 0 && str3.compareTo(str2) <= 0) {
                                    z = true;
                                    if (!z) {
                                        arrayList.add(obj);
                                    }
                                }
                                z = false;
                                if (!z) {
                                }
                            }
                            emptySet = arrayList;
                        }
                        if (!(!emptySet.isEmpty())) {
                            emptySet = null;
                        }
                        if (emptySet != null) {
                            Collection<String> collection = emptySet;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
                            for (String str4 : collection) {
                                ApiHookRecord apiHookRecord4 = ApiHookRecord.INSTANCE;
                                Intrinsics.checkExpressionValueIsNotNull(str4, "it");
                                keyCountByDateType = apiHookRecord4.keyCountByDateType(str4, str);
                                arrayList2.add(Integer.valueOf(sharedPreferences.getInt(keyCountByDateType, 0)));
                            }
                            ArrayList arrayList3 = arrayList2;
                            if (!(!arrayList3.isEmpty())) {
                                arrayList3 = null;
                            }
                            if (arrayList3 != null) {
                                i = CollectionsKt.sumOfInt(arrayList3);
                                keyDates2 = ApiHookRecord.INSTANCE.keyDates();
                                stringSet = sharedPreferences.getStringSet(keyDates2, null);
                                if (stringSet != null) {
                                    stringSet = SetsKt.emptySet();
                                }
                                String str5 = "";
                                for (String str6 : CollectionsKt.reversed(stringSet)) {
                                    ApiHookRecord apiHookRecord5 = ApiHookRecord.INSTANCE;
                                    Intrinsics.checkExpressionValueIsNotNull(str6, "date");
                                    keyValueByDateType = apiHookRecord5.keyValueByDateType(str6, str);
                                    str5 = sharedPreferences.getString(keyValueByDateType, "");
                                    if (str5 == null) {
                                        str5 = "";
                                    }
                                    if (str5.length() > 0) {
                                        break;
                                    }
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(StrategyConstants.NAME, str);
                                jSONObject.put(StrategyConstants.VALUE, str5);
                                jSONObject.put("query_count", i);
                                jSONArray.put(jSONObject);
                            }
                        }
                        i = 0;
                        keyDates2 = ApiHookRecord.INSTANCE.keyDates();
                        stringSet = sharedPreferences.getStringSet(keyDates2, null);
                        if (stringSet != null) {
                        }
                        String str52 = "";
                        while (r10.hasNext()) {
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(StrategyConstants.NAME, str);
                        jSONObject2.put(StrategyConstants.VALUE, str52);
                        jSONObject2.put("query_count", i);
                        jSONArray.put(jSONObject2);
                    }
                    callback.invoke(jSONArray);
                }
            }
        });
    }

    private final void tryDeleteExpireData() {
        ThreadPlus.INSTANCE.submit(new Function0<Unit>() { // from class: com.bytedance.upc.cache.ApiHookRecord$tryDeleteExpireData$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m3485invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3485invoke() {
                ApiMultiProcessSharedProvider.MultiProcessShared sharedPreferences;
                SimpleDateFormat simpleDateFormat;
                String keyDates;
                Set emptySet;
                String keyDates2;
                Collection<String> emptySet2;
                Set<String> set;
                String keyValueByDateType;
                String keyCountByDateType;
                String keyDates3;
                sharedPreferences = ApiHookRecord.INSTANCE.getSharedPreferences();
                if (sharedPreferences != null) {
                    Calendar calendar2 = Calendar.getInstance(Locale.US);
                    Intrinsics.checkExpressionValueIsNotNull(calendar2, "calendar");
                    long timeInMillis = calendar2.getTimeInMillis();
                    Integer num = 365;
                    num.intValue();
                    calendar2.setTimeInMillis(timeInMillis - ((num != null ? num.intValue() : 1) * 86400000));
                    ApiHookRecord apiHookRecord = ApiHookRecord.INSTANCE;
                    simpleDateFormat = ApiHookRecord.dateFormat;
                    String format = simpleDateFormat.format(calendar2.getTime());
                    keyDates = ApiHookRecord.INSTANCE.keyDates();
                    Set<String> stringSet = sharedPreferences.getStringSet(keyDates, null);
                    if (stringSet == null) {
                        emptySet = SetsKt.emptySet();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : stringSet) {
                            Intrinsics.checkExpressionValueIsNotNull(format, "expireDate");
                            if (((String) obj).compareTo(format) > 0) {
                                arrayList.add(obj);
                            }
                        }
                        emptySet = arrayList;
                    }
                    keyDates2 = ApiHookRecord.INSTANCE.keyDates();
                    Set<String> stringSet2 = sharedPreferences.getStringSet(keyDates2, null);
                    if (stringSet2 == null) {
                        emptySet2 = SetsKt.emptySet();
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : stringSet2) {
                            Intrinsics.checkExpressionValueIsNotNull(format, "expireDate");
                            if (((String) obj2).compareTo(format) < 0) {
                                arrayList2.add(obj2);
                            }
                        }
                        emptySet2 = arrayList2;
                    }
                    if (emptySet2.isEmpty()) {
                        return;
                    }
                    try {
                        ApiMultiProcessSharedProvider.Editor edit = sharedPreferences.edit();
                        if (edit != null) {
                            keyDates3 = ApiHookRecord.INSTANCE.keyDates();
                            edit.putStringSet(keyDates3, TypeIntrinsics.asMutableSet(emptySet));
                        }
                        for (String str : emptySet2) {
                            ApiHookRecord apiHookRecord2 = ApiHookRecord.INSTANCE;
                            set = ApiHookRecord.STATS_TYPES;
                            for (String str2 : set) {
                                if (edit != null) {
                                    ApiHookRecord apiHookRecord3 = ApiHookRecord.INSTANCE;
                                    Intrinsics.checkExpressionValueIsNotNull(str, "date");
                                    keyCountByDateType = apiHookRecord3.keyCountByDateType(str, str2);
                                    edit.remove(keyCountByDateType);
                                }
                                if (edit != null) {
                                    ApiHookRecord apiHookRecord4 = ApiHookRecord.INSTANCE;
                                    Intrinsics.checkExpressionValueIsNotNull(str, "date");
                                    keyValueByDateType = apiHookRecord4.keyValueByDateType(str, str2);
                                    edit.remove(keyValueByDateType);
                                }
                            }
                        }
                        if (edit != null) {
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
