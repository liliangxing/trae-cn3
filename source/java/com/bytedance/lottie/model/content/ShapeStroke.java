package com.bytedance.lottie.model.content;

import android.graphics.Paint;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.animation.content.Content;
import com.bytedance.lottie.animation.content.StrokeContent;
import com.bytedance.lottie.model.animatable.AnimatableColorValue;
import com.bytedance.lottie.model.animatable.AnimatableFloatValue;
import com.bytedance.lottie.model.animatable.AnimatableIntegerValue;
import com.bytedance.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeStroke implements ContentModel {
    private final LineCapType capType;
    private final AnimatableColorValue color;
    private final LineJoinType joinType;
    private final List<AnimatableFloatValue> lineDashPattern;
    private final float miterLimit;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableIntegerValue opacity;
    private final AnimatableFloatValue width;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = C02711.f40xe4f4c83e[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* renamed from: com.bytedance.lottie.model.content.ShapeStroke$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static /* synthetic */ class C02711 {

        /* renamed from: $SwitchMap$com$bytedance$lottie$model$content$ShapeStroke$LineCapType */
        static final /* synthetic */ int[] f40xe4f4c83e;

        /* renamed from: $SwitchMap$com$bytedance$lottie$model$content$ShapeStroke$LineJoinType */
        static final /* synthetic */ int[] f41x6acf7fb2;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f41x6acf7fb2 = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41x6acf7fb2[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41x6acf7fb2[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f40xe4f4c83e = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40xe4f4c83e[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40xe4f4c83e[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = C02711.f41x6acf7fb2[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.offset = animatableFloatValue;
        this.lineDashPattern = list;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
        this.width = animatableFloatValue2;
        this.capType = lineCapType;
        this.joinType = lineJoinType;
        this.miterLimit = f;
    }

    @Override // com.bytedance.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }

    public String getName() {
        return this.name;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getWidth() {
        return this.width;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.lineDashPattern;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.offset;
    }

    public LineCapType getCapType() {
        return this.capType;
    }

    public LineJoinType getJoinType() {
        return this.joinType;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }
}
