package com.bytedance.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.LottieProperty;
import com.bytedance.lottie.TextDelegate;
import com.bytedance.lottie.animation.content.ContentGroup;
import com.bytedance.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.bytedance.lottie.animation.keyframe.TextKeyframeAnimation;
import com.bytedance.lottie.model.DocumentData;
import com.bytedance.lottie.model.Font;
import com.bytedance.lottie.model.FontCharacter;
import com.bytedance.lottie.model.animatable.AnimatableTextProperties;
import com.bytedance.lottie.model.content.ShapeGroup;
import com.bytedance.lottie.utils.Utils;
import com.bytedance.lottie.value.LottieValueCallback;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TextLayer extends BaseLayer {
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private final char[] tempCharArray;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        int i = 1;
        this.tempCharArray = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.fillPaint = new Paint(i) { // from class: com.bytedance.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(i) { // from class: com.bytedance.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        TextKeyframeAnimation createAnimation = layer.getText().createAnimation();
        this.textAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(createAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (textProperties != null && textProperties.color != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = textProperties.color.createAnimation();
            this.colorAnimation = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (textProperties != null && textProperties.stroke != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = textProperties.stroke.createAnimation();
            this.strokeColorAnimation = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (textProperties != null && textProperties.strokeWidth != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = textProperties.strokeWidth.createAnimation();
            this.strokeWidthAnimation = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties == null || textProperties.tracking == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> createAnimation5 = textProperties.tracking.createAnimation();
        this.trackingAnimation = createAnimation5;
        createAnimation5.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas.setMatrix(matrix);
        }
        DocumentData value = this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(value.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            this.fillPaint.setColor(value.color);
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorAnimation;
        if (baseKeyframeAnimation2 != null) {
            this.strokePaint.setColor(baseKeyframeAnimation2.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int intValue = (this.transform.getOpacity().getValue().intValue() * HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_UNKNOWN) / 100;
        this.fillPaint.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthAnimation;
        if (baseKeyframeAnimation3 != null) {
            this.strokePaint.setStrokeWidth(baseKeyframeAnimation3.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth((float) (value.strokeWidth * Utils.dpScale() * Utils.getScale(matrix)));
        }
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextGlyphs(value, matrix, font, canvas);
        } else {
            drawTextWithFont(value, font, matrix, canvas);
        }
        canvas.restore();
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f = ((float) documentData.size) / 100.0f;
        float scale = Utils.getScale(matrix);
        String str = documentData.text;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter fontCharacter = (FontCharacter) this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                drawCharacterAsGlyph(fontCharacter, matrix, f, documentData, canvas);
                float width = ((float) fontCharacter.getWidth()) * f * Utils.dpScale() * scale;
                float f2 = documentData.tracking / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
                if (baseKeyframeAnimation != null) {
                    f2 += baseKeyframeAnimation.getValue().floatValue();
                }
                canvas.translate(width + (f2 * scale), 0.0f);
            }
        }
    }

    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix, Canvas canvas) {
        float scale = Utils.getScale(matrix);
        Typeface typeface = this.lottieDrawable.getTypeface(font.getFamily(), font.getStyle());
        if (typeface == null) {
            return;
        }
        String str = documentData.text;
        TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
        if (textDelegate != null) {
            str = textDelegate.getTextInternal(str);
        }
        this.fillPaint.setTypeface(typeface);
        this.fillPaint.setTextSize((float) (documentData.size * Utils.dpScale()));
        this.strokePaint.setTypeface(this.fillPaint.getTypeface());
        this.strokePaint.setTextSize(this.fillPaint.getTextSize());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            drawCharacterFromFont(charAt, documentData, canvas);
            char[] cArr = this.tempCharArray;
            cArr[0] = charAt;
            float measureText = this.fillPaint.measureText(cArr, 0, 1);
            float f = documentData.tracking / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
            if (baseKeyframeAnimation != null) {
                f += baseKeyframeAnimation.getValue().floatValue();
            }
            canvas.translate(measureText + (f * scale), 0.0f);
        }
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> contentsForCharacter = getContentsForCharacter(fontCharacter);
        for (int i = 0; i < contentsForCharacter.size(); i++) {
            Path path = contentsForCharacter.get(i).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, ((float) (-documentData.baselineShift)) * Utils.dpScale());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                drawGlyph(path, this.strokePaint, canvas);
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                drawGlyph(path, this.fillPaint, canvas);
            }
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void drawCharacterFromFont(char c, DocumentData documentData, Canvas canvas) {
        this.tempCharArray[0] = c;
        if (documentData.strokeOverFill) {
            drawCharacter(this.tempCharArray, this.fillPaint, canvas);
            drawCharacter(this.tempCharArray, this.strokePaint, canvas);
        } else {
            drawCharacter(this.tempCharArray, this.strokePaint, canvas);
            drawCharacter(this.tempCharArray, this.fillPaint, canvas);
        }
    }

    private void drawCharacter(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i)));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    @Override // com.bytedance.lottie.model.layer.BaseLayer, com.bytedance.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4;
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR && (baseKeyframeAnimation4 = this.colorAnimation) != null) {
            baseKeyframeAnimation4.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.STROKE_COLOR && (baseKeyframeAnimation3 = this.strokeColorAnimation) != null) {
            baseKeyframeAnimation3.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.STROKE_WIDTH && (baseKeyframeAnimation2 = this.strokeWidthAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else {
            if (t != LottieProperty.TEXT_TRACKING || (baseKeyframeAnimation = this.trackingAnimation) == null) {
                return;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        }
    }
}
