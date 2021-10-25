package ru.dataart.academy.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Calculator {
    /**
     * @param zipFilePath -  path to zip archive with text files
     * @param character   - character to find
     * @return - how many times character is in files
     */
    public Integer getNumberOfChar(String zipFilePath, char character) {
        Integer count = 0;
        try {
            ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                FileOutputStream fout = new FileOutputStream("zz.txt");
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.close();
            }
            zin.close();
            File file = new File("zz.txt");
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\s");
            }
            String[] array = sb.toString().split("\s");
            String num = Character.toString(character);
            List<String> list = new LinkedList<>(Arrays.asList(array));
            for (String s : list) {
                if (s.equals(num)) {
                    count++;
                }
            }
            scanner.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @param zipFilePath - path to zip archive with text files
     * @return - max length
     */

    public Integer getMaxWordLength(String zipFilePath) {
        int count = 0;
        int wordLength = 0;
        try {
            ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                FileOutputStream fout = new FileOutputStream("zz.txt");
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);

                }
                fout.close();
            }
            zin.close();
            File file = new File("zz.txt");
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\s");
            }
            String[] array = sb.toString().trim().split("");

            System.out.println(Arrays.toString(array));

            for (String x : array) {
                if (!Objects.equals(x, "\s\s")) {
                    count++;
                } else if (Objects.equals(x, "\s\s")) {
                    wordLength = count;
                    count = 0;
                }
            }
            scanner.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return wordLength;
    }

}
