package com.ss.alog.middleware;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes7.dex */
public abstract class ALogService implements IALogProtocol {
    protected static ALogService sInstance;
    protected static volatile boolean sIsStrickMode;

    /* JADX INFO: Access modifiers changed from: protected */
    public ALogService() {
        sInstance = this;
    }

    public static void setAlogService(ALogService aLogService) {
        sInstance = aLogService;
    }

    public static void initSafely() {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.init();
        }
    }

    @Deprecated
    public static void initSafely(String str) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.init(str);
        }
    }

    public static boolean debugSafely() {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
            return false;
        }
        return aLogService.isLoggable(3);
    }

    public static boolean isBlackTagSafely(String str) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
            return false;
        }
        return aLogService.isBlackTag(str);
    }

    public static void vSafely(String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.v(str, str2);
        }
    }

    public static void dSafely(String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.d(str, str2);
        }
    }

    public static void iSafely(String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.i(str, str2);
        }
    }

    public static void wSafely(String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.w(str, str2);
        }
    }

    public static void wSafely(String str, String str2, Throwable th) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.w(str, str2, th);
        }
    }

    public static void wSafely(String str, Throwable th) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.w(str, th);
        }
    }

    public static void eSafely(String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.e(str, str2);
        }
    }

    public static void eSafely(String str, String str2, Throwable th) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.e(str, str2, th);
        }
    }

    public static void eSafely(String str, Throwable th) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.e(str, th);
        }
    }

    public static void headerSafely(int i, String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.header(i, str, str2);
        }
    }

    public static void jsonSafely(int i, String str, String str2) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.json(i, str, str2);
        }
    }

    public static void bundleSafely(int i, String str, Bundle bundle) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.bundle(i, str, bundle);
        }
    }

    public static void intentSafely(int i, String str, Intent intent) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.intent(i, str, intent);
        }
    }

    public static void throwableSafely(int i, String str, Throwable th) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.throwable(i, str, th);
        }
    }

    public static void threadSafely(int i, String str, Thread thread) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.thread(i, str, thread);
        }
    }

    public static void statcktraceSafely(int i, String str, StackTraceElement[] stackTraceElementArr) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.statcktrace(i, str, stackTraceElementArr);
        }
    }

    public static void changeLevelSafely(int i) {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.changeLevel(i);
        }
    }

    public static void forceLogShardingSafely() {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.forceLogSharding();
        }
    }

    public static void destroySafely() {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.destroy();
        }
    }

    public static void flushSafely() {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.flush();
        }
    }

    public static void releaseSafely() {
        ALogService aLogService = sInstance;
        if (aLogService == null) {
            if (sIsStrickMode) {
                throw new RuntimeException("implement AlogService and set sInstance first");
            }
        } else {
            aLogService.release();
        }
    }
}
