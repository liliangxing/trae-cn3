package com.bytedance.ies.bullet.ui.common;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: IBulletViewProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0017J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0017¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider;", "", "offerTitleBarProvider", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "provideErrorView", "Landroid/view/View;", "provideLoadingView", "IBulletTitleBar", "IBulletTitleBarProvider", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletViewProvider {

    /* compiled from: IBulletViewProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static IBulletTitleBarProvider offerTitleBarProvider(IBulletViewProvider iBulletViewProvider) {
            return null;
        }

        @Deprecated(message = "get the error view from PageConfig")
        public static View provideErrorView(IBulletViewProvider iBulletViewProvider) {
            return null;
        }

        @Deprecated(message = "get the loading view from PageConfig")
        public static View provideLoadingView(IBulletViewProvider iBulletViewProvider) {
            return null;
        }
    }

    /* compiled from: IBulletViewProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBar;", "", "getBackView", "Landroid/widget/ImageView;", "getCloseAllView", "getMoreButtonView", "getReportView", "getShareView", "getTitleBarRoot", "Landroid/view/View;", "getTitleView", "Landroid/widget/TextView;", "setDefaultTitle", "", "defaultTitle", "", "setTitleBarBackgroundColor", "color", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IBulletTitleBar {

        /* compiled from: IBulletViewProvider.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class DefaultImpls {
            public static ImageView getBackView(IBulletTitleBar iBulletTitleBar) {
                return null;
            }

            public static ImageView getCloseAllView(IBulletTitleBar iBulletTitleBar) {
                return null;
            }

            public static ImageView getMoreButtonView(IBulletTitleBar iBulletTitleBar) {
                return null;
            }

            public static ImageView getReportView(IBulletTitleBar iBulletTitleBar) {
                return null;
            }

            public static ImageView getShareView(IBulletTitleBar iBulletTitleBar) {
                return null;
            }

            public static TextView getTitleView(IBulletTitleBar iBulletTitleBar) {
                return null;
            }
        }

        ImageView getBackView();

        ImageView getCloseAllView();

        ImageView getMoreButtonView();

        ImageView getReportView();

        ImageView getShareView();

        View getTitleBarRoot();

        TextView getTitleView();

        void setDefaultTitle(CharSequence defaultTitle);

        void setTitleBarBackgroundColor(int color);
    }

    /* compiled from: IBulletViewProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "", "getInitParams", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "initWithParams", "Landroid/view/View;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "uiModel", "provideTitleBar", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBar;", "setBackListener", "", "click", "Landroid/view/View$OnClickListener;", "setCloseAllListener", "setDefaultTitle", "defaultTitle", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface IBulletTitleBarProvider {

        /* compiled from: IBulletViewProvider.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class DefaultImpls {
            public static IBulletTitleBar provideTitleBar(IBulletTitleBarProvider iBulletTitleBarProvider) {
                return null;
            }
        }

        BDXPageModel getInitParams();

        View initWithParams(Context context, Uri uri, BDXPageModel uiModel);

        IBulletTitleBar provideTitleBar();

        void setBackListener(View.OnClickListener click);

        void setCloseAllListener(View.OnClickListener click);

        void setDefaultTitle(CharSequence defaultTitle);
    }

    IBulletTitleBarProvider offerTitleBarProvider();

    @Deprecated(message = "get the error view from PageConfig")
    View provideErrorView();

    @Deprecated(message = "get the loading view from PageConfig")
    View provideLoadingView();
}
