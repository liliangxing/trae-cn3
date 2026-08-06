package ms.bd.p001c;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import okio.Utf8;

/* renamed from: ms.bd.c.x3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0231x3 {

    /* renamed from: a */
    public static String f464a;

    /* renamed from: b */
    public static final String f465b = (String) AbstractC0190p2.m166a(16777217, 0, 0, "c4c507", new byte[]{51, 51, 29, 81, 27, 57, 33});

    /* renamed from: a */
    public static String m209a() {
        String str = f464a;
        if (str != null) {
            return str;
        }
        SensorManager sensorManager = (SensorManager) C0122d2.f158b.f159a.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d60c34", new byte[]{102, 49, 77, 4, 3, 49}));
        if (sensorManager != null) {
            StringBuilder sb = new StringBuilder();
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor != null) {
                sb.append(1).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5ead01", new byte[]{27})).append(defaultSensor.getName()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2378ec", new byte[]{28})).append(defaultSensor.getVendor()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5b0fba", new byte[]{56}));
            }
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(5);
            if (defaultSensor2 != null) {
                sb.append(5).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b283c1", new byte[]{76})).append(defaultSensor2.getName()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3f3efe", new byte[]{29})).append(defaultSensor2.getVendor()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2cf2a4", new byte[]{Utf8.REPLACEMENT_BYTE}));
            }
            Sensor defaultSensor3 = sensorManager.getDefaultSensor(9);
            if (defaultSensor3 != null) {
                sb.append(9).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "0567bc", new byte[]{30})).append(defaultSensor3.getName()).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b38f69", new byte[]{76})).append(defaultSensor3.getVendor());
            }
            f464a = sb.toString();
        }
        if (f464a == null) {
            f464a = f465b;
        }
        return f464a;
    }
}
