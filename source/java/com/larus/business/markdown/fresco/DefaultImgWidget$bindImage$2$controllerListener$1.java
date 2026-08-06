package com.larus.business.markdown.fresco;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.business.markdown.api.extplugin.image.ICustomImgLoader;
import com.larus.business.markdown.api.extplugin.image.ICustomImgSpan;
import com.larus.business.markdown.api.extplugin.image.ImageLoaderInfo;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DefaultImgWidget.kt */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/larus/business/markdown/fresco/DefaultImgWidget$bindImage$2$controllerListener$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "onFailure", "", "id", "", LynxError.LYNX_THROWABLE, "", "onFinalImageSet", "imageInfo", "animatable", "Landroid/graphics/drawable/Animatable;", "onSubmit", "callerContext", "", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultImgWidget$bindImage$2$controllerListener$1 extends BaseControllerListener<ImageInfo> {
    final /* synthetic */ ImageLoaderInfo $imageLoaderInfo;
    final /* synthetic */ SimpleDraweeView $imageView;
    final /* synthetic */ Ref.ObjectRef<Function0<Unit>> $loadImgTask;
    final /* synthetic */ ICustomImgSpan $span;
    final /* synthetic */ DefaultImgWidget this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultImgWidget$bindImage$2$controllerListener$1(SimpleDraweeView simpleDraweeView, DefaultImgWidget defaultImgWidget, ICustomImgSpan iCustomImgSpan, Ref.ObjectRef<Function0<Unit>> objectRef, ImageLoaderInfo imageLoaderInfo) {
        this.$imageView = simpleDraweeView;
        this.this$0 = defaultImgWidget;
        this.$span = iCustomImgSpan;
        this.$loadImgTask = objectRef;
        this.$imageLoaderInfo = imageLoaderInfo;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String id, Object callerContext) {
        this.$imageView.getHierarchy().setPlaceholderImage(ContextCompat.getDrawable(this.this$0.getContext(), C1324R.drawable.flow_md_img_placeholder), ScalingUtils.ScaleType.CENTER_CROP);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFailure(String id, Throwable throwable) {
        if (this.$span.getUrl().length() == 0) {
            this.$imageView.getHierarchy().setPlaceholderImage(ContextCompat.getDrawable(this.this$0.getContext(), C1324R.drawable.md_img_error_alert), ScalingUtils.ScaleType.CENTER_CROP);
            return;
        }
        this.$imageView.getHierarchy().setPlaceholderImage(ContextCompat.getDrawable(this.this$0.getContext(), C1324R.drawable.md_img_error), ScalingUtils.ScaleType.CENTER_CROP);
        SimpleDraweeView simpleDraweeView = this.$imageView;
        final Ref.ObjectRef<Function0<Unit>> objectRef = this.$loadImgTask;
        simpleDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.larus.business.markdown.fresco.DefaultImgWidget$bindImage$2$controllerListener$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultImgWidget$bindImage$2$controllerListener$1.onFailure$lambda$0(objectRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "$loadImgTask");
        Function0 function0 = (Function0) objectRef.element;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (imageInfo == null) {
            return;
        }
        this.$imageView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        Integer imgBgColor = this.$span.getImgBgColor();
        if (imgBgColor != null) {
            DefaultImgWidget defaultImgWidget = this.this$0;
            SimpleDraweeView simpleDraweeView = this.$imageView;
            imgBgColor.intValue();
            simpleDraweeView.getHierarchy().setActualImageColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(defaultImgWidget.getContext(), C1324R.color.press), PorterDuff.Mode.DST_OVER));
        }
        SimpleDraweeView simpleDraweeView2 = this.$imageView;
        final DefaultImgWidget defaultImgWidget2 = this.this$0;
        final ImageLoaderInfo imageLoaderInfo = this.$imageLoaderInfo;
        simpleDraweeView2.setOnClickListener(new View.OnClickListener() { // from class: com.larus.business.markdown.fresco.DefaultImgWidget$bindImage$2$controllerListener$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultImgWidget$bindImage$2$controllerListener$1.onFinalImageSet$lambda$2(DefaultImgWidget.this, imageLoaderInfo, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFinalImageSet$lambda$2(DefaultImgWidget defaultImgWidget, ImageLoaderInfo imageLoaderInfo, View view) {
        ICustomImgLoader iCustomImgLoader;
        Intrinsics.checkNotNullParameter(defaultImgWidget, "this$0");
        Intrinsics.checkNotNullParameter(imageLoaderInfo, "$imageLoaderInfo");
        iCustomImgLoader = defaultImgWidget.customImgLoader;
        if (iCustomImgLoader != null) {
            iCustomImgLoader.handleSuccessImgClick(imageLoaderInfo);
        }
    }
}
