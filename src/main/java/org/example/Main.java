package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> readFromFile(String pathName) {
        ArrayList<Integer> numbers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName))) {
            String[] line = bufferedReader.readLine().split(" ");
            for (String s : line) {
                numbers.add(Integer.parseInt(s));
            }
            return numbers;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Integer> getNumbers(ArrayList<Integer> nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer num : nums) {
            if (startsKEndsK(num, k)) {
                result.add(num);
            }
        }
        return result;
    }
    public static void writeToFile(String path, ArrayList<Integer> list) {
        try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(Paths.get(path)))) {
            for (int a: list) {
                dos.writeInt(a);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createKFiles(String pathName, int k) {
        ArrayList<Integer> numbers = readFromFile(pathName);
        System.out.println(numbers);
        for (int i = 0; i < k; i+=1) {
            writeToFile("C:/Users/1/IdeaProjects/Exam/src/main/java/org/example/numbers" + i + ".bin", getNumbers(numbers, i));
        }
    }

    public static boolean startsKEndsK(int n, int k) {
        if (n == k) return true;
        if (n % 10 == k) {
            int newN = n;
            while (newN / 10 > 0) {
                newN = newN / 10;
            }
            return newN % 10 == k;
        }
        return false;
    }

    public static void main(String[] args) {
        createKFiles("C:/Users/1/IdeaProjects/Exam/src/main/java/org/example/numbers.txt", 5);
    }
}