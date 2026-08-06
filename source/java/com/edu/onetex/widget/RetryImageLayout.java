package com.edu.onetex.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.edu.onetex.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryImageLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/edu/onetex/widget/RetryImageLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableAgain", "Ljava/lang/Runnable;", "enabledClick", "", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "outerRetryListener", "retryBtn", "Landroid/view/View;", "getRetryBtn", "()Landroid/view/View;", "setRetryBtn", "(Landroid/view/View;)V", "doClick", "", BaseSwitches.V, "onClick", "setOnRetryClickListener", "clickListener", "setRetryVisible", "visible", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class RetryImageLayout extends FrameLayout implements View.OnClickListener {
    private static final long DEFAULT_INTERVAL = 500;
    private HashMap _$_findViewCache;
    private final Runnable enableAgain;
    private boolean enabledClick;
    public ImageView imageView;
    private View.OnClickListener outerRetryListener;
    public View retryBtn;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public RetryImageLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public RetryImageLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RetryImageLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.enabledClick = true;
        this.enableAgain = new Runnable() { // from class: com.edu.onetex.widget.RetryImageLayout$enableAgain$1
            @Override // java.lang.Runnable
            public final void run() {
                RetryImageLayout.this.enabledClick = true;
            }
        };
        FrameLayout.inflate(context, R.layout.onetex_retry_image_layout, this);
        View findViewById = findViewById(R.id.onetex_image_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.onetex_image_iv)");
        this.imageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.onetex_image_retry_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.onetex_image_retry_tv)");
        this.retryBtn = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
        }
        findViewById2.setOnClickListener(this);
    }

    public final ImageView getImageView() {
        ImageView imageView = this.imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        }
        return imageView;
    }

    public final void setImageView(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.imageView = imageView;
    }

    public final View getRetryBtn() {
        View view = this.retryBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
        }
        return view;
    }

    public final void setRetryBtn(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.retryBtn = view;
    }

    private final void doClick(View v) {
        View.OnClickListener onClickListener = this.outerRetryListener;
        if (onClickListener != null) {
            onClickListener.onClick(v);
        }
    }

    public final void setOnRetryClickListener(View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.outerRetryListener = clickListener;
    }

    public final void setRetryVisible(boolean visible) {
        View view = this.retryBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
        }
        view.setVisibility(visible ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (this.retryBtn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
        }
        if (!(!Intrinsics.areEqual(r0, v)) && this.enabledClick) {
            this.enabledClick = false;
            HANDLER.postDelayed(this.enableAgain, 500L);
            doClick(v);
        }
    }
}
