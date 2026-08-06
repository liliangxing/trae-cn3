package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SlardarProperties {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static Properties mProperties;

    private static void tryLoadPropertiesFromApk() {
        InputStream inputStream;
        Context context = ApmContext.getContext();
        if (mProperties == null) {
            mProperties = new Properties();
            try {
                inputStream = context.getApplicationContext().getAssets().open(PROPERTIES_PATH);
            } catch (Throwable unused) {
                inputStream = null;
            }
            try {
                mProperties.load(inputStream);
            } catch (Throwable unused2) {
                try {
                    mProperties = null;
                } finally {
                    IOUtils.closeQuietly(inputStream);
                }
            }
        }
    }

    private static Object readKey(String str) {
        tryLoadPropertiesFromApk();
        try {
            Properties properties = mProperties;
            if (properties == null || !properties.containsKey(str)) {
                return null;
            }
            return mProperties.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getReleaseBuild() {
        return String.valueOf(readKey("release_build"));
    }
}
