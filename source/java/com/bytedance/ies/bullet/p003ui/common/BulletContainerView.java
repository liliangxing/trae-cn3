package com.bytedance.ies.bullet.p003ui.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextKt;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.secure.HybridSecureConfig;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IErrorView;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ILoadingView;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.LongParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContainerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\rH\u0016J\u001a\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020#2\b\b\u0002\u0010)\u001a\u00020\u0016H\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010+\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\u0012\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020\rH\u0002J8\u00103\u001a\u00020\r2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020\rH\u0016J\u001a\u0010?\u001a\u00020\r2\u0006\u00104\u001a\u0002052\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0018\u0010B\u001a\u00020\r2\u0006\u00104\u001a\u0002052\u0006\u0010C\u001a\u00020DH\u0016J\"\u0010E\u001a\u00020\r2\u0006\u00104\u001a\u0002052\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010F\u001a\u00020GH\u0016J\u001a\u0010H\u001a\u00020\r2\u0006\u00104\u001a\u0002052\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010K\u001a\u00020\r2\u0006\u00104\u001a\u0002052\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010L\u001a\u00020\rH\u0002J\b\u0010M\u001a\u00020\rH\u0002J\u001a\u0010N\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010O\u001a\u0004\u0018\u00010PJ>\u0010N\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00142\u0016\b\u0002\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000e2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u0010J\u000e\u0010S\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010T\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010O\u001a\u00020PJ8\u0010T\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007H\u0016J\u000e\u0010T\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0014J\u0015\u0010Z\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0000¢\u0006\u0002\b[J\u001a\u0010\\\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00122\n\b\u0002\u0010O\u001a\u0004\u0018\u00010PJ\u0014\u0010]\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0002J\b\u0010^\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0002J\b\u0010_\u001a\u00020\rH\u0002J\b\u0010`\u001a\u00020\rH\u0002J\b\u0010a\u001a\u00020\rH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "Lcom/bytedance/ies/bullet/ui/common/BulletCardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "errorCloseMethod", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/CloseMethod;", "errorReloadMethod", "Lcom/bytedance/ies/bullet/service/base/ReloadMethod;", "errorView", "Landroid/view/View;", "errorViewService", "Lcom/bytedance/ies/bullet/service/base/IViewService;", "loadingDelayInMilliSeconds", "", "loadingTimer", "Ljava/util/Timer;", "loadingTimerTask", "Ljava/util/TimerTask;", "loadingView", "loadingViewService", "originBackground", "Landroid/graphics/drawable/Drawable;", "placeholderView", "secureDenyView", "secureNoticeView", "shouldInterceptShowLoading", "", "useCustomBackground", "dispatchHideLoading", "dispatchShowLoading", "dispatchShowLoadingAfterDelay", "showLoading", "loadingDuration", "getLoadingView", "hasErrorView", "hideErrorView", "hideLoadingView", "hideSecureView", "secureView", "initContainerBgColor", "initErrorViewByService", "initLoadingViewByService", "loadUri", "uri", "Landroid/net/Uri;", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "onBulletViewRelease", "onKitViewCreate", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onLoadFail", "e", "", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onLoadUriSuccess", "setBackgroundColor", "setContainerBgColor", "setErrorView", "params", "Landroid/widget/FrameLayout$LayoutParams;", "closeMethod", "reloadMethod", "setLoadingDelay", "setLoadingView", SchemaConstants.QUERY_KEY_GRAVITY, "marginLeft", "marginTop", "marginRight", "marginBottom", "setLoadingViewInternal", "setLoadingViewInternal$anniex_release", "setPlaceholderView", "setStatusView", "showErrorView", "showLoadingView", "showSecureDenyView", "showSecureNoticeView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletContainerView extends BulletCardView {
    private BDXContainerModel containerModel;
    private Function0<Unit> errorCloseMethod;
    private Function0<Unit> errorReloadMethod;
    private View errorView;
    private IViewService errorViewService;
    private long loadingDelayInMilliSeconds;
    private Timer loadingTimer;
    private TimerTask loadingTimerTask;
    private View loadingView;
    private IViewService loadingViewService;
    private Drawable originBackground;
    private View placeholderView;
    private View secureDenyView;
    private View secureNoticeView;
    private boolean shouldInterceptShowLoading;
    private boolean useCustomBackground;

    /* compiled from: BulletContainerView.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SccConfig.SccLevel.values().length];
            try {
                iArr[SccConfig.SccLevel.NOTICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SccConfig.SccLevel.DENY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BulletContainerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BulletContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BulletContainerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.loadingDelayInMilliSeconds = 500L;
        this.errorReloadMethod = new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$errorReloadMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m598invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m598invoke() {
                AbsBulletMonitorCallback monitorCallback;
                BulletContext bulletContext = BulletContainerView.this.getBulletContext();
                if (bulletContext != null && (monitorCallback = bulletContext.getMonitorCallback()) != null) {
                    monitorCallback.reportErrorViewClick();
                }
                BulletContainerView.this.reLoadUri();
            }
        };
        setMCurrentScene(Scenes.Container);
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView
    public void loadUri(Uri uri, Bundle r8, BulletContext bulletContext, ContextProviderFactory contextProviderFactory, IBulletLifeCycle lifeCycle) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (contextProviderFactory == null) {
            contextProviderFactory = new ContextProviderFactory();
        }
        ContextProviderFactory contextProviderFactory2 = contextProviderFactory;
        contextProviderFactory2.registerWeakHolder(BulletContainerView.class, this);
        super.loadUri(uri, r8, bulletContext, contextProviderFactory2, lifeCycle);
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadStart(Uri uri, IBulletContainer container) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        super.onLoadStart(uri, container);
        if (getMCurrentScene() == Scenes.Container) {
            setStatusView(uri);
        }
        hideErrorView();
        showLoading(uri);
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        super.onLoadModelSuccess(uri, kitView, schemaModelUnion);
        ISchemaModel containerModel = schemaModelUnion.getContainerModel();
        BDXContainerModel bDXContainerModel = containerModel instanceof BDXContainerModel ? (BDXContainerModel) containerModel : null;
        if (bDXContainerModel != null) {
            this.containerModel = bDXContainerModel;
            if (bDXContainerModel.getShowLoading().get_isSet()) {
                if (Intrinsics.areEqual(bDXContainerModel.getShowLoading().getValue(), true)) {
                    this.shouldInterceptShowLoading = false;
                    dispatchShowLoadingAfterDelay$default(this, true, 0L, 2, null);
                } else {
                    hideLoadingView();
                }
            } else if (getMCurrentScene() == Scenes.Container || getMCurrentScene() == Scenes.Card) {
                hideLoadingView();
            } else {
                this.shouldInterceptShowLoading = false;
                dispatchShowLoadingAfterDelay$default(this, true, 0L, 2, null);
            }
            initContainerBgColor();
        }
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewCreate(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        super.onKitViewCreate(uri, kitView);
        View view = this.placeholderView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        super.onLoadUriSuccess(uri, kitView);
        setContainerBgColor();
        this.shouldInterceptShowLoading = true;
        TimerTask timerTask = this.loadingTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.loadingTimerTask = null;
        }
        Timer timer = this.loadingTimer;
        if (timer != null) {
            timer.cancel();
            this.loadingTimer = null;
        }
        hideLoadingView();
        hideErrorView();
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        SccConfig.SccLevel sccLevel;
        SchemaModelUnion schemaModelUnion;
        ISchemaData schemaData;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        super.onLoadFail(uri, e);
        setContainerBgColor();
        this.shouldInterceptShowLoading = true;
        TimerTask timerTask = this.loadingTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.loadingTimerTask = null;
        }
        Timer timer = this.loadingTimer;
        if (timer != null) {
            timer.cancel();
            this.loadingTimer = null;
        }
        hideLoadingView();
        IKitViewService kitView = getCurrentKitView();
        if (kitView == null || (sccLevel = kitView.getSccLevel()) == null) {
            sccLevel = SccConfig.SccLevel.SAFE;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[sccLevel.ordinal()];
        if (i == 1) {
            showSecureNoticeView();
            return;
        }
        if (i == 2) {
            showSecureDenyView();
            return;
        }
        BulletContext bulletContext = getBulletContext();
        if (bulletContext == null || (schemaModelUnion = bulletContext.getSchemaModelUnion()) == null || (schemaData = schemaModelUnion.getSchemaData()) == null) {
            return;
        }
        if (Intrinsics.areEqual(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_SHOW_ERROR, Boolean.valueOf((getMCurrentScene() == Scenes.Container || getMCurrentScene() == Scenes.Card) ? false : true)).getValue(), true)) {
            showErrorView();
        }
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewRelease() {
        super.onBulletViewRelease();
        KeyEvent.Callback callback = this.loadingView;
        if (callback instanceof IReleasable) {
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.IReleasable");
            ((IReleasable) callback).release();
        }
        KeyEvent.Callback callback2 = this.errorView;
        if (callback2 instanceof IReleasable) {
            Intrinsics.checkNotNull(callback2, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.IReleasable");
            ((IReleasable) callback2).release();
        }
    }

    public void dispatchShowLoading() {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "message:BulletContainerView dispatchShowLoading", null, null, 6, null);
        showLoadingView();
    }

    public void dispatchHideLoading() {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "message:BulletContainerView dispatchHideLoading", null, null, 6, null);
        hideLoadingView();
    }

    static /* synthetic */ void setStatusView$default(BulletContainerView bulletContainerView, Uri uri, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusView");
        }
        if ((i & 1) != 0) {
            uri = null;
        }
        bulletContainerView.setStatusView(uri);
    }

    private final void setStatusView(Uri uri) {
        Object obj;
        BulletContext bulletContext = getBulletContext();
        if (bulletContext != null && bulletContext.getContainerContext().getViewService() != null) {
            BulletLogger.printLog$default(BulletLogger.INSTANCE, "BulletContainerView.setStatusView: getViewService from bullet Context", null, "XView", 2, null);
            this.loadingViewService = bulletContext.getContainerContext().getViewService();
            this.errorViewService = bulletContext.getContainerContext().getViewService();
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            String safeGetQueryParameter = uri != null ? ExtKt.safeGetQueryParameter(uri, "url") : null;
            if (safeGetQueryParameter == null) {
                safeGetQueryParameter = "";
            }
            obj = Result.constructor-impl(Uri.parse(safeGetQueryParameter));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Uri uri2 = (Uri) obj;
        boolean areEqual = Intrinsics.areEqual(uri2 != null ? ExtKt.safeGetQueryParameter(uri2, SchemaConstants.QUERY_KEY_LOADING_STYLE) : null, "host");
        boolean areEqual2 = Intrinsics.areEqual(uri2 != null ? ExtKt.safeGetQueryParameter(uri2, SchemaConstants.QUERY_KEY_ERROR_PAGE_STYLE) : null, "host");
        String bid = areEqual ? "default_bid" : getMBid();
        String bid2 = areEqual2 ? "default_bid" : getMBid();
        this.loadingViewService = (IViewService) ServiceCenter.INSTANCE.instance().get(bid, IViewService.class);
        this.errorViewService = (IViewService) ServiceCenter.INSTANCE.instance().get(bid2, IViewService.class);
    }

    public final void setLoadingDelay(long loadingDelayInMilliSeconds) {
        if (loadingDelayInMilliSeconds >= 0) {
            this.loadingDelayInMilliSeconds = loadingDelayInMilliSeconds;
        }
    }

    public final void setLoadingView(IViewService loadingView) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        this.loadingViewService = loadingView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setErrorView$default(BulletContainerView bulletContainerView, IViewService iViewService, Function0 function0, Function0 function02, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setErrorView");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        bulletContainerView.setErrorView(iViewService, function0, function02);
    }

    public final void setErrorView(IViewService errorView, Function0<Unit> closeMethod, final Function0<Unit> reloadMethod) {
        Intrinsics.checkNotNullParameter(errorView, "errorView");
        this.errorViewService = errorView;
        this.errorCloseMethod = closeMethod;
        this.errorReloadMethod = new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$setErrorView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m599invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m599invoke() {
                AbsBulletMonitorCallback monitorCallback;
                BulletContext bulletContext = BulletContainerView.this.getBulletContext();
                if (bulletContext != null && (monitorCallback = bulletContext.getMonitorCallback()) != null) {
                    monitorCallback.reportErrorViewClick();
                }
                Function0<Unit> function0 = reloadMethod;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        };
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView
    public boolean hasErrorView() {
        boolean z = this.errorView != null;
        BulletContext bulletContext = getBulletContext();
        BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
        if (containerContext != null) {
            containerContext.setHasErrorView(z);
        }
        return z;
    }

    private final void initLoadingViewByService() {
        Unit unit;
        String str = getMCurrentScene() == Scenes.PopupFragment ? "popup" : "page";
        IViewService iViewService = this.loadingViewService;
        if (iViewService != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ILoadingView createLoadingView = iViewService.createLoadingView(context, str);
            if (createLoadingView != null) {
                View view = createLoadingView.getView();
                FrameLayout.LayoutParams loadingViewLayoutParams = iViewService.getLoadingViewLayoutParams(str);
                if (loadingViewLayoutParams != null) {
                    setLoadingView(view, loadingViewLayoutParams);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    IBulletContainer.DefaultImpls.setLoadingView$default(this, view, 0, 0, 0, 0, 0, 62, null);
                }
            }
        }
        this.loadingViewService = null;
    }

    private final void initErrorViewByService() {
        Unit unit;
        String str = getMCurrentScene() == Scenes.PopupFragment ? "popup" : "page";
        IViewService iViewService = this.errorViewService;
        if (iViewService != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            IErrorView createErrorView = iViewService.createErrorView(context, str);
            if (createErrorView != null) {
                View view = createErrorView.getView(this.errorCloseMethod, this.errorReloadMethod);
                FrameLayout.LayoutParams errorViewLayoutParams = iViewService.getErrorViewLayoutParams(str);
                if (errorViewLayoutParams != null) {
                    setErrorView(view, errorViewLayoutParams);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    setErrorView$default(this, view, null, 2, null);
                }
            }
        }
        this.errorViewService = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View getLoadingView() {
        initLoadingViewByService();
        View view = this.loadingView;
        if (!(view instanceof ILoadingView)) {
            return view;
        }
        ILoadingView iLoadingView = view instanceof ILoadingView ? (ILoadingView) view : null;
        if (iLoadingView != null) {
            return iLoadingView.getView();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showLoadingView() {
        initLoadingViewByService();
        View view = this.loadingView;
        if (view instanceof ILoadingView) {
            ILoadingView iLoadingView = view instanceof ILoadingView ? (ILoadingView) view : null;
            if (iLoadingView != null) {
                iLoadingView.show();
            }
        } else if (view != 0) {
            view.setVisibility(0);
        }
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "show loading", "XView", null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hideLoadingView() {
        View view = this.loadingView;
        if (view instanceof ILoadingView) {
            ILoadingView iLoadingView = view instanceof ILoadingView ? (ILoadingView) view : null;
            if (iLoadingView != null) {
                iLoadingView.hide();
            }
        } else if (view != 0) {
            view.setVisibility(8);
        }
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "hide loading", "XView", null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showErrorView() {
        AbsBulletMonitorCallback monitorCallback;
        initErrorViewByService();
        View view = this.errorView;
        if (view instanceof IErrorView) {
            IErrorView iErrorView = view instanceof IErrorView ? (IErrorView) view : null;
            if (iErrorView != null) {
                iErrorView.show();
            }
        } else if (view != 0) {
            view.setVisibility(0);
        }
        BulletContext bulletContext = getBulletContext();
        if (bulletContext != null && (monitorCallback = bulletContext.getMonitorCallback()) != null) {
            monitorCallback.reportErrorViewShow();
        }
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext2 = getBulletContext();
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext2 != null ? bulletContext2.getSessionId() : null, "show error page", "XView", null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void hideErrorView() {
        View view = this.errorView;
        if (view instanceof IErrorView) {
            IErrorView iErrorView = view instanceof IErrorView ? (IErrorView) view : null;
            if (iErrorView != null) {
                iErrorView.hide();
            }
        } else if (view != 0) {
            view.setVisibility(8);
        }
        BulletLogger bulletLogger = BulletLogger.INSTANCE;
        BulletContext bulletContext = getBulletContext();
        BulletLogger.printCoreLog$default(bulletLogger, bulletContext != null ? bulletContext.getSessionId() : null, "hide error page", "XView", null, 8, null);
    }

    public static /* synthetic */ void setErrorView$default(BulletContainerView bulletContainerView, View view, FrameLayout.LayoutParams layoutParams, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setErrorView");
        }
        if ((i & 2) != 0) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        bulletContainerView.setErrorView(view, layoutParams);
    }

    public final void setErrorView(View errorView, FrameLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(errorView, "errorView");
        View view = this.errorView;
        if (view != null) {
            removeView(view);
        }
        errorView.setLayoutParams(params);
        errorView.setVisibility(8);
        addView(errorView);
        this.errorView = errorView;
        BulletContext bulletContext = getBulletContext();
        BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
        if (containerContext == null) {
            return;
        }
        containerContext.setHasErrorView(true);
    }

    private final void showLoading(Uri uri) {
        long j;
        BulletContext bulletContext;
        View loadingView;
        BulletContainerContext containerContext;
        boolean z = (getMCurrentScene() == Scenes.Container || getMCurrentScene() == Scenes.Card) ? false : true;
        BulletContext bulletContext2 = getBulletContext();
        if (bulletContext2 != null) {
            Boolean value = new BooleanParam(bulletContext2.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_SHOW_LOADING, null).getValue();
            if (value != null) {
                z = value.booleanValue();
            }
            Long value2 = new LongParam(bulletContext2.getSchemaModelUnion().getSchemaData(), SchemaConstants.QUERY_KEY_LOADING_DURATION, null).getValue();
            if (value2 != null) {
                j = value2.longValue();
                bulletContext = getBulletContext();
                if (!(bulletContext == null && (containerContext = bulletContext.getContainerContext()) != null && containerContext.getIsReload()) && isLoadFail()) {
                    showLoadingView();
                    if (j == 0 || (loadingView = getLoadingView()) == null) {
                        return;
                    }
                    loadingView.postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$showLoading$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            BulletContainerView.this.hideLoadingView();
                        }
                    }, j);
                    return;
                }
                this.shouldInterceptShowLoading = false;
                dispatchShowLoadingAfterDelay(z, j);
            }
        }
        j = 0;
        bulletContext = getBulletContext();
        if (!(bulletContext == null && (containerContext = bulletContext.getContainerContext()) != null && containerContext.getIsReload())) {
        }
        this.shouldInterceptShowLoading = false;
        dispatchShowLoadingAfterDelay(z, j);
    }

    static /* synthetic */ void dispatchShowLoadingAfterDelay$default(BulletContainerView bulletContainerView, boolean z, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchShowLoadingAfterDelay");
        }
        if ((i & 2) != 0) {
            j = 0;
        }
        bulletContainerView.dispatchShowLoadingAfterDelay(z, j);
    }

    private final void dispatchShowLoadingAfterDelay(boolean showLoading, final long loadingDuration) {
        if (this.loadingTimer == null && showLoading) {
            this.loadingTimer = new Timer();
            TimerTask timerTask = this.loadingTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = new TimerTask() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$dispatchShowLoadingAfterDelay$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Context context = BulletContainerView.this.getContext();
                    ContextUtil contextUtil = ContextUtil.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Activity ownerActivity = contextUtil.getOwnerActivity(context);
                    if (ownerActivity != null) {
                        final BulletContainerView bulletContainerView = BulletContainerView.this;
                        final long j = loadingDuration;
                        ownerActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$dispatchShowLoadingAfterDelay$1$run$1
                            /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
                            
                                r0 = r1.getLoadingView();
                             */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void run() {
                                boolean z;
                                View loadingView;
                                BulletContainerView.this.loadingTimer = null;
                                BulletContainerView.this.loadingTimerTask = null;
                                z = BulletContainerView.this.shouldInterceptShowLoading;
                                if (z) {
                                    return;
                                }
                                BulletContainerView.this.showLoadingView();
                                if (j == 0 || loadingView == null) {
                                    return;
                                }
                                final BulletContainerView bulletContainerView2 = BulletContainerView.this;
                                loadingView.postDelayed(new Runnable() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$dispatchShowLoadingAfterDelay$1$run$1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        BulletContainerView.this.hideLoadingView();
                                    }
                                }, j);
                            }
                        });
                    }
                }
            };
            this.loadingTimerTask = timerTask2;
            Timer timer = this.loadingTimer;
            if (timer != null) {
                timer.schedule(timerTask2, this.loadingDelayInMilliSeconds);
            }
        }
    }

    private final void initContainerBgColor() {
        Integer value;
        UIColorParam containerBgColor;
        Drawable.ConstantState constantState;
        UIColorParam loadingBgColor;
        BDXContainerModel bDXContainerModel = this.containerModel;
        Drawable drawable = null;
        if (bDXContainerModel == null || (loadingBgColor = bDXContainerModel.getLoadingBgColor()) == null || (value = loadingBgColor.getValue()) == null) {
            BDXContainerModel bDXContainerModel2 = this.containerModel;
            value = (bDXContainerModel2 == null || (containerBgColor = bDXContainerModel2.getContainerBgColor()) == null) ? null : containerBgColor.getValue();
        }
        if (value != null) {
            int intValue = value.intValue();
            Drawable background = getBackground();
            if (background != null && (constantState = background.getConstantState()) != null) {
                drawable = constantState.newDrawable();
            }
            this.originBackground = drawable;
            this.useCustomBackground = true;
            setBackgroundColor(intValue);
        }
    }

    private final void setContainerBgColor() {
        BDXContainerModel bDXContainerModel = this.containerModel;
        if (bDXContainerModel != null) {
            IHostContextDepend hostContextDepend = XBaseRuntime.INSTANCE.getHostContextDepend();
            Unit unit = null;
            String skinName = hostContextDepend != null ? hostContextDepend.getSkinName() : null;
            if (skinName != null) {
                String lowerCase = skinName.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (Intrinsics.areEqual(lowerCase, "light")) {
                    Integer value = bDXContainerModel.getContainerLightBgColor().getValue();
                    if (value != null) {
                        setBackgroundColor(value.intValue());
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        setBackgroundColor();
                        return;
                    }
                    return;
                }
                Integer value2 = bDXContainerModel.getContainerDarkBgColor().getValue();
                if (value2 != null) {
                    setBackgroundColor(value2.intValue());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    setBackgroundColor();
                    return;
                }
                return;
            }
            setBackgroundColor();
        }
    }

    private final void setBackgroundColor() {
        Unit unit;
        BDXContainerModel bDXContainerModel = this.containerModel;
        Intrinsics.checkNotNull(bDXContainerModel);
        Integer value = bDXContainerModel.getContainerBgColor().getValue();
        if (value != null) {
            setBackgroundColor(value.intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && this.useCustomBackground) {
            setBackground(this.originBackground);
            this.useCustomBackground = false;
        }
    }

    @Override // com.bytedance.ies.bullet.p003ui.common.BulletCardView, com.bytedance.ies.bullet.core.container.IBulletContainer
    public void setLoadingView(View loadingView, int r4, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        View view = this.loadingView;
        if (view != null) {
            removeView(view);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = marginLeft;
        layoutParams.rightMargin = marginRight;
        layoutParams.topMargin = marginTop;
        layoutParams.bottomMargin = marginBottom;
        layoutParams.gravity = r4;
        loadingView.setLayoutParams(layoutParams);
        loadingView.setVisibility(8);
        addView(loadingView);
        this.loadingView = loadingView;
    }

    public final void setLoadingView(View loadingView, FrameLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        Intrinsics.checkNotNullParameter(params, "params");
        View view = this.loadingView;
        if (view != null) {
            removeView(view);
        }
        loadingView.setLayoutParams(params);
        loadingView.setVisibility(8);
        addView(loadingView);
        this.loadingView = loadingView;
    }

    public static /* synthetic */ void setPlaceholderView$default(BulletContainerView bulletContainerView, View view, FrameLayout.LayoutParams layoutParams, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPlaceholderView");
        }
        if ((i & 2) != 0) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        bulletContainerView.setPlaceholderView(view, layoutParams);
    }

    public final void setPlaceholderView(View placeholderView, FrameLayout.LayoutParams params) {
        Intrinsics.checkNotNullParameter(placeholderView, "placeholderView");
        View view = this.placeholderView;
        if (view != null) {
            removeView(view);
        }
        placeholderView.setLayoutParams(params);
        placeholderView.setVisibility(8);
        addView(placeholderView);
        this.placeholderView = placeholderView;
    }

    public final void setLoadingViewInternal$anniex_release(View loadingView) {
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        View view = this.loadingView;
        if (view != null) {
            removeView(view);
        }
        loadingView.setVisibility(0);
        addView(loadingView);
        this.loadingView = loadingView;
    }

    private final void showSecureNoticeView() {
        View view;
        HybridSecureConfig secureConfig;
        Function3<Context, String, Function0<Unit>, View> createNoticeView$anniex_release;
        View view2 = this.secureNoticeView;
        if (view2 == null) {
            String str = getMCurrentScene() == Scenes.PopupFragment ? "popup" : "page";
            BulletContext bulletContext = getBulletContext();
            if (bulletContext == null || (secureConfig = BulletContextKt.getSecureConfig(bulletContext)) == null || (createNoticeView$anniex_release = secureConfig.getCreateNoticeView$anniex_release()) == null) {
                view = null;
            } else {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                view = (View) createNoticeView$anniex_release.invoke(context, str, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$showSecureNoticeView$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m601invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m601invoke() {
                        View view3;
                        BulletContainerView bulletContainerView = BulletContainerView.this;
                        view3 = bulletContainerView.secureNoticeView;
                        bulletContainerView.hideSecureView(view3);
                        IKitViewService kitView = BulletContainerView.this.getCurrentKitView();
                        if (kitView != null) {
                            kitView.reloadCurrentUrl();
                        }
                    }
                });
            }
            this.secureNoticeView = view;
        } else {
            hideSecureView(view2);
        }
        View view3 = this.secureNoticeView;
        if (view3 != null) {
            view3.setVisibility(0);
            addView(view3);
        }
    }

    private final void showSecureDenyView() {
        View view;
        HybridSecureConfig secureConfig;
        Function3<Context, String, Function0<Unit>, View> createDenyView$anniex_release;
        View view2 = this.secureDenyView;
        if (view2 == null) {
            String str = getMCurrentScene() == Scenes.PopupFragment ? "popup" : "page";
            BulletContext bulletContext = getBulletContext();
            if (bulletContext == null || (secureConfig = BulletContextKt.getSecureConfig(bulletContext)) == null || (createDenyView$anniex_release = secureConfig.getCreateDenyView$anniex_release()) == null) {
                view = null;
            } else {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                view = (View) createDenyView$anniex_release.invoke(context, str, new Function0<Unit>() { // from class: com.bytedance.ies.bullet.ui.common.BulletContainerView$showSecureDenyView$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m600invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m600invoke() {
                        View view3;
                        Function0 function0;
                        IKitViewService kitView = BulletContainerView.this.getCurrentKitView();
                        boolean z = false;
                        if (kitView != null && kitView.onBackPressed()) {
                            z = true;
                        }
                        if (!z) {
                            function0 = BulletContainerView.this.errorCloseMethod;
                            if (function0 != null) {
                                function0.invoke();
                                return;
                            }
                            return;
                        }
                        BulletContainerView bulletContainerView = BulletContainerView.this;
                        view3 = bulletContainerView.secureDenyView;
                        bulletContainerView.hideSecureView(view3);
                    }
                });
            }
            this.secureDenyView = view;
        } else {
            hideSecureView(view2);
        }
        View view3 = this.secureDenyView;
        if (view3 != null) {
            view3.setVisibility(0);
            addView(view3);
        }
    }

    public final void hideSecureView(View secureView) {
        if (secureView != null) {
            secureView.setVisibility(8);
            removeView(secureView);
        }
    }
}
