package com.bytedance.push.task;

import android.content.Context;
import com.bytedance.push.model.TokenCache;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.SettingsManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class TokenStorage {
    private static Map<Integer, TokenCache> sCache;

    TokenStorage() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized TokenCache getBySenderType(Context context, int i) {
        synchronized (TokenStorage.class) {
            awaitLoadCache(context);
            Map<Integer, TokenCache> map = sCache;
            if (map == null) {
                return null;
            }
            return map.get(Integer.valueOf(i));
        }
    }

    private static void awaitLoadCache(Context context) {
        if (sCache != null) {
            return;
        }
        List<TokenCache> tokenCache = ((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).getTokenCache();
        if (tokenCache == null) {
            sCache = new HashMap();
            return;
        }
        HashMap hashMap = new HashMap();
        for (TokenCache tokenCache2 : tokenCache) {
            if (tokenCache2 != null) {
                hashMap.put(Integer.valueOf(tokenCache2.type), tokenCache2);
            }
        }
        sCache = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void save(Context context, TokenCache tokenCache) {
        Map<Integer, TokenCache> map;
        synchronized (TokenStorage.class) {
            awaitLoadCache(context);
            if (tokenCache != null && (map = sCache) != null) {
                map.put(Integer.valueOf(tokenCache.type), tokenCache);
                ((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).setTokenCache(new ArrayList(sCache.values()));
            }
        }
    }

    public static synchronized Map<Integer, TokenCache> getAllToken(Context context) {
        synchronized (TokenStorage.class) {
            awaitLoadCache(context);
            Map<Integer, TokenCache> map = sCache;
            if (map == null) {
                return null;
            }
            return Collections.unmodifiableMap(map);
        }
    }
}
