package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SPCache extends Cache {
    private final InstallOptions installOptions;
    private final Context mContext;
    private final SharedPreferences mSharedPref;

    public SPCache(Context context, SharedPreferences sharedPreferences, InstallOptions installOptions) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.mContext = context;
        this.mSharedPref = sharedPreferences;
        this.installOptions = installOptions;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String str, String str2) {
        storeValue(str, str2);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String str) {
        return getValue(str);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String str) {
        String value = getValue(str);
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return value.split("\n");
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        storeValue(str, TextUtils.join("\n", strArr));
    }

    private String getValue(String str) {
        return getSp(str).getString(str, null);
    }

    private void storeValue(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = getSp(str).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private SharedPreferences getSp(String str) {
        if ("device_id".equals(str) || "install_id".equals(str) || "bd_did".equals(str)) {
            return this.mSharedPref;
        }
        return LocalConstants.getCommonSp(this.mContext, this.installOptions);
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> list) {
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                SharedPreferences sp = getSp(str);
                SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(sp);
                if (editor == null) {
                    editor = getSp(str).edit();
                    hashMap.put(sp, editor);
                }
                if (sp != null && sp.contains(str)) {
                    editor.remove(str);
                }
            }
        }
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            ((SharedPreferences.Editor) ((Map.Entry) it.next()).getValue()).apply();
        }
        super.clear(list);
    }
}
