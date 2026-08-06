package ms.bd.c;

import android.content.Context;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public final class k4 {
    public final Class a;
    public final Object b;
    public final Method c;

    public k4(Context context) {
        int i;
        try {
            i = 1;
            try {
                Class<?> cls = Class.forName((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "e710f7", new byte[]{119, 58, 79, 10, 88, 46, 98, 4, 111, 105, 112, 123, 75, 64, 23, 41, 107, 6, 108, 46, 93, 49, 114, 86, 86, 54, 111, 18, 101, 114, 93, 56, 82, 72}));
                this.a = cls;
                this.b = cls.newInstance();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 1;
        }
        try {
            Class cls2 = this.a;
            byte[] bArr = new byte[7];
            bArr[0] = 38;
            bArr[i] = 48;
            bArr[2] = 80;
            bArr[3] = 98;
            bArr[4] = 47;
            bArr[5] = 8;
            bArr[6] = 23;
            String str = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "077916", bArr);
            Class<?>[] clsArr = new Class[i];
            clsArr[0] = Context.class;
            this.c = cls2.getMethod(str, clsArr);
        } catch (Exception unused3) {
        }
    }
}
