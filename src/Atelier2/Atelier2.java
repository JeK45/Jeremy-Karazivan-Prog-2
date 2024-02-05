package Atelier2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

class Atelier2 {
    JFrame frame;
    JComboBox<String> cmbChoice;
    JRadioButton radAscending, radDescending;
    ButtonGroup radGrp_sortOrder;
    JTextField txfMin, txfMax, txfAverage, txfValue;
    JButton btnSort, btnSearch, btnQuit;
    JTextArea txaNumbers;
    JScrollPane scr_txaNumbers;
    JPanel panLeft, panRight;

    Atelier2() {
        Dimension dimLeft = new Dimension(180, 25);

        frame = new JFrame("Atelier2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(400, 400));
        frame.setLayout(new GridLayout(1, 2));
//----------------------------------------------------------------------------------------
        cmbChoice = new JComboBox<>(new String[]{"Vider", "Garnir", "Nombres 1..100", "Nombres -25..25"});
        cmbChoice.setPreferredSize(dimLeft);
        cmbChoice.addItemListener(e -> cmbChoice_onSelection());
// ----------------------------------------------------------------------------------------
        radAscending = new JRadioButton("Croissant");
        radAscending.setSelected(true);

        radDescending = new JRadioButton("Décroissant");

        radGrp_sortOrder = new ButtonGroup();
        radGrp_sortOrder.add(radAscending);
        radGrp_sortOrder.add(radDescending);
//----------------------------------------------------------------------------------------
        txfMin = new JTextField("txfMin");
        txfMin.setEnabled(false);
        txfMin.setPreferredSize(dimLeft);
        txfMin.setHorizontalAlignment(JTextField.RIGHT);

        txfMax = new JTextField("txfMax");
        txfMax.setEnabled(false);
        txfMax.setPreferredSize(dimLeft);
        txfMax.setHorizontalAlignment(JTextField.RIGHT);

        txfAverage = new JTextField("txfMoyenne");
        txfAverage.setEnabled(false);
        txfAverage.setPreferredSize(dimLeft);
        txfAverage.setHorizontalAlignment(JTextField.RIGHT);

        txfValue = new JTextField("txfValeur");
        txfValue.setPreferredSize(dimLeft);
//----------------------------------------------------------------------------------------
        btnSort = new JButton("Trier");
        btnSort.addActionListener(e ->btnSort_onClick());

        btnSearch = new JButton("Chercher");
        btnSearch.addActionListener(e -> btnSearch_onClick());

        btnQuit = new JButton("Quitter");
        btnQuit.addActionListener( e -> btnQuit_onClick());
//----------------------------------------------------------------------------------------
        txaNumbers = new JTextArea();
        txaNumbers.setWrapStyleWord(true);
        txaNumbers.setLineWrap(true);

        scr_txaNumbers = new JScrollPane(txaNumbers);
        scr_txaNumbers.setPreferredSize(new Dimension(180, 350));
//----------------------------------------------------------------------------------------
        panLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        panLeft.add(cmbChoice);
        panLeft.add(radAscending);
        panLeft.add(radDescending);
        panLeft.add(btnSort);
        panLeft.add(txfMin);
        panLeft.add(txfMax);
        panLeft.add(txfAverage);
        panLeft.add(txfValue);
        panLeft.add(btnSearch);
        panLeft.add(btnQuit);

        panRight = new JPanel();
        panRight.add(scr_txaNumbers);

        frame.add(panLeft);
        frame.add(panRight);

        frame.setVisible(true);
    }

    void cmbChoice_onSelection() {
        switch (cmbChoice.getSelectedIndex()) {
            case 0:
                txaNumbers.setText("");
                break;
            case 1:
                writeArray(new int[]{10, 50, 2, 33, -27, 144, 57, 25});
                break;
            case 2:
                txaNumbers.setText("");
                for (int i = 1; i <= 100; i++) {
                    txaNumbers.setText(txaNumbers.getText() + i + "\n");
                }
                break;
            case 3:
                txaNumbers.setText("");
                for (int j = -25; j <= 25; j++) {
                    txaNumbers.setText(txaNumbers.getText() + j + "\n");
                }
                break;
        }
        updateStats();
    }

    void btnSort_onClick() {
        if (radAscending.isSelected()) {
            writeArray(Tableaux.TriCroissantSSS(stringArrayToIntArray(txaNumbers.getText().split("\n"))));
        }
        else {
            writeArray(Tableaux.TriDecroissantSSS(stringArrayToIntArray(txaNumbers.getText().split("\n"))));
        }
    }

    void btnSearch_onClick() {
        System.out.println("Trouvé à l'indice " + Tableaux.fouilleSeq(stringArrayToIntArray(txaNumbers.getText().split("\n")), Integer.parseInt(txfValue.getText())));
    }

    void btnQuit_onClick() {
        System.exit(0);
    }

    void updateStats() {
        txfMin.setText(Integer.toString(Tableaux.minimum(stringArrayToIntArray(txaNumbers.getText().split("\n")))));
        txfMax.setText(Integer.toString(Tableaux.maximum(stringArrayToIntArray(txaNumbers.getText().split("\n")))));
        txfAverage.setText(Double.toString(Tableaux.moyenne(stringArrayToIntArray(txaNumbers.getText().split("\n")))));
    }

    int[] stringArrayToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    void writeArray(int[] array) {
        txaNumbers.setText("");
        for (int elem: array) {
            txaNumbers.setText(txaNumbers.getText() + elem + "\n");
        }
    }

    public static void main(String[] args) {
        new Atelier2();
    }
}
