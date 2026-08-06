package com.bytedance.push.utils;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;

/* loaded from: classes4.dex */
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
            this.sMiVersion = SystemProperties.get("ro.miui.ui.version.name", "");
        }
        return !TextUtils.isEmpty(this.sMiVersion);
    }

    public boolean isMi12() {
        return getMiuiVersion() == 12;
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

    public String get(String str) throws IllegalArgumentException {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            th.printStackTrace();
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
}
