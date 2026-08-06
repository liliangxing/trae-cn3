package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.AbsXCheckPermissionV2MethodIDL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XCheckPermissionV2Method.kt */
@XBridgeMethod(name = "x.checkPermissionV2")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000bH\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J&\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J\u001e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XCheckPermissionV2Method;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXCheckPermissionV2MethodIDL;", "()V", "checkPermission", "", "context", "Landroid/content/Context;", "permName", "", "checkPermissions", "permissions", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXCheckPermissionV2MethodIDL$XCheckPermissionV2ParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXCheckPermissionV2MethodIDL$XCheckPermissionV2ResultModel;", "handleLocationPermission", "isFineLocation", "handleNotificationPermission", "Permission", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCheckPermissionV2Method extends AbsXCheckPermissionV2MethodIDL {

    /* compiled from: XCheckPermissionV2Method.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0017\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XCheckPermissionV2Method$Permission;", "", "permission", "", "", "(Ljava/lang/String;ILjava/util/List;)V", "getPermission", "()Ljava/util/List;", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", "NOTIFICATION", "LOCATION", "FINE_LOCATION", "CONTACTS", "UNKNOWN", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum Permission {
        CAMERA(CollectionsKt.listOf("android.permission.CAMERA")),
        MICROPHONE(CollectionsKt.listOf("android.permission.RECORD_AUDIO")),
        PHOTOALBUM(CollectionsKt.emptyList()),
        VIBRATE(CollectionsKt.listOf("android.permission.VIBRATE")),
        READ_CALENDAR(CollectionsKt.listOf("android.permission.READ_CALENDAR")),
        WRITE_CALENDAR(CollectionsKt.listOf("android.permission.WRITE_CALENDAR")),
        CALENDAR(CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"})),
        NOTIFICATION(CollectionsKt.listOf("")),
        LOCATION(XBridgePermissionUtils.INSTANCE.getLocationPermission()),
        FINE_LOCATION(XBridgePermissionUtils.INSTANCE.getLocationPermission()),
        CONTACTS(CollectionsKt.listOf("android.permission.READ_CONTACTS")),
        UNKNOWN(CollectionsKt.listOf((Object) null));


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<String> permission;

        Permission(List list) {
            this.permission = list;
        }

        public final List<String> getPermission() {
            return this.permission;
        }

        /* compiled from: XCheckPermissionV2Method.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XCheckPermissionV2Method$Permission$Companion;", "", "()V", "getPermissionByName", "Lcom/bytedance/sdk/xbridge/cn/system/XCheckPermissionV2Method$Permission;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Permission getPermissionByName(String name) {
                if (name != null) {
                    try {
                        String upperCase = name.toUpperCase();
                        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                        return Permission.valueOf(upperCase);
                    } catch (Exception unused) {
                        return Permission.UNKNOWN;
                    }
                }
                return Permission.UNKNOWN;
            }
        }
    }

    private final boolean checkPermission(Context context, String permName) {
        return (context == null || ContextCompat.checkSelfPermission(context, permName) == -1) ? false : true;
    }

    private final boolean checkPermissions(Context context, List<String> permissions) {
        if (context == null) {
            return false;
        }
        for (String str : permissions) {
            if (str != null && ContextCompat.checkSelfPermission(context, str) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ParamModel params, CompletionBlock<AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Permission permissionByName = Permission.INSTANCE.getPermissionByName(params.getPermission());
        if (permissionByName == Permission.UNKNOWN) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "Illegal permission", null, 4, null);
            return;
        }
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        if (permissionByName == Permission.NOTIFICATION) {
            handleNotificationPermission(ownerActivity, callback);
            return;
        }
        boolean z = false;
        if (permissionByName == Permission.LOCATION || permissionByName == Permission.FINE_LOCATION) {
            handleLocationPermission(ownerActivity, callback, permissionByName == Permission.FINE_LOCATION);
            return;
        }
        if (permissionByName == Permission.PHOTOALBUM) {
            XBridgePermissionUtils xBridgePermissionUtils = XBridgePermissionUtils.INSTANCE;
            Activity activity = ownerActivity;
            String accessLevel = params.getAccessLevel();
            if (accessLevel == null) {
                accessLevel = "readWrite";
            }
            boolean isPhotoAlbumPermissionGranted = xBridgePermissionUtils.isPhotoAlbumPermissionGranted(activity, accessLevel);
            XBridgePermissionUtils xBridgePermissionUtils2 = XBridgePermissionUtils.INSTANCE;
            String accessLevel2 = params.getAccessLevel();
            boolean isPhotoAlbumPermissionRejected = xBridgePermissionUtils2.isPhotoAlbumPermissionRejected(activity, accessLevel2 != null ? accessLevel2 : "readWrite");
            if (isPhotoAlbumPermissionGranted) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
                ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel).setStatus("permitted");
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
                return;
            } else if (isPhotoAlbumPermissionRejected) {
                XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
                ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel2).setStatus("denied");
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel2, null, 2, null);
                return;
            } else {
                XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
                ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel3).setStatus("undetermined");
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel3, null, 2, null);
                return;
            }
        }
        List<String> permission = permissionByName.getPermission();
        if (permission.size() == 1) {
            String str = (String) CollectionsKt.first(permission);
            if (str != null) {
                z = checkPermission(ownerActivity, str);
            }
        } else {
            z = checkPermissions(ownerActivity, permission);
        }
        boolean isPermissionsRejected = XBridgePermissionUtils.INSTANCE.isPermissionsRejected(ownerActivity, permission);
        if (z) {
            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
            ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel4).setStatus("permitted");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel4, null, 2, null);
        } else if (isPermissionsRejected) {
            XBaseModel createXModel5 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
            ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel5).setStatus("denied");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel5, null, 2, null);
        } else {
            XBaseModel createXModel6 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
            ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel6).setStatus("undetermined");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel6, null, 2, null);
        }
    }

    private final void handleNotificationPermission(Context context, CompletionBlock<AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel> callback) {
        boolean z;
        try {
            z = NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
        ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel).setStatus(z ? "permitted" : "undetermined");
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }

    private final void handleLocationPermission(Context context, CompletionBlock<AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel> callback, boolean isFineLocation) {
        boolean isLocationPermissionsGranted;
        boolean isLocationPermissionsRejected;
        String str = "denied";
        if (!XBridgePermissionUtils.INSTANCE.isLocationServiceEnabled(context)) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
            ((AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel).setStatus("denied");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            return;
        }
        if (isFineLocation) {
            isLocationPermissionsGranted = XBridgePermissionUtils.INSTANCE.isFineLocationPermissionGranted(context);
        } else {
            isLocationPermissionsGranted = XBridgePermissionUtils.INSTANCE.isLocationPermissionsGranted(context);
        }
        if (isFineLocation) {
            isLocationPermissionsRejected = XBridgePermissionUtils.INSTANCE.isALlLocationPermissionsRejected(context);
        } else {
            isLocationPermissionsRejected = XBridgePermissionUtils.INSTANCE.isLocationPermissionsRejected(context);
        }
        XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel.class));
        AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel xCheckPermissionV2ResultModel = (AbsXCheckPermissionV2MethodIDL.XCheckPermissionV2ResultModel) createXModel2;
        if (isLocationPermissionsGranted) {
            str = "permitted";
        } else if (!isLocationPermissionsRejected) {
            str = "undetermined";
        }
        xCheckPermissionV2ResultModel.setStatus(str);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel2, null, 2, null);
    }
}
