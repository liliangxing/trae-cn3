package com.bytedance.ies.bullet.service.popup.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import com.bytedance.ies.bullet.service.popup.ui.AnimController;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001dJF\u0010\u001f\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001dJ:\u0010 \u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001dH\u0002J<\u0010!\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001dH\u0002J\u0006\u0010\"\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006$"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AnimController;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "enterAnimProcessType", "Lcom/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType;", "getEnterAnimProcessType", "()Lcom/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType;", "setEnterAnimProcessType", "(Lcom/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType;)V", "exitAnimProcessType", "getExitAnimProcessType", "setExitAnimProcessType", "doEnterAnim", "", "maskView", "Landroid/view/View;", "anim", "Landroid/animation/ObjectAnimator;", "duration", "", "succUnits", "Lkotlin/Function0;", "animProgressListener", "Lkotlin/Function1;", "", "doExitAnim", "getContainerEnterAnim", "getContainerExitAnim", "refresh", "AnimProcessType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimController {
    private long endTime;
    private AnimProcessType enterAnimProcessType = AnimProcessType.NONE;
    private AnimProcessType exitAnimProcessType = AnimProcessType.NONE;

    /* compiled from: AnimController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/AnimController$AnimProcessType;", "", "(Ljava/lang/String;I)V", "NONE", "DOING", "DONE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public enum AnimProcessType {
        NONE,
        DOING,
        DONE
    }

    public final AnimProcessType getEnterAnimProcessType() {
        return this.enterAnimProcessType;
    }

    public final void setEnterAnimProcessType(AnimProcessType animProcessType) {
        Intrinsics.checkNotNullParameter(animProcessType, "<set-?>");
        this.enterAnimProcessType = animProcessType;
    }

    public final AnimProcessType getExitAnimProcessType() {
        return this.exitAnimProcessType;
    }

    public final void setExitAnimProcessType(AnimProcessType animProcessType) {
        Intrinsics.checkNotNullParameter(animProcessType, "<set-?>");
        this.exitAnimProcessType = animProcessType;
    }

    public final void refresh() {
        this.enterAnimProcessType = AnimProcessType.NONE;
        this.exitAnimProcessType = AnimProcessType.NONE;
    }

    public final void doEnterAnim(View maskView, ObjectAnimator anim, int duration, Function0<Unit> succUnits, Function1<? super Float, Unit> animProgressListener) {
        Intrinsics.checkNotNullParameter(succUnits, "succUnits");
        Intrinsics.checkNotNullParameter(animProgressListener, "animProgressListener");
        if (this.enterAnimProcessType != AnimProcessType.NONE) {
            return;
        }
        if (anim == null) {
            succUnits.invoke();
            return;
        }
        if (maskView != null) {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(maskView, "alpha", 0.0f, 1.0f).setDuration(300L);
            Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(maskView, \"alpha…0f, 1f).setDuration(300L)");
            ObjectAnimator containerEnterAnim = getContainerEnterAnim(anim, duration, succUnits, animProgressListener);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(duration2, containerEnterAnim);
            animatorSet.start();
            return;
        }
        getContainerEnterAnim(anim, duration, succUnits, animProgressListener).start();
    }

    private final ObjectAnimator getContainerEnterAnim(ObjectAnimator anim, int duration, final Function0<Unit> succUnits, final Function1<? super Float, Unit> animProgressListener) {
        anim.setDuration(duration);
        anim.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AnimController$getContainerEnterAnim$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimController.this.setEnterAnimProcessType(AnimController.AnimProcessType.DOING);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimController.this.setEnterAnimProcessType(AnimController.AnimProcessType.DONE);
                succUnits.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimController.this.setEnterAnimProcessType(AnimController.AnimProcessType.DONE);
                succUnits.invoke();
            }
        });
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AnimController$getContainerEnterAnim$2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function1<Float, Unit> function1 = animProgressListener;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    function1.invoke(Float.valueOf(animation.getAnimatedFraction()));
                    Result.m10253constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m10253constructorimpl(ResultKt.createFailure(th));
                }
            }
        });
        return anim;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void doExitAnim(View maskView, ObjectAnimator anim, int duration, Function0<Unit> succUnits, Function1<? super Float, Unit> animProgressListener) {
        Intrinsics.checkNotNullParameter(succUnits, "succUnits");
        Intrinsics.checkNotNullParameter(animProgressListener, "animProgressListener");
        if (this.exitAnimProcessType != AnimProcessType.NONE) {
            long currentTimeMillis = this.endTime - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                long j = duration;
                if (currentTimeMillis > j) {
                    Log.e("bullet", "doExitAnim with long sleep time " + currentTimeMillis);
                    Thread.sleep(j);
                } else {
                    Thread.sleep(currentTimeMillis);
                }
            }
            succUnits.invoke();
            return;
        }
        if (anim == null) {
            succUnits.invoke();
            return;
        }
        if (maskView != null) {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(maskView, "alpha", 1.0f, 0.0f).setDuration(duration);
            Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(maskView, \"alpha…ration(duration.toLong())");
            ObjectAnimator containerExitAnim = getContainerExitAnim(anim, duration, succUnits, animProgressListener);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(duration2, containerExitAnim);
            animatorSet.start();
        } else {
            getContainerExitAnim(anim, duration, succUnits, animProgressListener).start();
        }
        this.endTime = System.currentTimeMillis() + duration;
    }

    private final ObjectAnimator getContainerExitAnim(ObjectAnimator anim, int duration, final Function0<Unit> succUnits, final Function1<? super Float, Unit> animProgressListener) {
        anim.setDuration(duration);
        anim.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AnimController$getContainerExitAnim$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimController.this.setExitAnimProcessType(AnimController.AnimProcessType.DOING);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimController.this.setExitAnimProcessType(AnimController.AnimProcessType.DONE);
                succUnits.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                AnimController.this.setExitAnimProcessType(AnimController.AnimProcessType.DONE);
                succUnits.invoke();
            }
        });
        if (animProgressListener != null) {
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.AnimController$getContainerExitAnim$2$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Function1<Float, Unit> function1 = animProgressListener;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        Result.m10253constructorimpl(function1.invoke(Float.valueOf(animation.getAnimatedFraction())));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m10253constructorimpl(ResultKt.createFailure(th));
                    }
                }
            });
        }
        return anim;
    }
}
