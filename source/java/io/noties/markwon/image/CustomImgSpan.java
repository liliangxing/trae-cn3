package io.noties.markwon.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.facebook.imageutils.JfifUtil;
import com.larus.business.markdown.api.SpanUtilsKt;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.image.ICustomImgHandler;
import com.larus.business.markdown.api.extplugin.image.ICustomImgSpan;
import com.larus.business.markdown.api.extplugin.image.ICustomImgWidget;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.fresco.DefaultImgWidget;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.MarkdownSpanInfo;
import io.noties.markwon.html.tag.ImageGridHandler;
import io.noties.markwon.image.ImageSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomImgSpan.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001dH\u0016J\u0018\u00107\u001a\u0002052\u0006\u00106\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0016JR\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020<2\b\u00108\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020FH\u0016J4\u0010G\u001a\u00020\u00042\u0006\u0010E\u001a\u00020F2\b\u00108\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u0002052\u0006\u00106\u001a\u00020\u001dH\u0016J\u0018\u0010K\u001a\u0002052\u0006\u00108\u001a\u0002092\u0006\u0010L\u001a\u00020\u0002H\u0016J\"\u0010M\u001a\u0002052\u0006\u0010N\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010=2\u0006\u0010O\u001a\u00020\u0004H\u0002R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006Q"}, d2 = {"Lio/noties/markwon/image/CustomImgSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;", "startIndex", "", "endIndex", "url", "", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "replacementTextIsLink", "", "imageSize", "Lio/noties/markwon/image/ImageSize;", "imgBgColor", "imgCornerRadius", "maxContentWidth", "minWidthHeight", "defaultPlaceImageSize", "Landroid/graphics/Rect;", "dataHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "payload", "", "", "widget", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;", "(IILjava/lang/String;Lio/noties/markwon/core/MarkwonTheme;ZLio/noties/markwon/image/ImageSize;Ljava/lang/Integer;IIILandroid/graphics/Rect;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;Ljava/util/Map;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;)V", "attachedTextView", "Landroid/widget/TextView;", "getEndIndex", "()I", "getImgBgColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImgCornerRadius", "getPayload", "()Ljava/util/Map;", "getReplacementTextIsLink", "()Z", "size", "Landroid/util/Size;", "sizeRect", "getStartIndex", "getTheme", "()Lio/noties/markwon/core/MarkwonTheme;", "getUrl", "()Ljava/lang/String;", "getWidget", "()Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;", "setWidget", "(Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;)V", "afterAttach", "", "textView", "beforeAttach", "text", "Landroid/text/Spanned;", WebViewContainer.EVENT_draw, "canvas", "Landroid/graphics/Canvas;", "", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "onDetach", "onReuse", "span", "printLog", "log", ImageGridHandler.Index, "Companion", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomImgSpan extends ReplacementSpan implements ICustomImgSpan {
    public static final String LOG_TAG = "CustomAsyncDrawableSpan";
    private TextView attachedTextView;
    private final ICustomImgHandler dataHandler;
    private final Rect defaultPlaceImageSize;
    private final int endIndex;
    private final ImageSize imageSize;
    private final Integer imgBgColor;
    private final int imgCornerRadius;
    private final int maxContentWidth;
    private final int minWidthHeight;
    private final Map<String, Object> payload;
    private final boolean replacementTextIsLink;
    private Size size;
    private final Rect sizeRect;
    private final int startIndex;
    private final MarkwonTheme theme;
    private final String url;
    private ICustomImgWidget widget;

    private final void printLog(String log, CharSequence text, int index) {
    }

    public /* synthetic */ CustomImgSpan(int i, int i2, String str, MarkwonTheme markwonTheme, boolean z, ImageSize imageSize, Integer num, int i3, int i4, int i5, Rect rect, ICustomImgHandler iCustomImgHandler, Map map, ICustomImgWidget iCustomImgWidget, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, str, markwonTheme, z, imageSize, (i6 & 64) != 0 ? null : num, (i6 & 128) != 0 ? 0 : i3, i4, i5, rect, iCustomImgHandler, (i6 & 4096) != 0 ? null : map, (i6 & AnimationConstant.PROP_COLOR) != 0 ? null : iCustomImgWidget);
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public int getEndIndex() {
        return this.endIndex;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public String getUrl() {
        return this.url;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public MarkwonTheme getTheme() {
        return this.theme;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public boolean getReplacementTextIsLink() {
        return this.replacementTextIsLink;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public Integer getImgBgColor() {
        return this.imgBgColor;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public int getImgCornerRadius() {
        return this.imgCornerRadius;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public Map<String, Object> getPayload() {
        return this.payload;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public ICustomImgWidget getWidget() {
        return this.widget;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public void setWidget(ICustomImgWidget iCustomImgWidget) {
        this.widget = iCustomImgWidget;
    }

    public CustomImgSpan(int i, int i2, String str, MarkwonTheme markwonTheme, boolean z, ImageSize imageSize, Integer num, int i3, int i4, int i5, Rect rect, ICustomImgHandler iCustomImgHandler, Map<String, ? extends Object> map, ICustomImgWidget iCustomImgWidget) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        this.startIndex = i;
        this.endIndex = i2;
        this.url = str;
        this.theme = markwonTheme;
        this.replacementTextIsLink = z;
        this.imageSize = imageSize;
        this.imgBgColor = num;
        this.imgCornerRadius = i3;
        this.maxContentWidth = i4;
        this.minWidthHeight = i5;
        this.defaultPlaceImageSize = rect;
        this.dataHandler = iCustomImgHandler;
        this.payload = map;
        this.widget = iCustomImgWidget;
        this.sizeRect = new Rect();
        this.size = new Size(0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009f A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:3:0x000f, B:5:0x001b, B:7:0x0020, B:8:0x0024, B:10:0x002a, B:12:0x0030, B:15:0x0038, B:17:0x0094, B:19:0x009f, B:20:0x00a3, B:24:0x00ab, B:26:0x00af, B:30:0x00d6, B:33:0x00bb, B:35:0x00ca, B:36:0x00d0, B:38:0x0139, B:43:0x0055, B:45:0x0059, B:47:0x005f, B:49:0x0067), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:3:0x000f, B:5:0x001b, B:7:0x0020, B:8:0x0024, B:10:0x002a, B:12:0x0030, B:15:0x0038, B:17:0x0094, B:19:0x009f, B:20:0x00a3, B:24:0x00ab, B:26:0x00af, B:30:0x00d6, B:33:0x00bb, B:35:0x00ca, B:36:0x00d0, B:38:0x0139, B:43:0x0055, B:45:0x0059, B:47:0x005f, B:49:0x0067), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:3:0x000f, B:5:0x001b, B:7:0x0020, B:8:0x0024, B:10:0x002a, B:12:0x0030, B:15:0x0038, B:17:0x0094, B:19:0x009f, B:20:0x00a3, B:24:0x00ab, B:26:0x00af, B:30:0x00d6, B:33:0x00bb, B:35:0x00ca, B:36:0x00d0, B:38:0x0139, B:43:0x0055, B:45:0x0059, B:47:0x005f, B:49:0x0067), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beforeAttach(TextView textView, Spanned text) {
        Rect rect;
        Rect rect2;
        FrameLayout frameLayout;
        ICustomImgHandler iCustomImgHandler;
        DefaultImgWidget defaultImgWidget;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            int leadingMargin = SpanUtilsKt.getLeadingMargin(text, getStartIndex());
            ImageSize imageSize = this.imageSize;
            if (imageSize != null) {
                ImageSize.Dimension dimension = imageSize.width;
                float f = 0;
                if ((dimension != null ? dimension.value : 0.0f) > f) {
                    ImageSize.Dimension dimension2 = this.imageSize.height;
                    if ((dimension2 != null ? dimension2.value : 0.0f) > f) {
                        rect = ImageSizeScaleUtils.INSTANCE.handleScale(ImageSizeScaleUtils.INSTANCE.imageSizeToRect(this.imageSize, new Rect(), this.maxContentWidth - leadingMargin, 0.0f), this.maxContentWidth - leadingMargin, this.minWidthHeight);
                        rect2 = rect;
                        this.attachedTextView = textView;
                        ViewParent parent = textView.getParent();
                        frameLayout = !(parent instanceof FrameLayout) ? (FrameLayout) parent : null;
                        if ((textView instanceof IMarkdownTextView) && frameLayout != null) {
                            iCustomImgHandler = this.dataHandler;
                            if (iCustomImgHandler != null) {
                                defaultImgWidget = iCustomImgHandler.getWidget(frameLayout, textView, text, this);
                                if (defaultImgWidget != null) {
                                }
                                ICustomImgWidget iCustomImgWidget = defaultImgWidget;
                                this.size = iCustomImgWidget.bindData(textView, text, this, rect2, getPayload());
                                printLog("span calc new__: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), getStartIndex());
                                View asView = iCustomImgWidget.asView();
                                asView.setLayoutParams(new FrameLayout.LayoutParams(this.size.getWidth(), this.size.getHeight()));
                                asView.setVisibility(4);
                                setWidget(iCustomImgWidget);
                                frameLayout.addView(asView);
                                return;
                            }
                            Context context = frameLayout.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "container.context");
                            ICustomImgHandler iCustomImgHandler2 = this.dataHandler;
                            defaultImgWidget = new DefaultImgWidget(context, null, iCustomImgHandler2 == null ? iCustomImgHandler2.getCustomImgLoader() : null);
                            ICustomImgWidget iCustomImgWidget2 = defaultImgWidget;
                            this.size = iCustomImgWidget2.bindData(textView, text, this, rect2, getPayload());
                            printLog("span calc new__: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), getStartIndex());
                            View asView2 = iCustomImgWidget2.asView();
                            asView2.setLayoutParams(new FrameLayout.LayoutParams(this.size.getWidth(), this.size.getHeight()));
                            asView2.setVisibility(4);
                            setWidget(iCustomImgWidget2);
                            frameLayout.addView(asView2);
                            return;
                        }
                        setWidget(null);
                    }
                }
            }
            Rect rect3 = this.defaultPlaceImageSize;
            if (rect3 == null || rect3.width() <= 0 || this.defaultPlaceImageSize.height() <= 0) {
                return;
            }
            int width = this.defaultPlaceImageSize.width() - leadingMargin;
            Rect rect4 = this.defaultPlaceImageSize;
            this.sizeRect.set(rect4.left, rect4.top, rect4.left + width, rect4.top + ((int) ((this.defaultPlaceImageSize.height() / this.defaultPlaceImageSize.width()) * width)));
            rect = this.sizeRect;
            rect2 = rect;
            this.attachedTextView = textView;
            ViewParent parent2 = textView.getParent();
            if (!(parent2 instanceof FrameLayout)) {
            }
            if (textView instanceof IMarkdownTextView) {
                iCustomImgHandler = this.dataHandler;
                if (iCustomImgHandler != null) {
                }
                Context context2 = frameLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "container.context");
                ICustomImgHandler iCustomImgHandler22 = this.dataHandler;
                defaultImgWidget = new DefaultImgWidget(context2, null, iCustomImgHandler22 == null ? iCustomImgHandler22.getCustomImgLoader() : null);
                ICustomImgWidget iCustomImgWidget22 = defaultImgWidget;
                this.size = iCustomImgWidget22.bindData(textView, text, this, rect2, getPayload());
                printLog("span calc new__: " + this.size.getWidth() + ", " + this.size.getHeight(), textView.getText(), getStartIndex());
                View asView22 = iCustomImgWidget22.asView();
                asView22.setLayoutParams(new FrameLayout.LayoutParams(this.size.getWidth(), this.size.getHeight()));
                asView22.setVisibility(4);
                setWidget(iCustomImgWidget22);
                frameLayout.addView(asView22);
                return;
            }
            setWidget(null);
        } catch (Exception e) {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2529e("CustomImgSpan", "beforeAttach error:" + e);
            }
        }
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public void afterAttach(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        printLog("span afterAttach", textView.getText(), getStartIndex());
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public void onDetach(TextView textView) {
        View asView;
        Intrinsics.checkNotNullParameter(textView, "textView");
        ICustomImgWidget widget = getWidget();
        if (widget != null && (asView = widget.asView()) != null) {
            ViewParent parent = asView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(asView);
            }
        }
        this.attachedTextView = null;
        printLog("span detach", null, 0);
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgSpan
    public void onReuse(Spanned text, ICustomImgSpan span) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(span, "span");
        ICustomImgWidget widget = getWidget();
        if (widget != null) {
            widget.onReuse(text, this);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        int height;
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (text != null && text.length() == end) {
            height = this.size.getHeight();
        } else {
            TextView textView = this.attachedTextView;
            if (textView != null) {
                height = (int) ((this.size.getHeight() - textView.getLineSpacingExtra()) / textView.getLineSpacingMultiplier());
            } else {
                height = this.size.getHeight();
            }
        }
        if (fm != null) {
            fm.ascent = -this.size.getHeight();
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
        }
        printLog("span_size, get: " + this.size.getWidth() + ", " + height, text, start);
        return this.size.getWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, final CharSequence text, final int start, int end, float x, int top, int y, int bottom, Paint paint) {
        ICustomImgWidget widget;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        TextView textView = this.attachedTextView;
        if (textView == null || (widget = getWidget()) == null) {
            return;
        }
        final View asView = widget.asView();
        MarkdownSpanInfo markdownSpanInfo = null;
        SpannableString spannableString = text instanceof SpannableString ? (SpannableString) text : null;
        if (spannableString != null) {
            Object[] spans = spannableString.getSpans(start, end, MarkdownSpanInfo.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
            MarkdownSpanInfo[] markdownSpanInfoArr = (MarkdownSpanInfo[]) spans;
            if (markdownSpanInfoArr != null) {
                markdownSpanInfo = (MarkdownSpanInfo) ArraysKt.firstOrNull(markdownSpanInfoArr);
            }
        }
        asView.setAlpha((markdownSpanInfo != null ? markdownSpanInfo.getAlpha() : 255.0f) / JfifUtil.MARKER_FIRST_BYTE);
        final int top2 = top + textView.getTop() + textView.getPaddingTop() + (((bottom - top) - this.size.getHeight()) / 2);
        int left = ((int) x) + textView.getLeft() + textView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = asView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.topMargin == top2 && marginLayoutParams.leftMargin == left) {
            if (asView.getVisibility() != 0) {
                printLog("span just show image marginTop " + top2, text, start);
                asView.setVisibility(0);
                return;
            } else {
                printLog("span already show image marginTop " + top2, text, start);
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams2 = asView.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams2;
        marginLayoutParams3.topMargin = top2;
        marginLayoutParams3.leftMargin = left;
        asView.setLayoutParams(marginLayoutParams2);
        asView.setVisibility(4);
        asView.post(new Runnable() { // from class: io.noties.markwon.image.CustomImgSpan$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CustomImgSpan.draw$lambda$4(CustomImgSpan.this, top2, text, start, asView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void draw$lambda$4(CustomImgSpan customImgSpan, int i, CharSequence charSequence, int i2, View view) {
        Intrinsics.checkNotNullParameter(customImgSpan, "this$0");
        Intrinsics.checkNotNullParameter(view, "$widgetView");
        customImgSpan.printLog("post show image marginTop " + i, charSequence, i2);
        view.setVisibility(0);
    }
}
