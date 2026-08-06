package com.bytedance.sdk.xbridge.cn.permission.idl_bridge;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.media.utils.XBridgePermissionUtils;
import com.bytedance.sdk.xbridge.cn.permission.idl.AbsXRequestPermissionMethodIDL;
import com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod;
import com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$handle$lifeCycleMonitorListener$2;
import com.bytedance.sdk.xbridge.cn.permission.utils.PermissionPageUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLocationPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeMethodHelper;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.tracing.log.Fields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XRequestPermissionMethod.kt */
@XBridgeMethod(name = "x.requestPermission")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J6\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/permission/idl_bridge/XRequestPermissionMethod;", "Lcom/bytedance/sdk/xbridge/cn/permission/idl/AbsXRequestPermissionMethodIDL;", "()V", "mCallback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/permission/idl/AbsXRequestPermissionMethodIDL$XRequestPermissionResultModel;", "previousEvent", "Landroidx/lifecycle/Lifecycle$Event;", "actualRequestPermission", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "context", "Landroid/content/Context;", "permissions", "", "", "callback", "actualRequestPhotoAlbumPermission", "checkLocationPermission", "isFineLocation", "", "checkNotificationPermission", "getLocationStatus", "goToAppSettings", "handle", "params", "Lcom/bytedance/sdk/xbridge/cn/permission/idl/AbsXRequestPermissionMethodIDL$XRequestPermissionParamModel;", "handleLifeCycleCallback", "LifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", Fields.EVENT, "Permission", "anniex_release", "lifeCycleMonitorListener"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XRequestPermissionMethod extends AbsXRequestPermissionMethodIDL {
    private CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> mCallback;
    private Lifecycle.Event previousEvent;

    /* compiled from: XRequestPermissionMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0017\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/permission/idl_bridge/XRequestPermissionMethod$Permission;", "", "permission", "", "", "(Ljava/lang/String;ILjava/util/List;)V", "getPermission", "()Ljava/util/List;", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", "NOTIFICATION", "LOCATION", "FINE_LOCATION", "CONTACTS", "UNKNOWN", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

        /* compiled from: XRequestPermissionMethod.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/permission/idl_bridge/XRequestPermissionMethod$Permission$Companion;", "", "()V", "getPermissionByName", "Lcom/bytedance/sdk/xbridge/cn/permission/idl_bridge/XRequestPermissionMethod$Permission;", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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
                        Locale locale = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                        String upperCase = name.toUpperCase(locale);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                        return Permission.valueOf(upperCase);
                    } catch (Exception unused) {
                        return Permission.UNKNOWN;
                    }
                }
                return Permission.UNKNOWN;
            }
        }
    }

    private final String checkLocationPermission(Context context, boolean isFineLocation) {
        boolean isLocationPermissionsGranted;
        if (!XBridgePermissionUtils.INSTANCE.isLocationServiceEnabled(context)) {
            return "denied";
        }
        if (isFineLocation) {
            isLocationPermissionsGranted = XBridgePermissionUtils.INSTANCE.isFineLocationPermissionGranted(context);
        } else {
            isLocationPermissionsGranted = XBridgePermissionUtils.INSTANCE.isLocationPermissionsGranted(context);
        }
        return isLocationPermissionsGranted ? "permitted" : "undetermined";
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

    private final void goToAppSettings(Context context) {
        context.startActivity(PermissionPageUtils.INSTANCE.getNotificationSettingIntent(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLifeCycleCallback(LifecycleObserver LifecycleObserver, IBDXBridgeContext bridgeContext, Lifecycle.Event event) {
        Lifecycle lifecycle;
        if (event == Lifecycle.Event.ON_RESUME || event == Lifecycle.Event.ON_PAUSE) {
            if (this.previousEvent == Lifecycle.Event.ON_PAUSE && event == Lifecycle.Event.ON_RESUME) {
                this.previousEvent = null;
                FragmentActivity ownerActivity = bridgeContext.getOwnerActivity();
                FragmentActivity fragmentActivity = ownerActivity instanceof FragmentActivity ? ownerActivity : null;
                if (fragmentActivity != null && (lifecycle = fragmentActivity.getLifecycle()) != null) {
                    lifecycle.removeObserver(LifecycleObserver);
                }
                String checkNotificationPermission = checkNotificationPermission((Context) ownerActivity);
                CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock = this.mCallback;
                if (completionBlock != null) {
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                    AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel;
                    xRequestPermissionResultModel.setStatus(checkNotificationPermission);
                    xRequestPermissionResultModel.setLocationStatus("unknown");
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                }
                this.mCallback = null;
                return;
            }
            this.previousEvent = event;
        }
    }

    private static final LifecycleObserver handle$lambda$1(Lazy<XRequestPermissionMethod$handle$lifeCycleMonitorListener$2.C01621> lazy) {
        return (LifecycleObserver) lazy.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x011f, code lost:
    
        if (r0.isPermissionAllGranted(r9, (java.lang.String[]) java.util.Arrays.copyOf(r14, r14.length)) == true) goto L55;
     */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(final IBDXBridgeContext bridgeContext, AbsXRequestPermissionMethodIDL.XRequestPermissionParamModel params, final CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> callback) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Lazy lazy = LazyKt.lazy(new Function0<XRequestPermissionMethod$handle$lifeCycleMonitorListener$2.C01621>() { // from class: com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$handle$lifeCycleMonitorListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$handle$lifeCycleMonitorListener$2$1] */
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final C01621 m899invoke() {
                final XRequestPermissionMethod xRequestPermissionMethod = XRequestPermissionMethod.this;
                final IBDXBridgeContext iBDXBridgeContext = bridgeContext;
                return new GenericLifecycleObserver() { // from class: com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$handle$lifeCycleMonitorListener$2.1
                    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
                        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
                        XRequestPermissionMethod.this.handleLifeCycleCallback((LifecycleObserver) this, iBDXBridgeContext, event);
                    }
                };
            }
        });
        final Permission permissionByName = Permission.INSTANCE.getPermissionByName(params.getPermission());
        if (permissionByName == Permission.UNKNOWN) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "Illegal permission", null, 4, null);
            return;
        }
        final Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context not provided in host", null, 4, null);
            return;
        }
        if (permissionByName == Permission.NOTIFICATION) {
            Activity activity = ownerActivity;
            String checkNotificationPermission = checkNotificationPermission(activity);
            if (Intrinsics.areEqual(checkNotificationPermission, "permitted")) {
                XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel;
                xRequestPermissionResultModel.setStatus(checkNotificationPermission);
                xRequestPermissionResultModel.setLocationStatus("unknown");
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
                return;
            }
            this.mCallback = callback;
            FragmentActivity fragmentActivity = ownerActivity instanceof FragmentActivity ? (FragmentActivity) ownerActivity : null;
            if (fragmentActivity != null && (lifecycle = fragmentActivity.getLifecycle()) != null) {
                lifecycle.addObserver(handle$lambda$1(lazy));
            }
            goToAppSettings(activity);
            return;
        }
        if (permissionByName == Permission.LOCATION || permissionByName == Permission.FINE_LOCATION) {
            Activity activity2 = ownerActivity;
            String checkLocationPermission = checkLocationPermission(activity2, permissionByName == Permission.FINE_LOCATION);
            if (Intrinsics.areEqual(checkLocationPermission, "permitted")) {
                XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel2 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel2;
                xRequestPermissionResultModel2.setStatus(checkLocationPermission);
                xRequestPermissionResultModel2.setLocationStatus(getLocationStatus(activity2));
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel2, null, 2, null);
                return;
            }
            if (Intrinsics.areEqual(checkLocationPermission, "denied")) {
                XBaseModel createXModel3 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel3 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel3;
                xRequestPermissionResultModel3.setStatus(checkLocationPermission);
                xRequestPermissionResultModel3.setLocationStatus(getLocationStatus(activity2));
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel3, null, 2, null);
                return;
            }
            IHostLocationPermissionDepend locationPermissionDependInstance = RuntimeHelper.INSTANCE.getLocationPermissionDependInstance(bridgeContext);
            if (locationPermissionDependInstance != null) {
                locationPermissionDependInstance.requestPermission(ownerActivity, bridgeContext, getName(), new OnPermissionGrantCallback() { // from class: com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$handle$4
                    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback
                    public void onAllGranted() {
                        String locationStatus;
                        CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock = callback;
                        XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                        XRequestPermissionMethod xRequestPermissionMethod = this;
                        Activity activity3 = ownerActivity;
                        AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel4 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel4;
                        xRequestPermissionResultModel4.setStatus("permitted");
                        locationStatus = xRequestPermissionMethod.getLocationStatus(activity3);
                        xRequestPermissionResultModel4.setLocationStatus(locationStatus);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel4, null, 2, null);
                    }

                    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionGrantCallback
                    public void onNotGranted() {
                        String locationStatus;
                        String locationStatus2;
                        String locationStatus3;
                        if (permissionByName == XRequestPermissionMethod.Permission.LOCATION && XBridgePermissionUtils.INSTANCE.isCoarseLocationPermissionGranted(ownerActivity)) {
                            XBridge.log("onNotGranted, Permission = location && isCoarseLocationPermissionGranted");
                            CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock = callback;
                            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                            XRequestPermissionMethod xRequestPermissionMethod = this;
                            Activity activity3 = ownerActivity;
                            AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel4 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel4;
                            xRequestPermissionResultModel4.setStatus("permitted");
                            locationStatus3 = xRequestPermissionMethod.getLocationStatus(activity3);
                            xRequestPermissionResultModel4.setLocationStatus(locationStatus3);
                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel4, null, 2, null);
                            return;
                        }
                        if (XBridgePermissionUtils.INSTANCE.isALlLocationPermissionsRejected(ownerActivity)) {
                            XBridge.log("onNotGranted, isALlLocationPermissionsRejected");
                            CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock2 = callback;
                            XBaseModel createXModel5 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                            XRequestPermissionMethod xRequestPermissionMethod2 = this;
                            Activity activity4 = ownerActivity;
                            AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel5 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel5;
                            xRequestPermissionResultModel5.setStatus("denied");
                            locationStatus2 = xRequestPermissionMethod2.getLocationStatus(activity4);
                            xRequestPermissionResultModel5.setLocationStatus(locationStatus2);
                            CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel5, null, 2, null);
                            return;
                        }
                        XBridge.log("onNotGranted, else");
                        CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock3 = callback;
                        XBaseModel createXModel6 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                        XRequestPermissionMethod xRequestPermissionMethod3 = this;
                        Activity activity5 = ownerActivity;
                        AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel6 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel6;
                        xRequestPermissionResultModel6.setStatus("undetermined");
                        locationStatus = xRequestPermissionMethod3.getLocationStatus(activity5);
                        xRequestPermissionResultModel6.setLocationStatus(locationStatus);
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock3, (XBaseResultModel) createXModel6, null, 2, null);
                    }
                });
                return;
            }
            return;
        }
        if (permissionByName == Permission.PHOTOALBUM) {
            String accessLevel = params.getAccessLevel();
            if (accessLevel == null) {
                accessLevel = "readWrite";
            }
            Activity activity3 = ownerActivity;
            if (XBridgePermissionUtils.INSTANCE.isPhotoAlbumPermissionGranted(activity3, accessLevel)) {
                XBaseModel createXModel4 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel4 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel4;
                xRequestPermissionResultModel4.setStatus("permitted");
                xRequestPermissionResultModel4.setLocationStatus("unknown");
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel4, null, 2, null);
                return;
            }
            actualRequestPhotoAlbumPermission(bridgeContext, activity3, XBridgePermissionUtils.INSTANCE.getSpecifiedAlbumPermission(accessLevel), callback);
            return;
        }
        List<String> permission = permissionByName.getPermission();
        IHostPermissionDepend permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext);
        if (permissionDependInstance != null) {
            Activity activity4 = ownerActivity;
            ArrayList arrayList = new ArrayList();
            for (String str : permission) {
                if (str != null) {
                    arrayList.add(str);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        r3 = false;
        if (r3) {
            XBaseModel createXModel5 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
            AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel5 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel5;
            xRequestPermissionResultModel5.setStatus("permitted");
            xRequestPermissionResultModel5.setLocationStatus("unknown");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel5, null, 2, null);
            return;
        }
        actualRequestPermission(bridgeContext, ownerActivity, permissionByName.getPermission(), callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLocationStatus(Context context) {
        return XBridgePermissionUtils.INSTANCE.isFineLocationPermissionGranted(context) ? "fine" : XBridgePermissionUtils.INSTANCE.isCoarseLocationPermissionGranted(context) ? "coarse" : "failed";
    }

    private final void actualRequestPhotoAlbumPermission(IBDXBridgeContext bridgeContext, final Context context, List<String> permissions, final CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> callback) {
        final IHostPermissionDepend permissionDependInstance;
        Activity activity = XBridgeMethodHelper.INSTANCE.getActivity(context);
        if (activity == null || (permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext)) == null) {
            return;
        }
        String name = getName();
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            permissionDependInstance.requestPermission(activity, bridgeContext, name, (String[]) Arrays.copyOf(strArr, strArr.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$actualRequestPhotoAlbumPermission$1$2
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    String str2 = "permitted";
                    if (Build.VERSION.SDK_INT >= 33 && !allGranted && IHostPermissionDepend.this.isPermissionAllGranted(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) {
                        CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock = callback;
                        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                        AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel;
                        xRequestPermissionResultModel.setStatus("permitted");
                        xRequestPermissionResultModel.setLocationStatus("unknown");
                        CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                        return;
                    }
                    CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock2 = callback;
                    XBaseModel createXModel2 = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                    AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel2 = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel2;
                    if (!allGranted) {
                        str2 = !hasRejectedPermission(result) ? "undetermined" : "denied";
                    }
                    xRequestPermissionResultModel2.setStatus(str2);
                    xRequestPermissionResultModel2.setLocationStatus("unknown");
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock2, (XBaseResultModel) createXModel2, null, 2, null);
                }

                public final boolean hasRejectedPermission(Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Iterator<T> it = result.values().iterator();
                    while (it.hasNext()) {
                        if (((PermissionState) it.next()) == PermissionState.REJECTED) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final void actualRequestPermission(IBDXBridgeContext bridgeContext, Context context, List<String> permissions, final CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> callback) {
        IHostPermissionDepend permissionDependInstance;
        Activity activity = XBridgeMethodHelper.INSTANCE.getActivity(context);
        if (activity == null || (permissionDependInstance = RuntimeHelper.INSTANCE.getPermissionDependInstance(bridgeContext)) == null) {
            return;
        }
        String name = getName();
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (str != null) {
                arrayList.add(str);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            permissionDependInstance.requestPermission(activity, bridgeContext, name, (String[]) Arrays.copyOf(strArr, strArr.length), new OnPermissionCallback() { // from class: com.bytedance.sdk.xbridge.cn.permission.idl_bridge.XRequestPermissionMethod$actualRequestPermission$1$2
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
                public void onResult(boolean allGranted, Map<String, ? extends PermissionState> result) {
                    String str2;
                    Intrinsics.checkNotNullParameter(result, "result");
                    CompletionBlock<AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel> completionBlock = callback;
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel.class));
                    AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel xRequestPermissionResultModel = (AbsXRequestPermissionMethodIDL.XRequestPermissionResultModel) createXModel;
                    if (allGranted) {
                        str2 = "permitted";
                    } else {
                        str2 = !hasRejectedPermission(result) ? "undetermined" : "denied";
                    }
                    xRequestPermissionResultModel.setStatus(str2);
                    xRequestPermissionResultModel.setLocationStatus("unknown");
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                }

                public final boolean hasRejectedPermission(Map<String, ? extends PermissionState> result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Iterator<T> it = result.values().iterator();
                    while (it.hasNext()) {
                        if (((PermissionState) it.next()) == PermissionState.REJECTED) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
