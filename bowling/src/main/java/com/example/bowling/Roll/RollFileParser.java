package com.example.bowling.Roll;

import com.example.bowling.FileParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RollFileParser implements FileParser<Roll> {

    @Override
    public Stream<Roll> getAllData(String fileName) throws Exception {
        return Files.lines(Paths.get(fileName))
                .flatMap(l -> Stream.of(l.split("\\t")))
                .map(r -> r.split(" "))
                .map(r -> new Roll(r[1].trim(), r[0].trim()));
    }

    @Override
    public void validateData(List<Roll> data) throws Exception {
        for (Roll roll : data){
            roll.validateRoll();
        }
    }
}
