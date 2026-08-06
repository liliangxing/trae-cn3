package io.noties.markwon.ext.onetex;

import android.graphics.Bitmap;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexBitmapPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexBitmapPool;", "", "()V", "MAX_POOL_SIZE", "", "pool", "", "Landroid/graphics/Bitmap;", MonitorConstants.CONNECT_TYPE_GET, "width", "height", "config", "Landroid/graphics/Bitmap$Config;", "getBytesPerPixel", "put", "", "bitmap", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexBitmapPool {
    private static final int MAX_POOL_SIZE = 10;
    public static final LatexBitmapPool INSTANCE = new LatexBitmapPool();
    private static final List<Bitmap> pool = new ArrayList();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
            iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 4;
        }
    }

    private LatexBitmapPool() {
    }

    public final Bitmap get(int width, int height, Bitmap.Config config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        int i = -1;
        Bitmap bitmap = null;
        int i2 = 0;
        for (Object obj : pool) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Bitmap bitmap2 = (Bitmap) obj;
            int bytesPerPixel = width * height * INSTANCE.getBytesPerPixel(config);
            if (bitmap2.isMutable() && bitmap2.getAllocationByteCount() >= bytesPerPixel) {
                if (bitmap != null) {
                    int allocationByteCount = bitmap2.getAllocationByteCount();
                    if (bitmap == null) {
                        Intrinsics.throwNpe();
                    }
                    if (allocationByteCount >= bitmap.getAllocationByteCount()) {
                    }
                }
                i = i2;
                bitmap = bitmap2;
            }
            i2 = i3;
        }
        if (bitmap != null) {
            try {
                Result.Companion companion = Result.Companion;
                LatexBitmapPool latexBitmapPool = this;
                Bitmap remove = pool.remove(i);
                remove.reconfigure(width, height, config);
                remove.eraseColor(0);
                return remove;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Object obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                Object obj3 = (Void) (Result.isFailure-impl(obj2) ? null : obj2);
                if (obj3 != null) {
                    return (Bitmap) obj3;
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
                Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
                return createBitmap;
            }
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height, config);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap2, "Bitmap.createBitmap(width, height, config)");
        return createBitmap2;
    }

    public final void put(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        List<Bitmap> list = pool;
        if (list.size() < 10 && !bitmap.isRecycled() && bitmap.isMutable()) {
            list.add(bitmap);
        } else {
            if (bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    private final int getBytesPerPixel(Bitmap.Config config) {
        int i;
        if (config == null || (i = WhenMappings.$EnumSwitchMapping$0[config.ordinal()]) == 1) {
            return 4;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 1;
    }
}
