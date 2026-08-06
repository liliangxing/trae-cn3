package com.lynx.tasm.animation.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.animation.AnimationConstant;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.animation.InterpolatorFactory;
import com.lynx.tasm.animation.PropertyFactory;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.TransformProps;
import com.lynx.tasm.event.LynxCustomEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TransitionAnimationManager {
    private final LynxBaseUI mDelegateUI;
    private boolean mHasAlphaTransition;
    private boolean mHasVisibilityTransition;
    private int mLatestX = 0;
    private int mLatestY = 0;
    private int mLatestWidth = 0;
    private int mLatestHeight = 0;
    private SparseArray<AnimationInfo> mAnimationInfo = new SparseArray<>();
    private final HashMap<Integer, Animator> mRunningAnimators = new HashMap<>();
    private final HashMap<Integer, Animator> mIdleAnimators = new HashMap<>();

    public TransitionAnimationManager(LynxBaseUI lynxBaseUI) {
        this.mDelegateUI = lynxBaseUI;
    }

    public static boolean hasTransitionAnimation(StylesDiffMap stylesDiffMap) {
        return stylesDiffMap.hasKey(AnimationConstant.TRANSITION) || stylesDiffMap.hasKey(109);
    }

    public boolean isShouldTransitionType(int i) {
        if (i == 8177 || i == 16369 || i == 262129 || i == 262144) {
            return true;
        }
        for (int i2 : AnimationConstant.ALL_PLATFORM_TRANSITION_PROPS_ARR) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean initializeFromConfig(ReadableMap readableMap) {
        if (readableMap == null) {
            return false;
        }
        ReadableArray array = readableMap.getArray(AnimationConstant.TRANSITION);
        if (array == null) {
            endAllAnimators();
            return false;
        }
        SparseArray<AnimationInfo> sparseArray = this.mAnimationInfo;
        this.mAnimationInfo = new SparseArray<>();
        for (int i = 0; i < array.size(); i++) {
            ReadableArray array2 = array.getArray(i);
            int i2 = array2.getInt(0);
            if (isShouldTransitionType(i2)) {
                AnimationInfo animationInfo = new AnimationInfo();
                animationInfo.setProperty(i2);
                animationInfo.setDuration((long) array2.getDouble(1));
                animationInfo.setDelay((long) array2.getDouble(animationInfo.setTimingFunction(array2, 2)));
                animationInfo.setOrderIndex(i);
                int property = animationInfo.getProperty();
                if (property == 8177 || property == 16369 || property == 262129 || property == 262144) {
                    this.mAnimationInfo.clear();
                    int[] iArr = AnimationConstant.ALL_PLATFORM_TRANSITION_PROPS_ARR;
                    int length = iArr.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        int i5 = iArr[i3];
                        AnimationInfo animationInfo2 = new AnimationInfo(animationInfo);
                        animationInfo2.setOrderIndex(i4);
                        animationInfo2.setProperty(i5);
                        this.mAnimationInfo.put(animationInfo2.getProperty(), animationInfo2);
                        i3++;
                        i4++;
                    }
                    AnimationInfo.removeDuplicateAnimation(this.mAnimationInfo, 256, 1024);
                    AnimationInfo.removeDuplicateAnimation(this.mAnimationInfo, 512, AnimationConstant.PROP_BOTTOM);
                    if (sparseArray != null) {
                        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                            int keyAt = sparseArray.keyAt(i6);
                            if (this.mAnimationInfo.indexOfKey(keyAt) < 0) {
                                endTransitionAnimator(Integer.valueOf(keyAt));
                            }
                        }
                    }
                    return this.mAnimationInfo.size() == 0;
                }
                this.mAnimationInfo.put(animationInfo.getProperty(), animationInfo);
            }
        }
        AnimationInfo.removeDuplicateAnimation(this.mAnimationInfo, 256, 1024);
        AnimationInfo.removeDuplicateAnimation(this.mAnimationInfo, 512, AnimationConstant.PROP_BOTTOM);
        if (sparseArray != null) {
        }
        if (this.mAnimationInfo.size() == 0) {
        }
    }

    public void endAllAnimators() {
        Iterator it = ((HashMap) this.mRunningAnimators.clone()).values().iterator();
        while (it.hasNext()) {
            ((Animator) it.next()).cancel();
        }
        this.mRunningAnimators.clear();
        this.mIdleAnimators.clear();
    }

    public void endAllLayoutAnimators() {
        endTransitionAnimator(256);
        endTransitionAnimator(1024);
        endTransitionAnimator(512);
        endTransitionAnimator(Integer.valueOf(AnimationConstant.PROP_BOTTOM));
        endTransitionAnimator(32);
        endTransitionAnimator(16);
    }

    public void endTransitionAnimator(Integer num) {
        Animator animator = this.mRunningAnimators.get(num);
        if (animator != null) {
            animator.cancel();
            this.mRunningAnimators.remove(num);
        }
    }

    public boolean containTransition(int i) {
        return (this.mAnimationInfo.size() == 0 || this.mAnimationInfo.get(i) == null) ? false : true;
    }

    public boolean containLayoutTransition() {
        return this.mAnimationInfo.size() != 0 && (containsAnimation(256) || containsAnimation(1024) || containsAnimation(512) || containsAnimation(AnimationConstant.PROP_BOTTOM) || containsAnimation(16) || containsAnimation(32));
    }

    public boolean hasAnimationRunning() {
        return !this.mRunningAnimators.isEmpty();
    }

    public boolean applyPropertyTransition(LynxBaseUI lynxBaseUI, int i, Object obj) {
        if (this.mAnimationInfo.size() == 0 || this.mAnimationInfo.get(i) == null) {
            return false;
        }
        LynxBaseUI lynxBaseUI2 = this.mDelegateUI;
        final LynxBaseUI lynxBaseUI3 = lynxBaseUI2 != null ? lynxBaseUI2 : lynxBaseUI;
        AnimationInfo animationInfo = this.mAnimationInfo.get(i);
        float f = 1.0f;
        if (i != 1) {
            if (i == 64) {
                final int intValue = ((Integer) obj).intValue();
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(lynxBaseUI3.getLynxBackground().getBackgroundColor()), Integer.valueOf(intValue));
                this.mIdleAnimators.put(64, ofObject);
                ofObject.setDuration(Math.round((float) animationInfo.getDuration()));
                ofObject.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
                ofObject.setStartDelay(animationInfo.getDelay());
                final LynxBaseUI lynxBaseUI4 = lynxBaseUI3;
                ofObject.addListener(new TransitionListener(lynxBaseUI3, i) { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.1
                    @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        lynxBaseUI4.getLynxBackground().setBackgroundColor(intValue);
                        lynxBaseUI4.invalidate();
                        TransitionAnimationManager.this.mRunningAnimators.remove(64);
                    }
                });
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue != null) {
                            lynxBaseUI3.getLynxBackground().setBackgroundColor(((Integer) animatedValue).intValue());
                            lynxBaseUI3.invalidate();
                        }
                    }
                });
            } else {
                if (i != 128) {
                    if (i == 4096 && (lynxBaseUI3 instanceof LynxUI)) {
                        final LynxUI lynxUI = (LynxUI) lynxBaseUI3;
                        final TransformProps processTransform = TransformProps.processTransform((List) obj, lynxUI.getLynxContext().getUIBody().getFontSize(), lynxUI.getFontSize(), lynxUI.getLynxContext().getUIBody().getLatestWidth(), lynxUI.getLynxContext().getUIBody().getLatestHeight(), lynxUI.getLatestWidth(), lynxUI.getLatestHeight());
                        if (processTransform != null) {
                            final float translationX = lynxUI.getTranslationX();
                            final float translationY = lynxUI.getTranslationY();
                            final float translationZ = lynxUI.getView().getTranslationZ();
                            final float rotation = lynxUI.getView().getRotation();
                            final float rotationX = lynxUI.getView().getRotationX();
                            final float rotationY = lynxUI.getView().getRotationY();
                            final float scaleX = lynxUI.getView().getScaleX();
                            final float scaleY = lynxUI.getView().getScaleY();
                            ValueAnimator ofInt = ValueAnimator.ofInt(0);
                            this.mIdleAnimators.put(4096, ofInt);
                            ofInt.setDuration(animationInfo.getDuration());
                            ofInt.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
                            ofInt.setStartDelay(animationInfo.getDelay());
                            ofInt.addListener(new TransitionListener(lynxUI, i) { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.3
                                @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    lynxUI.getView().setTranslationX(processTransform.getTranslationX());
                                    lynxUI.getView().setTranslationY(processTransform.getTranslationY());
                                    lynxUI.getView().setTranslationZ(processTransform.getTranslationZ());
                                    if (lynxUI.getParent() instanceof UIShadowProxy) {
                                        lynxUI.getParent().notifyAnimating();
                                    }
                                    lynxUI.getView().setRotation(processTransform.getRotation());
                                    lynxUI.getView().setRotationX(processTransform.getRotationX());
                                    lynxUI.getView().setRotationY(processTransform.getRotationY());
                                    lynxUI.getView().setScaleX(processTransform.getScaleX());
                                    lynxUI.getView().setScaleY(processTransform.getScaleY());
                                    TransitionAnimationManager.this.mRunningAnimators.remove(4096);
                                }
                            });
                            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.4
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    float animatedFraction = valueAnimator.getAnimatedFraction();
                                    lynxUI.getView().setTranslationX(translationX + ((processTransform.getTranslationX() - translationX) * animatedFraction));
                                    lynxUI.getView().setTranslationY(translationY + ((processTransform.getTranslationY() - translationY) * animatedFraction));
                                    lynxUI.getView().setTranslationZ(translationZ + ((processTransform.getTranslationZ() - translationZ) * animatedFraction));
                                    lynxUI.getView().setRotation(rotation + ((processTransform.getRotation() - rotation) * animatedFraction));
                                    lynxUI.getView().setRotationX(rotationX + ((processTransform.getRotationX() - rotationX) * animatedFraction));
                                    lynxUI.getView().setRotationY(rotationY + ((processTransform.getRotationY() - rotationY) * animatedFraction));
                                    lynxUI.getView().setScaleX(scaleX + ((processTransform.getScaleX() - scaleX) * animatedFraction));
                                    lynxUI.getView().setScaleY(scaleY + (animatedFraction * (processTransform.getScaleY() - scaleY)));
                                    if (lynxUI.getParent() instanceof UIShadowProxy) {
                                        lynxUI.getParent().notifyAnimating();
                                    }
                                }
                            });
                        }
                    }
                    return true;
                }
                if (!this.mHasAlphaTransition) {
                    final LynxUI lynxUI2 = lynxBaseUI3.getParent() instanceof UIShadowProxy ? (LynxUI) lynxBaseUI3.getParent() : (LynxUI) lynxBaseUI3;
                    int intValue2 = ((Integer) obj).intValue();
                    int visibility = lynxUI2.getView().getVisibility();
                    int i2 = intValue2 == 1 ? 0 : 4;
                    if (visibility == i2) {
                        return true;
                    }
                    this.mHasVisibilityTransition = true;
                    final float alpha = lynxUI2.getView().getAlpha();
                    float f2 = 0.0f;
                    if (visibility == 0) {
                        f = 0.0f;
                    } else if ((visibility == 4 || visibility == 8) && i2 == 0) {
                        lynxUI2.getView().setAlpha(0.0f);
                        ValueAnimator ofObject2 = ValueAnimator.ofObject(new FloatEvaluator(), Float.valueOf(f2), Float.valueOf(f));
                        ofObject2.setDuration(animationInfo.getDuration());
                        ofObject2.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
                        ofObject2.setStartDelay(animationInfo.getDelay());
                        ofObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.7
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Object animatedValue = valueAnimator.getAnimatedValue();
                                if (animatedValue != null) {
                                    lynxUI2.getView().setAlpha(((Float) animatedValue).floatValue());
                                }
                            }
                        });
                        final LynxUI lynxUI3 = lynxUI2;
                        final int i3 = i2;
                        ofObject2.addListener(new TransitionListener(lynxBaseUI3, i) { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.8
                            @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                lynxUI3.setVisibilityForView(i3);
                                lynxUI3.getView().setAlpha(alpha);
                                TransitionAnimationManager.this.mRunningAnimators.remove(128);
                            }

                            @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                super.onAnimationStart(animator);
                                lynxUI3.getView().setVisibility(0);
                                TransitionAnimationManager.this.mHasVisibilityTransition = false;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                super.onAnimationCancel(animator);
                                TransitionAnimationManager.this.mHasVisibilityTransition = false;
                            }
                        });
                        this.mIdleAnimators.put(128, ofObject2);
                    }
                    f2 = alpha;
                    ValueAnimator ofObject22 = ValueAnimator.ofObject(new FloatEvaluator(), Float.valueOf(f2), Float.valueOf(f));
                    ofObject22.setDuration(animationInfo.getDuration());
                    ofObject22.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
                    ofObject22.setStartDelay(animationInfo.getDelay());
                    ofObject22.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.7
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Object animatedValue = valueAnimator.getAnimatedValue();
                            if (animatedValue != null) {
                                lynxUI2.getView().setAlpha(((Float) animatedValue).floatValue());
                            }
                        }
                    });
                    final LynxUI lynxUI32 = lynxUI2;
                    final int i32 = i2;
                    ofObject22.addListener(new TransitionListener(lynxBaseUI3, i) { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.8
                        @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            lynxUI32.setVisibilityForView(i32);
                            lynxUI32.getView().setAlpha(alpha);
                            TransitionAnimationManager.this.mRunningAnimators.remove(128);
                        }

                        @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            super.onAnimationStart(animator);
                            lynxUI32.getView().setVisibility(0);
                            TransitionAnimationManager.this.mHasVisibilityTransition = false;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            super.onAnimationCancel(animator);
                            TransitionAnimationManager.this.mHasVisibilityTransition = false;
                        }
                    });
                    this.mIdleAnimators.put(128, ofObject22);
                }
            }
        } else if (!this.mHasVisibilityTransition) {
            final float min = Math.min(((Float) obj).floatValue(), 1.0f);
            final LynxUI lynxUI4 = (LynxUI) lynxBaseUI3;
            ValueAnimator ofObject3 = ValueAnimator.ofObject(new FloatEvaluator(), Float.valueOf(lynxUI4.getView().getAlpha()), Float.valueOf(min));
            this.mIdleAnimators.put(1, ofObject3);
            ofObject3.setDuration(animationInfo.getDuration());
            ofObject3.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
            ofObject3.setStartDelay(animationInfo.getDelay());
            ofObject3.addListener(new TransitionListener(lynxUI4, i) { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.5
                @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    lynxUI4.getView().setAlpha(min);
                    if (lynxUI4.getParent() instanceof UIShadowProxy) {
                        lynxUI4.getParent().notifyAnimating();
                    }
                    TransitionAnimationManager.this.mRunningAnimators.remove(1);
                }
            });
            ofObject3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue != null) {
                        lynxUI4.getView().setAlpha(((Float) animatedValue).floatValue());
                        if (lynxUI4.getParent() instanceof UIShadowProxy) {
                            lynxUI4.getParent().notifyAnimating();
                        }
                    }
                }
            });
            this.mHasAlphaTransition = true;
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r3 != 2048) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ValueAnimator createLayoutAnimator(int i, final LynxBaseUI lynxBaseUI, int i2, int i3, AnimationInfo animationInfo, boolean z) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setDuration(animationInfo.getDuration());
        ofInt.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
        ofInt.setStartDelay(animationInfo.getDelay());
        ofInt.addListener(new LayoutTransitionListener(lynxBaseUI, i, this, z));
        if (i == 16) {
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.11
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue != null) {
                        lynxBaseUI.setWidth(((Integer) animatedValue).intValue());
                        LynxUI lynxUI = lynxBaseUI;
                        if (lynxUI.getParent() instanceof UIShadowProxy) {
                            lynxUI.getParent().notifyAnimating();
                        }
                    }
                }
            });
        } else if (i != 32) {
            if (i != 256) {
                if (i != 512) {
                    if (i != 1024) {
                    }
                }
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.10
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Object animatedValue = valueAnimator.getAnimatedValue();
                        if (animatedValue != null) {
                            lynxBaseUI.setTop(((Integer) animatedValue).intValue());
                            LynxUI lynxUI = lynxBaseUI;
                            if (lynxUI.getParent() instanceof UIShadowProxy) {
                                lynxUI.getParent().notifyAnimating();
                            }
                        }
                    }
                });
            }
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue != null) {
                        lynxBaseUI.setLeft(((Integer) animatedValue).intValue());
                        LynxUI lynxUI = lynxBaseUI;
                        if (lynxUI.getParent() instanceof UIShadowProxy) {
                            lynxUI.getParent().notifyAnimating();
                        }
                    }
                }
            });
        } else {
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.transition.TransitionAnimationManager.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Object animatedValue = valueAnimator.getAnimatedValue();
                    if (animatedValue != null) {
                        lynxBaseUI.setHeight(((Integer) animatedValue).intValue());
                        LynxUI lynxUI = lynxBaseUI;
                        if (lynxUI.getParent() instanceof UIShadowProxy) {
                            lynxUI.getParent().notifyAnimating();
                        }
                    }
                }
            });
        }
        return ofInt;
    }

    public void applyLayoutTransition(LynxBaseUI lynxBaseUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        if (lynxBaseUI instanceof LynxUI) {
            LynxBaseUI lynxBaseUI2 = this.mDelegateUI;
            LynxBaseUI lynxBaseUI3 = lynxBaseUI2 != null ? lynxBaseUI2 : lynxBaseUI;
            boolean z = lynxBaseUI3.getOriginLeft() != i;
            boolean z2 = lynxBaseUI3.getOriginTop() != i2;
            boolean z3 = lynxBaseUI3.getWidth() != i3;
            boolean z4 = lynxBaseUI3.getHeight() != i4;
            boolean z5 = lynxBaseUI3.getOriginLeft() + lynxBaseUI3.getWidth() == i + i3;
            boolean z6 = lynxBaseUI3.getOriginTop() + lynxBaseUI3.getHeight() == i2 + i4;
            lynxBaseUI3.onBeforeAnimation(i, i2, i3, i4, i5, i6, i7, i8);
            int i17 = 256;
            int i18 = 1024;
            boolean z7 = containsAnimation(256) || containsAnimation(1024);
            boolean z8 = containsAnimation(512) || containsAnimation(AnimationConstant.PROP_BOTTOM);
            boolean containsAnimation = containsAnimation(16);
            boolean containsAnimation2 = containsAnimation(32);
            int originLeft = ((z7 && z) || (containsAnimation && z5)) ? lynxBaseUI3.getOriginLeft() : i;
            int originTop = ((z8 && z2) || (containsAnimation2 && z6)) ? lynxBaseUI3.getOriginTop() : i2;
            int width = (z3 && containsAnimation) ? lynxBaseUI3.getWidth() : i3;
            int height = (z4 && containsAnimation2) ? lynxBaseUI3.getHeight() : i4;
            endAllLayoutAnimators();
            lynxBaseUI3.updateLayout(originLeft, originTop, width, height, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
            HashMap hashMap = new HashMap();
            int i19 = 0;
            while (i19 < this.mAnimationInfo.size()) {
                AnimationInfo valueAt = this.mAnimationInfo.valueAt(i19);
                if ((valueAt.getProperty() & AnimationConstant.PROP_OF_LAYOUT) != 0) {
                    int property = valueAt.getProperty();
                    if (property != 16) {
                        if (property != 32) {
                            if (property != i17) {
                                if (property != 512) {
                                    if (property != i18) {
                                        if (property != 2048) {
                                        }
                                    }
                                }
                                if (z2) {
                                    hashMap.put(Integer.valueOf(valueAt.getProperty()), createLayoutAnimator(valueAt.getProperty(), lynxBaseUI3, lynxBaseUI3.getOriginTop(), i2, valueAt, true));
                                }
                            }
                            if (z) {
                                hashMap.put(Integer.valueOf(valueAt.getProperty()), createLayoutAnimator(valueAt.getProperty(), lynxBaseUI3, lynxBaseUI3.getOriginLeft(), i, valueAt, true));
                            }
                        } else if (z4) {
                            AnimatorSet animatorSet = new AnimatorSet();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(createLayoutAnimator(32, lynxBaseUI3, lynxBaseUI3.getHeight(), i4, valueAt, true));
                            if (z2 && z6 && !z8) {
                                arrayList.add(createLayoutAnimator(512, lynxBaseUI3, lynxBaseUI3.getOriginTop(), i2, valueAt, false));
                            }
                            animatorSet.playTogether(arrayList);
                            hashMap.put(32, animatorSet);
                        }
                    } else if (z3) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(createLayoutAnimator(16, lynxBaseUI3, lynxBaseUI3.getWidth(), i3, valueAt, true));
                        if (z && z5 && !z7) {
                            arrayList2.add(createLayoutAnimator(256, lynxBaseUI3, lynxBaseUI3.getOriginLeft(), i, valueAt, false));
                        }
                        animatorSet2.playTogether(arrayList2);
                        hashMap.put(16, animatorSet2);
                    }
                }
                i19++;
                i17 = 256;
                i18 = 1024;
            }
            if (!hashMap.isEmpty()) {
                this.mIdleAnimators.putAll(hashMap);
            }
            this.mLatestX = i;
            this.mLatestY = i2;
            this.mLatestWidth = i3;
            this.mLatestHeight = i4;
        }
    }

    public void applyTransformTransition(LynxBaseUI lynxBaseUI) {
        LynxBaseUI lynxBaseUI2 = this.mDelegateUI;
        if (lynxBaseUI2 != null) {
            lynxBaseUI = lynxBaseUI2;
        }
        applyPropertyTransition(lynxBaseUI, 4096, lynxBaseUI.getTransformRaws());
    }

    public void startTransitions() {
        if (this.mIdleAnimators.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, Animator> entry : this.mIdleAnimators.entrySet()) {
            Animator animator = this.mRunningAnimators.get(entry.getKey());
            if (animator != null) {
                animator.cancel();
            }
            ensureFillModeBoth(entry.getValue());
            entry.getValue().start();
            this.mRunningAnimators.put(entry.getKey(), entry.getValue());
        }
        this.mIdleAnimators.clear();
    }

    private boolean containsAnimation(int i) {
        return this.mAnimationInfo.indexOfKey(i) >= 0;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class TransitionListener extends AnimatorListenerAdapter {
        private static final String sEventEnd = "transitionend";
        private static final Map<String, Object> sEventParams;
        private static final String sEventStart = "transitionstart";
        int mPropName;
        WeakReference<LynxBaseUI> mUI;

        static {
            HashMap hashMap = new HashMap();
            sEventParams = hashMap;
            hashMap.put("animation_type", AnimationConstant.TRANSITION);
        }

        public TransitionListener(LynxBaseUI lynxBaseUI, int i) {
            this.mUI = new WeakReference<>(lynxBaseUI);
            this.mPropName = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            sendAnimationEvent(sEventStart);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            sendAnimationEvent(sEventEnd);
        }

        private void sendAnimationEvent(String str) {
            LynxBaseUI lynxBaseUI = this.mUI.get();
            if (lynxBaseUI == null) {
                return;
            }
            if (lynxBaseUI instanceof UIShadowProxy) {
                lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
            }
            if (lynxBaseUI.getEvents() == null || !lynxBaseUI.getEvents().containsKey(str)) {
                return;
            }
            Map<String, Object> map = sEventParams;
            map.put("animation_type", "transition-" + PropertyFactory.propertyToString(this.mPropName));
            lynxBaseUI.getLynxContext().getEventEmitter().sendCustomEvent(new LynxCustomEvent(lynxBaseUI.getSign(), str, map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LayoutTransitionListener extends TransitionListener {
        WeakReference<TransitionAnimationManager> mManager;
        boolean mShouldSendAnimationEvent;

        public LayoutTransitionListener(LynxBaseUI lynxBaseUI, int i, TransitionAnimationManager transitionAnimationManager, boolean z) {
            super(lynxBaseUI, i);
            this.mShouldSendAnimationEvent = true;
            this.mManager = new WeakReference<>(transitionAnimationManager);
            this.mShouldSendAnimationEvent = z;
        }

        @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.mShouldSendAnimationEvent) {
                super.onAnimationStart(animator);
            }
        }

        @Override // com.lynx.tasm.animation.transition.TransitionAnimationManager.TransitionListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i;
            int i2;
            int i3;
            int i4;
            if (this.mShouldSendAnimationEvent) {
                super.onAnimationEnd(animator);
            }
            TransitionAnimationManager transitionAnimationManager = this.mManager.get();
            LynxBaseUI lynxBaseUI = this.mUI.get();
            if (lynxBaseUI == null || transitionAnimationManager == null) {
                return;
            }
            transitionAnimationManager.mRunningAnimators.remove(Integer.valueOf(this.mPropName));
            int originLeft = lynxBaseUI.getOriginLeft();
            int originTop = lynxBaseUI.getOriginTop();
            int width = lynxBaseUI.getWidth();
            int height = lynxBaseUI.getHeight();
            int i5 = this.mPropName;
            if (i5 != 16) {
                if (i5 != 32) {
                    if (i5 != 256) {
                        if (i5 != 512) {
                            if (i5 != 1024) {
                                if (i5 != 2048) {
                                    i2 = height;
                                }
                            }
                        }
                        i4 = originLeft;
                        i2 = height;
                        i3 = width;
                        i = transitionAnimationManager.mLatestY;
                        lynxBaseUI.updateLayout(i4, i, i3, i2, lynxBaseUI.getPaddingLeft(), lynxBaseUI.getPaddingTop(), lynxBaseUI.getPaddingRight(), lynxBaseUI.getPaddingBottom(), lynxBaseUI.getMarginLeft(), lynxBaseUI.getMarginTop(), lynxBaseUI.getMarginRight(), lynxBaseUI.getMarginBottom(), lynxBaseUI.getBorderLeftWidth(), lynxBaseUI.getBorderTopWidth(), lynxBaseUI.getBorderRightWidth(), lynxBaseUI.getBorderBottomWidth(), lynxBaseUI.getBound());
                    }
                    i2 = height;
                    i3 = width;
                    i = originTop;
                    i4 = transitionAnimationManager.mLatestX;
                    lynxBaseUI.updateLayout(i4, i, i3, i2, lynxBaseUI.getPaddingLeft(), lynxBaseUI.getPaddingTop(), lynxBaseUI.getPaddingRight(), lynxBaseUI.getPaddingBottom(), lynxBaseUI.getMarginLeft(), lynxBaseUI.getMarginTop(), lynxBaseUI.getMarginRight(), lynxBaseUI.getMarginBottom(), lynxBaseUI.getBorderLeftWidth(), lynxBaseUI.getBorderTopWidth(), lynxBaseUI.getBorderRightWidth(), lynxBaseUI.getBorderBottomWidth(), lynxBaseUI.getBound());
                }
                i2 = transitionAnimationManager.mLatestHeight;
                i3 = width;
                i = originTop;
            } else {
                i = originTop;
                i2 = height;
                i3 = transitionAnimationManager.mLatestWidth;
            }
            i4 = originLeft;
            lynxBaseUI.updateLayout(i4, i, i3, i2, lynxBaseUI.getPaddingLeft(), lynxBaseUI.getPaddingTop(), lynxBaseUI.getPaddingRight(), lynxBaseUI.getPaddingBottom(), lynxBaseUI.getMarginLeft(), lynxBaseUI.getMarginTop(), lynxBaseUI.getMarginRight(), lynxBaseUI.getMarginBottom(), lynxBaseUI.getBorderLeftWidth(), lynxBaseUI.getBorderTopWidth(), lynxBaseUI.getBorderRightWidth(), lynxBaseUI.getBorderBottomWidth(), lynxBaseUI.getBound());
        }
    }

    public void onDestroy() {
        endAllAnimators();
    }

    private void ensureFillModeBoth(Animator animator) {
        Animator clone = animator.clone();
        clone.setDuration(10000000L);
        clone.setStartDelay(0L);
        if (clone instanceof AnimatorSet) {
            Iterator<Animator> it = ((AnimatorSet) clone).getChildAnimations().iterator();
            while (it.hasNext()) {
                it.next().removeAllListeners();
            }
        }
        clone.removeAllListeners();
        clone.addListener(new StartListenerForFillModeBoth());
        clone.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class StartListenerForFillModeBoth extends AnimatorListenerAdapter {
        private StartListenerForFillModeBoth() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            animator.cancel();
        }
    }
}
