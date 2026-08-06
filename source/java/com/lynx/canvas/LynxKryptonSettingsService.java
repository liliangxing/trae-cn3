package com.lynx.canvas;

/* loaded from: classes6.dex */
public class LynxKryptonSettingsService extends KryptonSettingsService {
    private static final String TAG = "LynxKryptonSettingsService";

    @Override // com.lynx.canvas.KryptonSettingsService
    public boolean booleanValueForKey(String str, boolean z) {
        return LynxSettingsUtils.booleanValueForKey(str, z);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public int integerValueForKey(String str, int i) {
        return LynxSettingsUtils.integerValueForKey(str, i);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public double doubleValueForKey(String str, double d) {
        return LynxSettingsUtils.doubleValueForKey(str, d);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public String stringValueForKey(String str, String str2) {
        return LynxSettingsUtils.stringValueForKey(str, str2);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public Object objectValueForKey(String str, Object obj) {
        return LynxSettingsUtils.objectValueForKey(str, obj);
    }
}
