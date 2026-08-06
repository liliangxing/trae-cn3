package com.bytedance.crash.general;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes3.dex */
public class RomInfoHelper {
    private static final String UNKNOWN = "unknown";
    private static Rom sRomInstance;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkRoot() {
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i = 0; i < 11; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean findClassByName(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        return str.contains(LibrarianImpl.Constants.DOT) ? str : str + ".0";
    }

    public static int getOsApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getRandomDeviceId() {
        try {
            String uuid = UUID.randomUUID().toString();
            return !TextUtils.isEmpty(uuid) ? uuid : "0000-1111-2222-3333-4444";
        } catch (Throwable unused) {
            return "0000-1111-2222-3333-4444";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getKernelVersion() {
        try {
            return System.getProperty("os.version");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isHarmonyOs() {
        return findClassByName("ohos.utils.system.SystemCapability");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getRomIncremental() {
        return Build.VERSION.INCREMENTAL == null ? "unknown" : Build.VERSION.INCREMENTAL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getRomVersion() {
        return getRom().getVersion();
    }

    private static Rom getRom() {
        if (sRomInstance == null) {
            synchronized (Rom.class) {
                if (sRomInstance == null) {
                    sRomInstance = createRom();
                }
            }
        }
        return sRomInstance;
    }

    public static boolean isMiui() {
        return getRom() instanceof Miui;
    }

    private static Rom createRom() {
        Emui emui = new Emui();
        if (emui.identify()) {
            return emui;
        }
        Miui miui = new Miui();
        if (miui.identify()) {
            return miui;
        }
        FunTouch funTouch = new FunTouch();
        if (funTouch.identify()) {
            return funTouch;
        }
        ColorOS colorOS = new ColorOS();
        if (colorOS.identify()) {
            return colorOS;
        }
        Flyme flyme = new Flyme();
        if (flyme.identify()) {
            return flyme;
        }
        Eui eui = new Eui();
        if (eui.identify()) {
            return eui;
        }
        Sony sony = new Sony();
        if (sony.identify()) {
            return sony;
        }
        Amigo amigo = new Amigo();
        if (amigo.identify()) {
            return amigo;
        }
        OS360 os360 = new OS360();
        return os360.identify() ? os360 : new UnknownRom();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class Rom {
        protected static final String SEPARATOR = "_";
        protected static final Locale mLocale = Locale.getDefault();
        protected static String mOs;
        protected static String mVendor;

        abstract boolean identify();

        Rom(String str, String str2) {
            mVendor = str;
            mOs = str2;
        }

        String getVendor() {
            return mVendor;
        }

        String getOs() {
            return mOs;
        }

        String getVersion() {
            return Build.DISPLAY == null ? "unknown" : Build.DISPLAY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class UnknownRom extends Rom {
        private static final String OS = "unknown";
        private static final String VENDOR = "unknown";

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return true;
        }

        UnknownRom() {
            super("unknown", "unknown");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Emui extends Rom {
        private static final String OS = "emotionui";
        private static final String OS_1 = "magicui";
        private static final String PROPERTY = "ro.build.version.emui";
        private static final String VENDOR = "huawei";
        private final String mVersion;

        Emui() {
            super("huawei", "emotionui");
            this.mVersion = RomInfoHelper.getSystemProperty(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (!TextUtils.isEmpty(this.mVersion)) {
                String lowerCase = this.mVersion.toLowerCase(mLocale);
                if (lowerCase.startsWith("emotionui") || lowerCase.startsWith(OS_1)) {
                    return true;
                }
            }
            try {
                String str = Build.BRAND;
                if (!TextUtils.isEmpty(str)) {
                    if (str.toLowerCase(mLocale).startsWith("huawei")) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                return str2.toLowerCase(mLocale).startsWith("huawei");
            } catch (Throwable unused2) {
                return false;
            }
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            if (TextUtils.isEmpty(this.mVersion) || !this.mVersion.toLowerCase(mLocale).contains("emotionui")) {
                return Build.DISPLAY == null ? "unknown" : Build.DISPLAY;
            }
            return this.mVersion + "_" + Build.DISPLAY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Miui extends Rom {
        private static final String OS = "miui";
        private static final String VENDOR = "xiaomi";
        private final String mVersion;

        Miui() {
            super("xiaomi", "miui");
            this.mVersion = RomInfoHelper.getSystemProperty("ro.miui.ui.version.name");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return RomInfoHelper.findClassByName("miui.os.Build");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return "miui_" + this.mVersion + "_" + Build.VERSION.INCREMENTAL;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FunTouch extends Rom {
        private static final String OS = "funtouch";
        private static final String VENDOR = "vivo";
        private final String mDisplayId;
        private final String mProductVersion;

        FunTouch() {
            super(VENDOR, OS);
            this.mDisplayId = RomInfoHelper.getSystemProperty("ro.vivo.os.build.display.id");
            this.mProductVersion = RomInfoHelper.getSystemProperty("ro.vivo.product.version");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return !TextUtils.isEmpty(this.mDisplayId) && this.mDisplayId.toLowerCase(mLocale).contains(OS);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return this.mDisplayId + "_" + this.mProductVersion;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ColorOS extends Rom {
        private static final String OS = "coloros";
        private static final String PROPERTY = "ro.build.version.opporom";
        private static final String VENDOR = "oppo";
        private final String mVersion;

        ColorOS() {
            super(VENDOR, "coloros");
            this.mVersion = RomInfoHelper.getSystemProperty("ro.build.version.opporom");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase(mLocale).contains(VENDOR);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return "coloros_" + this.mVersion + "_" + Build.DISPLAY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Flyme extends Rom {
        private static final String OS = "flyme";
        private static final String VENDOR = "meizu";

        Flyme() {
            super(VENDOR, "flyme");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            if (TextUtils.isEmpty(Build.DISPLAY) || !Build.DISPLAY.toLowerCase(mLocale).contains("flyme")) {
                return !TextUtils.isEmpty(Build.USER) && Build.USER.equals("flyme");
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Eui extends Rom {
        private static final String OS = "eui";
        private static final String VENDOR = "letv";
        private final String mVersion;

        Eui() {
            super(VENDOR, OS);
            this.mVersion = RomInfoHelper.getSystemProperty("ro.letv.release.version");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return !TextUtils.isEmpty(this.mVersion);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return "eui_" + this.mVersion + "_" + Build.DISPLAY;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Sony extends Rom {
        private static final String OS = "sony";
        private static final String VENDOR = "sony";

        Sony() {
            super("sony", "sony");
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String str = Build.BRAND + Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) && str.toLowerCase(mLocale).contains("sony");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Amigo extends Rom {
        private static final String OS = "amigo";
        private static final String PROPERTY = "ro.gn.sv.version";
        private static final String VENDOR = "gionee";
        private final String mVersion;

        Amigo() {
            super(VENDOR, OS);
            this.mVersion = RomInfoHelper.getSystemProperty(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(mLocale).contains(OS);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return Build.DISPLAY + "_" + this.mVersion;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class OS360 extends Rom {
        private static final String OS = "360";
        private static final String PROPERTY = "ro.build.uiversion";
        private static final String VENDOR = "qiku";
        private final String mVersion;

        OS360() {
            super(VENDOR, OS);
            this.mVersion = RomInfoHelper.getSystemProperty(PROPERTY);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        boolean identify() {
            String str = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(mLocale);
            return lowerCase.contains(OS) || lowerCase.contains(VENDOR);
        }

        @Override // com.bytedance.crash.general.RomInfoHelper.Rom
        String getVersion() {
            return this.mVersion + "_" + Build.DISPLAY;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSystemProperty(String str) {
        return getSystemProperty(str, "");
    }
}
