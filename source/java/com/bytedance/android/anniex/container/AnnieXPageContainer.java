package com.bytedance.android.anniex.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.container.p025ui.AnnieXStatusAndNavImp;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.schema.AnnieXStatusAndNavModel;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapterKt;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.SchemaModelTransformer;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXPageContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\b\u00100\u001a\u00020\u0019H\u0016J\b\u00101\u001a\u00020\u0019H\u0016J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\u001a\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020-2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001c\u00106\u001a\u00020\u00192\b\u00105\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u001cH\u0016J(\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000fH\u0016J\b\u0010>\u001a\u00020\u0019H\u0014J\b\u0010?\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u0019H\u0016J\u0010\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010D\u001a\u00020\u0019H\u0002J\u0010\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u001cH\u0016J\u0010\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u001cH\u0016J\u0010\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u001cH\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u001cH\u0016J\u0010\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\rH\u0016J\b\u0010O\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006Q"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXPageContainer;", "Lcom/bytedance/android/anniex/container/AnnieXContainer;", "Lcom/bytedance/android/anniex/base/container/IPageContainer;", "builder", "Lcom/bytedance/android/anniex/base/builder/PageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/PageBuilder;)V", "activity", "Landroid/app/Activity;", "annieXStatusAndNavModel", "Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "clientComponent", "Lcom/bytedance/ies/bullet/base/core/common/Components;", "isFirstShow", "", "mWebScrollY", "", "pageComponent", "Lcom/bytedance/android/anniex/base/container/IPageContainer$PageComponent;", "statusBarAndNavImp", "Lcom/bytedance/android/anniex/container/ui/AnnieXStatusAndNavImp;", "uiModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "getUiModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "enterBackground", "", "enterForeground", "getViewType", "", "hideNavBar", "observerKeyboardStatusChange", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", Constants.KEY_DATA, "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "rootView", "Landroid/view/View;", "onDestroy", "onDetach", "onPause", "onResume", "onStart", "onStop", "onViewCreated", "view", "onWebPageFinish", "Landroid/webkit/WebView;", StreamTrafficObservable.STREAM_URL, "onWebScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "parseSchema", "postFirstVisibleEvent", "release", "setNavBarColor", "navBarColor", "setPageComponent", "setSecureInfo", "setStatusBarColor", "statusBarColor", "setStatusFontMode", "statusFontMode", "setTitle", "title", "setTitleColor", "titleColor", "setUserVisibleHint", "isVisibleToUser", "showNavBar", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXPageContainer extends AnnieXContainer implements IPageContainer {
    private static final String TAG = "AnnieXPageContainer";
    private final Activity activity;
    private AnnieXStatusAndNavModel annieXStatusAndNavModel;
    private Components clientComponent;
    private boolean isFirstShow;
    private int mWebScrollY;
    private IPageContainer.PageComponent pageComponent;
    private AnnieXStatusAndNavImp statusBarAndNavImp;

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return "page";
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onDetach() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPageContainer, com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onPause() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onStart() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXPageContainer(PageBuilder pageBuilder) {
        super(pageBuilder);
        Intrinsics.checkNotNullParameter(pageBuilder, "builder");
        this.activity = pageBuilder.getActivity$anniex_release();
        this.clientComponent = pageBuilder.getClientComponent();
    }

    @Override // com.bytedance.android.anniex.base.container.IPageContainer
    public void setDelegate(IAnnieXLitePageDelegate iAnnieXLitePageDelegate) {
        IPageContainer.DefaultImpls.setDelegate(this, iAnnieXLitePageDelegate);
    }

    private final BDXPageModel getUiModel() {
        BDXPageModel uiModel = getBulletContext().getSchemaModelUnion().getUiModel();
        if (uiModel instanceof BDXPageModel) {
            return uiModel;
        }
        return null;
    }

    @Override // com.bytedance.android.anniex.base.container.IPageContainer
    public void setPageComponent(IPageContainer.PageComponent pageComponent) {
        Intrinsics.checkNotNullParameter(pageComponent, "pageComponent");
        this.pageComponent = pageComponent;
        super.setUiComponent(pageComponent);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onCreate(Bundle savedInstanceState) {
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onCreate: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        setContainerVisible(true);
        registerWeakHolder(INavBarHost.class, this);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onCreateView(View rootView) {
        FrameLayout frameLayout;
        setRootView(rootView);
        AnnieXStatusAndNavImp annieXStatusAndNavImp = null;
        FrameLayout frameLayout2 = rootView != null ? (FrameLayout) rootView.findViewById(C0840R.id.annie_x_container_view) : null;
        if (frameLayout2 != null) {
            frameLayout = frameLayout2;
        } else {
            frameLayout = new FrameLayout(this.activity);
        }
        setParentViewGroup(frameLayout);
        View rootView2 = getRootView();
        Intrinsics.checkNotNull(rootView2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.statusBarAndNavImp = new AnnieXStatusAndNavImp(this.activity, this, (ViewGroup) rootView2);
        initUi();
        AnnieXStatusAndNavModel annieXStatusAndNavModel = this.annieXStatusAndNavModel;
        if (annieXStatusAndNavModel != null) {
            AnnieXStatusAndNavImp annieXStatusAndNavImp2 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                annieXStatusAndNavImp2 = null;
            }
            annieXStatusAndNavImp2.initNavBar(annieXStatusAndNavModel);
            AnnieXStatusAndNavImp annieXStatusAndNavImp3 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                annieXStatusAndNavImp3 = null;
            }
            annieXStatusAndNavImp3.initStatusBarAndSystemNavBar(annieXStatusAndNavModel);
            AnnieXStatusAndNavImp annieXStatusAndNavImp4 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                annieXStatusAndNavImp4 = null;
            }
            annieXStatusAndNavImp4.initKeyboard(this.activity.getWindow(), annieXStatusAndNavModel);
            AnnieXStatusAndNavImp annieXStatusAndNavImp5 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            } else {
                annieXStatusAndNavImp = annieXStatusAndNavImp5;
            }
            annieXStatusAndNavImp.initCommonTitleBar(annieXStatusAndNavModel);
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onCreateView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityCreated(Bundle savedInstanceState) {
        setSecureInfo();
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onResume() {
        IContainer.DefaultImpls.onVisibleChange$default(this, true, null, 2, null);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public void postFirstVisibleEvent() {
        if (this.isFirstShow || getKitView() == null) {
            return;
        }
        this.isFirstShow = true;
        AnnieXJSWorkerManager.INSTANCE.postFirstVisibleEvent$anniex_release(getCurrentSchema(), getCurrentBid(), getKitType());
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    protected void parseSchema() {
        ISchemaData schemaData = getBulletContext().getSchemaData();
        if (schemaData != null) {
            SchemaModelTransformer.INSTANCE.generateUiModel(getBulletContext(), schemaData);
            this.annieXStatusAndNavModel = (AnnieXStatusAndNavModel) SchemaService.Companion.getInstance().generateSchemaModel(schemaData, AnnieXStatusAndNavModel.class);
        }
        getBulletContext().setScene(Scenes.AbsActivity);
        getBulletContext().setClientComponent(this.clientComponent);
        super.parseSchema();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onConfigurationChanged: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onDestroy() {
        AnnieXJSWorkerManager.INSTANCE.postDestroyEvent$anniex_release(getCurrentSchema());
        this.isFirstShow = false;
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void hideNavBar() {
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.hideNavBar();
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void showNavBar() {
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.showNavBar();
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setNavBarColor(String navBarColor) {
        Intrinsics.checkNotNullParameter(navBarColor, "navBarColor");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setNavBarColor(navBarColor);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setTitle(title);
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitleColor(String titleColor) {
        Intrinsics.checkNotNullParameter(titleColor, "titleColor");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setTitleColor(titleColor);
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusBarColor(String statusBarColor) {
        Intrinsics.checkNotNullParameter(statusBarColor, "statusBarColor");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setStatusBarColor(statusBarColor);
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusFontMode(String statusFontMode) {
        Intrinsics.checkNotNullParameter(statusFontMode, "statusFontMode");
        AnnieXStatusAndNavImp annieXStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXStatusAndNavImp == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
            annieXStatusAndNavImp = null;
        }
        annieXStatusAndNavImp.setStatusFontMode(statusFontMode);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onStop() {
        IContainer.DefaultImpls.onVisibleChange$default(this, false, null, 2, null);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && getContainerVisible()) {
            setContainerVisible(false);
        }
        IContainer.DefaultImpls.onVisibleChange$default(this, isVisibleToUser, null, 2, null);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, com.bytedance.android.anniex.base.container.IContainer
    public void enterBackground() {
        super.enterBackground();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, com.bytedance.android.anniex.base.container.IContainer
    public void enterForeground() {
        super.enterForeground();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, com.bytedance.android.anniex.base.container.IContainer
    public void release() {
        super.release();
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public void onWebScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        super.onWebScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
        this.mWebScrollY = scrollY;
    }

    private final void setSecureInfo() {
        getBulletContext().getMonitorCallback().recordSecurityEventTime("on_container_created_start");
        ArgusContainerDelegate argusContainerDelegate = getBulletContext().getArgusContainerDelegate();
        if (argusContainerDelegate != null) {
            argusContainerDelegate.monitorContainerCreated(this.activity, ArgusWebDelegateAdapterKt.initArgusContainerCreatedParams(getBulletContext(), ArgusContainerCreateType.Activity));
        }
        getBulletContext().getMonitorCallback().recordSecurityEventTime("on_container_created_end");
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer
    public void onWebPageFinish(WebView view, String url) {
        super.onWebPageFinish(view, url);
    }

    @Override // com.bytedance.android.anniex.container.AnnieXContainer, com.bytedance.android.anniex.base.container.IContainer
    public void observerKeyboardStatusChange() {
        super.observerKeyboardStatusChange();
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            SoftInputKt.setWindowSoftInput$default(activity, (View) null, (View) null, (View) null, 0, false, getOnSoftInputChangeListener$anniex_release(), 31, (Object) null);
        }
    }
}
