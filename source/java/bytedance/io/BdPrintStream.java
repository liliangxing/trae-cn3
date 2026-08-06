package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class BdPrintStream extends PrintStream {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdPrintStream(OutputStream outputStream) {
        super(outputStream);
    }

    public BdPrintStream(OutputStream outputStream, boolean z) {
        super(outputStream, z);
    }

    public BdPrintStream(OutputStream outputStream, boolean z, String str) throws UnsupportedEncodingException {
        super(outputStream, z, str);
    }

    public BdPrintStream(String str) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(str));
    }

    public BdPrintStream(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        super(fms.resolve(str), str2);
    }

    public BdPrintStream(File file) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(file));
    }

    public BdPrintStream(File file, String str) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        super(fms.resolve(file), str);
    }
}
