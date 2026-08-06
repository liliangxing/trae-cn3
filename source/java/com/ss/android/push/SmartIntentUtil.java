package com.ss.android.push;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes7.dex */
public class SmartIntentUtil {
    public static short getShortExtra(Intent intent, String str, short s) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return s;
        }
        if (obj instanceof String) {
            try {
                return Short.valueOf(Short.parseShort((String) obj)).shortValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return s;
            }
        }
        try {
            return ((Short) obj).shortValue();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            return s;
        }
    }

    public static char getCharExtra(Intent intent, String str, char c) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return c;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            return str2.length() == 1 ? str2.charAt(0) : c;
        }
        try {
            return ((Character) obj).charValue();
        } catch (ClassCastException unused) {
            return c;
        }
    }

    public static int getIntExtra(Intent intent, String str, int i) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return i;
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused2) {
            return i;
        }
    }

    public static long getLongExtra(Intent intent, String str, long j) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return j;
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException unused2) {
            return j;
        }
    }

    public static float getFloatExtra(Intent intent, String str, float f) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return f;
        }
        if (obj instanceof String) {
            try {
                return Float.parseFloat((String) obj);
            } catch (NumberFormatException unused) {
                return f;
            }
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException unused2) {
            return f;
        }
    }

    public static double getDoubleExtra(Intent intent, String str, double d) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return d;
        }
        if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException unused) {
                return d;
            }
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException unused2) {
            return d;
        }
    }

    public static byte getByteExtra(Intent intent, String str, byte b) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return b;
        }
        if (obj instanceof String) {
            try {
                return Byte.parseByte((String) obj);
            } catch (NumberFormatException unused) {
                return b;
            }
        }
        try {
            return ((Byte) obj).byteValue();
        } catch (ClassCastException unused2) {
            return b;
        }
    }

    public static boolean getBooleanExtra(Intent intent, String str, boolean z) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return z;
        }
        if (obj instanceof String) {
            try {
                return Boolean.parseBoolean((String) obj);
            } catch (NumberFormatException unused) {
                return z;
            }
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused2) {
            return z;
        }
    }
}
