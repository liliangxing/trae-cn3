package com.bytedance.android.anniex.lite;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.builder.LitePageBuilder;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.container.p025ui.AnnieXPageHelper;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider;
import com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLiteFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0013\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u0004\u0018\u00010\bJ\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\b2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020.\u0018\u00010-J\"\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\u00020\"2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010=\u001a\u00020>2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010D\u001a\u00020\"H\u0016J\b\u0010E\u001a\u00020\"H\u0016J\u0010\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\"H\u0016J\b\u0010J\u001a\u00020\"H\u0016J\u0010\u0010K\u001a\u00020\"2\u0006\u0010L\u001a\u00020<H\u0016J\b\u0010M\u001a\u00020\"H\u0016J\b\u0010N\u001a\u00020\"H\u0016J\u001a\u0010O\u001a\u00020\"2\u0006\u0010P\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010Q\u001a\u00020\"2\b\u0010R\u001a\u0004\u0018\u00010<H\u0016J\u0015\u0010S\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\bTJ\u0015\u0010U\u001a\u00020\"2\u0006\u0010B\u001a\u00020\u0018H\u0000¢\u0006\u0002\bVJ\u0010\u0010W\u001a\u00020\"2\u0006\u0010X\u001a\u00020YH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "builder", "Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;)V", "()V", "currentBid", "", "currentSchema", "currentSessionId", "defaultTitleBar", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getDefaultTitleBar", "()Landroid/view/View;", "defaultTitleBar$delegate", "Lkotlin/Lazy;", "lifecycleObserver", "com/bytedance/android/anniex/lite/AnnieXLiteFragment$lifecycleObserver$1", "Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment$lifecycleObserver$1;", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "pageContainer", "Lcom/bytedance/android/anniex/lite/container/AnnieXLitePageContainer;", "pageDelegate", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "getPageDelegate", "()Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "pageDelegate$delegate", "pageIntent", "Landroid/content/Intent;", "rootView", "close", "", "getBid", "getBundle", "getChannel", "getContainerId", "getCurrentSchema", "getSchema", "Landroid/net/Uri;", "loadSchema", StrategyConstants.SCHEMA, "renderData", "", "", "onActivityResult", "requestCode", "", "resultCode", Constants.KEY_DATA, "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onViewCreated", "view", "setArguments", "args", "setListener", "setListener$anniex_release", "setPageContainer", "setPageContainer$anniex_release", "setUserVisibleHint", "isVisibleToUser", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLiteFragment extends AppCompatDialogFragment implements IRouterAbilityProvider {
    private static final String TAG = "AnnieXLiteFragment";
    private LitePageBuilder builder;
    private String currentBid;
    private String currentSchema;
    private String currentSessionId;

    /* renamed from: defaultTitleBar$delegate, reason: from kotlin metadata */
    private final Lazy defaultTitleBar;
    private AnnieXLiteFragment$lifecycleObserver$1 lifecycleObserver;
    private AnnieXFragmentListener listener;
    private AnnieXLitePageContainer pageContainer;

    /* renamed from: pageDelegate$delegate, reason: from kotlin metadata */
    private final Lazy pageDelegate;
    private Intent pageIntent;
    private View rootView;

    public void setArguments(Bundle args) {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.android.anniex.lite.AnnieXLiteFragment$lifecycleObserver$1] */
    public AnnieXLiteFragment() {
        this.currentBid = "default_bid";
        this.defaultTitleBar = LazyKt.lazy(new Function0<View>() { // from class: com.bytedance.android.anniex.lite.AnnieXLiteFragment$defaultTitleBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m3338invoke() {
                return AnnieXLiteFragment.this.getLayoutInflater().inflate(C0840R.layout.annie_x_title_bar, (ViewGroup) null, false);
            }
        });
        this.pageDelegate = LazyKt.lazy(new Function0<IAnnieXLitePageDelegate>() { // from class: com.bytedance.android.anniex.lite.AnnieXLiteFragment$pageDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IAnnieXLitePageDelegate m3339invoke() {
                LitePageBuilder litePageBuilder;
                String str;
                AnnieXServiceCenter annieXServiceCenter = AnnieXServiceCenter.INSTANCE;
                litePageBuilder = AnnieXLiteFragment.this.builder;
                if (litePageBuilder == null || (str = litePageBuilder.getBid()) == null) {
                    str = AnnieXLiteFragment.this.currentBid;
                }
                IAnnieXLitePageDelegateProvider iAnnieXLitePageDelegateProvider = (IAnnieXLitePageDelegateProvider) annieXServiceCenter.getService(str, IAnnieXLitePageDelegateProvider.class);
                if (iAnnieXLitePageDelegateProvider != null) {
                    return iAnnieXLitePageDelegateProvider.provideDelegate();
                }
                return null;
            }
        });
        this.lifecycleObserver = new LifecycleObserver() { // from class: com.bytedance.android.anniex.lite.AnnieXLiteFragment$lifecycleObserver$1
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume(LifecycleOwner source) {
                Intent intent;
                Intrinsics.checkNotNullParameter(source, "source");
                intent = AnnieXLiteFragment.this.pageIntent;
                FragmentActivity activity = AnnieXLiteFragment.this.getActivity();
                if (Intrinsics.areEqual(intent, activity != null ? activity.getIntent() : null)) {
                    return;
                }
                AnnieXLiteFragment.this.dismissAllowingStateLoss();
            }
        };
    }

    public String getBulletTag() {
        return IRouterAbilityProvider.DefaultImpls.getBulletTag(this);
    }

    private final View getDefaultTitleBar() {
        return (View) this.defaultTitleBar.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnieXLiteFragment(LitePageBuilder litePageBuilder) {
        this();
        Intrinsics.checkNotNullParameter(litePageBuilder, "builder");
        this.builder = litePageBuilder;
        this.currentBid = litePageBuilder.getBid();
        this.currentSchema = litePageBuilder.getBundle().getString("__x_inner_schema");
        this.currentSessionId = litePageBuilder.getBundle().getString("__x_session_id");
    }

    private final IAnnieXLitePageDelegate getPageDelegate() {
        return (IAnnieXLitePageDelegate) this.pageDelegate.getValue();
    }

    public final String getCurrentSchema() {
        return this.currentSchema;
    }

    public final void setPageContainer$anniex_release(AnnieXLitePageContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.pageContainer = container;
        if (container != null) {
            container.setDelegate(getPageDelegate());
        }
    }

    public final void setListener$anniex_release(AnnieXFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public String getContainerId() {
        String containerId;
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        return (annieXLitePageContainer == null || (containerId = annieXLitePageContainer.getContainerId()) == null) ? "" : containerId;
    }

    public Uri getSchema() {
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        return Uri.parse(annieXLitePageContainer != null ? annieXLitePageContainer.getCurrentSchema() : null);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(256);
        }
        return onCreateDialog;
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("bid", this.currentBid);
        outState.putString("__x_inner_schema", this.currentSchema);
    }

    public void onAttach(Context context) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        this.pageIntent = activity != null ? activity.getIntent() : null;
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (lifecycle = activity2.getLifecycle()) == null) {
            return;
        }
        lifecycle.addObserver(this.lifecycleObserver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle;
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            String string = savedInstanceState.getString("bid");
            if (string == null) {
                string = "default_bid";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "savedInstanceState.getSt…ID)?:BidConstants.DEFAULT");
            }
            this.currentBid = string;
            this.currentSchema = savedInstanceState.getString("__x_inner_schema");
            this.currentSessionId = savedInstanceState.getString("__x_session_id");
            LitePageBuilder litePageBuilder = new LitePageBuilder();
            litePageBuilder.setBid$anniex_release(this.currentBid);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            litePageBuilder.activity(requireActivity);
            litePageBuilder.bundle(savedInstanceState);
            this.builder = litePageBuilder;
        }
        if (!AnnieXPageHelper.INSTANCE.tryInitAnnieXIfNeed$anniex_release(getContext(), this.currentBid, TAG) && IConditionCallKt.enableAnnieXLitePageClose()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "tryInitAnnieXIfNeed failed, bid = " + this.currentBid, (Map) null, (LoggerContext) null, 12, (Object) null);
            dismissAllowingStateLoss();
            return;
        }
        if (this.pageContainer == null) {
            LitePageBuilder litePageBuilder2 = this.builder;
            AnnieXLitePageContainer annieXLitePageContainer = litePageBuilder2 != null ? new AnnieXLitePageContainer(litePageBuilder2) : null;
            this.pageContainer = annieXLitePageContainer;
            if (annieXLitePageContainer != null) {
                annieXLitePageContainer.setDelegate(getPageDelegate());
            }
        }
        AnnieXLitePageContainer annieXLitePageContainer2 = this.pageContainer;
        if (annieXLitePageContainer2 != null) {
            IAnnieXLitePageDelegate pageDelegate = getPageDelegate();
            if (pageDelegate != null) {
                DialogFragment dialogFragment = (DialogFragment) this;
                LitePageBuilder litePageBuilder3 = this.builder;
                if (litePageBuilder3 == null || (bundle = litePageBuilder3.getBundle()) == null) {
                    bundle = new Bundle();
                }
                pageDelegate.onCreate(dialogFragment, bundle);
            }
            annieXLitePageContainer2.onAttach((DialogFragment) this);
        }
        AnnieXLitePageContainer annieXLitePageContainer3 = this.pageContainer;
        if (annieXLitePageContainer3 != null) {
            annieXLitePageContainer3.onCreate(savedInstanceState);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AnnieXLitePageContainer annieXLitePageContainer;
        IAnnieXLitePageDelegate pageDelegate;
        AnnieXLitePageContainer annieXLitePageContainer2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onCreateView(inflater, container, savedInstanceState);
        }
        View inflate = inflater.inflate(C0840R.layout.annie_x_fragment_webcast, container, false);
        this.rootView = inflate;
        FrameLayout frameLayout = inflate != null ? (FrameLayout) inflate.findViewById(C0840R.id.anniex_title_bar_container) : null;
        AnnieXLitePageContainer annieXLitePageContainer3 = this.pageContainer;
        String str = this.currentBid;
        View defaultTitleBar = getDefaultTitleBar();
        Intrinsics.checkNotNullExpressionValue(defaultTitleBar, "defaultTitleBar");
        AnnieXLiteUtilsKt.setTitleBarView(frameLayout, annieXLitePageContainer3, str, defaultTitleBar, getContext());
        AnnieXLitePageContainer annieXLitePageContainer4 = this.pageContainer;
        if (annieXLitePageContainer4 != null) {
            annieXLitePageContainer4.onCreateView(this.rootView);
        }
        if (this.rootView != null && (annieXLitePageContainer = this.pageContainer) != null && (pageDelegate = getPageDelegate()) != null) {
            View view = this.rootView;
            Intrinsics.checkNotNull(view);
            IPopupContainer.PopupComponent createLiteComponent = pageDelegate.createLiteComponent(view, annieXLitePageContainer);
            if (createLiteComponent != null && (annieXLitePageContainer2 = this.pageContainer) != null) {
                annieXLitePageContainer2.setPopupComponent(createLiteComponent);
            }
        }
        return this.rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        AnnieXLitePageContainer annieXLitePageContainer;
        AnnieXLitePageContainer annieXLitePageContainer2;
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() == null && (str = this.currentSessionId) != null) {
            MonitorManager.INSTANCE.onContainerError$anniex_release(this.currentBid, str, AbsBulletMonitorCallback.ErrStage.Container, "open_dialog_fragment_with_no_activity");
        }
        View view2 = this.rootView;
        if (view2 != null && (annieXLitePageContainer2 = this.pageContainer) != null) {
            annieXLitePageContainer2.onViewCreated(view2, savedInstanceState);
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onViewCreated(view, savedInstanceState);
        }
        String str2 = this.currentSchema;
        if (str2 == null || (annieXLitePageContainer = this.pageContainer) == null) {
            return;
        }
        annieXLitePageContainer.loadSchema(str2, null);
    }

    public void onStart() {
        super.onStart();
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onStart(this.pageContainer);
        }
    }

    public void onDismiss(DialogInterface dialog) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        LitePageService.INSTANCE.destroyBulletPopup(this);
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.onDismiss(dialog);
        }
        IAnnieXLitePageDelegate pageDelegate = getPageDelegate();
        if (pageDelegate != null) {
            pageDelegate.onRelease();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (lifecycle = activity.getLifecycle()) == null) {
            return;
        }
        lifecycle.removeObserver(this.lifecycleObserver);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IAnnieXLitePageDelegate pageDelegate = getPageDelegate();
        if (pageDelegate != null) {
            pageDelegate.onActivityResult(requestCode, resultCode, data);
        }
    }

    public final void loadSchema(String schema, Map<String, ? extends Object> renderData) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.loadSchema(schema, renderData);
        }
        this.currentSchema = schema;
    }

    public void onResume() {
        super.onResume();
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.onResume();
        }
        AnnieXLitePageContainer annieXLitePageContainer2 = this.pageContainer;
        if (annieXLitePageContainer2 != null) {
            annieXLitePageContainer2.enterForeground();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.onPause();
        }
        AnnieXLitePageContainer annieXLitePageContainer2 = this.pageContainer;
        if (annieXLitePageContainer2 != null) {
            annieXLitePageContainer2.enterBackground();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onPause();
        }
    }

    public void onStop() {
        super.onStop();
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.onStop();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onStop();
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.setUserVisibleHint(isVisibleToUser);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onDestroy(this.pageContainer);
        }
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer != null) {
            annieXLitePageContainer.release();
        }
        this.pageContainer = null;
    }

    public void onDetach() {
        super.onDetach();
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onDetach();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onConfigurationChanged(newConfig);
        }
    }

    public String getBid() {
        String bid$anniex_release;
        LitePageBuilder litePageBuilder = this.builder;
        return (litePageBuilder == null || (bid$anniex_release = litePageBuilder.getBid()) == null) ? this.currentBid : bid$anniex_release;
    }

    public String getChannel() {
        Bundle bundle$anniex_release;
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer == null) {
            return "";
        }
        String str = null;
        String str2 = (String) new StringParam(annieXLitePageContainer.getAnnieXContext().getSchemaModelUnion().getSchemaData(), "channel", (String) null).getValue();
        if (str2 == null) {
            LitePageBuilder litePageBuilder = this.builder;
            if (litePageBuilder != null && (bundle$anniex_release = litePageBuilder.getBundle()) != null) {
                str = bundle$anniex_release.getString("__x_param_channel");
            }
            str2 = str == null ? "" : str;
        }
        return str2 == null ? "" : str2;
    }

    public String getBundle() {
        Bundle bundle$anniex_release;
        AnnieXLitePageContainer annieXLitePageContainer = this.pageContainer;
        if (annieXLitePageContainer == null) {
            return "";
        }
        String str = null;
        String str2 = (String) new StringParam(annieXLitePageContainer.getAnnieXContext().getSchemaModelUnion().getSchemaData(), "bundle", (String) null).getValue();
        if (str2 == null) {
            LitePageBuilder litePageBuilder = this.builder;
            if (litePageBuilder != null && (bundle$anniex_release = litePageBuilder.getBundle()) != null) {
                str = bundle$anniex_release.getString("__x_param_bundle");
            }
            str2 = str == null ? "" : str;
        }
        return str2 == null ? "" : str2;
    }

    public void close() {
        dismissAllowingStateLoss();
    }
}
