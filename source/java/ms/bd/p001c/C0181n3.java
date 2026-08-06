package ms.bd.p001c;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;

/* renamed from: ms.bd.c.n3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0181n3 implements SensorEventListener {

    /* renamed from: f */
    public static volatile C0181n3 f270f;

    /* renamed from: a */
    public final SensorManager f271a;

    /* renamed from: b */
    public int f272b;

    /* renamed from: c */
    public int f273c = 0;

    /* renamed from: d */
    public float[] f274d = new float[3];

    /* renamed from: e */
    public ArrayList f275e = new ArrayList();

    static {
        new DecimalFormat((String) AbstractC0190p2.m166a(16777217, 0, 0L, "0caff1", new byte[]{113, 47, 66}));
        f270f = null;
    }

    public C0181n3(Context context) {
        this.f271a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f271a = (SensorManager) applicationContext.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5bbd9b", new byte[]{55, 101, 31, 3, 9, 103}));
        }
    }

    /* renamed from: a */
    public static C0181n3 m158a(Context context) {
        if (f270f == null) {
            synchronized (C0181n3.class) {
                if (f270f == null) {
                    f270f = new C0181n3(context);
                }
            }
        }
        return f270f;
    }

    /* renamed from: b */
    public final synchronized void m160b() {
        try {
            SensorManager sensorManager = this.f271a;
            if (sensorManager != null) {
                if (this.f272b == 0) {
                    if (!this.f271a.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f272b++;
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public final synchronized void m161c() {
        try {
            SensorManager sensorManager = this.f271a;
            if (sensorManager != null) {
                int i = this.f272b - 1;
                this.f272b = i;
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
        this.f274d = sensorEvent.values;
        this.f273c = 1;
    }

    /* renamed from: a */
    public final JSONArray m159a() {
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        if (AbstractC0177n.m148a() != 1) {
            return null;
        }
        m160b();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.f273c == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.f274d[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.f274d[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.f274d[2]);
            } catch (Exception unused) {
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.f274d[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.f274d[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.f274d[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            m161c();
            this.f273c = 0;
            return jSONArray;
        } catch (Throwable th) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.f274d[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.f274d[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.f274d[2]).setScale(2, 4));
            m161c();
            this.f273c = 0;
            throw th;
        }
    }
}
