package com.bytedance.sdk.xbridge.cn.media.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.XBridge;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgePermissionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rJ\u0011\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u0010\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\rJ\u0011\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rJ\u001e\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rJ\u0016\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0004J\u0016\u0010,\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010.\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/utils/XBridgePermissionUtils;", "", "()V", "ALBUM_READ_ONLY", "", "ALBUM_READ_WRITE", "ALBUM_WRITE_ONLY", "TIRAMISU", "", "TYPE_READ_MEDIA_AUDIO", "TYPE_READ_MEDIA_IMAGES", "TYPE_READ_MEDIA_VIDEO", "getLocationPermission", "", "getReadAndWriteExternalStorageForAllType", "getReadAndWriteExternalStorageForAllTypeWithArray", "", "()[Ljava/lang/String;", "getReadExternalStorageForAllType", "getReadExternalStorageForAllTypeWithArray", "getReadExternalStorageForImageAndVideoWithArray", "getReadExternalStorageForImageWithArray", "getReadExternalStorageForVideoWithArray", "getSpecifiedAlbumPermission", DBData.FIELD_TYPE, "isALlLocationPermissionsRejected", "", "context", "Landroid/content/Context;", "isAboveAndroid10", "isCoarseLocationPermissionGranted", "isCoarseLocationPermissionsRejected", "isFineLocationPermissionGranted", "isFineLocationPermissionsRejected", "isLocationPermissionsGranted", "isLocationPermissionsRejected", "isLocationServiceEnabled", "isPermissionGranted", "permission", "isPermissionsRejected", "permissions", "isPermissionsRejectedAll", "isPhotoAlbumPermissionGranted", "accessLevel", "isPhotoAlbumPermissionRejected", "isWriteExternalStoragePermissionGranted", "needAdaptToTarget33", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgePermissionUtils {
    private static final String ALBUM_READ_ONLY = "readOnly";
    private static final String ALBUM_READ_WRITE = "readWrite";
    private static final String ALBUM_WRITE_ONLY = "writeOnly";
    public static final XBridgePermissionUtils INSTANCE = new XBridgePermissionUtils();
    private static final int TIRAMISU = 33;
    private static final String TYPE_READ_MEDIA_AUDIO = "android.permission.READ_MEDIA_AUDIO";
    private static final String TYPE_READ_MEDIA_IMAGES = "android.permission.READ_MEDIA_IMAGES";
    private static final String TYPE_READ_MEDIA_VIDEO = "android.permission.READ_MEDIA_VIDEO";

    /* renamed from: com_bytedance_sdk_xbridge_cn_media_utils_XBridgePermissionUtils_android_provider_Settings$Secure_getString */
    private static String m147xa5eb5df8(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    private XBridgePermissionUtils() {
    }

    public final List<String> getReadAndWriteExternalStorageForAllType() {
        return ArraysKt.asList(getReadAndWriteExternalStorageForAllTypeWithArray());
    }

    public final List<String> getReadExternalStorageForAllType() {
        return ArraysKt.asList(getReadExternalStorageForAllTypeWithArray());
    }

    public final String[] getReadAndWriteExternalStorageForAllTypeWithArray() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null && Build.VERSION.SDK_INT >= 33 && application.getApplicationInfo().targetSdkVersion >= 33) {
            return new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_AUDIO, TYPE_READ_MEDIA_VIDEO};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public final List<String> getSpecifiedAlbumPermission(String type) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        int hashCode = type.hashCode();
        if (hashCode != -1406475221) {
            if (hashCode != -1120887831) {
                if (hashCode == -867683742 && type.equals("readOnly")) {
                    if (needAdaptToTarget33()) {
                        return CollectionsKt.listOf(new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_VIDEO});
                    }
                    if (isAboveAndroid10()) {
                        return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
                    }
                    return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
                }
            } else if (type.equals("readWrite")) {
                if (needAdaptToTarget33()) {
                    return CollectionsKt.listOf(new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_VIDEO});
                }
                if (isAboveAndroid10()) {
                    return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
                }
                return CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
            }
        } else if (type.equals("writeOnly")) {
            if (needAdaptToTarget33()) {
                return CollectionsKt.emptyList();
            }
            if (isAboveAndroid10()) {
                return CollectionsKt.emptyList();
            }
            return CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return CollectionsKt.emptyList();
    }

    private final boolean needAdaptToTarget33() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        return application != null && Build.VERSION.SDK_INT >= 33 && application.getApplicationInfo().targetSdkVersion >= 33;
    }

    private final boolean isAboveAndroid10() {
        return Build.VERSION.SDK_INT >= 29;
    }

    private final boolean isPermissionGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public final String[] getReadExternalStorageForAllTypeWithArray() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null && Build.VERSION.SDK_INT >= 33 && application.getApplicationInfo().targetSdkVersion >= 33) {
            return new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_AUDIO, TYPE_READ_MEDIA_VIDEO};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public final String[] getReadExternalStorageForImageWithArray() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null && Build.VERSION.SDK_INT >= 33 && application.getApplicationInfo().targetSdkVersion >= 33) {
            return new String[]{TYPE_READ_MEDIA_IMAGES};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public final String[] getReadExternalStorageForImageAndVideoWithArray() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null && Build.VERSION.SDK_INT >= 33 && application.getApplicationInfo().targetSdkVersion >= 33) {
            return new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_VIDEO};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public final boolean isWriteExternalStoragePermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Build.VERSION.SDK_INT >= 33 && context.getApplicationInfo().targetSdkVersion >= 33) || ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") != -1;
    }

    public final String[] getReadExternalStorageForVideoWithArray() {
        Application application = BulletEnv.Companion.getInstance().getApplication();
        if (application != null && Build.VERSION.SDK_INT >= 33 && application.getApplicationInfo().targetSdkVersion >= 33) {
            return new String[]{TYPE_READ_MEDIA_VIDEO};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public final boolean isCoarseLocationPermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1;
    }

    public final boolean isFineLocationPermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1) ? false : true;
    }

    public final boolean isLocationPermissionsGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        XBridge.log("sdk version : " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 33 && context.getApplicationInfo().targetSdkVersion >= 33) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1) {
                return true;
            }
        } else if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1) {
            return true;
        }
        return false;
    }

    public final List<String> getLocationPermission() {
        return ArraysKt.toList(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
    }

    public final boolean isLocationPermissionsRejected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 33 && context.getApplicationInfo().targetSdkVersion >= 33) {
            return isPermissionsRejectedAll(context, getLocationPermission());
        }
        return isPermissionsRejected(context, getLocationPermission());
    }

    public final boolean isALlLocationPermissionsRejected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isPermissionsRejectedAll(context, getLocationPermission());
    }

    public final boolean isCoarseLocationPermissionsRejected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isPermissionsRejectedAll(context, CollectionsKt.listOf("android.permission.ACCESS_COARSE_LOCATION"));
    }

    public final boolean isFineLocationPermissionsRejected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isPermissionsRejectedAll(context, CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION"));
    }

    public final boolean isPhotoAlbumPermissionGranted(Context context, String accessLevel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accessLevel, "accessLevel");
        int hashCode = accessLevel.hashCode();
        if (hashCode != -1406475221) {
            if (hashCode != -1120887831) {
                if (hashCode == -867683742 && accessLevel.equals("readOnly")) {
                    if (needAdaptToTarget33()) {
                        if (isPermissionGranted(context, TYPE_READ_MEDIA_IMAGES) && isPermissionGranted(context, TYPE_READ_MEDIA_VIDEO)) {
                            return true;
                        }
                        return Build.VERSION.SDK_INT >= 34 && isPermissionGranted(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
                    }
                    if (isAboveAndroid10()) {
                        return isPermissionGranted(context, "android.permission.READ_EXTERNAL_STORAGE");
                    }
                    return isPermissionGranted(context, "android.permission.READ_EXTERNAL_STORAGE");
                }
            } else if (accessLevel.equals("readWrite")) {
                if (needAdaptToTarget33()) {
                    if (isPermissionGranted(context, TYPE_READ_MEDIA_IMAGES) && isPermissionGranted(context, TYPE_READ_MEDIA_VIDEO)) {
                        return true;
                    }
                    return Build.VERSION.SDK_INT >= 34 && isPermissionGranted(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
                }
                if (isAboveAndroid10()) {
                    return isPermissionGranted(context, "android.permission.READ_EXTERNAL_STORAGE");
                }
                return isPermissionGranted(context, "android.permission.READ_EXTERNAL_STORAGE") && isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
        } else if (accessLevel.equals("writeOnly")) {
            if (needAdaptToTarget33() || isAboveAndroid10()) {
                return true;
            }
            return isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }

    public final boolean isPhotoAlbumPermissionRejected(Context context, String accessLevel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accessLevel, "accessLevel");
        int hashCode = accessLevel.hashCode();
        if (hashCode != -1406475221) {
            if (hashCode != -1120887831) {
                if (hashCode == -867683742 && accessLevel.equals("readOnly")) {
                    if (needAdaptToTarget33()) {
                        if (isPermissionsRejected(context, CollectionsKt.listOf(new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_VIDEO}))) {
                            return true;
                        }
                        return Build.VERSION.SDK_INT >= 34 && isPermissionsRejected(context, CollectionsKt.listOf("android.permission.READ_MEDIA_VISUAL_USER_SELECTED"));
                    }
                    if (isAboveAndroid10()) {
                        return isPermissionsRejected(context, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
                    }
                    return isPermissionsRejected(context, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
                }
            } else if (accessLevel.equals("readWrite")) {
                if (needAdaptToTarget33()) {
                    if (isPermissionsRejected(context, CollectionsKt.listOf(new String[]{TYPE_READ_MEDIA_IMAGES, TYPE_READ_MEDIA_VIDEO}))) {
                        return true;
                    }
                    return Build.VERSION.SDK_INT >= 34 && isPermissionsRejected(context, CollectionsKt.listOf("android.permission.READ_MEDIA_VISUAL_USER_SELECTED"));
                }
                if (isAboveAndroid10()) {
                    return isPermissionsRejected(context, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
                }
                return isPermissionsRejected(context, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}));
            }
        } else if (accessLevel.equals("writeOnly")) {
            if (needAdaptToTarget33() || isAboveAndroid10()) {
                return false;
            }
            return isPermissionsRejected(context, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"));
        }
        return true;
    }

    public final boolean isPermissionsRejected(Context context, List<String> permissions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        for (String str : permissions) {
            if (str != null && !ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isPermissionsRejectedAll(Context context, List<String> permissions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return false;
        }
        for (String str : permissions) {
            if (str != null && ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isLocationServiceEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 28) {
            Object systemService = context.getSystemService("location");
            LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
            if (locationManager != null) {
                return locationManager.isLocationEnabled();
            }
            return false;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
