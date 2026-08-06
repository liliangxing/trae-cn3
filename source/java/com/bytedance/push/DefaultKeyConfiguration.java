package com.bytedance.push;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.push.utils.Logger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.ss.android.push.Triple;
import com.ss.android.pushmanager.KeyConfiguration;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultKeyConfiguration implements KeyConfiguration {
    private static final int MIN_VERSION = 1;
    private final String mChannel;
    private final boolean mIsI18n;

    public Pair<String, String> getMatrixPushConfig() {
        return null;
    }

    public DefaultKeyConfiguration(boolean z, String str) {
        this.mIsI18n = z;
        this.mChannel = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkVersion(Application application) {
        String packageName = application.getPackageName();
        if (this.mIsI18n && !checkConfigurationExist()) {
            Logger.m268d(EventConstants.PARAM_SOURCE_INIT, "i18n version，configuration not exist。ignore!");
        } else {
            if (!TextUtils.equals(packageName, com.bytedance.bytepoet.push.BytePoetConfig.PACKAGE_NAME)) {
                throw new IllegalArgumentException("packageName is different between configuration");
            }
            if (com.bytedance.bytepoet.push.BytePoetConfig.SUPPORT_SDK_VERSION < 1) {
                throw new IllegalArgumentException("configuration version mismatch，please go to [https://appcloud.bytedance.net/client-sdk/config] and generate new configuration again");
            }
        }
    }

    private boolean checkConfigurationExist() {
        try {
            Class.forName("com.bytedance.bytepoet.push.BytePoetConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public Pair<String, String> getMiPushConfig() {
        return new Pair<>(Key.MI_PUSH_APP_ID, Key.MI_PUSH_APP_KEY);
    }

    public Pair<String, String> getMzPushConfig() {
        return new Pair<>(Key.MZ_PUSH_APP_ID, Key.MZ_PUSH_APP_KEY);
    }

    public Pair<String, String> getOpPushConfig() {
        return new Pair<>(Key.OPPO_PUSH_APP_KEY, Key.OPPO_PUSH_APP_SECRET);
    }

    public Triple<String, String, String> getUmPushConfig() {
        return new Triple<String, String, String>() { // from class: com.bytedance.push.DefaultKeyConfiguration.1
            public String getLeft() {
                return Key.UMENG_APP_KEY;
            }

            public String getMiddle() {
                return Key.UMENG_MESSAGE_SECRET;
            }

            public String getRight() {
                return DefaultKeyConfiguration.this.mChannel;
            }
        };
    }
}
