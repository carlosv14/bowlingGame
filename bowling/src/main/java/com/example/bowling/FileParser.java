package com.example.bowling;

import java.util.List;
import java.util.stream.Stream;

public interface FileParser<Element> {

    Stream<Element> getAllData(String fileName) throws Exception;

    void validateData(List<Element> data) throws Exception;
}
