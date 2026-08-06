package com.bytedance.push.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: classes4.dex */
public class CommandHelper {

    /* loaded from: classes4.dex */
    public interface CommandOutPutCallback {
        void onCallback(String str);
    }

    public static String execCmd(String str, CommandOutPutCallback commandOutPutCallback, CommandOutPutCallback commandOutPutCallback2) {
        try {
            System.out.println("exec cmd: " + str);
            Process exec = Runtime.getRuntime().exec(str);
            GobblerThread gobblerThread = new GobblerThread(exec.getErrorStream(), "ERROR", commandOutPutCallback2);
            GobblerThread gobblerThread2 = new GobblerThread(exec.getInputStream(), "OUTPUT", commandOutPutCallback);
            gobblerThread.start();
            gobblerThread2.start();
            return exec.waitFor() == 0 ? "success" : "failed";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* loaded from: classes4.dex */
    public static class GobblerThread extends Thread {
        InputStream is;
        CommandOutPutCallback mCallback;
        String type;

        GobblerThread(InputStream inputStream, String str, CommandOutPutCallback commandOutPutCallback) {
            this.is = inputStream;
            this.type = str;
            this.mCallback = commandOutPutCallback;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.is));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else {
                        stringBuffer.append(readLine);
                    }
                }
                System.out.println(stringBuffer.toString());
                CommandOutPutCallback commandOutPutCallback = this.mCallback;
                if (commandOutPutCallback != null) {
                    commandOutPutCallback.onCallback(stringBuffer.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
