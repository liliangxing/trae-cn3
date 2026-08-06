package com.larus.business.markdown.api.extplugin.image;

import android.view.View;
import android.widget.TextView;
import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomImgLoader.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\n0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u001b\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\n0\tHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\tHÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003Jq\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\n0\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000bHÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/image/ImageLoaderInfo;", "", "imageView", "Landroid/view/View;", "textView", "Landroid/widget/TextView;", "span", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;", "imageViewList", "", "Lkotlin/Pair;", "", "imageInfoList", "Lcom/larus/business/markdown/api/extplugin/image/ImageInfo;", "imageIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "targetWidth", "targetHeight", "(Landroid/view/View;Landroid/widget/TextView;Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;Ljava/util/List;Ljava/util/List;Ljava/util/concurrent/atomic/AtomicInteger;II)V", "getImageIndex", "()Ljava/util/concurrent/atomic/AtomicInteger;", "getImageInfoList", "()Ljava/util/List;", "getImageView", "()Landroid/view/View;", "getImageViewList", "getSpan", "()Lcom/larus/business/markdown/api/extplugin/image/ICustomImgSpan;", "getTargetHeight", "()I", "getTargetWidth", "getTextView", "()Landroid/widget/TextView;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ImageLoaderInfo {
    private final AtomicInteger imageIndex;
    private final List<ImageInfo> imageInfoList;
    private final View imageView;
    private final List<Pair<Integer, View>> imageViewList;
    private final ICustomImgSpan span;
    private final int targetHeight;
    private final int targetWidth;
    private final TextView textView;

    /* renamed from: component1, reason: from getter */
    public final View getImageView() {
        return this.imageView;
    }

    /* renamed from: component2, reason: from getter */
    public final TextView getTextView() {
        return this.textView;
    }

    /* renamed from: component3, reason: from getter */
    public final ICustomImgSpan getSpan() {
        return this.span;
    }

    public final List<Pair<Integer, View>> component4() {
        return this.imageViewList;
    }

    public final List<ImageInfo> component5() {
        return this.imageInfoList;
    }

    /* renamed from: component6, reason: from getter */
    public final AtomicInteger getImageIndex() {
        return this.imageIndex;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTargetWidth() {
        return this.targetWidth;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public final ImageLoaderInfo copy(View imageView, TextView textView, ICustomImgSpan span, List<? extends Pair<Integer, ? extends View>> imageViewList, List<ImageInfo> imageInfoList, AtomicInteger imageIndex, int targetWidth, int targetHeight) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(imageViewList, "imageViewList");
        Intrinsics.checkNotNullParameter(imageInfoList, "imageInfoList");
        Intrinsics.checkNotNullParameter(imageIndex, "imageIndex");
        return new ImageLoaderInfo(imageView, textView, span, imageViewList, imageInfoList, imageIndex, targetWidth, targetHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageLoaderInfo)) {
            return false;
        }
        ImageLoaderInfo imageLoaderInfo = (ImageLoaderInfo) other;
        return Intrinsics.areEqual(this.imageView, imageLoaderInfo.imageView) && Intrinsics.areEqual(this.textView, imageLoaderInfo.textView) && Intrinsics.areEqual(this.span, imageLoaderInfo.span) && Intrinsics.areEqual(this.imageViewList, imageLoaderInfo.imageViewList) && Intrinsics.areEqual(this.imageInfoList, imageLoaderInfo.imageInfoList) && Intrinsics.areEqual(this.imageIndex, imageLoaderInfo.imageIndex) && this.targetWidth == imageLoaderInfo.targetWidth && this.targetHeight == imageLoaderInfo.targetHeight;
    }

    public int hashCode() {
        return (((((((((((((this.imageView.hashCode() * 31) + this.textView.hashCode()) * 31) + this.span.hashCode()) * 31) + this.imageViewList.hashCode()) * 31) + this.imageInfoList.hashCode()) * 31) + this.imageIndex.hashCode()) * 31) + Integer.hashCode(this.targetWidth)) * 31) + Integer.hashCode(this.targetHeight);
    }

    public String toString() {
        return "ImageLoaderInfo(imageView=" + this.imageView + ", textView=" + this.textView + ", span=" + this.span + ", imageViewList=" + this.imageViewList + ", imageInfoList=" + this.imageInfoList + ", imageIndex=" + this.imageIndex + ", targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageLoaderInfo(View imageView, TextView textView, ICustomImgSpan span, List<? extends Pair<Integer, ? extends View>> imageViewList, List<ImageInfo> imageInfoList, AtomicInteger imageIndex, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(imageViewList, "imageViewList");
        Intrinsics.checkNotNullParameter(imageInfoList, "imageInfoList");
        Intrinsics.checkNotNullParameter(imageIndex, "imageIndex");
        this.imageView = imageView;
        this.textView = textView;
        this.span = span;
        this.imageViewList = imageViewList;
        this.imageInfoList = imageInfoList;
        this.imageIndex = imageIndex;
        this.targetWidth = i;
        this.targetHeight = i2;
    }

    public final View getImageView() {
        return this.imageView;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final ICustomImgSpan getSpan() {
        return this.span;
    }

    public final List<Pair<Integer, View>> getImageViewList() {
        return this.imageViewList;
    }

    public final List<ImageInfo> getImageInfoList() {
        return this.imageInfoList;
    }

    public final AtomicInteger getImageIndex() {
        return this.imageIndex;
    }

    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public final int getTargetHeight() {
        return this.targetHeight;
    }
}
