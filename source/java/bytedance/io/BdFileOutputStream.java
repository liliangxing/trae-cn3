package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class BdFileOutputStream extends FileOutputStream {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdFileOutputStream(String str) throws FileNotFoundException, IllegalPathException {
        this((File) (str != null ? new BdFile(str) : null), false);
    }

    public BdFileOutputStream(String str, boolean z) throws FileNotFoundException, IllegalPathException {
        this(str != null ? new BdFile(str) : null, z);
    }

    public BdFileOutputStream(File file) throws FileNotFoundException, IllegalPathException {
        this((File) fms.resolve(file), false);
    }

    public BdFileOutputStream(File file, boolean z) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(file), z);
    }

    public BdFileOutputStream(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
    }
}
