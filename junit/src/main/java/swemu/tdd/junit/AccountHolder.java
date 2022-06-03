package swemu.tdd.junit;

public class AccountHolder {
    private final String name;
    private final String address;
    private final String zipCode;
    private final String city;

    public AccountHolder(String name, String address, String zipCode, String city) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }
}
