package com.jerikthedog.SpringDataJpaTutorial.test;

public class ExtendedMoo extends Moo {

    @Override
    public void sayMoo() {
        System.out.println("ExtendedMoo - before");
        super.sayMoo();
        System.out.println("ExtendedMoo - after");
    }

    @Override
    public void sayMoreMoo() {
        System.out.println("ExtendedMoreMoo - before");
        super.sayMoreMoo();
        System.out.println("ExtendedMoreMoo - after");
    }

}
