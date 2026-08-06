package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import com.bytedance.tobshadow.applog.store.p007kv.KVStoreConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.tobshadow.bdtracker.f5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0424f5 {

    /* renamed from: a */
    public static final Map<String, IKVStore> f602a = new HashMap();

    /* renamed from: a */
    public static IKVStore m438a(Context context, String str) {
        Map<String, IKVStore> map = f602a;
        if (map.containsKey(str)) {
            LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil find KVStore cache, sp_name: {}", "global", str);
            return map.get(str);
        }
        LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil create global default KVStore, sp_name: {}", "global", str);
        C0417e5 c0417e5 = new C0417e5("global", context, str);
        map.put(str, c0417e5);
        return c0417e5;
    }

    /* renamed from: a */
    public static IKVStore m439a(InitConfig initConfig, Context context, String str) {
        String str2;
        IKVStore c0417e5;
        KVStoreConfig kVStoreConfig = KVStoreConfig.DEFAULT_CONFIG;
        if (initConfig != null) {
            kVStoreConfig = initConfig.getKvStoreConfig();
            str2 = initConfig.getAid();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]KVStoreUtil createKVStore init config is null", "");
            str2 = "";
        }
        Map<String, IKVStore> map = f602a;
        if (map.containsKey(str)) {
            LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil find KVStore cache, sp_name: {}", str2, str);
            return map.get(str);
        }
        if (kVStoreConfig.isSecurityMode()) {
            String aesKey = kVStoreConfig.getAesKey();
            try {
                LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil createKVStore use SecurityKVStore, sp_name: {}", str2, str);
                c0417e5 = TextUtils.isEmpty(aesKey) ? new C0431g5(str2, context, str) : new C0431g5(str2, context, str, aesKey);
            } catch (Exception e) {
                LoggerImpl.global().error("[{}][KVStore]KVStoreUtil createKVStore use SecurityKVStore failed, use DefaultKVStore, sp_name: {}", e, str2, str);
                m440a(C0563z4.m764a(context, str, 0), str2);
                c0417e5 = new C0417e5(str2, context, str);
            }
        } else {
            LoggerImpl.global().debug("[{}][KVStore]KVStoreUtil createKVStore use DefaultKVStore, sp_name: {}", str2, str);
            c0417e5 = new C0417e5(str2, context, str);
        }
        f602a.put(str, c0417e5);
        return c0417e5;
    }

    /* renamed from: a */
    public static void m440a(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            LoggerImpl.global().debug("[{}][KVStore]kv clear failed, preferences == null: {}", str);
            return;
        }
        for (String str2 : sharedPreferences.getAll().keySet()) {
            sharedPreferences.edit().remove(str2).apply();
            LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore kv change, delete key: {}", str, str2);
        }
    }
}
