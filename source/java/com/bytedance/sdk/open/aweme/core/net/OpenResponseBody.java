package com.bytedance.sdk.open.aweme.core.net;

import com.bytedance.sdk.open.aweme.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class OpenResponseBody extends InputStream {
    private long contentLength;
    private String contentType;
    private InputStream real;
    private boolean finished = false;
    private boolean closed = false;
    private long readLength = 0;
    private byte[] bytesBody = null;
    private String stringBody = null;

    public OpenResponseBody(String str, long j, InputStream inputStream) {
        this.contentLength = j;
        this.contentType = str;
        this.real = inputStream;
    }

    public synchronized byte[] bytes() {
        byte[] bArr = this.bytesBody;
        if (bArr != null) {
            return bArr;
        }
        if (isClosed()) {
            return new byte[0];
        }
        try {
            this.bytesBody = IOUtils.toByteArray(this);
        } catch (Throwable unused) {
        }
        safeClose();
        if (this.bytesBody == null) {
            this.bytesBody = new byte[0];
        }
        return this.bytesBody;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.real.close();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getReadLength() {
        return this.readLength;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isReadFinished() {
        return this.finished;
    }

    public JSONObject jsonBody() {
        try {
            return new JSONObject(stringBody());
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.real.read();
        if (read != -1) {
            this.readLength++;
        } else {
            this.finished = true;
        }
        return read;
    }

    public boolean safeClose() {
        try {
            close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public String stringBody() {
        String str = this.stringBody;
        if (str != null) {
            return str;
        }
        String str2 = new String(bytes());
        this.stringBody = str2;
        return str2;
    }

    public String toString() {
        return "OpenResponseBody{contentType='" + this.contentType + "', contentLength=" + this.contentLength + ", finished=" + this.finished + ", closed=" + this.closed + ", readLength=" + this.readLength + AbstractJsonLexerKt.END_OBJ;
    }
}
