package ru.gb.pugacheva.lesson1java3;

import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    // метод по подсчету веса коробки.
    public float getWeight() {
        float weight = 0.0f;
        for (int i = 0; i < fruits.size(); i++) {
            weight += fruits.get(i).getWeight();
        }
        return weight;
    }

    //метод добавления фруктов в коробку
    public void addFruits(T fruit) {
        fruits.add(fruit);
    }

    //метод сравнения коробок по весу:
    public boolean compareBoxes(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.01;
    }

    //метод пересыпания фруктов в другую коробку (за счет того, что задаем обобщенный параметр T мы сразу создаем
    // ограничение, что аргументом в метод может быть подана только коробка с теми же фруктами, как и та, из
    // которой пересыпаем.
    public void putFruitsInAnotherBox(Box<T> another) {
        for (int i = 0; i < this.fruits.size(); i++) {
            another.addFruits(this.fruits.get(i));
        }
        this.fruits.clear();
    }
}



