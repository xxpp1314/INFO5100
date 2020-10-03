public class Professor {
    private String firstName;
    private String lastName;
    private int id;

    private int age;
    private String address;
    private String email;

    public static class Builder {
        private String firstName;
        private String lastName;
        private int id;

        private int age;
        private String address;
        private String email;

        public Builder(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Professor build() {
            return new Professor(firstName, lastName, id, age, address, email);
        }
    }

    public Professor(String firstName, String lastName, int id, int age, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
}

class Main {
    public static void main(String[] args) {
        Professor professor = new Professor.Builder("Oliver", "Gao", 123456)
                .setAge(36)
                .setAddress("Renton")
                .setEmail("olivergao@gmail.com").build();
        System.out.println("The professor's full name is " + professor.getFirstName() + professor.getLastName());
        System.out.println("The professor's id is " + professor.getId());
        System.out.println("The professor's age is " + professor.getAge());
        System.out.println("The professor's address is " + professor.getAddress());
        System.out.println("The professor's email is " + professor.getEmail());
    }
}
