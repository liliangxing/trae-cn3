package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.bdinstall.DrLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DisplayLoader extends BaseLoader {
    private final Context mApp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisplayLoader(Context context) {
        super(true, false);
        this.mApp = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject jSONObject) throws JSONException {
        DisplayMetrics displayMetrics = this.mApp.getResources().getDisplayMetrics();
        addOldDisplayInfo(jSONObject, displayMetrics);
        addNewDisplayInfo(jSONObject, displayMetrics);
        return true;
    }

    private void addNewDisplayInfo(JSONObject jSONObject, DisplayMetrics displayMetrics) throws JSONException {
        int i = displayMetrics.densityDpi;
        jSONObject.put("display_density_v2", i <= 120 ? "ldpi" : i <= 160 ? "mdpi" : i <= 240 ? "hdpi" : i <= 320 ? "xhdpi" : i <= 480 ? "xxhdpi" : i <= 640 ? "xxxhdpi" : "xxxxhdpi");
        int[] screenPixels = getScreenPixels();
        jSONObject.put("resolution_v2", screenPixels[1] + "x" + screenPixels[0]);
        if (DrLog.debug()) {
            DrLog.d("resolution " + screenPixels[1] + "x" + screenPixels[0]);
        }
    }

    private void addOldDisplayInfo(JSONObject jSONObject, DisplayMetrics displayMetrics) {
        try {
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[] getScreenPixels() {
        int i;
        int i2;
        try {
            WindowManager windowManager = (WindowManager) this.mApp.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            try {
                i2 = displayMetrics.heightPixels;
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                i2 = 0;
                return new int[]{i, i2};
            }
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        return new int[]{i, i2};
    }
}
