package com.google.android.gms.internal.fido;

import java.io.IOException;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* loaded from: classes6.dex */
final class zzbd extends zzbe {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzbd(String str, String str2, @CheckForNull Character ch) {
        super(r0, ch);
        char[] cArr;
        zzbb zzbbVar = new zzbb(str, str2.toCharArray());
        cArr = zzbbVar.zzf;
        zzam.zzc(cArr.length == 64);
    }

    @Override // com.google.android.gms.internal.fido.zzbe, com.google.android.gms.internal.fido.zzbf
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzam.zze(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = i3 + 1;
            int i6 = bArr[i3] & UByte.MAX_VALUE;
            int i7 = bArr[i5] & UByte.MAX_VALUE;
            int i8 = i5 + 1;
            int i9 = (i6 << 16) | (i7 << 8) | (bArr[i8] & UByte.MAX_VALUE);
            appendable.append(this.zzb.zza(i9 >>> 18));
            appendable.append(this.zzb.zza((i9 >>> 12) & 63));
            appendable.append(this.zzb.zza((i9 >>> 6) & 63));
            appendable.append(this.zzb.zza(i9 & 63));
            i3 = i8 + 1;
        }
        if (i3 < i2) {
            zzc(appendable, bArr, i3, i2 - i3);
        }
    }
}
