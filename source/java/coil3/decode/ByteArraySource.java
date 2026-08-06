package coil3.decode;

import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import kotlin.Metadata;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* compiled from: ImageSource.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcoil3/decode/ByteArraySource;", "Lokio/Source;", Constants.KEY_DATA, "", "<init>", "([B)V", "pos", "", SettingV2Monitor.REPORT_TYPE_READ, "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "close", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ByteArraySource implements Source {
    private final byte[] data;
    private int pos;

    public void close() {
    }

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    public long read(Buffer sink, long byteCount) {
        int i = this.pos;
        byte[] bArr = this.data;
        if (i >= bArr.length) {
            return -1L;
        }
        if (byteCount == 0) {
            return 0L;
        }
        int min = Math.min((int) byteCount, bArr.length - i);
        sink.write(this.data, this.pos, min);
        this.pos += min;
        return min;
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }
}
