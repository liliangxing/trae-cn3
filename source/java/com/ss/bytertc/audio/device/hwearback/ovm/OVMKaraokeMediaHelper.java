package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import com.bytedance.realx.base.RXLogging;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class OVMKaraokeMediaHelper {
    private static final String TAG = "OVMKaraokeMediaHelper";
    private Object helper;
    private Map<String, Method> methodCache = new ConcurrentHashMap();

    public static OVMKaraokeMediaHelper create(Context context) {
        try {
            return new OVMKaraokeMediaHelper(Class.forName("com.itgsa.opensdk.mediaunit.KaraokeMediaHelper").getConstructor(Context.class).newInstance(context));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private OVMKaraokeMediaHelper(Object helper) {
        this.helper = helper;
    }

    public void setListenRecordSame(int param) {
        try {
            Method method = getMethod("setListenRecordSame", Integer.TYPE);
            if (method != null) {
                method.invoke(this.helper, Integer.valueOf(param));
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "setListenRecordSame operate not allowed", th);
        }
    }

    public int getListenRecordSame() {
        try {
            Method method = getMethod("getListenRecordSame", new Class[0]);
            if (method != null) {
                return ((Integer) method.invoke(this.helper, new Object[0])).intValue();
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "getListenRecordSame operate not allowed", th);
        }
        return 0;
    }

    public int getVersion() {
        try {
            Method method = getMethod("getVersion", new Class[0]);
            if (method != null) {
                return ((Integer) method.invoke(this.helper, new Object[0])).intValue();
            }
            return -1;
        } catch (Throwable th) {
            RXLogging.e(TAG, "getPlayFeedbackParam operate not allowed", th);
            return -1;
        }
    }

    public boolean isDeviceSupportKaraoke() {
        try {
            Method method = getMethod("isDeviceSupportKaraoke", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(this.helper, new Object[0])).booleanValue();
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "isDeviceSupportKaraoke operate not allowed", th);
        }
        return false;
    }

    public boolean isAppSupportKaraoke(String appName) {
        try {
            Method method = getMethod("isAppSupportKaraoke", String.class);
            if (method != null) {
                return ((Boolean) method.invoke(this.helper, appName)).booleanValue();
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "isAppSupportKaraoke operate not allowed", th);
        }
        return false;
    }

    public String getKaraokeSupportParameters() {
        try {
            Method method = getMethod("getKaraokeSupportParameters", new Class[0]);
            return method != null ? (String) method.invoke(this.helper, new Object[0]) : "";
        } catch (Throwable th) {
            RXLogging.e(TAG, "getKaraokeSupportParameters operate not allowed", th);
            return "";
        }
    }

    public void openKTVDevice() {
        try {
            Method method = getMethod("openKTVDevice", new Class[0]);
            if (method != null) {
                method.invoke(this.helper, new Object[0]);
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "openKTVDevice operate not allowed", th);
        }
    }

    public void closeKTVDevice() {
        try {
            Method method = getMethod("closeKTVDevice", new Class[0]);
            if (method != null) {
                method.invoke(this.helper, new Object[0]);
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "closeKTVDevice operate not allowed", th);
        }
    }

    public void setPlayFeedbackParam(int param) {
        try {
            Method method = getMethod("setPlayFeedbackParam", Integer.TYPE);
            if (method != null) {
                method.invoke(this.helper, Integer.valueOf(param));
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "setPlayFeedbackParam operate not allowed", th);
        }
    }

    public int getPlayFeedbackParam() {
        try {
            Method method = getMethod("getPlayFeedbackParam", new Class[0]);
            if (method != null) {
                return ((Integer) method.invoke(this.helper, new Object[0])).intValue();
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "getPlayFeedbackParam operate not allowed", th);
        }
        return 0;
    }

    public void setMicVolParam(int param) {
        try {
            Method method = getMethod("setMicVolParam", Integer.TYPE);
            if (method != null) {
                method.invoke(this.helper, Integer.valueOf(param));
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "setMicVolParam operate not allowed", th);
        }
    }

    public int getMicVolParam() {
        try {
            Method method = getMethod("getMicVolParam", new Class[0]);
            if (method != null) {
                return ((Integer) method.invoke(this.helper, new Object[0])).intValue();
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "getMicVolParam operate not allowed", th);
        }
        return 0;
    }

    public void setMixerSoundType(int param) {
        try {
            Method method = getMethod("setMixerSoundType", Integer.TYPE);
            if (method != null) {
                method.invoke(this.helper, Integer.valueOf(param));
            }
        } catch (Throwable th) {
            RXLogging.e(TAG, "setMixerSoundType operate not allowed", th);
        }
    }

    public void setEqualizerType(int equalizerType) {
        try {
            Method method = getMethod("setEqualizerType", Integer.TYPE);
            if (method != null) {
                method.invoke(this.helper, Integer.valueOf(equalizerType));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            RXLogging.e(TAG, "setEqualizerType operate not allowed", th);
        }
    }

    private Method getMethod(String methodName, Class<?>... types) {
        Method method = this.methodCache.get(methodName);
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.helper.getClass().getMethod(methodName, types);
            this.methodCache.put(methodName, method2);
            return method2;
        } catch (Throwable th) {
            RXLogging.e(TAG, "Can not get method: " + methodName, th);
            return null;
        }
    }
}
