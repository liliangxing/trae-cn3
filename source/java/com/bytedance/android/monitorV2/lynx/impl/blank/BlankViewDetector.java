package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.monitorV2.lynx.impl.LynxProxy;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.ui.image.FlattenUIImage;
import com.lynx.tasm.ui.image.UIFilterImage;
import com.lynx.tasm.ui.image.UIImage;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlankViewDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002JP\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020!Jb\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020!0&26\u0010'\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00110(H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020!H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R!\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006/"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewDetector;", "", "()V", "xAlphaVideo", "Ljava/lang/Class;", "getXAlphaVideo", "()Ljava/lang/Class;", "xAlphaVideo$delegate", "Lkotlin/Lazy;", "xVideoPro", "getXVideoPro", "xVideoPro$delegate", "checkDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "checkLynxView", "", "view", "Lcom/lynx/tasm/LynxView;", "viewPrj", "Lcom/bytedance/android/monitorV2/lynx/impl/blank/BlankViewRegionChecker;", SlardarSettingsConsts.PERF_KEY_UI, "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "startX", "startY", "left", "top", "right", "bottom", "checkXElement", "detect", "projMap", "Landroid/view/View;", "getOverlayLynxView", "rectTarget", "Landroid/graphics/Rect;", "visitedViews", "", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "bound", "getViewBoundInWindow", "isInvisible", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BlankViewDetector {
    public static final BlankViewDetector INSTANCE = new BlankViewDetector();

    /* renamed from: xVideoPro$delegate, reason: from kotlin metadata */
    private static final Lazy xVideoPro = LazyKt.lazy(new Function0<Class<?>>() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankViewDetector$xVideoPro$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Class<?> m373invoke() {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Class.forName("com.bytedance.ies.xelement.video.pro.LynxVideoUI"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            return (Class) obj;
        }
    });

    /* renamed from: xAlphaVideo$delegate, reason: from kotlin metadata */
    private static final Lazy xAlphaVideo = LazyKt.lazy(new Function0<Class<?>>() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankViewDetector$xAlphaVideo$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Class<?> m372invoke() {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Class.forName("com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            return (Class) obj;
        }
    });

    private BlankViewDetector() {
    }

    private final Class<?> getXVideoPro() {
        return (Class) xVideoPro.getValue();
    }

    private final Class<?> getXAlphaVideo() {
        return (Class) xAlphaVideo.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getOverlayLynxView$default(BlankViewDetector blankViewDetector, View view, Rect rect, Set set, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            rect = blankViewDetector.getViewBoundInWindow(view);
        }
        if ((i & 4) != 0) {
            set = new HashSet();
        }
        blankViewDetector.getOverlayLynxView(view, rect, set, function2);
    }

    private final void getOverlayLynxView(View view, Rect rectTarget, Set<View> visitedViews, Function2<? super LynxView, ? super Rect, Unit> cb) {
        if (view.getVisibility() != 0 || visitedViews.contains(view)) {
            return;
        }
        visitedViews.add(view);
        if (view instanceof LynxView) {
            Rect viewBoundInWindow = getViewBoundInWindow(view);
            if (Rect.intersects(rectTarget, viewBoundInWindow) || rectTarget.contains(viewBoundInWindow)) {
                cb.invoke(view, viewBoundInWindow);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
                getOverlayLynxView(childAt, rectTarget, visitedViews, cb);
            }
        }
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            getOverlayLynxView((View) parent, rectTarget, visitedViews, cb);
        }
    }

    private final Rect getViewBoundInWindow(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
    }

    public final void detect(final BlankViewRegionChecker projMap, View view) {
        Object obj;
        Intrinsics.checkNotNullParameter(projMap, "projMap");
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Result.Companion companion = Result.Companion;
            BlankViewDetector blankViewDetector = this;
            final Rect viewBoundInWindow = getViewBoundInWindow(view);
            getOverlayLynxView$default(this, view, viewBoundInWindow, null, new Function2<LynxView, Rect, Unit>() { // from class: com.bytedance.android.monitorV2.lynx.impl.blank.BlankViewDetector$detect$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((LynxView) obj2, (Rect) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(LynxView lynxView, Rect rect) {
                    Intrinsics.checkNotNullParameter(lynxView, "v");
                    Intrinsics.checkNotNullParameter(rect, "bound");
                    int i = rect.left - viewBoundInWindow.left;
                    int i2 = rect.top - viewBoundInWindow.top;
                    BlankViewDetector blankViewDetector2 = this;
                    BlankViewRegionChecker blankViewRegionChecker = projMap;
                    LynxBaseUI lynxUIRoot = lynxView.getLynxUIRoot();
                    Intrinsics.checkNotNullExpressionValue(lynxUIRoot, "v.lynxUIRoot");
                    blankViewDetector2.checkLynxView(lynxView, blankViewRegionChecker, lynxUIRoot, 0, 0, i + 0, i2 + 0, i + lynxView.getWidth(), i2 + lynxView.getHeight());
                }
            }, 4, null);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            String simpleName = view.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "view.javaClass.simpleName");
            projMap.mark(0, 0, width, height, 1, simpleName, false);
            ExceptionUtil.handleException(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x010a, code lost:
    
        if ((r0.length() > 0 ? 1 : 0) != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010d, code lost:
    
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0128, code lost:
    
        if ((r0.length() > 0 ? 1 : 0) != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0206, code lost:
    
        if ((r0.length() > 0 ? 1 : 0) != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0225, code lost:
    
        if (r4.hasContent(r0) != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkLynxView(LynxView view, BlankViewRegionChecker viewPrj, LynxBaseUI ui, int startX, int startY, int left, int top, int right, int bottom) {
        String str;
        int checkDrawable;
        int i;
        int i2;
        int i3;
        if (isInvisible(ui)) {
            return;
        }
        if (ui.getChildren().size() > 0) {
            int checkDrawable2 = checkDrawable((Drawable) ui.getLynxBackground().getDrawable());
            String simpleName = ui.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "ui.javaClass.simpleName");
            viewPrj.mark(left, top, right, bottom, checkDrawable2, simpleName, false);
            int size = ui.getChildren().size();
            while (r8 < size) {
                LynxBaseUI childAt = ui.getChildAt(r8);
                if (childAt != null) {
                    int left2 = childAt.getLeft();
                    int top2 = childAt.getTop();
                    if (LynxProxy.INSTANCE.getGetOriginLeft().exist()) {
                        left2 = childAt.getOriginLeft();
                        top2 = childAt.getOriginTop();
                    }
                    int i4 = startX + left2;
                    int translationX = ((int) childAt.getTranslationX()) + (i4 - ui.getScrollX());
                    int i5 = startY + top2;
                    int translationY = ((int) childAt.getTranslationY()) + (i5 - ui.getScrollY());
                    int width = ((i4 + childAt.getWidth()) - ui.getScrollX()) + ((int) childAt.getTranslationX());
                    int height = ((i5 + childAt.getHeight()) - ui.getScrollY()) + ((int) childAt.getTranslationY());
                    if (translationX < right && translationY < bottom && width > left && height > top && translationX < width && translationY < height) {
                        i2 = r8;
                        i3 = size;
                        checkLynxView(view, viewPrj, childAt, translationX, translationY, Math.max(left, translationX), Math.max(top, translationY), Math.min(right, width), Math.min(bottom, height));
                        r8 = i2 + 1;
                        size = i3;
                    }
                }
                i2 = r8;
                i3 = size;
                r8 = i2 + 1;
                size = i3;
            }
            return;
        }
        if (ui instanceof UIText) {
            CharSequence text = ((UIText) ui).getView().getText();
            Intrinsics.checkNotNullExpressionValue(text, "ui.view.text");
        } else if (ui instanceof FlattenUIText) {
            CharSequence text2 = ((FlattenUIText) ui).getText();
            Intrinsics.checkNotNullExpressionValue(text2, "ui.text");
        } else if (ui instanceof UIFilterImage) {
            UIFilterImage uIFilterImage = (UIFilterImage) ui;
            if (TextUtils.isEmpty(uIFilterImage.getView().getSrc())) {
                checkDrawable = checkDrawable((Drawable) uIFilterImage.getLynxBackground().getDrawable());
                i = checkDrawable;
            }
            i = 1;
        } else if (ui instanceof UIImage) {
            UIImage uIImage = (UIImage) ui;
            if (TextUtils.isEmpty(uIImage.getView().getSrc())) {
                checkDrawable = checkDrawable((Drawable) uIImage.getLynxBackground().getDrawable());
                i = checkDrawable;
            }
            i = 1;
        } else {
            if (ui instanceof FlattenUIImage) {
                try {
                    Field declaredField = FlattenUIImage.class.getDeclaredField("mSources");
                    declaredField.setAccessible(true);
                    str = (String) declaredField.get(ui);
                } catch (Exception unused) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    checkDrawable = checkDrawable(((FlattenUIImage) ui).getImageDrawable());
                } else {
                    checkDrawable = checkDrawable((Drawable) ((FlattenUIImage) ui).getLynxBackground().getDrawable());
                }
            } else if (ui instanceof LynxUI) {
                LynxUI lynxUI = (LynxUI) ui;
                if (lynxUI.getView() instanceof ImageView) {
                    View view2 = lynxUI.getView();
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.widget.ImageView");
                    checkDrawable = checkDrawable(((ImageView) view2).getDrawable());
                } else if (lynxUI.getView() instanceof TextView) {
                    View view3 = lynxUI.getView();
                    Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.TextView");
                    CharSequence text3 = ((TextView) view3).getText();
                    Intrinsics.checkNotNullExpressionValue(text3, "ui.view as TextView).text");
                } else if (lynxUI.getView() instanceof TextureView) {
                    BlankCanvasDetector blankCanvasDetector = new BlankCanvasDetector();
                    View view4 = lynxUI.getView();
                    Intrinsics.checkNotNullExpressionValue(view4, "ui.view");
                } else if (lynxUI.getView().getBackground() != null) {
                    checkDrawable = checkDrawable(lynxUI.getView().getBackground());
                } else {
                    try {
                        r8 = checkXElement(ui);
                    } catch (Throwable unused2) {
                    }
                    i = r8;
                }
            } else {
                if (ui instanceof LynxFlattenUI) {
                    LynxFlattenUI lynxFlattenUI = (LynxFlattenUI) ui;
                    if (lynxFlattenUI.getLynxBackground() != null) {
                        checkDrawable = checkDrawable((Drawable) lynxFlattenUI.getLynxBackground().getDrawable());
                    }
                }
                i = r8;
            }
            i = checkDrawable;
        }
        String simpleName2 = ui.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName2, "ui.javaClass.simpleName");
        viewPrj.mark(left, top, right, bottom, i, simpleName2, true);
    }

    private final boolean isInvisible(LynxBaseUI ui) {
        if (ui instanceof LynxUI) {
            if (((LynxUI) ui).getView().getVisibility() == 0 && r8.getAlpha() >= 0.05d && r8.getScaleX() >= 0.01d && r8.getScaleY() >= 0.01d) {
                return false;
            }
        } else {
            if (!(ui instanceof LynxFlattenUI)) {
                return true;
            }
            if (((LynxFlattenUI) ui).getAlpha() >= 0.05d) {
                return false;
            }
        }
        return true;
    }

    private final int checkDrawable(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        return (!new BlankCanvasDetector().hasContent(drawable) ? 1 : 0) ^ 1;
    }

    private final int checkXElement(LynxBaseUI ui) {
        Class<?> xVideoPro2 = getXVideoPro();
        if (xVideoPro2 != null) {
            if (!xVideoPro2.isAssignableFrom(ui.getClass())) {
                xVideoPro2 = null;
            }
            if (xVideoPro2 != null) {
                Field declaredField = ui.getClass().getDeclaredField("mSrc");
                declaredField.setAccessible(true);
                return !TextUtils.isEmpty((String) declaredField.get(ui)) ? 1 : 0;
            }
        }
        Class<?> xAlphaVideo2 = getXAlphaVideo();
        if (xAlphaVideo2 == null) {
            return 0;
        }
        if ((xAlphaVideo2.isAssignableFrom(ui.getClass()) ? xAlphaVideo2 : null) == null) {
            return 0;
        }
        Field declaredField2 = ui.getClass().getDeclaredField("mResourceURL");
        declaredField2.setAccessible(true);
        return !TextUtils.isEmpty((String) declaredField2.get(ui)) ? 1 : 0;
    }
}
