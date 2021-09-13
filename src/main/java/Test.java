import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Author: r00t4dm
 * @Date: 2021/9/13 6:01 下午
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/r00t4dm/servlet-fileUpload/pom.xml");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4086);

        Future<Integer> operation = channel.read(byteBuffer, 0);

        while(!operation.isDone());

        byteBuffer.flip();
        byte[] data = new byte[byteBuffer.limit()];
        byteBuffer.get(data);
        System.out.println(new String(data));
        byteBuffer.clear();
    }
}
