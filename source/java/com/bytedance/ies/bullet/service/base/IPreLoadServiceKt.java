package com.bytedance.ies.bullet.service.base;

import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IPreLoadService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\n\u001a\u00020\u000b*\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000eH\u0086\bø\u0001\u0000\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u000f\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0001\u001a\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014*\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000*j\u0010\u0015\"2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\u001622\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000b0\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"HIGH", "", "LOW", "MEMORY_PRIORITY", "", "MEMORY_PRIORITY_HIGH", "MIDDLE", "TEMPLATE_STRATEGY_ONLY_EXIST", "TEMPLATE_STRATEGY_UPDATE_AND_CACHE", "TEMPLATE_STRATEGY_UPDATE_NOT_CACHE", "forEach", "", "Lorg/json/JSONArray;", "action", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "toPreloadConfig", "Lcom/bytedance/ies/bullet/service/base/PreloadConfig;", "toPreloadPriority", "toStringList", "", "PreLoadCallBack", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/bytedance/ies/bullet/service/base/PreLoadResult;", "code", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IPreLoadServiceKt {
    public static final int HIGH = 3;
    public static final int LOW = 1;
    public static final String MEMORY_PRIORITY = "memory_cache_priority";
    public static final String MEMORY_PRIORITY_HIGH = "high";
    public static final int MIDDLE = 2;
    public static final int TEMPLATE_STRATEGY_ONLY_EXIST = 0;
    public static final int TEMPLATE_STRATEGY_UPDATE_AND_CACHE = 1;
    public static final int TEMPLATE_STRATEGY_UPDATE_NOT_CACHE = 2;

    public static final int toPreloadPriority(int i) {
        if (i != 0) {
            return i != 1 ? 3 : 2;
        }
        return 1;
    }

    public static final List<String> toStringList(JSONArray jSONArray) {
        int length;
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        if (jSONArray.length() > 0 && jSONArray.length() - 1 >= 0) {
            int i = 0;
            while (true) {
                if (jSONArray.get(i) instanceof String) {
                    Object obj = jSONArray.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add((String) obj);
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x018d, code lost:
    
        if (r0 == null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PreloadConfig toPreloadConfig(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        int i;
        JSONArray jSONArray3;
        ArrayList arrayList6;
        ArrayList arrayList7;
        int i2;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        JSONArray jSONArray6;
        ArrayList arrayList12;
        JSONArray jSONArray7;
        ArrayList arrayList13;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("font");
        JSONArray optJSONArray3 = jSONObject.optJSONArray(FetchTokenInfoThread.VIDEO_TOKEN);
        JSONArray optJSONArray4 = jSONObject.optJSONArray("gecko_channel");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("js");
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            arrayList3 = arrayList18;
            int i3 = 0;
            while (i3 < length) {
                int i4 = length;
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                String optString = jSONObject2.optString("url");
                if (optString == null || optString.length() == 0) {
                    jSONArray6 = optJSONArray5;
                    jSONArray5 = optJSONArray;
                    jSONArray7 = optJSONArray4;
                    arrayList12 = arrayList17;
                    arrayList13 = arrayList16;
                } else {
                    jSONArray5 = optJSONArray;
                    jSONArray6 = optJSONArray5;
                    String optString2 = jSONObject2.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString2, "item.optString(\"url\")");
                    arrayList12 = arrayList17;
                    jSONArray7 = optJSONArray4;
                    arrayList13 = arrayList16;
                    arrayList14.add(new PreloadImageConfig(optString2, toPreloadPriority(jSONObject2.optInt(LynxImageService.PRIORITY_KEY, 0)), jSONObject2.optBoolean("serial", false), jSONObject2.optBoolean("enableMemory", true)));
                }
                i3++;
                length = i4;
                optJSONArray = jSONArray5;
                optJSONArray5 = jSONArray6;
                arrayList17 = arrayList12;
                optJSONArray4 = jSONArray7;
                arrayList16 = arrayList13;
            }
            jSONArray = optJSONArray5;
            jSONArray2 = optJSONArray4;
            arrayList = arrayList17;
            arrayList2 = arrayList16;
        } else {
            jSONArray = optJSONArray5;
            jSONArray2 = optJSONArray4;
            arrayList = arrayList17;
            arrayList2 = arrayList16;
            arrayList3 = arrayList18;
        }
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            int i5 = 0;
            while (i5 < length2) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i5);
                String optString3 = jSONObject3.optString("url");
                if (optString3 == null || optString3.length() == 0) {
                    jSONArray4 = optJSONArray2;
                } else {
                    String optString4 = jSONObject3.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString4, "item.optString(\"url\")");
                    jSONArray4 = optJSONArray2;
                    arrayList15.add(new PreloadFontConfig(optString4, toPreloadPriority(jSONObject3.optInt(LynxImageService.PRIORITY_KEY, 0)), jSONObject3.optBoolean("serial", false), jSONObject3.optBoolean("enableMemory", true), jSONObject3.optLong(IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, 600000L)));
                }
                i5++;
                optJSONArray2 = jSONArray4;
            }
        }
        if (optJSONArray3 != null) {
            int length3 = optJSONArray3.length();
            int i6 = 0;
            while (i6 < length3) {
                JSONObject jSONObject4 = optJSONArray3.getJSONObject(i6);
                String optString5 = jSONObject4.optString("id");
                if (optString5 == null || optString5.length() == 0) {
                    i2 = length3;
                    arrayList9 = arrayList14;
                    arrayList10 = arrayList15;
                    arrayList11 = arrayList2;
                } else {
                    String optString6 = jSONObject4.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString6, "item.optString(\"id\")");
                    boolean optBoolean = jSONObject4.optBoolean("h265", true);
                    String optString7 = jSONObject4.optString("uri");
                    Intrinsics.checkNotNullExpressionValue(optString7, "item.optString(\"uri\")");
                    JSONArray jSONArray8 = jSONObject4.getJSONArray("url");
                    i2 = length3;
                    if (jSONArray8 != null) {
                        Intrinsics.checkNotNullExpressionValue(jSONArray8, "getJSONArray(\"url\")");
                        arrayList8 = toStringList(jSONArray8);
                    }
                    arrayList8 = new ArrayList();
                    arrayList9 = arrayList14;
                    arrayList10 = arrayList15;
                    PreloadVideoConfig preloadVideoConfig = new PreloadVideoConfig(optString6, optBoolean, optString7, arrayList8, toPreloadPriority(jSONObject4.optInt(LynxImageService.PRIORITY_KEY, 0)), jSONObject4.optBoolean("serial", false), jSONObject4.optBoolean("enableMemory", true), jSONObject4.optLong(IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, 600000L));
                    arrayList11 = arrayList2;
                    arrayList11.add(preloadVideoConfig);
                }
                i6++;
                arrayList2 = arrayList11;
                arrayList14 = arrayList9;
                length3 = i2;
                arrayList15 = arrayList10;
            }
        }
        ArrayList arrayList19 = arrayList14;
        ArrayList arrayList20 = arrayList15;
        ArrayList arrayList21 = arrayList2;
        if (jSONArray2 != null) {
            int length4 = jSONArray2.length();
            int i7 = 0;
            while (i7 < length4) {
                JSONArray jSONArray9 = jSONArray2;
                JSONObject jSONObject5 = jSONArray9.getJSONObject(i7);
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "this.getJSONObject(i)");
                String optString8 = jSONObject5.optString("channel");
                if (optString8 == null || optString8.length() == 0) {
                    arrayList7 = arrayList;
                } else {
                    String optString9 = jSONObject5.optString("channel");
                    Intrinsics.checkNotNullExpressionValue(optString9, "it.optString(\"channel\")");
                    PreloadGeckoChannelConfig preloadGeckoChannelConfig = new PreloadGeckoChannelConfig(optString9, toPreloadPriority(jSONObject5.optInt(LynxImageService.PRIORITY_KEY, 0)), false, 4, null);
                    arrayList7 = arrayList;
                    arrayList7.add(preloadGeckoChannelConfig);
                }
                i7++;
                jSONArray2 = jSONArray9;
                arrayList = arrayList7;
            }
        }
        ArrayList arrayList22 = arrayList;
        if (jSONArray != null) {
            int length5 = jSONArray.length();
            int i8 = 0;
            while (i8 < length5) {
                JSONArray jSONArray10 = jSONArray;
                JSONObject jSONObject6 = jSONArray10.getJSONObject(i8);
                String optString10 = jSONObject6.optString("url");
                if (optString10 == null || optString10.length() == 0) {
                    i = length5;
                    jSONArray3 = jSONArray10;
                    arrayList6 = arrayList3;
                } else {
                    String optString11 = jSONObject6.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString11, "item.optString(\"url\")");
                    int preloadPriority = toPreloadPriority(jSONObject6.optInt(LynxImageService.PRIORITY_KEY, 0));
                    boolean optBoolean2 = jSONObject6.optBoolean("serial", false);
                    boolean optBoolean3 = jSONObject6.optBoolean("enableMemory", true);
                    String optString12 = jSONObject6.optString("memoryPriority");
                    i = length5;
                    Intrinsics.checkNotNullExpressionValue(optString12, "item.optString(\"memoryPriority\")");
                    jSONArray3 = jSONArray10;
                    PreloadJsConfig preloadJsConfig = new PreloadJsConfig(optString11, preloadPriority, optBoolean2, optBoolean3, optString12, jSONObject6.optLong(IPiaCacheProvider.CacheConfig.FIELD_EXPIRE, 600000L));
                    arrayList6 = arrayList3;
                    arrayList6.add(preloadJsConfig);
                }
                i8++;
                arrayList3 = arrayList6;
                length5 = i;
                jSONArray = jSONArray3;
            }
        }
        ArrayList arrayList23 = arrayList3;
        if (arrayList22.size() > 1) {
            CollectionsKt.sortWith(arrayList22, new Comparator<T>() { // from class: com.bytedance.ies.bullet.service.base.IPreLoadServiceKt$toPreloadConfig$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((PreloadGeckoChannelConfig) t2).getPriority()), Integer.valueOf(((PreloadGeckoChannelConfig) t).getPriority()));
                }
            });
        }
        if (arrayList19.size() > 1) {
            arrayList4 = arrayList19;
            CollectionsKt.sortWith(arrayList4, new Comparator<T>() { // from class: com.bytedance.ies.bullet.service.base.IPreLoadServiceKt$toPreloadConfig$$inlined$sortByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((PreloadImageConfig) t2).getPriority()), Integer.valueOf(((PreloadImageConfig) t).getPriority()));
                }
            });
        } else {
            arrayList4 = arrayList19;
        }
        if (arrayList20.size() > 1) {
            arrayList5 = arrayList20;
            CollectionsKt.sortWith(arrayList5, new Comparator<T>() { // from class: com.bytedance.ies.bullet.service.base.IPreLoadServiceKt$toPreloadConfig$$inlined$sortByDescending$3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((PreloadFontConfig) t2).getPriority()), Integer.valueOf(((PreloadFontConfig) t).getPriority()));
                }
            });
        } else {
            arrayList5 = arrayList20;
        }
        if (arrayList21.size() > 1) {
            CollectionsKt.sortWith(arrayList21, new Comparator<T>() { // from class: com.bytedance.ies.bullet.service.base.IPreLoadServiceKt$toPreloadConfig$$inlined$sortByDescending$4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((PreloadVideoConfig) t2).getPriority()), Integer.valueOf(((PreloadVideoConfig) t).getPriority()));
                }
            });
        }
        return new PreloadConfig(arrayList22, arrayList4, arrayList5, arrayList21, arrayList23);
    }

    public static final void forEach(JSONArray jSONArray, Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "this.getJSONObject(i)");
            function1.invoke(jSONObject);
        }
    }
}
