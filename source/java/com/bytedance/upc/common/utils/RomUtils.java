package com.bytedance.upc.common.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.ss.reflector.IReflector;
import com.bytedance.ss.reflector.ReflectorFactory;

/* loaded from: classes6.dex */
public class RomUtils {
    private static volatile RomUtils romUtils;
    private volatile Object mSystemProperties;
    String sColorVersion;
    String sEmuiVersion;
    String sFuntouchVersion;
    String sMiVersion;
    private String TAG = "RomUtils";
    public final String RUNTIME_OP = "ro.build.version.opporom";
    private final String FUNTOUCH_OS_VERSION = "ro.vivo.os.build.display.id";
    private final String VERSION_EMUI = "ro.build.version.emui";
    private final String OP = "oppo";
    private IReflector reflector = ReflectorFactory.getReflector();
    private int sMiuiVersion = -1;
    private double mEmuiOsVersionCode = -1.0d;
    private double mColorOsVersionCode = -1.0d;
    private double mFuntouchOsVersionCode = -1.0d;

    public static RomUtils getInstance() {
        if (romUtils == null) {
            synchronized (RomUtils.class) {
                if (romUtils == null) {
                    romUtils = new RomUtils();
                }
            }
        }
        return romUtils;
    }

    private RomUtils() {
    }

    private Object getSystemProperties() {
        if (this.mSystemProperties == null) {
            synchronized (RomUtils.class) {
                if (this.mSystemProperties == null) {
                    try {
                        this.mSystemProperties = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return this.mSystemProperties;
    }

    public boolean isMiOS() {
        if (TextUtils.isEmpty(this.sMiVersion)) {
            try {
                this.sMiVersion = get("ro.miui.ui.version.name");
            } catch (Throwable unused) {
            }
        }
        return !TextUtils.isEmpty(this.sMiVersion);
    }

    public boolean isMi12() {
        return getMiuiVersion() == 12;
    }

    private void initMiuiVersion() {
        if (this.sMiuiVersion == -1) {
            try {
                String str = (String) ReflectorFactory.getReflector().getMethod(this.reflector.getClass("android.os.SystemProperties"), "get", String.class, String.class).invoke(null, "ro.miui.ui.version.name", "");
                if (str != null && str.length() > 0 && str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    this.sMiuiVersion = Integer.parseInt(str.length() > 3 ? str.substring(1, 3) : str.substring(1));
                    return;
                }
            } catch (Exception unused) {
            }
            this.sMiuiVersion = 0;
        }
    }

    public boolean isHigherMi12V2() {
        initMiuiVersion();
        return this.sMiuiVersion >= 12;
    }

    public boolean isHigherMi12() {
        return getMiuiVersion() > 12;
    }

    private int getMiuiVersion() {
        if (!isMiOS()) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(this.sMiVersion) && this.sMiVersion.length() >= 2) {
                String substring = this.sMiVersion.substring(1);
                if (substring.indexOf(LibrarianImpl.Constants.DOT) > 0) {
                    substring = substring.substring(0, substring.indexOf(LibrarianImpl.Constants.DOT));
                }
                int parseInt = Integer.parseInt(substring);
                return parseInt >= 100 ? parseInt / 10 : parseInt;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public boolean isColorOS() {
        if (TextUtils.isEmpty(this.sColorVersion)) {
            this.sColorVersion = get("ro.build.version.opporom");
        }
        return !TextUtils.isEmpty(this.sColorVersion);
    }

    public boolean isHigherColor7() {
        try {
            if (!isColorOS()) {
                return false;
            }
            if (this.mColorOsVersionCode == -1.0d && !TextUtils.isEmpty(this.sColorVersion) && this.sColorVersion.length() >= 2) {
                String substring = this.sColorVersion.substring(1);
                if (substring.indexOf(LibrarianImpl.Constants.DOT) > 0) {
                    substring = substring.substring(0, substring.indexOf(LibrarianImpl.Constants.DOT));
                }
                this.mColorOsVersionCode = Double.parseDouble(substring);
            }
            return this.mColorOsVersionCode >= 7.0d;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isFuntouchOS() {
        if (TextUtils.isEmpty(this.sFuntouchVersion)) {
            this.sFuntouchVersion = get("ro.vivo.os.build.display.id");
        }
        return !TextUtils.isEmpty(this.sFuntouchVersion);
    }

    public boolean isLessFuntouch4() {
        if (!isFuntouchOS()) {
            return false;
        }
        try {
            if (this.mFuntouchOsVersionCode == -1.0d && !TextUtils.isEmpty(this.sFuntouchVersion) && this.sFuntouchVersion.length() >= 2) {
                String str = this.sFuntouchVersion;
                String substring = str.substring(str.indexOf("_") + 1);
                if (substring.indexOf(LibrarianImpl.Constants.DOT) > 0) {
                    substring = substring.substring(0, substring.indexOf(LibrarianImpl.Constants.DOT));
                }
                this.mFuntouchOsVersionCode = Double.parseDouble(substring);
            }
            return this.mFuntouchOsVersionCode <= 4.0d;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isEMUI() {
        if (TextUtils.isEmpty(this.sEmuiVersion)) {
            this.sEmuiVersion = get("ro.build.version.emui");
        }
        return !TextUtils.isEmpty(this.sEmuiVersion);
    }

    public boolean isHwDevice() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("hua")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("hua")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isLessEmui5() {
        if (!isEMUI()) {
            return false;
        }
        try {
            if (this.mEmuiOsVersionCode == -1.0d) {
                if (TextUtils.isEmpty(this.sEmuiVersion)) {
                    return false;
                }
                String str = this.sEmuiVersion;
                String substring = str.substring(str.indexOf("_") + 1);
                if (substring.indexOf(LibrarianImpl.Constants.DOT) > 0) {
                    substring = substring.substring(0, substring.indexOf(LibrarianImpl.Constants.DOT));
                }
                this.mEmuiOsVersionCode = Double.parseDouble(substring);
            }
            return this.mEmuiOsVersionCode < 5.0d;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isHigherEmui10() {
        if (!isEMUI()) {
            return false;
        }
        try {
            if (this.mEmuiOsVersionCode == -1.0d) {
                if (TextUtils.isEmpty(this.sEmuiVersion)) {
                    return false;
                }
                String str = this.sEmuiVersion;
                String substring = str.substring(str.indexOf("_") + 1);
                if (substring.indexOf(LibrarianImpl.Constants.DOT) > 0) {
                    substring = substring.substring(0, substring.indexOf(LibrarianImpl.Constants.DOT));
                }
                this.mEmuiOsVersionCode = Double.parseDouble(substring);
            }
            return this.mEmuiOsVersionCode >= 10.0d;
        } catch (Throwable unused) {
            return false;
        }
    }

    private String get(String str) throws IllegalArgumentException {
        try {
            Object systemProperties = getSystemProperties();
            return (String) systemProperties.getClass().getMethod("get", String.class).invoke(systemProperties, str);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Throwable unused) {
            return "";
        }
    }
}
