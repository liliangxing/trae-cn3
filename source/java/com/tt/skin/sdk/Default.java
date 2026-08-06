package com.tt.skin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.article.night.webview.IWebViewNightModeHelper;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tt.skin.sdk.api.ISkinChangeListener;
import com.tt.skin.sdk.api.ISkinListenerInterceptor;
import com.tt.skin.sdk.api.ISkinStatusInterceptor;
import com.tt.skin.sdk.api.ISkinViewInterceptor;
import com.tt.skin.sdk.api.ISkinWebViewInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Default.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/tt/skin/sdk/Default;", "", "()V", "DEFAULT_LISTENER_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;", "getDEFAULT_LISTENER_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinListenerInterceptor;", "DEFAULT_STATUS_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "getDEFAULT_STATUS_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinStatusInterceptor;", "DEFAULT_VIEW_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "getDEFAULT_VIEW_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinViewInterceptor;", "DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR", "Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR", "()Lcom/tt/skin/sdk/api/ISkinWebViewInterceptor;", "context", "", "cb", "Lkotlin/Function1;", "Landroid/content/Context;", "api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class Default {
    public static final Default INSTANCE = new Default();
    private static final ISkinListenerInterceptor DEFAULT_LISTENER_INTERCEPTOR = new ISkinListenerInterceptor() { // from class: com.tt.skin.sdk.Default$DEFAULT_LISTENER_INTERCEPTOR$1
        @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
        public void addLifeCycleSkinChangeListener(LifecycleOwner lifecycleOwner, ISkinChangeListener listener) {
            Intrinsics.checkParameterIsNotNull(lifecycleOwner, "lifecycleOwner");
        }

        @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
        public void addSkinChangeListener(ISkinChangeListener listener) {
        }

        @Override // com.tt.skin.sdk.api.ISkinListenerInterceptor
        public void removeSkinChangeListener(ISkinChangeListener listener) {
        }
    };
    private static final ISkinStatusInterceptor DEFAULT_STATUS_INTERCEPTOR = new ISkinStatusInterceptor() { // from class: com.tt.skin.sdk.Default$DEFAULT_STATUS_INTERCEPTOR$1
        @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
        public boolean inWhiteList(Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
            return false;
        }

        @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
        public boolean isCurPageNightMode(Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
            return false;
        }

        @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
        public boolean isDarkMode() {
            return false;
        }

        @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
        public boolean isDetailPageCssReady() {
            return false;
        }

        @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
        public boolean isIgnoreActivity(Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
            return false;
        }

        @Override // com.tt.skin.sdk.api.ISkinStatusInterceptor
        public boolean isJSReader() {
            return false;
        }
    };
    private static final ISkinViewInterceptor DEFAULT_VIEW_INTERCEPTOR = new ISkinViewInterceptor() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1
        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void ignoreActivity(Activity activity) {
            Intrinsics.checkParameterIsNotNull(activity, RXScreenCaptureService.KEY_LAUNCH_ACTIVITY);
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void refreshView(View view) {
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void refreshView(View view, boolean mustMainThread) {
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void registerViewOnSkinChangeListener(View view, Function1<? super Boolean, Unit> callback) {
            Intrinsics.checkParameterIsNotNull(callback, "callback");
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void resetViewIgnore(View view) {
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setViewIgnore(View view) {
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setTextColor(final TextView textView, final int colorRes) {
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$setTextColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        textView2.setTextColor(context.getResources().getColor(colorRes));
                    }
                }
            });
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setTextColor(final TextView textView, final int colorRes, boolean useColorStateList) {
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$setTextColor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        textView2.setTextColor(context.getResources().getColorStateList(colorRes));
                    }
                }
            });
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setHintTextColor(final TextView textView, final int colorRes) {
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$setHintTextColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        textView2.setHintTextColor(context.getResources().getColor(colorRes));
                    }
                }
            });
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setColorFilter(final ImageView imageView, final int colorRes) {
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$setColorFilter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    ImageView imageView2 = imageView;
                    if (imageView2 != null) {
                        imageView2.setColorFilter(context.getResources().getColor(colorRes));
                    }
                }
            });
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setHintTextColor(final TextView textView, final int colorRes, boolean useColorStateList) {
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$setHintTextColor$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    TextView textView2 = textView;
                    if (textView2 != null) {
                        textView2.setHintTextColor(context.getResources().getColorStateList(colorRes));
                    }
                }
            });
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public void setBackgroundColor(final View view, final int colorRes) {
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$setBackgroundColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    View view2 = view;
                    if (view2 != null) {
                        view2.setBackgroundColor(context.getResources().getColor(colorRes));
                    }
                }
            });
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public ColorStateList refreshNewColorStateList(final int colorStateListRes) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$refreshNewColorStateList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    objectRef.element = context.getResources().getColorStateList(colorStateListRes);
                }
            });
            return (ColorStateList) objectRef.element;
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public int refreshNewColor(final int colorRes) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$refreshNewColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    intRef.element = context.getResources().getColor(colorRes);
                }
            });
            return intRef.element;
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public ColorStateList getColorStateListFromSkinResource(final int colorRes) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$getColorStateListFromSkinResource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    objectRef.element = context.getResources().getColorStateList(colorRes);
                }
            });
            return (ColorStateList) objectRef.element;
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public int getColorFromSkinResource(final int colorRes) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$getColorFromSkinResource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    intRef.element = context.getResources().getColor(colorRes);
                }
            });
            return intRef.element;
        }

        @Override // com.tt.skin.sdk.api.ISkinViewInterceptor
        public Drawable getDrawableFromSkinResource(final int drawableRes) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            Default.INSTANCE.context(new Function1<Context, Unit>() { // from class: com.tt.skin.sdk.Default$DEFAULT_VIEW_INTERCEPTOR$1$getDrawableFromSkinResource$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Context) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context) {
                    Intrinsics.checkParameterIsNotNull(context, "it");
                    objectRef.element = context.getResources().getDrawable(drawableRes);
                }
            });
            return (Drawable) objectRef.element;
        }
    };
    private static final ISkinWebViewInterceptor DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR = new ISkinWebViewInterceptor() { // from class: com.tt.skin.sdk.Default$DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR$1
        @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
        public IWebViewNightModeHelper getNightModeHelper(WebView webView) {
            return null;
        }

        @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
        public IWebViewNightModeHelper judgeWebViewNightMode(LifecycleOwner lifecycleOwner, WebView webView) {
            return null;
        }

        @Override // com.tt.skin.sdk.api.ISkinWebViewInterceptor
        public IWebViewNightModeHelper judgeWebViewNightMode(LifecycleOwner lifecycleOwner, WebView webView, boolean isDetailPage) {
            return null;
        }
    };

    private Default() {
    }

    public final void context(Function1<? super Context, Unit> cb) {
        Intrinsics.checkParameterIsNotNull(cb, "cb");
        Context context = SkinManagerAdapter.INSTANCE.getContext();
        if (context != null) {
            cb.invoke(context);
        }
    }

    public final ISkinListenerInterceptor getDEFAULT_LISTENER_INTERCEPTOR() {
        return DEFAULT_LISTENER_INTERCEPTOR;
    }

    public final ISkinStatusInterceptor getDEFAULT_STATUS_INTERCEPTOR() {
        return DEFAULT_STATUS_INTERCEPTOR;
    }

    public final ISkinViewInterceptor getDEFAULT_VIEW_INTERCEPTOR() {
        return DEFAULT_VIEW_INTERCEPTOR;
    }

    public final ISkinWebViewInterceptor getDEFAULT_WEBVIEW_NIGHT_INTERCEPTOR() {
        return DEFAULT_WEBVIEW_NIGHT_INTERCEPTOR;
    }
}
