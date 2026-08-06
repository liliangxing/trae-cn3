package com.bytedance.android.livesdk.pannel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.livesdk.pannel.SheetPullUpProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetBaseBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000 .*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0003./0B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0012J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020+H\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "()V", "view", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isHideAble", "", "()Z", "setHideAble", "(Z)V", "mCallback", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$SheetCallback;", "getMCallback", "()Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$SheetCallback;", "setMCallback", "(Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$SheetCallback;)V", "pullUpProcessor", "Lcom/bytedance/android/livesdk/pannel/SheetPullUpProcessor;", "skipCollapsed", "getSkipCollapsed", "setSkipCollapsed", "slideProcessor", "Lcom/bytedance/android/livesdk/pannel/SheetSlideProcessor;", "findFirstId", "", "parent", "Landroid/view/ViewGroup;", "findScrollingChild", "getCurrentView", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "setBottomSheetCallback", "", "callback", "setPeekHeight", "peekHeight", "", "setState", StrategyConstants.STATE, "Companion", "SheetCallback", "State", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class SheetBaseBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float HIDE_FRICTION = 0.1f;
    public static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private boolean isHideAble;
    private SheetCallback mCallback;
    public SheetPullUpProcessor pullUpProcessor;
    private boolean skipCollapsed;
    public SheetSlideProcessor slideProcessor;

    /* compiled from: SheetBaseBehavior.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$SheetCallback;", "", "onSlide", "", "var1", "Landroid/view/View;", "var2", "", "onStateChanged", "", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface SheetCallback {
        void onSlide(View var1, float var2);

        void onStateChanged(View var1, int var2);
    }

    /* compiled from: SheetBaseBehavior.kt */
    @Retention(RetentionPolicy.SOURCE)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$State;", "", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public @interface State {
    }

    public void setPeekHeight(int peekHeight) {
    }

    public void setState(int state) {
    }

    /* compiled from: SheetBaseBehavior.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f\"\n\b\u0001\u0010\u0010*\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u0002H\u0010¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$Companion;", "", "()V", "HIDE_FRICTION", "", "HIDE_THRESHOLD", "PEEK_HEIGHT_AUTO", "", "STATE_COLLAPSED", "STATE_DRAGGING", "STATE_EXPANDED", "STATE_HALF_EXPANDED", "STATE_HIDDEN", "STATE_SETTLING", "from", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroid/view/View;", "view", "(Landroid/view/View;)Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <V extends View> SheetBaseBehavior<?> from(V view) {
            if (view == null) {
                Intrinsics.throwNpe();
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
                throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
            }
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (!(behavior instanceof SheetBaseBehavior)) {
                throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
            }
            return (SheetBaseBehavior) behavior;
        }
    }

    /* renamed from: isHideAble, reason: from getter */
    public final boolean getIsHideAble() {
        return this.isHideAble;
    }

    public final void setHideAble(boolean z) {
        this.isHideAble = z;
    }

    public final SheetCallback getMCallback() {
        return this.mCallback;
    }

    public final void setMCallback(SheetCallback sheetCallback) {
        this.mCallback = sheetCallback;
    }

    public final boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public final void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public SheetBaseBehavior() {
        this.slideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseBehavior$slideProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean disableDragDown() {
                return false;
            }
        };
        this.pullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseBehavior$pullUpProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enablePullUp() {
                return false;
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return SheetPullUpProcessor.DefaultImpls.disableNestedChildScroll(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToFull() {
                return SheetPullUpProcessor.DefaultImpls.enableToFull(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToHalf() {
                return SheetPullUpProcessor.DefaultImpls.enableToHalf(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent motionEvent) {
                Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
                return SheetPullUpProcessor.DefaultImpls.inIgnoreArea(this, motionEvent);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return SheetPullUpProcessor.DefaultImpls.isWebViewReachTop(this);
            }
        };
    }

    public SheetBaseBehavior(V v) {
        this.slideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseBehavior$slideProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean disableDragDown() {
                return false;
            }
        };
        this.pullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseBehavior$pullUpProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enablePullUp() {
                return false;
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return SheetPullUpProcessor.DefaultImpls.disableNestedChildScroll(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToFull() {
                return SheetPullUpProcessor.DefaultImpls.enableToFull(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToHalf() {
                return SheetPullUpProcessor.DefaultImpls.enableToHalf(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent motionEvent) {
                Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
                return SheetPullUpProcessor.DefaultImpls.inIgnoreArea(this, motionEvent);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return SheetPullUpProcessor.DefaultImpls.isWebViewReachTop(this);
            }
        };
    }

    public SheetBaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.slideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseBehavior$slideProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean disableDragDown() {
                return false;
            }
        };
        this.pullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseBehavior$pullUpProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enablePullUp() {
                return false;
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return SheetPullUpProcessor.DefaultImpls.disableNestedChildScroll(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToFull() {
                return SheetPullUpProcessor.DefaultImpls.enableToFull(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToHalf() {
                return SheetPullUpProcessor.DefaultImpls.enableToHalf(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent motionEvent) {
                Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
                return SheetPullUpProcessor.DefaultImpls.inIgnoreArea(this, motionEvent);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return SheetPullUpProcessor.DefaultImpls.isWebViewReachTop(this);
            }
        };
    }

    public final void setBottomSheetCallback(SheetCallback callback) {
        this.mCallback = callback;
    }

    public final View findScrollingChild(View view) {
        View findScrollingChild;
        if (view == null) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewPager) {
            View currentView = getCurrentView((ViewPager) view);
            if (currentView == null || (findScrollingChild = findScrollingChild(currentView)) == null || findScrollingChild.getVisibility() != 0) {
                return null;
            }
            return findScrollingChild;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild2 = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild2 != null) {
                    return findScrollingChild2;
                }
            }
        }
        return null;
    }

    private final View getCurrentView(ViewPager viewPager) {
        int currentItem = viewPager.getCurrentItem();
        int childCount = viewPager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewPager.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.support.v4.view.ViewPager.LayoutParams");
            }
            ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams) layoutParams;
            try {
                Field declaredField = layoutParams2.getClass().getDeclaredField("position");
                Intrinsics.checkExpressionValueIsNotNull(declaredField, "positionF");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(layoutParams2);
                if (!layoutParams2.isDecor && (obj instanceof Integer) && currentItem == ((Integer) obj).intValue()) {
                    return childAt;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public final String findFirstId(ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Resources resources = parent.getResources();
        if (parent.getId() != -1 && resources != null) {
            String resourceEntryName = resources.getResourceEntryName(parent.getId());
            if (!Intrinsics.areEqual("ttlive_design_bottom_sheet", resourceEntryName)) {
                Intrinsics.checkExpressionValueIsNotNull(resourceEntryName, "idStr");
                return resourceEntryName;
            }
        }
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                return findFirstId((ViewGroup) childAt);
            }
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            if (childAt.getId() != -1) {
                if (resources == null) {
                    Intrinsics.throwNpe();
                }
                String resourceEntryName2 = resources.getResourceEntryName(childAt.getId());
                Intrinsics.checkExpressionValueIsNotNull(resourceEntryName2, "resources!!.getResourceEntryName(child.id)");
                return resourceEntryName2;
            }
        }
        return "";
    }
}
