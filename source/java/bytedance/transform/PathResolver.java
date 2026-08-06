package bytedance.transform;

import android.content.Context;
import bytedance.io.exception.IllegalPathException;
import bytedance.resolver.FileHandler;
import bytedance.resolver.FileResolver;
import bytedance.util.FsLogger;

/* loaded from: classes2.dex */
public class PathResolver implements FileResolver {
    private Context mContext;

    public PathResolver(Context context) {
        this.mContext = context;
    }

    @Override // bytedance.resolver.FileResolver
    public FileHandler resolve(FileResolver.Controller controller) throws IllegalPathException {
        FileHandler originFile = controller.originFile();
        originFile.setPath(PathTransformService.getInstance().transform(originFile.getPath(), this.mContext));
        FsLogger.e("PathResolver:" + originFile.getPath());
        return controller.handle(originFile);
    }
}
