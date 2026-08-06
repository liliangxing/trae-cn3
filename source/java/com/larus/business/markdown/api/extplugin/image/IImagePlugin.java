package com.larus.business.markdown.api.extplugin.image;

import android.graphics.Rect;
import io.noties.markwon.AbstractMarkwonPlugin;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IImagePlugin.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J]\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/IImagePlugin;", "", "getPlugin", "Lio/noties/markwon/AbstractMarkwonPlugin;", "imgBgColor", "", "imgCornerRadius", "maxContentWidth", "minWidthHeight", "defaultPlaceImageSize", "Landroid/graphics/Rect;", "customImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "payload", "", "", "(Ljava/lang/Integer;ILjava/lang/Integer;ILandroid/graphics/Rect;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;Ljava/util/Map;)Lio/noties/markwon/AbstractMarkwonPlugin;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IImagePlugin {
    AbstractMarkwonPlugin getPlugin(Integer imgBgColor, int imgCornerRadius, Integer maxContentWidth, int minWidthHeight, Rect defaultPlaceImageSize, ICustomImgHandler customImgHandler, Map<String, ? extends Object> payload);

    /* compiled from: IImagePlugin.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ AbstractMarkwonPlugin getPlugin$default(IImagePlugin iImagePlugin, Integer num, int i, Integer num2, int i2, Rect rect, ICustomImgHandler iCustomImgHandler, Map map, int i3, Object obj) {
            if (obj == null) {
                return iImagePlugin.getPlugin((i3 & 1) != 0 ? null : num, i, num2, i2, rect, iCustomImgHandler, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlugin");
        }
    }
}
