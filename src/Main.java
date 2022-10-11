import Flower.Flower;
import Human.Human;
import Transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int currentYear = 2022;

        Human maxim = new Human("Максим", " Минск", currentYear - 35
                , " бренд-менеджер");
        Human anya = new Human("Аня", " Москва", currentYear - 29
                , " методист образовательных программ");
        Human katya = new Human("Катя", " Калининград", currentYear - 28
                , " продакт-менеджер");
        Human artem = new Human("Артем", " Москва", currentYear - 27
                , " директор по развитию бизнеса");
        Human vladimir = new Human("Владимир", " Казань"
                , currentYear - 21, null);

        printInfo(maxim);
        printInfo(anya);
        printInfo(katya);
        printInfo(artem);
        printInfo(vladimir);

        Flower rosa = new Flower(null, "Голландия", 35.59, 0);
        Flower chrysanthema = new Flower(null, null, 15, 5);
        Flower pion = new Flower(null, "Англия", 69.9, 1);
        Flower gypsophila = new Flower(null, "Турция", 19.5, 10);

        printInfo(rosa);
        printInfo(chrysanthema);
        printInfo(pion);
        printInfo(gypsophila);

        printCostOfFlowers(rosa, rosa, rosa,
                chrysanthema, chrysanthema, chrysanthema, chrysanthema, chrysanthema,
                gypsophila);

        Car lada = new Car("Lada", "Granta", 1.7, "Желтый"
                , 2015, "Россия");
        lada.setTires(false);
        lada.setInsurance(new Car.Insurance(LocalDate.now(), 30000D, "4557326"));
        lada.getInsurance().checkInsuranceNumber();
        lada.getInsurance().checkExpiration();
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "Черный"
                , 2020, "Германия");
        audi.setRegNumber("л536ав876");


        Car bmw = new Car("BMW", "Z8", 3.0, "Черный"
                , 2021, "Германия");
        bmw.setTires(false);

        Car kia = new Car("Kia", "Sportage 4 поколение", 2.4, "Красный"
                , 2016, "Южная Корея");
        kia.setRegNumber("н7893p267");
        System.out.println(kia.isCorrectRegNumber());

        Car hyundai = new Car("Hyundai", "Avante", 1.6, "Оранжевый"
                , 2016, "Южная Корея");
        hyundai.setTransmission("МКП");
        hyundai.setKey(new Car.Key(true, true));

        printInfo(lada);
        printInfo(audi);
        printInfo(bmw);
        printInfo(kia);
        printInfo(hyundai);
    }

    private static void printInfo(Human human) {
        System.out.println("Привет! Меня зовут " + human.name + ". Я из города" + human.getTown() +
                ". Я родился в " + human.getYearOfBirth() + " году. Я работаю на должности"
                + human.job + ". Будем знакомы!");
    }

    private static void printInfo(Flower flower) {
        System.out.println("Цвет:" + flower.getFlowerColor() + ", страна:" + flower.getCountry()
                + ", стоимость за штуку:" + flower.getCost() + ", срок стояния цветка:" + flower.lifeSpan);
    }

    private static void printCostOfFlowers(Flower... flowers) {
        float totalCost = 0;
        int minimumLifeSpan = Integer.MAX_VALUE;
        for (Flower flower : flowers) {
            if (flower.lifeSpan < minimumLifeSpan) {
                minimumLifeSpan = flower.lifeSpan;
            }
            totalCost += flower.getCost();
            printInfo(flower);
        }
        totalCost = (float) (totalCost * 1.1);
        System.out.println("Стоимость букета:" + totalCost);
        System.out.println("Срок стояния букета:" + minimumLifeSpan);
    }

    private static void printInfo(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() +
                ", год выпуска: " + car.getProductionYear() +
                ", страна сборки: " + car.getProductionCountry() +
                ", цвет кузова: " + car.getColor() +
                ", объем двигателя: " + car.getEngineVolume() +
                ", коробка передач: " + car.getTransmission() +
                ", тип кузова: " + car.getBodyType() +
                ", рег. номер: " + car.getRegNumber() +
                ", кол-во мест: " + car.getNumberOfSeats() +
                ", " + (car.isTires() ? "летняя" : "зимняя") + " резина" +
                ", " + (car.getKey().isKeylessAccess() ? "безключевой доступ" : "ключевой доступ") +
                ", " + (car.getKey().isRemoteEngineStart() ? "удаленный запуск" : "обычный запуск") +
                ", номер страховки " + car.getInsurance().getInsuranceNumber() +
                ", стоимость страховки " + car.getInsurance().getInsuranceCost() +
                ", срок действия страховки " + car.getInsurance().getExpiration());
    }
}







