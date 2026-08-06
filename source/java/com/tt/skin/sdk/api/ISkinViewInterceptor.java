package com.tt.skin.sdk.api;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ISkinViewInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J(\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0018H&J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u001c\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J\u001c\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J$\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0015H&J\u001c\u0010\"\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010\u0004\u001a\u00020\u0003H&J$\u0010\"\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0015H&J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¨\u0006$"}, d2 = {"Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "", "getColorFromSkinResource", "", "colorRes", "getColorStateListFromSkinResource", "Landroid/content/res/ColorStateList;", "getDrawableFromSkinResource", "Landroid/graphics/drawable/Drawable;", "drawableRes", "ignoreActivity", "", "activity", "Landroid/app/Activity;", "refreshNewColor", "refreshNewColorStateList", "colorStateListRes", "refreshView", "view", "Landroid/view/View;", "mustMainThread", "", "registerViewOnSkinChangeListener", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "resetViewIgnore", "setBackgroundColor", "setColorFilter", "imageView", "Landroid/widget/ImageView;", "setHintTextColor", "textView", "Landroid/widget/TextView;", "useColorStateList", "setTextColor", "setViewIgnore", "api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public interface ISkinViewInterceptor {
    int getColorFromSkinResource(int colorRes);

    ColorStateList getColorStateListFromSkinResource(int colorRes);

    Drawable getDrawableFromSkinResource(int drawableRes);

    void ignoreActivity(Activity activity);

    int refreshNewColor(int colorRes);

    ColorStateList refreshNewColorStateList(int colorStateListRes);

    void refreshView(View view);

    void refreshView(View view, boolean mustMainThread);

    void registerViewOnSkinChangeListener(View view, Function1<? super Boolean, Unit> callback);

    void resetViewIgnore(View view);

    void setBackgroundColor(View view, int colorRes);

    void setColorFilter(ImageView imageView, int colorRes);

    void setHintTextColor(TextView textView, int colorRes);

    void setHintTextColor(TextView textView, int colorRes, boolean useColorStateList);

    void setTextColor(TextView textView, int colorRes);

    void setTextColor(TextView textView, int colorRes, boolean useColorStateList);

    void setViewIgnore(View view);
}
