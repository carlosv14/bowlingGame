package com.example.bowling;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileParser<Element> {

    Stream<Element> getAllData(String fileName) throws IOException;
}
