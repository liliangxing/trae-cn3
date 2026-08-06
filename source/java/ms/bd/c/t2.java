package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public final class t2 {
    public static final t2 b = new t2();
    public final ArrayList a = new ArrayList();

    public final String a(int i, String str, String str2) {
        synchronized (this.a) {
            if (this.a.size() >= 1 && !TextUtils.isEmpty(str)) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    Map map = (Map) it.next();
                    if (map != null && !map.isEmpty() && map.containsKey(str)) {
                        ((MSManagerUtils.IMsBundleCallback) map.get(str)).callBack(i, str, str2);
                        it.remove();
                    }
                }
                return (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "4e8a69", new byte[]{117});
            }
            return (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "3124f0", new byte[]{114});
        }
    }
}
