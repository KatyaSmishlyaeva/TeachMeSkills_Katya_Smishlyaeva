package com.teachmeskills.homework8.task3;

public class TextFormaterRunner {

    public static void main(String[] args) {
        String string = "South America is famous for its wild animals." +
                " There are many kinds. We saw some of them. " +
                "We drove to the jungle in the north of Brazil. " +
                "We were really lucky! We walked very quietly and we saw a jaguar. " +
                "It is a kind of South American cheetah. " +
                "It was beautiful and very fast. I was really scared. " +
                "I think Jaguars like eating hedgehogs! We saw alligators there. " +
                "They were three metres long, fast and have big teeth Deed! " +
                "They are like crocodiles. We didn’t stay there long Noon. " +
                "We didn’t know. Maybe alligators like eating hedgehogs too! ";

        Text text = new Text();
        System.out.println(text.formatText(string));

    }
}
