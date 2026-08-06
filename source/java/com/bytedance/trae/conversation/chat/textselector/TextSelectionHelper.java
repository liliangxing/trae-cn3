package com.bytedance.trae.conversation.chat.textselector;

import android.os.Build;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.C0637R;
import io.noties.markwon.core.spans.StrongEmphasisSpan;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: TextSelectionHelper.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\u0002JC\u0010\u001d\u001a\u0004\u0018\u00010\u00122\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010 \u001a\u00020\u00052\u001e\u0010!\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001f0\"\"\b\u0012\u0002\b\u0003\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020\u0016J0\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J \u0010,\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J,\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*H\u0002J&\u00103\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u00020*H\u0002J&\u00104\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*H\u0002J&\u00105\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J&\u00109\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*H\u0002J&\u0010:\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*\u0018\u00010.2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*H\u0002J\u0018\u0010;\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00052\u0006\u0010<\u001a\u00020*H\u0002J\u0010\u0010=\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010>\u001a\u00020\u00072\u0006\u00107\u001a\u000208H\u0002J$\u0010?\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0.2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*H\u0002J0\u0010@\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0.2\u0006\u00101\u001a\u00020\u00052\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020*0.H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;", "", "<init>", "()V", "TAG", "", "value", "", "isEnteringSelection", "()Z", "pendingUpRunnable", "Ljava/lang/Runnable;", "pendingTextViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/widget/TextView;", "selectionActionModeAvailable", "Ljava/lang/Boolean;", "selectionActionMethod", "Ljava/lang/reflect/Method;", "editorField", "Ljava/lang/reflect/Field;", "enterSelectionMode", "", "textView", "touchX", "", "touchY", "tryReflectStartSelectionLess26", "tryReflectStartSelection", "findMethodUpHierarchy", "clazz", "Ljava/lang/Class;", "name", "paramTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "isSelectionActionModeAvailable", "cancelPendingSelection", "enterSelectionByTouch", "x", "y", "start", "", "end", "getCharIndexAtPosition", "getSelectPair", "Lkotlin/Pair;", "spannable", "Landroid/text/Spannable;", "txt", "touchIndex", "checkBold", "checkBookMark", "checkQuotation", "isQuoteChar", "c", "", "checkBracket", "checkContinuousLetterInNonLetter", "isWordChar", "index", "isNumOrLetter", "isLetter", "getSentencePair", "trimResult", "pair", "findParentRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "view", "Landroid/view/View;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TextSelectionHelper {
    public static final TextSelectionHelper INSTANCE = new TextSelectionHelper();
    private static final String TAG = "TextSelectionHelper";
    private static Field editorField;
    private static volatile boolean isEnteringSelection;
    private static WeakReference<TextView> pendingTextViewRef;
    private static Runnable pendingUpRunnable;
    private static Method selectionActionMethod;
    private static Boolean selectionActionModeAvailable;

    private final boolean isLetter(char c) {
        if ('A' <= c && c < '[') {
            return true;
        }
        return 'a' <= c && c < '{';
    }

    private final boolean isQuoteChar(char c) {
        return c == '\"' || c == 8220 || c == 8216;
    }

    private TextSelectionHelper() {
    }

    public final boolean isEnteringSelection() {
        return isEnteringSelection;
    }

    public final void enterSelectionMode(final TextView textView, final float touchX, final float touchY) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        final RecyclerView findParentRecyclerView = findParentRecyclerView(textView);
        if (findParentRecyclerView != null) {
            findParentRecyclerView.suppressLayout(true);
        }
        textView.setTextIsSelectable(true);
        textView.setFocusable(true);
        textView.setFocusableInTouchMode(true);
        textView.setHighlightColor(ContextCompat.getColor(textView.getContext(), C0637R.color.trae_text_select_highlight));
        textView.requestFocus();
        if (findParentRecyclerView != null) {
            findParentRecyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.textselector.TextSelectionHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    findParentRecyclerView.suppressLayout(false);
                }
            });
        }
        textView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.textselector.TextSelectionHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TextSelectionHelper.enterSelectionMode$lambda$1(textView, touchX, touchY);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterSelectionMode$lambda$1(TextView textView, float f, float f2) {
        boolean tryReflectStartSelection;
        CharSequence text = textView.getText();
        Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
        if (spannable == null) {
            return;
        }
        String obj = spannable.toString();
        if (obj.length() == 0) {
            return;
        }
        TextSelectionHelper textSelectionHelper = INSTANCE;
        Pair<Integer, Integer> selectPair = textSelectionHelper.getSelectPair(spannable, obj, textSelectionHelper.getCharIndexAtPosition(textView, f, f2));
        int intValue = ((Number) selectPair.component1()).intValue();
        int intValue2 = ((Number) selectPair.component2()).intValue();
        Selection.setSelection(spannable, intValue, intValue2);
        if (Build.VERSION.SDK_INT < 26) {
            tryReflectStartSelection = textSelectionHelper.tryReflectStartSelectionLess26(textView);
        } else {
            tryReflectStartSelection = textSelectionHelper.tryReflectStartSelection(textView);
        }
        if (tryReflectStartSelection) {
            return;
        }
        textSelectionHelper.enterSelectionByTouch(textView, f, f2, intValue, intValue2);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005d A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x000f, B:12:0x0017, B:13:0x001a, B:15:0x001e, B:19:0x0025, B:21:0x0029, B:24:0x003d, B:25:0x003f, B:27:0x0043, B:28:0x0046, B:30:0x004a, B:32:0x0050, B:38:0x005d, B:40:0x0061, B:43:0x0067, B:45:0x006b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0067 A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x000f, B:12:0x0017, B:13:0x001a, B:15:0x001e, B:19:0x0025, B:21:0x0029, B:24:0x003d, B:25:0x003f, B:27:0x0043, B:28:0x0046, B:30:0x004a, B:32:0x0050, B:38:0x005d, B:40:0x0061, B:43:0x0067, B:45:0x006b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean tryReflectStartSelectionLess26(TextView textView) {
        Object obj;
        boolean z;
        Class<?>[] parameterTypes;
        try {
            if (editorField == null) {
                editorField = TextView.class.getDeclaredField("mEditor");
            }
            Field field = editorField;
            if (field == null) {
                return false;
            }
            if (field != null) {
                field.setAccessible(true);
            }
            Field field2 = editorField;
            if (field2 != null && (obj = field2.get(textView)) != null) {
                if (selectionActionMethod == null) {
                    Method findMethodUpHierarchy = findMethodUpHierarchy(obj.getClass(), "startSelectionActionMode", Boolean.TYPE);
                    if (findMethodUpHierarchy == null) {
                        return false;
                    }
                    selectionActionMethod = findMethodUpHierarchy;
                }
                Method method = selectionActionMethod;
                if (method != null) {
                    method.setAccessible(true);
                }
                Method method2 = selectionActionMethod;
                if (method2 != null && (parameterTypes = method2.getParameterTypes()) != null) {
                    if (parameterTypes.length == 0) {
                        z = true;
                        if (!z) {
                            Method method3 = selectionActionMethod;
                            if (method3 != null) {
                                method3.invoke(obj, new Object[0]);
                            }
                        } else {
                            Method method4 = selectionActionMethod;
                            if (method4 != null) {
                                method4.invoke(obj, false);
                            }
                        }
                        return true;
                    }
                }
                z = false;
                if (!z) {
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005d A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x000f, B:12:0x0017, B:13:0x001a, B:15:0x001e, B:19:0x0025, B:21:0x0029, B:24:0x003d, B:25:0x003f, B:27:0x0043, B:28:0x0046, B:30:0x004a, B:32:0x0050, B:38:0x005d, B:40:0x0061, B:43:0x0067, B:45:0x006b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0067 A[Catch: all -> 0x0078, TryCatch #0 {all -> 0x0078, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x000f, B:12:0x0017, B:13:0x001a, B:15:0x001e, B:19:0x0025, B:21:0x0029, B:24:0x003d, B:25:0x003f, B:27:0x0043, B:28:0x0046, B:30:0x004a, B:32:0x0050, B:38:0x005d, B:40:0x0061, B:43:0x0067, B:45:0x006b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean tryReflectStartSelection(TextView textView) {
        Object obj;
        boolean z;
        Class<?>[] parameterTypes;
        try {
            if (editorField == null) {
                editorField = TextView.class.getDeclaredField("mEditor");
            }
            Field field = editorField;
            if (field == null) {
                return false;
            }
            if (field != null) {
                field.setAccessible(true);
            }
            Field field2 = editorField;
            if (field2 != null && (obj = field2.get(textView)) != null) {
                if (selectionActionMethod == null) {
                    Method findMethodUpHierarchy = findMethodUpHierarchy(obj.getClass(), "startSelectionActionModeAsync", Boolean.TYPE);
                    if (findMethodUpHierarchy == null) {
                        return false;
                    }
                    selectionActionMethod = findMethodUpHierarchy;
                }
                Method method = selectionActionMethod;
                if (method != null) {
                    method.setAccessible(true);
                }
                Method method2 = selectionActionMethod;
                if (method2 != null && (parameterTypes = method2.getParameterTypes()) != null) {
                    if (parameterTypes.length == 0) {
                        z = true;
                        if (!z) {
                            Method method3 = selectionActionMethod;
                            if (method3 != null) {
                                method3.invoke(obj, new Object[0]);
                            }
                        } else {
                            Method method4 = selectionActionMethod;
                            if (method4 != null) {
                                method4.invoke(obj, false);
                            }
                        }
                        return true;
                    }
                }
                z = false;
                if (!z) {
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final Method findMethodUpHierarchy(Class<?> clazz, String name, Class<?>... paramTypes) {
        while (clazz != null) {
            try {
                Result.Companion companion = Result.Companion;
                TextSelectionHelper textSelectionHelper = this;
                return clazz.getDeclaredMethod(name, (Class[]) Arrays.copyOf(paramTypes, paramTypes.length));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                try {
                    Result.Companion companion3 = Result.Companion;
                    Class<?> cls = clazz;
                    return clazz.getDeclaredMethod(name, new Class[0]);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th2));
                    clazz = clazz.getSuperclass();
                }
            }
        }
        return null;
    }

    public final boolean isSelectionActionModeAvailable() {
        Boolean bool = selectionActionModeAvailable;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
        } catch (Throwable th) {
            Log.e(TAG, "isSelectionActionModeAvailable", th);
        }
        if (TextView.class.getDeclaredField("mEditor") == null) {
            return false;
        }
        Class<?> cls = Class.forName("android.widget.Editor");
        String str = Build.VERSION.SDK_INT < 26 ? "startSelectionActionMode" : "startSelectionActionModeAsync";
        Intrinsics.checkNotNull(cls);
        if (findMethodUpHierarchy(cls, str, Boolean.TYPE) != null) {
            z = true;
        }
        selectionActionModeAvailable = Boolean.valueOf(z);
        return z;
    }

    public final void cancelPendingSelection() {
        Runnable runnable = pendingUpRunnable;
        WeakReference<TextView> weakReference = pendingTextViewRef;
        TextView textView = weakReference != null ? weakReference.get() : null;
        if (runnable != null && textView != null) {
            textView.removeCallbacks(runnable);
        }
        pendingUpRunnable = null;
        pendingTextViewRef = null;
        isEnteringSelection = false;
    }

    private final void enterSelectionByTouch(TextView textView, final float x, final float y, final int start, final int end) {
        cancelPendingSelection();
        isEnteringSelection = true;
        final WeakReference<TextView> weakReference = new WeakReference<>(textView);
        pendingTextViewRef = weakReference;
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.chat.textselector.TextSelectionHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TextSelectionHelper.enterSelectionByTouch$lambda$9(weakReference, x, y, start, end);
            }
        };
        pendingUpRunnable = runnable;
        textView.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enterSelectionByTouch$lambda$9(WeakReference weakReference, float f, float f2, int i, int i2) {
        pendingUpRunnable = null;
        pendingTextViewRef = null;
        TextView textView = (TextView) weakReference.get();
        boolean z = false;
        if (textView != null) {
            if (!textView.isAttachedToWindow()) {
                textView = null;
            }
            if (textView != null) {
                textView.performLongClick(f, f2);
                CharSequence text = textView.getText();
                Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
                if (spannable != null) {
                    if (i >= 0 && i <= spannable.length()) {
                        if (i <= i2 && i2 <= spannable.length()) {
                            z = true;
                        }
                        if (z && i != i2) {
                            Selection.setSelection(spannable, i, i2);
                        }
                    }
                }
                textView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.textselector.TextSelectionHelper$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        TextSelectionHelper.isEnteringSelection = false;
                    }
                });
                return;
            }
        }
        isEnteringSelection = false;
    }

    private final int getCharIndexAtPosition(TextView textView, float touchX, float touchY) {
        Layout layout = textView.getLayout();
        if (layout == null) {
            return 0;
        }
        return layout.getOffsetForHorizontal(layout.getLineForVertical((int) RangesKt.coerceIn(touchY - textView.getTotalPaddingTop(), 0.0f, (textView.getHeight() - textView.getTotalPaddingTop()) - textView.getTotalPaddingBottom())), RangesKt.coerceIn(touchX - textView.getTotalPaddingLeft(), 0.0f, (textView.getWidth() - textView.getTotalPaddingLeft()) - textView.getTotalPaddingRight()));
    }

    private final Pair<Integer, Integer> getSelectPair(Spannable spannable, String txt, int touchIndex) {
        int coerceIn = RangesKt.coerceIn(touchIndex, 0, txt.length() - 1);
        Pair<Integer, Integer> checkBold = checkBold(spannable, coerceIn);
        if (checkBold != null) {
            return checkBold;
        }
        Pair<Integer, Integer> checkBookMark = checkBookMark(txt, coerceIn);
        if (checkBookMark != null) {
            return INSTANCE.trimResult(txt, checkBookMark);
        }
        Pair<Integer, Integer> checkQuotation = checkQuotation(txt, coerceIn);
        if (checkQuotation != null) {
            return INSTANCE.trimResult(txt, checkQuotation);
        }
        Pair<Integer, Integer> checkBracket = checkBracket(txt, coerceIn);
        if (checkBracket != null) {
            return INSTANCE.trimResult(txt, checkBracket);
        }
        Pair<Integer, Integer> checkContinuousLetterInNonLetter = checkContinuousLetterInNonLetter(txt, coerceIn);
        return checkContinuousLetterInNonLetter != null ? INSTANCE.trimResult(txt, checkContinuousLetterInNonLetter) : trimResult(txt, getSentencePair(txt, coerceIn));
    }

    private final Pair<Integer, Integer> checkBold(Spannable spannable, int touchIndex) {
        Iterator it = ArrayIteratorKt.iterator((StrongEmphasisSpan[]) spannable.getSpans(0, spannable.length(), StrongEmphasisSpan.class));
        while (it.hasNext()) {
            StrongEmphasisSpan strongEmphasisSpan = (StrongEmphasisSpan) it.next();
            int spanStart = spannable.getSpanStart(strongEmphasisSpan);
            int spanEnd = spannable.getSpanEnd(strongEmphasisSpan);
            if (spanStart <= touchIndex && touchIndex < spanEnd) {
                return TuplesKt.to(Integer.valueOf(spanStart), Integer.valueOf(spanEnd));
            }
        }
        return null;
    }

    private final Pair<Integer, Integer> checkBookMark(String txt, int touchIndex) {
        int i = touchIndex;
        while (i > 0 && txt.charAt(i) != 12298 && txt.charAt(i) != 12299) {
            if (txt.charAt(i) == '\n') {
                return null;
            }
            i--;
        }
        if (txt.charAt(i) != 12298) {
            return null;
        }
        while (touchIndex < txt.length() - 1 && txt.charAt(touchIndex) != 12298 && txt.charAt(touchIndex) != 12299) {
            if (txt.charAt(touchIndex) == '\n') {
                return null;
            }
            touchIndex++;
        }
        if (txt.charAt(touchIndex) != 12299) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(i + 1), Integer.valueOf(touchIndex));
    }

    private final Pair<Integer, Integer> checkQuotation(String txt, int touchIndex) {
        Object obj;
        char c = '\"';
        List listOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to('\"', '\"'), TuplesKt.to((char) 8220, (char) 8221), TuplesKt.to((char) 8216, (char) 8217)});
        int i = touchIndex;
        while (i > 0 && !isQuoteChar(txt.charAt(i))) {
            if (txt.charAt(i) == '\n') {
                return null;
            }
            i--;
        }
        char charAt = txt.charAt(i);
        Iterator it = listOf.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Character) ((Pair) obj).getFirst()).charValue() == charAt) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            c = ((Character) pair.getSecond()).charValue();
        } else if (charAt != '\"') {
            return null;
        }
        while (touchIndex < txt.length() - 1 && txt.charAt(touchIndex) != c) {
            if (txt.charAt(touchIndex) == '\n') {
                return null;
            }
            touchIndex++;
        }
        if (txt.charAt(touchIndex) == c && i != touchIndex) {
            return TuplesKt.to(Integer.valueOf(i + 1), Integer.valueOf(touchIndex));
        }
        return null;
    }

    private final Pair<Integer, Integer> checkBracket(String txt, int touchIndex) {
        Character ch;
        List listOf = CollectionsKt.listOf(new Character[]{'(', (char) 65288});
        Map mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to('(', ')'), TuplesKt.to((char) 65288, (char) 65289)});
        int i = touchIndex;
        while (i > 0 && !listOf.contains(Character.valueOf(txt.charAt(i))) && txt.charAt(i) != ')' && txt.charAt(i) != 65289) {
            if (txt.charAt(i) == '\n') {
                return null;
            }
            i--;
        }
        if (!listOf.contains(Character.valueOf(txt.charAt(i))) || (ch = (Character) mapOf.get(Character.valueOf(txt.charAt(i)))) == null) {
            return null;
        }
        char charValue = ch.charValue();
        while (touchIndex < txt.length() - 1 && txt.charAt(touchIndex) != charValue) {
            if (txt.charAt(touchIndex) == '\n') {
                return null;
            }
            touchIndex++;
        }
        if (txt.charAt(touchIndex) != charValue) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(i + 1), Integer.valueOf(touchIndex));
    }

    private final Pair<Integer, Integer> checkContinuousLetterInNonLetter(String txt, int touchIndex) {
        if (!isNumOrLetter(txt.charAt(touchIndex))) {
            return null;
        }
        boolean isLetter = isLetter(txt.charAt(touchIndex));
        int i = touchIndex;
        while (i > 0 && isWordChar(txt, i - 1)) {
            i--;
            if (isLetter(txt.charAt(i))) {
                isLetter = true;
            }
        }
        while (touchIndex < txt.length() - 1) {
            int i2 = touchIndex + 1;
            if (!isWordChar(txt, i2)) {
                break;
            }
            if (isLetter(txt.charAt(i2))) {
                isLetter = true;
            }
            touchIndex = i2;
        }
        if (isLetter) {
            return TuplesKt.to(Integer.valueOf(i), Integer.valueOf(touchIndex + 1));
        }
        return null;
    }

    private final boolean isWordChar(String txt, int index) {
        if (index >= 0 && index < txt.length()) {
            char charAt = txt.charAt(index);
            if (isNumOrLetter(charAt) || CollectionsKt.listOf(new Character[]{' ', '/', '-', '%', (char) 8240}).contains(Character.valueOf(charAt))) {
                return true;
            }
            if ((charAt == ',' || charAt == '.') && index > 0 && index < txt.length() - 1) {
                char charAt2 = txt.charAt(index - 1);
                char charAt3 = txt.charAt(index + 1);
                if (charAt == '.' && isLetter(charAt2) && isLetter(charAt3)) {
                    return true;
                }
                if (Character.isDigit(charAt2) && Character.isDigit(charAt3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isNumOrLetter(char c) {
        return Character.isDigit(c) || isLetter(c);
    }

    private final Pair<Integer, Integer> getSentencePair(String txt, int touchIndex) {
        Set of = SetsKt.setOf(new Character[]{(char) 12290, (char) 65281, (char) 65311, '.', '!', '?', '\n'});
        int i = touchIndex;
        while (i > 0 && !of.contains(Character.valueOf(txt.charAt(i - 1)))) {
            i--;
        }
        while (touchIndex < txt.length() && !of.contains(Character.valueOf(txt.charAt(touchIndex)))) {
            touchIndex++;
        }
        if (touchIndex < txt.length() && of.contains(Character.valueOf(txt.charAt(touchIndex)))) {
            touchIndex++;
        }
        return TuplesKt.to(Integer.valueOf(i), Integer.valueOf(touchIndex));
    }

    private final Pair<Integer, Integer> trimResult(String txt, Pair<Integer, Integer> pair) {
        String str;
        if (((Number) pair.getFirst()).intValue() >= ((Number) pair.getSecond()).intValue() || ((Number) pair.getFirst()).intValue() < 0 || ((Number) pair.getSecond()).intValue() > txt.length()) {
            return TuplesKt.to(0, Integer.valueOf(txt.length()));
        }
        String substring = txt.substring(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        int intValue = ((Number) pair.getFirst()).intValue();
        int length = substring.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                str = substring;
                break;
            }
            if (!CharsKt.isWhitespace(substring.charAt(i))) {
                str = substring.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                break;
            }
            i++;
        }
        int length2 = intValue + str.length();
        int intValue2 = ((Number) pair.getSecond()).intValue();
        int lastIndex = StringsKt.getLastIndex(substring);
        while (true) {
            if (-1 >= lastIndex) {
                break;
            }
            if (!CharsKt.isWhitespace(substring.charAt(lastIndex))) {
                substring = substring.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                break;
            }
            lastIndex--;
        }
        int length3 = intValue2 - substring.length();
        return length2 < length3 ? TuplesKt.to(Integer.valueOf(length2), Integer.valueOf(length3)) : pair;
    }

    private final RecyclerView findParentRecyclerView(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof RecyclerView) {
                return (RecyclerView) parent;
            }
        }
        return null;
    }
}
