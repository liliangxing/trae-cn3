package com.edu.onetex.html.nodes;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.edu.onetex.html.HtmlEngine;
import com.edu.onetex.html.IImageLoader;
import com.edu.onetex.latex.TexSize;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.widget.RetryImageLayout;
import com.lynx.tasm.animation.AnimationConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ImageNodeCustomView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/edu/onetex/html/nodes/ImageNodeCustomView;", "Lcom/edu/onetex/html/nodes/AbsHtmlNodeCustomView;", AnimationConstant.PROP_STR_WIDTH, "Lcom/edu/onetex/latex/TexSize;", AnimationConstant.PROP_STR_HEIGHT, "src", "", "domain", "(Lcom/edu/onetex/latex/TexSize;Lcom/edu/onetex/latex/TexSize;Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/edu/onetex/html/IImageLoader$ILoadResult;", "onRetryClickListener", "Landroid/view/View$OnClickListener;", "createAndroidView", "Landroid/view/View;", "context", "Landroid/content/Context;", "loadImage", "", "paintAndroidView", "graphics2D", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ImageNodeCustomView extends AbsHtmlNodeCustomView {
    private final IImageLoader.ILoadResult callback;
    private final String domain;
    private final View.OnClickListener onRetryClickListener;
    private final String src;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageNodeCustomView(TexSize texSize, TexSize texSize2, String str, String str2) {
        super(texSize, texSize2);
        Intrinsics.checkNotNullParameter(texSize, AnimationConstant.PROP_STR_WIDTH);
        Intrinsics.checkNotNullParameter(texSize2, AnimationConstant.PROP_STR_HEIGHT);
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "domain");
        this.src = str;
        this.domain = str2;
        this.callback = new IImageLoader.ILoadResult() { // from class: com.edu.onetex.html.nodes.ImageNodeCustomView$callback$1
            @Override // com.edu.onetex.html.IImageLoader.ILoadResult
            public void onLoadFailed() {
                WeakReference<View> androidView = ImageNodeCustomView.this.getAndroidView();
                View view = androidView != null ? androidView.get() : null;
                RetryImageLayout retryImageLayout = (RetryImageLayout) (view instanceof RetryImageLayout ? view : null);
                if (retryImageLayout != null) {
                    retryImageLayout.setRetryVisible(true);
                }
            }

            @Override // com.edu.onetex.html.IImageLoader.ILoadResult
            public void onLoadSuccess() {
                WeakReference<View> androidView = ImageNodeCustomView.this.getAndroidView();
                View view = androidView != null ? androidView.get() : null;
                RetryImageLayout retryImageLayout = (RetryImageLayout) (view instanceof RetryImageLayout ? view : null);
                if (retryImageLayout != null) {
                    retryImageLayout.setRetryVisible(false);
                }
            }
        };
        this.onRetryClickListener = new View.OnClickListener() { // from class: com.edu.onetex.html.nodes.ImageNodeCustomView$onRetryClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageNodeCustomView.this.loadImage();
                WeakReference<View> androidView = ImageNodeCustomView.this.getAndroidView();
                View view2 = androidView != null ? androidView.get() : null;
                RetryImageLayout retryImageLayout = (RetryImageLayout) (view2 instanceof RetryImageLayout ? view2 : null);
                if (retryImageLayout != null) {
                    retryImageLayout.setRetryVisible(false);
                }
            }
        };
    }

    @Override // com.edu.onetex.html.nodes.AbsHtmlNodeCustomView
    public View createAndroidView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RetryImageLayout retryImageLayout = new RetryImageLayout(context, null, 0, 6, null);
        retryImageLayout.setOnRetryClickListener(this.onRetryClickListener);
        return retryImageLayout;
    }

    @Override // com.edu.onetex.html.nodes.AbsHtmlNodeCustomView, com.edu.onetex.latex.view.ILaTeXView
    public void paintAndroidView(Graphics2D graphics2D) {
        Intrinsics.checkNotNullParameter(graphics2D, "graphics2D");
        super.paintAndroidView(graphics2D);
        loadImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadImage() {
        ImageView imageView;
        String str;
        WeakReference<View> androidView = getAndroidView();
        View view = androidView != null ? androidView.get() : null;
        if (!(view instanceof RetryImageLayout)) {
            view = null;
        }
        RetryImageLayout retryImageLayout = (RetryImageLayout) view;
        if (retryImageLayout == null || (imageView = retryImageLayout.getImageView()) == null) {
            return;
        }
        if (StringsKt.startsWith$default(this.src, "https", false, 2, (Object) null) | StringsKt.startsWith$default(this.src, "http", false, 2, (Object) null)) {
            str = this.src;
        } else {
            str = this.domain + this.src;
        }
        IImageLoader imageLoader = HtmlEngine.INSTANCE.getImageLoader();
        if (imageLoader != null) {
            imageLoader.load(imageView, str, this.callback);
        }
    }
}
