package com.majiang.statistics.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenyuejun
 * @descripption
 * @date 2019/9/29 &{TIME}
 */
@Slf4j
public class File {
    public static ByteBuffer getSplitFileFormLocal(int offSet, String fileName, int splitFileSize, String localPath) throws Exception {
        //-----若文件不存在则重新下载

        java.io.File file = new java.io.File(localPath);

        ByteBuffer byteBuffer = MappedByteBuffer.allocate(Constants.Nova.SCREEN_MAX_BLOCK_SIZE);
        Path path = Paths.get(localPath);
        try (FileChannel fileChannel = FileChannel.open(path)) {
            byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, offSet, splitFileSize);
        } catch (IOException e) {
            log.error("从本地获取分片文件:{} 失败", fileName);
            e.printStackTrace();
        }
        return byteBuffer;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(6000/19);
    }

}
