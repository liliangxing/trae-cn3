package com.bytedance.pitaya.api.bean;

import android.graphics.Bitmap;
import com.bytedance.pitaya.media.GraphicByte;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PTYCvMat.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYCvMat;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", "bitmap", "Landroid/graphics/Bitmap;", "graphicByte", "Lcom/bytedance/pitaya/media/GraphicByte;", "(Landroid/graphics/Bitmap;Lcom/bytedance/pitaya/media/GraphicByte;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getGraphicByte", "()Lcom/bytedance/pitaya/media/GraphicByte;", "setGraphicByte", "(Lcom/bytedance/pitaya/media/GraphicByte;)V", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class PTYCvMat extends PTYClass {
    private Bitmap bitmap;
    private GraphicByte graphicByte;

    /* JADX WARN: Multi-variable type inference failed */
    public PTYCvMat() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ PTYCvMat(Bitmap bitmap, GraphicByte graphicByte, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bitmap, (i & 2) != 0 ? null : graphicByte);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public final GraphicByte getGraphicByte() {
        return this.graphicByte;
    }

    public final void setGraphicByte(GraphicByte graphicByte) {
        this.graphicByte = graphicByte;
    }

    public PTYCvMat(Bitmap bitmap, GraphicByte graphicByte) {
        super(2);
        this.bitmap = bitmap;
        this.graphicByte = graphicByte;
    }
}
