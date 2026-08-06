package com.edu.onetex.html.nodes;

import android.content.Context;
import android.view.View;
import com.edu.onetex.ScreenUtilKt;
import com.edu.onetex.latex.TexSize;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.view.ILaTeXView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsHtmlNodeCustomView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/edu/onetex/html/nodes/AbsHtmlNodeCustomView;", "Lcom/edu/onetex/latex/view/ILaTeXView;", "width", "Lcom/edu/onetex/latex/TexSize;", "height", "(Lcom/edu/onetex/latex/TexSize;Lcom/edu/onetex/latex/TexSize;)V", "androidView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "getAndroidView", "()Ljava/lang/ref/WeakReference;", "setAndroidView", "(Ljava/lang/ref/WeakReference;)V", "left", "", "top", "createAndroidView", "context", "Landroid/content/Context;", "getViewHeight", "getViewWidth", "paintAndroidView", "", "graphics2D", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "setX", "x", "setY", "y", "updateAndroidViewPosition", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class AbsHtmlNodeCustomView implements ILaTeXView {
    private WeakReference<View> androidView;
    private TexSize height;
    private double left;
    private double top;
    private TexSize width;

    public abstract View createAndroidView(Context context);

    public AbsHtmlNodeCustomView(TexSize width, TexSize height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        this.width = width;
        this.height = height;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WeakReference<View> getAndroidView() {
        return this.androidView;
    }

    protected final void setAndroidView(WeakReference<View> weakReference) {
        this.androidView = weakReference;
    }

    @Override // com.edu.onetex.latex.view.ILaTeXView
    public void setX(double x) {
        View view;
        this.left = x;
        WeakReference<View> weakReference = this.androidView;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setTranslationX(((float) this.left) * ScreenUtilKt.getScreenDensity());
    }

    @Override // com.edu.onetex.latex.view.ILaTeXView
    public void setY(double y) {
        View view;
        this.top = y;
        WeakReference<View> weakReference = this.androidView;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setTranslationY(((float) this.top) * ScreenUtilKt.getScreenDensity());
    }

    @Override // com.edu.onetex.latex.view.ILaTeXView
    public double getViewWidth() {
        return this.width.toPx();
    }

    @Override // com.edu.onetex.latex.view.ILaTeXView
    public double getViewHeight() {
        return this.height.toPx();
    }

    @Override // com.edu.onetex.latex.view.ILaTeXView
    public View getAndroidView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WeakReference<View> weakReference = this.androidView;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            updateAndroidViewPosition();
            return view;
        }
        View createAndroidView = createAndroidView(context);
        this.androidView = new WeakReference<>(createAndroidView);
        updateAndroidViewPosition();
        return createAndroidView;
    }

    @Override // com.edu.onetex.latex.view.ILaTeXView
    public void paintAndroidView(Graphics2D graphics2D) {
        View view;
        Intrinsics.checkNotNullParameter(graphics2D, "graphics2D");
        WeakReference<View> weakReference = this.androidView;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setVisibility(0);
    }

    private final void updateAndroidViewPosition() {
        setX(this.left);
        setY(this.top);
    }
}
