import java.util.Scanner;

//Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        5 - поиск
//Далее нужно запросить минимальные значения для указанных критериев -
//сохранить параметры фильтрации можно также в Map.
public class Computers {
    int ozu;
    int disk;
    String os;
    String color;


    @Override
    public String toString() {
        return "Компьютер с параметрами: " + "{ ОЗУ=" + ozu + "Гб, ЖД=" + disk + "Гб, ОС=" + os + ", Цвет=" + color + " }";
    }


    //    @Override
//    public String toString() {
//        return "name: " + name + ", poroda: " + poroda + ", age: " + age + ", owner: " + owner;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Cat)){
//            return false;
//        }
//        Cat cat = (Cat) obj;
//        return name.equals(cat.name) && poroda.equals(cat.poroda) && age == cat.age && owner.equals(cat.owner);
//    }
//
//    @Override
//    public int hashCode() {
//        return name.hashCode() + 7*poroda.hashCode() + 13*age + 17*owner.hashCode();
//    }
}