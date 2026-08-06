package com.bytedance.ies.bullet.service.base;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.ui.common.IBulletViewProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IViewService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IViewService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "createErrorView", "Lcom/bytedance/ies/bullet/service/base/IErrorView;", "context", "Landroid/content/Context;", "type", "", "createLoadingView", "Lcom/bytedance/ies/bullet/service/base/ILoadingView;", "getErrorViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getLoadingViewLayoutParams", "getTitleBarProvider", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IViewService extends IBulletService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String TYPE_CONTAINER = "container";
    public static final String TYPE_PAGE = "page";
    public static final String TYPE_POPUP = "popup";

    /* compiled from: IViewService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static IBulletViewProvider.IBulletTitleBarProvider getTitleBarProvider(IViewService iViewService, String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return null;
        }
    }

    IErrorView createErrorView(Context context, String type);

    ILoadingView createLoadingView(Context context, String type);

    FrameLayout.LayoutParams getErrorViewLayoutParams(String type);

    FrameLayout.LayoutParams getLoadingViewLayoutParams(String type);

    IBulletViewProvider.IBulletTitleBarProvider getTitleBarProvider(String type);

    /* compiled from: IViewService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IViewService$Companion;", "", "()V", "TYPE_CONTAINER", "", "TYPE_PAGE", "TYPE_POPUP", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String TYPE_CONTAINER = "container";
        public static final String TYPE_PAGE = "page";
        public static final String TYPE_POPUP = "popup";

        private Companion() {
        }
    }
}
