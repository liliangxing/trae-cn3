package ms.bd.c;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.ss.ttm.player.MediaPlayer;
import okio.Utf8;

/* loaded from: classes8.dex */
public abstract class x3 {
    public static String a;
    public static final String b = (String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "c4c507", new byte[]{51, 51, 29, 81, 27, 57, 33});

    public static String a() {
        String str = a;
        if (str != null) {
            return str;
        }
        SensorManager sensorManager = (SensorManager) d2.b.a.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "d60c34", new byte[]{102, 49, 77, 4, 3, 49}));
        if (sensorManager != null) {
            StringBuilder sb = new StringBuilder();
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor != null) {
                sb.append(1).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5ead01", new byte[]{27})).append(defaultSensor.getName()).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "2378ec", new byte[]{28})).append(defaultSensor.getVendor()).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5b0fba", new byte[]{56}));
            }
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(5);
            if (defaultSensor2 != null) {
                sb.append(5).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b283c1", new byte[]{76})).append(defaultSensor2.getName()).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "3f3efe", new byte[]{29})).append(defaultSensor2.getVendor()).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "2cf2a4", new byte[]{Utf8.REPLACEMENT_BYTE}));
            }
            Sensor defaultSensor3 = sensorManager.getDefaultSensor(9);
            if (defaultSensor3 != null) {
                sb.append(9).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "0567bc", new byte[]{30})).append(defaultSensor3.getName()).append((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "b38f69", new byte[]{76})).append(defaultSensor3.getVendor());
            }
            a = sb.toString();
        }
        if (a == null) {
            a = b;
        }
        return a;
    }
}
