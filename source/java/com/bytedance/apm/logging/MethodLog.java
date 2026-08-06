package com.bytedance.apm.logging;

import android.util.Log;

/* loaded from: classes3.dex */
public class MethodLog {
    public static LogImp sLog = new LogImp() { // from class: com.bytedance.apm.logging.MethodLog.1
        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void v(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.v(str, str2);
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void i(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void d(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void w(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.w(str, str2);
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void e(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.e(str, str2);
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2 + "  " + Log.getStackTraceString(th));
        }
    };

    /* loaded from: classes3.dex */
    public interface LogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }
}
