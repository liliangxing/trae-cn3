package com.bytedance.push.settings.storage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;

/* loaded from: classes4.dex */
final class ContainsProcessor implements Processor {
    private static final String KEY = "_key";
    static final String METHOD = "_contains";
    private static final String RESULT = "_result";
    private static final String STORAGE_KEY = "_storage_key";

    @Override // com.bytedance.push.settings.storage.Processor
    public String getMethodName() {
        return METHOD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle createArgs(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(STORAGE_KEY, str);
        bundle.putString(KEY, str2);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean parseResult(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(RESULT);
    }

    @Override // com.bytedance.push.settings.storage.Processor
    public Bundle process(Context context, String str, Bundle bundle, String str2) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(STORAGE_KEY);
        String string2 = bundle.getString(KEY);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        SettingsLoggerHelper.getInstance().d("process for " + string);
        bundle2.putBoolean(RESULT, SettingsManager.getStorageFactory().create(context, true, string, str2).contains(string2));
        return bundle2;
    }
}
