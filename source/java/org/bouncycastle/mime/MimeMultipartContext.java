package org.bouncycastle.mime;

import java.io.IOException;

/* loaded from: classes8.dex */
public interface MimeMultipartContext extends MimeContext {
    MimeContext createContext(int i) throws IOException;
}
