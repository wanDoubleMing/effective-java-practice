/**
 * DATE: 18/8/14
 * 1.使用静态工厂方法替代构造器来创建对象
 * 2.遇到多个构造器参数,考虑使用构造器
 *
 * @author: wan
 */
public class Person {

    private String name;

    private int age;

    private String sex;

    private String cardNo;

    private int height;

    private String from;

    /**
     * 正常情况,我们会使用多个不同参数的构造函数
     */
    public static class Builder {

        private String name;

        private int age;

        private String sex = "Man";

        private String cardNo = "0";

        private int height = 180;

        private String from = "china";

        public Builder(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Builder setSex(String sex){
            this.sex = sex;
            return this;
        }

        public Builder setCarNo(String cardNo){
            this.cardNo = cardNo;
            return this;
        }

        public Builder setHeight(int height){
            this.height = height;
            return this;
        }

        public Builder setFrom(String from){
            this.from = from;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    private Person(Builder builder){
        this.age = builder.age;
        this.name = builder.name;
        this.cardNo = builder.cardNo;
        this.from = builder.from;
        this.height = builder.height;
        this.sex = builder.sex;
    }

    @Override
    public String toString() {
        return "name=" + this.name + ";age=" + String.valueOf(this.age) + ";sex=" + this.sex +
                ";height=" + String.valueOf(this.height) + ";carNo=" + this.cardNo + ";from=" + this.from;

    }

    public static void main(String[] args) {
        String name = "wmm";
        int age = 18;
        Person person = new Person.Builder(name, age).setSex("boy").setHeight(185).setCarNo("abc").build();
        System.out.println(person);
    }
}