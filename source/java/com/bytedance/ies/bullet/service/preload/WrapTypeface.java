package com.bytedance.ies.bullet.service.preload;

import android.graphics.Typeface;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PreloadMemoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/WrapTypeface;", "Lcom/bytedance/ies/bullet/service/preload/Expired;", "typeface", "Landroid/graphics/Typeface;", "size", "", "expiredTime", "(Landroid/graphics/Typeface;JLjava/lang/Long;)V", "getExpiredTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSize", "()J", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "isExpired", "", PerfConsts.KEY_CURRENT_GALVANIC, "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WrapTypeface implements Expired {
    private final Long expiredTime;
    private final long size;
    private Typeface typeface;

    public WrapTypeface(Typeface typeface, long j, Long l) {
        this.typeface = typeface;
        this.size = j;
        this.expiredTime = l;
    }

    public /* synthetic */ WrapTypeface(Typeface typeface, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeface, j, (i & 4) != 0 ? null : l);
    }

    public final Long getExpiredTime() {
        return this.expiredTime;
    }

    public final long getSize() {
        return this.size;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.ReleaseComputable
    public long size() {
        return this.size;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.ReleaseComputable
    public void release() {
        this.typeface = null;
    }

    @Override // com.bytedance.ies.bullet.service.preload.Expired
    public boolean isExpired(long current) {
        Long l = this.expiredTime;
        return current > (l != null ? l.longValue() : current);
    }
}
