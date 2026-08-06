package com.larus.business.markdown.api.extplugin.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomImgLoader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/ICustomImgLoader;", "", "enableCustomHandle", "", "getEnableCustomHandle", "()Z", "setEnableCustomHandle", "(Z)V", "enableSuccessImgClick", "getEnableSuccessImgClick", "setEnableSuccessImgClick", "handle", "", "info", "Lcom/larus/business/markdown/api/extplugin/image/ImageLoaderInfo;", "handleSuccessImgClick", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ICustomImgLoader {

    /* compiled from: ICustomImgLoader.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static void handle(ICustomImgLoader iCustomImgLoader, ImageLoaderInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }

        public static void handleSuccessImgClick(ICustomImgLoader iCustomImgLoader, ImageLoaderInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    boolean getEnableCustomHandle();

    boolean getEnableSuccessImgClick();

    void handle(ImageLoaderInfo info);

    void handleSuccessImgClick(ImageLoaderInfo info);

    void setEnableCustomHandle(boolean z);

    void setEnableSuccessImgClick(boolean z);
}
