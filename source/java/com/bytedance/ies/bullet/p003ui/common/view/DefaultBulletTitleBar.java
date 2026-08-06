package com.bytedance.ies.bullet.p003ui.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultBulletTitleBar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/DefaultBulletTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_$_findViewCache", "", "", "Landroid/view/View;", "_$_findCachedViewByID", "id", "getBackView", "Landroid/widget/ImageView;", "getCloseAllView", "getMoreButtonView", "getReportView", "getShareView", "getTitleBarRoot", "getTitleView", "Landroid/widget/TextView;", "setDefaultTitle", "", "defaultTitle", "", "setTitleBarBackgroundColor", "color", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultBulletTitleBar extends FrameLayout implements IBulletViewProvider.IBulletTitleBar {
    private Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultBulletTitleBar(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.base_bullet_title_bar, (ViewGroup) this, true);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public View getTitleBarRoot() {
        return this;
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public ImageView getBackView() {
        return (ImageView) _$_findCachedViewByID(R.id.iv_back);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public ImageView getCloseAllView() {
        return (ImageView) _$_findCachedViewByID(R.id.iv_close_all);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public ImageView getShareView() {
        return (ImageView) _$_findCachedViewByID(R.id.iv_share);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public ImageView getReportView() {
        return (ImageView) _$_findCachedViewByID(R.id.iv_report);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public ImageView getMoreButtonView() {
        return (ImageView) _$_findCachedViewByID(R.id.iv_more);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public TextView getTitleView() {
        return (TextView) _$_findCachedViewByID(R.id.tv_title);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public void setDefaultTitle(CharSequence defaultTitle) {
        Intrinsics.checkNotNullParameter(defaultTitle, "defaultTitle");
        TextView titleView = getTitleView();
        if (titleView != null) {
            CharSequence text = titleView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "text");
            if (text.length() == 0) {
                titleView.setText(defaultTitle);
            }
        }
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBar
    public void setTitleBarBackgroundColor(int color) {
        ((FrameLayout) _$_findCachedViewByID(R.id.titlebar_root_view)).setBackgroundColor(color);
    }

    public View _$_findCachedViewByID(int id) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new LinkedHashMap();
        }
        View view = this._$_findViewCache.get(Integer.valueOf(id));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(id);
        if (findViewById == null) {
            return null;
        }
        this._$_findViewCache.put(Integer.valueOf(id), findViewById);
        return findViewById;
    }
}
