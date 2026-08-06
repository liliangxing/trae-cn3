package com.larus.business.markdown.fresco;

import android.graphics.Rect;
import com.larus.business.markdown.api.extplugin.image.ICustomImgHandler;
import com.larus.business.markdown.api.extplugin.image.IImagePlugin;
import io.noties.markwon.AbstractMarkwonPlugin;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ImagePluginImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J[\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/fresco/ImagePluginImpl;", "Lcom/larus/business/markdown/api/extplugin/image/IImagePlugin;", "()V", "getPlugin", "Lio/noties/markwon/AbstractMarkwonPlugin;", "imgBgColor", "", "imgCornerRadius", "maxContentWidth", "minWidthHeight", "defaultPlaceImageSize", "Landroid/graphics/Rect;", "customImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "payload", "", "", "", "(Ljava/lang/Integer;ILjava/lang/Integer;ILandroid/graphics/Rect;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;Ljava/util/Map;)Lio/noties/markwon/AbstractMarkwonPlugin;", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ImagePluginImpl implements IImagePlugin {
    @Override // com.larus.business.markdown.api.extplugin.image.IImagePlugin
    public AbstractMarkwonPlugin getPlugin(Integer imgBgColor, int imgCornerRadius, Integer maxContentWidth, int minWidthHeight, Rect defaultPlaceImageSize, ICustomImgHandler customImgHandler, Map<String, ? extends Object> payload) {
        return new ReusableFrescoImagesPlugin(imgBgColor, imgCornerRadius, maxContentWidth, minWidthHeight, defaultPlaceImageSize, customImgHandler, payload);
    }
}
