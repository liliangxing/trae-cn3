package com.lynx.tasm.animation.keyframe;

import android.text.TextUtils;
import android.view.View;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class KeyframeManager {
    private HashMap<String, LynxKeyframeAnimator> mAnimators = new HashMap<>();
    private AnimationInfo[] mInfos;
    private WeakReference<LynxUI> mUI;

    public static boolean hasKeyframeAnimation(StylesDiffMap stylesDiffMap) {
        return stylesDiffMap.hasKey("animation") || stylesDiffMap.hasKey(64);
    }

    public KeyframeManager(LynxUI lynxUI) {
        this.mUI = new WeakReference<>(lynxUI);
    }

    LynxUI getUI() {
        return this.mUI.get();
    }

    View getView() {
        return getUI().getView();
    }

    public void setAnimations(AnimationInfo[] animationInfoArr) {
        this.mInfos = animationInfoArr;
    }

    public void setAnimation(AnimationInfo animationInfo) {
        this.mInfos = new AnimationInfo[]{animationInfo};
    }

    public void notifyAnimationUpdated() {
        if (this.mInfos != null) {
            if (getUI().getHeight() == 0 && getUI().getWidth() == 0) {
                return;
            }
            HashMap<String, LynxKeyframeAnimator> hashMap = new HashMap<>();
            for (AnimationInfo animationInfo : this.mInfos) {
                if (animationInfo != null && !TextUtils.isEmpty(animationInfo.getName())) {
                    HashMap<String, LynxKeyframeAnimator> hashMap2 = this.mAnimators;
                    LynxKeyframeAnimator lynxKeyframeAnimator = hashMap2 != null ? hashMap2.get(animationInfo.getName()) : null;
                    if (lynxKeyframeAnimator == null) {
                        lynxKeyframeAnimator = new LynxKeyframeAnimator(getView(), getUI());
                    } else {
                        this.mAnimators.remove(animationInfo.getName());
                    }
                    hashMap.put(animationInfo.getName(), lynxKeyframeAnimator);
                }
            }
            HashMap<String, LynxKeyframeAnimator> hashMap3 = this.mAnimators;
            if (hashMap3 != null) {
                Iterator<LynxKeyframeAnimator> it = hashMap3.values().iterator();
                while (it.hasNext()) {
                    it.next().destroy();
                }
            }
            for (AnimationInfo animationInfo2 : this.mInfos) {
                if (animationInfo2 != null && !TextUtils.isEmpty(animationInfo2.getName())) {
                    hashMap.get(animationInfo2.getName()).apply(animationInfo2);
                }
            }
            this.mAnimators = hashMap;
        }
    }

    public void endAllAnimation() {
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mAnimators = null;
        this.mInfos = null;
    }

    public void notifyPropertyUpdated(String str, Object obj) {
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().notifyPropertyUpdated(str, obj);
        }
    }

    public boolean hasAnimationRunning() {
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return false;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void onAttach() {
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().onAttach();
        }
    }

    public void detachFromUI() {
        this.mUI = null;
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().detachFromUI();
        }
    }

    public void attachToUI(LynxUI lynxUI) {
        this.mUI = new WeakReference<>(lynxUI);
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().attachToUI(lynxUI);
        }
    }

    public void onDetach() {
        HashMap<String, LynxKeyframeAnimator> hashMap = this.mAnimators;
        if (hashMap == null) {
            return;
        }
        Iterator<LynxKeyframeAnimator> it = hashMap.values().iterator();
        while (it.hasNext()) {
            it.next().onDetach();
        }
    }

    public void onDestroy() {
        endAllAnimation();
    }
}
