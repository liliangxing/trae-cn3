package com.bytedance.kmp.image.options;

import androidx.compose.ui.layout.ContentScale;
import com.bytedance.ies.xbridge.XBridge;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageScaleType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageScaleType;", "", "scaleType", "Landroidx/compose/ui/layout/ContentScale;", "(Landroidx/compose/ui/layout/ContentScale;)V", "toComposeScaleType", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageScaleType {
    public static final int $stable = 0;
    private final ContentScale scaleType;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImageScaleType CENTER_CROP = new ImageScaleType(ContentScale.INSTANCE.getCrop());
    private static final ImageScaleType FIT_CENTER = new ImageScaleType(ContentScale.INSTANCE.getFit());
    private static final ImageScaleType INSIDE = new ImageScaleType(ContentScale.INSTANCE.getInside());
    private static final ImageScaleType FILL = new ImageScaleType(ContentScale.INSTANCE.getFillBounds());
    private static final ImageScaleType DEFAULT = new ImageScaleType(ContentScale.INSTANCE.getNone());
    private static final ImageScaleType FILL_HEIGHT = new ImageScaleType(ContentScale.INSTANCE.getFillHeight());
    private static final ImageScaleType FILL_WIDTH = new ImageScaleType(ContentScale.INSTANCE.getFillWidth());

    private ImageScaleType(ContentScale contentScale) {
        this.scaleType = contentScale;
    }

    /* compiled from: ImageScaleType.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageScaleType$Companion;", "", "()V", "CENTER_CROP", "Lcom/bytedance/kmp/image/options/ImageScaleType;", "getCENTER_CROP", "()Lcom/bytedance/kmp/image/options/ImageScaleType;", XBridge.DEFAULT_NAMESPACE, "getDEFAULT", "FILL", "getFILL", "FILL_HEIGHT", "getFILL_HEIGHT$annotations", "getFILL_HEIGHT", "FILL_WIDTH", "getFILL_WIDTH$annotations", "getFILL_WIDTH", "FIT_CENTER", "getFIT_CENTER", "INSIDE", "getINSIDE", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Android系统上不生效 ，等同于ContentScale.None")
        public static /* synthetic */ void getFILL_HEIGHT$annotations() {
        }

        @Deprecated(message = "Android系统上不生效 ，等同于ContentScale.None")
        public static /* synthetic */ void getFILL_WIDTH$annotations() {
        }

        private Companion() {
        }

        public final ImageScaleType getCENTER_CROP() {
            return ImageScaleType.CENTER_CROP;
        }

        public final ImageScaleType getFIT_CENTER() {
            return ImageScaleType.FIT_CENTER;
        }

        public final ImageScaleType getINSIDE() {
            return ImageScaleType.INSIDE;
        }

        public final ImageScaleType getFILL() {
            return ImageScaleType.FILL;
        }

        public final ImageScaleType getDEFAULT() {
            return ImageScaleType.DEFAULT;
        }

        public final ImageScaleType getFILL_HEIGHT() {
            return ImageScaleType.FILL_HEIGHT;
        }

        public final ImageScaleType getFILL_WIDTH() {
            return ImageScaleType.FILL_WIDTH;
        }
    }

    /* renamed from: toComposeScaleType, reason: from getter */
    public final ContentScale getScaleType() {
        return this.scaleType;
    }
}
