package io.noties.markwon.image;

import android.graphics.Rect;
import com.larus.business.markdown.api.extplugin.image.ICustomImgHandler;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.core.MarkwonTheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomImageSpanFactory.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/image/CustomImageSpanFactory;", "Lio/noties/markwon/image/ImageSpanFactory;", "imgBgColor", "", "imgCornerRadius", "maxContentWidth", "minWidthHeight", "defaultPlaceImageSize", "Landroid/graphics/Rect;", "customImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "payload", "", "", "", "(Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Rect;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;Ljava/util/Map;)V", "Ljava/lang/Integer;", "getSpans", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CustomImageSpanFactory extends ImageSpanFactory {
    private final ICustomImgHandler customImgHandler;
    private final Rect defaultPlaceImageSize;
    private final Integer imgBgColor;
    private final int imgCornerRadius;
    private final Integer maxContentWidth;
    private final Integer minWidthHeight;
    private final Map<String, Object> payload;

    public CustomImageSpanFactory() {
        this(null, 0, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ CustomImageSpanFactory(Integer num, int i, Integer num2, Integer num3, Rect rect, ICustomImgHandler iCustomImgHandler, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? null : rect, (i2 & 32) != 0 ? null : iCustomImgHandler, (i2 & 64) != 0 ? null : map);
    }

    public CustomImageSpanFactory(Integer num, int i, Integer num2, Integer num3, Rect rect, ICustomImgHandler iCustomImgHandler, Map<String, ? extends Object> map) {
        this.imgBgColor = num;
        this.imgCornerRadius = i;
        this.maxContentWidth = num2;
        this.minWidthHeight = num3;
        this.defaultPlaceImageSize = rect;
        this.customImgHandler = iCustomImgHandler;
        this.payload = map;
    }

    @Override // io.noties.markwon.image.ImageSpanFactory, io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        String require = ImageProps.DESTINATION.require(props);
        Intrinsics.checkNotNullExpressionValue(require, "DESTINATION.require(props)");
        String str = require;
        ImageSize imageSize = ImageProps.IMAGE_SIZE.get(props);
        if (imageSize == null && this.defaultPlaceImageSize == null) {
            return Unit.INSTANCE;
        }
        Integer num = ImageProps.IMAGE_START_INDEX.get(props);
        if (num == null) {
            return Unit.INSTANCE;
        }
        int intValue = num.intValue();
        Integer num2 = ImageProps.IMAGE_END_INDEX.get(props);
        if (num2 == null) {
            return Unit.INSTANCE;
        }
        int intValue2 = num2.intValue();
        Integer num3 = this.maxContentWidth;
        if (num3 == null) {
            return Unit.INSTANCE;
        }
        int intValue3 = num3.intValue();
        Integer num4 = this.minWidthHeight;
        int intValue4 = num4 != null ? num4.intValue() : 0;
        MarkwonTheme theme = configuration.theme();
        Intrinsics.checkNotNullExpressionValue(theme, "configuration.theme()");
        Boolean bool = ImageProps.REPLACEMENT_TEXT_IS_LINK.get(props, false);
        Intrinsics.checkNotNullExpressionValue(bool, "ImageProps.REPLACEMENT_TEXT_IS_LINK[props, false]");
        return new CustomImgSpan(intValue, intValue2, str, theme, bool.booleanValue(), imageSize, this.imgBgColor, this.imgCornerRadius, intValue3, intValue4, this.defaultPlaceImageSize, this.customImgHandler, this.payload, null, AnimationConstant.PROP_COLOR, null);
    }
}
