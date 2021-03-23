package ru.gb.pugacheva.lesson1java3;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

//        //проверка работы метода changePlaceArr
//        String [] array =  {"A", "B", "C", "D","E"};
//        System.out.println(Arrays.toString(changePlaceArr(array,2,4)));
//        Integer [] array1 = {1,2,3,4,5,6,7};
//        System.out.println(Arrays.toString(changePlaceArr(array1,0,3)));

//         //проверка работы метода makeArrayListFromArray
//        String [] intArr = {"A","B","C","A","D","Q","S"};
//        System.out.println(makeArrayListFromArray(intarr));

        // пробуем поработать с задачей про коробки с фруктами:
        //1. Создаем объекты классов:

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> box1 = new Box<>(new ArrayList<>(Arrays.asList(apple1, apple2, apple3, apple4, apple5)));
        Box<Orange> box2 = new Box<>(new ArrayList<>(Arrays.asList(orange1, orange2, orange3, orange4)));

        //2. Пробуем метод добавления фруктов в коробку:
        box1.addFruits(apple1);

        Box<Apple> box3 = new Box<>(new ArrayList<>(Arrays.asList(apple1, apple2, apple3, apple4, apple5)));

        // 3. Проверяем работу метода getWeight()
        System.out.println("Вес коробки box1 = " + box1.getWeight());
        System.out.println("Вес коробки box2 = " + box2.getWeight());

        //4. Проверяем работу метода compareBoxes :
        System.out.println(box1.compareBoxes(box2));

        // 5. Проверяем работу метода по пересыпанию фруктов:
        box1.putFruitsInAnotherBox(box3);
        //box2.putFruitsInAnotherBox(box1); - не работает. Казалось бы box1 пустая, но она была создана как
        // коробка для яблок, так что в итоге в нее и пустую пересыпать апельсины нельзя. Тут, вроде,
        // все логично и не подразумевается, что при освобождении коробки должен как-то обнуляться ее тип. Так?

        System.out.println("После пересыпания вес коробки 1 составляет " + box1.getWeight() + "кг, а вес коробки" +
                " 3 составляет " + box3.getWeight() + " кг");

    }

    // метод, который меняет два элемента массива местами (для массивов любого типа)
    public static <T> T[] changePlaceArr(T[] arr, int first, int second) {
        T firstItem = arr[first];
        T secondItem = arr[second];
        arr[first] = secondItem;
        arr[second] = firstItem;
        return arr;
    }

    // метод, который преобразует массив в ArrayList // метод рабтает только со ссылочными типами данных. Это
    // логично, т.к. ArrayList также по-любому со ссылочными работает. Преобразование примитивов в ссылочные
    // внутри обобщенного метода не вижу, как реализовать....
    public static <E> ArrayList<E> makeArrayListFromArray(E[] array) {
        ArrayList<E> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]); // тут была мысль использовать метод addAll, но из-за того, что подаю массив,
        }                           // не получалось (и я это подозревала, когда экспериментировала. А при коммите
        return arrayList;           // Джава говорит,что можно заменить мою реализацию на addAll (тут по коду
    }                               //особой разницы нет, но не пойму, почему тогда у меня не получилось его применить)
}
