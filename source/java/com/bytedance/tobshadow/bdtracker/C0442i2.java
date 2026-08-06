package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.tobshadow.applog.InitConfig;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.i2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0442i2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f661e;

    /* renamed from: f */
    public final C0467m f662f;

    public C0442i2(C0467m c0467m, Context context) {
        super(true, false);
        this.f662f = c0467m;
        this.f661e = context;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Display";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        int i;
        int i2;
        int i3;
        String str;
        InitConfig initConfig = this.f662f.getInitConfig();
        if (initConfig != null ? initConfig.isDisplayDensityAndDpiEnabled() : true) {
            int i4 = this.f661e.getResources().getDisplayMetrics().densityDpi;
            switch (i4) {
                case 120:
                    str = "ldpi";
                    break;
                case 240:
                    str = "hdpi";
                    break;
                case 260:
                case 280:
                case 300:
                case 320:
                    str = "xhdpi";
                    break;
                case 340:
                case 360:
                case FConstants.DECOMPRESS_FAIL_CODE /* 400 */:
                case 420:
                case 440:
                case 480:
                    str = "xxhdpi";
                    break;
                case 560:
                case 640:
                    str = "xxxhdpi";
                    break;
                default:
                    str = "mdpi";
                    break;
            }
            jSONObject.put("density_dpi", i4);
            jSONObject.put("display_density", str);
        }
        WindowManager windowManager = (WindowManager) this.f661e.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        if (defaultDisplay != null) {
            defaultDisplay.getRealMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            try {
                i3 = displayMetrics.heightPixels;
            } catch (Throwable th2) {
                th = th2;
                this.f662f.f764D.error("Get screen pixels failed", th, new Object[0]);
                i2 = i;
                i3 = 0;
                int[] iArr = {i2, i3};
                jSONObject.put("resolution", iArr[1] + "x" + iArr[0]);
                return true;
            }
        } else {
            Method method = Display.class.getMethod("getRawHeight", new Class[0]);
            Method method2 = Display.class.getMethod("getRawWidth", new Class[0]);
            i2 = method2 != null ? ((Integer) method2.invoke(defaultDisplay, new Object[0])).intValue() : 0;
            if (method != null) {
                try {
                    i3 = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                    i = i2;
                } catch (Throwable th3) {
                    th = th3;
                    i = i2;
                    this.f662f.f764D.error("Get screen pixels failed", th, new Object[0]);
                    i2 = i;
                    i3 = 0;
                    int[] iArr2 = {i2, i3};
                    jSONObject.put("resolution", iArr2[1] + "x" + iArr2[0]);
                    return true;
                }
            }
            i3 = 0;
            int[] iArr22 = {i2, i3};
            jSONObject.put("resolution", iArr22[1] + "x" + iArr22[0]);
            return true;
        }
        i2 = i;
        int[] iArr222 = {i2, i3};
        jSONObject.put("resolution", iArr222[1] + "x" + iArr222[0]);
        return true;
    }
}
