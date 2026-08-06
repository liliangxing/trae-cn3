package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.AbsXOpenPermissionSettingsMethodIDL;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.tracing.log.Fields;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XOpenPermissionSettingsMethod.kt */
@XBridgeMethod(name = "x.openPermissionSettings")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\"\u0010\u0014\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010$\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL;", "()V", "mAccessLevel", "", "mCallback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsResultModel;", "mPermission", "Lcom/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod$Permission;", "previousEvent", "Landroidx/lifecycle/Lifecycle$Event;", "checkLocationPermission", "context", "Landroid/content/Context;", "isFineLocation", "", "checkNotificationPermission", "checkPermission", "permName", "checkPermissions", "permissions", "", "checkPhotoAlbumPermission", "accessLevel", "goToAppSettings", "", "goToGlobalLocationSettings", "goToNotificationSettings", "handle", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXOpenPermissionSettingsMethodIDL$XOpenPermissionSettingsParamModel;", "callback", "handleCheckPermission", "isPermissionsRejected", "Permission", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XOpenPermissionSettingsMethod extends AbsXOpenPermissionSettingsMethodIDL {
    private String mAccessLevel;
    private CompletionBlock<AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel> mCallback;
    private Permission mPermission;
    private Lifecycle.Event previousEvent;

    /* compiled from: XOpenPermissionSettingsMethod.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Permission.values().length];
            try {
                iArr[Permission.NOTIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Permission.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Permission.FINE_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Permission.PHOTOALBUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: XOpenPermissionSettingsMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0017\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod$Permission;", "", "permission", "", "", "(Ljava/lang/String;ILjava/util/List;)V", "getPermission", "()Ljava/util/List;", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", "NOTIFICATION", "LOCATION", "FINE_LOCATION", "UNKNOWN", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

        /* compiled from: XOpenPermissionSettingsMethod.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod$Permission$Companion;", "", "()V", "getPermissionByName", "Lcom/bytedance/sdk/xbridge/cn/system/XOpenPermissionSettingsMethod$Permission;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

    private final String checkNotificationPermission(Context context) {
        boolean z;
        if (context == null) {
            return "undetermined";
        }
        try {
            z = NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        return z ? "permitted" : "undetermined";
    }

    private final boolean isPermissionsRejected(Context context, List<String> permissions) {
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

    private final String checkLocationPermission(Context context, boolean isFineLocation) {
        boolean isLocationPermissionsGranted;
        boolean isLocationPermissionsRejected;
        if (!XBridgePermissionUtils.INSTANCE.isLocationServiceEnabled(context)) {
            return "restricted";
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
        return isLocationPermissionsGranted ? "permitted" : isLocationPermissionsRejected ? "denied" : "undetermined";
    }

    private final String checkPhotoAlbumPermission(Context context, String accessLevel) {
        return XBridgePermissionUtils.INSTANCE.isPhotoAlbumPermissionGranted(context, accessLevel) ? "permitted" : XBridgePermissionUtils.INSTANCE.isPhotoAlbumPermissionRejected(context, accessLevel) ? "denied" : "undetermined";
    }

    private final void goToAppSettings(Context context) {
        context.startActivity(PermissionPageUtils.INSTANCE.getPermissionSettingIntent(context));
    }

    private final void goToNotificationSettings(Context context) {
        context.startActivity(PermissionPageUtils.INSTANCE.getNotificationSettingIntent(context));
    }

    private final void goToGlobalLocationSettings(Context context) {
        context.startActivity(PermissionPageUtils.INSTANCE.getLocationSettingsIntent(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String handleCheckPermission(Context context) {
        List<String> permission;
        String str;
        Permission permission2 = this.mPermission;
        int i = permission2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[permission2.ordinal()];
        if (i == 1) {
            return checkNotificationPermission(context);
        }
        boolean z = false;
        if (i == 2 || i == 3) {
            return checkLocationPermission(context, this.mPermission == Permission.FINE_LOCATION);
        }
        if (i == 4) {
            String str2 = this.mAccessLevel;
            if (str2 == null) {
                str2 = "readWrite";
            }
            return checkPhotoAlbumPermission(context, str2);
        }
        Permission permission3 = this.mPermission;
        if (permission3 == null || (permission = permission3.getPermission()) == null) {
            return "undetermined";
        }
        if (permission.size() == 1) {
            String str3 = (String) CollectionsKt.first(permission);
            if (str3 != null) {
                z = checkPermission(context, str3);
            }
        } else {
            z = checkPermissions(context, permission);
        }
        boolean isPermissionsRejected = isPermissionsRejected(context, permission);
        if (z) {
            str = "permitted";
        } else {
            if (!isPermissionsRejected) {
                return "undetermined";
            }
            str = "denied";
        }
        return str;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsParamModel params, CompletionBlock<AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LifecycleObserver lifecycleObserver = new GenericLifecycleObserver() { // from class: com.bytedance.sdk.xbridge.cn.system.XOpenPermissionSettingsMethod$handle$lifeCycleMonitorListener$1
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Lifecycle.Event event2;
                String handleCheckPermission;
                CompletionBlock completionBlock;
                CompletionBlock completionBlock2;
                Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
                Intrinsics.checkNotNullParameter(event, Fields.EVENT);
                XOpenPermissionSettingsMethod xOpenPermissionSettingsMethod = XOpenPermissionSettingsMethod.this;
                IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                if (event == Lifecycle.Event.ON_RESUME || event == Lifecycle.Event.ON_PAUSE) {
                    event2 = xOpenPermissionSettingsMethod.previousEvent;
                    if (event2 != Lifecycle.Event.ON_PAUSE || event != Lifecycle.Event.ON_RESUME) {
                        xOpenPermissionSettingsMethod.previousEvent = event;
                        return;
                    }
                    xOpenPermissionSettingsMethod.previousEvent = null;
                    Context ownerActivity = iBDXBridgeContext.getOwnerActivity();
                    if (ownerActivity == null) {
                        completionBlock2 = xOpenPermissionSettingsMethod.mCallback;
                        if (completionBlock2 != null) {
                            CompletionBlock.DefaultImpls.onFailure$default(completionBlock2, 0, "Context not provided in host", null, 4, null);
                            return;
                        }
                        return;
                    }
                    FragmentActivity fragmentActivity = ownerActivity instanceof FragmentActivity ? (FragmentActivity) ownerActivity : null;
                    if (fragmentActivity != null) {
                        fragmentActivity.getLifecycle().removeObserver((LifecycleObserver) this);
                    }
                    handleCheckPermission = xOpenPermissionSettingsMethod.handleCheckPermission(ownerActivity);
                    completionBlock = xOpenPermissionSettingsMethod.mCallback;
                    if (completionBlock != null) {
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel.class));
                        AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel xOpenPermissionSettingsResultModel = (AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel) createXModel;
                        if (Intrinsics.areEqual(handleCheckPermission, "restricted")) {
                            handleCheckPermission = "denied";
                        }
                        xOpenPermissionSettingsResultModel.setStatus(handleCheckPermission);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                    }
                    xOpenPermissionSettingsMethod.mCallback = null;
                }
            }
        };
        Permission permissionByName = Permission.INSTANCE.getPermissionByName(params.getPermission());
        if (permissionByName == Permission.UNKNOWN) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "Illegal permission", null, 4, null);
            return;
        }
        this.mPermission = permissionByName;
        FragmentActivity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        this.mAccessLevel = params.getAccessLevel();
        Activity activity = (Context) ownerActivity;
        String handleCheckPermission = handleCheckPermission(activity);
        if (Intrinsics.areEqual(handleCheckPermission, "permitted")) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel.class));
            ((AbsXOpenPermissionSettingsMethodIDL.XOpenPermissionSettingsResultModel) createXModel).setStatus(handleCheckPermission);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            return;
        }
        this.mCallback = callback;
        FragmentActivity fragmentActivity = ownerActivity instanceof FragmentActivity ? ownerActivity : null;
        if (fragmentActivity != null) {
            fragmentActivity.getLifecycle().addObserver(lifecycleObserver);
        }
        if ((permissionByName == Permission.LOCATION || permissionByName == Permission.FINE_LOCATION) && Intrinsics.areEqual(handleCheckPermission, "restricted")) {
            goToGlobalLocationSettings(activity);
        } else if (permissionByName == Permission.NOTIFICATION) {
            goToNotificationSettings(activity);
        } else {
            goToAppSettings(activity);
        }
    }
}
