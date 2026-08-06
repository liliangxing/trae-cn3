package com.bytedance.ies.bullet.p003ui.common.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.p003ui.common.view.BaseBulletTitleBarProvider;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import com.bytedance.push.interfaze.IMessageCallbackService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBulletTitleBarProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\b\u0016\u0018\u0000 .2\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/BaseBulletTitleBarProvider;", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "()V", "bulletTitleBar", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBar;", "getBulletTitleBar", "()Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBar;", "setBulletTitleBar", "(Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBar;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "initiated", "", "getInitiated", "()Z", "setInitiated", "(Z)V", "localUiModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "topRightClickHandler", "Lcom/bytedance/ies/bullet/ui/common/view/BaseBulletTitleBarProvider$ViewClickDelegate;", "getTopRightClickHandler", "()Lcom/bytedance/ies/bullet/ui/common/view/BaseBulletTitleBarProvider$ViewClickDelegate;", "setTopRightClickHandler", "(Lcom/bytedance/ies/bullet/ui/common/view/BaseBulletTitleBarProvider$ViewClickDelegate;)V", "applyParams", "", "uiModel", "enterImmersiveMode", "getInitParams", "initWithParams", "Landroid/view/View;", "uri", "Landroid/net/Uri;", "setBackListener", IMessageCallbackService.EVENT_TYPE_CLICK, "Landroid/view/View$OnClickListener;", "setCloseAllListener", "setDefaultTitle", "defaultTitle", "", "setWebParams", "Companion", "ViewClickDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseBulletTitleBarProvider implements IBulletViewProvider.IBulletTitleBarProvider {
    public static final int NAV_BTN_TYPE_MORE = 3;
    public static final int NAV_BTN_TYPE_REPORT = 1;
    public static final int NAV_BTN_TYPE_SHARE = 2;
    public static final int TITLE_BAR_STYLE_IMMERSIVE_MODE = 1;
    public IBulletViewProvider.IBulletTitleBar bulletTitleBar;
    public Context context;
    private boolean initiated;
    private BDXPageModel localUiModel;
    private ViewClickDelegate topRightClickHandler;

    /* compiled from: BaseBulletTitleBarProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/BaseBulletTitleBarProvider$ViewClickDelegate;", "", "onClick", "", "v", "Landroid/view/View;", "type", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ViewClickDelegate {
        void onClick(View v, int type);
    }

    /* compiled from: BaseBulletTitleBarProvider.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NavBtnType.values().length];
            try {
                iArr[NavBtnType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavBtnType.REPORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NavBtnType.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBarProvider
    public IBulletViewProvider.IBulletTitleBar provideTitleBar() {
        return IBulletViewProvider.IBulletTitleBarProvider.DefaultImpls.provideTitleBar(this);
    }

    public final IBulletViewProvider.IBulletTitleBar getBulletTitleBar() {
        IBulletViewProvider.IBulletTitleBar iBulletTitleBar = this.bulletTitleBar;
        if (iBulletTitleBar != null) {
            return iBulletTitleBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bulletTitleBar");
        return null;
    }

    public final void setBulletTitleBar(IBulletViewProvider.IBulletTitleBar iBulletTitleBar) {
        Intrinsics.checkNotNullParameter(iBulletTitleBar, "<set-?>");
        this.bulletTitleBar = iBulletTitleBar;
    }

    public final boolean getInitiated() {
        return this.initiated;
    }

    public final void setInitiated(boolean z) {
        this.initiated = z;
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public ViewClickDelegate getTopRightClickHandler() {
        return this.topRightClickHandler;
    }

    public void setTopRightClickHandler(ViewClickDelegate viewClickDelegate) {
        this.topRightClickHandler = viewClickDelegate;
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBarProvider
    /* renamed from: getInitParams, reason: from getter */
    public BDXPageModel getLocalUiModel() {
        return this.localUiModel;
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBarProvider
    public View initWithParams(Context context, Uri uri, BDXPageModel uiModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.initiated) {
            return getBulletTitleBar().getTitleBarRoot();
        }
        this.initiated = true;
        this.localUiModel = uiModel;
        setContext(context);
        DefaultBulletTitleBar provideTitleBar = provideTitleBar();
        if (provideTitleBar == null) {
            provideTitleBar = new DefaultBulletTitleBar(context);
        }
        setBulletTitleBar(provideTitleBar);
        applyParams(uiModel);
        return getBulletTitleBar().getTitleBarRoot();
    }

    public final void applyParams(BDXPageModel uiModel) {
        Drawable drawable;
        if (uiModel == null) {
            return;
        }
        Integer value = uiModel.getNavBarColor().getValue();
        if (value != null) {
            getBulletTitleBar().setTitleBarBackgroundColor(value.intValue());
        }
        TextView titleView = getBulletTitleBar().getTitleView();
        if (titleView != null) {
            String value2 = uiModel.getTitle().getValue();
            if (value2 == null) {
                value2 = "";
            }
            titleView.setText(value2);
        }
        Integer value3 = uiModel.getTitleColor().getValue();
        if (value3 != null) {
            int intValue = value3.intValue();
            TextView titleView2 = getBulletTitleBar().getTitleView();
            if (titleView2 != null) {
                titleView2.setTextColor(intValue);
            }
            ImageView backView = getBulletTitleBar().getBackView();
            if (backView != null) {
                Drawable drawable2 = null;
                try {
                    VectorDrawableCompat create = VectorDrawableCompat.create(getContext().getResources(), R.drawable.ic_title_bar_back_normal_vec, getContext().getTheme());
                    if (create != null) {
                        create.setTint(intValue);
                    } else {
                        create = null;
                    }
                    drawable = (Drawable) create;
                } catch (Resources.NotFoundException unused) {
                    Drawable drawable3 = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_title_bar_back_normal, getContext().getTheme());
                    if (drawable3 != null) {
                        DrawableCompat.setTint(drawable3, intValue);
                        drawable2 = drawable3;
                    }
                    drawable = drawable2;
                }
                backView.setImageDrawable(drawable);
            }
        }
        setWebParams(uiModel);
    }

    public void setWebParams(BDXPageModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        NavBtnType value = uiModel.getNavBtnType().getValue();
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1) {
            ImageView shareView = getBulletTitleBar().getShareView();
            if (shareView != null) {
                shareView.setVisibility(8);
            }
            ImageView reportView = getBulletTitleBar().getReportView();
            if (reportView != null) {
                reportView.setVisibility(8);
            }
        } else if (i == 2) {
            ImageView shareView2 = getBulletTitleBar().getShareView();
            if (shareView2 != null) {
                shareView2.setVisibility(8);
            }
            ImageView reportView2 = getBulletTitleBar().getReportView();
            if (reportView2 != null) {
                reportView2.setVisibility(0);
            }
            ImageView reportView3 = getBulletTitleBar().getReportView();
            if (reportView3 != null) {
                reportView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.view.BaseBulletTitleBarProvider$setWebParams$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseBulletTitleBarProvider.ViewClickDelegate topRightClickHandler = BaseBulletTitleBarProvider.this.getTopRightClickHandler();
                        if (topRightClickHandler != null) {
                            Intrinsics.checkNotNullExpressionValue(view, "it");
                            topRightClickHandler.onClick(view, 1);
                        }
                    }
                });
            }
        } else if (i == 3) {
            ImageView reportView4 = getBulletTitleBar().getReportView();
            if (reportView4 != null) {
                reportView4.setVisibility(8);
            }
            ImageView shareView3 = getBulletTitleBar().getShareView();
            if (shareView3 != null) {
                shareView3.setVisibility(0);
            }
            ImageView shareView4 = getBulletTitleBar().getShareView();
            if (shareView4 != null) {
                shareView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.view.BaseBulletTitleBarProvider$setWebParams$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseBulletTitleBarProvider.ViewClickDelegate topRightClickHandler = BaseBulletTitleBarProvider.this.getTopRightClickHandler();
                        if (topRightClickHandler != null) {
                            Intrinsics.checkNotNullExpressionValue(view, "it");
                            topRightClickHandler.onClick(view, 2);
                        }
                    }
                });
            }
        }
        ImageView moreButtonView = getBulletTitleBar().getMoreButtonView();
        if (moreButtonView != null) {
            moreButtonView.setVisibility(Intrinsics.areEqual(uiModel.getShowMoreButton().getValue(), true) ? 0 : 8);
            moreButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.ui.common.view.BaseBulletTitleBarProvider$setWebParams$3$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseBulletTitleBarProvider.ViewClickDelegate topRightClickHandler = BaseBulletTitleBarProvider.this.getTopRightClickHandler();
                    if (topRightClickHandler != null) {
                        Intrinsics.checkNotNullExpressionValue(view, "it");
                        topRightClickHandler.onClick(view, 3);
                    }
                }
            });
        }
        Integer value2 = uiModel.getTitleBarStyle().getValue();
        if (value2 != null && value2.intValue() == 1) {
            enterImmersiveMode();
        }
    }

    public void enterImmersiveMode() {
        getBulletTitleBar().setTitleBarBackgroundColor(0);
        TextView titleView = getBulletTitleBar().getTitleView();
        if (titleView == null) {
            return;
        }
        titleView.setVisibility(0);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBarProvider
    public void setDefaultTitle(CharSequence defaultTitle) {
        Intrinsics.checkNotNullParameter(defaultTitle, "defaultTitle");
        getBulletTitleBar().setDefaultTitle(defaultTitle);
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBarProvider
    public void setBackListener(View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, IMessageCallbackService.EVENT_TYPE_CLICK);
        ImageView backView = getBulletTitleBar().getBackView();
        if (backView != null) {
            backView.setOnClickListener(click);
            CharSequence contentDescription = backView.getContentDescription();
            if (contentDescription == null || contentDescription.length() == 0) {
                backView.setContentDescription("返回");
                ViewCompat.setAccessibilityDelegate(backView, new AccessibilityDelegateCompat() { // from class: com.bytedance.ies.bullet.ui.common.view.BaseBulletTitleBarProvider$setBackListener$1$delegate$1
                    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                        Intrinsics.checkNotNullParameter(host, "host");
                        Intrinsics.checkNotNullParameter(info, "info");
                        super.onInitializeAccessibilityNodeInfo(host, info);
                        info.setClassName(Button.class.getName());
                        info.setContentDescription("返回");
                    }
                });
            }
        }
    }

    @Override // com.bytedance.ies.bullet.ui.common.IBulletViewProvider.IBulletTitleBarProvider
    public void setCloseAllListener(View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, IMessageCallbackService.EVENT_TYPE_CLICK);
        ImageView closeAllView = getBulletTitleBar().getCloseAllView();
        if (closeAllView != null) {
            closeAllView.setOnClickListener(click);
            Unit unit = Unit.INSTANCE;
        }
    }
}
