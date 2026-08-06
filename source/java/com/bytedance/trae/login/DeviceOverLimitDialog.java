package com.bytedance.trae.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.rts.foundation.Int32;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.login.databinding.TraeDialogDeviceOverLimitBinding;
import com.bytedance.trae.login.traeauth.DeviceSummary;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: DeviceOverLimitDialog.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003-./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001e\u001a\u00020\u0018H\u0002J&\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180#H\u0002J0\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/bytedance/trae/login/DeviceOverLimitDialog;", "", "<init>", "()V", "TAG", "", "DEFAULT_BOTTOM_SHEET_HEIGHT_RATIO", "", "savedScene", "Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;", "savedCallback", "Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;", "savedActivity", "Landroid/app/Activity;", "savedMaxDeviceCount", "", "savedAdapter", "Lcom/bytedance/trae/login/DeviceOverLimitDeviceAdapter;", "isContinueClicked", "", "()Z", "setContinueClicked", "(Z)V", IMessageCallbackService.EVENT_TYPE_SHOW, "", "activity", "result", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", ReportConst.KEY_SCENE, "callback", "onCallback", "showLogoutConfirmDialog", "device", "Lcom/bytedance/trae/login/traeauth/DeviceSummary;", "onConfirmLogout", "Lkotlin/Function0;", "launchClearRefreshToken", "deviceId", "adapter", "binding", "Lcom/bytedance/trae/login/databinding/TraeDialogDeviceOverLimitBinding;", "maxDeviceCount", "resolveBottomSheetHeight", "bottomSheet", "Landroid/view/View;", "Callback", "Scene", "DeviceSpacingDecoration", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialog {
    private static final float DEFAULT_BOTTOM_SHEET_HEIGHT_RATIO = 0.9f;
    private static final String TAG = "DeviceOverLimitDialog";
    private static boolean isContinueClicked;
    private static Activity savedActivity;
    private static DeviceOverLimitDeviceAdapter savedAdapter;
    private static Callback savedCallback;
    private static Scene savedScene;
    public static final DeviceOverLimitDialog INSTANCE = new DeviceOverLimitDialog();
    private static int savedMaxDeviceCount = Int32.MAX_VALUE;

    /* compiled from: DeviceOverLimitDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/DeviceOverLimitDialog$Callback;", "", "onResult", "", "canContinue", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Callback {
        void onResult(boolean canContinue);
    }

    /* compiled from: DeviceOverLimitDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scene.values().length];
            try {
                iArr[Scene.LOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scene.REBIND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Scene.EXCHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DeviceOverLimitDialog() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DeviceOverLimitDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/login/DeviceOverLimitDialog$Scene;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN", "REBIND", "EXCHANGE", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Scene {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Scene[] $VALUES;
        public static final Scene LOGIN = new Scene("LOGIN", 0);
        public static final Scene REBIND = new Scene("REBIND", 1);
        public static final Scene EXCHANGE = new Scene("EXCHANGE", 2);

        private static final /* synthetic */ Scene[] $values() {
            return new Scene[]{LOGIN, REBIND, EXCHANGE};
        }

        public static EnumEntries<Scene> getEntries() {
            return $ENTRIES;
        }

        private Scene(String str, int i) {
        }

        static {
            Scene[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Scene valueOf(String str) {
            return (Scene) Enum.valueOf(Scene.class, str);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }
    }

    public final boolean isContinueClicked() {
        return isContinueClicked;
    }

    public final void setContinueClicked(boolean z) {
        isContinueClicked = z;
    }

    public static /* synthetic */ void show$default(DeviceOverLimitDialog deviceOverLimitDialog, Activity activity, ListDevicesResult listDevicesResult, Scene scene, Callback callback, int i, Object obj) {
        if ((i & 8) != 0) {
            callback = null;
        }
        deviceOverLimitDialog.show(activity, listDevicesResult, scene, callback);
    }

    public final void show(final Activity activity, final ListDevicesResult result, final Scene scene, Callback callback) {
        String string;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        savedScene = scene;
        savedCallback = callback;
        savedActivity = activity;
        Integer maxDeviceCount = result.getMaxDeviceCount();
        savedMaxDeviceCount = maxDeviceCount != null ? maxDeviceCount.intValue() : Int32.MAX_VALUE;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Activity activity2 = activity;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity2, com.google.android.material.R.style.Theme_MaterialComponents_Light_BottomSheetDialog);
        final TraeDialogDeviceOverLimitBinding inflate = TraeDialogDeviceOverLimitBinding.inflate(LayoutInflater.from(bottomSheetDialog.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        TextView textView = inflate.loginCurrentText;
        int i = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
        if (i == 1) {
            string = activity.getString(C0882R.string.trae_device_over_limit_login_current);
        } else if (i == 2) {
            string = activity.getString(C0882R.string.trae_device_over_limit_stay_current);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            string = activity.getString(C0882R.string.trae_device_over_limit_stay_current);
        }
        textView.setText(string);
        inflate.tvDescription.setText(activity.getString(C0882R.string.trae_device_over_limit_description, new Object[]{Integer.valueOf(savedMaxDeviceCount)}));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        List<DeviceSummary> devices = result.getDevices();
        if (devices == null) {
            devices = CollectionsKt.emptyList();
        }
        objectRef.element = new DeviceOverLimitDeviceAdapter(devices, new Function1() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit show$lambda$1;
                show$lambda$1 = DeviceOverLimitDialog.show$lambda$1(activity, objectRef, inflate, result, (DeviceSummary) obj);
                return show$lambda$1;
            }
        });
        savedAdapter = (DeviceOverLimitDeviceAdapter) objectRef.element;
        inflate.rvDevices.setLayoutManager(new LinearLayoutManager(activity2));
        inflate.rvDevices.addItemDecoration(new DeviceSpacingDecoration((int) (activity.getResources().getDisplayMetrics().density * 12)));
        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DeviceOverLimitDialog.show$lambda$2(dialogInterface);
            }
        });
        inflate.rvDevices.setAdapter((RecyclerView.Adapter) objectRef.element);
        inflate.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        inflate.btnLoginCurrent.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceOverLimitDialog.show$lambda$4(bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.setContentView(inflate.getRoot());
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DeviceOverLimitDialog.show$lambda$5(dialogInterface);
            }
        });
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DeviceOverLimitDialog.show$lambda$7(bottomSheetDialog, activity, scene, dialogInterface);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$1(final Activity activity, final Ref.ObjectRef objectRef, final TraeDialogDeviceOverLimitBinding traeDialogDeviceOverLimitBinding, final ListDevicesResult listDevicesResult, DeviceSummary deviceSummary) {
        Intrinsics.checkNotNullParameter(deviceSummary, "device");
        String deviceId = deviceSummary.getDeviceId();
        if (deviceId == null) {
            deviceId = "";
        }
        final String str = deviceId;
        if (StringsKt.isBlank(str)) {
            FLogger.INSTANCE.mo430w(TAG, "logout device clicked with empty deviceId");
        } else {
            FLogger.INSTANCE.mo428i(TAG, "logout device clicked, deviceId=" + str);
            INSTANCE.showLogoutConfirmDialog(activity, deviceSummary, new Function0() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit show$lambda$1$lambda$0;
                    show$lambda$1$lambda$0 = DeviceOverLimitDialog.show$lambda$1$lambda$0(activity, str, objectRef, traeDialogDeviceOverLimitBinding, listDevicesResult);
                    return show$lambda$1$lambda$0;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$1$lambda$0(Activity activity, String str, Ref.ObjectRef objectRef, TraeDialogDeviceOverLimitBinding traeDialogDeviceOverLimitBinding, ListDevicesResult listDevicesResult) {
        DeviceOverLimitDialog deviceOverLimitDialog = INSTANCE;
        Object obj = objectRef.element;
        Intrinsics.checkNotNull(obj);
        DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter = (DeviceOverLimitDeviceAdapter) obj;
        Integer maxDeviceCount = listDevicesResult.getMaxDeviceCount();
        deviceOverLimitDialog.launchClearRefreshToken(activity, str, deviceOverLimitDeviceAdapter, traeDialogDeviceOverLimitBinding, maxDeviceCount != null ? maxDeviceCount.intValue() : Int32.MAX_VALUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(DialogInterface dialogInterface) {
        INSTANCE.onCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$4(BottomSheetDialog bottomSheetDialog, View view) {
        isContinueClicked = true;
        bottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5(DialogInterface dialogInterface) {
        INSTANCE.onCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$7(BottomSheetDialog bottomSheetDialog, Activity activity, Scene scene, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int resolveBottomSheetHeight = INSTANCE.resolveBottomSheetHeight(activity, findViewById);
            from.setPeekHeight(resolveBottomSheetHeight);
            from.setState(3);
            from.setSkipCollapsed(true);
            from.setHideable(true);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = resolveBottomSheetHeight;
            findViewById.setLayoutParams(layoutParams);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (scene == Scene.EXCHANGE) {
                jSONObject.put(EventConstants.PARAM_SOURCE, "exchangetoken");
            } else if (scene == Scene.REBIND) {
                jSONObject.put(EventConstants.PARAM_SOURCE, "binddevice");
            } else {
                jSONObject.put(EventConstants.PARAM_SOURCE, "getrefreshtoken");
            }
            IApplog.Companion.reportEvent("device_page_show", jSONObject);
        } catch (Throwable unused) {
        }
    }

    private final void onCallback() {
        DeviceOverLimitDeviceAdapter deviceOverLimitDeviceAdapter = savedAdapter;
        if (deviceOverLimitDeviceAdapter == null) {
            return;
        }
        boolean z = deviceOverLimitDeviceAdapter.getItemCount() < savedMaxDeviceCount;
        try {
            JSONObject jSONObject = new JSONObject();
            if (isContinueClicked) {
                jSONObject.put("buttonType", "login");
            } else {
                jSONObject.put("buttonType", "close");
            }
            if (z) {
                jSONObject.put("loginStatus", "login");
            } else {
                jSONObject.put("loginStatus", "logout");
            }
            IApplog.Companion.reportEvent("device_page_dismiss", jSONObject);
        } catch (Throwable unused) {
        }
        Callback callback = savedCallback;
        if (callback != null) {
            callback.onResult(z);
        }
        savedScene = null;
        savedCallback = null;
        savedActivity = null;
        savedAdapter = null;
    }

    private final void showLogoutConfirmDialog(Activity activity, DeviceSummary device, final Function0<Unit> onConfirmLogout) {
        IApplog.Companion.reportEvent("device_delete_click");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        String deviceName = device.getDeviceName();
        if (deviceName == null) {
            deviceName = "";
        }
        String str = deviceName;
        if (StringsKt.isBlank(str)) {
            String deviceModel = device.getDeviceModel();
            str = deviceModel != null ? deviceModel : "";
        }
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            str2 = activity.getString(C0882R.string.trae_device_over_limit_unknown_device);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        }
        String string = activity.getString(C0882R.string.trae_device_over_limit_logout_confirm_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = activity.getString(C0882R.string.trae_device_over_limit_logout_confirm_message);
        String string3 = activity.getString(C0882R.string.trae_device_over_limit_logout_confirm_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = activity.getString(C0882R.string.trae_device_over_limit_logout_confirm_logout);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        new CustomConfirmDialog(activity, new CustomConfirmDialog.Config(string, string2, (String) null, (String) null, string3, string4, (Integer) null, 0.0f, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, 0, (Integer) null, (Integer) null, (Integer) null, false, new Function1() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit showLogoutConfirmDialog$lambda$10;
                showLogoutConfirmDialog$lambda$10 = DeviceOverLimitDialog.showLogoutConfirmDialog$lambda$10(onConfirmLogout, (String) obj);
                return showLogoutConfirmDialog$lambda$10;
            }
        }, new Function0() { // from class: com.bytedance.trae.login.DeviceOverLimitDialog$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 524236, (DefaultConstructorMarker) null)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showLogoutConfirmDialog$lambda$10(Function0 function0, String str) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private final void launchClearRefreshToken(Activity activity, String deviceId, DeviceOverLimitDeviceAdapter adapter, TraeDialogDeviceOverLimitBinding binding, int maxDeviceCount) {
        LifecycleCoroutineScope lifecycleScope;
        LifecycleOwner lifecycleOwner = activity instanceof LifecycleOwner ? (LifecycleOwner) activity : null;
        BuildersKt.launch$default((lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()) : (CoroutineScope) lifecycleScope, Dispatchers.getIO(), (CoroutineStart) null, new DeviceOverLimitDialog$launchClearRefreshToken$1(deviceId, adapter, maxDeviceCount, binding, activity, null), 2, (Object) null);
    }

    private final int resolveBottomSheetHeight(Activity activity, View bottomSheet) {
        int intValue;
        View decorView;
        Integer valueOf = Integer.valueOf(bottomSheet.getRootView().getHeight());
        Integer num = null;
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            intValue = valueOf.intValue();
        } else {
            Window window = activity.getWindow();
            if (window != null && (decorView = window.getDecorView()) != null) {
                Integer valueOf2 = Integer.valueOf(decorView.getHeight());
                if (valueOf2.intValue() > 0) {
                    num = valueOf2;
                }
            }
            intValue = num != null ? num.intValue() : activity.getResources().getDisplayMetrics().heightPixels;
        }
        return MathKt.roundToInt(intValue * DEFAULT_BOTTOM_SHEET_HEIGHT_RATIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceOverLimitDialog.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/login/DeviceOverLimitDialog$DeviceSpacingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spacing", "", "<init>", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DeviceSpacingDecoration extends RecyclerView.ItemDecoration {
        private final int spacing;

        public DeviceSpacingDecoration(int i) {
            this.spacing = i;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                int itemCount = adapter.getItemCount();
                if (childAdapterPosition == -1 || childAdapterPosition >= itemCount - 1) {
                    return;
                }
                outRect.bottom = this.spacing;
            }
        }
    }
}
