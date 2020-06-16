package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
//        Comparator comparator =  new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Attachment left = (Attachment) o1;
//                Attachment right = (Attachment) o2;
//                return left.getSize() - right.getSize();
//            }
//        };
//        attachments.sort(comparator);
//        System.out.println(attachments);
//
//        Comparator nameComparator =  new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Attachment left = (Attachment) o1;
//                Attachment right = (Attachment) o2;
//                return left.getName().compareTo(right.getName());
//            }
//        };
//        attachments.sort(nameComparator);
//        System.out.println(attachments);
//
//        System.out.println("====================================");
//
//        /**
//         * компаратор для строк через лямбда. Строки сравниватаюся через метод compareTo.
//         */
//        Comparator<Attachment> cmpText = (left, right) -> left.getName().compareTo(right.getName());
//        attachments.sort(cmpText);
//        System.out.println(attachments);
//
//        /**
//         * компаратор для строк через лямбда. Компаратор сортировает строки по убыванию длины.
//         */
//        Comparator<Attachment> cmpDescSize = (left, right) -> Integer.compare(right.getSize(), left.getSize());
//        attachments.sort(cmpDescSize);
//        System.out.println(attachments);

//        System.out.println("====================================");

        /**
         * компаратор для строк через лямбда. Строки сравниватаюся через метод compareTo.
         */
        Comparator<Attachment> cmpText2 = (left, right) -> {
            System.out.println("compare - " + left.getName() + " : " + right.getName());
            return left.getName().compareTo(right.getName());
        };
        attachments.sort(cmpText2);
        System.out.println(attachments);

        /**
         * компаратор для строк через лямбда. Компаратор сортировает строки по убыванию длины.
         */
        Comparator<Attachment> cmpDescSize2 = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return Integer.compare(right.getSize(), left.getSize());
        };
        attachments.sort(cmpDescSize2);
        System.out.println(attachments);

    }
}