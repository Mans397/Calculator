package Controller;

import Model.CalculatorModel;
import View.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstNumber = view.getFirstNumber();
            String secondNumber = view.getSecondNumber();
            String result;

            try {
                double num1 = Double.parseDouble(firstNumber);
                double num2 = Double.parseDouble(secondNumber);

                if (e.getSource() == view.getAddButton()) {
                    result = String.valueOf(model.add(num1, num2));
                } else if (e.getSource() == view.getSubtractButton()) {
                    result = String.valueOf(model.subtract(num1, num2));
                } else if (e.getSource() == view.getMultiplyButton()) {
                    result = String.valueOf(model.multiply(num1, num2));
                } else {
                    result = String.valueOf(model.divide(num1, num2));
                }
                view.setResult(result);
            } catch (ArithmeticException ex) {
                view.setResult(ex.getMessage());
            } catch (NumberFormatException ex) {
                view.setResult("Ошибка: вводите только числа");
            }
        }
    }
}
