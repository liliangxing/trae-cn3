package io.noties.markwon.html.tag;

import android.text.TextUtils;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.image.ImageProps;
import io.noties.markwon.image.ImageSize;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.commonmark.node.Image;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImageHandler extends SimpleTagHandler {
    private final ImageSizeParser imageSizeParser;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface ImageSizeParser {
        ImageSize parse(Map<String, String> map);
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler, io.noties.markwon.html.TagHandler
    public Collection<String> supportedTags() {
        return Collections.singleton("img");
    }

    public static ImageHandler create() {
        return new ImageHandler(new ImageSizeParserImpl(CssInlineStyleParser.create()));
    }

    public ImageHandler(ImageSizeParser imageSizeParser) {
        this.imageSizeParser = imageSizeParser;
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        SpanFactory spanFactory;
        String str = htmlTag.attributes().get("src");
        if ((TextUtils.isEmpty(str) && !markwonConfiguration.theme().enablePlaceHolderIfDestinationBlank) || (spanFactory = markwonConfiguration.spansFactory().get(Image.class)) == null) {
            return null;
        }
        String process = !TextUtils.isEmpty(str) ? markwonConfiguration.imageDestinationProcessor().process(str) : "";
        ImageSize parse = this.imageSizeParser.parse(htmlTag.attributes());
        ImageProps.DESTINATION.set(renderProps, process);
        ImageProps.IMAGE_SIZE.set(renderProps, parse);
        ImageProps.REPLACEMENT_TEXT_IS_LINK.set(renderProps, false);
        ImageProps.IMAGE_START_INDEX.set(renderProps, Integer.valueOf(htmlTag.start()));
        ImageProps.IMAGE_END_INDEX.set(renderProps, Integer.valueOf(htmlTag.end()));
        return spanFactory.getSpans(markwonConfiguration, renderProps);
    }
}
