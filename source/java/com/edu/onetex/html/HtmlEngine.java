package com.edu.onetex.html;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/edu/onetex/html/HtmlEngine;", "", "()V", "imageLoaderFactory", "Lcom/edu/onetex/html/IImageLoader;", "imageUrlDomain", "", "getImageLoader", "getImageUrlDomain", "registerImageLoader", "", "imageLoader", "setupImageUrlDomain", "domain", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class HtmlEngine {
    private static IImageLoader imageLoaderFactory;
    public static final HtmlEngine INSTANCE = new HtmlEngine();
    private static String imageUrlDomain = "";

    private HtmlEngine() {
    }

    public final void registerImageLoader(IImageLoader imageLoader) {
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        imageLoaderFactory = imageLoader;
    }

    public final IImageLoader getImageLoader() {
        return imageLoaderFactory;
    }

    public final void setupImageUrlDomain(String domain) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        imageUrlDomain = domain;
    }

    public final String getImageUrlDomain() {
        return imageUrlDomain;
    }
}
