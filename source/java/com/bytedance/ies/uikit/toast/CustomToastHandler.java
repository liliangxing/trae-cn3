package com.bytedance.ies.uikit.toast;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public class CustomToastHandler extends Handler {
    private static final int HIDE_TOAST = 1110;
    private static final int SHOWNEXT_TOAST = 1929;
    private static final int SHOW_TOAST = 291;
    private static CustomToastHandler mToastHandler;
    private boolean isShowing;
    private final Queue<CustomToast> mQueue;
    private int mQueueLength;

    private CustomToastHandler(Looper looper) {
        super(looper);
        this.isShowing = false;
        this.mQueueLength = 5;
        this.mQueue = new ConcurrentLinkedQueue();
    }

    public static synchronized CustomToastHandler getInstance() {
        synchronized (CustomToastHandler.class) {
            CustomToastHandler customToastHandler = mToastHandler;
            if (customToastHandler != null) {
                return customToastHandler;
            }
            CustomToastHandler customToastHandler2 = new CustomToastHandler(Looper.getMainLooper());
            mToastHandler = customToastHandler2;
            return customToastHandler2;
        }
    }

    public void onStop(Context context) {
        removeMessages(SHOWNEXT_TOAST);
        int size = this.mQueue.size();
        for (int i = 0; i < size; i++) {
            CustomToast poll = this.mQueue.poll();
            if (poll != null) {
                if (poll.getContext() == context) {
                    removeMessages(1110, poll);
                    poll.onStop();
                } else {
                    this.mQueue.add(poll);
                }
            }
        }
        if (!this.mQueue.isEmpty()) {
            sendEmptyMessage(SHOWNEXT_TOAST);
        }
        this.isShowing = false;
    }

    public void onPause(Context context) {
        for (CustomToast customToast : this.mQueue) {
            if (customToast != null && customToast.getContext() == context) {
                customToast.onPause();
            }
        }
    }

    public void onResume(Context context) {
        for (CustomToast customToast : this.mQueue) {
            if (customToast != null && customToast.getContext() == context) {
                customToast.onResume();
            }
        }
    }

    public void add(CustomToast customToast) {
        if (this.mQueue.contains(customToast) || this.mQueue.size() > this.mQueueLength) {
            return;
        }
        this.mQueue.offer(customToast);
        if (this.isShowing) {
            return;
        }
        sendEmptyMessage(SHOWNEXT_TOAST);
    }

    public void setQueueLength(int i) {
        this.mQueueLength = i;
    }

    public void remove(CustomToast customToast) {
        this.mQueue.remove(customToast);
        while (this.mQueue.contains(customToast)) {
            this.mQueue.remove(customToast);
        }
    }

    public void dismiss() {
        CustomToast peek = this.mQueue.peek();
        if (peek != null) {
            peek.dismiss();
        }
    }

    public void showNextToast() {
        if (this.mQueue.isEmpty()) {
            return;
        }
        CustomToast peek = this.mQueue.peek();
        if (peek != null && peek.isToastRelease()) {
            peek.dismiss();
            this.mQueue.poll();
            showNextToast();
        } else {
            if (peek == null || peek.isShowing()) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 291;
            obtain.obj = peek;
            sendMessage(obtain);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        CustomToast customToast = (CustomToast) message.obj;
        int i = message.what;
        if (i == 291) {
            showToast(customToast);
        } else if (i == 1110) {
            hideToast(customToast);
        } else {
            if (i != SHOWNEXT_TOAST) {
                return;
            }
            showNextToast();
        }
    }

    public void hideToast(final CustomToast customToast) {
        if (!customToast.isShowing() || customToast.isToastRelease()) {
            customToast.dismiss();
            this.isShowing = false;
            this.mQueue.remove(customToast);
            sendEmptyMessage(SHOWNEXT_TOAST);
            return;
        }
        if (!this.mQueue.contains(customToast)) {
            this.isShowing = false;
            removeMessages(1110);
            sendEmptyMessage(SHOWNEXT_TOAST);
        } else {
            AnimatorSet hideAnimatorSet = customToast.getHideAnimatorSet();
            hideAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.ies.uikit.toast.CustomToastHandler.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    customToast.setDismissing(true);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    customToast.setDismissing(false);
                    customToast.dismiss();
                    CustomToastHandler.this.isShowing = false;
                    CustomToastHandler.this.removeMessages(1110);
                    CustomToastHandler.this.sendEmptyMessage(CustomToastHandler.SHOWNEXT_TOAST);
                }
            });
            hideAnimatorSet.start();
            this.mQueue.poll();
        }
    }

    private void showToast(CustomToast customToast) {
        if (customToast.isShowing()) {
            return;
        }
        customToast.show();
        this.isShowing = true;
        customToast.getShowAnimatorSet().start();
        Message obtain = Message.obtain();
        obtain.what = 1110;
        obtain.obj = customToast;
        sendMessageDelayed(obtain, customToast.getDuration());
    }
}
