package com.bytedance.frameworks.baselib.network.http.impl;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.io.SafeObjectInputStream;
import com.ss.bduploader.UploadKeys;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.UByte;

/* loaded from: classes2.dex */
public class SerializableHttpCookie implements Serializable {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final String TAG = "SerializableHttpCookie";
    private static final long serialVersionUID = 6374381323722046732L;
    private transient HttpCookie cookie;
    private long whenCreated = System.currentTimeMillis();

    public SerializableHttpCookie(HttpCookie httpCookie) {
        this.cookie = httpCookie;
    }

    public boolean hasExpired() {
        long maxAge = this.cookie.getMaxAge();
        return maxAge != -1 && (System.currentTimeMillis() - this.whenCreated) / 1000 > maxAge;
    }

    public HttpCookie getHttpCookie() {
        return this.cookie;
    }

    public Long getWhenCreated() {
        return Long.valueOf(this.whenCreated);
    }

    public boolean equals(Object obj) {
        if (obj instanceof HttpCookie) {
            return this.cookie.equals(obj);
        }
        if (obj instanceof SerializableHttpCookie) {
            return this.cookie.equals(((SerializableHttpCookie) obj).cookie);
        }
        return false;
    }

    public int hashCode() {
        return this.cookie.hashCode();
    }

    private boolean getHttpOnly() {
        return this.cookie.getHttpOnly();
    }

    private void setHttpOnly(boolean z) {
        this.cookie.setHttpOnly(z);
    }

    public String encode() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
            return byteArrayToHexString(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            Log.d(TAG, "IOException in encodeCookie", e);
            return null;
        }
    }

    public static SerializableHttpCookie decode(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return (SerializableHttpCookie) new SafeObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(str)), (Class<?>[]) new Class[]{SerializableHttpCookie.class}).readObject();
            } catch (IOException e) {
                Log.d(TAG, "IOException in decodeCookie", e);
            } catch (ClassNotFoundException e2) {
                Log.d(TAG, "ClassNotFoundException in decodeCookie", e2);
            }
        }
        return null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cookie.getName());
        objectOutputStream.writeObject(this.cookie.getValue());
        objectOutputStream.writeObject(this.cookie.getComment());
        objectOutputStream.writeObject(this.cookie.getCommentURL());
        objectOutputStream.writeObject(this.cookie.getDomain());
        objectOutputStream.writeLong(this.cookie.getMaxAge());
        objectOutputStream.writeObject(this.cookie.getPath());
        objectOutputStream.writeObject(this.cookie.getPortlist());
        objectOutputStream.writeInt(this.cookie.getVersion());
        objectOutputStream.writeBoolean(this.cookie.getSecure());
        objectOutputStream.writeBoolean(this.cookie.getDiscard());
        objectOutputStream.writeBoolean(getHttpOnly());
        objectOutputStream.writeLong(this.whenCreated);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        HttpCookie httpCookie = new HttpCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
        this.cookie = httpCookie;
        httpCookie.setComment((String) objectInputStream.readObject());
        this.cookie.setCommentURL((String) objectInputStream.readObject());
        this.cookie.setDomain((String) objectInputStream.readObject());
        this.cookie.setMaxAge(objectInputStream.readLong());
        this.cookie.setPath((String) objectInputStream.readObject());
        this.cookie.setPortlist((String) objectInputStream.readObject());
        this.cookie.setVersion(objectInputStream.readInt());
        this.cookie.setSecure(objectInputStream.readBoolean());
        this.cookie.setDiscard(objectInputStream.readBoolean());
        setHttpOnly(objectInputStream.readBoolean());
        this.whenCreated = objectInputStream.readLong();
    }

    private String byteArrayToHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    private static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static int getEffectivePort(String str, int i) {
        if (i != -1) {
            return i;
        }
        if ("http".equalsIgnoreCase(str)) {
            return 80;
        }
        if ("https".equalsIgnoreCase(str)) {
            return UploadKeys.KeyIsGetVideoMeta;
        }
        return -1;
    }
}
