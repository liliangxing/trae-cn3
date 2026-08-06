package com.lynx.tasm.behavior.herotransition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.behavior.herotransition.HeroTransitionManager;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HeroAnimOwner {
    private static final String TAG = "HeroAnimOwner";
    private AnimationInfo mEnterAnimName;
    private AnimationInfo mExitAnimName;
    private final LynxUI mLynxUI;
    private AnimationInfo mPauseAnimName;
    private AnimationInfo mResumeAnimName;
    private String mSharedElementName;
    private int mOriginIndex = 0;
    private ViewGroup mOriginParent = null;
    private UIGroup mOriginParentUI = null;
    private volatile boolean mEnterAnimating = false;
    private volatile boolean mExitAnimating = false;
    private HashMap<String, LynxKeyframeAnimator.LynxAnimationListener> animListeners = new HashMap<>();

    public HeroAnimOwner(LynxUI lynxUI) {
        this.mLynxUI = lynxUI;
    }

    private <T extends View> void applyFakeSharedElementEnter(String str) {
        View sharedElementByTag = HeroTransitionManager.inst().getSharedElementByTag(str, this.mLynxUI);
        UIBody.UIBodyView bodyView = this.mLynxUI.getLynxContext().getUIBody().getBodyView();
        if (bodyView != null) {
            View view = this.mLynxUI.getView();
            if (sharedElementByTag != null) {
                view.setVisibility(sharedElementByTag.getVisibility());
                view.setAlpha(sharedElementByTag.getAlpha());
                view.setTranslationX(sharedElementByTag.getTranslationX());
                view.setTranslationY(sharedElementByTag.getTranslationY());
                view.setRotation(sharedElementByTag.getRotation());
                view.setRotationX(sharedElementByTag.getRotationX());
                view.setRotationY(sharedElementByTag.getRotationY());
                view.setScaleX(sharedElementByTag.getScaleX());
                view.setScaleY(sharedElementByTag.getScaleY());
                int width = sharedElementByTag.getWidth();
                int height = sharedElementByTag.getHeight();
                if (bodyView.getRootView() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) bodyView.getRootView();
                    if (view.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                        this.mOriginParent = viewGroup2;
                        int childCount = viewGroup2.getChildCount();
                        int i = 0;
                        while (true) {
                            if (i >= childCount) {
                                break;
                            }
                            if (view == this.mOriginParent.getChildAt(i)) {
                                this.mOriginIndex = i;
                                break;
                            }
                            i++;
                        }
                        this.mOriginParent.removeView(view);
                        this.mOriginParentUI = (UIGroup) this.mLynxUI.getParent();
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(width, height);
                    int[] iArr = new int[2];
                    sharedElementByTag.getLocationInWindow(iArr);
                    marginLayoutParams.setMargins(iArr[0], iArr[1], 0, 0);
                    viewGroup.addView(view, marginLayoutParams);
                    UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.herotransition.HeroAnimOwner.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HeroAnimOwner.this.mLynxUI.setAnimation(HeroAnimOwner.this.mEnterAnimName);
                            HeroAnimOwner.this.mLynxUI.requestLayout();
                        }
                    });
                    return;
                }
                return;
            }
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.herotransition.HeroAnimOwner.2
                @Override // java.lang.Runnable
                public void run() {
                    HeroAnimOwner.this.mLynxUI.setAnimation(HeroAnimOwner.this.mEnterAnimName);
                    if (HeroAnimOwner.this.mLynxUI.getKeyframeManager() != null) {
                        HeroAnimOwner.this.mLynxUI.getKeyframeManager().notifyAnimationUpdated();
                    }
                }
            });
        }
    }

    public void onAnimationEnd(String str) {
        LynxKeyframeAnimator.LynxAnimationListener lynxAnimationListener = this.animListeners.get(str);
        if (lynxAnimationListener != null) {
            lynxAnimationListener.onAnimationEnd(str);
            this.animListeners.remove(str);
        }
    }

    public void setEnterAnim(AnimationInfo animationInfo) {
        this.mEnterAnimName = animationInfo;
    }

    public void setExitAnim(AnimationInfo animationInfo) {
        this.mExitAnimName = animationInfo;
    }

    public void setPauseAnim(AnimationInfo animationInfo) {
        this.mPauseAnimName = animationInfo;
    }

    public void setResumeAnim(AnimationInfo animationInfo) {
        this.mResumeAnimName = animationInfo;
    }

    public void executePauseAnim() {
        AnimationInfo animationInfo;
        if (!HeroTransitionManager.inst().isSharedTransitionEnable() || isAnimating() || (animationInfo = this.mPauseAnimName) == null) {
            return;
        }
        this.mLynxUI.setAnimation(animationInfo);
        if (this.mLynxUI.getKeyframeManager() != null) {
            this.mLynxUI.getKeyframeManager().notifyAnimationUpdated();
        }
    }

    public void executeResumeAnim() {
        AnimationInfo animationInfo;
        if (!HeroTransitionManager.inst().isSharedTransitionEnable() || isAnimating() || (animationInfo = this.mResumeAnimName) == null) {
            return;
        }
        this.mLynxUI.setAnimation(animationInfo);
        if (this.mLynxUI.getKeyframeManager() != null) {
            this.mLynxUI.getKeyframeManager().notifyAnimationUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetToLynxView() {
        View view;
        if (this.mOriginParent == null || (view = this.mLynxUI.getView()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        int[] iArr = new int[2];
        this.mOriginParent.getLocationOnScreen(iArr);
        this.mOriginParentUI.removeChild(this.mLynxUI);
        this.mOriginParentUI.insertChild(this.mLynxUI, this.mOriginIndex);
        this.mLynxUI.updateLayout(view.getLeft() + iArr[0], view.getTop() - iArr[1], layoutParams.width, layoutParams.height, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, this.mLynxUI.getBound());
    }

    private void applyFakeSharedElementExit() {
        ViewGroup viewGroup = (ViewGroup) this.mLynxUI.getLynxContext().getUIBody().getBodyView().getRootView();
        View view = this.mLynxUI.getView();
        view.getLocationInWindow(new int[2]);
        ViewParent parent = view.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(view);
        }
        viewGroup.addView(view);
        this.mLynxUI.setAnimation(this.mExitAnimName);
        if (this.mLynxUI.getKeyframeManager() != null) {
            this.mLynxUI.getKeyframeManager().notifyAnimationUpdated();
        }
    }

    public void executeExitAnim(final HeroTransitionManager.LynxViewExitFinishListener lynxViewExitFinishListener) {
        AnimationInfo animationInfo;
        if (!HeroTransitionManager.inst().isSharedTransitionEnable() || isAnimating() || (animationInfo = this.mExitAnimName) == null) {
            return;
        }
        this.animListeners.put(animationInfo.getName(), new LynxKeyframeAnimator.LynxAnimationListener() { // from class: com.lynx.tasm.behavior.herotransition.HeroAnimOwner.3
            public void onAnimationEnd(String str) {
                HeroAnimOwner.this.animListeners.remove(str);
                View view = HeroAnimOwner.this.mLynxUI.getView();
                if (view == null) {
                    return;
                }
                ViewParent parent = view.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                HeroTransitionManager.LynxViewExitFinishListener lynxViewExitFinishListener2 = lynxViewExitFinishListener;
                if (lynxViewExitFinishListener2 != null) {
                    lynxViewExitFinishListener2.onLynxViewExited();
                }
                HeroAnimOwner.this.mExitAnimating = false;
            }
        });
        if (this.mSharedElementName != null) {
            this.mExitAnimating = true;
            applyFakeSharedElementExit();
        } else {
            this.mLynxUI.setAnimation(this.mExitAnimName);
            if (this.mLynxUI.getKeyframeManager() != null) {
                this.mLynxUI.getKeyframeManager().notifyAnimationUpdated();
            }
        }
    }

    public void executeEnterAnim(final HeroTransitionManager.LynxViewEnterFinishListener lynxViewEnterFinishListener) {
        AnimationInfo animationInfo;
        if (!HeroTransitionManager.inst().isSharedTransitionEnable() || isAnimating() || (animationInfo = this.mEnterAnimName) == null) {
            return;
        }
        if (this.mSharedElementName != null) {
            this.mEnterAnimating = true;
            applyFakeSharedElementEnter(this.mSharedElementName);
            this.animListeners.put(this.mEnterAnimName.getName(), new LynxKeyframeAnimator.LynxAnimationListener() { // from class: com.lynx.tasm.behavior.herotransition.HeroAnimOwner.4
                public void onAnimationEnd(String str) {
                    HeroAnimOwner.this.animListeners.remove(str);
                    HeroAnimOwner.this.resetToLynxView();
                    HeroTransitionManager.LynxViewEnterFinishListener lynxViewEnterFinishListener2 = lynxViewEnterFinishListener;
                    if (lynxViewEnterFinishListener2 != null) {
                        lynxViewEnterFinishListener2.onLynxViewEntered();
                    }
                    HeroAnimOwner.this.mEnterAnimating = false;
                }
            });
        } else {
            this.mLynxUI.setAnimation(animationInfo);
            if (this.mLynxUI.getKeyframeManager() != null) {
                this.mLynxUI.getKeyframeManager().notifyAnimationUpdated();
            }
        }
    }

    private boolean isAnimating() {
        return this.mEnterAnimating || this.mExitAnimating;
    }

    public void setSharedElementName(String str) {
        this.mSharedElementName = str;
        HeroTransitionManager.inst().registerHasSharedElementLynxUI(this.mLynxUI, str);
    }
}
