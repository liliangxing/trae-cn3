package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.CssProperty;
import io.noties.markwon.html.tag.ImageHandler;
import io.noties.markwon.image.ImageSize;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImageSizeParserImpl implements ImageHandler.ImageSizeParser {
    private final CssInlineStyleParser inlineStyleParser;

    public ImageSizeParserImpl(CssInlineStyleParser cssInlineStyleParser) {
        this.inlineStyleParser = cssInlineStyleParser;
    }

    @Override // io.noties.markwon.html.tag.ImageHandler.ImageSizeParser
    public ImageSize parse(Map<String, String> map) {
        ImageSize.Dimension dimension;
        ImageSize.Dimension dimension2;
        String str = map.get("style");
        if (!TextUtils.isEmpty(str)) {
            dimension = null;
            dimension2 = null;
            for (CssProperty cssProperty : this.inlineStyleParser.parse(str)) {
                String key = cssProperty.key();
                if (AnimationConstant.PROP_STR_WIDTH.equals(key)) {
                    dimension = dimension(cssProperty.value());
                } else if (AnimationConstant.PROP_STR_HEIGHT.equals(key)) {
                    dimension2 = dimension(cssProperty.value());
                }
                if (dimension != null && dimension2 != null) {
                    break;
                }
            }
        } else {
            dimension = null;
            dimension2 = null;
        }
        if (dimension != null && dimension2 != null) {
            return new ImageSize(dimension, dimension2);
        }
        if (dimension == null) {
            dimension = dimension(map.get(AnimationConstant.PROP_STR_WIDTH));
        }
        if (dimension2 == null) {
            dimension2 = dimension(map.get(AnimationConstant.PROP_STR_HEIGHT));
        }
        if (dimension == null && dimension2 == null) {
            return null;
        }
        return new ImageSize(dimension, dimension2);
    }

    ImageSize.Dimension dimension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i = length - 1;
        int i2 = i;
        while (i2 > -1) {
            if (Character.isDigit(str.charAt(i2))) {
                int i3 = i2 + 1;
                try {
                    return new ImageSize.Dimension(Float.parseFloat(str.substring(0, i3)), i2 == i ? null : str.substring(i3, length));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            i2--;
        }
        return null;
    }
}
