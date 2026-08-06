package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class PathAccessMonitor {
    private static final String TAG = "PathAccessMonitor";
    private static boolean sInit;

    public static void start(Context context, String str) {
        if (sInit) {
            return;
        }
        sInit = true;
        tryHookBlockGuard(context, str);
    }

    private static void tryHookBlockGuard(Context context, String str) {
        try {
            Method methodInner = DoubleReflectUtils.getMethodInner(Class.forName("dalvik.system.BlockGuard"), "setVmPolicy", Class.forName("dalvik.system.BlockGuard$VmPolicy"));
            methodInner.setAccessible(true);
            File file = new File(str);
            file.mkdirs();
            final FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "onPathAccess_" + Process.myPid() + "_" + System.currentTimeMillis()));
            methodInner.invoke(null, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{Class.forName("dalvik.system.BlockGuard$VmPolicy")}, new InvocationHandler() { // from class: com.bytedance.sysoptimizer.PathAccessMonitor.1
                int index = 0;

                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    Log.d(PathAccessMonitor.TAG, "invoke() called with: method = [" + method.getName() + "], args = [" + Arrays.toString(objArr) + "]", new Throwable());
                    if (!method.getName().equalsIgnoreCase("onPathAccess")) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("index=");
                    int i = this.index;
                    this.index = i + 1;
                    byte[] bytes = sb.append(i).append("\npath=").append(objArr[0]).append("\nstack=").append(Log.getStackTraceString(new Throwable())).append(UpdateDialogNewBase.TYPE).toString().getBytes();
                    synchronized (fileOutputStream) {
                        fileOutputStream.write(bytes);
                        fileOutputStream.flush();
                    }
                    return null;
                }
            }));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
