package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* loaded from: classes2.dex */
public class BdPrintWriter extends PrintWriter {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdPrintWriter(Writer writer) {
        super(writer);
    }

    public BdPrintWriter(Writer writer, boolean z) {
        super(writer, z);
    }

    public BdPrintWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public BdPrintWriter(OutputStream outputStream, boolean z) {
        super(outputStream, z);
    }

    public BdPrintWriter(String str) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(str));
    }

    public BdPrintWriter(String str, String str2) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        super(fms.resolve(str), str2);
    }

    public BdPrintWriter(File file) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(file));
    }

    public BdPrintWriter(File file, String str) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        super(fms.resolve(file), str);
    }
}
