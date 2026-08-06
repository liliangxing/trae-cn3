package com.bytedance.ies.bullet.base.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.reflect.JavaCalls;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RomUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\u00020\u00158FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0014\u0010\u0017R!\u0010\u001a\u001a\u00020\u00158FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001a\u0010\u0017R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/RomUtils;", "", "()V", "HTC_MANUFACTURER", "", "KEY_VERSION_EMUI", "KEY_VERSION_MIUI", "KEY_VERSION_OPPO", "KEY_VERSION_SMARTISAN", "KEY_VERSION_VIVO", "OPPO_MANUFACTURER", "ROM_EMUI", "ROM_FLYME", "ROM_MIUI", "ROM_OPPO", "ROM_QIKU", "ROM_SAMSUNG", "ROM_SMARTISAN", "ROM_VIVO", "VIVO_MANUFACTURER", "isFlyme", "", "isFlyme$annotations", "()Z", "isFlyme$delegate", "Lkotlin/Lazy;", "isMiui", "isMiui$annotations", "isMiui$delegate", "sName", "sVersion", "check", "rom", "getProp", "name", "getPropKitkat", "getRomManufacturer", "isOppo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class RomUtils {
    private static final String HTC_MANUFACTURER = "htc";
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String OPPO_MANUFACTURER = "oppo";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SAMSUNG = "SAMSUNG";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    private static final String VIVO_MANUFACTURER = "vivo";
    private static String sName;
    private static String sVersion;
    public static final RomUtils INSTANCE = new RomUtils();

    /* renamed from: isMiui$delegate, reason: from kotlin metadata */
    private static final Lazy isMiui = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.bullet.base.utils.RomUtils$isMiui$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m490invoke() {
            boolean z = false;
            try {
                if (Class.forName("miui.os.Build") != null) {
                    z = true;
                }
            } catch (Exception unused) {
            }
            return Boolean.valueOf(z);
        }
    });

    /* renamed from: isFlyme$delegate, reason: from kotlin metadata */
    private static final Lazy isFlyme = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.bullet.base.utils.RomUtils$isFlyme$2
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(android.os.Build.USER, "flyme") != false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        
            if (kotlin.text.StringsKt.indexOf$default(r0, "Flyme", 0, false, 6, (java.lang.Object) null) < 0) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
        
            r1 = true;
         */
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Boolean m489invoke() {
            String str = Build.DISPLAY;
            boolean z = false;
            if (!(str == null || str.length() == 0)) {
                String str2 = Build.DISPLAY;
                Intrinsics.checkNotNullExpressionValue(str2, "DISPLAY");
            }
            String str3 = Build.USER;
            if (!(str3 == null || str3.length() == 0)) {
            }
            return Boolean.valueOf(z);
        }
    });

    @JvmStatic
    public static /* synthetic */ void isFlyme$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isMiui$annotations() {
    }

    private RomUtils() {
    }

    public static final boolean isMiui() {
        return ((Boolean) isMiui.getValue()).booleanValue();
    }

    public static final boolean isFlyme() {
        return ((Boolean) isFlyme.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean isOppo() {
        RomUtils romUtils = INSTANCE;
        if (romUtils.getRomManufacturer() != null) {
            String romManufacturer = romUtils.getRomManufacturer();
            if (romManufacturer == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = romManufacturer.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual(lowerCase, OPPO_MANUFACTURER)) {
                return true;
            }
        }
        return romUtils.check(ROM_OPPO);
    }

    public final boolean check(String rom) {
        Intrinsics.checkNotNullParameter(rom, "rom");
        String str = sName;
        if (str != null) {
            return Intrinsics.areEqual(str, rom);
        }
        if (!TextUtils.isEmpty(getProp("ro.miui.ui.version.name"))) {
            sVersion = getProp("ro.miui.ui.version.name");
            sName = ROM_MIUI;
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_EMUI))) {
            sVersion = getProp(KEY_VERSION_EMUI);
            sName = ROM_EMUI;
        } else if (!TextUtils.isEmpty(getProp("ro.build.version.opporom"))) {
            sVersion = getProp("ro.build.version.opporom");
            sName = ROM_OPPO;
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_VIVO))) {
            sVersion = getProp(KEY_VERSION_VIVO);
            sName = ROM_VIVO;
        } else if (!TextUtils.isEmpty(getProp(KEY_VERSION_SMARTISAN))) {
            sVersion = getProp(KEY_VERSION_SMARTISAN);
            sName = ROM_SMARTISAN;
        } else {
            String str2 = Build.DISPLAY;
            sVersion = str2;
            boolean z = false;
            if (str2 != null) {
                String upperCase = str2.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                if (upperCase != null && StringsKt.contains$default(upperCase, ROM_FLYME, false, 2, (Object) null)) {
                    z = true;
                }
            }
            if (z) {
                sName = ROM_FLYME;
            } else {
                sVersion = "unknown";
                String str3 = Build.MANUFACTURER;
                Intrinsics.checkNotNullExpressionValue(str3, "MANUFACTURER");
                String upperCase2 = str3.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase2, "(this as java.lang.String).toUpperCase()");
                sName = upperCase2;
            }
        }
        return Intrinsics.areEqual(sName, rom);
    }

    private final String getRomManufacturer() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return str;
    }

    private final String getProp(String name) {
        return getPropKitkat(name);
    }

    private final String getPropKitkat(String name) {
        return (String) JavaCalls.callStaticMethod("android.os.SystemProperties", PrefetchRequestConfig.METHOD_GET, new Object[]{name, ""});
    }
}
