package bytedance.core;

import bytedance.io.exception.IllegalPathException;
import bytedance.resolver.FileHandler;
import bytedance.resolver.FileResolver;
import bytedance.util.DtfsUtils;
import bytedance.util.FsLogger;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RealResolverController implements FileResolver.Controller {
    private int excutes;
    private final int index;
    private final FileHandler originFile;
    private final List<FileResolver> resolvers;

    public RealResolverController(List<FileResolver> list, int i, FileHandler fileHandler) {
        this.resolvers = list;
        this.index = i;
        this.originFile = fileHandler;
    }

    @Override // bytedance.resolver.FileResolver.Controller
    public FileHandler originFile() {
        return this.originFile;
    }

    @Override // bytedance.resolver.FileResolver.Controller
    public FileHandler handle(FileHandler fileHandler) throws IllegalPathException {
        if (this.index >= this.resolvers.size()) {
            if (fileHandler.getPath() == null && fileHandler.getName() != null) {
                if (fileHandler.getParent() != null && !fileHandler.getParent().isEmpty()) {
                    fileHandler.setPath(internalResolve(fileHandler.getParent(), fileHandler.getName()));
                } else {
                    fileHandler.setPath(fileHandler.getName());
                }
            }
            return fileHandler;
        }
        int i = this.excutes + 1;
        this.excutes = i;
        if (i > 1) {
            DtfsUtils.uploadEvent(100);
            throw new IllegalStateException("FileResolver " + this.resolvers.get(this.index - 1) + " must call handle() exactly once");
        }
        RealResolverController realResolverController = new RealResolverController(this.resolvers, this.index + 1, fileHandler);
        FileResolver fileResolver = this.resolvers.get(this.index);
        FsLogger.d("RealResolverController", "FileResolver = " + (fileResolver != null ? fileResolver.toString() : "") + " file = " + fileHandler.getPath());
        FileHandler resolve = fileResolver.resolve(realResolverController);
        if (resolve == null) {
            DtfsUtils.uploadEvent(200);
            throw new NullPointerException("resolver " + fileResolver + " returned null");
        }
        if (resolve.getPath() != null) {
            return resolve;
        }
        DtfsUtils.uploadEvent(300);
        throw new IllegalStateException("resolver " + fileResolver + " returned a file with no body");
    }

    public String internalResolve(String str, String str2) {
        if (str2.isEmpty() || str2.equals("/")) {
            return str;
        }
        if (str2.charAt(0) == '/') {
            return str.equals("/") ? str2 : str + str2;
        }
        if (str.equals("/")) {
            return str + str2;
        }
        return str + '/' + str2;
    }
}
