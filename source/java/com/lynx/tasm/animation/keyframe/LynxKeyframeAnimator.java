package com.lynx.tasm.animation.keyframe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import com.facebook.common.time.Clock;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.animation.AnimationConstant;
import com.lynx.tasm.animation.AnimationInfo;
import com.lynx.tasm.animation.InterpolatorFactory;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BackgroundManager;
import com.lynx.tasm.behavior.ui.utils.TransformOrigin;
import com.lynx.tasm.behavior.ui.utils.TransformProps;
import com.lynx.tasm.behavior.ui.utils.TransformRaw;
import com.lynx.tasm.event.LynxCustomEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxKeyframeAnimator {
    private static final String TAG = "LynxKeyframeAnimator";
    public static final String sAlphaStr = "Alpha";
    public static final String sBackgroundColorStr = "BackgroundColor";
    private static final String sColorStr = "Color";
    private static final String sRotationXStr = "RotationX";
    private static final String sRotationYStr = "RotationY";
    private static final String sRotationZStr = "Rotation";
    private static final String sScaleXStr = "ScaleX";
    private static final String sScaleYStr = "ScaleY";
    private static final long sTimeNotInit = -1;
    public static final String sTransformStr = "Transform";
    private static final String sTranslationXStr = "TranslationX";
    private static final String sTranslationYStr = "TranslationY";
    private static final String sTranslationZStr = "TranslationZ";
    private WeakReference<LynxUI> mUI;
    private WeakReference<View> mView;
    private PauseTimeHelper mPauseTimeHelper = new PauseTimeHelper();
    private HashMap<String, Object> mPropertyOriginValue = new HashMap<>();
    private long mKeyframeStartTime = sTimeNotInit;
    private KeyframeParsedData mKeyframeParsedData = null;
    private ObjectAnimator[] mInternalAnimators = null;
    private LynxKFAnimatorState mState = LynxKFAnimatorState.IDLE;
    private AnimationInfo mInfo = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface LynxAnimationListener {
        void onAnimationEnd(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum LynxAnimationPropertyType {
        TRANSLATE_X,
        TRANSLATE_Y,
        TRANSLATE_Z,
        ROTATE_X,
        ROTATE_Y,
        ROTATE_Z,
        SCALE_X,
        SCALE_Y,
        OPACITY,
        BG_COLOR
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum LynxKFAnimatorState {
        IDLE,
        RUNNING,
        PAUSED,
        CANCELED,
        DESTROYED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class KeyframeParsedData {
        public ArrayList<Keyframe> mBColorKfList;
        PropertyValuesHolder[] mBGHolders;
        public Set<LynxAnimationPropertyType> mHasEndKeyframe;
        public boolean mHasPercentageTransform;
        public Set<LynxAnimationPropertyType> mHasStartKeyframe;
        public boolean mHasTransform;
        public ArrayList<Keyframe> mOpaKfList;
        public ArrayList<Keyframe> mRotXKfList;
        public ArrayList<Keyframe> mRotYKfList;
        public ArrayList<Keyframe> mRotZKfList;
        public ArrayList<Keyframe> mScaXKfList;
        public ArrayList<Keyframe> mScaYKfList;
        public ArrayList<Keyframe> mTranXKfList;
        public ArrayList<Keyframe> mTranYKfList;
        public ArrayList<Keyframe> mTranZKfList;
        PropertyValuesHolder[] mViewHolders;

        private KeyframeParsedData() {
            this.mOpaKfList = new ArrayList<>();
            this.mTranXKfList = new ArrayList<>();
            this.mTranYKfList = new ArrayList<>();
            this.mTranZKfList = new ArrayList<>();
            this.mRotZKfList = new ArrayList<>();
            this.mRotXKfList = new ArrayList<>();
            this.mRotYKfList = new ArrayList<>();
            this.mScaXKfList = new ArrayList<>();
            this.mScaYKfList = new ArrayList<>();
            this.mBColorKfList = new ArrayList<>();
            this.mHasPercentageTransform = false;
            this.mHasTransform = false;
            this.mHasStartKeyframe = new HashSet();
            this.mHasEndKeyframe = new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class PauseTimeHelper {
        private long mPauseTime;

        private PauseTimeHelper() {
            this.mPauseTime = LynxKeyframeAnimator.sTimeNotInit;
        }

        public void recordPauseTime() {
            if (this.mPauseTime == LynxKeyframeAnimator.sTimeNotInit) {
                this.mPauseTime = System.currentTimeMillis();
            }
        }

        public long getPauseDuration() {
            if (this.mPauseTime == LynxKeyframeAnimator.sTimeNotInit) {
                return 0L;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.mPauseTime;
            this.mPauseTime = LynxKeyframeAnimator.sTimeNotInit;
            return currentTimeMillis;
        }
    }

    public LynxKeyframeAnimator(View view, LynxUI lynxUI) {
        this.mUI = new WeakReference<>(lynxUI);
        this.mView = new WeakReference<>(view);
    }

    public void apply(AnimationInfo animationInfo) {
        LLog.DCHECK(this.mInfo == null || animationInfo.getName().equals(this.mInfo.getName()));
        if (getUI() == null) {
            return;
        }
        int i = C15163.f2309x72243e43[this.mState.ordinal()];
        if (i == 1 || i == 2) {
            if (!(animationInfo.isEqualTo(this.mInfo) && this.mState == LynxKFAnimatorState.IDLE && !shouldReInitTransform()) && animationInfo.getIterationCount() >= 0 && animationInfo.getDuration() > 0) {
                applyAnimationInfo(animationInfo);
                return;
            }
            return;
        }
        if (i == 3 || i == 4) {
            if (!animationInfo.isEqualTo(this.mInfo) || shouldReInitTransform()) {
                if (animationInfo.isOnlyPlayStateChanged(this.mInfo)) {
                    if (this.mState == LynxKFAnimatorState.PAUSED) {
                        resume(animationInfo);
                        return;
                    } else {
                        pause(animationInfo);
                        return;
                    }
                }
                cancel();
                apply(animationInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C15163 {

        /* renamed from: $SwitchMap$com$lynx$tasm$animation$keyframe$LynxKeyframeAnimator$LynxKFAnimatorState */
        static final /* synthetic */ int[] f2309x72243e43;

        static {
            int[] iArr = new int[LynxKFAnimatorState.values().length];
            f2309x72243e43 = iArr;
            try {
                iArr[LynxKFAnimatorState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2309x72243e43[LynxKFAnimatorState.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2309x72243e43[LynxKFAnimatorState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2309x72243e43[LynxKFAnimatorState.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void sendCancelEvent() {
        if (this.mState == LynxKFAnimatorState.CANCELED || this.mState == LynxKFAnimatorState.RUNNING || this.mState == LynxKFAnimatorState.PAUSED) {
            LynxUI ui = getUI();
            AnimationInfo animationInfo = getAnimationInfo();
            KeyframeAnimationListener.sendAnimationEvent(ui, "animationcancel", animationInfo != null ? animationInfo.getName() : "");
        }
    }

    public void destroy() {
        sendCancelEvent();
        cancel();
        restoreAllViewOriginValue();
        this.mState = LynxKFAnimatorState.DESTROYED;
    }

    private boolean shouldReInitTransform() {
        LynxUI lynxUI = this.mUI.get();
        return isPercentTransform() && lynxUI != null && lynxUI.hasSizeChanged();
    }

    public void notifyPropertyUpdated(String str, Object obj) {
        if (this.mPropertyOriginValue.containsKey(str)) {
            this.mPropertyOriginValue.put(str, obj);
        }
        if (str.equals(sBackgroundColorStr) && this.mPropertyOriginValue.containsKey(sColorStr)) {
            this.mPropertyOriginValue.put(sColorStr, obj);
        }
    }

    public void onAttach() {
        addListenerToLastAnimator();
    }

    public void onDetach() {
        ObjectAnimator[] objectAnimatorArr = this.mInternalAnimators;
        if (objectAnimatorArr != null) {
            for (ObjectAnimator objectAnimator : objectAnimatorArr) {
                objectAnimator.removeAllListeners();
            }
        }
    }

    public void detachFromUI() {
        cancel();
        restoreAllViewOriginValue();
        this.mUI = null;
        this.mView = null;
    }

    public void attachToUI(LynxUI lynxUI) {
        this.mUI = new WeakReference<>(lynxUI);
        this.mView = new WeakReference<>(lynxUI.getView());
        applyAnimationInfo(this.mInfo);
    }

    public boolean isRunning() {
        return this.mState == LynxKFAnimatorState.RUNNING;
    }

    public AnimationInfo getAnimationInfo() {
        return this.mInfo;
    }

    private boolean isAnimationExpired(AnimationInfo animationInfo) {
        if (this.mKeyframeStartTime == sTimeNotInit) {
            return false;
        }
        return System.currentTimeMillis() - this.mKeyframeStartTime >= ((((double) animationInfo.getIterationCount()) > 9.99999999E8d ? 1 : (((double) animationInfo.getIterationCount()) == 9.99999999E8d ? 0 : -1)) >= 0 ? Clock.MAX_TIME : (animationInfo.getDuration() * ((long) (animationInfo.getIterationCount() + 1))) + animationInfo.getDelay());
    }

    private boolean isPercentTransform() {
        KeyframeParsedData keyframeParsedData = this.mKeyframeParsedData;
        if (keyframeParsedData != null && keyframeParsedData.mHasPercentageTransform) {
            return true;
        }
        TransformOrigin transformOriginStr = getUI().getTransformOriginStr();
        return transformOriginStr != null && transformOriginStr.hasPercent();
    }

    private void pause(AnimationInfo animationInfo) {
        LLog.DCHECK(animationInfo.getPlayState() == 0);
        LLog.DCHECK(this.mState == LynxKFAnimatorState.RUNNING);
        this.mState = LynxKFAnimatorState.PAUSED;
        if (this.mInternalAnimators != null) {
            for (ObjectAnimator objectAnimator : this.mInternalAnimators) {
                objectAnimator.pause();
            }
        }
        if (!isAnimationExpired(animationInfo)) {
            this.mPauseTimeHelper.recordPauseTime();
        }
        this.mInfo = animationInfo;
    }

    private void resume(AnimationInfo animationInfo) {
        LLog.DCHECK(animationInfo.getPlayState() == 1);
        LLog.DCHECK(this.mState == LynxKFAnimatorState.PAUSED);
        this.mState = LynxKFAnimatorState.RUNNING;
        if (this.mInternalAnimators != null) {
            for (ObjectAnimator objectAnimator : this.mInternalAnimators) {
                objectAnimator.resume();
            }
        }
        this.mKeyframeStartTime += this.mPauseTimeHelper.getPauseDuration();
        this.mInfo = animationInfo;
    }

    private void cancel() {
        if (this.mState == LynxKFAnimatorState.RUNNING || this.mState == LynxKFAnimatorState.PAUSED) {
            ObjectAnimator[] objectAnimatorArr = this.mInternalAnimators;
            if (objectAnimatorArr != null && objectAnimatorArr.length > 0) {
                for (ObjectAnimator objectAnimator : this.mInternalAnimators) {
                    objectAnimator.cancel();
                }
            }
            this.mInternalAnimators = null;
            this.mState = LynxKFAnimatorState.CANCELED;
        }
    }

    private void run() {
        LLog.DCHECK(this.mState == LynxKFAnimatorState.IDLE || this.mState == LynxKFAnimatorState.CANCELED);
        this.mState = LynxKFAnimatorState.RUNNING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        LLog.DCHECK(this.mState == LynxKFAnimatorState.RUNNING);
        this.mState = LynxKFAnimatorState.IDLE;
    }

    private void applyAnimationInfo(AnimationInfo animationInfo) {
        BackgroundDrawable backgroundDrawable;
        long j;
        int i = 1;
        LLog.DCHECK(this.mState == LynxKFAnimatorState.IDLE || this.mState == LynxKFAnimatorState.CANCELED);
        BackgroundDrawable view = getView();
        LynxUI ui = getUI();
        if (view == null || ui == null || animationInfo == null) {
            return;
        }
        if ((this.mKeyframeParsedData == null || shouldReInitTransform()) && !parseKeyframes(ui, animationInfo)) {
            LLog.m2577e("Lynx", "Keyframes input error.");
            return;
        }
        if (this.mKeyframeStartTime != sTimeNotInit && animationInfo.getPlayState() == 1) {
            this.mKeyframeStartTime += this.mPauseTimeHelper.getPauseDuration();
        }
        BackgroundDrawable backgroundDrawable2 = getBackgroundDrawable();
        int i2 = 2;
        int i3 = backgroundDrawable2 != null ? 2 : 1;
        ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            KeyframeParsedData keyframeParsedData = this.mKeyframeParsedData;
            PropertyValuesHolder[] propertyValuesHolderArr = i4 == i ? keyframeParsedData.mBGHolders : keyframeParsedData.mViewHolders;
            if (propertyValuesHolderArr == null) {
                backgroundDrawable = backgroundDrawable2;
            } else {
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(i4 == i ? backgroundDrawable2 : view, propertyValuesHolderArr);
                ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        LynxUI lynxUI = (LynxUI) LynxKeyframeAnimator.this.mUI.get();
                        if (lynxUI == null || !(lynxUI.getParent() instanceof UIShadowProxy)) {
                            return;
                        }
                        lynxUI.getParent().notifyAnimating();
                    }
                });
                objectAnimatorArr[i4] = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setDuration(animationInfo.getDuration());
                ofPropertyValuesHolder.setRepeatCount(animationInfo.getIterationCount());
                if (AnimationInfo.isDirectionAlternate(animationInfo)) {
                    ofPropertyValuesHolder.setRepeatMode(i2);
                } else {
                    ofPropertyValuesHolder.setRepeatMode(i);
                }
                ofPropertyValuesHolder.setInterpolator(InterpolatorFactory.getInterpolator(animationInfo));
                if (animationInfo.getDelay() == 0 || !AnimationInfo.isFillModeBackwards(animationInfo)) {
                    backgroundDrawable = backgroundDrawable2;
                } else {
                    ObjectAnimator clone = ofPropertyValuesHolder.clone();
                    backgroundDrawable = backgroundDrawable2;
                    clone.setDuration(10000000L);
                    clone.addListener(new StartListener());
                    clone.start();
                }
                i5++;
                if (animationInfo.getDelay() >= 0) {
                    ofPropertyValuesHolder.setStartDelay(animationInfo.getDelay());
                    j = sTimeNotInit;
                } else {
                    long delay = animationInfo.getDelay();
                    j = sTimeNotInit;
                    ofPropertyValuesHolder.setCurrentPlayTime(delay * sTimeNotInit);
                }
                if (this.mKeyframeStartTime != j) {
                    long currentTimeMillis = System.currentTimeMillis() - this.mKeyframeStartTime;
                    if (currentTimeMillis < animationInfo.getDelay()) {
                        ofPropertyValuesHolder.setStartDelay(animationInfo.getDelay() - currentTimeMillis);
                    } else {
                        ofPropertyValuesHolder.setCurrentPlayTime(currentTimeMillis - animationInfo.getDelay());
                    }
                }
                ofPropertyValuesHolder.start();
            }
            i4++;
            backgroundDrawable2 = backgroundDrawable;
            i = 1;
            i2 = 2;
        }
        if (i5 == 0) {
            this.mInternalAnimators = null;
        } else if (i5 == i3) {
            this.mInternalAnimators = objectAnimatorArr;
        } else {
            this.mInternalAnimators = new ObjectAnimator[i5];
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                ObjectAnimator objectAnimator = objectAnimatorArr[i7];
                if (objectAnimator != null) {
                    this.mInternalAnimators[i6] = objectAnimator;
                    i6++;
                }
            }
        }
        addListenerToLastAnimator();
        if (this.mKeyframeStartTime == sTimeNotInit) {
            this.mKeyframeStartTime = System.currentTimeMillis();
        }
        if (!isAnimationExpired(animationInfo)) {
            if (this.mState == LynxKFAnimatorState.IDLE) {
                KeyframeAnimationListener.sendAnimationEvent(ui, "animationstart", animationInfo.getName());
            }
            run();
            if (animationInfo.getPlayState() == 0) {
                pause(animationInfo);
            }
        }
        this.mInfo = animationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LynxUI getUI() {
        return this.mUI.get();
    }

    private View getView() {
        return this.mView.get();
    }

    private PropertyValuesHolder calHolder(ArrayList<Keyframe> arrayList, String str) {
        return PropertyValuesHolder.ofKeyframe(str, (Keyframe[]) arrayList.toArray(new Keyframe[arrayList.size()]));
    }

    private void calStartEnd(float f, LynxAnimationPropertyType lynxAnimationPropertyType, KeyframeParsedData keyframeParsedData) {
        if (f == 0.0f) {
            keyframeParsedData.mHasStartKeyframe.add(lynxAnimationPropertyType);
        }
        if (f == 1.0f) {
            keyframeParsedData.mHasEndKeyframe.add(lynxAnimationPropertyType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0018 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void restoreAllViewOriginValue() {
        View view = getView();
        LynxUI ui = getUI();
        if (ui == null || view == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.mPropertyOriginValue.entrySet()) {
            String key = entry.getKey();
            key.hashCode();
            char c = 65535;
            switch (key.hashCode()) {
                case -1238332596:
                    if (key.equals(sTransformStr)) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            if (ui.getBackgroundManager() != null) {
                                ui.getBackgroundManager().setTransform((List) entry.getValue());
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            view.setAlpha(((Float) entry.getValue()).floatValue());
                            break;
                        case 2:
                            getBackgroundDrawable().setColor(((Integer) entry.getValue()).intValue());
                            break;
                        case 3:
                            view.setBackgroundColor(((Integer) entry.getValue()).intValue());
                            break;
                    }
                    break;
                case 63357246:
                    if (key.equals(sAlphaStr)) {
                        c = 1;
                    }
                    switch (c) {
                    }
                    break;
                case 65290051:
                    if (key.equals(sColorStr)) {
                        c = 2;
                    }
                    switch (c) {
                    }
                    break;
                case 290107061:
                    if (key.equals(sBackgroundColorStr)) {
                        c = 3;
                    }
                    switch (c) {
                    }
                    break;
                default:
                    switch (c) {
                    }
                    break;
            }
        }
    }

    private void saveViewOriginValue(String str, Object obj) {
        if (this.mPropertyOriginValue.containsKey(str)) {
            return;
        }
        this.mPropertyOriginValue.put(str, obj);
    }

    private boolean parseKeyframes(LynxUI lynxUI, AnimationInfo animationInfo) {
        ReadableMap keyframes = lynxUI.getKeyframes(animationInfo.getName());
        if (keyframes == null) {
            return false;
        }
        KeyframeParsedData keyframeParsedData = new KeyframeParsedData();
        ReadableMapKeySetIterator keySetIterator = keyframes.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            float parseFloat = Float.parseFloat(nextKey);
            if (AnimationInfo.isDirectionReverse(animationInfo)) {
                parseFloat = 1.0f - parseFloat;
            }
            ReadableMap map = keyframes.getMap(nextKey);
            ReadableMapKeySetIterator keySetIterator2 = map.keySetIterator();
            while (keySetIterator2.hasNextKey()) {
                String nextKey2 = keySetIterator2.nextKey();
                if (nextKey2.equals(AnimationConstant.PROP_STR_OPACITY)) {
                    saveViewOriginValue(sAlphaStr, Float.valueOf(getView().getAlpha()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.OPACITY, keyframeParsedData);
                    float f = (float) map.getDouble(nextKey2);
                    if (f < 0.0f || f > 1.0f) {
                        return false;
                    }
                    keyframeParsedData.mOpaKfList.add(Keyframe.ofFloat(parseFloat, f));
                } else if (nextKey2.equals(AnimationConstant.PROP_STR_TRANSFORM)) {
                    saveViewOriginValue(sTransformStr, lynxUI.getTransformRaws());
                    List transformRaw = TransformRaw.toTransformRaw(map.getArray(nextKey2));
                    TransformProps processTransform = TransformProps.processTransform(transformRaw, lynxUI.getLynxContext().getUIBody().getFontSize(), lynxUI.getFontSize(), lynxUI.getLynxContext().getUIBody().getLatestWidth(), lynxUI.getLynxContext().getUIBody().getLatestHeight(), lynxUI.getLatestWidth(), lynxUI.getLatestHeight());
                    if (processTransform == null) {
                        return false;
                    }
                    keyframeParsedData.mHasTransform = true;
                    if (TransformRaw.hasPercent(transformRaw)) {
                        keyframeParsedData.mHasPercentageTransform = true;
                    }
                    calStartEnd(parseFloat, LynxAnimationPropertyType.TRANSLATE_X, keyframeParsedData);
                    keyframeParsedData.mTranXKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getTranslationX()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.TRANSLATE_Y, keyframeParsedData);
                    keyframeParsedData.mTranYKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getTranslationY()));
                    lynxUI.getView().setOutlineProvider(null);
                    calStartEnd(parseFloat, LynxAnimationPropertyType.TRANSLATE_Z, keyframeParsedData);
                    keyframeParsedData.mTranZKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getTranslationZ()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.ROTATE_Z, keyframeParsedData);
                    keyframeParsedData.mRotZKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getRotation()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.ROTATE_X, keyframeParsedData);
                    keyframeParsedData.mRotXKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getRotationX()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.ROTATE_Y, keyframeParsedData);
                    keyframeParsedData.mRotYKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getRotationY()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.SCALE_X, keyframeParsedData);
                    keyframeParsedData.mScaXKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getScaleX()));
                    calStartEnd(parseFloat, LynxAnimationPropertyType.SCALE_Y, keyframeParsedData);
                    keyframeParsedData.mScaYKfList.add(Keyframe.ofFloat(parseFloat, processTransform.getScaleY()));
                } else if (nextKey2.equals(AnimationConstant.PROP_STR_BACKGROUND_COLOR)) {
                    if (getBackgroundDrawable() == null) {
                        saveViewOriginValue(sBackgroundColorStr, Integer.valueOf(lynxUI.getBackgroundColor()));
                    } else {
                        saveViewOriginValue(sColorStr, Integer.valueOf(lynxUI.getBackgroundColor()));
                    }
                    calStartEnd(parseFloat, LynxAnimationPropertyType.BG_COLOR, keyframeParsedData);
                    keyframeParsedData.mBColorKfList.add(Keyframe.ofInt(parseFloat, map.getInt(nextKey2)));
                }
            }
        }
        int i = getBackgroundDrawable() != null ? 2 : 1;
        for (int i2 = 0; i2 < i; i2++) {
            PropertyValuesHolder[] calKfHolder = calKfHolder(i2, i, keyframeParsedData);
            if (calKfHolder != null) {
                if (i2 == 0) {
                    keyframeParsedData.mViewHolders = calKfHolder;
                } else if (i2 == 1) {
                    keyframeParsedData.mBGHolders = calKfHolder;
                }
            }
        }
        this.mKeyframeParsedData = keyframeParsedData;
        return true;
    }

    private PropertyValuesHolder[] calKfHolder(int i, int i2, KeyframeParsedData keyframeParsedData) {
        PropertyValuesHolder calHolder;
        View view = getView();
        LynxUI ui = getUI();
        if (view != null && ui != null) {
            ArrayList arrayList = new ArrayList();
            Comparator<Keyframe> comparator = new Comparator<Keyframe>() { // from class: com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator.2
                @Override // java.util.Comparator
                public int compare(Keyframe keyframe, Keyframe keyframe2) {
                    return Float.compare(keyframe.getFraction(), keyframe2.getFraction());
                }
            };
            if (keyframeParsedData.mOpaKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.OPACITY)) {
                    keyframeParsedData.mOpaKfList.add(Keyframe.ofFloat(0.0f, view.getAlpha()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.OPACITY)) {
                    keyframeParsedData.mOpaKfList.add(Keyframe.ofFloat(1.0f, view.getAlpha()));
                }
                Collections.sort(keyframeParsedData.mOpaKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mOpaKfList, sAlphaStr));
            }
            if (keyframeParsedData.mTranXKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.TRANSLATE_X)) {
                    keyframeParsedData.mTranXKfList.add(Keyframe.ofFloat(0.0f, view.getTranslationX()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.TRANSLATE_X)) {
                    keyframeParsedData.mTranXKfList.add(Keyframe.ofFloat(1.0f, view.getTranslationX()));
                }
                Collections.sort(keyframeParsedData.mTranXKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mTranXKfList, sTranslationXStr));
            }
            if (keyframeParsedData.mTranYKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.TRANSLATE_Y)) {
                    keyframeParsedData.mTranYKfList.add(Keyframe.ofFloat(0.0f, view.getTranslationY()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.TRANSLATE_Y)) {
                    keyframeParsedData.mTranYKfList.add(Keyframe.ofFloat(1.0f, view.getTranslationY()));
                }
                Collections.sort(keyframeParsedData.mTranYKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mTranYKfList, sTranslationYStr));
            }
            if (keyframeParsedData.mTranZKfList.size() != 0 && i == 0) {
                float translationZ = view.getTranslationZ();
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.TRANSLATE_Z)) {
                    keyframeParsedData.mTranZKfList.add(Keyframe.ofFloat(0.0f, translationZ));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.TRANSLATE_Z)) {
                    keyframeParsedData.mTranZKfList.add(Keyframe.ofFloat(1.0f, translationZ));
                }
                Collections.sort(keyframeParsedData.mTranZKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mTranZKfList, sTranslationZStr));
            }
            if (keyframeParsedData.mRotZKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.ROTATE_Z)) {
                    keyframeParsedData.mRotZKfList.add(Keyframe.ofFloat(0.0f, view.getRotation()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.ROTATE_Z)) {
                    keyframeParsedData.mRotZKfList.add(Keyframe.ofFloat(1.0f, view.getRotation()));
                }
                Collections.sort(keyframeParsedData.mRotZKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mRotZKfList, sRotationZStr));
            }
            if (keyframeParsedData.mRotXKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.ROTATE_X)) {
                    keyframeParsedData.mRotXKfList.add(Keyframe.ofFloat(0.0f, view.getRotationX()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.ROTATE_X)) {
                    keyframeParsedData.mRotXKfList.add(Keyframe.ofFloat(1.0f, view.getRotationX()));
                }
                Collections.sort(keyframeParsedData.mRotXKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mRotXKfList, sRotationXStr));
            }
            if (keyframeParsedData.mRotYKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.ROTATE_Y)) {
                    keyframeParsedData.mRotYKfList.add(Keyframe.ofFloat(0.0f, view.getRotationY()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.ROTATE_Y)) {
                    keyframeParsedData.mRotYKfList.add(Keyframe.ofFloat(1.0f, view.getRotationY()));
                }
                Collections.sort(keyframeParsedData.mRotYKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mRotYKfList, sRotationYStr));
            }
            if (keyframeParsedData.mScaXKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.SCALE_X)) {
                    keyframeParsedData.mScaXKfList.add(Keyframe.ofFloat(0.0f, view.getScaleX()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.SCALE_X)) {
                    keyframeParsedData.mScaXKfList.add(Keyframe.ofFloat(1.0f, view.getScaleX()));
                }
                Collections.sort(keyframeParsedData.mScaXKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mScaXKfList, sScaleXStr));
            }
            if (keyframeParsedData.mScaYKfList.size() != 0 && i == 0) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.SCALE_Y)) {
                    keyframeParsedData.mScaYKfList.add(Keyframe.ofFloat(0.0f, view.getScaleY()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.SCALE_Y)) {
                    keyframeParsedData.mScaYKfList.add(Keyframe.ofFloat(1.0f, view.getScaleY()));
                }
                Collections.sort(keyframeParsedData.mScaYKfList, comparator);
                arrayList.add(calHolder(keyframeParsedData.mScaYKfList, sScaleYStr));
            }
            if (keyframeParsedData.mBColorKfList.size() != 0 && i + 1 == i2) {
                if (!keyframeParsedData.mHasStartKeyframe.contains(LynxAnimationPropertyType.BG_COLOR)) {
                    keyframeParsedData.mBColorKfList.add(Keyframe.ofInt(0.0f, ui.getBackgroundColor()));
                }
                if (!keyframeParsedData.mHasEndKeyframe.contains(LynxAnimationPropertyType.BG_COLOR)) {
                    keyframeParsedData.mBColorKfList.add(Keyframe.ofInt(1.0f, ui.getBackgroundColor()));
                }
                Collections.sort(keyframeParsedData.mBColorKfList, comparator);
                if (i == 0) {
                    calHolder = calHolder(keyframeParsedData.mBColorKfList, sBackgroundColorStr);
                } else {
                    calHolder = calHolder(keyframeParsedData.mBColorKfList, sColorStr);
                }
                calHolder.setEvaluator(new ArgbEvaluator());
                arrayList.add(calHolder);
            }
            if (arrayList.size() != 0) {
                return (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]);
            }
        }
        return null;
    }

    private BackgroundDrawable getBackgroundDrawable() {
        BackgroundManager backgroundManager;
        LynxUI ui = getUI();
        if (ui == null || (backgroundManager = ui.getBackgroundManager()) == null) {
            return null;
        }
        return backgroundManager.getDrawable();
    }

    private void addListenerToLastAnimator() {
        int length;
        ObjectAnimator[] objectAnimatorArr = this.mInternalAnimators;
        if (objectAnimatorArr != null && (length = objectAnimatorArr.length) > 0) {
            objectAnimatorArr[length - 1].addListener(new KeyframeAnimationListener(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class StartListener extends AnimatorListenerAdapter {
        private StartListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class KeyframeAnimationListener extends AnimatorListenerAdapter {
        private static final String EVENT_CANCEL = "animationcancel";
        private static final String EVENT_END = "animationend";
        private static final String EVENT_ITERATION = "animationiteration";
        private static final String EVENT_START = "animationstart";
        private static Map<String, Object> sEventParams;
        WeakReference<LynxKeyframeAnimator> mLynxAnimatorRef;

        static {
            HashMap hashMap = new HashMap();
            sEventParams = hashMap;
            hashMap.put("animation_type", "keyframe-animation");
            sEventParams.put("animation_name", "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void sendAnimationEvent(LynxUI lynxUI, String str, String str2) {
            if (lynxUI == null || lynxUI.getEvents() == null || !lynxUI.getEvents().containsKey(str)) {
                return;
            }
            sEventParams.put("animation_name", str2);
            lynxUI.getLynxContext().getEventEmitter().sendCustomEvent(new LynxCustomEvent(lynxUI.getSign(), str, sEventParams));
        }

        public KeyframeAnimationListener(LynxKeyframeAnimator lynxKeyframeAnimator) {
            this.mLynxAnimatorRef = new WeakReference<>(lynxKeyframeAnimator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            if (animator != null) {
                animator.removeAllListeners();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            LynxKeyframeAnimator lynxKeyframeAnimator = this.mLynxAnimatorRef.get();
            if (lynxKeyframeAnimator == null) {
                return;
            }
            AnimationInfo animationInfo = lynxKeyframeAnimator.getAnimationInfo();
            sendAnimationEvent(lynxKeyframeAnimator.getUI(), EVENT_ITERATION, animationInfo != null ? animationInfo.getName() : "");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LynxKeyframeAnimator lynxKeyframeAnimator = this.mLynxAnimatorRef.get();
            if (lynxKeyframeAnimator == null) {
                return;
            }
            AnimationInfo animationInfo = lynxKeyframeAnimator.getAnimationInfo();
            String name = animationInfo != null ? animationInfo.getName() : "";
            if (lynxKeyframeAnimator.isRunning()) {
                LynxUI ui = lynxKeyframeAnimator.getUI();
                sendAnimationEvent(ui, EVENT_END, name);
                if (ui != null) {
                    ui.onAnimationEnd(name);
                }
                lynxKeyframeAnimator.finish();
            }
            if (animationInfo != null && !AnimationInfo.isFillModeForwards(animationInfo)) {
                lynxKeyframeAnimator.restoreAllViewOriginValue();
            }
            lynxKeyframeAnimator.mInternalAnimators = null;
        }
    }
}
