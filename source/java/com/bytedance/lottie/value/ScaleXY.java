package com.bytedance.lottie.value;

import com.bytedance.lottie.utils.ObjectPool;

/* loaded from: classes4.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float f, float f2) {
        this.scaleX = f;
        this.scaleY = f2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    /* loaded from: classes4.dex */
    public static class Pool extends ObjectPool<ScaleXY> {
        private static final Pool POOL = new Pool();

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.lottie.utils.ObjectPool
        public ScaleXY[] initArray(int i) {
            return new ScaleXY[i];
        }

        public static ScaleXY obtain(float f, float f2) {
            ScaleXY poll = POOL.poll();
            if (poll != null) {
                poll.scaleX = f;
                poll.scaleY = f2;
                return poll;
            }
            return new ScaleXY(f, f2);
        }

        public static void recycle(ScaleXY scaleXY) {
            POOL.offer(scaleXY);
        }
    }
}
