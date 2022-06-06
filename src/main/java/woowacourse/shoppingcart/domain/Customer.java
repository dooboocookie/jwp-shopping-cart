package woowacourse.shoppingcart.domain;

import java.util.regex.Pattern;

public class Customer {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 30;
    private static final String PHONE_REGEX = "^010-\\d{4}-\\d{4}$";

    private Long id;
    private String email;
    private Password password;
    private String name;
    private String phone;
    private String address;

    private Customer() {

    }

    public Customer(String email, String password, String name, String phone, String address) {
        this(null, email, Password.encrypt(password), name, phone, address);
    }

    public Customer(Long id, String email, String password, String name, String phone, String address) {
        this(id, email, Password.encrypt(password), name, phone, address);
    }

    public Customer(Long id, String email, Password password, String name, String phone, String address) {
        validate(email, name, phone, address);
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    private void validate(String email, String name, String phone, String address) {
        validateEmptyEmail(email);
        validateNameLength(name);
        validatePhoneFormat(phone);
        validateEmptyAddress(address);
    }

    private void validateEmptyEmail(String email) {
        if (email.isBlank()) {
            throw new IllegalArgumentException("email이 빈 값일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상, 30자 이하여야 합니다.");
        }
    }

    private void validatePhoneFormat(String phone) {
        if (!Pattern.matches(PHONE_REGEX, phone)) {
            throw new IllegalArgumentException("전화번호의 형식이 맞지 않습니다.");
        }
    }

    private void validateEmptyAddress(String address) {
        if (address.isBlank()) {
            throw new IllegalArgumentException("address가 빈 값일 수 없습니다.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password.getPassword();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}