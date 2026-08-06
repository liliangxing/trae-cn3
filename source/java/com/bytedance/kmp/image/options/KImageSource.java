package com.bytedance.kmp.image.options;

import kotlin.Metadata;

/* compiled from: KImageSource.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/image/options/KImageSource;", "", "getType", "", "isLocalSource", "", "Companion", "Lcom/bytedance/kmp/image/options/AssetSource;", "Lcom/bytedance/kmp/image/options/ColorSource;", "Lcom/bytedance/kmp/image/options/LocalResourceSource;", "Lcom/bytedance/kmp/image/options/None;", "Lcom/bytedance/kmp/image/options/UrlSource;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface KImageSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int SOURCE_TYPE_ASSET = 3;
    public static final int SOURCE_TYPE_COLOR = 4;
    public static final int SOURCE_TYPE_LOCAL_RESOURCE = 2;
    public static final int SOURCE_TYPE_NONE = 0;
    public static final int SOURCE_TYPE_URL = 1;

    int getType();

    boolean isLocalSource();

    /* compiled from: KImageSource.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean isLocalSource(KImageSource kImageSource) {
            return kImageSource.getType() == 3 || kImageSource.getType() == 2;
        }
    }

    /* compiled from: KImageSource.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/kmp/image/options/KImageSource$Companion;", "", "()V", "SOURCE_TYPE_ASSET", "", "SOURCE_TYPE_COLOR", "SOURCE_TYPE_LOCAL_RESOURCE", "SOURCE_TYPE_NONE", "SOURCE_TYPE_URL", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int SOURCE_TYPE_ASSET = 3;
        public static final int SOURCE_TYPE_COLOR = 4;
        public static final int SOURCE_TYPE_LOCAL_RESOURCE = 2;
        public static final int SOURCE_TYPE_NONE = 0;
        public static final int SOURCE_TYPE_URL = 1;

        private Companion() {
        }
    }
}
