package com.study.datastructures;


public class GenericsTest {
    public static void main(String[] args) {
//        Container<String> stringContainer = new Container<>();
//        stringContainer.setValue("Hello");
//        String value = stringContainer.getValue();
//
//        Container<Integer> integerContainer = new Container<>();
//        integerContainer.setValue(100);
//        Integer value2 = integerContainer.getValue();

        Container stringContainer = new Container();
        stringContainer.setValue("Hello");
        String value = (String) stringContainer.getValue();

        Container integerContainer = new Container();
        integerContainer.setValue(100);
        Integer value2 = (Integer) integerContainer.getValue();
    }
}

class Container {
    Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}


//class Container<SomeType> {
//    SomeType value;
//
//    public SomeType getValue() {
//        return value;
//    }
//
//    public void setValue(SomeType value) {
//        this.value = value;
//    }
//}