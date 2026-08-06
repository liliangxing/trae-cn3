package io.noties.markwon.html.tag;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ClickableSpan;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.HtmlEmptyTagReplacement;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.tag.ImageGridHandler;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.image.AsyncGridDrawable;
import io.noties.markwon.pool.ReuseDrawablePool;
import io.noties.markwon.utils.Dip;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.commonmark.node.Link;

/* compiled from: ImageGridHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001a\u001b\u001cB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler;", "Lio/noties/markwon/html/tag/ImageHandler;", "context", "Landroid/content/Context;", "drawablePool", "Lio/noties/markwon/pool/ReuseDrawablePool;", "maxWidth", "", "requireLineBreak", "", "(Landroid/content/Context;Lio/noties/markwon/pool/ReuseDrawablePool;IZ)V", "addLink", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "tag", "Lio/noties/markwon/html/HtmlTag;", "href", "", "handle", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", "replaceTag", "", "emptyReplacement", "Lio/noties/markwon/html/HtmlEmptyTagReplacement;", "BottomAlignDrawableSpan", "Companion", "ThumbnailDrawable", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImageGridHandler extends ImageHandler {
    public static final String Height = "imgheight";
    public static final String Index = "index";
    public static final String ItemGap = "itemgap";
    public static final String LargeImage = "imgurl";
    public static final String SpanCount = "maxnuminline";
    public static final String Src = "src";
    public static final String State = "state";
    public static final String State_PlaceHolder = "1";
    public static final String Width = "imgwidth";
    private final Context context;
    private final ReuseDrawablePool drawablePool;
    private final int maxWidth;
    private final boolean requireLineBreak;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ImageGridHandler(Context context, ReuseDrawablePool reuseDrawablePool, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, reuseDrawablePool, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? true : z);
        if ((i2 & 2) != 0) {
            reuseDrawablePool = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageGridHandler(Context context, ReuseDrawablePool reuseDrawablePool, int i, boolean z) {
        super(new ImageSizeParserImpl(CssInlineStyleParser.create()));
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
        this.drawablePool = reuseDrawablePool;
        this.maxWidth = i;
        this.requireLineBreak = z;
    }

    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // io.noties.markwon.html.tag.SimpleTagHandler, io.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor visitor, MarkwonHtmlRenderer renderer, HtmlTag tag) {
        ?? r0;
        ThumbnailDrawable thumbnailDrawable;
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(renderer, "renderer");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Map<String, String> attributes = tag.attributes();
        Intrinsics.checkExpressionValueIsNotNull(attributes, "tag.attributes()");
        String str = attributes.get(SpanCount);
        final Integer intOrNull3 = str != null ? StringsKt.toIntOrNull(str) : null;
        String str2 = attributes.get("src");
        final String process = str2 != null ? visitor.configuration().imageDestinationProcessor().process(str2) : null;
        if (intOrNull3 != null && intOrNull3.intValue() > 0) {
            if (tag.isBlock()) {
                ImageHandler.visitChildren(visitor, renderer, tag.getAsBlock());
            }
            String str3 = attributes.get(LargeImage);
            String process2 = str3 != null ? visitor.configuration().imageDestinationProcessor().process(str3) : process;
            String str4 = attributes.get(Index);
            final int intValue = (str4 == null || (intOrNull2 = StringsKt.toIntOrNull(str4)) == null) ? 0 : intOrNull2.intValue();
            Dip create = Dip.create(this.context);
            String str5 = attributes.get(ItemGap);
            int px = create.toPx((str5 == null || (intOrNull = StringsKt.toIntOrNull(str5)) == null) ? 0 : intOrNull.intValue());
            String str6 = attributes.get(Width);
            Integer intOrNull4 = str6 != null ? StringsKt.toIntOrNull(str6) : null;
            String str7 = attributes.get(Height);
            Integer intOrNull5 = str7 != null ? StringsKt.toIntOrNull(str7) : null;
            final boolean areEqual = Intrinsics.areEqual(attributes.get("state"), "1");
            if (process == null || process2 == null) {
                return;
            }
            ReuseDrawablePool reuseDrawablePool = this.drawablePool;
            if (reuseDrawablePool == null || (thumbnailDrawable = reuseDrawablePool.obtain(new Function1<AsyncDrawable, Boolean>() { // from class: io.noties.markwon.html.tag.ImageGridHandler$handle$drawable$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((AsyncDrawable) obj));
                }

                public final boolean invoke(AsyncDrawable asyncDrawable) {
                    Intrinsics.checkParameterIsNotNull(asyncDrawable, "it");
                    if (asyncDrawable instanceof ImageGridHandler.ThumbnailDrawable) {
                        ImageGridHandler.ThumbnailDrawable thumbnailDrawable2 = (ImageGridHandler.ThumbnailDrawable) asyncDrawable;
                        if (Intrinsics.areEqual(thumbnailDrawable2.getThumbnail(), process)) {
                            int spanCount = thumbnailDrawable2.getSpanCount();
                            Integer num = intOrNull3;
                            if (num != null && spanCount == num.intValue() && thumbnailDrawable2.getIndex() == intValue && asyncDrawable.justPlaceHolder() == areEqual) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            })) == null) {
                AsyncDrawableLoader asyncDrawableLoader = visitor.configuration().asyncDrawableLoader();
                Intrinsics.checkExpressionValueIsNotNull(asyncDrawableLoader, "visitor.configuration().asyncDrawableLoader()");
                r0 = 0;
                thumbnailDrawable = new ThumbnailDrawable(process, process2, intOrNull4, intOrNull5, asyncDrawableLoader, intOrNull3.intValue(), intValue, px, this.maxWidth);
            } else {
                r0 = 0;
            }
            thumbnailDrawable.setJustPlaceHolder(areEqual);
            MarkwonTheme theme = visitor.configuration().theme();
            Intrinsics.checkExpressionValueIsNotNull(theme, "visitor.configuration().theme()");
            SpannableBuilder.setSpans(visitor.builder(), new BottomAlignDrawableSpan(theme, thumbnailDrawable, r0, r0), tag.start(), tag.end());
            addLink(visitor, tag, process2);
            return;
        }
        super.handle(visitor, renderer, tag);
        if (process != null) {
            addLink(visitor, tag, process);
        }
    }

    private final void addLink(MarkwonVisitor visitor, HtmlTag tag, String href) {
        boolean z;
        SpanFactory spanFactory = visitor.configuration().spansFactory().get(Link.class);
        List<SpannableBuilder.Span> spans = visitor.builder().getSpans(tag.start(), tag.end());
        Intrinsics.checkExpressionValueIsNotNull(spans, "visitor.builder().getSpans(tag.start(), tag.end())");
        List<SpannableBuilder.Span> list = spans;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!(!(((SpannableBuilder.Span) it.next()).what instanceof ClickableSpan))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (spanFactory == null || !z) {
            return;
        }
        RenderProps renderProps = visitor.renderProps();
        Intrinsics.checkExpressionValueIsNotNull(renderProps, "visitor.renderProps()");
        CoreProps.LINK_DESTINATION.set(renderProps, href);
        CoreProps.LINK_EXTRA.set(renderProps, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", LynxResourceModule.IMAGE_TYPE), TuplesKt.to("start", String.valueOf(tag.start())), TuplesKt.to("end", String.valueOf(tag.end()))}));
        SpannableBuilder.setSpans(visitor.builder(), spanFactory.getSpans(visitor.configuration(), renderProps), tag.start(), tag.end());
        CoreProps.LINK_EXTRA.clear(renderProps);
    }

    /* compiled from: ImageGridHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler$ThumbnailDrawable;", "Lio/noties/markwon/image/AsyncGridDrawable;", "thumbnail", "", "largeImage", AnimationConstant.PROP_STR_WIDTH, "", AnimationConstant.PROP_STR_HEIGHT, "loader", "Lio/noties/markwon/image/AsyncDrawableLoader;", "spanCount", ImageGridHandler.Index, "margin", "maxWidth", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lio/noties/markwon/image/AsyncDrawableLoader;IIII)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLargeImage", "()Ljava/lang/String;", "getThumbnail", "getWidth", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class ThumbnailDrawable extends AsyncGridDrawable {
        private final Integer height;
        private final String largeImage;
        private final String thumbnail;
        private final Integer width;

        public final String getThumbnail() {
            return this.thumbnail;
        }

        public final String getLargeImage() {
            return this.largeImage;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final Integer getHeight() {
            return this.height;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThumbnailDrawable(String str, String str2, Integer num, Integer num2, AsyncDrawableLoader asyncDrawableLoader, int i, int i2, int i3, int i4) {
            super(str, asyncDrawableLoader, i, i2, i3, i4);
            Intrinsics.checkParameterIsNotNull(str, "thumbnail");
            Intrinsics.checkParameterIsNotNull(str2, "largeImage");
            Intrinsics.checkParameterIsNotNull(asyncDrawableLoader, "loader");
            this.thumbnail = str;
            this.largeImage = str2;
            this.width = num;
            this.height = num2;
        }
    }

    /* compiled from: ImageGridHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ4\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/html/tag/ImageGridHandler$BottomAlignDrawableSpan;", "Lio/noties/markwon/image/AsyncDrawableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "alignment", "", "replacementTextIsLink", "", "(Lio/noties/markwon/core/MarkwonTheme;Lio/noties/markwon/image/AsyncDrawable;IZ)V", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class BottomAlignDrawableSpan extends AsyncDrawableSpan {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BottomAlignDrawableSpan(MarkwonTheme markwonTheme, AsyncDrawable asyncDrawable, int i, boolean z) {
            super(markwonTheme, asyncDrawable, i, z);
            Intrinsics.checkParameterIsNotNull(markwonTheme, "theme");
            Intrinsics.checkParameterIsNotNull(asyncDrawable, "drawable");
        }

        @Override // io.noties.markwon.image.AsyncDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
            Intrinsics.checkParameterIsNotNull(paint, "paint");
            if (getDrawable().hasResult()) {
                AsyncDrawable drawable = getDrawable();
                Intrinsics.checkExpressionValueIsNotNull(drawable, "drawable");
                Rect bounds = drawable.getBounds();
                Intrinsics.checkExpressionValueIsNotNull(bounds, "drawable.bounds");
                if (fm != null) {
                    Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                    int i = fontMetricsInt.descent - fontMetricsInt.ascent;
                    if (bounds.height() > i) {
                        fm.descent = fontMetricsInt.descent;
                        fm.ascent = (-bounds.height()) + fm.descent;
                    } else {
                        float height = (bounds.height() * 1.0f) / i;
                        fm.descent = MathKt.roundToInt(fontMetricsInt.descent * height);
                        fm.ascent = MathKt.roundToInt(fontMetricsInt.ascent * height);
                    }
                    fm.bottom = fm.descent;
                    fm.top = fm.ascent;
                }
                return bounds.width();
            }
            return super.getSize(paint, text, start, end, fm);
        }
    }

    @Override // io.noties.markwon.html.TagHandler
    public CharSequence replaceTag(HtmlTag tag, HtmlEmptyTagReplacement emptyReplacement) {
        Integer intOrNull;
        Integer intOrNull2;
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(emptyReplacement, "emptyReplacement");
        if (this.requireLineBreak) {
            Map<String, String> attributes = tag.attributes();
            Intrinsics.checkExpressionValueIsNotNull(attributes, "tag.attributes()");
            String textContent = tag.textContent();
            Intrinsics.checkExpressionValueIsNotNull(textContent, "tag.textContent()");
            String str = attributes.get(Index);
            int intValue = (str == null || (intOrNull2 = StringsKt.toIntOrNull(str)) == null) ? 0 : intOrNull2.intValue();
            String str2 = attributes.get(SpanCount);
            int intValue2 = (str2 == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? 0 : intOrNull.intValue();
            if (intValue2 > 0 && intValue != 0 && intValue % intValue2 == 0) {
                if (StringsKt.isBlank(textContent)) {
                    String replace = emptyReplacement.replace(tag);
                    String str3 = replace;
                    return str3 == null || StringsKt.isBlank(str3) ? "\n￼" : "\n" + replace;
                }
                return "\n" + textContent;
            }
        }
        return super.replaceTag(tag, emptyReplacement);
    }
}
