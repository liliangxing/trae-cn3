package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import org.apache.commons.codec.language.bm.Languages;

/* compiled from: PreloadItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "Template", "Image", "Video", "Lottie", "Font", "ExternalJs", "DynamicComponent", "Redirect", "Any", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum PreloadResourceType {
    Template("template"),
    Image("image"),
    Video("video"),
    Lottie("lottie"),
    Font(PreloadConfig.KEY_FONT),
    ExternalJs("externalJs"),
    DynamicComponent("dynamicComponent"),
    Redirect(ReportConsts.RESPONSE_REDIRECT),
    Any(Languages.ANY);

    private final String tag;

    PreloadResourceType(String str) {
        this.tag = str;
    }

    public final String getTag() {
        return this.tag;
    }
}
