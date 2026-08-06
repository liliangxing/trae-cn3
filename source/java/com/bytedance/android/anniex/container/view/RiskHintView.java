package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.anniex.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RiskHintView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/container/view/RiskHintView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "closeIv", "Landroid/widget/ImageView;", "hintTv", "Landroid/widget/TextView;", "riskView", "Landroid/view/ViewGroup;", "updateRiskInfo", "", "hintText", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class RiskHintView extends FrameLayout {
    private ImageView closeIv;
    private TextView hintTv;
    private ViewGroup riskView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RiskHintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void updateRiskInfo(final String hintText) {
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        ViewGroup viewGroup = this.riskView;
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.android.anniex.container.view.RiskHintView$updateRiskInfo$1
                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView;
                    textView = RiskHintView.this.hintTv;
                    if (textView == null) {
                        return;
                    }
                    textView.setText(hintText);
                }
            });
        } else {
            post(new Runnable() { // from class: com.bytedance.android.anniex.container.view.RiskHintView$updateRiskInfo$2
                @Override // java.lang.Runnable
                public final void run() {
                    ViewGroup viewGroup2;
                    ViewGroup viewGroup3;
                    ImageView imageView;
                    TextView textView;
                    RiskHintView riskHintView = RiskHintView.this;
                    riskHintView.riskView = (ViewGroup) LayoutInflater.from(riskHintView.getContext()).inflate(R.layout.annie_x_risk_hint_view, RiskHintView.this);
                    RiskHintView riskHintView2 = RiskHintView.this;
                    viewGroup2 = riskHintView2.riskView;
                    riskHintView2.hintTv = viewGroup2 != null ? (TextView) viewGroup2.findViewById(R.id.annie_x_risk_info_tv) : null;
                    RiskHintView riskHintView3 = RiskHintView.this;
                    viewGroup3 = riskHintView3.riskView;
                    riskHintView3.closeIv = viewGroup3 != null ? (ImageView) viewGroup3.findViewById(R.id.annie_x_risk_close_iv) : null;
                    imageView = RiskHintView.this.closeIv;
                    if (imageView != null) {
                        final RiskHintView riskHintView4 = RiskHintView.this;
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.view.RiskHintView$updateRiskInfo$2.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ViewGroup viewGroup4;
                                viewGroup4 = RiskHintView.this.riskView;
                                if (viewGroup4 == null) {
                                    return;
                                }
                                viewGroup4.setVisibility(8);
                            }
                        });
                    }
                    textView = RiskHintView.this.hintTv;
                    if (textView == null) {
                        return;
                    }
                    textView.setText(hintText);
                }
            });
        }
    }
}
