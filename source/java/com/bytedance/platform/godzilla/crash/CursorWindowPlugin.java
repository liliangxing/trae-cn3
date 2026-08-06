package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.database.CursorWindow;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class CursorWindowPlugin extends BasePlugin {
    private static final int DEFAULT_SIZE = 1048576;
    private static Field sCursorWindowSizeField = null;
    private static int sOriginSize = -1;
    private int mSize;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CursorWindowPlugin";
    }

    public CursorWindowPlugin() {
        this.mSize = 0;
    }

    public CursorWindowPlugin(int i) {
        this.mSize = i;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application application) {
        super.init(application);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        int i = this.mSize;
        if (i > 0) {
            resetCursorWindowSize(i);
        } else {
            resetCursorWindowSize(1048576);
        }
    }

    private boolean resetCursorWindowSize(int i) {
        Field field = FieldUtils.getField(CursorWindow.class, "sCursorWindowSize");
        sCursorWindowSizeField = field;
        if (field == null) {
            return false;
        }
        if (i <= 0) {
            i = 1048576;
        }
        field.setAccessible(true);
        try {
            int intValue = ((Integer) FieldUtils.readStaticField(sCursorWindowSizeField)).intValue();
            sOriginSize = intValue;
            if (intValue != i) {
                FieldUtils.writeStaticField(sCursorWindowSizeField, Integer.valueOf(i));
            }
            Logger.e(getName(), "Resize cursor window size successful! Resize form :" + sOriginSize + "to " + ((Integer) FieldUtils.readStaticField(sCursorWindowSizeField)).intValue());
            return true;
        } catch (IllegalAccessException unused) {
            return false;
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        int i;
        super.stop();
        Field field = sCursorWindowSizeField;
        if (field == null || (i = sOriginSize) <= 0) {
            return;
        }
        try {
            FieldUtils.writeStaticField(field, Integer.valueOf(i));
        } catch (IllegalAccessException unused) {
        }
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }
}
