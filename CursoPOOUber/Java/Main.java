class Main {
    public static void main(String[] args) {
        // UberX uberX = new UberX("NTU96A", new Account("Edwin", "123CC"), "brand",
        // "model");
        // uberX.setPassengers(4);
        // uberX.printDataCar();

        UberVan uberVan = new UberVan("VAN", new Account("killer", "9876543"));
        uberVan.setPassengers(6);
        uberVan.printDataCar();
    }
}