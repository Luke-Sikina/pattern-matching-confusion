import java.util.Objects;
import java.util.function.Consumer;

public class Example {

    Consumer<Integer> getSetterUsingSwitch(String field, MyPojo pojo) {
        return switch (field) {
            case "1" -> pojo::setA;
            case "2" -> pojo::setB;
            case "3" -> pojo::setC;
            default -> (Integer ignored) -> {};
        };
    }

    Consumer<Integer> getSetter(String field, MyPojo pojo) {
        if ("1".equals(field)) {
            return pojo::setA;
        } else if ("2".equals(field)) {
            return pojo::setB;
        } else if ("3".equals(field)) {
            return pojo::setC;
        } else {
            return (Integer ignored) -> {};
        }
    }

    private static final class MyPojo {
        int a, b, c;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyPojo myPojo)) return false;
            return getA() == myPojo.getA() && getB() == myPojo.getB() && getC() == myPojo.getC();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getA(), getB(), getC());
        }
    }
}
