package ru.vsu.cs.pekshev.T3;

import ru.vsu.cs.pekshev.util.SwingUtils;

import java.util.Stack;

public class Execution {
    /*7. Написать программу для вычисления значения выражения, представленного в обратной
польской записи.
Обычная запись  |Обратная польская запись
(b + c) * d     | b c + d *
a + (b + c) * d | a b c + d * +
(6 + 8)/2 + 11  |6 8 + 2 / 11 +
*/
    public static SimpleLinkedListStack<Integer> execute1(String[] line) throws Exception {
        final SimpleLinkedListStack<Integer> answerLinkedListStack = new SimpleLinkedListStack<>();
        int intValue;
        for (String s : line) {
            try {
                intValue = Integer.parseInt(s);
                answerLinkedListStack.push(intValue);
            } catch (NumberFormatException e) {
                if (s.equals("+")) {
                    answerLinkedListStack.push(answerLinkedListStack.pop() + answerLinkedListStack.pop());
                }
                if (s.equals("-")) {
                    answerLinkedListStack.push(answerLinkedListStack.pop() - answerLinkedListStack.pop());
                }
                if (s.equals("*")) {
                    answerLinkedListStack.push(answerLinkedListStack.pop() * answerLinkedListStack.pop());
                }
                try {
                    if (s.equals("/")) {
                        answerLinkedListStack.push(answerLinkedListStack.pop() / answerLinkedListStack.pop());
                    }
                } catch (Exception ex) {
                    SwingUtils.showInfoMessageBox("На ноль делить нельзя!");
                }
            }
        }
        return answerLinkedListStack;
    }

    public static Stack<Integer> execute2(String[] line) throws Exception {
        final Stack<Integer> answerStack = new Stack<>();
        int intValue;
        for (String s : line) {
            try {
                intValue = Integer.parseInt(s);
                answerStack.push(intValue);
            } catch (NumberFormatException e) {
                System.out.println(s);
                if (s.equals("+")) {
                    answerStack.push(answerStack.pop() + answerStack.pop());
                }
                if (s.equals("-")) {
                    answerStack.push(answerStack.pop() - answerStack.pop());
                }
                if (s.equals("*")) {
                    answerStack.push(answerStack.pop() * answerStack.pop());
                }
                try {
                    if (s.equals("/")) {
                        answerStack.push(answerStack.pop() / answerStack.pop());
                    }
                } catch (Exception ex) {
                    SwingUtils.showInfoMessageBox("На ноль делить нельзя!");
                }

            }
        }
        return answerStack;
    }
}
