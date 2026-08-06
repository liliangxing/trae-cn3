package bytedance.io;

import bytedance.core.FileManagerService;
import bytedance.io.exception.IllegalPathException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;

/* loaded from: classes2.dex */
public class BdFileReader extends FileReader {
    private static final FileManagerService fms = FileManagerService.getDefault();

    public BdFileReader(String str) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(str));
    }

    public BdFileReader(File file) throws FileNotFoundException, IllegalPathException {
        super(fms.resolve(file));
    }

    public BdFileReader(FileDescriptor fileDescriptor) {
        super(fileDescriptor);
    }
}
