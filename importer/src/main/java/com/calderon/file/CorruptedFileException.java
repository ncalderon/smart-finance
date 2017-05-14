package com.calderon.file;

/**
 * Created by Nathaniel on 1/3/2017.
 */
public class CorruptedFileException extends RuntimeException {
    public CorruptedFileException(String fileName) {
        super("Corrupted file: " + fileName);
    }
}
