package com.bytedance.trae;

import android.app.Application;

/**
 * stub for compilation only.
 *
 * 关键：getInst() 返回类型必须是 TraeApplication，不能是 Object。
 * 因为真实 APK 中 TraeApplication$Companion.getInst() 的方法签名是：
 *   getInst()Lcom/bytedance/trae/TraeApplication;
 * 如果 stub 写成返回 Object，编译后 smali 调用 getInst()Ljava/lang/Object;，
 * 运行时找不到匹配方法 → NoSuchMethodError（被 try-catch 静默吞掉）。
 *
 * 继承 Application（具体类，非抽象），使返回值可直接当 Context 用。
 */
public class TraeApplication extends Application {
    public static final Companion Companion = new Companion();

    public static class Companion {
        public TraeApplication getInst() { return null; }
    }
}
