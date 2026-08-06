package com.bytedance.sdk.xbridge.cn.system.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ShortcutUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/utils/ShortcutUtil;", "", "()V", "MARK", "", "MIUI_VERSION_NAME", "getLauncherAuthority", "context", "Landroid/content/Context;", "getSystemProperty", "propName", "goSettingPage", "", "hasActivity", "", "intent", "Landroid/content/Intent;", "hasShortcut", "id", "name", "openDefaultSetting", "openHWSetting", "openMISetting", "openMZSetting", "openOppoSetting", "openVivoSetting", "queryLauncher", "title", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShortcutUtil {
    public static final ShortcutUtil INSTANCE = new ShortcutUtil();
    private static final String MARK;
    private static final String MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    private ShortcutUtil() {
    }

    static {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        MARK = lowerCase;
    }

    public final void goSettingPage(Context context) {
        Intent openDefaultSetting;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = MARK;
        if (StringsKt.contains$default(str, "huawei", false, 2, (Object) null)) {
            openDefaultSetting = openHWSetting(context);
        } else if (StringsKt.contains$default(str, "xiaomi", false, 2, (Object) null)) {
            openDefaultSetting = openMISetting(context);
        } else if (StringsKt.contains$default(str, "oppo", false, 2, (Object) null)) {
            openDefaultSetting = openOppoSetting(context);
        } else if (StringsKt.contains$default(str, "vivo", false, 2, (Object) null)) {
            openDefaultSetting = openVivoSetting(context);
        } else if (StringsKt.contains$default(str, "meizu", false, 2, (Object) null)) {
            openDefaultSetting = openMZSetting(context);
        } else {
            openDefaultSetting = openDefaultSetting(context);
        }
        try {
            openDefaultSetting.putExtra("start_only_for_android", true);
            context.startActivity(openDefaultSetting);
        } catch (Exception unused) {
            context.startActivity(openDefaultSetting(context));
        }
    }

    private final Intent openHWSetting(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    private final Intent openMISetting(Context context) {
        String systemProperty = getSystemProperty(MIUI_VERSION_NAME);
        if (TextUtils.isEmpty(systemProperty) || StringsKt.contains$default(systemProperty, "V7", false, 2, (Object) null) || StringsKt.contains$default(systemProperty, "V8", false, 2, (Object) null)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        if (TextUtils.isEmpty(systemProperty) || StringsKt.contains$default(systemProperty, "V9", false, 2, (Object) null) || StringsKt.contains$default(systemProperty, "V10", false, 2, (Object) null) || StringsKt.contains$default(systemProperty, "V11", false, 2, (Object) null)) {
            Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent2.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
            intent2.putExtra("extra_pkgname", context.getPackageName());
            return intent2;
        }
        return openDefaultSetting(context);
    }

    private final Intent openVivoSetting(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
    }

    private final Intent openOppoSetting(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity");
        if (hasActivity(context, intent)) {
            return intent;
        }
        intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        return intent;
    }

    private final Intent openMZSetting(Context context) {
        return openDefaultSetting(context);
    }

    private final Intent openDefaultSetting(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    private final boolean hasActivity(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
        return packageManager.queryIntentActivities(intent, 65536).size() > 0;
    }

    private final String getSystemProperty(String propName) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + propName).getInputStream()), 1024);
            } catch (IOException unused) {
            }
            try {
                propName = bufferedReader.readLine();
                Intrinsics.checkNotNullExpressionValue(propName, "{\n            val p = Ru…nput.readLine()\n        }");
                bufferedReader.close();
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                propName = "";
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return propName;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        return propName;
    }

    public final boolean hasShortcut(Context context, String id, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        if (Build.VERSION.SDK_INT >= 25) {
            List<ShortcutInfo> pinnedShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getPinnedShortcuts();
            Intrinsics.checkNotNullExpressionValue(pinnedShortcuts, "context.getSystemService…ass.java).pinnedShortcuts");
            Iterator<T> it = pinnedShortcuts.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(((ShortcutInfo) it.next()).getId(), id)) {
                    return true;
                }
            }
        }
        return queryLauncher(context, name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean queryLauncher(Context context, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        String launcherAuthority = getLauncherAuthority(context);
        if (launcherAuthority != null) {
            if (!(launcherAuthority.length() > 0)) {
                launcherAuthority = null;
            }
        }
        launcherAuthority = "com.android.launcher3.settings";
        StringBuffer stringBuffer = new StringBuffer("content://");
        stringBuffer.append(launcherAuthority).append("/favorites?notify=true");
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(stringBuffer.toString()), null, "title=? ", new String[]{title}, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    if (cursor.moveToNext()) {
                        CloseableKt.closeFinally(cursor, (Throwable) null);
                        return true;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                } finally {
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private final String getLauncherAuthority(Context context) {
        List<ProviderInfo> queryContentProviders;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        if (resolveActivity == null || (queryContentProviders = packageManager.queryContentProviders(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.applicationInfo.uid, 8)) == null) {
            return "";
        }
        for (ProviderInfo providerInfo : queryContentProviders) {
            if (!TextUtils.isEmpty(providerInfo.readPermission) && Pattern.matches(".*launcher.*READ_SETTINGS", providerInfo.readPermission)) {
                return providerInfo.authority;
            }
        }
        return "";
    }
}
