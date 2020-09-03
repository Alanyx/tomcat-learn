package com.example.demo.tomcatColumn.lecture24.demo2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 自定义类加载器
 * <p>
 * 继承ClassLoader覆盖findClass方法（其中defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class）
 *
 * @author Alan Yin
 * @date 2020/8/31
 */

public class MyClassLoader extends ClassLoader {

    public MyClassLoader() {
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/yinxing/Desktop/Person.class");
        try {
            byte[] bytes = getClassBytes(file);
            // defineClass方法可以把二进制流字节组成的文件转换为一个java.lang.Class
            Class<?> clazz = this.defineClass(name, bytes, 0, bytes.length);
            return clazz;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getClassBytes(File file) throws IOException {
        // 这里读入.class的字节，因此要使用字节流
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            FileChannel fc = fis.getChannel();
            WritableByteChannel wbc = Channels.newChannel(baos);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                int i = fc.read(buffer);
                if (i == 0 || i == -1) {
                    break;
                }
                buffer.flip();
                wbc.write(buffer);
                buffer.clear();
            }
            return baos.toByteArray();
        }
    }

}
