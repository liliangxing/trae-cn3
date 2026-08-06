package com.larus.business.markdown.fresco;

import android.graphics.Rect;
import android.text.Spanned;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.larus.business.markdown.api.extplugin.image.CustomImgWidgetExtKt;
import com.larus.business.markdown.api.extplugin.image.ICustomImgHandler;
import com.larus.business.markdown.api.extplugin.image.ICustomImgSpan;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.RenderProps;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import io.noties.markwon.image.CustomImageSpanFactory;
import io.noties.markwon.image.ImageProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Image;
import org.commonmark.node.Node;

/* compiled from: ReusableFrescoImagesPlugin.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%BW\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\rH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/business/markdown/fresco/ReusableFrescoImagesPlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "imgBgColor", "", "imgCornerRadius", "maxContentWidth", "minWidthHeight", "defaultPlaceImageSize", "Landroid/graphics/Rect;", "customImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "payload", "", "", "", "(Ljava/lang/Integer;ILjava/lang/Integer;ILandroid/graphics/Rect;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;Ljava/util/Map;)V", "Ljava/lang/Integer;", "reuseCharSequence", "", "textView", "Landroid/widget/TextView;", "afterSetText", "", "beforeRender", "node", "Lorg/commonmark/node/Node;", "beforeSetText", "markdown", "Landroid/text/Spanned;", "configureConfiguration", "builder", "Lio/noties/markwon/MarkwonConfiguration$Builder;", "configureSpansFactory", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "printLog", "span", "message", "Companion", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ReusableFrescoImagesPlugin extends AbstractMarkwonPlugin {
    public static final String LOG_TAG = "";
    private final ICustomImgHandler customImgHandler;
    private final Rect defaultPlaceImageSize;
    private final Integer imgBgColor;
    private final int imgCornerRadius;
    private final Integer maxContentWidth;
    private final int minWidthHeight;
    private final Map<String, Object> payload;
    private CharSequence reuseCharSequence;
    private TextView textView;

    public /* synthetic */ ReusableFrescoImagesPlugin(Integer num, int i, Integer num2, int i2, Rect rect, ICustomImgHandler iCustomImgHandler, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, i, num2, i2, rect, (i3 & 32) != 0 ? null : iCustomImgHandler, map);
    }

    public ReusableFrescoImagesPlugin(Integer num, int i, Integer num2, int i2, Rect rect, ICustomImgHandler iCustomImgHandler, Map<String, ? extends Object> map) {
        this.imgBgColor = num;
        this.imgCornerRadius = i;
        this.maxContentWidth = num2;
        this.minWidthHeight = i2;
        this.defaultPlaceImageSize = rect;
        this.customImgHandler = iCustomImgHandler;
        this.payload = map;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Rect rect = this.defaultPlaceImageSize;
        Integer num = this.maxContentWidth;
        builder.imageSizeResolver(new CustomImageSizeResolverDef(rect, num != null ? num.intValue() : 0, this.minWidthHeight));
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        final Integer num = this.imgBgColor;
        final int i = this.imgCornerRadius;
        final Integer num2 = this.maxContentWidth;
        final int i2 = this.minWidthHeight;
        final Rect rect = this.defaultPlaceImageSize;
        final ICustomImgHandler iCustomImgHandler = this.customImgHandler;
        final Map<String, Object> map = this.payload;
        builder.setFactory(Image.class, new CustomImageSpanFactory(num, i, num2, i2, rect, iCustomImgHandler, map) { // from class: com.larus.business.markdown.fresco.ReusableFrescoImagesPlugin$configureSpansFactory$imageSpanFactory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Integer valueOf = Integer.valueOf(i2);
            }

            @Override // io.noties.markwon.image.CustomImageSpanFactory, io.noties.markwon.image.ImageSpanFactory, io.noties.markwon.SpanFactory
            public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
                TextView textView;
                CharSequence charSequence;
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(props, "props");
                String require = ImageProps.DESTINATION.require(props);
                Intrinsics.checkNotNullExpressionValue(require, "DESTINATION.require(props)");
                String str = require;
                Integer num3 = ImageProps.IMAGE_START_INDEX.get(props);
                if (num3 == null) {
                    return super.getSpans(configuration, props);
                }
                int intValue = num3.intValue();
                Integer num4 = ImageProps.IMAGE_END_INDEX.get(props);
                if (num4 == null) {
                    return super.getSpans(configuration, props);
                }
                int intValue2 = num4.intValue();
                textView = ReusableFrescoImagesPlugin.this.textView;
                ICustomImgSpan iCustomImgSpan = null;
                CharSequence text = textView != null ? textView.getText() : null;
                Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
                if (spanned == null) {
                    charSequence = ReusableFrescoImagesPlugin.this.reuseCharSequence;
                    spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
                }
                if (spanned != null) {
                    ICustomImgSpan[] iCustomImgSpanArr = (ICustomImgSpan[]) spanned.getSpans(intValue, intValue2, ICustomImgSpan.class);
                    if (iCustomImgSpanArr != null) {
                        int length = iCustomImgSpanArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            ICustomImgSpan iCustomImgSpan2 = iCustomImgSpanArr[i3];
                            if (iCustomImgSpan2.getStartIndex() == intValue && iCustomImgSpan2.getEndIndex() == intValue2 && Intrinsics.areEqual(iCustomImgSpan2.getUrl(), str)) {
                                iCustomImgSpan = iCustomImgSpan2;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (iCustomImgSpan != null) {
                        return iCustomImgSpan;
                    }
                }
                return super.getSpans(configuration, props);
            }
        });
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeRender(TextView textView, Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        super.beforeRender(textView, node);
        this.textView = textView;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeRender(CharSequence reuseCharSequence, Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        super.beforeRender(reuseCharSequence, node);
        this.reuseCharSequence = reuseCharSequence;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned markdown) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        super.beforeSetText(textView, markdown);
        CharSequence text = textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        ICustomImgSpan[] iCustomImgSpanArr = spanned != null ? (ICustomImgSpan[]) spanned.getSpans(0, text.length(), ICustomImgSpan.class) : null;
        if (iCustomImgSpanArr == null) {
            iCustomImgSpanArr = new ICustomImgSpan[0];
        }
        Object[] spans = markdown.getSpans(0, markdown.length(), ICustomImgSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "markdown.getSpans(0, mar…ustomImgSpan::class.java)");
        List<ICustomImgSpan> mutableList = ArraysKt.toMutableList(spans);
        for (ICustomImgSpan iCustomImgSpan : iCustomImgSpanArr) {
            if (!mutableList.remove(iCustomImgSpan)) {
                iCustomImgSpan.onDetach(textView);
            } else {
                Intrinsics.checkNotNullExpressionValue(iCustomImgSpan, "span");
                iCustomImgSpan.onReuse(markdown, iCustomImgSpan);
                printLog(iCustomImgSpan, "reuse span");
            }
        }
        for (ICustomImgSpan iCustomImgSpan2 : mutableList) {
            Intrinsics.checkNotNullExpressionValue(iCustomImgSpan2, "span");
            printLog(iCustomImgSpan2, "new span beforeAttach");
            iCustomImgSpan2.beforeAttach(textView, markdown);
        }
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        super.afterSetText(textView);
        ViewParent parent = textView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            CustomImgWidgetExtKt.clearWidgetCache(viewGroup);
        }
        CharSequence text = textView.getText();
        if (text instanceof Spanned) {
            ICustomImgSpan[] iCustomImgSpanArr = (ICustomImgSpan[]) ((Spanned) text).getSpans(0, text.length(), ICustomImgSpan.class);
            Intrinsics.checkNotNullExpressionValue(iCustomImgSpanArr, "spans");
            for (ICustomImgSpan iCustomImgSpan : iCustomImgSpanArr) {
                iCustomImgSpan.afterAttach(textView);
            }
        }
        this.textView = null;
        this.reuseCharSequence = null;
    }

    private final void printLog(Object span, String message) {
        Log.d("", "span[" + span.hashCode() + "]:" + message);
    }
}
