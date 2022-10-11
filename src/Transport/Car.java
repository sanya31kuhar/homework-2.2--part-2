package Transport;

import java.time.LocalDate;

public class Car {

    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int productionYear;
    private final String productionCountry;
    private String transmission;
    private final String bodyType;
    private String regNumber;
    private final int numberOfSeats;
    private boolean tires;
    private Key key;
    private Insurance insurance;


    public Car(String brand, String model, double engineVolume, String color, int productionYear,
               String productionCountry, String transmission, String bodyType, String regNumber, int numberOfSeats,
               boolean tires, Key key, Insurance insurance) {
        if (brand == null) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (productionCountry == null) {
            this.productionCountry = "default";
        } else {
            this.productionCountry = productionCountry;
        }
        this.engineVolume = engineVolume;
        if (color == null) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        this.productionYear = productionYear;
        if (transmission == null) {
            this.transmission = "АКП";
        } else {
            this.transmission = transmission;
        }
        if (regNumber == null) {
            this.regNumber = "x000xx000";
        } else {
            this.regNumber = regNumber;
        }
        if (bodyType == null) {
            this.bodyType = "пикап";
        } else {
            this.bodyType = bodyType;
        }
        if (key == null) {
            this.key = new Key();
        } else {
            this.key = key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance = insurance;
        }
        this.numberOfSeats = numberOfSeats;
        this.tires = tires;
    }

    public Car(String brand, String model, double engineVolume, String color,
               int productionYear, String productionCountry) {
        this(brand, model, engineVolume, color, productionYear, productionCountry,
                "АКП", "x000xx000", "пикап", 3
                , true, new Key(), new Insurance());
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission == null) {
            this.transmission = "АКП";
        } else {
            this.transmission = transmission;
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        if (regNumber == null) {
            this.regNumber = "x000xx000";
        } else {
            this.regNumber = regNumber;
        }
    }

    public boolean isTires() {
        return tires;
    }

    public void setTires(boolean tires) {
        this.tires = tires;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void changeTires() {
        tires = !tires;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isCorrectRegNumber() {
        if (regNumber.length() != 9) {
            return false;
        }

        char[] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4])
                || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return !Character.isDigit(chars[1]) && !Character.isDigit(chars[2]) && !Character.isDigit(chars[3]) &&
                !Character.isDigit(chars[6]) && !Character.isDigit(chars[7]) && !Character.isDigit(chars[8]);
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }
    }

    public static class Insurance {
        private final LocalDate expiration;
        private final double insuranceCost;
        private final String insuranceNumber;

        public Insurance(LocalDate expiration, double insuranceCost, String insuranceNumber) {
            if (expiration == null) {
                this.expiration = LocalDate.now().plusDays(365);
            } else {
                this.expiration = expiration;
            }
            this.insuranceCost = insuranceCost;
            if (insuranceNumber == null) {
                this.insuranceNumber = "123456789";
            } else {
                this.insuranceNumber = insuranceNumber;
            }
        }

        public Insurance() {
            this(null, 15000, null);
        }

        public LocalDate getExpiration() {
            return expiration;
        }

        public double getInsuranceCost() {
            return insuranceCost;
        }

        public String getInsuranceNumber() {
            return insuranceNumber;
        }

        public void checkExpiration() {
            if (expiration.isBefore(LocalDate.now()) || expiration.isEqual(LocalDate.now())) {
                System.out.println("Нужно срочно ехать оформлять новую страховку");
            }
        }

        public void checkInsuranceNumber() {
            if (insuranceNumber.length() != 9) {
                System.out.println("Номер страховки некорректный!");
            }
        }
    }
}





