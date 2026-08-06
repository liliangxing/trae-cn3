package com.bytedance.android.anniex.container.p025ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.container.AnnieXPageContainer;
import com.bytedance.android.anniex.container.util.CustomViewUtil;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0015\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\"\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00101\u001a\u00020 H\u0016J\b\u00102\u001a\u00020 H\u0016J\b\u00103\u001a\u00020 H\u0016J\b\u00104\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020+H\u0016J\b\u00107\u001a\u00020 H\u0016J\b\u00108\u001a\u00020 H\u0016J\u001a\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010;\u001a\u00020 2\b\u0010<\u001a\u0004\u0018\u00010+H\u0016J\u0015\u0010=\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0018H\u0000¢\u0006\u0002\b@J\u0010\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0011H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXFragment;", "Landroidx/fragment/app/Fragment;", "builder", "Lcom/bytedance/android/anniex/base/builder/PageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/PageBuilder;)V", "()V", "currentBid", "", "currentSchema", "defaultTitleBar", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getDefaultTitleBar", "()Landroid/view/View;", "defaultTitleBar$delegate", "Lkotlin/Lazy;", "isFlow", "", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "pageComponent", "com/bytedance/android/anniex/container/ui/AnnieXFragment$pageComponent$1", "Lcom/bytedance/android/anniex/container/ui/AnnieXFragment$pageComponent$1;", "pageContainer", "Lcom/bytedance/android/anniex/base/container/IPageContainer;", "pageDelegate", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "getPageDelegate", "()Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "pageDelegate$delegate", "rootView", "onActivityResult", "", "requestCode", "", "resultCode", Constants.KEY_DATA, "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onViewCreated", "view", "setArguments", "args", "setListener", "setListener$anniex_release", "setPageContainer", "setPageContainer$anniex_release", "setUserVisibleHint", "isVisibleToUser", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXFragment extends Fragment {
    private static final String BUNDLE_ON_RELOAD = "bundle_on_reload";
    private PageBuilder builder;
    private String currentBid;
    private String currentSchema;

    /* renamed from: defaultTitleBar$delegate, reason: from kotlin metadata */
    private final Lazy defaultTitleBar;
    private boolean isFlow;
    private AnnieXFragmentListener listener;
    private final AnnieXFragment$pageComponent$1 pageComponent;
    private IPageContainer pageContainer;

    /* renamed from: pageDelegate$delegate, reason: from kotlin metadata */
    private final Lazy pageDelegate;
    private View rootView;

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle args) {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.android.anniex.container.ui.AnnieXFragment$pageComponent$1] */
    public AnnieXFragment() {
        this.currentBid = "default_bid";
        this.defaultTitleBar = LazyKt.lazy(new Function0<View>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXFragment$defaultTitleBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m3303invoke() {
                return AnnieXFragment.this.getLayoutInflater().inflate(C0840R.layout.annie_x_title_bar, (ViewGroup) null, false);
            }
        });
        this.pageDelegate = LazyKt.lazy(new Function0<IAnnieXLitePageDelegate>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXFragment$pageDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IAnnieXLitePageDelegate m3304invoke() {
                PageBuilder pageBuilder;
                String str;
                AnnieXServiceCenter annieXServiceCenter = AnnieXServiceCenter.INSTANCE;
                pageBuilder = AnnieXFragment.this.builder;
                if (pageBuilder == null || (str = pageBuilder.getBid()) == null) {
                    str = AnnieXFragment.this.currentBid;
                }
                IAnnieXLitePageDelegateProvider iAnnieXLitePageDelegateProvider = (IAnnieXLitePageDelegateProvider) annieXServiceCenter.getService(str, IAnnieXLitePageDelegateProvider.class);
                if (iAnnieXLitePageDelegateProvider != null) {
                    return iAnnieXLitePageDelegateProvider.provideDelegate();
                }
                return null;
            }
        });
        this.pageComponent = new IPageContainer.PageComponent() { // from class: com.bytedance.android.anniex.container.ui.AnnieXFragment$pageComponent$1
            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createLoadingView() {
                IPageContainer iPageContainer;
                iPageContainer = AnnieXFragment.this.pageContainer;
                if (iPageContainer != null) {
                    return CustomViewUtil.INSTANCE.createLoadingView(iPageContainer);
                }
                return null;
            }

            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createErrorView() {
                IPageContainer iPageContainer;
                iPageContainer = AnnieXFragment.this.pageContainer;
                if (iPageContainer != null) {
                    return CustomViewUtil.INSTANCE.createErrorView(iPageContainer);
                }
                return null;
            }

            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public void close() {
                AnnieXFragment.this.requireActivity().finish();
            }
        };
    }

    private final View getDefaultTitleBar() {
        return (View) this.defaultTitleBar.getValue();
    }

    private final IAnnieXLitePageDelegate getPageDelegate() {
        return (IAnnieXLitePageDelegate) this.pageDelegate.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnieXFragment(PageBuilder pageBuilder) {
        this();
        Intrinsics.checkNotNullParameter(pageBuilder, "builder");
        this.builder = pageBuilder;
        this.currentBid = pageBuilder.getBid();
        this.currentSchema = pageBuilder.getBundle().getString("__x_inner_schema");
        this.isFlow = pageBuilder.getBundle().getBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW);
        IAnnieXLitePageDelegate pageDelegate = getPageDelegate();
        if (pageDelegate != null) {
            pageDelegate.onCreate(this, pageBuilder.getBundle());
        }
    }

    public final void setPageContainer$anniex_release(IPageContainer container) {
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

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("bid", this.currentBid);
        outState.putString("__x_inner_schema", this.currentSchema);
        outState.putBoolean(BUNDLE_ON_RELOAD, true);
        outState.putBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW, this.isFlow);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            String string = savedInstanceState.getString("bid");
            if (string == null) {
                string = "default_bid";
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "savedInstanceState.getSt…D)?: BidConstants.DEFAULT");
            }
            this.currentBid = string;
            this.currentSchema = savedInstanceState.getString("__x_inner_schema");
            this.isFlow = savedInstanceState.getBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW);
            PageBuilder pageBuilder = new PageBuilder();
            pageBuilder.setBid$anniex_release(this.currentBid);
            ComponentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            pageBuilder.activity((Activity) requireActivity);
            pageBuilder.bundle(savedInstanceState);
            if (this.pageContainer == null) {
                if (this.isFlow) {
                    this.pageContainer = new AnnieXFlowPageContainer(pageBuilder);
                } else {
                    this.pageContainer = new AnnieXPageContainer(pageBuilder);
                }
            }
            this.builder = pageBuilder;
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onCreate(savedInstanceState);
        }
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.onCreate(savedInstanceState);
        }
        IPageContainer iPageContainer2 = this.pageContainer;
        if (iPageContainer2 != null) {
            iPageContainer2.setPageComponent(this.pageComponent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onCreateView(inflater, container, savedInstanceState);
        }
        View inflate = inflater.inflate(C0840R.layout.annie_x_fragment, container, false);
        this.rootView = inflate;
        FrameLayout frameLayout = inflate != null ? (FrameLayout) inflate.findViewById(C0840R.id.anniex_title_bar_container) : null;
        IPageContainer iPageContainer = this.pageContainer;
        String str = this.currentBid;
        View defaultTitleBar = getDefaultTitleBar();
        Intrinsics.checkNotNullExpressionValue(defaultTitleBar, "defaultTitleBar");
        AnnieXLiteUtilsKt.setTitleBarView(frameLayout, iPageContainer, str, defaultTitleBar, getContext());
        IPageContainer iPageContainer2 = this.pageContainer;
        if (iPageContainer2 != null) {
            iPageContainer2.onCreateView(this.rootView);
        }
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        IPageContainer iPageContainer;
        IPageContainer iPageContainer2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view2 = this.rootView;
        if (view2 != null && (iPageContainer2 = this.pageContainer) != null) {
            iPageContainer2.onViewCreated(view2, savedInstanceState);
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onViewCreated(view, savedInstanceState);
        }
        boolean z = false;
        if (savedInstanceState != null && savedInstanceState.getBoolean(BUNDLE_ON_RELOAD)) {
            z = true;
        }
        if (!z || (str = this.currentSchema) == null || (iPageContainer = this.pageContainer) == null) {
            return;
        }
        iPageContainer.loadSchema(str, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.enterForeground();
        }
        IPageContainer iPageContainer2 = this.pageContainer;
        if (iPageContainer2 != null) {
            iPageContainer2.onResume();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.enterBackground();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.onStart();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onStart(this.pageContainer);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.onStop();
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IAnnieXLitePageDelegate pageDelegate = getPageDelegate();
        if (pageDelegate != null) {
            pageDelegate.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.setUserVisibleHint(isVisibleToUser);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onDestroy(this.pageContainer);
        }
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onDetach();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        IPageContainer iPageContainer = this.pageContainer;
        if (iPageContainer != null) {
            iPageContainer.onConfigurationChanged(newConfig);
        }
        AnnieXFragmentListener annieXFragmentListener = this.listener;
        if (annieXFragmentListener != null) {
            annieXFragmentListener.onConfigurationChanged(newConfig);
        }
    }
}
