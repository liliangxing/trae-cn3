package com.facebook.drawee.view;

import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.SizeReadyCallback;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LazySizeAttach implements SizeReadyCallback {
    private AbstractDraweeControllerBuilder mControllerBuilder;
    private DraweeView mDraweeView;
    private ImageRequestBuilder mRequestBuilder;

    public LazySizeAttach(ImageRequestBuilder imageRequestBuilder, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, DraweeView draweeView) {
        init(imageRequestBuilder, abstractDraweeControllerBuilder, draweeView);
    }

    private void init(ImageRequestBuilder imageRequestBuilder, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, DraweeView draweeView) {
        Preconditions.checkNotNull(imageRequestBuilder);
        Preconditions.checkNotNull(abstractDraweeControllerBuilder);
        Preconditions.checkNotNull(draweeView);
        this.mRequestBuilder = imageRequestBuilder;
        this.mControllerBuilder = abstractDraweeControllerBuilder;
        this.mDraweeView = draweeView;
    }

    @Override // com.facebook.imagepipeline.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        ImageRequestBuilder imageRequestBuilder = this.mRequestBuilder;
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        if (imageRequestBuilder == null) {
            return;
        }
        imageRequestBuilder.setResizeOptions(new ResizeOptions(i, i2));
        abstractDraweeControllerBuilder.setImageRequest(imageRequestBuilder.build());
        this.mDraweeView.setController(abstractDraweeControllerBuilder.build());
    }
}
