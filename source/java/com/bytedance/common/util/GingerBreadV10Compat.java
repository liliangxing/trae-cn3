package com.bytedance.common.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;

/* loaded from: classes3.dex */
public class GingerBreadV10Compat {
    static final BaseImpl IMPL = new V10Impl();

    /* loaded from: classes3.dex */
    static class BaseImpl {
        BaseImpl() {
        }

        public Bitmap createVideoThumbnail(String str, int i, int i2) {
            return ThumbnailUtils.createVideoThumbnail(str, i);
        }

        public Bitmap createVideoThumbnail(String str, int i, int i2, int i3) {
            return ThumbnailUtils.createVideoThumbnail(str, i);
        }
    }

    /* loaded from: classes3.dex */
    static class V10Impl extends BaseImpl {
        V10Impl() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[RETURN] */
        @Override // com.bytedance.common.util.GingerBreadV10Compat.BaseImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Bitmap createVideoThumbnail(String str, int i, int i2) {
            Bitmap bitmap;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException unused) {
                    }
                } catch (RuntimeException unused2) {
                    bitmap = null;
                    if (bitmap == null) {
                    }
                }
            } catch (IllegalArgumentException | RuntimeException unused3) {
                mediaMetadataRetriever.release();
                bitmap = null;
                if (bitmap == null) {
                }
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused4) {
                }
                throw th;
            }
            if (bitmap == null) {
                return null;
            }
            return bitmap;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
        @Override // com.bytedance.common.util.GingerBreadV10Compat.BaseImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Bitmap createVideoThumbnail(String str, int i, int i2, int i3) {
            Bitmap bitmap;
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException unused) {
                    }
                } catch (RuntimeException unused2) {
                    bitmap = null;
                    if (bitmap == null) {
                    }
                }
            } catch (IllegalArgumentException | RuntimeException unused3) {
                mediaMetadataRetriever.release();
                bitmap = null;
                if (bitmap == null) {
                }
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException unused4) {
                }
                throw th;
            }
            if (bitmap == null) {
                return null;
            }
            return Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        }
    }

    public static Bitmap createVideoThumbnail(String str, int i, int i2) {
        return IMPL.createVideoThumbnail(str, i, i2);
    }

    public static Bitmap createVideoThumbnail(String str, int i, int i2, int i3) {
        return IMPL.createVideoThumbnail(str, i, i2, i3);
    }
}
