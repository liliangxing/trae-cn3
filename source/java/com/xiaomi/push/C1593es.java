package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.C1760ar;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.es */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1593es {

    /* renamed from: a */
    private C1598ex f1657a;

    /* renamed from: a */
    private InputStream f1658a;

    /* renamed from: a */
    private volatile boolean f1661a;

    /* renamed from: a */
    private byte[] f1662a;

    /* renamed from: a */
    private ByteBuffer f1659a = ByteBuffer.allocate(2048);

    /* renamed from: b */
    private ByteBuffer f1663b = ByteBuffer.allocate(4);

    /* renamed from: a */
    private Adler32 f1660a = new Adler32();

    /* renamed from: a */
    private C1596ev f1656a = new C1596ev();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1593es(InputStream inputStream, C1598ex c1598ex) {
        this.f1658a = new BufferedInputStream(inputStream);
        this.f1657a = c1598ex;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2463a() {
        try {
            m2461c();
        } catch (IOException e) {
            if (!this.f1661a) {
                throw e;
            }
        }
    }

    /* renamed from: c */
    private void m2461c() {
        boolean z = false;
        this.f1661a = false;
        C1591eq m2462a = m2462a();
        if ("CONN".equals(m2462a.m2431a())) {
            C1562do.f m2202a = C1562do.f.m2202a(m2462a.m2442a());
            if (m2202a.m2207a()) {
                this.f1657a.m2551a(m2202a.m2206a());
                z = true;
            }
            if (m2202a.m2211c()) {
                C1562do.b m2203a = m2202a.m2203a();
                C1591eq c1591eq = new C1591eq();
                c1591eq.m2438a("SYNC", "CONF");
                c1591eq.m2440a(m2203a.mo2060a(), (String) null);
                this.f1657a.m2486a(c1591eq);
            }
            AbstractC1417b.m1089a("[Slim] CONN: host = " + m2202a.m2209b());
        }
        if (!z) {
            AbstractC1417b.m1089a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f1662a = this.f1657a.m2493a();
        while (!this.f1661a) {
            C1591eq m2462a2 = m2462a();
            long currentTimeMillis = System.currentTimeMillis();
            this.f1657a.m2555c();
            short m2433a = m2462a2.m2433a();
            if (m2433a == 1) {
                this.f1657a.m2486a(m2462a2);
            } else if (m2433a != 2) {
                if (m2433a == 3) {
                    try {
                        this.f1657a.m2495b(this.f1656a.m2480a(m2462a2.m2442a(), this.f1657a));
                    } catch (Exception e) {
                        AbstractC1417b.m1089a("[Slim] Parse packet from Blob chid=" + m2462a2.m2429a() + "; Id=" + m2462a2.m2455e() + " failure:" + e.getMessage());
                    }
                } else {
                    AbstractC1417b.m1089a("[Slim] unknow blob type " + ((int) m2462a2.m2433a()));
                }
            } else if ("SECMSG".equals(m2462a2.m2431a()) && ((m2462a2.m2429a() == 2 || m2462a2.m2429a() == 3) && TextUtils.isEmpty(m2462a2.m2446b()))) {
                try {
                    AbstractC1615fn m2480a = this.f1656a.m2480a(m2462a2.m2443a(C1755am.m3702a().m3705a(Integer.valueOf(m2462a2.m2429a()).toString(), m2462a2.m2457g()).f3006h), this.f1657a);
                    m2480a.f1788a = currentTimeMillis;
                    this.f1657a.m2495b(m2480a);
                } catch (Exception e2) {
                    AbstractC1417b.m1089a("[Slim] Parse packet from Blob chid=" + m2462a2.m2429a() + "; Id=" + m2462a2.m2455e() + " failure:" + e2.getMessage());
                }
            } else {
                this.f1657a.m2486a(m2462a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m2464b() {
        this.f1661a = true;
    }

    /* renamed from: a */
    private ByteBuffer m2459a() {
        this.f1659a.clear();
        m2460a(this.f1659a, 8);
        short s = this.f1659a.getShort(0);
        short s2 = this.f1659a.getShort(2);
        if (s != -15618 || s2 != 5) {
            throw new IOException("Malformed Input");
        }
        int i = this.f1659a.getInt(4);
        int position = this.f1659a.position();
        if (i > 32768) {
            throw new IOException("Blob size too large");
        }
        if (i + 4 > this.f1659a.remaining()) {
            ByteBuffer allocate = ByteBuffer.allocate(i + 2048);
            allocate.put(this.f1659a.array(), 0, this.f1659a.arrayOffset() + this.f1659a.position());
            this.f1659a = allocate;
        } else if (this.f1659a.capacity() > 4096 && i < 2048) {
            ByteBuffer allocate2 = ByteBuffer.allocate(2048);
            allocate2.put(this.f1659a.array(), 0, this.f1659a.arrayOffset() + this.f1659a.position());
            this.f1659a = allocate2;
        }
        m2460a(this.f1659a, i);
        this.f1663b.clear();
        m2460a(this.f1663b, 4);
        this.f1663b.position(0);
        int i2 = this.f1663b.getInt();
        this.f1660a.reset();
        this.f1660a.update(this.f1659a.array(), 0, this.f1659a.position());
        if (i2 != ((int) this.f1660a.getValue())) {
            AbstractC1417b.m1089a("CRC = " + ((int) this.f1660a.getValue()) + " and " + i2);
            throw new IOException("Corrupted Blob bad CRC");
        }
        byte[] bArr = this.f1662a;
        if (bArr != null) {
            C1760ar.m3748a(bArr, this.f1659a.array(), true, position, i);
        }
        return this.f1659a;
    }

    /* renamed from: a */
    C1591eq m2462a() {
        int i;
        ByteBuffer m2459a;
        C1591eq m2427a;
        try {
            m2459a = m2459a();
            i = m2459a.position();
        } catch (IOException e) {
            e = e;
            i = 0;
        }
        try {
            m2459a.flip();
            m2459a.position(8);
            if (i == 8) {
                m2427a = new C1597ew();
            } else {
                m2427a = C1591eq.m2427a(m2459a.slice());
            }
            AbstractC1417b.m1101c("[Slim] Read {cmd=" + m2427a.m2431a() + ";chid=" + m2427a.m2429a() + ";len=" + i + "}");
            return m2427a;
        } catch (IOException e2) {
            e = e2;
            if (i == 0) {
                i = this.f1659a.position();
            }
            StringBuilder sb = new StringBuilder("[Slim] read Blob [");
            byte[] array = this.f1659a.array();
            if (i > 128) {
                i = 128;
            }
            AbstractC1417b.m1089a(sb.append(C1467aa.m1437a(array, 0, i)).append("] Err:").append(e.getMessage()).toString());
            throw e;
        }
    }

    /* renamed from: a */
    private void m2460a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        do {
            int read = this.f1658a.read(byteBuffer.array(), position, i);
            if (read == -1) {
                throw new EOFException();
            }
            i -= read;
            position += read;
        } while (i > 0);
        byteBuffer.position(position);
    }
}
