package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig;
import com.bytedance.trae.conversation.chat.block.renderer.markdown.MarkdownHeaderFactoryHooker;
import com.example.memorycollector.BuildConfig;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.MarkwonTheme;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: HeadingSpan2.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002Jp\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lio/noties/markwon/core/spans/HeadingSpan2;", "Lio/noties/markwon/core/spans/HeadingSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "level", "", "diffDp", "headingColor", "headingLevelTextSizeMap", "", "", "(Lio/noties/markwon/core/MarkwonTheme;IILjava/lang/Integer;Ljava/util/Map;)V", "defaultTextSizeMap", "Ljava/lang/Integer;", "apply2", "", "paint", "Landroid/text/TextPaint;", "drawLeadingMargin", "c", "Landroid/graphics/Canvas;", "p", "Landroid/graphics/Paint;", "x", "dir", AnimationConstant.PROP_STR_TOP, "baseline", AnimationConstant.PROP_STR_BOTTOM, "text", "", "start", "end", "first", "", "layout", "Landroid/text/Layout;", "updateDrawState", "tp", "updateMeasureState", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class HeadingSpan2 extends HeadingSpan {
    private final Map<Integer, Integer> defaultTextSizeMap;
    private final int diffDp;
    private final Integer headingColor;
    private final Map<Integer, Float> headingLevelTextSizeMap;
    private final int level;

    @Override // io.noties.markwon.core.spans.HeadingSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
    }

    @Override // io.noties.markwon.core.spans.HeadingSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
        m2589xfb3ce3df(this, tp);
    }

    @Override // io.noties.markwon.core.spans.HeadingSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        m2590x9e8fc261(this, p);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadingSpan2(MarkwonTheme markwonTheme, int i, int i2, Integer num, Map<Integer, Float> map) {
        super(markwonTheme, i);
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        this.level = i;
        this.diffDp = i2;
        this.headingColor = num;
        this.headingLevelTextSizeMap = map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, Integer.valueOf(MarkdownDimensExtKt.getDp_20()));
        linkedHashMap.put(2, Integer.valueOf(MarkdownDimensExtKt.getDp_19()));
        linkedHashMap.put(3, Integer.valueOf(MarkdownDimensExtKt.getDp_17()));
        linkedHashMap.put(4, Integer.valueOf(MarkdownDimensExtKt.getDp_17()));
        linkedHashMap.put(5, Integer.valueOf(MarkdownDimensExtKt.getDp_17()));
        linkedHashMap.put(6, Integer.valueOf(MarkdownDimensExtKt.getDp_17()));
        this.defaultTextSizeMap = linkedHashMap;
    }

    /* renamed from: io_noties_markwon_core_spans_HeadingSpan2__updateDrawState$___twin___ */
    public void m2591x1c499b7c(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "tp");
        apply2(textPaint);
    }

    /* renamed from: io_noties_markwon_core_spans_HeadingSpan2__updateMeasureState$___twin___ */
    public void m2592xe423729c(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "p");
        apply2(textPaint);
    }

    private final void apply2(TextPaint paint) {
        Float f;
        Map<Integer, Float> map = this.headingLevelTextSizeMap;
        if (map == null || (f = map.get(Integer.valueOf(this.level))) == null) {
            f = this.defaultTextSizeMap.get(Integer.valueOf(this.level));
        }
        if (f != null) {
            paint.setFakeBoldText(true);
            paint.setTextSize(f.floatValue() + MarkdownUnitExtKt.dp2pxFloat(Integer.valueOf(this.diffDp)));
        }
        Integer num = this.headingColor;
        if (num != null) {
            paint.setColor(num.intValue());
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "io.noties.markwon.core.spans.HeadingSpan")
    @Insert(shouldIgnoreCheck = BuildConfig.ONLINE, value = "updateMeasureState")
    /* renamed from: io_noties_markwon_core_spans_HeadingSpan2_com_bytedance_trae_conversation_chat_block_renderer_markdown_MarkdownHeaderFactoryHooker_hookUpdateMeasureState */
    public static void m2590x9e8fc261(HeadingSpan2 headingSpan2, TextPaint textPaint) {
        HeaderStyleConfig headerStyleConfig;
        headingSpan2.m2592xe423729c(textPaint);
        HeadingSpan2 headingSpan22 = headingSpan2;
        synchronized (MarkdownHeaderFactoryHooker.sStyleMap) {
            headerStyleConfig = (HeaderStyleConfig) MarkdownHeaderFactoryHooker.sStyleMap.get(headingSpan22);
        }
        if (headerStyleConfig != null) {
            MarkdownHeaderFactoryHooker.applyCustomHeadingStyle(textPaint, headingSpan22.getLevel(), headerStyleConfig);
        }
    }

    @TargetClass(scope = Scope.LEAF, value = "io.noties.markwon.core.spans.HeadingSpan")
    @Insert(shouldIgnoreCheck = BuildConfig.ONLINE, value = "updateDrawState")
    /* renamed from: io_noties_markwon_core_spans_HeadingSpan2_com_bytedance_trae_conversation_chat_block_renderer_markdown_MarkdownHeaderFactoryHooker_hookUpdateDrawState */
    public static void m2589xfb3ce3df(HeadingSpan2 headingSpan2, TextPaint textPaint) {
        HeaderStyleConfig headerStyleConfig;
        headingSpan2.m2591x1c499b7c(textPaint);
        HeadingSpan2 headingSpan22 = headingSpan2;
        synchronized (MarkdownHeaderFactoryHooker.sStyleMap) {
            headerStyleConfig = (HeaderStyleConfig) MarkdownHeaderFactoryHooker.sStyleMap.get(headingSpan22);
        }
        if (headerStyleConfig != null) {
            MarkdownHeaderFactoryHooker.applyCustomHeadingStyle(textPaint, headingSpan22.getLevel(), headerStyleConfig);
        }
    }
}
