package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* loaded from: classes2.dex */
public class BdFileInputStream extends FileInputStream {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdFileInputStream(String str) throws FileNotFoundException, IllegalPathException {
        this(str != null ? new BdFile(str) : null);
    }

    public BdFileInputStream(File file) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(file));
    }

    public BdFileInputStream(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
    }
}
