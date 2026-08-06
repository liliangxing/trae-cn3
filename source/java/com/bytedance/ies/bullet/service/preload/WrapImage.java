package com.bytedance.ies.bullet.service.preload;

import android.graphics.Bitmap;
import com.bytedance.apm.constant.PerfConsts;
import com.facebook.common.references.CloseableReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PreloadMemoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WrapImage;", "Lcom/bytedance/ies/bullet/service/preload/Expired;", "image", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "size", "", "expiredTime", "(Lcom/facebook/common/references/CloseableReference;JLjava/lang/Long;)V", "getExpiredTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getImage", "()Lcom/facebook/common/references/CloseableReference;", "setImage", "(Lcom/facebook/common/references/CloseableReference;)V", "getSize", "()J", "isExpired", "", PerfConsts.KEY_CURRENT_GALVANIC, "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WrapImage implements Expired {
    private final Long expiredTime;
    private CloseableReference<Bitmap> image;
    private final long size;

    public WrapImage(CloseableReference<Bitmap> closeableReference, long j, Long l) {
        this.image = closeableReference;
        this.size = j;
        this.expiredTime = l;
    }

    public /* synthetic */ WrapImage(CloseableReference closeableReference, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(closeableReference, j, (i & 4) != 0 ? null : l);
    }

    public final Long getExpiredTime() {
        return this.expiredTime;
    }

    public final CloseableReference<Bitmap> getImage() {
        return this.image;
    }

    public final long getSize() {
        return this.size;
    }

    public final void setImage(CloseableReference<Bitmap> closeableReference) {
        this.image = closeableReference;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.ReleaseComputable
    public long size() {
        return this.size;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.ReleaseComputable
    public void release() {
        CloseableReference<Bitmap> closeableReference = this.image;
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    @Override // com.bytedance.ies.bullet.service.preload.Expired
    public boolean isExpired(long current) {
        Long l = this.expiredTime;
        return current > (l != null ? l.longValue() : current);
    }
}
