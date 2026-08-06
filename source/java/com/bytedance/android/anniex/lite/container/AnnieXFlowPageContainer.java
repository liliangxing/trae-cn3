package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.container.p025ui.AnnieXStatusAndNavImp;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.schema.AnnieXStatusAndNavModel;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.router.config.StackManager;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimationParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXFlowPageContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\b\u0000\u0018\u0000 h2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001hB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020-H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020(H\u0016J\b\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020#H\u0002J:\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020(2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u000207\u0018\u0001062\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\"\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010H\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010I\u001a\u00020#H\u0016J\b\u0010J\u001a\u00020#H\u0016J\u0010\u0010K\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016J\b\u0010L\u001a\u00020#H\u0016J\b\u0010M\u001a\u00020#H\u0016J\b\u0010N\u001a\u00020#H\u0016J\b\u0010O\u001a\u00020#H\u0016J\u001a\u0010P\u001a\u00020#2\u0006\u0010Q\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J(\u0010R\u001a\u00020#2\u0006\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0013H\u0016J\b\u0010W\u001a\u00020#H\u0016J\u0012\u0010X\u001a\u00020#2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010Y\u001a\u00020#2\u0006\u0010Z\u001a\u00020(H\u0016J\u0010\u0010[\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\\\u001a\u00020#H\u0002J\u0010\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020(H\u0016J\u0010\u0010_\u001a\u00020#2\u0006\u0010`\u001a\u00020(H\u0016J\u0010\u0010a\u001a\u00020#2\u0006\u0010b\u001a\u00020(H\u0016J\u0010\u0010c\u001a\u00020#2\u0006\u0010d\u001a\u00020(H\u0016J\u0010\u0010e\u001a\u00020#2\u0006\u0010f\u001a\u00020\u0010H\u0016J\b\u0010g\u001a\u00020#H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXFlowPageContainer;", "Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Lcom/bytedance/android/anniex/base/container/IPageContainer;", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "builder", "Lcom/bytedance/android/anniex/base/builder/PageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/PageBuilder;)V", "activity", "Landroid/app/Activity;", "annieXStatusAndNavModel", "Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "getAnnieXStatusAndNavModel", "()Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "annieXStatusAndNavModel$delegate", "Lkotlin/Lazy;", "isFirstShow", "", "isReleased", "mWebScrollY", "", "pageComponent", "Lcom/bytedance/android/anniex/base/container/IPageContainer$PageComponent;", "pageDelegate", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "pageModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "getPageModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "pageModel$delegate", "rootView", "Landroid/view/View;", "statusBarAndNavImp", "Lcom/bytedance/android/anniex/container/ui/AnnieXStatusAndNavImp;", "canBackPress", "close", "", "enterBackground", "enterForeground", "finish", "getBulletTag", "", "getBundle", "getChannel", "getContainerId", "getScenes", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getSchema", "Landroid/net/Uri;", "getViewType", "hideNavBar", "initPageContext", "loadSchema", StrategyConstants.SCHEMA, "renderData", "", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "lifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", Constants.KEY_DATA, "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "onDestroy", "onDetach", "onEngineReady", "onPause", "onResume", "onStart", "onStop", "onViewCreated", "view", "onWebScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "release", "setDelegate", "setNavBarColor", "navBarColor", "setPageComponent", "setSecureInfo", "setStatusBarColor", "statusBarColor", "setStatusFontMode", "statusFontMode", "setTitle", "title", "setTitleColor", "titleColor", "setUserVisibleHint", "isVisibleToUser", "showNavBar", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXFlowPageContainer extends AnnieXLiteContainer implements IPageContainer, IRouterAbilityProvider {
    private static final String TAG = "AnnieXFlowPageContainer";
    private final Activity activity;

    /* renamed from: annieXStatusAndNavModel$delegate, reason: from kotlin metadata */
    private final Lazy annieXStatusAndNavModel;
    private boolean isFirstShow;
    private volatile boolean isReleased;
    private int mWebScrollY;
    private IPageContainer.PageComponent pageComponent;
    private IAnnieXLitePageDelegate pageDelegate;

    /* renamed from: pageModel$delegate, reason: from kotlin metadata */
    private final Lazy pageModel;
    private View rootView;
    private AnnieXStatusAndNavImp statusBarAndNavImp;

    /* compiled from: AnnieXFlowPageContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutAnimation.values().length];
            try {
                iArr[OutAnimation.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutAnimation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutAnimation.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OutAnimation.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OutAnimation.IN_NONE_OUT_AUTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void setSecureInfo() {
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return "page";
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onDestroy() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onDetach() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onStart() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXFlowPageContainer(PageBuilder pageBuilder) {
        super(pageBuilder);
        Intrinsics.checkNotNullParameter(pageBuilder, "builder");
        this.activity = pageBuilder.getActivity$anniex_release();
        this.annieXStatusAndNavModel = LazyKt.lazy(new Function0<AnnieXStatusAndNavModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer$annieXStatusAndNavModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnnieXStatusAndNavModel m3341invoke() {
                return (AnnieXStatusAndNavModel) SchemaService.Companion.getInstance().generateSchemaModel(AnnieXFlowPageContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), AnnieXStatusAndNavModel.class);
            }
        });
        this.pageModel = LazyKt.lazy(new Function0<BDXPageModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer$pageModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BDXPageModel m3342invoke() {
                return SchemaService.Companion.getInstance().generateSchemaModel(AnnieXFlowPageContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), BDXPageModel.class);
            }
        });
    }

    private final AnnieXStatusAndNavModel getAnnieXStatusAndNavModel() {
        return (AnnieXStatusAndNavModel) this.annieXStatusAndNavModel.getValue();
    }

    private final BDXPageModel getPageModel() {
        return (BDXPageModel) this.pageModel.getValue();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public Scenes getScenes() {
        return Scenes.AnnieXPage;
    }

    @Override // com.bytedance.android.anniex.base.container.IPageContainer
    public void setPageComponent(IPageContainer.PageComponent pageComponent) {
        Intrinsics.checkNotNullParameter(pageComponent, "pageComponent");
        this.pageComponent = pageComponent;
        super.setUiComponent(pageComponent);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void onCreate(Bundle savedInstanceState) {
        OutAnimationParam needOutAnimation;
        OutAnimation outAnimation;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onCreate: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        setContainerVisible(true);
        StackManager.Companion.getInstance().add(this, getAnnieXContext().getSessionId());
        BDXPageModel pageModel = getPageModel();
        if (pageModel == null || (needOutAnimation = pageModel.getNeedOutAnimation()) == null || (outAnimation = (OutAnimation) needOutAnimation.getValue()) == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[outAnimation.ordinal()];
        if (i == 1) {
            this.activity.overridePendingTransition(C0840R.anim.splash_slide_in_bottom, C0840R.anim.bullet_keep_same);
            return;
        }
        if (i == 2) {
            this.activity.overridePendingTransition(C0840R.anim.anniex_flow_slide_in_right, C0840R.anim.bullet_keep_same);
            return;
        }
        if (i == 3) {
            this.activity.overridePendingTransition(C0840R.anim.anniex_flow_slide_in_left, C0840R.anim.bullet_keep_same);
        } else if (i == 4 || i == 5) {
            this.activity.overridePendingTransition(0, 0);
        } else {
            this.activity.overridePendingTransition(C0840R.anim.anniex_flow_slide_in_right, C0840R.anim.anniex_flow_slide_out_left);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onCreateView(View rootView) {
        FrameLayout frameLayout;
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate;
        this.rootView = rootView;
        AnnieXStatusAndNavImp annieXStatusAndNavImp = null;
        FrameLayout frameLayout2 = rootView != null ? (FrameLayout) rootView.findViewById(C0840R.id.annie_x_container_view) : null;
        if (frameLayout2 != null) {
            frameLayout = frameLayout2;
        } else {
            frameLayout = new FrameLayout(this.activity);
        }
        setParentViewGroup(frameLayout);
        Activity activity = this.activity;
        AnnieXFlowPageContainer annieXFlowPageContainer = this;
        View view = this.rootView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this.statusBarAndNavImp = new AnnieXStatusAndNavImp(activity, annieXFlowPageContainer, (ViewGroup) view);
        initUi();
        AnnieXStatusAndNavModel annieXStatusAndNavModel = getAnnieXStatusAndNavModel();
        if (annieXStatusAndNavModel != null) {
            AnnieXStatusAndNavImp annieXStatusAndNavImp2 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                annieXStatusAndNavImp2 = null;
            }
            annieXStatusAndNavImp2.initStatusBarAndSystemNavBar(annieXStatusAndNavModel);
            AnnieXStatusAndNavImp annieXStatusAndNavImp3 = this.statusBarAndNavImp;
            if (annieXStatusAndNavImp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                annieXStatusAndNavImp3 = null;
            }
            annieXStatusAndNavImp3.initKeyboard(this.activity.getWindow(), annieXStatusAndNavModel);
            if (AnnieXLiteUtilsKt.isInitDefaultTitleBar(annieXFlowPageContainer)) {
                AnnieXStatusAndNavImp annieXStatusAndNavImp4 = this.statusBarAndNavImp;
                if (annieXStatusAndNavImp4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                    annieXStatusAndNavImp4 = null;
                }
                annieXStatusAndNavImp4.initNavBar(annieXStatusAndNavModel);
                AnnieXStatusAndNavImp annieXStatusAndNavImp5 = this.statusBarAndNavImp;
                if (annieXStatusAndNavImp5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusBarAndNavImp");
                } else {
                    annieXStatusAndNavImp = annieXStatusAndNavImp5;
                }
                annieXStatusAndNavImp.initCommonTitleBar(annieXStatusAndNavModel);
            }
        }
        View view2 = this.rootView;
        if (view2 != null && (iAnnieXLitePageDelegate = this.pageDelegate) != null) {
            iAnnieXLitePageDelegate.onCreateView(view2, annieXFlowPageContainer, getAnnieXContext());
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onCreateView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String schema, Map<String, ? extends Object> renderData, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        initPageContext();
        super.loadSchema(schema, renderData, contextProviderFactory, lifecycle);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public boolean canBackPress() {
        BooleanParam blockBackPress;
        AnnieXBlankDetectorManager.INSTANCE.onPageBlankCheck(getKitView(), getAnnieXContext().getSchemaModelUnion().getSchemaData());
        if (AnnieXLiteUtilsKt.onBackPressed(this, getAnnieXContext())) {
            return false;
        }
        BDXContainerModel containerModel = getContainerModel();
        if (!((containerModel == null || (blockBackPress = containerModel.getBlockBackPress()) == null) ? false : Intrinsics.areEqual(blockBackPress.getValue(), true))) {
            return true;
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "====intercept backPress=====", (Map) null, (LoggerContext) null, 12, (Object) null);
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.onBackPress(true);
        }
        return false;
    }

    private final void initPageContext() {
        getAnnieXContext().getContextProviderFactory().registerHolder(IContainer.class, this);
        registerWeakHolder(INavBarHost.class, this);
        if (IConditionCallKt.enableFlowPageCloseFix()) {
            registerWeakHolder(Activity.class, this.activity);
        }
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.onInitBizContext(getAnnieXContext().getContextProviderFactory());
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityCreated(Bundle savedInstanceState) {
        setSecureInfo();
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onResume() {
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.onPageVisibleChange(true);
        }
        IContainer.DefaultImpls.onVisibleChange$default(this, true, null, 2, null);
        if (this.isFirstShow) {
            return;
        }
        this.isFirstShow = true;
        AnnieXJSWorkerManager.INSTANCE.postFirstVisibleEvent$anniex_release(getCurrentSchema(), getCurrentBid(), getKitType());
    }

    @Override // com.bytedance.android.anniex.base.container.IPageContainer, com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onPause() {
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.onPageVisibleChange(false);
        }
        IContainer.DefaultImpls.onVisibleChange$default(this, false, null, 2, null);
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onConfigurationChanged: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    public String getChannel() {
        String str = (String) new StringParam(getAnnieXContext().getSchemaModelUnion().getSchemaData(), "channel", (String) null).getValue();
        if (str != null) {
            return str;
        }
        String string = getBuilder().getBundle().getString("__x_param_channel");
        return string == null ? "" : string;
    }

    public String getBundle() {
        String str = (String) new StringParam(getAnnieXContext().getSchemaModelUnion().getSchemaData(), "bundle", (String) null).getValue();
        if (str != null) {
            return str;
        }
        String string = getBuilder().getBundle().getString("__x_param_bundle");
        return string == null ? "" : string;
    }

    @Override // com.bytedance.android.anniex.base.container.IPageContainer
    public void setDelegate(IAnnieXLitePageDelegate pageDelegate) {
        this.pageDelegate = pageDelegate;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getContainerId() {
        return getAnnieXContext().getSessionId();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void close() {
        super.close();
        this.activity.finish();
    }

    public String getBulletTag() {
        return (String) new StringParam(getAnnieXContext().getSchemaModelUnion().getSchemaData(), "bdx_tag", (String) null).getValue();
    }

    public Uri getSchema() {
        return Uri.parse(getCurrentSchema());
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void onEngineReady(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.registerExtraJSB(contextProviderFactory);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void finish() {
        OutAnimationParam needOutAnimation;
        OutAnimation outAnimation;
        BDXPageModel pageModel = getPageModel();
        if (pageModel == null || (needOutAnimation = pageModel.getNeedOutAnimation()) == null || (outAnimation = (OutAnimation) needOutAnimation.getValue()) == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[outAnimation.ordinal()];
        if (i == 1) {
            this.activity.overridePendingTransition(0, C0840R.anim.bullet_bottom_out);
            return;
        }
        if (i == 2) {
            this.activity.overridePendingTransition(0, C0840R.anim.bullet_right_out);
        } else if (i == 4 || i == 5) {
            this.activity.overridePendingTransition(0, 0);
        } else {
            this.activity.overridePendingTransition(C0840R.anim.anniex_flow_slide_in_left, C0840R.anim.anniex_flow_slide_out_right);
        }
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

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void enterBackground() {
        super.enterBackground();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void enterForeground() {
        super.enterForeground();
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void release() {
        super.release();
        if (!this.isReleased) {
            StackManager.Companion.getInstance().remove(this, getAnnieXContext().getSessionId());
            AnnieXJSWorkerManager.INSTANCE.postDestroyEvent$anniex_release(getCurrentSchema());
            IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
            if (iAnnieXLitePageDelegate != null) {
                iAnnieXLitePageDelegate.onRelease();
            }
            this.isFirstShow = false;
        }
        this.isReleased = true;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public void onWebScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        super.onWebScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
        this.mWebScrollY = scrollY;
    }
}
