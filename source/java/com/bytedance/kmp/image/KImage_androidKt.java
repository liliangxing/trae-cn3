package com.bytedance.kmp.image;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import com.bytedance.kmp.image.options.ImageOptions;
import com.bytedance.kmp.image.options.KImageSource;
import com.bytedance.kmp.image.painter.AndroidFrescoPainterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KImage.android.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f¨\u0006\u0013"}, d2 = {"KImage", "", "imageSource", "Lcom/bytedance/kmp/image/options/KImageSource;", "contentDescription", "", "alignment", "Landroidx/compose/ui/Alignment;", "imageOption", "Lcom/bytedance/kmp/image/options/ImageOptions;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bytedance/kmp/image/options/KImageSource;Ljava/lang/String;Landroidx/compose/ui/Alignment;Lcom/bytedance/kmp/image/options/ImageOptions;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "setCoilSmallerCache", "enable", "", "setKImageUseOptimization", "staticImage", "animatedImage", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KImage_androidKt {
    public static final void setCoilSmallerCache(boolean z) {
    }

    public static final void setKImageUseOptimization(boolean z, boolean z2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void KImage(final KImageSource kImageSource, String str, Alignment alignment, ImageOptions imageOptions, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        int i4;
        Alignment alignment2;
        ImageOptions imageOptions2;
        int i5;
        Modifier modifier2;
        String str3;
        int i6;
        Modifier modifier3;
        final Alignment alignment3;
        ImageOptions imageOptions3;
        final Modifier modifier4;
        int i7;
        Intrinsics.checkNotNullParameter(kImageSource, "imageSource");
        Composer startRestartGroup = composer.startRestartGroup(1153751279);
        ComposerKt.sourceInformation(startRestartGroup, "C(KImage)P(3,1)14@573L49,12@519L190:KImage.android.kt#ozspmd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(kImageSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            str2 = str;
            i3 |= startRestartGroup.changed(str2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                alignment2 = alignment;
                i3 |= startRestartGroup.changed(alignment2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        imageOptions2 = imageOptions;
                        if (startRestartGroup.changed(imageOptions2)) {
                            i7 = 2048;
                            i3 |= i7;
                        }
                    } else {
                        imageOptions2 = imageOptions;
                    }
                    i7 = 1024;
                    i3 |= i7;
                } else {
                    imageOptions2 = imageOptions;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    i3 |= startRestartGroup.changed(modifier2) ? 16384 : 8192;
                    if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            str3 = i8 == 0 ? null : str2;
                            if (i4 != 0) {
                                alignment2 = Alignment.Companion.getCenter();
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                imageOptions2 = ImageOptions.INSTANCE.newInstance();
                            }
                            if (i5 == 0) {
                                i6 = i3;
                                modifier3 = (Modifier) Modifier.Companion;
                                alignment3 = alignment2;
                                imageOptions3 = imageOptions2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1153751279, i6, -1, "com.bytedance.kmp.image.KImage (KImage.android.kt:11)");
                                }
                                int i9 = i6 >> 6;
                                ImageKt.Image(AndroidFrescoPainterKt.rememberPlatformPainter(kImageSource, imageOptions3, startRestartGroup, (i6 & 14) | (i9 & 112)), str3, modifier3, alignment3, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, (i9 & 896) | (i6 & 112) | ((i6 << 3) & 7168), 112);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                imageOptions2 = imageOptions3;
                                modifier4 = modifier3;
                            } else {
                                i6 = i3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            i6 = i3;
                            str3 = str2;
                        }
                        alignment3 = alignment2;
                        imageOptions3 = imageOptions2;
                        modifier3 = modifier2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i92 = i6 >> 6;
                        ImageKt.Image(AndroidFrescoPainterKt.rememberPlatformPainter(kImageSource, imageOptions3, startRestartGroup, (i6 & 14) | (i92 & 112)), str3, modifier3, alignment3, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, (i92 & 896) | (i6 & 112) | ((i6 << 3) & 7168), 112);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        imageOptions2 = imageOptions3;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        str3 = str2;
                        alignment3 = alignment2;
                        modifier4 = modifier2;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        final String str4 = str3;
                        final ImageOptions imageOptions4 = imageOptions2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bytedance.kmp.image.KImage_androidKt$KImage$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i10) {
                                KImage_androidKt.KImage(KImageSource.this, str4, alignment3, imageOptions4, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                modifier2 = modifier;
                if ((i3 & 9363) == 9362) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i5 == 0) {
                }
            }
            alignment2 = alignment;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            modifier2 = modifier;
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i5 == 0) {
            }
        }
        str2 = str;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        alignment2 = alignment;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i5 == 0) {
        }
    }
}
