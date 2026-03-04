package iti.xml;

public class Student {
    String name;
    int age;
    String email;
    String phone;
    String track;
    String about;

    public Student() {
    }

    public Student(String name, int age, String email, String phone, String track, String about) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.track = track;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString(){
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", track='" + track + '\'' +
            ", about='" + about + '\'' +
            '}';
    }

}
