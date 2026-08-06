package com.lynx.canvas;

import android.app.ActivityManager;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class Krypton {
    public static int FONT_STYLE_ITALIC = 1;
    public static int FONT_STYLE_NORMAL = 0;
    public static int FONT_WEIGHT_BOLD = 700;
    public static int FONT_WEIGHT_NORMAL = 400;
    private static final String TAG = "Krypton";
    private static volatile Krypton sInstance;
    private Context context;
    private volatile boolean hasInit = false;
    private ConcurrentHashMap<String, IKryptonJavaLogger> mLoggerDictionary = new ConcurrentHashMap<>();
    private IKryptonNativeLibraryLoader mNativeLibraryLoader;

    /* loaded from: classes6.dex */
    public interface IKryptonJavaLogger {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface IKryptonNativeLibraryLoader {
        void loadLibrary(String str) throws UnsatisfiedLinkError;
    }

    public native void nativeRegisterLogger(String str, long j);

    public static Krypton inst() {
        if (sInstance == null) {
            synchronized (Krypton.class) {
                if (sInstance == null) {
                    sInstance = new Krypton();
                }
            }
        }
        return sInstance;
    }

    private Krypton() {
    }

    public synchronized void init(IKryptonNativeLibraryLoader iKryptonNativeLibraryLoader, Context context) {
        if (!isES3Supported(context)) {
            KryptonLLog.e(TAG, "Krypton not support with device do not support ES3");
            return;
        }
        if (this.hasInit) {
            KryptonLLog.w(TAG, "Krypton has already been initialized");
            return;
        }
        this.mNativeLibraryLoader = iKryptonNativeLibraryLoader;
        this.context = context;
        if (loadLibrary("lynxbase", true)) {
            if (loadLibrary("krypton", true)) {
                KryptonLLog.i(TAG, "Native Krypton Library load success ");
                this.hasInit = true;
            }
        }
    }

    private static boolean isES3Supported(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 196608;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean hasInitialized() {
        return this.hasInit;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean loadLibrary(String str, boolean z) {
        try {
            IKryptonNativeLibraryLoader iKryptonNativeLibraryLoader = this.mNativeLibraryLoader;
            if (iKryptonNativeLibraryLoader != null) {
                iKryptonNativeLibraryLoader.loadLibrary(str);
                KryptonLLog.i(TAG, "Native library load " + str + " success with native library loader");
                return true;
            }
            System.loadLibrary(str);
            KryptonLLog.i(TAG, "Native library load " + str + " success with System.loadLibrary");
            return true;
        } catch (RuntimeException e) {
            if (z) {
                if (this.mNativeLibraryLoader == null) {
                    KryptonLLog.e(TAG, "Native library load " + str + "from system with runtime exception " + e.getMessage());
                } else {
                    KryptonLLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with runtime exception " + e.getMessage());
                }
            }
            return false;
        } catch (UnsatisfiedLinkError e2) {
            if (z) {
                if (this.mNativeLibraryLoader == null) {
                    KryptonLLog.e(TAG, "Native library load " + str + "from system with error message " + e2.getMessage());
                } else {
                    KryptonLLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with error message " + e2.getMessage());
                }
            }
            return false;
        }
    }

    private static boolean triggerLoadLibrary(String str, boolean z) {
        return inst().loadLibrary(str, z);
    }

    @Deprecated
    public boolean registerFont(String str, String str2, int i, int i2) {
        return CanvasFontRegistry.GetInstance().registerFont(str, str2, i, i2);
    }

    public void registerFontLazyProvider(KryptonFontLazyProvider kryptonFontLazyProvider) {
        CanvasFontRegistry.GetInstance().registerFontLazyProvider(kryptonFontLazyProvider);
    }

    public void registerLogger(String str, IKryptonJavaLogger iKryptonJavaLogger) {
        if (str == null) {
            return;
        }
        if (iKryptonJavaLogger == null) {
            this.mLoggerDictionary.remove(str);
        } else {
            this.mLoggerDictionary.put(str, iKryptonJavaLogger);
        }
    }

    public void setNativeLibraryLoader(IKryptonNativeLibraryLoader iKryptonNativeLibraryLoader) {
        this.mNativeLibraryLoader = iKryptonNativeLibraryLoader;
    }

    public IKryptonNativeLibraryLoader getNativeLibraryLoader() {
        return this.mNativeLibraryLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcurrentHashMap<String, IKryptonJavaLogger> getLoggers() {
        return this.mLoggerDictionary;
    }
}
