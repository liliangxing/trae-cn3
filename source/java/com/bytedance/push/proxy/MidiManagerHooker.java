package com.bytedance.push.proxy;

import android.media.midi.MidiManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MidiManagerHooker extends BaseHooker {
    private static volatile MidiManagerHooker midiManagerHooker;

    @Override // com.bytedance.push.proxy.BaseHooker
    protected String getLogTag() {
        return "MidiManagerHooker";
    }

    public static MidiManagerHooker getInstance() {
        if (midiManagerHooker == null) {
            synchronized (MidiManagerHooker.class) {
                if (midiManagerHooker == null) {
                    midiManagerHooker = new MidiManagerHooker();
                }
            }
        }
        return midiManagerHooker;
    }

    @Override // com.bytedance.push.proxy.BaseHooker
    protected boolean doHook() {
        try {
            Logger.m274i(getLogTag(), "[doHook]hookSuccess：" + this.hookSuccess);
            if (this.hookSuccess) {
                return true;
            }
            MidiManager midiManager = (MidiManager) AppProvider.getApp().getApplicationContext().getSystemService("midi");
            Logger.m274i(getLogTag(), "midiManager：" + midiManager);
            Field declaredField = Class.forName("android.media.midi.MidiManager").getDeclaredField("mService");
            declaredField.setAccessible(true);
            this.mBase = declaredField.get(midiManager);
            declaredField.set(midiManager, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.media.midi.IMidiManager")}, this));
            Logger.m274i(getLogTag(), "success hook MidiManager");
            return true;
        } catch (Throwable th) {
            Logger.m272e(getLogTag(), "error when hook MidiManager ", th);
            return false;
        }
    }
}
