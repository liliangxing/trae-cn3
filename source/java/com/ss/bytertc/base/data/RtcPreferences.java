package com.ss.bytertc.base.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.realx.base.ContextUtils;
import com.ss.bytertc.engine.utils.LogUtil;
import java.io.UnsupportedEncodingException;

/* loaded from: classes7.dex */
public class RtcPreferences {
    public static final String ONER_RTC_PREFERENCE = "oner_rtc_preference";
    public static final String PREF_CONFIGURE = "pref_configure";
    public static final String PREF_FEEDBACK = "pref_rtc_feedback_data";
    public static final String PREF_HOST_RTT_HISTORY = "pref_host_rtt_history";
    private static final String RTC_PREFERENCE = "rtc_preference";
    private static final String TAG = "RtcPreferences";
    private static volatile RtcPreferences sInstance;
    private final SharedPreferences mSharedPreferences;

    private RtcPreferences(Context applicationContext) {
        this.mSharedPreferences = applicationContext.getSharedPreferences(RTC_PREFERENCE, 0);
    }

    public static RtcPreferences instance(Context context) {
        try {
            if (sInstance == null) {
                synchronized (RtcPreferences.class) {
                    try {
                        if (context == null) {
                            throw new RuntimeException("unable to init RtcPreferences without context");
                        }
                        if (sInstance == null) {
                            sInstance = new RtcPreferences(context);
                        }
                    } finally {
                    }
                }
            }
            return sInstance;
        } catch (OutOfMemoryError unused) {
            Log.e(TAG, "create SharedPreferences failed as out of memory");
            return null;
        }
    }

    public void remove(String key) {
        if (key == null) {
            return;
        }
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.remove(key);
        edit.apply();
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public int getInt(String key, int defValue) {
        return this.mSharedPreferences.getInt(key, defValue);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public String getString(String key, String defValue) {
        String string = this.mSharedPreferences.getString(key, defValue);
        try {
            string.getBytes(Constant.CHARSET_UTF_8);
            return string;
        } catch (UnsupportedEncodingException e) {
            LogUtil.e(TAG, "Unable to get bytes use utf-8", e);
            return "";
        }
    }

    private static RtcPreferences getInstance() {
        return instance(ContextUtils.getApplicationContext());
    }

    private void clearCache() {
        this.mSharedPreferences.edit().clear().commit();
    }
}
