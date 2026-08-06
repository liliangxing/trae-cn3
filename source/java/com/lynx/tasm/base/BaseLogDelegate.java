package com.lynx.tasm.base;

import com.lynx.base.log.AbsBaseLogDelegate;

/* loaded from: classes6.dex */
public class BaseLogDelegate extends AbsBaseLogDelegate {
    private static volatile BaseLogDelegate sInstance;
    private static AbsLogDelegate sLogDelegate;

    public static BaseLogDelegate inst() {
        if (sInstance == null) {
            synchronized (BaseLogDelegate.class) {
                if (sInstance == null) {
                    sInstance = new BaseLogDelegate();
                }
            }
        }
        return sInstance;
    }

    public void setDelegate(AbsLogDelegate absLogDelegate) {
        sLogDelegate = absLogDelegate;
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public void v(String str, String str2) {
        AbsLogDelegate absLogDelegate = sLogDelegate;
        if (absLogDelegate == null) {
            return;
        }
        absLogDelegate.v(str, str2);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public void d(String str, String str2) {
        AbsLogDelegate absLogDelegate = sLogDelegate;
        if (absLogDelegate == null) {
            return;
        }
        absLogDelegate.d(str, str2);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public void i(String str, String str2) {
        AbsLogDelegate absLogDelegate = sLogDelegate;
        if (absLogDelegate == null) {
            return;
        }
        absLogDelegate.i(str, str2);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public void w(String str, String str2) {
        AbsLogDelegate absLogDelegate = sLogDelegate;
        if (absLogDelegate == null) {
            return;
        }
        absLogDelegate.w(str, str2);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public void e(String str, String str2) {
        AbsLogDelegate absLogDelegate = sLogDelegate;
        if (absLogDelegate == null) {
            return;
        }
        absLogDelegate.e(str, str2);
    }
}
