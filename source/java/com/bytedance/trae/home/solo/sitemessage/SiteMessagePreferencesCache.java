package com.bytedance.trae.home.solo.sitemessage;

import android.content.SharedPreferences;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SiteMessagePreferencesCache.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010$\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010&\u001a\u00020\"J\u0011\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0002J\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u0016\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\u0010\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_PREFERENCES", "KEY_ITEMS", "gson", "Lcom/google/gson/Gson;", "memoryPreferences", "", "", "memoryItems", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "cacheKeySuffix", "getCacheKeySuffix", "()Ljava/lang/String;", "storeCountryCode", "getStoreCountryCode", "enabledTypes", "getEnabledTypes", "currentPreferences", "getCurrentPreferences", "()Ljava/util/Map;", "currentItems", "getCurrentItems", "()Ljava/util/List;", "save", "", SiteMessagePreferencesCache.KEY_PREFERENCES, "saveItems", SiteMessagePreferencesCache.KEY_ITEMS, "clear", ApiRequest.METHOD_GET, "key", "defaultPreferences", "loadFromDisk", "loadItemsFromDisk", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessagePreferencesCache {
    private static final String KEY_ITEMS = "items";
    private static final String KEY_PREFERENCES = "preferences";
    private static final String PREFS_NAME = "site_message_preferences";
    private static volatile List<SiteMessagePreferencesTypeItem> memoryItems;
    private static volatile Map<String, Boolean> memoryPreferences;
    public static final SiteMessagePreferencesCache INSTANCE = new SiteMessagePreferencesCache();
    private static final Gson gson = new Gson();
    public static final int $stable = 8;

    private SiteMessagePreferencesCache() {
    }

    private final SharedPreferences getPrefs() {
        SharedPreferences sharedPreferences = AppHost.INSTANCE.getApplication().getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    private final String getCacheKeySuffix() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        return userId == null ? "" : userId;
    }

    public final String getStoreCountryCode() {
        String country = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        return country;
    }

    public final String getEnabledTypes() {
        Map<String, Boolean> currentPreferences = getCurrentPreferences();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Boolean> entry : currentPreferences.entrySet()) {
            if (entry.getValue().booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        List sorted = CollectionsKt.sorted(linkedHashMap.keySet());
        return sorted.isEmpty() ? "offers,tips,account,feedback" : CollectionsKt.joinToString$default(sorted, IWeiboService.Scope.EMPTY_SCOPE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final Map<String, Boolean> getCurrentPreferences() {
        synchronized (this) {
            Map<String, Boolean> map = memoryPreferences;
            if (map != null) {
                return map;
            }
            SiteMessagePreferencesCache siteMessagePreferencesCache = INSTANCE;
            Map<String, Boolean> loadFromDisk = siteMessagePreferencesCache.loadFromDisk();
            if (loadFromDisk != null) {
                memoryPreferences = loadFromDisk;
                return loadFromDisk;
            }
            return siteMessagePreferencesCache.defaultPreferences();
        }
    }

    public final List<SiteMessagePreferencesTypeItem> getCurrentItems() {
        synchronized (this) {
            List<SiteMessagePreferencesTypeItem> list = memoryItems;
            if (list != null) {
                return list;
            }
            List<SiteMessagePreferencesTypeItem> loadItemsFromDisk = INSTANCE.loadItemsFromDisk();
            if (loadItemsFromDisk != null) {
                memoryItems = loadItemsFromDisk;
            } else {
                loadItemsFromDisk = null;
            }
            return loadItemsFromDisk;
        }
    }

    public final void save(Map<String, Boolean> preferences) {
        Intrinsics.checkNotNullParameter(preferences, KEY_PREFERENCES);
        memoryPreferences = preferences;
        getPrefs().edit().putString("preferences." + getCacheKeySuffix(), gson.toJson(preferences)).apply();
    }

    public final void saveItems(List<SiteMessagePreferencesTypeItem> items) {
        Intrinsics.checkNotNullParameter(items, KEY_ITEMS);
        memoryItems = items;
        getPrefs().edit().putString("items." + getCacheKeySuffix(), gson.toJson(items)).apply();
    }

    public final void clear() {
        memoryPreferences = null;
        memoryItems = null;
        String cacheKeySuffix = getCacheKeySuffix();
        getPrefs().edit().remove("preferences." + cacheKeySuffix).remove("items." + cacheKeySuffix).apply();
    }

    public final boolean get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Boolean bool = getCurrentPreferences().get(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final Map<String, Boolean> defaultPreferences() {
        return StringsKt.equals(getStoreCountryCode(), "DE", true) ? MapsKt.mapOf(new Pair[]{TuplesKt.to("offers", false), TuplesKt.to("tips", false), TuplesKt.to(SettingsTracker.TYPE_ACCOUNT, true), TuplesKt.to("feedback", false)}) : MapsKt.mapOf(new Pair[]{TuplesKt.to("offers", true), TuplesKt.to("tips", true), TuplesKt.to(SettingsTracker.TYPE_ACCOUNT, true), TuplesKt.to("feedback", true)});
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesCache$loadFromDisk$1] */
    private final Map<String, Boolean> loadFromDisk() {
        String string = getPrefs().getString("preferences." + getCacheKeySuffix(), null);
        if (string == null) {
            return null;
        }
        try {
            return (Map) gson.fromJson(string, new TypeToken<Map<String, ? extends Boolean>>() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesCache$loadFromDisk$1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesCache$loadItemsFromDisk$1] */
    private final List<SiteMessagePreferencesTypeItem> loadItemsFromDisk() {
        String string = getPrefs().getString("items." + getCacheKeySuffix(), null);
        if (string == null) {
            return null;
        }
        try {
            return (List) gson.fromJson(string, new TypeToken<List<? extends SiteMessagePreferencesTypeItem>>() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesCache$loadItemsFromDisk$1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }
}
