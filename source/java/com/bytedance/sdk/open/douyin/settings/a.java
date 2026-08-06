package com.bytedance.sdk.open.douyin.settings;

/* loaded from: classes5.dex */
public class a {
    private static final String a = "EntranceChecker";

    /* renamed from: com.bytedance.sdk.open.douyin.settings.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class C0102a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.DOUYIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[b.DOUYIN_LITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[b.DOUYIN_HOTSOON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[c.values().length];
            a = iArr2;
            try {
                iArr2[c.AUTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum b {
        DOUYIN,
        DOUYIN_LITE,
        DOUYIN_HOTSOON
    }

    /* loaded from: classes5.dex */
    public enum c {
        AUTH,
        SHARE
    }

    public static boolean a(c cVar, b bVar) {
        int i;
        int i2 = C0102a.a[cVar.ordinal()];
        if (i2 == 1) {
            i = OpenSettingsManager.inst().getSDKConfig().authEntrance;
        } else {
            if (i2 != 2) {
                return false;
            }
            i = OpenSettingsManager.inst().getSDKConfig().shareEntrance;
        }
        int i3 = C0102a.b[bVar.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 == 3 && (i & 4) > 0 : (i & 2) > 0 : (i & 1) > 0;
    }
}
