package com.bytedance.android.anniex.container.util;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.IErrorView;
import com.bytedance.ies.bullet.service.base.ILoadingView;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomViewUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/container/util/CustomViewUtil;", "", "()V", "HOST", "", "TAG", "createDenyView", "Landroid/view/View;", "createErrorView", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "Lcom/bytedance/android/anniex/container/AnnieXContainer;", "createLoadingView", "createNoticeView", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CustomViewUtil {
    private static final String HOST = "host";
    public static final CustomViewUtil INSTANCE = new CustomViewUtil();
    private static final String TAG = "CustomViewUtil";

    public final View createDenyView() {
        return null;
    }

    public final View createNoticeView() {
        return null;
    }

    private CustomViewUtil() {
    }

    public final View createErrorView(final AnnieXContainer container) {
        String currentBid;
        IErrorView createErrorView;
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        ISchemaData schemaData = container.getSchemaData();
        if (schemaData == null) {
            return null;
        }
        if (Intrinsics.areEqual(new StringParam(schemaData, "error_page_style", (String) null).getValue(), HOST)) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use host theme to create error view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = "default_bid";
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use custom theme to create error view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = container.getCurrentBid();
        }
        String viewType = container.getViewType();
        IViewService iViewService = ServiceCenter.Companion.instance().get(currentBid, IViewService.class);
        if (iViewService == null || (createErrorView = iViewService.createErrorView(container.getSystemContext(), viewType)) == null || (view = createErrorView.getView(new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.util.CustomViewUtil$createErrorView$1$1$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m3310invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public void m3310invoke() {
                AnnieXContainer.this.close();
            }
        }, new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.util.CustomViewUtil$createErrorView$1$1$2
            public /* bridge */ /* synthetic */ Object invoke() {
                m3311invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public void m3311invoke() {
                AnnieXContainer.this.reload(null);
            }
        })) == null) {
            return null;
        }
        FrameLayout.LayoutParams errorViewLayoutParams = iViewService.getErrorViewLayoutParams(viewType);
        if (errorViewLayoutParams != null) {
            view.setLayoutParams(errorViewLayoutParams);
        }
        return view;
    }

    public final View createErrorView(final IContainer container) {
        String currentBid;
        Context systemContext;
        IErrorView createErrorView;
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        ISchemaData currentSchema = container.getCurrentSchema();
        if (currentSchema == null) {
            return null;
        }
        if (Intrinsics.areEqual(new StringParam(currentSchema, "error_page_style", (String) null).getValue(), HOST)) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use host theme to create error view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = "default_bid";
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use custom theme to create error view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = container.getCurrentBid();
        }
        String viewType = container.getViewType();
        IViewService iViewService = ServiceCenter.Companion.instance().get(currentBid, IViewService.class);
        if (iViewService == null || (systemContext = container.getSystemContext()) == null || (createErrorView = iViewService.createErrorView(systemContext, viewType)) == null || (view = createErrorView.getView(new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.util.CustomViewUtil$createErrorView$2$1$1$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m3312invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public void m3312invoke() {
                IContainer.this.close();
            }
        }, new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.util.CustomViewUtil$createErrorView$2$1$1$2
            public /* bridge */ /* synthetic */ Object invoke() {
                m3313invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public void m3313invoke() {
                IContainer.this.reload(null);
            }
        })) == null) {
            return null;
        }
        view.setLayoutParams(iViewService.getErrorViewLayoutParams(viewType));
        return view;
    }

    public final View createLoadingView(AnnieXContainer container) {
        String currentBid;
        ILoadingView createLoadingView;
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        ISchemaData schemaData = container.getSchemaData();
        if (schemaData == null) {
            return null;
        }
        if (Intrinsics.areEqual(new StringParam(schemaData, "loading_style", (String) null).getValue(), HOST)) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use host theme to create loading view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = "default_bid";
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use custom theme to create loading view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = container.getCurrentBid();
        }
        String viewType = container.getViewType();
        IViewService iViewService = ServiceCenter.Companion.instance().get(currentBid, IViewService.class);
        if (iViewService == null || (createLoadingView = iViewService.createLoadingView(container.getSystemContext(), viewType)) == null || (view = createLoadingView.getView()) == null) {
            return null;
        }
        FrameLayout.LayoutParams loadingViewLayoutParams = iViewService.getLoadingViewLayoutParams(viewType);
        if (loadingViewLayoutParams != null) {
            view.setLayoutParams(loadingViewLayoutParams);
        }
        return view;
    }

    public final View createLoadingView(IContainer container) {
        String currentBid;
        Context systemContext;
        ILoadingView createLoadingView;
        View view;
        Intrinsics.checkNotNullParameter(container, "container");
        ISchemaData currentSchema = container.getCurrentSchema();
        if (currentSchema == null) {
            return null;
        }
        if (Intrinsics.areEqual(new StringParam(currentSchema, "loading_style", (String) null).getValue(), HOST)) {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use host theme to create loading view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = "default_bid";
        } else {
            HybridLogger.d$default(HybridLogger.INSTANCE, TAG, "use custom theme to create loading view", (Map) null, (LoggerContext) null, 12, (Object) null);
            currentBid = container.getCurrentBid();
        }
        String viewType = container.getViewType();
        IViewService iViewService = ServiceCenter.Companion.instance().get(currentBid, IViewService.class);
        if (iViewService == null || (systemContext = container.getSystemContext()) == null || (createLoadingView = iViewService.createLoadingView(systemContext, viewType)) == null || (view = createLoadingView.getView()) == null) {
            return null;
        }
        FrameLayout.LayoutParams loadingViewLayoutParams = iViewService.getLoadingViewLayoutParams(viewType);
        if (loadingViewLayoutParams != null) {
            view.setLayoutParams(loadingViewLayoutParams);
        }
        return view;
    }
}
