package com.bytedance.android.anniex.lite.container;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.builder.LitePageBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.INavBarHost;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.container.p025ui.AnnieXLitePageStatusAndNavImp;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.utils.AnnieXLiteUtilsKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.schema.AnnieXStatusAndNavModel;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimationParam;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXLitePageContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b0*\u0001\u0012\b\u0000\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0001yB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020*H\u0016J\b\u00102\u001a\u00020*H\u0016J\b\u00103\u001a\u00020*H\u0002J\u0012\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\"\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020*2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0016J\u0012\u0010@\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010A\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010B\u001a\u00020*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010C\u001a\u00020*H\u0016J\b\u0010D\u001a\u00020*H\u0016J\u0012\u0010E\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020*H\u0016J\b\u0010L\u001a\u00020*H\u0016J\u0012\u0010M\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010N\u001a\u00020*H\u0016J\b\u0010O\u001a\u00020*H\u0016J\u001a\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u000106H\u0016J(\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020\u00192\u0006\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u0019H\u0016J\b\u0010W\u001a\u00020*H\u0016J$\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u0002002\u0006\u0010Z\u001a\u0002002\n\b\u0002\u0010[\u001a\u0004\u0018\u000100H\u0002J\u0010\u0010\\\u001a\u00020*2\b\u0010]\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010^\u001a\u00020*2\u0006\u0010_\u001a\u00020\u000fH\u0016J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020\u000fH\u0016J\u0010\u0010b\u001a\u00020*2\u0006\u0010c\u001a\u000200H\u0016J\u0010\u0010d\u001a\u00020*2\u0006\u0010e\u001a\u00020\u0015H\u0016J\u0010\u0010f\u001a\u00020*2\u0006\u0010g\u001a\u00020\u000fH\u0016J\u0010\u0010h\u001a\u00020*2\u0006\u0010i\u001a\u00020\u0019H\u0016J\u0010\u0010j\u001a\u00020*2\u0006\u0010k\u001a\u00020\u000fH\u0016J\u0010\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u000200H\u0016J\u0010\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u000200H\u0016J\u0010\u0010p\u001a\u00020*2\u0006\u0010q\u001a\u000200H\u0016J\u0010\u0010r\u001a\u00020*2\u0006\u0010s\u001a\u000200H\u0016J\u0010\u0010t\u001a\u00020*2\u0006\u0010u\u001a\u00020\u000fH\u0016J\b\u0010v\u001a\u00020*H\u0002J\b\u0010w\u001a\u00020*H\u0016J\b\u0010x\u001a\u00020*H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLitePageContainer;", "Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Lcom/bytedance/android/anniex/base/container/IPopupContainer;", "builder", "Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;)V", "annieXStatusAndNavModel", "Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "getAnnieXStatusAndNavModel", "()Lcom/bytedance/android/anniex/schema/AnnieXStatusAndNavModel;", "annieXStatusAndNavModel$delegate", "Lkotlin/Lazy;", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "isFirstShow", "", "isReleased", "lifeCycleListener", "com/bytedance/android/anniex/lite/container/AnnieXLitePageContainer$lifeCycleListener$1", "Lcom/bytedance/android/anniex/lite/container/AnnieXLitePageContainer$lifeCycleListener$1;", "litePageComponent", "Lcom/bytedance/android/anniex/base/container/IPopupContainer$PopupComponent;", "mDialog", "Landroid/app/Dialog;", "mWebScrollY", "", "mWindow", "Landroid/view/Window;", "pageDelegate", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "pageModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "getPageModel", "()Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "pageModel$delegate", "rootView", "Landroid/view/View;", "statusBarAndNavImp", "Lcom/bytedance/android/anniex/container/ui/AnnieXLitePageStatusAndNavImp;", "swipeRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "addKitView", "", "bindOnBackPressedCallback", "canBackPress", "enterBackground", "enterForeground", "getViewType", "", "hideNavBar", "hidePopupClose", "initPageContext", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", Constants.KEY_DATA, "Landroid/content/Intent;", "onAttach", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateDialog", "onCreateView", "onDestroy", "onDetach", "onDismiss", "dialogInterface", "Landroid/content/DialogInterface;", "onEngineReady", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "onPause", "onResume", "onShow", "onStart", "onStop", "onViewCreated", "view", "onWebScrollChanged", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "release", "reportPullRefreshEvent", StreamTrafficObservable.STREAM_URL, "eventType", "errorMsg", "setDelegate", "delegate", "setEnableToFull", "enableToFull", "setEnableToHalf", "enableToHalf", "setNavBarColor", "navBarColor", "setPopupComponent", "popupComponent", "setPullDownClose", "pullDownClose", "setPullDownHeight", "pullDownHeight", "setShowTopClose", "showTopClose", "setStatusBarColor", "statusBarColor", "setStatusFontMode", "statusFontMode", "setTitle", "title", "setTitleColor", "titleColor", "setUserVisibleHint", "isVisibleToUser", "setWindowAttr", "showNavBar", "showPopupClose", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLitePageContainer extends AnnieXLiteContainer implements IPopupContainer {
    private static final String TAG = "AnnieXLitePageContainer";

    /* renamed from: annieXStatusAndNavModel$delegate, reason: from kotlin metadata */
    private final Lazy annieXStatusAndNavModel;
    private DialogFragment dialogFragment;
    private boolean isFirstShow;
    private volatile boolean isReleased;
    private AnnieXLitePageContainer$lifeCycleListener$1 lifeCycleListener;
    private IPopupContainer.PopupComponent litePageComponent;
    private Dialog mDialog;
    private int mWebScrollY;
    private Window mWindow;
    private IAnnieXLitePageDelegate pageDelegate;

    /* renamed from: pageModel$delegate, reason: from kotlin metadata */
    private final Lazy pageModel;
    private View rootView;
    private AnnieXLitePageStatusAndNavImp statusBarAndNavImp;
    private SmartRefreshLayout swipeRefreshLayout;

    /* compiled from: AnnieXLitePageContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutAnimation.values().length];
            try {
                iArr[OutAnimation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutAnimation.IN_NONE_OUT_AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutAnimation.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OutAnimation.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer, com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return "page";
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void hidePopupClose() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onActivityCreated(Bundle savedInstanceState) {
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

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void onShow(DialogInterface dialogInterface) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onStart() {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setEnableToFull(boolean enableToFull) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setEnableToHalf(boolean enableToHalf) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setPullDownClose(boolean pullDownClose) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setPullDownHeight(int pullDownHeight) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setShowTopClose(boolean showTopClose) {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void showPopupClose() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$lifeCycleListener$1] */
    public AnnieXLitePageContainer(LitePageBuilder litePageBuilder) {
        super(litePageBuilder);
        Intrinsics.checkNotNullParameter(litePageBuilder, "builder");
        this.annieXStatusAndNavModel = LazyKt.lazy(new Function0<AnnieXStatusAndNavModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$annieXStatusAndNavModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnnieXStatusAndNavModel m3350invoke() {
                return (AnnieXStatusAndNavModel) SchemaService.Companion.getInstance().generateSchemaModel(AnnieXLitePageContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), AnnieXStatusAndNavModel.class);
            }
        });
        this.pageModel = LazyKt.lazy(new Function0<BDXPageModel>() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$pageModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BDXPageModel m3351invoke() {
                return SchemaService.Companion.getInstance().generateSchemaModel(AnnieXLitePageContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData(), BDXPageModel.class);
            }
        });
        this.lifeCycleListener = new AbsAnnieXLifecycle() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$lifeCycleListener$1
            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onLoadSuccess(String schema, IContainer container) {
                SmartRefreshLayout smartRefreshLayout;
                SmartRefreshLayout smartRefreshLayout2;
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                super.onLoadSuccess(schema, container);
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXLitePageContainer", "===onLoadSuccess: " + AnnieXLitePageContainer.this.getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
                smartRefreshLayout = AnnieXLitePageContainer.this.swipeRefreshLayout;
                if ((smartRefreshLayout != null ? smartRefreshLayout.getState() : null) == RefreshState.Refreshing) {
                    smartRefreshLayout2 = AnnieXLitePageContainer.this.swipeRefreshLayout;
                    if (smartRefreshLayout2 != null) {
                        smartRefreshLayout2.finishRefresh();
                    }
                    AnnieXLitePageContainer annieXLitePageContainer = AnnieXLitePageContainer.this;
                    AnnieXLitePageContainer.reportPullRefreshEvent$default(annieXLitePageContainer, annieXLitePageContainer.getUrl(), "refresh success", null, 4, null);
                }
            }

            @Override // com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle
            public void onLoadFail(String schema, IContainer container, Throwable throwable) {
                SmartRefreshLayout smartRefreshLayout;
                SmartRefreshLayout smartRefreshLayout2;
                Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
                Intrinsics.checkNotNullParameter(container, "container");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                super.onLoadFail(schema, container, throwable);
                HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXLitePageContainer", "===onLoadFail: " + AnnieXLitePageContainer.this.getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
                smartRefreshLayout = AnnieXLitePageContainer.this.swipeRefreshLayout;
                if ((smartRefreshLayout != null ? smartRefreshLayout.getState() : null) == RefreshState.Refreshing) {
                    smartRefreshLayout2 = AnnieXLitePageContainer.this.swipeRefreshLayout;
                    if (smartRefreshLayout2 != null) {
                        smartRefreshLayout2.finishRefresh();
                    }
                    AnnieXLitePageContainer annieXLitePageContainer = AnnieXLitePageContainer.this;
                    annieXLitePageContainer.reportPullRefreshEvent(annieXLitePageContainer.getUrl(), "refresh failed", throwable.getMessage());
                }
            }
        };
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public Integer getPopupInitHeight() {
        return IPopupContainer.DefaultImpls.getPopupInitHeight(this);
    }

    private final AnnieXStatusAndNavModel getAnnieXStatusAndNavModel() {
        return (AnnieXStatusAndNavModel) this.annieXStatusAndNavModel.getValue();
    }

    private final BDXPageModel getPageModel() {
        return (BDXPageModel) this.pageModel.getValue();
    }

    public final void setDelegate(IAnnieXLitePageDelegate delegate) {
        this.pageDelegate = delegate;
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void onAttach(DialogFragment dialogFragment) {
        Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
        this.dialogFragment = dialogFragment;
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void setPopupComponent(IPopupContainer.PopupComponent popupComponent) {
        Intrinsics.checkNotNullParameter(popupComponent, "popupComponent");
        this.litePageComponent = popupComponent;
        super.setUiComponent(popupComponent);
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void onCreate(Bundle savedInstanceState) {
        OutAnimationParam needOutAnimation;
        OutAnimation outAnimation;
        setContainerVisible(true);
        registerWeakHolder(INavBarHost.class, this);
        getLifecycleDispatcher().addLifecycle(this.lifeCycleListener);
        DialogFragment dialogFragment = null;
        if ((getBuilder() instanceof LitePageBuilder) && ((LitePageBuilder) getBuilder()).getIsFromScan()) {
            DialogFragment dialogFragment2 = this.dialogFragment;
            if (dialogFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
            } else {
                dialogFragment = dialogFragment2;
            }
            dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog_animation_none);
            return;
        }
        BDXPageModel pageModel = getPageModel();
        if (pageModel != null && (needOutAnimation = pageModel.getNeedOutAnimation()) != null && (outAnimation = (OutAnimation) needOutAnimation.getValue()) != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[outAnimation.ordinal()];
            if (i == 1 || i == 2) {
                DialogFragment dialogFragment3 = this.dialogFragment;
                if (dialogFragment3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
                } else {
                    dialogFragment = dialogFragment3;
                }
                dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog_animation_none);
                return;
            }
            if (i == 3) {
                DialogFragment dialogFragment4 = this.dialogFragment;
                if (dialogFragment4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
                } else {
                    dialogFragment = dialogFragment4;
                }
                dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog_animation_bottom);
                return;
            }
            if (i == 4) {
                if (IConditionCallKt.enableFixNeedOutAnimation()) {
                    DialogFragment dialogFragment5 = this.dialogFragment;
                    if (dialogFragment5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
                    } else {
                        dialogFragment = dialogFragment5;
                    }
                    dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog_animation_right_fix);
                    return;
                }
                DialogFragment dialogFragment6 = this.dialogFragment;
                if (dialogFragment6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
                } else {
                    dialogFragment = dialogFragment6;
                }
                dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog_animation_right);
                return;
            }
            DialogFragment dialogFragment7 = this.dialogFragment;
            if (dialogFragment7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
            } else {
                dialogFragment = dialogFragment7;
            }
            dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog);
            return;
        }
        DialogFragment dialogFragment8 = this.dialogFragment;
        if (dialogFragment8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        } else {
            dialogFragment = dialogFragment8;
        }
        dialogFragment.setStyle(1, C0840R.style.annie_x_full_screen_dialog);
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AppCompatDialog(getContext());
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    public void onCreateView(View rootView) {
        this.rootView = rootView;
        DialogFragment dialogFragment = this.dialogFragment;
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = null;
        if (dialogFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
            dialogFragment = null;
        }
        Dialog dialog = dialogFragment.getDialog();
        this.mDialog = dialog;
        this.mWindow = dialog != null ? dialog.getWindow() : null;
        FrameLayout frameLayout = rootView != null ? (FrameLayout) rootView.findViewById(C0840R.id.annie_x_container_view) : null;
        if (frameLayout == null) {
            frameLayout = new FrameLayout(getBuilder().getSystemContext$anniex_release());
        }
        setParentViewGroup(frameLayout);
        Window window = this.mWindow;
        if (window != null) {
            View view = this.rootView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            annieXLitePageStatusAndNavImp = new AnnieXLitePageStatusAndNavImp(window, this, (ViewGroup) view);
        }
        this.statusBarAndNavImp = annieXLitePageStatusAndNavImp;
        initUi();
        AnnieXStatusAndNavModel annieXStatusAndNavModel = getAnnieXStatusAndNavModel();
        if (annieXStatusAndNavModel != null) {
            AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp2 = this.statusBarAndNavImp;
            if (annieXLitePageStatusAndNavImp2 != null) {
                annieXLitePageStatusAndNavImp2.initStatusBarAndSystemNavBar(annieXStatusAndNavModel);
            }
            AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp3 = this.statusBarAndNavImp;
            if (annieXLitePageStatusAndNavImp3 != null) {
                annieXLitePageStatusAndNavImp3.initKeyboard(this.mWindow, annieXStatusAndNavModel);
            }
            if (AnnieXLiteUtilsKt.isInitDefaultTitleBar(this)) {
                AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp4 = this.statusBarAndNavImp;
                if (annieXLitePageStatusAndNavImp4 != null) {
                    annieXLitePageStatusAndNavImp4.initNavBar(annieXStatusAndNavModel);
                }
                AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp5 = this.statusBarAndNavImp;
                if (annieXLitePageStatusAndNavImp5 != null) {
                    annieXLitePageStatusAndNavImp5.initCommonTitleBar(annieXStatusAndNavModel);
                }
            }
        }
        setWindowAttr();
        initPageContext();
        bindOnBackPressedCallback();
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            Intrinsics.checkNotNull(rootView);
            iAnnieXLitePageDelegate.onCreateView(rootView, this, getAnnieXContext());
        }
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===onCreateView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
    }

    private final void bindOnBackPressedCallback() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$bindOnBackPressedCallback$1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    IAnnieXLitePageDelegate iAnnieXLitePageDelegate;
                    Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                    if (i != 4 || keyEvent.getAction() != 1) {
                        return false;
                    }
                    AnnieXBlankDetectorManager.INSTANCE.onPageBlankCheck(AnnieXLitePageContainer.this.getKitView(), AnnieXLitePageContainer.this.getAnnieXContext().getSchemaModelUnion().getSchemaData());
                    AnnieXLitePageContainer annieXLitePageContainer = AnnieXLitePageContainer.this;
                    if (AnnieXLiteUtilsKt.onBackPressed(annieXLitePageContainer, annieXLitePageContainer.getAnnieXContext())) {
                        return true;
                    }
                    if (AnnieXLitePageContainer.this.canBackPress()) {
                        return false;
                    }
                    HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXLitePageContainer", "====intercept backPress=====", (Map) null, (LoggerContext) null, 12, (Object) null);
                    iAnnieXLitePageDelegate = AnnieXLitePageContainer.this.pageDelegate;
                    if (iAnnieXLitePageDelegate != null) {
                        iAnnieXLitePageDelegate.onBackPress(true);
                    }
                    return true;
                }
            });
        }
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public boolean canBackPress() {
        BooleanParam blockBackPress;
        BDXContainerModel containerModel = getContainerModel();
        return !((containerModel == null || (blockBackPress = containerModel.getBlockBackPress()) == null) ? false : Intrinsics.areEqual(blockBackPress.getValue(), true));
    }

    private final void setWindowAttr() {
        Window window = this.mWindow;
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        Window window2 = this.mWindow;
        if (window2 != null) {
            window2.clearFlags(1024);
        }
    }

    private final void initPageContext() {
        DialogFragment dialogFragment = this.dialogFragment;
        if (dialogFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
            dialogFragment = null;
        }
        registerWeakHolder(DialogFragment.class, dialogFragment);
        registerWeakHolder(IContainer.class, this);
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.onInitBizContext(getAnnieXContext().getContextProviderFactory());
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupContainer
    public void onDismiss(DialogInterface dialogInterface) {
        release();
    }

    @Override // com.bytedance.android.anniex.base.container.BaseContainer, com.bytedance.android.anniex.base.container.IContainer
    public void onEngineReady(ContextProviderFactory contextProviderFactory) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        IAnnieXLitePageDelegate iAnnieXLitePageDelegate = this.pageDelegate;
        if (iAnnieXLitePageDelegate != null) {
            iAnnieXLitePageDelegate.registerExtraJSB(contextProviderFactory);
        }
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

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
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

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void hideNavBar() {
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.hideNavBar();
        }
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void showNavBar() {
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.showNavBar();
        }
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setNavBarColor(String navBarColor) {
        Intrinsics.checkNotNullParameter(navBarColor, "navBarColor");
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.setNavBarColor(navBarColor);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.setTitle(title);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.INavBarHost
    public void setTitleColor(String titleColor) {
        Intrinsics.checkNotNullParameter(titleColor, "titleColor");
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.setTitleColor(titleColor);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusBarColor(String statusBarColor) {
        Intrinsics.checkNotNullParameter(statusBarColor, "statusBarColor");
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.setStatusBarColor(statusBarColor);
        }
    }

    @Override // com.bytedance.android.anniex.base.container.IStatusBarHost
    public void setStatusFontMode(String statusFontMode) {
        Intrinsics.checkNotNullParameter(statusFontMode, "statusFontMode");
        AnnieXLitePageStatusAndNavImp annieXLitePageStatusAndNavImp = this.statusBarAndNavImp;
        if (annieXLitePageStatusAndNavImp != null) {
            annieXLitePageStatusAndNavImp.setStatusFontMode(statusFontMode);
        }
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
            AnnieXJSWorkerManager.INSTANCE.postDestroyEvent$anniex_release(getCurrentSchema());
            this.isFirstShow = false;
        }
        this.isReleased = true;
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    public void onWebScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        super.onWebScrollChanged(scrollX, scrollY, oldScrollX, oldScrollY);
        this.mWebScrollY = scrollY;
        SmartRefreshLayout smartRefreshLayout = this.swipeRefreshLayout;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.setEnabled(scrollY == 0);
        }
    }

    @Override // com.bytedance.android.anniex.lite.container.AnnieXLiteContainer
    protected void addKitView() {
        View enginView;
        BooleanParam enablePullToRefresh;
        HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addKitView: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
        IAnnieXEngineProxy engine = getEngine();
        if (engine == null || (enginView = engine.getEnginView()) == null) {
            return;
        }
        BDXPageModel pageModel = getPageModel();
        if (!((pageModel == null || (enablePullToRefresh = pageModel.getEnablePullToRefresh()) == null) ? false : Intrinsics.areEqual(enablePullToRefresh.getValue(), true))) {
            getParentViewGroup().removeAllViews();
            getParentViewGroup().addView(enginView);
        } else {
            HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addLottieSwipeRefreshLayout: " + getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
            if (this.swipeRefreshLayout != null) {
                HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "===addLottieSwipeRefreshLayout: remove old swipeRefreshLayout", (Map) null, (LoggerContext) null, 12, (Object) null);
                getParentViewGroup().removeView((View) this.swipeRefreshLayout);
            }
            SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(getParentViewGroup().getContext());
            smartRefreshLayout.setEnableRefresh(true);
            smartRefreshLayout.addView(enginView, new ViewGroup.LayoutParams(-1, -1));
            smartRefreshLayout.setRefreshHeader(new LottieRefreshHeader(getContext()));
            smartRefreshLayout.setHeaderHeight(50.0f);
            smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer$addKitView$1$1
                public final void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.checkNotNullParameter(refreshLayout, "it");
                    HybridLogger.i$default(HybridLogger.INSTANCE, "AnnieXLitePageContainer", "reload: " + AnnieXLitePageContainer.this.getUrl(), (Map) null, (LoggerContext) null, 12, (Object) null);
                    IContainer.DefaultImpls.reload$default(AnnieXLitePageContainer.this, null, 1, null);
                    AnnieXLitePageContainer annieXLitePageContainer = AnnieXLitePageContainer.this;
                    AnnieXLitePageContainer.reportPullRefreshEvent$default(annieXLitePageContainer, annieXLitePageContainer.getUrl(), "pull_refresh", null, 4, null);
                }
            });
            getParentViewGroup().addView((View) smartRefreshLayout, -1, -1);
            this.swipeRefreshLayout = smartRefreshLayout;
        }
        getLifecycleDispatcher().onAttachView(getUrl(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void reportPullRefreshEvent$default(AnnieXLitePageContainer annieXLitePageContainer, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        annieXLitePageContainer.reportPullRefreshEvent(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportPullRefreshEvent(String url, String eventType, String errorMsg) {
        IMonitorReportService iMonitorReportService = ServiceCenter.Companion.instance().get(IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("anniex_pull_refresh", (String) null, (String) null, (JSONObject) null, (JSONObject) null, (Boolean) null, (JSONObject) null, (JSONObject) null, 254, (DefaultConstructorMarker) null);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(StreamTrafficObservable.STREAM_URL, url);
            jSONObject.put("refresh_state", eventType);
            if (errorMsg != null) {
                jSONObject.put(StrategyConstants.ERROR_MSG, errorMsg);
            }
            reportInfo.setCategory(jSONObject);
            iMonitorReportService.report(reportInfo);
        }
    }
}
