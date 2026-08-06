package com.github.alexzhirkevich.customqrgenerator;

import android.graphics.Bitmap;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: QrCodeGenerator.kt */
@Deprecated(message = "Use QrCodeDrawable instead")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J-\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrCodeGenerator;", "", "generateQrCode", "Landroid/graphics/Bitmap;", "data", "Lcom/github/alexzhirkevich/customqrgenerator/QrData;", "options", "Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;", "charset", "Ljava/nio/charset/Charset;", "generateQrCodeSuspend", "(Lcom/github/alexzhirkevich/customqrgenerator/QrData;Lcom/github/alexzhirkevich/customqrgenerator/QrOptions;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface QrCodeGenerator {
    Bitmap generateQrCode(QrData data, QrOptions options, Charset charset);

    Object generateQrCodeSuspend(QrData qrData, QrOptions qrOptions, Charset charset, Continuation<? super Bitmap> continuation);

    /* compiled from: QrCodeGenerator.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Bitmap generateQrCode$default(QrCodeGenerator qrCodeGenerator, QrData qrData, QrOptions qrOptions, Charset charset, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateQrCode");
            }
            if ((i & 4) != 0) {
                charset = null;
            }
            return qrCodeGenerator.generateQrCode(qrData, qrOptions, charset);
        }

        public static /* synthetic */ Object generateQrCodeSuspend$default(QrCodeGenerator qrCodeGenerator, QrData qrData, QrOptions qrOptions, Charset charset, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateQrCodeSuspend");
            }
            if ((i & 4) != 0) {
                charset = null;
            }
            return qrCodeGenerator.generateQrCodeSuspend(qrData, qrOptions, charset, continuation);
        }
    }
}
