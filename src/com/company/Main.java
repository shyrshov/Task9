package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Path filePath = Paths.get("src/com/company/firstFile.txt");
        Path newFilePath = Paths.get("src/com/company/secondFile.txt");
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
    }
        try(BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.forName("UTF-8"))){
            writer.write("Hello World!");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try (OutputStream stream = new FileOutputStream(newFilePath.toFile())) {

            Files.copy(filePath, stream);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.delete(filePath);
        } catch (NoSuchFileException e) {
            System.out.println(e.getMessage());
        } catch (DirectoryNotEmptyException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
