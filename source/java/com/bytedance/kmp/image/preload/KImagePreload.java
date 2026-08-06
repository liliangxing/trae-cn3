package com.bytedance.kmp.image.preload;

import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.kmp.image.options.ImageOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KImagePreload.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/kmp/image/preload/KImagePreload;", "", "()V", ResourceInfo.RESOURCE_FROM_PRELOAD, "", "url", "", "imageOption", "Lcom/bytedance/kmp/image/options/ImageOptions;", "cacheStrategy", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "preloadToDisk", "preloadToMemory", "CacheStrategy", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KImagePreload {
    public static final int $stable = 0;
    public static final KImagePreload INSTANCE = new KImagePreload();

    private KImagePreload() {
    }

    public static /* synthetic */ void preload$default(KImagePreload kImagePreload, String str, ImageOptions imageOptions, CacheStrategy cacheStrategy, int i, Object obj) {
        if ((i & 2) != 0) {
            imageOptions = ImageOptions.INSTANCE.newInstance();
        }
        if ((i & 4) != 0) {
            cacheStrategy = CacheStrategy.Disk.INSTANCE;
        }
        kImagePreload.preload(str, imageOptions, cacheStrategy);
    }

    public final void preload(String url, ImageOptions imageOption, CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageOption, "imageOption");
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        KImagePreload_androidKt.preloadImg(url, imageOption, cacheStrategy);
    }

    public static /* synthetic */ void preloadToDisk$default(KImagePreload kImagePreload, String str, ImageOptions imageOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            imageOptions = ImageOptions.INSTANCE.newInstance();
        }
        kImagePreload.preloadToDisk(str, imageOptions);
    }

    public final void preloadToDisk(String url, ImageOptions imageOption) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageOption, "imageOption");
        preload(url, imageOption, CacheStrategy.Disk.INSTANCE);
    }

    public static /* synthetic */ void preloadToMemory$default(KImagePreload kImagePreload, String str, ImageOptions imageOptions, int i, Object obj) {
        if ((i & 2) != 0) {
            imageOptions = ImageOptions.INSTANCE.newInstance();
        }
        kImagePreload.preloadToMemory(str, imageOptions);
    }

    public final void preloadToMemory(String url, ImageOptions imageOption) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageOption, "imageOption");
        preload(url, imageOption, CacheStrategy.Memory.INSTANCE);
    }

    /* compiled from: KImagePreload.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "", "()V", "All", "Disk", "Memory", "Request", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$All;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$Disk;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$Memory;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$Request;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class CacheStrategy {
        public static final int $stable = 0;

        public /* synthetic */ CacheStrategy(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: KImagePreload.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$Disk;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class Disk extends CacheStrategy {
            public static final int $stable = 0;
            public static final Disk INSTANCE = new Disk();

            private Disk() {
                super(null);
            }
        }

        private CacheStrategy() {
        }

        /* compiled from: KImagePreload.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$Memory;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class Memory extends CacheStrategy {
            public static final int $stable = 0;
            public static final Memory INSTANCE = new Memory();

            private Memory() {
                super(null);
            }
        }

        /* compiled from: KImagePreload.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$Request;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class Request extends CacheStrategy {
            public static final int $stable = 0;
            public static final Request INSTANCE = new Request();

            private Request() {
                super(null);
            }
        }

        /* compiled from: KImagePreload.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy$All;", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "()V", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class All extends CacheStrategy {
            public static final int $stable = 0;
            public static final All INSTANCE = new All();

            private All() {
                super(null);
            }
        }
    }
}
