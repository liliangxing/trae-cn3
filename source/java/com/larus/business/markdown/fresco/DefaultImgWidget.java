package com.larus.business.markdown.fresco;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.net.Uri;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.image.ICustomImgLoader;
import com.larus.business.markdown.api.extplugin.image.ICustomImgSpan;
import com.larus.business.markdown.api.extplugin.image.ICustomImgWidget;
import com.larus.business.markdown.api.extplugin.image.ImageInfo;
import com.larus.business.markdown.api.extplugin.image.ImageLoaderInfo;
import com.larus.business.markdown.fresco.databinding.MdCustomImgWidgetBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: DefaultImgWidget.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J>\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%H\u0016J0\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020&H\u0002J\u0018\u00100\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001a\u00101\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u00010\u000b2\u0006\u00103\u001a\u00020\u0013H\u0002J\u0018\u00104\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0002J \u00105\u001a\u00020)2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u00106\u001a\u00020)2\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/business/markdown/fresco/DefaultImgWidget;", "Landroid/widget/FrameLayout;", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "customImgLoader", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgLoader;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgLoader;)V", "currInflateView", "Landroid/view/View;", "imageIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "imageInfoList", "", "Lcom/larus/business/markdown/api/extplugin/image/ImageInfo;", "imageViewList", "Lkotlin/Pair;", "", "imgSpanList", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;", "lastBindJob", "Lkotlinx/coroutines/Job;", "spanSize", "Landroid/util/Size;", "widgetSize", "asView", "bindData", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "rect", "Landroid/graphics/Rect;", "payload", "", "", "", "bindImage", "", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "targetWidth", "targetHeight", "getBigImageInfo", "url", "onReuse", "setClipViewCornerRadius", "view", "radius", "updateImageInfo", "updateSimpleImageGroupUISingle", "updateSpanSize", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultImgWidget extends FrameLayout implements ICustomImgWidget {
    private View currInflateView;
    private final ICustomImgLoader customImgLoader;
    private final AtomicInteger imageIndex;
    private final List<ImageInfo> imageInfoList;
    private final List<Pair<Integer, View>> imageViewList;
    private final List<ICustomImgSpan> imgSpanList;
    private Job lastBindJob;
    private Size spanSize;
    private Size widgetSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultImgWidget(Context context) {
        this(context, null, null, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultImgWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DefaultImgWidget(Context context, AttributeSet attributeSet, ICustomImgLoader iCustomImgLoader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet, (i & 4) != 0 ? null : iCustomImgLoader);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultImgWidget(Context context, AttributeSet attributeSet, ICustomImgLoader iCustomImgLoader) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.customImgLoader = iCustomImgLoader;
        this.spanSize = new Size(0, 0);
        this.widgetSize = new Size(0, 0);
        this.imgSpanList = new ArrayList();
        this.imageViewList = new ArrayList();
        this.imageInfoList = new ArrayList();
        this.imageIndex = new AtomicInteger(0);
    }

    private final void updateImageInfo(Spanned text, ICustomImgSpan span) {
        this.imgSpanList.clear();
        List<ICustomImgSpan> list = this.imgSpanList;
        int i = 0;
        Object[] spans = text.getSpans(0, text.length(), ICustomImgSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(0, text.le…ustomImgSpan::class.java)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            if (((ICustomImgSpan) obj).getWidget() != null) {
                arrayList.add(obj);
            }
        }
        list.addAll(CollectionsKt.reversed(arrayList));
        this.imageViewList.clear();
        List<Pair<Integer, View>> list2 = this.imageViewList;
        List<ICustomImgSpan> list3 = this.imgSpanList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (Object obj2 : list3) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer valueOf = Integer.valueOf(i);
            ICustomImgWidget widget = ((ICustomImgSpan) obj2).getWidget();
            Intrinsics.checkNotNull(widget);
            arrayList2.add(TuplesKt.to(valueOf, widget.asView()));
            i = i2;
        }
        list2.addAll(arrayList2);
        this.imageInfoList.clear();
        List<ImageInfo> list4 = this.imageInfoList;
        List<ICustomImgSpan> list5 = this.imgSpanList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        Iterator<T> it = list5.iterator();
        while (it.hasNext()) {
            arrayList3.add(getBigImageInfo(((ICustomImgSpan) it.next()).getUrl()));
        }
        list4.addAll(arrayList3);
        this.imageIndex.set(this.imgSpanList.indexOf(span));
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgWidget
    public Size bindData(TextView textView, Spanned text, ICustomImgSpan span, Rect rect, Map<String, ? extends Object> payload) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(rect, "rect");
        updateSpanSize(rect);
        Job job = this.lastBindJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.lastBindJob = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new DefaultImgWidget$bindData$1(this, span, text, textView, null), 3, (Object) null);
        return this.spanSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSimpleImageGroupUISingle(ICustomImgSpan span, Spanned text, TextView textView) {
        MdCustomImgWidgetBinding bind;
        View view = this.currInflateView;
        boolean z = false;
        if (view != null && view.getId() == C1324R.id.custom_img_widget_group) {
            z = true;
        }
        if (!z) {
            removeAllViews();
            bind = MdCustomImgWidgetBinding.inflate(LayoutInflater.from(getContext()), this, true);
        } else {
            bind = MdCustomImgWidgetBinding.bind(view);
        }
        Intrinsics.checkNotNullExpressionValue(bind, "if (currInflateView?.id …urrInflateView)\n        }");
        View root = bind.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        View view2 = root;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            layoutParams.height = -1;
            view2.setLayoutParams(layoutParams);
            updateImageInfo(text, span);
            SimpleDraweeView simpleDraweeView = bind.customImgWidget;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "binding.customImgWidget");
            bindImage(simpleDraweeView, textView, span, this.widgetSize.getWidth(), this.widgetSize.getHeight());
            setClipViewCornerRadius(this, span.getImgCornerRadius());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void setClipViewCornerRadius(View view, final int radius) {
        if (view != null) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.larus.business.markdown.fresco.DefaultImgWidget$setClipViewCornerRadius$1$1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), radius);
                }
            });
            view.setClipToOutline(true);
        }
    }

    private final void bindImage(final SimpleDraweeView imageView, final TextView textView, final ICustomImgSpan span, final int targetWidth, final int targetHeight) {
        try {
            imageView.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(span.getImgCornerRadius()));
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.larus.business.markdown.fresco.DefaultImgWidget$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bindImage$lambda$5;
                    bindImage$lambda$5 = DefaultImgWidget.bindImage$lambda$5(textView, view);
                    return bindImage$lambda$5;
                }
            });
            final ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo(imageView, textView, span, this.imageViewList, this.imageInfoList, this.imageIndex, targetWidth, targetHeight);
            ICustomImgLoader iCustomImgLoader = this.customImgLoader;
            boolean z = false;
            if (iCustomImgLoader != null && iCustomImgLoader.getEnableCustomHandle()) {
                z = true;
            }
            if (z) {
                this.customImgLoader.handle(imageLoaderInfo);
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new Function0<Unit>() { // from class: com.larus.business.markdown.fresco.DefaultImgWidget$bindImage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2813invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2813invoke() {
                    ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(ICustomImgSpan.this.getUrl())).setLocalThumbnailPreviewsEnabled(true).setResizeOptions(new ResizeOptions(targetWidth, targetHeight)).build();
                    imageView.setController(Fresco.newDraweeControllerBuilder().setOldController(imageView.getController()).setAutoPlayAnimations(true).setTapToRetryEnabled(false).setImageRequest(build).setControllerListener(new DefaultImgWidget$bindImage$2$controllerListener$1(imageView, this, ICustomImgSpan.this, objectRef, imageLoaderInfo)).build());
                }
            };
            ((Function0) objectRef.element).invoke();
        } catch (Throwable th) {
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2529e("DefaultImgWidget", "error:" + th.getMessage() + ",url:" + span.getUrl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindImage$lambda$5(TextView textView, View view) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        return textView.performLongClick();
    }

    private final ImageInfo getBigImageInfo(String url) {
        return new ImageInfo(url, url, url);
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgWidget
    public View asView() {
        return this;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.ICustomImgWidget
    public void onReuse(Spanned text, ICustomImgSpan span) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(span, "span");
        updateImageInfo(text, span);
    }

    private final void updateSpanSize(Rect rect) {
        this.spanSize = new Size(rect.width(), rect.height());
        this.widgetSize = new Size(rect.width(), rect.height());
    }
}
