package com.bytedance.ies.bullet.service.base;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IViewService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/BaseViewService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IViewService;", "()V", "createErrorView", "Lcom/bytedance/ies/bullet/service/base/IErrorView;", "context", "Landroid/content/Context;", "type", "", "createLoadingView", "Lcom/bytedance/ies/bullet/service/base/ILoadingView;", "getErrorViewLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "getLoadingViewLayoutParams", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseViewService extends BaseBulletService implements IViewService {
    @Override // com.bytedance.ies.bullet.service.base.IViewService
    public IErrorView createErrorView(Context context, String type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.IViewService
    public ILoadingView createLoadingView(Context context, String type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.IViewService
    public FrameLayout.LayoutParams getErrorViewLayoutParams(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.IViewService
    public FrameLayout.LayoutParams getLoadingViewLayoutParams(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.IViewService
    public IBulletViewProvider.IBulletTitleBarProvider getTitleBarProvider(String str) {
        return IViewService.DefaultImpls.getTitleBarProvider(this, str);
    }
}
