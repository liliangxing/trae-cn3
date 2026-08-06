package com.bytedance.trae.conversation.chat.block.renderer.markdown;

import android.content.res.Resources;
import android.text.TextPaint;
import com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig;
import io.noties.markwon.core.spans.HeadingSpan;
import java.util.Map;
import java.util.WeakHashMap;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes5.dex */
public class MarkdownHeaderFactoryHooker {
    public static final WeakHashMap<HeadingSpan, HeaderStyleConfig> sStyleMap = new WeakHashMap<>();

    public static void bindHeadingStyle(HeadingSpan headingSpan, HeaderStyleConfig headerStyleConfig) {
        WeakHashMap<HeadingSpan, HeaderStyleConfig> weakHashMap = sStyleMap;
        synchronized (weakHashMap) {
            weakHashMap.put(headingSpan, headerStyleConfig);
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "io.noties.markwon.core.spans.HeadingSpan")
    @Insert(shouldIgnoreCheck = true, value = "updateMeasureState")
    public void hookUpdateMeasureState(TextPaint textPaint) {
        HeaderStyleConfig headerStyleConfig;
        Origin.callVoid();
        HeadingSpan headingSpan = (HeadingSpan) This.get();
        WeakHashMap<HeadingSpan, HeaderStyleConfig> weakHashMap = sStyleMap;
        synchronized (weakHashMap) {
            headerStyleConfig = weakHashMap.get(headingSpan);
        }
        if (headerStyleConfig != null) {
            applyCustomHeadingStyle(textPaint, headingSpan.getLevel(), headerStyleConfig);
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "io.noties.markwon.core.spans.HeadingSpan")
    @Insert(shouldIgnoreCheck = true, value = "updateDrawState")
    public void hookUpdateDrawState(TextPaint textPaint) {
        HeaderStyleConfig headerStyleConfig;
        Origin.callVoid();
        HeadingSpan headingSpan = (HeadingSpan) This.get();
        WeakHashMap<HeadingSpan, HeaderStyleConfig> weakHashMap = sStyleMap;
        synchronized (weakHashMap) {
            headerStyleConfig = weakHashMap.get(headingSpan);
        }
        if (headerStyleConfig != null) {
            applyCustomHeadingStyle(textPaint, headingSpan.getLevel(), headerStyleConfig);
        }
    }

    public static void applyCustomHeadingStyle(TextPaint textPaint, int i, HeaderStyleConfig headerStyleConfig) {
        float f;
        Map<Integer, Float> sizesSp = headerStyleConfig.getSizesSp();
        if (sizesSp == null || !sizesSp.containsKey(Integer.valueOf(i))) {
            f = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? 15.0f : 16.0f : 17.0f : 18.0f : 19.0f : 20.0f;
        } else {
            f = sizesSp.get(Integer.valueOf(i)).floatValue();
        }
        textPaint.setTextSize(f * Resources.getSystem().getDisplayMetrics().scaledDensity);
        Integer color = headerStyleConfig.getColor();
        if (color != null) {
            textPaint.setColor(color.intValue());
        }
    }
}
