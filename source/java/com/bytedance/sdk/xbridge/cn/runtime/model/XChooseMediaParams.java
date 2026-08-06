package com.bytedance.sdk.xbridge.cn.runtime.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XChooseMediaParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\u0018\u00002\u00020\u0001B\u007f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001e\"\u0004\b1\u0010 R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u001a\u00103\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b6\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/model/XChooseMediaParams;", "", "mediaTypes", "", "", "sourceType", "maxCount", "", "compressImage", "", "saveToPhotoAlbum", "cameraType", "needBinaryData", "compressWidth", "compressHeight", "imageParams", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/ImageParams;", "videoParams", "Lcom/bytedance/sdk/xbridge/cn/runtime/model/VideoParams;", "(Ljava/util/List;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZIILcom/bytedance/sdk/xbridge/cn/runtime/model/ImageParams;Lcom/bytedance/sdk/xbridge/cn/runtime/model/VideoParams;)V", "getCameraType", "()Ljava/lang/String;", "getCompressHeight", "()I", "getCompressImage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCompressWidth", "copyToPrivateDirection", "getCopyToPrivateDirection", "()Z", "setCopyToPrivateDirection", "(Z)V", "cropRatioHeight", "getCropRatioHeight", "setCropRatioHeight", "(I)V", "cropRatioWidth", "getCropRatioWidth", "setCropRatioWidth", "getImageParams", "()Lcom/bytedance/sdk/xbridge/cn/runtime/model/ImageParams;", "isNeedCut", "setNeedCut", "getMaxCount", "getMediaTypes", "()Ljava/util/List;", "needBase64Data", "getNeedBase64Data", "setNeedBase64Data", "getNeedBinaryData", "needUploadFile", "getNeedUploadFile", "setNeedUploadFile", "getSaveToPhotoAlbum", "getSourceType", "getVideoParams", "()Lcom/bytedance/sdk/xbridge/cn/runtime/model/VideoParams;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class XChooseMediaParams {
    private final String cameraType;
    private final int compressHeight;
    private final Boolean compressImage;
    private final int compressWidth;
    private boolean copyToPrivateDirection;
    private int cropRatioHeight;
    private int cropRatioWidth;
    private final ImageParams imageParams;
    private boolean isNeedCut;
    private final int maxCount;
    private final List<String> mediaTypes;
    private boolean needBase64Data;
    private final boolean needBinaryData;
    private boolean needUploadFile;
    private final Boolean saveToPhotoAlbum;
    private final String sourceType;
    private final VideoParams videoParams;

    public XChooseMediaParams(List<String> list, String sourceType, int i, Boolean bool, Boolean bool2, String cameraType, boolean z, int i2, int i3, ImageParams imageParams, VideoParams videoParams) {
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intrinsics.checkNotNullParameter(cameraType, "cameraType");
        this.mediaTypes = list;
        this.sourceType = sourceType;
        this.maxCount = i;
        this.compressImage = bool;
        this.saveToPhotoAlbum = bool2;
        this.cameraType = cameraType;
        this.needBinaryData = z;
        this.compressWidth = i2;
        this.compressHeight = i3;
        this.imageParams = imageParams;
        this.videoParams = videoParams;
    }

    public final List<String> getMediaTypes() {
        return this.mediaTypes;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public /* synthetic */ XChooseMediaParams(List list, String str, int i, Boolean bool, Boolean bool2, String str2, boolean z, int i2, int i3, ImageParams imageParams, VideoParams videoParams, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i4 & 4) != 0 ? 1 : i, (i4 & 8) != 0 ? false : bool, (i4 & 16) != 0 ? false : bool2, (i4 & 32) != 0 ? "front" : str2, (i4 & 64) != 0 ? false : z, (i4 & 128) != 0 ? 0 : i2, (i4 & 256) != 0 ? 0 : i3, (i4 & 512) != 0 ? null : imageParams, (i4 & 1024) != 0 ? null : videoParams);
    }

    public final Boolean getCompressImage() {
        return this.compressImage;
    }

    public final Boolean getSaveToPhotoAlbum() {
        return this.saveToPhotoAlbum;
    }

    public final String getCameraType() {
        return this.cameraType;
    }

    public final boolean getNeedBinaryData() {
        return this.needBinaryData;
    }

    public final int getCompressWidth() {
        return this.compressWidth;
    }

    public final int getCompressHeight() {
        return this.compressHeight;
    }

    public final ImageParams getImageParams() {
        return this.imageParams;
    }

    public final VideoParams getVideoParams() {
        return this.videoParams;
    }

    /* renamed from: isNeedCut, reason: from getter */
    public final boolean getIsNeedCut() {
        return this.isNeedCut;
    }

    public final void setNeedCut(boolean z) {
        this.isNeedCut = z;
    }

    public final int getCropRatioWidth() {
        return this.cropRatioWidth;
    }

    public final void setCropRatioWidth(int i) {
        this.cropRatioWidth = i;
    }

    public final int getCropRatioHeight() {
        return this.cropRatioHeight;
    }

    public final void setCropRatioHeight(int i) {
        this.cropRatioHeight = i;
    }

    public final boolean getNeedBase64Data() {
        return this.needBase64Data;
    }

    public final void setNeedBase64Data(boolean z) {
        this.needBase64Data = z;
    }

    public final boolean getNeedUploadFile() {
        return this.needUploadFile;
    }

    public final void setNeedUploadFile(boolean z) {
        this.needUploadFile = z;
    }

    public final boolean getCopyToPrivateDirection() {
        return this.copyToPrivateDirection;
    }

    public final void setCopyToPrivateDirection(boolean z) {
        this.copyToPrivateDirection = z;
    }
}
