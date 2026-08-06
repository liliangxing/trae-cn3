package com.lynx.tasm.behavior.herotransition;

import android.text.TextUtils;
import android.view.View;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HeroTransitionManager {
    private static final String TAG = "HeroTransitionManager";
    private ConcurrentHashMap<String, WeakReference<View>> elementsMap = new ConcurrentHashMap<>();
    private WeakHashMap<LynxUI, AnimationInfo> mExitTransitionMap = new WeakHashMap<>();
    private WeakHashMap<LynxUI, AnimationInfo> mEnterTransitionMap = new WeakHashMap<>();
    private WeakHashMap<LynxUI, AnimationInfo> mResumeTransitionMap = new WeakHashMap<>();
    private WeakHashMap<LynxUI, AnimationInfo> mPauseTransitionMap = new WeakHashMap<>();
    private WeakHashMap<LynxUI, String> mHasSharedElementLynxUIMap = new WeakHashMap<>();
    private volatile boolean mEnableSharedTransition = true;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LynxViewEnterFinishListener {
        void onLynxViewEntered();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LynxViewExitFinishListener {
        void onLynxViewExited();
    }

    public boolean isSharedTransitionEnable() {
        return this.mEnableSharedTransition;
    }

    public void setSharedTransitionEnable(boolean z) {
        this.mEnableSharedTransition = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Holder {
        private static HeroTransitionManager sInstance = new HeroTransitionManager();

        private Holder() {
        }
    }

    public static HeroTransitionManager inst() {
        return Holder.sInstance;
    }

    public synchronized void registerSharedElement(View view, String str) {
        if (!TextUtils.isEmpty(str) && view != null) {
            this.elementsMap.put(str, new WeakReference<>(view));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        r3.elementsMap.remove(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void unRegisterSharedElement(String str) {
        Iterator<Map.Entry<String, WeakReference<View>>> it = this.elementsMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String key = it.next().getKey();
            if (key != null && key.equals(str)) {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        r3.elementsMap.remove(r1.getKey());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void unRegisterSharedElement(View view) {
        Iterator<Map.Entry<String, WeakReference<View>>> it = this.elementsMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, WeakReference<View>> next = it.next();
            WeakReference<View> value = next.getValue();
            if (value != null && value.get() == view) {
                break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void registerHasSharedElementLynxUI(LynxUI lynxUI, String str) {
        this.mHasSharedElementLynxUIMap.put(lynxUI, str);
    }

    private View getSharedElementByTag(String str) {
        WeakReference<View> weakReference = this.elementsMap.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public synchronized View getSharedElementByTag(String str, LynxUI lynxUI) {
        View sharedElementByTag = getSharedElementByTag(str);
        if (sharedElementByTag == null) {
            for (Map.Entry<LynxUI, String> entry : this.mHasSharedElementLynxUIMap.entrySet()) {
                LynxUI key = entry.getKey();
                if (lynxUI != key && entry.getValue().equals(str)) {
                    return key.getView();
                }
            }
        }
        return sharedElementByTag;
    }

    public synchronized void registerEnterAnim(LynxUI lynxUI, AnimationInfo animationInfo) {
        this.mEnterTransitionMap.put(lynxUI, animationInfo);
        lynxUI.setEnterAnim(animationInfo);
    }

    public synchronized void registerExitAnim(LynxUI lynxUI, AnimationInfo animationInfo) {
        this.mExitTransitionMap.put(lynxUI, animationInfo);
        lynxUI.setExitAnim(animationInfo);
    }

    public synchronized void registerResumeAnim(LynxUI lynxUI, AnimationInfo animationInfo) {
        this.mResumeTransitionMap.put(lynxUI, animationInfo);
        lynxUI.setResumeAnim(animationInfo);
    }

    public synchronized void registerPauseAnim(LynxUI lynxUI, AnimationInfo animationInfo) {
        this.mPauseTransitionMap.put(lynxUI, animationInfo);
        lynxUI.setPauseAnim(animationInfo);
    }

    public void executeEnterAnim(UIBody.UIBodyView uIBodyView, final LynxViewEnterFinishListener lynxViewEnterFinishListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (LynxUI lynxUI : this.mEnterTransitionMap.keySet()) {
            if (lynxUI.getLynxContext().getUIBody().getBodyView() == uIBodyView) {
                atomicInteger.incrementAndGet();
                lynxUI.execEnterAnim(new LynxViewEnterFinishListener() { // from class: com.lynx.tasm.behavior.herotransition.HeroTransitionManager.1
                    @Override // com.lynx.tasm.behavior.herotransition.HeroTransitionManager.LynxViewEnterFinishListener
                    public void onLynxViewEntered() {
                        LynxViewEnterFinishListener lynxViewEnterFinishListener2;
                        if (atomicInteger.decrementAndGet() != 0 || (lynxViewEnterFinishListener2 = lynxViewEnterFinishListener) == null) {
                            return;
                        }
                        lynxViewEnterFinishListener2.onLynxViewEntered();
                    }
                });
            }
        }
        if (atomicInteger.get() != 0 || lynxViewEnterFinishListener == null) {
            return;
        }
        lynxViewEnterFinishListener.onLynxViewEntered();
    }

    public void executeExitAnim(LynxView lynxView, final LynxViewExitFinishListener lynxViewExitFinishListener) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        for (LynxUI lynxUI : this.mExitTransitionMap.keySet()) {
            if (lynxUI.getLynxContext().getUIBody().getBodyView() == lynxView) {
                atomicInteger.incrementAndGet();
                lynxUI.execExitAnim(new LynxViewExitFinishListener() { // from class: com.lynx.tasm.behavior.herotransition.HeroTransitionManager.2
                    @Override // com.lynx.tasm.behavior.herotransition.HeroTransitionManager.LynxViewExitFinishListener
                    public void onLynxViewExited() {
                        LynxViewExitFinishListener lynxViewExitFinishListener2;
                        if (atomicInteger.decrementAndGet() != 0 || (lynxViewExitFinishListener2 = lynxViewExitFinishListener) == null) {
                            return;
                        }
                        lynxViewExitFinishListener2.onLynxViewExited();
                    }
                });
            }
        }
        if (atomicInteger.get() != 0 || lynxViewExitFinishListener == null) {
            return;
        }
        lynxViewExitFinishListener.onLynxViewExited();
    }

    public void executeResumeAnim(LynxView lynxView) {
        for (LynxUI lynxUI : this.mResumeTransitionMap.keySet()) {
            if (lynxUI.getLynxContext().getUIBody().getBodyView() == lynxView) {
                lynxUI.execResumeAnim();
            }
        }
    }

    public void executePauseAnim(LynxView lynxView) {
        for (LynxUI lynxUI : this.mPauseTransitionMap.keySet()) {
            if (lynxUI.getLynxContext().getUIBody().getBodyView() == lynxView) {
                lynxUI.execPauseAnim();
            }
        }
    }

    public void onLynxViewDestroy(LynxView lynxView) {
        clearLynxViewRegisters(this.mHasSharedElementLynxUIMap, lynxView);
        clearLynxViewRegisters(this.mEnterTransitionMap, lynxView);
        clearLynxViewRegisters(this.mExitTransitionMap, lynxView);
        clearLynxViewRegisters(this.mPauseTransitionMap, lynxView);
        clearLynxViewRegisters(this.mResumeTransitionMap, lynxView);
    }

    private <T> void clearLynxViewRegisters(Map<LynxUI, T> map, LynxView lynxView) {
        Iterator<Map.Entry<LynxUI, T>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            LynxUI key = it.next().getKey();
            if (key != null && key.getLynxContext().getUIBody().getBodyView() == lynxView) {
                it.remove();
            }
        }
    }
}
