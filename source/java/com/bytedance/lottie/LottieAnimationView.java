package com.bytedance.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.lottie.model.KeyPath;
import com.bytedance.lottie.utils.ContextUtil;
import com.bytedance.lottie.value.LottieFrameInfo;
import com.bytedance.lottie.value.LottieValueCallback;
import com.bytedance.lottie.value.SimpleLottieValueCallback;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LottieAnimationView extends AppCompatImageView implements LifecycleObserver {
    private static boolean ONLY_ABOVE_M_USE_HARDWARE = false;
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private boolean autoRecycleBitmap;
    private int buildDrawingCacheDepth;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private boolean disableRecycleBitmap;
    private final LottieListener<Throwable> failureListener;
    private boolean isPaused;
    private boolean isRunningBefore;
    private boolean isRunningBeforeInvisible;
    private boolean isRunningBeforePaused;
    private boolean isVisible;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    private LifecycleOwner mLifecycleOwner;
    private RenderMode renderMode;
    private boolean started;
    private boolean useHardwareLayer;
    private boolean wasAnimatingWhenDetached;

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new LottieListener<LottieComposition>() { // from class: com.bytedance.lottie.LottieAnimationView.1
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.failureListener = new LottieListener<Throwable>() { // from class: com.bytedance.lottie.LottieAnimationView.2
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieMonitor.reportError("parse_composition_error", th);
            }
        };
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.autoRecycleBitmap = true;
        this.disableRecycleBitmap = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.renderMode = RenderMode.AUTOMATIC;
        this.buildDrawingCacheDepth = 0;
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new LottieListener<LottieComposition>() { // from class: com.bytedance.lottie.LottieAnimationView.1
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.failureListener = new LottieListener<Throwable>() { // from class: com.bytedance.lottie.LottieAnimationView.2
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieMonitor.reportError("parse_composition_error", th);
            }
        };
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.autoRecycleBitmap = true;
        this.disableRecycleBitmap = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.renderMode = RenderMode.AUTOMATIC;
        this.buildDrawingCacheDepth = 0;
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new LottieListener<LottieComposition>() { // from class: com.bytedance.lottie.LottieAnimationView.1
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.failureListener = new LottieListener<Throwable>() { // from class: com.bytedance.lottie.LottieAnimationView.2
            @Override // com.bytedance.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieMonitor.reportError("parse_composition_error", th);
            }
        };
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.useHardwareLayer = false;
        this.autoRecycleBitmap = true;
        this.disableRecycleBitmap = false;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.renderMode = RenderMode.AUTOMATIC;
        this.buildDrawingCacheDepth = 0;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0267R.styleable.LottieDiamondAnimationView);
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        boolean z = obtainStyledAttributes.getBoolean(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_auto_recycle_bitmap, true);
        this.autoRecycleBitmap = z;
        this.lottieDrawable.setAutoRecycleBitmaps(z);
        if (obtainStyledAttributes.getBoolean(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_loop, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_repeatCount, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(C0267R.styleable.f37x984bce5e, false));
        if (obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_colorFilter)) {
            addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(obtainStyledAttributes.getColor(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_scale)) {
            this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(C0267R.styleable.LottieDiamondAnimationView_lottie_diamond_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        enableOrDisableHardwareLayer();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (this.isPaused) {
            this.isPaused = false;
            if (this.isRunningBefore && this.isVisible) {
                resumeAnimation();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        if (this.isPaused) {
            return;
        }
        this.isPaused = true;
        boolean isAnimating = isAnimating();
        if (this.isVisible) {
            this.isRunningBefore = isAnimating;
        }
        if (isAnimating) {
            pauseAnimation();
        }
    }

    public void registerLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (this.mLifecycleOwner != lifecycleOwner) {
            if (isActivated()) {
                unregisterLifecycleOwnerInner(this.mLifecycleOwner);
                registerLifecycleOwnerInner(lifecycleOwner);
            }
            this.mLifecycleOwner = lifecycleOwner;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void registerLifecycleOwnerInner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(this);
            return;
        }
        LifecycleOwner activity = ContextUtil.getActivity((View) this);
        if (activity instanceof LifecycleOwner) {
            activity.getLifecycle().addObserver(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void unregisterLifecycleOwnerInner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            return;
        }
        LifecycleOwner activity = ContextUtil.getActivity((View) this);
        if (activity instanceof LifecycleOwner) {
            activity.getLifecycle().removeObserver(this);
        }
    }

    private String showLottieStatus(String str) {
        return toString() + str + " isvisible:" + this.isVisible + " isPaused: " + this.isPaused + " isStarted: " + this.started + " isRunningBefore: " + this.isRunningBefore;
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.lottieDrawable != null) {
            if (i == 0 && isShown()) {
                if (this.isVisible) {
                    return;
                }
                this.isVisible = true;
                if (this.isPaused || !this.isRunningBefore) {
                    return;
                }
                resumeAnimation();
                return;
            }
            if (this.isVisible) {
                this.isVisible = false;
                boolean isAnimating = isAnimating();
                if (!this.isPaused) {
                    this.isRunningBefore = isAnimating;
                }
                if (isAnimating) {
                    pauseAnimation();
                }
            }
        }
    }

    public void setImageResource(int i) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        setImageDrawable(drawable, true);
    }

    private void setImageDrawable(Drawable drawable, boolean z) {
        if (z && drawable != this.lottieDrawable) {
            recycleBitmaps();
        }
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        recycleBitmaps();
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.isAnimating = this.lottieDrawable.isAnimating();
        savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        savedState.repeatMode = this.lottieDrawable.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.animationResId;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
        registerLifecycleOwnerInner(this.mLifecycleOwner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        Activity activity = ContextUtil.getActivity((View) this);
        if (!this.disableRecycleBitmap && (this.autoRecycleBitmap || (activity != null && activity.isFinishing()))) {
            forceRecycleBitmaps();
        }
        super.onDetachedFromWindow();
        unregisterLifecycleOwnerInner(this.mLifecycleOwner);
    }

    public boolean isAutoRecycleBitmap() {
        return this.autoRecycleBitmap;
    }

    public void setAutoRecycleBitmap(boolean z) {
        this.autoRecycleBitmap = z;
        this.lottieDrawable.setAutoRecycleBitmaps(z);
    }

    public void disableRecycleBitmap() {
        this.disableRecycleBitmap = true;
        setAutoRecycleBitmap(false);
        this.lottieDrawable.disableRecycleBitmaps();
    }

    public void forceRecycleBitmaps() {
        this.lottieDrawable.recycleBitmaps();
    }

    void recycleBitmaps() {
        if (this.autoRecycleBitmap) {
            this.lottieDrawable.recycleBitmaps();
        }
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    @Deprecated
    public void useExperimentalHardwareAcceleration(boolean z) {
        useHardwareAcceleration(z);
    }

    public void useHardwareAcceleration() {
        useHardwareAcceleration(true);
    }

    public void useHardwareAcceleration(boolean z) {
        if (this.useHardwareLayer == z) {
            return;
        }
        this.useHardwareLayer = z;
        enableOrDisableHardwareLayer();
    }

    public boolean getUseHardwareAcceleration() {
        return this.useHardwareLayer;
    }

    public void setAnimation(int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), i));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new JsonReader(new StringReader(str)), str2);
    }

    public void setAnimation(JsonReader jsonReader, String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonReader(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str));
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.failureListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setComposition(LottieComposition lottieComposition) {
        if (C0225L.DBG) {
            Log.v(TAG, "Set Composition \n" + lottieComposition);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        boolean composition = this.lottieDrawable.setComposition(lottieComposition);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || composition) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<LottieOnCompositionLoadedListener> it = this.lottieOnCompositionLoadedListeners.iterator();
            while (it.hasNext()) {
                it.next().onCompositionLoaded(lottieComposition);
            }
        }
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void playAnimation() {
        this.started = true;
        this.lottieDrawable.playAnimation();
        this.isRunningBefore = true;
        enableOrDisableHardwareLayer();
    }

    public void resumeAnimation() {
        this.lottieDrawable.resumeAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isAnimationStarted() {
        return this.started;
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) lottieValueCallback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.bytedance.lottie.LottieAnimationView.3
            @Override // com.bytedance.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setScale(float f) {
        this.lottieDrawable.setScale(f);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null, false);
            setImageDrawable(this.lottieDrawable, false);
        }
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public void cancelAnimation() {
        this.started = false;
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void stopAnimation() {
        this.started = false;
        this.lottieDrawable.endAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(float f) {
        this.lottieDrawable.setProgress(f);
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        if (this.composition != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    public void buildDrawingCache(boolean z) {
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        enableOrDisableHardwareLayer();
    }

    public static void setOnlyAboveMUseHardware(boolean z) {
        ONLY_ABOVE_M_USE_HARDWARE = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.lottie.LottieAnimationView$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C02294 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$lottie$RenderMode;

        static {
            int[] iArr = new int[RenderMode.values().length];
            $SwitchMap$com$bytedance$lottie$RenderMode = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r3 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void enableOrDisableHardwareLayer() {
        LottieComposition lottieComposition;
        int i = C02294.$SwitchMap$com$bytedance$lottie$RenderMode[this.renderMode.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i != 2 && i == 3) {
                LottieComposition lottieComposition2 = this.composition;
                boolean z = false;
                if ((lottieComposition2 == null || !lottieComposition2.hasDashPattern() || Build.VERSION.SDK_INT >= 28) && ((lottieComposition = this.composition) == null || lottieComposition.getMaskAndMatteCount() <= 4)) {
                    z = true;
                }
                boolean z2 = ONLY_ABOVE_M_USE_HARDWARE;
            }
            i2 = 1;
        }
        if (i2 != getLayerType()) {
            setLayerType(i2, null);
        }
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bytedance.lottie.LottieAnimationView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateComposition(LottieComposition lottieComposition) {
        if (C0225L.DBG) {
            Log.v(TAG, "Update Composition \n" + lottieComposition);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        this.lottieDrawable.forceUpdateComposition(lottieComposition);
        enableOrDisableHardwareLayer();
        setImageDrawable(null);
        setImageDrawable(this.lottieDrawable);
        requestLayout();
        Iterator<LottieOnCompositionLoadedListener> it = this.lottieOnCompositionLoadedListeners.iterator();
        while (it.hasNext()) {
            it.next().onCompositionLoaded(lottieComposition);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        super.onDraw(canvas);
    }
}
