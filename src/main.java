import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class main {
    private JTabbedPane tabbedPane1;
    private JTextField a100TextField;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField a0TextField;
    private JTextField textField7;
    private JTextField a1000TextField;
    private JTextField textField8;
    private JTextField textField9;
    private JButton 计算Button;
    private JTextField a100TextField1;
    private JTextField textField11;
    private JComboBox comboBox3;
    private JTextField textField12;
    private JTextField textField13;
    private JButton 计算Button1;
    private JTextField a0TextField1;
    private JTextField a100TextField2;
    private JTextField textField10;
    private JTextField a0TextField2;
    private JTextField a0TextField3;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField17;
    private JButton 计算Button2;
    private JPanel main;
    private JCheckBox 代工CheckBox;

    public static void main(String[] args) {
        JFrame frame = new JFrame("华二商赛助手[增强版] by 190720");
        frame.setContentPane(new main().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private main() {
        计算Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer c = Integer.parseInt(a100TextField.getText());
                Integer productType = comboBox1.getSelectedIndex();
                Integer productTime = 0;
                Integer developCost = 0;
                Double productRatio = 0.0;
                Double productCost;
                switch (productType) {
                    case 0:
                        productRatio = 0.9;
                        productTime = 5;
                        developCost = 50;
                        break;
                    case 1:
                        productRatio = 1.2;
                        productTime = 8;
                        developCost = 80;
                        break;
                    case 2:
                        productRatio = 1.6;
                        productTime = 12;
                        developCost = 100;
                }
                if (代工CheckBox.isSelected()) {
                    developCost = 0;
                    productTime = 0;
                }
                productCost = productRatio * c;
                textField2.setText(String.valueOf(productCost) + " /件");
                textField3.setText(String.valueOf(developCost) + " 万");
                textField4.setText(String.valueOf(productTime) + " 分钟");

                Integer machineType = comboBox2.getSelectedIndex();
                Integer machineCost = 0;
                Integer machineProductivity = 0;
                String machineProduct = "";
                Integer moneyDecline = 0;
                Integer productivityDecline = 0;
                Integer machineProgress = Integer.parseInt(a0TextField.getText());
                Integer machineProgressDecline;
                switch (machineType) {
                    case 0:
                        machineCost = 150;
                        machineProductivity = 50;
                        machineProduct = "L/M";
                        moneyDecline = 15;
                        productivityDecline = 10;
                        break;
                    case 1:
                        machineCost = 180;
                        machineProductivity = 60;
                        machineProduct = "M";
                        moneyDecline = 15;
                        productivityDecline = 10;
                        break;
                    case 2:
                        machineCost = 200;
                        machineProductivity = 60;
                        machineProduct = "L/M/H";
                        moneyDecline = 10;
                        productivityDecline = 5;
                }
                Integer tmpMachineProductivity = machineProductivity;
                machineProductivity = (int) ((1 - productivityDecline * machineProgress * 0.01) * machineProductivity);
                machineProgressDecline = (int) (machineCost * Math.pow(10,4) * moneyDecline * (machineProgress + 1) * 0.01);
                textField1.setText(String.valueOf(machineCost) + " 万");
                if (machineProductivity.equals(tmpMachineProductivity)) {
                    textField5.setText(String.valueOf(machineProductivity) + " 件/分钟");
                } else {
                    textField5.setText(String.valueOf(tmpMachineProductivity) + " - " + String.valueOf(machineProductivity) + " 件/分钟, 每年减少 " + String.valueOf(productivityDecline * tmpMachineProductivity * 0.01) + " 件/分钟");
                }
                textField6.setText(machineProduct);
                textField7.setText(String.valueOf(machineProgressDecline));

                Integer tax = Integer.parseInt(a0TextField1.getText());
                Integer pieces = Integer.parseInt(a1000TextField.getText());
                Integer totalCost = (int) (developCost * Math.pow(10,4) + productCost * pieces + machineProgressDecline);
                // FAKE START
                Integer tmpTotalCost = (int) (totalCost * 0.001);
                tmpTotalCost = (int) (tmpTotalCost * 1.2);
                totalCost += tmpTotalCost * 1000;
                // FAKE  END
                totalCost = (int) (totalCost / (1 - tax * 0.01));
                Integer pieceCost = totalCost / pieces;
                textField8.setText(String.valueOf(totalCost));
                textField9.setText(String.valueOf(pieceCost));
            }
        });

        计算Button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer c = Integer.parseInt(a100TextField1.getText());
                Integer productType = comboBox3.getSelectedIndex();
                Integer n = Integer.parseInt(textField11.getText());
                Double ratio = 0.0;
                Integer basicValue;
                switch (productType) {
                    case 0:
                        ratio = 0.9;
                        break;
                    case 1:
                        ratio = 1.6;
                        break;
                    case 2:
                        ratio = 2.8;
                }
                basicValue = (int) (c + ratio * n * c);
                // FAKE START
                //basicValue = (int) (basicValue * 1.6);
                // FAKE  END
                textField12.setText(String.valueOf(basicValue));

                Double brandValue = Double.parseDouble(textField10.getText());
                Double originBrandValue = Double.parseDouble(a0TextField2.getText());
                Integer duration = Integer.parseInt(a0TextField3.getText());
                Integer finalValue = (int) (basicValue * (1 + brandValue * 0.01 + originBrandValue * 0.01) * (1 - duration * 0.1));
                textField13.setText(String.valueOf(finalValue));
            }
        });

        计算Button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Integer c = Integer.parseInt(a100TextField2.getText());
                Integer lPieces = Integer.parseInt(textField14.getText());
                Integer mPieces = Integer.parseInt(textField15.getText());
                Integer hPieces = Integer.parseInt(textField16.getText());
                Integer price = (int) (0.3 * c * lPieces + 0.4 * c * mPieces + 0.5 * c * hPieces);
                textField17.setText(String.valueOf(price));
            }
        });
    }
}
