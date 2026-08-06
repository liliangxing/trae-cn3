package com.lynx.tasm.p001ui.image;

import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.generic.WrappingUtils;
import com.lynx.tasm.BehaviorClassWarmer;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.p001ui.image.fresco.BaseRoundedCornerPostprocessor;
import com.lynx.tasm.p001ui.image.helper.ImageResizeUtils;
import com.lynx.tasm.p001ui.image.helper.ImageSource;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIImageClassWarmer implements BehaviorClassWarmer {
    public void warmClass() {
        try {
            Class.forName(FlattenUIImage.class.getName());
            Class.forName(LynxImageManager.class.getName());
            Class.forName(UIImage.class.getName());
            Class.forName(ImageUtils.class.getName());
            Class.forName(ImageResizeUtils.class.getName());
            Class.forName(AutoSizeImage.class.getName());
            Class.forName(ImageResizeMode.class.getName());
            Class.forName(LynxAbstractDraweeControllerBuilder.class.getName());
            Class.forName(LynxAbstractDraweeController.class.getName());
            Class.forName(LynxDraweeControllerBuilder.class.getName());
            Class.forName(LynxDraweeController.class.getName());
            Class.forName(FrescoImageView.class.getName());
            Class.forName(FrescoBackgroundImageDrawable.class.getName());
            Class.forName(BaseRoundedCornerPostprocessor.class.getName());
            Class.forName(TemporaryDraweeHolder.class.getName());
            Class.forName(ImageResizeMethod.class.getName());
            Class.forName(ImageSource.class.getName());
            Class.forName(AbstractDraweeControllerBuilder.class.getName());
            Class.forName(PipelineDraweeControllerBuilder.class.getName());
            Class.forName(BaseControllerListener.class.getName());
            Class.forName(GenericDraweeHierarchyBuilder.class.getName());
            Class.forName(RoundingParams.class.getName());
            Class.forName(GenericDraweeHierarchy.class.getName());
            Class.forName(ForwardingDrawable.class.getName());
            Class.forName(DrawableProperties.class.getName());
            Class.forName(DrawableUtils.class.getName());
            Class.forName(WrappingUtils.class.getName());
            Class.forName(ScaleTypeDrawable.class.getName());
            Class.forName(ArrayDrawable.class.getName());
            Class.forName(FadeDrawable.class.getName());
            Class.forName(RoundedColorDrawable.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
