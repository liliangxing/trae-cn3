package com.ss.android.common.app.permission.callback;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: ActivityPlus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u008e\u0001\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\nj\u0002`\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132[\u0010\u0014\u001aW\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001a\u008e\u0001\u0010\u001c\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u001dj\u0002`\u001e2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132[\u0010\u0014\u001aW\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0002¢\u0006\u0002\u0010\u001f\u001a\u0088\u0001\u0010 \u001a\u00020\r*\u00020!2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132]\b\u0002\u0010\u0014\u001aW\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0007¢\u0006\u0002\u0010\"\u001a\u0088\u0001\u0010 \u001a\u00020\r*\u00020#2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132]\b\u0002\u0010\u0014\u001aW\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0007¢\u0006\u0002\u0010$\u001a\u008c\u0001\u0010 \u001a\u00020\r*\u00060%j\u0002`&2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132]\b\u0002\u0010\u0014\u001aW\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0007¢\u0006\u0002\u0010'\u001a\u008c\u0001\u0010 \u001a\u00020\r*\u00060(j\u0002`)2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132]\b\u0002\u0010\u0014\u001aW\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aH\u0007¢\u0006\u0002\u0010*\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0002\u0010+\"\u00020%2\u00020%*\f\b\u0002\u0010,\"\u00020\n2\u00020\n*¦\u0001\b\u0002\u0010-\"O\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r0\u00152O\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0012\u0012\u001b\u0012\u0019\u0012\u0006\b\u0001\u0012\u00020\u00010\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r0\u0015*\f\b\u0002\u0010.\"\u00020(2\u00020(*\f\b\u0002\u0010/\"\u00020\u001d2\u00020\u001d¨\u00060"}, d2 = {"TAG_FRAGMENT", "", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "pendingRequestManagerFragments", "", "Landroid/app/FragmentManager;", "Lcom/ss/android/common/app/permission/callback/AssistFragment;", "requestActivityPermissions", "", "fragmentManager", "Lcom/ss/android/common/app/permission/callback/AppFragmentManager;", "permissions", "", "requestCode", "", "callBack", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "grantResults", "Lcom/ss/android/common/app/permission/callback/CallBack;", "(Landroid/app/FragmentManager;[Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "requestV4ActivityPermissions", "Landroidx/fragment/app/FragmentManager;", "Lcom/ss/android/common/app/permission/callback/V4FragmentManager;", "(Landroid/support/v4/app/FragmentManager;[Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "requestPermissions", "Landroid/app/Activity;", "(Landroid/app/Activity;[Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "Landroidx/fragment/app/FragmentActivity;", "(Landroid/support/v4/app/FragmentActivity;[Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "Landroid/app/Fragment;", "Lcom/ss/android/common/app/permission/callback/AppFragment;", "(Landroid/app/Fragment;[Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/common/app/permission/callback/V4Fragment;", "(Landroid/support/v4/app/Fragment;[Ljava/lang/String;ILkotlin/jvm/functions/Function3;)V", "AppFragment", "AppFragmentManager", "CallBack", "V4Fragment", "V4FragmentManager", "permissions_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ActivityPlusKt {
    private static final String TAG_FRAGMENT = "com.ss.android.bridge_base.AssistFragment";
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(ActivityPlusKt.class, "permissions_release"), "mainHandler", "getMainHandler()Landroid/os/Handler;"))};
    private static final Lazy mainHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: com.ss.android.common.app.permission.callback.ActivityPlusKt$mainHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m4146invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private static final Map<FragmentManager, AssistFragment> pendingRequestManagerFragments = new LinkedHashMap();

    private static final Handler getMainHandler() {
        Lazy lazy = mainHandler$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Handler) lazy.getValue();
    }

    public static final void requestPermissions(Activity activity, String[] strArr, int i) {
        requestPermissions$default(activity, strArr, i, (Function3) null, 4, (Object) null);
    }

    public static final void requestPermissions(Fragment fragment, String[] strArr, int i) {
        requestPermissions$default(fragment, strArr, i, (Function3) null, 4, (Object) null);
    }

    public static final void requestPermissions(androidx.fragment.app.Fragment fragment, String[] strArr, int i) {
        requestPermissions$default(fragment, strArr, i, (Function3) null, 4, (Object) null);
    }

    public static final void requestPermissions(FragmentActivity fragmentActivity, String[] strArr, int i) {
        requestPermissions$default(fragmentActivity, strArr, i, (Function3) null, 4, (Object) null);
    }

    public static /* synthetic */ void requestPermissions$default(Activity activity, String[] strArr, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function3 = null;
        }
        requestPermissions(activity, strArr, i, (Function3<? super Integer, ? super String[], ? super int[], Unit>) function3);
    }

    public static final void requestPermissions(Activity activity, String[] strArr, int i, Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$requestPermissions");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        FragmentManager fragmentManager = activity.getFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(fragmentManager, "fragmentManager");
        requestActivityPermissions(fragmentManager, strArr, i, function3);
    }

    public static /* synthetic */ void requestPermissions$default(Fragment fragment, String[] strArr, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function3 = null;
        }
        requestPermissions(fragment, strArr, i, (Function3<? super Integer, ? super String[], ? super int[], Unit>) function3);
    }

    public static final void requestPermissions(Fragment fragment, String[] strArr, int i, Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$requestPermissions");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Activity activity = fragment.getActivity();
        Intrinsics.checkExpressionValueIsNotNull(activity, RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
        FragmentManager fragmentManager = activity.getFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(fragmentManager, "activity.fragmentManager");
        requestActivityPermissions(fragmentManager, strArr, i, function3);
    }

    public static /* synthetic */ void requestPermissions$default(FragmentActivity fragmentActivity, String[] strArr, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function3 = null;
        }
        requestPermissions(fragmentActivity, strArr, i, (Function3<? super Integer, ? super String[], ? super int[], Unit>) function3);
    }

    public static final void requestPermissions(FragmentActivity fragmentActivity, String[] strArr, int i, Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "$this$requestPermissions");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        requestV4ActivityPermissions(supportFragmentManager, strArr, i, function3);
    }

    public static /* synthetic */ void requestPermissions$default(androidx.fragment.app.Fragment fragment, String[] strArr, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function3 = null;
        }
        requestPermissions(fragment, strArr, i, (Function3<? super Integer, ? super String[], ? super int[], Unit>) function3);
    }

    public static final void requestPermissions(androidx.fragment.app.Fragment fragment, String[] strArr, int i, Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        Intrinsics.checkParameterIsNotNull(fragment, "$this$requestPermissions");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        androidx.fragment.app.FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        requestV4ActivityPermissions(childFragmentManager, strArr, i, function3);
    }

    private static final void requestV4ActivityPermissions(androidx.fragment.app.FragmentManager fragmentManager, String[] strArr, int i, final Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        androidx.fragment.app.Fragment findFragmentByTag = fragmentManager.findFragmentByTag(TAG_FRAGMENT);
        if (!(findFragmentByTag instanceof AssistV4Fragment)) {
            findFragmentByTag = null;
        }
        AssistV4Fragment assistV4Fragment = (AssistV4Fragment) findFragmentByTag;
        if (assistV4Fragment == null) {
            assistV4Fragment = new AssistV4Fragment();
            fragmentManager.beginTransaction().add(assistV4Fragment, TAG_FRAGMENT).commitNowAllowingStateLoss();
        }
        assistV4Fragment.setOnRequestPermissionsResult(new Function3<Integer, String[], int[], Unit>() { // from class: com.ss.android.common.app.permission.callback.ActivityPlusKt$requestV4ActivityPermissions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).intValue(), (String[]) obj2, (int[]) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, String[] strArr2, int[] iArr) {
                Intrinsics.checkParameterIsNotNull(strArr2, "permissions");
                Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
                Function3 function32 = function3;
                if (function32 != null) {
                }
            }
        });
        assistV4Fragment.requestPermissions(strArr, i);
    }

    private static final void requestActivityPermissions(final FragmentManager fragmentManager, final String[] strArr, final int i, final Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(TAG_FRAGMENT);
        if (!(findFragmentByTag instanceof AssistFragment)) {
            findFragmentByTag = null;
        }
        objectRef.element = (AssistFragment) findFragmentByTag;
        if (((AssistFragment) objectRef.element) == null) {
            Map<FragmentManager, AssistFragment> map = pendingRequestManagerFragments;
            objectRef.element = map.get(fragmentManager);
            if (((AssistFragment) objectRef.element) == null) {
                objectRef.element = new AssistFragment();
                map.put(fragmentManager, (AssistFragment) objectRef.element);
                fragmentManager.beginTransaction().add((AssistFragment) objectRef.element, TAG_FRAGMENT).commitAllowingStateLoss();
            }
        }
        getMainHandler().post(new Runnable() { // from class: com.ss.android.common.app.permission.callback.ActivityPlusKt$requestActivityPermissions$1
            @Override // java.lang.Runnable
            public final void run() {
                Map map2;
                map2 = ActivityPlusKt.pendingRequestManagerFragments;
                map2.remove(fragmentManager);
                ((AssistFragment) objectRef.element).setOnRequestPermissionsResult(new Function3<Integer, String[], int[], Unit>() { // from class: com.ss.android.common.app.permission.callback.ActivityPlusKt$requestActivityPermissions$1.1
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke(((Number) obj).intValue(), (String[]) obj2, (int[]) obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2, String[] strArr2, int[] iArr) {
                        Intrinsics.checkParameterIsNotNull(strArr2, "permissions");
                        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
                        Function3 function32 = function3;
                        if (function32 != null) {
                        }
                    }
                });
                ((AssistFragment) objectRef.element).requestPermissions(strArr, i);
            }
        });
    }
}
