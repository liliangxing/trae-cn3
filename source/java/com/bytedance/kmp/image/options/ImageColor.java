package com.bytedance.kmp.image.options;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* compiled from: ImageColor.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageColor;", "", "color", "", "(J)V", "getColor", "()J", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageColor {
    public static final int $stable = 0;
    private static final ImageColor Blue;
    private static final ImageColor Cyan;
    private static final ImageColor Gray;
    private static final ImageColor Green;
    private static final ImageColor LightGray;
    private static final ImageColor Magenta;
    private static final ImageColor Red;
    private static final ImageColor Transparent;
    private static final ImageColor White;
    private static final ImageColor Yellow;
    private static final ArrayList<ImageColor> randomColorList;
    private final long color;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImageColor Black = new ImageColor(4278190080L);
    private static final ImageColor DarkGray = new ImageColor(4282664004L);

    public ImageColor(long j) {
        this.color = j;
    }

    /* compiled from: ImageColor.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010,\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u0007R\u001c\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\u0007R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00040*j\b\u0012\u0004\u0012\u00020\u0004`+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageColor$Companion;", "", "()V", "Black", "Lcom/bytedance/kmp/image/options/ImageColor;", "getBlack$annotations", "getBlack", "()Lcom/bytedance/kmp/image/options/ImageColor;", "Blue", "getBlue$annotations", "getBlue", "Cyan", "getCyan$annotations", "getCyan", "DarkGray", "getDarkGray$annotations", "getDarkGray", "Gray", "getGray$annotations", "getGray", "Green", "getGreen$annotations", "getGreen", "LightGray", "getLightGray$annotations", "getLightGray", "Magenta", "getMagenta$annotations", "getMagenta", "Red", "getRed$annotations", "getRed", "Transparent", "getTransparent$annotations", "getTransparent", "White", "getWhite$annotations", "getWhite", "Yellow", "getYellow$annotations", "getYellow", "randomColorList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "randomColor", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getBlack$annotations() {
        }

        public static /* synthetic */ void getBlue$annotations() {
        }

        public static /* synthetic */ void getCyan$annotations() {
        }

        public static /* synthetic */ void getDarkGray$annotations() {
        }

        public static /* synthetic */ void getGray$annotations() {
        }

        public static /* synthetic */ void getGreen$annotations() {
        }

        public static /* synthetic */ void getLightGray$annotations() {
        }

        public static /* synthetic */ void getMagenta$annotations() {
        }

        public static /* synthetic */ void getRed$annotations() {
        }

        public static /* synthetic */ void getTransparent$annotations() {
        }

        public static /* synthetic */ void getWhite$annotations() {
        }

        public static /* synthetic */ void getYellow$annotations() {
        }

        private Companion() {
        }

        public final ImageColor getBlack() {
            return ImageColor.Black;
        }

        public final ImageColor getDarkGray() {
            return ImageColor.DarkGray;
        }

        public final ImageColor getGray() {
            return ImageColor.Gray;
        }

        public final ImageColor getLightGray() {
            return ImageColor.LightGray;
        }

        public final ImageColor getWhite() {
            return ImageColor.White;
        }

        public final ImageColor getRed() {
            return ImageColor.Red;
        }

        public final ImageColor getGreen() {
            return ImageColor.Green;
        }

        public final ImageColor getBlue() {
            return ImageColor.Blue;
        }

        public final ImageColor getYellow() {
            return ImageColor.Yellow;
        }

        public final ImageColor getCyan() {
            return ImageColor.Cyan;
        }

        public final ImageColor getMagenta() {
            return ImageColor.Magenta;
        }

        public final ImageColor getTransparent() {
            return ImageColor.Transparent;
        }

        public final ImageColor randomColor() {
            Object obj = ImageColor.randomColorList.get(Random.INSTANCE.nextInt(ImageColor.randomColorList.size() - 1));
            Intrinsics.checkNotNullExpressionValue(obj, "randomColorList[Random.n…andomColorList.size - 1)]");
            return (ImageColor) obj;
        }
    }

    public final long getColor() {
        return this.color;
    }

    static {
        ImageColor imageColor = new ImageColor(4287137928L);
        Gray = imageColor;
        LightGray = new ImageColor(4291611852L);
        White = new ImageColor(BodyPartID.bodyIdMax);
        ImageColor imageColor2 = new ImageColor(4294901760L);
        Red = imageColor2;
        ImageColor imageColor3 = new ImageColor(4278255360L);
        Green = imageColor3;
        ImageColor imageColor4 = new ImageColor(4278190335L);
        Blue = imageColor4;
        ImageColor imageColor5 = new ImageColor(4294967040L);
        Yellow = imageColor5;
        ImageColor imageColor6 = new ImageColor(4278255615L);
        Cyan = imageColor6;
        ImageColor imageColor7 = new ImageColor(4294902015L);
        Magenta = imageColor7;
        Transparent = new ImageColor(0L);
        randomColorList = CollectionsKt.arrayListOf(imageColor, imageColor2, imageColor3, imageColor4, imageColor5, imageColor6, imageColor7);
    }
}
