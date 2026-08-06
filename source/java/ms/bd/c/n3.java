package ms.bd.c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.ss.ttm.player.MediaPlayer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: classes8.dex */
public final class n3 implements SensorEventListener {
    public static volatile n3 f;
    public final SensorManager a;
    public int b;
    public int c = 0;
    public float[] d = new float[3];
    public ArrayList e = new ArrayList();

    static {
        new DecimalFormat((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "0caff1", new byte[]{113, 47, 66}));
        f = null;
    }

    public n3(Context context) {
        this.a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.a = (SensorManager) applicationContext.getSystemService((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "5bbd9b", new byte[]{55, 101, 31, 3, 9, 103}));
        }
    }

    public static n3 a(Context context) {
        if (f == null) {
            synchronized (n3.class) {
                if (f == null) {
                    f = new n3(context);
                }
            }
        }
        return f;
    }

    public final synchronized void b() {
        try {
            SensorManager sensorManager = this.a;
            if (sensorManager != null) {
                if (this.b == 0) {
                    if (!this.a.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized void c() {
        try {
            SensorManager sensorManager = this.a;
            if (sensorManager != null) {
                int i = this.b - 1;
                this.b = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.d = sensorEvent.values;
        this.c = 1;
    }

    public final JSONArray a() {
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        if (n.a() != 1) {
            return null;
        }
        b();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.c == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.d[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.d[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.d[2]);
            } catch (Exception unused) {
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.d[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.d[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.d[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            c();
            this.c = 0;
            return jSONArray;
        } catch (Throwable th) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.d[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.d[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.d[2]).setScale(2, 4));
            c();
            this.c = 0;
            throw th;
        }
    }
}
