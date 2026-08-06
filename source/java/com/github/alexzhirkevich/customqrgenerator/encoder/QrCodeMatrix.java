package com.github.alexzhirkevich.customqrgenerator.encoder;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrCodeMatrix.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0000J\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0086\u0002J!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\tH\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix;", "", "size", "", "(I)V", "getSize", "()I", "types", "", "Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix$PixelType;", "copy", "get", RXScreenCaptureService.KEY_INDEX, "j", "set", "", "type", "PixelType", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QrCodeMatrix {
    private final int size;
    private List<PixelType> types;

    /* compiled from: QrCodeMatrix.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/encoder/QrCodeMatrix$PixelType;", "", "(Ljava/lang/String;I)V", "DarkPixel", "LightPixel", "Background", "Logo", "VersionEye", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public enum PixelType {
        DarkPixel,
        LightPixel,
        Background,
        Logo,
        VersionEye
    }

    public QrCodeMatrix(int i) {
        this.size = i;
        int i2 = i * i;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(PixelType.Background);
        }
        this.types = arrayList;
    }

    public final int getSize() {
        return this.size;
    }

    public final PixelType get(int i, int j) {
        Integer valueOf;
        boolean z = false;
        if (i >= 0 && i < this.size) {
            if (j >= 0 && j < this.size) {
                z = true;
            }
            valueOf = !z ? Integer.valueOf(j) : null;
        } else {
            valueOf = Integer.valueOf(i);
        }
        if (valueOf != null) {
            throw new IndexOutOfBoundsException("Index " + valueOf + " is out of 0.." + (this.size - 1) + " matrix bound");
        }
        return this.types.get(i + (j * this.size));
    }

    public final void set(int i, int j, PixelType type) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter(type, "type");
        boolean z = false;
        if (i >= 0 && i < this.size) {
            if (j >= 0 && j < this.size) {
                z = true;
            }
            valueOf = !z ? Integer.valueOf(j) : null;
        } else {
            valueOf = Integer.valueOf(i);
        }
        if (valueOf != null) {
            throw new IndexOutOfBoundsException("Index " + valueOf + " is out of 0.." + (this.size - 1) + " matrix bound");
        }
        this.types.set(i + (j * this.size), type);
    }

    public final QrCodeMatrix copy() {
        QrCodeMatrix qrCodeMatrix = new QrCodeMatrix(this.size);
        qrCodeMatrix.types = CollectionsKt.toMutableList((Collection) this.types);
        return qrCodeMatrix;
    }
}
