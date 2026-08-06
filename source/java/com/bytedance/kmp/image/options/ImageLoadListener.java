package com.bytedance.kmp.image.options;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageLoadListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageLoadListener;", "", "onFail", "", "error", "", "onLoadStart", "onSuccess", "successResult", "Lcom/bytedance/kmp/image/options/ImageLoadListener$SuccessResult;", "Rect", "SuccessResult", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ImageLoadListener {

    /* compiled from: ImageLoadListener.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onFail(ImageLoadListener imageLoadListener, Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public static void onLoadStart(ImageLoadListener imageLoadListener) {
        }

        public static void onSuccess(ImageLoadListener imageLoadListener, SuccessResult successResult) {
            Intrinsics.checkNotNullParameter(successResult, "successResult");
        }
    }

    void onFail(Throwable error);

    void onLoadStart();

    void onSuccess(SuccessResult successResult);

    /* compiled from: ImageLoadListener.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageLoadListener$SuccessResult;", "", "imageWidth", "", "imageHeight", "cropRect", "Lcom/bytedance/kmp/image/options/ImageLoadListener$Rect;", "(IILcom/bytedance/kmp/image/options/ImageLoadListener$Rect;)V", "getCropRect", "()Lcom/bytedance/kmp/image/options/ImageLoadListener$Rect;", "getImageHeight", "()I", "getImageWidth", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class SuccessResult {
        public static final int $stable = 0;
        private final Rect cropRect;
        private final int imageHeight;
        private final int imageWidth;

        public SuccessResult(int i, int i2, Rect cropRect) {
            Intrinsics.checkNotNullParameter(cropRect, "cropRect");
            this.imageWidth = i;
            this.imageHeight = i2;
            this.cropRect = cropRect;
        }

        public final int getImageWidth() {
            return this.imageWidth;
        }

        public final int getImageHeight() {
            return this.imageHeight;
        }

        public /* synthetic */ SuccessResult(int i, int i2, Rect rect, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i3 & 4) != 0 ? new Rect(0, 0, 0, 0, 15, null) : rect);
        }

        public final Rect getCropRect() {
            return this.cropRect;
        }
    }

    /* compiled from: ImageLoadListener.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageLoadListener$Rect;", "", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "getLeft", "originalHeight", "getOriginalHeight", "setOriginalHeight", "(I)V", "originalWidth", "getOriginalWidth", "setOriginalWidth", "getRight", "getTop", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Rect {
        public static final int $stable = 0;
        private final int bottom;
        private final int left;
        private int originalHeight;
        private int originalWidth;
        private final int right;
        private final int top;

        public Rect() {
            this(0, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ Rect copy$default(Rect rect, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = rect.left;
            }
            if ((i5 & 2) != 0) {
                i2 = rect.top;
            }
            if ((i5 & 4) != 0) {
                i3 = rect.right;
            }
            if ((i5 & 8) != 0) {
                i4 = rect.bottom;
            }
            return rect.copy(i, i2, i3, i4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        public final Rect copy(int left, int top, int right, int bottom) {
            return new Rect(left, top, right, bottom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rect)) {
                return false;
            }
            Rect rect = (Rect) other;
            return this.left == rect.left && this.top == rect.top && this.right == rect.right && this.bottom == rect.bottom;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
        }

        public String toString() {
            return "Rect(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
        }

        public Rect(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }

        public /* synthetic */ Rect(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public final int getOriginalWidth() {
            return this.originalWidth;
        }

        public final void setOriginalWidth(int i) {
            this.originalWidth = i;
        }

        public final int getOriginalHeight() {
            return this.originalHeight;
        }

        public final void setOriginalHeight(int i) {
            this.originalHeight = i;
        }
    }
}
