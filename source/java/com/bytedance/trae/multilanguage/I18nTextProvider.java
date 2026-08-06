package com.bytedance.trae.multilanguage;

import android.content.res.Resources;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: I18nTextProvider.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fJ1\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0013\"\u00020\u0001¢\u0006\u0002\u0010\u0014J.\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0002J?\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u000fH\u0002R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/multilanguage/I18nTextProvider;", "", "<init>", "()V", "hotStrings", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/trae/multilanguage/I18nLanguage;", "", "updateStrings", "", "language", "strings", "", "getString", "resources", "Landroid/content/res/Resources;", "stringResId", "", "args", "", "(Landroid/content/res/Resources;I[Ljava/lang/Object;)Ljava/lang/String;", "getStringWithNamedArgs", "namedArgs", "getStringByName", "keyName", "resourceEntryNameOrNull", "formatHotString", "hotString", "(Landroid/content/res/Resources;Lcom/bytedance/trae/multilanguage/I18nLanguage;Ljava/lang/String;I[Ljava/lang/Object;)Ljava/lang/String;", "currentLocale", "Ljava/util/Locale;", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class I18nTextProvider {
    public static final I18nTextProvider INSTANCE = new I18nTextProvider();
    private static final ConcurrentHashMap<I18nLanguage, ConcurrentHashMap<String, String>> hotStrings = new ConcurrentHashMap<>();

    private I18nTextProvider() {
    }

    public final void updateStrings(I18nLanguage language, Map<String, String> strings) {
        ConcurrentHashMap<String, String> putIfAbsent;
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(strings, "strings");
        if (strings.isEmpty()) {
            return;
        }
        ConcurrentHashMap<I18nLanguage, ConcurrentHashMap<String, String>> concurrentHashMap = hotStrings;
        ConcurrentHashMap<String, String> concurrentHashMap2 = concurrentHashMap.get(language);
        if (concurrentHashMap2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(language, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap2 = putIfAbsent;
        }
        concurrentHashMap2.putAll(strings);
    }

    public final String getString(Resources resources, int stringResId, Object... args) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(args, "args");
        String resourceEntryNameOrNull = resourceEntryNameOrNull(resources, stringResId);
        I18nLanguage fromLocale = I18nLanguage.INSTANCE.fromLocale(currentLocale(resources));
        String str = null;
        if (resourceEntryNameOrNull != null && (concurrentHashMap = hotStrings.get(fromLocale)) != null) {
            str = concurrentHashMap.get(resourceEntryNameOrNull);
        }
        String str2 = str;
        String str3 = str2;
        if (!(str3 == null || str3.length() == 0)) {
            return formatHotString(resources, fromLocale, str2, stringResId, args);
        }
        String string = resources.getString(stringResId, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getStringWithNamedArgs(Resources resources, int stringResId, Map<String, ? extends Object> namedArgs) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(namedArgs, "namedArgs");
        String string = getString(resources, stringResId, new Object[0]);
        if (namedArgs.isEmpty()) {
            return string;
        }
        Iterator<T> it = namedArgs.entrySet().iterator();
        String str = string;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            String str3 = "{" + str2 + '}';
            String obj = value != null ? value.toString() : null;
            if (obj == null) {
                obj = "";
            }
            str = StringsKt.replace$default(str, str3, obj, false, 4, (Object) null);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:3:0x000c, B:5:0x0020, B:6:0x0028, B:8:0x002f, B:15:0x003c, B:18:0x004c, B:22:0x0063), top: B:2:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getStringByName(Resources resources, String keyName) {
        boolean z;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        try {
            ConcurrentHashMap<String, String> concurrentHashMap = hotStrings.get(I18nLanguage.INSTANCE.fromLocale(currentLocale(resources)));
            String str = concurrentHashMap != null ? concurrentHashMap.get(keyName) : null;
            String str2 = str;
            boolean z2 = false;
            if (str2 != null && str2.length() != 0) {
                z = false;
                if (z) {
                    return str;
                }
                int identifier = resources.getIdentifier(keyName, "string", resources.getResourcePackageName(C0882R.string.imkit_error_default));
                if (identifier == 0) {
                    return null;
                }
                String string = resources.getString(identifier);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (string.length() > 0) {
                    if (!Intrinsics.areEqual(string, keyName)) {
                        z2 = true;
                    }
                }
                if (z2) {
                    return string;
                }
                return null;
            }
            z = true;
            if (z) {
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private final String resourceEntryNameOrNull(Resources resources, int i) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(resources.getResourceEntryName(i));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    private final String formatHotString(Resources resources, I18nLanguage language, String hotString, int stringResId, Object[] args) {
        Object obj;
        if (args.length == 0) {
            return hotString;
        }
        try {
            Result.Companion companion = Result.Companion;
            I18nTextProvider i18nTextProvider = this;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = language.getLocale();
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(locale, hotString, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            obj = Result.constructor-impl(format);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = resources.getString(stringResId, Arrays.copyOf(args, args.length));
            Intrinsics.checkNotNullExpressionValue(obj, "getString(...)");
        }
        return (String) obj;
    }

    private final Locale currentLocale(Resources resources) {
        Locale locale = resources.getConfiguration().getLocales().get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Intrinsics.checkNotNull(locale);
        return locale;
    }
}
