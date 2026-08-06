package com.bytedance.sdk.open.douyin.settings;

/* renamed from: com.bytedance.sdk.open.douyin.settings.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0125a {

    /* renamed from: a */
    private static final String f97a = "EntranceChecker";

    /* renamed from: com.bytedance.sdk.open.douyin.settings.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f98a;

        /* renamed from: b */
        static final /* synthetic */ int[] f99b;

        static {
            int[] iArr = new int[b.values().length];
            f99b = iArr;
            try {
                iArr[b.DOUYIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f99b[b.DOUYIN_LITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f99b[b.DOUYIN_HOTSOON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[c.values().length];
            f98a = iArr2;
            try {
                iArr2[c.AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f98a[c.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.open.douyin.settings.a$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum b {
        DOUYIN,
        DOUYIN_LITE,
        DOUYIN_HOTSOON
    }

    /* renamed from: com.bytedance.sdk.open.douyin.settings.a$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum c {
        AUTH,
        SHARE
    }

    /* renamed from: a */
    public static boolean m44a(c cVar, b bVar) {
        int i;
        int i2 = a.f98a[cVar.ordinal()];
        if (i2 == 1) {
            i = OpenSettingsManager.inst().getSDKConfig().authEntrance;
        } else {
            if (i2 != 2) {
                return false;
            }
            i = OpenSettingsManager.inst().getSDKConfig().shareEntrance;
        }
        int i3 = a.f99b[bVar.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 == 3 && (i & 4) > 0 : (i & 2) > 0 : (i & 1) > 0;
    }
}
