package com.bytedance.trae.home.onboarding;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.home.C0820R;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: OnboardingPagerAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;", "pages", "", "Lcom/bytedance/trae/home/onboarding/OnboardingPageData;", "density", "", "<init>", "(Ljava/util/List;F)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "getItemCount", "PageViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class OnboardingPagerAdapter extends RecyclerView.Adapter<PageViewHolder> {
    public static final int $stable = 8;
    private final float density;
    private final List<OnboardingPageData> pages;

    public OnboardingPagerAdapter(List<OnboardingPageData> list, float f) {
        Intrinsics.checkNotNullParameter(list, "pages");
        this.pages = list;
        this.density = f;
    }

    /* compiled from: OnboardingPagerAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/onboarding/OnboardingPagerAdapter$PageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class PageViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public PageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setPadding(0, (int) (RangesKt.coerceAtLeast((((context.getResources().getDisplayMetrics().heightPixels / this.density) - 132.0f) - 343.0f) * 0.382f, 60.0f) * this.density), 0, 0);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 32.0f);
        textView.setTextColor(ContextCompat.getColor(context, C0820R.color.onboarding_text_default));
        textView.setGravity(17);
        textView.setTag("title");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        float f = 24;
        layoutParams.setMarginStart((int) (this.density * f));
        layoutParams.setMarginEnd((int) (this.density * f));
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        Space space = new Space(context);
        space.setLayoutParams(new LinearLayout.LayoutParams(0, (int) (60 * this.density)));
        linearLayout.addView(space);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) (203 * this.density));
        float f2 = 40;
        layoutParams2.setMarginStart((int) (this.density * f2));
        layoutParams2.setMarginEnd((int) (f2 * this.density));
        linearLayout2.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f * this.density);
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setClipToOutline(true);
        linearLayout2.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setTag("image");
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.addView(imageView);
        linearLayout2.setTag("imageContainer");
        linearLayout.addView(linearLayout2);
        return new PageViewHolder(linearLayout);
    }

    public void onBindViewHolder(PageViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        OnboardingPageData onboardingPageData = this.pages.get(position);
        Context context = holder.itemView.getContext();
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) linearLayout.findViewWithTag("title");
        ImageView imageView = (ImageView) linearLayout.findViewWithTag("image");
        String string = context.getString(onboardingPageData.getTitleNormalResId());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
        if (locale == null) {
            locale = Locale.ENGLISH;
        }
        if (Intrinsics.areEqual(locale.getLanguage(), Locale.ENGLISH.getLanguage())) {
            String string2 = context.getString(onboardingPageData.getTitleItalicResId());
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            textView.setText(string + '\n' + string2);
        } else {
            textView.setText(string);
        }
        imageView.setImageResource(onboardingPageData.getImageResId());
    }

    public int getItemCount() {
        return this.pages.size();
    }
}
