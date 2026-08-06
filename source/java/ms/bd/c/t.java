package ms.bd.c;

import android.os.Build;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;

/* loaded from: classes8.dex */
public abstract class t {
    public static HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b294e9", new byte[]{34}), Build.MODEL);
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f282d0", new byte[]{37}), Build.BRAND);
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "06438f", new byte[]{114}), Build.BOARD);
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "fa4473", new byte[]{35}), Build.VERSION.RELEASE);
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "8afa6b", new byte[]{124}), Build.DISPLAY);
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "73c2bc", new byte[]{112}), Build.HARDWARE);
        hashMap.put((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "69e59a", new byte[]{112}), Build.FINGERPRINT);
        return hashMap;
    }
}
