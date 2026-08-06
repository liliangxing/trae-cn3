package ms.bd.c;

import android.content.Context;
import android.location.LocationManager;
import com.ss.ttm.player.MediaPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* loaded from: classes8.dex */
public abstract class w1 {
    public static x1 a(Context context, String str) {
        Field field;
        Object obj;
        Class<?>[] interfaces;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5184cb", new byte[]{40, 60, 72, 65, 72, 124, 57, 30}));
            if (locationManager == null) {
                return new x1(-10, "", "", null);
            }
            Field[] declaredFields = locationManager.getClass().getDeclaredFields();
            if (declaredFields == null) {
                return new x1(-20, "", "", null);
            }
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    obj = null;
                    break;
                }
                field = declaredFields[i];
                field.setAccessible(true);
                try {
                    obj = field.get(locationManager);
                    if (obj != null && !(obj instanceof String) && (interfaces = obj.getClass().getInterfaces()) != null && interfaces.length != 0 && str.equals(interfaces[0].getName())) {
                        break;
                    }
                    i++;
                } catch (IllegalAccessException unused) {
                    return new x1(-21, "", "", null);
                }
            }
            if (obj == null) {
                return new x1(-22, "", "", null);
            }
            return new x1(obj instanceof Proxy ? 1 : 0, field.getName(), obj.getClass().getName(), null);
        } catch (Throwable unused2) {
            return new x1(-11, "", "", null);
        }
    }
}
