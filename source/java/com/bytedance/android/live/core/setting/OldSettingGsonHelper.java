package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.setting.p027v2.helper.SettingBooleanTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
class OldSettingGsonHelper {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class SingletonHolder {
        private static final GsonBuilder sBuilder;
        private static final Gson sInstance;

        private SingletonHolder() {
        }

        static {
            GsonBuilder registerTypeAdapter = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Boolean.class, new SettingBooleanTypeAdapter()).registerTypeAdapter(Boolean.TYPE, new SettingBooleanTypeAdapter());
            sBuilder = registerTypeAdapter;
            sInstance = registerTypeAdapter.create();
        }
    }

    OldSettingGsonHelper() {
    }

    public static Gson get() {
        return SingletonHolder.sInstance;
    }
}
