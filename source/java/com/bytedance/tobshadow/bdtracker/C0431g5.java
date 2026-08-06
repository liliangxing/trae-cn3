package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;

/* renamed from: com.bytedance.tobshadow.bdtracker.g5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0431g5 extends AbstractC0410d5 {

    /* renamed from: e */
    public static final String[] f639e = new String[0];

    /* renamed from: f */
    public static boolean f640f;

    /* renamed from: d */
    public final String[] f641d;

    public C0431g5(String str, Context context, String str2) {
        super(str, context, str2);
        SharedPreferences m764a = C0563z4.m764a(context, "security_store_" + str, 0);
        if (m764a.contains("sks_kv")) {
            this.f641d = m764a.getString("sks_kv", "").split("/");
        } else {
            String[] m584a = C0480n5.m584a();
            this.f641d = m584a;
            m764a.edit().putString("sks_kv", m584a[0] + "/" + m584a[1]).apply();
        }
        m451a(m764a, this.f641d);
    }

    public C0431g5(String str, Context context, String str2, String str3) {
        super(str, context, str2);
        String[] strArr = {str3, new String(new byte[16])};
        this.f641d = strArr;
        LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore create use custom key", str);
        SharedPreferences m764a = C0563z4.m764a(context, "security_store_" + str, 0);
        if (m764a.contains("sks_kv")) {
            m764a.edit().remove("sks_kv").apply();
        }
        m451a(m764a, strArr);
    }

    /* renamed from: a */
    public static String m447a(String str, String[] strArr, String str2) {
        if (strArr != null && strArr.length >= 2) {
            String str3 = strArr[0];
            String str4 = strArr[1];
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(2, new SecretKeySpec(str3.getBytes(), "AES"), new IvParameterSpec(str4.getBytes()));
                return new String(cipher.doFinal(Base64.decode(str, 0)));
            } catch (Throwable th) {
                LoggerImpl.global().error("[{}][KVStore]decrypt aes failed", th, str2);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String[] m448a(Context context, String str) {
        String string;
        SharedPreferences m764a = C0563z4.m764a(context, "security_store_" + str, 0);
        if (m764a.contains("sks_kv") && (string = m764a.getString("sks_kv", null)) != null) {
            return string.split("/");
        }
        return f639e;
    }

    /* renamed from: b */
    public static String m449b(String str, String[] strArr, String str2) {
        if (strArr != null && strArr.length >= 2) {
            String str3 = strArr[0];
            String str4 = strArr[1];
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                cipher.init(1, new SecretKeySpec(str3.getBytes(), "AES"), new IvParameterSpec(str4.getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Throwable th) {
                LoggerImpl.global().error("[{}][KVStore]encrypt aes failed", th, str2);
            }
        }
        return str;
    }

    /* renamed from: b */
    public static HashSet<String> m450b(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            HashSet<String> hashSet2 = new HashSet<>();
            for (int i = 0; i < length; i++) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        hashSet2.add(string);
                    }
                } catch (Throwable th) {
                    th = th;
                    hashSet = hashSet2;
                    LoggerImpl.global().error("[{}][KVStore]convertToSet failed", th, str2);
                    return hashSet;
                }
            }
            return hashSet2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public String mo337a() {
        return "sks";
    }

    /* renamed from: a */
    public final void m451a(SharedPreferences sharedPreferences, String[] strArr) {
        if (sharedPreferences.contains("sks_hash")) {
            String string = sharedPreferences.getString("sks_hash", "");
            String m533a = C0473m5.m533a(strArr[0]);
            if (f640f || !Objects.equals(string, m533a)) {
                if (!Objects.equals(string, m533a)) {
                    f640f = true;
                }
                C0424f5.m440a(this.f532a.get(), this.f533b);
            }
        }
        sharedPreferences.edit().putString("sks_hash", C0473m5.m533a(strArr[0])).apply();
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo338a(String str) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkHasKVStoreSwitch failed, preferences == null, key: {}", this.f533b, str);
            return;
        }
        String m251a = C0380a.m251a("", str);
        if (sharedPreferences.contains(m251a)) {
            sharedPreferences.edit().remove(m251a).apply();
            LoggerImpl.global().debug("[{}][KVStore]BaseKVStore remove raw key: {}", this.f533b, m251a);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo343a(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(mo337a() + str, m449b(String.valueOf(z), this.f641d, this.f533b)).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putBooleanInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getBoolean failed, preferences == null, key: {}", this.f533b, str);
            return z;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("", str);
            if (sharedPreferences2.contains(m251a)) {
                boolean z2 = sharedPreferences2.getBoolean(m251a, z);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo343a(str, z2);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.f533b, str);
            }
        }
        String string = sharedPreferences.getString(mo337a() + str, null);
        if (TextUtils.isEmpty(string)) {
            return z;
        }
        try {
            return Boolean.parseBoolean(m447a(string, this.f641d, this.f533b));
        } catch (Throwable th) {
            LoggerImpl.global().error("[{}][KVStore]SecurityKVStore Boolean.parseBoolean failed, key: {}, ", th, this.f533b, str);
            remove(str);
            return z;
        }
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public int getInt(String str, int i) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getInt failed, preferences == null, key: {}", this.f533b, str);
            return i;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("", str);
            if (sharedPreferences2.contains(m251a)) {
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.f533b, str);
                int i2 = sharedPreferences2.getInt(m251a, i);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo339a(str, i2);
            }
        }
        String string = sharedPreferences.getString(mo337a() + str, null);
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        try {
            return Integer.parseInt(m447a(string, this.f641d, this.f533b));
        } catch (Throwable th) {
            LoggerImpl.global().error("[{}][KVStore]SecurityKVStore Integer.parseInt failed, key: {}, ", th, this.f533b, str);
            remove(str);
            return i;
        }
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public long getLong(String str, long j) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getLong failed, preferences == null, key: {}", this.f533b, str);
            return j;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("", str);
            if (sharedPreferences2.contains(m251a)) {
                long j2 = sharedPreferences2.getLong(m251a, j);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo340a(str, j2);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.f533b, str);
            }
        }
        String string = sharedPreferences.getString(mo337a() + str, null);
        if (TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return Long.parseLong(m447a(string, this.f641d, this.f533b));
        } catch (Throwable th) {
            LoggerImpl.global().error("[{}][KVStore]SecurityKVStore Long.parseLong failed, key: {}, ", th, this.f533b, str);
            remove(str);
            return j;
        }
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getString failed, preferences == null, key: {}", this.f533b, str);
            return str2;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("", str);
            if (sharedPreferences2.contains(m251a)) {
                String string = sharedPreferences2.getString(m251a, str2);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                mo341a(str, string);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.f533b, str);
            }
        }
        String string2 = sharedPreferences.getString(mo337a() + str, null);
        return TextUtils.isEmpty(string2) ? str2 : m447a(string2, this.f641d, this.f533b);
    }

    @Override // com.bytedance.tobshadow.applog.store.p007kv.IKVStore
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences == null) {
            LoggerImpl.global().warn("[{}][KVStore]getStringSet failed, preferences == null, key: {}", this.f533b, str);
            return set;
        }
        SharedPreferences sharedPreferences2 = this.f532a.get();
        if (sharedPreferences2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]checkNeedMigrateKV failed, preferences == null, key: {}", this.f533b, str);
        } else {
            String m251a = C0380a.m251a("", str);
            if (sharedPreferences2.contains(m251a)) {
                Set<String> stringSet = sharedPreferences2.getStringSet(m251a, set);
                sharedPreferences2.edit().remove(m251a).apply();
                mo338a(str);
                if (stringSet == null) {
                    stringSet = new HashSet<>();
                }
                mo342a(str, stringSet);
                LoggerImpl.global().debug("[{}][KVStore]SecurityKVStore replace raw key: {}", this.f533b, str);
            }
        }
        return TextUtils.isEmpty(sharedPreferences.getString(new StringBuilder().append(mo337a()).append(str).toString(), null)) ? set : m450b(m447a(sharedPreferences.getString(mo337a() + str, "[]"), this.f641d, this.f533b), this.f533b);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo339a(String str, int i) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(mo337a() + str, m449b(String.valueOf(i), this.f641d, this.f533b)).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putIntInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo340a(String str, long j) {
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(mo337a() + str, m449b(String.valueOf(j), this.f641d, this.f533b)).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putLongInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo341a(String str, String str2) {
        if (str2 == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringInner is null, remove key: {}", this.f533b, str);
            remove(str);
            return;
        }
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(mo337a() + str, m449b(str2, this.f641d, this.f533b)).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putStringInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0410d5
    /* renamed from: a */
    public void mo342a(String str, Set<String> set) {
        if (set == null) {
            LoggerImpl.global().warn("[{}][KVStore]putStringSetInner is null, remove key: {}", this.f533b, str);
            remove(str);
            return;
        }
        SharedPreferences sharedPreferences = this.f532a.get();
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(mo337a() + str, m449b(set.toString(), this.f641d, this.f533b)).apply();
        } else {
            LoggerImpl.global().warn("[{}][KVStore]putStringSetInner failed, preferences == null, key: {}", this.f533b, str);
        }
    }
}
