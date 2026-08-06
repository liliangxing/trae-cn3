package com.bytedance.router;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes4.dex */
class SmartIntent extends Intent {
    @Override // android.content.Intent
    public int getIntExtra(String str, int i) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return i;
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Integer", Integer.valueOf(i), e);
                return i;
            }
        }
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Integer", Integer.valueOf(i), e2);
            return i;
        }
    }

    public static Intent smartIntent(Intent intent) {
        return (intent == null || (intent instanceof SmartIntent)) ? intent : new SmartIntent(intent);
    }

    public static boolean isSmartIntent(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent instanceof SmartIntent;
    }

    private SmartIntent(Intent intent) {
        super(intent);
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return s;
        }
        if (obj instanceof String) {
            try {
                return Short.valueOf(Short.parseShort((String) obj)).shortValue();
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Short", Short.valueOf(s), e);
                return s;
            }
        }
        try {
            return ((Short) obj).shortValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Short", Short.valueOf(s), e2);
            return s;
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return c;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.length() == 1) {
                return str2.charAt(0);
            }
            typeWarning(str, obj, "Char", Character.valueOf(c), null);
            return c;
        }
        try {
            return ((Character) obj).charValue();
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Char", Character.valueOf(c), e);
            return c;
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return j;
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Long", Long.valueOf(j), e);
                return j;
            }
        }
        try {
            return ((Long) obj).longValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Long", Long.valueOf(j), e2);
            return j;
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return f;
        }
        if (obj instanceof String) {
            try {
                return Float.parseFloat((String) obj);
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Float", Float.valueOf(f), e);
                return f;
            }
        }
        try {
            return ((Float) obj).floatValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Float", Float.valueOf(f), e2);
            return f;
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return d;
        }
        if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Double", Double.valueOf(d), e);
                return d;
            }
        }
        try {
            return ((Double) obj).doubleValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Double", Double.valueOf(d), e2);
            return d;
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return b;
        }
        if (obj instanceof String) {
            try {
                return Byte.parseByte((String) obj);
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Byte", Byte.valueOf(b), e);
                return b;
            }
        }
        try {
            return ((Byte) obj).byteValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Byte", Byte.valueOf(b), e2);
            return b;
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        Object obj;
        Bundle extras = super.getExtras();
        if (extras == null || (obj = extras.get(str)) == null) {
            return z;
        }
        if (obj instanceof String) {
            try {
                return Boolean.parseBoolean((String) obj);
            } catch (NumberFormatException e) {
                typeWarning(str, obj, "Boolean", Boolean.valueOf(z), e);
                return z;
            }
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException e2) {
            typeWarning(str, obj, "Boolean", Boolean.valueOf(z), e2);
            return z;
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        return super.getExtras();
    }

    @Override // android.content.Intent
    public Uri getData() {
        return super.getData();
    }

    private void typeWarning(String str, Object obj, String str2, Object obj2, RuntimeException runtimeException) {
        Log.w("SmartIntent", "Key " + str + " expected " + str2 + " but value was a " + obj.getClass().getName() + ".  The default value " + obj2 + " was returned.");
        if (runtimeException != null) {
            Log.w("SmartIntent", "Attempt to cast generated internal exception:", runtimeException);
        }
    }
}
