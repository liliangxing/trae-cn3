package com.bytedance.ies.bullet.p003ui.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletTitleBar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/BulletTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_$_findViewCache", "", "Landroid/view/View;", "titleBarRootView", "getTitleBarRootView", "()Landroid/view/View;", "setTitleBarRootView", "(Landroid/view/View;)V", "_$_findCachedViewByID", "id", EventConstants.PARAM_SOURCE_INIT, "", "uiModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "setBackListener", IMessageCallbackService.EVENT_TYPE_CLICK, "Landroid/view/View$OnClickListener;", "setCloseAllListener", "setTitleIfMissing", SchemaConstants.QUERY_KEY_TITLE, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletTitleBar extends FrameLayout {
    private Map<Integer, View> _$_findViewCache;
    private View titleBarRootView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BulletTitleBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BulletTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BulletTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View inflate = LayoutInflater.from(context).inflate(R.layout.bullet_title_bar, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…et_title_bar, this, true)");
        this.titleBarRootView = inflate;
    }

    public final View getTitleBarRootView() {
        return this.titleBarRootView;
    }

    public final void setTitleBarRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.titleBarRootView = view;
    }

    public final void init(BDXPageModel uiModel) {
        if (uiModel == null) {
            return;
        }
        Integer value = uiModel.getNavBarColor().getValue();
        if (value != null) {
            ((FrameLayout) _$_findCachedViewByID(R.id.titlebar_root_view)).setBackgroundColor(value.intValue());
        }
        TextView textView = (TextView) _$_findCachedViewByID(R.id.tv_title);
        String value2 = uiModel.getTitle().getValue();
        if (value2 == null) {
            value2 = "";
        }
        textView.setText(value2);
        Integer value3 = uiModel.getTitleColor().getValue();
        if (value3 != null) {
            int intValue = value3.intValue();
            ((TextView) _$_findCachedViewByID(R.id.tv_title)).setTextColor(intValue);
            ((AutoRTLImageView) _$_findCachedViewByID(R.id.iv_back)).setContentDescription("返回");
            ViewCompat.setAccessibilityDelegate(_$_findCachedViewByID(R.id.iv_back), new AccessibilityDelegateCompat() { // from class: com.bytedance.ies.bullet.ui.common.view.BulletTitleBar$init$2$delegate$1
                public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    Intrinsics.checkNotNullParameter(info, "info");
                    super.onInitializeAccessibilityNodeInfo(host, info);
                    info.setClassName(Button.class.getName());
                }
            });
            ((AutoRTLImageView) _$_findCachedViewByID(R.id.iv_back)).getAccessibilityNodeProvider();
            AutoRTLImageView autoRTLImageView = (AutoRTLImageView) _$_findCachedViewByID(R.id.iv_back);
            VectorDrawableCompat create = VectorDrawableCompat.create(getContext().getResources(), R.drawable.ic_title_bar_back_normal_vec, getContext().getTheme());
            if (create != null) {
                create.setTint(intValue);
            } else {
                create = null;
            }
            autoRTLImageView.setImageDrawable((Drawable) create);
        }
        if (Intrinsics.areEqual(uiModel.getShowCloseall().getValue(), true)) {
            ((AutoRTLImageView) _$_findCachedViewByID(R.id.iv_close_all)).setVisibility(0);
        }
    }

    public final void setTitleIfMissing(CharSequence title) {
        Intrinsics.checkNotNullParameter(title, SchemaConstants.QUERY_KEY_TITLE);
        CharSequence text = ((TextView) _$_findCachedViewByID(R.id.tv_title)).getText();
        Intrinsics.checkNotNullExpressionValue(text, "this@BulletTitleBar.`_$_…d.widget.TextView>().text");
        if (text.length() == 0) {
            ((TextView) _$_findCachedViewByID(R.id.tv_title)).setText(title);
        }
    }

    public final void setBackListener(View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, IMessageCallbackService.EVENT_TYPE_CLICK);
        ((AutoRTLImageView) _$_findCachedViewByID(R.id.iv_back)).setOnClickListener(click);
    }

    public final void setCloseAllListener(View.OnClickListener click) {
        Intrinsics.checkNotNullParameter(click, IMessageCallbackService.EVENT_TYPE_CLICK);
        ((AutoRTLImageView) _$_findCachedViewByID(R.id.iv_close_all)).setOnClickListener(click);
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
