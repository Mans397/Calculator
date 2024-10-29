package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private final JTextField firstNumberField = new JTextField(15);
    private final JTextField secondNumberField = new JTextField(15);
    private final JTextArea resultArea = new JTextArea(3, 20);

    private final JButton addButton = new JButton("+");
    private final JButton subtractButton = new JButton("-");
    private final JButton multiplyButton = new JButton("*");
    private final JButton divideButton = new JButton("/");

    public CalculatorView() {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300); // Размеры окна изменены для квадратного вида
        frame.setLayout(new GridLayout(3, 1)); // Используем GridLayout для равномерного распределения

        JPanel inputPanel = new JPanel();
        inputPanel.add(firstNumberField);
        inputPanel.add(secondNumberField);

        JPanel operationPanel = new JPanel();
        operationPanel.add(addButton);
        operationPanel.add(subtractButton);
        operationPanel.add(multiplyButton);
        operationPanel.add(divideButton);

        JPanel resultPanel = new JPanel();
        resultPanel.add(resultArea);

        // Добавление всех панелей в основной фрейм
        frame.add(inputPanel);
        frame.add(operationPanel);
        frame.add(resultPanel);

        frame.setVisible(true);
    }

    public String getFirstNumber() {
        return firstNumberField.getText();
    }

    public String getSecondNumber() {
        return secondNumberField.getText();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public void addOperationListener(ActionListener listenForOperationButton) {
        addButton.addActionListener(listenForOperationButton);
        subtractButton.addActionListener(listenForOperationButton);
        multiplyButton.addActionListener(listenForOperationButton);
        divideButton.addActionListener(listenForOperationButton);
    }

    // Методы для получения кнопок
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

}
