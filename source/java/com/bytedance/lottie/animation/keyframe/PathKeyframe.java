package com.bytedance.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.utils.Utils;
import com.bytedance.lottie.value.Keyframe;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PathKeyframe extends Keyframe<PointF> {
    private Path path;

    /* JADX WARN: Multi-variable type inference failed */
    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        boolean z = (this.endValue == 0 || this.startValue == 0 || !((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y)) ? false : true;
        if (this.endValue == 0 || z) {
            return;
        }
        this.path = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, keyframe.pathCp1, keyframe.pathCp2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path getPath() {
        return this.path;
    }
}
