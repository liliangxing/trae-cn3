package com.bytedance.sdk.xbridge.cn.system;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionPageUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils;", "", "()V", "manufactorHandlers", "", "", "Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$IManufacturerHandler;", "getLocationSettingsIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getNotificationSettingIntent", "getPermissionSettingIntent", "DefaultManufacturer", "Huawei", "IManufacturerHandler", "Meizu", "Xiaomi", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PermissionPageUtils {
    public static final PermissionPageUtils INSTANCE = new PermissionPageUtils();
    private static final Map<String, IManufacturerHandler> manufactorHandlers = MapsKt.mapOf(TuplesKt.to("meizu", new Meizu()));

    /* compiled from: PermissionPageUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$IManufacturerHandler;", "", "getLocationSettingIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getNotificationSettingIntent", "getPermissionSettingIntent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IManufacturerHandler {
        Intent getLocationSettingIntent(Context context);

        Intent getNotificationSettingIntent(Context context);

        Intent getPermissionSettingIntent(Context context);
    }

    private PermissionPageUtils() {
    }

    public final Intent getPermissionSettingIntent(Context context) {
        Intent permissionSettingIntent;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = Build.MANUFACTURER;
        Map<String, IManufacturerHandler> map = manufactorHandlers;
        Intrinsics.checkNotNullExpressionValue(str, "brand");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        IManufacturerHandler iManufacturerHandler = map.get(lowerCase);
        return (iManufacturerHandler == null || (permissionSettingIntent = iManufacturerHandler.getPermissionSettingIntent(context)) == null) ? new DefaultManufacturer().getPermissionSettingIntent(context) : permissionSettingIntent;
    }

    public final Intent getNotificationSettingIntent(Context context) {
        Intent notificationSettingIntent;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = Build.MANUFACTURER;
        Map<String, IManufacturerHandler> map = manufactorHandlers;
        Intrinsics.checkNotNullExpressionValue(str, "brand");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        IManufacturerHandler iManufacturerHandler = map.get(lowerCase);
        return (iManufacturerHandler == null || (notificationSettingIntent = iManufacturerHandler.getNotificationSettingIntent(context)) == null) ? new DefaultManufacturer().getNotificationSettingIntent(context) : notificationSettingIntent;
    }

    public final Intent getLocationSettingsIntent(Context context) {
        Intent locationSettingIntent;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = Build.MANUFACTURER;
        Map<String, IManufacturerHandler> map = manufactorHandlers;
        Intrinsics.checkNotNullExpressionValue(str, "brand");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        IManufacturerHandler iManufacturerHandler = map.get(lowerCase);
        return (iManufacturerHandler == null || (locationSettingIntent = iManufacturerHandler.getLocationSettingIntent(context)) == null) ? new DefaultManufacturer().getLocationSettingIntent(context) : locationSettingIntent;
    }

    /* compiled from: PermissionPageUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$DefaultManufacturer;", "Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$IManufacturerHandler;", "()V", "createAppSettingsIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getLocationSettingIntent", "getNotificationSettingIntent", "getPermissionSettingIntent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class DefaultManufacturer implements IManufacturerHandler {
        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getPermissionSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return createAppSettingsIntent(context);
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getNotificationSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 26) {
                Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.addFlags(268435456);
                return intent;
            }
            return createAppSettingsIntent(context);
        }

        private final Intent createAppSettingsIntent(Context context) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(268435456);
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            return intent;
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getLocationSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            intent.addFlags(268435456);
            return intent;
        }
    }

    /* compiled from: PermissionPageUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$Huawei;", "Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$DefaultManufacturer;", "()V", "getPermissionSettingIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Huawei extends DefaultManufacturer {
        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.DefaultManufacturer, com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getPermissionSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
            return intent;
        }
    }

    /* compiled from: PermissionPageUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$Meizu;", "Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$DefaultManufacturer;", "()V", "getLocationSettingIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getNotificationSettingIntent", "getPermissionSettingIntent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Meizu extends DefaultManufacturer {
        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.DefaultManufacturer, com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getPermissionSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
            return intent;
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.DefaultManufacturer, com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getNotificationSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ComponentName componentName = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            intent.setFlags(268435456);
            return intent;
        }

        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.DefaultManufacturer, com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getLocationSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("com.meizu.connectivitysettings.CONNECTIVITY_SETTINGS");
            intent.addFlags(268435456);
            intent.putExtra(":settings:show_fragment", "com.meizu.settings.location.MzLocationSettings");
            return intent;
        }
    }

    /* compiled from: PermissionPageUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$Xiaomi;", "Lcom/bytedance/sdk/xbridge/cn/system/PermissionPageUtils$DefaultManufacturer;", "()V", "getPermissionSettingIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Xiaomi extends DefaultManufacturer {
        @Override // com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.DefaultManufacturer, com.bytedance.sdk.xbridge.cn.system.PermissionPageUtils.IManufacturerHandler
        public Intent getPermissionSettingIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
    }
}
